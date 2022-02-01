package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.h;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.plugin.voip.widget.a;
import com.tencent.mm.sdk.platformtools.ak;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/ui/VoipViewFragment;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioView", "Lcom/tencent/mm/plugin/voip/widget/BaseSmallView;", "mIsVideoTalking", "", "videoView", "doAnimator", "", "isSwitchToVideo", "getCurrentView", "getSmallView", "isVideo", "isSwitch", "initAudioView", "initVideoView", "onBadNetTipShow", "show", "onHangupHappened", "onStartRecordFailed", "refreshMiniView", "setVoicePlayDevice", "device", "switchToVideo", "switchToVoice", "updateText", "text", "", "updateTime", "plugin-voip_release"})
public final class VoipViewFragment
  extends FrameLayout
{
  public BaseSmallView CBL;
  public BaseSmallView CBM;
  private boolean CBN;
  
  public VoipViewFragment(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(210336);
    AppMethodBeat.o(210336);
  }
  
  public VoipViewFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(210337);
    AppMethodBeat.o(210337);
  }
  
  public VoipViewFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(210338);
    if (h.eDn())
    {
      paramContext = ak.getContext();
      com.tencent.mm.plugin.voip.c.eys();
    }
    for (paramContext = (BaseSmallView)new a(paramContext, u.tw(false));; paramContext = (BaseSmallView)new com.tencent.mm.plugin.voip.widget.c(paramContext, u.tw(false)))
    {
      this.CBM = paramContext;
      this.CBL = ((BaseSmallView)new f(ak.getContext()));
      paramContext = this.CBL;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      paramContext = this.CBM;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      addView((View)this.CBL);
      addView((View)this.CBM);
      AppMethodBeat.o(210338);
      return;
      paramContext = ak.getContext();
      com.tencent.mm.plugin.voip.c.eys();
    }
  }
  
  private final void tD(boolean paramBoolean)
  {
    AppMethodBeat.i(210331);
    if (paramBoolean)
    {
      this.CBN = true;
      localObject = this.CBL;
      if (localObject != null) {
        ((BaseSmallView)localObject).setVisibility(0);
      }
      localObject = this.CBM;
      if (localObject != null) {
        ((BaseSmallView)localObject).setVisibility(0);
      }
      localObject = this.CBM;
      if (localObject != null) {
        ((BaseSmallView)localObject).setAlpha(0.0F);
      }
      localObject = this.CBL;
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
      localObject = this.CBM;
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
              AppMethodBeat.o(210331);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(210331);
      return;
    }
    this.CBN = false;
    Object localObject = this.CBM;
    if (localObject != null) {
      ((BaseSmallView)localObject).setVisibility(8);
    }
    if (this.CBM != null) {
      removeView((View)this.CBM);
    }
    localObject = this.CBL;
    if (localObject != null) {
      ((BaseSmallView)localObject).setVisibility(0);
    }
    localObject = this.CBL;
    if (localObject != null) {
      ((BaseSmallView)localObject).setAlpha(0.0F);
    }
    localObject = this.CBL;
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
            AppMethodBeat.o(210331);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(210331);
  }
  
  public final void aFc(String paramString)
  {
    AppMethodBeat.i(210335);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null)
    {
      localBaseSmallView.aFc(paramString);
      AppMethodBeat.o(210335);
      return;
    }
    AppMethodBeat.o(210335);
  }
  
  public final void aFd(String paramString)
  {
    AppMethodBeat.i(210334);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null)
    {
      localBaseSmallView.aFd(paramString);
      AppMethodBeat.o(210334);
      return;
    }
    AppMethodBeat.o(210334);
  }
  
  public final BaseSmallView ax(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210332);
    if (paramBoolean2) {
      tD(paramBoolean1);
    }
    this.CBN = paramBoolean1;
    if (paramBoolean1)
    {
      localBaseSmallView = this.CBM;
      if (localBaseSmallView != null) {
        localBaseSmallView.setVisibility(0);
      }
      localBaseSmallView = this.CBM;
      AppMethodBeat.o(210332);
      return localBaseSmallView;
    }
    BaseSmallView localBaseSmallView = this.CBL;
    if (localBaseSmallView != null) {
      localBaseSmallView.setVisibility(0);
    }
    localBaseSmallView = this.CBL;
    AppMethodBeat.o(210332);
    return localBaseSmallView;
  }
  
  final BaseSmallView getCurrentView()
  {
    if (this.CBN) {
      return this.CBM;
    }
    return this.CBL;
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(210333);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null)
    {
      localBaseSmallView.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(210333);
      return;
    }
    AppMethodBeat.o(210333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipViewFragment
 * JD-Core Version:    0.7.0.1
 */