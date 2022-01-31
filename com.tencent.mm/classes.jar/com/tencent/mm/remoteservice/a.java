package com.tencent.mm.remoteservice;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class a
  extends b.a
{
  private final d eMh;
  public b uaA;
  protected RemoteService uaz;
  
  public a(d paramd)
  {
    this.eMh = paramd;
  }
  
  public Object CLIENT_CALL(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = objectsToBundle(paramVarArgs);
    try
    {
      this.uaA.onCallback(paramString, paramVarArgs, true);
      return paramVarArgs.get("result_key");
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.BaseClientRequest", "exception:%s", new Object[] { bk.j(paramString) });
      }
    }
  }
  
  public Object REMOTE_CALL(String paramString, Object... paramVarArgs)
  {
    if (this.eMh.isConnected())
    {
      paramVarArgs = objectsToBundle(paramVarArgs);
      this.eMh.a(this, paramString, paramVarArgs);
      paramVarArgs.setClassLoader(getClass().getClassLoader());
      return paramVarArgs.get("result_key");
    }
    this.eMh.connect(new a.1(this, paramVarArgs, paramString));
    return null;
  }
  
  public Object[] getArgs(Bundle paramBundle)
  {
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
    return localLinkedList.toArray();
  }
  
  public Bundle objectsToBundle(Object... paramVarArgs)
  {
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
    return localBundle;
  }
  
  public void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    y.d("MicroMsg.BaseClientRequest", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    for (;;)
    {
      int i;
      Object localObject1;
      try
      {
        Method[] arrayOfMethod = getClass().getMethods();
        int j = arrayOfMethod.length;
        i = 0;
        localObject1 = localObject2;
        if (i >= j) {
          break label154;
        }
        localObject1 = arrayOfMethod[i];
        if (!((Method)localObject1).getName().equalsIgnoreCase(paramString)) {
          break label170;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.BaseClientRequest", "exception:%s", new Object[] { bk.j(paramString) });
        return;
      }
      if (((Method)localObject1).isAnnotationPresent(paramString))
      {
        paramString = ((Method)localObject1).invoke(this, getArgs(paramBundle));
        if (((Method)localObject1).getReturnType() != Void.TYPE)
        {
          paramBundle.putSerializable("result_key", (Serializable)paramString);
          return;
          paramString = f.class;
          continue;
          label154:
          if (localObject1 != null)
          {
            if (!paramBoolean) {
              continue;
            }
            paramString = e.class;
            continue;
          }
        }
      }
      return;
      label170:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.remoteservice.a
 * JD-Core Version:    0.7.0.1
 */