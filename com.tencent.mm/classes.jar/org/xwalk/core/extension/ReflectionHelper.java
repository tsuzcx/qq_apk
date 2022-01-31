package org.xwalk.core.extension;

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
  static Set<Class<?>> primitives = new HashSet();
  private Map<String, String> bindingClasses = new HashMap();
  private Map<String, ReflectionHelper> constructorReflections = new HashMap();
  private ReflectionHelper.MemberInfo entryPoint = null;
  private String[] eventList = null;
  private Map<String, ReflectionHelper.MemberInfo> members = new HashMap();
  private Class<?> myClass;
  
  public ReflectionHelper(Class<?> paramClass)
  {
    this.myClass = paramClass;
    init();
  }
  
  public static boolean isSerializable(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    return (localClass.isPrimitive()) || (primitives.contains(localClass)) || ((paramObject instanceof String)) || ((paramObject instanceof Map)) || ((paramObject instanceof JSONArray)) || ((paramObject instanceof JSONObject));
  }
  
  public static String objToJSON(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    paramObject = toSerializableObject(paramObject);
    if ((paramObject instanceof String)) {
      return JSONObject.quote(paramObject.toString());
    }
    return paramObject.toString();
  }
  
  public static void registerHandlers(ReflectionHelper paramReflectionHelper, MessageHandler paramMessageHandler, Object paramObject)
  {
    if ((paramReflectionHelper == null) || (paramMessageHandler == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramReflectionHelper.getMembers().keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (ReflectionHelper.MemberInfo)paramReflectionHelper.getMembers().get(localObject);
        paramMessageHandler.register(((ReflectionHelper.MemberInfo)localObject).jsName, ((ReflectionHelper.MemberInfo)localObject).javaName, ((ReflectionHelper.MemberInfo)localObject).type, paramObject, paramReflectionHelper);
      }
    }
  }
  
  public static Object toSerializableObject(Object paramObject)
  {
    int i = 0;
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
        label48:
        i += 1;
        continue;
        do
        {
          return localObject1;
          localObject1 = paramObject;
        } while (isSerializable(paramObject));
        try
        {
          localObject1 = (String)paramObject.getClass().getMethod("toJSONString", new Class[0]).invoke(paramObject, new Object[0]);
          if (((String)localObject1).trim().charAt(0) == '[') {
            return new JSONArray((String)localObject1);
          }
          localObject1 = new JSONObject((String)localObject1);
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
            return localJSONObject;
          }
          catch (Exception paramObject)
          {
            Log.e("JsStubReflectHelper", "Field to serialize object to JSON.");
            return null;
          }
        }
      }
      catch (Exception localException2)
      {
        break label48;
      }
    }
  }
  
  Object[] getArgsFromJson(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, Method paramMethod, JSONArray paramJSONArray)
  {
    i = 0;
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
    return arrayOfObject;
  }
  
  ReflectionHelper getConstructorReflection(String paramString)
  {
    if (!this.constructorReflections.containsKey(paramString)) {
      return null;
    }
    return (ReflectionHelper)this.constructorReflections.get(paramString);
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
    return (ReflectionHelper.MemberInfo)this.members.get(paramString);
  }
  
  void getMemberInfo(AccessibleObject[] paramArrayOfAccessibleObject, ReflectionHelper.MemberType paramMemberType)
  {
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
          break label325;
        }
        localJsApi = (JsApi)((AccessibleObject)localObject).getAnnotation(JsApi.class);
        if ((paramMemberType != ReflectionHelper.MemberType.JS_PROPERTY) || (!localJsApi.isEventList())) {
          break label208;
        }
        if (((Field)localObject).getType().equals([Ljava.lang.String.class)) {
          break label181;
        }
        Log.w("JsStubReflectHelper", "Invalid type for Supported JS event list" + str);
      }
    }
    for (;;)
    {
      i += 1;
      break;
      try
      {
        label181:
        this.eventList = ((String[])((Field)localObject).get(null));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        continue;
        label208:
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
              label325:
              if (!((AccessibleObject)localObject).isAnnotationPresent(JsConstructor.class)) {
                continue;
              }
              if (paramMemberType != ReflectionHelper.MemberType.JS_METHOD)
              {
                Log.w("JsStubReflectHelper", "Invalid @JsConstructor on non-function member:" + str);
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
              Log.w("JsStubReflectHelper", "Invalid entry point setting on property:" + str);
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
    if (!hasProperty(paramString).booleanValue()) {
      throw new NoSuchFieldException("No such property:" + paramString);
    }
    if ((!getMemberInfo(paramString).isStatic) && (!this.myClass.isInstance(paramObject))) {
      throw new InvocationTargetException(new Exception("Invalid target to set property:" + paramString));
    }
    paramString = (Field)((ReflectionHelper.MemberInfo)this.members.get(paramString)).accesser;
    if (!paramString.isAccessible()) {
      paramString.setAccessible(true);
    }
    return paramString.get(paramObject);
  }
  
  ReflectionHelper getReflectionByBindingClass(String paramString)
  {
    if (!this.bindingClasses.containsKey(paramString)) {
      return null;
    }
    return getConstructorReflection((String)this.bindingClasses.get(paramString));
  }
  
  public Object handleMessage(MessageInfo paramMessageInfo, Object paramObject)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        str1 = paramMessageInfo.getCmd();
        if (paramMessageInfo.getBinaryArgs() != null)
        {
          localJSONArray = new JSONArray();
          localJSONArray.put(paramMessageInfo.getBinaryArgs());
          localJSONArray.put(paramMessageInfo.getCallbackId());
          str2 = paramMessageInfo.getJsName();
          localXWalkExternalExtension = paramMessageInfo.getExtension();
          j = paramMessageInfo.getInstanceId();
        }
        switch (str1.hashCode())
        {
        case -633190737: 
          Log.w("JsStubReflectHelper", "Unsupported cmd: " + str1);
          return null;
          localJSONArray = paramMessageInfo.getArgs();
          continue;
          if (!str1.equals("invokeNative")) {
            break label305;
          }
        }
      }
      catch (Exception paramMessageInfo)
      {
        String str1;
        JSONArray localJSONArray;
        String str2;
        XWalkExternalExtension localXWalkExternalExtension;
        int j;
        Log.w("JsStubReflectHelper", "Invalid message, error msg:\n" + paramMessageInfo.toString());
        return null;
      }
      if (str1.equals("newInstance"))
      {
        i = 1;
        break label307;
        if (str1.equals("getProperty"))
        {
          i = 2;
          break label307;
          if (str1.equals("setProperty"))
          {
            i = 3;
            break label307;
            return invokeMethod(localXWalkExternalExtension, j, paramObject, str2, localJSONArray);
            paramObject = (BindingObject)invokeMethod(localXWalkExternalExtension, j, paramObject, str2, localJSONArray);
            return Boolean.valueOf(paramMessageInfo.getInstanceHelper().addBindingObject(paramMessageInfo.getObjectId(), paramObject));
            return getProperty(paramObject, str2);
            setProperty(paramObject, str2, localJSONArray.get(0));
            return null;
          }
        }
      }
      label305:
      i = -1;
      label307:
      switch (i)
      {
      }
    }
  }
  
  Boolean hasMethod(String paramString)
  {
    if (!this.members.containsKey(paramString)) {
      return Boolean.valueOf(false);
    }
    paramString = (ReflectionHelper.MemberInfo)this.members.get(paramString);
    if ((paramString.type == ReflectionHelper.MemberType.JS_METHOD) || (paramString.type == ReflectionHelper.MemberType.JS_CONSTRUCTOR)) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  Boolean hasProperty(String paramString)
  {
    if (!this.members.containsKey(paramString)) {
      return Boolean.valueOf(false);
    }
    if (((ReflectionHelper.MemberInfo)this.members.get(paramString)).type == ReflectionHelper.MemberType.JS_PROPERTY) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  void init()
  {
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
  }
  
  Object invokeMethod(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, Object paramObject, String paramString, JSONArray paramJSONArray)
  {
    if (!hasMethod(paramString).booleanValue()) {
      throw new NoSuchMethodException("No such method:" + paramString);
    }
    if ((!getMemberInfo(paramString).isStatic) && (!this.myClass.isInstance(paramObject))) {
      throw new InvocationTargetException(new Exception("Invalid target to set property:" + paramString));
    }
    paramString = (Method)((ReflectionHelper.MemberInfo)this.members.get(paramString)).accesser;
    if (!paramString.isAccessible()) {
      paramString.setAccessible(true);
    }
    return paramString.invoke(paramObject, getArgsFromJson(paramXWalkExternalExtension, paramInt, paramString, paramJSONArray));
  }
  
  boolean isBindingClass(Class<?> paramClass)
  {
    return BindingObject.class.isAssignableFrom(paramClass);
  }
  
  boolean isEventSupported(String paramString)
  {
    if (this.eventList == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.eventList.length)
      {
        if (this.eventList[i].equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  boolean isInstance(Object paramObject)
  {
    return this.myClass.isInstance(paramObject);
  }
  
  void setProperty(Object paramObject1, String paramString, Object paramObject2)
  {
    if (!hasProperty(paramString).booleanValue()) {
      throw new NoSuchFieldException("No such property:" + paramString);
    }
    if ((!getMemberInfo(paramString).isStatic) && (!this.myClass.isInstance(paramObject1))) {
      throw new InvocationTargetException(new Exception("Invalid target to set property:" + paramString));
    }
    paramString = (Field)((ReflectionHelper.MemberInfo)this.members.get(paramString)).accesser;
    if (!paramString.isAccessible()) {
      paramString.setAccessible(true);
    }
    paramString.set(paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.xwalk.core.extension.ReflectionHelper
 * JD-Core Version:    0.7.0.1
 */