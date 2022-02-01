package com.tencent.mm.plugin.webview.ui.tools.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.y;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmitHelper;", "", "()V", "TAG", "", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "getMpShareVideoInfo", "()Lcom/tencent/mm/message/MPShareVideoInfo;", "setMpShareVideoInfo", "(Lcom/tencent/mm/message/MPShareVideoInfo;)V", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-webview_release"})
public final class d
{
  final String TAG = "MicroMsg.MPVideoTransmit";
  public y gGE;
  
  public final boolean c(final Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(82661);
    k.h(paramActivity, "activity");
    if (3 == paramInt1)
    {
      if (this.gGE == null)
      {
        ad.w(this.TAG, "onActivityResult mpMsgInfo is null");
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
            Object localObject = c.BsS;
            localObject = this.gGE;
            if (localObject == null) {
              k.fvU();
            }
            c.b(str, (y)localObject, paramIntent, (com.tencent.mm.ipcinvoker.d)new a(this, paramActivity));
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
        ad.w(this.TAG, "share cancel");
        if ((paramActivity instanceof WebViewUI))
        {
          paramActivity = ((WebViewUI)paramActivity).AQP;
          if (paramActivity != null)
          {
            paramIntent = this.gGE;
            if (paramIntent == null) {
              k.fvU();
            }
            paramActivity.jU(paramIntent.CEg, "canceled");
          }
        }
      }
    }
    AppMethodBeat.o(82661);
    return false;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    a(d paramd, Activity paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.d
 * JD-Core Version:    0.7.0.1
 */