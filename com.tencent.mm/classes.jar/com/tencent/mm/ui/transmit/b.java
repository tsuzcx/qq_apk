package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.m;
import java.util.HashSet;
import java.util.List;

public final class b
  extends m
{
  String bVk;
  private ah handler = new ah(Looper.getMainLooper());
  j kwU;
  private com.tencent.mm.plugin.fts.a.a.a kxg;
  private MMCreateChatroomUI wfY;
  private com.tencent.mm.plugin.fts.a.l wfZ = new b.1(this);
  
  public b(MMCreateChatroomUI paramMMCreateChatroomUI, int paramInt)
  {
    super(paramMMCreateChatroomUI, false, paramInt);
    this.wfY = paramMMCreateChatroomUI;
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    this.bVk = paramString;
    paramArrayOfInt = new i();
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.kxf = this.wfZ;
    paramArrayOfInt.bVk = paramString;
    paramArrayOfInt.kxe = com.tencent.mm.plugin.fts.a.c.b.kxE;
    paramArrayOfInt.kxa = new int[] { 131072 };
    paramArrayOfInt.kxd.add("filehelper");
    paramArrayOfInt.kxd.add(q.Gj());
    paramArrayOfInt.kxd.addAll(this.wfY.wgc.cJr());
    this.kxg = ((com.tencent.mm.plugin.fts.a.n)g.t(com.tencent.mm.plugin.fts.a.n.class)).search(2, paramArrayOfInt);
  }
  
  public final void adg()
  {
    if (this.kxg != null) {
      ((com.tencent.mm.plugin.fts.a.n)g.t(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.kxg);
    }
    this.bVk = null;
  }
  
  public final int getCount()
  {
    if ((this.kwU != null) && (this.kwU.kxh != null)) {
      return this.kwU.kxh.size();
    }
    return 0;
  }
  
  protected final com.tencent.mm.ui.contact.a.a jQ(int paramInt)
  {
    com.tencent.mm.plugin.fts.a.a.l locall = (com.tencent.mm.plugin.fts.a.a.l)this.kwU.kxh.get(paramInt);
    Object localObject;
    if (locall.kwg.equals("no_result​")) {
      localObject = new h(paramInt);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.contact.a.a)localObject).bVk = this.bVk;
      ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      ((com.tencent.mm.ui.contact.a.a)localObject).vLJ = false;
      return localObject;
      localObject = new d(paramInt);
      ((d)localObject).fYx = locall;
      ((com.tencent.mm.ui.contact.a.a)localObject).kwi = this.kwU.kwi;
      ((com.tencent.mm.ui.contact.a.a)localObject).vLJ = bBJ();
      ((d)localObject).dDQ = true;
      ((d)localObject).kxV = (paramInt + 1);
      ((d)localObject).cU(((d)localObject).fYx.type, ((d)localObject).fYx.kwf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.b
 * JD-Core Version:    0.7.0.1
 */