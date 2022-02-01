package com.tencent.youtu.ytcommon.tools.wejson;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeJson
{
  private static final String EMPTY_ARR = "[]";
  private static final String EMPTY_MAP = "{}";
  
  private <T> T fromArr(JSONArray paramJSONArray, Class<T> paramClass)
  {
    AppMethodBeat.i(73425);
    paramClass = paramClass.getComponentType();
    Object localObject = Array.newInstance(paramClass, paramJSONArray.length());
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Array.set(localObject, i, fromJsonData(getObject(paramJSONArray, i), paramClass, paramClass));
      i += 1;
    }
    AppMethodBeat.o(73425);
    return localObject;
  }
  
  private <T> T fromJsonArr(JSONArray paramJSONArray, Class<T> paramClass, Class<?> paramClass1)
  {
    AppMethodBeat.i(73418);
    if (paramClass.equals(List.class))
    {
      paramJSONArray = fromList(paramJSONArray, paramClass, paramClass1);
      AppMethodBeat.o(73418);
      return paramJSONArray;
    }
    if (paramClass.isArray())
    {
      paramJSONArray = fromArr(paramJSONArray, paramClass);
      AppMethodBeat.o(73418);
      return paramJSONArray;
    }
    paramJSONArray = new WeJsonException("json 解析错误:不支持的类型:" + paramClass.getName());
    AppMethodBeat.o(73418);
    throw paramJSONArray;
  }
  
  private Object fromJsonData(Object paramObject, Class<?> paramClass1, Class<?> paramClass2)
  {
    AppMethodBeat.i(73424);
    if ((paramObject instanceof JSONArray))
    {
      paramObject = fromJsonArr((JSONArray)paramObject, paramClass1, paramClass2);
      AppMethodBeat.o(73424);
      return paramObject;
    }
    if ((paramObject instanceof JSONObject))
    {
      paramObject = fromJsonObj((JSONObject)paramObject, paramClass1, paramClass2);
      AppMethodBeat.o(73424);
      return paramObject;
    }
    AppMethodBeat.o(73424);
    return paramObject;
  }
  
  private <T> T fromJsonObj(JSONObject paramJSONObject, Class<T> paramClass, Class<?> paramClass1)
  {
    AppMethodBeat.i(73419);
    if (paramClass.equals(Map.class))
    {
      paramJSONObject = fromMap(paramJSONObject, paramClass, paramClass1);
      AppMethodBeat.o(73419);
      return paramJSONObject;
    }
    paramJSONObject = fromPojo(paramJSONObject, paramClass);
    AppMethodBeat.o(73419);
    return paramJSONObject;
  }
  
  private List fromList(JSONArray paramJSONArray, Class<List> paramClass, Class<?> paramClass1)
  {
    AppMethodBeat.i(73420);
    if (paramClass1 == null)
    {
      paramJSONArray = new WeJsonException("无法确定列表项的类型");
      AppMethodBeat.o(73420);
      throw paramJSONArray;
    }
    Object localObject1;
    int i;
    Object localObject2;
    if (paramClass.getName().equals("java.util.List"))
    {
      localObject1 = new ArrayList();
      i = 0;
      if (i >= paramJSONArray.length()) {
        break label178;
      }
      localObject2 = getObject(paramJSONArray, i);
      if (!(localObject2 instanceof JSONArray)) {
        break label135;
      }
      ((List)localObject1).add(fromJsonArr((JSONArray)localObject2, paramClass, paramClass1));
    }
    for (;;)
    {
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localObject1 = (List)paramClass.newInstance();
        }
        catch (Exception paramJSONArray)
        {
          paramJSONArray = new WeJsonException("创建List类型失败,该列表不支持无参实例化", paramJSONArray);
          AppMethodBeat.o(73420);
          throw paramJSONArray;
        }
      }
      label135:
      if ((localObject2 instanceof JSONObject)) {
        ((List)localObject1).add(fromJsonObj((JSONObject)localObject2, paramClass, paramClass1));
      } else {
        ((List)localObject1).add(localObject2);
      }
    }
    label178:
    AppMethodBeat.o(73420);
    return localObject1;
  }
  
  private Map fromMap(JSONObject paramJSONObject, Class<Map> paramClass, Class<?> paramClass1)
  {
    AppMethodBeat.i(73421);
    if (paramClass1 == null)
    {
      paramJSONObject = new WeJsonException("无法确定列表项的类型");
      AppMethodBeat.o(73421);
      throw paramJSONObject;
    }
    Object localObject1;
    Iterator localIterator;
    if (paramClass.getName().equals("java.util.Map"))
    {
      localObject1 = new HashMap();
      localIterator = paramJSONObject.keys();
    }
    for (;;)
    {
      String str;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label155;
        }
        str = (String)localIterator.next();
        Object localObject2 = getObject(paramJSONObject, str);
        if (localObject2 != null)
        {
          ((Map)localObject1).put(str, fromJsonData(localObject2, paramClass, paramClass1));
          continue;
          try
          {
            localObject1 = (Map)paramClass.newInstance();
          }
          catch (Exception paramJSONObject)
          {
            paramJSONObject = new WeJsonException("创建Map类型失败,该Map不支持无参实例化", paramJSONObject);
            AppMethodBeat.o(73421);
            throw paramJSONObject;
          }
        }
      }
      ((Map)localObject1).put(str, null);
    }
    label155:
    AppMethodBeat.o(73421);
    return localObject1;
  }
  
  private <T> T fromPojo(JSONObject paramJSONObject, Class<T> paramClass)
  {
    AppMethodBeat.i(73426);
    Object localObject2 = paramClass.getDeclaredFields();
    Object localObject3 = paramClass.getSuperclass();
    Object localObject1 = new Field[0];
    if (localObject3 != null) {
      localObject1 = ((Class)localObject3).getDeclaredFields();
    }
    localObject3 = new Field[localObject2.length + localObject1.length];
    int i = 0;
    while (i < localObject2.length)
    {
      localObject3[i] = localObject2[i];
      i += 1;
    }
    i = localObject2.length;
    while (i < localObject3.length)
    {
      localObject3[i] = localObject1[(i - localObject2.length)];
      i += 1;
    }
    if (localObject3.length == 0)
    {
      AppMethodBeat.o(73426);
      return null;
    }
    Object localObject4;
    Object localObject5;
    try
    {
      localObject4 = paramClass.newInstance();
      i = 0;
    }
    catch (Exception paramJSONObject)
    {
      try
      {
        int j;
        ((Field)localObject5).set(localObject4, localObject1);
        i += 1;
      }
      catch (IllegalAccessException paramJSONObject)
      {
        paramJSONObject = new WeJsonException("设置成员变量值失败.", paramJSONObject);
        AppMethodBeat.o(73426);
        throw paramJSONObject;
      }
      paramJSONObject = paramJSONObject;
      paramJSONObject = new WeJsonException("必须为该类型提供一个无参构造方法:" + paramClass.getName(), paramJSONObject);
      AppMethodBeat.o(73426);
      throw paramJSONObject;
    }
    if (i < localObject3.length)
    {
      localObject5 = localObject3[i];
      localObject2 = ((Field)localObject5).getName();
      if (!((String)localObject2).contains("$"))
      {
        j = ((Field)localObject5).getModifiers();
        localObject1 = paramJSONObject.opt((String)localObject2);
        if (localObject1 != null)
        {
          localObject1 = fromJsonData(localObject1, getMemberType(paramClass, (Field)localObject5), getSubType(paramClass, (Field)localObject5, localObject1));
          if (!JSONObject.NULL.equals(localObject1)) {
            break label424;
          }
          localObject1 = null;
        }
      }
    }
    label424:
    for (;;)
    {
      if ((j & 0x1) != 0) {}
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder("set").append(((String)localObject2).substring(0, 1).toUpperCase());
        if (((String)localObject2).length() == 1)
        {
          localObject2 = "";
          localObject2 = (String)localObject2;
          localObject5 = ((Field)localObject5).getType();
        }
        try
        {
          localObject2 = paramClass.getMethod((String)localObject2, new Class[] { localObject5 });
          try
          {
            ((Method)localObject2).invoke(localObject4, new Object[] { localObject1 });
          }
          catch (Exception paramJSONObject)
          {
            paramJSONObject = new WeJsonException("调用set方法失败.", paramJSONObject);
            AppMethodBeat.o(73426);
            throw paramJSONObject;
          }
          localObject2 = ((String)localObject2).substring(1);
        }
        catch (NoSuchMethodException localNoSuchMethodException) {}
        AppMethodBeat.o(73426);
        return localObject4;
      }
    }
  }
  
  private <T> Class<?> getMemberType(Class<T> paramClass, Field paramField)
  {
    AppMethodBeat.i(73427);
    if ((paramField.getGenericType() instanceof TypeVariable))
    {
      paramClass.getTypeParameters();
      paramField = paramClass.getGenericSuperclass();
      if ((paramField instanceof ParameterizedType))
      {
        paramClass = ((ParameterizedType)paramField).getActualTypeArguments()[0];
        if ((paramClass instanceof Class))
        {
          paramClass = (Class)paramClass;
          AppMethodBeat.o(73427);
          return paramClass;
        }
        paramClass = new WeJsonException("不支持嵌套泛型");
        AppMethodBeat.o(73427);
        throw paramClass;
      }
      paramClass = new WeJsonException("缺少泛型信息:".concat(String.valueOf(paramClass)));
      AppMethodBeat.o(73427);
      throw paramClass;
    }
    paramClass = paramField.getType();
    AppMethodBeat.o(73427);
    return paramClass;
  }
  
  private Object getObject(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(73422);
    try
    {
      paramJSONArray = paramJSONArray.get(paramInt);
      AppMethodBeat.o(73422);
      return paramJSONArray;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray = new WeJsonException("JSONArray.get() cause JSONException", paramJSONArray);
      AppMethodBeat.o(73422);
      throw paramJSONArray;
    }
  }
  
  private Object getObject(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(73423);
    try
    {
      paramJSONObject = paramJSONObject.get(paramString);
      AppMethodBeat.o(73423);
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject = new WeJsonException("JSONObject.get() cause JSONException", paramJSONObject);
      AppMethodBeat.o(73423);
      throw paramJSONObject;
    }
  }
  
  private <T> Class<?> getSubType(Class<T> paramClass, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(73428);
    if ((paramField.getGenericType() instanceof TypeVariable))
    {
      paramClass.getTypeParameters();
      paramField = paramClass.getGenericSuperclass();
      if ((paramField instanceof ParameterizedType))
      {
        paramClass = ((ParameterizedType)paramField).getActualTypeArguments()[0];
        if ((paramClass instanceof Class))
        {
          paramClass = (Class)paramClass;
          AppMethodBeat.o(73428);
          return paramClass;
        }
        paramClass = new WeJsonException("不支持嵌套泛型");
        AppMethodBeat.o(73428);
        throw paramClass;
      }
      paramClass = new WeJsonException("缺少泛型信息:".concat(String.valueOf(paramClass)));
      AppMethodBeat.o(73428);
      throw paramClass;
    }
    if (paramField.getType().equals(List.class))
    {
      paramClass = paramField.getGenericType();
      if ((paramClass instanceof ParameterizedType))
      {
        paramClass = ((ParameterizedType)paramClass).getActualTypeArguments()[0];
        if ((paramClass instanceof Class))
        {
          paramClass = (Class)paramClass;
          AppMethodBeat.o(73428);
          return paramClass;
        }
        paramClass = new WeJsonException("不支持嵌套泛型:" + paramField.getName());
        AppMethodBeat.o(73428);
        throw paramClass;
      }
      paramClass = new WeJsonException("缺少泛型类型声明:" + paramField.getName());
      AppMethodBeat.o(73428);
      throw paramClass;
    }
    if (paramField.getType().equals(Map.class))
    {
      paramClass = paramField.getGenericType();
      if ((paramClass instanceof ParameterizedType))
      {
        paramClass = ((ParameterizedType)paramClass).getActualTypeArguments()[1];
        if ((paramClass instanceof Class))
        {
          paramClass = (Class)paramClass;
          AppMethodBeat.o(73428);
          return paramClass;
        }
        paramClass = new WeJsonException("不支持嵌套泛型:" + paramField.getName());
        AppMethodBeat.o(73428);
        throw paramClass;
      }
      paramClass = new WeJsonException("缺少泛型类型声明:" + paramField.getName());
      AppMethodBeat.o(73428);
      throw paramClass;
    }
    paramClass = paramField.getType();
    AppMethodBeat.o(73428);
    return paramClass;
  }
  
  private String getValidStr(String paramString)
  {
    AppMethodBeat.i(73412);
    paramString = paramString.replace("\"", "\\\"").replace("\\", "\\\\").replace("\b", "\\b").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f").replace("\t", "\\t");
    AppMethodBeat.o(73412);
    return paramString;
  }
  
  private <T> boolean isPrimitivePackageType(T paramT)
  {
    return ((paramT instanceof Integer)) || ((paramT instanceof Short)) || ((paramT instanceof Long)) || ((paramT instanceof Byte)) || ((paramT instanceof Boolean)) || ((paramT instanceof Float)) || ((paramT instanceof Double)) || ((paramT instanceof Character));
  }
  
  private <T> void process(StringBuilder paramStringBuilder, T paramT)
  {
    AppMethodBeat.i(73411);
    if (paramT.getClass().isPrimitive())
    {
      paramStringBuilder.append(paramT);
      AppMethodBeat.o(73411);
      return;
    }
    if ((paramT instanceof String))
    {
      paramStringBuilder.append('"').append(getValidStr((String)paramT)).append('"');
      AppMethodBeat.o(73411);
      return;
    }
    if (isPrimitivePackageType(paramT))
    {
      paramStringBuilder.append(paramT);
      AppMethodBeat.o(73411);
      return;
    }
    if (paramT.getClass().isArray())
    {
      processArr(paramStringBuilder, (Object[])paramT);
      AppMethodBeat.o(73411);
      return;
    }
    if ((paramT instanceof Iterable))
    {
      processIterable(paramStringBuilder, (Iterable)paramT);
      AppMethodBeat.o(73411);
      return;
    }
    if ((paramT instanceof Map))
    {
      processMap(paramStringBuilder, (Map)paramT);
      AppMethodBeat.o(73411);
      return;
    }
    processObj(paramStringBuilder, paramT);
    AppMethodBeat.o(73411);
  }
  
  private <T> void processArr(StringBuilder paramStringBuilder, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(73416);
    if (paramArrayOfObject.length == 0)
    {
      paramStringBuilder.append("[]");
      AppMethodBeat.o(73416);
      return;
    }
    paramStringBuilder.append('[');
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      process(paramStringBuilder, paramArrayOfObject[i]);
      if (i < paramArrayOfObject.length - 1) {
        paramStringBuilder.append(',');
      }
      i += 1;
    }
    paramStringBuilder.append(']');
    AppMethodBeat.o(73416);
  }
  
  private void processIterable(StringBuilder paramStringBuilder, Iterable paramIterable)
  {
    AppMethodBeat.i(73415);
    paramIterable = paramIterable.iterator();
    paramStringBuilder.append('[');
    int i = 0;
    while (paramIterable.hasNext())
    {
      i += 1;
      process(paramStringBuilder, paramIterable.next());
      paramStringBuilder.append(',');
    }
    if (i > 0) {
      paramStringBuilder.deleteCharAt(paramStringBuilder.length() - 1);
    }
    paramStringBuilder.append(']');
    AppMethodBeat.o(73415);
  }
  
  private void processMap(StringBuilder paramStringBuilder, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(73413);
    if (paramMap.size() == 0)
    {
      paramStringBuilder.append("{}");
      AppMethodBeat.o(73413);
      return;
    }
    paramStringBuilder.append('{');
    int j = paramMap.size();
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      Object localObject = localEntry.getValue();
      String str = (String)localEntry.getKey();
      if ((str != null) && (!str.equals("")) && (localObject != null) && ((!(localObject instanceof String)) || (!localEntry.equals(""))))
      {
        paramStringBuilder.append('"').append(str).append('"');
        paramStringBuilder.append(':');
        process(paramStringBuilder, localObject);
        if (i < j - 1) {
          paramStringBuilder.append(',');
        }
        i += 1;
      }
    }
    paramStringBuilder.append('}');
    AppMethodBeat.o(73413);
  }
  
  private <T> void processObj(StringBuilder paramStringBuilder, T paramT)
  {
    int j = 0;
    AppMethodBeat.i(73414);
    Object localObject1 = paramT.getClass().getDeclaredFields();
    Object localObject3 = paramT.getClass().getSuperclass().getDeclaredFields();
    Object localObject2 = new Field[localObject1.length + localObject3.length];
    int i = 0;
    while (i < localObject1.length)
    {
      localObject2[i] = localObject1[i];
      i += 1;
    }
    i = localObject1.length;
    while (i < localObject2.length)
    {
      localObject2[i] = localObject3[(i - localObject1.length)];
      i += 1;
    }
    if (localObject2.length == 0)
    {
      paramStringBuilder.append("{}");
      AppMethodBeat.o(73414);
      return;
    }
    localObject3 = new HashMap();
    i = 0;
    for (;;)
    {
      if (i < localObject2.length) {
        localObject1 = localObject2[i];
      }
      try
      {
        int k = ((Field)localObject1).getModifiers();
        if ((k & 0x8) == 0)
        {
          String str = ((Field)localObject1).getName();
          if (!str.contains("$")) {
            if ((k & 0x1) != 0)
            {
              localObject1 = ((Field)localObject1).get(paramT);
              if (localObject1 != null) {
                ((Map)localObject3).put(str, localObject1);
              }
            }
            else
            {
              Class localClass = paramT.getClass();
              StringBuilder localStringBuilder = new StringBuilder("get").append(str.substring(0, 1).toUpperCase());
              if (str.length() == 1) {}
              for (localObject1 = "";; localObject1 = str.substring(1))
              {
                localObject1 = localClass.getMethod((String)localObject1, new Class[0]);
                if (localObject1 == null) {
                  break;
                }
                localObject1 = ((Method)localObject1).invoke(paramT, new Object[0]);
                if (localObject1 == null) {
                  break;
                }
                ((Map)localObject3).put(str, localObject1);
                break;
              }
              paramStringBuilder.append('{');
              k = ((Map)localObject3).size();
              paramT = ((Map)localObject3).entrySet().iterator();
              i = j;
              for (;;)
              {
                if (paramT.hasNext())
                {
                  localObject2 = (Map.Entry)paramT.next();
                  i += 1;
                  localObject1 = (String)((Map.Entry)localObject2).getKey();
                  localObject2 = ((Map.Entry)localObject2).getValue();
                  if ((!(localObject2 instanceof String)) || (!localObject2.equals("")))
                  {
                    paramStringBuilder.append('"').append((String)localObject1).append('"').append(':');
                    process(paramStringBuilder, localObject2);
                    if (i < k) {
                      paramStringBuilder.append(',');
                    }
                  }
                }
                else
                {
                  paramStringBuilder.append('}');
                  AppMethodBeat.o(73414);
                  return;
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        label480:
        break label480;
      }
      i += 1;
    }
  }
  
  public <T> T fromJson(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(73417);
    if (paramString == null)
    {
      AppMethodBeat.o(73417);
      return null;
    }
    if (paramClass == null)
    {
      paramString = new WeJsonException("必须指定classOfT");
      AppMethodBeat.o(73417);
      throw paramString;
    }
    paramString = paramString.trim();
    if (paramString.startsWith("[")) {
      try
      {
        paramString = fromJsonArr(new JSONArray(paramString), paramClass, null);
        if (paramString == null) {
          break label192;
        }
        AppMethodBeat.o(73417);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = new WeJsonException("json 解析错误" + paramString.getMessage(), paramString);
        AppMethodBeat.o(73417);
        throw paramString;
      }
    } else if (paramString.startsWith("{")) {
      try
      {
        paramString = fromJsonObj(new JSONObject(paramString), paramClass, null);
        AppMethodBeat.o(73417);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = new WeJsonException("json 解析错误:" + paramString.getMessage(), paramString);
        AppMethodBeat.o(73417);
        throw paramString;
      }
    }
    label192:
    paramString = new WeJsonException("classOfT 指定错误");
    AppMethodBeat.o(73417);
    throw paramString;
  }
  
  public <T> String toJson(T paramT)
  {
    AppMethodBeat.i(73409);
    paramT = toJson(paramT, 0);
    AppMethodBeat.o(73409);
    return paramT;
  }
  
  public <T> String toJson(T paramT, int paramInt)
  {
    AppMethodBeat.i(73410);
    if (paramT == null)
    {
      AppMethodBeat.o(73410);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    process(localStringBuilder, paramT);
    paramT = localStringBuilder.toString();
    AppMethodBeat.o(73410);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.wejson.WeJson
 * JD-Core Version:    0.7.0.1
 */