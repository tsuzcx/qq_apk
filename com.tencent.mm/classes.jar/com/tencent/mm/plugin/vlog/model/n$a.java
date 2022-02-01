package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial$Companion;", "", "()V", "CropMinDuration", "", "ImageSourceDuration", "MaxHeight", "", "MaxWidth", "TAG", "", "TypeImage", "TypeVideo", "VideoTrackMaxDuration", "asyncSourceToTrackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "sources", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFromPath", "paths", "types", "sourceFrom", "images", "videos", "indices", "", "createImageSource", "Lcom/tencent/mm/plugin/vlog/model/ImageSource;", "path", "createVideoSource", "Lcom/tencent/mm/plugin/vlog/model/VideoSource;", "getImageRotate", "sourceToTrack", "source", "(Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-vlog_release"})
public final class n$a
{
  /* Error */
  static int ayh(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: ldc 58
    //   6: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 70	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnull +84 -> 99
    //   18: aload_0
    //   19: checkcast 72	java/io/Closeable
    //   22: astore_3
    //   23: new 74	android/support/e/a
    //   26: dup
    //   27: aload_3
    //   28: checkcast 76	java/io/InputStream
    //   31: invokespecial 79	android/support/e/a:<init>	(Ljava/io/InputStream;)V
    //   34: astore_0
    //   35: getstatic 85	d/y:KTp	Ld/y;
    //   38: astore 4
    //   40: aload_3
    //   41: aconst_null
    //   42: invokestatic 90	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   45: aload_0
    //   46: ifnull +13 -> 59
    //   49: aload_0
    //   50: ldc 92
    //   52: invokevirtual 95	android/support/e/a:m	(Ljava/lang/String;)I
    //   55: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnonnull +44 -> 104
    //   63: aload_1
    //   64: ifnonnull +57 -> 121
    //   67: aload_1
    //   68: ifnonnull +70 -> 138
    //   71: ldc 58
    //   73: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: iconst_0
    //   77: ireturn
    //   78: astore_1
    //   79: ldc 58
    //   81: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_1
    //   85: athrow
    //   86: astore_0
    //   87: aload_3
    //   88: aload_1
    //   89: invokestatic 90	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   92: ldc 58
    //   94: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: athrow
    //   99: aconst_null
    //   100: astore_0
    //   101: goto -56 -> 45
    //   104: aload_1
    //   105: invokevirtual 108	java/lang/Integer:intValue	()I
    //   108: bipush 6
    //   110: if_icmpne -47 -> 63
    //   113: ldc 58
    //   115: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: bipush 90
    //   120: ireturn
    //   121: aload_1
    //   122: invokevirtual 108	java/lang/Integer:intValue	()I
    //   125: iconst_3
    //   126: if_icmpne -59 -> 67
    //   129: ldc 58
    //   131: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: sipush 180
    //   137: ireturn
    //   138: aload_1
    //   139: invokevirtual 108	java/lang/Integer:intValue	()I
    //   142: bipush 8
    //   144: if_icmpne -73 -> 71
    //   147: ldc 58
    //   149: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: sipush 270
    //   155: ireturn
    //   156: astore_0
    //   157: aload_2
    //   158: astore_1
    //   159: goto -72 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   3	65	1	localInteger	java.lang.Integer
    //   78	61	1	localThrowable	Throwable
    //   158	1	1	localObject1	Object
    //   1	157	2	localObject2	Object
    //   22	66	3	localCloseable	java.io.Closeable
    //   38	1	4	localy	d.y
    // Exception table:
    //   from	to	target	type
    //   23	40	78	java/lang/Throwable
    //   79	86	86	finally
    //   23	40	156	finally
  }
  
  public static aa ayi(String paramString)
  {
    AppMethodBeat.i(207550);
    k.h(paramString, "path");
    for (;;)
    {
      try
      {
        Object localObject = l.AnC;
        localObject = l.aye(paramString);
        if (localObject == null) {
          continue;
        }
        i = ((l.a)localObject).width;
        j = ((l.a)localObject).height;
        l = ((l.a)localObject).duration;
        k = ((l.a)localObject).duc;
        if (k == 90) {
          break label115;
        }
        if (k != 270) {
          break label112;
        }
      }
      catch (Exception paramString)
      {
        long l;
        b.printErrStackTrace(n.access$getTAG$cp(), (Throwable)paramString, "createVideoSource error", new Object[0]);
        AppMethodBeat.o(207550);
        return null;
      }
      paramString = new aa(i, j, paramString, l);
      AppMethodBeat.o(207550);
      return paramString;
      label112:
      continue;
      label115:
      int k = i;
      int i = j;
      int j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.n.a
 * JD-Core Version:    0.7.0.1
 */