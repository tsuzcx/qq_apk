package com.tencent.mm.plugin.sns.cover.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.cover.a.c;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.r.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverFadeImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "snsCoverReporter", "Lcom/tencent/mm/plugin/sns/cover/api/ISnsCoverReporter;", "getSnsCoverReporter", "()Lcom/tencent/mm/plugin/sns/cover/api/ISnsCoverReporter;", "setSnsCoverReporter", "(Lcom/tencent/mm/plugin/sns/cover/api/ISnsCoverReporter;)V", "sourceDecodeCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "source", "", "getSourceDecodeCallback", "()Lkotlin/jvm/functions/Function1;", "setSourceDecodeCallback", "(Lkotlin/jvm/functions/Function1;)V", "blurBitmap", "bitmap", "width", "", "height", "centerCropImage", "Lkotlin/Pair;", "", "decodeImg", "filePath", "", "setImageBitmapWithFade", "setImagePath", "userName", "snsId", "", "path", "centerCrop", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsCoverFadeImageView
  extends AppCompatImageView
{
  public static final SnsCoverFadeImageView.a QlT;
  private kotlin.g.a.b<? super Bitmap, ah> QlU;
  private c QlV;
  
  static
  {
    AppMethodBeat.i(307553);
    QlT = new SnsCoverFadeImageView.a((byte)0);
    AppMethodBeat.o(307553);
  }
  
  public SnsCoverFadeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(307524);
    setScaleType(ImageView.ScaleType.CENTER_CROP);
    AppMethodBeat.o(307524);
  }
  
  private static final void a(String paramString1, long paramLong, String paramString2, SnsCoverFadeImageView paramSnsCoverFadeImageView, boolean paramBoolean1, String paramString3, boolean paramBoolean2, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(307551);
    s.u(paramString1, "$userName");
    s.u(paramString2, "$localPath");
    s.u(paramSnsCoverFadeImageView, "this$0");
    if (paramBoolean2)
    {
      al.hgG().h(paramString1, paramLong, paramString2);
      paramSnsCoverFadeImageView.cT(paramString2, paramBoolean1);
      AppMethodBeat.o(307551);
      return;
    }
    Log.e("MicroMsg.SnsCoverFadeImageView", s.X("downloadImage error:", paramString3));
    AppMethodBeat.o(307551);
  }
  
  private final kotlin.r<Bitmap, Boolean> aK(Bitmap paramBitmap)
  {
    AppMethodBeat.i(307538);
    int i = com.tencent.mm.cd.a.br(getContext(), b.d.sns_cover_fold_height);
    int j = com.tencent.mm.cd.a.ms(getContext());
    float f1 = i / j;
    if (f1 > paramBitmap.getHeight() / paramBitmap.getWidth())
    {
      paramBitmap = new kotlin.r(BitmapUtil.getCenterCropBitmap(paramBitmap, (int)(paramBitmap.getHeight() / f1), paramBitmap.getHeight(), false), Boolean.TRUE);
      AppMethodBeat.o(307538);
      return paramBitmap;
    }
    float f2 = paramBitmap.getWidth();
    paramBitmap = new kotlin.r(BitmapUtil.getCenterCropBitmap(paramBitmap, paramBitmap.getWidth(), (int)(f2 * f1), false), Boolean.FALSE);
    AppMethodBeat.o(307538);
    return paramBitmap;
  }
  
  private static Bitmap aXb(String paramString)
  {
    AppMethodBeat.i(307541);
    Bitmap localBitmap2 = BitmapUtil.decodeFileWithSample(paramString);
    Bitmap localBitmap1 = localBitmap2;
    int i;
    int j;
    int k;
    if (localBitmap2 != null)
    {
      i = localBitmap2.getWidth();
      j = localBitmap2.getHeight();
      k = ForceGpuUtil.getMaxTextureSize();
      if (i <= k) {
        break label72;
      }
      localBitmap1 = BitmapUtil.getCenterCropBitmap(localBitmap2, k, localBitmap2.getHeight(), true);
    }
    for (;;)
    {
      i = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString);
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(307541);
      return localBitmap1;
      label72:
      localBitmap1 = localBitmap2;
      if (j > k) {
        localBitmap1 = BitmapUtil.getCenterCropBitmap(localBitmap2, localBitmap2.getWidth(), k, true);
      }
    }
    paramString = BitmapUtil.rotateAndScale(localBitmap1, i, 1.0F, 1.0F);
    AppMethodBeat.o(307541);
    return paramString;
  }
  
  private final void cT(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(307533);
    paramString = aXb(paramString);
    if (paramString != null)
    {
      if (paramBoolean)
      {
        kotlin.r localr = aK(paramString);
        final Bitmap localBitmap = (Bitmap)localr.bsC;
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, localBitmap));
        if (((Boolean)localr.bsD).booleanValue())
        {
          h(localBitmap, localBitmap.getWidth(), (int)(localBitmap.getWidth() * 1.777778F));
          AppMethodBeat.o(307533);
          return;
        }
      }
      if (paramString.getHeight() * 1.0F / paramString.getWidth() < 1.777778F)
      {
        h(paramString, paramString.getWidth(), (int)(paramString.getWidth() * 1.777778F));
        AppMethodBeat.o(307533);
        return;
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, paramString));
    }
    AppMethodBeat.o(307533);
  }
  
  private final void h(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(307546);
    Object localObject = com.tencent.mm.plugin.expansions.b.yFu;
    if (!com.tencent.mm.plugin.expansions.b.isInstalled("xlab"))
    {
      Log.w("MicroMsg.SnsCoverFadeImageView", "Expansions not yet installed, drop blurBitmap");
      AppMethodBeat.o(307546);
      return;
    }
    localObject = com.tencent.mm.plugin.expansions.b.yFu;
    com.tencent.mm.plugin.expansions.b.tryLoadLibrary("xlabeffect");
    localObject = com.tencent.mm.plugin.expansions.b.yFu;
    com.tencent.mm.plugin.expansions.b.tryLoadLibrary("pag");
    localObject = new com.tencent.mm.videocomposition.effect.a();
    ((com.tencent.mm.videocomposition.effect.a)localObject).HkF.agEB.scene = 1;
    ((com.tencent.mm.videocomposition.effect.a)localObject).setInputBitmap(paramBitmap);
    ((com.tencent.mm.videocomposition.effect.a)localObject).setOutputSize(paramInt1, paramInt2);
    ((com.tencent.mm.videocomposition.effect.a)localObject).HkF.GpO.jQk();
    ((com.tencent.mm.videocomposition.effect.a)localObject).aW((kotlin.g.a.b)new b(this));
    AppMethodBeat.o(307546);
  }
  
  public final void b(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(307572);
    s.u(paramString1, "userName");
    Log.i("MicroMsg.SnsCoverFadeImageView", s.X("SnsCoverFadeImageView load cover,imagePath:", paramString2));
    if ((paramString2 != null) && (n.U(paramString2, "http", false) == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Object localObject = this.QlV;
      if (localObject != null) {
        ((c)localObject).DA(false);
      }
      localObject = com.tencent.mm.plugin.sns.storage.r.QYI;
      localObject = r.a.aZO(paramString1);
      com.tencent.mm.modelimage.loader.a locala = com.tencent.mm.modelimage.r.bKe();
      c.a locala1 = new c.a();
      locala1.fullPath = ((String)localObject);
      locala1.oKp = true;
      locala.a(paramString2, locala1.bKx(), new SnsCoverFadeImageView..ExternalSyntheticLambda0(paramString1, paramLong, (String)localObject, this, paramBoolean, paramString2));
      AppMethodBeat.o(307572);
      return;
    }
    paramString1 = this.QlV;
    if (paramString1 != null) {
      paramString1.DA(true);
    }
    cT(paramString2, paramBoolean);
    AppMethodBeat.o(307572);
  }
  
  public final c getSnsCoverReporter()
  {
    return this.QlV;
  }
  
  public final kotlin.g.a.b<Bitmap, ah> getSourceDecodeCallback()
  {
    return this.QlU;
  }
  
  public final void setImageBitmapWithFade(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(307574);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(307574);
      return;
    }
    if (paramBitmap.getHeight() * 1.0F / paramBitmap.getWidth() < 1.777778F)
    {
      h(paramBitmap, paramBitmap.getWidth(), (int)(paramBitmap.getWidth() * 1.777778F));
      AppMethodBeat.o(307574);
      return;
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramBitmap));
    AppMethodBeat.o(307574);
  }
  
  public final void setSnsCoverReporter(c paramc)
  {
    this.QlV = paramc;
  }
  
  public final void setSourceDecodeCallback(kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    this.QlU = paramb;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "effectBitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    b(SnsCoverFadeImageView paramSnsCoverFadeImageView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(SnsCoverFadeImageView paramSnsCoverFadeImageView, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(SnsCoverFadeImageView paramSnsCoverFadeImageView, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(SnsCoverFadeImageView paramSnsCoverFadeImageView, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.preview.SnsCoverFadeImageView
 * JD-Core Version:    0.7.0.1
 */