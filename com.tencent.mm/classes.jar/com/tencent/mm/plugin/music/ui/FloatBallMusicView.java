package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeClickListener", "Landroid/view/View$OnClickListener;", "floatBallViewListener", "com/tencent/mm/plugin/music/ui/FloatBallMusicView$floatBallViewListener$1", "Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$floatBallViewListener$1;", "iconClickListener", "mCoverPath", "", "marginSize", "musicCover", "Landroid/widget/ImageView;", "musicIcon", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "musicIconLayout", "init", "", "loadMusicCover", "coverPath", "onLoadCoverFailed", "refreshLayoutWhenPositionChanged", "isDockerLeft", "", "release", "setCoverPath", "setOnCloseListener", "closeListener", "setOnMusicIconClickListener", "clickListener", "Companion", "RoundCornerBitmapTransformation", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FloatBallMusicView
  extends RelativeLayout
{
  public static final FloatBallMusicView.a LOH;
  private String LMf;
  private MMAnimateView LOI;
  private ImageView LOJ;
  private RelativeLayout LOK;
  private int LOL;
  public final c LOM;
  private View.OnClickListener LON;
  private View.OnClickListener LOO;
  private WeImageView puG;
  
  static
  {
    AppMethodBeat.i(270926);
    LOH = new FloatBallMusicView.a((byte)0);
    AppMethodBeat.o(270926);
  }
  
  public FloatBallMusicView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(270904);
    AppMethodBeat.o(270904);
  }
  
  public FloatBallMusicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(270905);
    AppMethodBeat.o(270905);
  }
  
  public FloatBallMusicView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(270910);
    this.LMf = "";
    this.LOM = new c(this);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(a.g.layout_float_ball_music_view, (ViewGroup)this, true);
    this.LOL = bd.bs(paramContext, a.c.Edge_A);
    this.LOI = ((MMAnimateView)paramAttributeSet.findViewById(a.e.music_icon));
    this.LOJ = ((ImageView)paramAttributeSet.findViewById(a.e.music_cover));
    this.LOK = ((RelativeLayout)paramAttributeSet.findViewById(a.e.music_icon_layout));
    this.puG = ((WeImageView)paramAttributeSet.findViewById(a.e.music_close_button));
    paramContext = this.LOI;
    if (paramContext != null) {
      paramContext.setImageResource(a.d.float_ball_music_view_icon);
    }
    paramContext = this.LOJ;
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
    paramContext = this.LOK;
    if (paramContext != null) {
      paramContext.setOnClickListener(new FloatBallMusicView..ExternalSyntheticLambda1(this));
    }
    paramContext = this.puG;
    if (paramContext != null) {
      paramContext.setOnClickListener(new FloatBallMusicView..ExternalSyntheticLambda0(this));
    }
    zN(((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).cXP());
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).a((g)this.LOM);
    paramContext = this.puG;
    if (paramContext != null) {
      paramContext.setContentDescription((CharSequence)getResources().getString(a.h.talkback_music_video_close_btn));
    }
    paramContext = this.LOK;
    if (paramContext != null) {
      paramContext.setImportantForAccessibility(4);
    }
    AppMethodBeat.o(270910);
  }
  
  private static final void a(FloatBallMusicView paramFloatBallMusicView, View paramView)
  {
    AppMethodBeat.i(270913);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFloatBallMusicView);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/music/ui/FloatBallMusicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFloatBallMusicView, "this$0");
    paramFloatBallMusicView = paramFloatBallMusicView.LOO;
    if (paramFloatBallMusicView != null) {
      paramFloatBallMusicView.onClick(paramView);
    }
    a.a(new Object(), "com/tencent/mm/plugin/music/ui/FloatBallMusicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(270913);
  }
  
  private static final void b(FloatBallMusicView paramFloatBallMusicView, View paramView)
  {
    AppMethodBeat.i(270915);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFloatBallMusicView);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/music/ui/FloatBallMusicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFloatBallMusicView, "this$0");
    paramFloatBallMusicView = paramFloatBallMusicView.LON;
    if (paramFloatBallMusicView != null) {
      paramFloatBallMusicView.onClick(paramView);
    }
    a.a(new Object(), "com/tencent/mm/plugin/music/ui/FloatBallMusicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(270915);
  }
  
  private final void goL()
  {
    AppMethodBeat.i(270912);
    Log.e("MicroMsg.FloatBallMusicView", "alvinluo loadMusicCover failed");
    Object localObject = this.LOK;
    if (localObject != null) {
      ((RelativeLayout)localObject).setBackgroundResource(a.d.float_ball_music_view_grey_bg);
    }
    localObject = this.LOJ;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    AppMethodBeat.o(270912);
  }
  
  public final void setCoverPath(String paramString)
  {
    AppMethodBeat.i(270949);
    Object localObject;
    if (!s.p(this.LMf, paramString))
    {
      if (paramString == null)
      {
        localObject = "";
        this.LMf = ((String)localObject);
        localObject = (CharSequence)paramString;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label69;
        }
      }
      label69:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label74;
        }
        goL();
        AppMethodBeat.o(270949);
        return;
        localObject = paramString;
        break;
      }
      label74:
      localObject = new ah.f();
      ((ah.f)localObject).aqH = "";
      if ((n.U(paramString, "http", false)) || (n.U(paramString, "https", false))) {
        break label230;
      }
      paramString = y.n(paramString, false);
      if (!y.ZC(paramString))
      {
        Log.e("MicroMsg.FloatBallMusicView", "alvinluo setCoverPath file not exist %s", new Object[] { paramString });
        goL();
        AppMethodBeat.o(270949);
        return;
      }
    }
    label230:
    for (((ah.f)localObject).aqH = s.X("file://", paramString);; ((ah.f)localObject).aqH = paramString)
    {
      Log.v("MicroMsg.FloatBallMusicView", s.X("alvinluo loadMusicCover url: ", ((ah.f)localObject).aqH));
      paramString = com.tencent.mm.modelappbrand.a.b.bEY();
      b.k localk = (b.k)new d(this, (ah.f)localObject);
      localObject = (String)((ah.f)localObject).aqH;
      FloatBallMusicView.b.a locala = FloatBallMusicView.b.LOP;
      paramString.a(localk, (String)localObject, (b.h)FloatBallMusicView.b.goM());
      AppMethodBeat.o(270949);
      return;
    }
  }
  
  public final void setOnCloseListener(View.OnClickListener paramOnClickListener)
  {
    this.LON = paramOnClickListener;
  }
  
  public final void setOnMusicIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.LOO = paramOnClickListener;
  }
  
  public final void zN(boolean paramBoolean)
  {
    ah localah1 = null;
    AppMethodBeat.i(270940);
    Object localObject2 = this.LOK;
    if (localObject2 != null)
    {
      localObject1 = this.LOK;
      if (localObject1 == null)
      {
        localObject1 = null;
        ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    else
    {
      localObject2 = this.puG;
      if (localObject2 != null)
      {
        localObject1 = this.puG;
        if (localObject1 != null) {
          break label181;
        }
      }
    }
    for (Object localObject1 = localah1;; localObject1 = localah1)
    {
      ((WeImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(270940);
      return;
      localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      if ((localObject1 instanceof RelativeLayout.LayoutParams))
      {
        if (!paramBoolean) {
          break label141;
        }
        ((RelativeLayout.LayoutParams)localObject1).removeRule(20);
        ((RelativeLayout.LayoutParams)localObject1).addRule(21);
        ((RelativeLayout.LayoutParams)localObject1).setMarginStart(0);
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(this.LOL);
      }
      for (;;)
      {
        ah localah2 = ah.aiuX;
        break;
        label141:
        ((RelativeLayout.LayoutParams)localObject1).removeRule(21);
        ((RelativeLayout.LayoutParams)localObject1).addRule(20);
        ((RelativeLayout.LayoutParams)localObject1).setMarginStart(this.LOL);
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
      }
      label181:
      localObject1 = ((WeImageView)localObject1).getLayoutParams();
      if (localObject1 != null) {
        break label195;
      }
    }
    label195:
    if ((localObject1 instanceof RelativeLayout.LayoutParams))
    {
      if (!paramBoolean) {
        break label231;
      }
      ((RelativeLayout.LayoutParams)localObject1).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject1).addRule(20);
    }
    for (;;)
    {
      localah1 = ah.aiuX;
      break;
      label231:
      ((RelativeLayout.LayoutParams)localObject1).removeRule(20);
      ((RelativeLayout.LayoutParams)localObject1).addRule(21);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/music/ui/FloatBallMusicView$floatBallViewListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "onBallPositionChanged", "", "x", "", "y", "height", "isSettled", "", "isDockLeft", "collapseState", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.ball.c.h
  {
    c(FloatBallMusicView paramFloatBallMusicView) {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
    {
      AppMethodBeat.i(270919);
      super.a(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4);
      this.LOR.zN(paramBoolean2);
      AppMethodBeat.o(270919);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/music/ui/FloatBallMusicView$loadMusicCover$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements b.k
  {
    d(FloatBallMusicView paramFloatBallMusicView, ah.f<String> paramf) {}
    
    public final void bFg() {}
    
    public final void bFh()
    {
      AppMethodBeat.i(369745);
      FloatBallMusicView.c(this.LOR);
      AppMethodBeat.o(369745);
    }
    
    public final String key()
    {
      return (String)this.LOS.aqH;
    }
    
    public final void onBitmapLoaded(Bitmap paramBitmap)
    {
      AppMethodBeat.i(270921);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        Object localObject = FloatBallMusicView.a(this.LOR);
        if (localObject != null) {
          ((RelativeLayout)localObject).setBackgroundResource(a.d.transparent_background);
        }
        localObject = FloatBallMusicView.b(this.LOR);
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = FloatBallMusicView.b(this.LOR);
        if (localObject != null)
        {
          ((ImageView)localObject).setImageBitmap(paramBitmap);
          AppMethodBeat.o(270921);
        }
      }
      else
      {
        FloatBallMusicView.c(this.LOR);
      }
      AppMethodBeat.o(270921);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.FloatBallMusicView
 * JD-Core Version:    0.7.0.1
 */