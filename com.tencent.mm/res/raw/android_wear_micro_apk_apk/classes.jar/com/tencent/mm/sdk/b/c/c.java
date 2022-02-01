package com.tencent.mm.sdk.b.c;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Printer;
import com.tencent.mm.sdk.b.a.a;

public final class c
{
  private static a abv;
  public static final d abw = new d()
  {
    public final HandlerThread I(String paramAnonymousString)
    {
      paramAnonymousString = new HandlerThread("[GT]".concat(String.valueOf(paramAnonymousString)))
      {
        public final void run()
        {
          super.run();
          if (this.abx != null) {
            this.abx.run();
          }
        }
        
        public final String toString()
        {
          return String.format("[%s,%s,%s]", new Object[] { getName(), Long.valueOf(getId()), getState() });
        }
      };
      if (c.lV() != null) {
        c.lV();
      }
      return paramAnonymousString;
    }
    
    public final HandlerThread a(final Runnable paramAnonymousRunnable, String paramAnonymousString, final Printer paramAnonymousPrinter)
    {
      paramAnonymousRunnable = new HandlerThread("[GT]".concat(String.valueOf(paramAnonymousString)))
      {
        protected final void onLooperPrepared()
        {
          super.onLooperPrepared();
          getLooper().setMessageLogging(paramAnonymousPrinter);
        }
        
        public final void run()
        {
          super.run();
          if (paramAnonymousRunnable != null) {
            paramAnonymousRunnable.run();
          }
        }
        
        public final String toString()
        {
          return String.format("[%s,%s,%s]", new Object[] { getName(), Long.valueOf(getId()), getState() });
        }
      };
      if (c.lV() != null) {
        c.lV();
      }
      return paramAnonymousRunnable;
    }
  };
  
  public static HandlerThread H(String paramString)
  {
    return abw.I(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.c.c
 * JD-Core Version:    0.7.0.1
 */