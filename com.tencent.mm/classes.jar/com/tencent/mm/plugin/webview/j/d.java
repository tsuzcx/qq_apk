package com.tencent.mm.plugin.webview.j;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;

public final class d
{
  public static String aIR(String paramString)
  {
    AppMethodBeat.i(213831);
    Object localObject = new k(b.asv());
    if (!((k)localObject).mkdirs()) {
      ae.i("MicroMsg.WebJSSDKUtil", "mkdirs failed.File is exist = " + ((k)localObject).exists());
    }
    if (!((k)localObject).exists()) {
      ae.e("MicroMsg.WebJSSDKUtil", "camera storage path do not exist.(%s)", new Object[] { b.asv() });
    }
    localObject = w.B(((k)localObject).fTh()) + "/" + paramString + ".jpg";
    ae.i("MicroMsg.WebJSSDKUtil", "get file path from capture file name : %s == %s", new Object[] { paramString, localObject });
    AppMethodBeat.o(213831);
    return localObject;
  }
  
  public static Intent aIS(String paramString)
  {
    AppMethodBeat.i(213832);
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    paramString = aIR(paramString);
    localIntent.putExtra("output", o.a(ak.getContext(), new k(paramString)));
    AppMethodBeat.o(213832);
    return localIntent;
  }
  
  public static Intent eUh()
  {
    AppMethodBeat.i(213833);
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    AppMethodBeat.o(213833);
    return localIntent;
  }
  
  public static Intent eUi()
  {
    AppMethodBeat.i(213834);
    Intent localIntent = new Intent("android.provider.MediaStore.RECORD_SOUND");
    AppMethodBeat.o(213834);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.d
 * JD-Core Version:    0.7.0.1
 */