package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.fly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  implements com.tencent.mm.bc.b
{
  private com.tencent.mm.plugin.talkroom.a.b SNg;
  private MMHandler handler;
  private HashSet<com.tencent.mm.bc.a> listeners;
  private final String path;
  
  public e()
  {
    AppMethodBeat.i(29461);
    this.listeners = new HashSet();
    Object localObject = new u(b.hCq());
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
    }
    this.path = (b.hCq() + "talkroomMemberList.info");
    this.handler = new MMHandler(Looper.getMainLooper());
    if (this.SNg == null)
    {
      if (!y.ZC(this.path))
      {
        this.SNg = new com.tencent.mm.plugin.talkroom.a.b();
        AppMethodBeat.o(29461);
        return;
      }
      try
      {
        localObject = y.bi(this.path, 0, -1);
        this.SNg = ((com.tencent.mm.plugin.talkroom.a.b)new com.tencent.mm.plugin.talkroom.a.b().parseFrom((byte[])localObject));
        AppMethodBeat.o(29461);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", localException, "", new Object[0]);
        this.SNg = new com.tencent.mm.plugin.talkroom.a.b();
      }
    }
    AppMethodBeat.o(29461);
  }
  
  private boolean a(com.tencent.mm.plugin.talkroom.a.b paramb)
  {
    AppMethodBeat.i(179741);
    if (paramb.SMV.isEmpty())
    {
      y.deleteFile(this.path);
      AppMethodBeat.o(179741);
      return true;
    }
    try
    {
      paramb = paramb.toByteArray();
      y.f(this.path, paramb, paramb.length);
      AppMethodBeat.o(179741);
      return true;
    }
    catch (Exception paramb)
    {
      Log.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", paramb, "", new Object[0]);
      AppMethodBeat.o(179741);
    }
    return false;
  }
  
  private void aF(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(29468);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      final com.tencent.mm.bc.a locala = (com.tencent.mm.bc.a)localIterator.next();
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29460);
          locala.m(paramString1, paramString2, paramString3);
          AppMethodBeat.o(29460);
        }
      });
    }
    AppMethodBeat.o(29468);
  }
  
  /* Error */
  public final boolean Pv(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 29464
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/talkroom/model/e:SNg	Lcom/tencent/mm/plugin/talkroom/a/b;
    //   12: getfield 119	com/tencent/mm/plugin/talkroom/a/b:SMV	Ljava/util/LinkedList;
    //   15: invokevirtual 161	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore_3
    //   19: aload_3
    //   20: invokeinterface 146 1 0
    //   25: ifeq +46 -> 71
    //   28: aload_3
    //   29: invokeinterface 150 1 0
    //   34: checkcast 163	com/tencent/mm/plugin/talkroom/a/a
    //   37: astore 4
    //   39: aload 4
    //   41: getfield 166	com/tencent/mm/plugin/talkroom/a/a:username	Ljava/lang/String;
    //   44: aload_1
    //   45: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifeq -29 -> 19
    //   51: aload 4
    //   53: getfield 176	com/tencent/mm/plugin/talkroom/a/a:sceneType	I
    //   56: ifne -37 -> 19
    //   59: iconst_1
    //   60: istore_2
    //   61: sipush 29464
    //   64: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: monitorexit
    //   69: iload_2
    //   70: ireturn
    //   71: iconst_0
    //   72: istore_2
    //   73: sipush 29464
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
  
  public final void a(com.tencent.mm.bc.a parama)
  {
    try
    {
      AppMethodBeat.i(29462);
      this.listeners.add(parama);
      AppMethodBeat.o(29462);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void a(String paramString1, LinkedList<fly> paramLinkedList, String paramString2, String paramString3, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(29467);
        localObject = paramLinkedList;
        if (paramLinkedList == null) {
          localObject = new LinkedList();
        }
        Log.i("MicroMsg.TalkRoomInfoListMgr", "updateList talk: %s,  size: %d", new Object[] { paramString1, Integer.valueOf(((LinkedList)localObject).size()) });
        paramLinkedList = (LinkedList)((LinkedList)localObject).clone();
        boolean bool = paramLinkedList.isEmpty();
        localObject = this.SNg.SMV.iterator();
        if (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.talkroom.a.a locala = (com.tencent.mm.plugin.talkroom.a.a)((Iterator)localObject).next();
          if (!locala.username.equals(paramString1)) {
            continue;
          }
          if (bool)
          {
            this.SNg.SMV.remove(locala);
            a(this.SNg);
            aF(paramString1, paramString2, paramString3);
            AppMethodBeat.o(29467);
            return;
          }
          locala.hSk = paramLinkedList;
          locala.sceneType = paramInt;
          continue;
        }
        if (bool) {
          break label222;
        }
      }
      finally {}
      Object localObject = new com.tencent.mm.plugin.talkroom.a.a();
      ((com.tencent.mm.plugin.talkroom.a.a)localObject).username = paramString1;
      ((com.tencent.mm.plugin.talkroom.a.a)localObject).hSk = paramLinkedList;
      ((com.tencent.mm.plugin.talkroom.a.a)localObject).sceneType = paramInt;
      this.SNg.SMV.add(localObject);
      label222:
      a(this.SNg);
      aF(paramString1, paramString2, paramString3);
      AppMethodBeat.o(29467);
    }
  }
  
  public final void b(com.tencent.mm.bc.a parama)
  {
    try
    {
      AppMethodBeat.i(29463);
      this.listeners.remove(parama);
      AppMethodBeat.o(29463);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  /* Error */
  public final boolean bNn()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 29465
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/talkroom/model/e:SNg	Lcom/tencent/mm/plugin/talkroom/a/b;
    //   12: getfield 119	com/tencent/mm/plugin/talkroom/a/b:SMV	Ljava/util/LinkedList;
    //   15: invokevirtual 161	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore_2
    //   19: aload_2
    //   20: invokeinterface 146 1 0
    //   25: ifeq +74 -> 99
    //   28: aload_2
    //   29: invokeinterface 150 1 0
    //   34: checkcast 163	com/tencent/mm/plugin/talkroom/a/a
    //   37: astore_3
    //   38: aload_3
    //   39: getfield 176	com/tencent/mm/plugin/talkroom/a/a:sceneType	I
    //   42: ifne -23 -> 19
    //   45: aload_3
    //   46: getfield 210	com/tencent/mm/plugin/talkroom/a/a:hSk	Ljava/util/LinkedList;
    //   49: invokevirtual 161	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   52: astore_3
    //   53: aload_3
    //   54: invokeinterface 146 1 0
    //   59: ifeq -40 -> 19
    //   62: aload_3
    //   63: invokeinterface 150 1 0
    //   68: checkcast 219	com/tencent/mm/protocal/protobuf/fly
    //   71: astore 4
    //   73: invokestatic 224	com/tencent/mm/model/z:bAM	()Ljava/lang/String;
    //   76: aload 4
    //   78: getfield 227	com/tencent/mm/protocal/protobuf/fly:UserName	Ljava/lang/String;
    //   81: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -31 -> 53
    //   87: iconst_1
    //   88: istore_1
    //   89: sipush 29465
    //   92: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: monitorexit
    //   97: iload_1
    //   98: ireturn
    //   99: iconst_0
    //   100: istore_1
    //   101: sipush 29465
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
    //   71	6	4	localfly	fly
    // Exception table:
    //   from	to	target	type
    //   2	19	110	finally
    //   19	53	110	finally
    //   53	87	110	finally
    //   89	95	110	finally
    //   101	107	110	finally
  }
  
  public final void bNo()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(179740);
        LinkedList localLinkedList = new LinkedList();
        if ((this.SNg.SMV != null) && (!this.SNg.SMV.isEmpty()))
        {
          localObject2 = (com.tencent.mm.plugin.talkroom.a.a[])this.SNg.SMV.toArray(new com.tencent.mm.plugin.talkroom.a.a[0]);
          int k = localObject2.length;
          j = 0;
          if (j < k)
          {
            Object localObject3 = localObject2[j];
            if (Util.isNullOrNil(localObject3.hSk)) {
              break label218;
            }
            int i = 1;
            Iterator localIterator = localObject3.hSk.iterator();
            if (localIterator.hasNext())
            {
              fly localfly = (fly)localIterator.next();
              Log.d("MicroMsg.TalkRoomInfoListMgr", "member :".concat(String.valueOf(localfly)));
              if (!localfly.UserName.equals(z.bAM())) {
                break label215;
              }
              Log.i("MicroMsg.TalkRoomInfoListMgr", "reset list info and remove self location info");
              i = 0;
              break label215;
            }
            if (i == 0) {
              break label218;
            }
            localLinkedList.add(localObject3);
            break label218;
          }
        }
        Object localObject2 = new com.tencent.mm.plugin.talkroom.a.b();
        ((com.tencent.mm.plugin.talkroom.a.b)localObject2).SMV = localLinkedList;
        a((com.tencent.mm.plugin.talkroom.a.b)localObject2);
        AppMethodBeat.o(179740);
        return;
      }
      finally {}
      label215:
      continue;
      label218:
      j += 1;
    }
  }
  
  /* Error */
  public final LinkedList<fly> bdh(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 29466
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/talkroom/model/e:SNg	Lcom/tencent/mm/plugin/talkroom/a/b;
    //   12: getfield 119	com/tencent/mm/plugin/talkroom/a/b:SMV	Ljava/util/LinkedList;
    //   15: invokevirtual 161	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore_2
    //   19: aload_2
    //   20: invokeinterface 146 1 0
    //   25: ifeq +45 -> 70
    //   28: aload_2
    //   29: invokeinterface 150 1 0
    //   34: checkcast 163	com/tencent/mm/plugin/talkroom/a/a
    //   37: astore_3
    //   38: aload_3
    //   39: getfield 166	com/tencent/mm/plugin/talkroom/a/a:username	Ljava/lang/String;
    //   42: aload_1
    //   43: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq -27 -> 19
    //   49: aload_3
    //   50: getfield 210	com/tencent/mm/plugin/talkroom/a/a:hSk	Ljava/util/LinkedList;
    //   53: invokevirtual 200	java/util/LinkedList:clone	()Ljava/lang/Object;
    //   56: checkcast 121	java/util/LinkedList
    //   59: astore_1
    //   60: sipush 29466
    //   63: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: areturn
    //   70: new 121	java/util/LinkedList
    //   73: dup
    //   74: invokespecial 182	java/util/LinkedList:<init>	()V
    //   77: astore_1
    //   78: sipush 29466
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.e
 * JD-Core Version:    0.7.0.1
 */