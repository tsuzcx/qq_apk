package com.tencent.mm.plugin.music.f;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.i.a.a.a;
import com.tencent.mm.sdk.platformtools.ae;

final class d$2$1
  implements Runnable
{
  d$2$1(d.2 param2, int paramInt) {}
  
  public final void run()
  {
    Toast.makeText(ae.getContext(), ae.getContext().getString(a.a.music_url_wrong), 0).show();
    d.a(this.mAJ.mAH, this.mAJ.mAH.myB, this.byD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d.2.1
 * JD-Core Version:    0.7.0.1
 */