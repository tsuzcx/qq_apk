package com.tencent.mm.plugin.webview.j;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class d
{
  public static String awF(String paramString)
  {
    AppMethodBeat.i(189769);
    Object localObject = new e(b.ais());
    if (!((e)localObject).mkdirs()) {
      ad.i("MicroMsg.WebJSSDKUtil", "mkdirs failed.File is exist = " + ((e)localObject).exists());
    }
    if (!((e)localObject).exists()) {
      ad.e("MicroMsg.WebJSSDKUtil", "camera storage path do not exist.(%s)", new Object[] { b.ais() });
    }
    localObject = q.B(((e)localObject).fhU()) + "/" + paramString + ".jpg";
    ad.i("MicroMsg.WebJSSDKUtil", "get file path from capture file name : %s == %s", new Object[] { paramString, localObject });
    AppMethodBeat.o(189769);
    return localObject;
  }
  
  public static Intent awG(String paramString)
  {
    AppMethodBeat.i(189770);
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    paramString = awF(paramString);
    localIntent.putExtra("output", m.a(aj.getContext(), new e(paramString)));
    AppMethodBeat.o(189770);
    return localIntent;
  }
  
  public static Intent emf()
  {
    AppMethodBeat.i(189771);
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    AppMethodBeat.o(189771);
    return localIntent;
  }
  
  public static Intent emg()
  {
    AppMethodBeat.i(189772);
    Intent localIntent = new Intent("android.provider.MediaStore.RECORD_SOUND");
    AppMethodBeat.o(189772);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.d
 * JD-Core Version:    0.7.0.1
 */