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
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.ball.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeClickListener", "Landroid/view/View$OnClickListener;", "floatBallViewListener", "com/tencent/mm/plugin/music/ui/FloatBallMusicView$floatBallViewListener$1", "Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$floatBallViewListener$1;", "iconClickListener", "mCoverPath", "", "marginSize", "musicCover", "Landroid/widget/ImageView;", "musicIcon", "musicIconLayout", "init", "", "loadMusicCover", "coverPath", "onLoadCoverFailed", "refreshLayoutWhenPositionChanged", "isDockerLeft", "", "release", "setCoverPath", "setOnCloseListener", "closeListener", "setOnMusicIconClickListener", "clickListener", "Companion", "RoundCornerBitmapTransformation", "plugin-music_release"})
public final class FloatBallMusicView
  extends RelativeLayout
{
  public static final FloatBallMusicView.a AmI;
  private String Akf;
  private ImageView AmB;
  private RelativeLayout AmC;
  private WeImageView AmD;
  private int AmE;
  public final c AmF;
  private View.OnClickListener AmG;
  private View.OnClickListener AmH;
  private WeImageView uPJ;
  
  static
  {
    AppMethodBeat.i(220010);
    AmI = new FloatBallMusicView.a((byte)0);
    AppMethodBeat.o(220010);
  }
  
  public FloatBallMusicView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(220007);
    AppMethodBeat.o(220007);
  }
  
  public FloatBallMusicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(220008);
    AppMethodBeat.o(220008);
  }
  
  public FloatBallMusicView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220009);
    this.Akf = "";
    this.AmF = new c(this);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131495172, (ViewGroup)this, true);
    this.AmE = at.aH(paramContext, 2131165314);
    this.uPJ = ((WeImageView)paramAttributeSet.findViewById(2131305092));
    this.AmB = ((ImageView)paramAttributeSet.findViewById(2131305088));
    this.AmC = ((RelativeLayout)paramAttributeSet.findViewById(2131305094));
    this.AmD = ((WeImageView)paramAttributeSet.findViewById(2131305086));
    paramContext = this.uPJ;
    if (paramContext != null) {
      paramContext.setImageResource(2131690621);
    }
    paramContext = this.AmB;
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
    paramContext = this.AmC;
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new FloatBallMusicView.d(this));
    }
    paramContext = this.AmD;
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new FloatBallMusicView.e(this));
    }
    paramContext = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class);
    p.g(paramContext, "MMKernel.service(IFloatBallService::class.java)");
    sp(((com.tencent.mm.plugin.ball.c.b)paramContext).chT());
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).a((com.tencent.mm.plugin.ball.c.g)this.AmF);
    AppMethodBeat.o(220009);
  }
  
  private final void evd()
  {
    AppMethodBeat.i(220006);
    Log.e("MicroMsg.FloatBallMusicView", "alvinluo loadMusicCover failed");
    Object localObject = this.AmC;
    if (localObject != null) {
      ((RelativeLayout)localObject).setBackgroundResource(2131232766);
    }
    localObject = this.AmB;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(8);
      AppMethodBeat.o(220006);
      return;
    }
    AppMethodBeat.o(220006);
  }
  
  public final void setCoverPath(String paramString)
  {
    AppMethodBeat.i(220005);
    if ((p.j(this.Akf, paramString) ^ true)) {
      if (paramString != null) {
        break label238;
      }
    }
    label238:
    for (Object localObject1 = "";; localObject1 = paramString)
    {
      this.Akf = ((String)localObject1);
      localObject1 = (CharSequence)paramString;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        evd();
        AppMethodBeat.o(220005);
        return;
      }
      Object localObject2 = new z.f();
      ((z.f)localObject2).SYG = "";
      if ((!n.J(paramString, "http", false)) && (!n.J(paramString, "https", false))) {
        if (!s.YS(paramString))
        {
          Log.e("MicroMsg.FloatBallMusicView", "alvinluo setCoverPath file not exist");
          evd();
          AppMethodBeat.o(220005);
          return;
        }
      }
      for (((z.f)localObject2).SYG = "file://".concat(String.valueOf(paramString));; ((z.f)localObject2).SYG = paramString)
      {
        Log.v("MicroMsg.FloatBallMusicView", "alvinluo loadMusicCover url: " + (String)((z.f)localObject2).SYG);
        paramString = com.tencent.mm.modelappbrand.a.b.aXY();
        localObject1 = (b.k)new f(this, (z.f)localObject2);
        localObject2 = (String)((z.f)localObject2).SYG;
        FloatBallMusicView.b.a locala = FloatBallMusicView.b.AmK;
        paramString.a((b.k)localObject1, (String)localObject2, (b.h)FloatBallMusicView.b.eve());
        AppMethodBeat.o(220005);
        return;
      }
    }
  }
  
  public final void setOnCloseListener(View.OnClickListener paramOnClickListener)
  {
    this.AmG = paramOnClickListener;
  }
  
  public final void setOnMusicIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.AmH = paramOnClickListener;
  }
  
  public final void sp(boolean paramBoolean)
  {
    AppMethodBeat.i(220004);
    Object localObject2 = this.AmC;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = this.AmC;
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
          ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(this.AmE);
        }
      }
      else {
        ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    else
    {
      localObject2 = this.AmD;
      if (localObject2 == null) {
        break label225;
      }
      localObject1 = this.AmD;
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
      AppMethodBeat.o(220004);
      return;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject1).addRule(20);
      ((RelativeLayout.LayoutParams)localObject1).setMarginStart(this.AmE);
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
    AppMethodBeat.o(220004);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/music/ui/FloatBallMusicView$floatBallViewListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "onBallPositionChanged", "", "x", "", "y", "height", "isSettled", "", "isDockLeft", "plugin-music_release"})
  public static final class c
    extends h
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(219999);
      super.a(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
      this.AmL.sp(paramBoolean2);
      AppMethodBeat.o(219999);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/music/ui/FloatBallMusicView$loadMusicCover$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-music_release"})
  public static final class f
    implements b.k
  {
    f(z.f paramf) {}
    
    public final void I(Bitmap paramBitmap)
    {
      AppMethodBeat.i(220002);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        Object localObject = FloatBallMusicView.c(this.AmL);
        if (localObject != null) {
          ((RelativeLayout)localObject).setBackgroundResource(2131235359);
        }
        localObject = FloatBallMusicView.d(this.AmL);
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = FloatBallMusicView.d(this.AmL);
        if (localObject != null)
        {
          ((ImageView)localObject).setImageBitmap(paramBitmap);
          AppMethodBeat.o(220002);
          return;
        }
        AppMethodBeat.o(220002);
        return;
      }
      FloatBallMusicView.e(this.AmL);
      AppMethodBeat.o(220002);
    }
    
    public final String Lb()
    {
      return (String)this.AmM.SYG;
    }
    
    public final void aYg() {}
    
    public final void oD()
    {
      AppMethodBeat.i(258342);
      FloatBallMusicView.e(this.AmL);
      AppMethodBeat.o(258342);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.FloatBallMusicView
 * JD-Core Version:    0.7.0.1
 */