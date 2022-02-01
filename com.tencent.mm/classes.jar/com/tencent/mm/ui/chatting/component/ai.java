package com.tencent.mm.ui.chatting.component;

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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.textstatus.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ae;
import com.tencent.mm.ui.chatting.component.api.ba;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.k;
import com.tencent.mm.ui.chatting.component.api.r;
import com.tencent.mm.ui.chatting.component.api.y;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=ae.class)
public class ai
  extends a
  implements ae
{
  private View aeuw;
  private TextView aeux;
  private int aeuy;
  private int aeuz = 0;
  private int mVisibleItemCount = 0;
  private Runnable yy;
  
  private boolean jta()
  {
    AppMethodBeat.i(35441);
    e locale = (e)this.hlc.cm(e.class);
    if ((au.bwu(this.hlc.getTalkerUserName())) || (au.bwA(this.hlc.getTalkerUserName())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    if ((this.hlc.Uxa.iZC()) && (locale.jqS() != null) && (((locale.jqS().aAN()) && (!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbw())) || (locale.jqS().aAM())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    AppMethodBeat.o(35441);
    return false;
  }
  
  public final void aCf(int paramInt)
  {
    AppMethodBeat.i(35440);
    if (jta()) {}
    for (int i = 5; (this.aeuy < i) || (this.aeuw == null); i = 10)
    {
      AppMethodBeat.o(35440);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.aeuw.getLayoutParams();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35440);
      return;
      localLayoutParams.setMargins(0, this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.LargePadding) * 3, 0, 0);
      AppMethodBeat.o(35440);
      return;
      ba localba = (ba)this.hlc.cm(ba.class);
      int j;
      if (localba.jtH())
      {
        i = localba.jtK();
        if (!localba.jtI()) {
          break label265;
        }
        j = this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.NormalButtonHeight);
        label189:
        if (!localba.jtJ()) {
          break label270;
        }
        paramInt = this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.Edge_6A);
        label216:
        if (j <= i) {
          break label278;
        }
        if (j <= paramInt) {
          break label275;
        }
        paramInt = j;
      }
      for (;;)
      {
        localLayoutParams.setMargins(0, this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.LargePadding) + paramInt, 0, 0);
        AppMethodBeat.o(35440);
        return;
        i = 0;
        break;
        label265:
        j = 0;
        break label189;
        label270:
        paramInt = 0;
        break label216;
        label275:
        continue;
        label278:
        if (i > paramInt) {
          paramInt = i;
        }
      }
      localLayoutParams.setMargins(0, this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.LargePadding), 0, 0);
      AppMethodBeat.o(35440);
      return;
      if (!((ba)this.hlc.cm(ba.class)).jtH()) {
        localLayoutParams.setMargins(0, this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.LargePadding), 0, 0);
      }
    }
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35442);
    super.jjf();
    this.aeuw = this.hlc.findViewById(R.h.fyr);
    this.aeuw.setVisibility(8);
    if (((com.tencent.mm.ui.chatting.component.api.i)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.i.class)).jrA()) {
      this.aeuy = ((com.tencent.mm.plugin.findersdk.a.z)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.z.class)).aAs(this.hlc.getTalkerUserName());
    }
    for (;;)
    {
      Log.i("MicroMsg.HistoryMsgTongueComponent", "[onChattingInit] mUnreadMessageCount:%s", new Object[] { Integer.valueOf(this.aeuy) });
      AppMethodBeat.o(35442);
      return;
      if (((k)this.hlc.cm(k.class)).jrF())
      {
        this.aeuy = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).aAs(this.hlc.getTalkerUserName());
      }
      else if (((r)this.hlc.cm(r.class)).jrT())
      {
        this.aeuy = ((s)com.tencent.mm.kernel.h.ax(s.class)).aAs(this.hlc.getTalkerUserName());
      }
      else
      {
        bh.bCz();
        bb localbb = com.tencent.mm.model.c.bzG().bxM(this.hlc.getTalkerUserName());
        if (localbb != null) {
          this.aeuy = localbb.field_unReadCount;
        }
      }
    }
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35443);
    super.jjh();
    e locale = (e)this.hlc.cm(e.class);
    if (locale.jqV()) {
      this.aeuy = locale.jrg();
    }
    this.hlc.cm(e.class);
    if (((!Util.isNullOrNil(this.hlc.getTalkerUserName())) && (!this.hlc.juE()) && (!au.bwx(this.hlc.getTalkerUserName())) && (!ab.IS(this.hlc.getTalkerUserName())) && (!au.bws(this.hlc.getTalkerUserName())) && (!au.bvS(this.hlc.getTalkerUserName()))) || (this.hlc.juF()) || (jta())) {}
    for (final int i = 1; i == 0; i = 0)
    {
      Log.w("MicroMsg.HistoryMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s unreadCount:%s isBizChat:%s", new Object[] { this.hlc.getTalkerUserName(), Integer.valueOf(this.aeuy), Boolean.valueOf(locale.jqV()) });
      this.aeuw.setVisibility(8);
      this.aeuz = 0;
      AppMethodBeat.o(35443);
      return;
    }
    int j = this.aeuy;
    com.tencent.mm.booter.z localz;
    if (jta())
    {
      i = 5;
      Log.i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j >= i)
      {
        Log.i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
        this.aeux = ((TextView)this.hlc.findViewById(R.h.fys));
        localz = com.tencent.mm.booter.z.lsV;
        if (localz.lsZ != null) {
          break label450;
        }
        localz.lta = 1;
        label312:
        if (j <= 999) {
          break label462;
        }
        this.aeux.setText(String.format(this.hlc.aezO.getMMResources().getString(R.l.gxB), new Object[] { Integer.valueOf(999) }));
        label358:
        if (!locale.jqV()) {
          break label502;
        }
        bh.bCz();
      }
    }
    for (i = com.tencent.mm.model.c.bzE().cu(this.hlc.getTalkerUserName(), locale.jrk()) - this.aeuy;; i = com.tencent.mm.model.c.bzD().aLW(this.hlc.getTalkerUserName()) - this.aeuy)
    {
      this.aeuw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35435);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HistoryMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ai.a(ai.this, 2);
          paramAnonymousView = com.tencent.mm.booter.z.lsV;
          if (paramAnonymousView.lsZ != null) {
            paramAnonymousView.lsZ.ltq = 2;
          }
          if (((y)ai.this.hlc.cm(y.class)).jss()) {
            ((y)ai.this.hlc.cm(y.class)).jst();
          }
          for (;;)
          {
            if (au.bwA(ai.this.hlc.getTalkerUserName())) {
              ((com.tencent.mm.ui.chatting.component.api.h)ai.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.h.class)).jru();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HistoryMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35435);
            return;
            ai.b(ai.this, i);
          }
        }
      });
      if (!((y)this.hlc.cm(y.class)).jss()) {
        jsX();
      }
      AppMethodBeat.o(35443);
      return;
      i = 10;
      break;
      label450:
      localz.lsZ.ltq = 1;
      break label312;
      label462:
      this.aeux.setText(String.format(this.hlc.aezO.getMMResources().getString(R.l.gxB), new Object[] { Integer.valueOf(j) }));
      break label358;
      label502:
      bh.bCz();
    }
  }
  
  public final int jsV()
  {
    return this.aeuy;
  }
  
  public final void jsW()
  {
    AppMethodBeat.i(35437);
    if (this.aeuw == null)
    {
      AppMethodBeat.o(35437);
      return;
    }
    this.aeuy = -1;
    if (this.aeuw.getVisibility() == 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.aeuw.getWidth(), 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.hlc.aezO.getContext(), 17432581));
      this.aeuw.startAnimation(localTranslateAnimation);
    }
    this.aeuw.setVisibility(8);
    AppMethodBeat.o(35437);
  }
  
  public final void jsX()
  {
    AppMethodBeat.i(35438);
    if (jta()) {}
    for (int i = 5; this.aeuy <= i; i = 10)
    {
      Log.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] mUnreadMessageCount is smaller than threshold:".concat(String.valueOf(i)));
      this.aeuw.setVisibility(8);
      AppMethodBeat.o(35438);
      return;
    }
    if (this.aeuw.getVisibility() == 0)
    {
      Log.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has show!!!");
      AppMethodBeat.o(35438);
      return;
    }
    if ((au.bwu(this.hlc.getTalkerUserName())) && (this.aeuy <= this.mVisibleItemCount))
    {
      Log.i("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has fold message cell");
      AppMethodBeat.o(35438);
      return;
    }
    this.aeuw.removeCallbacks(this.yy);
    View localView = this.aeuw;
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35436);
        Log.i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
        ai.a(ai.this).setVisibility(0);
        ai.a(ai.this, 1);
        Object localObject = (ba)ai.this.hlc.cm(ba.class);
        if ((((ba)localObject).jtH()) || (((ba)localObject).jtJ()) || (((ba)localObject).jtI())) {
          ai.this.aCf(1);
        }
        for (;;)
        {
          localObject = new TranslateAnimation(ai.a(ai.this).getWidth(), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject).setDuration(300L);
          ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(ai.this.hlc.aezO.getContext(), 17432581));
          ai.a(ai.this).startAnimation((Animation)localObject);
          AppMethodBeat.o(35436);
          return;
          if (ai.b(ai.this)) {
            ai.this.aCf(3);
          } else {
            ai.this.aCf(0);
          }
        }
      }
    };
    this.yy = local2;
    localView.postDelayed(local2, 100L);
    AppMethodBeat.o(35438);
  }
  
  public final void jsY()
  {
    this.aeuz = 0;
  }
  
  public final int jsZ()
  {
    return this.aeuz;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35439);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    this.mVisibleItemCount = paramInt2;
    if ((this.aeuy > 0) && (paramInt3 - (paramInt1 + 1) >= this.aeuy) && (this.aeuw != null) && (this.aeuw.getVisibility() == 0))
    {
      Log.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissMsgTongue mUnreadMessage[%d] [%d,%d]", new Object[] { Integer.valueOf(this.aeuy), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1) });
      jsW();
    }
    AppMethodBeat.o(35439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ai
 * JD-Core Version:    0.7.0.1
 */