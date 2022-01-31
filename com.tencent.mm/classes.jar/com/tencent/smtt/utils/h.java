package com.tencent.smtt.utils;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

class h
  implements Runnable
{
  h(e parame) {}
  
  public void run()
  {
    AppMethodBeat.i(65199);
    Toast.makeText(this.a.b, "下载失败，请检查网络", 0).show();
    AppMethodBeat.o(65199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.utils.h
 * JD-Core Version:    0.7.0.1
 */