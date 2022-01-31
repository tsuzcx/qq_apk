package com.tencent.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class f
{
  private static boolean Bzd = false;
  private static boolean Bze = false;
  private static boolean Bzf = false;
  private static f Bzg;
  private int Bzh;
  private Map<Long, Map<f.a, Queue<Integer>>> Bzi;
  private Map<Long, Map<Integer, f.a>> Bzj;
  private Map<Long, Set<Integer>> Bzk;
  private long Bzl;
  private final String TAG;
  
  public f()
  {
    AppMethodBeat.i(86593);
    this.TAG = f.class.getSimpleName();
    this.Bzh = 0;
    this.Bzi = new HashMap();
    this.Bzj = new HashMap();
    this.Bzk = new HashMap();
    AppMethodBeat.o(86593);
  }
  
  /* Error */
  private void K(int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 69
    //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ifnonnull +11 -> 21
    //   13: ldc 69
    //   15: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: iload_2
    //   22: aload_1
    //   23: arraylength
    //   24: if_icmpge +23 -> 47
    //   27: iload_2
    //   28: iconst_0
    //   29: iadd
    //   30: ifgt +17 -> 47
    //   33: aload_0
    //   34: aload_1
    //   35: iconst_0
    //   36: iaload
    //   37: invokespecial 72	com/tencent/util/f:Tl	(I)V
    //   40: iload_2
    //   41: iconst_1
    //   42: iadd
    //   43: istore_2
    //   44: goto -23 -> 21
    //   47: ldc 69
    //   49: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -34 -> 18
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	f
    //   0	60	1	paramArrayOfInt	int[]
    //   1	43	2	i	int
    // Exception table:
    //   from	to	target	type
    //   4	9	55	finally
    //   13	18	55	finally
    //   21	27	55	finally
    //   33	40	55	finally
    //   47	52	55	finally
  }
  
  /* Error */
  private void Tl(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 73
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 79	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   10: invokevirtual 83	java/lang/Thread:getId	()J
    //   13: lstore_2
    //   14: ldc 85
    //   16: iconst_3
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: lload_2
    //   23: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: iload_1
    //   30: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   33: aastore
    //   34: dup
    //   35: iconst_2
    //   36: invokestatic 99	com/tencent/util/f:dXa	()Ljava/lang/String;
    //   39: aastore
    //   40: invokestatic 105	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   43: pop
    //   44: iload_1
    //   45: ifne +28 -> 73
    //   48: ldc 107
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: lload_2
    //   57: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   60: aastore
    //   61: invokestatic 105	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   64: pop
    //   65: ldc 73
    //   67: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: getstatic 29	com/tencent/util/f:Bzd	Z
    //   76: ifeq +201 -> 277
    //   79: aload_0
    //   80: getfield 59	com/tencent/util/f:Bzi	Ljava/util/Map;
    //   83: lload_2
    //   84: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   87: invokeinterface 113 2 0
    //   92: ifne +24 -> 116
    //   95: aload_0
    //   96: getfield 59	com/tencent/util/f:Bzi	Ljava/util/Map;
    //   99: lload_2
    //   100: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   103: new 56	java/util/HashMap
    //   106: dup
    //   107: invokespecial 57	java/util/HashMap:<init>	()V
    //   110: invokeinterface 117 3 0
    //   115: pop
    //   116: aload_0
    //   117: getfield 59	com/tencent/util/f:Bzi	Ljava/util/Map;
    //   120: lload_2
    //   121: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: invokeinterface 121 2 0
    //   129: checkcast 109	java/util/Map
    //   132: astore 6
    //   134: aload_0
    //   135: iload_1
    //   136: invokespecial 125	com/tencent/util/f:Tm	(I)Lcom/tencent/util/f$a;
    //   139: astore 5
    //   141: aload 5
    //   143: astore 4
    //   145: aload 5
    //   147: ifnonnull +15 -> 162
    //   150: new 6	com/tencent/util/f$a
    //   153: dup
    //   154: aload_0
    //   155: iconst_m1
    //   156: iconst_m1
    //   157: invokespecial 128	com/tencent/util/f$a:<init>	(Lcom/tencent/util/f;II)V
    //   160: astore 4
    //   162: aload 6
    //   164: aload 4
    //   166: invokeinterface 113 2 0
    //   171: ifne +20 -> 191
    //   174: aload 6
    //   176: aload 4
    //   178: new 130	java/util/LinkedList
    //   181: dup
    //   182: invokespecial 131	java/util/LinkedList:<init>	()V
    //   185: invokeinterface 117 3 0
    //   190: pop
    //   191: aload 6
    //   193: aload 4
    //   195: invokeinterface 121 2 0
    //   200: checkcast 133	java/util/Queue
    //   203: iload_1
    //   204: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: invokeinterface 136 2 0
    //   212: pop
    //   213: ldc 138
    //   215: iconst_4
    //   216: anewarray 4	java/lang/Object
    //   219: dup
    //   220: iconst_0
    //   221: lload_2
    //   222: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aload 4
    //   230: getfield 141	com/tencent/util/f$a:width	I
    //   233: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aastore
    //   237: dup
    //   238: iconst_2
    //   239: aload 4
    //   241: getfield 144	com/tencent/util/f$a:height	I
    //   244: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   247: aastore
    //   248: dup
    //   249: iconst_3
    //   250: invokestatic 99	com/tencent/util/f:dXa	()Ljava/lang/String;
    //   253: aastore
    //   254: invokestatic 105	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   257: pop
    //   258: aload_0
    //   259: invokespecial 147	com/tencent/util/f:dXb	()V
    //   262: ldc 73
    //   264: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: goto -197 -> 70
    //   270: astore 4
    //   272: aload_0
    //   273: monitorexit
    //   274: aload 4
    //   276: athrow
    //   277: ldc 149
    //   279: iconst_3
    //   280: anewarray 4	java/lang/Object
    //   283: dup
    //   284: iconst_0
    //   285: lload_2
    //   286: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   289: aastore
    //   290: dup
    //   291: iconst_1
    //   292: iload_1
    //   293: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: aastore
    //   297: dup
    //   298: iconst_2
    //   299: invokestatic 99	com/tencent/util/f:dXa	()Ljava/lang/String;
    //   302: aastore
    //   303: invokestatic 105	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   306: pop
    //   307: iconst_1
    //   308: iconst_1
    //   309: newarray int
    //   311: dup
    //   312: iconst_0
    //   313: iload_1
    //   314: iastore
    //   315: iconst_0
    //   316: invokestatic 155	android/opengl/GLES20:glDeleteTextures	(I[II)V
    //   319: aload_0
    //   320: getfield 63	com/tencent/util/f:Bzk	Ljava/util/Map;
    //   323: lload_2
    //   324: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   327: invokeinterface 121 2 0
    //   332: checkcast 157	java/util/Set
    //   335: astore 4
    //   337: aload 4
    //   339: ifnull +15 -> 354
    //   342: aload 4
    //   344: iload_1
    //   345: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: invokeinterface 160 2 0
    //   353: pop
    //   354: aload_0
    //   355: aload_0
    //   356: getfield 54	com/tencent/util/f:Bzh	I
    //   359: iconst_1
    //   360: isub
    //   361: putfield 54	com/tencent/util/f:Bzh	I
    //   364: getstatic 29	com/tencent/util/f:Bzd	Z
    //   367: ifeq -109 -> 258
    //   370: aload_0
    //   371: getfield 61	com/tencent/util/f:Bzj	Ljava/util/Map;
    //   374: lload_2
    //   375: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   378: invokeinterface 121 2 0
    //   383: checkcast 109	java/util/Map
    //   386: astore 4
    //   388: aload 4
    //   390: ifnull -132 -> 258
    //   393: aload 4
    //   395: iload_1
    //   396: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   399: invokeinterface 162 2 0
    //   404: pop
    //   405: goto -147 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	f
    //   0	408	1	paramInt	int
    //   13	362	2	l	long
    //   143	97	4	locala1	f.a
    //   270	5	4	localObject1	Object
    //   335	59	4	localObject2	Object
    //   139	7	5	locala2	f.a
    //   132	60	6	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	44	270	finally
    //   48	70	270	finally
    //   73	116	270	finally
    //   116	141	270	finally
    //   150	162	270	finally
    //   162	191	270	finally
    //   191	258	270	finally
    //   258	267	270	finally
    //   277	337	270	finally
    //   342	354	270	finally
    //   354	388	270	finally
    //   393	405	270	finally
  }
  
  /* Error */
  private f.a Tm(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 163
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 29	com/tencent/util/f:Bzd	Z
    //   10: ifeq +59 -> 69
    //   13: invokestatic 79	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 83	java/lang/Thread:getId	()J
    //   19: lstore_2
    //   20: aload_0
    //   21: getfield 61	com/tencent/util/f:Bzj	Ljava/util/Map;
    //   24: lload_2
    //   25: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: invokeinterface 121 2 0
    //   33: checkcast 109	java/util/Map
    //   36: astore 4
    //   38: aload 4
    //   40: ifnull +29 -> 69
    //   43: aload 4
    //   45: iload_1
    //   46: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: invokeinterface 121 2 0
    //   54: checkcast 6	com/tencent/util/f$a
    //   57: astore 4
    //   59: ldc 163
    //   61: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 4
    //   68: areturn
    //   69: aconst_null
    //   70: astore 4
    //   72: ldc 163
    //   74: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: goto -13 -> 64
    //   80: astore 4
    //   82: aload_0
    //   83: monitorexit
    //   84: aload 4
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	f
    //   0	87	1	paramInt	int
    //   19	6	2	l	long
    //   36	35	4	localObject1	Object
    //   80	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	80	finally
    //   43	64	80	finally
    //   72	77	80	finally
  }
  
  public static f dWZ()
  {
    AppMethodBeat.i(86594);
    if (Bzg == null) {}
    try
    {
      if (Bzg == null) {
        Bzg = new f();
      }
      f localf = Bzg;
      AppMethodBeat.o(86594);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(86594);
    }
  }
  
  private static String dXa()
  {
    AppMethodBeat.i(86607);
    if (Bzf)
    {
      Object localObject = Thread.currentThread().getStackTrace();
      if ((localObject == null) || (localObject.length == 0))
      {
        AppMethodBeat.o(86607);
        return "unknown";
      }
      int i = 0;
      int j;
      for (;;)
      {
        j = i;
        if (i >= localObject.length) {
          break;
        }
        if (localObject[i].getMethodName().equals("getCallFrom")) {
          for (;;)
          {
            j = i;
            if (i >= localObject.length) {
              break;
            }
            j = i;
            if (!localObject[i].getClassName().contains("GLMemoryManager")) {
              break;
            }
            i += 1;
          }
        }
        i += 1;
      }
      if (j < localObject.length)
      {
        localObject = localObject[j];
        localObject = ((StackTraceElement)localObject).getClassName() + " - " + ((StackTraceElement)localObject).getMethodName() + "()";
        AppMethodBeat.o(86607);
        return localObject;
      }
    }
    AppMethodBeat.o(86607);
    return "unknown";
  }
  
  private void dXb()
  {
    AppMethodBeat.i(86608);
    if (Bze) {
      String.format("texture reference count = %d", new Object[] { Integer.valueOf(this.Bzh) });
    }
    AppMethodBeat.o(86608);
  }
  
  private int rZ(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(86595);
      int i = z(-1, -1, paramBoolean);
      AppMethodBeat.o(86595);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private int z(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 220
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 79	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   10: invokevirtual 83	java/lang/Thread:getId	()J
    //   13: lstore 4
    //   15: new 197	java/lang/StringBuilder
    //   18: dup
    //   19: ldc 222
    //   21: invokespecial 225	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: iload_3
    //   25: invokevirtual 228	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: ldc 230
    //   30: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: iconst_4
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: lload 4
    //   44: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: iload_1
    //   51: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: iload_2
    //   58: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: aastore
    //   62: dup
    //   63: iconst_3
    //   64: invokestatic 99	com/tencent/util/f:dXa	()Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 105	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   71: pop
    //   72: getstatic 29	com/tencent/util/f:Bzd	Z
    //   75: ifeq +257 -> 332
    //   78: iload_3
    //   79: ifne +253 -> 332
    //   82: aload_0
    //   83: getfield 59	com/tencent/util/f:Bzi	Ljava/util/Map;
    //   86: lload 4
    //   88: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   91: invokeinterface 121 2 0
    //   96: checkcast 109	java/util/Map
    //   99: astore 6
    //   101: aload 6
    //   103: ifnull +229 -> 332
    //   106: aload 6
    //   108: invokeinterface 234 1 0
    //   113: ifne +219 -> 332
    //   116: aload 6
    //   118: new 6	com/tencent/util/f$a
    //   121: dup
    //   122: aload_0
    //   123: iload_1
    //   124: iload_2
    //   125: invokespecial 128	com/tencent/util/f$a:<init>	(Lcom/tencent/util/f;II)V
    //   128: invokeinterface 121 2 0
    //   133: checkcast 133	java/util/Queue
    //   136: astore 7
    //   138: aload 7
    //   140: ifnull +72 -> 212
    //   143: aload 7
    //   145: invokeinterface 235 1 0
    //   150: ifne +62 -> 212
    //   153: ldc 237
    //   155: iconst_3
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: lload 4
    //   163: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: iload_1
    //   170: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: aastore
    //   174: dup
    //   175: iconst_2
    //   176: iload_2
    //   177: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: aastore
    //   181: invokestatic 105	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   184: pop
    //   185: aload_0
    //   186: invokespecial 147	com/tencent/util/f:dXb	()V
    //   189: aload 7
    //   191: invokeinterface 241 1 0
    //   196: checkcast 93	java/lang/Integer
    //   199: invokevirtual 245	java/lang/Integer:intValue	()I
    //   202: istore_1
    //   203: ldc 220
    //   205: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_0
    //   209: monitorexit
    //   210: iload_1
    //   211: ireturn
    //   212: aload 6
    //   214: invokeinterface 249 1 0
    //   219: invokeinterface 253 1 0
    //   224: astore 6
    //   226: aload 6
    //   228: invokeinterface 258 1 0
    //   233: ifeq +99 -> 332
    //   236: aload 6
    //   238: invokeinterface 261 1 0
    //   243: checkcast 263	java/util/Map$Entry
    //   246: invokeinterface 266 1 0
    //   251: checkcast 133	java/util/Queue
    //   254: astore 7
    //   256: aload 7
    //   258: invokeinterface 235 1 0
    //   263: ifne -37 -> 226
    //   266: ldc_w 268
    //   269: iconst_3
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: lload 4
    //   277: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: iload_1
    //   284: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   287: aastore
    //   288: dup
    //   289: iconst_2
    //   290: iload_2
    //   291: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   294: aastore
    //   295: invokestatic 105	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   298: pop
    //   299: aload_0
    //   300: invokespecial 147	com/tencent/util/f:dXb	()V
    //   303: aload 7
    //   305: invokeinterface 241 1 0
    //   310: checkcast 93	java/lang/Integer
    //   313: invokevirtual 245	java/lang/Integer:intValue	()I
    //   316: istore_1
    //   317: ldc 220
    //   319: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: goto -114 -> 208
    //   325: astore 6
    //   327: aload_0
    //   328: monitorexit
    //   329: aload 6
    //   331: athrow
    //   332: ldc_w 270
    //   335: iconst_3
    //   336: anewarray 4	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: lload 4
    //   343: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   346: aastore
    //   347: dup
    //   348: iconst_1
    //   349: iload_1
    //   350: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: aastore
    //   354: dup
    //   355: iconst_2
    //   356: iload_2
    //   357: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: aastore
    //   361: invokestatic 105	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   364: pop
    //   365: iconst_1
    //   366: newarray int
    //   368: astore 6
    //   370: iconst_1
    //   371: aload 6
    //   373: iconst_0
    //   374: invokestatic 273	android/opengl/GLES20:glGenTextures	(I[II)V
    //   377: aload_0
    //   378: getfield 63	com/tencent/util/f:Bzk	Ljava/util/Map;
    //   381: lload 4
    //   383: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   386: invokeinterface 113 2 0
    //   391: ifne +25 -> 416
    //   394: aload_0
    //   395: getfield 63	com/tencent/util/f:Bzk	Ljava/util/Map;
    //   398: lload 4
    //   400: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   403: new 275	java/util/HashSet
    //   406: dup
    //   407: invokespecial 276	java/util/HashSet:<init>	()V
    //   410: invokeinterface 117 3 0
    //   415: pop
    //   416: aload_0
    //   417: getfield 63	com/tencent/util/f:Bzk	Ljava/util/Map;
    //   420: lload 4
    //   422: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   425: invokeinterface 121 2 0
    //   430: checkcast 157	java/util/Set
    //   433: aload 6
    //   435: iconst_0
    //   436: iaload
    //   437: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: invokeinterface 279 2 0
    //   445: pop
    //   446: aload_0
    //   447: aload_0
    //   448: getfield 54	com/tencent/util/f:Bzh	I
    //   451: iconst_1
    //   452: iadd
    //   453: putfield 54	com/tencent/util/f:Bzh	I
    //   456: aload_0
    //   457: invokespecial 147	com/tencent/util/f:dXb	()V
    //   460: aload 6
    //   462: iconst_0
    //   463: iaload
    //   464: istore_1
    //   465: ldc 220
    //   467: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   470: goto -262 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	this	f
    //   0	473	1	paramInt1	int
    //   0	473	2	paramInt2	int
    //   0	473	3	paramBoolean	boolean
    //   13	408	4	l	long
    //   99	138	6	localObject1	Object
    //   325	5	6	localObject2	Object
    //   368	93	6	arrayOfInt	int[]
    //   136	168	7	localQueue	Queue
    // Exception table:
    //   from	to	target	type
    //   2	78	325	finally
    //   82	101	325	finally
    //   106	138	325	finally
    //   143	208	325	finally
    //   212	226	325	finally
    //   226	322	325	finally
    //   332	416	325	finally
    //   416	460	325	finally
    //   465	470	325	finally
  }
  
  public final void FC(int paramInt)
  {
    try
    {
      AppMethodBeat.i(86602);
      Tl(paramInt);
      AppMethodBeat.o(86602);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void I(int[] paramArrayOfInt)
  {
    try
    {
      AppMethodBeat.i(86596);
      c(paramArrayOfInt, false);
      AppMethodBeat.o(86596);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  public final void J(int[] paramArrayOfInt)
  {
    try
    {
      AppMethodBeat.i(86600);
      K(paramArrayOfInt);
      AppMethodBeat.o(86600);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  /* Error */
  public final boolean aH(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 292
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 29	com/tencent/util/f:Bzd	Z
    //   11: ifeq +108 -> 119
    //   14: invokestatic 79	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   17: invokevirtual 83	java/lang/Thread:getId	()J
    //   20: lstore 4
    //   22: aload_0
    //   23: getfield 61	com/tencent/util/f:Bzj	Ljava/util/Map;
    //   26: lload 4
    //   28: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   31: invokeinterface 113 2 0
    //   36: ifeq +83 -> 119
    //   39: aload_0
    //   40: getfield 61	com/tencent/util/f:Bzj	Ljava/util/Map;
    //   43: lload 4
    //   45: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: invokeinterface 121 2 0
    //   53: checkcast 109	java/util/Map
    //   56: iload_1
    //   57: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokeinterface 121 2 0
    //   65: checkcast 6	com/tencent/util/f$a
    //   68: astore 7
    //   70: aload 7
    //   72: ifnull +35 -> 107
    //   75: aload 7
    //   77: getfield 141	com/tencent/util/f$a:width	I
    //   80: iload_2
    //   81: if_icmpne +26 -> 107
    //   84: aload 7
    //   86: getfield 144	com/tencent/util/f$a:height	I
    //   89: iload_3
    //   90: if_icmpne +17 -> 107
    //   93: iconst_1
    //   94: istore 6
    //   96: ldc_w 292
    //   99: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_0
    //   103: monitorexit
    //   104: iload 6
    //   106: ireturn
    //   107: ldc_w 292
    //   110: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iconst_0
    //   114: istore 6
    //   116: goto -14 -> 102
    //   119: ldc_w 292
    //   122: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iconst_0
    //   126: istore 6
    //   128: goto -26 -> 102
    //   131: astore 7
    //   133: aload_0
    //   134: monitorexit
    //   135: aload 7
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	f
    //   0	138	1	paramInt1	int
    //   0	138	2	paramInt2	int
    //   0	138	3	paramInt3	int
    //   20	24	4	l	long
    //   94	33	6	bool	boolean
    //   68	17	7	locala	f.a
    //   131	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	70	131	finally
    //   75	93	131	finally
    //   96	102	131	finally
    //   107	113	131	finally
    //   119	125	131	finally
  }
  
  public final void aI(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(86605);
      if (Bzd)
      {
        long l = Thread.currentThread().getId();
        String.format("updateTextureSize(), GLThread id = %d, textureId = %d, width = %d, height = %d, called from: %s", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), dXa() });
        if (!this.Bzj.containsKey(Long.valueOf(l))) {
          this.Bzj.put(Long.valueOf(l), new HashMap());
        }
        ((Map)this.Bzj.get(Long.valueOf(l))).put(Integer.valueOf(paramInt1), new f.a(this, paramInt2, paramInt3));
      }
      AppMethodBeat.o(86605);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void c(int[] paramArrayOfInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 298
    //   7: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_1
    //   11: ifnonnull +12 -> 23
    //   14: ldc_w 298
    //   17: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: iload_3
    //   24: aload_1
    //   25: arraylength
    //   26: if_icmpge +24 -> 50
    //   29: iload_3
    //   30: iconst_0
    //   31: iadd
    //   32: ifgt +18 -> 50
    //   35: aload_1
    //   36: iconst_0
    //   37: aload_0
    //   38: iload_2
    //   39: invokespecial 300	com/tencent/util/f:rZ	(Z)I
    //   42: iastore
    //   43: iload_3
    //   44: iconst_1
    //   45: iadd
    //   46: istore_3
    //   47: goto -24 -> 23
    //   50: ldc_w 298
    //   53: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -36 -> 20
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	f
    //   0	64	1	paramArrayOfInt	int[]
    //   0	64	2	paramBoolean	boolean
    //   1	46	3	i	int
    // Exception table:
    //   from	to	target	type
    //   4	10	59	finally
    //   14	20	59	finally
    //   23	29	59	finally
    //   35	43	59	finally
    //   50	56	59	finally
  }
  
  public final int ix(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(86598);
      paramInt1 = z(paramInt1, paramInt2, false);
      AppMethodBeat.o(86598);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void iy(int paramInt1, int paramInt2)
  {
    try
    {
      this.Bzl += paramInt1 * paramInt2 * 4;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void iz(int paramInt1, int paramInt2)
  {
    try
    {
      this.Bzl -= paramInt1 * paramInt2 * 4;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.util.f
 * JD-Core Version:    0.7.0.1
 */