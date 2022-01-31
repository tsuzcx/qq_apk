package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar;

public abstract class g
  extends WebSearchVideoPlayerSeekBar
{
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract void hide();
  
  public void setCurrentPlaySecond(int paramInt)
  {
    this.mPosition = paramInt;
    this.ofs.setText(lC(paramInt / 60) + ":" + lC(paramInt % 60));
    BI(BH(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.g
 * JD-Core Version:    0.7.0.1
 */