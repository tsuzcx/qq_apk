package com.tencent.mm.remoteservice;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class a
  extends b.a
{
  protected RemoteService NCu;
  public b NCv;
  private final d gVN;
  
  public a(d paramd)
  {
    this.gVN = paramd;
  }
  
  public Object CLIENT_CALL(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(152736);
    paramVarArgs = objectsToBundle(paramVarArgs);
    try
    {
      this.NCv.onCallback(paramString, paramVarArgs, true);
      paramString = paramVarArgs.get("result_key");
      AppMethodBeat.o(152736);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.BaseClientRequest", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      }
    }
  }
  
  public Object REMOTE_CALL(final String paramString, final Object... paramVarArgs)
  {
    AppMethodBeat.i(152735);
    if (this.gVN.isConnected())
    {
      paramVarArgs = objectsToBundle(paramVarArgs);
      this.gVN.a(this, paramString, paramVarArgs);
      paramVarArgs.setClassLoader(getClass().getClassLoader());
      paramString = paramVarArgs.get("result_key");
      AppMethodBeat.o(152735);
      return paramString;
    }
    this.gVN.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152733);
        Bundle localBundle = a.this.objectsToBundle(paramVarArgs);
        a.a(a.this).a(a.this, paramString, localBundle);
        AppMethodBeat.o(152733);
      }
    });
    AppMethodBeat.o(152735);
    return null;
  }
  
  public Object[] getArgs(Bundle paramBundle)
  {
    AppMethodBeat.i(152738);
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    int j = paramBundle.size();
    while (i < j)
    {
      String str = String.valueOf(i);
      if (paramBundle.containsKey(str)) {
        localLinkedList.add(paramBundle.get(str));
      }
      i += 1;
    }
    paramBundle = localLinkedList.toArray();
    AppMethodBeat.o(152738);
    return paramBundle;
  }
  
  protected Bundle objectsToBundle(Object... paramVarArgs)
  {
    AppMethodBeat.i(152737);
    Bundle localBundle = new Bundle();
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      if ((paramVarArgs[i] instanceof Bundle)) {
        localBundle.putBundle(String.valueOf(i), (Bundle)paramVarArgs[i]);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramVarArgs[i] instanceof Parcelable)) {
          localBundle.putParcelable(String.valueOf(i), (Parcelable)paramVarArgs[i]);
        } else {
          localBundle.putSerializable(String.valueOf(i), (Serializable)paramVarArgs[i]);
        }
      }
    }
    AppMethodBeat.o(152737);
    return localBundle;
  }
  
  public void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(152734);
    Log.d("MicroMsg.BaseClientRequest", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        Method[] arrayOfMethod = getClass().getMethods();
        int j = arrayOfMethod.length;
        int i = 0;
        Object localObject1 = localObject2;
        if (i < j)
        {
          localObject1 = arrayOfMethod[i];
          if (((Method)localObject1).getName().equalsIgnoreCase(paramString))
          {
            break label178;
            if (((Method)localObject1).isAnnotationPresent(paramString))
            {
              paramString = ((Method)localObject1).invoke(this, getArgs(paramBundle));
              if (((Method)localObject1).getReturnType() != Void.TYPE) {
                paramBundle.putSerializable("result_key", (Serializable)paramString);
              }
            }
            AppMethodBeat.o(152734);
          }
          else
          {
            i += 1;
            continue;
            paramString = f.class;
            continue;
          }
        }
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.BaseClientRequest", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        AppMethodBeat.o(152734);
        return;
      }
      label178:
      if (paramBoolean) {
        paramString = e.class;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.remoteservice.a
 * JD-Core Version:    0.7.0.1
 */