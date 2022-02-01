package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.Result;
import kotlin.d.a.a;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/ScanImageUtils;", "", "()V", "TAG", "", "convertHevcToJpeg", "", "imagePath", "targetImagePath", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageMimeType", "getImageSize", "Landroid/graphics/Point;", "isHevc", "scan-sdk_release"})
public final class f
{
  public static final f IYY;
  
  static
  {
    AppMethodBeat.i(193464);
    IYY = new f();
    AppMethodBeat.o(193464);
  }
  
  public static final Object a(String paramString1, String paramString2, d<? super Boolean> paramd)
  {
    AppMethodBeat.i(193463);
    h localh = new h(b.k(paramd));
    d locald = (d)localh;
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramString1 = BitmapUtil.decodeFile(paramString1, (BitmapFactory.Options)localObject);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.ScanImageUtils", "alvinluo convertHevcToJpeg bitmap null");
      paramString1 = Boolean.FALSE;
      paramString2 = Result.Companion;
      locald.resumeWith(Result.constructor-impl(paramString1));
    }
    for (;;)
    {
      paramString1 = localh.iBS();
      if (paramString1 == a.aaAA) {
        p.k(paramd, "frame");
      }
      AppMethodBeat.o(193463);
      return paramString1;
      try
      {
        localObject = new ByteArrayOutputStream();
        paramString1.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
        u.H(paramString2, ((ByteArrayOutputStream)localObject).toByteArray());
        paramString1 = Boolean.TRUE;
        paramString2 = Result.Companion;
        locald.resumeWith(Result.constructor-impl(paramString1));
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.ScanImageUtils", (Throwable)paramString1, "alvinluo convertHevcToJpeg exception", new Object[0]);
        paramString1 = Boolean.FALSE;
        paramString2 = Result.Companion;
        locald.resumeWith(Result.constructor-impl(paramString1));
      }
    }
  }
  
  public static Point aXy(String paramString)
  {
    AppMethodBeat.i(193461);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(193461);
      return null;
    }
    if (!u.agG(paramString))
    {
      AppMethodBeat.o(193461);
      return null;
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    paramString = new Point(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight);
    AppMethodBeat.o(193461);
    return paramString;
  }
  
  public static final boolean aXz(String paramString)
  {
    AppMethodBeat.i(193462);
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapUtil.decodeFile(paramString, (BitmapFactory.Options)localObject);
    Log.d("MicroMsg.ScanImageUtils", "alvinluo getImageMimeType %s", new Object[] { ((BitmapFactory.Options)localObject).outMimeType });
    paramString = ((BitmapFactory.Options)localObject).outMimeType;
    localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; (i == 0) && ((n.pu(paramString, "hevc")) || (n.pu(paramString, "wxpc")) || (n.pu(paramString, "wxam"))); i = 0)
    {
      AppMethodBeat.o(193462);
      return true;
    }
    AppMethodBeat.o(193462);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.f
 * JD-Core Version:    0.7.0.1
 */