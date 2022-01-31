package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  implements com.tencent.mm.bg.b
{
  private ak handler;
  private HashSet<com.tencent.mm.bg.a> listeners;
  private final String path;
  private com.tencent.mm.plugin.talkroom.a.b tch;
  
  public e()
  {
    AppMethodBeat.i(25779);
    this.listeners = new HashSet();
    Object localObject = new com.tencent.mm.vfs.b(b.cHu());
    if (!((com.tencent.mm.vfs.b)localObject).exists()) {
      ((com.tencent.mm.vfs.b)localObject).mkdirs();
    }
    this.path = (b.cHu() + "talkroomMemberList.info");
    this.handler = new ak(Looper.getMainLooper());
    if (this.tch == null)
    {
      if (!com.tencent.mm.vfs.e.cN(this.path))
      {
        this.tch = new com.tencent.mm.plugin.talkroom.a.b();
        AppMethodBeat.o(25779);
        return;
      }
      try
      {
        localObject = com.tencent.mm.vfs.e.i(this.path, 0, -1);
        this.tch = ((com.tencent.mm.plugin.talkroom.a.b)new com.tencent.mm.plugin.talkroom.a.b().parseFrom((byte[])localObject));
        AppMethodBeat.o(25779);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", localException, "", new Object[0]);
        this.tch = new com.tencent.mm.plugin.talkroom.a.b();
      }
    }
    AppMethodBeat.o(25779);
  }
  
  private void Y(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(25786);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      final com.tencent.mm.bg.a locala = (com.tencent.mm.bg.a)localIterator.next();
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25778);
          locala.k(paramString1, paramString2, paramString3);
          AppMethodBeat.o(25778);
        }
      });
    }
    AppMethodBeat.o(25786);
  }
  
  private boolean bLE()
  {
    AppMethodBeat.i(25787);
    if (this.tch.tbW.isEmpty())
    {
      com.tencent.mm.vfs.e.deleteFile(this.path);
      AppMethodBeat.o(25787);
      return true;
    }
    try
    {
      byte[] arrayOfByte = this.tch.toByteArray();
      com.tencent.mm.vfs.e.b(this.path, arrayOfByte, arrayOfByte.length);
      AppMethodBeat.o(25787);
      return true;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", localException, "", new Object[0]);
      AppMethodBeat.o(25787);
    }
    return false;
  }
  
  public final void a(com.tencent.mm.bg.a parama)
  {
    try
    {
      AppMethodBeat.i(25780);
      this.listeners.add(parama);
      AppMethodBeat.o(25780);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void a(String paramString1, LinkedList<cjn> paramLinkedList, String paramString2, String paramString3, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(25785);
        localObject = paramLinkedList;
        if (paramLinkedList == null) {
          localObject = new LinkedList();
        }
        ab.i("MicroMsg.TalkRoomInfoListMgr", "updateList talk: %s,  size: %d", new Object[] { paramString1, Integer.valueOf(((LinkedList)localObject).size()) });
        paramLinkedList = (LinkedList)((LinkedList)localObject).clone();
        boolean bool = paramLinkedList.isEmpty();
        localObject = this.tch.tbW.iterator();
        if (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.talkroom.a.a locala = (com.tencent.mm.plugin.talkroom.a.a)((Iterator)localObject).next();
          if (!locala.username.equals(paramString1)) {
            continue;
          }
          if (bool)
          {
            this.tch.tbW.remove(locala);
            bLE();
            Y(paramString1, paramString2, paramString3);
            AppMethodBeat.o(25785);
            return;
          }
          locala.cAC = paramLinkedList;
          locala.sceneType = paramInt;
          continue;
        }
        if (bool) {
          break label218;
        }
      }
      finally {}
      Object localObject = new com.tencent.mm.plugin.talkroom.a.a();
      ((com.tencent.mm.plugin.talkroom.a.a)localObject).username = paramString1;
      ((com.tencent.mm.plugin.talkroom.a.a)localObject).cAC = paramLinkedList;
      ((com.tencent.mm.plugin.talkroom.a.a)localObject).sceneType = paramInt;
      this.tch.tbW.add(localObject);
      label218:
      bLE();
      Y(paramString1, paramString2, paramString3);
      AppMethodBeat.o(25785);
    }
  }
  
  /* Error */
  public final boolean akO()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 25783
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/talkroom/model/e:tch	Lcom/tencent/mm/plugin/talkroom/a/b;
    //   12: getfield 140	com/tencent/mm/plugin/talkroom/a/b:tbW	Ljava/util/LinkedList;
    //   15: invokevirtual 183	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore_2
    //   19: aload_2
    //   20: invokeinterface 122 1 0
    //   25: ifeq +74 -> 99
    //   28: aload_2
    //   29: invokeinterface 126 1 0
    //   34: checkcast 185	com/tencent/mm/plugin/talkroom/a/a
    //   37: astore_3
    //   38: aload_3
    //   39: getfield 207	com/tencent/mm/plugin/talkroom/a/a:sceneType	I
    //   42: ifne -23 -> 19
    //   45: aload_3
    //   46: getfield 203	com/tencent/mm/plugin/talkroom/a/a:cAC	Ljava/util/LinkedList;
    //   49: invokevirtual 183	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   52: astore_3
    //   53: aload_3
    //   54: invokeinterface 122 1 0
    //   59: ifeq -40 -> 19
    //   62: aload_3
    //   63: invokeinterface 126 1 0
    //   68: checkcast 214	com/tencent/mm/protocal/protobuf/cjn
    //   71: astore 4
    //   73: invokestatic 219	com/tencent/mm/model/r:Zn	()Ljava/lang/String;
    //   76: aload 4
    //   78: getfield 222	com/tencent/mm/protocal/protobuf/cjn:jJA	Ljava/lang/String;
    //   81: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -31 -> 53
    //   87: iconst_1
    //   88: istore_1
    //   89: sipush 25783
    //   92: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: monitorexit
    //   97: iload_1
    //   98: ireturn
    //   99: iconst_0
    //   100: istore_1
    //   101: sipush 25783
    //   104: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: goto -12 -> 95
    //   110: astore_2
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_2
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	e
    //   88	13	1	bool	boolean
    //   18	11	2	localIterator	Iterator
    //   110	4	2	localObject1	Object
    //   37	26	3	localObject2	Object
    //   71	6	4	localcjn	cjn
    // Exception table:
    //   from	to	target	type
    //   2	19	110	finally
    //   19	53	110	finally
    //   53	87	110	finally
    //   89	95	110	finally
    //   101	107	110	finally
  }
  
  public final void b(com.tencent.mm.bg.a parama)
  {
    try
    {
      AppMethodBeat.i(25781);
      this.listeners.remove(parama);
      AppMethodBeat.o(25781);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  /* Error */
  public final LinkedList<cjn> uK(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 25784
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/talkroom/model/e:tch	Lcom/tencent/mm/plugin/talkroom/a/b;
    //   12: getfield 140	com/tencent/mm/plugin/talkroom/a/b:tbW	Ljava/util/LinkedList;
    //   15: invokevirtual 183	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore_2
    //   19: aload_2
    //   20: invokeinterface 122 1 0
    //   25: ifeq +45 -> 70
    //   28: aload_2
    //   29: invokeinterface 126 1 0
    //   34: checkcast 185	com/tencent/mm/plugin/talkroom/a/a
    //   37: astore_3
    //   38: aload_3
    //   39: getfield 188	com/tencent/mm/plugin/talkroom/a/a:username	Ljava/lang/String;
    //   42: aload_1
    //   43: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq -27 -> 19
    //   49: aload_3
    //   50: getfield 203	com/tencent/mm/plugin/talkroom/a/a:cAC	Ljava/util/LinkedList;
    //   53: invokevirtual 182	java/util/LinkedList:clone	()Ljava/lang/Object;
    //   56: checkcast 142	java/util/LinkedList
    //   59: astore_1
    //   60: sipush 25784
    //   63: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: areturn
    //   70: new 142	java/util/LinkedList
    //   73: dup
    //   74: invokespecial 164	java/util/LinkedList:<init>	()V
    //   77: astore_1
    //   78: sipush 25784
    //   81: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: goto -18 -> 66
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	e
    //   0	92	1	paramString	String
    //   18	11	2	localIterator	Iterator
    //   37	13	3	locala	com.tencent.mm.plugin.talkroom.a.a
    // Exception table:
    //   from	to	target	type
    //   2	19	87	finally
    //   19	66	87	finally
    //   70	84	87	finally
  }
  
  /* Error */
  public final boolean uL(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 25782
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/talkroom/model/e:tch	Lcom/tencent/mm/plugin/talkroom/a/b;
    //   12: getfield 140	com/tencent/mm/plugin/talkroom/a/b:tbW	Ljava/util/LinkedList;
    //   15: invokevirtual 183	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore_3
    //   19: aload_3
    //   20: invokeinterface 122 1 0
    //   25: ifeq +46 -> 71
    //   28: aload_3
    //   29: invokeinterface 126 1 0
    //   34: checkcast 185	com/tencent/mm/plugin/talkroom/a/a
    //   37: astore 4
    //   39: aload 4
    //   41: getfield 188	com/tencent/mm/plugin/talkroom/a/a:username	Ljava/lang/String;
    //   44: aload_1
    //   45: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifeq -29 -> 19
    //   51: aload 4
    //   53: getfield 207	com/tencent/mm/plugin/talkroom/a/a:sceneType	I
    //   56: ifne -37 -> 19
    //   59: iconst_1
    //   60: istore_2
    //   61: sipush 25782
    //   64: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: monitorexit
    //   69: iload_2
    //   70: ireturn
    //   71: iconst_0
    //   72: istore_2
    //   73: sipush 25782
    //   76: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -12 -> 67
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	e
    //   0	87	1	paramString	String
    //   60	13	2	bool	boolean
    //   18	11	3	localIterator	Iterator
    //   37	15	4	locala	com.tencent.mm.plugin.talkroom.a.a
    // Exception table:
    //   from	to	target	type
    //   2	19	82	finally
    //   19	59	82	finally
    //   61	67	82	finally
    //   73	79	82	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.e
 * JD-Core Version:    0.7.0.1
 */