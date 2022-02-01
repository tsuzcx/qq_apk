package com.tencent.mm.vfs;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFileSystem
  implements FileSystem
{
  private volatile n RaS = n.Rdw;
  
  public final void a(String paramString, n.a parama)
  {
    if (parama == null)
    {
      this.RaS = n.Rdw;
      return;
    }
    this.RaS = new n(this, paramString, parama);
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
      localObject1 = this.RaS;
      if (((n)localObject1).Rdv != null) {
        ((n)localObject1).Rdv.a(((n)localObject1).gIx, ((n)localObject1).Rdu, paramInt, paramVarArgs);
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