package com.tencent.mm.ui.chatting.component;

import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ae;
import com.tencent.mm.ui.chatting.component.api.ao;
import com.tencent.mm.ui.chatting.component.api.ba;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.y;
import com.tencent.mm.ui.chatting.view.d;
import com.tencent.mm.ui.chatting.view.d.b;
import java.util.Arrays;
import kotlin.g.b.am;
import kotlin.g.b.s;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=ao.class)
public class az
  extends a
  implements ao
{
  private long MQo = 0L;
  private View aevD;
  private TextView aevE;
  private d aevF;
  private int aevG = 0;
  private long aevH = 0L;
  private long aevI = 0L;
  private Runnable yy;
  
  public final void a(final cc paramcc1, cc paramcc2, int paramInt)
  {
    AppMethodBeat.i(255820);
    if (this.aevD == null)
    {
      AppMethodBeat.o(255820);
      return;
    }
    e locale = (e)this.hlc.cm(e.class);
    if ((paramcc2 != null) && (paramcc1 != null) && (paramcc2.field_msgId != this.aevI))
    {
      this.MQo = paramcc2.field_msgId;
      this.aevI = paramcc1.field_msgId;
      this.aevH = paramInt;
    }
    paramcc2 = (e)this.hlc.cm(e.class);
    if (((Util.isNullOrNil(this.hlc.getTalkerUserName())) || (this.hlc.juE()) || (au.bwx(this.hlc.getTalkerUserName())) || (ab.IS(this.hlc.getTalkerUserName())) || (au.bws(this.hlc.getTalkerUserName())) || (au.bvS(this.hlc.getTalkerUserName()))) && (!this.hlc.juF()) && (!paramcc2.jqV()))
    {
      paramcc2 = (e)this.hlc.cm(e.class);
      if ((!au.bwu(this.hlc.getTalkerUserName())) && (!au.bwA(this.hlc.getTalkerUserName()))) {
        break label286;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label359;
      }
    }
    label286:
    label359:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label364;
      }
      Log.w("MicroMsg.QuoteMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s isBizChat:%s", new Object[] { this.hlc.getTalkerUserName(), Boolean.valueOf(locale.jqV()) });
      this.aevD.setVisibility(8);
      this.aevG = 0;
      AppMethodBeat.o(255820);
      return;
      if ((this.hlc.Uxa.iZC()) && (paramcc2.jqS() != null) && (((paramcc2.jqS().aAN()) && (!((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbw())) || (paramcc2.jqS().aAM())))
      {
        paramInt = 1;
        break;
      }
      paramInt = 0;
      break;
    }
    label364:
    Log.i("MicroMsg.QuoteMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
    this.aevE = ((TextView)this.hlc.findViewById(R.h.fyq));
    this.aevE.setText(this.hlc.aezO.getMMResources().getString(R.l.gzf));
    this.aevD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(256363);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/QuoteMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        az.a(az.this, 2);
        az.a(az.this, az.a(az.this), paramcc1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/QuoteMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(256363);
      }
    });
    if (!((y)this.hlc.cm(y.class)).jss())
    {
      if (this.aevD.getVisibility() == 0)
      {
        Log.w("MicroMsg.QuoteMsgTongueComponent", "[showMsgTongue] has show!!!");
        AppMethodBeat.o(255820);
        return;
      }
      paramInt = this.hlc.getListView().getFirstVisiblePosition();
      int i = this.hlc.getListView().getLastVisiblePosition();
      paramInt = Math.max(paramInt, 0);
      i = Math.max(i, 0);
      if ((paramInt < 0) || (i >= this.hlc.getListView().getAdapter().getCount())) {
        Log.i("MicroMsg.QuoteMsgTongueComponent", "invalid position %d-%d, cnt:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.hlc.getListView().getAdapter().getCount()) });
      }
      label654:
      for (;;)
      {
        paramInt = 0;
        if (paramInt == 0) {
          break;
        }
        Log.i("MicroMsg.QuoteMsgTongueComponent", "[showMsgTongue] is AheadMsgInScreen!!!");
        AppMethodBeat.o(255820);
        return;
        for (;;)
        {
          if (paramInt > i) {
            break label654;
          }
          paramcc1 = (cc)this.hlc.getListView().getAdapter().getItem(paramInt);
          if ((paramcc1 != null) && (this.MQo == paramcc1.field_msgId))
          {
            paramInt = 1;
            break;
          }
          paramInt += 1;
        }
      }
      this.hlc.hideVKB();
      ((ae)this.hlc.cm(ae.class)).jsW();
      this.aevD.removeCallbacks(this.yy);
      paramcc1 = this.aevD;
      paramcc2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256353);
          Log.i("MicroMsg.QuoteMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
          az.b(az.this).setVisibility(0);
          az.a(az.this, 1);
          Object localObject = (ba)az.this.hlc.cm(ba.class);
          if ((((ba)localObject).jtH()) || (((ba)localObject).jtJ()) || (((ba)localObject).jtI())) {
            az.this.aCi(1);
          }
          for (;;)
          {
            localObject = new TranslateAnimation(az.b(az.this).getWidth(), 0.0F, 0.0F, 0.0F);
            ((TranslateAnimation)localObject).setDuration(300L);
            ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(az.this.hlc.aezO.getContext(), 17432581));
            az.b(az.this).startAnimation((Animation)localObject);
            AppMethodBeat.o(256353);
            return;
            if (az.c(az.this)) {
              az.this.aCi(3);
            } else {
              az.this.aCi(0);
            }
          }
        }
      };
      this.yy = paramcc2;
      paramcc1.postDelayed(paramcc2, 100L);
    }
    AppMethodBeat.o(255820);
  }
  
  public final void aCi(int paramInt)
  {
    AppMethodBeat.i(255855);
    if (this.aevD == null)
    {
      AppMethodBeat.o(255855);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.aevD.getLayoutParams();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(255855);
      return;
      localLayoutParams.setMargins(0, 0, 0, this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.LargePadding) * 3);
      AppMethodBeat.o(255855);
      return;
      ba localba = (ba)this.hlc.cm(ba.class);
      int i;
      int j;
      if (localba.jtH())
      {
        i = localba.jtK();
        if (!localba.jtI()) {
          break label249;
        }
        j = this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.NormalButtonHeight);
        label172:
        if (!localba.jtJ()) {
          break label254;
        }
        paramInt = this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.Edge_6A);
        label199:
        if (j <= i) {
          break label262;
        }
        if (j <= paramInt) {
          break label259;
        }
        paramInt = j;
      }
      for (;;)
      {
        localLayoutParams.setMargins(0, 0, 0, this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.LargePadding) + paramInt);
        AppMethodBeat.o(255855);
        return;
        i = 0;
        break;
        label249:
        j = 0;
        break label172;
        label254:
        paramInt = 0;
        break label199;
        label259:
        continue;
        label262:
        if (i > paramInt) {
          paramInt = i;
        }
      }
      localLayoutParams.setMargins(0, 0, 0, this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.LargePadding) * 3);
      AppMethodBeat.o(255855);
      return;
      if (!((ba)this.hlc.cm(ba.class)).jtH()) {
        localLayoutParams.setMargins(0, 0, 0, this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.LargePadding) * 3);
      }
    }
  }
  
  public final void d(View paramView, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(255837);
    if (this.aevF != null)
    {
      this.aevF.dismiss();
      this.aevF = null;
    }
    this.aevF = new d(paramView.getContext());
    Object localObject1 = new int[2];
    paramView.getLocationInWindow((int[])localObject1);
    int m;
    int n;
    int[] arrayOfInt;
    int i;
    int i3;
    int i1;
    int i2;
    try
    {
      this.aevF.GDy = localObject1[0];
      this.aevF.bmv = com.tencent.mm.cd.a.fromDPToPix(paramView.getContext(), 2);
      this.aevF.aeLB = com.tencent.mm.cd.a.fromDPToPix(paramView.getContext(), 100);
      localObject1 = this.aevF;
      s.u(paramView, "anchor");
      if (!((d)localObject1).GDx)
      {
        ((d)localObject1).getContentView().measure(0, 0);
        ((d)localObject1).GDx = true;
      }
      m = ((d)localObject1).getContentView().getMeasuredWidth();
      n = ((d)localObject1).getContentView().getMeasuredHeight();
      arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      i = arrayOfInt[0];
      j = (paramView.getWidth() - m) / 2 + i;
      i3 = arrayOfInt[1] - n;
      localObject2 = aw.bf(((d)localObject1).context);
      i1 = ((Point)localObject2).x;
      i2 = ((Point)localObject2).y;
      int i4 = ((d)localObject1).GDy;
      int k = ((d)localObject1).GDy + 0;
      i = j;
      if (j <= i1 - i4 - m)
      {
        i = j;
        if (j < k) {
          i = k;
        }
      }
      localObject2 = ((d)localObject1).GDu.getLayoutParams();
      if (localObject2 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(255837);
        throw paramView;
      }
    }
    finally
    {
      AppMethodBeat.o(255837);
      return;
    }
    Object localObject2 = (RelativeLayout.LayoutParams)localObject2;
    if (((d)localObject1).GDw.getLayoutParams() == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(255837);
      throw paramView;
    }
    ((RelativeLayout.LayoutParams)localObject2).setMarginStart(arrayOfInt[0] + paramView.getWidth() / 2 - i - ((d)localObject1).GDu.getMeasuredWidth() / 2);
    if (i3 <= ((d)localObject1).aeLB) {
      if (((d)localObject1).aeLC != d.b.aeLE)
      {
        ((d)localObject1).getContentView().setRotation(((d)localObject1).getContentView().getRotation() + 180.0F);
        ((d)localObject1).GDw.setRotation(((d)localObject1).GDw.getRotation() + 180.0F);
        ((d)localObject1).aeLC = d.b.aeLE;
      }
    }
    for (int j = ((d)localObject1).bmv + n + paramView.getHeight() + i3;; j = i3 - j)
    {
      ((d)localObject1).setAnimationStyle(R.m.gZs);
      ((d)localObject1).showAtLocation(paramView, 0, i, j);
      paramView = am.aixg;
      s.s(String.format("popX:%s, popY:%s, sw:%s, sh:%s, pw:%s, ph:%s", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(m), Integer.valueOf(n) }, 6)), "java.lang.String.format(format, *args)");
      this.aevF.aeLD = paramOnClickListener;
      AppMethodBeat.o(255837);
      return;
      if (((d)localObject1).aeLC != d.b.aeLF)
      {
        ((d)localObject1).getContentView().setRotation(((d)localObject1).getContentView().getRotation() + 180.0F);
        ((d)localObject1).GDw.setRotation(((d)localObject1).GDw.getRotation() + 180.0F);
        ((d)localObject1).aeLC = d.b.aeLF;
      }
      j = ((d)localObject1).bmv;
    }
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(255860);
    super.jjf();
    this.aevD = this.hlc.findViewById(R.h.fyp);
    if (this.aevD == null)
    {
      AppMethodBeat.o(255860);
      return;
    }
    this.aevD.setVisibility(8);
    this.MQo = 0L;
    this.aevI = 0L;
    AppMethodBeat.o(255860);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(255862);
    super.jjh();
    AppMethodBeat.o(255862);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(255851);
    super.jji();
    AppMethodBeat.o(255851);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(255847);
    super.jjj();
    if (this.aevF != null) {
      this.aevF.dismiss();
    }
    AppMethodBeat.o(255847);
  }
  
  public final void jsW()
  {
    AppMethodBeat.i(255828);
    if (this.aevD == null)
    {
      AppMethodBeat.o(255828);
      return;
    }
    if (this.aevD.getVisibility() == 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.aevD.getWidth(), 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.hlc.aezO.getContext(), 17432581));
      this.aevD.startAnimation(localTranslateAnimation);
      this.aevI = 0L;
      this.MQo = 0L;
      this.aevH = 0L;
    }
    this.aevD.setVisibility(8);
    AppMethodBeat.o(255828);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(255841);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((this.aevH >= paramInt1) && (this.aevH < paramInt1 + paramInt2)) {
      jsW();
    }
    AppMethodBeat.o(255841);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(255843);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if ((paramInt == 1) && (this.aevF != null) && (this.aevF.isShowing())) {
      this.aevF.dismiss();
    }
    AppMethodBeat.o(255843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.az
 * JD-Core Version:    0.7.0.1
 */