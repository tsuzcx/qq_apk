package com.tencent.mm.ui.chatting.atsomeone;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.p.i;
import com.tencent.mm.storage.ah;
import java.util.List;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "chatroom", "", "(Ljava/lang/String;)V", "getChatroom", "()Ljava/lang/String;", "chatroomMember", "Lcom/tencent/mm/storage/ChatRoomMember;", "getChatroomMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "setChatroomMember", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "dbProvider", "Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "memberList", "", "getMemberList", "()Ljava/util/List;", "setMemberList", "(Ljava/util/List;)V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "getPriority", "", "onCreate", "", "Companion", "app_release"})
public final class c
  extends com.tencent.mm.plugin.livelist.a.a<f>
{
  public static final c.a WFX;
  private final kotlin.f Ejb;
  private ah WFW;
  private List<String> fMr;
  private final String fxT;
  
  static
  {
    AppMethodBeat.i(281300);
    WFX = new c.a((byte)0);
    AppMethodBeat.o(281300);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(281298);
    this.fxT = paramString;
    this.Ejb = g.ar((kotlin.g.a.a)b.WFY);
    AppMethodBeat.o(281298);
  }
  
  public final int getPriority()
  {
    return -1;
  }
  
  /* Error */
  public final void onCreate()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 216
    //   4: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 218
    //   9: invokestatic 224	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   12: astore_1
    //   13: aload_1
    //   14: ldc 226
    //   16: invokestatic 229	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_0
    //   20: aload_1
    //   21: checkcast 218	com/tencent/mm/plugin/chatroom/a/b
    //   24: invokeinterface 233 1 0
    //   29: aload_0
    //   30: getfield 94	com/tencent/mm/ui/chatting/atsomeone/c:fxT	Ljava/lang/String;
    //   33: invokeinterface 239 2 0
    //   38: putfield 200	com/tencent/mm/ui/chatting/atsomeone/c:WFW	Lcom/tencent/mm/storage/ah;
    //   41: aload_0
    //   42: getfield 94	com/tencent/mm/ui/chatting/atsomeone/c:fxT	Ljava/lang/String;
    //   45: invokestatic 245	com/tencent/mm/model/v:Ps	(Ljava/lang/String;)Ljava/util/List;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +210 -> 260
    //   53: aload_1
    //   54: invokestatic 250	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
    //   57: invokeinterface 253 2 0
    //   62: pop
    //   63: getstatic 259	com/tencent/mm/f/c/ax:TABLE	Lcom/tencent/mm/sdk/storage/sql/SingleTable;
    //   66: getstatic 263	com/tencent/mm/f/c/ax:C_USERNAME	Lcom/tencent/mm/sdk/storage/sql/Column;
    //   69: invokestatic 269	kotlin/a/j:listOf	(Ljava/lang/Object;)Ljava/util/List;
    //   72: invokevirtual 275	com/tencent/mm/sdk/storage/sql/SingleTable:select	(Ljava/util/List;)Lcom/tencent/mm/sdk/storage/sql/SelectSql$Builder;
    //   75: ldc_w 277
    //   78: invokevirtual 283	com/tencent/mm/sdk/storage/sql/SelectSql$Builder:log	(Ljava/lang/String;)Lcom/tencent/mm/sdk/storage/sql/SelectSql$Builder;
    //   81: getstatic 263	com/tencent/mm/f/c/ax:C_USERNAME	Lcom/tencent/mm/sdk/storage/sql/Column;
    //   84: aload_1
    //   85: invokevirtual 289	com/tencent/mm/sdk/storage/sql/Column:inString	(Ljava/util/List;)Lcom/tencent/mm/sdk/sql/SingleCondition;
    //   88: checkcast 291	com/tencent/mm/sdk/sql/ISqlCondition
    //   91: invokevirtual 295	com/tencent/mm/sdk/storage/sql/SelectSql$Builder:where	(Lcom/tencent/mm/sdk/sql/ISqlCondition;)Lcom/tencent/mm/sdk/storage/sql/SelectSql$Builder;
    //   94: astore_3
    //   95: getstatic 299	com/tencent/mm/plugin/p/a/a:Ejf	Lcom/tencent/mm/plugin/p/a/a$a;
    //   98: astore 4
    //   100: aload_3
    //   101: invokestatic 304	com/tencent/mm/plugin/p/a/a$a:eLW	()Ljava/util/List;
    //   104: invokevirtual 307	com/tencent/mm/sdk/storage/sql/SelectSql$Builder:orderBy	(Ljava/util/List;)Lcom/tencent/mm/sdk/storage/sql/SelectSql$Builder;
    //   107: invokevirtual 311	com/tencent/mm/sdk/storage/sql/SelectSql$Builder:build	()Lcom/tencent/mm/sdk/storage/sql/SelectSql;
    //   110: astore_3
    //   111: new 144	java/util/ArrayList
    //   114: dup
    //   115: invokespecial 145	java/util/ArrayList:<init>	()V
    //   118: astore 4
    //   120: aload_0
    //   121: getfield 108	com/tencent/mm/ui/chatting/atsomeone/c:Ejb	Lkotlin/f;
    //   124: invokeinterface 316 1 0
    //   129: checkcast 318	com/tencent/mm/plugin/p/i
    //   132: invokevirtual 322	com/tencent/mm/plugin/p/i:eLT	()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   135: astore 5
    //   137: aload 5
    //   139: ifnull +92 -> 231
    //   142: aload 5
    //   144: aload_3
    //   145: invokevirtual 327	com/tencent/mm/sdk/storage/sql/SelectSql:getSql	()Ljava/lang/String;
    //   148: aload_3
    //   149: invokevirtual 331	com/tencent/mm/sdk/storage/sql/SelectSql:getParams	()[Ljava/lang/String;
    //   152: invokeinterface 337 3 0
    //   157: astore_3
    //   158: aload_3
    //   159: ifnull +72 -> 231
    //   162: aload_3
    //   163: checkcast 339	java/io/Closeable
    //   166: astore_3
    //   167: aload_3
    //   168: checkcast 341	android/database/Cursor
    //   171: astore 5
    //   173: aload 5
    //   175: invokeinterface 344 1 0
    //   180: ifeq +41 -> 221
    //   183: aload 4
    //   185: aload 5
    //   187: iconst_0
    //   188: invokeinterface 348 2 0
    //   193: invokevirtual 153	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   196: pop
    //   197: goto -24 -> 173
    //   200: astore_2
    //   201: ldc 216
    //   203: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_2
    //   207: athrow
    //   208: astore_1
    //   209: aload_3
    //   210: aload_2
    //   211: invokestatic 353	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   214: ldc 216
    //   216: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_1
    //   220: athrow
    //   221: getstatic 359	kotlin/x:aazN	Lkotlin/x;
    //   224: astore 5
    //   226: aload_3
    //   227: aconst_null
    //   228: invokestatic 353	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   231: aload_1
    //   232: invokeinterface 362 1 0
    //   237: aload_1
    //   238: aload 4
    //   240: checkcast 364	java/util/Collection
    //   243: invokeinterface 368 2 0
    //   248: pop
    //   249: aload_0
    //   250: aload_1
    //   251: putfield 125	com/tencent/mm/ui/chatting/atsomeone/c:fMr	Ljava/util/List;
    //   254: ldc 216
    //   256: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: return
    //   260: aconst_null
    //   261: astore_1
    //   262: goto -13 -> 249
    //   265: astore_1
    //   266: goto -57 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	c
    //   12	73	1	localObject1	java.lang.Object
    //   208	43	1	localObject2	java.lang.Object
    //   261	1	1	localObject3	java.lang.Object
    //   265	1	1	localObject4	java.lang.Object
    //   1	1	2	localObject5	java.lang.Object
    //   200	11	2	localThrowable	java.lang.Throwable
    //   94	133	3	localObject6	java.lang.Object
    //   98	141	4	localObject7	java.lang.Object
    //   135	90	5	localObject8	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   167	173	200	java/lang/Throwable
    //   173	197	200	java/lang/Throwable
    //   221	226	200	java/lang/Throwable
    //   201	208	208	finally
    //   167	173	265	finally
    //   173	197	265	finally
    //   221	226	265	finally
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<i>
  {
    public static final b WFY;
    
    static
    {
      AppMethodBeat.i(290054);
      WFY = new b();
      AppMethodBeat.o(290054);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.c
 * JD-Core Version:    0.7.0.1
 */