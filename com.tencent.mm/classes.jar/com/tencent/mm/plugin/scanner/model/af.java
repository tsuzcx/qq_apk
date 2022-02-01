package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.g.e;
import com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanTranslateHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "destroy", "", "handleResult", "session", "", "result", "Landroid/os/Bundle;", "jumpResultUI", "originPath", "", "source", "", "originBitmap", "Landroid/graphics/Bitmap;", "captureTime", "processFrame", "bytes", "", "cameraResolution", "Landroid/graphics/Point;", "cameraRotation", "processImage", "filePath", "Companion", "scan-translation_release"})
public final class af
  extends e
{
  public static final a IMy;
  
  static
  {
    AppMethodBeat.i(211759);
    IMy = new a((byte)0);
    AppMethodBeat.o(211759);
  }
  
  public af(Context paramContext)
  {
    AppMethodBeat.i(211757);
    this.context = paramContext;
    AppMethodBeat.o(211757);
  }
  
  private final void a(String paramString, int paramInt, Bitmap paramBitmap, long paramLong)
  {
    AppMethodBeat.i(211754);
    Log.i("MicroMsg.ScanTranslateHandler", "alvinluo jumpResultUI originPath: %s, captureTime: %d", new Object[] { paramString, Long.valueOf(paramLong) });
    ag.r(paramString, paramBitmap);
    paramBitmap = new Intent();
    paramBitmap.putExtra("key_translation_origin_image_path", paramString);
    paramBitmap.putExtra("key_translation_source", paramInt);
    paramBitmap.putExtra("key_translation_capture_time", paramLong);
    paramBitmap.setClass(this.context, ScanTranslationResultUI.class);
    paramString = this.context;
    paramBitmap = new com.tencent.mm.hellhoundlib.b.a().bm(paramBitmap);
    com.tencent.mm.hellhoundlib.a.a.b(paramString, paramBitmap.aFh(), "com/tencent/mm/plugin/scanner/model/ScanTranslateHandler", "jumpResultUI", "(Ljava/lang/String;ILandroid/graphics/Bitmap;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)paramBitmap.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/scanner/model/ScanTranslateHandler", "jumpResultUI", "(Ljava/lang/String;ILandroid/graphics/Bitmap;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(211754);
  }
  
  public final void c(final long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(211750);
    if (paramBundle == null)
    {
      AppMethodBeat.o(211750);
      return;
    }
    Object localObject2 = paramBundle.getString("key_translate_file_path");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    p.j(localObject1, "result.getString(KEY_TRANSLATE_FILE_PATH) ?: \"\"");
    if (((CharSequence)localObject1).length() > 0) {}
    for (final int i = 1; i != 0; i = 0)
    {
      h.ZvG.bg((Runnable)new b(this, (String)localObject1));
      AppMethodBeat.o(211750);
      return;
    }
    localObject2 = paramBundle.getByteArray("key_translate_yuv_byte_array");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[0];
    }
    p.j(localObject1, "result.getByteArray(KEY_…E_ARRAY) ?: byteArrayOf()");
    if (localObject1.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label228;
      }
    }
    label228:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject2 = (Point)paramBundle.getParcelable("key_translate_camera_resolution");
        i = paramBundle.getInt("key_translate_camera_rotation", 0);
        paramLong = paramBundle.getLong("key_translate_capture_time", 0L);
        h.ZvG.bg((Runnable)new c(this, (byte[])localObject1, (Point)localObject2, i, paramLong));
      }
      AppMethodBeat.o(211750);
      return;
      i = 0;
      break;
    }
  }
  
  public final void destroy() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanTranslateHandler$Companion;", "", "()V", "KEY_TRANSLATE_CAMERA_RESOLUTION", "", "KEY_TRANSLATE_CAMERA_ROTATION", "KEY_TRANSLATE_CAPTURE_TIME", "KEY_TRANSLATE_FILE_PATH", "KEY_TRANSLATE_YUV_BYTE_ARRAY", "TAG", "scan-translation_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(af paramaf, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(211954);
      af.a(this.IMz, this.pqJ);
      AppMethodBeat.o(211954);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(af paramaf, byte[] paramArrayOfByte, Point paramPoint, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(212027);
      af.a(this.IMz, this.IMA, this.IMB, i, paramLong);
      AppMethodBeat.o(212027);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.af
 * JD-Core Version:    0.7.0.1
 */