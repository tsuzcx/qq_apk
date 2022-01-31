package com.tencent.mm.plugin.story.model;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgr;
import java.util.HashMap;
import java.util.Vector;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "", "path", "", "(Ljava/lang/String;)V", "downLoadingScenes", "Ljava/util/HashMap;", "", "downLoadingSize", "getDownLoadingSize", "()I", "postLocks", "Ljava/util/Vector;", "queue", "Lcom/tencent/mm/protocal/protobuf/StoryAsyncQueue;", "releactionUploadScene", "selfName", "uploadLocks", "addDelItem", "", "snsId", "", "addDownLoadingId", "", "mediaId", "sceneKey", "addPostId", "mLocalId", "addUploadId", "checkNotDel", "checkQueue", "checkQueueImp", "checkSendComment", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StoryCommentToSend;", "fileToList", "getSceneHashCodeByUploadId", "uploadId", "getSelfName", "isDownloading", "isInSnsObj", "list", "Lcom/tencent/mm/protocal/protobuf/StoryCommentInfo;", "content", "createTime", "isPosting", "listToFile", "releationUploadScene", "uplocalid", "hashCode", "removeDelItem", "removeDelItemImp", "removeDownLoadingS", "removePostId", "removeReleationUploadScene", "uploadid", "removeUploadId", "setSelfName", "Companion", "plugin-story_release"})
public final class e
{
  private static final String FILE_NAME = "storyAsyncQueue.data";
  private static final String TAG = "MicroMsg.StoryAsyncQueueMgr";
  private static final String suA = "_AD_TAG_";
  public static final e.a suB;
  private static final int suz = 21600;
  private String dZZ;
  private final String path;
  private cgr suu;
  private final Vector<Integer> suv;
  private final HashMap<String, Integer> suw;
  private final Vector<Integer> sux;
  private final HashMap<Integer, Integer> suy;
  
  static
  {
    AppMethodBeat.i(109021);
    suB = new e.a((byte)0);
    TAG = "MicroMsg.StoryAsyncQueueMgr";
    FILE_NAME = "storyAsyncQueue.data";
    suz = 21600;
    suA = "_AD_TAG_";
    AppMethodBeat.o(109021);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(109020);
    this.path = paramString;
    this.dZZ = "";
    this.suv = new Vector();
    this.suw = new HashMap();
    this.sux = new Vector();
    this.suy = new HashMap();
    if (!coH()) {
      this.suu = new cgr();
    }
    this.suv.clear();
    this.suw.clear();
    AppMethodBeat.o(109020);
  }
  
  /* Error */
  private final boolean coH()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 168
    //   4: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 133	com/tencent/mm/plugin/story/model/e:path	Ljava/lang/String;
    //   11: iconst_0
    //   12: iconst_m1
    //   13: invokestatic 173	com/tencent/mm/vfs/e:i	(Ljava/lang/String;II)[B
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull +14 -> 32
    //   21: ldc 168
    //   23: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: iconst_0
    //   27: istore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: new 156	com/tencent/mm/protocal/protobuf/cgr
    //   35: dup
    //   36: invokespecial 157	com/tencent/mm/protocal/protobuf/cgr:<init>	()V
    //   39: aload_2
    //   40: invokevirtual 177	com/tencent/mm/protocal/protobuf/cgr:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnonnull +55 -> 100
    //   48: new 179	a/v
    //   51: dup
    //   52: ldc 181
    //   54: invokespecial 183	a/v:<init>	(Ljava/lang/String;)V
    //   57: astore_2
    //   58: ldc 168
    //   60: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_2
    //   64: athrow
    //   65: astore_2
    //   66: getstatic 111	com/tencent/mm/plugin/story/model/e:TAG	Ljava/lang/String;
    //   69: aload_2
    //   70: checkcast 185	java/lang/Throwable
    //   73: ldc 134
    //   75: iconst_0
    //   76: anewarray 4	java/lang/Object
    //   79: invokestatic 191	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload_0
    //   83: getfield 133	com/tencent/mm/plugin/story/model/e:path	Ljava/lang/String;
    //   86: invokestatic 195	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   89: pop
    //   90: ldc 168
    //   92: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: iconst_0
    //   96: istore_1
    //   97: goto -69 -> 28
    //   100: aload_0
    //   101: aload_2
    //   102: checkcast 156	com/tencent/mm/protocal/protobuf/cgr
    //   105: putfield 159	com/tencent/mm/plugin/story/model/e:suu	Lcom/tencent/mm/protocal/protobuf/cgr;
    //   108: iconst_1
    //   109: istore_1
    //   110: ldc 168
    //   112: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: goto -87 -> 28
    //   118: astore_2
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_2
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	e
    //   27	83	1	bool	boolean
    //   16	48	2	localObject1	Object
    //   65	37	2	localIOException	java.io.IOException
    //   118	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	44	65	java/io/IOException
    //   48	65	65	java/io/IOException
    //   100	108	65	java/io/IOException
    //   2	17	118	finally
    //   21	26	118	finally
    //   32	44	118	finally
    //   48	65	118	finally
    //   66	95	118	finally
    //   100	108	118	finally
    //   110	115	118	finally
  }
  
  public final boolean DI(int paramInt)
  {
    try
    {
      AppMethodBeat.i(109019);
      this.suv.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(109019);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.e
 * JD-Core Version:    0.7.0.1
 */