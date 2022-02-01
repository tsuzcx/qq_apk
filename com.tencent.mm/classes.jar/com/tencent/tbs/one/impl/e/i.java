package com.tencent.tbs.one.impl.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.j;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class i
  extends h
{
  public SharedPreferences m;
  g n;
  private Set<String> o;
  private final Object p;
  private final Object q;
  private com.tencent.tbs.one.impl.b.b r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String[] w;
  private String[] x;
  private final Runnable y;
  
  public i(Context paramContext, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    super(paramContext, paramString1);
    AppMethodBeat.i(174076);
    this.p = new Object();
    this.q = new Object();
    this.y = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174074);
        String str = i.this.b;
        com.tencent.tbs.one.impl.a.f.a("[%s] Running idle task", new Object[] { str });
        int i;
        if (i.this.n != null)
        {
          if (i.this.n.a != null) {}
          for (i = 1; i != 0; i = 0)
          {
            com.tencent.tbs.one.impl.a.f.a("[%s] %s in updating", new Object[] { str, "Early out for idle task," });
            i.this.j();
            AppMethodBeat.o(174074);
            return;
          }
        }
        Iterator localIterator = i.this.j.values().iterator();
        while (localIterator.hasNext())
        {
          com.tencent.tbs.one.impl.c.b localb = (com.tencent.tbs.one.impl.c.b)localIterator.next();
          if ((localb.e) && (localb.k == null)) {}
          for (i = 1; i != 0; i = 0)
          {
            com.tencent.tbs.one.impl.a.f.a("[%s] %s in loading component", new Object[] { str, "Early out for idle task," });
            i.this.j();
            AppMethodBeat.o(174074);
            return;
          }
        }
        f.a(i.this.a);
        f.d(i.this.c);
        if (!i.this.e)
        {
          com.tencent.tbs.one.impl.a.f.a("[%s] %s disabled", new Object[] { str, "Early out for auto update," });
          AppMethodBeat.o(174074);
          return;
        }
        if (!i.this.a())
        {
          com.tencent.tbs.one.impl.a.f.a("[%s] %s not use online service", new Object[] { str, "Early out for auto update," });
          AppMethodBeat.o(174074);
          return;
        }
        long l = i.this.m.getLong("last_update_time", 0L);
        if (System.currentTimeMillis() - l < 86400000L)
        {
          com.tencent.tbs.one.impl.a.f.a("[%s] %s the interval is not reached, last update time: %s", new Object[] { str, "Early out for auto update,", com.tencent.tbs.one.impl.a.d.a(l) });
          AppMethodBeat.o(174074);
          return;
        }
        i.this.c().update(null, new TBSOneCallback()
        {
          public final void onError(int paramAnonymous2Int, String paramAnonymous2String)
          {
            AppMethodBeat.i(174072);
            i.this.k();
            AppMethodBeat.o(174072);
          }
        });
        AppMethodBeat.o(174074);
      }
    };
    this.s = paramString2;
    this.u = paramString3;
    this.w = paramArrayOfString;
    this.m = paramContext.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", new Object[] { paramString1 }), 4);
    if (!this.m.contains("last_update_time")) {
      k();
    }
    this.o = this.m.getStringSet("disabled_component_names", new HashSet());
    com.tencent.tbs.one.impl.a.f.a("[%s] Disabled components {%s} from preferences", new Object[] { paramString1, TextUtils.join(", ", this.o) });
    j();
    AppMethodBeat.o(174076);
  }
  
  private com.tencent.tbs.one.impl.a.a<e<File>> a(TBSOneManager.Policy paramPolicy, d.a parama, final File paramFile, Bundle paramBundle)
  {
    AppMethodBeat.i(192446);
    final Context localContext = this.a;
    String str = this.b;
    Object localObject = null;
    switch (5.a[paramPolicy.ordinal()])
    {
    default: 
      paramPolicy = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(192446);
      return paramPolicy;
      paramPolicy = new com.tencent.tbs.one.impl.e.b.a(localContext, str, parama, paramFile, paramBundle);
      continue;
      paramPolicy = new com.tencent.tbs.one.impl.a.a()
      {
        public final void a()
        {
          Object localObject3 = null;
          Object localObject1 = null;
          AppMethodBeat.i(174027);
          try
          {
            InputStream localInputStream = com.tencent.tbs.one.impl.a.c.a(localContext, this.c, this.d);
            localObject1 = localInputStream;
            localObject3 = localInputStream;
            com.tencent.tbs.one.impl.a.c.a(localInputStream, paramFile, null);
            com.tencent.tbs.one.impl.a.c.a(localInputStream);
            return;
          }
          catch (IOException localIOException)
          {
            localIOException = localIOException;
            localObject3 = localObject1;
            a(313, "Failed to unzip local component from " + this.d + " to " + paramFile.getAbsolutePath() + ", localRepository: " + this.c, localIOException);
            return;
          }
          finally
          {
            com.tencent.tbs.one.impl.a.c.a(localObject3);
            AppMethodBeat.o(174027);
          }
        }
      };
      continue;
      paramPolicy = new com.tencent.tbs.one.impl.e.c.a(localContext, str, parama, paramFile, paramBundle);
      continue;
      paramPolicy = com.tencent.tbs.one.impl.a.a(this, parama, paramFile, paramBundle);
    }
  }
  
  private boolean a(String paramString, TBSOneCallback paramTBSOneCallback)
  {
    AppMethodBeat.i(192439);
    if (this.o.contains(paramString))
    {
      if (paramTBSOneCallback != null) {
        paramTBSOneCallback.onError(501, "The component has disabled");
      }
      AppMethodBeat.o(192439);
      return false;
    }
    AppMethodBeat.o(192439);
    return true;
  }
  
  private void f(String paramString)
  {
    AppMethodBeat.i(174099);
    Object localObject = com.tencent.tbs.one.impl.common.f.d(com.tencent.tbs.one.impl.common.f.a(this.a.getDir("tbs", 0), Process.myPid()), this.b);
    com.tencent.tbs.one.impl.a.c.d(((File)localObject).getParentFile());
    if (!((File)localObject).exists()) {
      com.tencent.tbs.one.impl.a.c.b((File)localObject);
    }
    localObject = new HashSet(Arrays.asList(l()));
    ((Set)localObject).add(paramString);
    paramString = this.m.edit();
    paramString.putStringSet("in_use_component_names", (Set)localObject);
    paramString.apply();
    AppMethodBeat.o(174099);
  }
  
  private String m()
  {
    AppMethodBeat.i(174091);
    Object localObject;
    if (this.t == null)
    {
      localObject = this.f;
      if (localObject == null) {
        break label68;
      }
      localObject = ((TBSOneDelegate)localObject).shouldOverrideLocalRepositoryPath(this.b, this.s);
      if (localObject == null) {
        break label57;
      }
      this.t = ((String)localObject);
    }
    for (;;)
    {
      localObject = this.t;
      AppMethodBeat.o(174091);
      return localObject;
      label57:
      this.t = this.s;
      continue;
      label68:
      this.t = this.s;
    }
  }
  
  public final com.tencent.tbs.one.impl.a.a<e<com.tencent.tbs.one.impl.common.d>> a(Bundle paramBundle, l<e<com.tencent.tbs.one.impl.common.d>> paraml)
  {
    AppMethodBeat.i(192443);
    TBSOneManager.Policy localPolicy = this.d;
    if (localPolicy == TBSOneManager.Policy.BUILTIN_ONLY)
    {
      paramBundle = super.a(paramBundle, paraml);
      AppMethodBeat.o(192443);
      return paramBundle;
    }
    Object localObject1 = this.b;
    com.tencent.tbs.one.impl.a.f.a("[%s] Installing DEPS, policy: %s", new Object[] { localObject1, localPolicy });
    File localFile1 = com.tencent.tbs.one.impl.common.f.b(this.c);
    j localj1;
    j localj2;
    int i;
    if (h())
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] Applying the last update", new Object[] { localObject1 });
      Object localObject2 = this.a;
      f.a((Context)localObject2);
      localj1 = i();
      if (localj1 == null) {
        break label450;
      }
      localj2 = j.a(com.tencent.tbs.one.impl.common.f.e(localFile1, ".lock"));
      if (localj2 == null) {
        break label426;
      }
      if (!h()) {
        break label402;
      }
      localObject2 = com.tencent.tbs.one.impl.common.f.b((Context)localObject2).listFiles();
      if (localObject2 == null) {
        break label348;
      }
      int j = localObject2.length;
      i = 0;
      if (i >= j) {
        break label348;
      }
      File localFile2 = localObject2[i];
      if ((localFile2.getName().equals(String.valueOf(Process.myPid()))) || (!com.tencent.tbs.one.impl.common.f.d(localFile2, (String)localObject1).exists())) {
        break label341;
      }
      com.tencent.tbs.one.impl.a.f.a("[%s] The category is being used by process %s", new Object[] { localObject1, localFile2.getName() });
      i = 1;
      if (i != 0) {
        break label378;
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.tbs.one.impl.a.c.c(com.tencent.tbs.one.impl.common.f.c(this.c), localFile1);
        localj2.a();
        localj1.a();
        localObject1 = this.g.get("permanent_version");
        if (!(localObject1 instanceof Integer)) {
          break label474;
        }
        i = ((Integer)localObject1).intValue();
        if (localPolicy != TBSOneManager.Policy.AUTO) {
          break label479;
        }
        paramBundle = a(TBSOneManager.Policy.AUTO, i, localFile1, paramBundle);
        paramBundle = new d(paramBundle, localFile1);
        paramBundle.a(new l() {});
        paramBundle.a(paraml);
        AppMethodBeat.o(192443);
        return paramBundle;
        label341:
        i += 1;
        break;
        label348:
        i = 0;
      }
      catch (IOException localIOException)
      {
        com.tencent.tbs.one.impl.a.f.c("[%s] Failed to apply the last update", new Object[] { localObject1, localIOException });
        continue;
      }
      label378:
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the category is being used by other processes", new Object[] { localObject1, "Early out for applying the last update," });
      continue;
      label402:
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the last update has applied by another process", new Object[] { localObject1, "Early out for applying the last update," });
      continue;
      label426:
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the DEPS installation lock is busy", new Object[] { localObject1, "Early out for applying the last update," });
      continue;
      label450:
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the update lock is busy", new Object[] { localObject1, "Early out for applying the last update," });
      continue;
      label474:
      i = -1;
      continue;
      label479:
      if (localPolicy == TBSOneManager.Policy.LOCAL_ONLY) {
        paramBundle = a(TBSOneManager.Policy.LOCAL_ONLY, i, localFile1, paramBundle);
      } else if (localPolicy == TBSOneManager.Policy.ONLINE) {
        paramBundle = a(TBSOneManager.Policy.ONLINE, i, localFile1, paramBundle);
      } else if (localPolicy == TBSOneManager.Policy.BUILTIN_FIRST) {
        paramBundle = new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { a(TBSOneManager.Policy.BUILTIN_ONLY, i, localFile1, paramBundle), a(TBSOneManager.Policy.AUTO, i, localFile1, paramBundle) });
      } else if (localPolicy == TBSOneManager.Policy.LOCAL_FIRST) {
        paramBundle = new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { a(TBSOneManager.Policy.LOCAL_ONLY, i, localFile1, paramBundle), a(TBSOneManager.Policy.AUTO, i, localFile1, paramBundle) });
      } else {
        paramBundle = null;
      }
    }
  }
  
  public final com.tencent.tbs.one.impl.a.a<e<File>> a(Bundle paramBundle, d.a parama, l<e<File>> paraml)
  {
    AppMethodBeat.i(192444);
    TBSOneManager.Policy localPolicy = this.d;
    if (localPolicy == TBSOneManager.Policy.BUILTIN_ONLY)
    {
      paramBundle = super.a(paramBundle, parama, paraml);
      AppMethodBeat.o(192444);
      return paramBundle;
    }
    com.tencent.tbs.one.impl.a.f.a("[%s] Installing component %s, version: %d, policy: %s", new Object[] { this.b, parama.a, Integer.valueOf(parama.c), localPolicy });
    File localFile = a(parama.a, parama.c);
    com.tencent.tbs.one.impl.a.c.d(localFile.getParentFile());
    Object localObject = null;
    if (localPolicy == TBSOneManager.Policy.AUTO) {
      localObject = a(TBSOneManager.Policy.AUTO, parama, localFile, paramBundle);
    }
    for (;;)
    {
      paramBundle = new c(parama, (com.tencent.tbs.one.impl.a.a)localObject, localFile);
      paramBundle.a(paraml);
      AppMethodBeat.o(192444);
      return paramBundle;
      if (localPolicy == TBSOneManager.Policy.LOCAL_ONLY) {
        localObject = a(TBSOneManager.Policy.LOCAL_ONLY, parama, localFile, paramBundle);
      } else if (localPolicy == TBSOneManager.Policy.ONLINE) {
        localObject = a(TBSOneManager.Policy.ONLINE, parama, localFile, paramBundle);
      } else if (localPolicy == TBSOneManager.Policy.BUILTIN_FIRST) {
        localObject = new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { a(TBSOneManager.Policy.BUILTIN_ONLY, parama, localFile, paramBundle), a(TBSOneManager.Policy.AUTO, parama, localFile, paramBundle) });
      } else if (localPolicy == TBSOneManager.Policy.LOCAL_FIRST) {
        localObject = new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { a(TBSOneManager.Policy.LOCAL_ONLY, parama, localFile, paramBundle), a(TBSOneManager.Policy.AUTO, parama, localFile, paramBundle) });
      }
    }
  }
  
  public final com.tencent.tbs.one.impl.a.a<e<com.tencent.tbs.one.impl.common.d>> a(TBSOneManager.Policy paramPolicy, int paramInt, final File paramFile, Bundle paramBundle)
  {
    AppMethodBeat.i(192445);
    final Context localContext = this.a;
    String str = this.b;
    Object localObject = null;
    switch (5.a[paramPolicy.ordinal()])
    {
    default: 
      paramPolicy = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(192445);
      return paramPolicy;
      paramPolicy = new com.tencent.tbs.one.impl.e.b.b(localContext, str, paramFile);
      continue;
      paramPolicy = new com.tencent.tbs.one.impl.a.a()
      {
        public final void a()
        {
          AppMethodBeat.i(173977);
          Object localObject4 = null;
          Object localObject1 = null;
          Object localObject2 = null;
          try
          {
            InputStream localInputStream = com.tencent.tbs.one.impl.a.c.a(localContext, this.c, "DEPS");
            localObject2 = localInputStream;
            localObject4 = localInputStream;
            localObject1 = localInputStream;
            com.tencent.tbs.one.impl.common.d locald = com.tencent.tbs.one.impl.common.d.a(com.tencent.tbs.one.impl.a.c.a(localInputStream, "utf-8", paramFile));
            com.tencent.tbs.one.impl.a.c.a(localInputStream);
            a(e.a(e.a.c, locald));
            AppMethodBeat.o(173977);
            return;
          }
          catch (IOException localIOException)
          {
            localObject1 = localObject2;
            a(303, "Failed to copy local DEPS from " + this.c + " to " + paramFile.getAbsolutePath(), localIOException);
            com.tencent.tbs.one.impl.a.c.a(localObject2);
            AppMethodBeat.o(173977);
            return;
          }
          catch (TBSOneException localTBSOneException)
          {
            localObject1 = localIOException;
            a(localTBSOneException.getErrorCode(), localTBSOneException.getMessage(), localTBSOneException.getCause());
            com.tencent.tbs.one.impl.a.c.a(localIOException);
            AppMethodBeat.o(173977);
            return;
          }
          finally
          {
            com.tencent.tbs.one.impl.a.c.a((Closeable)localObject1);
            AppMethodBeat.o(173977);
          }
        }
      };
      continue;
      paramPolicy = new com.tencent.tbs.one.impl.e.c.b(localContext, str, f(), paramFile);
      continue;
      paramPolicy = com.tencent.tbs.one.impl.a.a(this, paramInt, paramFile, paramBundle);
    }
  }
  
  public final void a(Bundle paramBundle, String paramString, TBSOneCallback<File> paramTBSOneCallback)
  {
    AppMethodBeat.i(192442);
    if (a(paramString, paramTBSOneCallback)) {
      super.a(paramBundle, paramString, paramTBSOneCallback);
    }
    AppMethodBeat.o(192442);
  }
  
  protected final void a(e<com.tencent.tbs.one.impl.common.d> parame)
  {
    AppMethodBeat.i(174102);
    super.a(parame);
    SharedPreferences.Editor localEditor = this.m.edit();
    localEditor.putInt("in_use_deps_version", ((com.tencent.tbs.one.impl.common.d)parame.b).a);
    localEditor.apply();
    AppMethodBeat.o(174102);
  }
  
  public final void a(String paramString, Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    AppMethodBeat.i(192440);
    f(paramString);
    if (a(paramString, paramTBSOneCallback)) {
      super.a(paramString, paramBundle, paramTBSOneCallback);
    }
    AppMethodBeat.o(192440);
  }
  
  public final void a(String paramString, Object paramObject)
  {
    AppMethodBeat.i(174077);
    super.a(paramString, paramObject);
    if (paramString.equals("permanent_version")) {
      a(false);
    }
    AppMethodBeat.o(174077);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(174078);
    super.a(paramBoolean);
    if (paramBoolean) {
      j();
    }
    AppMethodBeat.o(174078);
  }
  
  public final void b(e<com.tencent.tbs.one.impl.common.d> parame)
  {
    AppMethodBeat.i(174101);
    if (parame.a != e.a.e)
    {
      AppMethodBeat.o(174101);
      return;
    }
    HashSet localHashSet = new HashSet();
    if ((parame.c instanceof JSONObject))
    {
      String str = this.b;
      JSONObject localJSONObject1 = (JSONObject)parame.c;
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("SWITCH");
      Iterator localIterator;
      Object localObject;
      if (localJSONObject2 != null)
      {
        localIterator = localJSONObject2.keys();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (localJSONObject2.optInt((String)localObject, 0) == 1) {
            localHashSet.add(localObject);
          }
        }
      }
      localJSONObject2 = localJSONObject1.optJSONObject("RESET");
      if (localJSONObject2 != null)
      {
        parame = (com.tencent.tbs.one.impl.common.d)parame.b;
        localIterator = localJSONObject2.keys();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (localJSONObject2.optInt((String)localObject, 0) == 1)
          {
            d.a locala = parame.b((String)localObject);
            if (locala != null)
            {
              localObject = a((String)localObject, locala.c);
              if (((File)localObject).exists())
              {
                f.e((File)localObject);
                com.tencent.tbs.one.impl.a.f.a("[%s] Reset component %s", new Object[] { str, ((File)localObject).getAbsolutePath() });
              }
              else
              {
                com.tencent.tbs.one.impl.a.f.c("[%s] Failed to reset component, %s does not exist", new Object[] { str, ((File)localObject).getAbsolutePath() });
              }
            }
            else
            {
              com.tencent.tbs.one.impl.a.f.c("[%s] Failed to reset component %s, no component config", new Object[] { str, localObject });
            }
          }
        }
      }
      if (localJSONObject1.optInt("ULOG") == 1) {
        StatisticReport.reportLog();
      }
    }
    this.o = localHashSet;
    com.tencent.tbs.one.impl.a.f.a("[%s] Disabled components {%s} from server", new Object[] { this.b, TextUtils.join(", ", this.o) });
    parame = this.m.edit();
    parame.putStringSet("disabled_component_names", localHashSet);
    parame.apply();
    AppMethodBeat.o(174101);
  }
  
  public final void b(String paramString, Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    AppMethodBeat.i(192441);
    f(paramString);
    if (a(paramString, paramTBSOneCallback)) {
      super.b(paramString, paramBundle, paramTBSOneCallback);
    }
    AppMethodBeat.o(192441);
  }
  
  public final boolean b(String paramString)
  {
    AppMethodBeat.i(174081);
    paramString = a(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(174081);
      return false;
    }
    paramString = paramString.listFiles();
    if (paramString == null)
    {
      AppMethodBeat.o(174081);
      return false;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramString[i];
      if ((localFile.isDirectory()) && (f.g(localFile)))
      {
        AppMethodBeat.o(174081);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(174081);
    return false;
  }
  
  public final TBSOneOnlineService c()
  {
    AppMethodBeat.i(174079);
    if (!a())
    {
      AppMethodBeat.o(174079);
      return null;
    }
    synchronized (this.p)
    {
      if (this.n == null) {
        this.n = new g(this);
      }
      g localg = this.n;
      AppMethodBeat.o(174079);
      return localg;
    }
  }
  
  public final int[] c(String paramString)
  {
    AppMethodBeat.i(174082);
    paramString = a(paramString);
    int[] arrayOfInt;
    int j;
    int i;
    File localFile;
    if (paramString.exists())
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        arrayOfInt = new int[paramString.length];
        int i1 = paramString.length;
        j = 0;
        i = 0;
        if (j < i1)
        {
          localFile = paramString[j];
          if ((!localFile.isDirectory()) || (!f.g(localFile))) {
            break label156;
          }
        }
      }
    }
    label156:
    for (;;)
    {
      try
      {
        int i2 = Integer.parseInt(localFile.getName());
        int k = i + 1;
        arrayOfInt[i] = i2;
        i = k;
      }
      catch (Exception localException)
      {
        com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse installed version from path %s", new Object[] { this.b, localFile.getAbsolutePath() });
        continue;
      }
      j += 1;
      break;
      paramString = Arrays.copyOfRange(arrayOfInt, 0, i);
      AppMethodBeat.o(174082);
      return paramString;
      AppMethodBeat.o(174082);
      return new int[0];
    }
  }
  
  public final TBSOneDebugger d()
  {
    AppMethodBeat.i(174080);
    synchronized (this.q)
    {
      if (this.r == null) {
        this.r = new com.tencent.tbs.one.impl.b.b(this.b);
      }
      com.tencent.tbs.one.impl.b.b localb = this.r;
      AppMethodBeat.o(174080);
      return localb;
    }
  }
  
  public final String[] e()
  {
    AppMethodBeat.i(174092);
    Object localObject;
    if (this.x == null)
    {
      localObject = this.f;
      if (localObject == null) {
        break label68;
      }
      localObject = ((TBSOneDelegate)localObject).shouldOverrideSharableApplicationPackages(this.b, this.w);
      if (localObject == null) {
        break label57;
      }
      this.x = ((String[])localObject);
    }
    for (;;)
    {
      localObject = this.x;
      AppMethodBeat.o(174092);
      return localObject;
      label57:
      this.x = this.w;
      continue;
      label68:
      this.x = this.w;
    }
  }
  
  public final String f()
  {
    AppMethodBeat.i(174093);
    Object localObject;
    if (this.v == null)
    {
      localObject = this.f;
      if (localObject == null) {
        break label68;
      }
      localObject = ((TBSOneDelegate)localObject).shouldOverrideOnlineServiceUrl(this.b, this.u);
      if (localObject == null) {
        break label57;
      }
      this.v = ((String)localObject);
    }
    for (;;)
    {
      localObject = this.v;
      AppMethodBeat.o(174093);
      return localObject;
      label57:
      this.v = this.u;
      continue;
      label68:
      this.v = this.u;
    }
  }
  
  final File g()
  {
    AppMethodBeat.i(174094);
    File localFile = new File(this.c, "incomplete-update");
    AppMethodBeat.o(174094);
    return localFile;
  }
  
  public final boolean h()
  {
    AppMethodBeat.i(174095);
    boolean bool2 = com.tencent.tbs.one.impl.common.f.c(this.c).exists();
    if (!g().exists()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] Checking update availability, exists: %b, complete: %b", new Object[] { this.b, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break;
      }
      AppMethodBeat.o(174095);
      return true;
    }
    AppMethodBeat.o(174095);
    return false;
  }
  
  public final j i()
  {
    AppMethodBeat.i(174096);
    j localj = j.a(com.tencent.tbs.one.impl.common.f.e(com.tencent.tbs.one.impl.common.f.c(this.c), ".lock"));
    AppMethodBeat.o(174096);
    return localj;
  }
  
  final void j()
  {
    AppMethodBeat.i(174097);
    Handler localHandler = m.a();
    localHandler.removeCallbacks(this.y);
    localHandler.postDelayed(this.y, 10000L);
    AppMethodBeat.o(174097);
  }
  
  final void k()
  {
    AppMethodBeat.i(174098);
    SharedPreferences.Editor localEditor = this.m.edit();
    localEditor.putLong("last_update_time", System.currentTimeMillis());
    localEditor.apply();
    AppMethodBeat.o(174098);
  }
  
  public final String[] l()
  {
    AppMethodBeat.i(174100);
    String[] arrayOfString = (String[])this.m.getStringSet("in_use_component_names", new HashSet()).toArray(new String[0]);
    AppMethodBeat.o(174100);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.i
 * JD-Core Version:    0.7.0.1
 */