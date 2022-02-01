package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;", "", "rootView", "Landroid/widget/RelativeLayout;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "context", "Landroid/content/Context;", "drawPaint", "Landroid/graphics/Paint;", "isDoingAnimationChange", "", "lastRenderSwitchTick", "", "getLastRenderSwitchTick", "()Ljava/lang/Long;", "setLastRenderSwitchTick", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mContentView", "value", "", "mCurrentRenderUser", "getMCurrentRenderUser", "()Ljava/lang/String;", "setMCurrentRenderUser", "(Ljava/lang/String;)V", "mCurrentShowUser", "getMCurrentShowUser", "setMCurrentShowUser", "mPrevBitmap", "Landroid/graphics/Bitmap;", "getMPrevBitmap", "()Landroid/graphics/Bitmap;", "setMPrevBitmap", "(Landroid/graphics/Bitmap;)V", "mPrevBitmapAngle", "", "mPrevBitmapMirror", "mPrevTarget", "getMPrevTarget", "()I", "setMPrevTarget", "(I)V", "mVoiceIv", "mVoiceRoot", "Landroid/view/View;", "radius", "", "renderView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "getRenderView", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "setRenderView", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;)V", "getRootView", "()Landroid/widget/RelativeLayout;", "setRootView", "(Landroid/widget/RelativeLayout;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "applyOrientation", "", "orientation", "changeRenderToAvatarAnimation", "userName", "changeRenderToVideoAnimation", "bitmap", "angle", "mirror", "target", "changeRenderUser", "name", "doAnimationHide", "doAnimationShow", "doShowOrHideSpeakerVoice", "show", "drawAvatar", "drawBitmap", "drawPrevBitmap", "drawVideo", "img", "resetLayoutCauseDoodle", "Companion", "plugin-multitalk_release"})
public final class h
{
  public static final h.a FCd;
  RelativeLayout DtO;
  int FBZ;
  private ImageView FCa;
  private View FCb;
  private RelativeLayout FCc;
  private a Fwg;
  VoIPRenderTextureView FyB;
  String FyI;
  String FyJ;
  Long FyK;
  private Bitmap FyL;
  private int FyM;
  private int FyN;
  private boolean FyP;
  private Context context;
  ImageView mOe;
  private final float radius;
  private Paint tUe;
  
  static
  {
    AppMethodBeat.i(199966);
    FCd = new h.a((byte)0);
    AppMethodBeat.o(199966);
  }
  
  public h(RelativeLayout paramRelativeLayout, a parama)
  {
    AppMethodBeat.i(199963);
    this.DtO = paramRelativeLayout;
    this.Fwg = parama;
    this.radius = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    this.context = this.DtO.getContext();
    paramRelativeLayout = LayoutInflater.from(this.context).inflate(a.f.multitalk_screen_project_avatart, (ViewGroup)this.DtO);
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(199963);
      throw paramRelativeLayout;
    }
    this.FCc = ((RelativeLayout)paramRelativeLayout);
    paramRelativeLayout = this.FCc;
    if (paramRelativeLayout != null) {
      paramRelativeLayout.setClipToOutline(true);
    }
    paramRelativeLayout = this.FCc;
    if (paramRelativeLayout != null) {
      paramRelativeLayout.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    paramRelativeLayout = this.FCc;
    if (paramRelativeLayout != null)
    {
      paramRelativeLayout = (VoIPRenderTextureView)paramRelativeLayout.findViewById(a.e.multitalk_small_video_view_content);
      this.FyB = paramRelativeLayout;
      paramRelativeLayout = this.FyB;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setClipToOutline(true);
      }
      paramRelativeLayout = this.FyB;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
      }
      this.tUe = new Paint();
      paramRelativeLayout = this.tUe;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setColor(-16777216);
      }
      paramRelativeLayout = this.tUe;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setFilterBitmap(true);
      }
      paramRelativeLayout = this.tUe;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setTextSize(40.0F);
      }
      paramRelativeLayout = this.FCc;
      if (paramRelativeLayout == null) {
        break label355;
      }
      paramRelativeLayout = (ImageView)paramRelativeLayout.findViewById(a.e.avatar_frame);
      label290:
      this.mOe = paramRelativeLayout;
      paramRelativeLayout = this.FCc;
      if (paramRelativeLayout == null) {
        break label360;
      }
    }
    label355:
    label360:
    for (paramRelativeLayout = (ImageView)paramRelativeLayout.findViewById(a.e.voice_icon_iv);; paramRelativeLayout = null)
    {
      this.FCa = paramRelativeLayout;
      parama = this.FCc;
      paramRelativeLayout = localObject;
      if (parama != null) {
        paramRelativeLayout = parama.findViewById(a.e.voice_icon_root);
      }
      this.FCb = paramRelativeLayout;
      AppMethodBeat.o(199963);
      return;
      paramRelativeLayout = null;
      break;
      paramRelativeLayout = null;
      break label290;
    }
  }
  
  private final void aQI(final String paramString)
  {
    AppMethodBeat.i(199925);
    com.tencent.e.h.ZvG.bc((Runnable)new d(this, paramString));
    AppMethodBeat.o(199925);
  }
  
  public final void XQ(int paramInt)
  {
    AppMethodBeat.i(199955);
    if (this.Fwg.eYY() == 0)
    {
      Object localObject1 = this.FCc;
      if (localObject1 != null)
      {
        if (paramInt != 180) {
          switch (paramInt)
          {
          }
        }
        for (;;)
        {
          if (this.FBZ != 1)
          {
            localObject1 = this.FyI;
            if (localObject1 != null) {
              aQJ((String)localObject1);
            }
          }
          if (paramInt == 180) {
            break;
          }
          localObject1 = this.mOe;
          if (localObject1 != null) {
            ((ImageView)localObject1).setRotation(360.0F - paramInt);
          }
          localObject1 = this.FCa;
          if (localObject1 == null) {
            break;
          }
          ((ImageView)localObject1).setRotation(360.0F - paramInt);
          AppMethodBeat.o(199955);
          return;
          Object localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
          if (localObject2 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(199955);
            throw ((Throwable)localObject1);
          }
          localObject2 = (RelativeLayout.LayoutParams)localObject2;
          if (localObject2 != null) {
            ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
          }
          if (localObject2 != null) {
            ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
          }
          if (localObject2 != null) {
            ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
          }
          if (localObject2 != null) {
            ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
          }
          if (localObject2 != null) {
            ((RelativeLayout.LayoutParams)localObject2).addRule(21, -1);
          }
          if (localObject2 != null) {
            ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          }
          ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((RelativeLayout)localObject1).requestLayout();
          if (this.Fwg.eYY() == 0)
          {
            localObject1 = this.DtO;
            localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
            if (localObject2 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(199955);
              throw ((Throwable)localObject1);
            }
            localObject2 = (RelativeLayout.LayoutParams)localObject2;
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
            }
            ((RelativeLayout.LayoutParams)localObject2).bottomMargin = f.FxV;
            ((RelativeLayout.LayoutParams)localObject2).addRule(21, -1);
            ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
            ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ((RelativeLayout)localObject1).requestLayout();
          }
          localObject1 = this.FCb;
          if (localObject1 != null)
          {
            localObject2 = ((View)localObject1).getLayoutParams();
            if (localObject2 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(199955);
              throw ((Throwable)localObject1);
            }
            localObject2 = (RelativeLayout.LayoutParams)localObject2;
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).addRule(20, -1);
            }
            ((RelativeLayout.LayoutParams)localObject2).setMarginStart(f.FxG / 2);
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ((View)localObject1).requestLayout();
            continue;
            localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
            if (localObject2 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(199955);
              throw ((Throwable)localObject1);
            }
            localObject2 = (RelativeLayout.LayoutParams)localObject2;
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).addRule(20, -1);
            }
            if (localObject2 != null) {
              ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
            }
            ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ((RelativeLayout)localObject1).requestLayout();
            localObject1 = this.FCb;
            if (localObject1 != null)
            {
              localObject2 = ((View)localObject1).getLayoutParams();
              if (localObject2 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(199955);
                throw ((Throwable)localObject1);
              }
              localObject2 = (RelativeLayout.LayoutParams)localObject2;
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
              }
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
              }
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
              }
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
              }
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
              }
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).addRule(21, -1);
              }
              ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(f.FxG / 2);
              ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              ((View)localObject1).requestLayout();
            }
            if (this.Fwg.eYY() == 0)
            {
              localObject1 = this.DtO;
              localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
              if (localObject2 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(199955);
                throw ((Throwable)localObject1);
              }
              localObject2 = (RelativeLayout.LayoutParams)localObject2;
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
              }
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
              }
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
              }
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
              }
              ((RelativeLayout.LayoutParams)localObject2).setMarginStart(f.FxM);
              ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
              ((RelativeLayout.LayoutParams)localObject2).addRule(20, -1);
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
              }
              ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              ((RelativeLayout)localObject1).requestLayout();
              continue;
              localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
              if (localObject2 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(199955);
                throw ((Throwable)localObject1);
              }
              localObject2 = (RelativeLayout.LayoutParams)localObject2;
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
              }
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
              }
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
              }
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
              }
              ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
              if (localObject2 != null) {
                ((RelativeLayout.LayoutParams)localObject2).addRule(21, -1);
              }
              ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              ((RelativeLayout)localObject1).requestLayout();
              localObject1 = this.FCb;
              if (localObject1 != null)
              {
                localObject2 = ((View)localObject1).getLayoutParams();
                if (localObject2 == null)
                {
                  localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                  AppMethodBeat.o(199955);
                  throw ((Throwable)localObject1);
                }
                localObject2 = (RelativeLayout.LayoutParams)localObject2;
                if (localObject2 != null) {
                  ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
                }
                if (localObject2 != null) {
                  ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
                }
                if (localObject2 != null) {
                  ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
                }
                if (localObject2 != null) {
                  ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
                }
                if (localObject2 != null) {
                  ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
                }
                if (localObject2 != null) {
                  ((RelativeLayout.LayoutParams)localObject2).addRule(21, -1);
                }
                ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(f.FxG / 2);
                ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((View)localObject1).requestLayout();
              }
              if (this.Fwg.eYY() == 0)
              {
                localObject1 = this.DtO;
                localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
                if (localObject2 == null)
                {
                  localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                  AppMethodBeat.o(199955);
                  throw ((Throwable)localObject1);
                }
                localObject2 = (RelativeLayout.LayoutParams)localObject2;
                if (localObject2 != null) {
                  ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
                }
                if (localObject2 != null) {
                  ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
                }
                if (localObject2 != null) {
                  ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
                }
                if (localObject2 != null) {
                  ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
                }
                ((RelativeLayout.LayoutParams)localObject2).addRule(21, -1);
                ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
                ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(f.FxM);
                ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((RelativeLayout)localObject1).requestLayout();
              }
            }
          }
        }
        AppMethodBeat.o(199955);
        return;
      }
    }
    AppMethodBeat.o(199955);
  }
  
  public final void aQG(String paramString)
  {
    Long localLong = null;
    AppMethodBeat.i(199891);
    if (paramString == null)
    {
      this.FyL = null;
      this.FyN = -1;
      this.FyM = -1;
    }
    for (;;)
    {
      this.FyK = localLong;
      this.FyI = paramString;
      AppMethodBeat.o(199891);
      return;
      localLong = Long.valueOf(Util.currentTicks());
    }
  }
  
  public final void aQH(String paramString)
  {
    AppMethodBeat.i(199894);
    aQG(paramString);
    this.FyJ = paramString;
    AppMethodBeat.o(199894);
  }
  
  public final boolean aQJ(final String paramString)
  {
    int j = 0;
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(199923);
        kotlin.g.b.p.k(paramString, "userName");
        if (this.FyB == null)
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "drawAvatar view is null");
          AppMethodBeat.o(199923);
          return bool;
        }
        if (this.FyP)
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "renderVideoBitmap img false cause isDoingAnimationChange");
          AppMethodBeat.o(199923);
          continue;
        }
        a.b.A(this.mOe, paramString);
      }
      finally {}
      Log.i("MicroMsg.ScreenProjectAvatarCellLayout", "changeRenderAnimation %s ", new Object[] { paramString });
      int i = j;
      if ((kotlin.g.b.p.h(this.FyJ, paramString) ^ true))
      {
        i = j;
        if (this.FyB != null)
        {
          i = j;
          if (this.FBZ != 0)
          {
            aQH(paramString);
            this.FyP = true;
            com.tencent.e.h.ZvG.bc((Runnable)new b(this, paramString));
            this.FBZ = 0;
            i = 1;
          }
        }
      }
      if (i == 0)
      {
        Object localObject = this.mOe;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = this.FyB;
        if (localObject != null) {
          ((VoIPRenderTextureView)localObject).setVisibility(8);
        }
        aQI(paramString);
      }
      AppMethodBeat.o(199923);
      bool = true;
    }
  }
  
  public final boolean b(final String paramString, final Bitmap paramBitmap, final int paramInt1, final int paramInt2)
  {
    int j = 0;
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(199916);
        kotlin.g.b.p.k(paramString, "userName");
        if (this.FyB == null)
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "drawVideo view is null");
          AppMethodBeat.o(199916);
          return bool;
        }
        if (paramBitmap == null)
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "renderVideoBitmap img is null");
          AppMethodBeat.o(199916);
          continue;
        }
        if (!this.FyP) {
          break label100;
        }
      }
      finally {}
      Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "renderVideoBitmap img false cause isDoingAnimationChange");
      AppMethodBeat.o(199916);
      continue;
      label100:
      Log.i("MicroMsg.ScreenProjectAvatarCellLayout", "changeRenderAnimation %s and target is %s", new Object[] { paramString, Integer.valueOf(1) });
      int i = j;
      if ((kotlin.g.b.p.h(this.FyJ, paramString) ^ true))
      {
        i = j;
        if (this.FyB != null)
        {
          i = j;
          if (this.FBZ != 1)
          {
            aQH(paramString);
            this.FyP = true;
            com.tencent.e.h.ZvG.bc((Runnable)new c(this, paramString, paramBitmap, paramInt2, paramInt1));
            i = 1;
          }
        }
      }
      if (i == 0)
      {
        Object localObject = this.mOe;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(8);
        }
        localObject = this.FyB;
        if (localObject != null) {
          ((VoIPRenderTextureView)localObject).setVisibility(0);
        }
        g(paramBitmap, paramInt2, paramInt1);
        aQI(paramString);
        AppMethodBeat.o(199916);
        bool = true;
      }
      else
      {
        AppMethodBeat.o(199916);
        bool = true;
      }
    }
  }
  
  public final Integer eYy()
  {
    AppMethodBeat.i(199885);
    int i = this.DtO.getVisibility();
    AppMethodBeat.o(199885);
    return Integer.valueOf(i);
  }
  
  public final void eZk()
  {
    AppMethodBeat.i(199929);
    eZm();
    XQ(this.Fwg.eYV());
    this.DtO.setAlpha(0.0F);
    this.DtO.setVisibility(0);
    this.DtO.clearAnimation();
    this.DtO.animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new f(this)).start();
    AppMethodBeat.o(199929);
  }
  
  public final void eZl()
  {
    AppMethodBeat.i(199936);
    this.FBZ = 0;
    this.DtO.setAlpha(1.0F);
    this.DtO.setVisibility(0);
    this.DtO.clearAnimation();
    this.DtO.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new e(this)).start();
    AppMethodBeat.o(199936);
  }
  
  public final void eZm()
  {
    AppMethodBeat.i(199941);
    RelativeLayout localRelativeLayout;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.Fwg.eYV() == 90) || (this.Fwg.eYV() == 270))
    {
      localRelativeLayout = this.DtO;
      int i = f.FxY;
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      if (!this.Fwg.eYW()) {
        break label94;
      }
      localLayoutParams.setMarginEnd(f.FxV);
    }
    for (;;)
    {
      localLayoutParams.addRule(21);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(199941);
      return;
      label94:
      localLayoutParams.setMarginEnd(f.FxM);
    }
  }
  
  public final void g(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Canvas localCanvas = null;
    for (;;)
    {
      int i;
      int j;
      try
      {
        AppMethodBeat.i(199910);
        if ((paramBitmap == null) || (paramBitmap.isRecycled()))
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "DrawBitmap, bitmap is null or recycled");
          com.tencent.mm.plugin.multitalk.model.p.eWM();
          AppMethodBeat.o(199910);
          return;
        }
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        if (this.FyB == null)
        {
          AppMethodBeat.o(199910);
          continue;
        }
        localObject = this.FyB;
      }
      finally {}
      Object localObject;
      if (localObject != null) {
        localCanvas = ((VoIPRenderTextureView)localObject).lockCanvas(null);
      }
      if (localCanvas == null)
      {
        Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "getCanvasError");
        AppMethodBeat.o(199910);
      }
      else
      {
        localObject = new Matrix();
        int k = this.Fwg.eYV();
        if ((k == 90) || (k == 270)) {
          if (paramInt1 == OpenGlRender.FLAG_Angle270)
          {
            ((Matrix)localObject).setRotate(-90.0F, i / 2.0F, j / 2.0F);
            label178:
            if (paramInt2 == OpenGlRender.FLAG_Mirror)
            {
              ((Matrix)localObject).postScale(-1.0F, 1.0F);
              ((Matrix)localObject).postTranslate(i, 0.0F);
            }
            ((Matrix)localObject).postScale(localCanvas.getWidth() / j, localCanvas.getHeight() / i);
            localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            boolean bool = paramBitmap.isRecycled();
            if (bool) {}
          }
        }
        try
        {
          localCanvas.drawBitmap(paramBitmap, (Matrix)localObject, this.tUe);
          this.FyM = paramInt1;
          this.FyN = paramInt2;
          this.FyL = paramBitmap;
          this.FBZ = 1;
          try
          {
            paramBitmap = this.FyB;
            if (paramBitmap == null) {
              break label431;
            }
            paramBitmap.unlockCanvasAndPost(localCanvas);
            AppMethodBeat.o(199910);
          }
          catch (Exception paramBitmap)
          {
            Log.printErrStackTrace("MicroMsg.ScreenProjectAvatarCellLayout", (Throwable)paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
            AppMethodBeat.o(199910);
          }
          continue;
          if (paramInt1 != OpenGlRender.FLAG_Angle90) {
            break label178;
          }
          ((Matrix)localObject).setRotate(-270.0F, i / 2.0F, j / 2.0F);
          break label178;
          if (paramInt1 == OpenGlRender.FLAG_Angle270)
          {
            ((Matrix)localObject).setRotate(270.0F, i / 2.0F, j / 2.0F);
            break label178;
          }
          if (paramInt1 != OpenGlRender.FLAG_Angle90) {
            break label178;
          }
          ((Matrix)localObject).setRotate(90.0F, i / 2.0F, j / 2.0F);
        }
        catch (Exception paramBitmap)
        {
          for (;;)
          {
            Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "draw bitmap error");
          }
          label431:
          AppMethodBeat.o(199910);
        }
      }
    }
  }
  
  public final void vg(boolean paramBoolean)
  {
    AppMethodBeat.i(199942);
    XQ(this.Fwg.eYV());
    View localView = this.FCb;
    if (localView != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localView.setVisibility(i);
        AppMethodBeat.o(199942);
        return;
      }
    }
    AppMethodBeat.o(199942);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(h paramh, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(198587);
      Object localObject = this.FCe.FyB;
      if (localObject != null)
      {
        localObject = ((VoIPRenderTextureView)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
              {
                public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
                
                public final void onAnimationEnd(Animator paramAnonymousAnimator)
                {
                  AppMethodBeat.i(197789);
                  paramAnonymousAnimator = this.FCf.FCe.FyB;
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setVisibility(8);
                  }
                  h.a(this.FCf.FCe);
                  paramAnonymousAnimator = this.FCf.FCe.mOe;
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setAlpha(1.0F);
                  }
                  paramAnonymousAnimator = this.FCf.FCe.mOe;
                  if (paramAnonymousAnimator != null)
                  {
                    paramAnonymousAnimator.setVisibility(0);
                    AppMethodBeat.o(197789);
                    return;
                  }
                  AppMethodBeat.o(197789);
                }
                
                public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
                
                public final void onAnimationStart(Animator paramAnonymousAnimator)
                {
                  AppMethodBeat.i(197795);
                  RelativeLayout localRelativeLayout = this.FCf.FCe.DtO;
                  Object localObject = new StringBuilder();
                  paramAnonymousAnimator = h.b(this.FCf.FCe);
                  if (paramAnonymousAnimator != null) {}
                  for (paramAnonymousAnimator = paramAnonymousAnimator.getString(a.h.chatting_voip_voice);; paramAnonymousAnimator = null)
                  {
                    paramAnonymousAnimator = ((StringBuilder)localObject).append(String.valueOf(paramAnonymousAnimator)).append(",");
                    localObject = com.tencent.mm.kernel.h.ae(n.class);
                    kotlin.g.b.p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
                    localObject = ((n)localObject).bbL().RG(this.FCf.mtC);
                    kotlin.g.b.p.j(localObject, "MMKernel.service(IMessen…ava).contactStg[userName]");
                    localRelativeLayout.setContentDescription((CharSequence)((as)localObject).getNickname());
                    AppMethodBeat.o(197795);
                    return;
                  }
                }
              });
              if (localObject != null)
              {
                ((ViewPropertyAnimator)localObject).withStartAction((Runnable)new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(199501);
                    Object localObject = this.FCf.FCe.mOe;
                    if (localObject != null) {
                      ((ImageView)localObject).setAlpha(0.0F);
                    }
                    localObject = this.FCf.FCe.mOe;
                    if (localObject != null)
                    {
                      localObject = ((ImageView)localObject).animate();
                      if (localObject != null)
                      {
                        localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
                        if (localObject != null)
                        {
                          ((ViewPropertyAnimator)localObject).setDuration(300L);
                          AppMethodBeat.o(199501);
                          return;
                        }
                      }
                    }
                    AppMethodBeat.o(199501);
                  }
                });
                AppMethodBeat.o(198587);
                return;
              }
            }
          }
        }
      }
      AppMethodBeat.o(198587);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(h paramh, String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(196342);
      Object localObject = this.FCe.mOe;
      if (localObject != null)
      {
        localObject = ((ImageView)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
              {
                public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
                
                public final void onAnimationEnd(Animator paramAnonymousAnimator)
                {
                  AppMethodBeat.i(205903);
                  paramAnonymousAnimator = this.FCg.FCe.mOe;
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setVisibility(8);
                  }
                  h.a(this.FCg.FCe);
                  paramAnonymousAnimator = this.FCg.FCe.FyB;
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setAlpha(1.0F);
                  }
                  paramAnonymousAnimator = this.FCg.FCe.FyB;
                  if (paramAnonymousAnimator != null)
                  {
                    paramAnonymousAnimator.setVisibility(0);
                    AppMethodBeat.o(205903);
                    return;
                  }
                  AppMethodBeat.o(205903);
                }
                
                public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
                
                public final void onAnimationStart(Animator paramAnonymousAnimator)
                {
                  AppMethodBeat.i(205905);
                  RelativeLayout localRelativeLayout = this.FCg.FCe.DtO;
                  Object localObject = new StringBuilder();
                  paramAnonymousAnimator = h.b(this.FCg.FCe);
                  if (paramAnonymousAnimator != null) {}
                  for (paramAnonymousAnimator = paramAnonymousAnimator.getString(a.h.chatting_voip_voice);; paramAnonymousAnimator = null)
                  {
                    paramAnonymousAnimator = ((StringBuilder)localObject).append(String.valueOf(paramAnonymousAnimator)).append(",");
                    localObject = com.tencent.mm.kernel.h.ae(n.class);
                    kotlin.g.b.p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
                    localObject = ((n)localObject).bbL().RG(this.FCg.mtC);
                    kotlin.g.b.p.j(localObject, "MMKernel.service(IMessen…ava).contactStg[userName]");
                    localRelativeLayout.setContentDescription((CharSequence)((as)localObject).getNickname());
                    AppMethodBeat.o(205905);
                    return;
                  }
                }
              });
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).withStartAction((Runnable)new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(204721);
                    Object localObject = this.FCg.FCe.FyB;
                    if (localObject != null) {
                      ((VoIPRenderTextureView)localObject).setAlpha(0.0F);
                    }
                    localObject = this.FCg.FCe.FyB;
                    if (localObject != null)
                    {
                      localObject = ((VoIPRenderTextureView)localObject).animate();
                      if (localObject != null)
                      {
                        localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
                        if (localObject != null)
                        {
                          localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
                          if (localObject != null)
                          {
                            ((ViewPropertyAnimator)localObject).start();
                            AppMethodBeat.o(204721);
                            return;
                          }
                        }
                      }
                    }
                    AppMethodBeat.o(204721);
                  }
                });
                if (localObject != null) {
                  ((ViewPropertyAnimator)localObject).start();
                }
              }
            }
          }
        }
      }
      this.FCe.g(paramBitmap, paramInt2, paramInt1);
      AppMethodBeat.o(196342);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(h paramh, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(200015);
      RelativeLayout localRelativeLayout = this.FCe.DtO;
      Object localObject2 = new StringBuilder();
      Object localObject1 = h.b(this.FCe);
      if (localObject1 != null) {}
      for (localObject1 = ((Context)localObject1).getString(a.h.chatting_voip_voice);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject2).append(String.valueOf(localObject1)).append(",");
        localObject2 = com.tencent.mm.kernel.h.ae(n.class);
        kotlin.g.b.p.j(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
        localObject2 = ((n)localObject2).bbL().RG(paramString);
        kotlin.g.b.p.j(localObject2, "MMKernel.service(IMessen…ss.java).contactStg[name]");
        localRelativeLayout.setContentDescription((CharSequence)((as)localObject2).getNickname());
        if ((kotlin.g.b.p.h(this.FCe.FyJ, paramString) ^ true))
        {
          this.FCe.aQH(paramString);
          this.FCe.FyK = Long.valueOf(Util.currentTicks());
        }
        AppMethodBeat.o(200015);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout$doAnimationHide$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(198595);
      this.FCe.DtO.setVisibility(4);
      AppMethodBeat.o(198595);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout$doAnimationShow$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(200470);
      this.FCe.DtO.setAlpha(1.0F);
      AppMethodBeat.o(200470);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.h
 * JD-Core Version:    0.7.0.1
 */