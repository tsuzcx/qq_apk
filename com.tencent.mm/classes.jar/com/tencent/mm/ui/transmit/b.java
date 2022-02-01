package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.o.a;
import com.tencent.mm.ui.contact.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class b
  extends o
{
  private MMCreateChatroomUI LiX;
  private l LiY;
  private aq handler;
  String query;
  k tFQ;
  private com.tencent.mm.plugin.fts.a.a.a tGb;
  
  public b(MMCreateChatroomUI paramMMCreateChatroomUI, int paramInt)
  {
    super(paramMMCreateChatroomUI, false, paramInt);
    AppMethodBeat.i(39232);
    this.handler = new aq(Looper.getMainLooper());
    this.LiY = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(39231);
        if (paramAnonymousk.bZU == 0) {
          b.a(b.this, paramAnonymousk);
        }
        for (;;)
        {
          if (paramAnonymousk.tGc.size() == 0)
          {
            m localm = new m();
            localm.tEY = "no_result​";
            paramAnonymousk.tGc = new ArrayList();
            paramAnonymousk.tGc.add(localm);
          }
          b.this.clearCache();
          b.this.notifyDataSetChanged();
          b.a(b.this).y(paramAnonymousk.tCm.query, paramAnonymousk.tGc.size(), true);
          AppMethodBeat.o(39231);
          return;
          b.a(b.this, null);
        }
      }
    };
    this.LiX = paramMMCreateChatroomUI;
    AppMethodBeat.o(39232);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(39233);
    this.query = paramString;
    paramArrayOfInt = new j();
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.tGa = this.LiY;
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.tFZ = com.tencent.mm.plugin.fts.a.c.b.tGz;
    paramArrayOfInt.tFV = new int[] { 131072 };
    paramArrayOfInt.tFY.add("filehelper");
    paramArrayOfInt.tFY.add(v.aAC());
    paramArrayOfInt.tFY.addAll(this.LiX.Ljb.fPk());
    this.tGb = ((n)g.ad(n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(39233);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(39234);
    if (this.tGb != null) {
      ((n)g.ad(n.class)).cancelSearchTask(this.tGb);
    }
    this.query = null;
    AppMethodBeat.o(39234);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(39236);
    if ((this.tFQ != null) && (this.tFQ.tGc != null))
    {
      int i = this.tFQ.tGc.size();
      AppMethodBeat.o(39236);
      return i;
    }
    AppMethodBeat.o(39236);
    return 0;
  }
  
  public final com.tencent.mm.ui.contact.a.a rk(int paramInt)
  {
    AppMethodBeat.i(39235);
    m localm = (m)this.tFQ.tGc.get(paramInt);
    Object localObject;
    if (localm.tEY.equals("no_result​")) {
      localObject = new i(paramInt);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
      ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      ((com.tencent.mm.ui.contact.a.a)localObject).KJj = false;
      AppMethodBeat.o(39235);
      return localObject;
      localObject = new e(paramInt);
      ((e)localObject).kno = localm;
      ((com.tencent.mm.ui.contact.a.a)localObject).tFe = this.tFQ.tFe;
      ((com.tencent.mm.ui.contact.a.a)localObject).KJj = dUh();
      ((e)localObject).gxU = true;
      ((e)localObject).tGM = (paramInt + 1);
      ((e)localObject).gf(((e)localObject).kno.type, ((e)localObject).kno.tEX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.b
 * JD-Core Version:    0.7.0.1
 */