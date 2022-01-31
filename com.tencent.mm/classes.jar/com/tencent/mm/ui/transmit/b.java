package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import java.util.HashSet;
import java.util.List;

public final class b
  extends com.tencent.mm.ui.contact.n
{
  private MMCreateChatroomUI AyP;
  private com.tencent.mm.plugin.fts.a.l AyQ;
  private ak handler;
  j mSK;
  private com.tencent.mm.plugin.fts.a.a.a mSV;
  String query;
  
  public b(MMCreateChatroomUI paramMMCreateChatroomUI, int paramInt)
  {
    super(paramMMCreateChatroomUI, false, paramInt);
    AppMethodBeat.i(35035);
    this.handler = new ak(Looper.getMainLooper());
    this.AyQ = new b.1(this);
    this.AyP = paramMMCreateChatroomUI;
    AppMethodBeat.o(35035);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35036);
    this.query = paramString;
    paramArrayOfInt = new com.tencent.mm.plugin.fts.a.a.i();
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.mSU = this.AyQ;
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.mST = com.tencent.mm.plugin.fts.a.c.b.mTt;
    paramArrayOfInt.mSP = new int[] { 131072 };
    paramArrayOfInt.mSS.add("filehelper");
    paramArrayOfInt.mSS.add(r.Zn());
    paramArrayOfInt.mSS.addAll(this.AyP.AyT.dOh());
    this.mSV = ((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(35036);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(35037);
    if (this.mSV != null) {
      ((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.mSV);
    }
    this.query = null;
    AppMethodBeat.o(35037);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(35039);
    if ((this.mSK != null) && (this.mSK.mSW != null))
    {
      int i = this.mSK.mSW.size();
      AppMethodBeat.o(35039);
      return i;
    }
    AppMethodBeat.o(35039);
    return 0;
  }
  
  public final com.tencent.mm.ui.contact.a.a mM(int paramInt)
  {
    AppMethodBeat.i(35038);
    com.tencent.mm.plugin.fts.a.a.l locall = (com.tencent.mm.plugin.fts.a.a.l)this.mSK.mSW.get(paramInt);
    Object localObject;
    if (locall.mRV.equals("no_result​")) {
      localObject = new com.tencent.mm.ui.contact.a.i(paramInt);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
      ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      ((com.tencent.mm.ui.contact.a.a)localObject).Adl = false;
      AppMethodBeat.o(35038);
      return localObject;
      localObject = new e(paramInt);
      ((e)localObject).hrL = locall;
      ((com.tencent.mm.ui.contact.a.a)localObject).mRX = this.mSK.mRX;
      ((com.tencent.mm.ui.contact.a.a)localObject).Adl = cni();
      ((e)localObject).eBr = true;
      ((e)localObject).mTI = (paramInt + 1);
      ((e)localObject).es(((e)localObject).hrL.type, ((e)localObject).hrL.mRU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.b
 * JD-Core Version:    0.7.0.1
 */