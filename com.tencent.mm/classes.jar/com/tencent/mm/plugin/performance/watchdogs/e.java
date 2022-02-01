package com.tencent.mm.plugin.performance.watchdogs;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.e.c;
import com.tencent.matrix.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private static List<c> a(a parama)
  {
    AppMethodBeat.i(200803);
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
          break label233;
        }
        Object localObject2 = localObject1[i];
        try
        {
          localObject2 = getStringFromFile(str + ((File)localObject2).getName() + "/stat");
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).replaceAll("\n", "").split(" ");
            c localc = new c();
            localc.tid = Long.parseLong(localObject2[0]);
            localc.name = localObject2[1].replace("(", "").replace(")", "");
            localc.state = localObject2[2].replace("'", "");
            localLinkedList.add(localc);
            parama.a(localc);
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
    label233:
    AppMethodBeat.o(200803);
    return localLinkedList;
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(200805);
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
    AppMethodBeat.o(200805);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(200805);
    return paramInputStream;
  }
  
  public static int foD()
  {
    AppMethodBeat.i(200796);
    ThreadGroup localThreadGroup = Looper.getMainLooper().getThread().getThreadGroup();
    if (localThreadGroup == null)
    {
      AppMethodBeat.o(200796);
      return -1;
    }
    int i = localThreadGroup.enumerate(new Thread[localThreadGroup.activeCount() * 2]);
    AppMethodBeat.o(200796);
    return i;
  }
  
  public static int foE()
  {
    AppMethodBeat.i(200797);
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
            AppMethodBeat.o(200797);
            return i;
          }
        }
        i += 1;
      }
      Log.w("MicroMsg.ThreadInfoReader", "[getProcessThreadCount] Wrong!", new Object[] { localObject1[24] });
      i = Util.safeParseInt(localObject1[24].trim());
      AppMethodBeat.o(200797);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(200797);
    }
    return 0;
  }
  
  public static List<b> foF()
  {
    AppMethodBeat.i(200800);
    Object localObject1 = new HashMap();
    Object localObject3 = Looper.getMainLooper().getThread().getThreadGroup();
    if (localObject3 == null) {
      Log.e("MicroMsg.ThreadInfoReader", "getJavaThreads failed");
    }
    for (;;)
    {
      localObject1 = new a()
      {
        public final void a(e.c paramAnonymousc)
        {
          AppMethodBeat.i(201206);
          e.c localc = (e.c)this.GRv.get(Long.valueOf(paramAnonymousc.tid));
          if (localc != null)
          {
            paramAnonymousc.name = (localc.name.replaceAll("-?[0-9]\\d*", "?") + "J");
            paramAnonymousc.GRx = localc.GRx;
            paramAnonymousc.GRw = localc.GRw;
            paramAnonymousc.GRy = localc.GRy;
            AppMethodBeat.o(201206);
            return;
          }
          paramAnonymousc.name = paramAnonymousc.name.replaceAll("-?[0-9]\\d*", "?");
          AppMethodBeat.o(201206);
        }
      };
      new Object() {};
      localObject1 = a((a)localObject1);
      localObject3 = new HashMap();
      Object localObject4 = ((List)localObject1).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        c localc = (c)((Iterator)localObject4).next();
        localObject2 = (b)((HashMap)localObject3).get(localc.name);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new b(localc.name);
          ((HashMap)localObject3).put(localc.name, localObject1);
        }
        ((b)localObject1).list.add(localc);
      }
      Object localObject2 = new Thread[((ThreadGroup)localObject3).activeCount() * 2];
      int j = ((ThreadGroup)localObject3).enumerate((Thread[])localObject2);
      int i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        if ((localObject3 instanceof HandlerThread))
        {
          localObject4 = new c();
          ((c)localObject4).name = ((Thread)localObject3).getName();
          ((c)localObject4).tid = ((HandlerThread)localObject3).getThreadId();
          ((Map)localObject1).put(Long.valueOf(((c)localObject4).tid), localObject4);
          ((c)localObject4).GRw = true;
        }
        i += 1;
      }
    }
    localObject1 = new LinkedList(((HashMap)localObject3).values());
    Collections.sort((List)localObject1, new Comparator() {});
    AppMethodBeat.o(200800);
    return localObject1;
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(200808);
    Object localObject1 = new q(paramString);
    paramString = null;
    try
    {
      localObject1 = u.al((q)localObject1);
      paramString = (String)localObject1;
      String str = convertStreamToString((InputStream)localObject1);
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
      AppMethodBeat.o(200808);
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(200808);
    }
  }
  
  static abstract interface a
  {
    public abstract void a(e.c paramc);
  }
  
  public static final class b
  {
    List<e.c> list;
    String name;
    
    b(String paramString)
    {
      AppMethodBeat.i(200785);
      this.list = new LinkedList();
      this.name = paramString;
      AppMethodBeat.o(200785);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(200789);
      if ((paramObject instanceof e.c))
      {
        paramObject = (e.c)paramObject;
        boolean bool = this.name.equals(paramObject.name);
        AppMethodBeat.o(200789);
        return bool;
      }
      AppMethodBeat.o(200789);
      return false;
    }
    
    public final boolean foG()
    {
      AppMethodBeat.i(200787);
      if (this.list.size() > 0)
      {
        boolean bool = ((e.c)this.list.get(0)).GRw;
        AppMethodBeat.o(200787);
        return bool;
      }
      AppMethodBeat.o(200787);
      return false;
    }
    
    public final int getSize()
    {
      AppMethodBeat.i(200786);
      int i = this.list.size();
      AppMethodBeat.o(200786);
      return i;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(200790);
      int i = this.name.hashCode();
      AppMethodBeat.o(200790);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(200791);
      String str = this.name + "=" + getSize();
      AppMethodBeat.o(200791);
      return str;
    }
  }
  
  static final class c
  {
    boolean GRw;
    int GRx;
    String GRy;
    String name;
    String state;
    long tid;
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
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
      AppMethodBeat.i(202426);
      String str = String.format("name=%s tid=%s state=%s isHandlerThread=%s", new Object[] { this.name, Long.valueOf(this.tid), this.state, Boolean.valueOf(this.GRw) });
      AppMethodBeat.o(202426);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.e
 * JD-Core Version:    0.7.0.1
 */