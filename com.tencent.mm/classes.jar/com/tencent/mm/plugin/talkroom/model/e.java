package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.protocal.c.bxc;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  implements com.tencent.mm.bf.b
{
  private ah handler;
  private com.tencent.mm.plugin.talkroom.a.b pAw;
  private HashSet<com.tencent.mm.bf.a> pAx = new HashSet();
  private final String path;
  
  public e()
  {
    Object localObject = new com.tencent.mm.vfs.b(b.bMw());
    if (!((com.tencent.mm.vfs.b)localObject).exists()) {
      ((com.tencent.mm.vfs.b)localObject).mkdirs();
    }
    this.path = (b.bMw() + "talkroomMemberList.info");
    this.handler = new ah(Looper.getMainLooper());
    if (this.pAw == null)
    {
      if (!com.tencent.mm.vfs.e.bK(this.path)) {
        this.pAw = new com.tencent.mm.plugin.talkroom.a.b();
      }
    }
    else {
      return;
    }
    try
    {
      localObject = com.tencent.mm.vfs.e.c(this.path, 0, -1);
      this.pAw = ((com.tencent.mm.plugin.talkroom.a.b)new com.tencent.mm.plugin.talkroom.a.b().aH((byte[])localObject));
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", localException, "", new Object[0]);
      this.pAw = new com.tencent.mm.plugin.talkroom.a.b();
    }
  }
  
  private void R(String paramString1, String paramString2, String paramString3)
  {
    Iterator localIterator = this.pAx.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.bf.a locala = (com.tencent.mm.bf.a)localIterator.next();
      this.handler.post(new e.1(this, locala, paramString1, paramString2, paramString3));
    }
  }
  
  private boolean bel()
  {
    if (this.pAw.pAk.isEmpty())
    {
      com.tencent.mm.vfs.e.deleteFile(this.path);
      return true;
    }
    try
    {
      byte[] arrayOfByte = this.pAw.toByteArray();
      com.tencent.mm.vfs.e.b(this.path, arrayOfByte, arrayOfByte.length);
      return true;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", localException, "", new Object[0]);
    }
    return false;
  }
  
  /* Error */
  public final boolean RF()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/mm/plugin/talkroom/model/e:pAw	Lcom/tencent/mm/plugin/talkroom/a/b;
    //   6: getfield 132	com/tencent/mm/plugin/talkroom/a/b:pAk	Ljava/util/LinkedList;
    //   9: invokevirtual 150	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   12: astore_2
    //   13: aload_2
    //   14: invokeinterface 112 1 0
    //   19: ifeq +70 -> 89
    //   22: aload_2
    //   23: invokeinterface 116 1 0
    //   28: checkcast 152	com/tencent/mm/plugin/talkroom/a/a
    //   31: astore_3
    //   32: aload_3
    //   33: getfield 156	com/tencent/mm/plugin/talkroom/a/a:sceneType	I
    //   36: ifne -23 -> 13
    //   39: aload_3
    //   40: getfield 159	com/tencent/mm/plugin/talkroom/a/a:bSX	Ljava/util/LinkedList;
    //   43: invokevirtual 150	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   46: astore_3
    //   47: aload_3
    //   48: invokeinterface 112 1 0
    //   53: ifeq -40 -> 13
    //   56: aload_3
    //   57: invokeinterface 116 1 0
    //   62: checkcast 161	com/tencent/mm/protocal/c/bxc
    //   65: astore 4
    //   67: invokestatic 166	com/tencent/mm/model/q:Gj	()Ljava/lang/String;
    //   70: aload 4
    //   72: getfield 169	com/tencent/mm/protocal/c/bxc:hPY	Ljava/lang/String;
    //   75: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: istore_1
    //   79: iload_1
    //   80: ifeq -33 -> 47
    //   83: iconst_1
    //   84: istore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: iload_1
    //   88: ireturn
    //   89: iconst_0
    //   90: istore_1
    //   91: goto -6 -> 85
    //   94: astore_2
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_2
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	e
    //   78	13	1	bool	boolean
    //   12	11	2	localIterator	Iterator
    //   94	4	2	localObject1	Object
    //   31	26	3	localObject2	Object
    //   65	6	4	localbxc	bxc
    // Exception table:
    //   from	to	target	type
    //   2	13	94	finally
    //   13	47	94	finally
    //   47	79	94	finally
  }
  
  public final void a(com.tencent.mm.bf.a parama)
  {
    try
    {
      this.pAx.add(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void a(String paramString1, LinkedList<bxc> paramLinkedList, String paramString2, String paramString3, int paramInt)
  {
    Object localObject = paramLinkedList;
    if (paramLinkedList == null) {}
    for (;;)
    {
      try
      {
        localObject = new LinkedList();
        y.i("MicroMsg.TalkRoomInfoListMgr", "updateList talk: %s,  size: %d", new Object[] { paramString1, Integer.valueOf(((LinkedList)localObject).size()) });
        paramLinkedList = (LinkedList)((LinkedList)localObject).clone();
        boolean bool = paramLinkedList.isEmpty();
        localObject = this.pAw.pAk.iterator();
        if (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.talkroom.a.a locala = (com.tencent.mm.plugin.talkroom.a.a)((Iterator)localObject).next();
          if (!locala.username.equals(paramString1)) {
            continue;
          }
          if (bool)
          {
            this.pAw.pAk.remove(locala);
            bel();
            R(paramString1, paramString2, paramString3);
            return;
          }
          locala.bSX = paramLinkedList;
          locala.sceneType = paramInt;
          continue;
        }
        if (bool) {
          break label206;
        }
      }
      finally {}
      localObject = new com.tencent.mm.plugin.talkroom.a.a();
      ((com.tencent.mm.plugin.talkroom.a.a)localObject).username = paramString1;
      ((com.tencent.mm.plugin.talkroom.a.a)localObject).bSX = paramLinkedList;
      ((com.tencent.mm.plugin.talkroom.a.a)localObject).sceneType = paramInt;
      this.pAw.pAk.add(localObject);
      label206:
      bel();
      R(paramString1, paramString2, paramString3);
    }
  }
  
  public final void b(com.tencent.mm.bf.a parama)
  {
    try
    {
      this.pAx.remove(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  /* Error */
  public final LinkedList<bxc> nw(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/mm/plugin/talkroom/model/e:pAw	Lcom/tencent/mm/plugin/talkroom/a/b;
    //   6: getfield 132	com/tencent/mm/plugin/talkroom/a/b:pAk	Ljava/util/LinkedList;
    //   9: invokevirtual 150	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   12: astore_2
    //   13: aload_2
    //   14: invokeinterface 112 1 0
    //   19: ifeq +39 -> 58
    //   22: aload_2
    //   23: invokeinterface 116 1 0
    //   28: checkcast 152	com/tencent/mm/plugin/talkroom/a/a
    //   31: astore_3
    //   32: aload_3
    //   33: getfield 204	com/tencent/mm/plugin/talkroom/a/a:username	Ljava/lang/String;
    //   36: aload_1
    //   37: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq -27 -> 13
    //   43: aload_3
    //   44: getfield 159	com/tencent/mm/plugin/talkroom/a/a:bSX	Ljava/util/LinkedList;
    //   47: invokevirtual 201	java/util/LinkedList:clone	()Ljava/lang/Object;
    //   50: checkcast 134	java/util/LinkedList
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: areturn
    //   58: new 134	java/util/LinkedList
    //   61: dup
    //   62: invokespecial 182	java/util/LinkedList:<init>	()V
    //   65: astore_1
    //   66: goto -12 -> 54
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	e
    //   0	74	1	paramString	String
    //   12	11	2	localIterator	Iterator
    //   31	13	3	locala	com.tencent.mm.plugin.talkroom.a.a
    // Exception table:
    //   from	to	target	type
    //   2	13	69	finally
    //   13	54	69	finally
    //   58	66	69	finally
  }
  
  /* Error */
  public final boolean nx(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/mm/plugin/talkroom/model/e:pAw	Lcom/tencent/mm/plugin/talkroom/a/b;
    //   6: getfield 132	com/tencent/mm/plugin/talkroom/a/b:pAk	Ljava/util/LinkedList;
    //   9: invokevirtual 150	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   12: astore 4
    //   14: aload 4
    //   16: invokeinterface 112 1 0
    //   21: ifeq +43 -> 64
    //   24: aload 4
    //   26: invokeinterface 116 1 0
    //   31: checkcast 152	com/tencent/mm/plugin/talkroom/a/a
    //   34: astore 5
    //   36: aload 5
    //   38: getfield 204	com/tencent/mm/plugin/talkroom/a/a:username	Ljava/lang/String;
    //   41: aload_1
    //   42: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifeq -31 -> 14
    //   48: aload 5
    //   50: getfield 156	com/tencent/mm/plugin/talkroom/a/a:sceneType	I
    //   53: istore_2
    //   54: iload_2
    //   55: ifne -41 -> 14
    //   58: iconst_1
    //   59: istore_3
    //   60: aload_0
    //   61: monitorexit
    //   62: iload_3
    //   63: ireturn
    //   64: iconst_0
    //   65: istore_3
    //   66: goto -6 -> 60
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	e
    //   0	74	1	paramString	String
    //   53	2	2	i	int
    //   59	7	3	bool	boolean
    //   12	13	4	localIterator	Iterator
    //   34	15	5	locala	com.tencent.mm.plugin.talkroom.a.a
    // Exception table:
    //   from	to	target	type
    //   2	14	69	finally
    //   14	54	69	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.e
 * JD-Core Version:    0.7.0.1
 */