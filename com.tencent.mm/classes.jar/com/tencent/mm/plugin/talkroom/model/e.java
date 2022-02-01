package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.dgr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  implements com.tencent.mm.bh.b
{
  private ao handler;
  private HashSet<com.tencent.mm.bh.a> listeners;
  private final String path;
  private com.tencent.mm.plugin.talkroom.a.b zVQ;
  
  public e()
  {
    AppMethodBeat.i(29461);
    this.listeners = new HashSet();
    Object localObject = new com.tencent.mm.vfs.e(b.ebo());
    if (!((com.tencent.mm.vfs.e)localObject).exists()) {
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    this.path = (b.ebo() + "talkroomMemberList.info");
    this.handler = new ao(Looper.getMainLooper());
    if (this.zVQ == null)
    {
      if (!i.eA(this.path))
      {
        this.zVQ = new com.tencent.mm.plugin.talkroom.a.b();
        AppMethodBeat.o(29461);
        return;
      }
      try
      {
        localObject = i.aU(this.path, 0, -1);
        this.zVQ = ((com.tencent.mm.plugin.talkroom.a.b)new com.tencent.mm.plugin.talkroom.a.b().parseFrom((byte[])localObject));
        AppMethodBeat.o(29461);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", localException, "", new Object[0]);
        this.zVQ = new com.tencent.mm.plugin.talkroom.a.b();
      }
    }
    AppMethodBeat.o(29461);
  }
  
  private boolean a(com.tencent.mm.plugin.talkroom.a.b paramb)
  {
    AppMethodBeat.i(179741);
    if (paramb.zVE.isEmpty())
    {
      i.deleteFile(this.path);
      AppMethodBeat.o(179741);
      return true;
    }
    try
    {
      paramb = paramb.toByteArray();
      i.f(this.path, paramb, paramb.length);
      AppMethodBeat.o(179741);
      return true;
    }
    catch (Exception paramb)
    {
      ac.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", paramb, "", new Object[0]);
      AppMethodBeat.o(179741);
    }
    return false;
  }
  
  private void ah(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(29468);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      final com.tencent.mm.bh.a locala = (com.tencent.mm.bh.a)localIterator.next();
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29460);
          locala.h(paramString1, paramString2, paramString3);
          AppMethodBeat.o(29460);
        }
      });
    }
    AppMethodBeat.o(29468);
  }
  
  /* Error */
  public final boolean DC(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 29464
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/talkroom/model/e:zVQ	Lcom/tencent/mm/plugin/talkroom/a/b;
    //   12: getfield 119	com/tencent/mm/plugin/talkroom/a/b:zVE	Ljava/util/LinkedList;
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
  
  public final void a(com.tencent.mm.bh.a parama)
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
  
  public final void a(String paramString1, LinkedList<dgr> paramLinkedList, String paramString2, String paramString3, int paramInt)
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
        ac.i("MicroMsg.TalkRoomInfoListMgr", "updateList talk: %s,  size: %d", new Object[] { paramString1, Integer.valueOf(((LinkedList)localObject).size()) });
        paramLinkedList = (LinkedList)((LinkedList)localObject).clone();
        boolean bool = paramLinkedList.isEmpty();
        localObject = this.zVQ.zVE.iterator();
        if (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.talkroom.a.a locala = (com.tencent.mm.plugin.talkroom.a.a)((Iterator)localObject).next();
          if (!locala.username.equals(paramString1)) {
            continue;
          }
          if (bool)
          {
            this.zVQ.zVE.remove(locala);
            a(this.zVQ);
            ah(paramString1, paramString2, paramString3);
            AppMethodBeat.o(29467);
            return;
          }
          locala.dow = paramLinkedList;
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
      ((com.tencent.mm.plugin.talkroom.a.a)localObject).dow = paramLinkedList;
      ((com.tencent.mm.plugin.talkroom.a.a)localObject).sceneType = paramInt;
      this.zVQ.zVE.add(localObject);
      label222:
      a(this.zVQ);
      ah(paramString1, paramString2, paramString3);
      AppMethodBeat.o(29467);
    }
  }
  
  /* Error */
  public final boolean aIJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 29465
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/talkroom/model/e:zVQ	Lcom/tencent/mm/plugin/talkroom/a/b;
    //   12: getfield 119	com/tencent/mm/plugin/talkroom/a/b:zVE	Ljava/util/LinkedList;
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
    //   46: getfield 210	com/tencent/mm/plugin/talkroom/a/a:dow	Ljava/util/LinkedList;
    //   49: invokevirtual 161	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   52: astore_3
    //   53: aload_3
    //   54: invokeinterface 146 1 0
    //   59: ifeq -40 -> 19
    //   62: aload_3
    //   63: invokeinterface 150 1 0
    //   68: checkcast 217	com/tencent/mm/protocal/protobuf/dgr
    //   71: astore 4
    //   73: invokestatic 222	com/tencent/mm/model/u:axw	()Ljava/lang/String;
    //   76: aload 4
    //   78: getfield 225	com/tencent/mm/protocal/protobuf/dgr:ncR	Ljava/lang/String;
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
    //   71	6	4	localdgr	dgr
    // Exception table:
    //   from	to	target	type
    //   2	19	110	finally
    //   19	53	110	finally
    //   53	87	110	finally
    //   89	95	110	finally
    //   101	107	110	finally
  }
  
  public final void aIK()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(179740);
        LinkedList localLinkedList = new LinkedList();
        if ((this.zVQ.zVE != null) && (!this.zVQ.zVE.isEmpty()))
        {
          localObject2 = (com.tencent.mm.plugin.talkroom.a.a[])this.zVQ.zVE.toArray(new com.tencent.mm.plugin.talkroom.a.a[0]);
          int k = localObject2.length;
          j = 0;
          if (j < k)
          {
            Object localObject3 = localObject2[j];
            if (bs.gY(localObject3.dow)) {
              break label217;
            }
            int i = 1;
            Iterator localIterator = localObject3.dow.iterator();
            if (localIterator.hasNext())
            {
              dgr localdgr = (dgr)localIterator.next();
              ac.d("MicroMsg.TalkRoomInfoListMgr", "member :".concat(String.valueOf(localdgr)));
              if (!localdgr.ncR.equals(u.axw())) {
                break label214;
              }
              ac.i("MicroMsg.TalkRoomInfoListMgr", "reset list info and remove self location info");
              i = 0;
              break label214;
            }
            if (i == 0) {
              break label217;
            }
            localLinkedList.add(localObject3);
            break label217;
          }
        }
        Object localObject2 = new com.tencent.mm.plugin.talkroom.a.b();
        ((com.tencent.mm.plugin.talkroom.a.b)localObject2).zVE = localLinkedList;
        a((com.tencent.mm.plugin.talkroom.a.b)localObject2);
        AppMethodBeat.o(179740);
        return;
      }
      finally {}
      label214:
      continue;
      label217:
      j += 1;
    }
  }
  
  /* Error */
  public final LinkedList<dgr> axD(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 29466
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/talkroom/model/e:zVQ	Lcom/tencent/mm/plugin/talkroom/a/b;
    //   12: getfield 119	com/tencent/mm/plugin/talkroom/a/b:zVE	Ljava/util/LinkedList;
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
    //   50: getfield 210	com/tencent/mm/plugin/talkroom/a/a:dow	Ljava/util/LinkedList;
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
  
  public final void b(com.tencent.mm.bh.a parama)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.e
 * JD-Core Version:    0.7.0.1
 */