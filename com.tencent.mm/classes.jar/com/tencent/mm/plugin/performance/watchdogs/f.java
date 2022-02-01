package com.tencent.mm.plugin.performance.watchdogs;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.e.c;
import com.tencent.matrix.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  private static List<d> a(b paramb, a parama)
  {
    AppMethodBeat.i(301066);
    LinkedList localLinkedList = new LinkedList();
    String str = String.format("/proc/%s/task/", new Object[] { Integer.valueOf(Process.myPid()) });
    Object localObject1 = new File(str);
    if (((File)localObject1).isDirectory())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label244;
        }
        Object localObject2 = localObject1[i];
        try
        {
          localObject2 = getStringFromFile(str + ((File)localObject2).getName() + "/stat");
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).replaceAll("\n", "").split(" ");
            d locald = new d();
            locald.tid = Long.parseLong(localObject2[0]);
            locald.name = localObject2[1].replace("(", "").replace(")", "");
            locald.state = localObject2[2].replace("'", "");
            if (!parama.gzI())
            {
              localLinkedList.add(locald);
              paramb.a(locald);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            c.e("MicroMsg.ThreadInfoReader", d.e(localException), new Object[0]);
          }
        }
        i += 1;
      }
    }
    label244:
    AppMethodBeat.o(301066);
    return localLinkedList;
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(301071);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      try
      {
        for (;;)
        {
          paramInputStream = localBufferedReader.readLine();
          if (paramInputStream == null) {
            break;
          }
          localStringBuilder.append(paramInputStream).append('\n');
        }
        if (localBufferedReader == null) {
          break label61;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedReader localBufferedReader = null;
      }
    }
    localBufferedReader.close();
    label61:
    AppMethodBeat.o(301071);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(301071);
    return paramInputStream;
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(301076);
    Object localObject1 = new u(paramString);
    paramString = null;
    try
    {
      localObject1 = y.ao((u)localObject1);
      paramString = (String)localObject1;
      String str = convertStreamToString((InputStream)localObject1);
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
      AppMethodBeat.o(301076);
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(301076);
    }
  }
  
  public static int gzD()
  {
    AppMethodBeat.i(301025);
    ThreadGroup localThreadGroup = Looper.getMainLooper().getThread().getThreadGroup();
    if (localThreadGroup == null)
    {
      AppMethodBeat.o(301025);
      return -1;
    }
    int i = localThreadGroup.enumerate(new Thread[localThreadGroup.activeCount() * 2]);
    AppMethodBeat.o(301025);
    return i;
  }
  
  public static Collection<c> gzE()
  {
    AppMethodBeat.i(301034);
    HashMap localHashMap = new HashMap();
    Object localObject1 = Looper.getMainLooper().getThread().getThreadGroup();
    if (localObject1 == null)
    {
      Log.e("MicroMsg.ThreadInfoReader", "getJavaThreads failed");
      localObject1 = localHashMap.values();
      AppMethodBeat.o(301034);
      return localObject1;
    }
    Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject1).activeCount() * 2];
    int j = ((ThreadGroup)localObject1).enumerate(arrayOfThread);
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      localObject2 = arrayOfThread[i];
      localObject1 = ((Thread)localObject2).getName();
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).replaceAll("[0-9]\\d*", "?");
        if (!((String)localObject1).contains("Binder:")) {
          break label233;
        }
        localObject1 = "Binder:?_?";
      }
    }
    label233:
    for (;;)
    {
      d locald = new d();
      locald.name = ((String)localObject1);
      locald.tid = ((Thread)localObject2).getId();
      c localc = (c)localHashMap.get(localObject1);
      localObject2 = localc;
      if (localc == null)
      {
        localObject2 = new c((String)localObject1);
        localHashMap.put(localObject1, localObject2);
      }
      ((c)localObject2).list.add(locald);
      i += 1;
      break;
      localObject1 = new LinkedList(localHashMap.values());
      Collections.sort((List)localObject1, new Comparator() {});
      AppMethodBeat.o(301034);
      return localObject1;
    }
  }
  
  public static int gzF()
  {
    AppMethodBeat.i(301042);
    Object localObject1 = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      localObject1 = getStringFromFile((String)localObject1).trim().split("\n");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (((String)localObject2).startsWith("Threads"))
        {
          localObject2 = Pattern.compile("\\d+").matcher((CharSequence)localObject2);
          if (((Matcher)localObject2).find())
          {
            i = Util.safeParseInt(((Matcher)localObject2).group());
            AppMethodBeat.o(301042);
            return i;
          }
        }
        i += 1;
      }
      Log.w("MicroMsg.ThreadInfoReader", "[getProcessThreadCount] Wrong!", new Object[] { localObject1[24] });
      i = Util.safeParseInt(localObject1[24].trim());
      AppMethodBeat.o(301042);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(301042);
    }
    return 0;
  }
  
  public static List<c> gzG()
  {
    AppMethodBeat.i(301045);
    Object localObject = a(new b()new a
    {
      public final void a(f.d paramAnonymousd)
      {
        AppMethodBeat.i(301019);
        f.d locald = (f.d)f.this.get(Long.valueOf(paramAnonymousd.tid));
        if (locald != null)
        {
          paramAnonymousd.name = (locald.name.replaceAll("-?[0-9]\\d*", "?") + "J");
          paramAnonymousd.MOV = locald.MOV;
          paramAnonymousd.MOU = locald.MOU;
          paramAnonymousd.MOW = locald.MOW;
          AppMethodBeat.o(301019);
          return;
        }
        paramAnonymousd.name = paramAnonymousd.name.replaceAll("-?[0-9]\\d*", "?");
        AppMethodBeat.o(301019);
      }
    }, new a()
    {
      public final boolean gzI()
      {
        return false;
      }
    });
    HashMap localHashMap = new HashMap();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      c localc = (c)localHashMap.get(locald.name);
      localObject = localc;
      if (localc == null)
      {
        localObject = new c(locald.name);
        localHashMap.put(locald.name, localObject);
      }
      ((c)localObject).list.add(locald);
    }
    localObject = new LinkedList(localHashMap.values());
    Collections.sort((List)localObject, new Comparator() {});
    AppMethodBeat.o(301045);
    return localObject;
  }
  
  private static Map<Long, d> gzH()
  {
    AppMethodBeat.i(301055);
    HashMap localHashMap = new HashMap();
    ThreadGroup localThreadGroup = Looper.getMainLooper().getThread().getThreadGroup();
    if (localThreadGroup == null)
    {
      Log.e("MicroMsg.ThreadInfoReader", "getJavaThreads failed");
      AppMethodBeat.o(301055);
      return localHashMap;
    }
    Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount() * 2];
    int j = localThreadGroup.enumerate(arrayOfThread);
    int i = 0;
    while (i < j)
    {
      localThreadGroup = arrayOfThread[i];
      if ((localThreadGroup instanceof HandlerThread))
      {
        d locald = new d();
        locald.name = localThreadGroup.getName();
        locald.tid = ((HandlerThread)localThreadGroup).getThreadId();
        localHashMap.put(Long.valueOf(locald.tid), locald);
        locald.MOU = true;
      }
      i += 1;
    }
    AppMethodBeat.o(301055);
    return localHashMap;
  }
  
  public static abstract interface a
  {
    public abstract boolean gzI();
  }
  
  static abstract interface b
  {
    public abstract void a(f.d paramd);
  }
  
  public static final class c
  {
    List<f.d> list;
    String name;
    
    c(String paramString)
    {
      AppMethodBeat.i(300990);
      this.list = new LinkedList();
      this.name = paramString;
      AppMethodBeat.o(300990);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(301004);
      if ((paramObject instanceof f.d))
      {
        paramObject = (f.d)paramObject;
        boolean bool = this.name.equals(paramObject.name);
        AppMethodBeat.o(301004);
        return bool;
      }
      AppMethodBeat.o(301004);
      return false;
    }
    
    public final int getSize()
    {
      AppMethodBeat.i(300993);
      int i = this.list.size();
      AppMethodBeat.o(300993);
      return i;
    }
    
    public final boolean gzJ()
    {
      AppMethodBeat.i(300998);
      if (this.list.size() > 0)
      {
        boolean bool = ((f.d)this.list.get(0)).MOU;
        AppMethodBeat.o(300998);
        return bool;
      }
      AppMethodBeat.o(300998);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(301009);
      int i = this.name.hashCode();
      AppMethodBeat.o(301009);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(301013);
      String str = this.name + "=" + getSize();
      AppMethodBeat.o(301013);
      return str;
    }
  }
  
  static final class d
  {
    boolean MOU;
    int MOV;
    String MOW;
    String name;
    String state;
    long tid;
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        bool1 = bool2;
        if (this.tid == paramObject.tid) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public final int hashCode()
    {
      return (int)this.tid;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(301017);
      String str = String.format("name=%s tid=%s state=%s isHandlerThread=%s", new Object[] { this.name, Long.valueOf(this.tid), this.state, Boolean.valueOf(this.MOU) });
      AppMethodBeat.o(301017);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.f
 * JD-Core Version:    0.7.0.1
 */