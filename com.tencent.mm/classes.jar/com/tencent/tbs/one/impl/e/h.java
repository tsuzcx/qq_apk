package com.tencent.tbs.one.impl.e;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class h
{
  public Context a;
  public String b;
  File c;
  public volatile TBSOneManager.Policy d;
  volatile boolean e;
  public TBSOneDelegate f;
  public Map<String, Object> g;
  public d h;
  public com.tencent.tbs.one.impl.a.a<d> i;
  Map<String, com.tencent.tbs.one.impl.c.b> j;
  public Map<String, List<g>> k;
  public b l;
  
  public h(Context paramContext, String paramString)
  {
    AppMethodBeat.i(174116);
    this.d = TBSOneManager.Policy.AUTO;
    this.e = false;
    this.g = new ConcurrentHashMap();
    this.j = new ConcurrentHashMap();
    this.k = new ConcurrentHashMap();
    this.l = new b(this);
    this.a = paramContext;
    this.b = paramString;
    this.c = com.tencent.tbs.one.impl.common.f.a(paramContext.getDir("tbs", 0), paramString);
    com.tencent.tbs.one.impl.a.c.d(this.c);
    com.tencent.tbs.one.impl.a.c.d(com.tencent.tbs.one.impl.common.f.d(this.c));
    AppMethodBeat.o(174116);
  }
  
  private com.tencent.tbs.one.impl.c.b f(String paramString)
  {
    AppMethodBeat.i(174120);
    com.tencent.tbs.one.impl.c.b localb2 = (com.tencent.tbs.one.impl.c.b)this.j.get(paramString);
    com.tencent.tbs.one.impl.c.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new com.tencent.tbs.one.impl.c.b(this, paramString);
      this.j.put(paramString, localb1);
    }
    AppMethodBeat.o(174120);
    return localb1;
  }
  
  public com.tencent.tbs.one.impl.a.a<e<d>> a(Bundle paramBundle, l<e<d>> paraml)
  {
    AppMethodBeat.i(190653);
    String str = this.b;
    com.tencent.tbs.one.impl.a.f.a("[%s] Installing DEPS", new Object[] { str });
    if (this.f != null)
    {
      paramBundle = this.f.shouldOverrideFilePath(str, null, -1, "DEPS");
      if (paramBundle == null) {}
    }
    for (paramBundle = new File(paramBundle);; paramBundle = null)
    {
      Object localObject = paramBundle;
      if (paramBundle == null) {
        localObject = com.tencent.tbs.one.impl.common.f.c(com.tencent.tbs.one.impl.common.f.a(this.a), str);
      }
      if (!((File)localObject).exists())
      {
        paraml.a(105, "Failed to find DEPS file " + ((File)localObject).getAbsolutePath(), null);
        AppMethodBeat.o(190653);
        return null;
      }
      try
      {
        paramBundle = d.a((File)localObject);
        paraml.a(e.a(e.a.b, paramBundle));
        AppMethodBeat.o(190653);
        return null;
      }
      catch (TBSOneException paramBundle)
      {
        paraml.a(paramBundle.getErrorCode(), paramBundle.getMessage(), paramBundle.getCause());
        AppMethodBeat.o(190653);
        return null;
      }
    }
  }
  
  public com.tencent.tbs.one.impl.a.a<e<File>> a(Bundle paramBundle, d.a parama, l<e<File>> paraml)
  {
    AppMethodBeat.i(190654);
    com.tencent.tbs.one.impl.a.f.a("[%s] Installing component %s, version: %d", new Object[] { this.b, parama.a, Integer.valueOf(parama.c) });
    paramBundle = a(parama.a, parama.c);
    com.tencent.tbs.one.impl.a.c.d(paramBundle);
    paraml.a(e.a(e.a.b, paramBundle));
    AppMethodBeat.o(190654);
    return null;
  }
  
  public final File a(String paramString)
  {
    AppMethodBeat.i(174117);
    paramString = com.tencent.tbs.one.impl.common.f.b(this.c, paramString);
    AppMethodBeat.o(174117);
    return paramString;
  }
  
  public final File a(String paramString, int paramInt)
  {
    AppMethodBeat.i(174118);
    paramString = com.tencent.tbs.one.impl.common.f.a(this.c, paramString, paramInt);
    AppMethodBeat.o(174118);
    return paramString;
  }
  
  public void a(Bundle paramBundle, String paramString, TBSOneCallback<File> paramTBSOneCallback)
  {
    AppMethodBeat.i(190652);
    f(paramString).a(paramBundle, paramTBSOneCallback);
    AppMethodBeat.o(190652);
  }
  
  protected void a(e<d> parame)
  {
    AppMethodBeat.i(174119);
    com.tencent.tbs.one.impl.a.f.a("[%s] Finished loading DEPS#%d from %s", new Object[] { this.b, Integer.valueOf(((d)parame.b).a), parame.a });
    this.h = ((d)parame.b);
    AppMethodBeat.o(174119);
  }
  
  public void a(String paramString, Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    AppMethodBeat.i(190650);
    paramString = f(paramString);
    if (paramString.l != null)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Loaded component %s", new Object[] { paramString.b.b, paramString.a, paramString.l });
      if (paramTBSOneCallback != null)
      {
        paramTBSOneCallback.onProgressChanged(0, 100);
        paramTBSOneCallback.onCompleted(paramString.l);
      }
      AppMethodBeat.o(190650);
      return;
    }
    if (paramTBSOneCallback != null)
    {
      paramTBSOneCallback.onProgressChanged(0, paramString.g);
      paramString.d.add(paramTBSOneCallback);
    }
    if (paramString.k != null)
    {
      paramString.b();
      AppMethodBeat.o(190650);
      return;
    }
    paramString.a(paramBundle);
    AppMethodBeat.o(190650);
  }
  
  public void a(String paramString, Object paramObject)
  {
    AppMethodBeat.i(174126);
    this.g.put(paramString, paramObject);
    AppMethodBeat.o(174126);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final boolean a()
  {
    return (this.d != TBSOneManager.Policy.BUILTIN_ONLY) && (this.d != TBSOneManager.Policy.LOCAL_ONLY);
  }
  
  public void b(String paramString, Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    AppMethodBeat.i(190651);
    f(paramString).a(paramBundle, paramTBSOneCallback);
    AppMethodBeat.o(190651);
  }
  
  public final boolean b()
  {
    return this.d == TBSOneManager.Policy.BUILTIN_ONLY;
  }
  
  public boolean b(String paramString)
  {
    return true;
  }
  
  public TBSOneOnlineService c()
  {
    return null;
  }
  
  public int[] c(String paramString)
  {
    return new int[] { -1 };
  }
  
  public TBSOneDebugger d()
  {
    return null;
  }
  
  public final com.tencent.tbs.one.impl.c.b d(String paramString)
  {
    AppMethodBeat.i(174124);
    paramString = (com.tencent.tbs.one.impl.c.b)this.j.get(paramString);
    AppMethodBeat.o(174124);
    return paramString;
  }
  
  public final com.tencent.tbs.one.impl.c.a e(String paramString)
  {
    AppMethodBeat.i(174125);
    paramString = (com.tencent.tbs.one.impl.c.b)this.j.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(174125);
      return null;
    }
    paramString = paramString.l;
    AppMethodBeat.o(174125);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.h
 * JD-Core Version:    0.7.0.1
 */