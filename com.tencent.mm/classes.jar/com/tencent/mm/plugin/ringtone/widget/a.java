package com.tencent.mm.plugin.ringtone.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.ringtone.b.c;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.plugin.ringtone.c;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/widget/CommonRingtoneLayout;", "Lcom/tencent/mm/plugin/ringtone/widget/RingtoneControlEvent;", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "globalRingtoneEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/ringtone/widget/RingtoneControlEvent$ControlEvent;", "getGlobalRingtoneEvent", "()Landroidx/lifecycle/MutableLiveData;", "setGlobalRingtoneEvent", "(Landroidx/lifecycle/MutableLiveData;)V", "mContext", "Landroid/content/Context;", "mDuration", "", "mPlayerIcon", "Lcom/tencent/mm/plugin/ringtone/widget/RingtonePlayIcon;", "getMPlayerIcon", "()Lcom/tencent/mm/plugin/ringtone/widget/RingtonePlayIcon;", "setMPlayerIcon", "(Lcom/tencent/mm/plugin/ringtone/widget/RingtonePlayIcon;)V", "mRingBackInfo", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "mRingtoneAnimationIV", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "mRingtoneDuration", "Landroid/widget/TextView;", "mRingtoneNameTv", "mSwitchIcon", "ringtoneDurationTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getRootView", "()Landroid/view/View;", "setRootView", "applyRingtonePlay", "", "play", "", "formatTime", "", "time", "refreshCommonRingBackInfo", "info", "release", "responseRingtonePlay", "isPlay", "showReplaceRingtone", "startCountDown", "startCountDownRingtone", "startRingtoneAnimatorIv", "statusChange", "status", "param", "Landroid/os/Bundle;", "stopRingtoneAnimatorIv", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b
{
  public TextView OFU;
  public MMAnimateView OFV;
  public TextView OFW;
  public com.tencent.mm.plugin.ringtone.g.d OFX;
  public MTimerHandler OFY;
  public x<b.a> OFZ;
  private View OGa;
  public d OGb;
  public Context mContext;
  private long mDuration;
  public View rootView;
  
  public a(View paramView)
  {
    AppMethodBeat.i(273121);
    this.rootView = paramView;
    paramView = this.rootView.getContext();
    s.s(paramView, "rootView.context");
    this.mContext = paramView;
    this.OFZ = new x();
    this.OFU = ((TextView)this.rootView.findViewById(b.c.common_ringtone_name));
    this.OFW = ((TextView)this.rootView.findViewById(b.c.common_ringtone_play_duration));
    this.OFV = ((MMAnimateView)this.rootView.findViewById(b.c.ringtone_animator_iv));
    paramView = this.OFV;
    if (paramView != null)
    {
      Object localObject = com.tencent.mm.plugin.ringtone.l.b.OFS;
      localObject = this.rootView.getContext();
      s.s(localObject, "rootView.context");
      paramView.setImageDrawable(com.tencent.mm.plugin.ringtone.l.b.m((Context)localObject, b.e.icons_filled_ringing, com.tencent.mm.plugin.ringtone.b.a.FG_0));
    }
    paramView = this.OFV;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    this.OGa = this.rootView.findViewById(b.c.ringtone_replace);
    paramView = this.OGa;
    if (paramView != null) {
      paramView.setOnClickListener(new a..ExternalSyntheticLambda0(this));
    }
    paramView = this.rootView.findViewById(b.c.ringtone_play_iv);
    s.s(paramView, "rootView.findViewById(R.id.ringtone_play_iv)");
    this.OGb = new d((WeImageView)paramView, this.mContext);
    paramView = this.OGb;
    if (paramView != null) {
      paramView.setOnClickListener(new a..ExternalSyntheticLambda1(this));
    }
    this.rootView.setOnClickListener(new a..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(273121);
  }
  
  private final void BS(boolean paramBoolean)
  {
    AppMethodBeat.i(273135);
    d locald;
    if (paramBoolean)
    {
      locald = this.OGb;
      if (locald != null)
      {
        locald.gPh();
        AppMethodBeat.o(273135);
      }
    }
    else
    {
      locald = this.OGb;
      if (locald != null) {
        locald.gPi();
      }
    }
    AppMethodBeat.o(273135);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(273186);
    s.u(parama, "this$0");
    if (parama.OFX != null) {
      if (parama.mDuration > 0L)
      {
        parama.mDuration -= 1L;
        TextView localTextView = parama.OFW;
        if (localTextView != null)
        {
          localTextView.setText((CharSequence)iY(Math.max(0L, parama.mDuration)));
          AppMethodBeat.o(273186);
        }
      }
      else
      {
        ((b)parama).a(b.a.OGc);
      }
    }
    AppMethodBeat.o(273186);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(273160);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/widget/CommonRingtoneLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    ((b)parama).a(b.a.OGd);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/ringtone/widget/CommonRingtoneLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273160);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(273170);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/widget/CommonRingtoneLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = parama.OFX;
    if ((paramView != null) && (paramView.OBU == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((b)parama).a(b.a.OGc);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/ringtone/widget/CommonRingtoneLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273170);
      return;
    }
  }
  
  private static final boolean b(a parama)
  {
    AppMethodBeat.i(273194);
    s.u(parama, "this$0");
    h.ahAA.bk(new a..ExternalSyntheticLambda4(parama));
    AppMethodBeat.o(273194);
    return true;
  }
  
  private static final void c(a parama, View paramView)
  {
    AppMethodBeat.i(273176);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/widget/CommonRingtoneLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = parama.OFX;
    if ((paramView != null) && (paramView.OBU == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((b)parama).a(b.a.OGc);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/ringtone/widget/CommonRingtoneLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273176);
      return;
    }
  }
  
  private final void gPe()
  {
    AppMethodBeat.i(273127);
    MMAnimateView localMMAnimateView = this.OFV;
    if (localMMAnimateView != null) {
      localMMAnimateView.setVisibility(0);
    }
    localMMAnimateView = this.OFV;
    if (localMMAnimateView != null) {
      localMMAnimateView.setImageFilePath(c.BL(true));
    }
    localMMAnimateView = this.OFV;
    if (localMMAnimateView != null) {
      localMMAnimateView.stop();
    }
    localMMAnimateView = this.OFV;
    if (localMMAnimateView != null) {
      localMMAnimateView.start();
    }
    AppMethodBeat.o(273127);
  }
  
  private final void gPf()
  {
    AppMethodBeat.i(273143);
    MMAnimateView localMMAnimateView = this.OFV;
    if (localMMAnimateView != null)
    {
      Object localObject = com.tencent.mm.plugin.ringtone.l.b.OFS;
      localObject = this.rootView.getContext();
      s.s(localObject, "rootView.context");
      localMMAnimateView.setImageDrawable(com.tencent.mm.plugin.ringtone.l.b.m((Context)localObject, b.e.icons_filled_ringing, com.tencent.mm.plugin.ringtone.b.a.FG_0));
    }
    localMMAnimateView = this.OFV;
    if (localMMAnimateView != null) {
      localMMAnimateView.stop();
    }
    localMMAnimateView = this.OFV;
    if (localMMAnimateView != null) {
      localMMAnimateView.clearAnimation();
    }
    AppMethodBeat.o(273143);
  }
  
  public static String iY(long paramLong)
  {
    AppMethodBeat.i(273151);
    Object localObject = am.aixg;
    localObject = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) }, 2));
    s.s(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(273151);
    return localObject;
  }
  
  public final void BT(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(273243);
    Object localObject = this.OFX;
    if ((localObject != null) && (((com.tencent.mm.plugin.ringtone.g.d)localObject).OBU == true)) {}
    while (i == 0)
    {
      BS(paramBoolean);
      localObject = this.OFX;
      if (localObject != null)
      {
        this.mDuration = (((com.tencent.mm.plugin.ringtone.g.d)localObject).mEndTime / 1000L - ((com.tencent.mm.plugin.ringtone.g.d)localObject).mStartTime / 1000L);
        TextView localTextView = this.OFW;
        if (localTextView != null) {
          localTextView.setText((CharSequence)iY(((com.tencent.mm.plugin.ringtone.g.d)localObject).mEndTime / 1000L - ((com.tencent.mm.plugin.ringtone.g.d)localObject).mStartTime / 1000L));
        }
      }
      if (!paramBoolean)
      {
        gPf();
        localObject = this.OFY;
        if (localObject != null) {
          ((MTimerHandler)localObject).stopTimer();
        }
        localObject = this.OFY;
        if (localObject != null) {
          ((MTimerHandler)localObject).quit();
        }
        this.OFY = null;
        AppMethodBeat.o(273243);
        return;
        i = 0;
      }
      else
      {
        gPe();
      }
    }
    AppMethodBeat.o(273243);
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(273251);
    s.u(parama, "status");
    switch (a.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(273251);
      return;
      this.OFZ.t(b.a.OGc);
      AppMethodBeat.o(273251);
      return;
      this.OFZ.t(b.a.OGd);
    }
  }
  
  public final void gPg()
  {
    AppMethodBeat.i(273235);
    if (this.OFY == null)
    {
      this.OFY = new MTimerHandler("ringtone_count_down", new a..ExternalSyntheticLambda3(this), true);
      MTimerHandler localMTimerHandler = this.OFY;
      if (localMTimerHandler != null) {
        localMTimerHandler.startTimer(1000L, 1000L);
      }
    }
    AppMethodBeat.o(273235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.widget.a
 * JD-Core Version:    0.7.0.1
 */