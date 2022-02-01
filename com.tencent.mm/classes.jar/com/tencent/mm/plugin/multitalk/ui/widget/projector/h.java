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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
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
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;", "", "rootView", "Landroid/widget/RelativeLayout;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "context", "Landroid/content/Context;", "drawPaint", "Landroid/graphics/Paint;", "isDoingAnimationChange", "", "lastRenderSwitchTick", "", "getLastRenderSwitchTick", "()Ljava/lang/Long;", "setLastRenderSwitchTick", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mContentView", "value", "", "mCurrentRenderUser", "getMCurrentRenderUser", "()Ljava/lang/String;", "setMCurrentRenderUser", "(Ljava/lang/String;)V", "mCurrentShowUser", "getMCurrentShowUser", "setMCurrentShowUser", "mPrevBitmap", "Landroid/graphics/Bitmap;", "getMPrevBitmap", "()Landroid/graphics/Bitmap;", "setMPrevBitmap", "(Landroid/graphics/Bitmap;)V", "mPrevBitmapAngle", "", "mPrevBitmapMirror", "mPrevTarget", "getMPrevTarget", "()I", "setMPrevTarget", "(I)V", "mVoiceIv", "mVoiceRoot", "Landroid/view/View;", "radius", "", "renderView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "getRenderView", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "setRenderView", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;)V", "getRootView", "()Landroid/widget/RelativeLayout;", "setRootView", "(Landroid/widget/RelativeLayout;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "applyOrientation", "", "orientation", "changeRenderToAvatarAnimation", "userName", "changeRenderToVideoAnimation", "bitmap", "angle", "mirror", "target", "changeRenderUser", "name", "doAnimationHide", "doAnimationShow", "doShowOrHideSpeakerVoice", "show", "drawAvatar", "drawBitmap", "drawPrevBitmap", "drawVideo", "img", "resetLayoutCauseDoodle", "Companion", "plugin-multitalk_release"})
public final class h
{
  public static final h.a zWv;
  private Context context;
  ImageView jWS;
  private Paint qvj;
  private final float radius;
  private a zQD;
  VoIPRenderTextureView zSZ;
  String zTg;
  String zTh;
  Long zTi;
  private Bitmap zTj;
  private int zTk;
  private int zTl;
  private boolean zTn;
  private int zWq;
  private ImageView zWr;
  private View zWs;
  private RelativeLayout zWt;
  RelativeLayout zWu;
  
  static
  {
    AppMethodBeat.i(239989);
    zWv = new h.a((byte)0);
    AppMethodBeat.o(239989);
  }
  
  public h(RelativeLayout paramRelativeLayout, a parama)
  {
    AppMethodBeat.i(239988);
    this.zWu = paramRelativeLayout;
    this.zQD = parama;
    this.radius = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    this.context = this.zWu.getContext();
    paramRelativeLayout = LayoutInflater.from(this.context).inflate(2131495739, (ViewGroup)this.zWu);
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(239988);
      throw paramRelativeLayout;
    }
    this.zWt = ((RelativeLayout)paramRelativeLayout);
    paramRelativeLayout = this.zWt;
    if (paramRelativeLayout != null) {
      paramRelativeLayout.setClipToOutline(true);
    }
    paramRelativeLayout = this.zWt;
    if (paramRelativeLayout != null) {
      paramRelativeLayout.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    paramRelativeLayout = this.zWt;
    if (paramRelativeLayout != null)
    {
      paramRelativeLayout = (VoIPRenderTextureView)paramRelativeLayout.findViewById(2131305060);
      this.zSZ = paramRelativeLayout;
      paramRelativeLayout = this.zSZ;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setClipToOutline(true);
      }
      paramRelativeLayout = this.zSZ;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
      }
      this.qvj = new Paint();
      paramRelativeLayout = this.qvj;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setColor(-16777216);
      }
      paramRelativeLayout = this.qvj;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setFilterBitmap(true);
      }
      paramRelativeLayout = this.qvj;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setTextSize(40.0F);
      }
      paramRelativeLayout = this.zWt;
      if (paramRelativeLayout == null) {
        break label352;
      }
      paramRelativeLayout = (ImageView)paramRelativeLayout.findViewById(2131297130);
      label287:
      this.jWS = paramRelativeLayout;
      paramRelativeLayout = this.zWt;
      if (paramRelativeLayout == null) {
        break label357;
      }
    }
    label352:
    label357:
    for (paramRelativeLayout = (ImageView)paramRelativeLayout.findViewById(2131309946);; paramRelativeLayout = null)
    {
      this.zWr = paramRelativeLayout;
      parama = this.zWt;
      paramRelativeLayout = localObject;
      if (parama != null) {
        paramRelativeLayout = parama.findViewById(2131309947);
      }
      this.zWs = paramRelativeLayout;
      AppMethodBeat.o(239988);
      return;
      paramRelativeLayout = null;
      break;
      paramRelativeLayout = null;
      break label287;
    }
  }
  
  private final void aGu(final String paramString)
  {
    AppMethodBeat.i(239982);
    com.tencent.f.h.RTc.aV((Runnable)new d(this, paramString));
    AppMethodBeat.o(239982);
  }
  
  public final void RA(int paramInt)
  {
    AppMethodBeat.i(239987);
    if (this.zQD.epi() == 0)
    {
      Object localObject1 = this.zWt;
      if (localObject1 != null)
      {
        if (paramInt != 180) {
          switch (paramInt)
          {
          }
        }
        for (;;)
        {
          if (this.zWq != 1)
          {
            localObject1 = this.zTg;
            if (localObject1 != null) {
              aGv((String)localObject1);
            }
          }
          localObject1 = this.zWr;
          if (localObject1 == null) {
            break;
          }
          ((ImageView)localObject1).setRotation(360.0F - paramInt);
          AppMethodBeat.o(239987);
          return;
          Object localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
          if (localObject2 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(239987);
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
          localObject1 = this.zWs;
          if (localObject1 != null)
          {
            localObject2 = ((View)localObject1).getLayoutParams();
            if (localObject2 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(239987);
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
            ((RelativeLayout.LayoutParams)localObject2).setMarginStart(f.zSe / 2);
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ((View)localObject1).requestLayout();
            continue;
            localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
            if (localObject2 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(239987);
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
            localObject1 = this.zWs;
            if (localObject1 != null)
            {
              localObject2 = ((View)localObject1).getLayoutParams();
              if (localObject2 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(239987);
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
              ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(f.zSe / 2);
              ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              ((View)localObject1).requestLayout();
              continue;
              localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
              if (localObject2 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(239987);
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
              localObject1 = this.zWs;
              if (localObject1 != null)
              {
                localObject2 = ((View)localObject1).getLayoutParams();
                if (localObject2 == null)
                {
                  localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                  AppMethodBeat.o(239987);
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
                ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(f.zSe / 2);
                ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((View)localObject1).requestLayout();
              }
            }
          }
        }
        AppMethodBeat.o(239987);
        return;
      }
    }
    AppMethodBeat.o(239987);
  }
  
  public final void aGs(String paramString)
  {
    Long localLong = null;
    AppMethodBeat.i(239977);
    if (paramString == null)
    {
      this.zTj = null;
      this.zTl = -1;
      this.zTk = -1;
    }
    for (;;)
    {
      this.zTi = localLong;
      this.zTg = paramString;
      AppMethodBeat.o(239977);
      return;
      localLong = Long.valueOf(Util.currentTicks());
    }
  }
  
  public final void aGt(String paramString)
  {
    AppMethodBeat.i(239978);
    aGs(paramString);
    this.zTh = paramString;
    AppMethodBeat.o(239978);
  }
  
  public final boolean aGv(final String paramString)
  {
    int j = 0;
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(239981);
        kotlin.g.b.p.h(paramString, "userName");
        if (this.zSZ == null)
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "drawAvatar view is null");
          AppMethodBeat.o(239981);
          return bool;
        }
        if (this.zTn)
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "renderVideoBitmap img false cause isDoingAnimationChange");
          AppMethodBeat.o(239981);
          continue;
        }
        a.b.y(this.jWS, paramString);
      }
      finally {}
      Log.i("MicroMsg.ScreenProjectAvatarCellLayout", "changeRenderAnimation %s ", new Object[] { paramString });
      int i = j;
      if ((kotlin.g.b.p.j(this.zTh, paramString) ^ true))
      {
        i = j;
        if (this.zSZ != null)
        {
          i = j;
          if (this.zWq != 0)
          {
            aGt(paramString);
            this.zTn = true;
            com.tencent.f.h.RTc.aV((Runnable)new b(this, paramString));
            this.zWq = 0;
            i = 1;
          }
        }
      }
      if (i == 0)
      {
        Object localObject = this.jWS;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = this.zSZ;
        if (localObject != null) {
          ((VoIPRenderTextureView)localObject).setVisibility(8);
        }
        aGu(paramString);
      }
      AppMethodBeat.o(239981);
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
        AppMethodBeat.i(239980);
        kotlin.g.b.p.h(paramString, "userName");
        if (this.zSZ == null)
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "drawVideo view is null");
          AppMethodBeat.o(239980);
          return bool;
        }
        if (paramBitmap == null)
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "renderVideoBitmap img is null");
          AppMethodBeat.o(239980);
          continue;
        }
        if (!this.zTn) {
          break label100;
        }
      }
      finally {}
      Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "renderVideoBitmap img false cause isDoingAnimationChange");
      AppMethodBeat.o(239980);
      continue;
      label100:
      Log.i("MicroMsg.ScreenProjectAvatarCellLayout", "changeRenderAnimation %s and target is %s", new Object[] { paramString, Integer.valueOf(1) });
      int i = j;
      if ((kotlin.g.b.p.j(this.zTh, paramString) ^ true))
      {
        i = j;
        if (this.zSZ != null)
        {
          i = j;
          if (this.zWq != 1)
          {
            aGt(paramString);
            this.zTn = true;
            com.tencent.f.h.RTc.aV((Runnable)new c(this, paramString, paramBitmap, paramInt2, paramInt1));
            i = 1;
          }
        }
      }
      if (i == 0)
      {
        Object localObject = this.jWS;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(8);
        }
        localObject = this.zSZ;
        if (localObject != null) {
          ((VoIPRenderTextureView)localObject).setVisibility(0);
        }
        g(paramBitmap, paramInt2, paramInt1);
        aGu(paramString);
        AppMethodBeat.o(239980);
        bool = true;
      }
      else
      {
        AppMethodBeat.o(239980);
        bool = true;
      }
    }
  }
  
  public final Integer eoH()
  {
    AppMethodBeat.i(239976);
    int i = this.zWu.getVisibility();
    AppMethodBeat.o(239976);
    return Integer.valueOf(i);
  }
  
  public final void epx()
  {
    AppMethodBeat.i(239983);
    epz();
    RA(this.zQD.epf());
    this.zWu.setAlpha(0.0F);
    this.zWu.setVisibility(0);
    this.zWu.clearAnimation();
    this.zWu.animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new f(this)).start();
    AppMethodBeat.o(239983);
  }
  
  public final void epy()
  {
    AppMethodBeat.i(239984);
    this.zWu.setAlpha(1.0F);
    this.zWu.setVisibility(0);
    this.zWu.clearAnimation();
    this.zWu.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new e(this)).start();
    AppMethodBeat.o(239984);
  }
  
  public final void epz()
  {
    AppMethodBeat.i(239985);
    RelativeLayout localRelativeLayout;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.zQD.epf() == 90) || (this.zQD.epf() == 270))
    {
      localRelativeLayout = this.zWu;
      int i = f.zSw;
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      if (!this.zQD.epg()) {
        break label94;
      }
      localLayoutParams.setMarginEnd(f.zSt);
    }
    for (;;)
    {
      localLayoutParams.addRule(21);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(239985);
      return;
      label94:
      localLayoutParams.setMarginEnd(f.zSk);
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
        AppMethodBeat.i(239979);
        if ((paramBitmap == null) || (paramBitmap.isRecycled()))
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "DrawBitmap, bitmap is null or recycled");
          com.tencent.mm.plugin.multitalk.model.p.emX();
          AppMethodBeat.o(239979);
          return;
        }
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        if (this.zSZ == null)
        {
          AppMethodBeat.o(239979);
          continue;
        }
        localObject = this.zSZ;
      }
      finally {}
      Object localObject;
      if (localObject != null) {
        localCanvas = ((VoIPRenderTextureView)localObject).lockCanvas(null);
      }
      if (localCanvas == null)
      {
        Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "getCanvasError");
        AppMethodBeat.o(239979);
      }
      else
      {
        localObject = new Matrix();
        int k = this.zQD.epf();
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
          localCanvas.drawBitmap(paramBitmap, (Matrix)localObject, this.qvj);
          this.zTk = paramInt1;
          this.zTl = paramInt2;
          this.zTj = paramBitmap;
          this.zWq = 1;
          try
          {
            paramBitmap = this.zSZ;
            if (paramBitmap == null) {
              break label431;
            }
            paramBitmap.unlockCanvasAndPost(localCanvas);
            AppMethodBeat.o(239979);
          }
          catch (Exception paramBitmap)
          {
            Log.printErrStackTrace("MicroMsg.ScreenProjectAvatarCellLayout", (Throwable)paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
            AppMethodBeat.o(239979);
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
          AppMethodBeat.o(239979);
        }
      }
    }
  }
  
  public final void se(boolean paramBoolean)
  {
    AppMethodBeat.i(239986);
    RA(this.zQD.epf());
    View localView = this.zWs;
    if (localView != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localView.setVisibility(i);
        AppMethodBeat.o(239986);
        return;
      }
    }
    AppMethodBeat.o(239986);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(h paramh, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(239968);
      Object localObject = this.zWw.zSZ;
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
                  AppMethodBeat.i(239965);
                  paramAnonymousAnimator = this.zWx.zWw.zSZ;
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setVisibility(8);
                  }
                  h.a(this.zWx.zWw);
                  paramAnonymousAnimator = this.zWx.zWw.jWS;
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setAlpha(1.0F);
                  }
                  paramAnonymousAnimator = this.zWx.zWw.jWS;
                  if (paramAnonymousAnimator != null)
                  {
                    paramAnonymousAnimator.setVisibility(0);
                    AppMethodBeat.o(239965);
                    return;
                  }
                  AppMethodBeat.o(239965);
                }
                
                public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
                
                public final void onAnimationStart(Animator paramAnonymousAnimator)
                {
                  AppMethodBeat.i(239966);
                  RelativeLayout localRelativeLayout = this.zWx.zWw.zWu;
                  Object localObject = new StringBuilder();
                  paramAnonymousAnimator = h.b(this.zWx.zWw);
                  if (paramAnonymousAnimator != null) {}
                  for (paramAnonymousAnimator = paramAnonymousAnimator.getString(2131757549);; paramAnonymousAnimator = null)
                  {
                    paramAnonymousAnimator = ((StringBuilder)localObject).append(String.valueOf(paramAnonymousAnimator)).append(",");
                    localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    kotlin.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
                    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(this.zWx.jDi);
                    kotlin.g.b.p.g(localObject, "MMKernel.service(IMessen…ava).contactStg[userName]");
                    localRelativeLayout.setContentDescription((CharSequence)((as)localObject).getNickname());
                    AppMethodBeat.o(239966);
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
                    AppMethodBeat.i(239967);
                    Object localObject = this.zWx.zWw.jWS;
                    if (localObject != null) {
                      ((ImageView)localObject).setAlpha(0.0F);
                    }
                    localObject = this.zWx.zWw.jWS;
                    if (localObject != null)
                    {
                      localObject = ((ImageView)localObject).animate();
                      if (localObject != null)
                      {
                        localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
                        if (localObject != null)
                        {
                          ((ViewPropertyAnimator)localObject).setDuration(300L);
                          AppMethodBeat.o(239967);
                          return;
                        }
                      }
                    }
                    AppMethodBeat.o(239967);
                  }
                });
                AppMethodBeat.o(239968);
                return;
              }
            }
          }
        }
      }
      AppMethodBeat.o(239968);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(h paramh, String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(239972);
      Object localObject = this.zWw.jWS;
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
                  AppMethodBeat.i(239969);
                  paramAnonymousAnimator = this.zWy.zWw.jWS;
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setVisibility(8);
                  }
                  h.a(this.zWy.zWw);
                  paramAnonymousAnimator = this.zWy.zWw.zSZ;
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setAlpha(1.0F);
                  }
                  paramAnonymousAnimator = this.zWy.zWw.zSZ;
                  if (paramAnonymousAnimator != null)
                  {
                    paramAnonymousAnimator.setVisibility(0);
                    AppMethodBeat.o(239969);
                    return;
                  }
                  AppMethodBeat.o(239969);
                }
                
                public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
                
                public final void onAnimationStart(Animator paramAnonymousAnimator)
                {
                  AppMethodBeat.i(239970);
                  RelativeLayout localRelativeLayout = this.zWy.zWw.zWu;
                  Object localObject = new StringBuilder();
                  paramAnonymousAnimator = h.b(this.zWy.zWw);
                  if (paramAnonymousAnimator != null) {}
                  for (paramAnonymousAnimator = paramAnonymousAnimator.getString(2131757549);; paramAnonymousAnimator = null)
                  {
                    paramAnonymousAnimator = ((StringBuilder)localObject).append(String.valueOf(paramAnonymousAnimator)).append(",");
                    localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    kotlin.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
                    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(this.zWy.jDi);
                    kotlin.g.b.p.g(localObject, "MMKernel.service(IMessen…ava).contactStg[userName]");
                    localRelativeLayout.setContentDescription((CharSequence)((as)localObject).getNickname());
                    AppMethodBeat.o(239970);
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
                    AppMethodBeat.i(239971);
                    Object localObject = this.zWy.zWw.zSZ;
                    if (localObject != null) {
                      ((VoIPRenderTextureView)localObject).setAlpha(0.0F);
                    }
                    localObject = this.zWy.zWw.zSZ;
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
                            AppMethodBeat.o(239971);
                            return;
                          }
                        }
                      }
                    }
                    AppMethodBeat.o(239971);
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
      this.zWw.g(paramBitmap, paramInt2, paramInt1);
      AppMethodBeat.o(239972);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(h paramh, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(239973);
      RelativeLayout localRelativeLayout = this.zWw.zWu;
      Object localObject2 = new StringBuilder();
      Object localObject1 = h.b(this.zWw);
      if (localObject1 != null) {}
      for (localObject1 = ((Context)localObject1).getString(2131757549);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject2).append(String.valueOf(localObject1)).append(",");
        localObject2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).aSN().Kn(paramString);
        kotlin.g.b.p.g(localObject2, "MMKernel.service(IMessen…ss.java).contactStg[name]");
        localRelativeLayout.setContentDescription((CharSequence)((as)localObject2).getNickname());
        if ((kotlin.g.b.p.j(this.zWw.zTh, paramString) ^ true))
        {
          this.zWw.aGt(paramString);
          this.zWw.zTi = Long.valueOf(Util.currentTicks());
        }
        AppMethodBeat.o(239973);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout$doAnimationHide$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(239974);
      this.zWw.zWu.setVisibility(4);
      AppMethodBeat.o(239974);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout$doAnimationShow$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(239975);
      this.zWw.zWu.setAlpha(1.0F);
      AppMethodBeat.o(239975);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.h
 * JD-Core Version:    0.7.0.1
 */