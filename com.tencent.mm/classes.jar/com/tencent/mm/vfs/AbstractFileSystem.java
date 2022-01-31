package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFileSystem
  implements FileSystem
{
  private String wuh;
  private a wui;
  
  public void a(CancellationSignal paramCancellationSignal) {}
  
  public final void a(String paramString, a parama)
  {
    try
    {
      this.wuh = paramString;
      this.wui = parama;
      return;
    }
    finally {}
  }
  
  protected final void j(int paramInt, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    Object localObject1;
    for (paramVarArgs = null;; paramVarArgs = (Object[])localObject1)
    {
      Object localObject2;
      try
      {
        localObject1 = this.wuh;
        localObject2 = this.wui;
        if (localObject2 != null) {
          ((a)localObject2).b((String)localObject1, paramInt, paramVarArgs);
        }
        return;
      }
      finally {}
      localObject1 = new HashMap(paramVarArgs.length / 2);
      int i = 0;
      while (i < paramVarArgs.length - 1)
      {
        int j = i + 1;
        localObject2 = paramVarArgs[i];
        if (j >= paramVarArgs.length) {
          break;
        }
        i = j + 1;
        Object localObject3 = paramVarArgs[j];
        ((Map)localObject1).put(localObject2.toString(), localObject3);
      }
    }
  }
  
  public void m(Map<String, String> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.AbstractFileSystem
 * JD-Core Version:    0.7.0.1
 */