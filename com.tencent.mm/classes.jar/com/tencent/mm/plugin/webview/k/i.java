package com.tencent.mm.plugin.webview.k;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;

public final class i
{
  public static Intent bkA(String paramString)
  {
    AppMethodBeat.i(295694);
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    paramString = getFilePath(paramString);
    localIntent.putExtra("output", FileProviderHelper.getUriForFile(MMApplicationContext.getContext(), new u(paramString)));
    AppMethodBeat.o(295694);
    return localIntent;
  }
  
  public static String getFilePath(String paramString)
  {
    AppMethodBeat.i(295689);
    Object localObject = new u(b.bmL());
    if (!((u)localObject).jKY()) {
      Log.i("MicroMsg.WebJSSDKUtil", "mkdirs failed.File is exist = " + ((u)localObject).jKS());
    }
    if (!((u)localObject).jKS()) {
      Log.e("MicroMsg.WebJSSDKUtil", "camera storage path do not exist.(%s)", new Object[] { b.bmL() });
    }
    localObject = ah.v(((u)localObject).jKT()) + "/" + paramString + ".jpg";
    Log.i("MicroMsg.WebJSSDKUtil", "get file path from capture file name : %s == %s", new Object[] { paramString, localObject });
    AppMethodBeat.o(295689);
    return localObject;
  }
  
  public static Intent ivA()
  {
    AppMethodBeat.i(295698);
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    AppMethodBeat.o(295698);
    return localIntent;
  }
  
  public static Intent ivB()
  {
    AppMethodBeat.i(295701);
    Intent localIntent = new Intent("android.provider.MediaStore.RECORD_SOUND");
    AppMethodBeat.o(295701);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.i
 * JD-Core Version:    0.7.0.1
 */