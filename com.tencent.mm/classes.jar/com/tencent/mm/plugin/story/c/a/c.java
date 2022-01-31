package com.tencent.mm.plugin.story.c.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.i.d.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "()V", "RECORDER_TYPE_FFMPEG", "", "RECORDER_TYPE_MEDIACODEC", "TAG", "", "getTAG", "()Ljava/lang/String;", "findVideoFps", "path", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "EncodeConfig", "plugin-story_release"})
public final class c
  extends com.tencent.mm.plugin.story.c.c<c.a>
{
  private static final String TAG = "MicroMsg.StoryEncodeElementConfig";
  public static final c srQ;
  
  static
  {
    AppMethodBeat.i(108967);
    srQ = new c();
    TAG = "MicroMsg.StoryEncodeElementConfig";
    AppMethodBeat.o(108967);
  }
  
  /* Error */
  private static int acC(String paramString)
  {
    // Byte code:
    //   0: ldc 62
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 64	android/media/MediaExtractor
    //   8: dup
    //   9: invokespecial 65	android/media/MediaExtractor:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: astore_3
    //   17: aload 4
    //   19: aload_0
    //   20: invokevirtual 69	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: invokevirtual 73	android/media/MediaExtractor:getTrackCount	()I
    //   31: istore_2
    //   32: iconst_0
    //   33: istore_1
    //   34: iload_1
    //   35: iload_2
    //   36: if_icmpge +209 -> 245
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: iload_1
    //   45: invokevirtual 77	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   48: astore_0
    //   49: aload 4
    //   51: astore_3
    //   52: aload_0
    //   53: ldc 79
    //   55: invokevirtual 85	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   58: ifeq +192 -> 250
    //   61: aload 4
    //   63: astore_3
    //   64: aload_0
    //   65: ldc 79
    //   67: invokevirtual 89	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: invokestatic 94	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   73: ifeq +6 -> 79
    //   76: goto +174 -> 250
    //   79: aload 4
    //   81: astore_3
    //   82: aload_0
    //   83: ldc 79
    //   85: invokevirtual 89	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   88: astore 5
    //   90: aload 4
    //   92: astore_3
    //   93: getstatic 52	com/tencent/mm/plugin/story/c/a/c:TAG	Ljava/lang/String;
    //   96: ldc 96
    //   98: iconst_1
    //   99: anewarray 98	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload 5
    //   106: aastore
    //   107: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload 4
    //   112: astore_3
    //   113: aload 5
    //   115: ldc 79
    //   117: invokestatic 109	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   120: aload 4
    //   122: astore_3
    //   123: aload 5
    //   125: ldc 111
    //   127: invokestatic 117	a/l/m:jw	(Ljava/lang/String;Ljava/lang/String;)Z
    //   130: ifeq +120 -> 250
    //   133: aload 4
    //   135: astore_3
    //   136: aload_0
    //   137: ldc 119
    //   139: invokevirtual 122	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   142: istore_1
    //   143: aload 4
    //   145: astore_3
    //   146: getstatic 52	com/tencent/mm/plugin/story/c/a/c:TAG	Ljava/lang/String;
    //   149: ldc 124
    //   151: iconst_1
    //   152: anewarray 98	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: iload_1
    //   158: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: aastore
    //   162: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aload 4
    //   167: invokevirtual 133	android/media/MediaExtractor:release	()V
    //   170: ldc 62
    //   172: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: iload_1
    //   176: ireturn
    //   177: astore 5
    //   179: aconst_null
    //   180: astore_0
    //   181: aload_0
    //   182: astore_3
    //   183: getstatic 52	com/tencent/mm/plugin/story/c/a/c:TAG	Ljava/lang/String;
    //   186: aload 5
    //   188: checkcast 135	java/lang/Throwable
    //   191: ldc 137
    //   193: iconst_0
    //   194: anewarray 98	java/lang/Object
    //   197: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload_0
    //   201: ifnull +7 -> 208
    //   204: aload_0
    //   205: invokevirtual 133	android/media/MediaExtractor:release	()V
    //   208: ldc 62
    //   210: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: iconst_0
    //   214: ireturn
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_3
    //   218: aload_3
    //   219: ifnull +7 -> 226
    //   222: aload_3
    //   223: invokevirtual 133	android/media/MediaExtractor:release	()V
    //   226: ldc 62
    //   228: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aload_0
    //   232: athrow
    //   233: astore_0
    //   234: goto -16 -> 218
    //   237: astore 5
    //   239: aload 4
    //   241: astore_0
    //   242: goto -61 -> 181
    //   245: iconst_0
    //   246: istore_1
    //   247: goto -82 -> 165
    //   250: iload_1
    //   251: iconst_1
    //   252: iadd
    //   253: istore_1
    //   254: goto -220 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramString	String
    //   33	221	1	i	int
    //   31	6	2	j	int
    //   16	207	3	localObject	Object
    //   12	228	4	localMediaExtractor	android.media.MediaExtractor
    //   88	36	5	str	String
    //   177	10	5	localException1	java.lang.Exception
    //   237	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   5	14	177	java/lang/Exception
    //   5	14	215	finally
    //   17	23	233	finally
    //   26	32	233	finally
    //   42	49	233	finally
    //   52	61	233	finally
    //   64	76	233	finally
    //   82	90	233	finally
    //   93	110	233	finally
    //   113	120	233	finally
    //   123	133	233	finally
    //   136	143	233	finally
    //   146	165	233	finally
    //   183	200	233	finally
    //   17	23	237	java/lang/Exception
    //   26	32	237	java/lang/Exception
    //   42	49	237	java/lang/Exception
    //   52	61	237	java/lang/Exception
    //   64	76	237	java/lang/Exception
    //   82	90	237	java/lang/Exception
    //   93	110	237	java/lang/Exception
    //   113	120	237	java/lang/Exception
    //   123	133	237	java/lang/Exception
    //   136	143	237	java/lang/Exception
    //   146	165	237	java/lang/Exception
  }
  
  public final void Uv()
  {
    AppMethodBeat.i(108965);
    Object localObject1 = (c.a)Ut();
    Object localObject2 = com.tencent.mm.plugin.story.proxy.d.sDB;
    com.tencent.mm.plugin.story.proxy.d.cCz();
    localObject2 = com.tencent.mm.plugin.story.proxy.d.getVideoPara();
    j.q(localObject2, "<set-?>");
    ((c.a)localObject1).qbq = ((VideoTransPara)localObject2);
    localObject1 = ((c.a)Ut()).qbq;
    ((c.a)Ut()).eRu = ((VideoTransPara)localObject1).width;
    localObject2 = (c.a)Ut();
    d.a locala = com.tencent.mm.media.i.d.eZG;
    ((c.a)localObject2).eRv = d.a.ka(((VideoTransPara)localObject1).width);
    if (((c.a)Ut()).eRv % 16 != 0) {
      ((c.a)Ut()).eRv = com.tencent.mm.plugin.mmsight.d.zn(((c.a)Ut()).eRv);
    }
    if (((c.a)Ut()).eRu % 16 != 0) {
      ((c.a)Ut()).eRu = com.tencent.mm.plugin.mmsight.d.zn(((c.a)Ut()).eRu);
    }
    ((c.a)Ut()).qbq.width = ((c.a)Ut()).eRu;
    ((c.a)Ut()).qbq.height = ((c.a)Ut()).eRv;
    ((c.a)Ut()).videoBitrate = ((VideoTransPara)localObject1).videoBitrate;
    ((c.a)Ut()).fzT = ((VideoTransPara)localObject1).fzT;
    ((c.a)Ut()).eRw = ((VideoTransPara)localObject1).fps;
    ((c.a)Ut()).fzU = ((VideoTransPara)localObject1).fzU;
    ((c.a)Ut()).duration = ((VideoTransPara)localObject1).duration;
    ((c.a)Ut()).fzW = ((VideoTransPara)localObject1).fzW;
    ((c.a)Ut()).fzV = ((VideoTransPara)localObject1).fzV;
    ((c.a)Ut()).isDefault = ((VideoTransPara)localObject1).isDefault;
    ((c.a)Ut()).fAg = ((VideoTransPara)localObject1).fAg;
    ((c.a)Ut()).audioSampleRate = ((VideoTransPara)localObject1).audioSampleRate;
    localObject1 = (c.a)Ut();
    j.q("StoryCheckSendVideoBitrateLimit", "key");
    if (ah.brt())
    {
      localObject2 = g.E(a.class);
      j.p(localObject2, "MMKernel.service<IConfig…onfigService::class.java)");
    }
    for (float f = bo.getFloat(((a)localObject2).Nq().getValue("StoryCheckSendVideoBitrateLimit"), 1.3F);; f = bo.getFloat(CaptureMMProxy.getInstance().getDynamicConfig("StoryCheckSendVideoBitrateLimit"), 1.3F))
    {
      ((c.a)localObject1).srR = f;
      if (ac.erC.eqK != -1) {
        ((c.a)Ut()).eqK = ac.erC.eqK;
      }
      if (bp.dud())
      {
        localObject1 = (c.a)Ut();
        localObject2 = g.RL();
        j.p(localObject2, "MMKernel.storage()");
        ((c.a)localObject1).eqK = ((com.tencent.mm.kernel.e)localObject2).Ru().getInt(ac.a.yJF, 2);
      }
      ab.i(TAG, "loadConfigFromVideoParam: " + (c.a)Ut());
      AppMethodBeat.o(108965);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.c
 * JD-Core Version:    0.7.0.1
 */