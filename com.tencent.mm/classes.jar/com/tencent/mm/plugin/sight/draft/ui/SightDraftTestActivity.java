package com.tencent.mm.plugin.sight.draft.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class SightDraftTestActivity
  extends HellActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28692);
    super.onCreate(paramBundle);
    paramBundle = new SightDraftContainerView(this);
    setContentView(paramBundle);
    paramBundle.dTW();
    AppMethodBeat.o(28692);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftTestActivity
 * JD-Core Version:    0.7.0.1
 */