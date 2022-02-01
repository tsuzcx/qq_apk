package org.xwalk.core;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.l;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class XWalkReflectionInitHandler
{
  public static final String TAG = "XWalkReflectionInitHandler";
  static HashMap<String, LinkedList<ReservedAction>> sReservedActions;
  static LinkedList<String> sReservedActivities;
  
  static
  {
    AppMethodBeat.i(187681);
    sReservedActivities = new LinkedList();
    sReservedActions = new HashMap();
    AppMethodBeat.o(187681);
  }
  
  public static void handlePostInit(Context paramContext)
  {
    AppMethodBeat.i(187651);
    handlePostInit(paramContext.getClass().getName());
    AppMethodBeat.o(187651);
  }
  
  private static void handlePostInit(String paramString)
  {
    AppMethodBeat.i(187661);
    Log.i("XWalkReflectionInitHandler", "handlePostInit, tag:".concat(String.valueOf(paramString)));
    if (!sReservedActions.containsKey(paramString))
    {
      AppMethodBeat.o(187661);
      return;
    }
    LinkedList localLinkedList = (LinkedList)sReservedActions.get(paramString);
    while ((localLinkedList != null) && (localLinkedList.size() != 0))
    {
      ReservedAction localReservedAction = (ReservedAction)localLinkedList.pop();
      if (localReservedAction.mObject != null)
      {
        Log.w("XWalkReflectionInitHandler", "Init reserved object: " + localReservedAction.mObject.getClass());
        new ReflectMethod(localReservedAction.mObject, "reflectionInit", new Class[0]).invoke(new Object[0]);
        l.y(1749L, 22L, 1L);
      }
      else if (localReservedAction.mClass != null)
      {
        Log.w("XWalkReflectionInitHandler", "Init reserved class: " + localReservedAction.mClass.toString());
        new ReflectMethod(localReservedAction.mClass, "reflectionInit", new Class[0]).invoke(new Object[0]);
        l.y(1749L, 23L, 1L);
      }
      else
      {
        Log.w("XWalkReflectionInitHandler", "Call reserved method: " + localReservedAction.mMethod.toString());
        Object[] arrayOfObject = localReservedAction.mArguments;
        if (arrayOfObject != null)
        {
          int i = 0;
          while (i < arrayOfObject.length)
          {
            if ((arrayOfObject[i] instanceof ReflectMethod)) {
              arrayOfObject[i] = ((ReflectMethod)arrayOfObject[i]).invokeWithArguments();
            }
            i += 1;
          }
        }
        localReservedAction.mMethod.invoke(arrayOfObject);
        l.y(1749L, 24L, 1L);
      }
    }
    sReservedActions.remove(paramString);
    sReservedActivities.remove(paramString);
    AppMethodBeat.o(187661);
  }
  
  public static void handlePreInit(Context paramContext)
  {
    AppMethodBeat.i(187643);
    XWalkEnvironment.init(paramContext);
    handlePreInit(paramContext.getClass().getName());
    AppMethodBeat.o(187643);
  }
  
  private static void handlePreInit(String paramString)
  {
    AppMethodBeat.i(187647);
    if (XWalkCoreWrapper.getInstance() != null)
    {
      AppMethodBeat.o(187647);
      return;
    }
    Log.i("XWalkReflectionInitHandler", "handlePreInit, tag:".concat(String.valueOf(paramString)));
    if (sReservedActions.containsKey(paramString)) {
      sReservedActions.remove(paramString);
    }
    for (;;)
    {
      sReservedActions.put(paramString, new LinkedList());
      AppMethodBeat.o(187647);
      return;
      sReservedActivities.add(paramString);
    }
  }
  
  public static void reserveReflectClass(Class<?> paramClass)
  {
    AppMethodBeat.i(187673);
    if (sReservedActivities.isEmpty())
    {
      Log.w("XWalkReflectionInitHandler", "reserveReflectClass, call handlePreInit method first");
      AppMethodBeat.o(187673);
      return;
    }
    String str = (String)sReservedActivities.getLast();
    Log.w("XWalkReflectionInitHandler", "Reserve (" + paramClass.toString() + ") for " + str);
    if (sReservedActions.get(str) != null) {
      ((LinkedList)sReservedActions.get(str)).add(new ReservedAction(paramClass));
    }
    AppMethodBeat.o(187673);
  }
  
  public static void reserveReflectMethod(ReflectMethod paramReflectMethod)
  {
    AppMethodBeat.i(187678);
    if (sReservedActivities.isEmpty())
    {
      Log.w("XWalkReflectionInitHandler", "reserveReflectMethod, call handlePreInit method first");
      AppMethodBeat.o(187678);
      return;
    }
    String str = (String)sReservedActivities.getLast();
    Log.w("XWalkReflectionInitHandler", "Reserve method (" + paramReflectMethod.toString() + ") for " + str);
    if (sReservedActions.get(str) != null) {
      ((LinkedList)sReservedActions.get(str)).add(new ReservedAction(paramReflectMethod));
    }
    AppMethodBeat.o(187678);
  }
  
  public static void reserveReflectObject(Object paramObject)
  {
    AppMethodBeat.i(187668);
    if (sReservedActivities.isEmpty())
    {
      Log.w("XWalkReflectionInitHandler", "reserveReflectObject, call handlePreInit method first");
      AppMethodBeat.o(187668);
      return;
    }
    String str = (String)sReservedActivities.getLast();
    Log.w("XWalkReflectionInitHandler", "Reserve object (" + paramObject.getClass() + ") for " + str);
    if (sReservedActions.get(str) != null) {
      ((LinkedList)sReservedActions.get(str)).add(new ReservedAction(paramObject));
    }
    AppMethodBeat.o(187668);
  }
  
  static class ReservedAction
  {
    Object[] mArguments;
    Class<?> mClass;
    ReflectMethod mMethod;
    Object mObject;
    
    ReservedAction(Class<?> paramClass)
    {
      this.mClass = paramClass;
    }
    
    ReservedAction(Object paramObject)
    {
      this.mObject = paramObject;
    }
    
    ReservedAction(ReflectMethod paramReflectMethod)
    {
      AppMethodBeat.i(187607);
      this.mMethod = paramReflectMethod;
      if (paramReflectMethod.getArguments() != null) {
        this.mArguments = Arrays.copyOf(paramReflectMethod.getArguments(), paramReflectMethod.getArguments().length);
      }
      AppMethodBeat.o(187607);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkReflectionInitHandler
 * JD-Core Version:    0.7.0.1
 */