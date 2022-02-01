package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.graphics.Color;
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
  
  public void init()
  {
    super.init();
    setBackgroundColor(Color.parseColor("#40000000"));
  }
  
  public void setCurrentPlaySecond(int paramInt)
  {
    this.mPosition = paramInt;
    this.lrv.setText(tr(paramInt / 60) + ":" + tr(paramInt % 60));
    Wo(Wn(paramInt));
  }
  
  public abstract void show();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.g
 * JD-Core Version:    0.7.0.1
 */