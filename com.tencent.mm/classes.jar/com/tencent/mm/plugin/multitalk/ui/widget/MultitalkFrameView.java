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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.ae;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "avatarIv", "Landroid/widget/ImageView;", "debugInfo", "Landroid/widget/TextView;", "drawPaint", "Landroid/graphics/Paint;", "elementPrev", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;", "getElementPrev", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;", "setElementPrev", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "mILinkMode", "", "mId", "getMId", "setMId", "mPrevBitmap", "Landroid/graphics/Bitmap;", "mPrevBitmapAngle", "mPrevBitmapMirror", "mRecvFps", "mShowDebugInfo", "mVideoHeight", "mVideoWidth", "nickName", "", "position", "getPosition", "setPosition", "renderView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;", "getStatus", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;", "setStatus", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;)V", "username", "changeToAvatar", "", "changeToNone", "changeToScreenCast", "changeToVideo", "changeUser", "mid", "drawAvatar", "drawBitmap", "bitmap", "angle", "mirror", "canvas", "Landroid/graphics/Canvas;", "pureDraw", "userName", "bm", "drawBitmapPrev", "drawPrevBitmap", "drawVideo", "img", "finish", "getAvatarIv", "getBitmapMatrix", "Landroid/graphics/Matrix;", "displayWidth", "displayHeight", "bmWidth", "bmHeight", "getCurrentSnapShot", "getNickName", "getUsername", "isAvatarMode", "isScreenCast", "isVideoMode", "refreshDebugInfo", "refreshView", "showVideoInfo", "updateAvatarBitmap", "Companion", "PrevBitmapDataClass", "Status", "plugin-multitalk_release"})
public final class MultitalkFrameView
  extends FrameLayout
  implements f
{
  public static final MultitalkFrameView.a zUV;
  private ImageView gyr;
  private int index;
  private int mId;
  private int mVideoHeight;
  private int mVideoWidth;
  private String nickName;
  private int position;
  private Paint qvj;
  private int qvm;
  public boolean qvn;
  private String username;
  private VoIPRenderTextureView zSZ;
  private TextView zUR;
  private MultitalkFrameView.c zUS;
  private boolean zUT;
  private b zUU;
  
  static
  {
    AppMethodBeat.i(239890);
    zUV = new MultitalkFrameView.a((byte)0);
    AppMethodBeat.o(239890);
  }
  
  public MultitalkFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(239889);
    this.zUS = MultitalkFrameView.c.zVc;
    if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {}
    for (boolean bool = true;; bool = false)
    {
      this.qvn = bool;
      this.mId = -1;
      paramAttributeSet = ac.eom();
      kotlin.g.b.p.g(paramAttributeSet, "SubCoreMultiTalk.getMultiTalkManager()");
      this.zUT = paramAttributeSet.ens();
      this.mVideoWidth = getMeasuredWidth();
      this.mVideoHeight = getMeasuredHeight();
      Log.printInfoStack("MicroMsg.MultitalkFrameView", "MultitalkFrameView init " + hashCode(), new Object[0]);
      LayoutInflater.from(paramContext).inflate(2131495725, (ViewGroup)this);
      this.zSZ = ((VoIPRenderTextureView)getRootView().findViewById(2131301719));
      this.gyr = ((ImageView)getRootView().findViewById(2131301715));
      this.zUR = ((TextView)getRootView().findViewById(2131299430));
      this.qvj = new Paint();
      paramContext = this.qvj;
      if (paramContext != null) {
        paramContext.setColor(-16777216);
      }
      paramContext = this.qvj;
      if (paramContext != null) {
        paramContext.setFilterBitmap(false);
      }
      paramContext = this.qvj;
      if (paramContext != null) {
        paramContext.setTextSize(40.0F);
      }
      this.zUU = new b();
      AppMethodBeat.o(239889);
      return;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(239888);
    if (paramb != null) {}
    for (Object localObject1 = paramb.zUW;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = paramb.zUW;
        if (localObject1 == null) {
          kotlin.g.b.p.hyc();
        }
        if (!((Bitmap)localObject1).isRecycled())
        {
          Object localObject2 = this.username;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = paramb.zUW;
          if (localObject2 == null) {
            kotlin.g.b.p.hyc();
          }
          a((String)localObject1, (Bitmap)localObject2, paramb.zUX, paramb.zUY);
        }
      }
      AppMethodBeat.o(239888);
      return;
    }
  }
  
  public final void a(String paramString, final Bitmap paramBitmap, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(239880);
    kotlin.g.b.p.h(paramString, "userName");
    kotlin.g.b.p.h(paramBitmap, "bm");
    h.RTc.aV((Runnable)new d(this, paramBitmap, paramInt1, paramInt2));
    AppMethodBeat.o(239880);
  }
  
  public final void eN(String paramString, int paramInt)
  {
    AppMethodBeat.i(239886);
    Log.i("MicroMsg.MultitalkFrameView", "changeUser from %s to %s", new Object[] { this.username, paramString });
    this.username = paramString;
    Object localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    kotlin.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(paramString);
    if (localObject != null) {}
    for (this.nickName = ((as)localObject).arI();; this.nickName = paramString)
    {
      this.mId = paramInt;
      AppMethodBeat.o(239886);
      return;
    }
  }
  
  public final void emz()
  {
    AppMethodBeat.i(239881);
    Object localObject = this.gyr;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.zSZ;
    if (localObject != null)
    {
      ((VoIPRenderTextureView)localObject).setVisibility(8);
      AppMethodBeat.o(239881);
      return;
    }
    AppMethodBeat.o(239881);
  }
  
  public final boolean enp()
  {
    return this.zUS == MultitalkFrameView.c.zVa;
  }
  
  public final void eoX()
  {
    AppMethodBeat.i(239882);
    if (epc())
    {
      q localq = ac.eom();
      kotlin.g.b.p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      localq.enz();
      ae.a((f)this);
    }
    AppMethodBeat.o(239882);
  }
  
  public final void eoY()
  {
    AppMethodBeat.i(239883);
    if (Util.isNullOrNil(getUsername()))
    {
      AppMethodBeat.o(239883);
      return;
    }
    Log.printInfoStack("MicroMsg.MultitalkFrameView", "changeToAvatar %s from %s", new Object[] { getUsername(), this.zUS.name() });
    this.zUS = MultitalkFrameView.c.zUZ;
    eoX();
    AppMethodBeat.o(239883);
  }
  
  public final void eoZ()
  {
    AppMethodBeat.i(239884);
    Log.printInfoStack("MicroMsg.MultitalkFrameView", "changeToVideo %s from %s", new Object[] { getUsername(), this.zUS.name() });
    this.zUS = MultitalkFrameView.c.zVa;
    a(this.zUU);
    AppMethodBeat.o(239884);
  }
  
  public final void epa()
  {
    this.zUS = MultitalkFrameView.c.zVb;
    this.zUU.zUW = null;
  }
  
  public final void epb()
  {
    AppMethodBeat.i(239885);
    Log.i("MicroMsg.MultitalkFrameView", "changeToNone %s from %s", new Object[] { getUsername(), this.zUS.name() });
    this.zUS = MultitalkFrameView.c.zVc;
    eN("", -1);
    AppMethodBeat.o(239885);
  }
  
  public final boolean epc()
  {
    return this.zUS == MultitalkFrameView.c.zUZ;
  }
  
  public final boolean epd()
  {
    return this.zUS == MultitalkFrameView.c.zVb;
  }
  
  public final void f(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(239879);
      if ((paramBitmap == null) || (paramBitmap.isRecycled()))
      {
        Log.e("MicroMsg.MultitalkFrameView", "DrawBitmap, bitmap is null or recycled");
        com.tencent.mm.plugin.multitalk.model.p.emX();
        AppMethodBeat.o(239879);
      }
      for (;;)
      {
        return;
        if (this.zSZ != null) {
          break;
        }
        AppMethodBeat.o(239879);
      }
      localObject = this.zSZ;
    }
    finally {}
    if (localObject != null) {}
    for (Object localObject = ((VoIPRenderTextureView)localObject).lockCanvas(null);; localObject = null)
    {
      if (localObject == null)
      {
        Log.e("MicroMsg.MultitalkFrameView", "getCanvasError");
        AppMethodBeat.o(239879);
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
              ((Canvas)localObject).drawBitmap(paramBitmap, localMatrix, this.qvj);
              try
              {
                paramBitmap = this.zSZ;
                if (paramBitmap != null) {
                  paramBitmap.unlockCanvasAndPost((Canvas)localObject);
                }
                this.qvm += 1;
                AppMethodBeat.o(239879);
              }
              catch (Exception paramBitmap)
              {
                Log.printErrStackTrace("MicroMsg.MultitalkFrameView", (Throwable)paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                AppMethodBeat.o(239879);
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
  
  public final ImageView getAvatarIv()
  {
    return this.gyr;
  }
  
  public final b getCurrentSnapShot()
  {
    return this.zUU;
  }
  
  public final b getElementPrev()
  {
    return this.zUU;
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
    return this.zUS;
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
    AppMethodBeat.i(239887);
    kotlin.g.b.p.h(paramb, "<set-?>");
    this.zUU = paramb;
    AppMethodBeat.o(239887);
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
    AppMethodBeat.i(239878);
    kotlin.g.b.p.h(paramc, "<set-?>");
    this.zUS = paramc;
    AppMethodBeat.o(239878);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;", "", "()V", "currentBitmap", "Landroid/graphics/Bitmap;", "getCurrentBitmap", "()Landroid/graphics/Bitmap;", "setCurrentBitmap", "(Landroid/graphics/Bitmap;)V", "prevAngle", "", "getPrevAngle", "()I", "setPrevAngle", "(I)V", "prevMirror", "getPrevMirror", "setPrevMirror", "plugin-multitalk_release"})
  public static final class b
  {
    Bitmap zUW;
    int zUX;
    int zUY;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(MultitalkFrameView paramMultitalkFrameView, Bitmap paramBitmap, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(239876);
      Object localObject = MultitalkFrameView.b(this.zVe);
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = MultitalkFrameView.c(this.zVe);
      if (localObject != null) {
        ((VoIPRenderTextureView)localObject).setVisibility(0);
      }
      this.zVe.f(paramBitmap, paramInt1, paramInt2);
      AppMethodBeat.o(239876);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class e
    implements Runnable
  {
    public e(MultitalkFrameView paramMultitalkFrameView) {}
    
    public final void run()
    {
      AppMethodBeat.i(239877);
      Log.i("MicroMsg.MultitalkFrameView", "log location 2");
      MultitalkFrameView.a(this.zVe);
      AppMethodBeat.o(239877);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView
 * JD-Core Version:    0.7.0.1
 */