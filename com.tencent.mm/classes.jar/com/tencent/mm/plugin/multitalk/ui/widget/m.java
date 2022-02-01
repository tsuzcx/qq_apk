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
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView;", "Lcom/tencent/mm/plugin/voip/widget/BaseSmallView;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mStatusView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniStatusLayout;", "mVideoView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVideoView;", "mVoiceView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView;", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "radius", "", "changeRendererSpeaker", "", "userName", "", "checkIfReceivingVideo", "", "drawAvatar", "drawBitmap", "bm", "Landroid/graphics/Bitmap;", "angle", "", "mirror", "getAvatarIv", "Landroid/widget/ImageView;", "getLastRenderSwitchTick", "", "()Ljava/lang/Long;", "getRendererSpeaker", "getUsername", "initShowMode", "isVideo", "onHangupHappened", "onResumeIconAndTipShow", "refreshLayoutCauseDockChanged", "isDockerLeft", "refreshMiniView", "refreshRenderTick", "setVoicePlayDevice", "device", "showSelfCameraStatus", "show", "showSelfMuteStatus", "showSpeakerAvatar", "switchToVideo", "switchToVoice", "uninit", "updateText", "text", "updateTime", "Companion", "plugin-multitalk_release"})
public final class m
  extends BaseSmallView
  implements f
{
  public static final m.a Fzn;
  j Fzk;
  i Fzl;
  private h Fzm;
  private HashMap _$_findViewCache;
  private PowerManager.WakeLock kqO;
  private final float radius;
  
  static
  {
    AppMethodBeat.i(206399);
    Fzn = new m.a((byte)0);
    AppMethodBeat.o(206399);
  }
  
  public m(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(206398);
    this.radius = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 12);
    Object localObject = MMApplicationContext.getContext().getSystemService("power");
    if (localObject == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(206398);
      throw paramContext;
    }
    this.kqO = ((PowerManager)localObject).newWakeLock(536870922, "MicroMsg.MultiTalkSmallView");
    localObject = this.kqO;
    if (localObject != null)
    {
      com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView", "<init>", "(Landroid/content/Context;)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      ((PowerManager.WakeLock)localObject).acquire();
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView", "<init>", "(Landroid/content/Context;)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    }
    LayoutInflater.from(paramContext).inflate(a.f.multitalk_mini_widget_view, (ViewGroup)this);
    setClipToOutline(true);
    setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    paramContext = _$_findCachedViewById(a.e.multitalk_voice);
    p.j(paramContext, "multitalk_voice");
    paramContext.setClipToOutline(true);
    paramContext = _$_findCachedViewById(a.e.multitalk_voice);
    p.j(paramContext, "multitalk_voice");
    paramContext.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    paramContext = _$_findCachedViewById(a.e.multitalk_video);
    p.j(paramContext, "multitalk_video");
    paramContext.setClipToOutline(true);
    paramContext = _$_findCachedViewById(a.e.multitalk_video);
    p.j(paramContext, "multitalk_video");
    paramContext.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    paramContext = _$_findCachedViewById(a.e.multitalk_voice);
    p.j(paramContext, "multitalk_voice");
    this.Fzk = new j(paramContext);
    paramContext = _$_findCachedViewById(a.e.multitalk_video);
    p.j(paramContext, "multitalk_video");
    this.Fzl = new i(paramContext);
    paramContext = _$_findCachedViewById(a.e.multitalk_minio_small_status_layout);
    p.j(paramContext, "multitalk_minio_small_status_layout");
    this.Fzm = new h(paramContext);
    AppMethodBeat.o(206398);
  }
  
  private View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(206400);
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
    AppMethodBeat.o(206400);
    return localView1;
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(206383);
    p.k(paramString, "userName");
    p.k(paramBitmap, "bm");
    Object localObject1 = this.Fzl;
    if (localObject1 != null) {}
    for (localObject1 = ((i)localObject1).FyI; localObject1 != null; localObject1 = null)
    {
      i locali = this.Fzl;
      localObject1 = localObject2;
      if (locali != null) {
        localObject1 = locali.FyI;
      }
      if (!p.h(paramString, localObject1)) {
        break;
      }
      localObject1 = this.Fzl;
      if (localObject1 == null) {
        break;
      }
      ((i)localObject1).b(paramString, paramBitmap, paramInt2, paramInt1);
      AppMethodBeat.o(206383);
      return;
    }
    AppMethodBeat.o(206383);
  }
  
  public final void aQM(String paramString)
  {
    AppMethodBeat.i(206384);
    super.aQM(paramString);
    Object localObject1 = this.Fzk;
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
      localObject2 = ((j)localObject1).oFW;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = ((j)localObject1).context;
      if (localObject1 != null) {}
      for (localObject1 = ((Context)localObject1).getString(b.g.chatting_voip_voice);; localObject1 = null)
      {
        ((View)localObject2).setContentDescription((CharSequence)(String.valueOf(localObject1) + "," + paramString));
        AppMethodBeat.o(206384);
        return;
      }
    }
    AppMethodBeat.o(206384);
  }
  
  public final void aQN(String paramString)
  {
    AppMethodBeat.i(206390);
    super.aQN(paramString);
    Object localObject1 = this.Fzk;
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
      localObject2 = ((j)localObject1).oFW;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = ((j)localObject1).context;
      if (localObject1 != null) {}
      for (localObject1 = ((Context)localObject1).getString(b.g.chatting_voip_voice);; localObject1 = null)
      {
        ((View)localObject2).setContentDescription((CharSequence)(String.valueOf(localObject1) + "," + paramString));
        AppMethodBeat.o(206390);
        return;
      }
    }
    AppMethodBeat.o(206390);
  }
  
  public final void aQO(String paramString)
  {
    AppMethodBeat.i(206392);
    p.k(paramString, "userName");
    Object localObject = ad.eYc();
    p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((q)localObject).eXf().contains(paramString))
    {
      localObject = this.Fzl;
      if (localObject != null)
      {
        ((i)localObject).aQJ(paramString);
        AppMethodBeat.o(206392);
        return;
      }
    }
    AppMethodBeat.o(206392);
  }
  
  public final void aQP(String paramString)
  {
    AppMethodBeat.i(206394);
    Object localObject = getLastRenderSwitchTick();
    if (localObject != null) {}
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      Log.printInfoStack("MicroMsg.MultiTalkSmallView", "changeRendererSpeaker %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      localObject = this.Fzl;
      if (localObject == null) {
        break;
      }
      ((i)localObject).aQG(paramString);
      AppMethodBeat.o(206394);
      return;
    }
    AppMethodBeat.o(206394);
  }
  
  public final void dDz()
  {
    AppMethodBeat.i(206378);
    Object localObject = this.Fzk;
    if (localObject != null)
    {
      localObject = ((j)localObject).eYy();
      if (localObject != null) {
        break label134;
      }
    }
    label134:
    while (((Integer)localObject).intValue() != 4)
    {
      localObject = this.Fzk;
      if (localObject != null)
      {
        ((j)localObject).oFW.setAlpha(1.0F);
        ((j)localObject).oFW.setVisibility(0);
        ((j)localObject).oFW.clearAnimation();
        ((j)localObject).oFW.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new j.a((j)localObject)).start();
      }
      localObject = this.Fzl;
      if (localObject != null) {
        ((i)localObject).XH(0);
      }
      localObject = this.Fzl;
      if (localObject == null) {
        break label142;
      }
      ((i)localObject).aQJ(getRendererSpeaker());
      AppMethodBeat.o(206378);
      return;
      localObject = null;
      break;
    }
    label142:
    AppMethodBeat.o(206378);
  }
  
  public final void eWn() {}
  
  public final boolean eYB()
  {
    AppMethodBeat.i(206385);
    super.eYB();
    Object localObject1 = this.Fzk;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((j)localObject1).timeTv;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = ((j)localObject1).FyV;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setBackground(au.o(((j)localObject1).context, a.g.icons_filled_call_end, Color.parseColor("#FA5151")));
      }
      localObject2 = ((j)localObject1).FyV;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setIconColor(Color.parseColor("#FA5151"));
      }
      localObject2 = ((j)localObject1).mrN;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(0);
      }
      localObject2 = ((j)localObject1).mrN;
      if (localObject2 != null) {
        ((TextView)localObject2).setTextColor(Color.parseColor("#FA5151"));
      }
      localObject2 = ((j)localObject1).mrN;
      if (localObject2 != null) {
        ((TextView)localObject2).setText(a.h.voip_miniwindow_end_wording);
      }
      ((j)localObject1).oFW.clearAnimation();
    }
    localObject1 = this.Fzl;
    if (localObject1 != null)
    {
      localObject2 = ((i)localObject1).FyA;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = ((i)localObject1).FyE;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      localObject2 = ((i)localObject1).FyF;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(au.o(((i)localObject1).context, a.g.icons_filled_call_end, Color.parseColor("#FFFFFF")));
      }
      localObject2 = ((i)localObject1).FyG;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(0);
      }
      localObject2 = ((i)localObject1).FyC;
      if (localObject2 != null) {
        ((ImageView)localObject2).clearAnimation();
      }
      localObject1 = ((i)localObject1).FyG;
      if (localObject1 != null) {
        ((TextView)localObject1).setText(a.h.voip_miniwindow_end_wording);
      }
    }
    AppMethodBeat.o(206385);
    return true;
  }
  
  public final void eYC()
  {
    AppMethodBeat.i(206387);
    Object localObject1 = this.Fzl;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((i)localObject1).FyA;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(0);
      }
      localObject1 = ((i)localObject1).FyE;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    localObject1 = this.Fzk;
    if (localObject1 != null)
    {
      localObject2 = ((j)localObject1).FyV;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setBackground(au.o(((j)localObject1).context, a.g.icons_filled_call, Color.parseColor("#07C160")));
      }
      localObject2 = ((j)localObject1).FyV;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
      }
      localObject2 = ((j)localObject1).mrN;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = ((j)localObject1).mrN;
      if (localObject2 != null) {
        ((TextView)localObject2).setTextColor(Color.parseColor("#07C160"));
      }
      localObject1 = ((j)localObject1).timeTv;
      if (localObject1 != null)
      {
        ((TextView)localObject1).setVisibility(0);
        AppMethodBeat.o(206387);
        return;
      }
      AppMethodBeat.o(206387);
      return;
    }
    AppMethodBeat.o(206387);
  }
  
  public final void eYD()
  {
    AppMethodBeat.i(206388);
    super.eYD();
    Object localObject1 = this.Fzk;
    if (localObject1 != null)
    {
      Object localObject2 = ((j)localObject1).cCj;
      Context localContext;
      int j;
      Object localObject3;
      if (localObject2 != null)
      {
        localContext = ((j)localObject1).context;
        j = a.d.voip_mini_voice_rectangle;
        localObject3 = ((j)localObject1).context;
        if (localObject3 == null) {
          break label137;
        }
        localObject3 = ((Context)localObject3).getResources();
        if (localObject3 == null) {
          break label137;
        }
      }
      label137:
      for (int i = ((Resources)localObject3).getColor(a.b.multitalk_mini_view_color);; i = -1)
      {
        ((View)localObject2).setBackground(au.o(localContext, j, i));
        localObject2 = ((j)localObject1).context;
        if (localObject2 == null) {
          break label149;
        }
        localObject2 = ((Context)localObject2).getResources();
        if (localObject2 == null) {
          break label149;
        }
        i = ((Resources)localObject2).getColor(a.b.FG_1);
        localObject1 = ((j)localObject1).timeTv;
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setTextColor(i);
        AppMethodBeat.o(206388);
        return;
      }
      AppMethodBeat.o(206388);
      return;
      label149:
      AppMethodBeat.o(206388);
      return;
    }
    AppMethodBeat.o(206388);
  }
  
  public final ImageView getAvatarIv()
  {
    return null;
  }
  
  public final Long getLastRenderSwitchTick()
  {
    i locali = this.Fzl;
    if (locali != null) {
      return locali.FyK;
    }
    return null;
  }
  
  public final String getRendererSpeaker()
  {
    Object localObject = this.Fzl;
    if (localObject != null)
    {
      String str = ((i)localObject).FyI;
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
    Object localObject = this.Fzl;
    if (localObject != null)
    {
      String str = ((i)localObject).FyI;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(206386);
    Object localObject1;
    Object localObject2;
    if (this.NKw != paramInt)
    {
      this.NKw = paramInt;
      localObject1 = this.Fzl;
      if (localObject1 != null)
      {
        localObject1 = ((i)localObject1).FyA;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
      }
      localObject1 = this.Fzl;
      if (localObject1 != null)
      {
        localObject2 = ((i)localObject1).FyE;
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
      }
      switch (paramInt)
      {
      default: 
        localObject1 = this.Fzk;
        if (localObject1 != null)
        {
          localObject2 = ((j)localObject1).mrN;
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
      AppMethodBeat.o(206386);
      return;
      localObject2 = ((i)localObject1).FyF;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(au.o(((i)localObject1).context, b.f.icons_filled_bluetooth, Color.parseColor("#FFFFFF")));
      }
      localObject1 = ((i)localObject1).FyG;
      if (localObject1 == null) {
        p.iCn();
      }
      ((TextView)localObject1).setText(b.g.voip_mini_bluetooth);
      break;
      localObject2 = ((i)localObject1).FyF;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(au.o(((i)localObject1).context, b.f.icons_filled_volume_up, Color.parseColor("#FFFFFF")));
      }
      localObject1 = ((i)localObject1).FyG;
      if (localObject1 == null) {
        p.iCn();
      }
      ((TextView)localObject1).setText(b.g.voip_mini_mike);
      break;
      localObject2 = ((i)localObject1).FyF;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(au.o(((i)localObject1).context, b.f.icons_filled_ear, Color.parseColor("#FFFFFF")));
      }
      localObject1 = ((i)localObject1).FyG;
      if (localObject1 == null) {
        p.iCn();
      }
      ((TextView)localObject1).setText(b.g.voip_mini_earpiece);
      break;
      localObject2 = ((i)localObject1).FyF;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(au.o(((i)localObject1).context, b.f.icons_filled_headset, Color.parseColor("#FFFFFF")));
      }
      localObject1 = ((i)localObject1).FyG;
      if (localObject1 == null) {
        p.iCn();
      }
      ((TextView)localObject1).setText(b.g.voip_mini_headset);
      break;
      localObject2 = ((j)localObject1).FyV;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setBackground(au.o(((j)localObject1).context, a.g.icons_filled_bluetooth, Color.parseColor("#07C160")));
      }
      localObject2 = ((j)localObject1).FyV;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
      }
      localObject2 = ((j)localObject1).mrN;
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText(a.h.voip_mini_bluetooth);
        continue;
        localObject2 = ((j)localObject1).FyV;
        if (localObject2 != null) {
          ((WeImageView)localObject2).setBackground(au.o(((j)localObject1).context, a.g.icons_filled_volume_up, Color.parseColor("#07C160")));
        }
        localObject2 = ((j)localObject1).FyV;
        if (localObject2 != null) {
          ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
        }
        localObject2 = ((j)localObject1).mrN;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setText(a.h.voip_mini_mike);
          continue;
          localObject2 = ((j)localObject1).FyV;
          if (localObject2 != null) {
            ((WeImageView)localObject2).setBackground(au.o(((j)localObject1).context, a.g.icons_filled_ear, Color.parseColor("#07C160")));
          }
          localObject2 = ((j)localObject1).FyV;
          if (localObject2 != null) {
            ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
          }
          localObject2 = ((j)localObject1).mrN;
          if (localObject2 != null)
          {
            ((TextView)localObject2).setText(a.h.voip_mini_earpiece);
            continue;
            localObject2 = ((j)localObject1).FyV;
            if (localObject2 != null) {
              ((WeImageView)localObject2).setBackground(au.o(((j)localObject1).context, a.g.icons_filled_headset, Color.parseColor("#07C160")));
            }
            localObject2 = ((j)localObject1).FyV;
            if (localObject2 != null) {
              ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
            }
            localObject2 = ((j)localObject1).mrN;
            if (localObject2 != null) {
              ((TextView)localObject2).setText(a.h.voip_mini_headset);
            }
          }
        }
      }
    }
  }
  
  public final void uV(boolean paramBoolean)
  {
    AppMethodBeat.i(206374);
    if (paramBoolean)
    {
      Object localObject = this.Fzk;
      if (localObject != null)
      {
        Integer localInteger = Integer.valueOf(4);
        if (localInteger != null)
        {
          ((j)localObject).oFW.setVisibility(localInteger.intValue());
          ((j)localObject).FyW = localInteger;
        }
      }
      localObject = this.Fzl;
      if (localObject != null)
      {
        ((i)localObject).XH(0);
        AppMethodBeat.o(206374);
        return;
      }
    }
    AppMethodBeat.o(206374);
  }
  
  public final void uW(boolean paramBoolean)
  {
    AppMethodBeat.i(206381);
    h localh = this.Fzm;
    if (localh != null)
    {
      localh.Fyy = paramBoolean;
      localh.ak(localh.Fyz, localh.Fyy);
      AppMethodBeat.o(206381);
      return;
    }
    AppMethodBeat.o(206381);
  }
  
  public final void uX(boolean paramBoolean)
  {
    AppMethodBeat.i(206382);
    h localh = this.Fzm;
    if (localh != null)
    {
      localh.Fyz = paramBoolean;
      localh.ak(localh.Fyz, localh.Fyy);
      AppMethodBeat.o(206382);
      return;
    }
    AppMethodBeat.o(206382);
  }
  
  public final void uY(boolean paramBoolean)
  {
    AppMethodBeat.i(206396);
    Object localObject2 = this.Fzk;
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
          AppMethodBeat.o(206396);
          throw ((Throwable)localObject1);
        }
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        if (!paramBoolean) {
          break label187;
        }
        ((RelativeLayout.LayoutParams)localObject1).setMarginStart(aw.fromDPToPix(((j)localObject2).context, 24));
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(aw.fromDPToPix(((j)localObject2).context, 8));
        localObject2 = ((j)localObject2).contentView;
        if (localObject2 != null) {
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    localObject2 = this.Fzl;
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
          AppMethodBeat.o(206396);
          throw ((Throwable)localObject1);
          label187:
          ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(aw.fromDPToPix(((j)localObject2).context, 24));
          ((RelativeLayout.LayoutParams)localObject1).setMarginStart(aw.fromDPToPix(((j)localObject2).context, 8));
          break;
        }
        label221:
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        if (!paramBoolean) {
          break label313;
        }
        ((RelativeLayout.LayoutParams)localObject1).setMarginStart(aw.fromDPToPix(((i)localObject2).context, 24));
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(aw.fromDPToPix(((i)localObject2).context, 8));
      }
    }
    for (;;)
    {
      localObject2 = ((i)localObject2).contentView;
      if (localObject2 != null) {
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.Fzm;
      if (localObject1 == null) {
        break label396;
      }
      localObject2 = ((h)localObject1).oFW.getLayoutParams();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(206396);
      throw ((Throwable)localObject1);
      label313:
      ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(aw.fromDPToPix(((i)localObject2).context, 24));
      ((RelativeLayout.LayoutParams)localObject1).setMarginStart(aw.fromDPToPix(((i)localObject2).context, 8));
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject2).addRule(20);
    }
    for (;;)
    {
      ((h)localObject1).oFW.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      AppMethodBeat.o(206396);
      return;
      ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
      ((RelativeLayout.LayoutParams)localObject2).addRule(21);
    }
    label396:
    AppMethodBeat.o(206396);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(206373);
    super.uninit();
    Object localObject = this.Fzl;
    if (localObject != null)
    {
      localObject = ((i)localObject).FyC;
      if (localObject != null) {
        ((ImageView)localObject).clearAnimation();
      }
    }
    localObject = this.Fzk;
    if (localObject != null) {
      ((j)localObject).oFW.clearAnimation();
    }
    if (this.kqO != null)
    {
      localObject = this.kqO;
      if (localObject == null) {
        p.iCn();
      }
      if (((PowerManager.WakeLock)localObject).isHeld())
      {
        Log.i("MicroMsg.MultiTalkSmallView", "release waklock");
        localObject = this.kqO;
        if (localObject != null)
        {
          com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView", "uninit", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          ((PowerManager.WakeLock)localObject).release();
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView", "uninit", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          AppMethodBeat.o(206373);
          return;
        }
      }
    }
    AppMethodBeat.o(206373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.m
 * JD-Core Version:    0.7.0.1
 */