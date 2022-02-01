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
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.k;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil;", "", "()V", "TAG", "", "damp", "", "getDamp", "()I", "setDamp", "(I)V", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "validAreaRect", "getValidAreaRect", "setValidAreaRect", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "checkMD5", "", "file", "destMD5", "cleanExpiredTask", "", "cleanNullData", "taskId", "cleanUnAvailableData", "convertBundleToJson", "bundle", "Landroid/os/Bundle;", "convertJsonToBundle", "jsonStr", "getAudioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "storyEditorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getLastDataIfNoMix", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "limitTime", "", "getRemuxTask", "getStoryCaptureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "getStoryDataEditorItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "baseItemData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "context", "Landroid/content/Context;", "getStoryFileMD5", "Lcom/tencent/mm/protocal/protobuf/StoryEditorFileMD5;", "getUserData", "insertRemuxTask", "videoMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "editorData", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "extraConfig", "expiredTime", "blurBgPath", "scene", "", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "onUnSerializeStoryDataDrawingRect", "", "onUnSerializeStoryDataValidRect", "reStartMix", "reshowEmojiEditorItem", "emojiItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "reshowEmojiItem", "itemLayout", "Landroid/view/ViewGroup;", "item", "reshowLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "reshowLyricsItem", "reshowPositionEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "reshowPositionItem", "reshowStoryDataEditorItem", "reshowStoryDataEditorItemFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "targetWidth", "targetHeight", "targetRotation", "reshowTextEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "reshowTextItem", "reshowTipEditorItem", "reshowTipItem", "serializeStoryDataToByteArray", "timeStamp", "signVideoMixTime", "updateByLocal", "editData", "updateRemuxTaskState", "state", "plugin-recordvideo_release"})
public final class e
{
  private static final d xtm;
  private static Rect xul;
  private static Rect xum;
  private static int xun;
  public static final e xuo;
  
  static
  {
    AppMethodBeat.i(75216);
    xuo = new e();
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(PluginVideoEditor.class);
    d.g.b.p.g(locala, "MMKernel.plugin(PluginVideoEditor::class.java)");
    xtm = ((PluginVideoEditor)locala).getVideoEditorDataStorage();
    xul = new Rect(0, 0, ar.ci(aj.getContext()).x, ar.ci(aj.getContext()).y);
    xum = new Rect(0, 0, ar.ci(aj.getContext()).x, ar.ci(aj.getContext()).y);
    xun = 54;
    AppMethodBeat.o(75216);
  }
  
  public static com.tencent.mm.plugin.recordvideo.ui.editor.b.g a(afy paramafy, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(200273);
    d.g.b.p.h(paramafy, "storyEditorProtoData");
    d.g.b.p.h(paramContext, "context");
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story as frame retriever");
    List localList = (List)new ArrayList();
    Object localObject1 = paramafy.FZr;
    d.g.b.p.g(localObject1, "storyEditorProtoData.baseItemData");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (ja)localIterator.next();
      int i = ((ja)localObject1).dataType;
      Object localObject2;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNP.value)
      {
        d.g.b.p.g(localObject1, "it");
        localObject1 = new q((ja)localObject1);
        ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
        if (!((q)localObject1).isValid()) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject2).c(null))
        {
          if (localObject1 == null) {
            break label184;
          }
          localList.add(localObject1);
          break;
          localObject2 = new r(paramContext);
          ((r)localObject2).b((q)localObject1);
        }
      }
      else
      {
        label184:
        if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNQ.value)
        {
          d.g.b.p.g(localObject1, "it");
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((ja)localObject1);
          ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the emoji editor item");
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f(paramContext);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject2).a((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1);
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject2).c(null);
          if (localObject1 != null) {
            localList.add(localObject1);
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNR.value)
        {
          d.g.b.p.g(localObject1, "it");
          localObject1 = new k((ja)localObject1);
          ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.p(paramContext);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject2).a((k)localObject1);
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject2).c(null);
          if (localObject1 != null) {
            localList.add(localObject1);
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNS.value)
        {
          d.g.b.p.g(localObject1, "it");
          localObject1 = new q((ja)localObject1);
          ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
          if (!((q)localObject1).isValid()) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject2).c(null))
          {
            if (localObject1 == null) {
              break label444;
            }
            localList.add(localObject1);
            break;
            localObject2 = new s(paramContext);
            ((s)localObject2).b((q)localObject1);
          }
        }
        else
        {
          label444:
          if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNT.value)
          {
            long l1 = paramafy.endTime;
            long l2 = paramafy.startTime;
            d.g.b.p.g(localObject1, "it");
            localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.l((ja)localObject1);
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.l)localObject1).yN(l1 - l2);
            ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
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
      AppMethodBeat.o(200273);
      return null;
    }
    if ((paramInt2 == 0) || (paramInt1 == 0))
    {
      ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "error width " + paramInt1 + " height " + paramInt2);
      AppMethodBeat.o(200273);
      return null;
    }
    paramContext = com.tencent.mm.plugin.recordvideo.e.c.xRv;
    paramContext = paramafy.videoPath;
    d.g.b.p.g(paramContext, "storyEditorProtoData.videoPath");
    paramContext = com.tencent.mm.plugin.recordvideo.e.c.awc(paramContext);
    if ((!paramafy.htP) && (paramContext != null) && (!paramContext.xRw))
    {
      paramafy = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(b(paramafy), c(paramafy), localList, paramInt1, paramInt2, paramContext.width, paramContext.height, paramInt3, false, null, 768));
      AppMethodBeat.o(200273);
      return paramafy;
    }
    paramafy = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(b(paramafy), c(paramafy), localList, paramInt1, paramInt2, 0, 0, paramInt3, false, null, 768));
    AppMethodBeat.o(200273);
    return paramafy;
  }
  
  private static djg a(afy paramafy)
  {
    AppMethodBeat.i(75207);
    d.g.b.p.h(paramafy, "storyEditorProtoData");
    djg localdjg = new djg();
    localdjg.Hyg = i.aPK(paramafy.GdG);
    localdjg.Hyf = i.aPK(paramafy.hml);
    if (!bt.hj((List)paramafy.GdP))
    {
      localdjg.Hye = "";
      localdjg.Hyi = "";
      Iterator localIterator = paramafy.GdP.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = localdjg.Hyi;
        localdjg.Hyi = (str2 + i.aPK(str1));
      }
    }
    localdjg.Hye = i.aPK(paramafy.videoPath);
    localdjg.Hyi = "";
    if (com.tencent.matrix.trace.g.b.ea(localdjg.Hye)) {
      localdjg.Hye = "";
    }
    localdjg.Hyh = i.aPK(paramafy.thumbPath);
    AppMethodBeat.o(75207);
    return localdjg;
  }
  
  public static String a(VideoMixer paramVideoMixer, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList, aif paramaif, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(75194);
    d.g.b.p.h(paramVideoMixer, "videoMixer");
    d.g.b.p.h(paramList, "editorData");
    d.g.b.p.h(paramaif, "extraConfig");
    try
    {
      long l = System.currentTimeMillis();
      c localc = new c();
      localc.field_taskId = ai.ee((localc.hashCode() & 0x7FFFFFFF) + '#' + l);
      localc.field_timeStamp = l;
      localc.field_mixRetryTime = 0;
      localc.field_baseItemData = a(paramVideoMixer, l, paramList);
      paramList = c.b.xuj;
      localc.field_status = c.b.dEK();
      l = paramLong;
      if (paramLong > 2592000000L) {
        l = 2592000000L;
      }
      localc.field_expiredTime = l;
      paramList = paramVideoMixer.dFb();
      localc.field_targetWidth = paramList.videoWidth;
      localc.field_targetHeight = paramList.videoHeight;
      localc.field_videoBitrate = paramList.videoBitrate;
      localc.field_audioBitrate = paramList.audioBitrate;
      localc.field_audioSampleRate = paramList.audioSampleRate;
      localc.field_audioChannelCount = paramList.audioChannelCount;
      localc.field_frameRate = paramList.videoFrameRate;
      localc.field_videoRotate = paramList.hlJ;
      localc.field_extraConfig = paramaif.toByteArray();
      paramVideoMixer = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      localc.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.c.dGK().dFJ();
      paramVideoMixer = CaptureDataManager.xxY;
      d.g.b.p.g(paramVideoMixer, "CaptureDataManager.INSTANCE");
      localc.field_userData = aj(paramVideoMixer.getExtData());
      paramVideoMixer = paramString;
      if (paramString == null) {
        paramVideoMixer = "";
      }
      localc.field_blurBgPath = paramVideoMixer;
      localc.field_fromScene = paramInt;
      boolean bool = xtm.insert((com.tencent.mm.sdk.e.c)localc);
      ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramList + ", ret:" + bool);
      paramVideoMixer = a.xua;
      paramVideoMixer = localc.field_taskId;
      d.g.b.p.g(paramVideoMixer, "videoEditorData.field_taskId");
      a.bF(paramInt, paramVideoMixer);
      paramVideoMixer = localc.field_taskId;
      AppMethodBeat.o(75194);
      return paramVideoMixer;
    }
    catch (Exception paramVideoMixer)
    {
      ad.printErrStackTrace("MicroMsg.mix_background.VideoEditStorageUtil", (Throwable)paramVideoMixer, "", new Object[0]);
      AppMethodBeat.o(75194);
    }
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte1, VideoMixer.MixConfig paramMixConfig, byte[] paramArrayOfByte2, int paramInt)
  {
    AppMethodBeat.i(75195);
    d.g.b.p.h(paramArrayOfByte1, "baseItemData");
    d.g.b.p.h(paramMixConfig, "mixConfig");
    d.g.b.p.h(paramArrayOfByte2, "extraConfig");
    try
    {
      long l = System.currentTimeMillis();
      c localc = new c();
      localc.field_taskId = ai.ee((localc.hashCode() & 0x7FFFFFFF) + '#' + l);
      localc.field_timeStamp = l;
      localc.field_mixRetryTime = 0;
      com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)new afy();
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
          ad.l("safeParser", "", new Object[] { paramArrayOfByte1 });
          paramArrayOfByte1 = null;
          continue;
          paramArrayOfByte1 = null;
        }
      }
      paramArrayOfByte1 = (afy)paramArrayOfByte1;
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1.timeStamp = l;
        paramArrayOfByte1.GdM = a(paramArrayOfByte1);
      }
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1 = paramArrayOfByte1.toByteArray();
        localc.field_baseItemData = paramArrayOfByte1;
        paramArrayOfByte1 = c.b.xuj;
        localc.field_status = c.b.dEK();
        localc.field_expiredTime = 2592000000L;
        localc.field_targetWidth = paramMixConfig.videoWidth;
        localc.field_targetHeight = paramMixConfig.videoHeight;
        localc.field_videoBitrate = paramMixConfig.videoBitrate;
        localc.field_audioBitrate = paramMixConfig.audioBitrate;
        localc.field_audioSampleRate = paramMixConfig.audioSampleRate;
        localc.field_audioChannelCount = paramMixConfig.audioChannelCount;
        localc.field_frameRate = paramMixConfig.videoFrameRate;
        localc.field_videoRotate = paramMixConfig.hlJ;
        localc.field_extraConfig = paramArrayOfByte2;
        paramArrayOfByte1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        localc.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.c.dGK().dFJ();
        paramArrayOfByte1 = CaptureDataManager.xxY;
        d.g.b.p.g(paramArrayOfByte1, "CaptureDataManager.INSTANCE");
        localc.field_userData = aj(paramArrayOfByte1.getExtData());
        localc.field_blurBgPath = "";
        localc.field_fromScene = paramInt;
        bool = xtm.insert((com.tencent.mm.sdk.e.c)localc);
        ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramMixConfig + ", ret:" + bool);
        paramArrayOfByte1 = a.xua;
        paramArrayOfByte1 = localc.field_taskId;
        d.g.b.p.g(paramArrayOfByte1, "videoEditorData.field_taskId");
        a.bF(paramInt, paramArrayOfByte1);
        paramArrayOfByte1 = localc.field_taskId;
        AppMethodBeat.o(75195);
        return paramArrayOfByte1;
      }
      return null;
    }
    catch (Exception paramArrayOfByte1)
    {
      ad.printErrStackTrace("MicroMsg.mix_background.VideoEditStorageUtil", (Throwable)paramArrayOfByte1, "", new Object[0]);
      AppMethodBeat.o(75195);
    }
  }
  
  public static ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> a(LinkedList<ja> paramLinkedList, Context paramContext)
  {
    AppMethodBeat.i(75208);
    d.g.b.p.h(paramLinkedList, "baseItemData");
    d.g.b.p.h(paramContext, "context");
    ArrayList localArrayList = new ArrayList();
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "get the editor data which is waiting for run mixing");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject1 = (ja)paramLinkedList.next();
      int i = ((ja)localObject1).dataType;
      Object localObject2;
      afx localafx;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNP.value)
      {
        localObject1 = new q((ja)localObject1);
        localObject2 = new r(paramContext);
        d.g.b.p.h(localObject1, "item");
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(((r)localObject2).c((q)localObject1), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).gR);
        localafx = new afx();
        localafx.start = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).xNA.getStart();
        localafx.bpc = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).xNA.getEnd();
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localObject2).xPq = localafx;
        localArrayList.add(localObject2);
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNQ.value)
      {
        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((ja)localObject1);
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1).gjb;
        if (localObject2 == null) {
          d.g.b.p.gfZ();
        }
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e((EmojiInfo)localObject2, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).gR);
        localafx = new afx();
        localafx.start = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).xNA.getStart();
        localafx.bpc = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).xNA.getEnd();
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localObject2).xPq = localafx;
        localArrayList.add(localObject2);
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNR.value)
      {
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.p(paramContext);
        localObject1 = new k((ja)localObject1);
        d.g.b.p.h(localObject1, "item");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject2).b((k)localObject1), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).gR));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNS.value)
      {
        localObject2 = new s(paramContext);
        localObject1 = new q((ja)localObject1);
        d.g.b.p.h(localObject1, "item");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(((s)localObject2).c((q)localObject1), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).gR));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNT.value)
      {
        localArrayList.add(new m(paramContext).b(new com.tencent.mm.plugin.recordvideo.ui.editor.item.l((ja)localObject1)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNU.value)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNU;
        localObject1 = ((ja)localObject1).FCa;
        d.g.b.p.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.p.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bx.b)localObject1).getBytes();
        d.g.b.p.g(localObject1, "it.itemData.buffer.bytes");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject2, (byte[])localObject1)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNV.value)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNV;
        localObject1 = ((ja)localObject1).FCa;
        d.g.b.p.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.p.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bx.b)localObject1).getBytes();
        d.g.b.p.g(localObject1, "it.itemData.buffer.bytes");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject2, (byte[])localObject1)));
      }
    }
    AppMethodBeat.o(75208);
    return localArrayList;
  }
  
  public static void a(afy paramafy, Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(75210);
    d.g.b.p.h(paramafy, "storyEditorProtoData");
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramViewGroup, "itemLayout");
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story which has editor item");
    Object localObject = paramafy.FZr;
    d.g.b.p.g(localObject, "storyEditorProtoData.baseItemData");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ja localja = (ja)((Iterator)localObject).next();
      int i = localja.dataType;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNP.value) {
        aq.f((Runnable)new e.a(localja, paramContext, paramViewGroup, paramafy));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNQ.value) {
        aq.f((Runnable)new e.b(localja, paramContext, paramViewGroup, paramafy));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNR.value) {
        aq.f((Runnable)new e.c(localja, paramContext, paramViewGroup, paramafy));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNS.value) {
        aq.f((Runnable)new e.d(localja, paramContext, paramViewGroup, paramafy));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNT.value) {
        aq.f((Runnable)new e.e(localja, paramContext, paramViewGroup, paramafy));
      }
    }
    AppMethodBeat.o(75210);
  }
  
  private static byte[] a(VideoMixer paramVideoMixer, long paramLong, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(75202);
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "is running serialize the videoEditorInfo to bytearray");
    afy localafy = new afy();
    Object localObject1 = paramVideoMixer.xuO.xuH;
    float[] arrayOfFloat = paramVideoMixer.xuO.xuU;
    paramVideoMixer = paramVideoMixer.xuO.xuV;
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "input the timeStamp is ".concat(String.valueOf(paramLong)));
    Object localObject2;
    if (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwU == 3)
    {
      localObject2 = j.hne;
      if (i.fv(j.a.yg(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwP)))
      {
        localObject2 = j.hne;
        localafy.GdG = j.a.yg(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwP);
      }
    }
    localafy.timeStamp = paramLong;
    if (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwR == -1L)
    {
      paramLong = 0L;
      localafy.startTime = paramLong;
      localafy.endTime = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwS;
      localafy.thumbPath = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwQ;
      localafy.videoPath = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwP;
      localafy.htP = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).htP;
      localObject2 = com.tencent.mm.plugin.sight.base.e.axx(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwP);
      if ((localObject2 != null) && ((((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwS == -1L) || (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwS == 0L))) {
        localafy.endTime = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
      }
      if (!bt.hj((List)((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwW))
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.b.e.xxi;
        localafy.endTime = com.tencent.mm.plugin.recordvideo.b.e.dFo();
      }
      if (localafy.endTime <= 0L) {
        break label564;
      }
    }
    label564:
    for (paramLong = localafy.endTime;; paramLong = 0L)
    {
      localafy.endTime = paramLong;
      localafy.GdP.addAll((Collection)((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwW);
      localafy.hhG = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwU;
      localafy.GdH = ((int)arrayOfFloat[0]);
      localafy.GdJ = ((int)arrayOfFloat[1]);
      localafy.GdI = ((int)arrayOfFloat[2]);
      localafy.GdK = ((int)arrayOfFloat[3]);
      localafy.FZr = new LinkedList();
      if (paramVideoMixer != null)
      {
        localafy.GdR = ((int)paramVideoMixer[0]);
        localafy.GdT = ((int)paramVideoMixer[1]);
        localafy.GdS = ((int)paramVideoMixer[2]);
        localafy.GdU = ((int)paramVideoMixer[3]);
      }
      paramVideoMixer = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwV;
      if (paramVideoMixer != null)
      {
        localafy.hml = paramVideoMixer.cachePath;
        localafy.xyZ = paramVideoMixer.xyZ;
        localafy.musicUrl = paramVideoMixer.musicUrl;
        localafy.aXj = paramVideoMixer.aXj;
        localafy.xzc = paramVideoMixer.xzc;
        localafy.GdN = paramVideoMixer.position;
        localafy.GdO = paramVideoMixer.xze;
      }
      localafy.GdM = a(localafy);
      paramVideoMixer = ((Iterable)paramList).iterator();
      while (paramVideoMixer.hasNext())
      {
        paramList = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramVideoMixer.next();
        localObject1 = new ja();
        ((ja)localObject1).dataType = paramList.xNC.value;
        ((ja)localObject1).FCa = z.al(paramList.dHT().toByteArray());
        localafy.FZr.add(localObject1);
      }
      paramLong = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xwR;
      break;
    }
    paramVideoMixer = localafy.toByteArray();
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "storyEditorItem " + localafy.videoPath + " thumb " + localafy.thumbPath + " and result " + i.fv(localafy.thumbPath) + " music " + localafy.hml + " ret " + bt.sy(paramVideoMixer.length * 1L) + '}');
    d.g.b.p.g(paramVideoMixer, "ret");
    AppMethodBeat.o(75202);
    return paramVideoMixer;
  }
  
  private static String aj(Bundle paramBundle)
  {
    AppMethodBeat.i(75215);
    if (paramBundle == null)
    {
      AppMethodBeat.o(75215);
      return "";
    }
    Object localObject = paramBundle.keySet();
    if (localObject == null)
    {
      AppMethodBeat.o(75215);
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localJSONObject.put(str, paramBundle.get(str));
    }
    paramBundle = localJSONObject.toString();
    d.g.b.p.g(paramBundle, "jsonObject.toString()");
    AppMethodBeat.o(75215);
    return paramBundle;
  }
  
  public static void avA(String paramString)
  {
    AppMethodBeat.i(75203);
    d.g.b.p.h(paramString, "taskId");
    d locald = xtm;
    d.g.b.p.h(paramString, "taskId");
    locald.db.delete(d.TABLE, "taskId=?", new String[] { String.valueOf(paramString) });
    AppMethodBeat.o(75203);
  }
  
  public static void avB(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(75204);
    d.g.b.p.h(paramString, "taskId");
    paramString = xtm.avx(paramString);
    Object localObject2 = (com.tencent.mm.bx.a)new afy();
    if (paramString != null) {}
    for (paramString = paramString.field_baseItemData;; paramString = null)
    {
      try
      {
        ((com.tencent.mm.bx.a)localObject2).parseFrom(paramString);
        paramString = (String)localObject2;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { paramString });
          paramString = null;
          continue;
          paramString = null;
          continue;
          paramString = null;
        }
      }
      localObject2 = (afy)paramString;
      ad.m("MicroMsg.mix_background.VideoEditStorageUtil", "cleanUnAvailableData, videoPath " + localObject2 + "?.videoPath", new Object[0]);
      if ((localObject2 != null) && (((afy)localObject2).htP == true)) {
        i.deleteFile(((afy)localObject2).videoPath);
      }
      if (localObject2 == null) {
        break;
      }
      paramString = ((afy)localObject2).GdG;
      i.deleteFile(paramString);
      if (localObject2 == null) {
        break label192;
      }
      paramString = ((afy)localObject2).hml;
      i.deleteFile(paramString);
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = ((afy)localObject2).thumbPath;
      }
      i.deleteFile(paramString);
      AppMethodBeat.o(75204);
      return;
    }
  }
  
  public static void avC(String paramString)
  {
    AppMethodBeat.i(75205);
    d.g.b.p.h(paramString, "taskId");
    paramString = xtm.avx(paramString);
    if (paramString != null)
    {
      paramString.field_mixRetryTime = 0;
      Object localObject = c.b.xuj;
      paramString.field_status = c.b.dEK();
      xtm.a(paramString.aOC(), paramString);
      localObject = f.xuv;
      f.a(paramString, null);
    }
    AppMethodBeat.o(75205);
  }
  
  public static aif avD(String paramString)
  {
    AppMethodBeat.i(200274);
    d.g.b.p.h(paramString, "taskId");
    Object localObject = avy(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200274);
      return null;
    }
    paramString = (com.tencent.mm.bx.a)new aif();
    localObject = ((c)localObject).field_extraConfig;
    try
    {
      paramString.parseFrom((byte[])localObject);
      paramString = (aif)paramString;
      AppMethodBeat.o(200274);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { paramString });
        paramString = null;
      }
    }
  }
  
  public static Bundle avE(String paramString)
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
    d.g.b.p.g(localIterator, "jsonObject.keys()");
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
  
  public static c avy(String paramString)
  {
    AppMethodBeat.i(75197);
    d.g.b.p.h(paramString, "taskId");
    paramString = xtm.avx(paramString);
    AppMethodBeat.o(75197);
    return paramString;
  }
  
  public static void avz(String paramString)
  {
    AppMethodBeat.i(75198);
    d.g.b.p.h(paramString, "taskId");
    c localc = xtm.avx(paramString);
    if (localc != null)
    {
      localc.field_mixRetryTime += 1;
      xtm.a(paramString, localc);
      AppMethodBeat.o(75198);
      return;
    }
    AppMethodBeat.o(75198);
  }
  
  public static float[] b(afy paramafy)
  {
    AppMethodBeat.i(75209);
    d.g.b.p.h(paramafy, "storyEditorProtoData");
    float f1 = paramafy.GdH;
    float f2 = paramafy.GdJ;
    float f3 = paramafy.GdI;
    float f4 = paramafy.GdK;
    AppMethodBeat.o(75209);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static float[] c(afy paramafy)
  {
    AppMethodBeat.i(200272);
    d.g.b.p.h(paramafy, "storyEditorProtoData");
    float f1 = paramafy.GdR;
    float f2 = paramafy.GdT;
    float f3 = paramafy.GdS;
    float f4 = paramafy.GdU;
    AppMethodBeat.o(200272);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static Rect dEN()
  {
    return xul;
  }
  
  public static Rect dEO()
  {
    return xum;
  }
  
  public static int dEP()
  {
    return xun;
  }
  
  public static void dEQ()
  {
    AppMethodBeat.i(75200);
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "clean expired task, num:".concat(String.valueOf(xtm.db.delete(d.TABLE, "timeStamp< ?-expiredTime", new String[] { System.currentTimeMillis() }))));
    AppMethodBeat.o(75200);
  }
  
  public static void dES()
  {
    AppMethodBeat.i(75206);
    f localf = f.xuv;
    f.dET();
    AppMethodBeat.o(75206);
  }
  
  public static void eK(String paramString, int paramInt)
  {
    AppMethodBeat.i(75199);
    d.g.b.p.h(paramString, "taskId");
    c localc = xtm.avx(paramString);
    if (localc != null)
    {
      localc.field_status = paramInt;
      xtm.a(paramString, localc);
      AppMethodBeat.o(75199);
      return;
    }
    AppMethodBeat.o(75199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.e
 * JD-Core Version:    0.7.0.1
 */