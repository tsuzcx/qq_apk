package com.tencent.tbs.one.impl.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.d.a;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class j
  extends a<Void>
{
  i b;
  boolean c;
  Map<String, a> d;
  Bundle e;
  
  public j(i parami, Bundle paramBundle)
  {
    AppMethodBeat.i(190677);
    this.d = new ConcurrentHashMap();
    this.b = parami;
    this.e = paramBundle;
    AppMethodBeat.o(190677);
  }
  
  private boolean a(d paramd, String paramString, Set<d.a> paramSet)
  {
    AppMethodBeat.i(173971);
    d.a locala = paramd.b(paramString);
    if (locala != null)
    {
      paramString = locala.f;
      if (paramString != null)
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          if (!a(paramd, paramString[i], paramSet))
          {
            AppMethodBeat.o(173971);
            return false;
          }
          i += 1;
        }
      }
      paramSet.add(locala);
      AppMethodBeat.o(173971);
      return true;
    }
    a(309, "Failed to get info for component ".concat(String.valueOf(paramString)), null);
    AppMethodBeat.o(173971);
    return false;
  }
  
  private void c()
  {
    AppMethodBeat.i(173972);
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b();
    }
    this.d.clear();
    AppMethodBeat.o(173972);
  }
  
  public final void a()
  {
    AppMethodBeat.i(173970);
    com.tencent.tbs.one.impl.a.f.a("[%s] Requesting the latest DEPS", new Object[] { this.b.b });
    final i locali = this.b;
    final String str = locali.b;
    Object localObject = com.tencent.tbs.one.impl.common.f.c(locali.c);
    if (((File)localObject).exists()) {
      com.tencent.tbs.one.impl.a.c.c((File)localObject);
    }
    localObject = locali.a(TBSOneManager.Policy.AUTO, -1, (File)localObject, this.e);
    ((a)localObject).a(new com.tencent.tbs.one.impl.common.c()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(174104);
        com.tencent.tbs.one.impl.a.f.c("[%s] Failed to request the latest DEPS, error: [%d] %s", new Object[] { str, Integer.valueOf(paramAnonymousInt), paramAnonymousString, paramAnonymousThrowable });
        j.this.a(paramAnonymousInt, paramAnonymousString, paramAnonymousThrowable);
        AppMethodBeat.o(174104);
      }
    });
    this.d.put("DEPS", localObject);
    AppMethodBeat.o(173970);
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(173973);
    com.tencent.tbs.one.impl.a.f.b("Failed to update, error: [%d] %s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.c = true;
    c();
    File localFile = com.tencent.tbs.one.impl.common.f.c(this.b.c);
    if (localFile.exists()) {
      com.tencent.tbs.one.impl.a.c.c(localFile);
    }
    super.a(paramInt, paramString, paramThrowable);
    AppMethodBeat.o(173973);
  }
  
  public final void b()
  {
    AppMethodBeat.i(173974);
    super.b();
    c();
    AppMethodBeat.o(173974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.j
 * JD-Core Version:    0.7.0.1
 */