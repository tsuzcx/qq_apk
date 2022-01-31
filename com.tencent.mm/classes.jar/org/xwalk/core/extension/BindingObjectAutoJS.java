package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class BindingObjectAutoJS
  extends BindingObject
{
  public static void dispatchEvent(JsContextInfo paramJsContextInfo, String paramString, Object paramObject)
  {
    AppMethodBeat.i(86077);
    if (!paramJsContextInfo.getTargetReflect().isEventSupported(paramString))
    {
      Log.w(paramJsContextInfo.getTag(), "Unsupport event in extension: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(86077);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "dispatchEvent");
      localJSONObject.put("constructorName", paramJsContextInfo.getConstructorName());
      localJSONObject.put("objectId", paramJsContextInfo.getObjectId());
      localJSONObject.put("type", paramString);
      localJSONObject.put("event", ReflectionHelper.toSerializableObject(paramObject));
      paramJsContextInfo.postMessage(localJSONObject);
      AppMethodBeat.o(86077);
      return;
    }
    catch (Exception paramJsContextInfo)
    {
      AppMethodBeat.o(86077);
    }
  }
  
  public static void invokeJsCallback(JsContextInfo paramJsContextInfo, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(86073);
    Object localObject = (Object[])paramVarArgs;
    if ((localObject.length == 1) && ((localObject[0] instanceof JSONArray))) {}
    for (paramVarArgs = (JSONArray)localObject[0];; paramVarArgs = (JSONArray)ReflectionHelper.toSerializableObject(paramVarArgs)) {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "invokeCallback");
        ((JSONObject)localObject).put("callbackId", paramString);
        ((JSONObject)localObject).put("args", paramVarArgs);
        paramJsContextInfo.postMessage((JSONObject)localObject);
        AppMethodBeat.o(86073);
        return;
      }
      catch (Exception paramJsContextInfo)
      {
        AppMethodBeat.o(86073);
      }
    }
  }
  
  public static void invokeJsCallback(JsContextInfo paramJsContextInfo, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(86075);
    paramJsContextInfo.postMessage(paramArrayOfByte);
    AppMethodBeat.o(86075);
  }
  
  public static void sendEvent(JsContextInfo paramJsContextInfo, String paramString, Object paramObject)
  {
    AppMethodBeat.i(86079);
    paramJsContextInfo.getExtensionClient().sendEvent(paramString, paramObject);
    AppMethodBeat.o(86079);
  }
  
  public static void updateProperty(JsContextInfo paramJsContextInfo, String paramString)
  {
    AppMethodBeat.i(86081);
    Object localObject = paramJsContextInfo.getTargetReflect();
    if (!((ReflectionHelper)localObject).hasProperty(paramString).booleanValue())
    {
      Log.w(paramJsContextInfo.getTag(), "Unexposed property in extension: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(86081);
      return;
    }
    boolean bool = ((ReflectionHelper)localObject).getMemberInfo(paramString).isStatic;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "updateProperty");
      if (bool) {}
      for (localObject = "0";; localObject = paramJsContextInfo.getObjectId())
      {
        localJSONObject.put("objectId", localObject);
        localJSONObject.put("constructorName", paramJsContextInfo.getConstructorName());
        localJSONObject.put("name", paramString);
        paramJsContextInfo.postMessage(localJSONObject);
        AppMethodBeat.o(86081);
        return;
      }
      return;
    }
    catch (Exception paramJsContextInfo)
    {
      AppMethodBeat.o(86081);
    }
  }
  
  public void dispatchEvent(String paramString, Object paramObject)
  {
    AppMethodBeat.i(86078);
    dispatchEvent(getJsContextInfo(), paramString, paramObject);
    AppMethodBeat.o(86078);
  }
  
  public JsContextInfo getJsContextInfo()
  {
    AppMethodBeat.i(86072);
    JsContextInfo localJsContextInfo = new JsContextInfo(this.mInstanceHelper.getId(), this.mInstanceHelper.getExtension(), getClass(), this.mObjectId);
    AppMethodBeat.o(86072);
    return localJsContextInfo;
  }
  
  public Object handleMessage(MessageInfo paramMessageInfo)
  {
    AppMethodBeat.i(86071);
    Object localObject = null;
    ReflectionHelper localReflectionHelper = this.mInstanceHelper.getExtension().getReflection().getReflectionByBindingClass(getClass().getName());
    try
    {
      paramMessageInfo = localReflectionHelper.handleMessage(paramMessageInfo, this);
      AppMethodBeat.o(86071);
      return paramMessageInfo;
    }
    catch (Exception paramMessageInfo)
    {
      for (;;)
      {
        Log.e("BindingObjectAutoJs", paramMessageInfo.toString());
        paramMessageInfo = localObject;
      }
    }
  }
  
  public void invokeJsCallback(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(86074);
    invokeJsCallback(getJsContextInfo(), paramString, paramVarArgs);
    AppMethodBeat.o(86074);
  }
  
  public void invokeJsCallback(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(86076);
    getJsContextInfo().postMessage(paramArrayOfByte);
    AppMethodBeat.o(86076);
  }
  
  public void sendEvent(String paramString, Object paramObject)
  {
    AppMethodBeat.i(86080);
    sendEvent(getJsContextInfo(), paramString, paramObject);
    AppMethodBeat.o(86080);
  }
  
  public void updateProperty(String paramString)
  {
    AppMethodBeat.i(86082);
    updateProperty(getJsContextInfo(), paramString);
    AppMethodBeat.o(86082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.xwalk.core.extension.BindingObjectAutoJS
 * JD-Core Version:    0.7.0.1
 */