package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.scanner.g;
import com.tencent.mm.plugin.scanner.g.f;
import com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanTranslateHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler;", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "destroy", "", "handleResult", "session", "", "result", "jumpResultUI", "originPath", "", "source", "", "originBitmap", "Landroid/graphics/Bitmap;", "captureTime", "processFrame", "bytes", "", "cameraResolution", "Landroid/graphics/Point;", "cameraRotation", "processImage", "filePath", "Companion", "scan-translation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
  extends f<Bundle>
{
  public static final ao.a OTH;
  
  static
  {
    AppMethodBeat.i(314309);
    OTH = new ao.a((byte)0);
    AppMethodBeat.o(314309);
  }
  
  public ao(Context paramContext)
  {
    AppMethodBeat.i(314284);
    this.context = paramContext;
    AppMethodBeat.o(314284);
  }
  
  private static final void a(ao paramao, String paramString)
  {
    AppMethodBeat.i(314295);
    s.u(paramao, "this$0");
    s.u(paramString, "$filePath");
    if (!Util.isNullOrNil(paramString))
    {
      int i = Exif.fromFile(paramString).getOrientationInDegree();
      Log.i("MicroMsg.ScanTranslateHandler", "alvinluo processImage degree %s", new Object[] { Integer.valueOf(i) });
      Bitmap localBitmap = BitmapUtil.decodeFileWithSample(paramString);
      if (localBitmap != null)
      {
        localBitmap = BitmapUtil.rotate(localBitmap, i);
        s.checkNotNull(paramString);
        s.s(localBitmap, "originalBitmap");
        paramao.a(paramString, 1, localBitmap, 0L);
      }
    }
    AppMethodBeat.o(314295);
  }
  
  private static final void a(ao paramao, byte[] paramArrayOfByte, Point paramPoint, int paramInt, long paramLong)
  {
    AppMethodBeat.i(314305);
    s.u(paramao, "this$0");
    s.u(paramArrayOfByte, "$byteArray");
    for (;;)
    {
      try
      {
        if (paramArrayOfByte.length == 0)
        {
          i = 1;
          break label241;
          if ((i == 0) || (paramPoint == null)) {
            continue;
          }
          long l = System.currentTimeMillis();
          paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramPoint.x, paramPoint.y, null);
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramPoint.x, paramPoint.y), 100, (OutputStream)localByteArrayOutputStream);
          paramArrayOfByte = BitmapUtil.decodeByteArray(localByteArrayOutputStream.toByteArray());
          i = (int)(System.currentTimeMillis() - l);
          if (paramArrayOfByte == null) {
            continue;
          }
          l = System.currentTimeMillis();
          paramArrayOfByte = BitmapUtil.rotate(paramArrayOfByte, paramInt);
          Log.i("MicroMsg.ScanTranslateHandler", "alvinluo processFrame decode cost %d, rotate cost %d", new Object[] { Integer.valueOf(i), Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          if (paramArrayOfByte == null) {
            continue;
          }
          paramPoint = ((g)com.tencent.mm.kernel.h.az(g.class)).genScanCaptureImgPath("jpg");
          s.s(paramPoint, "originalPath");
          paramao.a(paramPoint, 0, paramArrayOfByte, paramLong);
          AppMethodBeat.o(314305);
          return;
        }
        i = 0;
      }
      catch (Exception paramao)
      {
        Log.printErrStackTrace("MicroMsg.ScanTranslateHandler", (Throwable)paramao, "alvinluo scanTranslate processFrame exception", new Object[0]);
        AppMethodBeat.o(314305);
        return;
      }
      int i = 0;
      continue;
      label241:
      if (i == 0) {
        i = 1;
      }
    }
  }
  
  private final void a(String paramString, int paramInt, Bitmap paramBitmap, long paramLong)
  {
    AppMethodBeat.i(314291);
    Log.i("MicroMsg.ScanTranslateHandler", "alvinluo jumpResultUI originPath: %s, captureTime: %d", new Object[] { paramString, Long.valueOf(paramLong) });
    ap.r(paramString, paramBitmap);
    paramBitmap = new Intent();
    paramBitmap.putExtra("key_translation_origin_image_path", paramString);
    paramBitmap.putExtra("key_translation_source", paramInt);
    paramBitmap.putExtra("key_translation_capture_time", paramLong);
    paramBitmap.setClass(this.context, ScanTranslationResultUI.class);
    paramString = this.context;
    paramBitmap = new com.tencent.mm.hellhoundlib.b.a().cG(paramBitmap);
    com.tencent.mm.hellhoundlib.a.a.b(paramString, paramBitmap.aYi(), "com/tencent/mm/plugin/scanner/model/ScanTranslateHandler", "jumpResultUI", "(Ljava/lang/String;ILandroid/graphics/Bitmap;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)paramBitmap.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/scanner/model/ScanTranslateHandler", "jumpResultUI", "(Ljava/lang/String;ILandroid/graphics/Bitmap;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(314291);
  }
  
  public final void aS(Bundle paramBundle)
  {
    AppMethodBeat.i(314322);
    if (paramBundle == null)
    {
      AppMethodBeat.o(314322);
      return;
    }
    Object localObject2 = paramBundle.getString("key_translate_file_path");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if (((CharSequence)localObject1).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.threadpool.h.ahAA.bo(new ao..ExternalSyntheticLambda0(this, (String)localObject1));
      AppMethodBeat.o(314322);
      return;
    }
    localObject2 = paramBundle.getByteArray("key_translate_yuv_byte_array");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[0];
    }
    if (localObject1.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label196;
      }
    }
    label196:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject2 = (Point)paramBundle.getParcelable("key_translate_camera_resolution");
        i = paramBundle.getInt("key_translate_camera_rotation", 0);
        long l = paramBundle.getLong("key_translate_capture_time", 0L);
        com.tencent.threadpool.h.ahAA.bo(new ao..ExternalSyntheticLambda1(this, (byte[])localObject1, (Point)localObject2, i, l));
      }
      AppMethodBeat.o(314322);
      return;
      i = 0;
      break;
    }
  }
  
  public final void destroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ao
 * JD-Core Version:    0.7.0.1
 */