package com.tencent.mm.plugin.webview.ui.tools.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.y;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmitHelper;", "", "()V", "TAG", "", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "getMpShareVideoInfo", "()Lcom/tencent/mm/message/MPShareVideoInfo;", "setMpShareVideoInfo", "(Lcom/tencent/mm/message/MPShareVideoInfo;)V", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-webview_release"})
public final class e
{
  final String TAG = "MicroMsg.MPVideoTransmit";
  public y hCc;
  
  public final boolean d(final Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(82661);
    p.h(paramActivity, "activity");
    if (3 == paramInt1)
    {
      if (this.hCc == null)
      {
        ae.w(this.TAG, "onActivityResult mpMsgInfo is null");
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
            Object localObject = d.EGT;
            localObject = this.hCc;
            if (localObject == null) {
              p.gkB();
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
        ae.w(this.TAG, "share cancel");
        if ((paramActivity instanceof WebViewUI))
        {
          paramActivity = ((WebViewUI)paramActivity).DRx;
          if (paramActivity != null)
          {
            paramIntent = this.hCc;
            if (paramIntent == null) {
              p.gkB();
            }
            paramActivity.kV(paramIntent.FUx, "canceled");
          }
        }
      }
    }
    AppMethodBeat.o(82661);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
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