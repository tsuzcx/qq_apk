package com.tencent.mm.plugin.normsg.b;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.c;
import java.util.List;
import java.util.Map;

public final class a
  implements b.g
{
  public static final a.a<String> mGN;
  private long mGO = 0L;
  private long mGP = 0L;
  private long mGQ = 0L;
  private long mGR = 0L;
  private long mGS = 0L;
  private int mGT = 0;
  private boolean mGU = false;
  private long mGV = 0L;
  
  static
  {
    a.a locala = new a.a((byte)0);
    mGN = locala;
    locala.add("");
    mGN.add(":tools");
    mGN.add(":toolsmp");
    mGN.add(":appbrand0");
    mGN.add(":appbrand1");
    mGN.add(":appbrand2");
    mGN.add(":appbrand3");
    mGN.add(":appbrand4");
  }
  
  private a()
  {
    boS();
  }
  
  public static String Kf(String paramString)
  {
    int i = paramString.indexOf(':');
    if (i != -1) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public static a boQ()
  {
    return a.b.mGW;
  }
  
  /* Error */
  private void boS()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 99	java/io/File
    //   5: dup
    //   6: invokestatic 105	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   9: invokevirtual 111	android/content/Context:getCacheDir	()Ljava/io/File;
    //   12: ldc 113
    //   14: invokestatic 118	com/tencent/mm/plugin/normsg/b/d:Kd	(Ljava/lang/String;)Ljava/lang/String;
    //   17: invokespecial 121	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_3
    //   21: new 123	java/io/DataInputStream
    //   24: dup
    //   25: new 125	java/io/BufferedInputStream
    //   28: dup
    //   29: new 127	java/io/FileInputStream
    //   32: dup
    //   33: aload_3
    //   34: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: invokespecial 133	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: invokespecial 134	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore 4
    //   45: aload 4
    //   47: astore_3
    //   48: aload 4
    //   50: invokevirtual 138	java/io/DataInputStream:readInt	()I
    //   53: i2l
    //   54: ldc2_w 139
    //   57: lcmp
    //   58: ifeq +91 -> 149
    //   61: aload 4
    //   63: astore_3
    //   64: new 142	java/lang/IllegalStateException
    //   67: dup
    //   68: ldc 144
    //   70: invokespecial 147	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   73: athrow
    //   74: astore 5
    //   76: aload 4
    //   78: astore_3
    //   79: ldc 149
    //   81: aload 5
    //   83: ldc 151
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 157	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: aload 4
    //   94: astore_3
    //   95: aload_0
    //   96: lconst_0
    //   97: putfield 59	com/tencent/mm/plugin/normsg/b/a:mGO	J
    //   100: aload 4
    //   102: astore_3
    //   103: aload_0
    //   104: lconst_0
    //   105: putfield 61	com/tencent/mm/plugin/normsg/b/a:mGP	J
    //   108: aload 4
    //   110: astore_3
    //   111: aload_0
    //   112: lconst_0
    //   113: putfield 63	com/tencent/mm/plugin/normsg/b/a:mGQ	J
    //   116: aload 4
    //   118: astore_3
    //   119: aload_0
    //   120: invokestatic 163	java/lang/System:currentTimeMillis	()J
    //   123: putfield 65	com/tencent/mm/plugin/normsg/b/a:mGR	J
    //   126: aload 4
    //   128: astore_3
    //   129: aload_0
    //   130: lconst_0
    //   131: putfield 67	com/tencent/mm/plugin/normsg/b/a:mGS	J
    //   134: aload 4
    //   136: astore_3
    //   137: aload_0
    //   138: invokespecial 166	com/tencent/mm/plugin/normsg/b/a:boT	()V
    //   141: aload 4
    //   143: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   146: aload_0
    //   147: monitorexit
    //   148: return
    //   149: aload 4
    //   151: astore_3
    //   152: aload_0
    //   153: aload 4
    //   155: invokevirtual 175	java/io/DataInputStream:readLong	()J
    //   158: putfield 59	com/tencent/mm/plugin/normsg/b/a:mGO	J
    //   161: aload 4
    //   163: astore_3
    //   164: aload_0
    //   165: aload 4
    //   167: invokevirtual 175	java/io/DataInputStream:readLong	()J
    //   170: putfield 61	com/tencent/mm/plugin/normsg/b/a:mGP	J
    //   173: aload 4
    //   175: astore_3
    //   176: aload_0
    //   177: aload 4
    //   179: invokevirtual 175	java/io/DataInputStream:readLong	()J
    //   182: putfield 63	com/tencent/mm/plugin/normsg/b/a:mGQ	J
    //   185: aload 4
    //   187: astore_3
    //   188: aload_0
    //   189: aload 4
    //   191: invokevirtual 175	java/io/DataInputStream:readLong	()J
    //   194: putfield 65	com/tencent/mm/plugin/normsg/b/a:mGR	J
    //   197: aload 4
    //   199: astore_3
    //   200: aload 4
    //   202: invokevirtual 175	java/io/DataInputStream:readLong	()J
    //   205: lstore_1
    //   206: lload_1
    //   207: lconst_0
    //   208: lcmp
    //   209: ifle +23 -> 232
    //   212: aload 4
    //   214: astore_3
    //   215: aload_0
    //   216: getfield 67	com/tencent/mm/plugin/normsg/b/a:mGS	J
    //   219: lconst_0
    //   220: lcmp
    //   221: ifgt +11 -> 232
    //   224: aload 4
    //   226: astore_3
    //   227: aload_0
    //   228: lload_1
    //   229: putfield 67	com/tencent/mm/plugin/normsg/b/a:mGS	J
    //   232: aload 4
    //   234: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   237: goto -91 -> 146
    //   240: astore_3
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_3
    //   244: athrow
    //   245: astore 4
    //   247: aconst_null
    //   248: astore_3
    //   249: aload_3
    //   250: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   253: aload 4
    //   255: athrow
    //   256: astore 4
    //   258: goto -9 -> 249
    //   261: astore 5
    //   263: aconst_null
    //   264: astore 4
    //   266: goto -190 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	a
    //   205	24	1	l	long
    //   20	207	3	localObject1	Object
    //   240	4	3	localObject2	Object
    //   248	2	3	localCloseable	java.io.Closeable
    //   43	190	4	localDataInputStream	java.io.DataInputStream
    //   245	9	4	localObject3	Object
    //   256	1	4	localObject4	Object
    //   264	1	4	localObject5	Object
    //   74	8	5	localThrowable1	Throwable
    //   261	1	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   48	61	74	java/lang/Throwable
    //   64	74	74	java/lang/Throwable
    //   152	161	74	java/lang/Throwable
    //   164	173	74	java/lang/Throwable
    //   176	185	74	java/lang/Throwable
    //   188	197	74	java/lang/Throwable
    //   200	206	74	java/lang/Throwable
    //   215	224	74	java/lang/Throwable
    //   227	232	74	java/lang/Throwable
    //   2	21	240	finally
    //   141	146	240	finally
    //   232	237	240	finally
    //   249	256	240	finally
    //   21	45	245	finally
    //   48	61	256	finally
    //   64	74	256	finally
    //   79	92	256	finally
    //   95	100	256	finally
    //   103	108	256	finally
    //   111	116	256	finally
    //   119	126	256	finally
    //   129	134	256	finally
    //   137	141	256	finally
    //   152	161	256	finally
    //   164	173	256	finally
    //   176	185	256	finally
    //   188	197	256	finally
    //   200	206	256	finally
    //   215	224	256	finally
    //   227	232	256	finally
    //   21	45	261	java/lang/Throwable
  }
  
  /* Error */
  private void boT()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 99	java/io/File
    //   5: dup
    //   6: invokestatic 105	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   9: invokevirtual 111	android/content/Context:getCacheDir	()Ljava/io/File;
    //   12: ldc 113
    //   14: invokestatic 118	com/tencent/mm/plugin/normsg/b/d:Kd	(Ljava/lang/String;)Ljava/lang/String;
    //   17: invokespecial 121	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_1
    //   21: new 177	java/io/DataOutputStream
    //   24: dup
    //   25: new 179	java/io/BufferedOutputStream
    //   28: dup
    //   29: new 181	java/io/FileOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: invokespecial 185	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   40: invokespecial 186	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   43: astore_2
    //   44: aload_2
    //   45: astore_1
    //   46: aload_2
    //   47: ldc 187
    //   49: invokevirtual 191	java/io/DataOutputStream:writeInt	(I)V
    //   52: aload_2
    //   53: astore_1
    //   54: aload_2
    //   55: aload_0
    //   56: getfield 59	com/tencent/mm/plugin/normsg/b/a:mGO	J
    //   59: invokevirtual 195	java/io/DataOutputStream:writeLong	(J)V
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: aload_0
    //   66: getfield 61	com/tencent/mm/plugin/normsg/b/a:mGP	J
    //   69: invokevirtual 195	java/io/DataOutputStream:writeLong	(J)V
    //   72: aload_2
    //   73: astore_1
    //   74: aload_2
    //   75: aload_0
    //   76: getfield 63	com/tencent/mm/plugin/normsg/b/a:mGQ	J
    //   79: invokevirtual 195	java/io/DataOutputStream:writeLong	(J)V
    //   82: aload_2
    //   83: astore_1
    //   84: aload_2
    //   85: aload_0
    //   86: getfield 65	com/tencent/mm/plugin/normsg/b/a:mGR	J
    //   89: invokevirtual 195	java/io/DataOutputStream:writeLong	(J)V
    //   92: aload_2
    //   93: astore_1
    //   94: aload_2
    //   95: aload_0
    //   96: getfield 67	com/tencent/mm/plugin/normsg/b/a:mGS	J
    //   99: invokevirtual 195	java/io/DataOutputStream:writeLong	(J)V
    //   102: aload_2
    //   103: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   106: aload_0
    //   107: monitorexit
    //   108: return
    //   109: astore_3
    //   110: aconst_null
    //   111: astore_2
    //   112: aload_2
    //   113: astore_1
    //   114: ldc 149
    //   116: aload_3
    //   117: ldc 197
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 157	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload_2
    //   127: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   130: goto -24 -> 106
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    //   138: astore_2
    //   139: aconst_null
    //   140: astore_1
    //   141: aload_1
    //   142: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   145: aload_2
    //   146: athrow
    //   147: astore_2
    //   148: goto -7 -> 141
    //   151: astore_3
    //   152: goto -40 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	a
    //   20	94	1	localObject1	Object
    //   133	4	1	localObject2	Object
    //   140	2	1	localCloseable	java.io.Closeable
    //   43	84	2	localDataOutputStream	java.io.DataOutputStream
    //   138	8	2	localObject3	Object
    //   147	1	2	localObject4	Object
    //   109	8	3	localThrowable1	Throwable
    //   151	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   21	44	109	java/lang/Throwable
    //   2	21	133	finally
    //   102	106	133	finally
    //   126	130	133	finally
    //   141	147	133	finally
    //   21	44	138	finally
    //   46	52	147	finally
    //   54	62	147	finally
    //   64	72	147	finally
    //   74	82	147	finally
    //   84	92	147	finally
    //   94	102	147	finally
    //   114	126	147	finally
    //   46	52	151	java/lang/Throwable
    //   54	62	151	java/lang/Throwable
    //   64	72	151	java/lang/Throwable
    //   74	82	151	java/lang/Throwable
    //   84	92	151	java/lang/Throwable
    //   94	102	151	java/lang/Throwable
  }
  
  /* Error */
  private void boU()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/tencent/mm/plugin/normsg/b/a:mGU	Z
    //   6: ifne +22 -> 28
    //   9: invokestatic 163	java/lang/System:currentTimeMillis	()J
    //   12: lstore_1
    //   13: aload_0
    //   14: getfield 73	com/tencent/mm/plugin/normsg/b/a:mGV	J
    //   17: lstore_3
    //   18: lload_1
    //   19: lload_3
    //   20: lsub
    //   21: ldc2_w 199
    //   24: lcmp
    //   25: ifge +6 -> 31
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: lload_1
    //   33: putfield 73	com/tencent/mm/plugin/normsg/b/a:mGV	J
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 71	com/tencent/mm/plugin/normsg/b/a:mGU	Z
    //   41: getstatic 206	com/tencent/mm/plugin/secinforeport/a/d:nQr	Lcom/tencent/mm/plugin/secinforeport/a/d;
    //   44: ldc 207
    //   46: invokevirtual 210	com/tencent/mm/plugin/secinforeport/a/d:wZ	(I)V
    //   49: goto -21 -> 28
    //   52: astore 5
    //   54: aload_0
    //   55: monitorexit
    //   56: aload 5
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	a
    //   12	21	1	l1	long
    //   17	3	3	l2	long
    //   52	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	52	finally
    //   31	49	52	finally
  }
  
  private void cd(String paramString, int paramInt)
  {
    try
    {
      long l = System.currentTimeMillis();
      if (l - this.mGO > 86400000L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.d("Normsg_AED", "findview, pkg: " + paramString + ", res_count: " + paramInt, null);
        this.mGO = l;
        boT();
      }
      if ((com.tencent.mm.compatible.util.h.zK()) && (a.c.boX())) {
        boU();
      }
      return;
    }
    finally {}
  }
  
  private void d(int paramInt, View paramView)
  {
    if (paramView == null) {}
    label71:
    for (;;)
    {
      return;
      if (paramInt == 16)
      {
        try
        {
          try
          {
            if (this.mGT == 0) {
              continue;
            }
          }
          finally {}
          if (!(paramView instanceof Button)) {
            break label71;
          }
        }
        finally {}
        if (paramView.getId() == this.mGT)
        {
          this.mGS += 1L;
          boT();
        }
      }
    }
  }
  
  private static String ej(String paramString1, String paramString2)
  {
    label65:
    do
    {
      Object localObject;
      try
      {
        g.DN().CX();
        localObject = ((c)localObject).ctr();
      }
      catch (b paramString1)
      {
        try
        {
          localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.b.dHs;
          localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.fJ("100373");
          if ((localObject != null) && (((c)localObject).isValid())) {
            break label65;
          }
          y.w("MircoMsg.AEDHLP", "check point 1, explained by src code.");
          return paramString2;
        }
        catch (b paramString1)
        {
          y.printErrStackTrace("MircoMsg.AEDHLP", paramString1, "check point 1-1, explained by src code.", new Object[0]);
          return paramString2;
        }
        paramString1 = paramString1;
        y.w("MircoMsg.AEDHLP", "check point 0, explained by src code.");
        return paramString2;
      }
      if (localObject == null)
      {
        y.w("MircoMsg.AEDHLP", "check point 2, explained by src code.");
        return paramString2;
      }
      paramString1 = (String)((Map)localObject).get(paramString1);
    } while ((paramString1 == null) || (paramString1.length() <= 0));
    return paramString1;
  }
  
  private void p(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      long l = System.currentTimeMillis();
      if (l - this.mGP > 86400000L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.d("Normsg_AED", "action: " + paramInt + ", pkg: " + paramString1 + ", view: " + paramString2, null);
        this.mGP = l;
        boT();
      }
      if ((com.tencent.mm.compatible.util.h.zK()) && (a.c.boX())) {
        boU();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private static String vt(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 105	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   3: ldc_w 336
    //   6: invokevirtual 340	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   9: checkcast 342	android/app/ActivityManager
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +6 -> 20
    //   17: ldc 36
    //   19: areturn
    //   20: aload_1
    //   21: invokevirtual 346	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +58 -> 84
    //   29: aload_2
    //   30: invokeinterface 352 1 0
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface 357 1 0
    //   42: ifeq +42 -> 84
    //   45: aload_2
    //   46: invokeinterface 361 1 0
    //   51: checkcast 363	android/app/ActivityManager$RunningAppProcessInfo
    //   54: astore_3
    //   55: aload_3
    //   56: getfield 366	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   59: iload_0
    //   60: if_icmpne -24 -> 36
    //   63: aload_3
    //   64: getfield 370	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   67: astore_2
    //   68: aload_2
    //   69: areturn
    //   70: astore_2
    //   71: ldc 149
    //   73: aload_2
    //   74: ldc_w 372
    //   77: iconst_0
    //   78: anewarray 4	java/lang/Object
    //   81: invokestatic 157	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_1
    //   85: sipush 16384
    //   88: invokevirtual 376	android/app/ActivityManager:getRunningServices	(I)Ljava/util/List;
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull +58 -> 151
    //   96: aload_1
    //   97: invokeinterface 352 1 0
    //   102: astore_1
    //   103: aload_1
    //   104: invokeinterface 357 1 0
    //   109: ifeq +42 -> 151
    //   112: aload_1
    //   113: invokeinterface 361 1 0
    //   118: checkcast 378	android/app/ActivityManager$RunningServiceInfo
    //   121: astore_2
    //   122: aload_2
    //   123: getfield 379	android/app/ActivityManager$RunningServiceInfo:pid	I
    //   126: iload_0
    //   127: if_icmpne -24 -> 103
    //   130: aload_2
    //   131: getfield 382	android/app/ActivityManager$RunningServiceInfo:process	Ljava/lang/String;
    //   134: astore_1
    //   135: aload_1
    //   136: areturn
    //   137: astore_1
    //   138: ldc 149
    //   140: aload_1
    //   141: ldc_w 384
    //   144: iconst_0
    //   145: anewarray 4	java/lang/Object
    //   148: invokestatic 157	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aconst_null
    //   152: astore_1
    //   153: new 386	java/io/BufferedReader
    //   156: dup
    //   157: new 388	java/io/FileReader
    //   160: dup
    //   161: getstatic 394	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   164: ldc_w 396
    //   167: invokestatic 118	com/tencent/mm/plugin/normsg/b/d:Kd	(Ljava/lang/String;)Ljava/lang/String;
    //   170: iconst_1
    //   171: anewarray 4	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: iload_0
    //   177: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: aastore
    //   181: invokestatic 406	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   184: invokespecial 407	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   187: invokespecial 410	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   190: astore_2
    //   191: aload_2
    //   192: astore_1
    //   193: aload_2
    //   194: invokevirtual 413	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   197: astore_3
    //   198: aload_3
    //   199: ifnull +16 -> 215
    //   202: aload_2
    //   203: astore_1
    //   204: aload_3
    //   205: invokevirtual 416	java/lang/String:trim	()Ljava/lang/String;
    //   208: astore_3
    //   209: aload_2
    //   210: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   213: aload_3
    //   214: areturn
    //   215: aload_2
    //   216: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   219: ldc 36
    //   221: areturn
    //   222: astore_3
    //   223: aconst_null
    //   224: astore_2
    //   225: aload_2
    //   226: astore_1
    //   227: ldc 149
    //   229: aload_3
    //   230: ldc_w 418
    //   233: iconst_0
    //   234: anewarray 4	java/lang/Object
    //   237: invokestatic 157	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: aload_2
    //   241: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   244: goto -25 -> 219
    //   247: astore_3
    //   248: aload_1
    //   249: astore_2
    //   250: aload_3
    //   251: astore_1
    //   252: aload_2
    //   253: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   256: aload_1
    //   257: athrow
    //   258: astore_3
    //   259: aload_1
    //   260: astore_2
    //   261: aload_3
    //   262: astore_1
    //   263: goto -11 -> 252
    //   266: astore_3
    //   267: goto -42 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramInt	int
    //   12	124	1	localObject1	Object
    //   137	4	1	localThrowable1	Throwable
    //   152	111	1	localObject2	Object
    //   24	45	2	localObject3	Object
    //   70	4	2	localThrowable2	Throwable
    //   121	140	2	localObject4	Object
    //   54	160	3	localObject5	Object
    //   222	8	3	localThrowable3	Throwable
    //   247	4	3	localObject6	Object
    //   258	4	3	localObject7	Object
    //   266	1	3	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   20	25	70	java/lang/Throwable
    //   29	36	70	java/lang/Throwable
    //   36	68	70	java/lang/Throwable
    //   84	92	137	java/lang/Throwable
    //   96	103	137	java/lang/Throwable
    //   103	135	137	java/lang/Throwable
    //   153	191	222	java/lang/Throwable
    //   153	191	247	finally
    //   193	198	258	finally
    //   204	209	258	finally
    //   227	240	258	finally
    //   193	198	266	java/lang/Throwable
    //   204	209	266	java/lang/Throwable
  }
  
  public final void a(int paramInt, View paramView, List<AccessibilityNodeInfo> paramList)
  {
    int i = 0;
    String str;
    if (paramView != null)
    {
      paramView = paramView.toString();
      str = vt(paramInt);
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label133;
      }
    }
    label133:
    for (boolean bool = true;; bool = false)
    {
      y.i("MircoMsg.AEDHLP", "[tomys] ae about searching, pid:%d, pname:%s, vwinfo:%s, is_found:%b", new Object[] { Integer.valueOf(paramInt), str, paramView, Boolean.valueOf(bool) });
      paramInt = i;
      if (paramList != null) {
        paramInt = paramList.size();
      }
      cd(str, paramInt);
      if ((a.c.boV()) && (str != null) && (str.contains(d.Kd(">\020r\033c\001xV"))) && (paramList != null)) {
        paramList.clear();
      }
      return;
      paramView = "";
      break;
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, View paramView)
  {
    if (paramView != null) {}
    for (String str1 = paramView.toString();; str1 = "")
    {
      String str2 = vt(paramInt2);
      y.i("MircoMsg.AEDHLP", "[tomys] ae about action, pid:%d, pname:%s, vwinfo:%s, action:%d", new Object[] { Integer.valueOf(paramInt2), str2, str1, Integer.valueOf(paramInt1) });
      d(paramInt1, paramView);
      p(paramInt1, str2, str1);
      if ((!a.c.boV()) || (str2 == null) || (!str2.contains(d.Kd(">\020r\033c\001xV")))) {
        break;
      }
      return false;
    }
    return true;
  }
  
  public final long boR()
  {
    try
    {
      long l = this.mGS;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void g(Throwable paramThrowable)
  {
    y.printErrStackTrace("MircoMsg.AEDHLP", paramThrowable, "[tomys] unexpected error happens.", new Object[0]);
    h(paramThrowable);
  }
  
  /* Error */
  public final void h(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: invokestatic 163	java/lang/System:currentTimeMillis	()J
    //   12: lstore_2
    //   13: lload_2
    //   14: aload_0
    //   15: getfield 63	com/tencent/mm/plugin/normsg/b/a:mGQ	J
    //   18: lsub
    //   19: ldc2_w 213
    //   22: lcmp
    //   23: ifle -17 -> 6
    //   26: new 470	java/io/StringWriter
    //   29: dup
    //   30: invokespecial 471	java/io/StringWriter:<init>	()V
    //   33: astore 5
    //   35: new 473	java/io/PrintWriter
    //   38: dup
    //   39: aload 5
    //   41: invokespecial 476	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   44: astore 4
    //   46: aload_1
    //   47: aload 4
    //   49: invokevirtual 480	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   52: aload 4
    //   54: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   57: getstatic 220	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   60: ldc_w 482
    //   63: new 224	java/lang/StringBuilder
    //   66: dup
    //   67: ldc_w 484
    //   70: invokespecial 227	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload 5
    //   75: invokevirtual 485	java/io/StringWriter:toString	()Ljava/lang/String;
    //   78: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: aconst_null
    //   85: invokevirtual 244	com/tencent/mm/plugin/report/service/h:d	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   88: aload_0
    //   89: lload_2
    //   90: putfield 63	com/tencent/mm/plugin/normsg/b/a:mGQ	J
    //   93: aload_0
    //   94: invokespecial 166	com/tencent/mm/plugin/normsg/b/a:boT	()V
    //   97: goto -91 -> 6
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: aconst_null
    //   107: astore 4
    //   109: aload 4
    //   111: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   114: goto -57 -> 57
    //   117: aload 4
    //   119: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: goto -8 -> 117
    //   128: astore_1
    //   129: goto -20 -> 109
    //   132: astore_1
    //   133: aconst_null
    //   134: astore 4
    //   136: goto -19 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	a
    //   0	139	1	paramThrowable	Throwable
    //   12	78	2	l	long
    //   44	91	4	localPrintWriter	java.io.PrintWriter
    //   33	41	5	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   9	35	100	finally
    //   52	57	100	finally
    //   57	97	100	finally
    //   109	114	100	finally
    //   117	124	100	finally
    //   35	46	105	java/lang/Throwable
    //   46	52	124	finally
    //   46	52	128	java/lang/Throwable
    //   35	46	132	finally
  }
  
  public final void vs(int paramInt)
  {
    try
    {
      this.mGT = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.a
 * JD-Core Version:    0.7.0.1
 */