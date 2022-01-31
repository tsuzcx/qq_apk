package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class c
{
  protected HashMap<String, HashMap<String, byte[]>> a;
  protected HashMap<String, Object> b;
  protected String c;
  k d;
  private HashMap<String, Object> e;
  
  c()
  {
    AppMethodBeat.i(98605);
    this.a = new HashMap();
    this.b = new HashMap();
    this.e = new HashMap();
    this.c = "GBK";
    this.d = new k();
    AppMethodBeat.o(98605);
  }
  
  private void a(ArrayList<String> paramArrayList, Object paramObject)
  {
    AppMethodBeat.i(98610);
    for (;;)
    {
      if (paramObject.getClass().isArray())
      {
        if (!paramObject.getClass().getComponentType().toString().equals("byte"))
        {
          paramArrayList = new IllegalArgumentException("only byte[] is supported");
          AppMethodBeat.o(98610);
          throw paramArrayList;
        }
        if (Array.getLength(paramObject) > 0)
        {
          paramArrayList.add("java.util.List");
          paramObject = Array.get(paramObject, 0);
        }
        else
        {
          paramArrayList.add("Array");
          paramArrayList.add("?");
          AppMethodBeat.o(98610);
        }
      }
      else
      {
        if ((paramObject instanceof Array))
        {
          paramArrayList = new IllegalArgumentException("can not support Array, please use List");
          AppMethodBeat.o(98610);
          throw paramArrayList;
        }
        if ((paramObject instanceof List))
        {
          paramArrayList.add("java.util.List");
          paramObject = (List)paramObject;
          if (paramObject.size() > 0)
          {
            paramObject = paramObject.get(0);
          }
          else
          {
            paramArrayList.add("?");
            AppMethodBeat.o(98610);
          }
        }
        else
        {
          if (!(paramObject instanceof Map)) {
            break label257;
          }
          paramArrayList.add("java.util.Map");
          paramObject = (Map)paramObject;
          if (paramObject.size() <= 0) {
            break;
          }
          Object localObject = paramObject.keySet().iterator().next();
          paramObject = paramObject.get(localObject);
          paramArrayList.add(localObject.getClass().getName());
        }
      }
    }
    paramArrayList.add("?");
    paramArrayList.add("?");
    AppMethodBeat.o(98610);
    return;
    label257:
    paramArrayList.add(paramObject.getClass().getName());
    AppMethodBeat.o(98610);
  }
  
  private Object b(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(98608);
    if (this.b.containsKey(paramString)) {}
    for (paramString = this.b.get(paramString);; paramString = paramClassLoader)
    {
      AppMethodBeat.o(98608);
      return paramString;
      paramClassLoader = a.a(paramString, paramBoolean, paramClassLoader);
      this.b.put(paramString, paramClassLoader);
    }
  }
  
  private void b(String paramString, Object paramObject)
  {
    AppMethodBeat.i(98609);
    this.e.put(paramString, paramObject);
    AppMethodBeat.o(98609);
  }
  
  public <T> T a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    String str = null;
    AppMethodBeat.i(98607);
    if (!this.a.containsKey(paramString))
    {
      AppMethodBeat.o(98607);
      return null;
    }
    if (this.e.containsKey(paramString))
    {
      paramString = this.e.get(paramString);
      AppMethodBeat.o(98607);
      return paramString;
    }
    Object localObject = ((HashMap)this.a.get(paramString)).entrySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (Map.Entry)((Iterator)localObject).next();
      str = (String)((Map.Entry)localObject).getKey();
    }
    for (localObject = (byte[])((Map.Entry)localObject).getValue();; localObject = new byte[0]) {
      try
      {
        paramClassLoader = b(str, paramBoolean, paramClassLoader);
        this.d.a((byte[])localObject);
        this.d.a(this.c);
        paramClassLoader = this.d.a(paramClassLoader, 0, true);
        b(paramString, paramClassLoader);
        AppMethodBeat.o(98607);
        return paramClassLoader;
      }
      catch (Exception paramString)
      {
        paramString = new b(paramString);
        AppMethodBeat.o(98607);
        throw paramString;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public <T> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(98606);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("put key can not is null");
      AppMethodBeat.o(98606);
      throw paramString;
    }
    if (paramT == null)
    {
      paramString = new IllegalArgumentException("put value can not is null");
      AppMethodBeat.o(98606);
      throw paramString;
    }
    if ((paramT instanceof Set))
    {
      paramString = new IllegalArgumentException("can not support Set");
      AppMethodBeat.o(98606);
      throw paramString;
    }
    Object localObject = new l();
    ((l)localObject).a(this.c);
    ((l)localObject).a(paramT, 0);
    localObject = n.a(((l)localObject).a());
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    a(localArrayList, paramT);
    localHashMap.put(a.a(localArrayList), localObject);
    this.e.remove(paramString);
    this.a.put(paramString, localHashMap);
    AppMethodBeat.o(98606);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(98612);
    this.d.a(paramArrayOfByte);
    this.d.a(this.c);
    paramArrayOfByte = new HashMap(1);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("", new byte[0]);
    paramArrayOfByte.put("", localHashMap);
    this.a = this.d.a(paramArrayOfByte, 0, false);
    AppMethodBeat.o(98612);
  }
  
  public byte[] a()
  {
    AppMethodBeat.i(98611);
    Object localObject = new l(0);
    ((l)localObject).a(this.c);
    ((l)localObject).a(this.a, 0);
    localObject = n.a(((l)localObject).a());
    AppMethodBeat.o(98611);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.c
 * JD-Core Version:    0.7.0.1
 */