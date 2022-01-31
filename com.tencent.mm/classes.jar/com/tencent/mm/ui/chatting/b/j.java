package com.tencent.mm.ui.chatting.b;

import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.aj.a;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.k;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.b.b.r;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.s;

@com.tencent.mm.ui.chatting.b.a.a(cFA=com.tencent.mm.ui.chatting.b.b.h.class)
public class j
  extends a
  implements aj, com.tencent.mm.ui.chatting.b.b.h
{
  public static av vpo = new av(5, "MicroMsg.ChattingMoreBtnBarHelper");
  private ad bSg;
  private com.tencent.mm.ui.tools.n drn;
  private com.tencent.mm.ui.tools.j gvM;
  private boolean hasInit = false;
  private Animation ogs;
  private boolean vgB;
  private String vmj = "";
  private boolean vnY = false;
  private ChattingFooterMoreBtnBar vpp;
  private boolean vpq = true;
  
  private void cEg()
  {
    if (this.vnY) {
      this.byx.showOptionMenu(false);
    }
    for (;;)
    {
      ((ai)this.byx.ac(ai.class)).cFy();
      return;
      ((q)this.byx.ac(q.class)).cEG();
    }
  }
  
  public final void a(aj.a parama) {}
  
  public final void aS(bi parambi)
  {
    if (this.hasInit)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
      this.bSg = this.byx.pSb;
      if ((!this.byx.cFD()) && (!((c)this.byx.ac(c.class)).cDH())) {
        break label588;
      }
    }
    label588:
    for (boolean bool = true;; bool = false)
    {
      this.vgB = bool;
      this.vpp.cCO();
      this.byx.vtz.getController().addSearchMenu(true, this.drn);
      this.vpp.startAnimation(this.ogs);
      this.vpp.setVisibility(0);
      this.vnY = true;
      ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFg();
      g localg = (g)this.byx.ac(g.class);
      localg.cDn();
      localg.cDm();
      localg.hQ(parambi.field_msgId);
      int i = localg.bug();
      this.vpp.GQ(i);
      ((k)this.byx.ac(k.class)).cEn();
      this.byx.XM();
      cEg();
      ((com.tencent.mm.ui.chatting.b.b.n)this.byx.ac(com.tencent.mm.ui.chatting.b.b.n.class)).cEz();
      com.tencent.mm.plugin.report.service.h.nFQ.f(10811, new Object[] { Integer.valueOf(1) });
      if (this.bSg.cua())
      {
        parambi = this.byx;
        i = R.h.menu_search;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", new Object[] { Integer.valueOf(i) });
        parambi.vtA.removeOptionMenu(i);
      }
      ((r)this.byx.ac(r.class)).cER();
      return;
      this.hasInit = true;
      if (this.vpp == null)
      {
        ((ViewStub)this.byx.findViewById(R.h.viewstub_chatting_more_btn)).inflate();
        this.vpp = ((ChattingFooterMoreBtnBar)this.byx.findViewById(R.h.chatting_footer_more_btn_bar));
      }
      if (((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFm())
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        if (this.drn == null) {}
      }
      for (this.drn.weq = null;; this.drn.weq = new j.8(this))
      {
        this.vpp.c(3, new j.2(this));
        this.vpp.c(2, new j.3(this));
        this.vpp.c(1, new j.4(this));
        this.vpp.c(0, new j.5(this));
        this.vpp.c(4, new j.6(this));
        this.ogs = AnimationUtils.loadAnimation(this.byx.vtz.getContext(), R.a.push_up_in);
        ((g)this.byx.ac(g.class)).e(new j.1(this));
        this.gvM = new com.tencent.mm.ui.tools.j(this.byx.vtz.getContext());
        break;
        this.drn = new com.tencent.mm.ui.tools.n((byte)0);
      }
    }
  }
  
  public final void aT(bi parambi)
  {
    if (parambi == null) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
    }
    g localg;
    do
    {
      return;
      localg = (g)this.byx.ac(g.class);
    } while (!localg.hQ(parambi.field_msgId));
    int i = localg.bug();
    this.vpp.GQ(i);
    this.vpp.setVisibility(0);
    this.drn.cJg();
  }
  
  public final void b(aj.a parama)
  {
    cEf();
  }
  
  public final void cDe()
  {
    cEf();
  }
  
  public final boolean cDf()
  {
    return this.vpq;
  }
  
  public final void cEf()
  {
    this.byx.vtz.getController().addSearchMenu(false, this.drn);
    this.vpp.setVisibility(8);
    ((g)this.byx.ac(g.class)).aRs();
    ((c)this.byx.ac(c.class)).cDT();
    ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFg();
    this.vnY = false;
    cEg();
    ((k)this.byx.ac(k.class)).cEo();
    ((com.tencent.mm.ui.chatting.b.b.n)this.byx.ac(com.tencent.mm.ui.chatting.b.b.n.class)).cEz();
    this.byx.XM();
    l.cCz();
  }
  
  public final boolean cEh()
  {
    return this.vnY;
  }
  
  public final void cEi()
  {
    if (this.drn != null)
    {
      this.drn.cJg();
      this.drn.weq = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j
 * JD-Core Version:    0.7.0.1
 */