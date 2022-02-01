package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView.1;
import com.tencent.mm.sdk.thread.ThreadPool;

public class TopStoryVideoPlayTextureView
  extends SynchronizedVideoPlayTextureView
{
  private Object lock;
  
  public TopStoryVideoPlayTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126151);
    this.lock = new Object();
    AppMethodBeat.o(126151);
  }
  
  public TopStoryVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126152);
    this.lock = new Object();
    AppMethodBeat.o(126152);
  }
  
  public TopStoryVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126153);
    this.lock = new Object();
    AppMethodBeat.o(126153);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126156);
    ThreadPool.post(new SynchronizedVideoPlayTextureView.1(this), "player-stop");
    AppMethodBeat.o(126156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */