package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiPublishTextState$JsSetStatusTask$invoke$setStatusCallback$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiPublishTextState$JsSetStatusTask$invoke$setStatusCallback$1
  extends ResultReceiver
{
  JsApiPublishTextState$JsSetStatusTask$invoke$setStatusCallback$1(f<Bundle> paramf)
  {
    super(null);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(297628);
    super.onReceiveResult(paramInt, paramBundle);
    Bundle localBundle = new Bundle();
    localBundle.putInt("KEY_RESULT_CODE", paramInt);
    localBundle.putParcelable("KEY_RESULT_DATA", (Parcelable)paramBundle);
    paramBundle = this.mht;
    if (paramBundle != null) {
      paramBundle.onCallback(localBundle);
    }
    AppMethodBeat.o(297628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiPublishTextState.JsSetStatusTask.invoke.setStatusCallback.1
 * JD-Core Version:    0.7.0.1
 */