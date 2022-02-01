package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsTimeLineUserPagerUI
  extends SnsTimeLineUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUserPagerUI
 * JD-Core Version:    0.7.0.1
 */