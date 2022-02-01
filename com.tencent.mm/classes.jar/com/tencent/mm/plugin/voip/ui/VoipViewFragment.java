package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.plugin.voip.widget.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/ui/VoipViewFragment;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioView", "Lcom/tencent/mm/plugin/voip/widget/BaseSmallView;", "mIsVideoTalking", "", "videoView", "doAnimator", "", "isSwitchToVideo", "getCurrentView", "getSmallView", "isVideo", "isSwitch", "initAudioView", "initVideoView", "onBadNetTipShow", "show", "onHangupHappened", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onStartRecordFailed", "refreshMiniView", "setVoicePlayDevice", "device", "switchToVideo", "switchToVoice", "updateText", "text", "", "updateTime", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VoipViewFragment
  extends FrameLayout
{
  public BaseSmallView UKR;
  public BaseSmallView UKS;
  private boolean UKT;
  
  public VoipViewFragment(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(292454);
    AppMethodBeat.o(292454);
  }
  
  public VoipViewFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(292456);
    AppMethodBeat.o(292456);
  }
  
  public VoipViewFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(292465);
    this.UKS = ((BaseSmallView)new a(MMApplicationContext.getContext()));
    this.UKR = ((BaseSmallView)new l(MMApplicationContext.getContext()));
    paramContext = this.UKR;
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
    paramContext = this.UKS;
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
    addView((View)this.UKR);
    addView((View)this.UKS);
    AppMethodBeat.o(292465);
  }
  
  private final void GI(boolean paramBoolean)
  {
    AppMethodBeat.i(292472);
    if (paramBoolean)
    {
      this.UKT = true;
      localObject = this.UKR;
      if (localObject != null) {
        ((BaseSmallView)localObject).setVisibility(0);
      }
      localObject = this.UKS;
      if (localObject != null) {
        ((BaseSmallView)localObject).setVisibility(0);
      }
      localObject = this.UKS;
      if (localObject != null) {
        ((BaseSmallView)localObject).setAlpha(0.0F);
      }
      localObject = this.UKR;
      if (localObject != null)
      {
        localObject = ((BaseSmallView)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
            if (localObject != null) {
              ((ViewPropertyAnimator)localObject).start();
            }
          }
        }
      }
      localObject = this.UKS;
      if (localObject != null)
      {
        localObject = ((BaseSmallView)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
            if (localObject != null) {
              ((ViewPropertyAnimator)localObject).start();
            }
          }
        }
      }
      AppMethodBeat.o(292472);
      return;
    }
    this.UKT = false;
    Object localObject = this.UKS;
    if (localObject != null) {
      ((BaseSmallView)localObject).setVisibility(8);
    }
    if (this.UKS != null) {
      removeView((View)this.UKS);
    }
    localObject = this.UKR;
    if (localObject != null) {
      ((BaseSmallView)localObject).setVisibility(0);
    }
    localObject = this.UKR;
    if (localObject != null) {
      ((BaseSmallView)localObject).setAlpha(0.0F);
    }
    localObject = this.UKR;
    if (localObject != null)
    {
      localObject = ((BaseSmallView)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
          if (localObject != null) {
            ((ViewPropertyAnimator)localObject).start();
          }
        }
      }
    }
    AppMethodBeat.o(292472);
  }
  
  public final void aNF(String paramString)
  {
    AppMethodBeat.i(292503);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null) {
      localBaseSmallView.aNF(paramString);
    }
    AppMethodBeat.o(292503);
  }
  
  public final BaseSmallView br(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(292481);
    if (paramBoolean2) {
      GI(paramBoolean1);
    }
    this.UKT = paramBoolean1;
    if (paramBoolean1)
    {
      localBaseSmallView = this.UKS;
      if (localBaseSmallView != null) {
        localBaseSmallView.setVisibility(0);
      }
      localBaseSmallView = this.UKS;
      AppMethodBeat.o(292481);
      return localBaseSmallView;
    }
    BaseSmallView localBaseSmallView = this.UKR;
    if (localBaseSmallView != null) {
      localBaseSmallView.setVisibility(0);
    }
    localBaseSmallView = this.UKR;
    AppMethodBeat.o(292481);
    return localBaseSmallView;
  }
  
  final BaseSmallView getCurrentView()
  {
    if (this.UKT) {
      return this.UKS;
    }
    return this.UKR;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(292489);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null) {
      localBaseSmallView.setVoicePlayDevice(paramInt);
    }
    AppMethodBeat.o(292489);
  }
  
  public final void updateText(String paramString)
  {
    AppMethodBeat.i(292496);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null) {
      localBaseSmallView.updateText(paramString);
    }
    AppMethodBeat.o(292496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipViewFragment
 * JD-Core Version:    0.7.0.1
 */