package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.c.g;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.plugin.voip.widget.a;
import com.tencent.mm.plugin.voip.widget.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/ui/VoipViewFragment;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioView", "Lcom/tencent/mm/plugin/voip/widget/BaseSmallView;", "mIsVideoTalking", "", "videoView", "doAnimator", "", "isSwitchToVideo", "getCurrentView", "getSmallView", "isVideo", "isSwitch", "initAudioView", "initVideoView", "onBadNetTipShow", "show", "onHangupHappened", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onStartRecordFailed", "refreshMiniView", "setVoicePlayDevice", "device", "switchToVideo", "switchToVoice", "updateText", "text", "", "updateTime", "plugin-voip_release"})
public final class VoipViewFragment
  extends FrameLayout
{
  public BaseSmallView NWr;
  public BaseSmallView NWs;
  private boolean NWt;
  
  public VoipViewFragment(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(234787);
    AppMethodBeat.o(234787);
  }
  
  public VoipViewFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(234788);
    AppMethodBeat.o(234788);
  }
  
  public VoipViewFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(234790);
    if (g.gCD()) {}
    for (paramContext = (BaseSmallView)new a(MMApplicationContext.getContext());; paramContext = (BaseSmallView)new c(MMApplicationContext.getContext()))
    {
      this.NWs = paramContext;
      this.NWr = ((BaseSmallView)new f(MMApplicationContext.getContext()));
      paramContext = this.NWr;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      paramContext = this.NWs;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      addView((View)this.NWr);
      addView((View)this.NWs);
      AppMethodBeat.o(234790);
      return;
    }
  }
  
  private final void Bf(boolean paramBoolean)
  {
    AppMethodBeat.i(234781);
    if (paramBoolean)
    {
      this.NWt = true;
      localObject = this.NWr;
      if (localObject != null) {
        ((BaseSmallView)localObject).setVisibility(0);
      }
      localObject = this.NWs;
      if (localObject != null) {
        ((BaseSmallView)localObject).setVisibility(0);
      }
      localObject = this.NWs;
      if (localObject != null) {
        ((BaseSmallView)localObject).setAlpha(0.0F);
      }
      localObject = this.NWr;
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
      localObject = this.NWs;
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
              AppMethodBeat.o(234781);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(234781);
      return;
    }
    this.NWt = false;
    Object localObject = this.NWs;
    if (localObject != null) {
      ((BaseSmallView)localObject).setVisibility(8);
    }
    if (this.NWs != null) {
      removeView((View)this.NWs);
    }
    localObject = this.NWr;
    if (localObject != null) {
      ((BaseSmallView)localObject).setVisibility(0);
    }
    localObject = this.NWr;
    if (localObject != null) {
      ((BaseSmallView)localObject).setAlpha(0.0F);
    }
    localObject = this.NWr;
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
            AppMethodBeat.o(234781);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(234781);
  }
  
  public final void aQM(String paramString)
  {
    AppMethodBeat.i(234785);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null)
    {
      localBaseSmallView.aQM(paramString);
      AppMethodBeat.o(234785);
      return;
    }
    AppMethodBeat.o(234785);
  }
  
  public final void aQN(String paramString)
  {
    AppMethodBeat.i(234786);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null)
    {
      localBaseSmallView.aQN(paramString);
      AppMethodBeat.o(234786);
      return;
    }
    AppMethodBeat.o(234786);
  }
  
  public final BaseSmallView aV(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(234783);
    if (paramBoolean2) {
      Bf(paramBoolean1);
    }
    this.NWt = paramBoolean1;
    if (paramBoolean1)
    {
      localBaseSmallView = this.NWs;
      if (localBaseSmallView != null) {
        localBaseSmallView.setVisibility(0);
      }
      localBaseSmallView = this.NWs;
      AppMethodBeat.o(234783);
      return localBaseSmallView;
    }
    BaseSmallView localBaseSmallView = this.NWr;
    if (localBaseSmallView != null) {
      localBaseSmallView.setVisibility(0);
    }
    localBaseSmallView = this.NWr;
    AppMethodBeat.o(234783);
    return localBaseSmallView;
  }
  
  final BaseSmallView getCurrentView()
  {
    if (this.NWt) {
      return this.NWs;
    }
    return this.NWr;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(234784);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null)
    {
      localBaseSmallView.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(234784);
      return;
    }
    AppMethodBeat.o(234784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipViewFragment
 * JD-Core Version:    0.7.0.1
 */