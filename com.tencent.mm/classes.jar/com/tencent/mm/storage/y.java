package com.tencent.mm.storage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class y
{
  private boolean dxK = false;
  private String filePath = "";
  public boolean unp = false;
  public boolean unq = false;
  private Map<Integer, Object> values;
  
  public y(String paramString)
  {
    if (!new File(paramString).exists()) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ConfigFileStorage", "ConfigFileStorage not exit path[%s]", new Object[] { paramString });
    }
    this.filePath = paramString;
    ctV();
    this.dxK = false;
  }
  
  /* Error */
  private void ctV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 30	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 24	com/tencent/mm/storage/y:filePath	Ljava/lang/String;
    //   10: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 36	java/io/File:exists	()Z
    //   18: ifne +33 -> 51
    //   21: aload_2
    //   22: invokevirtual 55	java/io/File:createNewFile	()Z
    //   25: istore_1
    //   26: ldc 38
    //   28: ldc 57
    //   30: iconst_2
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_0
    //   37: getfield 24	com/tencent/mm/storage/y:filePath	Ljava/lang/String;
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: iload_1
    //   44: invokestatic 63	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   47: aastore
    //   48: invokestatic 66	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: aload_2
    //   52: invokevirtual 70	java/io/File:length	()J
    //   55: lconst_0
    //   56: lcmp
    //   57: ifne +35 -> 92
    //   60: aload_0
    //   61: new 72	java/util/HashMap
    //   64: dup
    //   65: invokespecial 73	java/util/HashMap:<init>	()V
    //   68: putfield 75	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   71: ldc 38
    //   73: ldc 77
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_0
    //   82: getfield 24	com/tencent/mm/storage/y:filePath	Ljava/lang/String;
    //   85: aastore
    //   86: invokestatic 66	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: new 79	java/io/FileInputStream
    //   95: dup
    //   96: aload_2
    //   97: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   100: astore_3
    //   101: new 84	java/io/ObjectInputStream
    //   104: dup
    //   105: aload_3
    //   106: invokespecial 87	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   109: astore_2
    //   110: aload_2
    //   111: astore 5
    //   113: aload_3
    //   114: astore 4
    //   116: aload_0
    //   117: aload_2
    //   118: invokevirtual 91	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   121: checkcast 93	java/util/Map
    //   124: putfield 75	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   127: aload_2
    //   128: astore 5
    //   130: aload_3
    //   131: astore 4
    //   133: ldc 38
    //   135: ldc 95
    //   137: iconst_1
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_0
    //   144: getfield 75	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   147: invokeinterface 99 1 0
    //   152: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: aastore
    //   156: invokestatic 107	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: aload_2
    //   160: astore 5
    //   162: aload_3
    //   163: astore 4
    //   165: aload_0
    //   166: iconst_0
    //   167: putfield 26	com/tencent/mm/storage/y:unp	Z
    //   170: aload_2
    //   171: invokevirtual 110	java/io/ObjectInputStream:close	()V
    //   174: aload_3
    //   175: invokevirtual 111	java/io/FileInputStream:close	()V
    //   178: goto -89 -> 89
    //   181: astore_2
    //   182: goto -93 -> 89
    //   185: astore 6
    //   187: aconst_null
    //   188: astore_2
    //   189: aconst_null
    //   190: astore_3
    //   191: aload_2
    //   192: astore 5
    //   194: aload_3
    //   195: astore 4
    //   197: aload_0
    //   198: new 72	java/util/HashMap
    //   201: dup
    //   202: invokespecial 73	java/util/HashMap:<init>	()V
    //   205: putfield 75	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   208: aload_2
    //   209: astore 5
    //   211: aload_3
    //   212: astore 4
    //   214: ldc 38
    //   216: aload 6
    //   218: ldc 113
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 117	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: aload_2
    //   228: astore 5
    //   230: aload_3
    //   231: astore 4
    //   233: aload_0
    //   234: iconst_1
    //   235: putfield 26	com/tencent/mm/storage/y:unp	Z
    //   238: aload_2
    //   239: ifnull +7 -> 246
    //   242: aload_2
    //   243: invokevirtual 110	java/io/ObjectInputStream:close	()V
    //   246: aload_3
    //   247: ifnull -158 -> 89
    //   250: aload_3
    //   251: invokevirtual 111	java/io/FileInputStream:close	()V
    //   254: goto -165 -> 89
    //   257: astore_2
    //   258: goto -169 -> 89
    //   261: astore_2
    //   262: aconst_null
    //   263: astore 5
    //   265: aconst_null
    //   266: astore_3
    //   267: aload 5
    //   269: ifnull +8 -> 277
    //   272: aload 5
    //   274: invokevirtual 110	java/io/ObjectInputStream:close	()V
    //   277: aload_3
    //   278: ifnull +7 -> 285
    //   281: aload_3
    //   282: invokevirtual 111	java/io/FileInputStream:close	()V
    //   285: aload_2
    //   286: athrow
    //   287: astore_2
    //   288: aload_0
    //   289: monitorexit
    //   290: aload_2
    //   291: athrow
    //   292: astore_3
    //   293: goto -8 -> 285
    //   296: astore_2
    //   297: aconst_null
    //   298: astore 5
    //   300: goto -33 -> 267
    //   303: astore_2
    //   304: aload 4
    //   306: astore_3
    //   307: goto -40 -> 267
    //   310: astore 6
    //   312: aconst_null
    //   313: astore_2
    //   314: goto -123 -> 191
    //   317: astore 6
    //   319: goto -128 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	y
    //   25	19	1	bool	boolean
    //   13	158	2	localObject1	Object
    //   181	1	2	localException1	java.lang.Exception
    //   188	55	2	localObject2	Object
    //   257	1	2	localException2	java.lang.Exception
    //   261	25	2	localObject3	Object
    //   287	4	2	localObject4	Object
    //   296	1	2	localObject5	Object
    //   303	1	2	localObject6	Object
    //   313	1	2	localObject7	Object
    //   100	182	3	localFileInputStream1	java.io.FileInputStream
    //   292	1	3	localException3	java.lang.Exception
    //   306	1	3	localObject8	Object
    //   114	191	4	localFileInputStream2	java.io.FileInputStream
    //   111	188	5	localObject9	Object
    //   185	32	6	localException4	java.lang.Exception
    //   310	1	6	localException5	java.lang.Exception
    //   317	1	6	localException6	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   170	178	181	java/lang/Exception
    //   2	51	185	java/lang/Exception
    //   51	89	185	java/lang/Exception
    //   92	101	185	java/lang/Exception
    //   242	246	257	java/lang/Exception
    //   250	254	257	java/lang/Exception
    //   2	51	261	finally
    //   51	89	261	finally
    //   92	101	261	finally
    //   170	178	287	finally
    //   242	246	287	finally
    //   250	254	287	finally
    //   272	277	287	finally
    //   281	285	287	finally
    //   285	287	287	finally
    //   272	277	292	java/lang/Exception
    //   281	285	292	java/lang/Exception
    //   101	110	296	finally
    //   116	127	303	finally
    //   133	159	303	finally
    //   165	170	303	finally
    //   197	208	303	finally
    //   214	227	303	finally
    //   233	238	303	finally
    //   101	110	310	java/lang/Exception
    //   116	127	317	java/lang/Exception
    //   133	159	317	java/lang/Exception
    //   165	170	317	java/lang/Exception
  }
  
  /* Error */
  private void yQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 125	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   5: lstore_1
    //   6: new 127	java/io/FileOutputStream
    //   9: dup
    //   10: aload_0
    //   11: getfield 24	com/tencent/mm/storage/y:filePath	Ljava/lang/String;
    //   14: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: new 130	java/io/ObjectOutputStream
    //   22: dup
    //   23: aload 4
    //   25: invokespecial 133	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_3
    //   29: aload_3
    //   30: astore 6
    //   32: aload 4
    //   34: astore 5
    //   36: aload_3
    //   37: aload_0
    //   38: getfield 75	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   41: invokevirtual 137	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   44: aload_3
    //   45: astore 6
    //   47: aload 4
    //   49: astore 5
    //   51: aload 4
    //   53: invokevirtual 140	java/io/FileOutputStream:flush	()V
    //   56: aload_3
    //   57: astore 6
    //   59: aload 4
    //   61: astore 5
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 28	com/tencent/mm/storage/y:unq	Z
    //   68: aload_3
    //   69: astore 6
    //   71: aload 4
    //   73: astore 5
    //   75: ldc 38
    //   77: ldc 142
    //   79: iconst_2
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_0
    //   86: getfield 75	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   89: invokeinterface 146 1 0
    //   94: invokeinterface 152 1 0
    //   99: arraylength
    //   100: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: lload_1
    //   107: invokestatic 156	com/tencent/mm/sdk/platformtools/bk:co	(J)J
    //   110: invokestatic 161	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   113: aastore
    //   114: invokestatic 164	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload_3
    //   118: invokevirtual 165	java/io/ObjectOutputStream:close	()V
    //   121: aload 4
    //   123: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   126: aload_0
    //   127: monitorexit
    //   128: return
    //   129: astore 7
    //   131: aconst_null
    //   132: astore_3
    //   133: aconst_null
    //   134: astore 4
    //   136: aload_3
    //   137: astore 6
    //   139: aload 4
    //   141: astore 5
    //   143: ldc 38
    //   145: ldc 168
    //   147: iconst_1
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload 7
    //   155: invokestatic 172	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   158: aastore
    //   159: invokestatic 46	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: aload_3
    //   163: astore 6
    //   165: aload 4
    //   167: astore 5
    //   169: ldc 38
    //   171: aload 7
    //   173: ldc 174
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokestatic 117	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_3
    //   183: astore 6
    //   185: aload 4
    //   187: astore 5
    //   189: aload_0
    //   190: iconst_1
    //   191: putfield 28	com/tencent/mm/storage/y:unq	Z
    //   194: aload_3
    //   195: ifnull +7 -> 202
    //   198: aload_3
    //   199: invokevirtual 165	java/io/ObjectOutputStream:close	()V
    //   202: aload 4
    //   204: ifnull -78 -> 126
    //   207: aload 4
    //   209: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   212: goto -86 -> 126
    //   215: astore_3
    //   216: goto -90 -> 126
    //   219: astore_3
    //   220: aconst_null
    //   221: astore 6
    //   223: aconst_null
    //   224: astore 4
    //   226: aload 6
    //   228: ifnull +8 -> 236
    //   231: aload 6
    //   233: invokevirtual 165	java/io/ObjectOutputStream:close	()V
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   246: aload_3
    //   247: athrow
    //   248: astore_3
    //   249: aload_0
    //   250: monitorexit
    //   251: aload_3
    //   252: athrow
    //   253: astore 4
    //   255: goto -9 -> 246
    //   258: astore_3
    //   259: aconst_null
    //   260: astore 6
    //   262: goto -36 -> 226
    //   265: astore_3
    //   266: aload 5
    //   268: astore 4
    //   270: goto -44 -> 226
    //   273: astore 7
    //   275: aconst_null
    //   276: astore_3
    //   277: goto -141 -> 136
    //   280: astore 7
    //   282: goto -146 -> 136
    //   285: astore_3
    //   286: goto -160 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	y
    //   5	102	1	l	long
    //   28	171	3	localObjectOutputStream1	java.io.ObjectOutputStream
    //   215	1	3	localException1	java.lang.Exception
    //   219	28	3	localObject1	Object
    //   248	4	3	localObject2	Object
    //   258	1	3	localObject3	Object
    //   265	1	3	localObject4	Object
    //   276	1	3	localObject5	Object
    //   285	1	3	localException2	java.lang.Exception
    //   17	225	4	localFileOutputStream1	java.io.FileOutputStream
    //   253	1	4	localException3	java.lang.Exception
    //   268	1	4	localObject6	Object
    //   34	233	5	localFileOutputStream2	java.io.FileOutputStream
    //   30	231	6	localObjectOutputStream2	java.io.ObjectOutputStream
    //   129	43	7	localIOException1	java.io.IOException
    //   273	1	7	localIOException2	java.io.IOException
    //   280	1	7	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	19	129	java/io/IOException
    //   198	202	215	java/lang/Exception
    //   207	212	215	java/lang/Exception
    //   2	19	219	finally
    //   117	126	248	finally
    //   198	202	248	finally
    //   207	212	248	finally
    //   231	236	248	finally
    //   241	246	248	finally
    //   246	248	248	finally
    //   231	236	253	java/lang/Exception
    //   241	246	253	java/lang/Exception
    //   19	29	258	finally
    //   36	44	265	finally
    //   51	56	265	finally
    //   63	68	265	finally
    //   75	117	265	finally
    //   143	162	265	finally
    //   169	182	265	finally
    //   189	194	265	finally
    //   19	29	273	java/io/IOException
    //   36	44	280	java/io/IOException
    //   51	56	280	java/io/IOException
    //   63	68	280	java/io/IOException
    //   75	117	280	java/io/IOException
    //   117	126	285	java/lang/Exception
  }
  
  /* Error */
  public final int Fl(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokevirtual 180	com/tencent/mm/storage/y:get	(I)Ljava/lang/Object;
    //   7: checkcast 101	java/lang/Integer
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +9 -> 21
    //   15: iconst_0
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: aload_2
    //   22: invokevirtual 183	java/lang/Integer:intValue	()I
    //   25: istore_1
    //   26: goto -9 -> 17
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	y
    //   0	34	1	paramInt	int
    //   10	12	2	localInteger	Integer
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	29	finally
    //   21	26	29	finally
  }
  
  public final void cqu()
  {
    try
    {
      this.dxK = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ctU()
  {
    try
    {
      this.dxK = false;
      yQ();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Object get(int paramInt)
  {
    try
    {
      Object localObject1 = this.values.get(Integer.valueOf(paramInt));
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /* Error */
  public final Object get(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 75	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 190 2 0
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +7 -> 24
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: areturn
    //   24: aload_3
    //   25: astore_2
    //   26: goto -6 -> 20
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	y
    //   0	34	1	paramInt	int
    //   0	34	2	paramObject	Object
    //   15	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	29	finally
  }
  
  /* Error */
  public long getLong(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokevirtual 180	com/tencent/mm/storage/y:get	(I)Ljava/lang/Object;
    //   7: checkcast 158	java/lang/Long
    //   10: astore 4
    //   12: aload 4
    //   14: ifnonnull +7 -> 21
    //   17: aload_0
    //   18: monitorexit
    //   19: lload_2
    //   20: lreturn
    //   21: aload 4
    //   23: invokevirtual 196	java/lang/Long:longValue	()J
    //   26: lstore_2
    //   27: goto -10 -> 17
    //   30: astore 4
    //   32: aload_0
    //   33: monitorexit
    //   34: aload 4
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	y
    //   0	37	1	paramInt	int
    //   0	37	2	paramLong	long
    //   10	12	4	localLong	Long
    //   30	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	30	finally
    //   21	27	30	finally
  }
  
  public final void reset()
  {
    try
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ConfigFileStorage", "ConfigFileStorage reset ");
      File localFile = new File(this.filePath);
      if (localFile.exists()) {
        localFile.delete();
      }
      this.values = new HashMap();
      return;
    }
    finally {}
  }
  
  public final void set(int paramInt, Object paramObject)
  {
    try
    {
      this.values.put(Integer.valueOf(paramInt), paramObject);
      if (!this.dxK) {
        yQ();
      }
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public final void setInt(int paramInt1, int paramInt2)
  {
    try
    {
      set(paramInt1, Integer.valueOf(paramInt2));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void setLong(int paramInt, long paramLong)
  {
    try
    {
      set(paramInt, Long.valueOf(paramLong));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.y
 * JD-Core Version:    0.7.0.1
 */