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
    AppMethodBeat.i(155191);
    if (!paramJsContextInfo.getTargetReflect().isEventSupported(paramString))
    {
      Log.w(paramJsContextInfo.getTag(), "Unsupport event in extension: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(155191);
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
      AppMethodBeat.o(155191);
      return;
    }
    catch (Exception paramJsContextInfo)
    {
      AppMethodBeat.o(155191);
    }
  }
  
  public static void invokeJsCallback(JsContextInfo paramJsContextInfo, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(155187);
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
        AppMethodBeat.o(155187);
        return;
      }
      catch (Exception paramJsContextInfo)
      {
        AppMethodBeat.o(155187);
      }
    }
  }
  
  public static void invokeJsCallback(JsContextInfo paramJsContextInfo, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155189);
    paramJsContextInfo.postMessage(paramArrayOfByte);
    AppMethodBeat.o(155189);
  }
  
  public static void sendEvent(JsContextInfo paramJsContextInfo, String paramString, Object paramObject)
  {
    AppMethodBeat.i(155193);
    paramJsContextInfo.getExtensionClient().sendEvent(paramString, paramObject);
    AppMethodBeat.o(155193);
  }
  
  public static void updateProperty(JsContextInfo paramJsContextInfo, String paramString)
  {
    AppMethodBeat.i(155195);
    Object localObject = paramJsContextInfo.getTargetReflect();
    if (!((ReflectionHelper)localObject).hasProperty(paramString).booleanValue())
    {
      Log.w(paramJsContextInfo.getTag(), "Unexposed property in extension: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(155195);
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
        AppMethodBeat.o(155195);
        return;
      }
      return;
    }
    catch (Exception paramJsContextInfo)
    {
      AppMethodBeat.o(155195);
    }
  }
  
  public void dispatchEvent(String paramString, Object paramObject)
  {
    AppMethodBeat.i(155192);
    dispatchEvent(getJsContextInfo(), paramString, paramObject);
    AppMethodBeat.o(155192);
  }
  
  public JsContextInfo getJsContextInfo()
  {
    AppMethodBeat.i(155186);
    JsContextInfo localJsContextInfo = new JsContextInfo(this.mInstanceHelper.getId(), this.mInstanceHelper.getExtension(), getClass(), this.mObjectId);
    AppMethodBeat.o(155186);
    return localJsContextInfo;
  }
  
  public Object handleMessage(MessageInfo paramMessageInfo)
  {
    AppMethodBeat.i(155185);
    Object localObject = null;
    ReflectionHelper localReflectionHelper = this.mInstanceHelper.getExtension().getReflection().getReflectionByBindingClass(getClass().getName());
    try
    {
      paramMessageInfo = localReflectionHelper.handleMessage(paramMessageInfo, this);
      AppMethodBeat.o(155185);
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
    AppMethodBeat.i(155188);
    invokeJsCallback(getJsContextInfo(), paramString, paramVarArgs);
    AppMethodBeat.o(155188);
  }
  
  public void invokeJsCallback(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155190);
    getJsContextInfo().postMessage(paramArrayOfByte);
    AppMethodBeat.o(155190);
  }
  
  public void sendEvent(String paramString, Object paramObject)
  {
    AppMethodBeat.i(155194);
    sendEvent(getJsContextInfo(), paramString, paramObject);
    AppMethodBeat.o(155194);
  }
  
  public void updateProperty(String paramString)
  {
    AppMethodBeat.i(155196);
    updateProperty(getJsContextInfo(), paramString);
    AppMethodBeat.o(155196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.extension.BindingObjectAutoJS
 * JD-Core Version:    0.7.0.1
 */