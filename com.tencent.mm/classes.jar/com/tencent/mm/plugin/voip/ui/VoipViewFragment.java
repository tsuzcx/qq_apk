package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.plugin.voip.widget.a;
import com.tencent.mm.plugin.voip.widget.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/ui/VoipViewFragment;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioView", "Lcom/tencent/mm/plugin/voip/widget/BaseSmallView;", "mIsVideoTalking", "", "videoView", "doAnimator", "", "isSwitchToVideo", "getCurrentView", "getSmallView", "isVideo", "isSwitch", "initAudioView", "initVideoView", "onBadNetTipShow", "show", "onHangupHappened", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onStartRecordFailed", "refreshMiniView", "setVoicePlayDevice", "device", "switchToVideo", "switchToVoice", "updateText", "text", "", "updateTime", "plugin-voip_release"})
public final class VoipViewFragment
  extends FrameLayout
{
  public BaseSmallView HfB;
  public BaseSmallView HfC;
  private boolean HfD;
  
  public VoipViewFragment(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(235987);
    AppMethodBeat.o(235987);
  }
  
  public VoipViewFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(235988);
    AppMethodBeat.o(235988);
  }
  
  public VoipViewFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235989);
    if (g.fKe()) {}
    for (paramContext = (BaseSmallView)new a(MMApplicationContext.getContext());; paramContext = (BaseSmallView)new c(MMApplicationContext.getContext()))
    {
      this.HfC = paramContext;
      this.HfB = ((BaseSmallView)new f(MMApplicationContext.getContext()));
      paramContext = this.HfB;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      paramContext = this.HfC;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      addView((View)this.HfB);
      addView((View)this.HfC);
      AppMethodBeat.o(235989);
      return;
    }
  }
  
  private final void xn(boolean paramBoolean)
  {
    AppMethodBeat.i(235982);
    if (paramBoolean)
    {
      this.HfD = true;
      localObject = this.HfB;
      if (localObject != null) {
        ((BaseSmallView)localObject).setVisibility(0);
      }
      localObject = this.HfC;
      if (localObject != null) {
        ((BaseSmallView)localObject).setVisibility(0);
      }
      localObject = this.HfC;
      if (localObject != null) {
        ((BaseSmallView)localObject).setAlpha(0.0F);
      }
      localObject = this.HfB;
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
      localObject = this.HfC;
      if (localObject != null)
      {
        localObject = ((BaseSmallView)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
            if (localObject != null)
            {
              ((ViewPropertyAnimator)localObject).start();
              AppMethodBeat.o(235982);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(235982);
      return;
    }
    this.HfD = false;
    Object localObject = this.HfC;
    if (localObject != null) {
      ((BaseSmallView)localObject).setVisibility(8);
    }
    if (this.HfC != null) {
      removeView((View)this.HfC);
    }
    localObject = this.HfB;
    if (localObject != null) {
      ((BaseSmallView)localObject).setVisibility(0);
    }
    localObject = this.HfB;
    if (localObject != null) {
      ((BaseSmallView)localObject).setAlpha(0.0F);
    }
    localObject = this.HfB;
    if (localObject != null)
    {
      localObject = ((BaseSmallView)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
          if (localObject != null)
          {
            ((ViewPropertyAnimator)localObject).start();
            AppMethodBeat.o(235982);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(235982);
  }
  
  public final void aGx(String paramString)
  {
    AppMethodBeat.i(235985);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null)
    {
      localBaseSmallView.aGx(paramString);
      AppMethodBeat.o(235985);
      return;
    }
    AppMethodBeat.o(235985);
  }
  
  public final void aGy(String paramString)
  {
    AppMethodBeat.i(235986);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null)
    {
      localBaseSmallView.aGy(paramString);
      AppMethodBeat.o(235986);
      return;
    }
    AppMethodBeat.o(235986);
  }
  
  public final BaseSmallView aJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(235983);
    if (paramBoolean2) {
      xn(paramBoolean1);
    }
    this.HfD = paramBoolean1;
    if (paramBoolean1)
    {
      localBaseSmallView = this.HfC;
      if (localBaseSmallView != null) {
        localBaseSmallView.setVisibility(0);
      }
      localBaseSmallView = this.HfC;
      AppMethodBeat.o(235983);
      return localBaseSmallView;
    }
    BaseSmallView localBaseSmallView = this.HfB;
    if (localBaseSmallView != null) {
      localBaseSmallView.setVisibility(0);
    }
    localBaseSmallView = this.HfB;
    AppMethodBeat.o(235983);
    return localBaseSmallView;
  }
  
  final BaseSmallView getCurrentView()
  {
    if (this.HfD) {
      return this.HfC;
    }
    return this.HfB;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(235984);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null)
    {
      localBaseSmallView.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(235984);
      return;
    }
    AppMethodBeat.o(235984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipViewFragment
 * JD-Core Version:    0.7.0.1
 */