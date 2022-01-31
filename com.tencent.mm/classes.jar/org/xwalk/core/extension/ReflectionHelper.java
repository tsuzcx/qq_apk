package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.Log;

class ReflectionHelper
{
  private static final String TAG = "JsStubReflectHelper";
  static Set<Class<?>> primitives;
  private Map<String, String> bindingClasses;
  private Map<String, ReflectionHelper> constructorReflections;
  private ReflectionHelper.MemberInfo entryPoint;
  private String[] eventList;
  private Map<String, ReflectionHelper.MemberInfo> members;
  private Class<?> myClass;
  
  static
  {
    AppMethodBeat.i(86160);
    primitives = new HashSet();
    AppMethodBeat.o(86160);
  }
  
  public ReflectionHelper(Class<?> paramClass)
  {
    AppMethodBeat.i(86140);
    this.members = new HashMap();
    this.bindingClasses = new HashMap();
    this.constructorReflections = new HashMap();
    this.eventList = null;
    this.entryPoint = null;
    this.myClass = paramClass;
    init();
    AppMethodBeat.o(86140);
  }
  
  public static boolean isSerializable(Object paramObject)
  {
    AppMethodBeat.i(86151);
    Class localClass = paramObject.getClass();
    if ((localClass.isPrimitive()) || (primitives.contains(localClass)) || ((paramObject instanceof String)) || ((paramObject instanceof Map)) || ((paramObject instanceof JSONArray)) || ((paramObject instanceof JSONObject)))
    {
      AppMethodBeat.o(86151);
      return true;
    }
    AppMethodBeat.o(86151);
    return false;
  }
  
  public static String objToJSON(Object paramObject)
  {
    AppMethodBeat.i(86153);
    if (paramObject == null)
    {
      AppMethodBeat.o(86153);
      return "null";
    }
    paramObject = toSerializableObject(paramObject);
    if (paramObject == null)
    {
      AppMethodBeat.o(86153);
      return "null";
    }
    if ((paramObject instanceof String))
    {
      paramObject = JSONObject.quote(paramObject.toString());
      AppMethodBeat.o(86153);
      return paramObject;
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(86153);
    return paramObject;
  }
  
  public static void registerHandlers(ReflectionHelper paramReflectionHelper, MessageHandler paramMessageHandler, Object paramObject)
  {
    AppMethodBeat.i(86144);
    if ((paramReflectionHelper == null) || (paramMessageHandler == null))
    {
      AppMethodBeat.o(86144);
      return;
    }
    Iterator localIterator = paramReflectionHelper.getMembers().keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ReflectionHelper.MemberInfo)paramReflectionHelper.getMembers().get(localObject);
      paramMessageHandler.register(((ReflectionHelper.MemberInfo)localObject).jsName, ((ReflectionHelper.MemberInfo)localObject).javaName, ((ReflectionHelper.MemberInfo)localObject).type, paramObject, paramReflectionHelper);
    }
    AppMethodBeat.o(86144);
  }
  
  public static Object toSerializableObject(Object paramObject)
  {
    int i = 0;
    AppMethodBeat.i(86152);
    Object localObject1;
    if (paramObject.getClass().isArray())
    {
      localObject1 = new JSONArray();
      paramObject = (Object[])paramObject;
      i = 0;
    }
    for (;;)
    {
      if (i < paramObject.length) {}
      try
      {
        ((JSONArray)localObject1).put(i, toSerializableObject(paramObject[i]));
        label53:
        i += 1;
        continue;
        AppMethodBeat.o(86152);
        return localObject1;
        if (isSerializable(paramObject))
        {
          AppMethodBeat.o(86152);
          return paramObject;
        }
        try
        {
          localObject1 = (String)paramObject.getClass().getMethod("toJSONString", new Class[0]).invoke(paramObject, new Object[0]);
          if (((String)localObject1).trim().charAt(0) == '[')
          {
            localObject1 = new JSONArray((String)localObject1);
            AppMethodBeat.o(86152);
            return localObject1;
          }
          localObject1 = new JSONObject((String)localObject1);
          AppMethodBeat.o(86152);
          return localObject1;
        }
        catch (Exception localException1)
        {
          Log.w("JsStubReflectHelper", "No serialization method: \"toJSONString\", or errors happened.");
          try
          {
            Object localObject2 = paramObject.getClass();
            JSONObject localJSONObject = new JSONObject();
            localObject2 = ((Class)localObject2).getFields();
            int j = localObject2.length;
            while (i < j)
            {
              Object localObject3 = localObject2[i];
              localJSONObject.put(localObject3.getName(), localObject3.get(paramObject));
              i += 1;
            }
            AppMethodBeat.o(86152);
            return localJSONObject;
          }
          catch (Exception paramObject)
          {
            Log.e("JsStubReflectHelper", "Field to serialize object to JSON.");
            AppMethodBeat.o(86152);
            return null;
          }
        }
      }
      catch (Exception localException2)
      {
        break label53;
      }
    }
  }
  
  Object[] getArgsFromJson(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, Method paramMethod, JSONArray paramJSONArray)
  {
    i = 0;
    AppMethodBeat.i(86150);
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Object[] arrayOfObject = new Object[arrayOfClass.length];
    boolean bool1 = Modifier.isStatic(paramMethod.getModifiers());
    if (i < arrayOfClass.length)
    {
      Class localClass = arrayOfClass[i];
      if (bool1) {}
      for (;;)
      {
        try
        {
          boolean bool2 = localClass.equals(JsContextInfo.class);
          if (bool2) {
            j = i + 1;
          }
        }
        catch (Exception localException1)
        {
          continue;
        }
        try
        {
          arrayOfObject[i] = new JsContextInfo(paramInt, paramXWalkExternalExtension, paramMethod.getClass(), Integer.toString(0));
          i = j;
        }
        catch (Exception localException2)
        {
          i = j;
          continue;
        }
        i += 1;
        break;
        arrayOfObject[i] = paramJSONArray.get(i);
      }
    }
    AppMethodBeat.o(86150);
    return arrayOfObject;
  }
  
  ReflectionHelper getConstructorReflection(String paramString)
  {
    AppMethodBeat.i(86145);
    if (!this.constructorReflections.containsKey(paramString))
    {
      AppMethodBeat.o(86145);
      return null;
    }
    paramString = (ReflectionHelper)this.constructorReflections.get(paramString);
    AppMethodBeat.o(86145);
    return paramString;
  }
  
  ReflectionHelper.MemberInfo getEntryPoint()
  {
    return this.entryPoint;
  }
  
  String[] getEventList()
  {
    return this.eventList;
  }
  
  ReflectionHelper.MemberInfo getMemberInfo(String paramString)
  {
    AppMethodBeat.i(86149);
    paramString = (ReflectionHelper.MemberInfo)this.members.get(paramString);
    AppMethodBeat.o(86149);
    return paramString;
  }
  
  void getMemberInfo(AccessibleObject[] paramArrayOfAccessibleObject, ReflectionHelper.MemberType paramMemberType)
  {
    AppMethodBeat.i(86141);
    int j = paramArrayOfAccessibleObject.length;
    int i = 0;
    Object localObject;
    String str;
    JsApi localJsApi;
    if (i < j)
    {
      localObject = paramArrayOfAccessibleObject[i];
      if ((((AccessibleObject)localObject).isAnnotationPresent(JsApi.class)) || (((AccessibleObject)localObject).isAnnotationPresent(JsConstructor.class)))
      {
        ReflectionHelper.MemberInfo localMemberInfo = new ReflectionHelper.MemberInfo(this);
        str = ((Member)localObject).getName();
        localMemberInfo.javaName = str;
        localMemberInfo.accesser = ((AccessibleObject)localObject);
        localMemberInfo.isStatic = Modifier.isStatic(((Member)localObject).getModifiers());
        if (!((AccessibleObject)localObject).isAnnotationPresent(JsApi.class)) {
          break label324;
        }
        localJsApi = (JsApi)((AccessibleObject)localObject).getAnnotation(JsApi.class);
        if ((paramMemberType != ReflectionHelper.MemberType.JS_PROPERTY) || (!localJsApi.isEventList())) {
          break label207;
        }
        if (((Field)localObject).getType().equals([Ljava.lang.String.class)) {
          break label180;
        }
        Log.w("JsStubReflectHelper", "Invalid type for Supported JS event list".concat(String.valueOf(str)));
      }
    }
    for (;;)
    {
      i += 1;
      break;
      try
      {
        label180:
        this.eventList = ((String[])((Field)localObject).get(null));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        continue;
        label207:
        localIllegalArgumentException.type = paramMemberType;
        localIllegalArgumentException.isWritable = localJsApi.isWritable();
        localIllegalArgumentException.isEntryPoint = localJsApi.isEntryPoint();
        localIllegalArgumentException.withPromise = localJsApi.withPromise();
        localIllegalArgumentException.jsName = str;
        localIllegalArgumentException.wrapArgs = localJsApi.wrapArgs();
        localIllegalArgumentException.wrapReturns = localJsApi.wrapReturns();
        for (;;)
        {
          if (localIllegalArgumentException.isEntryPoint)
          {
            if (this.entryPoint != null)
            {
              Log.w("JsStubReflectHelper", "Entry point already exist, try to set another:" + localIllegalArgumentException.jsName);
              break;
              label324:
              if (!((AccessibleObject)localObject).isAnnotationPresent(JsConstructor.class)) {
                continue;
              }
              if (paramMemberType != ReflectionHelper.MemberType.JS_METHOD)
              {
                Log.w("JsStubReflectHelper", "Invalid @JsConstructor on non-function member:".concat(String.valueOf(str)));
                break;
              }
              localObject = (JsConstructor)((AccessibleObject)localObject).getAnnotation(JsConstructor.class);
              localIllegalArgumentException.type = ReflectionHelper.MemberType.JS_CONSTRUCTOR;
              localIllegalArgumentException.isEntryPoint = ((JsConstructor)localObject).isEntryPoint();
              localIllegalArgumentException.mainClass = ((JsConstructor)localObject).mainClass();
              localIllegalArgumentException.withPromise = false;
              if (localIllegalArgumentException.mainClass == null) {
                break;
              }
              localIllegalArgumentException.jsName = localIllegalArgumentException.mainClass.getSimpleName();
              this.bindingClasses.put(localIllegalArgumentException.mainClass.getName(), localIllegalArgumentException.jsName);
              this.constructorReflections.put(localIllegalArgumentException.jsName, new ReflectionHelper(localIllegalArgumentException.mainClass));
              continue;
            }
            if ((paramMemberType == ReflectionHelper.MemberType.JS_PROPERTY) && (!isBindingClass(((Field)localIllegalArgumentException.accesser).getType())))
            {
              Log.w("JsStubReflectHelper", "Invalid entry point setting on property:".concat(String.valueOf(str)));
              break;
            }
            this.entryPoint = localIllegalArgumentException;
          }
        }
        if (this.members.containsKey(localIllegalArgumentException.jsName))
        {
          Log.w("JsStubReflectHelper", "Conflict namespace - " + localIllegalArgumentException.jsName);
        }
        else
        {
          this.members.put(localIllegalArgumentException.jsName, localIllegalArgumentException);
          continue;
          AppMethodBeat.o(86141);
          return;
        }
      }
      catch (IllegalAccessException localIllegalAccessException) {}
    }
  }
  
  Map<String, ReflectionHelper.MemberInfo> getMembers()
  {
    return this.members;
  }
  
  Object getProperty(Object paramObject, String paramString)
  {
    AppMethodBeat.i(86155);
    if (!hasProperty(paramString).booleanValue())
    {
      paramObject = new NoSuchFieldException("No such property:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(86155);
      throw paramObject;
    }
    if ((!getMemberInfo(paramString).isStatic) && (!this.myClass.isInstance(paramObject)))
    {
      paramObject = new InvocationTargetException(new Exception("Invalid target to set property:".concat(String.valueOf(paramString))));
      AppMethodBeat.o(86155);
      throw paramObject;
    }
    paramString = (Field)((ReflectionHelper.MemberInfo)this.members.get(paramString)).accesser;
    if (!paramString.isAccessible()) {
      paramString.setAccessible(true);
    }
    paramObject = paramString.get(paramObject);
    AppMethodBeat.o(86155);
    return paramObject;
  }
  
  ReflectionHelper getReflectionByBindingClass(String paramString)
  {
    AppMethodBeat.i(86146);
    if (!this.bindingClasses.containsKey(paramString))
    {
      AppMethodBeat.o(86146);
      return null;
    }
    paramString = getConstructorReflection((String)this.bindingClasses.get(paramString));
    AppMethodBeat.o(86146);
    return paramString;
  }
  
  public Object handleMessage(MessageInfo paramMessageInfo, Object paramObject)
  {
    i = 0;
    AppMethodBeat.i(86159);
    try
    {
      str1 = paramMessageInfo.getCmd();
      if (paramMessageInfo.getBinaryArgs() == null) {
        break label142;
      }
      localJSONArray = new JSONArray();
      localJSONArray.put(paramMessageInfo.getBinaryArgs());
      localJSONArray.put(paramMessageInfo.getCallbackId());
      str2 = paramMessageInfo.getJsName();
      localXWalkExternalExtension = paramMessageInfo.getExtension();
      j = paramMessageInfo.getInstanceId();
      switch (str1.hashCode())
      {
      }
    }
    catch (Exception paramMessageInfo)
    {
      for (;;)
      {
        String str1;
        JSONArray localJSONArray;
        String str2;
        XWalkExternalExtension localXWalkExternalExtension;
        int j;
        label142:
        Log.w("JsStubReflectHelper", "Invalid message, error msg:\n" + paramMessageInfo.toString());
        paramMessageInfo = null;
        continue;
        i = -1;
        switch (i)
        {
        }
      }
    }
    Log.w("JsStubReflectHelper", "Unsupported cmd: ".concat(String.valueOf(str1)));
    paramMessageInfo = null;
    for (;;)
    {
      AppMethodBeat.o(86159);
      return paramMessageInfo;
      localJSONArray = paramMessageInfo.getArgs();
      break;
      if (!str1.equals("invokeNative")) {
        break label329;
      }
      break label331;
      if (!str1.equals("newInstance")) {
        break label329;
      }
      i = 1;
      break label331;
      if (!str1.equals("getProperty")) {
        break label329;
      }
      i = 2;
      break label331;
      if (!str1.equals("setProperty")) {
        break label329;
      }
      i = 3;
      break label331;
      paramMessageInfo = invokeMethod(localXWalkExternalExtension, j, paramObject, str2, localJSONArray);
      continue;
      paramObject = (BindingObject)invokeMethod(localXWalkExternalExtension, j, paramObject, str2, localJSONArray);
      paramMessageInfo = Boolean.valueOf(paramMessageInfo.getInstanceHelper().addBindingObject(paramMessageInfo.getObjectId(), paramObject));
      continue;
      paramMessageInfo = getProperty(paramObject, str2);
      continue;
      setProperty(paramObject, str2, localJSONArray.get(0));
      paramMessageInfo = null;
    }
  }
  
  Boolean hasMethod(String paramString)
  {
    AppMethodBeat.i(86147);
    if (!this.members.containsKey(paramString))
    {
      paramString = Boolean.FALSE;
      AppMethodBeat.o(86147);
      return paramString;
    }
    paramString = (ReflectionHelper.MemberInfo)this.members.get(paramString);
    if ((paramString.type == ReflectionHelper.MemberType.JS_METHOD) || (paramString.type == ReflectionHelper.MemberType.JS_CONSTRUCTOR)) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(86147);
      return Boolean.valueOf(bool);
    }
  }
  
  Boolean hasProperty(String paramString)
  {
    AppMethodBeat.i(86148);
    if (!this.members.containsKey(paramString))
    {
      paramString = Boolean.FALSE;
      AppMethodBeat.o(86148);
      return paramString;
    }
    if (((ReflectionHelper.MemberInfo)this.members.get(paramString)).type == ReflectionHelper.MemberType.JS_PROPERTY) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(86148);
      return Boolean.valueOf(bool);
    }
  }
  
  void init()
  {
    AppMethodBeat.i(86143);
    primitives.add(Byte.class);
    primitives.add(Integer.class);
    primitives.add(Long.class);
    primitives.add(Double.class);
    primitives.add(Character.class);
    primitives.add(Float.class);
    primitives.add(Boolean.class);
    primitives.add(Short.class);
    getMemberInfo(this.myClass.getDeclaredMethods(), ReflectionHelper.MemberType.JS_METHOD);
    getMemberInfo(this.myClass.getDeclaredFields(), ReflectionHelper.MemberType.JS_PROPERTY);
    AppMethodBeat.o(86143);
  }
  
  Object invokeMethod(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, Object paramObject, String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(86154);
    if (!hasMethod(paramString).booleanValue())
    {
      paramXWalkExternalExtension = new NoSuchMethodException("No such method:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(86154);
      throw paramXWalkExternalExtension;
    }
    if ((!getMemberInfo(paramString).isStatic) && (!this.myClass.isInstance(paramObject)))
    {
      paramXWalkExternalExtension = new InvocationTargetException(new Exception("Invalid target to set property:".concat(String.valueOf(paramString))));
      AppMethodBeat.o(86154);
      throw paramXWalkExternalExtension;
    }
    paramString = (Method)((ReflectionHelper.MemberInfo)this.members.get(paramString)).accesser;
    if (!paramString.isAccessible()) {
      paramString.setAccessible(true);
    }
    paramXWalkExternalExtension = paramString.invoke(paramObject, getArgsFromJson(paramXWalkExternalExtension, paramInt, paramString, paramJSONArray));
    AppMethodBeat.o(86154);
    return paramXWalkExternalExtension;
  }
  
  boolean isBindingClass(Class<?> paramClass)
  {
    AppMethodBeat.i(86142);
    boolean bool = BindingObject.class.isAssignableFrom(paramClass);
    AppMethodBeat.o(86142);
    return bool;
  }
  
  boolean isEventSupported(String paramString)
  {
    AppMethodBeat.i(86157);
    if (this.eventList == null)
    {
      AppMethodBeat.o(86157);
      return false;
    }
    int i = 0;
    while (i < this.eventList.length)
    {
      if (this.eventList[i].equals(paramString))
      {
        AppMethodBeat.o(86157);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(86157);
    return false;
  }
  
  boolean isInstance(Object paramObject)
  {
    AppMethodBeat.i(86158);
    boolean bool = this.myClass.isInstance(paramObject);
    AppMethodBeat.o(86158);
    return bool;
  }
  
  void setProperty(Object paramObject1, String paramString, Object paramObject2)
  {
    AppMethodBeat.i(86156);
    if (!hasProperty(paramString).booleanValue())
    {
      paramObject1 = new NoSuchFieldException("No such property:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(86156);
      throw paramObject1;
    }
    if ((!getMemberInfo(paramString).isStatic) && (!this.myClass.isInstance(paramObject1)))
    {
      paramObject1 = new InvocationTargetException(new Exception("Invalid target to set property:".concat(String.valueOf(paramString))));
      AppMethodBeat.o(86156);
      throw paramObject1;
    }
    paramString = (Field)((ReflectionHelper.MemberInfo)this.members.get(paramString)).accesser;
    if (!paramString.isAccessible()) {
      paramString.setAccessible(true);
    }
    paramString.set(paramObject1, paramObject2);
    AppMethodBeat.o(86156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.xwalk.core.extension.ReflectionHelper
 * JD-Core Version:    0.7.0.1
 */