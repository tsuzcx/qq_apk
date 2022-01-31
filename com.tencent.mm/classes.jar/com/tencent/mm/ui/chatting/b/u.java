package com.tencent.mm.ui.chatting.b;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.d;
import com.tencent.mm.booter.z;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.chatting.b.b.ae;
import com.tencent.mm.ui.chatting.b.b.r;
import com.tencent.mm.ui.chatting.e;

@com.tencent.mm.ui.chatting.b.a.a(cFA=r.class)
public class u
  extends a
  implements r
{
  private Runnable amY;
  private View vrg;
  private TextView vrh;
  private int vri;
  private int vrj = 0;
  
  private boolean cEV()
  {
    com.tencent.mm.ui.chatting.b.b.c localc = (com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
    if (s.hP(this.byx.getTalkerUserName())) {
      return true;
    }
    return (this.byx.pSb.cua()) && (localc.cDD() != null) && ((localc.cDD().Lw()) || (localc.cDD().Lv()));
  }
  
  public final void Hc(int paramInt)
  {
    if (cEV())
    {
      i = 5;
      if ((this.vri >= i) && (this.vrg != null)) {
        break label31;
      }
    }
    label31:
    FrameLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      i = 10;
      break;
      localLayoutParams = (FrameLayout.LayoutParams)this.vrg.getLayoutParams();
      switch (paramInt)
      {
      case -1: 
      case 2: 
      default: 
        return;
      }
    } while (((ae)this.byx.ac(ae.class)).cFn());
    localLayoutParams.setMargins(0, this.byx.vtz.getMMResources().getDimensionPixelSize(R.f.LargePadding), 0, 0);
    return;
    localLayoutParams.setMargins(0, this.byx.vtz.getMMResources().getDimensionPixelSize(R.f.LargePadding) * 3, 0, 0);
    return;
    ae localae = (ae)this.byx.ac(ae.class);
    if (localae.cFn())
    {
      paramInt = localae.cFp();
      if (!localae.cFo()) {
        break label257;
      }
    }
    label257:
    for (int i = this.byx.vtz.getMMResources().getDimensionPixelSize(R.f.NormalButtonHeight);; i = 0)
    {
      int j = paramInt;
      if (i > paramInt) {
        j = i;
      }
      localLayoutParams.setMargins(0, this.byx.vtz.getMMResources().getDimensionPixelSize(R.f.LargePadding) + j, 0, 0);
      return;
      paramInt = 0;
      break;
    }
    localLayoutParams.setMargins(0, this.byx.vtz.getMMResources().getDimensionPixelSize(R.f.LargePadding), 0, 0);
  }
  
  public final int cEQ()
  {
    return this.vri;
  }
  
  public final void cER()
  {
    if (this.vrg == null) {
      return;
    }
    this.vri = -1;
    if (this.vrg.getVisibility() == 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.vrg.getWidth(), 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.byx.vtz.getContext(), 17432581));
      this.vrg.startAnimation(localTranslateAnimation);
    }
    this.vrg.setVisibility(8);
  }
  
  public final void cES()
  {
    if (cEV()) {}
    for (int i = 5; this.vri <= i; i = 10)
    {
      y.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] mUnreadMessageCount is smaller than threshold:" + i);
      this.vrg.setVisibility(8);
      return;
    }
    if (this.vrg.getVisibility() == 0)
    {
      y.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has show!!!");
      return;
    }
    this.vrg.removeCallbacks(this.amY);
    View localView = this.vrg;
    u.2 local2 = new u.2(this);
    this.amY = local2;
    localView.postDelayed(local2, 100L);
  }
  
  public final void cET()
  {
    this.vrj = 0;
  }
  
  public final int cEU()
  {
    return this.vrj;
  }
  
  public final void cyM()
  {
    super.cyM();
    this.vrg = this.byx.findViewById(R.h.chatting_goback_history_layout);
    this.vrg.setVisibility(8);
    au.Hx();
    ak localak = com.tencent.mm.model.c.FB().abv(this.byx.getTalkerUserName());
    if (localak != null)
    {
      this.vri = localak.field_unReadCount;
      y.i("MicroMsg.HistoryMsgTongueComponent", "[onChattingInit] getUnDeliverCount:%s mUnreadMessageCount:%s", new Object[] { Integer.valueOf(localak.field_UnDeliverCount), Integer.valueOf(this.vri) });
    }
  }
  
  public final void cyO()
  {
    super.cyO();
    com.tencent.mm.ui.chatting.b.b.c localc = (com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
    if (localc.cDG()) {
      this.vri = localc.cDO();
    }
    Object localObject = (com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
    if (((!bk.bl(this.byx.getTalkerUserName())) && (!this.byx.cFC()) && (!s.hS(this.byx.getTalkerUserName())) && (!s.hl(this.byx.getTalkerUserName())) && (!s.hN(this.byx.getTalkerUserName())) && (!s.ho(this.byx.getTalkerUserName()))) || (this.byx.cFD()) || (((com.tencent.mm.ui.chatting.b.b.c)localObject).cDG()) || (cEV()))
    {
      i = 1;
      if (i != 0) {
        break label222;
      }
      y.w("MicroMsg.HistoryMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s unreadCount:%s isBizChat:%s", new Object[] { this.byx.getTalkerUserName(), Integer.valueOf(this.vri), Boolean.valueOf(localc.cDG()) });
      this.vrg.setVisibility(8);
      this.vrj = 0;
    }
    label222:
    int j;
    label236:
    do
    {
      return;
      i = 0;
      break;
      j = this.vri;
      if (!cEV()) {
        break label437;
      }
      i = 5;
      y.i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    } while (j < i);
    y.i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
    this.vrh = ((TextView)this.byx.findViewById(R.h.chatting_goback_history_tv));
    localObject = z.diw;
    if (((z)localObject).diA == null)
    {
      ((z)localObject).diB = 1;
      label311:
      if (j <= 999) {
        break label455;
      }
      this.vrh.setText(String.format(this.byx.vtz.getMMResources().getString(R.l.chatting_history_go_back_tip), new Object[] { Integer.valueOf(999) }));
      label357:
      if (!localc.cDG()) {
        break label495;
      }
      au.Hx();
    }
    for (int i = com.tencent.mm.model.c.Fz().ax(this.byx.getTalkerUserName(), localc.cDS()) - this.vri;; i = com.tencent.mm.model.c.Fy().HP(this.byx.getTalkerUserName()) - this.vri)
    {
      this.vrg.setOnClickListener(new u.1(this, i));
      if (((com.tencent.mm.ui.chatting.b.b.o)this.byx.ac(com.tencent.mm.ui.chatting.b.b.o.class)).cEB()) {
        break;
      }
      cES();
      return;
      label437:
      i = 10;
      break label236;
      ((z)localObject).diA.diS = 1;
      break label311;
      label455:
      this.vrh.setText(String.format(this.byx.vtz.getMMResources().getString(R.l.chatting_history_go_back_tip), new Object[] { Integer.valueOf(j) }));
      break label357;
      label495:
      au.Hx();
    }
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((this.vri > 0) && (paramInt3 - (paramInt1 + 1) >= this.vri) && (this.vrg != null) && (this.vrg.getVisibility() == 0))
    {
      y.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissMsgTongue mUnreadMessage[%d] [%d,%d]", new Object[] { Integer.valueOf(this.vri), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1) });
      cER();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.u
 * JD-Core Version:    0.7.0.1
 */