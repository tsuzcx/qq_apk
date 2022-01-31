package com.tencent.xweb.xwalk;

import java.io.File;

final class a$33
  implements Runnable
{
  a$33(a parama, String paramString) {}
  
  public final void run()
  {
    try
    {
      Thread.sleep(5000L);
      label6:
      File localFile = new File(this.xlu);
      String str = this.xlu + ".zip";
      m.a(new File[] { localFile }, str);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.33
 * JD-Core Version:    0.7.0.1
 */