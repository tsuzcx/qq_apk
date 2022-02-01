package com.tencent.mm.plugin.story.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/data/StoryUtil;", "", "()V", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String Qoo;
  public static final a Sjl;
  private static final String Sjm;
  private static final float Sjn;
  private static final String Sjo;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(118627);
    Sjl = new a((byte)0);
    TAG = "MicroMsg.StoryUtil";
    Sjm = "Locall_path";
    Sjn = -1000.0F;
    Qoo = "storyb";
    Sjo = "story_respone_count";
    AppMethodBeat.o(118627);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion;", "", "()V", "B_PRE", "", "INVALID_GEO", "", "getINVALID_GEO", "()F", "LOCAL_PATH_PRE", "getLOCAL_PATH_PRE", "()Ljava/lang/String;", "RESPONE_COUNT", "TAG", "bitmapAvailable", "", "bm", "Landroid/graphics/Bitmap;", "dumpMedia", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "exportVideo", "", "videoPath", "getFullStrSeq", "stringSeq", "getStoryResponeCount", "", "getVideoInfo", "Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion$VideoInfo;", "path", "getVideoMIME", "longToFullString", "seq", "", "longToString", "VideoInfo", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static String aXy(String paramString)
    {
      AppMethodBeat.i(118625);
      s.u(paramString, "stringSeq");
      paramString = new StringBuffer(paramString);
      while (paramString.length() < 25) {
        paramString.insert(0, "0");
      }
      paramString = paramString.toString();
      s.s(paramString, "sb.toString()");
      AppMethodBeat.o(118625);
      return paramString;
    }
    
    /* Error */
    public static String bbG(String paramString)
    {
      // Byte code:
      //   0: ldc 101
      //   2: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: ldc 102
      //   8: invokestatic 71	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: aload_0
      //   12: invokestatic 108	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   15: ifeq +11 -> 26
      //   18: ldc 101
      //   20: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   23: ldc 109
      //   25: areturn
      //   26: aconst_null
      //   27: astore_1
      //   28: new 111	com/tencent/mm/media/f/a
      //   31: dup
      //   32: aload_0
      //   33: invokespecial 112	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
      //   36: astore_0
      //   37: aload_0
      //   38: invokevirtual 115	com/tencent/mm/media/f/a:bpp	()Ljava/lang/String;
      //   41: astore_2
      //   42: aload_2
      //   43: astore_1
      //   44: aload_2
      //   45: ifnonnull +6 -> 51
      //   48: ldc 109
      //   50: astore_1
      //   51: aload_0
      //   52: invokevirtual 118	com/tencent/mm/media/f/a:release	()V
      //   55: ldc 101
      //   57: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   60: aload_1
      //   61: areturn
      //   62: astore_0
      //   63: aload_1
      //   64: astore_0
      //   65: aload_0
      //   66: ifnull +7 -> 73
      //   69: aload_0
      //   70: invokevirtual 118	com/tencent/mm/media/f/a:release	()V
      //   73: ldc 101
      //   75: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   78: ldc 109
      //   80: areturn
      //   81: astore_0
      //   82: aconst_null
      //   83: astore_1
      //   84: aload_1
      //   85: ifnull +7 -> 92
      //   88: aload_1
      //   89: invokevirtual 118	com/tencent/mm/media/f/a:release	()V
      //   92: ldc 101
      //   94: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public static String uB(long paramLong)
    {
      AppMethodBeat.i(118624);
      if (paramLong == 0L)
      {
        AppMethodBeat.o(118624);
        return "";
      }
      String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
      s.s(str, "big.toString()");
      str = aXy(str);
      AppMethodBeat.o(118624);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.e.b
 * JD-Core Version:    0.7.0.1
 */