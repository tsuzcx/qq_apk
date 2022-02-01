package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView;", "Lcom/tencent/mm/plugin/voip/widget/BaseSmallView;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mStatusView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniStatusLayout;", "mVideoView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVideoView;", "mVoiceView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView;", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "radius", "", "changeRendererSpeaker", "", "userName", "", "checkIfReceivingVideo", "", "drawAvatar", "drawBitmap", "bm", "Landroid/graphics/Bitmap;", "angle", "", "mirror", "getAvatarIv", "Landroid/widget/ImageView;", "getLastRenderSwitchTick", "", "()Ljava/lang/Long;", "getRendererSpeaker", "getUsername", "initShowMode", "isVideo", "onHangupHappened", "onResumeIconAndTipShow", "refreshLayoutCauseDockChanged", "isDockerLeft", "refreshMiniView", "refreshRenderTick", "setVoicePlayDevice", "device", "showSelfCameraStatus", "show", "showSelfMuteStatus", "showSpeakerAvatar", "switchToVideo", "switchToVoice", "uninit", "updateText", "text", "updateTime", "Companion", "plugin-multitalk_release"})
public final class m
  extends BaseSmallView
  implements f
{
  public static final m.a zTL;
  private HashMap _$_findViewCache;
  private PowerManager.WakeLock hCN;
  private final float radius;
  j zTI;
  i zTJ;
  private h zTK;
  
  static
  {
    AppMethodBeat.i(239840);
    zTL = new m.a((byte)0);
    AppMethodBeat.o(239840);
  }
  
  public m(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(239839);
    this.radius = a.fromDPToPix(MMApplicationContext.getContext(), 12);
    Object localObject = MMApplicationContext.getContext().getSystemService("power");
    if (localObject == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(239839);
      throw paramContext;
    }
    this.hCN = ((PowerManager)localObject).newWakeLock(536870922, "MicroMsg.MultiTalkSmallView");
    localObject = this.hCN;
    if (localObject != null) {
      ((PowerManager.WakeLock)localObject).acquire();
    }
    LayoutInflater.from(paramContext).inflate(2131495733, (ViewGroup)this);
    setClipToOutline(true);
    setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    paramContext = _$_findCachedViewById(2131305070);
    p.g(paramContext, "multitalk_voice");
    paramContext.setClipToOutline(true);
    paramContext = _$_findCachedViewById(2131305070);
    p.g(paramContext, "multitalk_voice");
    paramContext.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    paramContext = _$_findCachedViewById(2131305068);
    p.g(paramContext, "multitalk_video");
    paramContext.setClipToOutline(true);
    paramContext = _$_findCachedViewById(2131305068);
    p.g(paramContext, "multitalk_video");
    paramContext.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    paramContext = _$_findCachedViewById(2131305070);
    p.g(paramContext, "multitalk_voice");
    this.zTI = new j(paramContext);
    paramContext = _$_findCachedViewById(2131305068);
    p.g(paramContext, "multitalk_video");
    this.zTJ = new i(paramContext);
    paramContext = _$_findCachedViewById(2131305043);
    p.g(paramContext, "multitalk_minio_small_status_layout");
    this.zTK = new h(paramContext);
    AppMethodBeat.o(239839);
  }
  
  private View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(239841);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(239841);
    return localView1;
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(239829);
    p.h(paramString, "userName");
    p.h(paramBitmap, "bm");
    Object localObject1 = this.zTJ;
    if (localObject1 != null) {}
    for (localObject1 = ((i)localObject1).zTg; localObject1 != null; localObject1 = null)
    {
      i locali = this.zTJ;
      localObject1 = localObject2;
      if (locali != null) {
        localObject1 = locali.zTg;
      }
      if (!p.j(paramString, localObject1)) {
        break;
      }
      localObject1 = this.zTJ;
      if (localObject1 == null) {
        break;
      }
      ((i)localObject1).b(paramString, paramBitmap, paramInt2, paramInt1);
      AppMethodBeat.o(239829);
      return;
    }
    AppMethodBeat.o(239829);
  }
  
  public final void aGA(String paramString)
  {
    AppMethodBeat.i(239837);
    Object localObject = getLastRenderSwitchTick();
    if (localObject != null) {}
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      Log.printInfoStack("MicroMsg.MultiTalkSmallView", "changeRendererSpeaker %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      localObject = this.zTJ;
      if (localObject == null) {
        break;
      }
      ((i)localObject).aGs(paramString);
      AppMethodBeat.o(239837);
      return;
    }
    AppMethodBeat.o(239837);
  }
  
  public final void aGx(String paramString)
  {
    AppMethodBeat.i(239830);
    super.aGx(paramString);
    Object localObject1 = this.zTI;
    if (localObject1 != null)
    {
      Object localObject2 = ((j)localObject1).timeTv;
      if (localObject2 != null) {
        ((TextView)localObject2).setTextSize(1, 12.0F);
      }
      localObject2 = ((j)localObject1).timeTv;
      if (localObject2 != null) {
        ((TextView)localObject2).setText((CharSequence)paramString);
      }
      localObject2 = ((j)localObject1).lJI;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = ((j)localObject1).context;
      if (localObject1 != null) {}
      for (localObject1 = ((Context)localObject1).getString(2131757549);; localObject1 = null)
      {
        ((View)localObject2).setContentDescription((CharSequence)(String.valueOf(localObject1) + "," + paramString));
        AppMethodBeat.o(239830);
        return;
      }
    }
    AppMethodBeat.o(239830);
  }
  
  public final void aGy(String paramString)
  {
    AppMethodBeat.i(239835);
    super.aGy(paramString);
    Object localObject1 = this.zTI;
    if (localObject1 != null)
    {
      Object localObject2 = ((j)localObject1).timeTv;
      if (localObject2 != null) {
        ((TextView)localObject2).setTextSize(1, 14.0F);
      }
      localObject2 = ((j)localObject1).timeTv;
      if (localObject2 != null) {
        ((TextView)localObject2).setText((CharSequence)paramString);
      }
      localObject2 = ((j)localObject1).lJI;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = ((j)localObject1).context;
      if (localObject1 != null) {}
      for (localObject1 = ((Context)localObject1).getString(2131757549);; localObject1 = null)
      {
        ((View)localObject2).setContentDescription((CharSequence)(String.valueOf(localObject1) + "," + paramString));
        AppMethodBeat.o(239835);
        return;
      }
    }
    AppMethodBeat.o(239835);
  }
  
  public final void aGz(String paramString)
  {
    AppMethodBeat.i(239836);
    p.h(paramString, "userName");
    Object localObject = ac.eom();
    p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((q)localObject).enr().contains(paramString))
    {
      localObject = this.zTJ;
      if (localObject != null)
      {
        ((i)localObject).aGv(paramString);
        AppMethodBeat.o(239836);
        return;
      }
    }
    AppMethodBeat.o(239836);
  }
  
  public final void emz() {}
  
  public final void eoJ()
  {
    AppMethodBeat.i(239826);
    Object localObject = this.zTI;
    if (localObject != null)
    {
      localObject = ((j)localObject).eoH();
      if (localObject != null) {
        break label134;
      }
    }
    label134:
    while (((Integer)localObject).intValue() != 4)
    {
      localObject = this.zTI;
      if (localObject != null)
      {
        ((j)localObject).lJI.setAlpha(1.0F);
        ((j)localObject).lJI.setVisibility(0);
        ((j)localObject).lJI.clearAnimation();
        ((j)localObject).lJI.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new j.a((j)localObject)).start();
      }
      localObject = this.zTJ;
      if (localObject != null) {
        ((i)localObject).H(0);
      }
      localObject = this.zTJ;
      if (localObject == null) {
        break label142;
      }
      ((i)localObject).aGv(getRendererSpeaker());
      AppMethodBeat.o(239826);
      return;
      localObject = null;
      break;
    }
    label142:
    AppMethodBeat.o(239826);
  }
  
  public final boolean eoK()
  {
    AppMethodBeat.i(239831);
    super.eoK();
    Object localObject1 = this.zTI;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((j)localObject1).timeTv;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = ((j)localObject1).zTt;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setBackground(ar.m(((j)localObject1).context, 2131690499, Color.parseColor("#FA5151")));
      }
      localObject2 = ((j)localObject1).zTt;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setIconColor(Color.parseColor("#FA5151"));
      }
      localObject2 = ((j)localObject1).jBS;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(0);
      }
      localObject2 = ((j)localObject1).jBS;
      if (localObject2 != null) {
        ((TextView)localObject2).setTextColor(Color.parseColor("#FA5151"));
      }
      localObject2 = ((j)localObject1).jBS;
      if (localObject2 != null) {
        ((TextView)localObject2).setText(2131767321);
      }
      ((j)localObject1).lJI.clearAnimation();
    }
    localObject1 = this.zTJ;
    if (localObject1 != null)
    {
      localObject2 = ((i)localObject1).zSY;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = ((i)localObject1).zTc;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      localObject2 = ((i)localObject1).zTd;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(ar.m(((i)localObject1).context, 2131690499, Color.parseColor("#FFFFFF")));
      }
      localObject2 = ((i)localObject1).zTe;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(0);
      }
      localObject2 = ((i)localObject1).zTa;
      if (localObject2 != null) {
        ((ImageView)localObject2).clearAnimation();
      }
      localObject1 = ((i)localObject1).zTe;
      if (localObject1 != null) {
        ((TextView)localObject1).setText(2131767321);
      }
    }
    AppMethodBeat.o(239831);
    return true;
  }
  
  public final void eoL()
  {
    AppMethodBeat.i(239833);
    Object localObject1 = this.zTJ;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((i)localObject1).zSY;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(0);
      }
      localObject1 = ((i)localObject1).zTc;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    localObject1 = this.zTI;
    if (localObject1 != null)
    {
      localObject2 = ((j)localObject1).zTt;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setBackground(ar.m(((j)localObject1).context, 2131690498, Color.parseColor("#07C160")));
      }
      localObject2 = ((j)localObject1).zTt;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
      }
      localObject2 = ((j)localObject1).jBS;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = ((j)localObject1).jBS;
      if (localObject2 != null) {
        ((TextView)localObject2).setTextColor(Color.parseColor("#07C160"));
      }
      localObject1 = ((j)localObject1).timeTv;
      if (localObject1 != null)
      {
        ((TextView)localObject1).setVisibility(0);
        AppMethodBeat.o(239833);
        return;
      }
      AppMethodBeat.o(239833);
      return;
    }
    AppMethodBeat.o(239833);
  }
  
  public final void eoM()
  {
    AppMethodBeat.i(239834);
    super.eoM();
    Object localObject1 = this.zTI;
    if (localObject1 != null)
    {
      Object localObject2 = ((j)localObject1).cBH;
      Context localContext;
      Object localObject3;
      if (localObject2 != null)
      {
        localContext = ((j)localObject1).context;
        localObject3 = ((j)localObject1).context;
        if (localObject3 == null) {
          break label126;
        }
        localObject3 = ((Context)localObject3).getResources();
        if (localObject3 == null) {
          break label126;
        }
      }
      label126:
      for (int i = ((Resources)localObject3).getColor(2131100863);; i = -1)
      {
        ((View)localObject2).setBackground(ar.m(localContext, 2131235538, i));
        localObject2 = ((j)localObject1).context;
        if (localObject2 == null) {
          break label138;
        }
        localObject2 = ((Context)localObject2).getResources();
        if (localObject2 == null) {
          break label138;
        }
        i = ((Resources)localObject2).getColor(2131099748);
        localObject1 = ((j)localObject1).timeTv;
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setTextColor(i);
        AppMethodBeat.o(239834);
        return;
      }
      AppMethodBeat.o(239834);
      return;
      label138:
      AppMethodBeat.o(239834);
      return;
    }
    AppMethodBeat.o(239834);
  }
  
  public final ImageView getAvatarIv()
  {
    return null;
  }
  
  public final Long getLastRenderSwitchTick()
  {
    i locali = this.zTJ;
    if (locali != null) {
      return locali.zTi;
    }
    return null;
  }
  
  public final String getRendererSpeaker()
  {
    Object localObject = this.zTJ;
    if (localObject != null)
    {
      String str = ((i)localObject).zTg;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final String getUsername()
  {
    Object localObject = this.zTJ;
    if (localObject != null)
    {
      String str = ((i)localObject).zTg;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final void rS(boolean paramBoolean)
  {
    AppMethodBeat.i(239825);
    if (paramBoolean)
    {
      Object localObject = this.zTI;
      if (localObject != null)
      {
        Integer localInteger = Integer.valueOf(4);
        if (localInteger != null)
        {
          ((j)localObject).lJI.setVisibility(localInteger.intValue());
          ((j)localObject).zTu = localInteger;
        }
      }
      localObject = this.zTJ;
      if (localObject != null)
      {
        ((i)localObject).H(0);
        AppMethodBeat.o(239825);
        return;
      }
    }
    AppMethodBeat.o(239825);
  }
  
  public final void rT(boolean paramBoolean)
  {
    AppMethodBeat.i(239827);
    h localh = this.zTK;
    if (localh != null)
    {
      localh.zSW = paramBoolean;
      localh.aa(localh.zSX, localh.zSW);
      AppMethodBeat.o(239827);
      return;
    }
    AppMethodBeat.o(239827);
  }
  
  public final void rU(boolean paramBoolean)
  {
    AppMethodBeat.i(239828);
    h localh = this.zTK;
    if (localh != null)
    {
      localh.zSX = paramBoolean;
      localh.aa(localh.zSX, localh.zSW);
      AppMethodBeat.o(239828);
      return;
    }
    AppMethodBeat.o(239828);
  }
  
  public final void rV(boolean paramBoolean)
  {
    AppMethodBeat.i(239838);
    Object localObject2 = this.zTI;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((j)localObject2).contentView;
      if ((localObject1 != null) && (((View)localObject1).getLayoutParams() != null))
      {
        localObject1 = ((j)localObject2).contentView;
        if (localObject1 != null) {}
        for (localObject1 = ((View)localObject1).getLayoutParams(); localObject1 == null; localObject1 = null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(239838);
          throw ((Throwable)localObject1);
        }
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        if (!paramBoolean) {
          break label187;
        }
        ((RelativeLayout.LayoutParams)localObject1).setMarginStart(at.fromDPToPix(((j)localObject2).context, 24));
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(at.fromDPToPix(((j)localObject2).context, 8));
        localObject2 = ((j)localObject2).contentView;
        if (localObject2 != null) {
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    localObject2 = this.zTJ;
    if (localObject2 != null)
    {
      localObject1 = ((i)localObject2).contentView;
      if ((localObject1 != null) && (((View)localObject1).getLayoutParams() != null))
      {
        localObject1 = ((i)localObject2).contentView;
        if (localObject1 != null) {}
        for (localObject1 = ((View)localObject1).getLayoutParams();; localObject1 = null)
        {
          if (localObject1 != null) {
            break label221;
          }
          localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(239838);
          throw ((Throwable)localObject1);
          label187:
          ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(at.fromDPToPix(((j)localObject2).context, 24));
          ((RelativeLayout.LayoutParams)localObject1).setMarginStart(at.fromDPToPix(((j)localObject2).context, 8));
          break;
        }
        label221:
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        if (!paramBoolean) {
          break label313;
        }
        ((RelativeLayout.LayoutParams)localObject1).setMarginStart(at.fromDPToPix(((i)localObject2).context, 24));
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(at.fromDPToPix(((i)localObject2).context, 8));
      }
    }
    for (;;)
    {
      localObject2 = ((i)localObject2).contentView;
      if (localObject2 != null) {
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.zTK;
      if (localObject1 == null) {
        break label396;
      }
      localObject2 = ((h)localObject1).lJI.getLayoutParams();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(239838);
      throw ((Throwable)localObject1);
      label313:
      ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(at.fromDPToPix(((i)localObject2).context, 24));
      ((RelativeLayout.LayoutParams)localObject1).setMarginStart(at.fromDPToPix(((i)localObject2).context, 8));
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject2).addRule(20);
    }
    for (;;)
    {
      ((h)localObject1).lJI.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      AppMethodBeat.o(239838);
      return;
      ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
      ((RelativeLayout.LayoutParams)localObject2).addRule(21);
    }
    label396:
    AppMethodBeat.o(239838);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(239832);
    Object localObject1;
    Object localObject2;
    if (this.GUk != paramInt)
    {
      this.GUk = paramInt;
      localObject1 = this.zTJ;
      if (localObject1 != null)
      {
        localObject1 = ((i)localObject1).zSY;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
      }
      localObject1 = this.zTJ;
      if (localObject1 != null)
      {
        localObject2 = ((i)localObject1).zTc;
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
      }
      switch (paramInt)
      {
      default: 
        localObject1 = this.zTI;
        if (localObject1 != null)
        {
          localObject2 = ((j)localObject1).jBS;
          if (localObject2 != null) {
            ((TextView)localObject2).setVisibility(0);
          }
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = ((j)localObject1).timeTv;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(239832);
      return;
      localObject2 = ((i)localObject1).zTd;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(ar.m(((i)localObject1).context, 2131690495, Color.parseColor("#FFFFFF")));
      }
      localObject1 = ((i)localObject1).zTe;
      if (localObject1 == null) {
        p.hyc();
      }
      ((TextView)localObject1).setText(2131767317);
      break;
      localObject2 = ((i)localObject1).zTd;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(ar.m(((i)localObject1).context, 2131690708, Color.parseColor("#FFFFFF")));
      }
      localObject1 = ((i)localObject1).zTe;
      if (localObject1 == null) {
        p.hyc();
      }
      ((TextView)localObject1).setText(2131767320);
      break;
      localObject2 = ((i)localObject1).zTd;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(ar.m(((i)localObject1).context, 2131690544, Color.parseColor("#FFFFFF")));
      }
      localObject1 = ((i)localObject1).zTe;
      if (localObject1 == null) {
        p.hyc();
      }
      ((TextView)localObject1).setText(2131767318);
      break;
      localObject2 = ((i)localObject1).zTd;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(ar.m(((i)localObject1).context, 2131690568, Color.parseColor("#FFFFFF")));
      }
      localObject1 = ((i)localObject1).zTe;
      if (localObject1 == null) {
        p.hyc();
      }
      ((TextView)localObject1).setText(2131767319);
      break;
      localObject2 = ((j)localObject1).zTt;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setBackground(ar.m(((j)localObject1).context, 2131690495, Color.parseColor("#07C160")));
      }
      localObject2 = ((j)localObject1).zTt;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
      }
      localObject2 = ((j)localObject1).jBS;
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText(2131767317);
        continue;
        localObject2 = ((j)localObject1).zTt;
        if (localObject2 != null) {
          ((WeImageView)localObject2).setBackground(ar.m(((j)localObject1).context, 2131690708, Color.parseColor("#07C160")));
        }
        localObject2 = ((j)localObject1).zTt;
        if (localObject2 != null) {
          ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
        }
        localObject2 = ((j)localObject1).jBS;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setText(2131767320);
          continue;
          localObject2 = ((j)localObject1).zTt;
          if (localObject2 != null) {
            ((WeImageView)localObject2).setBackground(ar.m(((j)localObject1).context, 2131690544, Color.parseColor("#07C160")));
          }
          localObject2 = ((j)localObject1).zTt;
          if (localObject2 != null) {
            ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
          }
          localObject2 = ((j)localObject1).jBS;
          if (localObject2 != null)
          {
            ((TextView)localObject2).setText(2131767318);
            continue;
            localObject2 = ((j)localObject1).zTt;
            if (localObject2 != null) {
              ((WeImageView)localObject2).setBackground(ar.m(((j)localObject1).context, 2131690568, Color.parseColor("#07C160")));
            }
            localObject2 = ((j)localObject1).zTt;
            if (localObject2 != null) {
              ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
            }
            localObject2 = ((j)localObject1).jBS;
            if (localObject2 != null) {
              ((TextView)localObject2).setText(2131767319);
            }
          }
        }
      }
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(239824);
    super.uninit();
    Object localObject = this.zTJ;
    if (localObject != null)
    {
      localObject = ((i)localObject).zTa;
      if (localObject != null) {
        ((ImageView)localObject).clearAnimation();
      }
    }
    localObject = this.zTI;
    if (localObject != null) {
      ((j)localObject).lJI.clearAnimation();
    }
    if (this.hCN != null)
    {
      localObject = this.hCN;
      if (localObject == null) {
        p.hyc();
      }
      if (((PowerManager.WakeLock)localObject).isHeld())
      {
        Log.i("MicroMsg.MultiTalkSmallView", "release waklock");
        localObject = this.hCN;
        if (localObject != null)
        {
          ((PowerManager.WakeLock)localObject).release();
          AppMethodBeat.o(239824);
          return;
        }
      }
    }
    AppMethodBeat.o(239824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.m
 * JD-Core Version:    0.7.0.1
 */