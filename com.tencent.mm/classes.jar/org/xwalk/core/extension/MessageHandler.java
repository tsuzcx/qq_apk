package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public class MessageHandler
{
  private String TAG;
  private Map<String, Handler> mHandlers;
  
  public MessageHandler()
  {
    AppMethodBeat.i(86125);
    this.TAG = "MessageHandler";
    this.mHandlers = new HashMap();
    AppMethodBeat.o(86125);
  }
  
  public MessageHandler(MessageHandler paramMessageHandler)
  {
    AppMethodBeat.i(86126);
    this.TAG = "MessageHandler";
    this.mHandlers = new HashMap();
    this.mHandlers.putAll(paramMessageHandler.mHandlers);
    AppMethodBeat.o(86126);
  }
  
  public Object handleMessage(MessageInfo paramMessageInfo)
  {
    AppMethodBeat.i(86131);
    Object localObject = paramMessageInfo.getJsName();
    Handler localHandler = (Handler)this.mHandlers.get(localObject);
    if ((localHandler == null) || (localHandler.targetObject == null))
    {
      Log.w(this.TAG, "Cannot find handler for method ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(86131);
      return null;
    }
    localObject = localHandler.targetObject;
    if ((paramMessageInfo.getExtension().isAutoJS()) && (localHandler.reflection != null)) {}
    for (;;)
    {
      try
      {
        paramMessageInfo = localHandler.reflection.handleMessage(paramMessageInfo, localObject);
        AppMethodBeat.o(86131);
        return paramMessageInfo;
      }
      catch (Exception paramMessageInfo)
      {
        Log.e(this.TAG, paramMessageInfo.toString());
        paramMessageInfo = null;
        continue;
      }
      try
      {
        paramMessageInfo = localObject.getClass().getMethod(localHandler.javaName, new Class[] { MessageInfo.class }).invoke(localObject, new Object[] { paramMessageInfo });
      }
      catch (IllegalAccessException paramMessageInfo)
      {
        Log.e(this.TAG, paramMessageInfo.toString());
        paramMessageInfo = null;
      }
      catch (IllegalArgumentException paramMessageInfo)
      {
        break label151;
      }
      catch (NoSuchMethodException paramMessageInfo)
      {
        break label151;
      }
      catch (InvocationTargetException paramMessageInfo)
      {
        break label151;
      }
      catch (SecurityException paramMessageInfo)
      {
        label151:
        break label151;
      }
    }
  }
  
  public void register(String paramString, Object paramObject)
  {
    AppMethodBeat.i(86130);
    register(paramString, paramString, ReflectionHelper.MemberType.JS_METHOD, paramObject, null);
    AppMethodBeat.o(86130);
  }
  
  public void register(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(86129);
    register(paramString1, paramString2, ReflectionHelper.MemberType.JS_METHOD, paramObject, null);
    AppMethodBeat.o(86129);
  }
  
  public void register(String paramString1, String paramString2, ReflectionHelper.MemberType paramMemberType, Object paramObject)
  {
    AppMethodBeat.i(86128);
    register(paramString1, paramString2, paramMemberType, paramObject, null);
    AppMethodBeat.o(86128);
  }
  
  public void register(String paramString1, String paramString2, ReflectionHelper.MemberType paramMemberType, Object paramObject, ReflectionHelper paramReflectionHelper)
  {
    AppMethodBeat.i(86127);
    if (this.mHandlers.containsKey(paramString1))
    {
      Log.w(this.TAG, "Existing handler for ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(86127);
      return;
    }
    paramString2 = new Handler(paramString2, paramMemberType, paramObject, paramReflectionHelper);
    this.mHandlers.put(paramString1, paramString2);
    AppMethodBeat.o(86127);
  }
  
  public class Handler
  {
    String javaName;
    ReflectionHelper reflection;
    Object targetObject;
    ReflectionHelper.MemberType type;
    
    public Handler(String paramString, ReflectionHelper.MemberType paramMemberType, Object paramObject)
    {
      this(paramString, paramMemberType, paramObject, null);
    }
    
    public Handler(String paramString, ReflectionHelper.MemberType paramMemberType, Object paramObject, ReflectionHelper paramReflectionHelper)
    {
      this.type = paramMemberType;
      this.javaName = paramString;
      this.targetObject = paramObject;
      this.reflection = paramReflectionHelper;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.extension.MessageHandler
 * JD-Core Version:    0.7.0.1
 */