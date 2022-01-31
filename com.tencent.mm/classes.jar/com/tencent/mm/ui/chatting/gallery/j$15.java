package com.tencent.mm.ui.chatting.gallery;

import android.widget.RelativeLayout;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.am.a;

final class j$15
  implements am.a
{
  j$15(j paramj) {}
  
  public final boolean tC()
  {
    if (!j.f(this.vwT).isStreaming()) {}
    k localk;
    boolean bool;
    do
    {
      do
      {
        return false;
        localk = this.vwT.vtH.cFV();
      } while ((localk == null) || (localk.vxg == null) || (localk.cGH().vxg.getVisibility() != 0));
      bool = true;
      if (localk.cGH().vxj.isPlaying()) {
        bool = j.b(this.vwT, localk);
      }
    } while (!bool);
    int i = localk.cGH().vxj.getCurrentPosition() / 1000;
    return j.f(this.vwT).jr(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.15
 * JD-Core Version:    0.7.0.1
 */