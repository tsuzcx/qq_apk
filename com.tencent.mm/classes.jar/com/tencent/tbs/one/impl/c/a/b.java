package com.tencent.tbs.one.impl.c.a;

import android.app.Service;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.optional.TBSOneStandaloneService.ServiceImpl;
import dalvik.system.DexClassLoader;

public class b
  extends TBSOneStandaloneService.ServiceImpl
{
  private byte _hellAccFlag_;
  
  public void onDestroy()
  {
    AppMethodBeat.i(173812);
    super.onDestroy();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/tbs/one/impl/c/a/b", "onDestroy", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)locala.mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/tbs/one/impl/c/a/b", "onDestroy", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    AppMethodBeat.o(173812);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(173811);
    String str1;
    String str2;
    String str3;
    long l;
    ClassLoader localClassLoader;
    if (paramIntent != null)
    {
      str1 = paramIntent.getStringExtra("dexPath");
      str2 = paramIntent.getStringExtra("dexName");
      str3 = paramIntent.getStringExtra("optimizedDirectory");
      paramIntent = paramIntent.getStringExtra("librarySearchPath");
      l = System.currentTimeMillis();
      f.a("Optimizing dex %s in standalone service", new Object[] { str1 });
      localClassLoader = this.a.getClassLoader();
    }
    try
    {
      new DexClassLoader(str1, str3, paramIntent, localClassLoader);
      com.tencent.tbs.one.impl.a.c.b(c.b(str3, str2));
      f.a("Optimized dex %s in standalone service, cost %dms", new Object[] { str1, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(173811);
      return 1;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        f.c("Failed to optimize dex %s", new Object[] { str1, paramIntent });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.b
 * JD-Core Version:    0.7.0.1
 */