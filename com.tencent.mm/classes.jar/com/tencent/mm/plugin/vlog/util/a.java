package com.tencent.mm.plugin.vlog.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.RectF;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.vfs.y;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/util/FinderEditUtil;", "", "()V", "FULLSCREEN_RATIO", "", "getFULLSCREEN_RATIO", "()F", "MIN_RATIO", "NORMAL_RATIO", "getNORMAL_RATIO", "RATIO_TOLERANCE", "SUPPORT_RATIO", "TAG", "", "calculateEnhancementLimitRect", "Landroid/graphics/RectF;", "valid", "getFontSizeWithoutScale", "context", "Landroid/content/Context;", "fontSize", "getGOPSize", "", "path", "getRatio", "width", "height", "getVideoCompositionThumb", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "keepPhotoExifInfo", "source", "dst", "makePhotoSizeConformity", "maxSize", "quality", "bitmap", "savePhotoThumbNail", "compressQuality", "withOutScale", "Landroid/view/View;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a UsM;
  private static final float UsN;
  
  static
  {
    AppMethodBeat.i(281334);
    UsM = new a();
    UsN = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zst, 1.777778F);
    AppMethodBeat.o(281334);
  }
  
  public static void a(int paramInt, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(281304);
    s.u(paramBitmap, "bitmap");
    s.u(paramString, "path");
    BitmapUtil.saveBitmapToImage(paramBitmap, paramInt, Bitmap.CompressFormat.JPEG, paramString, false);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while ((0L > 0L) && (y.bEl(paramString) > 0L) && (i > 0) && (paramInt <= 5))
    {
      i -= 5;
      BitmapUtil.saveBitmapToImage(paramBitmap, i, Bitmap.CompressFormat.JPEG, paramString, false);
      paramInt += 1;
    }
    Log.i("MicroMsg.FinderEditUtil", "makePhotoSizeConformity  maxSize:0  compressQuality:" + i + " size:" + y.ZC(paramString));
    AppMethodBeat.o(281304);
  }
  
  public static int bfB(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(281314);
    s.u(paramString, "path");
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpa, true);
    Log.i("MicroMsg.FinderEditUtil", "getGOPSize path:" + paramString + " enable:" + bool);
    if ((!y.ZC(paramString)) && (bool))
    {
      AppMethodBeat.o(281314);
      return 0;
    }
    localc = new com.tencent.mm.compatible.i.c();
    i = k;
    try
    {
      localc.setDataSource(paramString);
      i = k;
      n = localc.lZm.getTrackCount();
      if (n <= 0) {
        break label191;
      }
      j = 0;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int n;
        int j;
        int m;
        Object localObject;
        label191:
        localException1 = localException1;
        localc.lZm.release();
      }
    }
    finally
    {
      localc.lZm.release();
      AppMethodBeat.o(281314);
    }
    m = j + 1;
    i = k;
    localObject = localc.getTrackFormat(j);
    i = k;
    s.s(localObject, "extractor.getTrackFormat(i)");
    i = k;
    localObject = ((MediaFormat)localObject).getString("mime");
    if (localObject != null)
    {
      i = k;
      if (n.i((CharSequence)localObject, (CharSequence)"video") == true)
      {
        i = 1;
        if (i == 0) {
          break label289;
        }
        i = k;
        localc.selectTrack(j);
        i = k;
        localObject = ByteBuffer.allocate(102400);
        i = 0;
        j = i;
      }
    }
  }
  
  public static float g(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(281322);
    s.u(paramContext, "context");
    Object localObject1 = paramContext.getSystemService("window");
    if (localObject1 == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(281322);
      throw paramContext;
    }
    Object localObject2 = (WindowManager)localObject1;
    localObject1 = new DisplayMetrics();
    localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
    if (localObject2 != null) {
      ((Display)localObject2).getMetrics((DisplayMetrics)localObject1);
    }
    paramFloat = ((DisplayMetrics)localObject1).density * paramFloat / paramContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(281322);
    return paramFloat;
  }
  
  public static float hUK()
  {
    AppMethodBeat.i(281288);
    e locale = e.Uio;
    if (e.hTa())
    {
      AppMethodBeat.o(281288);
      return 1.333333F;
    }
    AppMethodBeat.o(281288);
    return 1.166667F;
  }
  
  public static float hUL()
  {
    return UsN;
  }
  
  public static void iM(View paramView)
  {
    AppMethodBeat.i(281325);
    s.u(paramView, "<this>");
    paramView.post(new a..ExternalSyntheticLambda0(paramView));
    AppMethodBeat.o(281325);
  }
  
  public static void iN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(281309);
    s.u(paramString1, "source");
    s.u(paramString2, "dst");
    com.tencent.mm.plugin.gallery.picker.b.c localc = com.tencent.mm.plugin.gallery.picker.b.c.HJQ;
    com.tencent.mm.plugin.gallery.picker.b.c.iN(paramString1, paramString2);
    AppMethodBeat.o(281309);
  }
  
  public static RectF j(RectF paramRectF)
  {
    AppMethodBeat.i(281319);
    s.u(paramRectF, "valid");
    int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 208);
    int j = aw.bf(MMApplicationContext.getContext()).y;
    int k = bf.bk(MMApplicationContext.getContext());
    paramRectF = new RectF(0.0F, paramRectF.top, paramRectF.right, Math.min(j - i - k, paramRectF.bottom));
    AppMethodBeat.o(281319);
    return paramRectF;
  }
  
  private static final void kv(View paramView)
  {
    AppMethodBeat.i(281331);
    s.u(paramView, "$this_withOutScale");
    Object localObject1 = paramView.getContext();
    s.s(localObject1, "context");
    int i = (int)g((Context)localObject1, paramView.getPaddingLeft());
    localObject1 = paramView.getContext();
    s.s(localObject1, "context");
    int j = (int)g((Context)localObject1, paramView.getPaddingRight());
    localObject1 = paramView.getContext();
    s.s(localObject1, "context");
    int k = (int)g((Context)localObject1, paramView.getPaddingTop());
    localObject1 = paramView.getContext();
    s.s(localObject1, "context");
    paramView.setPadding(i, k, j, (int)g((Context)localObject1, paramView.getPaddingBottom()));
    localObject1 = paramView.getLayoutParams();
    Object localObject2;
    if (((ViewGroup.LayoutParams)localObject1).width > 0)
    {
      localObject2 = paramView.getContext();
      s.s(localObject2, "context");
      ((ViewGroup.LayoutParams)localObject1).width = ((int)g((Context)localObject2, ((ViewGroup.LayoutParams)localObject1).width));
    }
    if (((ViewGroup.LayoutParams)localObject1).height > 0)
    {
      localObject2 = paramView.getContext();
      s.s(localObject2, "context");
      ((ViewGroup.LayoutParams)localObject1).height = ((int)g((Context)localObject2, ((ViewGroup.LayoutParams)localObject1).height));
    }
    if ((localObject1 instanceof FrameLayout.LayoutParams))
    {
      localObject2 = (FrameLayout.LayoutParams)localObject1;
      Context localContext = paramView.getContext();
      s.s(localContext, "context");
      ((FrameLayout.LayoutParams)localObject2).leftMargin = ((int)g(localContext, ((FrameLayout.LayoutParams)localObject1).leftMargin));
      localObject2 = (FrameLayout.LayoutParams)localObject1;
      localContext = paramView.getContext();
      s.s(localContext, "context");
      ((FrameLayout.LayoutParams)localObject2).rightMargin = ((int)g(localContext, ((FrameLayout.LayoutParams)localObject1).rightMargin));
      localObject2 = (FrameLayout.LayoutParams)localObject1;
      localContext = paramView.getContext();
      s.s(localContext, "context");
      ((FrameLayout.LayoutParams)localObject2).topMargin = ((int)g(localContext, ((FrameLayout.LayoutParams)localObject1).topMargin));
      localObject2 = (FrameLayout.LayoutParams)localObject1;
      localContext = paramView.getContext();
      s.s(localContext, "context");
      ((FrameLayout.LayoutParams)localObject2).bottomMargin = ((int)g(localContext, ((FrameLayout.LayoutParams)localObject1).bottomMargin));
    }
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    AppMethodBeat.o(281331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.util.a
 * JD-Core Version:    0.7.0.1
 */