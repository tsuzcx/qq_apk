package com.tencent.mm.vfs;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFileSystem
  implements FileSystem
{
  private volatile s agvF = s.agzG;
  
  public final void a(String paramString, s.a parama)
  {
    if (parama == null)
    {
      this.agvF = s.agzG;
      return;
    }
    this.agvF = new s(this, paramString, parama);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected final void l(int paramInt, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    Object localObject1;
    for (paramVarArgs = null;; paramVarArgs = (Object[])localObject1)
    {
      localObject1 = this.agvF;
      if (((s)localObject1).agzF != null) {
        ((s)localObject1).agzF.a(((s)localObject1).lWh, ((s)localObject1).agzE, paramInt, paramVarArgs);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.AbstractFileSystem
 * JD-Core Version:    0.7.0.1
 */