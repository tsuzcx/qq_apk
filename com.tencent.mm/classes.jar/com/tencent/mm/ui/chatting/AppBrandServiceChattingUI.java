package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandServiceChattingUI
  extends ChattingUI
{
  protected final ChattingUIFragment dFB()
  {
    AppMethodBeat.i(30369);
    AppBrandServiceChattingUI.AppBrandServiceChattingFmUI localAppBrandServiceChattingFmUI = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI((byte)0);
    AppMethodBeat.o(30369);
    return localAppBrandServiceChattingFmUI;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30368);
    overridePendingTransition(0, 0);
    super.onCreate(null);
    AppMethodBeat.o(30368);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI
 * JD-Core Version:    0.7.0.1
 */