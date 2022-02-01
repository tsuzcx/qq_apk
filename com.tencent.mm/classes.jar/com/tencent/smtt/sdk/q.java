package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

class q
{
  private DexLoader a = null;
  private Object b = null;
  
  public q(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public Object a(Context paramContext, Object paramObject, Bundle paramBundle)
  {
    AppMethodBeat.i(54370);
    if (this.a != null) {
      this.b = this.a.newInstance("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new Class[] { Context.class, Object.class, Bundle.class }, new Object[] { paramContext, paramObject, paramBundle });
    }
    paramContext = this.b;
    AppMethodBeat.o(54370);
    return paramContext;
  }
  
  public void a()
  {
    AppMethodBeat.i(54371);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(54371);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(54374);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    }
    AppMethodBeat.o(54374);
  }
  
  public void b()
  {
    AppMethodBeat.i(54372);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(54372);
  }
  
  public void c()
  {
    AppMethodBeat.i(54373);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(54373);
  }
  
  public long d()
  {
    AppMethodBeat.i(54375);
    if (this.a != null)
    {
      Object localObject = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new Class[0], new Object[0]);
      if ((localObject instanceof Long))
      {
        long l = ((Long)localObject).longValue();
        AppMethodBeat.o(54375);
        return l;
      }
    }
    AppMethodBeat.o(54375);
    return 0L;
  }
  
  public int e()
  {
    AppMethodBeat.i(54376);
    if (this.a != null)
    {
      Object localObject = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new Class[0], new Object[0]);
      if ((localObject instanceof Integer))
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(54376);
        return i;
      }
    }
    AppMethodBeat.o(54376);
    return 0;
  }
  
  public int f()
  {
    AppMethodBeat.i(54377);
    if (this.a != null)
    {
      Object localObject = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new Class[0], new Object[0]);
      if ((localObject instanceof Integer))
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(54377);
        return i;
      }
    }
    AppMethodBeat.o(54377);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.q
 * JD-Core Version:    0.7.0.1
 */