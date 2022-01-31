package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.os.Bundle;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

@JgClassChecked(author=20, fComment="checked", lastDate="20150202", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class QQCallbackUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7470);
    ab.i("MicroMsg.webview.QQCallbackUI", "QQCallbackUI onCreate");
    super.onCreate(paramBundle);
    finish();
    AppMethodBeat.o(7470);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.QQCallbackUI
 * JD-Core Version:    0.7.0.1
 */