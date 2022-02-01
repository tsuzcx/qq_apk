package com.tencent.mm.ui.chatting.d;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.h;
import com.tencent.mm.ui.chatting.d.b.t;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.z.class)
public class ac
  extends a
  implements com.tencent.mm.ui.chatting.d.b.z
{
  private View JLf;
  private TextView JLg;
  private int JLh;
  private int JLi = 0;
  private Runnable azC;
  
  private boolean fEq()
  {
    AppMethodBeat.i(35441);
    d locald = (d)this.cWM.bh(d.class);
    if ((w.Ai(this.cWM.getTalkerUserName())) || (w.An(this.cWM.getTalkerUserName())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    if ((this.cWM.BYG.fqg()) && (locald.fCE() != null) && (((locald.fCE().Kl()) && (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNf())) || (locald.fCE().Kk())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    AppMethodBeat.o(35441);
    return false;
  }
  
  public final void adk(int paramInt)
  {
    AppMethodBeat.i(35440);
    if (fEq()) {}
    for (int i = 5; (this.JLh < i) || (this.JLf == null); i = 10)
    {
      AppMethodBeat.o(35440);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.JLf.getLayoutParams();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35440);
      return;
      localLayoutParams.setMargins(0, this.cWM.JOR.getMMResources().getDimensionPixelSize(2131165480) * 3, 0, 0);
      AppMethodBeat.o(35440);
      return;
      ao localao = (ao)this.cWM.bh(ao.class);
      int j;
      if (localao.fEU())
      {
        i = localao.fEX();
        if (!localao.fEV()) {
          break label261;
        }
        j = this.cWM.JOR.getMMResources().getDimensionPixelSize(2131165511);
        label187:
        if (!localao.fEW()) {
          break label266;
        }
        paramInt = this.cWM.JOR.getMMResources().getDimensionPixelSize(2131165298);
        label213:
        if (j <= i) {
          break label274;
        }
        if (j <= paramInt) {
          break label271;
        }
        paramInt = j;
      }
      for (;;)
      {
        localLayoutParams.setMargins(0, this.cWM.JOR.getMMResources().getDimensionPixelSize(2131165480) + paramInt, 0, 0);
        AppMethodBeat.o(35440);
        return;
        i = 0;
        break;
        label261:
        j = 0;
        break label187;
        label266:
        paramInt = 0;
        break label213;
        label271:
        continue;
        label274:
        if (i > paramInt) {
          paramInt = i;
        }
      }
      localLayoutParams.setMargins(0, this.cWM.JOR.getMMResources().getDimensionPixelSize(2131165480), 0, 0);
      AppMethodBeat.o(35440);
      return;
      if (!((ao)this.cWM.bh(ao.class)).fEU()) {
        localLayoutParams.setMargins(0, this.cWM.JOR.getMMResources().getDimensionPixelSize(2131165480), 0, 0);
      }
    }
  }
  
  public final int fEl()
  {
    return this.JLh;
  }
  
  public final void fEm()
  {
    AppMethodBeat.i(35437);
    if (this.JLf == null)
    {
      AppMethodBeat.o(35437);
      return;
    }
    this.JLh = -1;
    if (this.JLf.getVisibility() == 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.JLf.getWidth(), 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.cWM.JOR.getContext(), 17432581));
      this.JLf.startAnimation(localTranslateAnimation);
    }
    this.JLf.setVisibility(8);
    AppMethodBeat.o(35437);
  }
  
  public final void fEn()
  {
    AppMethodBeat.i(35438);
    if (fEq()) {}
    for (int i = 5; this.JLh <= i; i = 10)
    {
      ad.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] mUnreadMessageCount is smaller than threshold:".concat(String.valueOf(i)));
      this.JLf.setVisibility(8);
      AppMethodBeat.o(35438);
      return;
    }
    if (this.JLf.getVisibility() == 0)
    {
      ad.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has show!!!");
      AppMethodBeat.o(35438);
      return;
    }
    this.JLf.removeCallbacks(this.azC);
    View localView = this.JLf;
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35436);
        ad.i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
        ac.a(ac.this).setVisibility(0);
        ac.a(ac.this, 1);
        Object localObject = (ao)ac.this.cWM.bh(ao.class);
        if ((((ao)localObject).fEU()) || (((ao)localObject).fEW()) || (((ao)localObject).fEV())) {
          ac.this.adk(1);
        }
        for (;;)
        {
          localObject = new TranslateAnimation(ac.a(ac.this).getWidth(), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject).setDuration(300L);
          ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(ac.this.cWM.JOR.getContext(), 17432581));
          ac.a(ac.this).startAnimation((Animation)localObject);
          AppMethodBeat.o(35436);
          return;
          if (ac.b(ac.this)) {
            ac.this.adk(3);
          } else {
            ac.this.adk(0);
          }
        }
      }
    };
    this.azC = local2;
    localView.postDelayed(local2, 100L);
    AppMethodBeat.o(35438);
  }
  
  public final void fEo()
  {
    this.JLi = 0;
  }
  
  public final int fEp()
  {
    return this.JLi;
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35442);
    super.fws();
    this.JLf = this.cWM.findViewById(2131298101);
    this.JLf.setVisibility(8);
    if (((h)this.cWM.bh(h.class)).fDl()) {
      this.JLh = ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).aif(this.cWM.getTalkerUserName());
    }
    for (;;)
    {
      ad.i("MicroMsg.HistoryMsgTongueComponent", "[onChattingInit] mUnreadMessageCount:%s", new Object[] { Integer.valueOf(this.JLh) });
      AppMethodBeat.o(35442);
      return;
      if (((com.tencent.mm.ui.chatting.d.b.i)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.i.class)).fDn())
      {
        this.JLh = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).aif(this.cWM.getTalkerUserName());
      }
      else
      {
        com.tencent.mm.model.ba.aBQ();
        at localat = com.tencent.mm.model.c.azv().aTz(this.cWM.getTalkerUserName());
        if (localat != null) {
          this.JLh = localat.field_unReadCount;
        }
      }
    }
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35443);
    super.fwu();
    d locald = (d)this.cWM.bh(d.class);
    if (locald.fCH()) {
      this.JLh = locald.fCQ();
    }
    Object localObject = (d)this.cWM.bh(d.class);
    if (((!bt.isNullOrNil(this.cWM.getTalkerUserName())) && (!this.cWM.fFt()) && (!w.Al(this.cWM.getTalkerUserName())) && (!w.zE(this.cWM.getTalkerUserName())) && (!w.Ag(this.cWM.getTalkerUserName())) && (!w.zH(this.cWM.getTalkerUserName()))) || (this.cWM.fFu()) || (((d)localObject).fCH()) || (fEq())) {}
    for (final int i = 1; i == 0; i = 0)
    {
      ad.w("MicroMsg.HistoryMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s unreadCount:%s isBizChat:%s", new Object[] { this.cWM.getTalkerUserName(), Integer.valueOf(this.JLh), Boolean.valueOf(locald.fCH()) });
      this.JLf.setVisibility(8);
      this.JLi = 0;
      AppMethodBeat.o(35443);
      return;
    }
    int j = this.JLh;
    if (fEq())
    {
      i = 5;
      ad.i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j >= i)
      {
        ad.i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
        this.JLg = ((TextView)this.cWM.findViewById(2131298102));
        localObject = com.tencent.mm.booter.z.fFA;
        if (((com.tencent.mm.booter.z)localObject).fFE != null) {
          break label464;
        }
        ((com.tencent.mm.booter.z)localObject).fFF = 1;
        label326:
        if (j <= 999) {
          break label476;
        }
        this.JLg.setText(String.format(this.cWM.JOR.getMMResources().getString(2131757180), new Object[] { Integer.valueOf(999) }));
        label372:
        if (!locald.fCH()) {
          break label516;
        }
        com.tencent.mm.model.ba.aBQ();
      }
    }
    for (i = com.tencent.mm.model.c.azt().ce(this.cWM.getTalkerUserName(), locald.fCU()) - this.JLh;; i = com.tencent.mm.model.c.azs().aqm(this.cWM.getTalkerUserName()) - this.JLh)
    {
      this.JLf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35435);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HistoryMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ac.a(ac.this, 2);
          paramAnonymousView = com.tencent.mm.booter.z.fFA;
          if (paramAnonymousView.fFE != null) {
            paramAnonymousView.fFE.fFV = 2;
          }
          if (((t)ac.this.cWM.bh(t.class)).fDP()) {
            ((t)ac.this.cWM.bh(t.class)).fDQ();
          }
          for (;;)
          {
            if (w.An(ac.this.cWM.getTalkerUserName())) {
              ((com.tencent.mm.ui.chatting.d.b.g)ac.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.g.class)).fDf();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HistoryMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35435);
            return;
            ac.b(ac.this, i);
          }
        }
      });
      if (!((t)this.cWM.bh(t.class)).fDP()) {
        fEn();
      }
      AppMethodBeat.o(35443);
      return;
      i = 10;
      break;
      label464:
      ((com.tencent.mm.booter.z)localObject).fFE.fFV = 1;
      break label326;
      label476:
      this.JLg.setText(String.format(this.cWM.JOR.getMMResources().getString(2131757180), new Object[] { Integer.valueOf(j) }));
      break label372;
      label516:
      com.tencent.mm.model.ba.aBQ();
    }
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35439);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((this.JLh > 0) && (paramInt3 - (paramInt1 + 1) >= this.JLh) && (this.JLf != null) && (this.JLf.getVisibility() == 0))
    {
      ad.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissMsgTongue mUnreadMessage[%d] [%d,%d]", new Object[] { Integer.valueOf(this.JLh), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1) });
      fEm();
    }
    AppMethodBeat.o(35439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ac
 * JD-Core Version:    0.7.0.1
 */