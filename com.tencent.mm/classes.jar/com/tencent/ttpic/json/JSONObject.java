package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;

public class JSONObject
{
  public static final Object NULL;
  private final Map map;
  
  static
  {
    AppMethodBeat.i(50180);
    NULL = new Null(null);
    AppMethodBeat.o(50180);
  }
  
  public JSONObject()
  {
    AppMethodBeat.i(50114);
    this.map = new HashMap();
    AppMethodBeat.o(50114);
  }
  
  public JSONObject(JSONObject paramJSONObject, String[] paramArrayOfString)
  {
    this();
    AppMethodBeat.i(50115);
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfString.length) {}
      try
      {
        putOnce(paramArrayOfString[i], paramJSONObject.opt(paramArrayOfString[i]));
        label32:
        i += 1;
        continue;
        AppMethodBeat.o(50115);
        return;
      }
      catch (Exception localException)
      {
        break label32;
      }
    }
  }
  
  public JSONObject(JSONTokener paramJSONTokener)
  {
    this();
    AppMethodBeat.i(50116);
    if (paramJSONTokener.nextClean() != '{')
    {
      paramJSONTokener = paramJSONTokener.syntaxError("A JSONObject text must begin with '{'");
      AppMethodBeat.o(50116);
      throw paramJSONTokener;
    }
    do
    {
      paramJSONTokener.back();
      String str;
      switch (paramJSONTokener.nextClean())
      {
      default: 
        paramJSONTokener.back();
        str = paramJSONTokener.nextValue().toString();
        if (paramJSONTokener.nextClean() != ':')
        {
          paramJSONTokener = paramJSONTokener.syntaxError("Expected a ':' after a key");
          AppMethodBeat.o(50116);
          throw paramJSONTokener;
        }
        break;
      case '\000': 
        paramJSONTokener = paramJSONTokener.syntaxError("A JSONObject text must end with '}'");
        AppMethodBeat.o(50116);
        throw paramJSONTokener;
      case '}': 
        AppMethodBeat.o(50116);
        return;
      }
      putOnce(str, paramJSONTokener.nextValue());
      switch (paramJSONTokener.nextClean())
      {
      default: 
        paramJSONTokener = paramJSONTokener.syntaxError("Expected a ',' or '}'");
        AppMethodBeat.o(50116);
        throw paramJSONTokener;
      }
    } while (paramJSONTokener.nextClean() != '}');
    AppMethodBeat.o(50116);
    return;
    AppMethodBeat.o(50116);
  }
  
  public JSONObject(Object paramObject)
  {
    this();
    AppMethodBeat.i(50118);
    populateMap(paramObject);
    AppMethodBeat.o(50118);
  }
  
  public JSONObject(Object paramObject, String[] paramArrayOfString)
  {
    this();
    AppMethodBeat.i(50119);
    Class localClass = paramObject.getClass();
    int i = 0;
    for (;;)
    {
      String str;
      if (i < paramArrayOfString.length) {
        str = paramArrayOfString[i];
      }
      try
      {
        putOpt(str, localClass.getField(str).get(paramObject));
        label46:
        i += 1;
        continue;
        AppMethodBeat.o(50119);
        return;
      }
      catch (Exception localException)
      {
        break label46;
      }
    }
  }
  
  public JSONObject(String paramString)
  {
    this(new JSONTokener(paramString));
    AppMethodBeat.i(50120);
    AppMethodBeat.o(50120);
  }
  
  public JSONObject(String paramString, Locale paramLocale)
  {
    this();
    AppMethodBeat.i(50121);
    ResourceBundle localResourceBundle = ResourceBundle.getBundle(paramString, paramLocale, Thread.currentThread().getContextClassLoader());
    Enumeration localEnumeration = localResourceBundle.getKeys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = localEnumeration.nextElement();
      if ((localObject instanceof String))
      {
        String[] arrayOfString = ((String)localObject).split("\\.");
        int j = arrayOfString.length - 1;
        int i = 0;
        for (paramLocale = this; i < j; paramLocale = paramString)
        {
          String str = arrayOfString[i];
          JSONObject localJSONObject = paramLocale.optJSONObject(str);
          paramString = localJSONObject;
          if (localJSONObject == null)
          {
            paramString = new JSONObject();
            paramLocale.put(str, paramString);
          }
          i += 1;
        }
        paramLocale.put(arrayOfString[j], localResourceBundle.getString((String)localObject));
      }
    }
    AppMethodBeat.o(50121);
  }
  
  public JSONObject(Map paramMap)
  {
    AppMethodBeat.i(50117);
    this.map = new HashMap();
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        Object localObject = localEntry.getValue();
        if (localObject != null) {
          this.map.put(localEntry.getKey(), wrap(localObject));
        }
      }
    }
    AppMethodBeat.o(50117);
  }
  
  public static String doubleToString(double paramDouble)
  {
    AppMethodBeat.i(50124);
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble)))
    {
      AppMethodBeat.o(50124);
      return "null";
    }
    String str2 = Double.toString(paramDouble);
    String str1 = str2;
    if (str2.indexOf('.') > 0)
    {
      str1 = str2;
      if (str2.indexOf('e') < 0)
      {
        str1 = str2;
        if (str2.indexOf('E') < 0)
        {
          while (str2.endsWith("0")) {
            str2 = str2.substring(0, str2.length() - 1);
          }
          str1 = str2;
          if (str2.endsWith(".")) {
            str1 = str2.substring(0, str2.length() - 1);
          }
        }
      }
    }
    AppMethodBeat.o(50124);
    return str1;
  }
  
  public static String[] getNames(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50132);
    int i = paramJSONObject.length();
    if (i == 0)
    {
      AppMethodBeat.o(50132);
      return null;
    }
    paramJSONObject = paramJSONObject.keys();
    String[] arrayOfString = new String[i];
    i = 0;
    while (paramJSONObject.hasNext())
    {
      arrayOfString[i] = ((String)paramJSONObject.next());
      i += 1;
    }
    AppMethodBeat.o(50132);
    return arrayOfString;
  }
  
  public static String[] getNames(Object paramObject)
  {
    AppMethodBeat.i(50133);
    if (paramObject == null)
    {
      AppMethodBeat.o(50133);
      return null;
    }
    paramObject = paramObject.getClass().getFields();
    int j = paramObject.length;
    if (j == 0)
    {
      AppMethodBeat.o(50133);
      return null;
    }
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = paramObject[i].getName();
      i += 1;
    }
    AppMethodBeat.o(50133);
    return arrayOfString;
  }
  
  static final void indent(Writer paramWriter, int paramInt)
  {
    AppMethodBeat.i(50178);
    int i = 0;
    while (i < paramInt)
    {
      paramWriter.write(32);
      i += 1;
    }
    AppMethodBeat.o(50178);
  }
  
  public static String numberToString(Number paramNumber)
  {
    AppMethodBeat.i(50142);
    if (paramNumber == null)
    {
      paramNumber = new JSONException("Null pointer");
      AppMethodBeat.o(50142);
      throw paramNumber;
    }
    testValidity(paramNumber);
    String str = paramNumber.toString();
    paramNumber = str;
    if (str.indexOf('.') > 0)
    {
      paramNumber = str;
      if (str.indexOf('e') < 0)
      {
        paramNumber = str;
        if (str.indexOf('E') < 0)
        {
          while (str.endsWith("0")) {
            str = str.substring(0, str.length() - 1);
          }
          paramNumber = str;
          if (str.endsWith(".")) {
            paramNumber = str.substring(0, str.length() - 1);
          }
        }
      }
    }
    AppMethodBeat.o(50142);
    return paramNumber;
  }
  
  private void populateMap(Object paramObject)
  {
    int j = 0;
    AppMethodBeat.i(50156);
    Object localObject1 = paramObject.getClass();
    int i;
    Method[] arrayOfMethod;
    label37:
    Method localMethod;
    if (((Class)localObject1).getClassLoader() != null)
    {
      i = 1;
      if (i == 0) {
        break label197;
      }
      arrayOfMethod = ((Class)localObject1).getMethods();
      i = j;
      if (i >= arrayOfMethod.length) {
        break label295;
      }
      localMethod = arrayOfMethod[i];
    }
    try
    {
      if (!Modifier.isPublic(localMethod.getModifiers())) {
        break label185;
      }
      localObject2 = localMethod.getName();
      localObject1 = "";
      if (!((String)localObject2).startsWith("get")) {
        break label220;
      }
      if ("getClass".equals(localObject2)) {
        break label307;
      }
      if (!"getDeclaringClass".equals(localObject2)) {
        break label209;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        label109:
        continue;
        String str = "";
      }
    }
    if ((((String)localObject1).length() > 0) && (Character.isUpperCase(((String)localObject1).charAt(0))) && (localMethod.getParameterTypes().length == 0))
    {
      if (((String)localObject1).length() != 1) {
        break label242;
      }
      localObject2 = ((String)localObject1).toLowerCase();
    }
    for (;;)
    {
      localObject1 = localMethod.invoke(paramObject, null);
      if (localObject1 != null) {
        this.map.put(localObject2, wrap(localObject1));
      }
      label185:
      i += 1;
      break label37;
      i = 0;
      break;
      label197:
      arrayOfMethod = ((Class)localObject1).getDeclaredMethods();
      i = j;
      break label37;
      label209:
      localObject1 = ((String)localObject2).substring(3);
      break label109;
      label220:
      if (!((String)localObject2).startsWith("is")) {
        break label109;
      }
      localObject1 = ((String)localObject2).substring(2);
      break label109;
      label242:
      localObject2 = localObject1;
      if (!Character.isUpperCase(((String)localObject1).charAt(1))) {
        localObject2 = ((String)localObject1).substring(0, 1).toLowerCase() + ((String)localObject1).substring(1);
      }
    }
    label295:
    AppMethodBeat.o(50156);
  }
  
  public static Writer quote(String paramString, Writer paramWriter)
  {
    AppMethodBeat.i(50167);
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramWriter.write("\"\"");
      AppMethodBeat.o(50167);
      return paramWriter;
    }
    int m = paramString.length();
    paramWriter.write(34);
    int i = 0;
    int j = 0;
    if (i < m)
    {
      int k = paramString.charAt(i);
      switch (k)
      {
      default: 
        if ((k < 32) || ((k >= 128) && (k < 160)) || ((k >= 8192) && (k < 8448)))
        {
          paramWriter.write("\\u");
          String str = Integer.toHexString(k);
          paramWriter.write("0000", 0, 4 - str.length());
          paramWriter.write(str);
        }
        break;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        paramWriter.write(92);
        paramWriter.write(k);
        continue;
        if (j == 60) {
          paramWriter.write(92);
        }
        paramWriter.write(k);
        continue;
        paramWriter.write("\\b");
        continue;
        paramWriter.write("\\t");
        continue;
        paramWriter.write("\\n");
        continue;
        paramWriter.write("\\f");
        continue;
        paramWriter.write("\\r");
      }
    }
    paramWriter.write(34);
    AppMethodBeat.o(50167);
    return paramWriter;
  }
  
  public static String quote(String paramString)
  {
    AppMethodBeat.i(50166);
    StringWriter localStringWriter = new StringWriter();
    synchronized (localStringWriter.getBuffer())
    {
      try
      {
        paramString = quote(paramString, localStringWriter).toString();
        AppMethodBeat.o(50166);
        return paramString;
      }
      catch (IOException paramString)
      {
        AppMethodBeat.o(50166);
        return "";
      }
    }
  }
  
  public static Object stringToValue(String paramString)
  {
    AppMethodBeat.i(50169);
    if (paramString.equals(""))
    {
      AppMethodBeat.o(50169);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("true"))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(50169);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("false"))
    {
      paramString = Boolean.FALSE;
      AppMethodBeat.o(50169);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("null"))
    {
      paramString = NULL;
      AppMethodBeat.o(50169);
      return paramString;
    }
    int i = paramString.charAt(0);
    if (((i >= 48) && (i <= 57)) || (i == 45)) {
      try
      {
        Object localObject;
        if ((paramString.indexOf('.') >= 0) || (paramString.indexOf('e') >= 0) || (paramString.indexOf('E') >= 0))
        {
          localObject = Double.valueOf(paramString);
          if (!((Double)localObject).isInfinite())
          {
            boolean bool = ((Double)localObject).isNaN();
            if (!bool)
            {
              AppMethodBeat.o(50169);
              return localObject;
            }
          }
        }
        else
        {
          localObject = new Long(paramString);
          if (paramString.equals(((Long)localObject).toString()))
          {
            if (((Long)localObject).longValue() == ((Long)localObject).intValue())
            {
              localObject = new Integer(((Long)localObject).intValue());
              AppMethodBeat.o(50169);
              return localObject;
            }
            AppMethodBeat.o(50169);
            return localObject;
          }
        }
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(50169);
    return paramString;
  }
  
  public static void testValidity(Object paramObject)
  {
    AppMethodBeat.i(50170);
    if (paramObject != null) {
      if ((paramObject instanceof Double))
      {
        if ((((Double)paramObject).isInfinite()) || (((Double)paramObject).isNaN()))
        {
          paramObject = new JSONException("JSON does not allow non-finite numbers.");
          AppMethodBeat.o(50170);
          throw paramObject;
        }
      }
      else if (((paramObject instanceof Float)) && ((((Float)paramObject).isInfinite()) || (((Float)paramObject).isNaN())))
      {
        paramObject = new JSONException("JSON does not allow non-finite numbers.");
        AppMethodBeat.o(50170);
        throw paramObject;
      }
    }
    AppMethodBeat.o(50170);
  }
  
  public static String valueToString(Object paramObject)
  {
    AppMethodBeat.i(50174);
    if ((paramObject == null) || (paramObject.equals(null)))
    {
      AppMethodBeat.o(50174);
      return "null";
    }
    if ((paramObject instanceof JSONString))
    {
      try
      {
        paramObject = ((JSONString)paramObject).toJSONString();
        if ((paramObject instanceof String))
        {
          paramObject = (String)paramObject;
          AppMethodBeat.o(50174);
          return paramObject;
        }
      }
      catch (Exception paramObject)
      {
        paramObject = new JSONException(paramObject);
        AppMethodBeat.o(50174);
        throw paramObject;
      }
      paramObject = new JSONException("Bad value from toJSONString: ".concat(String.valueOf(paramObject)));
      AppMethodBeat.o(50174);
      throw paramObject;
    }
    if ((paramObject instanceof Number))
    {
      paramObject = numberToString((Number)paramObject);
      AppMethodBeat.o(50174);
      return paramObject;
    }
    if (((paramObject instanceof Boolean)) || ((paramObject instanceof JSONObject)) || ((paramObject instanceof JSONArray)))
    {
      paramObject = paramObject.toString();
      AppMethodBeat.o(50174);
      return paramObject;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = new JSONObject((Map)paramObject).toString();
      AppMethodBeat.o(50174);
      return paramObject;
    }
    if ((paramObject instanceof Collection))
    {
      paramObject = new JSONArray((Collection)paramObject).toString();
      AppMethodBeat.o(50174);
      return paramObject;
    }
    if (paramObject.getClass().isArray())
    {
      paramObject = new JSONArray(paramObject).toString();
      AppMethodBeat.o(50174);
      return paramObject;
    }
    paramObject = quote(paramObject.toString());
    AppMethodBeat.o(50174);
    return paramObject;
  }
  
  public static Object wrap(Object paramObject)
  {
    AppMethodBeat.i(50175);
    if (paramObject == null) {}
    try
    {
      paramObject = NULL;
      AppMethodBeat.o(50175);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      boolean bool;
      Object localObject;
      AppMethodBeat.o(50175);
    }
    if ((!(paramObject instanceof JSONObject)) && (!(paramObject instanceof JSONArray)) && (!NULL.equals(paramObject)) && (!(paramObject instanceof JSONString)) && (!(paramObject instanceof Byte)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Long)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Double)))
    {
      bool = paramObject instanceof String;
      if (!bool) {}
    }
    else
    {
      AppMethodBeat.o(50175);
      return paramObject;
    }
    if ((paramObject instanceof Collection))
    {
      paramObject = new JSONArray((Collection)paramObject);
      AppMethodBeat.o(50175);
      return paramObject;
    }
    if (paramObject.getClass().isArray())
    {
      paramObject = new JSONArray(paramObject);
      AppMethodBeat.o(50175);
      return paramObject;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = new JSONObject((Map)paramObject);
      AppMethodBeat.o(50175);
      return paramObject;
    }
    localObject = paramObject.getClass().getPackage();
    if (localObject != null) {}
    for (localObject = ((Package)localObject).getName(); (((String)localObject).startsWith("java.")) || (((String)localObject).startsWith("javax.")) || (paramObject.getClass().getClassLoader() == null); localObject = "")
    {
      paramObject = paramObject.toString();
      AppMethodBeat.o(50175);
      return paramObject;
    }
    paramObject = new JSONObject(paramObject);
    AppMethodBeat.o(50175);
    return paramObject;
    return null;
  }
  
  static final Writer writeValue(Writer paramWriter, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50177);
    if ((paramObject == null) || (paramObject.equals(null))) {
      paramWriter.write("null");
    }
    for (;;)
    {
      AppMethodBeat.o(50177);
      return paramWriter;
      if ((paramObject instanceof JSONObject))
      {
        ((JSONObject)paramObject).write(paramWriter, paramInt1, paramInt2);
      }
      else if ((paramObject instanceof JSONArray))
      {
        ((JSONArray)paramObject).write(paramWriter, paramInt1, paramInt2);
      }
      else if ((paramObject instanceof Map))
      {
        new JSONObject((Map)paramObject).write(paramWriter, paramInt1, paramInt2);
      }
      else if ((paramObject instanceof Collection))
      {
        new JSONArray((Collection)paramObject).write(paramWriter, paramInt1, paramInt2);
      }
      else if (paramObject.getClass().isArray())
      {
        new JSONArray(paramObject).write(paramWriter, paramInt1, paramInt2);
      }
      else if ((paramObject instanceof Number))
      {
        paramWriter.write(numberToString((Number)paramObject));
      }
      else if ((paramObject instanceof Boolean))
      {
        paramWriter.write(paramObject.toString());
      }
      else
      {
        if ((paramObject instanceof JSONString)) {
          for (;;)
          {
            try
            {
              String str = ((JSONString)paramObject).toJSONString();
              if (str != null)
              {
                paramObject = str.toString();
                paramWriter.write(paramObject);
              }
            }
            catch (Exception paramWriter)
            {
              paramWriter = new JSONException(paramWriter);
              AppMethodBeat.o(50177);
              throw paramWriter;
            }
            paramObject = quote(paramObject.toString());
          }
        }
        quote(paramObject.toString(), paramWriter);
      }
    }
  }
  
  public JSONObject accumulate(String paramString, Object paramObject)
  {
    AppMethodBeat.i(50122);
    testValidity(paramObject);
    Object localObject = opt(paramString);
    if (localObject == null)
    {
      localObject = paramObject;
      if ((paramObject instanceof JSONArray)) {
        localObject = new JSONArray().put(paramObject);
      }
      put(paramString, localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(50122);
      return this;
      if ((localObject instanceof JSONArray)) {
        ((JSONArray)localObject).put(paramObject);
      } else {
        put(paramString, new JSONArray().put(localObject).put(paramObject));
      }
    }
  }
  
  public JSONObject append(String paramString, Object paramObject)
  {
    AppMethodBeat.i(50123);
    testValidity(paramObject);
    Object localObject = opt(paramString);
    if (localObject == null) {
      put(paramString, new JSONArray().put(paramObject));
    }
    for (;;)
    {
      AppMethodBeat.o(50123);
      return this;
      if (!(localObject instanceof JSONArray)) {
        break;
      }
      put(paramString, ((JSONArray)localObject).put(paramObject));
    }
    paramString = new JSONException("JSONObject[" + paramString + "] is not a JSONArray.");
    AppMethodBeat.o(50123);
    throw paramString;
  }
  
  public Object get(String paramString)
  {
    AppMethodBeat.i(50125);
    if (paramString == null)
    {
      paramString = new JSONException("Null key.");
      AppMethodBeat.o(50125);
      throw paramString;
    }
    Object localObject = opt(paramString);
    if (localObject == null)
    {
      paramString = new JSONException("JSONObject[" + quote(paramString) + "] not found.");
      AppMethodBeat.o(50125);
      throw paramString;
    }
    AppMethodBeat.o(50125);
    return localObject;
  }
  
  public boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(50126);
    Object localObject = get(paramString);
    if ((localObject.equals(Boolean.FALSE)) || (((localObject instanceof String)) && (((String)localObject).equalsIgnoreCase("false"))))
    {
      AppMethodBeat.o(50126);
      return false;
    }
    if ((localObject.equals(Boolean.TRUE)) || (((localObject instanceof String)) && (((String)localObject).equalsIgnoreCase("true"))))
    {
      AppMethodBeat.o(50126);
      return true;
    }
    paramString = new JSONException("JSONObject[" + quote(paramString) + "] is not a Boolean.");
    AppMethodBeat.o(50126);
    throw paramString;
  }
  
  public double getDouble(String paramString)
  {
    AppMethodBeat.i(50127);
    Object localObject = get(paramString);
    try
    {
      if ((localObject instanceof Number))
      {
        d = ((Number)localObject).doubleValue();
        AppMethodBeat.o(50127);
        return d;
      }
      double d = Double.parseDouble((String)localObject);
      AppMethodBeat.o(50127);
      return d;
    }
    catch (Exception localException)
    {
      paramString = new JSONException("JSONObject[" + quote(paramString) + "] is not a number.");
      AppMethodBeat.o(50127);
      throw paramString;
    }
  }
  
  public int getInt(String paramString)
  {
    AppMethodBeat.i(50128);
    Object localObject = get(paramString);
    try
    {
      if ((localObject instanceof Number))
      {
        i = ((Number)localObject).intValue();
        AppMethodBeat.o(50128);
        return i;
      }
      int i = Integer.parseInt((String)localObject);
      AppMethodBeat.o(50128);
      return i;
    }
    catch (Exception localException)
    {
      paramString = new JSONException("JSONObject[" + quote(paramString) + "] is not an int.");
      AppMethodBeat.o(50128);
      throw paramString;
    }
  }
  
  public JSONArray getJSONArray(String paramString)
  {
    AppMethodBeat.i(50129);
    Object localObject = get(paramString);
    if ((localObject instanceof JSONArray))
    {
      paramString = (JSONArray)localObject;
      AppMethodBeat.o(50129);
      return paramString;
    }
    paramString = new JSONException("JSONObject[" + quote(paramString) + "] is not a JSONArray.");
    AppMethodBeat.o(50129);
    throw paramString;
  }
  
  public JSONObject getJSONObject(String paramString)
  {
    AppMethodBeat.i(50130);
    Object localObject = get(paramString);
    if ((localObject instanceof JSONObject))
    {
      paramString = (JSONObject)localObject;
      AppMethodBeat.o(50130);
      return paramString;
    }
    paramString = new JSONException("JSONObject[" + quote(paramString) + "] is not a JSONObject.");
    AppMethodBeat.o(50130);
    throw paramString;
  }
  
  public long getLong(String paramString)
  {
    AppMethodBeat.i(50131);
    Object localObject = get(paramString);
    try
    {
      if ((localObject instanceof Number))
      {
        l = ((Number)localObject).longValue();
        AppMethodBeat.o(50131);
        return l;
      }
      long l = Long.parseLong((String)localObject);
      AppMethodBeat.o(50131);
      return l;
    }
    catch (Exception localException)
    {
      paramString = new JSONException("JSONObject[" + quote(paramString) + "] is not a long.");
      AppMethodBeat.o(50131);
      throw paramString;
    }
  }
  
  public String getString(String paramString)
  {
    AppMethodBeat.i(50134);
    Object localObject = get(paramString);
    if ((localObject instanceof String))
    {
      paramString = (String)localObject;
      AppMethodBeat.o(50134);
      return paramString;
    }
    paramString = new JSONException("JSONObject[" + quote(paramString) + "] not a string.");
    AppMethodBeat.o(50134);
    throw paramString;
  }
  
  public boolean has(String paramString)
  {
    AppMethodBeat.i(50135);
    boolean bool = this.map.containsKey(paramString);
    AppMethodBeat.o(50135);
    return bool;
  }
  
  public JSONObject increment(String paramString)
  {
    AppMethodBeat.i(50136);
    Object localObject = opt(paramString);
    if (localObject == null) {
      put(paramString, 1);
    }
    for (;;)
    {
      AppMethodBeat.o(50136);
      return this;
      if ((localObject instanceof Integer))
      {
        put(paramString, ((Integer)localObject).intValue() + 1);
      }
      else if ((localObject instanceof Long))
      {
        put(paramString, ((Long)localObject).longValue() + 1L);
      }
      else if ((localObject instanceof Double))
      {
        put(paramString, ((Double)localObject).doubleValue() + 1.0D);
      }
      else
      {
        if (!(localObject instanceof Float)) {
          break;
        }
        put(paramString, ((Float)localObject).floatValue() + 1.0F);
      }
    }
    paramString = new JSONException("Unable to increment [" + quote(paramString) + "].");
    AppMethodBeat.o(50136);
    throw paramString;
  }
  
  public boolean isNull(String paramString)
  {
    AppMethodBeat.i(50137);
    boolean bool = NULL.equals(opt(paramString));
    AppMethodBeat.o(50137);
    return bool;
  }
  
  public Set keySet()
  {
    AppMethodBeat.i(50139);
    Set localSet = this.map.keySet();
    AppMethodBeat.o(50139);
    return localSet;
  }
  
  public Iterator keys()
  {
    AppMethodBeat.i(50138);
    Iterator localIterator = keySet().iterator();
    AppMethodBeat.o(50138);
    return localIterator;
  }
  
  public int length()
  {
    AppMethodBeat.i(50140);
    int i = this.map.size();
    AppMethodBeat.o(50140);
    return i;
  }
  
  public JSONArray names()
  {
    AppMethodBeat.i(50141);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = keys();
    while (localIterator.hasNext()) {
      localJSONArray.put(localIterator.next());
    }
    if (localJSONArray.length() == 0)
    {
      AppMethodBeat.o(50141);
      return null;
    }
    AppMethodBeat.o(50141);
    return localJSONArray;
  }
  
  public Object opt(String paramString)
  {
    AppMethodBeat.i(50143);
    if (paramString == null)
    {
      AppMethodBeat.o(50143);
      return null;
    }
    paramString = this.map.get(paramString);
    AppMethodBeat.o(50143);
    return paramString;
  }
  
  public boolean optBoolean(String paramString)
  {
    AppMethodBeat.i(50144);
    boolean bool = optBoolean(paramString, false);
    AppMethodBeat.o(50144);
    return bool;
  }
  
  public boolean optBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(50145);
    try
    {
      boolean bool = getBoolean(paramString);
      AppMethodBeat.o(50145);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(50145);
    }
    return paramBoolean;
  }
  
  public double optDouble(String paramString)
  {
    AppMethodBeat.i(50146);
    double d = optDouble(paramString, (0.0D / 0.0D));
    AppMethodBeat.o(50146);
    return d;
  }
  
  public double optDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(50147);
    try
    {
      double d = getDouble(paramString);
      AppMethodBeat.o(50147);
      return d;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(50147);
    }
    return paramDouble;
  }
  
  public int optInt(String paramString)
  {
    AppMethodBeat.i(50148);
    int i = optInt(paramString, 0);
    AppMethodBeat.o(50148);
    return i;
  }
  
  public int optInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(50149);
    try
    {
      int i = getInt(paramString);
      AppMethodBeat.o(50149);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(50149);
    }
    return paramInt;
  }
  
  public JSONArray optJSONArray(String paramString)
  {
    AppMethodBeat.i(50150);
    paramString = opt(paramString);
    if ((paramString instanceof JSONArray))
    {
      paramString = (JSONArray)paramString;
      AppMethodBeat.o(50150);
      return paramString;
    }
    AppMethodBeat.o(50150);
    return null;
  }
  
  public JSONObject optJSONObject(String paramString)
  {
    AppMethodBeat.i(50151);
    paramString = opt(paramString);
    if ((paramString instanceof JSONObject))
    {
      paramString = (JSONObject)paramString;
      AppMethodBeat.o(50151);
      return paramString;
    }
    AppMethodBeat.o(50151);
    return null;
  }
  
  public long optLong(String paramString)
  {
    AppMethodBeat.i(50152);
    long l = optLong(paramString, 0L);
    AppMethodBeat.o(50152);
    return l;
  }
  
  public long optLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(50153);
    try
    {
      long l = getLong(paramString);
      AppMethodBeat.o(50153);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(50153);
    }
    return paramLong;
  }
  
  public String optString(String paramString)
  {
    AppMethodBeat.i(50154);
    paramString = optString(paramString, "");
    AppMethodBeat.o(50154);
    return paramString;
  }
  
  public String optString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50155);
    paramString1 = opt(paramString1);
    if (NULL.equals(paramString1))
    {
      AppMethodBeat.o(50155);
      return paramString2;
    }
    paramString1 = paramString1.toString();
    AppMethodBeat.o(50155);
    return paramString1;
  }
  
  public JSONObject put(String paramString, double paramDouble)
  {
    AppMethodBeat.i(50159);
    put(paramString, Double.valueOf(paramDouble));
    AppMethodBeat.o(50159);
    return this;
  }
  
  public JSONObject put(String paramString, int paramInt)
  {
    AppMethodBeat.i(50160);
    put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(50160);
    return this;
  }
  
  public JSONObject put(String paramString, long paramLong)
  {
    AppMethodBeat.i(50161);
    put(paramString, new Long(paramLong));
    AppMethodBeat.o(50161);
    return this;
  }
  
  public JSONObject put(String paramString, Object paramObject)
  {
    AppMethodBeat.i(50163);
    if (paramString == null)
    {
      paramString = new NullPointerException("Null key.");
      AppMethodBeat.o(50163);
      throw paramString;
    }
    if (paramObject != null)
    {
      testValidity(paramObject);
      this.map.put(paramString, paramObject);
    }
    for (;;)
    {
      AppMethodBeat.o(50163);
      return this;
      remove(paramString);
    }
  }
  
  public JSONObject put(String paramString, Collection paramCollection)
  {
    AppMethodBeat.i(50158);
    put(paramString, new JSONArray(paramCollection));
    AppMethodBeat.o(50158);
    return this;
  }
  
  public JSONObject put(String paramString, Map paramMap)
  {
    AppMethodBeat.i(50162);
    put(paramString, new JSONObject(paramMap));
    AppMethodBeat.o(50162);
    return this;
  }
  
  public JSONObject put(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(50157);
    if (paramBoolean) {}
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      put(paramString, localBoolean);
      AppMethodBeat.o(50157);
      return this;
    }
  }
  
  public JSONObject putOnce(String paramString, Object paramObject)
  {
    AppMethodBeat.i(50164);
    if ((paramString != null) && (paramObject != null))
    {
      if (opt(paramString) != null)
      {
        paramString = new JSONException("Duplicate key \"" + paramString + "\"");
        AppMethodBeat.o(50164);
        throw paramString;
      }
      put(paramString, paramObject);
    }
    AppMethodBeat.o(50164);
    return this;
  }
  
  public JSONObject putOpt(String paramString, Object paramObject)
  {
    AppMethodBeat.i(50165);
    if ((paramString != null) && (paramObject != null)) {
      put(paramString, paramObject);
    }
    AppMethodBeat.o(50165);
    return this;
  }
  
  public Object remove(String paramString)
  {
    AppMethodBeat.i(50168);
    paramString = this.map.remove(paramString);
    AppMethodBeat.o(50168);
    return paramString;
  }
  
  public JSONArray toJSONArray(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(50171);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(50171);
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localJSONArray.put(opt(paramJSONArray.getString(i)));
      i += 1;
    }
    AppMethodBeat.o(50171);
    return localJSONArray;
  }
  
  public String toString()
  {
    AppMethodBeat.i(50172);
    try
    {
      String str = toString(0);
      AppMethodBeat.o(50172);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50172);
    }
    return null;
  }
  
  public String toString(int paramInt)
  {
    AppMethodBeat.i(50173);
    Object localObject1 = new StringWriter();
    synchronized (((StringWriter)localObject1).getBuffer())
    {
      localObject1 = write((Writer)localObject1, paramInt, 0).toString();
      AppMethodBeat.o(50173);
      return localObject1;
    }
  }
  
  public Writer write(Writer paramWriter)
  {
    AppMethodBeat.i(50176);
    paramWriter = write(paramWriter, 0, 0);
    AppMethodBeat.o(50176);
    return paramWriter;
  }
  
  /* Error */
  Writer write(Writer paramWriter, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 689
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_0
    //   10: invokevirtual 240	com/tencent/ttpic/json/JSONObject:length	()I
    //   13: istore 5
    //   15: aload_0
    //   16: invokevirtual 243	com/tencent/ttpic/json/JSONObject:keys	()Ljava/util/Iterator;
    //   19: astore 6
    //   21: aload_1
    //   22: bipush 123
    //   24: invokevirtual 260	java/io/Writer:write	(I)V
    //   27: iload 5
    //   29: iconst_1
    //   30: if_icmpne +72 -> 102
    //   33: aload 6
    //   35: invokeinterface 186 1 0
    //   40: astore 6
    //   42: aload_1
    //   43: aload 6
    //   45: invokevirtual 76	java/lang/Object:toString	()Ljava/lang/String;
    //   48: invokestatic 469	com/tencent/ttpic/json/JSONObject:quote	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokevirtual 348	java/io/Writer:write	(Ljava/lang/String;)V
    //   54: aload_1
    //   55: bipush 58
    //   57: invokevirtual 260	java/io/Writer:write	(I)V
    //   60: iload_2
    //   61: ifle +9 -> 70
    //   64: aload_1
    //   65: bipush 32
    //   67: invokevirtual 260	java/io/Writer:write	(I)V
    //   70: aload_1
    //   71: aload_0
    //   72: getfield 38	com/tencent/ttpic/json/JSONObject:map	Ljava/util/Map;
    //   75: aload 6
    //   77: invokeinterface 600 2 0
    //   82: iload_2
    //   83: iload_3
    //   84: invokestatic 691	com/tencent/ttpic/json/JSONObject:writeValue	(Ljava/io/Writer;Ljava/lang/Object;II)Ljava/io/Writer;
    //   87: pop
    //   88: aload_1
    //   89: bipush 125
    //   91: invokevirtual 260	java/io/Writer:write	(I)V
    //   94: ldc_w 689
    //   97: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: areturn
    //   102: iload 5
    //   104: ifeq -16 -> 88
    //   107: iload_3
    //   108: iload_2
    //   109: iadd
    //   110: istore 5
    //   112: aload 6
    //   114: invokeinterface 183 1 0
    //   119: ifeq +92 -> 211
    //   122: aload 6
    //   124: invokeinterface 186 1 0
    //   129: astore 7
    //   131: iload 4
    //   133: ifeq +9 -> 142
    //   136: aload_1
    //   137: bipush 44
    //   139: invokevirtual 260	java/io/Writer:write	(I)V
    //   142: iload_2
    //   143: ifle +9 -> 152
    //   146: aload_1
    //   147: bipush 10
    //   149: invokevirtual 260	java/io/Writer:write	(I)V
    //   152: aload_1
    //   153: iload 5
    //   155: invokestatic 693	com/tencent/ttpic/json/JSONObject:indent	(Ljava/io/Writer;I)V
    //   158: aload_1
    //   159: aload 7
    //   161: invokevirtual 76	java/lang/Object:toString	()Ljava/lang/String;
    //   164: invokestatic 469	com/tencent/ttpic/json/JSONObject:quote	(Ljava/lang/String;)Ljava/lang/String;
    //   167: invokevirtual 348	java/io/Writer:write	(Ljava/lang/String;)V
    //   170: aload_1
    //   171: bipush 58
    //   173: invokevirtual 260	java/io/Writer:write	(I)V
    //   176: iload_2
    //   177: ifle +9 -> 186
    //   180: aload_1
    //   181: bipush 32
    //   183: invokevirtual 260	java/io/Writer:write	(I)V
    //   186: aload_1
    //   187: aload_0
    //   188: getfield 38	com/tencent/ttpic/json/JSONObject:map	Ljava/util/Map;
    //   191: aload 7
    //   193: invokeinterface 600 2 0
    //   198: iload_2
    //   199: iload 5
    //   201: invokestatic 691	com/tencent/ttpic/json/JSONObject:writeValue	(Ljava/io/Writer;Ljava/lang/Object;II)Ljava/io/Writer;
    //   204: pop
    //   205: iconst_1
    //   206: istore 4
    //   208: goto -96 -> 112
    //   211: iload_2
    //   212: ifle +9 -> 221
    //   215: aload_1
    //   216: bipush 10
    //   218: invokevirtual 260	java/io/Writer:write	(I)V
    //   221: aload_1
    //   222: iload_3
    //   223: invokestatic 693	com/tencent/ttpic/json/JSONObject:indent	(Ljava/io/Writer;I)V
    //   226: goto -138 -> 88
    //   229: astore_1
    //   230: new 265	com/tencent/ttpic/json/JSONException
    //   233: dup
    //   234: aload_1
    //   235: invokespecial 440	com/tencent/ttpic/json/JSONException:<init>	(Ljava/lang/Throwable;)V
    //   238: astore_1
    //   239: ldc_w 689
    //   242: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload_1
    //   246: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	JSONObject
    //   0	247	1	paramWriter	Writer
    //   0	247	2	paramInt1	int
    //   0	247	3	paramInt2	int
    //   7	200	4	i	int
    //   13	187	5	j	int
    //   19	104	6	localObject1	Object
    //   129	63	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	27	229	java/io/IOException
    //   33	60	229	java/io/IOException
    //   64	70	229	java/io/IOException
    //   70	88	229	java/io/IOException
    //   88	94	229	java/io/IOException
    //   112	131	229	java/io/IOException
    //   136	142	229	java/io/IOException
    //   146	152	229	java/io/IOException
    //   152	176	229	java/io/IOException
    //   180	186	229	java/io/IOException
    //   186	205	229	java/io/IOException
    //   215	221	229	java/io/IOException
    //   221	226	229	java/io/IOException
  }
  
  static final class Null
  {
    protected final Object clone()
    {
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      return (paramObject == null) || (paramObject == this);
    }
    
    public final String toString()
    {
      return "null";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.json.JSONObject
 * JD-Core Version:    0.7.0.1
 */