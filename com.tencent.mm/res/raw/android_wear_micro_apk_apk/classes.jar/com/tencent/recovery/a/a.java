package com.tencent.recovery.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements e
{
  private List<b> aiU = new ArrayList(100);
  
  public final void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.aiU.size() < 100)
    {
      b localb = new b(this, (byte)0);
      localb.level = 5;
      localb.tag = paramString1;
      localb.aiV = paramString2;
      localb.aiW = paramVarArgs;
      this.aiU.add(localb);
    }
    Log.e(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public final void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (this.aiU.size() < 100)
    {
      b localb = new b(this, (byte)0);
      localb.level = 5;
      localb.tag = paramString1;
      localb.aiV = paramString2;
      localb.aiW = paramVarArgs;
      localb.aiX = paramThrowable;
      this.aiU.add(localb);
    }
    Log.e(paramString1, String.format(paramString2, paramVarArgs), paramThrowable);
  }
  
  public final void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.aiU.size() < 100)
    {
      b localb = new b(this, (byte)0);
      localb.level = 3;
      localb.tag = paramString1;
      localb.aiV = paramString2;
      localb.aiW = paramVarArgs;
      this.aiU.add(localb);
    }
    Log.i(paramString1, String.format(paramString2, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.a.a
 * JD-Core Version:    0.7.0.1
 */