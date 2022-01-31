package com.tencent.mm.plugin.voip.video.a;

import com.tencent.mm.compatible.util.k;

public class c
{
  public static boolean jkg = false;
  
  static
  {
    aJY();
  }
  
  public static void aJY()
  {
    System.currentTimeMillis();
    if (!jkg) {}
    try
    {
      k.b("image_filter_common", c.class.getClassLoader());
      k.b("image_filter_gpu", c.class.getClassLoader());
      k.b("format_convert", c.class.getClassLoader());
      k.b("YTCommon", c.class.getClassLoader());
      jkg = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      jkg = false;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      jkg = false;
      return;
    }
    catch (Exception localException)
    {
      jkg = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.c
 * JD-Core Version:    0.7.0.1
 */