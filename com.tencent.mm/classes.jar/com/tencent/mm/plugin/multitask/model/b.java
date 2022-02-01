package com.tencent.mm.plugin.multitask.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.plugin.p.h;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/model/MultiTaskLiveStorage;", "Lcom/tencent/mm/plugin/livestorage/MMLiveStorage;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "dbProvider", "Lcom/tencent/mm/plugin/livestorage/ILiveDBProvider;", "(Lcom/tencent/mm/plugin/livestorage/ILiveDBProvider;)V", "checkAndMove", "", "item", "createObserverOwner", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "deleteById", "id", "", "getById", "getMultiTaskInfoList", "", "getTaskListByType", "type", "", "Companion", "plugin-multitask_release"})
public final class b
  extends h<MultiTaskInfo>
{
  public static final b.a FHK;
  
  static
  {
    AppMethodBeat.i(249017);
    FHK = new b.a((byte)0);
    AppMethodBeat.o(249017);
  }
  
  public b(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(249015);
    AppMethodBeat.o(249015);
  }
  
  /* Error */
  public final java.util.List<MultiTaskInfo> Yc(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 70
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 72	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 74	java/util/ArrayList:<init>	()V
    //   14: astore_2
    //   15: aload_0
    //   16: getfield 78	com/tencent/mm/plugin/p/h:EiW	Lcom/tencent/mm/plugin/p/c;
    //   19: invokeinterface 84 1 0
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull +113 -> 141
    //   31: aload 4
    //   33: ldc 86
    //   35: iconst_1
    //   36: anewarray 88	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: iload_1
    //   42: invokestatic 92	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   45: aastore
    //   46: invokeinterface 98 3 0
    //   51: astore 4
    //   53: aload 4
    //   55: ifnull +86 -> 141
    //   58: aload 4
    //   60: checkcast 100	java/io/Closeable
    //   63: astore 4
    //   65: aload 4
    //   67: checkcast 102	android/database/Cursor
    //   70: astore 5
    //   72: aload 5
    //   74: invokeinterface 106 1 0
    //   79: ifeq +51 -> 130
    //   82: new 108	com/tencent/mm/plugin/multitask/model/MultiTaskInfo
    //   85: dup
    //   86: invokespecial 109	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:<init>	()V
    //   89: astore 6
    //   91: aload 6
    //   93: aload 5
    //   95: invokevirtual 113	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:convertFrom	(Landroid/database/Cursor;)V
    //   98: aload_2
    //   99: aload 6
    //   101: invokevirtual 117	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   104: pop
    //   105: goto -33 -> 72
    //   108: astore_3
    //   109: ldc 70
    //   111: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_3
    //   115: athrow
    //   116: astore_2
    //   117: aload 4
    //   119: aload_3
    //   120: invokestatic 123	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   123: ldc 70
    //   125: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_2
    //   129: athrow
    //   130: getstatic 129	kotlin/x:aazN	Lkotlin/x;
    //   133: astore 5
    //   135: aload 4
    //   137: aconst_null
    //   138: invokestatic 123	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   141: aload_2
    //   142: checkcast 131	java/util/List
    //   145: astore_2
    //   146: ldc 70
    //   148: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_2
    //   152: areturn
    //   153: astore_2
    //   154: goto -37 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	b
    //   0	157	1	paramInt	int
    //   14	85	2	localArrayList	java.util.ArrayList
    //   116	26	2	localObject1	java.lang.Object
    //   145	7	2	localList	java.util.List
    //   153	1	2	localObject2	java.lang.Object
    //   1	1	3	localObject3	java.lang.Object
    //   108	12	3	localThrowable	java.lang.Throwable
    //   24	112	4	localObject4	java.lang.Object
    //   70	64	5	localObject5	java.lang.Object
    //   89	11	6	localMultiTaskInfo	MultiTaskInfo
    // Exception table:
    //   from	to	target	type
    //   65	72	108	java/lang/Throwable
    //   72	105	108	java/lang/Throwable
    //   130	135	108	java/lang/Throwable
    //   109	116	116	finally
    //   65	72	153	finally
    //   72	105	153	finally
    //   130	135	153	finally
  }
  
  /* Error */
  public final MultiTaskInfo aRb(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 136
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 137
    //   10: invokestatic 62	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 78	com/tencent/mm/plugin/p/h:EiW	Lcom/tencent/mm/plugin/p/c;
    //   17: invokeinterface 84 1 0
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull +80 -> 104
    //   27: aload_3
    //   28: ldc 139
    //   30: iconst_1
    //   31: anewarray 88	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: aload_1
    //   37: aastore
    //   38: invokeinterface 98 3 0
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +59 -> 104
    //   48: aload_1
    //   49: checkcast 100	java/io/Closeable
    //   52: astore_3
    //   53: aload_3
    //   54: checkcast 102	android/database/Cursor
    //   57: astore_1
    //   58: aload_1
    //   59: invokeinterface 106 1 0
    //   64: ifeq +31 -> 95
    //   67: new 108	com/tencent/mm/plugin/multitask/model/MultiTaskInfo
    //   70: dup
    //   71: invokespecial 109	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:<init>	()V
    //   74: astore 4
    //   76: aload 4
    //   78: aload_1
    //   79: invokevirtual 113	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:convertFrom	(Landroid/database/Cursor;)V
    //   82: aload_3
    //   83: aconst_null
    //   84: invokestatic 123	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   87: ldc 136
    //   89: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload 4
    //   94: areturn
    //   95: getstatic 129	kotlin/x:aazN	Lkotlin/x;
    //   98: astore_1
    //   99: aload_3
    //   100: aconst_null
    //   101: invokestatic 123	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   104: ldc 136
    //   106: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_2
    //   112: ldc 136
    //   114: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_2
    //   118: athrow
    //   119: astore_1
    //   120: aload_3
    //   121: aload_2
    //   122: invokestatic 123	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   125: ldc 136
    //   127: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_1
    //   131: athrow
    //   132: astore_1
    //   133: goto -13 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	b
    //   0	136	1	paramString	java.lang.String
    //   1	1	2	localObject1	java.lang.Object
    //   111	11	2	localThrowable	java.lang.Throwable
    //   22	99	3	localObject2	java.lang.Object
    //   74	19	4	localMultiTaskInfo	MultiTaskInfo
    // Exception table:
    //   from	to	target	type
    //   53	82	111	java/lang/Throwable
    //   95	99	111	java/lang/Throwable
    //   112	119	119	finally
    //   53	82	132	finally
    //   95	99	132	finally
  }
  
  public final StorageObserverOwner<MultiTaskInfo> createObserverOwner()
  {
    AppMethodBeat.i(249014);
    StorageObserverOwner localStorageObserverOwner = new StorageObserverOwner();
    AppMethodBeat.o(249014);
    return localStorageObserverOwner;
  }
  
  /* Error */
  public final java.util.List<MultiTaskInfo> fbd()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 148
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 72	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 74	java/util/ArrayList:<init>	()V
    //   14: astore_1
    //   15: aload_0
    //   16: getfield 78	com/tencent/mm/plugin/p/h:EiW	Lcom/tencent/mm/plugin/p/c;
    //   19: invokeinterface 84 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +95 -> 121
    //   29: aload_3
    //   30: ldc 150
    //   32: aconst_null
    //   33: invokeinterface 98 3 0
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +81 -> 121
    //   43: aload_3
    //   44: checkcast 100	java/io/Closeable
    //   47: astore_3
    //   48: aload_3
    //   49: checkcast 102	android/database/Cursor
    //   52: astore 4
    //   54: aload 4
    //   56: invokeinterface 106 1 0
    //   61: ifeq +50 -> 111
    //   64: new 108	com/tencent/mm/plugin/multitask/model/MultiTaskInfo
    //   67: dup
    //   68: invokespecial 109	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:<init>	()V
    //   71: astore 5
    //   73: aload 5
    //   75: aload 4
    //   77: invokevirtual 113	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:convertFrom	(Landroid/database/Cursor;)V
    //   80: aload_1
    //   81: aload 5
    //   83: invokevirtual 117	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   86: pop
    //   87: goto -33 -> 54
    //   90: astore_2
    //   91: ldc 148
    //   93: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_2
    //   97: athrow
    //   98: astore_1
    //   99: aload_3
    //   100: aload_2
    //   101: invokestatic 123	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   104: ldc 148
    //   106: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_1
    //   110: athrow
    //   111: getstatic 129	kotlin/x:aazN	Lkotlin/x;
    //   114: astore 4
    //   116: aload_3
    //   117: aconst_null
    //   118: invokestatic 123	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   121: aload_1
    //   122: checkcast 131	java/util/List
    //   125: astore_1
    //   126: ldc 148
    //   128: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_1
    //   132: areturn
    //   133: astore_1
    //   134: goto -35 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	b
    //   14	67	1	localArrayList	java.util.ArrayList
    //   98	24	1	localObject1	java.lang.Object
    //   125	7	1	localList	java.util.List
    //   133	1	1	localObject2	java.lang.Object
    //   1	1	2	localObject3	java.lang.Object
    //   90	11	2	localThrowable	java.lang.Throwable
    //   24	93	3	localObject4	java.lang.Object
    //   52	63	4	localObject5	java.lang.Object
    //   71	11	5	localMultiTaskInfo	MultiTaskInfo
    // Exception table:
    //   from	to	target	type
    //   48	54	90	java/lang/Throwable
    //   54	87	90	java/lang/Throwable
    //   111	116	90	java/lang/Throwable
    //   91	98	98	finally
    //   48	54	133	finally
    //   54	87	133	finally
    //   111	116	133	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.model.b
 * JD-Core Version:    0.7.0.1
 */