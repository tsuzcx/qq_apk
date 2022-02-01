package com.tencent.mm.plugin.webview.ui.tools.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.y;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmitHelper;", "", "()V", "TAG", "", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "getMpShareVideoInfo", "()Lcom/tencent/mm/message/MPShareVideoInfo;", "setMpShareVideoInfo", "(Lcom/tencent/mm/message/MPShareVideoInfo;)V", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-webview_release"})
public final class e
{
  final String TAG = "MicroMsg.MPVideoTransmit";
  public y iwi;
  
  public final boolean d(final Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(82661);
    p.h(paramActivity, "activity");
    if (3 == paramInt1)
    {
      if (this.iwi == null)
      {
        Log.w(this.TAG, "onActivityResult mpMsgInfo is null");
        AppMethodBeat.o(82661);
        return true;
      }
      String str;
      if (paramInt2 == -1) {
        if (paramIntent != null)
        {
          str = paramIntent.getStringExtra("Select_Conv_User");
          if (paramIntent == null) {
            break label130;
          }
          paramIntent = paramIntent.getStringExtra("custom_send_text");
          label72:
          if (str != null)
          {
            Object localObject = d.Jwx;
            localObject = this.iwi;
            if (localObject == null) {
              p.hyc();
            }
            d.b(str, (y)localObject, paramIntent, (com.tencent.mm.ipcinvoker.d)new a(this, paramActivity));
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(82661);
        return true;
        str = null;
        break;
        label130:
        paramIntent = null;
        break label72;
        Log.w(this.TAG, "share cancel");
        if ((paramActivity instanceof WebViewUI))
        {
          paramActivity = ((WebViewUI)paramActivity).IBw;
          if (paramActivity != null)
          {
            paramIntent = this.iwi;
            if (paramIntent == null) {
              p.hyc();
            }
            paramActivity.lT(paramIntent.KOf, "canceled");
          }
        }
      }
    }
    AppMethodBeat.o(82661);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    a(e parame, Activity paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.e
 * JD-Core Version:    0.7.0.1
 */