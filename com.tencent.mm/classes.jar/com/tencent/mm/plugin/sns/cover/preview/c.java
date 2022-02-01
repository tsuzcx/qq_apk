package com.tencent.mm.plugin.sns.cover.preview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.cover.a.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/preview/SnsImageBackPreview;", "Lcom/tencent/mm/plugin/sns/cover/api/AbsSnsBackPreview;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "coverFoldImageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCoverFoldImageView", "()Landroid/widget/ImageView;", "coverFoldImageView$delegate", "Lkotlin/Lazy;", "coverInfo", "Lcom/tencent/mm/plugin/sns/cover/api/ISnsCoverInfo;", "snsCoverStatusProvider", "Lcom/tencent/mm/plugin/sns/cover/api/SnsCoverStatusProvider;", "thumbView", "Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverFadeImageView;", "getThumbView", "()Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverFadeImageView;", "thumbView$delegate", "getLayoutId", "", "getType", "loadCover", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onPause", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onResume", "setCoverFoldStatusProvider", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.sns.cover.a.a
{
  public static final c.a Qma;
  private e GIL;
  private final j Gqu;
  private final j Qmb;
  private com.tencent.mm.plugin.sns.cover.a.b Qmc;
  
  static
  {
    AppMethodBeat.i(307472);
    Qma = new c.a((byte)0);
    AppMethodBeat.o(307472);
  }
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(307429);
    this.Gqu = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Qmb = kotlin.k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(307429);
  }
  
  private static final boolean a(c paramc, com.tencent.mm.plugin.sns.cover.a.b paramb, View paramView)
  {
    AppMethodBeat.i(307458);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/cover/preview/SnsImageBackPreview", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramc, "this$0");
    s.u(paramb, "$coverInfo");
    paramView = com.tencent.mm.plugin.sns.cover.edit.b.b.QlB;
    paramc = paramc.getContext();
    s.s(paramc, "context");
    s.u(paramc, "context");
    s.u(paramb, "coverInfo");
    paramView = BitmapUtil.getImageOptions(paramb.gUr());
    paramb = "path:" + paramb.gUr() + "\n width:" + paramView.outWidth + " height:" + paramView.outHeight + " \nsize:" + y.bEl(paramb.gUr());
    paramView = new TextView(paramc);
    paramView.setText((CharSequence)paramb);
    paramView.setGravity(19);
    paramView.setTextSize(1, 10.0F);
    paramView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramView.setTextColor(paramc.getResources().getColor(b.c.FG_0));
    paramView.setTypeface(Typeface.MONOSPACE);
    int i = paramc.getResources().getDimensionPixelSize(b.d.LargePadding);
    paramView.setPadding(i, i, i, i);
    com.tencent.mm.ui.base.k.a(paramc, null, (View)paramView, null);
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/sns/cover/preview/SnsImageBackPreview", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(307458);
    return true;
  }
  
  private final ImageView getCoverFoldImageView()
  {
    AppMethodBeat.i(307446);
    ImageView localImageView = (ImageView)this.Qmb.getValue();
    AppMethodBeat.o(307446);
    return localImageView;
  }
  
  private final SnsCoverFadeImageView getThumbView()
  {
    AppMethodBeat.i(307438);
    SnsCoverFadeImageView localSnsCoverFadeImageView = (SnsCoverFadeImageView)this.Gqu.getValue();
    AppMethodBeat.o(307438);
    return localSnsCoverFadeImageView;
  }
  
  public final void a(final com.tencent.mm.plugin.sns.cover.a.b paramb)
  {
    AppMethodBeat.i(307519);
    s.u(paramb, "coverInfo");
    this.Qmc = paramb;
    getCoverFoldImageView().setImageBitmap(null);
    getThumbView().setSourceDecodeCallback((kotlin.g.a.b)new c(this, paramb));
    Object localObject = this.GIL;
    if (localObject != null)
    {
      localObject = ((e)localObject).getSnsCoverReporter();
      if (localObject != null) {
        ((com.tencent.mm.plugin.sns.cover.a.c)localObject).hep();
      }
    }
    localObject = getThumbView();
    String str = paramb.getUserName();
    s.s(str, "coverInfo.userName");
    Long localLong = paramb.heo();
    s.s(localLong, "coverInfo.snsObjId");
    ((SnsCoverFadeImageView)localObject).b(str, ((Number)localLong).longValue(), paramb.gUr(), true);
    if ((h.baE().ban().getInt(at.a.adgH, 0) == 1) && (WeChatEnvironment.hasDebugger())) {
      setOnLongClickListener(new c..ExternalSyntheticLambda0(this, paramb));
    }
    AppMethodBeat.o(307519);
  }
  
  public final void etL()
  {
    AppMethodBeat.i(307504);
    Log.i("MicroMsg.SnsImageBackPreview", "[onPreOpen]");
    getCoverFoldImageView().setVisibility(4);
    AppMethodBeat.o(307504);
  }
  
  public final void etM()
  {
    AppMethodBeat.i(307501);
    Log.i("MicroMsg.SnsImageBackPreview", "[onPreClose]");
    AppMethodBeat.o(307501);
  }
  
  public final void etO() {}
  
  public final int getLayoutId()
  {
    return b.g.sns_cover_image_preview;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(307523);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.SnsImageBackPreview", "onConfigurationChanged");
    paramConfiguration = this.Qmc;
    if (paramConfiguration != null) {
      a(paramConfiguration);
    }
    AppMethodBeat.o(307523);
  }
  
  public final void onDestroy() {}
  
  public final void onPause() {}
  
  public final void onPostClose()
  {
    AppMethodBeat.i(307514);
    Log.i("MicroMsg.SnsImageBackPreview", "[onPostClose]");
    getCoverFoldImageView().setVisibility(0);
    AppMethodBeat.o(307514);
  }
  
  public final void onResume() {}
  
  public final void setCoverFoldStatusProvider(e parame)
  {
    AppMethodBeat.i(307516);
    super.setCoverFoldStatusProvider(parame);
    this.GIL = parame;
    AppMethodBeat.o(307516);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    c(c paramc, com.tencent.mm.plugin.sns.cover.a.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverFadeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<SnsCoverFadeImageView>
  {
    d(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.preview.c
 * JD-Core Version:    0.7.0.1
 */