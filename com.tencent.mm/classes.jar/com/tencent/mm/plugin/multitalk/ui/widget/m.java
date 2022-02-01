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
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.ui.k;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView;", "Lcom/tencent/mm/plugin/voip/widget/BaseSmallView;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mStatusView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniStatusLayout;", "mVideoView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVideoView;", "mVoiceView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView;", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "radius", "", "changeRendererSpeaker", "", "userName", "", "checkIfReceivingVideo", "", "drawAvatar", "drawBitmap", "bm", "Landroid/graphics/Bitmap;", "angle", "", "mirror", "getAvatarIv", "Landroid/widget/ImageView;", "getLastRenderSwitchTick", "", "()Ljava/lang/Long;", "getRendererSpeaker", "getStateContentDesc", "getUsername", "initShowMode", "isVideo", "onHangupHappened", "onResumeIconAndTipShow", "refreshLayoutCauseDockChanged", "isDockerLeft", "refreshMiniView", "refreshRenderTick", "setVoicePlayDevice", "device", "showSelfCameraStatus", "show", "showSelfMuteStatus", "showSpeakerAvatar", "switchToVideo", "switchToVoice", "uninit", "updateText", "text", "updateTime", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends BaseSmallView
  implements f
{
  public static final m.a Lvr;
  j Lvs;
  i Lvt;
  private h Lvu;
  private PowerManager.WakeLock mUJ;
  private final float radius;
  
  static
  {
    AppMethodBeat.i(285456);
    Lvr = new m.a((byte)0);
    AppMethodBeat.o(285456);
  }
  
  public m(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(285449);
    this.radius = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 12);
    Object localObject = MMApplicationContext.getContext().getSystemService("power");
    if (localObject == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(285449);
      throw paramContext;
    }
    this.mUJ = ((PowerManager)localObject).newWakeLock(536870922, "MicroMsg.MultiTalkSmallView");
    localObject = this.mUJ;
    if (localObject != null)
    {
      com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView", "<init>", "(Landroid/content/Context;)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      ((PowerManager.WakeLock)localObject).acquire();
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView", "<init>", "(Landroid/content/Context;)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    }
    LayoutInflater.from(paramContext).inflate(a.f.multitalk_mini_widget_view, (ViewGroup)this);
    setClipToOutline(true);
    setOutlineProvider((ViewOutlineProvider)new k(this.radius));
    findViewById(a.e.multitalk_voice).setClipToOutline(true);
    findViewById(a.e.multitalk_voice).setOutlineProvider((ViewOutlineProvider)new k(this.radius));
    findViewById(a.e.multitalk_video).setClipToOutline(true);
    findViewById(a.e.multitalk_video).setOutlineProvider((ViewOutlineProvider)new k(this.radius));
    paramContext = findViewById(a.e.multitalk_voice);
    s.s(paramContext, "multitalk_voice");
    this.Lvs = new j(paramContext);
    paramContext = findViewById(a.e.multitalk_video);
    s.s(paramContext, "multitalk_video");
    this.Lvt = new i(paramContext);
    paramContext = findViewById(a.e.multitalk_minio_small_status_layout);
    s.s(paramContext, "multitalk_minio_small_status_layout");
    this.Lvu = new h(paramContext);
    AppMethodBeat.o(285449);
  }
  
  private final String getStateContentDesc()
  {
    Object localObject2 = null;
    AppMethodBeat.i(285453);
    Object localObject1 = this.Lvu;
    int i;
    label40:
    String str;
    if ((localObject1 != null) && (!((h)localObject1).LuL))
    {
      i = 1;
      if (i == 0) {
        break label113;
      }
      localObject1 = getContext();
      if (localObject1 != null) {
        break label102;
      }
      localObject1 = null;
      str = s.X("", localObject1);
      localObject1 = this.Lvu;
      if ((localObject1 == null) || (((h)localObject1).LuK != true)) {
        break label138;
      }
      i = 1;
      label68:
      if (i == 0) {
        break label154;
      }
      localObject1 = getContext();
      if (localObject1 != null) {
        break label143;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = s.X(str, localObject1);
      AppMethodBeat.o(285453);
      return localObject1;
      i = 0;
      break;
      label102:
      localObject1 = ((Context)localObject1).getString(a.h.voip_multi_voice_icon_open);
      break label40;
      label113:
      localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label40;
      }
      localObject1 = ((Context)localObject1).getString(a.h.voip_multi_voice_icon_close);
      break label40;
      label138:
      i = 0;
      break label68;
      label143:
      localObject1 = ((Context)localObject1).getString(a.h.voip_multi_video_icon_open);
      continue;
      label154:
      Context localContext = getContext();
      localObject1 = localObject2;
      if (localContext != null) {
        localObject1 = localContext.getString(a.h.voip_multi_video_icon_close);
      }
    }
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(285486);
    s.u(paramString, "userName");
    s.u(paramBitmap, "bm");
    Object localObject1 = this.Lvt;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject1 = this.Lvt;
        if (localObject1 != null) {
          break label105;
        }
      }
    }
    label105:
    for (localObject1 = localObject2;; localObject1 = ((i)localObject1).LuU)
    {
      if (s.p(paramString, localObject1))
      {
        localObject1 = this.Lvt;
        if (localObject1 != null) {
          ((i)localObject1).b(paramString, paramBitmap, paramInt2, paramInt1);
        }
      }
      AppMethodBeat.o(285486);
      return;
      localObject1 = ((i)localObject1).LuU;
      break;
    }
  }
  
  public final void aNF(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(285533);
    super.aNF(paramString);
    Object localObject2 = this.Lvs;
    if (localObject2 != null)
    {
      TextView localTextView = ((j)localObject2).timeTv;
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
      localObject2 = ((j)localObject2).timeTv;
      if (localObject2 != null) {
        ((TextView)localObject2).setText((CharSequence)paramString);
      }
    }
    localObject2 = findViewById(a.e.multitalk_video);
    paramString = getContext();
    if (paramString == null)
    {
      paramString = null;
      ((View)localObject2).setContentDescription((CharSequence)s.X(paramString, getStateContentDesc()));
      localObject2 = findViewById(a.e.multitalk_voice);
      paramString = getContext();
      if (paramString != null) {
        break label145;
      }
    }
    label145:
    for (paramString = localObject1;; paramString = paramString.getString(a.h.talkback_video_talk_multi_talking_no_time))
    {
      ((View)localObject2).setContentDescription((CharSequence)s.X(paramString, getStateContentDesc()));
      AppMethodBeat.o(285533);
      return;
      paramString = paramString.getString(a.h.talkback_video_talk_multi_talking_no_time);
      break;
    }
  }
  
  public final void aNG(String paramString)
  {
    AppMethodBeat.i(285540);
    s.u(paramString, "userName");
    if (!ac.ggS().Loj.contains(paramString))
    {
      i locali = this.Lvt;
      if (locali != null) {
        locali.aNC(paramString);
      }
    }
    AppMethodBeat.o(285540);
  }
  
  public final void aNH(String paramString)
  {
    AppMethodBeat.i(285553);
    Object localObject = getLastRenderSwitchTick();
    if (localObject == null) {}
    for (long l = 0L;; l = ((Long)localObject).longValue())
    {
      Log.printInfoStack("MicroMsg.MultiTalkSmallView", "changeRendererSpeaker %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      localObject = this.Lvt;
      if (localObject != null) {
        ((i)localObject).aNz(paramString);
      }
      AppMethodBeat.o(285553);
      return;
    }
  }
  
  public final void etJ()
  {
    AppMethodBeat.i(285470);
    Object localObject = this.Lvs;
    if (localObject != null)
    {
      localObject = ((j)localObject).ght();
      if (localObject != null) {
        break label135;
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        localObject = this.Lvs;
        if (localObject != null)
        {
          ((j)localObject).rootView.setAlpha(1.0F);
          ((j)localObject).rootView.setVisibility(0);
          ((j)localObject).rootView.clearAnimation();
          ((j)localObject).rootView.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new j.a((j)localObject)).start();
        }
        localObject = this.Lvt;
        if (localObject != null) {
          ((i)localObject).abR(0);
        }
        localObject = this.Lvt;
        if (localObject != null) {
          ((i)localObject).aNC(getRendererSpeaker());
        }
      }
      AppMethodBeat.o(285470);
      return;
      label135:
      if (((Integer)localObject).intValue() != 4) {
        break;
      }
    }
  }
  
  public final ImageView getAvatarIv()
  {
    return null;
  }
  
  public final Long getLastRenderSwitchTick()
  {
    i locali = this.Lvt;
    if (locali == null) {
      return null;
    }
    return locali.LuW;
  }
  
  public final String getRendererSpeaker()
  {
    Object localObject = this.Lvt;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((i)localObject).LuU;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final String getUsername()
  {
    Object localObject = this.Lvt;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((i)localObject).LuU;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final void gfe() {}
  
  public final boolean ghw()
  {
    AppMethodBeat.i(285506);
    super.ghw();
    Object localObject1 = this.Lvs;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((j)localObject1).timeTv;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = ((j)localObject1).Lvd;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setBackground(bb.m(((j)localObject1).context, a.g.icons_filled_call_end, Color.parseColor("#FA5151")));
      }
      localObject2 = ((j)localObject1).Lvd;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setIconColor(Color.parseColor("#FA5151"));
      }
      localObject2 = ((j)localObject1).pls;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(0);
      }
      localObject2 = ((j)localObject1).pls;
      if (localObject2 != null) {
        ((TextView)localObject2).setTextColor(Color.parseColor("#FA5151"));
      }
      localObject2 = ((j)localObject1).pls;
      if (localObject2 != null) {
        ((TextView)localObject2).setText(a.h.voip_miniwindow_end_wording);
      }
      ((j)localObject1).rootView.clearAnimation();
    }
    localObject1 = this.Lvt;
    if (localObject1 != null)
    {
      localObject2 = ((i)localObject1).LuN;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = ((i)localObject1).ucy;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      localObject2 = ((i)localObject1).LuR;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(bb.m(((i)localObject1).context, a.g.icons_filled_call_end, Color.parseColor("#FFFFFF")));
      }
      localObject2 = ((i)localObject1).LuS;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(0);
      }
      localObject2 = ((i)localObject1).LuP;
      if (localObject2 != null) {
        ((ImageView)localObject2).clearAnimation();
      }
      localObject1 = ((i)localObject1).LuS;
      if (localObject1 != null) {
        ((TextView)localObject1).setText(a.h.voip_miniwindow_end_wording);
      }
    }
    findViewById(a.e.multitalk_video).setContentDescription((CharSequence)"");
    findViewById(a.e.multitalk_voice).setContentDescription((CharSequence)"");
    AppMethodBeat.o(285506);
    return true;
  }
  
  public final void ghx()
  {
    AppMethodBeat.i(285523);
    Object localObject1 = this.Lvt;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((i)localObject1).LuN;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(0);
      }
      localObject1 = ((i)localObject1).ucy;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    localObject1 = this.Lvs;
    if (localObject1 != null)
    {
      localObject2 = ((j)localObject1).Lvd;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setBackground(bb.m(((j)localObject1).context, a.g.icons_filled_call, Color.parseColor("#07C160")));
      }
      localObject2 = ((j)localObject1).Lvd;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
      }
      localObject2 = ((j)localObject1).pls;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = ((j)localObject1).pls;
      if (localObject2 != null) {
        ((TextView)localObject2).setTextColor(Color.parseColor("#07C160"));
      }
      localObject1 = ((j)localObject1).timeTv;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
    }
    AppMethodBeat.o(285523);
  }
  
  public final void ghy()
  {
    int i = -1;
    AppMethodBeat.i(285529);
    super.ghy();
    Object localObject1 = this.Lvs;
    Object localObject2;
    Context localContext;
    int j;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((j)localObject1).AhP;
      if (localObject2 != null)
      {
        localContext = ((j)localObject1).context;
        j = a.d.voip_mini_voice_rectangle;
        localObject3 = ((j)localObject1).context;
        if (localObject3 != null) {
          break label118;
        }
      }
    }
    for (;;)
    {
      ((View)localObject2).setBackground(bb.m(localContext, j, i));
      localObject2 = ((j)localObject1).context;
      if (localObject2 != null)
      {
        localObject2 = ((Context)localObject2).getResources();
        if (localObject2 != null)
        {
          i = ((Resources)localObject2).getColor(a.b.FG_1);
          localObject1 = ((j)localObject1).timeTv;
          if (localObject1 != null) {
            ((TextView)localObject1).setTextColor(i);
          }
        }
      }
      AppMethodBeat.o(285529);
      return;
      label118:
      localObject3 = ((Context)localObject3).getResources();
      if (localObject3 != null) {
        i = ((Resources)localObject3).getColor(a.b.multitalk_mini_view_color);
      }
    }
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(285516);
    Object localObject1;
    Object localObject2;
    if (this.Uxg != paramInt)
    {
      this.Uxg = paramInt;
      localObject1 = this.Lvt;
      if (localObject1 != null)
      {
        localObject1 = ((i)localObject1).LuN;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
      }
      localObject1 = this.Lvt;
      if (localObject1 != null)
      {
        localObject2 = ((i)localObject1).ucy;
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
      }
      switch (paramInt)
      {
      default: 
        localObject1 = this.Lvs;
        if (localObject1 != null)
        {
          localObject2 = ((j)localObject1).pls;
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
      AppMethodBeat.o(285516);
      return;
      localObject2 = ((i)localObject1).LuR;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(bb.m(((i)localObject1).context, b.f.icons_filled_bluetooth, Color.parseColor("#FFFFFF")));
      }
      localObject1 = ((i)localObject1).LuS;
      s.checkNotNull(localObject1);
      ((TextView)localObject1).setText(b.g.voip_mini_bluetooth);
      break;
      localObject2 = ((i)localObject1).LuR;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(bb.m(((i)localObject1).context, b.f.icons_filled_volume_up, Color.parseColor("#FFFFFF")));
      }
      localObject1 = ((i)localObject1).LuS;
      s.checkNotNull(localObject1);
      ((TextView)localObject1).setText(b.g.voip_mini_mike);
      break;
      localObject2 = ((i)localObject1).LuR;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(bb.m(((i)localObject1).context, b.f.icons_filled_ear, Color.parseColor("#FFFFFF")));
      }
      localObject1 = ((i)localObject1).LuS;
      s.checkNotNull(localObject1);
      ((TextView)localObject1).setText(b.g.voip_mini_earpiece);
      break;
      localObject2 = ((i)localObject1).LuR;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(bb.m(((i)localObject1).context, b.f.icons_filled_headset, Color.parseColor("#FFFFFF")));
      }
      localObject1 = ((i)localObject1).LuS;
      s.checkNotNull(localObject1);
      ((TextView)localObject1).setText(b.g.voip_mini_headset);
      break;
      localObject2 = ((j)localObject1).Lvd;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setBackground(bb.m(((j)localObject1).context, a.g.icons_filled_bluetooth, Color.parseColor("#07C160")));
      }
      localObject2 = ((j)localObject1).Lvd;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
      }
      localObject2 = ((j)localObject1).pls;
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText(a.h.voip_mini_bluetooth);
        continue;
        localObject2 = ((j)localObject1).Lvd;
        if (localObject2 != null) {
          ((WeImageView)localObject2).setBackground(bb.m(((j)localObject1).context, a.g.icons_filled_volume_up, Color.parseColor("#07C160")));
        }
        localObject2 = ((j)localObject1).Lvd;
        if (localObject2 != null) {
          ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
        }
        localObject2 = ((j)localObject1).pls;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setText(a.h.voip_mini_mike);
          continue;
          localObject2 = ((j)localObject1).Lvd;
          if (localObject2 != null) {
            ((WeImageView)localObject2).setBackground(bb.m(((j)localObject1).context, a.g.icons_filled_ear, Color.parseColor("#07C160")));
          }
          localObject2 = ((j)localObject1).Lvd;
          if (localObject2 != null) {
            ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
          }
          localObject2 = ((j)localObject1).pls;
          if (localObject2 != null)
          {
            ((TextView)localObject2).setText(a.h.voip_mini_earpiece);
            continue;
            localObject2 = ((j)localObject1).Lvd;
            if (localObject2 != null) {
              ((WeImageView)localObject2).setBackground(bb.m(((j)localObject1).context, a.g.icons_filled_headset, Color.parseColor("#07C160")));
            }
            localObject2 = ((j)localObject1).Lvd;
            if (localObject2 != null) {
              ((WeImageView)localObject2).setIconColor(Color.parseColor("#07C160"));
            }
            localObject2 = ((j)localObject1).pls;
            if (localObject2 != null) {
              ((TextView)localObject2).setText(a.h.voip_mini_headset);
            }
          }
        }
      }
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(285461);
    super.uninit();
    Object localObject = this.Lvt;
    if (localObject != null)
    {
      localObject = ((i)localObject).LuP;
      if (localObject != null) {
        ((ImageView)localObject).clearAnimation();
      }
    }
    localObject = this.Lvs;
    if (localObject != null) {
      ((j)localObject).rootView.clearAnimation();
    }
    if (this.mUJ != null)
    {
      localObject = this.mUJ;
      s.checkNotNull(localObject);
      if (((PowerManager.WakeLock)localObject).isHeld())
      {
        Log.i("MicroMsg.MultiTalkSmallView", "release waklock");
        localObject = this.mUJ;
        if (localObject != null)
        {
          com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView", "uninit", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          ((PowerManager.WakeLock)localObject).release();
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView", "uninit", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        }
      }
    }
    AppMethodBeat.o(285461);
  }
  
  public final void updateText(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(285501);
    super.updateText(paramString);
    Object localObject2 = this.Lvs;
    if (localObject2 != null)
    {
      TextView localTextView = ((j)localObject2).timeTv;
      if (localTextView != null) {
        localTextView.setTextSize(1, 12.0F);
      }
      localObject2 = ((j)localObject2).timeTv;
      if (localObject2 != null) {
        ((TextView)localObject2).setText((CharSequence)paramString);
      }
    }
    localObject2 = findViewById(a.e.multitalk_video);
    paramString = getContext();
    if (paramString == null)
    {
      paramString = null;
      ((View)localObject2).setContentDescription((CharSequence)s.X(paramString, getStateContentDesc()));
      localObject2 = findViewById(a.e.multitalk_voice);
      paramString = getContext();
      if (paramString != null) {
        break label145;
      }
    }
    label145:
    for (paramString = localObject1;; paramString = paramString.getString(a.h.talkback_video_talk_multi_waiting))
    {
      ((View)localObject2).setContentDescription((CharSequence)s.X(paramString, getStateContentDesc()));
      AppMethodBeat.o(285501);
      return;
      paramString = paramString.getString(a.h.talkback_video_talk_multi_waiting);
      break;
    }
  }
  
  public final void zj(boolean paramBoolean)
  {
    AppMethodBeat.i(285463);
    if (paramBoolean)
    {
      Object localObject = this.Lvs;
      if (localObject != null)
      {
        Integer localInteger = Integer.valueOf(4);
        if (localInteger != null)
        {
          ((j)localObject).rootView.setVisibility(localInteger.intValue());
          ((j)localObject).Lve = localInteger;
        }
      }
      localObject = this.Lvt;
      if (localObject != null) {
        ((i)localObject).abR(0);
      }
    }
    AppMethodBeat.o(285463);
  }
  
  public final void zk(boolean paramBoolean)
  {
    AppMethodBeat.i(285475);
    h localh = this.Lvu;
    if (localh != null)
    {
      localh.LuK = paramBoolean;
      localh.aD(localh.LuL, localh.LuK);
    }
    AppMethodBeat.o(285475);
  }
  
  public final void zl(boolean paramBoolean)
  {
    AppMethodBeat.i(285481);
    h localh = this.Lvu;
    if (localh != null)
    {
      localh.LuL = paramBoolean;
      localh.aD(localh.LuL, localh.LuK);
    }
    AppMethodBeat.o(285481);
  }
  
  public final void zm(boolean paramBoolean)
  {
    AppMethodBeat.i(285563);
    Object localObject2 = this.Lvs;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((j)localObject2).contentView;
      if ((localObject1 != null) && (((View)localObject1).getLayoutParams() != null))
      {
        localObject1 = ((j)localObject2).contentView;
        if (localObject1 == null) {}
        for (localObject1 = null; localObject1 == null; localObject1 = ((View)localObject1).getLayoutParams())
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(285563);
          throw ((Throwable)localObject1);
        }
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        if (!paramBoolean) {
          break label184;
        }
        ((RelativeLayout.LayoutParams)localObject1).setMarginStart(bd.fromDPToPix(((j)localObject2).context, 24));
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(bd.fromDPToPix(((j)localObject2).context, 8));
        localObject2 = ((j)localObject2).contentView;
        if (localObject2 != null) {
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    localObject2 = this.Lvt;
    if (localObject2 != null)
    {
      localObject1 = ((i)localObject2).contentView;
      if ((localObject1 != null) && (((View)localObject1).getLayoutParams() != null))
      {
        localObject1 = ((i)localObject2).contentView;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((View)localObject1).getLayoutParams())
        {
          if (localObject1 != null) {
            break label221;
          }
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(285563);
          throw ((Throwable)localObject1);
          label184:
          ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(bd.fromDPToPix(((j)localObject2).context, 24));
          ((RelativeLayout.LayoutParams)localObject1).setMarginStart(bd.fromDPToPix(((j)localObject2).context, 8));
          break;
        }
        label221:
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        if (!paramBoolean) {
          break label313;
        }
        ((RelativeLayout.LayoutParams)localObject1).setMarginStart(bd.fromDPToPix(((i)localObject2).context, 24));
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(bd.fromDPToPix(((i)localObject2).context, 8));
      }
    }
    for (;;)
    {
      localObject2 = ((i)localObject2).contentView;
      if (localObject2 != null) {
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.Lvu;
      if (localObject1 == null) {
        break label374;
      }
      localObject2 = ((h)localObject1).rootView.getLayoutParams();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(285563);
      throw ((Throwable)localObject1);
      label313:
      ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(bd.fromDPToPix(((i)localObject2).context, 24));
      ((RelativeLayout.LayoutParams)localObject1).setMarginStart(bd.fromDPToPix(((i)localObject2).context, 8));
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject2).addRule(20);
    }
    for (;;)
    {
      ((h)localObject1).rootView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      label374:
      AppMethodBeat.o(285563);
      return;
      ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
      ((RelativeLayout.LayoutParams)localObject2).addRule(21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.m
 * JD-Core Version:    0.7.0.1
 */