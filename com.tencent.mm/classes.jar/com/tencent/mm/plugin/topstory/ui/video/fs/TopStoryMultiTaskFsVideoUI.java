package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.a;

@a(6)
public class TopStoryMultiTaskFsVideoUI
  extends TopStoryFSVideoUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(271798);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    AppMethodBeat.o(271798);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryMultiTaskFsVideoUI
 * JD-Core Version:    0.7.0.1
 */