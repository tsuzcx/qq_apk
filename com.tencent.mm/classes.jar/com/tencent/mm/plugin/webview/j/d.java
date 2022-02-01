package com.tencent.mm.plugin.webview.j;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class d
{
  public static String aBX(String paramString)
  {
    AppMethodBeat.i(205398);
    Object localObject = new e(b.aps());
    if (!((e)localObject).mkdirs()) {
      ac.i("MicroMsg.WebJSSDKUtil", "mkdirs failed.File is exist = " + ((e)localObject).exists());
    }
    if (!((e)localObject).exists()) {
      ac.e("MicroMsg.WebJSSDKUtil", "camera storage path do not exist.(%s)", new Object[] { b.aps() });
    }
    localObject = q.B(((e)localObject).fxV()) + "/" + paramString + ".jpg";
    ac.i("MicroMsg.WebJSSDKUtil", "get file path from capture file name : %s == %s", new Object[] { paramString, localObject });
    AppMethodBeat.o(205398);
    return localObject;
  }
  
  public static Intent aBY(String paramString)
  {
    AppMethodBeat.i(205399);
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    paramString = aBX(paramString);
    localIntent.putExtra("output", m.a(ai.getContext(), new e(paramString)));
    AppMethodBeat.o(205399);
    return localIntent;
  }
  
  public static Intent eBB()
  {
    AppMethodBeat.i(205400);
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    AppMethodBeat.o(205400);
    return localIntent;
  }
  
  public static Intent eBC()
  {
    AppMethodBeat.i(205401);
    Intent localIntent = new Intent("android.provider.MediaStore.RECORD_SOUND");
    AppMethodBeat.o(205401);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.d
 * JD-Core Version:    0.7.0.1
 */