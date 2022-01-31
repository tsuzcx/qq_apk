package com.tencent.mm.sdk.f;

import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

public final class a
{
  private ThreadGroup eqG;
  private final AtomicInteger ukc = new AtomicInteger(1);
  private e.b ukd;
  
  a(e.b paramb)
  {
    this.ukd = paramb;
    this.eqG = new ThreadGroup("MM_FREE_THREAD_GROUP");
  }
  
  static HandlerThread dr(String paramString, int paramInt)
  {
    Assert.assertNotNull("newThread arg name is null!", paramString);
    return new a("mmt_h" + paramString, paramInt);
  }
  
  static final class a
    extends HandlerThread
  {
    a(String paramString, int paramInt)
    {
      super(paramInt);
    }
    
    public final void run()
    {
      super.run();
    }
    
    public final void start()
    {
      super.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.f.a
 * JD-Core Version:    0.7.0.1
 */