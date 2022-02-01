package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fhz;
import java.util.HashMap;
import java.util.Vector;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "", "path", "", "(Ljava/lang/String;)V", "downLoadingScenes", "Ljava/util/HashMap;", "", "downLoadingSize", "getDownLoadingSize", "()I", "postLocks", "Ljava/util/Vector;", "queue", "Lcom/tencent/mm/protocal/protobuf/StoryAsyncQueue;", "releactionUploadScene", "selfName", "uploadLocks", "addDelItem", "", "snsId", "", "addDownLoadingId", "", "mediaId", "sceneKey", "addPostId", "mLocalId", "addUploadId", "checkNotDel", "checkQueue", "checkQueueImp", "checkSendComment", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StoryCommentToSend;", "fileToList", "getSceneHashCodeByUploadId", "uploadId", "getSelfName", "isDownloading", "isInSnsObj", "list", "Lcom/tencent/mm/protocal/protobuf/StoryCommentInfo;", "content", "createTime", "isPosting", "listToFile", "releationUploadScene", "uplocalid", "hashCode", "removeDelItem", "removeDelItemImp", "removeDownLoadingS", "removePostId", "removeReleationUploadScene", "uploadid", "removeUploadId", "setSelfName", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final String FILE_NAME;
  public static final a SjB;
  private static final int SjH;
  private static final String SjI;
  private static final String TAG;
  private fhz SjC;
  private final Vector<Integer> SjD;
  private final HashMap<String, Integer> SjE;
  private final Vector<Integer> SjF;
  private final HashMap<Integer, Integer> SjG;
  private String ltf;
  private final String path;
  
  static
  {
    AppMethodBeat.i(118651);
    SjB = new a((byte)0);
    TAG = "MicroMsg.StoryAsyncQueueMgr";
    FILE_NAME = "storyAsyncQueue.data";
    SjH = 21600;
    SjI = "_AD_TAG_";
    AppMethodBeat.o(118651);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(118650);
    this.path = paramString;
    this.ltf = "";
    this.SjD = new Vector();
    this.SjE = new HashMap();
    this.SjF = new Vector();
    this.SjG = new HashMap();
    if (!hfV()) {
      this.SjC = new fhz();
    }
    this.SjD.clear();
    this.SjE.clear();
    AppMethodBeat.o(118650);
  }
  
  /* Error */
  private final boolean hfV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 169
    //   4: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 136	com/tencent/mm/plugin/story/model/e:path	Ljava/lang/String;
    //   11: iconst_0
    //   12: iconst_m1
    //   13: invokestatic 175	com/tencent/mm/vfs/y:bi	(Ljava/lang/String;II)[B
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull +14 -> 32
    //   21: ldc 169
    //   23: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: iconst_0
    //   27: istore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: new 159	com/tencent/mm/protocal/protobuf/fhz
    //   35: dup
    //   36: invokespecial 160	com/tencent/mm/protocal/protobuf/fhz:<init>	()V
    //   39: aload_2
    //   40: invokevirtual 179	com/tencent/mm/protocal/protobuf/fhz:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnonnull +55 -> 100
    //   48: new 181	java/lang/NullPointerException
    //   51: dup
    //   52: ldc 183
    //   54: invokespecial 185	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   57: astore_2
    //   58: ldc 169
    //   60: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_2
    //   64: athrow
    //   65: astore_2
    //   66: getstatic 110	com/tencent/mm/plugin/story/model/e:TAG	Ljava/lang/String;
    //   69: aload_2
    //   70: checkcast 187	java/lang/Throwable
    //   73: ldc 137
    //   75: iconst_0
    //   76: anewarray 4	java/lang/Object
    //   79: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload_0
    //   83: getfield 136	com/tencent/mm/plugin/story/model/e:path	Ljava/lang/String;
    //   86: invokestatic 197	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   89: pop
    //   90: ldc 169
    //   92: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: iconst_0
    //   96: istore_1
    //   97: goto -69 -> 28
    //   100: aload_0
    //   101: aload_2
    //   102: checkcast 159	com/tencent/mm/protocal/protobuf/fhz
    //   105: putfield 162	com/tencent/mm/plugin/story/model/e:SjC	Lcom/tencent/mm/protocal/protobuf/fhz;
    //   108: iconst_1
    //   109: istore_1
    //   110: ldc 169
    //   112: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final boolean akC(int paramInt)
  {
    try
    {
      AppMethodBeat.i(118649);
      this.SjD.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(118649);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr$Companion;", "", "()V", "AD_CMD_TAG", "", "getAD_CMD_TAG", "()Ljava/lang/String;", "EXPIRES", "", "FILE_NAME", "getFILE_NAME", "TAG", "getTAG", "fromAcitonToCommentInfo", "Lcom/tencent/mm/protocal/protobuf/StoryCommentInfo;", "isAdCmd", "", "clientId", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.e
 * JD-Core Version:    0.7.0.1
 */