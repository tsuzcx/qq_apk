package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.af;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "avatarIv", "Landroid/widget/ImageView;", "debugInfo", "Landroid/widget/TextView;", "drawPaint", "Landroid/graphics/Paint;", "elementPrev", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;", "getElementPrev", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;", "setElementPrev", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "mILinkMode", "", "mId", "getMId", "setMId", "mPrevBitmap", "Landroid/graphics/Bitmap;", "mPrevBitmapAngle", "mPrevBitmapMirror", "mRecvFps", "mShowDebugInfo", "mVideoHeight", "mVideoWidth", "nickName", "", "position", "getPosition", "setPosition", "renderView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;", "getStatus", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;", "setStatus", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;)V", "username", "changeToAvatar", "", "changeToNone", "changeToScreenCast", "changeToVideo", "changeUser", "mid", "drawAvatar", "drawBitmap", "bitmap", "angle", "mirror", "canvas", "Landroid/graphics/Canvas;", "pureDraw", "userName", "bm", "drawBitmapPrev", "drawPrevBitmap", "drawVideo", "img", "finish", "getAvatarIv", "getBitmapMatrix", "Landroid/graphics/Matrix;", "displayWidth", "displayHeight", "bmWidth", "bmHeight", "getCurrentSnapShot", "getNickName", "getUsername", "isAvatarMode", "isScreenCast", "isVideoMode", "refreshDebugInfo", "refreshView", "showVideoInfo", "updateAvatarBitmap", "Companion", "PrevBitmapDataClass", "Status", "plugin-multitalk_release"})
public final class MultitalkFrameView
  extends FrameLayout
  implements f
{
  public static final MultitalkFrameView.a FAE;
  private TextView FAA;
  private MultitalkFrameView.c FAB;
  private boolean FAC;
  private b FAD;
  private VoIPRenderTextureView FyB;
  private int index;
  private ImageView jiu;
  private int mId;
  private int mVideoHeight;
  private int mVideoWidth;
  private String nickName;
  private int position;
  private Paint tUe;
  private int tUh;
  public boolean tUi;
  private String username;
  
  static
  {
    AppMethodBeat.i(202504);
    FAE = new MultitalkFrameView.a((byte)0);
    AppMethodBeat.o(202504);
  }
  
  public MultitalkFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(202502);
    this.FAB = MultitalkFrameView.c.FAL;
    if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {}
    for (boolean bool = true;; bool = false)
    {
      this.tUi = bool;
      this.mId = -1;
      paramAttributeSet = ad.eYc();
      kotlin.g.b.p.j(paramAttributeSet, "SubCoreMultiTalk.getMultiTalkManager()");
      this.FAC = paramAttributeSet.eXg();
      this.mVideoWidth = getMeasuredWidth();
      this.mVideoHeight = getMeasuredHeight();
      Log.printInfoStack("MicroMsg.MultitalkFrameView", "MultitalkFrameView init " + hashCode(), new Object[0]);
      LayoutInflater.from(paramContext).inflate(a.f.multitalk_frame_layout, (ViewGroup)this);
      this.FyB = ((VoIPRenderTextureView)getRootView().findViewById(a.e.frame_video));
      this.jiu = ((ImageView)getRootView().findViewById(a.e.frame_avatar));
      this.FAA = ((TextView)getRootView().findViewById(a.e.debug_info));
      this.tUe = new Paint();
      paramContext = this.tUe;
      if (paramContext != null) {
        paramContext.setColor(-16777216);
      }
      paramContext = this.tUe;
      if (paramContext != null) {
        paramContext.setFilterBitmap(false);
      }
      paramContext = this.tUe;
      if (paramContext != null) {
        paramContext.setTextSize(40.0F);
      }
      this.FAD = new b();
      AppMethodBeat.o(202502);
      return;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(202485);
    if (paramb != null) {}
    for (Object localObject1 = paramb.FAF;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = paramb.FAF;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        if (!((Bitmap)localObject1).isRecycled())
        {
          Object localObject2 = this.username;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = paramb.FAF;
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          a((String)localObject1, (Bitmap)localObject2, paramb.FAG, paramb.FAH);
        }
      }
      AppMethodBeat.o(202485);
      return;
    }
  }
  
  public final void a(String paramString, final Bitmap paramBitmap, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(202439);
    kotlin.g.b.p.k(paramString, "userName");
    kotlin.g.b.p.k(paramBitmap, "bm");
    com.tencent.e.h.ZvG.bc((Runnable)new d(this, paramBitmap, paramInt1, paramInt2));
    AppMethodBeat.o(202439);
  }
  
  public final void eWn()
  {
    AppMethodBeat.i(202443);
    Object localObject = this.jiu;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.FyB;
    if (localObject != null)
    {
      ((VoIPRenderTextureView)localObject).setVisibility(8);
      AppMethodBeat.o(202443);
      return;
    }
    AppMethodBeat.o(202443);
  }
  
  public final boolean eXd()
  {
    return this.FAB == MultitalkFrameView.c.FAJ;
  }
  
  public final void eYN()
  {
    AppMethodBeat.i(202453);
    if (eYS())
    {
      q localq = ad.eYc();
      kotlin.g.b.p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      localq.eXp();
      af.a((f)this);
    }
    AppMethodBeat.o(202453);
  }
  
  public final void eYO()
  {
    AppMethodBeat.i(202460);
    if (Util.isNullOrNil(getUsername()))
    {
      AppMethodBeat.o(202460);
      return;
    }
    Log.printInfoStack("MicroMsg.MultitalkFrameView", "changeToAvatar %s from %s", new Object[] { getUsername(), this.FAB.name() });
    this.FAB = MultitalkFrameView.c.FAI;
    eYN();
    AppMethodBeat.o(202460);
  }
  
  public final void eYP()
  {
    AppMethodBeat.i(202463);
    Log.printInfoStack("MicroMsg.MultitalkFrameView", "changeToVideo %s from %s", new Object[] { getUsername(), this.FAB.name() });
    this.FAB = MultitalkFrameView.c.FAJ;
    a(this.FAD);
    AppMethodBeat.o(202463);
  }
  
  public final void eYQ()
  {
    this.FAB = MultitalkFrameView.c.FAK;
    this.FAD.FAF = null;
  }
  
  public final void eYR()
  {
    AppMethodBeat.i(202468);
    Log.i("MicroMsg.MultitalkFrameView", "changeToNone %s from %s", new Object[] { getUsername(), this.FAB.name() });
    this.FAB = MultitalkFrameView.c.FAL;
    fo("", -1);
    AppMethodBeat.o(202468);
  }
  
  public final boolean eYS()
  {
    return this.FAB == MultitalkFrameView.c.FAI;
  }
  
  public final boolean eYT()
  {
    return this.FAB == MultitalkFrameView.c.FAK;
  }
  
  public final void f(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(202435);
      if ((paramBitmap == null) || (paramBitmap.isRecycled()))
      {
        Log.e("MicroMsg.MultitalkFrameView", "DrawBitmap, bitmap is null or recycled");
        com.tencent.mm.plugin.multitalk.model.p.eWM();
        AppMethodBeat.o(202435);
      }
      for (;;)
      {
        return;
        if (this.FyB != null) {
          break;
        }
        AppMethodBeat.o(202435);
      }
      localObject = this.FyB;
    }
    finally {}
    if (localObject != null) {}
    for (Object localObject = ((VoIPRenderTextureView)localObject).lockCanvas(null);; localObject = null)
    {
      if (localObject == null)
      {
        Log.e("MicroMsg.MultitalkFrameView", "getCanvasError");
        AppMethodBeat.o(202435);
        break;
      }
      int k = ((Canvas)localObject).getWidth();
      int m = ((Canvas)localObject).getHeight();
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      if ((paramInt1 == OpenGlRender.FLAG_Angle270) || (paramInt1 == 270))
      {
        localMatrix.postTranslate(-i / 2.0F, -j / 2.0F);
        localMatrix.postRotate(270.0F);
        localMatrix.postTranslate(j / 2.0F, i / 2.0F);
        paramInt1 = j;
      }
      for (;;)
      {
        for (;;)
        {
          if (paramInt2 == OpenGlRender.FLAG_Mirror)
          {
            localMatrix.postScale(-1.0F, 1.0F);
            localMatrix.postTranslate(paramInt1, 0.0F);
          }
          float f1 = m / k;
          float f2 = i / paramInt1;
          if (f1 < f2)
          {
            f1 = m / i;
            localMatrix.postScale(f1, f1);
            localMatrix.postTranslate((k - paramInt1 * f1) / 2.0F, 0.0F);
            label284:
            this.mVideoWidth = paramBitmap.getWidth();
            this.mVideoHeight = paramBitmap.getHeight();
            ((Canvas)localObject).drawColor(0, PorterDuff.Mode.CLEAR);
            ((Canvas)localObject).drawColor(Color.parseColor("#232323"));
            boolean bool = paramBitmap.isRecycled();
            if (bool) {}
          }
          try
          {
            for (;;)
            {
              ((Canvas)localObject).drawBitmap(paramBitmap, localMatrix, this.tUe);
              try
              {
                paramBitmap = this.FyB;
                if (paramBitmap != null) {
                  paramBitmap.unlockCanvasAndPost((Canvas)localObject);
                }
                this.tUh += 1;
                AppMethodBeat.o(202435);
              }
              catch (Exception paramBitmap)
              {
                Log.printErrStackTrace("MicroMsg.MultitalkFrameView", (Throwable)paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                AppMethodBeat.o(202435);
              }
            }
            if ((paramInt1 != OpenGlRender.FLAG_Angle90) && (paramInt1 != 90)) {
              break label547;
            }
            localMatrix.postTranslate(-i / 2.0F, -j / 2.0F);
            localMatrix.postRotate(90.0F);
            localMatrix.postTranslate(j / 2.0F, i / 2.0F);
            paramInt1 = j;
            continue;
            if (f1 > f2)
            {
              f1 = k / paramInt1;
              localMatrix.postScale(f1, f1);
              localMatrix.postTranslate(0.0F, (m - f1 * i) / 2.0F);
              break label284;
            }
            localMatrix.postScale(k / paramInt1, m / i);
          }
          catch (Exception paramBitmap)
          {
            for (;;)
            {
              Log.e("MicroMsg.MultitalkFrameView", "draw bitmap error");
            }
          }
        }
        break;
        label547:
        paramInt1 = i;
        i = j;
      }
    }
  }
  
  public final void fo(String paramString, int paramInt)
  {
    AppMethodBeat.i(202473);
    Log.i("MicroMsg.MultitalkFrameView", "changeUser from %s to %s", new Object[] { this.username, paramString });
    this.username = paramString;
    Object localObject = com.tencent.mm.kernel.h.ae(n.class);
    kotlin.g.b.p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((n)localObject).bbL().RG(paramString);
    if (localObject != null) {}
    for (this.nickName = ((as)localObject).ayr();; this.nickName = paramString)
    {
      this.mId = paramInt;
      AppMethodBeat.o(202473);
      return;
    }
  }
  
  public final ImageView getAvatarIv()
  {
    return this.jiu;
  }
  
  public final b getCurrentSnapShot()
  {
    return this.FAD;
  }
  
  public final b getElementPrev()
  {
    return this.FAD;
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final int getMId()
  {
    return this.mId;
  }
  
  public final String getNickName()
  {
    return this.nickName;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  public final MultitalkFrameView.c getStatus()
  {
    return this.FAB;
  }
  
  public final String getUsername()
  {
    String str2 = this.username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void setElementPrev(b paramb)
  {
    AppMethodBeat.i(202480);
    kotlin.g.b.p.k(paramb, "<set-?>");
    this.FAD = paramb;
    AppMethodBeat.o(202480);
  }
  
  public final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public final void setMId(int paramInt)
  {
    this.mId = paramInt;
  }
  
  public final void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public final void setStatus(MultitalkFrameView.c paramc)
  {
    AppMethodBeat.i(202410);
    kotlin.g.b.p.k(paramc, "<set-?>");
    this.FAB = paramc;
    AppMethodBeat.o(202410);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;", "", "()V", "currentBitmap", "Landroid/graphics/Bitmap;", "getCurrentBitmap", "()Landroid/graphics/Bitmap;", "setCurrentBitmap", "(Landroid/graphics/Bitmap;)V", "prevAngle", "", "getPrevAngle", "()I", "setPrevAngle", "(I)V", "prevMirror", "getPrevMirror", "setPrevMirror", "plugin-multitalk_release"})
  public static final class b
  {
    Bitmap FAF;
    int FAG;
    int FAH;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(MultitalkFrameView paramMultitalkFrameView, Bitmap paramBitmap, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(204096);
      Object localObject = MultitalkFrameView.b(this.FAN);
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = MultitalkFrameView.c(this.FAN);
      if (localObject != null) {
        ((VoIPRenderTextureView)localObject).setVisibility(0);
      }
      this.FAN.f(paramBitmap, paramInt1, paramInt2);
      AppMethodBeat.o(204096);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView
 * JD-Core Version:    0.7.0.1
 */