package com.tencent.mm.plugin.topstory;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class c$1
  extends ah
{
  c$1(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    ((c.a)paramMessage.obj).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.c.1
 * JD-Core Version:    0.7.0.1
 */