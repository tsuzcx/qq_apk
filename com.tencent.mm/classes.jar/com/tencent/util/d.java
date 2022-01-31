package com.tencent.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class d
{
  private static boolean xcw = false;
  private static boolean xcx = false;
  private static boolean xcy = false;
  private static d xcz;
  private final String TAG = d.class.getSimpleName();
  private int xcA = 0;
  private Map<Long, Map<d.a, Queue<Integer>>> xcB = new HashMap();
  private Map<Long, Map<Integer, d.a>> xcC = new HashMap();
  private Map<Long, Set<Integer>> xcD = new HashMap();
  
  /* Error */
  private void A(int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: aload_0
    //   9: monitorexit
    //   10: return
    //   11: iload_2
    //   12: aload_1
    //   13: arraylength
    //   14: if_icmpge -6 -> 8
    //   17: iload_2
    //   18: iconst_0
    //   19: iadd
    //   20: ifgt -12 -> 8
    //   23: aload_0
    //   24: aload_1
    //   25: iconst_0
    //   26: iaload
    //   27: invokespecial 60	com/tencent/util/d:Ks	(I)V
    //   30: iload_2
    //   31: iconst_1
    //   32: iadd
    //   33: istore_2
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	d
    //   0	42	1	paramArrayOfInt	int[]
    //   1	33	2	i	int
    // Exception table:
    //   from	to	target	type
    //   11	17	37	finally
    //   23	30	37	finally
  }
  
  /* Error */
  private void Ks(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 66	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5: invokevirtual 70	java/lang/Thread:getId	()J
    //   8: lstore_2
    //   9: ldc 72
    //   11: iconst_3
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: lload_2
    //   18: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: iload_1
    //   25: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: invokestatic 86	com/tencent/util/d:cRk	()Ljava/lang/String;
    //   34: aastore
    //   35: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   38: pop
    //   39: iload_1
    //   40: ifne +23 -> 63
    //   43: ldc 94
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: lload_2
    //   52: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   55: aastore
    //   56: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   59: pop
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: getstatic 27	com/tencent/util/d:xcw	Z
    //   66: ifeq +196 -> 262
    //   69: aload_0
    //   70: getfield 50	com/tencent/util/d:xcB	Ljava/util/Map;
    //   73: lload_2
    //   74: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: invokeinterface 100 2 0
    //   82: ifne +24 -> 106
    //   85: aload_0
    //   86: getfield 50	com/tencent/util/d:xcB	Ljava/util/Map;
    //   89: lload_2
    //   90: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   93: new 47	java/util/HashMap
    //   96: dup
    //   97: invokespecial 48	java/util/HashMap:<init>	()V
    //   100: invokeinterface 104 3 0
    //   105: pop
    //   106: aload_0
    //   107: getfield 50	com/tencent/util/d:xcB	Ljava/util/Map;
    //   110: lload_2
    //   111: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: invokeinterface 108 2 0
    //   119: checkcast 96	java/util/Map
    //   122: astore 6
    //   124: aload_0
    //   125: iload_1
    //   126: invokespecial 112	com/tencent/util/d:Kt	(I)Lcom/tencent/util/d$a;
    //   129: astore 5
    //   131: aload 5
    //   133: astore 4
    //   135: aload 5
    //   137: ifnonnull +15 -> 152
    //   140: new 6	com/tencent/util/d$a
    //   143: dup
    //   144: aload_0
    //   145: iconst_m1
    //   146: iconst_m1
    //   147: invokespecial 115	com/tencent/util/d$a:<init>	(Lcom/tencent/util/d;II)V
    //   150: astore 4
    //   152: aload 6
    //   154: aload 4
    //   156: invokeinterface 100 2 0
    //   161: ifne +20 -> 181
    //   164: aload 6
    //   166: aload 4
    //   168: new 117	java/util/LinkedList
    //   171: dup
    //   172: invokespecial 118	java/util/LinkedList:<init>	()V
    //   175: invokeinterface 104 3 0
    //   180: pop
    //   181: aload 6
    //   183: aload 4
    //   185: invokeinterface 108 2 0
    //   190: checkcast 120	java/util/Queue
    //   193: iload_1
    //   194: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: invokeinterface 123 2 0
    //   202: pop
    //   203: ldc 125
    //   205: iconst_4
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: lload_2
    //   212: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   215: aastore
    //   216: dup
    //   217: iconst_1
    //   218: aload 4
    //   220: getfield 128	com/tencent/util/d$a:width	I
    //   223: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   226: aastore
    //   227: dup
    //   228: iconst_2
    //   229: aload 4
    //   231: getfield 131	com/tencent/util/d$a:height	I
    //   234: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: aastore
    //   238: dup
    //   239: iconst_3
    //   240: invokestatic 86	com/tencent/util/d:cRk	()Ljava/lang/String;
    //   243: aastore
    //   244: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   247: pop
    //   248: aload_0
    //   249: invokespecial 134	com/tencent/util/d:cRl	()V
    //   252: goto -192 -> 60
    //   255: astore 4
    //   257: aload_0
    //   258: monitorexit
    //   259: aload 4
    //   261: athrow
    //   262: ldc 136
    //   264: iconst_3
    //   265: anewarray 4	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: lload_2
    //   271: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   274: aastore
    //   275: dup
    //   276: iconst_1
    //   277: iload_1
    //   278: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   281: aastore
    //   282: dup
    //   283: iconst_2
    //   284: invokestatic 86	com/tencent/util/d:cRk	()Ljava/lang/String;
    //   287: aastore
    //   288: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   291: pop
    //   292: iconst_1
    //   293: iconst_1
    //   294: newarray int
    //   296: dup
    //   297: iconst_0
    //   298: iload_1
    //   299: iastore
    //   300: iconst_0
    //   301: invokestatic 142	android/opengl/GLES20:glDeleteTextures	(I[II)V
    //   304: aload_0
    //   305: getfield 54	com/tencent/util/d:xcD	Ljava/util/Map;
    //   308: lload_2
    //   309: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   312: invokeinterface 108 2 0
    //   317: checkcast 144	java/util/Set
    //   320: astore 4
    //   322: aload 4
    //   324: ifnull +15 -> 339
    //   327: aload 4
    //   329: iload_1
    //   330: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: invokeinterface 147 2 0
    //   338: pop
    //   339: aload_0
    //   340: aload_0
    //   341: getfield 45	com/tencent/util/d:xcA	I
    //   344: iconst_1
    //   345: isub
    //   346: putfield 45	com/tencent/util/d:xcA	I
    //   349: getstatic 27	com/tencent/util/d:xcw	Z
    //   352: ifeq -104 -> 248
    //   355: aload_0
    //   356: getfield 52	com/tencent/util/d:xcC	Ljava/util/Map;
    //   359: lload_2
    //   360: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   363: invokeinterface 108 2 0
    //   368: checkcast 96	java/util/Map
    //   371: astore 4
    //   373: aload 4
    //   375: ifnull -127 -> 248
    //   378: aload 4
    //   380: iload_1
    //   381: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: invokeinterface 149 2 0
    //   389: pop
    //   390: goto -142 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	d
    //   0	393	1	paramInt	int
    //   8	352	2	l	long
    //   133	97	4	locala1	d.a
    //   255	5	4	localObject1	Object
    //   320	59	4	localObject2	Object
    //   129	7	5	locala2	d.a
    //   122	60	6	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	39	255	finally
    //   43	60	255	finally
    //   63	106	255	finally
    //   106	131	255	finally
    //   140	152	255	finally
    //   152	181	255	finally
    //   181	248	255	finally
    //   248	252	255	finally
    //   262	322	255	finally
    //   327	339	255	finally
    //   339	373	255	finally
    //   378	390	255	finally
  }
  
  /* Error */
  private d.a Kt(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 27	com/tencent/util/d:xcw	Z
    //   5: ifeq +54 -> 59
    //   8: invokestatic 66	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11: invokevirtual 70	java/lang/Thread:getId	()J
    //   14: lstore_2
    //   15: aload_0
    //   16: getfield 52	com/tencent/util/d:xcC	Ljava/util/Map;
    //   19: lload_2
    //   20: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   23: invokeinterface 108 2 0
    //   28: checkcast 96	java/util/Map
    //   31: astore 4
    //   33: aload 4
    //   35: ifnull +24 -> 59
    //   38: aload 4
    //   40: iload_1
    //   41: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 108 2 0
    //   49: checkcast 6	com/tencent/util/d$a
    //   52: astore 4
    //   54: aload_0
    //   55: monitorexit
    //   56: aload 4
    //   58: areturn
    //   59: aconst_null
    //   60: astore 4
    //   62: goto -8 -> 54
    //   65: astore 4
    //   67: aload_0
    //   68: monitorexit
    //   69: aload 4
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	d
    //   0	72	1	paramInt	int
    //   14	6	2	l	long
    //   31	30	4	localObject1	Object
    //   65	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	65	finally
    //   38	54	65	finally
  }
  
  public static d cRj()
  {
    if (xcz == null) {}
    try
    {
      if (xcz == null) {
        xcz = new d();
      }
      return xcz;
    }
    finally {}
  }
  
  private static String cRk()
  {
    if (xcy)
    {
      Object localObject = Thread.currentThread().getStackTrace();
      if ((localObject == null) || (localObject.length == 0)) {
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
        return ((StackTraceElement)localObject).getClassName() + " - " + ((StackTraceElement)localObject).getMethodName() + "()";
      }
    }
    return "unknown";
  }
  
  private void cRl()
  {
    if (xcx) {
      String.format("texture reference count = %d", new Object[] { Integer.valueOf(this.xcA) });
    }
  }
  
  private int on(boolean paramBoolean)
  {
    try
    {
      int i = v(-1, -1, paramBoolean);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private int v(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 66	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5: invokevirtual 70	java/lang/Thread:getId	()J
    //   8: lstore 4
    //   10: new 181	java/lang/StringBuilder
    //   13: dup
    //   14: ldc 203
    //   16: invokespecial 206	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: iload_3
    //   20: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: ldc 211
    //   25: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: iconst_4
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: lload 4
    //   39: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: iload_1
    //   46: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: iload_2
    //   53: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: aastore
    //   57: dup
    //   58: iconst_3
    //   59: invokestatic 86	com/tencent/util/d:cRk	()Ljava/lang/String;
    //   62: aastore
    //   63: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   66: pop
    //   67: getstatic 27	com/tencent/util/d:xcw	Z
    //   70: ifeq +239 -> 309
    //   73: iload_3
    //   74: ifne +235 -> 309
    //   77: aload_0
    //   78: getfield 50	com/tencent/util/d:xcB	Ljava/util/Map;
    //   81: lload 4
    //   83: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   86: invokeinterface 108 2 0
    //   91: checkcast 96	java/util/Map
    //   94: astore 6
    //   96: aload 6
    //   98: ifnull +211 -> 309
    //   101: aload 6
    //   103: invokeinterface 215 1 0
    //   108: ifne +201 -> 309
    //   111: aload 6
    //   113: new 6	com/tencent/util/d$a
    //   116: dup
    //   117: aload_0
    //   118: iload_1
    //   119: iload_2
    //   120: invokespecial 115	com/tencent/util/d$a:<init>	(Lcom/tencent/util/d;II)V
    //   123: invokeinterface 108 2 0
    //   128: checkcast 120	java/util/Queue
    //   131: astore 7
    //   133: aload 7
    //   135: ifnull +67 -> 202
    //   138: aload 7
    //   140: invokeinterface 216 1 0
    //   145: ifne +57 -> 202
    //   148: ldc 218
    //   150: iconst_3
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: lload 4
    //   158: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: iload_1
    //   165: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: dup
    //   170: iconst_2
    //   171: iload_2
    //   172: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   179: pop
    //   180: aload_0
    //   181: invokespecial 134	com/tencent/util/d:cRl	()V
    //   184: aload 7
    //   186: invokeinterface 222 1 0
    //   191: checkcast 80	java/lang/Integer
    //   194: invokevirtual 226	java/lang/Integer:intValue	()I
    //   197: istore_1
    //   198: aload_0
    //   199: monitorexit
    //   200: iload_1
    //   201: ireturn
    //   202: aload 6
    //   204: invokeinterface 230 1 0
    //   209: invokeinterface 234 1 0
    //   214: astore 6
    //   216: aload 6
    //   218: invokeinterface 239 1 0
    //   223: ifeq +86 -> 309
    //   226: aload 6
    //   228: invokeinterface 242 1 0
    //   233: checkcast 244	java/util/Map$Entry
    //   236: invokeinterface 247 1 0
    //   241: checkcast 120	java/util/Queue
    //   244: astore 7
    //   246: aload 7
    //   248: invokeinterface 216 1 0
    //   253: ifne -37 -> 216
    //   256: ldc 249
    //   258: iconst_3
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: lload 4
    //   266: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: aastore
    //   270: dup
    //   271: iconst_1
    //   272: iload_1
    //   273: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: aastore
    //   277: dup
    //   278: iconst_2
    //   279: iload_2
    //   280: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   287: pop
    //   288: aload_0
    //   289: invokespecial 134	com/tencent/util/d:cRl	()V
    //   292: aload 7
    //   294: invokeinterface 222 1 0
    //   299: checkcast 80	java/lang/Integer
    //   302: invokevirtual 226	java/lang/Integer:intValue	()I
    //   305: istore_1
    //   306: goto -108 -> 198
    //   309: ldc 251
    //   311: iconst_3
    //   312: anewarray 4	java/lang/Object
    //   315: dup
    //   316: iconst_0
    //   317: lload 4
    //   319: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   322: aastore
    //   323: dup
    //   324: iconst_1
    //   325: iload_1
    //   326: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: aastore
    //   330: dup
    //   331: iconst_2
    //   332: iload_2
    //   333: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   336: aastore
    //   337: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   340: pop
    //   341: iconst_1
    //   342: newarray int
    //   344: astore 6
    //   346: iconst_1
    //   347: aload 6
    //   349: iconst_0
    //   350: invokestatic 254	android/opengl/GLES20:glGenTextures	(I[II)V
    //   353: aload_0
    //   354: getfield 54	com/tencent/util/d:xcD	Ljava/util/Map;
    //   357: lload 4
    //   359: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   362: invokeinterface 100 2 0
    //   367: ifne +25 -> 392
    //   370: aload_0
    //   371: getfield 54	com/tencent/util/d:xcD	Ljava/util/Map;
    //   374: lload 4
    //   376: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   379: new 256	java/util/HashSet
    //   382: dup
    //   383: invokespecial 257	java/util/HashSet:<init>	()V
    //   386: invokeinterface 104 3 0
    //   391: pop
    //   392: aload_0
    //   393: getfield 54	com/tencent/util/d:xcD	Ljava/util/Map;
    //   396: lload 4
    //   398: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   401: invokeinterface 108 2 0
    //   406: checkcast 144	java/util/Set
    //   409: aload 6
    //   411: iconst_0
    //   412: iaload
    //   413: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   416: invokeinterface 260 2 0
    //   421: pop
    //   422: aload_0
    //   423: aload_0
    //   424: getfield 45	com/tencent/util/d:xcA	I
    //   427: iconst_1
    //   428: iadd
    //   429: putfield 45	com/tencent/util/d:xcA	I
    //   432: aload_0
    //   433: invokespecial 134	com/tencent/util/d:cRl	()V
    //   436: aload 6
    //   438: iconst_0
    //   439: iaload
    //   440: istore_1
    //   441: goto -243 -> 198
    //   444: astore 6
    //   446: aload_0
    //   447: monitorexit
    //   448: aload 6
    //   450: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	this	d
    //   0	451	1	paramInt1	int
    //   0	451	2	paramInt2	int
    //   0	451	3	paramBoolean	boolean
    //   8	389	4	l	long
    //   94	343	6	localObject1	Object
    //   444	5	6	localObject2	Object
    //   131	162	7	localQueue	Queue
    // Exception table:
    //   from	to	target	type
    //   2	73	444	finally
    //   77	96	444	finally
    //   101	133	444	finally
    //   138	198	444	finally
    //   202	216	444	finally
    //   216	306	444	finally
    //   309	392	444	finally
    //   392	436	444	finally
  }
  
  public final void Kr(int paramInt)
  {
    try
    {
      Ks(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean av(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 27	com/tencent/util/d:xcw	Z
    //   5: ifeq +98 -> 103
    //   8: invokestatic 66	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11: invokevirtual 70	java/lang/Thread:getId	()J
    //   14: lstore 4
    //   16: aload_0
    //   17: getfield 52	com/tencent/util/d:xcC	Ljava/util/Map;
    //   20: lload 4
    //   22: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   25: invokeinterface 100 2 0
    //   30: ifeq +73 -> 103
    //   33: aload_0
    //   34: getfield 52	com/tencent/util/d:xcC	Ljava/util/Map;
    //   37: lload 4
    //   39: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: invokeinterface 108 2 0
    //   47: checkcast 96	java/util/Map
    //   50: iload_1
    //   51: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: invokeinterface 108 2 0
    //   59: checkcast 6	com/tencent/util/d$a
    //   62: astore 7
    //   64: aload 7
    //   66: ifnull +31 -> 97
    //   69: aload 7
    //   71: getfield 128	com/tencent/util/d$a:width	I
    //   74: iload_2
    //   75: if_icmpne +22 -> 97
    //   78: aload 7
    //   80: getfield 131	com/tencent/util/d$a:height	I
    //   83: istore_1
    //   84: iload_1
    //   85: iload_3
    //   86: if_icmpne +11 -> 97
    //   89: iconst_1
    //   90: istore 6
    //   92: aload_0
    //   93: monitorexit
    //   94: iload 6
    //   96: ireturn
    //   97: iconst_0
    //   98: istore 6
    //   100: goto -8 -> 92
    //   103: iconst_0
    //   104: istore 6
    //   106: goto -14 -> 92
    //   109: astore 7
    //   111: aload_0
    //   112: monitorexit
    //   113: aload 7
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	d
    //   0	116	1	paramInt1	int
    //   0	116	2	paramInt2	int
    //   0	116	3	paramInt3	int
    //   14	24	4	l	long
    //   90	15	6	bool	boolean
    //   62	17	7	locala	d.a
    //   109	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	64	109	finally
    //   69	84	109	finally
  }
  
  public final void aw(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (xcw)
      {
        long l = Thread.currentThread().getId();
        String.format("updateTextureSize(), GLThread id = %d, textureId = %d, width = %d, height = %d, called from: %s", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), cRk() });
        if (!this.xcC.containsKey(Long.valueOf(l))) {
          this.xcC.put(Long.valueOf(l), new HashMap());
        }
        ((Map)this.xcC.get(Long.valueOf(l))).put(Integer.valueOf(paramInt1), new d.a(this, paramInt2, paramInt3));
      }
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
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: aload_0
    //   9: monitorexit
    //   10: return
    //   11: iload_3
    //   12: aload_1
    //   13: arraylength
    //   14: if_icmpge -6 -> 8
    //   17: iload_3
    //   18: iconst_0
    //   19: iadd
    //   20: ifgt -12 -> 8
    //   23: aload_1
    //   24: iconst_0
    //   25: aload_0
    //   26: iload_2
    //   27: invokespecial 271	com/tencent/util/d:on	(Z)I
    //   30: iastore
    //   31: iload_3
    //   32: iconst_1
    //   33: iadd
    //   34: istore_3
    //   35: goto -24 -> 11
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	d
    //   0	43	1	paramArrayOfInt	int[]
    //   0	43	2	paramBoolean	boolean
    //   1	34	3	i	int
    // Exception table:
    //   from	to	target	type
    //   11	17	38	finally
    //   23	31	38	finally
  }
  
  public final int gp(int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = v(paramInt1, paramInt2, false);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void y(int[] paramArrayOfInt)
  {
    try
    {
      c(paramArrayOfInt, false);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  public final void z(int[] paramArrayOfInt)
  {
    try
    {
      A(paramArrayOfInt);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.util.d
 * JD-Core Version:    0.7.0.1
 */