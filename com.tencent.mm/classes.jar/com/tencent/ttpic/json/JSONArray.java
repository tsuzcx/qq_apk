package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class JSONArray
{
  private final ArrayList myArrayList;
  
  public JSONArray()
  {
    AppMethodBeat.i(50057);
    this.myArrayList = new ArrayList();
    AppMethodBeat.o(50057);
  }
  
  public JSONArray(JSONTokener paramJSONTokener)
  {
    this();
    AppMethodBeat.i(50058);
    if (paramJSONTokener.nextClean() != '[')
    {
      paramJSONTokener = paramJSONTokener.syntaxError("A JSONArray text must start with '['");
      AppMethodBeat.o(50058);
      throw paramJSONTokener;
    }
    if (paramJSONTokener.nextClean() != ']')
    {
      paramJSONTokener.back();
      for (;;)
      {
        if (paramJSONTokener.nextClean() == ',')
        {
          paramJSONTokener.back();
          this.myArrayList.add(JSONObject.NULL);
        }
        for (;;)
        {
          switch (paramJSONTokener.nextClean())
          {
          default: 
            paramJSONTokener = paramJSONTokener.syntaxError("Expected a ',' or ']'");
            AppMethodBeat.o(50058);
            throw paramJSONTokener;
            paramJSONTokener.back();
            this.myArrayList.add(paramJSONTokener.nextValue());
          }
        }
        if (paramJSONTokener.nextClean() == ']')
        {
          AppMethodBeat.o(50058);
          return;
        }
        paramJSONTokener.back();
      }
      AppMethodBeat.o(50058);
      return;
    }
    AppMethodBeat.o(50058);
  }
  
  public JSONArray(Object paramObject)
  {
    this();
    AppMethodBeat.i(50061);
    if (paramObject.getClass().isArray())
    {
      int j = Array.getLength(paramObject);
      int i = 0;
      while (i < j)
      {
        put(JSONObject.wrap(Array.get(paramObject, i)));
        i += 1;
      }
      AppMethodBeat.o(50061);
      return;
    }
    paramObject = new JSONException("JSONArray initial value should be a string or collection or array.");
    AppMethodBeat.o(50061);
    throw paramObject;
  }
  
  public JSONArray(String paramString)
  {
    this(new JSONTokener(paramString));
    AppMethodBeat.i(50059);
    AppMethodBeat.o(50059);
  }
  
  public JSONArray(Collection paramCollection)
  {
    AppMethodBeat.i(50060);
    this.myArrayList = new ArrayList();
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        this.myArrayList.add(JSONObject.wrap(paramCollection.next()));
      }
    }
    AppMethodBeat.o(50060);
  }
  
  public Object get(int paramInt)
  {
    AppMethodBeat.i(50062);
    Object localObject = opt(paramInt);
    if (localObject == null)
    {
      localObject = new JSONException("JSONArray[" + paramInt + "] not found.");
      AppMethodBeat.o(50062);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(50062);
    return localObject;
  }
  
  public boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(50063);
    Object localObject = get(paramInt);
    if ((localObject.equals(Boolean.FALSE)) || (((localObject instanceof String)) && (((String)localObject).equalsIgnoreCase("false"))))
    {
      AppMethodBeat.o(50063);
      return false;
    }
    if ((localObject.equals(Boolean.TRUE)) || (((localObject instanceof String)) && (((String)localObject).equalsIgnoreCase("true"))))
    {
      AppMethodBeat.o(50063);
      return true;
    }
    localObject = new JSONException("JSONArray[" + paramInt + "] is not a boolean.");
    AppMethodBeat.o(50063);
    throw ((Throwable)localObject);
  }
  
  public double getDouble(int paramInt)
  {
    AppMethodBeat.i(50064);
    Object localObject = get(paramInt);
    try
    {
      if ((localObject instanceof Number))
      {
        d = ((Number)localObject).doubleValue();
        AppMethodBeat.o(50064);
        return d;
      }
      double d = Double.parseDouble((String)localObject);
      AppMethodBeat.o(50064);
      return d;
    }
    catch (Exception localException)
    {
      JSONException localJSONException = new JSONException("JSONArray[" + paramInt + "] is not a number.");
      AppMethodBeat.o(50064);
      throw localJSONException;
    }
  }
  
  public int getInt(int paramInt)
  {
    AppMethodBeat.i(50065);
    Object localObject = get(paramInt);
    try
    {
      if ((localObject instanceof Number))
      {
        i = ((Number)localObject).intValue();
        AppMethodBeat.o(50065);
        return i;
      }
      int i = Integer.parseInt((String)localObject);
      AppMethodBeat.o(50065);
      return i;
    }
    catch (Exception localException)
    {
      JSONException localJSONException = new JSONException("JSONArray[" + paramInt + "] is not a number.");
      AppMethodBeat.o(50065);
      throw localJSONException;
    }
  }
  
  public JSONArray getJSONArray(int paramInt)
  {
    AppMethodBeat.i(50066);
    Object localObject = get(paramInt);
    if ((localObject instanceof JSONArray))
    {
      localObject = (JSONArray)localObject;
      AppMethodBeat.o(50066);
      return localObject;
    }
    localObject = new JSONException("JSONArray[" + paramInt + "] is not a JSONArray.");
    AppMethodBeat.o(50066);
    throw ((Throwable)localObject);
  }
  
  public JSONObject getJSONObject(int paramInt)
  {
    AppMethodBeat.i(50067);
    Object localObject = get(paramInt);
    if ((localObject instanceof JSONObject))
    {
      localObject = (JSONObject)localObject;
      AppMethodBeat.o(50067);
      return localObject;
    }
    localObject = new JSONException("JSONArray[" + paramInt + "] is not a JSONObject.");
    AppMethodBeat.o(50067);
    throw ((Throwable)localObject);
  }
  
  public long getLong(int paramInt)
  {
    AppMethodBeat.i(50068);
    Object localObject = get(paramInt);
    try
    {
      if ((localObject instanceof Number))
      {
        l = ((Number)localObject).longValue();
        AppMethodBeat.o(50068);
        return l;
      }
      long l = Long.parseLong((String)localObject);
      AppMethodBeat.o(50068);
      return l;
    }
    catch (Exception localException)
    {
      JSONException localJSONException = new JSONException("JSONArray[" + paramInt + "] is not a number.");
      AppMethodBeat.o(50068);
      throw localJSONException;
    }
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(50069);
    Object localObject = get(paramInt);
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(50069);
      return localObject;
    }
    localObject = new JSONException("JSONArray[" + paramInt + "] not a string.");
    AppMethodBeat.o(50069);
    throw ((Throwable)localObject);
  }
  
  public boolean isNull(int paramInt)
  {
    AppMethodBeat.i(50070);
    boolean bool = JSONObject.NULL.equals(opt(paramInt));
    AppMethodBeat.o(50070);
    return bool;
  }
  
  public String join(String paramString)
  {
    AppMethodBeat.i(50071);
    int j = length();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuffer.append(paramString);
      }
      localStringBuffer.append(JSONObject.valueToString(this.myArrayList.get(i)));
      i += 1;
    }
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(50071);
    return paramString;
  }
  
  public int length()
  {
    AppMethodBeat.i(50072);
    int i = this.myArrayList.size();
    AppMethodBeat.o(50072);
    return i;
  }
  
  public Object opt(int paramInt)
  {
    AppMethodBeat.i(50073);
    if ((paramInt < 0) || (paramInt >= length()))
    {
      AppMethodBeat.o(50073);
      return null;
    }
    Object localObject = this.myArrayList.get(paramInt);
    AppMethodBeat.o(50073);
    return localObject;
  }
  
  public boolean optBoolean(int paramInt)
  {
    AppMethodBeat.i(50074);
    boolean bool = optBoolean(paramInt, false);
    AppMethodBeat.o(50074);
    return bool;
  }
  
  public boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(50075);
    try
    {
      boolean bool = getBoolean(paramInt);
      AppMethodBeat.o(50075);
      return bool;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50075);
    }
    return paramBoolean;
  }
  
  public double optDouble(int paramInt)
  {
    AppMethodBeat.i(50076);
    double d = optDouble(paramInt, (0.0D / 0.0D));
    AppMethodBeat.o(50076);
    return d;
  }
  
  public double optDouble(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(50077);
    try
    {
      double d = getDouble(paramInt);
      AppMethodBeat.o(50077);
      return d;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50077);
    }
    return paramDouble;
  }
  
  public int optInt(int paramInt)
  {
    AppMethodBeat.i(50078);
    paramInt = optInt(paramInt, 0);
    AppMethodBeat.o(50078);
    return paramInt;
  }
  
  public int optInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50079);
    try
    {
      paramInt1 = getInt(paramInt1);
      AppMethodBeat.o(50079);
      return paramInt1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50079);
    }
    return paramInt2;
  }
  
  public JSONArray optJSONArray(int paramInt)
  {
    AppMethodBeat.i(50080);
    Object localObject = opt(paramInt);
    if ((localObject instanceof JSONArray))
    {
      localObject = (JSONArray)localObject;
      AppMethodBeat.o(50080);
      return localObject;
    }
    AppMethodBeat.o(50080);
    return null;
  }
  
  public JSONObject optJSONObject(int paramInt)
  {
    AppMethodBeat.i(50081);
    Object localObject = opt(paramInt);
    if ((localObject instanceof JSONObject))
    {
      localObject = (JSONObject)localObject;
      AppMethodBeat.o(50081);
      return localObject;
    }
    AppMethodBeat.o(50081);
    return null;
  }
  
  public long optLong(int paramInt)
  {
    AppMethodBeat.i(50082);
    long l = optLong(paramInt, 0L);
    AppMethodBeat.o(50082);
    return l;
  }
  
  public long optLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(50083);
    try
    {
      long l = getLong(paramInt);
      AppMethodBeat.o(50083);
      return l;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50083);
    }
    return paramLong;
  }
  
  public String optString(int paramInt)
  {
    AppMethodBeat.i(50084);
    String str = optString(paramInt, "");
    AppMethodBeat.o(50084);
    return str;
  }
  
  public String optString(int paramInt, String paramString)
  {
    AppMethodBeat.i(50085);
    Object localObject = opt(paramInt);
    if (JSONObject.NULL.equals(localObject))
    {
      AppMethodBeat.o(50085);
      return paramString;
    }
    paramString = localObject.toString();
    AppMethodBeat.o(50085);
    return paramString;
  }
  
  public JSONArray put(double paramDouble)
  {
    AppMethodBeat.i(50088);
    Double localDouble = Double.valueOf(paramDouble);
    JSONObject.testValidity(localDouble);
    put(localDouble);
    AppMethodBeat.o(50088);
    return this;
  }
  
  public JSONArray put(int paramInt)
  {
    AppMethodBeat.i(50089);
    put(Integer.valueOf(paramInt));
    AppMethodBeat.o(50089);
    return this;
  }
  
  public JSONArray put(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(50095);
    put(paramInt, Double.valueOf(paramDouble));
    AppMethodBeat.o(50095);
    return this;
  }
  
  public JSONArray put(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50096);
    put(paramInt1, Integer.valueOf(paramInt2));
    AppMethodBeat.o(50096);
    return this;
  }
  
  public JSONArray put(int paramInt, long paramLong)
  {
    AppMethodBeat.i(50097);
    put(paramInt, new Long(paramLong));
    AppMethodBeat.o(50097);
    return this;
  }
  
  public JSONArray put(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(50099);
    JSONObject.testValidity(paramObject);
    if (paramInt < 0)
    {
      paramObject = new JSONException("JSONArray[" + paramInt + "] not found.");
      AppMethodBeat.o(50099);
      throw paramObject;
    }
    if (paramInt < length()) {
      this.myArrayList.set(paramInt, paramObject);
    }
    for (;;)
    {
      AppMethodBeat.o(50099);
      return this;
      while (paramInt != length()) {
        put(JSONObject.NULL);
      }
      put(paramObject);
    }
  }
  
  public JSONArray put(int paramInt, Collection paramCollection)
  {
    AppMethodBeat.i(50094);
    put(paramInt, new JSONArray(paramCollection));
    AppMethodBeat.o(50094);
    return this;
  }
  
  public JSONArray put(int paramInt, Map paramMap)
  {
    AppMethodBeat.i(50098);
    put(paramInt, new JSONObject(paramMap));
    AppMethodBeat.o(50098);
    return this;
  }
  
  public JSONArray put(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(50093);
    if (paramBoolean) {}
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      put(paramInt, localBoolean);
      AppMethodBeat.o(50093);
      return this;
    }
  }
  
  public JSONArray put(long paramLong)
  {
    AppMethodBeat.i(50090);
    put(new Long(paramLong));
    AppMethodBeat.o(50090);
    return this;
  }
  
  public JSONArray put(Object paramObject)
  {
    AppMethodBeat.i(50092);
    this.myArrayList.add(paramObject);
    AppMethodBeat.o(50092);
    return this;
  }
  
  public JSONArray put(Collection paramCollection)
  {
    AppMethodBeat.i(50087);
    put(new JSONArray(paramCollection));
    AppMethodBeat.o(50087);
    return this;
  }
  
  public JSONArray put(Map paramMap)
  {
    AppMethodBeat.i(50091);
    put(new JSONObject(paramMap));
    AppMethodBeat.o(50091);
    return this;
  }
  
  public JSONArray put(boolean paramBoolean)
  {
    AppMethodBeat.i(50086);
    if (paramBoolean) {}
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      put(localBoolean);
      AppMethodBeat.o(50086);
      return this;
    }
  }
  
  public Object remove(int paramInt)
  {
    AppMethodBeat.i(50100);
    Object localObject = opt(paramInt);
    this.myArrayList.remove(paramInt);
    AppMethodBeat.o(50100);
    return localObject;
  }
  
  public JSONObject toJSONObject(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(50101);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0) || (length() == 0))
    {
      AppMethodBeat.o(50101);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localJSONObject.put(paramJSONArray.getString(i), opt(i));
      i += 1;
    }
    AppMethodBeat.o(50101);
    return localJSONObject;
  }
  
  public String toString()
  {
    AppMethodBeat.i(50102);
    try
    {
      String str = toString(0);
      AppMethodBeat.o(50102);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50102);
    }
    return null;
  }
  
  public String toString(int paramInt)
  {
    AppMethodBeat.i(50103);
    Object localObject1 = new StringWriter();
    synchronized (((StringWriter)localObject1).getBuffer())
    {
      localObject1 = write((Writer)localObject1, paramInt, 0).toString();
      AppMethodBeat.o(50103);
      return localObject1;
    }
  }
  
  public Writer write(Writer paramWriter)
  {
    AppMethodBeat.i(50104);
    paramWriter = write(paramWriter, 0, 0);
    AppMethodBeat.o(50104);
    return paramWriter;
  }
  
  /* Error */
  Writer write(Writer paramWriter, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 384
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 237	com/tencent/ttpic/json/JSONArray:length	()I
    //   10: istore 6
    //   12: aload_1
    //   13: bipush 91
    //   15: invokevirtual 388	java/io/Writer:write	(I)V
    //   18: iload 6
    //   20: iconst_1
    //   21: if_icmpne +32 -> 53
    //   24: aload_1
    //   25: aload_0
    //   26: getfield 22	com/tencent/ttpic/json/JSONArray:myArrayList	Ljava/util/ArrayList;
    //   29: iconst_0
    //   30: invokevirtual 244	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   33: iload_2
    //   34: iload_3
    //   35: invokestatic 392	com/tencent/ttpic/json/JSONObject:writeValue	(Ljava/io/Writer;Ljava/lang/Object;II)Ljava/io/Writer;
    //   38: pop
    //   39: aload_1
    //   40: bipush 93
    //   42: invokevirtual 388	java/io/Writer:write	(I)V
    //   45: ldc_w 384
    //   48: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_1
    //   52: areturn
    //   53: iload 6
    //   55: ifeq -16 -> 39
    //   58: iload_3
    //   59: iload_2
    //   60: iadd
    //   61: istore 7
    //   63: iconst_0
    //   64: istore 4
    //   66: iconst_0
    //   67: istore 5
    //   69: iload 4
    //   71: iload 6
    //   73: if_icmpge +59 -> 132
    //   76: iload 5
    //   78: ifeq +9 -> 87
    //   81: aload_1
    //   82: bipush 44
    //   84: invokevirtual 388	java/io/Writer:write	(I)V
    //   87: iload_2
    //   88: ifle +9 -> 97
    //   91: aload_1
    //   92: bipush 10
    //   94: invokevirtual 388	java/io/Writer:write	(I)V
    //   97: aload_1
    //   98: iload 7
    //   100: invokestatic 396	com/tencent/ttpic/json/JSONObject:indent	(Ljava/io/Writer;I)V
    //   103: aload_1
    //   104: aload_0
    //   105: getfield 22	com/tencent/ttpic/json/JSONArray:myArrayList	Ljava/util/ArrayList;
    //   108: iload 4
    //   110: invokevirtual 244	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   113: iload_2
    //   114: iload 7
    //   116: invokestatic 392	com/tencent/ttpic/json/JSONObject:writeValue	(Ljava/io/Writer;Ljava/lang/Object;II)Ljava/io/Writer;
    //   119: pop
    //   120: iload 4
    //   122: iconst_1
    //   123: iadd
    //   124: istore 4
    //   126: iconst_1
    //   127: istore 5
    //   129: goto -60 -> 69
    //   132: iload_2
    //   133: ifle +9 -> 142
    //   136: aload_1
    //   137: bipush 10
    //   139: invokevirtual 388	java/io/Writer:write	(I)V
    //   142: aload_1
    //   143: iload_3
    //   144: invokestatic 396	com/tencent/ttpic/json/JSONObject:indent	(Ljava/io/Writer;I)V
    //   147: goto -108 -> 39
    //   150: astore_1
    //   151: new 92	com/tencent/ttpic/json/JSONException
    //   154: dup
    //   155: aload_1
    //   156: invokespecial 399	com/tencent/ttpic/json/JSONException:<init>	(Ljava/lang/Throwable;)V
    //   159: astore_1
    //   160: ldc_w 384
    //   163: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	JSONArray
    //   0	168	1	paramWriter	Writer
    //   0	168	2	paramInt1	int
    //   0	168	3	paramInt2	int
    //   64	61	4	i	int
    //   67	61	5	j	int
    //   10	64	6	k	int
    //   61	54	7	m	int
    // Exception table:
    //   from	to	target	type
    //   6	18	150	java/io/IOException
    //   24	39	150	java/io/IOException
    //   39	45	150	java/io/IOException
    //   81	87	150	java/io/IOException
    //   91	97	150	java/io/IOException
    //   97	120	150	java/io/IOException
    //   136	142	150	java/io/IOException
    //   142	147	150	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.json.JSONArray
 * JD-Core Version:    0.7.0.1
 */