package com.tencent.mm.ui.widget.cedit.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class a<T>
{
  private Object QLN;
  private Method mMethod;
  
  public a(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(206117);
    this.QLN = paramObject;
    paramObject = paramObject.getClass();
    for (;;)
    {
      if (paramObject != Object.class) {}
      try
      {
        this.mMethod = paramObject.getDeclaredMethod(paramString, paramVarArgs);
        label35:
        paramObject = paramObject.getSuperclass();
        continue;
        if (this.mMethod == null) {
          new Throwable("MB ".concat(String.valueOf(paramString)));
        }
        AppMethodBeat.o(206117);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label35;
      }
    }
  }
  
  /* Error */
  public a(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 16	java/lang/Object:<init>	()V
    //   4: ldc 63
    //   6: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: astore_1
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 25	com/tencent/mm/ui/widget/cedit/util/a:QLN	Ljava/lang/Object;
    //   19: aload_1
    //   20: ldc 5
    //   22: if_acmpeq +27 -> 49
    //   25: aload_0
    //   26: aload_1
    //   27: aload_2
    //   28: aload_3
    //   29: invokevirtual 35	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   32: putfield 37	com/tencent/mm/ui/widget/cedit/util/a:mMethod	Ljava/lang/reflect/Method;
    //   35: aload_1
    //   36: invokevirtual 40	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   39: astore_1
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aconst_null
    //   45: astore_1
    //   46: goto -32 -> 14
    //   49: ldc 63
    //   51: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: astore 4
    //   57: goto -22 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	a
    //   0	60	1	paramString1	String
    //   0	60	2	paramString2	String
    //   0	60	3	paramVarArgs	Class<?>[]
    //   55	1	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   9	14	43	java/lang/Throwable
    //   25	35	55	java/lang/Throwable
  }
  
  public final T invoke(Object... paramVarArgs)
  {
    AppMethodBeat.i(206119);
    try
    {
      this.mMethod.setAccessible(true);
      paramVarArgs = this.mMethod.invoke(this.QLN, paramVarArgs);
      AppMethodBeat.o(206119);
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs)
    {
      AppMethodBeat.o(206119);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.a
 * JD-Core Version:    0.7.0.1
 */