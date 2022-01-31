package com.tencent.mm.ui.chatting.c;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.y;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.p;
import com.tencent.mm.ui.chatting.c.b.s;

@com.tencent.mm.ui.chatting.c.a.a(dJy=s.class)
public class u
  extends a
  implements s
{
  private Runnable apo;
  private View zGL;
  private TextView zGM;
  private int zGN;
  private int zGO = 0;
  
  private boolean dIM()
  {
    AppMethodBeat.i(31546);
    com.tencent.mm.ui.chatting.c.b.d locald = (com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class);
    if (t.oy(this.caz.getTalkerUserName()))
    {
      AppMethodBeat.o(31546);
      return true;
    }
    if ((this.caz.txj.dwz()) && (locald.dHs() != null) && (((locald.dHs().aee()) && (!((b)g.E(b.class)).aWl())) || (locald.dHs().aed())))
    {
      AppMethodBeat.o(31546);
      return true;
    }
    AppMethodBeat.o(31546);
    return false;
  }
  
  public final void PG(int paramInt)
  {
    AppMethodBeat.i(31545);
    if (dIM()) {}
    for (int i = 5; (this.zGN < i) || (this.zGL == null); i = 10)
    {
      AppMethodBeat.o(31545);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.zGL.getLayoutParams();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31545);
      return;
      localLayoutParams.setMargins(0, this.caz.zJz.getMMResources().getDimensionPixelSize(2131427772) * 3, 0, 0);
      AppMethodBeat.o(31545);
      return;
      af localaf = (af)this.caz.ay(af.class);
      if (localaf.dJj())
      {
        paramInt = localaf.dJl();
        if (!localaf.dJk()) {
          break label239;
        }
      }
      label239:
      for (i = this.caz.zJz.getMMResources().getDimensionPixelSize(2131427803);; i = 0)
      {
        int j = paramInt;
        if (i > paramInt) {
          j = i;
        }
        localLayoutParams.setMargins(0, this.caz.zJz.getMMResources().getDimensionPixelSize(2131427772) + j, 0, 0);
        AppMethodBeat.o(31545);
        return;
        paramInt = 0;
        break;
      }
      localLayoutParams.setMargins(0, this.caz.zJz.getMMResources().getDimensionPixelSize(2131427772), 0, 0);
      AppMethodBeat.o(31545);
      return;
      if (!((af)this.caz.ay(af.class)).dJj()) {
        localLayoutParams.setMargins(0, this.caz.zJz.getMMResources().getDimensionPixelSize(2131427772), 0, 0);
      }
    }
  }
  
  public final void dBY()
  {
    AppMethodBeat.i(31547);
    super.dBY();
    this.zGL = this.caz.findViewById(2131822451);
    this.zGL.setVisibility(8);
    aw.aaz();
    ak localak = c.YF().arH(this.caz.getTalkerUserName());
    if (localak != null)
    {
      this.zGN = localak.field_unReadCount;
      ab.i("MicroMsg.HistoryMsgTongueComponent", "[onChattingInit] getUnDeliverCount:%s mUnreadMessageCount:%s", new Object[] { Integer.valueOf(localak.field_UnDeliverCount), Integer.valueOf(this.zGN) });
    }
    AppMethodBeat.o(31547);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31548);
    super.dCa();
    com.tencent.mm.ui.chatting.c.b.d locald = (com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class);
    if (locald.dHv()) {
      this.zGN = locald.dHE();
    }
    Object localObject = (com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class);
    if (((!bo.isNullOrNil(this.caz.getTalkerUserName())) && (!this.caz.dJE()) && (!t.oB(this.caz.getTalkerUserName())) && (!t.nU(this.caz.getTalkerUserName())) && (!t.ow(this.caz.getTalkerUserName())) && (!t.nX(this.caz.getTalkerUserName()))) || (this.caz.dJF()) || (((com.tencent.mm.ui.chatting.c.b.d)localObject).dHv()) || (dIM())) {}
    for (int i = 1; i == 0; i = 0)
    {
      ab.w("MicroMsg.HistoryMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s unreadCount:%s isBizChat:%s", new Object[] { this.caz.getTalkerUserName(), Integer.valueOf(this.zGN), Boolean.valueOf(locald.dHv()) });
      this.zGL.setVisibility(8);
      this.zGO = 0;
      AppMethodBeat.o(31548);
      return;
    }
    int j = this.zGN;
    if (dIM())
    {
      i = 5;
      ab.i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j >= i)
      {
        ab.i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
        this.zGM = ((TextView)this.caz.findViewById(2131822452));
        localObject = y.dZP;
        if (((y)localObject).dZT != null) {
          break label461;
        }
        ((y)localObject).dZU = 1;
        label323:
        if (j <= 999) {
          break label473;
        }
        this.zGM.setText(String.format(this.caz.zJz.getMMResources().getString(2131298191), new Object[] { Integer.valueOf(999) }));
        label369:
        if (!locald.dHv()) {
          break label513;
        }
        aw.aaz();
      }
    }
    for (i = c.YD().bf(this.caz.getTalkerUserName(), locald.dHI()) - this.zGN;; i = c.YC().TA(this.caz.getTalkerUserName()) - this.zGN)
    {
      this.zGL.setOnClickListener(new u.1(this, i));
      if (!((p)this.caz.ay(p.class)).dIr()) {
        dIJ();
      }
      AppMethodBeat.o(31548);
      return;
      i = 10;
      break;
      label461:
      ((y)localObject).dZT.eal = 1;
      break label323;
      label473:
      this.zGM.setText(String.format(this.caz.zJz.getMMResources().getString(2131298191), new Object[] { Integer.valueOf(j) }));
      break label369;
      label513:
      aw.aaz();
    }
  }
  
  public final int dIH()
  {
    return this.zGN;
  }
  
  public final void dII()
  {
    AppMethodBeat.i(31542);
    if (this.zGL == null)
    {
      AppMethodBeat.o(31542);
      return;
    }
    this.zGN = -1;
    if (this.zGL.getVisibility() == 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.zGL.getWidth(), 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.caz.zJz.getContext(), 17432581));
      this.zGL.startAnimation(localTranslateAnimation);
    }
    this.zGL.setVisibility(8);
    AppMethodBeat.o(31542);
  }
  
  public final void dIJ()
  {
    AppMethodBeat.i(31543);
    if (dIM()) {}
    for (int i = 5; this.zGN <= i; i = 10)
    {
      ab.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] mUnreadMessageCount is smaller than threshold:".concat(String.valueOf(i)));
      this.zGL.setVisibility(8);
      AppMethodBeat.o(31543);
      return;
    }
    if (this.zGL.getVisibility() == 0)
    {
      ab.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has show!!!");
      AppMethodBeat.o(31543);
      return;
    }
    this.zGL.removeCallbacks(this.apo);
    View localView = this.zGL;
    u.2 local2 = new u.2(this);
    this.apo = local2;
    localView.postDelayed(local2, 100L);
    AppMethodBeat.o(31543);
  }
  
  public final void dIK()
  {
    this.zGO = 0;
  }
  
  public final int dIL()
  {
    return this.zGO;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(31544);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((this.zGN > 0) && (paramInt3 - (paramInt1 + 1) >= this.zGN) && (this.zGL != null) && (this.zGL.getVisibility() == 0))
    {
      ab.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissMsgTongue mUnreadMessage[%d] [%d,%d]", new Object[] { Integer.valueOf(this.zGN), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1) });
      dII();
    }
    AppMethodBeat.o(31544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.u
 * JD-Core Version:    0.7.0.1
 */