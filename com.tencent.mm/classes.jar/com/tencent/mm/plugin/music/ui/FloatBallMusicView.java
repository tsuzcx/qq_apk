package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.u;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeClickListener", "Landroid/view/View$OnClickListener;", "floatBallViewListener", "com/tencent/mm/plugin/music/ui/FloatBallMusicView$floatBallViewListener$1", "Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$floatBallViewListener$1;", "iconClickListener", "mCoverPath", "", "marginSize", "musicCover", "Landroid/widget/ImageView;", "musicIcon", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "musicIconLayout", "init", "", "loadMusicCover", "coverPath", "onLoadCoverFailed", "refreshLayoutWhenPositionChanged", "isDockerLeft", "", "release", "setCoverPath", "setOnCloseListener", "closeListener", "setOnMusicIconClickListener", "clickListener", "Companion", "RoundCornerBitmapTransformation", "plugin-music_release"})
public final class FloatBallMusicView
  extends RelativeLayout
{
  public static final a FTP;
  private String FRj;
  private MMAnimateView FTH;
  private ImageView FTI;
  private RelativeLayout FTJ;
  private WeImageView FTK;
  private int FTL;
  public final c FTM;
  private View.OnClickListener FTN;
  private View.OnClickListener FTO;
  
  static
  {
    AppMethodBeat.i(260097);
    FTP = new a((byte)0);
    AppMethodBeat.o(260097);
  }
  
  public FloatBallMusicView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(260090);
    AppMethodBeat.o(260090);
  }
  
  public FloatBallMusicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(260092);
    AppMethodBeat.o(260092);
  }
  
  public FloatBallMusicView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(260095);
    this.FRj = "";
    this.FTM = new c(this);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(a.g.layout_float_ball_music_view, (ViewGroup)this, true);
    this.FTL = aw.aZ(paramContext, a.c.Edge_A);
    this.FTH = ((MMAnimateView)paramAttributeSet.findViewById(a.e.music_icon));
    this.FTI = ((ImageView)paramAttributeSet.findViewById(a.e.music_cover));
    this.FTJ = ((RelativeLayout)paramAttributeSet.findViewById(a.e.music_icon_layout));
    this.FTK = ((WeImageView)paramAttributeSet.findViewById(a.e.music_close_button));
    paramContext = this.FTH;
    if (paramContext != null) {
      paramContext.setImageResource(a.d.float_ball_music_view_icon);
    }
    paramContext = this.FTI;
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
    paramContext = this.FTJ;
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new d(this));
    }
    paramContext = this.FTK;
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new e(this));
    }
    paramContext = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class);
    p.j(paramContext, "MMKernel.service(IFloatBallService::class.java)");
    vv(((com.tencent.mm.plugin.ball.c.b)paramContext).cvf());
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).a((g)this.FTM);
    AppMethodBeat.o(260095);
  }
  
  private final void ffx()
  {
    AppMethodBeat.i(260088);
    Log.e("MicroMsg.FloatBallMusicView", "alvinluo loadMusicCover failed");
    Object localObject = this.FTJ;
    if (localObject != null) {
      ((RelativeLayout)localObject).setBackgroundResource(a.d.float_ball_music_view_grey_bg);
    }
    localObject = this.FTI;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(8);
      AppMethodBeat.o(260088);
      return;
    }
    AppMethodBeat.o(260088);
  }
  
  public final void setCoverPath(String paramString)
  {
    AppMethodBeat.i(260086);
    if ((p.h(this.FRj, paramString) ^ true)) {
      if (paramString != null) {
        break label249;
      }
    }
    label249:
    for (Object localObject = "";; localObject = paramString)
    {
      this.FRj = ((String)localObject);
      localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        ffx();
        AppMethodBeat.o(260086);
        return;
      }
      localObject = new aa.f();
      ((aa.f)localObject).aaBC = "";
      if ((!n.M(paramString, "http", false)) && (!n.M(paramString, "https", false)))
      {
        paramString = u.n(paramString, false);
        if (!u.agG(paramString))
        {
          Log.e("MicroMsg.FloatBallMusicView", "alvinluo setCoverPath file not exist %s", new Object[] { paramString });
          ffx();
          AppMethodBeat.o(260086);
          return;
        }
      }
      for (((aa.f)localObject).aaBC = "file://".concat(String.valueOf(paramString));; ((aa.f)localObject).aaBC = paramString)
      {
        Log.v("MicroMsg.FloatBallMusicView", "alvinluo loadMusicCover url: " + (String)((aa.f)localObject).aaBC);
        paramString = com.tencent.mm.modelappbrand.a.b.bhh();
        b.k localk = (b.k)new f(this, (aa.f)localObject);
        localObject = (String)((aa.f)localObject).aaBC;
        FloatBallMusicView.b.a locala = b.FTR;
        paramString.a(localk, (String)localObject, (b.h)b.ffy());
        AppMethodBeat.o(260086);
        return;
      }
    }
  }
  
  public final void setOnCloseListener(View.OnClickListener paramOnClickListener)
  {
    this.FTN = paramOnClickListener;
  }
  
  public final void setOnMusicIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.FTO = paramOnClickListener;
  }
  
  public final void vv(boolean paramBoolean)
  {
    AppMethodBeat.i(260079);
    Object localObject2 = this.FTJ;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = this.FTJ;
      if (localObject1 == null) {
        break label194;
      }
      localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
      if (localObject1 == null) {
        break label194;
      }
      if ((localObject1 instanceof RelativeLayout.LayoutParams))
      {
        if (paramBoolean)
        {
          ((RelativeLayout.LayoutParams)localObject1).removeRule(20);
          ((RelativeLayout.LayoutParams)localObject1).addRule(21);
          ((RelativeLayout.LayoutParams)localObject1).setMarginStart(0);
          ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(this.FTL);
        }
      }
      else {
        ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    else
    {
      localObject2 = this.FTK;
      if (localObject2 == null) {
        break label225;
      }
      localObject1 = this.FTK;
      if (localObject1 == null) {
        break label220;
      }
      localObject1 = ((WeImageView)localObject1).getLayoutParams();
      if (localObject1 == null) {
        break label220;
      }
      if ((localObject1 instanceof RelativeLayout.LayoutParams))
      {
        if (!paramBoolean) {
          break label199;
        }
        ((RelativeLayout.LayoutParams)localObject1).removeRule(21);
        ((RelativeLayout.LayoutParams)localObject1).addRule(20);
      }
    }
    for (;;)
    {
      ((WeImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(260079);
      return;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject1).addRule(20);
      ((RelativeLayout.LayoutParams)localObject1).setMarginStart(this.FTL);
      ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
      break;
      label194:
      localObject1 = null;
      break;
      label199:
      ((RelativeLayout.LayoutParams)localObject1).removeRule(20);
      ((RelativeLayout.LayoutParams)localObject1).addRule(21);
      continue;
      label220:
      localObject1 = null;
    }
    label225:
    AppMethodBeat.o(260079);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$Companion;", "", "()V", "TAG", "", "plugin-music_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation;", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "roundRate", "", "(F)V", "getRoundRate", "()F", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "Companion", "plugin-music_release"})
  public static final class b
    implements b.h
  {
    private static final b FTQ;
    public static final a FTR;
    private final float kPA = 0.16F;
    
    static
    {
      AppMethodBeat.i(259401);
      FTR = new a((byte)0);
      FTQ = new b();
      AppMethodBeat.o(259401);
    }
    
    public final Bitmap H(Bitmap paramBitmap)
    {
      AppMethodBeat.i(259399);
      p.k(paramBitmap, "bitmap");
      if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
      {
        AppMethodBeat.o(259399);
        return paramBitmap;
      }
      try
      {
        Object localObject;
        if (paramBitmap.getWidth() == paramBitmap.getHeight()) {
          localObject = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, paramBitmap.getWidth() * this.kPA);
        }
        while (localObject != null)
        {
          AppMethodBeat.o(259399);
          return localObject;
          int j = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
          int i = j;
          if (j <= 0) {
            i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
          }
          Bitmap localBitmap = BitmapUtil.getCenterCropBitmap(paramBitmap, i, i, true);
          localObject = localBitmap;
          if (localBitmap != null) {
            localObject = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth() * this.kPA);
          }
        }
        return paramBitmap;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallMusicView", (Throwable)localException, "getRoundBitmap exception", new Object[0]);
        AppMethodBeat.o(259399);
      }
    }
    
    public final String key()
    {
      return "FloatBallMusicCover";
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation;", "getINSTANCE", "()Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation;", "plugin-music_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/music/ui/FloatBallMusicView$floatBallViewListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "onBallPositionChanged", "", "x", "", "y", "height", "isSettled", "", "isDockLeft", "plugin-music_release"})
  public static final class c
    extends com.tencent.mm.plugin.ball.c.h
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(260360);
      super.a(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
      this.FTS.vv(paramBoolean2);
      AppMethodBeat.o(260360);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FloatBallMusicView paramFloatBallMusicView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(259680);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/music/ui/FloatBallMusicView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = FloatBallMusicView.a(this.FTS);
      if (localObject != null) {
        ((View.OnClickListener)localObject).onClick(paramView);
      }
      a.a(this, "com/tencent/mm/plugin/music/ui/FloatBallMusicView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(259680);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FloatBallMusicView paramFloatBallMusicView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(259473);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/music/ui/FloatBallMusicView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = FloatBallMusicView.b(this.FTS);
      if (localObject != null) {
        ((View.OnClickListener)localObject).onClick(paramView);
      }
      a.a(this, "com/tencent/mm/plugin/music/ui/FloatBallMusicView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(259473);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/music/ui/FloatBallMusicView$loadMusicCover$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-music_release"})
  public static final class f
    implements b.k
  {
    f(aa.f paramf) {}
    
    public final void G(Bitmap paramBitmap)
    {
      AppMethodBeat.i(259641);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        Object localObject = FloatBallMusicView.c(this.FTS);
        if (localObject != null) {
          ((RelativeLayout)localObject).setBackgroundResource(a.d.transparent_background);
        }
        localObject = FloatBallMusicView.d(this.FTS);
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = FloatBallMusicView.d(this.FTS);
        if (localObject != null)
        {
          ((ImageView)localObject).setImageBitmap(paramBitmap);
          AppMethodBeat.o(259641);
          return;
        }
        AppMethodBeat.o(259641);
        return;
      }
      FloatBallMusicView.e(this.FTS);
      AppMethodBeat.o(259641);
    }
    
    public final void bhq() {}
    
    public final void bhr()
    {
      AppMethodBeat.i(292975);
      FloatBallMusicView.e(this.FTS);
      AppMethodBeat.o(292975);
    }
    
    public final String key()
    {
      return (String)this.FTT.aaBC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.FloatBallMusicView
 * JD-Core Version:    0.7.0.1
 */