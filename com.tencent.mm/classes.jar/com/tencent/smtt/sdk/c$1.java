package com.tencent.smtt.sdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements DownloadListener
{
  private byte _hellAccFlag_;
  
  c$1(Context paramContext) {}
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(54363);
    try
    {
      paramString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      paramString2.setFlags(268435456);
      paramString1 = this.a;
      paramString2 = new com.tencent.mm.hellhoundlib.b.a().ba(paramString2);
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.aeD(), "com/tencent/smtt/sdk/c$1", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString1.startActivity((Intent)paramString2.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/smtt/sdk/c$1", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(54363);
      return;
    }
    catch (ActivityNotFoundException paramString1)
    {
      AppMethodBeat.o(54363);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.c.1
 * JD-Core Version:    0.7.0.1
 */