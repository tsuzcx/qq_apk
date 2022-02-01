package com.tencent.smtt.utils;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TbsLogClient$a
  implements Runnable
{
  String a = null;
  
  TbsLogClient$a(TbsLogClient paramTbsLogClient, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    AppMethodBeat.i(54005);
    if (this.b.b != null) {
      this.b.b.append(this.a + "\n");
    }
    AppMethodBeat.o(54005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsLogClient.a
 * JD-Core Version:    0.7.0.1
 */