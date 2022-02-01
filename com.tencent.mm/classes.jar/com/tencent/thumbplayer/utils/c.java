package com.tencent.thumbplayer.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class c
{
  private a ahMT;
  private a ahMU;
  private ArrayList<String> ahMV;
  private String ahMW;
  
  public c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(227086);
    this.ahMT = null;
    this.ahMU = null;
    this.ahMV = new ArrayList();
    this.ahMW = null;
    this.ahMT = a.dq(paramContext, paramString);
    this.ahMW = (paramString + "_key");
    this.ahMU = a.dq(paramContext, this.ahMW);
    AppMethodBeat.o(227086);
  }
  
  /* Error */
  public final void a(String paramString, java.io.Serializable paramSerializable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 61
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnull +10 -> 18
    //   11: aload_1
    //   12: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +11 -> 26
    //   18: ldc 61
    //   20: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 26	com/tencent/thumbplayer/utils/c:ahMT	Lcom/tencent/thumbplayer/utils/a;
    //   30: aload_1
    //   31: invokevirtual 71	com/tencent/thumbplayer/utils/a:remove	(Ljava/lang/String;)Z
    //   34: pop
    //   35: aload_0
    //   36: getfield 26	com/tencent/thumbplayer/utils/c:ahMT	Lcom/tencent/thumbplayer/utils/a;
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 74	com/tencent/thumbplayer/utils/a:put	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   44: aload_0
    //   45: getfield 33	com/tencent/thumbplayer/utils/c:ahMV	Ljava/util/ArrayList;
    //   48: aload_1
    //   49: invokevirtual 77	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   52: pop
    //   53: aload_0
    //   54: getfield 33	com/tencent/thumbplayer/utils/c:ahMV	Ljava/util/ArrayList;
    //   57: aload_1
    //   58: invokevirtual 80	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   61: pop
    //   62: aload_0
    //   63: getfield 28	com/tencent/thumbplayer/utils/c:ahMU	Lcom/tencent/thumbplayer/utils/a;
    //   66: aload_0
    //   67: getfield 35	com/tencent/thumbplayer/utils/c:ahMW	Ljava/lang/String;
    //   70: invokevirtual 71	com/tencent/thumbplayer/utils/a:remove	(Ljava/lang/String;)Z
    //   73: pop
    //   74: aload_0
    //   75: getfield 28	com/tencent/thumbplayer/utils/c:ahMU	Lcom/tencent/thumbplayer/utils/a;
    //   78: aload_0
    //   79: getfield 35	com/tencent/thumbplayer/utils/c:ahMW	Ljava/lang/String;
    //   82: aload_0
    //   83: getfield 33	com/tencent/thumbplayer/utils/c:ahMV	Ljava/util/ArrayList;
    //   86: invokevirtual 74	com/tencent/thumbplayer/utils/a:put	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   89: ldc 61
    //   91: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: goto -71 -> 23
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	c
    //   0	102	1	paramString	String
    //   0	102	2	paramSerializable	java.io.Serializable
    // Exception table:
    //   from	to	target	type
    //   2	7	97	finally
    //   11	18	97	finally
    //   18	23	97	finally
    //   26	94	97	finally
  }
  
  /* Error */
  public final void bGj(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 83
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +11 -> 22
    //   14: ldc 83
    //   16: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 26	com/tencent/thumbplayer/utils/c:ahMT	Lcom/tencent/thumbplayer/utils/a;
    //   26: aload_1
    //   27: invokevirtual 71	com/tencent/thumbplayer/utils/a:remove	(Ljava/lang/String;)Z
    //   30: pop
    //   31: aload_0
    //   32: getfield 33	com/tencent/thumbplayer/utils/c:ahMV	Ljava/util/ArrayList;
    //   35: aload_1
    //   36: invokevirtual 77	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: aload_0
    //   41: getfield 28	com/tencent/thumbplayer/utils/c:ahMU	Lcom/tencent/thumbplayer/utils/a;
    //   44: aload_0
    //   45: getfield 35	com/tencent/thumbplayer/utils/c:ahMW	Ljava/lang/String;
    //   48: invokevirtual 71	com/tencent/thumbplayer/utils/a:remove	(Ljava/lang/String;)Z
    //   51: pop
    //   52: aload_0
    //   53: getfield 28	com/tencent/thumbplayer/utils/c:ahMU	Lcom/tencent/thumbplayer/utils/a;
    //   56: aload_0
    //   57: getfield 35	com/tencent/thumbplayer/utils/c:ahMW	Ljava/lang/String;
    //   60: aload_0
    //   61: getfield 33	com/tencent/thumbplayer/utils/c:ahMV	Ljava/util/ArrayList;
    //   64: invokevirtual 74	com/tencent/thumbplayer/utils/a:put	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   67: ldc 83
    //   69: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: goto -53 -> 19
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	c
    //   0	80	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	19	75	finally
    //   22	72	75	finally
  }
  
  public final Object kbp()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(227105);
        ArrayList localArrayList = (ArrayList)this.ahMU.getAsObject(this.ahMW);
        if ((localArrayList == null) || (localArrayList.size() <= 0))
        {
          AppMethodBeat.o(227105);
          return localObject1;
        }
        i = 0;
        localObject1 = localObject3;
        if (i < localArrayList.size())
        {
          localObject3 = (String)localArrayList.get(i);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label150;
          }
          localObject3 = this.ahMT.getAsObject((String)localObject3);
          if (localObject3 == null) {
            break label150;
          }
          if (localObject1 == null)
          {
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(localObject3);
            break label150;
          }
        }
        else
        {
          this.ahMT.clear();
          this.ahMU.clear();
          this.ahMV.clear();
          AppMethodBeat.o(227105);
          continue;
        }
        continue;
      }
      finally {}
      label150:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.c
 * JD-Core Version:    0.7.0.1
 */