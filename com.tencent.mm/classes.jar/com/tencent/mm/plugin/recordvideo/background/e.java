package com.tencent.mm.plugin.recordvideo.background;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.j;
import com.tencent.mm.media.i.j.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.recordvideo.PluginVideoEditor;
import com.tencent.mm.plugin.recordvideo.e.d.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.k;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.edo;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil;", "", "()V", "TAG", "", "damp", "", "getDamp", "()I", "setDamp", "(I)V", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "validAreaRect", "getValidAreaRect", "setValidAreaRect", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "visibleRect", "getVisibleRect", "checkMD5", "", "file", "destMD5", "cleanExpiredTask", "", "cleanNullData", "taskId", "cleanUnAvailableData", "convertBundleToJson", "bundle", "Landroid/os/Bundle;", "convertJsonToBundle", "jsonStr", "getAudioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "storyEditorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getLastDataIfNoMix", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "limitTime", "", "getRemuxTask", "getStoryCaptureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "getStoryDataEditorItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "baseItemData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "context", "Landroid/content/Context;", "getStoryFileMD5", "Lcom/tencent/mm/protocal/protobuf/StoryEditorFileMD5;", "getUserData", "insertRemuxTask", "videoMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "editorData", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "extraConfig", "expiredTime", "blurBgPath", "scene", "", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "onUnSerializeStoryDataDrawingRect", "", "onUnSerializeStoryDataValidRect", "reStartMix", "reshowEmojiEditorItem", "emojiItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "reshowEmojiItem", "itemLayout", "Landroid/view/ViewGroup;", "item", "reshowLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "reshowLyricsItem", "reshowPositionEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "reshowPositionItem", "reshowStoryDataEditorItem", "reshowStoryDataEditorItemFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "targetWidth", "targetHeight", "targetRotation", "reshowTextEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "reshowTextItem", "reshowTipEditorItem", "reshowTipItem", "serializeStoryDataToByteArray", "timeStamp", "signVideoMixTime", "updateByLocal", "editData", "updateRemuxTaskState", "state", "plugin-recordvideo_release"})
public final class e
{
  private static final d BJm;
  private static Rect BKm;
  private static Rect BKn;
  private static int BKo;
  public static final e BKp;
  private static final Rect vPN;
  
  static
  {
    AppMethodBeat.i(75216);
    BKp = new e();
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ah(PluginVideoEditor.class);
    kotlin.g.b.p.g(locala, "MMKernel.plugin(PluginVideoEditor::class.java)");
    BJm = ((PluginVideoEditor)locala).getVideoEditorDataStorage();
    BKm = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    BKn = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    vPN = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    BKo = 54;
    AppMethodBeat.o(75216);
  }
  
  public static com.tencent.mm.plugin.recordvideo.ui.editor.b.g a(aio paramaio, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(237239);
    kotlin.g.b.p.h(paramaio, "storyEditorProtoData");
    kotlin.g.b.p.h(paramContext, "context");
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story as frame retriever");
    List localList = (List)new ArrayList();
    Object localObject1 = paramaio.Lna;
    kotlin.g.b.p.g(localObject1, "storyEditorProtoData.baseItemData");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (jn)localIterator.next();
      int i = ((jn)localObject1).dataType;
      Object localObject2;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeK.value)
      {
        kotlin.g.b.p.g(localObject1, "it");
        localObject1 = new q((jn)localObject1);
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
        if (!((q)localObject1).isValid()) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject2).c(null))
        {
          if (localObject1 == null) {
            break label185;
          }
          localList.add(localObject1);
          break;
          localObject2 = new r(paramContext);
          ((r)localObject2).b((q)localObject1);
        }
      }
      else
      {
        label185:
        if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeL.value)
        {
          kotlin.g.b.p.g(localObject1, "it");
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jn)localObject1);
          Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the emoji editor item");
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f(paramContext);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject2).a((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1);
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject2).c(null);
          if (localObject1 != null) {
            localList.add(localObject1);
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeM.value)
        {
          kotlin.g.b.p.g(localObject1, "it");
          localObject1 = new k((jn)localObject1);
          Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.p(paramContext);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject2).a((k)localObject1);
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject2).c(null);
          if (localObject1 != null) {
            localList.add(localObject1);
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeN.value)
        {
          kotlin.g.b.p.g(localObject1, "it");
          localObject1 = new q((jn)localObject1);
          Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
          if (!((q)localObject1).isValid()) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject2).c(null))
          {
            if (localObject1 == null) {
              break label448;
            }
            localList.add(localObject1);
            break;
            localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.s(paramContext);
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject2).b((q)localObject1);
          }
        }
        else
        {
          label448:
          if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeO.value)
          {
            long l1 = paramaio.endTime;
            long l2 = paramaio.startTime;
            kotlin.g.b.p.g(localObject1, "it");
            localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.l((jn)localObject1);
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.l)localObject1).Ij(l1 - l2);
            Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
            localObject2 = new m(paramContext);
            ((m)localObject2).a((com.tencent.mm.plugin.recordvideo.ui.editor.item.l)localObject1);
            localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject2).c(null);
            if (localObject1 != null) {
              localList.add(localObject1);
            }
          }
        }
      }
    }
    if (localList.size() == 0)
    {
      AppMethodBeat.o(237239);
      return null;
    }
    if ((paramInt2 == 0) || (paramInt1 == 0))
    {
      Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "error width " + paramInt1 + " height " + paramInt2);
      AppMethodBeat.o(237239);
      return null;
    }
    paramContext = com.tencent.mm.plugin.recordvideo.e.d.Cin;
    paramContext = paramaio.videoPath;
    kotlin.g.b.p.g(paramContext, "storyEditorProtoData.videoPath");
    paramContext = com.tencent.mm.plugin.recordvideo.e.d.aLQ(paramContext);
    if ((!paramaio.iqf) && (paramContext != null) && (!paramContext.Cio))
    {
      paramaio = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(b(paramaio), c(paramaio), localList, paramInt1, paramInt2, paramContext.width, paramContext.height, paramInt3, false, null, 768));
      AppMethodBeat.o(237239);
      return paramaio;
    }
    paramaio = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(b(paramaio), c(paramaio), localList, paramInt1, paramInt2, 0, 0, paramInt3, false, null, 768));
    AppMethodBeat.o(237239);
    return paramaio;
  }
  
  private static edo a(aio paramaio)
  {
    AppMethodBeat.i(75207);
    kotlin.g.b.p.h(paramaio, "storyEditorProtoData");
    edo localedo = new edo();
    localedo.NdT = com.tencent.mm.vfs.s.bhK(paramaio.LrT);
    localedo.NdS = com.tencent.mm.vfs.s.bhK(paramaio.iiv);
    if (!Util.isNullOrNil((List)paramaio.Lsc))
    {
      localedo.NdR = "";
      localedo.NdV = "";
      Iterator localIterator = paramaio.Lsc.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = localedo.NdV;
        localedo.NdV = (str2 + com.tencent.mm.vfs.s.bhK(str1));
      }
    }
    localedo.NdR = com.tencent.mm.vfs.s.bhK(paramaio.videoPath);
    localedo.NdV = "";
    if (com.tencent.matrix.trace.g.b.eP(localedo.NdR)) {
      localedo.NdR = "";
    }
    localedo.NdU = com.tencent.mm.vfs.s.bhK(paramaio.thumbPath);
    AppMethodBeat.o(75207);
    return localedo;
  }
  
  public static String a(VideoMixer paramVideoMixer, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList, ald paramald, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(75194);
    kotlin.g.b.p.h(paramVideoMixer, "videoMixer");
    kotlin.g.b.p.h(paramList, "editorData");
    kotlin.g.b.p.h(paramald, "extraConfig");
    try
    {
      long l = System.currentTimeMillis();
      c localc = new c();
      localc.field_taskId = MD5Util.getMD5String((localc.hashCode() & 0x7FFFFFFF) + '#' + l);
      localc.field_timeStamp = l;
      localc.field_mixRetryTime = 0;
      localc.field_baseItemData = a(paramVideoMixer, l, paramList);
      paramList = c.b.BKk;
      localc.field_status = c.b.eIO();
      l = paramLong;
      if (paramLong > 2592000000L) {
        l = 2592000000L;
      }
      localc.field_expiredTime = l;
      paramList = paramVideoMixer.eJf();
      localc.field_targetWidth = paramList.videoWidth;
      localc.field_targetHeight = paramList.videoHeight;
      localc.field_videoBitrate = paramList.videoBitrate;
      localc.field_audioBitrate = paramList.audioBitrate;
      localc.field_audioSampleRate = paramList.audioSampleRate;
      localc.field_audioChannelCount = paramList.audioChannelCount;
      localc.field_frameRate = paramList.videoFrameRate;
      localc.field_videoRotate = paramList.ihS;
      localc.field_extraConfig = paramald.toByteArray();
      paramVideoMixer = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      localc.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.c.eKW().eJN();
      paramVideoMixer = CaptureDataManager.BOb;
      kotlin.g.b.p.g(paramVideoMixer, "CaptureDataManager.INSTANCE");
      localc.field_userData = au(paramVideoMixer.getExtData());
      paramVideoMixer = paramString;
      if (paramString == null) {
        paramVideoMixer = "";
      }
      localc.field_blurBgPath = paramVideoMixer;
      localc.field_fromScene = paramInt;
      boolean bool = BJm.insert((IAutoDBItem)localc);
      Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramList + ", ret:" + bool);
      paramVideoMixer = a.BKb;
      paramVideoMixer = localc.field_taskId;
      kotlin.g.b.p.g(paramVideoMixer, "videoEditorData.field_taskId");
      a.bT(paramInt, paramVideoMixer);
      paramVideoMixer = localc.field_taskId;
      AppMethodBeat.o(75194);
      return paramVideoMixer;
    }
    catch (Exception paramVideoMixer)
    {
      Log.printErrStackTrace("MicroMsg.mix_background.VideoEditStorageUtil", (Throwable)paramVideoMixer, "", new Object[0]);
      AppMethodBeat.o(75194);
    }
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte1, VideoMixer.MixConfig paramMixConfig, byte[] paramArrayOfByte2, int paramInt)
  {
    AppMethodBeat.i(75195);
    kotlin.g.b.p.h(paramArrayOfByte1, "baseItemData");
    kotlin.g.b.p.h(paramMixConfig, "mixConfig");
    kotlin.g.b.p.h(paramArrayOfByte2, "extraConfig");
    try
    {
      long l = System.currentTimeMillis();
      c localc = new c();
      localc.field_taskId = MD5Util.getMD5String((localc.hashCode() & 0x7FFFFFFF) + '#' + l);
      localc.field_timeStamp = l;
      localc.field_mixRetryTime = 0;
      com.tencent.mm.bw.a locala = (com.tencent.mm.bw.a)new aio();
      try
      {
        locala.parseFrom(paramArrayOfByte1);
        paramArrayOfByte1 = locala;
      }
      catch (Exception paramArrayOfByte1)
      {
        for (;;)
        {
          boolean bool;
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte1 });
          paramArrayOfByte1 = null;
          continue;
          paramArrayOfByte1 = null;
        }
      }
      paramArrayOfByte1 = (aio)paramArrayOfByte1;
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1.timeStamp = l;
        paramArrayOfByte1.LrZ = a(paramArrayOfByte1);
      }
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1 = paramArrayOfByte1.toByteArray();
        localc.field_baseItemData = paramArrayOfByte1;
        paramArrayOfByte1 = c.b.BKk;
        localc.field_status = c.b.eIO();
        localc.field_expiredTime = 2592000000L;
        localc.field_targetWidth = paramMixConfig.videoWidth;
        localc.field_targetHeight = paramMixConfig.videoHeight;
        localc.field_videoBitrate = paramMixConfig.videoBitrate;
        localc.field_audioBitrate = paramMixConfig.audioBitrate;
        localc.field_audioSampleRate = paramMixConfig.audioSampleRate;
        localc.field_audioChannelCount = paramMixConfig.audioChannelCount;
        localc.field_frameRate = paramMixConfig.videoFrameRate;
        localc.field_videoRotate = paramMixConfig.ihS;
        localc.field_extraConfig = paramArrayOfByte2;
        paramArrayOfByte1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        localc.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.c.eKW().eJN();
        paramArrayOfByte1 = CaptureDataManager.BOb;
        kotlin.g.b.p.g(paramArrayOfByte1, "CaptureDataManager.INSTANCE");
        localc.field_userData = au(paramArrayOfByte1.getExtData());
        localc.field_blurBgPath = "";
        localc.field_fromScene = paramInt;
        bool = BJm.insert((IAutoDBItem)localc);
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramMixConfig + ", ret:" + bool);
        paramArrayOfByte1 = a.BKb;
        paramArrayOfByte1 = localc.field_taskId;
        kotlin.g.b.p.g(paramArrayOfByte1, "videoEditorData.field_taskId");
        a.bT(paramInt, paramArrayOfByte1);
        paramArrayOfByte1 = localc.field_taskId;
        AppMethodBeat.o(75195);
        return paramArrayOfByte1;
      }
      return null;
    }
    catch (Exception paramArrayOfByte1)
    {
      Log.printErrStackTrace("MicroMsg.mix_background.VideoEditStorageUtil", (Throwable)paramArrayOfByte1, "", new Object[0]);
      AppMethodBeat.o(75195);
    }
  }
  
  public static ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> a(LinkedList<jn> paramLinkedList, Context paramContext)
  {
    AppMethodBeat.i(75208);
    kotlin.g.b.p.h(paramLinkedList, "baseItemData");
    kotlin.g.b.p.h(paramContext, "context");
    ArrayList localArrayList = new ArrayList();
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "get the editor data which is waiting for run mixing");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject1 = (jn)paramLinkedList.next();
      int i = ((jn)localObject1).dataType;
      Object localObject2;
      ain localain;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeK.value)
      {
        localObject1 = new q((jn)localObject1);
        localObject2 = new r(paramContext);
        kotlin.g.b.p.h(localObject1, "item");
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(((r)localObject2).c((q)localObject1), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).gT);
        localain = new ain();
        localain.start = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Cev.getStart();
        localain.boX = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Cev.getEnd();
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localObject2).Cgj = localain;
        localArrayList.add(localObject2);
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeL.value)
      {
        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jn)localObject1);
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1).gWm;
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e((EmojiInfo)localObject2, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).gT);
        localain = new ain();
        localain.start = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Cev.getStart();
        localain.boX = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Cev.getEnd();
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localObject2).Cgj = localain;
        localArrayList.add(localObject2);
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeM.value)
      {
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.p(paramContext);
        localObject1 = new k((jn)localObject1);
        kotlin.g.b.p.h(localObject1, "item");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject2).b((k)localObject1), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).gT));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeN.value)
      {
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.s(paramContext);
        localObject1 = new q((jn)localObject1);
        kotlin.g.b.p.h(localObject1, "item");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject2).c((q)localObject1), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).gT));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeO.value)
      {
        localArrayList.add(new m(paramContext).b(new com.tencent.mm.plugin.recordvideo.ui.editor.item.l((jn)localObject1)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeP.value)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeP;
        localObject1 = ((jn)localObject1).KOd;
        kotlin.g.b.p.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        kotlin.g.b.p.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bw.b)localObject1).zy;
        kotlin.g.b.p.g(localObject1, "it.itemData.buffer.bytes");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject2, (byte[])localObject1)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeQ.value)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeQ;
        localObject1 = ((jn)localObject1).KOd;
        kotlin.g.b.p.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        kotlin.g.b.p.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bw.b)localObject1).zy;
        kotlin.g.b.p.g(localObject1, "it.itemData.buffer.bytes");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject2, (byte[])localObject1)));
      }
    }
    AppMethodBeat.o(75208);
    return localArrayList;
  }
  
  public static void a(final aio paramaio, final Context paramContext, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(75210);
    kotlin.g.b.p.h(paramaio, "storyEditorProtoData");
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramViewGroup, "itemLayout");
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story which has editor item");
    Object localObject = paramaio.Lna;
    kotlin.g.b.p.g(localObject, "storyEditorProtoData.baseItemData");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      jn localjn = (jn)((Iterator)localObject).next();
      int i = localjn.dataType;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeK.value) {
        MMHandlerThread.postToMainThread((Runnable)new a(localjn, paramContext, paramViewGroup, paramaio));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeL.value) {
        MMHandlerThread.postToMainThread((Runnable)new b(localjn, paramContext, paramViewGroup, paramaio));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeM.value) {
        MMHandlerThread.postToMainThread((Runnable)new c(localjn, paramContext, paramViewGroup, paramaio));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeN.value) {
        MMHandlerThread.postToMainThread((Runnable)new d(localjn, paramContext, paramViewGroup, paramaio));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeO.value) {
        MMHandlerThread.postToMainThread((Runnable)new e(localjn, paramContext, paramViewGroup, paramaio));
      }
    }
    AppMethodBeat.o(75210);
  }
  
  private static byte[] a(VideoMixer paramVideoMixer, long paramLong, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(75202);
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "is running serialize the videoEditorInfo to bytearray");
    aio localaio = new aio();
    Object localObject1 = paramVideoMixer.BKP.BKI;
    float[] arrayOfFloat = paramVideoMixer.BKP.BKV;
    paramVideoMixer = paramVideoMixer.BKP.BKW;
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "input the timeStamp is ".concat(String.valueOf(paramLong)));
    Object localObject2;
    if (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMY == 3)
    {
      localObject2 = j.ijn;
      if (com.tencent.mm.vfs.s.YS(j.a.Hp(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMT)))
      {
        localObject2 = j.ijn;
        localaio.LrT = j.a.Hp(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMT);
      }
    }
    localaio.timeStamp = paramLong;
    if (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMV == -1L)
    {
      paramLong = 0L;
      localaio.startTime = paramLong;
      localaio.endTime = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMW;
      localaio.thumbPath = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMU;
      localaio.videoPath = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMT;
      localaio.iqf = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).iqf;
      localObject2 = com.tencent.mm.plugin.sight.base.e.aNx(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMT);
      if ((localObject2 != null) && ((((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMW == -1L) || (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMW == 0L))) {
        localaio.endTime = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
      }
      if (!Util.isNullOrNil((List)((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMZ))
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
        localaio.endTime = com.tencent.mm.plugin.recordvideo.b.e.eJs();
      }
      if (localaio.endTime <= 0L) {
        break label564;
      }
    }
    label564:
    for (paramLong = localaio.endTime;; paramLong = 0L)
    {
      localaio.endTime = paramLong;
      localaio.Lsc.addAll((Collection)((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMZ);
      localaio.idq = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMY;
      localaio.LrU = ((int)arrayOfFloat[0]);
      localaio.LrW = ((int)arrayOfFloat[1]);
      localaio.LrV = ((int)arrayOfFloat[2]);
      localaio.LrX = ((int)arrayOfFloat[3]);
      localaio.Lna = new LinkedList();
      if (paramVideoMixer != null)
      {
        localaio.Lse = ((int)paramVideoMixer[0]);
        localaio.Lsg = ((int)paramVideoMixer[1]);
        localaio.Lsf = ((int)paramVideoMixer[2]);
        localaio.Lsh = ((int)paramVideoMixer[3]);
      }
      paramVideoMixer = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).uPh;
      if (paramVideoMixer != null)
      {
        localaio.iiv = paramVideoMixer.cachePath;
        localaio.BOX = paramVideoMixer.BOX;
        localaio.musicUrl = paramVideoMixer.musicUrl;
        localaio.aXa = paramVideoMixer.aXa;
        localaio.BPa = paramVideoMixer.BPa;
        localaio.Lsa = paramVideoMixer.position;
        localaio.Lsb = paramVideoMixer.BPd;
      }
      localaio.LrZ = a(localaio);
      paramVideoMixer = ((Iterable)paramList).iterator();
      while (paramVideoMixer.hasNext())
      {
        paramList = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramVideoMixer.next();
        localObject1 = new jn();
        ((jn)localObject1).dataType = paramList.Cex.value;
        ((jn)localObject1).KOd = z.aC(paramList.eMk().toByteArray());
        localaio.Lna.add(localObject1);
      }
      paramLong = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).BMV;
      break;
    }
    paramVideoMixer = localaio.toByteArray();
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "storyEditorItem " + localaio.videoPath + " thumb " + localaio.thumbPath + " and result " + com.tencent.mm.vfs.s.YS(localaio.thumbPath) + " music " + localaio.iiv + " ret " + Util.getSizeKB(paramVideoMixer.length * 1L) + '}');
    kotlin.g.b.p.g(paramVideoMixer, "ret");
    AppMethodBeat.o(75202);
    return paramVideoMixer;
  }
  
  public static c aLf(String paramString)
  {
    AppMethodBeat.i(75197);
    kotlin.g.b.p.h(paramString, "taskId");
    paramString = BJm.aLe(paramString);
    AppMethodBeat.o(75197);
    return paramString;
  }
  
  public static void aLg(String paramString)
  {
    AppMethodBeat.i(75198);
    kotlin.g.b.p.h(paramString, "taskId");
    c localc = BJm.aLe(paramString);
    if (localc != null)
    {
      localc.field_mixRetryTime += 1;
      BJm.a(paramString, localc);
      AppMethodBeat.o(75198);
      return;
    }
    AppMethodBeat.o(75198);
  }
  
  public static void aLh(String paramString)
  {
    AppMethodBeat.i(75203);
    kotlin.g.b.p.h(paramString, "taskId");
    d locald = BJm;
    kotlin.g.b.p.h(paramString, "taskId");
    locald.db.delete(d.TABLE, "taskId=?", new String[] { String.valueOf(paramString) });
    AppMethodBeat.o(75203);
  }
  
  public static void aLi(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(75204);
    kotlin.g.b.p.h(paramString, "taskId");
    paramString = BJm.aLe(paramString);
    Object localObject2 = (com.tencent.mm.bw.a)new aio();
    if (paramString != null) {}
    for (paramString = paramString.field_baseItemData;; paramString = null)
    {
      try
      {
        ((com.tencent.mm.bw.a)localObject2).parseFrom(paramString);
        paramString = (String)localObject2;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramString });
          paramString = null;
          continue;
          paramString = null;
          continue;
          paramString = null;
        }
      }
      localObject2 = (aio)paramString;
      Log.printInfoStack("MicroMsg.mix_background.VideoEditStorageUtil", "cleanUnAvailableData, videoPath " + localObject2 + "?.videoPath", new Object[0]);
      if ((localObject2 != null) && (((aio)localObject2).iqf == true)) {
        com.tencent.mm.vfs.s.deleteFile(((aio)localObject2).videoPath);
      }
      if (localObject2 == null) {
        break;
      }
      paramString = ((aio)localObject2).LrT;
      com.tencent.mm.vfs.s.deleteFile(paramString);
      if (localObject2 == null) {
        break label192;
      }
      paramString = ((aio)localObject2).iiv;
      com.tencent.mm.vfs.s.deleteFile(paramString);
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = ((aio)localObject2).thumbPath;
      }
      com.tencent.mm.vfs.s.deleteFile(paramString);
      AppMethodBeat.o(75204);
      return;
    }
  }
  
  public static void aLj(String paramString)
  {
    AppMethodBeat.i(75205);
    kotlin.g.b.p.h(paramString, "taskId");
    paramString = BJm.aLe(paramString);
    if (paramString != null)
    {
      paramString.field_mixRetryTime = 0;
      Object localObject = c.b.BKk;
      paramString.field_status = c.b.eIO();
      BJm.a(paramString.bjl(), paramString);
      localObject = f.BKw;
      f.a(paramString, null);
    }
    AppMethodBeat.o(75205);
  }
  
  public static ald aLk(String paramString)
  {
    AppMethodBeat.i(237240);
    kotlin.g.b.p.h(paramString, "taskId");
    Object localObject = aLf(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(237240);
      return null;
    }
    paramString = (com.tencent.mm.bw.a)new ald();
    localObject = ((c)localObject).field_extraConfig;
    try
    {
      paramString.parseFrom((byte[])localObject);
      paramString = (ald)paramString;
      AppMethodBeat.o(237240);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramString });
        paramString = null;
      }
    }
  }
  
  public static Bundle aLl(String paramString)
  {
    AppMethodBeat.i(75214);
    Bundle localBundle = new Bundle();
    if (paramString != null) {
      if (((CharSequence)paramString).length() != 0) {
        break label44;
      }
    }
    label44:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(75214);
      return localBundle;
    }
    paramString = new JSONObject(paramString);
    Iterator localIterator = paramString.keys();
    kotlin.g.b.p.g(localIterator, "jsonObject.keys()");
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramString.get(str);
      if ((localObject instanceof String)) {
        localBundle.putString(str, (String)localObject);
      } else if ((localObject instanceof Integer)) {
        localBundle.putInt(str, ((Number)localObject).intValue());
      } else if ((localObject instanceof Long)) {
        localBundle.putLong(str, ((Number)localObject).longValue());
      } else if ((localObject instanceof Boolean)) {
        localBundle.putBoolean(str, ((Boolean)localObject).booleanValue());
      } else if ((localObject instanceof Byte)) {
        localBundle.putByte(str, ((Number)localObject).byteValue());
      } else if ((localObject instanceof Character)) {
        localBundle.putChar(str, ((Character)localObject).charValue());
      } else if ((localObject instanceof Float)) {
        localBundle.putFloat(str, ((Number)localObject).floatValue());
      } else if ((localObject instanceof Short)) {
        localBundle.putShort(str, ((Number)localObject).shortValue());
      } else if ((localObject instanceof Double)) {
        localBundle.putDouble(str, ((Number)localObject).doubleValue());
      } else {
        localBundle.putString(str, localObject.toString());
      }
    }
    AppMethodBeat.o(75214);
    return localBundle;
  }
  
  private static String au(Bundle paramBundle)
  {
    AppMethodBeat.i(75215);
    if (paramBundle == null)
    {
      AppMethodBeat.o(75215);
      return "";
    }
    Object localObject1 = paramBundle.keySet();
    if (localObject1 == null)
    {
      AppMethodBeat.o(75215);
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = paramBundle.get(str);
      if ((localObject2 instanceof List)) {
        localJSONObject.put(str, new JSONArray((Collection)localObject2));
      } else {
        localJSONObject.put(str, paramBundle.get(str));
      }
    }
    paramBundle = localJSONObject.toString();
    kotlin.g.b.p.g(paramBundle, "jsonObject.toString()");
    AppMethodBeat.o(75215);
    return paramBundle;
  }
  
  public static float[] b(aio paramaio)
  {
    AppMethodBeat.i(75209);
    kotlin.g.b.p.h(paramaio, "storyEditorProtoData");
    float f1 = paramaio.LrU;
    float f2 = paramaio.LrW;
    float f3 = paramaio.LrV;
    float f4 = paramaio.LrX;
    AppMethodBeat.o(75209);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static float[] c(aio paramaio)
  {
    AppMethodBeat.i(237238);
    kotlin.g.b.p.h(paramaio, "storyEditorProtoData");
    float f1 = paramaio.Lse;
    float f2 = paramaio.Lsg;
    float f3 = paramaio.Lsf;
    float f4 = paramaio.Lsh;
    AppMethodBeat.o(237238);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static Rect eIR()
  {
    return BKm;
  }
  
  public static Rect eIS()
  {
    return BKn;
  }
  
  public static int eIT()
  {
    return BKo;
  }
  
  public static void eIU()
  {
    AppMethodBeat.i(75200);
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "clean expired task, num:".concat(String.valueOf(BJm.db.delete(d.TABLE, "timeStamp< ?-expiredTime", new String[] { System.currentTimeMillis() }))));
    AppMethodBeat.o(75200);
  }
  
  public static void eIW()
  {
    AppMethodBeat.i(75206);
    f localf = f.BKw;
    f.eIX();
    AppMethodBeat.o(75206);
  }
  
  public static void fk(String paramString, int paramInt)
  {
    AppMethodBeat.i(75199);
    kotlin.g.b.p.h(paramString, "taskId");
    c localc = BJm.aLe(paramString);
    if (localc != null)
    {
      localc.field_status = paramInt;
      BJm.a(paramString, localc);
      AppMethodBeat.o(75199);
      return;
    }
    AppMethodBeat.o(75199);
  }
  
  public static Rect getVisibleRect()
  {
    return vPN;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$1"})
  static final class a
    implements Runnable
  {
    a(jn paramjn, Context paramContext, ViewGroup paramViewGroup, aio paramaio) {}
    
    public final void run()
    {
      AppMethodBeat.i(75189);
      Object localObject = e.BKp;
      localObject = paramContext;
      ViewGroup localViewGroup = paramViewGroup;
      jn localjn = this.BKq;
      kotlin.g.b.p.g(localjn, "it");
      e.a((Context)localObject, localViewGroup, new q(localjn));
      AppMethodBeat.o(75189);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$2"})
  static final class b
    implements Runnable
  {
    b(jn paramjn, Context paramContext, ViewGroup paramViewGroup, aio paramaio) {}
    
    public final void run()
    {
      AppMethodBeat.i(75190);
      Object localObject = e.BKp;
      localObject = paramContext;
      ViewGroup localViewGroup = paramViewGroup;
      jn localjn = this.BKq;
      kotlin.g.b.p.g(localjn, "it");
      e.a((Context)localObject, localViewGroup, new com.tencent.mm.plugin.recordvideo.ui.editor.item.e(localjn));
      AppMethodBeat.o(75190);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$3"})
  static final class c
    implements Runnable
  {
    c(jn paramjn, Context paramContext, ViewGroup paramViewGroup, aio paramaio) {}
    
    public final void run()
    {
      AppMethodBeat.i(75191);
      Object localObject = e.BKp;
      localObject = paramContext;
      ViewGroup localViewGroup = paramViewGroup;
      jn localjn = this.BKq;
      kotlin.g.b.p.g(localjn, "it");
      e.a((Context)localObject, localViewGroup, new k(localjn));
      AppMethodBeat.o(75191);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$4"})
  static final class d
    implements Runnable
  {
    d(jn paramjn, Context paramContext, ViewGroup paramViewGroup, aio paramaio) {}
    
    public final void run()
    {
      AppMethodBeat.i(75192);
      Object localObject = e.BKp;
      localObject = paramContext;
      ViewGroup localViewGroup = paramViewGroup;
      jn localjn = this.BKq;
      kotlin.g.b.p.g(localjn, "it");
      e.b((Context)localObject, localViewGroup, new q(localjn));
      AppMethodBeat.o(75192);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$5"})
  static final class e
    implements Runnable
  {
    e(jn paramjn, Context paramContext, ViewGroup paramViewGroup, aio paramaio) {}
    
    public final void run()
    {
      AppMethodBeat.i(75193);
      long l1 = paramaio.endTime;
      long l2 = paramaio.startTime;
      Object localObject = this.BKq;
      kotlin.g.b.p.g(localObject, "it");
      localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.item.l((jn)localObject);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.l)localObject).Ij(l1 - l2);
      e locale = e.BKp;
      e.a(paramContext, paramViewGroup, (com.tencent.mm.plugin.recordvideo.ui.editor.item.l)localObject);
      AppMethodBeat.o(75193);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.e
 * JD-Core Version:    0.7.0.1
 */