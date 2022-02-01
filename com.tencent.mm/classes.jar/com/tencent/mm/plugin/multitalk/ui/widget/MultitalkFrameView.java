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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.ae;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "avatarIv", "Landroid/widget/ImageView;", "container", "Landroid/widget/RelativeLayout;", "debugInfo", "Landroid/widget/TextView;", "drawPaint", "Landroid/graphics/Paint;", "elementPrev", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;", "getElementPrev", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;", "setElementPrev", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "mILinkMode", "", "mId", "getMId", "setMId", "mPrevBitmap", "Landroid/graphics/Bitmap;", "mPrevBitmapAngle", "mPrevBitmapMirror", "mRecvFps", "mShowDebugInfo", "mVideoHeight", "mVideoWidth", "nickName", "", "position", "getPosition", "setPosition", "renderView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;", "getStatus", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;", "setStatus", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;)V", "username", "changeToAvatar", "", "changeToNone", "changeToScreenCast", "changeToVideo", "changeUser", "mid", "drawAvatar", "drawBitmap", "bitmap", "angle", "mirror", "canvas", "Landroid/graphics/Canvas;", "pureDraw", "userName", "bm", "drawBitmapPrev", "drawPrevBitmap", "drawVideo", "img", "finish", "getAvatarIv", "getBitmapMatrix", "Landroid/graphics/Matrix;", "displayWidth", "displayHeight", "bmWidth", "bmHeight", "getCurrentSnapShot", "getNickName", "getUsername", "isAvatarMode", "isScreenCast", "isVideoMode", "refreshDebugInfo", "refreshView", "showVideoInfo", "updateAvatarBitmap", "Companion", "PrevBitmapDataClass", "Status", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultitalkFrameView
  extends FrameLayout
  implements f
{
  public static final MultitalkFrameView.a LwE;
  private VoIPRenderTextureView LuO;
  private RelativeLayout LwF;
  private TextView LwG;
  private MultitalkFrameView.c LwH;
  private boolean LwI;
  private b LwJ;
  private int index;
  private ImageView lKK;
  private int mId;
  private int mVideoHeight;
  private int mVideoWidth;
  private String nickName;
  private int position;
  private String username;
  private Paint wXu;
  private int wXx;
  private boolean wXy;
  
  static
  {
    AppMethodBeat.i(285530);
    LwE = new MultitalkFrameView.a((byte)0);
    AppMethodBeat.o(285530);
  }
  
  public MultitalkFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(285502);
    this.LwH = MultitalkFrameView.c.LwP;
    if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {}
    for (boolean bool = true;; bool = false)
    {
      this.wXy = bool;
      this.mId = -1;
      this.LwI = ac.ggS().gfV();
      this.mVideoWidth = getMeasuredWidth();
      this.mVideoHeight = getMeasuredHeight();
      Log.printInfoStack("MicroMsg.MultitalkFrameView", s.X("MultitalkFrameView init ", Integer.valueOf(hashCode())), new Object[0]);
      LayoutInflater.from(paramContext).inflate(a.f.multitalk_frame_layout, (ViewGroup)this);
      this.LwF = ((RelativeLayout)getRootView().findViewById(a.e.multitalk_frame_container));
      this.LuO = ((VoIPRenderTextureView)getRootView().findViewById(a.e.frame_video));
      this.lKK = ((ImageView)getRootView().findViewById(a.e.frame_avatar));
      this.LwG = ((TextView)getRootView().findViewById(a.e.debug_info));
      this.wXu = new Paint();
      paramContext = this.wXu;
      if (paramContext != null) {
        paramContext.setColor(-16777216);
      }
      paramContext = this.wXu;
      if (paramContext != null) {
        paramContext.setFilterBitmap(false);
      }
      paramContext = this.wXu;
      if (paramContext != null) {
        paramContext.setTextSize(40.0F);
      }
      this.LwJ = new b();
      AppMethodBeat.o(285502);
      return;
    }
  }
  
  private static final void a(MultitalkFrameView paramMultitalkFrameView)
  {
    AppMethodBeat.i(285521);
    s.u(paramMultitalkFrameView, "this$0");
    Log.i("MicroMsg.MultitalkFrameView", "log location 2");
    TextView localTextView = paramMultitalkFrameView.LwG;
    if (localTextView != null) {
      localTextView.setText((CharSequence)kotlin.n.n.bJB("\n            mid: " + paramMultitalkFrameView.mId + "\n            fps: " + paramMultitalkFrameView.wXx + "\n            size: " + paramMultitalkFrameView.mVideoWidth + 'x' + paramMultitalkFrameView.mVideoHeight + "\n            isILink: " + paramMultitalkFrameView.LwI + "\n            "));
    }
    paramMultitalkFrameView.wXx = 0;
    AppMethodBeat.o(285521);
  }
  
  private static final void a(MultitalkFrameView paramMultitalkFrameView, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(285525);
    s.u(paramMultitalkFrameView, "this$0");
    s.u(paramBitmap, "$bm");
    Object localObject = paramMultitalkFrameView.lKK;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = paramMultitalkFrameView.LuO;
    if (localObject != null) {
      ((VoIPRenderTextureView)localObject).setVisibility(0);
    }
    paramMultitalkFrameView.f(paramBitmap, paramInt1, paramInt2);
    AppMethodBeat.o(285525);
  }
  
  private void f(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(285509);
      if ((paramBitmap == null) || (paramBitmap.isRecycled()))
      {
        Log.e("MicroMsg.MultitalkFrameView", "DrawBitmap, bitmap is null or recycled");
        o.gfG();
        AppMethodBeat.o(285509);
      }
      for (;;)
      {
        return;
        if (this.LuO != null) {
          break;
        }
        AppMethodBeat.o(285509);
      }
      localObject = this.LuO;
    }
    finally {}
    if (localObject == null) {}
    for (Object localObject = null;; localObject = ((VoIPRenderTextureView)localObject).lockCanvas(null))
    {
      if (localObject != null) {
        break label107;
      }
      Log.e("MicroMsg.MultitalkFrameView", "getCanvasError");
      AppMethodBeat.o(285509);
      break;
    }
    label107:
    int k = ((Canvas)localObject).getWidth();
    int m = ((Canvas)localObject).getHeight();
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    if ((paramInt1 == OpenGlRender.FLAG_Angle270) || (paramInt1 == 270))
    {
      localMatrix.postTranslate(-j / 2.0F, -i / 2.0F);
      localMatrix.postRotate(270.0F);
      localMatrix.postTranslate(i / 2.0F, j / 2.0F);
      paramInt1 = j;
    }
    for (;;)
    {
      for (;;)
      {
        if (paramInt2 == OpenGlRender.FLAG_Mirror)
        {
          localMatrix.postScale(-1.0F, 1.0F);
          localMatrix.postTranslate(i, 0.0F);
        }
        float f1 = m / k;
        float f2 = paramInt1 / i;
        if (f1 < f2)
        {
          f1 = m / paramInt1;
          localMatrix.postScale(f1, f1);
          localMatrix.postTranslate((k - f1 * i) / 2.0F, 0.0F);
          label291:
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
            ((Canvas)localObject).drawBitmap(paramBitmap, localMatrix, this.wXu);
            try
            {
              paramBitmap = this.LuO;
              if (paramBitmap != null) {
                paramBitmap.unlockCanvasAndPost((Canvas)localObject);
              }
              this.wXx += 1;
              AppMethodBeat.o(285509);
            }
            catch (Exception paramBitmap)
            {
              Log.printErrStackTrace("MicroMsg.MultitalkFrameView", (Throwable)paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
              AppMethodBeat.o(285509);
            }
          }
          if ((paramInt1 != OpenGlRender.FLAG_Angle90) && (paramInt1 != 90)) {
            break label554;
          }
          localMatrix.postTranslate(-j / 2.0F, -i / 2.0F);
          localMatrix.postRotate(90.0F);
          localMatrix.postTranslate(i / 2.0F, j / 2.0F);
          paramInt1 = j;
          continue;
          if (f1 > f2)
          {
            f1 = k / i;
            localMatrix.postScale(f1, f1);
            localMatrix.postTranslate(0.0F, (m - paramInt1 * f1) / 2.0F);
            break label291;
          }
          localMatrix.postScale(k / i, m / paramInt1);
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
      label554:
      paramInt1 = i;
      i = j;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(285675);
    if (paramb == null) {}
    for (Object localObject1 = null;; localObject1 = paramb.currentBitmap)
    {
      if (localObject1 != null)
      {
        localObject1 = paramb.currentBitmap;
        s.checkNotNull(localObject1);
        if (!((Bitmap)localObject1).isRecycled())
        {
          Object localObject2 = this.username;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = paramb.currentBitmap;
          s.checkNotNull(localObject2);
          a((String)localObject1, (Bitmap)localObject2, paramb.LwK, paramb.LwL);
        }
      }
      AppMethodBeat.o(285675);
      return;
    }
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(285583);
    s.u(paramString, "userName");
    s.u(paramBitmap, "bm");
    com.tencent.threadpool.h.ahAA.bk(new MultitalkFrameView..ExternalSyntheticLambda1(this, paramBitmap, paramInt1, paramInt2));
    AppMethodBeat.o(285583);
  }
  
  public final ImageView getAvatarIv()
  {
    return this.lKK;
  }
  
  public final b getCurrentSnapShot()
  {
    return this.LwJ;
  }
  
  public final b getElementPrev()
  {
    return this.LwJ;
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
    return this.LwH;
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
  
  public final boolean gfU()
  {
    return this.LwH == MultitalkFrameView.c.LwN;
  }
  
  public final void gfe()
  {
    AppMethodBeat.i(285589);
    Object localObject = this.lKK;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.LuO;
    if (localObject != null) {
      ((VoIPRenderTextureView)localObject).setVisibility(8);
    }
    AppMethodBeat.o(285589);
  }
  
  public final void gh(String paramString, int paramInt)
  {
    AppMethodBeat.i(285636);
    Log.i("MicroMsg.MultitalkFrameView", "changeUser from %s to %s", new Object[] { this.username, paramString });
    this.username = paramString;
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString);
    if (localau != null) {}
    for (this.nickName = localau.aSU();; this.nickName = paramString)
    {
      this.mId = paramInt;
      paramString = this.LwF;
      if (paramString != null) {
        paramString.setTag(a.e.tag_multi_talk_name, this.nickName);
      }
      AppMethodBeat.o(285636);
      return;
    }
  }
  
  public final void ghK()
  {
    AppMethodBeat.i(285576);
    if (this.wXy) {
      com.tencent.threadpool.h.ahAA.bk(new MultitalkFrameView..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(285576);
  }
  
  public final void ghL()
  {
    AppMethodBeat.i(285609);
    if (ghQ())
    {
      ac.ggS().ggf();
      ae.a((f)this);
    }
    AppMethodBeat.o(285609);
  }
  
  public final void ghM()
  {
    AppMethodBeat.i(285617);
    if (Util.isNullOrNil(getUsername()))
    {
      AppMethodBeat.o(285617);
      return;
    }
    Log.printInfoStack("MicroMsg.MultitalkFrameView", "changeToAvatar %s from %s", new Object[] { getUsername(), this.LwH.name() });
    this.LwH = MultitalkFrameView.c.LwM;
    ghL();
    AppMethodBeat.o(285617);
  }
  
  public final void ghN()
  {
    AppMethodBeat.i(285622);
    Log.printInfoStack("MicroMsg.MultitalkFrameView", "changeToVideo %s from %s", new Object[] { getUsername(), this.LwH.name() });
    this.LwH = MultitalkFrameView.c.LwN;
    a(this.LwJ);
    AppMethodBeat.o(285622);
  }
  
  public final void ghO()
  {
    this.LwH = MultitalkFrameView.c.LwO;
    this.LwJ.currentBitmap = null;
  }
  
  public final void ghP()
  {
    AppMethodBeat.i(285628);
    Log.i("MicroMsg.MultitalkFrameView", "changeToNone %s from %s", new Object[] { getUsername(), this.LwH.name() });
    this.LwH = MultitalkFrameView.c.LwP;
    gh("", -1);
    AppMethodBeat.o(285628);
  }
  
  public final boolean ghQ()
  {
    return this.LwH == MultitalkFrameView.c.LwM;
  }
  
  public final boolean ghR()
  {
    return this.LwH == MultitalkFrameView.c.LwO;
  }
  
  public final void setElementPrev(b paramb)
  {
    AppMethodBeat.i(285665);
    s.u(paramb, "<set-?>");
    this.LwJ = paramb;
    AppMethodBeat.o(285665);
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
    AppMethodBeat.i(285567);
    s.u(paramc, "<set-?>");
    this.LwH = paramc;
    AppMethodBeat.o(285567);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;", "", "()V", "currentBitmap", "Landroid/graphics/Bitmap;", "getCurrentBitmap", "()Landroid/graphics/Bitmap;", "setCurrentBitmap", "(Landroid/graphics/Bitmap;)V", "prevAngle", "", "getPrevAngle", "()I", "setPrevAngle", "(I)V", "prevMirror", "getPrevMirror", "setPrevMirror", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    int LwK;
    int LwL;
    Bitmap currentBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView
 * JD-Core Version:    0.7.0.1
 */