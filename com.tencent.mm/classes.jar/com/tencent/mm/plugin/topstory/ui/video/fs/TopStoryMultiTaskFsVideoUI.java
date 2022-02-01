package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.a;

@a(6)
public class TopStoryMultiTaskFsVideoUI
  extends TopStoryFSVideoUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202691);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    AppMethodBeat.o(202691);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryMultiTaskFsVideoUI
 * JD-Core Version:    0.7.0.1
 */