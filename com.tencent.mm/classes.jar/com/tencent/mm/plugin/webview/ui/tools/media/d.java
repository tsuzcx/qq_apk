package com.tencent.mm.plugin.webview.ui.tools.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.y;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.k;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmitHelper;", "", "()V", "TAG", "", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "getMpShareVideoInfo", "()Lcom/tencent/mm/message/MPShareVideoInfo;", "setMpShareVideoInfo", "(Lcom/tencent/mm/message/MPShareVideoInfo;)V", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private final String TAG = "MicroMsg.MPVideoTransmit";
  public y nQs;
  
  private static final void a(Activity paramActivity, d paramd)
  {
    AppMethodBeat.i(296696);
    s.u(paramActivity, "$activity");
    s.u(paramd, "this$0");
    k.cZ((Context)paramActivity, paramActivity.getString(c.i.biz_video_shared_tips));
    if ((paramActivity instanceof WebViewUI))
    {
      paramActivity = ((WebViewUI)paramActivity).WlX;
      if (paramActivity != null)
      {
        localObject = paramd.nQs;
        s.checkNotNull(localObject);
        paramActivity.ok(((y)localObject).YMn, "success");
      }
    }
    paramActivity = g.Xms;
    paramActivity = paramd.nQs;
    s.checkNotNull(paramActivity);
    paramActivity = paramActivity.YMn;
    s.s(paramActivity, "mpShareVideoInfo!!.videoVid");
    Object localObject = paramd.nQs;
    s.checkNotNull(localObject);
    localObject = ((y)localObject).YMm;
    s.s(localObject, "mpShareVideoInfo!!.mpUrl");
    paramd = paramd.nQs;
    s.checkNotNull(paramd);
    g.a.h(1, paramActivity, (String)localObject, paramd.nVq);
    AppMethodBeat.o(296696);
  }
  
  private static final void a(d paramd, Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(296704);
    s.u(paramd, "this$0");
    s.u(paramActivity, "$activity");
    if (paramBundle.getBoolean("ret", true))
    {
      MMHandlerThread.postToMainThread(new d..ExternalSyntheticLambda2(paramActivity, paramd));
      AppMethodBeat.o(296704);
      return;
    }
    Log.w(paramd.TAG, "share fail");
    MMHandlerThread.postToMainThread(new d..ExternalSyntheticLambda1(paramActivity, paramd));
    AppMethodBeat.o(296704);
  }
  
  private static final void b(Activity paramActivity, d paramd)
  {
    AppMethodBeat.i(296698);
    s.u(paramActivity, "$activity");
    s.u(paramd, "this$0");
    if ((paramActivity instanceof WebViewUI))
    {
      paramActivity = ((WebViewUI)paramActivity).WlX;
      if (paramActivity != null)
      {
        paramd = paramd.nQs;
        s.checkNotNull(paramd);
        paramActivity.ok(paramd.YMn, "failed");
      }
    }
    AppMethodBeat.o(296698);
  }
  
  public final boolean d(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    AppMethodBeat.i(82661);
    s.u(paramActivity, "activity");
    if (203 == paramInt1)
    {
      if (this.nQs == null)
      {
        Log.w(this.TAG, "onActivityResult mpMsgInfo is null");
        AppMethodBeat.o(82661);
        return true;
      }
      String str;
      if (paramInt2 == -1) {
        if (paramIntent == null)
        {
          str = null;
          if (paramIntent != null) {
            break label124;
          }
          paramIntent = (Intent)localObject;
          label66:
          if (str != null)
          {
            localObject = c.Xmk;
            localObject = this.nQs;
            s.checkNotNull(localObject);
            c.b(str, (y)localObject, paramIntent, new d..ExternalSyntheticLambda0(this, paramActivity));
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(82661);
        return true;
        str = paramIntent.getStringExtra("Select_Conv_User");
        break;
        label124:
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        break label66;
        Log.w(this.TAG, "share cancel");
        if ((paramActivity instanceof WebViewUI))
        {
          paramActivity = ((WebViewUI)paramActivity).WlX;
          if (paramActivity != null)
          {
            paramIntent = this.nQs;
            s.checkNotNull(paramIntent);
            paramActivity.ok(paramIntent.YMn, "canceled");
          }
        }
      }
    }
    AppMethodBeat.o(82661);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.d
 * JD-Core Version:    0.7.0.1
 */