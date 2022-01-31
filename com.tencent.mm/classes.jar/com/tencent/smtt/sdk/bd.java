package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

class bd
  extends Handler
{
  bd(TbsReaderPredownload paramTbsReaderPredownload, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(139367);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(139367);
      return;
      if ((!this.a.c.isEmpty()) && (!this.a.d))
      {
        paramMessage = (String)this.a.c.removeFirst();
        this.a.j = paramMessage;
        if (!this.a.a(paramMessage)) {
          this.a.a(-1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.bd
 * JD-Core Version:    0.7.0.1
 */