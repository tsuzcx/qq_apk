package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.a.a;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.sdk.a.e;
import com.tencent.smtt.sdk.a.e.a;
import com.tencent.smtt.sdk.a.g;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c
{
  private static String a = "EmergencyManager";
  private static int b = 0;
  private static int c = 1;
  private static int d = 2;
  private static int e = 3;
  private static int f = 4;
  private static int g = 5;
  private static c h;
  private Context i;
  private long j = 60000L;
  private long k = 86400000L;
  private boolean l = false;
  private DexLoader m;
  
  private c(Context paramContext)
  {
    this.i = paramContext;
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(192545);
      if (h == null) {
        h = new c(paramContext);
      }
      paramContext = h;
      AppMethodBeat.o(192545);
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt, List<com.tencent.smtt.sdk.a.b> paramList)
  {
    AppMethodBeat.i(192549);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    g localg = g.a();
    Object localObject = localg.a(this.i, "emergence_ids");
    HashSet localHashSet = new HashSet();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String[] arrayOfString = g.a((String)((Iterator)localObject).next());
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          localHashSet.add(Integer.valueOf(Integer.parseInt(arrayOfString[0])));
        }
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (com.tencent.smtt.sdk.a.b)paramList.next();
      int n = ((com.tencent.smtt.sdk.a.b)localObject).b();
      int i1 = ((com.tencent.smtt.sdk.a.b)localObject).a();
      if (localHashSet.contains(Integer.valueOf(i1)))
      {
        TbsLog.d(a, "Command has been executed: " + ((com.tencent.smtt.sdk.a.b)localObject).toString() + ", ignored");
      }
      else if (((com.tencent.smtt.sdk.a.b)localObject).e())
      {
        TbsLog.d(a, "Command is out of date: " + ((com.tencent.smtt.sdk.a.b)localObject).toString() + ", now: " + a.a(System.currentTimeMillis()));
      }
      else
      {
        localLinkedHashMap.put(Integer.valueOf(n), ((com.tencent.smtt.sdk.a.b)localObject).c());
        TbsLog.d(a, "Emergence command: " + ((com.tencent.smtt.sdk.a.b)localObject).toString());
        localObject = g.a(new String[] { String.valueOf(i1), String.valueOf(((com.tencent.smtt.sdk.a.b)localObject).d()) });
        localg.a(this.i, "emergence_ids", (String)localObject);
      }
    }
    a(paramInt, localLinkedHashMap);
    a(Integer.valueOf(paramInt), localLinkedHashMap);
    AppMethodBeat.o(192549);
  }
  
  private void a(int paramInt, Map<Integer, String> paramMap)
  {
    AppMethodBeat.i(192550);
    f localf = f.a();
    localf.a(paramInt, paramMap);
    localf.a(1000, new f.a()
    {
      public void a(String paramAnonymousString)
      {
        AppMethodBeat.i(192554);
        new StringBuilder("Execute command [1000](").append(paramAnonymousString).append("), force tbs downloader request");
        paramAnonymousString = TbsDownloadConfig.getInstance(c.a(c.this)).mPreferences.edit();
        paramAnonymousString.putLong("last_check", 0L);
        paramAnonymousString.apply();
        paramAnonymousString.commit();
        AppMethodBeat.o(192554);
      }
    });
    AppMethodBeat.o(192550);
  }
  
  private void f()
  {
    AppMethodBeat.i(192548);
    com.tencent.smtt.sdk.a.c localc = new com.tencent.smtt.sdk.a.c();
    localc.a(com.tencent.smtt.utils.b.a(this.i));
    localc.b(com.tencent.smtt.utils.b.c(this.i));
    localc.a(Integer.valueOf(com.tencent.smtt.utils.b.b(this.i)));
    localc.c(com.tencent.smtt.utils.b.a());
    Iterator localIterator = g.a().a(this.i, "emergence_ids").iterator();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext()) {
      try
      {
        Object localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = g.a((String)localObject);
          if ((localObject != null) && (localObject.length == 2))
          {
            int n = Integer.parseInt(localObject[0]);
            long l1 = Long.parseLong(localObject[1]);
            if (System.currentTimeMillis() < l1) {
              localArrayList.add(Integer.valueOf(n));
            }
          }
        }
      }
      catch (Exception localException) {}
    }
    localc.a(localArrayList);
    new e(this.i, n.a(this.i).g(), localc.a()).a(new e.a()
    {
      public void a(String paramAnonymousString)
      {
        AppMethodBeat.i(192575);
        TbsLog.d(c.b(), "Request emergency configuration finished: ".concat(String.valueOf(paramAnonymousString)));
        paramAnonymousString = d.a(paramAnonymousString);
        if ((paramAnonymousString != null) && (paramAnonymousString.a() == 0))
        {
          g.a().a(c.a(c.this), "emergence_req_interval", paramAnonymousString.b());
          paramAnonymousString = paramAnonymousString.c();
          if (paramAnonymousString != null)
          {
            TbsLog.d(c.b(), "Request emergency ok");
            c.a(c.this, c.c(), paramAnonymousString);
            AppMethodBeat.o(192575);
            return;
          }
          TbsLog.d(c.b(), "Request emergency no configuration");
          c.a(c.this, c.d(), new ArrayList());
          AppMethodBeat.o(192575);
          return;
        }
        TbsLog.d(c.b(), "Request emergency bad request");
        c.a(c.this, c.e(), new ArrayList());
        AppMethodBeat.o(192575);
      }
    });
    AppMethodBeat.o(192548);
  }
  
  public void a()
  {
    AppMethodBeat.i(192547);
    if (!this.l)
    {
      this.l = true;
      g localg = g.a();
      if (!localg.b())
      {
        localg.a(this.i);
        try
        {
          long l3 = g.a().b(this.i, "emergence_timestamp");
          long l2 = g.a().b(this.i, "emergence_req_interval");
          long l1 = System.currentTimeMillis();
          l3 = l1 - l3;
          l2 = Math.min(Math.max(this.j, l2), this.k);
          if (l3 > l2)
          {
            TbsLog.d(a, "Emergency configuration is out of date, attempt to query again, " + l3 / 1000L + " seconds has past");
            g.a().a(this.i, "emergence_timestamp", l1);
            f();
          }
          for (;;)
          {
            return;
            a(c, new ArrayList());
            TbsLog.d(a, "Emergency configuration is up to date, " + l3 / 1000L + " seconds has past, need " + Math.abs(l3 - l2) / 1000L + " more seconds for an another request");
          }
          a(f, new ArrayList());
        }
        catch (Exception localException)
        {
          a(g, new ArrayList());
          TbsLog.d(a, "Unexpected exception happened when query emergency configuration: " + localException.getMessage());
          return;
        }
        finally
        {
          g.a().c();
          AppMethodBeat.o(192547);
        }
      }
      TbsLog.d(a, "Emergency preference is locked by another process");
    }
    AppMethodBeat.o(192547);
  }
  
  public void a(DexLoader paramDexLoader)
  {
    this.m = paramDexLoader;
  }
  
  public void a(Integer paramInteger, Map<Integer, String> paramMap)
  {
    AppMethodBeat.i(192546);
    if (this.m != null)
    {
      TbsLog.e(a, "Dispatch emergency commands on tbs shell");
      this.m.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "dispatchEmergencyCommand", new Class[] { Integer.class, Map.class }, new Object[] { paramInteger, paramMap });
    }
    for (;;)
    {
      TbsLog.e(a, "Dispatch emergency commands on tbs extension");
      QbSdk.a(this.i, paramInteger, paramMap);
      AppMethodBeat.o(192546);
      return;
      TbsLog.e(a, "Dex loader is null, cancel commands dispatching of tbs shell");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.c
 * JD-Core Version:    0.7.0.1
 */