package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

class bg
{
  private DexLoader a = null;
  private Object b = null;
  
  public bg(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public Object a(Context paramContext, Object paramObject, Bundle paramBundle)
  {
    AppMethodBeat.i(139382);
    if (this.a != null) {
      this.b = this.a.newInstance("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new Class[] { Context.class, Object.class, Bundle.class }, new Object[] { paramContext, paramObject, paramBundle });
    }
    paramContext = this.b;
    AppMethodBeat.o(139382);
    return paramContext;
  }
  
  public void a()
  {
    AppMethodBeat.i(139383);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(139383);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(139386);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    }
    AppMethodBeat.o(139386);
  }
  
  public void b()
  {
    AppMethodBeat.i(139384);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(139384);
  }
  
  public void c()
  {
    AppMethodBeat.i(139385);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(139385);
  }
  
  public long d()
  {
    AppMethodBeat.i(139387);
    if (this.a != null)
    {
      Object localObject = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new Class[0], new Object[0]);
      if ((localObject instanceof Long))
      {
        long l = ((Long)localObject).longValue();
        AppMethodBeat.o(139387);
        return l;
      }
    }
    AppMethodBeat.o(139387);
    return 0L;
  }
  
  public int e()
  {
    AppMethodBeat.i(139388);
    if (this.a != null)
    {
      Object localObject = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new Class[0], new Object[0]);
      if ((localObject instanceof Integer))
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(139388);
        return i;
      }
    }
    AppMethodBeat.o(139388);
    return 0;
  }
  
  public int f()
  {
    AppMethodBeat.i(139389);
    if (this.a != null)
    {
      Object localObject = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new Class[0], new Object[0]);
      if ((localObject instanceof Integer))
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(139389);
        return i;
      }
    }
    AppMethodBeat.o(139389);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.bg
 * JD-Core Version:    0.7.0.1
 */