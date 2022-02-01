package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
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
  private MMCreateChatroomUI QxW;
  private l QxX;
  private MMHandler handler;
  String query;
  k wWP;
  private com.tencent.mm.plugin.fts.a.a.a wXa;
  
  public b(MMCreateChatroomUI paramMMCreateChatroomUI, int paramInt)
  {
    super(paramMMCreateChatroomUI, false, paramInt);
    AppMethodBeat.i(39232);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.QxX = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(39231);
        if (paramAnonymousk.resultCode == 0) {
          b.a(b.this, paramAnonymousk);
        }
        for (;;)
        {
          if (paramAnonymousk.wXb.size() == 0)
          {
            m localm = new m();
            localm.wVX = "no_result​";
            paramAnonymousk.wXb = new ArrayList();
            paramAnonymousk.wXb.add(localm);
          }
          b.this.clearCache();
          b.this.notifyDataSetChanged();
          b.a(b.this).B(paramAnonymousk.wTn.query, paramAnonymousk.wXb.size(), true);
          AppMethodBeat.o(39231);
          return;
          b.a(b.this, null);
        }
      }
    };
    this.QxW = paramMMCreateChatroomUI;
    AppMethodBeat.o(39232);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(39233);
    this.query = paramString;
    paramArrayOfInt = new j();
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.wWZ = this.QxX;
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.wWY = com.tencent.mm.plugin.fts.a.c.b.wXy;
    paramArrayOfInt.wWU = new int[] { 131072 };
    paramArrayOfInt.wWX.add("filehelper");
    paramArrayOfInt.wWX.add(z.aTY());
    paramArrayOfInt.wWX.addAll(this.QxW.Qya.gYd());
    this.wXa = ((n)g.ah(n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(39233);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(39234);
    if (this.wXa != null) {
      ((n)g.ah(n.class)).cancelSearchTask(this.wXa);
    }
    this.query = null;
    AppMethodBeat.o(39234);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(39236);
    if ((this.wWP != null) && (this.wWP.wXb != null))
    {
      int i = this.wWP.wXb.size();
      AppMethodBeat.o(39236);
      return i;
    }
    AppMethodBeat.o(39236);
    return 0;
  }
  
  public final com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    AppMethodBeat.i(39235);
    m localm = (m)this.wWP.wXb.get(paramInt);
    Object localObject;
    if (localm.wVX.equals("no_result​")) {
      localObject = new i(paramInt);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
      ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      ((com.tencent.mm.ui.contact.a.a)localObject).PWh = false;
      AppMethodBeat.o(39235);
      return localObject;
      localObject = new e(paramInt);
      ((e)localObject).lqW = localm;
      ((com.tencent.mm.ui.contact.a.a)localObject).wWd = this.wWP.wWd;
      ((com.tencent.mm.ui.contact.a.a)localObject).PWh = eWh();
      ((e)localObject).hkH = true;
      ((e)localObject).wXL = (paramInt + 1);
      ((e)localObject).gE(((e)localObject).lqW.type, ((e)localObject).lqW.wVW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.b
 * JD-Core Version:    0.7.0.1
 */