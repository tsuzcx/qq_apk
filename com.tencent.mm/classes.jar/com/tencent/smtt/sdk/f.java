package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class f
{
  private static String a = "SDKEcService";
  private static f b;
  private Map<Integer, a> c;
  private Map<Integer, String> d;
  private int e;
  
  public f()
  {
    AppMethodBeat.i(192556);
    this.e = -1;
    this.c = new LinkedHashMap();
    this.d = new LinkedHashMap();
    AppMethodBeat.o(192556);
  }
  
  public static f a()
  {
    AppMethodBeat.i(192555);
    if (b == null) {
      b = new f();
    }
    f localf = b;
    AppMethodBeat.o(192555);
    return localf;
  }
  
  public void a(int paramInt, a parama)
  {
    AppMethodBeat.i(192557);
    if (this.d.containsKey(Integer.valueOf(paramInt)))
    {
      String str = (String)this.d.get(Integer.valueOf(paramInt));
      this.d.remove(Integer.valueOf(paramInt));
      parama.a(str);
      TbsLog.e(a, "Executed command: " + paramInt + ", extra: " + str + ", emergency configuration has requested");
      AppMethodBeat.o(192557);
      return;
    }
    if (this.e == -1)
    {
      this.c.put(Integer.valueOf(paramInt), parama);
      TbsLog.e(a, "Emergency configuration has not yet dispatched. Command query: " + paramInt + " has been suspended");
      AppMethodBeat.o(192557);
      return;
    }
    TbsLog.e(a, "Emergency configuration has been dispatched, status: " + this.e + ". Command query: " + paramInt + " ignored");
    AppMethodBeat.o(192557);
  }
  
  public void a(int paramInt, Map<Integer, String> paramMap)
  {
    AppMethodBeat.i(192558);
    TbsLog.e(a, "Handle emergency commands in sdk, status: ".concat(String.valueOf(paramInt)));
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramInt == 0)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      Integer localInteger;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label181;
        }
        localInteger = (Integer)localIterator.next();
        if (!this.c.containsKey(localInteger)) {
          break;
        }
        localObject = (a)this.c.get(localInteger);
        if (localObject != null) {
          ((a)localObject).a((String)paramMap.get(localInteger));
        }
      }
      Object localObject = (String)paramMap.get(localInteger);
      if (localObject != null) {}
      for (;;)
      {
        localLinkedHashMap.put(localInteger, localObject);
        break;
        localObject = "";
      }
    }
    this.c.clear();
    TbsLog.e(a, "Handle emergency commands failed, ignore all unhandled emergencies, status: ".concat(String.valueOf(paramInt)));
    label181:
    this.d = localLinkedHashMap;
    this.e = paramInt;
    AppMethodBeat.o(192558);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.f
 * JD-Core Version:    0.7.0.1
 */