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
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/ui/VoipViewFragment;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioView", "Lcom/tencent/mm/plugin/voip/widget/BaseSmallView;", "mIsVideoTalking", "", "videoView", "doAnimator", "", "isSwitchToVideo", "getCurrentView", "getSmallView", "isVideo", "isSwitch", "initAudioView", "initVideoView", "onBadNetTipShow", "show", "onHangupHappened", "onStartRecordFailed", "refreshMiniView", "setVoicePlayDevice", "device", "switchToVideo", "switchToVoice", "updateText", "text", "", "updateTime", "plugin-voip_release"})
public final class VoipViewFragment
  extends FrameLayout
{
  public BaseSmallView Ckh;
  public BaseSmallView Cki;
  private boolean Ckj;
  
  public VoipViewFragment(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(215915);
    AppMethodBeat.o(215915);
  }
  
  public VoipViewFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(215916);
    AppMethodBeat.o(215916);
  }
  
  public VoipViewFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(215917);
    if (h.ezF())
    {
      paramContext = aj.getContext();
      com.tencent.mm.plugin.voip.c.euM();
    }
    for (paramContext = (BaseSmallView)new a(paramContext, u.tp(false));; paramContext = (BaseSmallView)new com.tencent.mm.plugin.voip.widget.c(paramContext, u.tp(false)))
    {
      this.Cki = paramContext;
      this.Ckh = ((BaseSmallView)new f(aj.getContext()));
      paramContext = this.Ckh;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      paramContext = this.Cki;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      addView((View)this.Ckh);
      addView((View)this.Cki);
      AppMethodBeat.o(215917);
      return;
      paramContext = aj.getContext();
      com.tencent.mm.plugin.voip.c.euM();
    }
  }
  
  private final void tw(boolean paramBoolean)
  {
    AppMethodBeat.i(215910);
    if (paramBoolean)
    {
      this.Ckj = true;
      localObject = this.Ckh;
      if (localObject != null) {
        ((BaseSmallView)localObject).setVisibility(0);
      }
      localObject = this.Cki;
      if (localObject != null) {
        ((BaseSmallView)localObject).setVisibility(0);
      }
      localObject = this.Cki;
      if (localObject != null) {
        ((BaseSmallView)localObject).setAlpha(0.0F);
      }
      localObject = this.Ckh;
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
      localObject = this.Cki;
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
              AppMethodBeat.o(215910);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(215910);
      return;
    }
    this.Ckj = false;
    Object localObject = this.Cki;
    if (localObject != null) {
      ((BaseSmallView)localObject).setVisibility(8);
    }
    if (this.Cki != null) {
      removeView((View)this.Cki);
    }
    localObject = this.Ckh;
    if (localObject != null) {
      ((BaseSmallView)localObject).setVisibility(0);
    }
    localObject = this.Ckh;
    if (localObject != null) {
      ((BaseSmallView)localObject).setAlpha(0.0F);
    }
    localObject = this.Ckh;
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
            AppMethodBeat.o(215910);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(215910);
  }
  
  public final void aDJ(String paramString)
  {
    AppMethodBeat.i(215914);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null)
    {
      localBaseSmallView.aDJ(paramString);
      AppMethodBeat.o(215914);
      return;
    }
    AppMethodBeat.o(215914);
  }
  
  public final void aDK(String paramString)
  {
    AppMethodBeat.i(215913);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null)
    {
      localBaseSmallView.aDK(paramString);
      AppMethodBeat.o(215913);
      return;
    }
    AppMethodBeat.o(215913);
  }
  
  public final BaseSmallView ay(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215911);
    if (paramBoolean2) {
      tw(paramBoolean1);
    }
    this.Ckj = paramBoolean1;
    if (paramBoolean1)
    {
      localBaseSmallView = this.Cki;
      if (localBaseSmallView != null) {
        localBaseSmallView.setVisibility(0);
      }
      localBaseSmallView = this.Cki;
      AppMethodBeat.o(215911);
      return localBaseSmallView;
    }
    BaseSmallView localBaseSmallView = this.Ckh;
    if (localBaseSmallView != null) {
      localBaseSmallView.setVisibility(0);
    }
    localBaseSmallView = this.Ckh;
    AppMethodBeat.o(215911);
    return localBaseSmallView;
  }
  
  final BaseSmallView getCurrentView()
  {
    if (this.Ckj) {
      return this.Cki;
    }
    return this.Ckh;
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(215912);
    BaseSmallView localBaseSmallView = getCurrentView();
    if (localBaseSmallView != null)
    {
      localBaseSmallView.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(215912);
      return;
    }
    AppMethodBeat.o(215912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipViewFragment
 * JD-Core Version:    0.7.0.1
 */