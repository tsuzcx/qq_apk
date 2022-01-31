package com.tencent.xweb.extension.video;

import android.widget.TextView;

final class d$3
  implements Runnable
{
  d$3(d paramd, boolean paramBoolean, double paramDouble) {}
  
  public final void run()
  {
    if ((this.xiH) && (d.a(this.xiF) != 0.0D)) {
      d.l(this.xiF).c((int)(100.0D * (this.xiI / d.a(this.xiF))), false);
    }
    d.m(this.xiF).setText(d.a(this.xiF, this.xiI));
    d.o(this.xiF).setText(d.n(this.xiF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.3
 * JD-Core Version:    0.7.0.1
 */