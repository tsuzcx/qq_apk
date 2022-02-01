package com.tencent.mm.vfs;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFileSystem
  implements FileSystem
{
  private volatile j LFC = j.LHI;
  
  public final void a(String paramString, j.a parama)
  {
    if (parama == null)
    {
      this.LFC = j.LHI;
      return;
    }
    this.LFC = new j(this, paramString, parama);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected final void k(int paramInt, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    Object localObject1;
    for (paramVarArgs = null;; paramVarArgs = (Object[])localObject1)
    {
      localObject1 = this.LFC;
      if (((j)localObject1).LHH != null) {
        ((j)localObject1).LHH.a(((j)localObject1).gcZ, ((j)localObject1).LHG, paramInt, paramVarArgs);
      }
      return;
      localObject1 = new HashMap(paramVarArgs.length / 2);
      int i = 0;
      while (i < paramVarArgs.length - 1)
      {
        int j = i + 1;
        Object localObject2 = paramVarArgs[i];
        if (j >= paramVarArgs.length) {
          break;
        }
        i = j + 1;
        Object localObject3 = paramVarArgs[j];
        ((Map)localObject1).put(localObject2.toString(), localObject3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.AbstractFileSystem
 * JD-Core Version:    0.7.0.1
 */