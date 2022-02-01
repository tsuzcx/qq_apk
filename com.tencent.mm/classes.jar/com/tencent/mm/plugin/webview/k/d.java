package com.tencent.mm.plugin.webview.k;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class d
{
  public static String aYW(String paramString)
  {
    AppMethodBeat.i(224512);
    Object localObject = new o(b.aKV());
    if (!((o)localObject).mkdirs()) {
      Log.i("MicroMsg.WebJSSDKUtil", "mkdirs failed.File is exist = " + ((o)localObject).exists());
    }
    if (!((o)localObject).exists()) {
      Log.e("MicroMsg.WebJSSDKUtil", "camera storage path do not exist.(%s)", new Object[] { b.aKV() });
    }
    localObject = aa.z(((o)localObject).her()) + "/" + paramString + ".jpg";
    Log.i("MicroMsg.WebJSSDKUtil", "get file path from capture file name : %s == %s", new Object[] { paramString, localObject });
    AppMethodBeat.o(224512);
    return localObject;
  }
  
  public static Intent aYX(String paramString)
  {
    AppMethodBeat.i(224513);
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    paramString = aYW(paramString);
    localIntent.putExtra("output", FileProviderHelper.getUriForFile(MMApplicationContext.getContext(), new o(paramString)));
    AppMethodBeat.o(224513);
    return localIntent;
  }
  
  public static Intent gcV()
  {
    AppMethodBeat.i(224514);
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    AppMethodBeat.o(224514);
    return localIntent;
  }
  
  public static Intent gcW()
  {
    AppMethodBeat.i(224515);
    Intent localIntent = new Intent("android.provider.MediaStore.RECORD_SOUND");
    AppMethodBeat.o(224515);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.d
 * JD-Core Version:    0.7.0.1
 */