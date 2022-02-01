package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ap;
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
  private MMCreateChatroomUI HuY;
  private l HuZ;
  private ap handler;
  String query;
  k rpE;
  private com.tencent.mm.plugin.fts.a.a.a rpP;
  
  public b(MMCreateChatroomUI paramMMCreateChatroomUI, int paramInt)
  {
    super(paramMMCreateChatroomUI, false, paramInt);
    AppMethodBeat.i(39232);
    this.handler = new ap(Looper.getMainLooper());
    this.HuZ = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(39231);
        if (paramAnonymousk.bRZ == 0) {
          b.a(b.this, paramAnonymousk);
        }
        for (;;)
        {
          if (paramAnonymousk.rpQ.size() == 0)
          {
            m localm = new m();
            localm.roN = "no_result​";
            paramAnonymousk.rpQ = new ArrayList();
            paramAnonymousk.rpQ.add(localm);
          }
          b.this.clearCache();
          b.this.notifyDataSetChanged();
          b.a(b.this).y(paramAnonymousk.rma.query, paramAnonymousk.rpQ.size(), true);
          AppMethodBeat.o(39231);
          return;
          b.a(b.this, null);
        }
      }
    };
    this.HuY = paramMMCreateChatroomUI;
    AppMethodBeat.o(39232);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(39233);
    this.query = paramString;
    paramArrayOfInt = new j();
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.rpO = this.HuZ;
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.rpN = com.tencent.mm.plugin.fts.a.c.b.rqn;
    paramArrayOfInt.rpJ = new int[] { 131072 };
    paramArrayOfInt.rpM.add("filehelper");
    paramArrayOfInt.rpM.add(u.aqG());
    paramArrayOfInt.rpM.addAll(this.HuY.Hvc.fej());
    this.rpP = ((n)g.ad(n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(39233);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(39234);
    if (this.rpP != null) {
      ((n)g.ad(n.class)).cancelSearchTask(this.rpP);
    }
    this.query = null;
    AppMethodBeat.o(39234);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(39236);
    if ((this.rpE != null) && (this.rpE.rpQ != null))
    {
      int i = this.rpE.rpQ.size();
      AppMethodBeat.o(39236);
      return i;
    }
    AppMethodBeat.o(39236);
    return 0;
  }
  
  public final com.tencent.mm.ui.contact.a.a pU(int paramInt)
  {
    AppMethodBeat.i(39235);
    m localm = (m)this.rpE.rpQ.get(paramInt);
    Object localObject;
    if (localm.roN.equals("no_result​")) {
      localObject = new i(paramInt);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
      ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      ((com.tencent.mm.ui.contact.a.a)localObject).GVT = false;
      AppMethodBeat.o(39235);
      return localObject;
      localObject = new e(paramInt);
      ((e)localObject).jpy = localm;
      ((com.tencent.mm.ui.contact.a.a)localObject).roS = this.rpE.roS;
      ((com.tencent.mm.ui.contact.a.a)localObject).GVT = dqZ();
      ((e)localObject).fWW = true;
      ((e)localObject).rqA = (paramInt + 1);
      ((e)localObject).fI(((e)localObject).jpy.type, ((e)localObject).jpy.roM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.b
 * JD-Core Version:    0.7.0.1
 */