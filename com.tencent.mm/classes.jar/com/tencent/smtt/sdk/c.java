package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c
{
  private static c e;
  private static boolean g = false;
  private String a;
  private String b;
  private String c;
  private String d;
  private final Map<Integer, a> f;
  
  private c()
  {
    AppMethodBeat.i(195985);
    this.a = "EmergenceMsgPublisher";
    this.b = "tbs_emergence";
    this.c = "emergence_executed_ids";
    this.d = "emergence_ids";
    this.f = new LinkedHashMap();
    AppMethodBeat.o(195985);
  }
  
  public static c a()
  {
    AppMethodBeat.i(195991);
    if (e == null) {
      e = new c();
    }
    c localc = e;
    AppMethodBeat.o(195991);
    return localc;
  }
  
  private void a(Context paramContext, b paramb, a parama)
  {
    AppMethodBeat.i(196020);
    if (parama != null)
    {
      a("Executed command: " + paramb.b + ", extra: " + paramb.c);
      parama.a(paramb.c);
      paramContext = paramContext.getSharedPreferences(this.b, 4);
      Object localObject = paramContext.getString(this.c, "");
      parama = new HashSet();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        if ((localObject != null) && (localObject.length > 0)) {
          try
          {
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              parama.add(Integer.valueOf(Integer.parseInt(localObject[i])));
              i += 1;
            }
            parama.add(Integer.valueOf(paramb.a));
          }
          catch (Throwable localThrowable) {}
        }
      }
      paramb = new StringBuilder();
      parama = parama.iterator();
      while (parama.hasNext())
      {
        paramb.append((Integer)parama.next());
        paramb.append(",");
      }
      paramContext = paramContext.edit();
      paramContext.putString(this.c, paramb.toString());
      paramContext.commit();
    }
    AppMethodBeat.o(196020);
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(196011);
    TbsLog.d(this.a, paramString);
    AppMethodBeat.o(196011);
  }
  
  public Map<Integer, b> a(Context paramContext)
  {
    int k = 0;
    AppMethodBeat.i(196001);
    HashMap localHashMap = new HashMap();
    Object localObject1 = paramContext.getSharedPreferences(this.b, 0);
    if (paramContext == null)
    {
      a("Unexpected null context!");
      AppMethodBeat.o(196001);
      return localHashMap;
    }
    paramContext = ((SharedPreferences)localObject1).getString(this.d, "");
    if (TextUtils.isEmpty(paramContext))
    {
      a("Empty local emergence ids!");
      AppMethodBeat.o(196001);
      return localHashMap;
    }
    a("Local emergence ids: ".concat(String.valueOf(paramContext)));
    paramContext = paramContext.split(";");
    int j;
    int i;
    if (paramContext != null)
    {
      j = paramContext.length;
      i = 0;
    }
    for (;;)
    {
      Object localObject2;
      String[] arrayOfString;
      if (i < j)
      {
        localObject2 = paramContext[i];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          arrayOfString = ((String)localObject2).split(",");
          if ((arrayOfString != null) && (arrayOfString.length == 4)) {
            localObject2 = new b();
          }
        }
      }
      try
      {
        ((b)localObject2).a = Integer.parseInt(arrayOfString[0]);
        ((b)localObject2).b = Integer.parseInt(arrayOfString[1]);
        ((b)localObject2).c = String.valueOf(arrayOfString[2]);
        ((b)localObject2).d = Long.parseLong(arrayOfString[3]);
        label206:
        if (System.currentTimeMillis() < ((b)localObject2).d) {
          localHashMap.put(Integer.valueOf(((b)localObject2).a), localObject2);
        }
        i += 1;
        continue;
        paramContext = ((SharedPreferences)localObject1).getString(this.c, "");
        a("Executed ids: ".concat(String.valueOf(paramContext)));
        paramContext = paramContext.split(",");
        if (paramContext != null)
        {
          localObject1 = new ArrayList();
          int n = paramContext.length;
          i = 0;
          for (;;)
          {
            j = k;
            if (i >= n) {
              break;
            }
            localObject2 = paramContext[i];
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              j = -1;
            }
            try
            {
              int m = Integer.parseInt((String)localObject2);
              j = m;
            }
            catch (Throwable localThrowable1)
            {
              label330:
              break label330;
            }
            if (j > 0) {
              ((List)localObject1).add(Integer.valueOf(j));
            }
            i += 1;
          }
          while (j < ((List)localObject1).size())
          {
            localHashMap.remove(((List)localObject1).get(j));
            j += 1;
          }
        }
        AppMethodBeat.o(196001);
        return localHashMap;
      }
      catch (Throwable localThrowable2)
      {
        break label206;
      }
    }
  }
  
  public void a(Context paramContext, Integer paramInteger, a parama)
  {
    AppMethodBeat.i(195989);
    Map localMap = a(paramContext);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localMap.get((Integer)localIterator.next());
      if (localb == null)
      {
        a("Unexpected null command!");
      }
      else if (localb.b == paramInteger.intValue())
      {
        a(paramContext, localb, parama);
        AppMethodBeat.o(195989);
        return;
      }
    }
    if (!g)
    {
      this.f.put(paramInteger, parama);
      a("Emergence config did not arrived yet, code[" + paramInteger + "] has been suspended");
    }
    AppMethodBeat.o(195989);
  }
  
  public void b(Context paramContext)
  {
    AppMethodBeat.i(196010);
    Map localMap = a(paramContext);
    a("On notify emergence, validate commands: ".concat(String.valueOf(localMap)));
    g = true;
    Iterator localIterator1 = this.f.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Integer localInteger1 = (Integer)localIterator1.next();
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        Integer localInteger2 = (Integer)localIterator2.next();
        if (((b)localMap.get(localInteger2)).b == localInteger1.intValue()) {
          a(paramContext, (b)localMap.get(localInteger2), (a)this.f.get(localInteger1));
        }
      }
    }
    if (!this.f.isEmpty())
    {
      a("Emergency code[" + this.f.keySet() + "] did not happen, clear suspended queries");
      this.f.clear();
    }
    AppMethodBeat.o(196010);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
  
  public static class b
  {
    public int a = -1;
    public int b = -1;
    public String c = "";
    public long d = -1L;
    
    public String toString()
    {
      AppMethodBeat.i(195880);
      String str = "{seqId=" + this.a + ", code=" + this.b + ", extra='" + this.c + '\'' + ", expired=" + this.d + '}';
      AppMethodBeat.o(195880);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.c
 * JD-Core Version:    0.7.0.1
 */