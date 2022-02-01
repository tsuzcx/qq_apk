package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

class s
{
  private DexLoader a = null;
  private Object b = null;
  
  public s(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public Object a(Context paramContext, Object paramObject, Bundle paramBundle)
  {
    AppMethodBeat.i(192566);
    if (this.a != null) {
      this.b = this.a.newInstance("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new Class[] { Context.class, Object.class, Bundle.class }, new Object[] { paramContext, paramObject, paramBundle });
    }
    paramContext = this.b;
    AppMethodBeat.o(192566);
    return paramContext;
  }
  
  public void a()
  {
    AppMethodBeat.i(192567);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(192567);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(192570);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    }
    AppMethodBeat.o(192570);
  }
  
  public void b()
  {
    AppMethodBeat.i(192568);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(192568);
  }
  
  public void c()
  {
    AppMethodBeat.i(192569);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(192569);
  }
  
  public long d()
  {
    AppMethodBeat.i(192571);
    if (this.a != null)
    {
      Object localObject = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new Class[0], new Object[0]);
      if ((localObject instanceof Long))
      {
        long l = ((Long)localObject).longValue();
        AppMethodBeat.o(192571);
        return l;
      }
    }
    AppMethodBeat.o(192571);
    return 0L;
  }
  
  public int e()
  {
    AppMethodBeat.i(192572);
    if (this.a != null)
    {
      Object localObject = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new Class[0], new Object[0]);
      if ((localObject instanceof Integer))
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(192572);
        return i;
      }
    }
    AppMethodBeat.o(192572);
    return 0;
  }
  
  public int f()
  {
    AppMethodBeat.i(192573);
    if (this.a != null)
    {
      Object localObject = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new Class[0], new Object[0]);
      if ((localObject instanceof Integer))
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(192573);
        return i;
      }
    }
    AppMethodBeat.o(192573);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.s
 * JD-Core Version:    0.7.0.1
 */