package com.tencent.smtt.utils;

import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

class f
  implements Runnable
{
  f(e parame) {}
  
  public void run()
  {
    AppMethodBeat.i(65197);
    Toast.makeText(this.a.b, "下载成功", 0).show();
    this.a.c.setVisibility(4);
    this.a.f.a(this.a.d, this.a.a, this.a.b, d.a());
    AppMethodBeat.o(65197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.f
 * JD-Core Version:    0.7.0.1
 */