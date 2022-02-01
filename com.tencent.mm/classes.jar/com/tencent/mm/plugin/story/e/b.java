package com.tencent.mm.plugin.story.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/data/StoryUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class b
{
  private static final String DEI = "storyb";
  public static final a FlA;
  private static final String Flx = "Locall_path";
  private static final float Fly = -1000.0F;
  private static final String Flz = "story_respone_count";
  private static final String TAG = "MicroMsg.StoryUtil";
  
  static
  {
    AppMethodBeat.i(118627);
    FlA = new a((byte)0);
    TAG = "MicroMsg.StoryUtil";
    Flx = "Locall_path";
    Fly = -1000.0F;
    DEI = "storyb";
    Flz = "story_respone_count";
    AppMethodBeat.o(118627);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion;", "", "()V", "B_PRE", "", "INVALID_GEO", "", "getINVALID_GEO", "()F", "LOCAL_PATH_PRE", "getLOCAL_PATH_PRE", "()Ljava/lang/String;", "RESPONE_COUNT", "TAG", "bitmapAvailable", "", "bm", "Landroid/graphics/Bitmap;", "dumpMedia", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "exportVideo", "", "videoPath", "getFullStrSeq", "stringSeq", "getStoryResponeCount", "", "getVideoInfo", "Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion$VideoInfo;", "path", "getVideoMIME", "longToFullString", "seq", "", "longToString", "VideoInfo", "plugin-story_release"})
  public static final class a
  {
    public static String Jc(long paramLong)
    {
      AppMethodBeat.i(118624);
      if (paramLong == 0L)
      {
        AppMethodBeat.o(118624);
        return "";
      }
      String str = Long.toBinaryString(paramLong);
      p.g(str, "java.lang.Long.toBinaryString(seq)");
      str = new BigInteger(str, 2).toString();
      p.g(str, "big.toString()");
      str = aOr(str);
      AppMethodBeat.o(118624);
      return str;
    }
    
    private static String aOr(String paramString)
    {
      AppMethodBeat.i(118625);
      p.h(paramString, "stringSeq");
      paramString = new StringBuffer(paramString);
      while (paramString.length() < 25) {
        paramString.insert(0, "0");
      }
      paramString = paramString.toString();
      p.g(paramString, "sb.toString()");
      AppMethodBeat.o(118625);
      return paramString;
    }
    
    /* Error */
    public static String aRO(String paramString)
    {
      // Byte code:
      //   0: ldc 119
      //   2: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: ldc 120
      //   8: invokestatic 97	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: aload_0
      //   12: invokestatic 126	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   15: ifeq +11 -> 26
      //   18: ldc 119
      //   20: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   23: ldc 65
      //   25: areturn
      //   26: aconst_null
      //   27: astore_1
      //   28: new 128	com/tencent/mm/media/f/a
      //   31: dup
      //   32: aload_0
      //   33: invokespecial 129	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
      //   36: astore_0
      //   37: aload_0
      //   38: invokevirtual 132	com/tencent/mm/media/f/a:aMs	()Ljava/lang/String;
      //   41: astore_2
      //   42: aload_2
      //   43: astore_1
      //   44: aload_2
      //   45: ifnonnull +6 -> 51
      //   48: ldc 65
      //   50: astore_1
      //   51: aload_0
      //   52: invokevirtual 135	com/tencent/mm/media/f/a:release	()V
      //   55: ldc 119
      //   57: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   60: aload_1
      //   61: areturn
      //   62: astore_0
      //   63: aload_1
      //   64: astore_0
      //   65: aload_0
      //   66: ifnull +7 -> 73
      //   69: aload_0
      //   70: invokevirtual 135	com/tencent/mm/media/f/a:release	()V
      //   73: ldc 119
      //   75: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   78: ldc 65
      //   80: areturn
      //   81: astore_0
      //   82: aconst_null
      //   83: astore_1
      //   84: aload_1
      //   85: ifnull +7 -> 92
      //   88: aload_1
      //   89: invokevirtual 135	com/tencent/mm/media/f/a:release	()V
      //   92: ldc 119
      //   94: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   97: aload_0
      //   98: athrow
      //   99: astore_1
      //   100: aload_0
      //   101: astore_2
      //   102: aload_1
      //   103: astore_0
      //   104: aload_2
      //   105: astore_1
      //   106: goto -22 -> 84
      //   109: astore_1
      //   110: goto -45 -> 65
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	113	0	paramString	String
      //   27	62	1	localObject1	Object
      //   99	4	1	localObject2	Object
      //   105	1	1	localObject3	Object
      //   109	1	1	localException	java.lang.Exception
      //   41	64	2	str	String
      // Exception table:
      //   from	to	target	type
      //   28	37	62	java/lang/Exception
      //   28	37	81	finally
      //   37	42	99	finally
      //   37	42	109	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.e.b
 * JD-Core Version:    0.7.0.1
 */