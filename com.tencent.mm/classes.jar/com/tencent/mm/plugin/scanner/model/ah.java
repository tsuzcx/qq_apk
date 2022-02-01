package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.f.e;
import com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanTranslateHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "destroy", "", "handleResult", "session", "", "result", "Landroid/os/Bundle;", "jumpResultUI", "originPath", "", "source", "", "originBitmap", "Landroid/graphics/Bitmap;", "captureTime", "processFrame", "bytes", "", "cameraResolution", "Landroid/graphics/Point;", "cameraRotation", "processImage", "filePath", "Companion", "scan-translation_release"})
public final class ah
  extends e
{
  public static final ah.a CHm;
  
  static
  {
    AppMethodBeat.i(200123);
    CHm = new ah.a((byte)0);
    AppMethodBeat.o(200123);
  }
  
  public ah(Context paramContext)
  {
    AppMethodBeat.i(200122);
    this.context = paramContext;
    AppMethodBeat.o(200122);
  }
  
  private final void a(String paramString, int paramInt, Bitmap paramBitmap, long paramLong)
  {
    AppMethodBeat.i(200121);
    Log.i("MicroMsg.ScanTranslateHandler", "alvinluo jumpResultUI originPath: %s, captureTime: %d", new Object[] { paramString, Long.valueOf(paramLong) });
    ai.r(paramString, paramBitmap);
    paramBitmap = new Intent();
    paramBitmap.putExtra("key_translation_origin_image_path", paramString);
    paramBitmap.putExtra("key_translation_source", paramInt);
    paramBitmap.putExtra("key_translation_capture_time", paramLong);
    paramBitmap.setClass(this.context, ScanTranslationResultUI.class);
    paramString = this.context;
    paramBitmap = new com.tencent.mm.hellhoundlib.b.a().bl(paramBitmap);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, paramBitmap.axQ(), "com/tencent/mm/plugin/scanner/model/ScanTranslateHandler", "jumpResultUI", "(Ljava/lang/String;ILandroid/graphics/Bitmap;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)paramBitmap.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/scanner/model/ScanTranslateHandler", "jumpResultUI", "(Ljava/lang/String;ILandroid/graphics/Bitmap;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(200121);
  }
  
  public final void c(final long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(200120);
    if (paramBundle == null)
    {
      AppMethodBeat.o(200120);
      return;
    }
    Object localObject2 = paramBundle.getString("key_translate_file_path");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    p.g(localObject1, "result.getString(KEY_TRANSLATE_FILE_PATH) ?: \"\"");
    if (((CharSequence)localObject1).length() > 0) {}
    for (final int i = 1; i != 0; i = 0)
    {
      h.RTc.aZ((Runnable)new b(this, (String)localObject1));
      AppMethodBeat.o(200120);
      return;
    }
    localObject2 = paramBundle.getByteArray("key_translate_yuv_byte_array");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[0];
    }
    p.g(localObject1, "result.getByteArray(KEY_…E_ARRAY) ?: byteArrayOf()");
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
        h.RTc.aZ((Runnable)new c(this, (byte[])localObject1, (Point)localObject2, i, paramLong));
      }
      AppMethodBeat.o(200120);
      return;
      i = 0;
      break;
    }
  }
  
  public final void destroy() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ah paramah, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(200118);
      ah.a(this.CHn, this.msC);
      AppMethodBeat.o(200118);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ah paramah, byte[] paramArrayOfByte, Point paramPoint, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(200119);
      ah.a(this.CHn, this.CHo, this.CHp, i, paramLong);
      AppMethodBeat.o(200119);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ah
 * JD-Core Version:    0.7.0.1
 */