package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.o;

public final class e
{
  public a SQc;
  private final k.c SQd;
  public final k bbv;
  
  public e(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(214987);
    this.SQd = new k.c()
    {
      /* Error */
      public final void a(io.flutter.plugin.a.j paramAnonymousj, io.flutter.plugin.a.k.d paramAnonymousd)
      {
        // Byte code:
        //   0: ldc 23
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 14	io/flutter/embedding/engine/c/e$1:SQe	Lio/flutter/embedding/engine/c/e;
        //   9: getfield 33	io/flutter/embedding/engine/c/e:SQc	Lio/flutter/embedding/engine/c/e$a;
        //   12: ifnonnull +9 -> 21
        //   15: ldc 23
        //   17: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   20: return
        //   21: aload_1
        //   22: getfield 42	io/flutter/plugin/a/j:method	Ljava/lang/String;
        //   25: astore 5
        //   27: new 44	java/lang/StringBuilder
        //   30: dup
        //   31: ldc 46
        //   33: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   36: aload 5
        //   38: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   41: ldc 55
        //   43: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   46: pop
        //   47: invokestatic 60	io/flutter/a:hwd	()V
        //   50: iconst_m1
        //   51: istore_3
        //   52: aload 5
        //   54: invokevirtual 66	java/lang/String:hashCode	()I
        //   57: istore 4
        //   59: iload 4
        //   61: tableswitch	default:+19 -> 80, -1307105544:+45->106
        //   81: tableswitch	default:+19 -> 100, 0:+40->121
        //   101: fload 184
        //   103: nop
        //   104: fload_2
        //   105: return
        //   106: aload 5
        //   108: ldc 68
        //   110: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   113: ifeq -33 -> 80
        //   116: iconst_0
        //   117: istore_3
        //   118: goto -38 -> 80
        //   121: aload_1
        //   122: getfield 76	io/flutter/plugin/a/j:SxX	Ljava/lang/Object;
        //   125: checkcast 78	java/util/HashMap
        //   128: ldc 80
        //   130: invokevirtual 84	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   133: checkcast 62	java/lang/String
        //   136: astore_1
        //   137: aload_0
        //   138: getfield 14	io/flutter/embedding/engine/c/e$1:SQe	Lio/flutter/embedding/engine/c/e;
        //   141: getfield 33	io/flutter/embedding/engine/c/e:SQc	Lio/flutter/embedding/engine/c/e$a;
        //   144: aload_1
        //   145: invokeinterface 89 2 0
        //   150: aload_2
        //   151: getstatic 95	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
        //   154: invokeinterface 101 2 0
        //   159: goto -59 -> 100
        //   162: astore_1
        //   163: aload_2
        //   164: ldc 103
        //   166: new 44	java/lang/StringBuilder
        //   169: dup
        //   170: ldc 105
        //   172: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   175: aload_1
        //   176: invokevirtual 109	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   179: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   182: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   185: aconst_null
        //   186: invokeinterface 116 4 0
        //   191: ldc 23
        //   193: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   196: return
        //   197: astore_1
        //   198: aload_2
        //   199: ldc 103
        //   201: new 44	java/lang/StringBuilder
        //   204: dup
        //   205: ldc 118
        //   207: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   210: aload_1
        //   211: invokevirtual 109	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   214: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   217: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   220: aconst_null
        //   221: invokeinterface 116 4 0
        //   226: ldc 23
        //   228: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   231: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	232	0	this	1
        //   0	232	1	paramAnonymousj	io.flutter.plugin.a.j
        //   0	232	2	paramAnonymousd	io.flutter.plugin.a.k.d
        //   51	67	3	i	int
        //   57	3	4	j	int
        //   25	82	5	str	String
        // Exception table:
        //   from	to	target	type
        //   52	59	162	java/lang/Exception
        //   106	116	162	java/lang/Exception
        //   121	137	162	java/lang/Exception
        //   150	159	162	java/lang/Exception
        //   198	231	162	java/lang/Exception
        //   137	150	197	java/lang/Exception
      }
    };
    this.bbv = new k(paramDartExecutor, "flutter/mousecursor", o.SSr);
    this.bbv.a(this.SQd);
    AppMethodBeat.o(214987);
  }
  
  public static abstract interface a
  {
    public abstract void btg(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.embedding.engine.c.e
 * JD-Core Version:    0.7.0.1
 */