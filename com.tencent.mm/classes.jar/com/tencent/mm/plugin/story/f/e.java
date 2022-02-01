package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.enb;
import java.util.HashMap;
import java.util.Vector;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "", "path", "", "(Ljava/lang/String;)V", "downLoadingScenes", "Ljava/util/HashMap;", "", "downLoadingSize", "getDownLoadingSize", "()I", "postLocks", "Ljava/util/Vector;", "queue", "Lcom/tencent/mm/protocal/protobuf/StoryAsyncQueue;", "releactionUploadScene", "selfName", "uploadLocks", "addDelItem", "", "snsId", "", "addDownLoadingId", "", "mediaId", "sceneKey", "addPostId", "mLocalId", "addUploadId", "checkNotDel", "checkQueue", "checkQueueImp", "checkSendComment", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StoryCommentToSend;", "fileToList", "getSceneHashCodeByUploadId", "uploadId", "getSelfName", "isDownloading", "isInSnsObj", "list", "Lcom/tencent/mm/protocal/protobuf/StoryCommentInfo;", "content", "createTime", "isPosting", "listToFile", "releationUploadScene", "uplocalid", "hashCode", "removeDelItem", "removeDelItemImp", "removeDownLoadingS", "removePostId", "removeReleationUploadScene", "uploadid", "removeUploadId", "setSelfName", "Companion", "plugin-story_release"})
public final class e
{
  private static final String FILE_NAME = "storyAsyncQueue.data";
  private static final int LFV = 21600;
  private static final String LFW = "_AD_TAG_";
  public static final a LFX;
  private static final String TAG = "MicroMsg.StoryAsyncQueueMgr";
  private enb LFQ;
  private final Vector<Integer> LFR;
  private final HashMap<String, Integer> LFS;
  private final Vector<Integer> LFT;
  private final HashMap<Integer, Integer> LFU;
  private String iRj;
  private final String path;
  
  static
  {
    AppMethodBeat.i(118651);
    LFX = new a((byte)0);
    TAG = "MicroMsg.StoryAsyncQueueMgr";
    FILE_NAME = "storyAsyncQueue.data";
    LFV = 21600;
    LFW = "_AD_TAG_";
    AppMethodBeat.o(118651);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(118650);
    this.path = paramString;
    this.iRj = "";
    this.LFR = new Vector();
    this.LFS = new HashMap();
    this.LFT = new Vector();
    this.LFU = new HashMap();
    if (!fOj()) {
      this.LFQ = new enb();
    }
    this.LFR.clear();
    this.LFS.clear();
    AppMethodBeat.o(118650);
  }
  
  /* Error */
  private final boolean fOj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 167
    //   4: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 134	com/tencent/mm/plugin/story/f/e:path	Ljava/lang/String;
    //   11: iconst_0
    //   12: iconst_m1
    //   13: invokestatic 173	com/tencent/mm/vfs/u:aY	(Ljava/lang/String;II)[B
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull +14 -> 32
    //   21: ldc 167
    //   23: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: iconst_0
    //   27: istore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: new 157	com/tencent/mm/protocal/protobuf/enb
    //   35: dup
    //   36: invokespecial 158	com/tencent/mm/protocal/protobuf/enb:<init>	()V
    //   39: aload_2
    //   40: invokevirtual 177	com/tencent/mm/protocal/protobuf/enb:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnonnull +55 -> 100
    //   48: new 179	kotlin/t
    //   51: dup
    //   52: ldc 181
    //   54: invokespecial 183	kotlin/t:<init>	(Ljava/lang/String;)V
    //   57: astore_2
    //   58: ldc 167
    //   60: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_2
    //   64: athrow
    //   65: astore_2
    //   66: getstatic 112	com/tencent/mm/plugin/story/f/e:TAG	Ljava/lang/String;
    //   69: aload_2
    //   70: checkcast 185	java/lang/Throwable
    //   73: ldc 135
    //   75: iconst_0
    //   76: anewarray 4	java/lang/Object
    //   79: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload_0
    //   83: getfield 134	com/tencent/mm/plugin/story/f/e:path	Ljava/lang/String;
    //   86: invokestatic 195	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   89: pop
    //   90: ldc 167
    //   92: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: iconst_0
    //   96: istore_1
    //   97: goto -69 -> 28
    //   100: aload_0
    //   101: aload_2
    //   102: checkcast 157	com/tencent/mm/protocal/protobuf/enb
    //   105: putfield 160	com/tencent/mm/plugin/story/f/e:LFQ	Lcom/tencent/mm/protocal/protobuf/enb;
    //   108: iconst_1
    //   109: istore_1
    //   110: ldc 167
    //   112: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final boolean afN(int paramInt)
  {
    try
    {
      AppMethodBeat.i(118649);
      this.LFR.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(118649);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr$Companion;", "", "()V", "AD_CMD_TAG", "", "getAD_CMD_TAG", "()Ljava/lang/String;", "EXPIRES", "", "FILE_NAME", "getFILE_NAME", "TAG", "getTAG", "fromAcitonToCommentInfo", "Lcom/tencent/mm/protocal/protobuf/StoryCommentInfo;", "isAdCmd", "", "clientId", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.e
 * JD-Core Version:    0.7.0.1
 */