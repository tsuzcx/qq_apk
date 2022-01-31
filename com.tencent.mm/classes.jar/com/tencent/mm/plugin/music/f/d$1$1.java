package com.tencent.mm.plugin.music.f;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.i.a.a.a;
import com.tencent.mm.sdk.platformtools.ae;

final class d$1$1
  implements Runnable
{
  d$1$1(d.1 param1) {}
  
  public final void run()
  {
    if (System.currentTimeMillis() - this.mAI.mAG > 10000L)
    {
      this.mAI.mAG = System.currentTimeMillis();
      Toast.makeText(ae.getContext(), ae.getContext().getString(a.a.music_file_wrong), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d.1.1
 * JD-Core Version:    0.7.0.1
 */