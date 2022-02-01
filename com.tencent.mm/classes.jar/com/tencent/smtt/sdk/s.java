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
    AppMethodBeat.i(188185);
    if (this.a != null) {
      this.b = this.a.newInstance("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new Class[] { Context.class, Object.class, Bundle.class }, new Object[] { paramContext, paramObject, paramBundle });
    }
    paramContext = this.b;
    AppMethodBeat.o(188185);
    return paramContext;
  }
  
  public void a()
  {
    AppMethodBeat.i(188186);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(188186);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(188189);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    }
    AppMethodBeat.o(188189);
  }
  
  public void b()
  {
    AppMethodBeat.i(188187);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(188187);
  }
  
  public void c()
  {
    AppMethodBeat.i(188188);
    if (this.a != null) {
      this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(188188);
  }
  
  public long d()
  {
    AppMethodBeat.i(188190);
    if (this.a != null)
    {
      Object localObject = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new Class[0], new Object[0]);
      if ((localObject instanceof Long))
      {
        long l = ((Long)localObject).longValue();
        AppMethodBeat.o(188190);
        return l;
      }
    }
    AppMethodBeat.o(188190);
    return 0L;
  }
  
  public int e()
  {
    AppMethodBeat.i(188191);
    if (this.a != null)
    {
      Object localObject = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new Class[0], new Object[0]);
      if ((localObject instanceof Integer))
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(188191);
        return i;
      }
    }
    AppMethodBeat.o(188191);
    return 0;
  }
  
  public int f()
  {
    AppMethodBeat.i(188192);
    if (this.a != null)
    {
      Object localObject = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new Class[0], new Object[0]);
      if ((localObject instanceof Integer))
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(188192);
        return i;
      }
    }
    AppMethodBeat.o(188192);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.s
 * JD-Core Version:    0.7.0.1
 */