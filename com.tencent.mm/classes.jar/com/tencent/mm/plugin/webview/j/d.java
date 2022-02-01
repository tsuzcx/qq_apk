package com.tencent.mm.plugin.webview.j;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class d
{
  public static String aHy(String paramString)
  {
    AppMethodBeat.i(214000);
    Object localObject = new e(b.asg());
    if (!((e)localObject).mkdirs()) {
      ad.i("MicroMsg.WebJSSDKUtil", "mkdirs failed.File is exist = " + ((e)localObject).exists());
    }
    if (!((e)localObject).exists()) {
      ad.e("MicroMsg.WebJSSDKUtil", "camera storage path do not exist.(%s)", new Object[] { b.asg() });
    }
    localObject = q.B(((e)localObject).fOK()) + "/" + paramString + ".jpg";
    ad.i("MicroMsg.WebJSSDKUtil", "get file path from capture file name : %s == %s", new Object[] { paramString, localObject });
    AppMethodBeat.o(214000);
    return localObject;
  }
  
  public static Intent aHz(String paramString)
  {
    AppMethodBeat.i(214001);
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    paramString = aHy(paramString);
    localIntent.putExtra("output", n.a(aj.getContext(), new e(paramString)));
    AppMethodBeat.o(214001);
    return localIntent;
  }
  
  public static Intent eQv()
  {
    AppMethodBeat.i(214002);
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    AppMethodBeat.o(214002);
    return localIntent;
  }
  
  public static Intent eQw()
  {
    AppMethodBeat.i(214003);
    Intent localIntent = new Intent("android.provider.MediaStore.RECORD_SOUND");
    AppMethodBeat.o(214003);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.d
 * JD-Core Version:    0.7.0.1
 */