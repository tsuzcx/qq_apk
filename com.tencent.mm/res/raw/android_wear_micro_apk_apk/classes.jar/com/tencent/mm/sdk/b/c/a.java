package com.tencent.mm.sdk.b.c;

import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

@Deprecated
public final class a
{
  private final AtomicInteger abt = new AtomicInteger(1);
  private ThreadGroup abu = new ThreadGroup("MM_FREE_THREAD_GROUP");
  
  public static HandlerThread G(String paramString)
  {
    Assert.assertNotNull("newThread arg name is null!", paramString);
    return new b("mmt_h".concat(String.valueOf(paramString)), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.c.a
 * JD-Core Version:    0.7.0.1
 */