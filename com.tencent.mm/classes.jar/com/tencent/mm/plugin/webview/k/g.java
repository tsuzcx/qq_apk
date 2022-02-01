package com.tencent.mm.plugin.webview.k;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.q;

public final class g
{
  public static Intent bkR(String paramString)
  {
    AppMethodBeat.i(205996);
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    paramString = getFilePath(paramString);
    localIntent.putExtra("output", FileProviderHelper.getUriForFile(MMApplicationContext.getContext(), new q(paramString)));
    AppMethodBeat.o(205996);
    return localIntent;
  }
  
  public static Intent gVS()
  {
    AppMethodBeat.i(205997);
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    AppMethodBeat.o(205997);
    return localIntent;
  }
  
  public static Intent gVT()
  {
    AppMethodBeat.i(205998);
    Intent localIntent = new Intent("android.provider.MediaStore.RECORD_SOUND");
    AppMethodBeat.o(205998);
    return localIntent;
  }
  
  public static String getFilePath(String paramString)
  {
    AppMethodBeat.i(205994);
    Object localObject = new q(b.aSX());
    if (!((q)localObject).ifL()) {
      Log.i("MicroMsg.WebJSSDKUtil", "mkdirs failed.File is exist = " + ((q)localObject).ifE());
    }
    if (!((q)localObject).ifE()) {
      Log.e("MicroMsg.WebJSSDKUtil", "camera storage path do not exist.(%s)", new Object[] { b.aSX() });
    }
    localObject = ((q)localObject).bOF() + "/" + paramString + ".jpg";
    Log.i("MicroMsg.WebJSSDKUtil", "get file path from capture file name : %s == %s", new Object[] { paramString, localObject });
    AppMethodBeat.o(205994);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.g
 * JD-Core Version:    0.7.0.1
 */