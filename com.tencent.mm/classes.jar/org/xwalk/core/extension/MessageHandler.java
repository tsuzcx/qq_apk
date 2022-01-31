package org.xwalk.core.extension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public class MessageHandler
{
  private String TAG = "MessageHandler";
  private Map<String, MessageHandler.Handler> mHandlers = new HashMap();
  
  public MessageHandler() {}
  
  public MessageHandler(MessageHandler paramMessageHandler)
  {
    this.mHandlers.putAll(paramMessageHandler.mHandlers);
  }
  
  public Object handleMessage(MessageInfo paramMessageInfo)
  {
    Object localObject = paramMessageInfo.getJsName();
    MessageHandler.Handler localHandler = (MessageHandler.Handler)this.mHandlers.get(localObject);
    if ((localHandler == null) || (localHandler.targetObject == null))
    {
      Log.w(this.TAG, "Cannot find handler for method " + (String)localObject);
      return null;
    }
    localObject = localHandler.targetObject;
    if ((paramMessageInfo.getExtension().isAutoJS()) && (localHandler.reflection != null)) {
      try
      {
        paramMessageInfo = localHandler.reflection.handleMessage(paramMessageInfo, localObject);
        return paramMessageInfo;
      }
      catch (Exception paramMessageInfo)
      {
        Log.e(this.TAG, paramMessageInfo.toString());
        return null;
      }
    }
    try
    {
      paramMessageInfo = localObject.getClass().getMethod(localHandler.javaName, new Class[] { MessageInfo.class }).invoke(localObject, new Object[] { paramMessageInfo });
      return paramMessageInfo;
    }
    catch (IllegalAccessException paramMessageInfo)
    {
      Log.e(this.TAG, paramMessageInfo.toString());
      return null;
    }
    catch (IllegalArgumentException paramMessageInfo)
    {
      break label139;
    }
    catch (NoSuchMethodException paramMessageInfo)
    {
      break label139;
    }
    catch (InvocationTargetException paramMessageInfo)
    {
      break label139;
    }
    catch (SecurityException paramMessageInfo)
    {
      label139:
      break label139;
    }
  }
  
  public void register(String paramString, Object paramObject)
  {
    register(paramString, paramString, ReflectionHelper.MemberType.JS_METHOD, paramObject, null);
  }
  
  public void register(String paramString1, String paramString2, Object paramObject)
  {
    register(paramString1, paramString2, ReflectionHelper.MemberType.JS_METHOD, paramObject, null);
  }
  
  public void register(String paramString1, String paramString2, ReflectionHelper.MemberType paramMemberType, Object paramObject)
  {
    register(paramString1, paramString2, paramMemberType, paramObject, null);
  }
  
  public void register(String paramString1, String paramString2, ReflectionHelper.MemberType paramMemberType, Object paramObject, ReflectionHelper paramReflectionHelper)
  {
    if (this.mHandlers.containsKey(paramString1))
    {
      Log.w(this.TAG, "Existing handler for " + paramString1);
      return;
    }
    paramString2 = new MessageHandler.Handler(this, paramString2, paramMemberType, paramObject, paramReflectionHelper);
    this.mHandlers.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.extension.MessageHandler
 * JD-Core Version:    0.7.0.1
 */