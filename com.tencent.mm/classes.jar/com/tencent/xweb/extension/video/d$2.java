package com.tencent.xweb.extension.video;

import android.widget.ImageView;
import org.xwalk.core.R.drawable;

final class d$2
  implements Runnable
{
  d$2(d paramd, boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.xiG)
    {
      d.k(this.xiF).setImageResource(R.drawable.xweb_video_play_btn);
      return;
    }
    d.k(this.xiF).setImageResource(R.drawable.xweb_video_stop_btn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.2
 * JD-Core Version:    0.7.0.1
 */