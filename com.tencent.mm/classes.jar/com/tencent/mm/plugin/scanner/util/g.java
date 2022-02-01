package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.h;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanImageUtils;", "", "()V", "TAG", "", "convertHevcToJpeg", "", "imagePath", "targetImagePath", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageMimeType", "getImageSize", "Landroid/graphics/Point;", "isHevc", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g PiK;
  
  static
  {
    AppMethodBeat.i(314133);
    PiK = new g();
    AppMethodBeat.o(314133);
  }
  
  public static Point aVg(String paramString)
  {
    AppMethodBeat.i(314118);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(314118);
      return null;
    }
    if (!y.ZC(paramString))
    {
      AppMethodBeat.o(314118);
      return null;
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    paramString = new Point(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight);
    AppMethodBeat.o(314118);
    return paramString;
  }
  
  public static final boolean aVh(String paramString)
  {
    AppMethodBeat.i(314123);
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapUtil.decodeFile(paramString, (BitmapFactory.Options)localObject);
    Log.d("MicroMsg.ScanImageUtils", "alvinluo getImageMimeType %s", new Object[] { ((BitmapFactory.Options)localObject).outMimeType });
    paramString = ((BitmapFactory.Options)localObject).outMimeType;
    localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; (i == 0) && ((n.rs(paramString, "hevc")) || (n.rs(paramString, "wxpc")) || (n.rs(paramString, "wxam"))); i = 0)
    {
      AppMethodBeat.o(314123);
      return true;
    }
    AppMethodBeat.o(314123);
    return false;
  }
  
  public static final Object b(String paramString1, String paramString2, d<? super Boolean> paramd)
  {
    AppMethodBeat.i(314130);
    h localh = new h(b.au(paramd));
    d locald = (d)localh;
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    ah localah = ah.aiuX;
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
      paramString1 = localh.kli();
      if (paramString1 == a.aiwj) {
        s.u(paramd, "frame");
      }
      AppMethodBeat.o(314130);
      return paramString1;
      try
      {
        localObject = new ByteArrayOutputStream();
        paramString1.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
        paramString1 = ((ByteArrayOutputStream)localObject).toByteArray();
        y.f(paramString2, paramString1, paramString1.length);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.g
 * JD-Core Version:    0.7.0.1
 */