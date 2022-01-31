package com.tencent.mm.ui.base;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class MMFalseProgressBar$1
  extends ah
{
  MMFalseProgressBar$1(MMFalseProgressBar paramMMFalseProgressBar, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1000: 
      MMFalseProgressBar.a(this.uUJ);
      return;
    case 1001: 
      MMFalseProgressBar.b(this.uUJ);
      return;
    case 1002: 
      MMFalseProgressBar.c(this.uUJ);
      return;
    }
    MMFalseProgressBar.d(this.uUJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFalseProgressBar.1
 * JD-Core Version:    0.7.0.1
 */