package com.tencent.mm.plugin.story.e;

import a.f.b.j;
import a.l;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.af;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion;", "", "()V", "B_PRE", "", "INVALID_GEO", "", "getINVALID_GEO", "()F", "LOCAL_PATH_PRE", "getLOCAL_PATH_PRE", "()Ljava/lang/String;", "RESPONE_COUNT", "TAG", "bitmapAvailable", "", "bm", "Landroid/graphics/Bitmap;", "dumpMedia", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "exportVideo", "", "videoPath", "getFullStrSeq", "stringSeq", "getStoryResponeCount", "", "getVideoInfo", "Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion$VideoInfo;", "path", "getVideoMIME", "longToFullString", "seq", "", "longToString", "VideoInfo", "plugin-story_release"})
public final class c$a
{
  public static void acM(String paramString)
  {
    AppMethodBeat.i(108994);
    j.q(paramString, "videoPath");
    if (g.RL().Ru().getBoolean(ac.a.yEJ, true))
    {
      String str = com.tencent.mm.plugin.mmsight.d.TY("mp4");
      j.p(str, "MMSightUtil.getExportImagePath(\"mp4\")");
      ab.i(c.access$getTAG$cp(), "auto save " + paramString + " exportPath " + str, new Object[] { paramString, str });
      com.tencent.mm.vfs.e.C(paramString, str);
      q.a(str, ah.getContext());
    }
    AppMethodBeat.o(108994);
  }
  
  public static c.a.a acN(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(108995);
    j.q(paramString, "path");
    a locala = com.tencent.mm.plugin.sight.base.d.Zo(paramString);
    if (locala == null)
    {
      AppMethodBeat.o(108995);
      return null;
    }
    if ((locala.height <= 0) || (locala.width <= 0)) {}
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      locala.width = bo.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
      locala.height = bo.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
      locala.videoBitrate = bo.getInt(localMediaMetadataRetriever.extractMetadata(20), 0);
      localMediaMetadataRetriever.release();
      label116:
      int k = SightVideoJNI.getMp4Rotate(paramString);
      paramString = af.hQ(ah.getContext());
      int j;
      int i;
      if ((k == 270) || (k == 90))
      {
        j = 1;
        if (j == 0) {
          break label239;
        }
        i = locala.height;
        label153:
        if (j == 0) {
          break label248;
        }
        j = locala.width;
        label163:
        if (Math.abs(i / j - paramString.x / paramString.y) > 0.01D) {
          break label257;
        }
      }
      for (;;)
      {
        paramString = new c.a.a(locala.width, locala.height, locala.eVA, k, locala.videoBitrate, locala.eRw, bool);
        AppMethodBeat.o(108995);
        return paramString;
        j = 0;
        break;
        label239:
        i = locala.width;
        break label153;
        label248:
        j = locala.height;
        break label163;
        label257:
        bool = false;
      }
    }
    catch (Exception localException)
    {
      break label116;
    }
  }
  
  /* Error */
  public static String acO(String paramString)
  {
    // Byte code:
    //   0: ldc 232
    //   2: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 156
    //   8: invokestatic 70	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokestatic 236	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   15: ifeq +11 -> 26
    //   18: ldc 232
    //   20: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: ldc 237
    //   25: areturn
    //   26: aconst_null
    //   27: astore_1
    //   28: new 239	com/tencent/mm/media/e/a
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 240	com/tencent/mm/media/e/a:<init>	(Ljava/lang/String;)V
    //   36: astore_0
    //   37: aload_0
    //   38: invokevirtual 243	com/tencent/mm/media/e/a:UV	()Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: ifnonnull +6 -> 51
    //   48: ldc 237
    //   50: astore_1
    //   51: aload_0
    //   52: invokevirtual 244	com/tencent/mm/media/e/a:release	()V
    //   55: ldc 232
    //   57: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_1
    //   61: areturn
    //   62: astore_0
    //   63: aload_1
    //   64: astore_0
    //   65: aload_0
    //   66: ifnull +7 -> 73
    //   69: aload_0
    //   70: invokevirtual 244	com/tencent/mm/media/e/a:release	()V
    //   73: ldc 232
    //   75: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: ldc 237
    //   80: areturn
    //   81: astore_0
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 244	com/tencent/mm/media/e/a:release	()V
    //   92: ldc 232
    //   94: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   109	1	1	localException	Exception
    //   41	64	2	str	String
    // Exception table:
    //   from	to	target	type
    //   28	37	62	java/lang/Exception
    //   28	37	81	finally
    //   37	42	99	finally
    //   37	42	109	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.e.c.a
 * JD-Core Version:    0.7.0.1
 */