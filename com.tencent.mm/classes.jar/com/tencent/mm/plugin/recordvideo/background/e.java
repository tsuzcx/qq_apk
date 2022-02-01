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
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.dkb;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil;", "", "()V", "TAG", "", "damp", "", "getDamp", "()I", "setDamp", "(I)V", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "validAreaRect", "getValidAreaRect", "setValidAreaRect", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "checkMD5", "", "file", "destMD5", "cleanExpiredTask", "", "cleanNullData", "taskId", "cleanUnAvailableData", "convertBundleToJson", "bundle", "Landroid/os/Bundle;", "convertJsonToBundle", "jsonStr", "getAudioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "storyEditorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getLastDataIfNoMix", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "limitTime", "", "getRemuxTask", "getStoryCaptureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "getStoryDataEditorItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "baseItemData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "context", "Landroid/content/Context;", "getStoryFileMD5", "Lcom/tencent/mm/protocal/protobuf/StoryEditorFileMD5;", "getUserData", "insertRemuxTask", "videoMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "editorData", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "extraConfig", "expiredTime", "blurBgPath", "scene", "", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "onUnSerializeStoryDataDrawingRect", "", "onUnSerializeStoryDataValidRect", "reStartMix", "reshowEmojiEditorItem", "emojiItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "reshowEmojiItem", "itemLayout", "Landroid/view/ViewGroup;", "item", "reshowLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "reshowLyricsItem", "reshowPositionEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "reshowPositionItem", "reshowStoryDataEditorItem", "reshowStoryDataEditorItemFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "targetWidth", "targetHeight", "targetRotation", "reshowTextEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "reshowTextItem", "reshowTipEditorItem", "reshowTipItem", "serializeStoryDataToByteArray", "timeStamp", "signVideoMixTime", "updateByLocal", "editData", "updateRemuxTaskState", "state", "plugin-recordvideo_release"})
public final class e
{
  private static final d xJj;
  private static Rect xKi;
  private static Rect xKj;
  private static int xKk;
  public static final e xKl;
  
  static
  {
    AppMethodBeat.i(75216);
    xKl = new e();
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(PluginVideoEditor.class);
    d.g.b.p.g(locala, "MMKernel.plugin(PluginVideoEditor::class.java)");
    xJj = ((PluginVideoEditor)locala).getVideoEditorDataStorage();
    xKi = new Rect(0, 0, com.tencent.mm.ui.ar.ck(ak.getContext()).x, com.tencent.mm.ui.ar.ck(ak.getContext()).y);
    xKj = new Rect(0, 0, com.tencent.mm.ui.ar.ck(ak.getContext()).x, com.tencent.mm.ui.ar.ck(ak.getContext()).y);
    xKk = 54;
    AppMethodBeat.o(75216);
  }
  
  public static com.tencent.mm.plugin.recordvideo.ui.editor.b.g a(agh paramagh, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(206534);
    d.g.b.p.h(paramagh, "storyEditorProtoData");
    d.g.b.p.h(paramContext, "context");
    ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story as frame retriever");
    List localList = (List)new ArrayList();
    Object localObject1 = paramagh.GrR;
    d.g.b.p.g(localObject1, "storyEditorProtoData.baseItemData");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (ja)localIterator.next();
      int i = ((ja)localObject1).dataType;
      Object localObject2;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydI.value)
      {
        d.g.b.p.g(localObject1, "it");
        localObject1 = new q((ja)localObject1);
        ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
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
        if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydJ.value)
        {
          d.g.b.p.g(localObject1, "it");
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((ja)localObject1);
          ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the emoji editor item");
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f(paramContext);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject2).a((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1);
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject2).c(null);
          if (localObject1 != null) {
            localList.add(localObject1);
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydK.value)
        {
          d.g.b.p.g(localObject1, "it");
          localObject1 = new k((ja)localObject1);
          ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.p(paramContext);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject2).a((k)localObject1);
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject2).c(null);
          if (localObject1 != null) {
            localList.add(localObject1);
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydL.value)
        {
          d.g.b.p.g(localObject1, "it");
          localObject1 = new q((ja)localObject1);
          ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
          if (!((q)localObject1).isValid()) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject2).c(null))
          {
            if (localObject1 == null) {
              break label448;
            }
            localList.add(localObject1);
            break;
            localObject2 = new s(paramContext);
            ((s)localObject2).b((q)localObject1);
          }
        }
        else
        {
          label448:
          if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydM.value)
          {
            long l1 = paramagh.endTime;
            long l2 = paramagh.startTime;
            d.g.b.p.g(localObject1, "it");
            localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.l((ja)localObject1);
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.l)localObject1).zl(l1 - l2);
            ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
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
      AppMethodBeat.o(206534);
      return null;
    }
    if ((paramInt2 == 0) || (paramInt1 == 0))
    {
      ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "error width " + paramInt1 + " height " + paramInt2);
      AppMethodBeat.o(206534);
      return null;
    }
    paramContext = com.tencent.mm.plugin.recordvideo.e.c.yho;
    paramContext = paramagh.videoPath;
    d.g.b.p.g(paramContext, "storyEditorProtoData.videoPath");
    paramContext = com.tencent.mm.plugin.recordvideo.e.c.axr(paramContext);
    if ((!paramagh.hwD) && (paramContext != null) && (!paramContext.yhp))
    {
      paramagh = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(b(paramagh), c(paramagh), localList, paramInt1, paramInt2, paramContext.width, paramContext.height, paramInt3, false, null, 768));
      AppMethodBeat.o(206534);
      return paramagh;
    }
    paramagh = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(b(paramagh), c(paramagh), localList, paramInt1, paramInt2, 0, 0, paramInt3, false, null, 768));
    AppMethodBeat.o(206534);
    return paramagh;
  }
  
  private static dkb a(agh paramagh)
  {
    AppMethodBeat.i(75207);
    d.g.b.p.h(paramagh, "storyEditorProtoData");
    dkb localdkb = new dkb();
    localdkb.HRR = o.aRh(paramagh.Gwn);
    localdkb.HRQ = o.aRh(paramagh.hoZ);
    if (!bu.ht((List)paramagh.Gww))
    {
      localdkb.HRP = "";
      localdkb.HRT = "";
      Iterator localIterator = paramagh.Gww.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = localdkb.HRT;
        localdkb.HRT = (str2 + o.aRh(str1));
      }
    }
    localdkb.HRP = o.aRh(paramagh.videoPath);
    localdkb.HRT = "";
    if (com.tencent.matrix.trace.g.b.ef(localdkb.HRP)) {
      localdkb.HRP = "";
    }
    localdkb.HRS = o.aRh(paramagh.thumbPath);
    AppMethodBeat.o(75207);
    return localdkb;
  }
  
  public static String a(VideoMixer paramVideoMixer, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList, aip paramaip, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(75194);
    d.g.b.p.h(paramVideoMixer, "videoMixer");
    d.g.b.p.h(paramList, "editorData");
    d.g.b.p.h(paramaip, "extraConfig");
    try
    {
      long l = System.currentTimeMillis();
      c localc = new c();
      localc.field_taskId = aj.ej((localc.hashCode() & 0x7FFFFFFF) + '#' + l);
      localc.field_timeStamp = l;
      localc.field_mixRetryTime = 0;
      localc.field_baseItemData = a(paramVideoMixer, l, paramList);
      paramList = c.b.xKg;
      localc.field_status = c.b.dIb();
      l = paramLong;
      if (paramLong > 2592000000L) {
        l = 2592000000L;
      }
      localc.field_expiredTime = l;
      paramList = paramVideoMixer.dIs();
      localc.field_targetWidth = paramList.videoWidth;
      localc.field_targetHeight = paramList.videoHeight;
      localc.field_videoBitrate = paramList.videoBitrate;
      localc.field_audioBitrate = paramList.audioBitrate;
      localc.field_audioSampleRate = paramList.audioSampleRate;
      localc.field_audioChannelCount = paramList.audioChannelCount;
      localc.field_frameRate = paramList.videoFrameRate;
      localc.field_videoRotate = paramList.hoy;
      localc.field_extraConfig = paramaip.toByteArray();
      paramVideoMixer = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      localc.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.c.dKb().dJa();
      paramVideoMixer = CaptureDataManager.xNV;
      d.g.b.p.g(paramVideoMixer, "CaptureDataManager.INSTANCE");
      localc.field_userData = ak(paramVideoMixer.getExtData());
      paramVideoMixer = paramString;
      if (paramString == null) {
        paramVideoMixer = "";
      }
      localc.field_blurBgPath = paramVideoMixer;
      localc.field_fromScene = paramInt;
      boolean bool = xJj.insert((com.tencent.mm.sdk.e.c)localc);
      ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramList + ", ret:" + bool);
      paramVideoMixer = a.xJX;
      paramVideoMixer = localc.field_taskId;
      d.g.b.p.g(paramVideoMixer, "videoEditorData.field_taskId");
      a.bF(paramInt, paramVideoMixer);
      paramVideoMixer = localc.field_taskId;
      AppMethodBeat.o(75194);
      return paramVideoMixer;
    }
    catch (Exception paramVideoMixer)
    {
      ae.printErrStackTrace("MicroMsg.mix_background.VideoEditStorageUtil", (Throwable)paramVideoMixer, "", new Object[0]);
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
      localc.field_taskId = aj.ej((localc.hashCode() & 0x7FFFFFFF) + '#' + l);
      localc.field_timeStamp = l;
      localc.field_mixRetryTime = 0;
      com.tencent.mm.bw.a locala = (com.tencent.mm.bw.a)new agh();
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
          ae.l("safeParser", "", new Object[] { paramArrayOfByte1 });
          paramArrayOfByte1 = null;
          continue;
          paramArrayOfByte1 = null;
        }
      }
      paramArrayOfByte1 = (agh)paramArrayOfByte1;
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1.timeStamp = l;
        paramArrayOfByte1.Gwt = a(paramArrayOfByte1);
      }
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1 = paramArrayOfByte1.toByteArray();
        localc.field_baseItemData = paramArrayOfByte1;
        paramArrayOfByte1 = c.b.xKg;
        localc.field_status = c.b.dIb();
        localc.field_expiredTime = 2592000000L;
        localc.field_targetWidth = paramMixConfig.videoWidth;
        localc.field_targetHeight = paramMixConfig.videoHeight;
        localc.field_videoBitrate = paramMixConfig.videoBitrate;
        localc.field_audioBitrate = paramMixConfig.audioBitrate;
        localc.field_audioSampleRate = paramMixConfig.audioSampleRate;
        localc.field_audioChannelCount = paramMixConfig.audioChannelCount;
        localc.field_frameRate = paramMixConfig.videoFrameRate;
        localc.field_videoRotate = paramMixConfig.hoy;
        localc.field_extraConfig = paramArrayOfByte2;
        paramArrayOfByte1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        localc.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.c.dKb().dJa();
        paramArrayOfByte1 = CaptureDataManager.xNV;
        d.g.b.p.g(paramArrayOfByte1, "CaptureDataManager.INSTANCE");
        localc.field_userData = ak(paramArrayOfByte1.getExtData());
        localc.field_blurBgPath = "";
        localc.field_fromScene = paramInt;
        bool = xJj.insert((com.tencent.mm.sdk.e.c)localc);
        ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramMixConfig + ", ret:" + bool);
        paramArrayOfByte1 = a.xJX;
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
      ae.printErrStackTrace("MicroMsg.mix_background.VideoEditStorageUtil", (Throwable)paramArrayOfByte1, "", new Object[0]);
      AppMethodBeat.o(75195);
    }
  }
  
  public static ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> a(LinkedList<ja> paramLinkedList, Context paramContext)
  {
    AppMethodBeat.i(75208);
    d.g.b.p.h(paramLinkedList, "baseItemData");
    d.g.b.p.h(paramContext, "context");
    ArrayList localArrayList = new ArrayList();
    ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "get the editor data which is waiting for run mixing");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject1 = (ja)paramLinkedList.next();
      int i = ((ja)localObject1).dataType;
      Object localObject2;
      agg localagg;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydI.value)
      {
        localObject1 = new q((ja)localObject1);
        localObject2 = new r(paramContext);
        d.g.b.p.h(localObject1, "item");
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(((r)localObject2).c((q)localObject1), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).gR);
        localagg = new agg();
        localagg.start = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).ydt.getStart();
        localagg.bpc = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).ydt.getEnd();
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localObject2).yfj = localagg;
        localArrayList.add(localObject2);
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydJ.value)
      {
        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((ja)localObject1);
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1).glt;
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e((EmojiInfo)localObject2, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).gR);
        localagg = new agg();
        localagg.start = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).ydt.getStart();
        localagg.bpc = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).ydt.getEnd();
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localObject2).yfj = localagg;
        localArrayList.add(localObject2);
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydK.value)
      {
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.p(paramContext);
        localObject1 = new k((ja)localObject1);
        d.g.b.p.h(localObject1, "item");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject2).b((k)localObject1), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).gR));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydL.value)
      {
        localObject2 = new s(paramContext);
        localObject1 = new q((ja)localObject1);
        d.g.b.p.h(localObject1, "item");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(((s)localObject2).c((q)localObject1), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).gR));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydM.value)
      {
        localArrayList.add(new m(paramContext).b(new com.tencent.mm.plugin.recordvideo.ui.editor.item.l((ja)localObject1)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydN.value)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydN;
        localObject1 = ((ja)localObject1).FUv;
        d.g.b.p.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.p.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bw.b)localObject1).getBytes();
        d.g.b.p.g(localObject1, "it.itemData.buffer.bytes");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject2, (byte[])localObject1)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydO.value)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydO;
        localObject1 = ((ja)localObject1).FUv;
        d.g.b.p.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.p.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bw.b)localObject1).getBytes();
        d.g.b.p.g(localObject1, "it.itemData.buffer.bytes");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject2, (byte[])localObject1)));
      }
    }
    AppMethodBeat.o(75208);
    return localArrayList;
  }
  
  public static void a(final agh paramagh, final Context paramContext, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(75210);
    d.g.b.p.h(paramagh, "storyEditorProtoData");
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramViewGroup, "itemLayout");
    ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story which has editor item");
    Object localObject = paramagh.GrR;
    d.g.b.p.g(localObject, "storyEditorProtoData.baseItemData");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ja localja = (ja)((Iterator)localObject).next();
      int i = localja.dataType;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydI.value) {
        com.tencent.mm.sdk.platformtools.ar.f((Runnable)new a(localja, paramContext, paramViewGroup, paramagh));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydJ.value) {
        com.tencent.mm.sdk.platformtools.ar.f((Runnable)new b(localja, paramContext, paramViewGroup, paramagh));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydK.value) {
        com.tencent.mm.sdk.platformtools.ar.f((Runnable)new c(localja, paramContext, paramViewGroup, paramagh));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydL.value) {
        com.tencent.mm.sdk.platformtools.ar.f((Runnable)new d(localja, paramContext, paramViewGroup, paramagh));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydM.value) {
        com.tencent.mm.sdk.platformtools.ar.f((Runnable)new e(localja, paramContext, paramViewGroup, paramagh));
      }
    }
    AppMethodBeat.o(75210);
  }
  
  private static byte[] a(VideoMixer paramVideoMixer, long paramLong, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(75202);
    ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "is running serialize the videoEditorInfo to bytearray");
    agh localagh = new agh();
    Object localObject1 = paramVideoMixer.xKL.xKE;
    float[] arrayOfFloat = paramVideoMixer.xKL.xKR;
    paramVideoMixer = paramVideoMixer.xKL.xKS;
    ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "input the timeStamp is ".concat(String.valueOf(paramLong)));
    Object localObject2;
    if (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMR == 3)
    {
      localObject2 = j.hpS;
      if (o.fB(j.a.yQ(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMM)))
      {
        localObject2 = j.hpS;
        localagh.Gwn = j.a.yQ(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMM);
      }
    }
    localagh.timeStamp = paramLong;
    if (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMO == -1L)
    {
      paramLong = 0L;
      localagh.startTime = paramLong;
      localagh.endTime = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMP;
      localagh.thumbPath = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMN;
      localagh.videoPath = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMM;
      localagh.hwD = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).hwD;
      localObject2 = com.tencent.mm.plugin.sight.base.e.ayN(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMM);
      if ((localObject2 != null) && ((((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMP == -1L) || (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMP == 0L))) {
        localagh.endTime = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
      }
      if (!bu.ht((List)((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMT))
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.b.e.xNf;
        localagh.endTime = com.tencent.mm.plugin.recordvideo.b.e.dIF();
      }
      if (localagh.endTime <= 0L) {
        break label564;
      }
    }
    label564:
    for (paramLong = localagh.endTime;; paramLong = 0L)
    {
      localagh.endTime = paramLong;
      localagh.Gww.addAll((Collection)((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMT);
      localagh.hku = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMR;
      localagh.Gwo = ((int)arrayOfFloat[0]);
      localagh.Gwq = ((int)arrayOfFloat[1]);
      localagh.Gwp = ((int)arrayOfFloat[2]);
      localagh.Gwr = ((int)arrayOfFloat[3]);
      localagh.GrR = new LinkedList();
      if (paramVideoMixer != null)
      {
        localagh.Gwy = ((int)paramVideoMixer[0]);
        localagh.GwA = ((int)paramVideoMixer[1]);
        localagh.Gwz = ((int)paramVideoMixer[2]);
        localagh.GwB = ((int)paramVideoMixer[3]);
      }
      paramVideoMixer = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMS;
      if (paramVideoMixer != null)
      {
        localagh.hoZ = paramVideoMixer.cachePath;
        localagh.xOV = paramVideoMixer.xOV;
        localagh.musicUrl = paramVideoMixer.musicUrl;
        localagh.aXj = paramVideoMixer.aXj;
        localagh.xOY = paramVideoMixer.xOY;
        localagh.Gwu = paramVideoMixer.position;
        localagh.Gwv = paramVideoMixer.xPa;
      }
      localagh.Gwt = a(localagh);
      paramVideoMixer = ((Iterable)paramList).iterator();
      while (paramVideoMixer.hasNext())
      {
        paramList = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramVideoMixer.next();
        localObject1 = new ja();
        ((ja)localObject1).dataType = paramList.ydv.value;
        ((ja)localObject1).FUv = z.al(paramList.dLk().toByteArray());
        localagh.GrR.add(localObject1);
      }
      paramLong = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).xMO;
      break;
    }
    paramVideoMixer = localagh.toByteArray();
    ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "storyEditorItem " + localagh.videoPath + " thumb " + localagh.thumbPath + " and result " + o.fB(localagh.thumbPath) + " music " + localagh.hoZ + " ret " + bu.sL(paramVideoMixer.length * 1L) + '}');
    d.g.b.p.g(paramVideoMixer, "ret");
    AppMethodBeat.o(75202);
    return paramVideoMixer;
  }
  
  private static String ak(Bundle paramBundle)
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
  
  public static c awN(String paramString)
  {
    AppMethodBeat.i(75197);
    d.g.b.p.h(paramString, "taskId");
    paramString = xJj.awM(paramString);
    AppMethodBeat.o(75197);
    return paramString;
  }
  
  public static void awO(String paramString)
  {
    AppMethodBeat.i(75198);
    d.g.b.p.h(paramString, "taskId");
    c localc = xJj.awM(paramString);
    if (localc != null)
    {
      localc.field_mixRetryTime += 1;
      xJj.a(paramString, localc);
      AppMethodBeat.o(75198);
      return;
    }
    AppMethodBeat.o(75198);
  }
  
  public static void awP(String paramString)
  {
    AppMethodBeat.i(75203);
    d.g.b.p.h(paramString, "taskId");
    d locald = xJj;
    d.g.b.p.h(paramString, "taskId");
    locald.db.delete(d.TABLE, "taskId=?", new String[] { String.valueOf(paramString) });
    AppMethodBeat.o(75203);
  }
  
  public static void awQ(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(75204);
    d.g.b.p.h(paramString, "taskId");
    paramString = xJj.awM(paramString);
    Object localObject2 = (com.tencent.mm.bw.a)new agh();
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
          ae.l("safeParser", "", new Object[] { paramString });
          paramString = null;
          continue;
          paramString = null;
          continue;
          paramString = null;
        }
      }
      localObject2 = (agh)paramString;
      ae.m("MicroMsg.mix_background.VideoEditStorageUtil", "cleanUnAvailableData, videoPath " + localObject2 + "?.videoPath", new Object[0]);
      if ((localObject2 != null) && (((agh)localObject2).hwD == true)) {
        o.deleteFile(((agh)localObject2).videoPath);
      }
      if (localObject2 == null) {
        break;
      }
      paramString = ((agh)localObject2).Gwn;
      o.deleteFile(paramString);
      if (localObject2 == null) {
        break label192;
      }
      paramString = ((agh)localObject2).hoZ;
      o.deleteFile(paramString);
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = ((agh)localObject2).thumbPath;
      }
      o.deleteFile(paramString);
      AppMethodBeat.o(75204);
      return;
    }
  }
  
  public static void awR(String paramString)
  {
    AppMethodBeat.i(75205);
    d.g.b.p.h(paramString, "taskId");
    paramString = xJj.awM(paramString);
    if (paramString != null)
    {
      paramString.field_mixRetryTime = 0;
      Object localObject = c.b.xKg;
      paramString.field_status = c.b.dIb();
      xJj.a(paramString.aOZ(), paramString);
      localObject = f.xKs;
      f.a(paramString, null);
    }
    AppMethodBeat.o(75205);
  }
  
  public static aip awS(String paramString)
  {
    AppMethodBeat.i(206535);
    d.g.b.p.h(paramString, "taskId");
    Object localObject = awN(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(206535);
      return null;
    }
    paramString = (com.tencent.mm.bw.a)new aip();
    localObject = ((c)localObject).field_extraConfig;
    try
    {
      paramString.parseFrom((byte[])localObject);
      paramString = (aip)paramString;
      AppMethodBeat.o(206535);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.l("safeParser", "", new Object[] { paramString });
        paramString = null;
      }
    }
  }
  
  public static Bundle awT(String paramString)
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
  
  public static float[] b(agh paramagh)
  {
    AppMethodBeat.i(75209);
    d.g.b.p.h(paramagh, "storyEditorProtoData");
    float f1 = paramagh.Gwo;
    float f2 = paramagh.Gwq;
    float f3 = paramagh.Gwp;
    float f4 = paramagh.Gwr;
    AppMethodBeat.o(75209);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static float[] c(agh paramagh)
  {
    AppMethodBeat.i(206533);
    d.g.b.p.h(paramagh, "storyEditorProtoData");
    float f1 = paramagh.Gwy;
    float f2 = paramagh.GwA;
    float f3 = paramagh.Gwz;
    float f4 = paramagh.GwB;
    AppMethodBeat.o(206533);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static Rect dIe()
  {
    return xKi;
  }
  
  public static Rect dIf()
  {
    return xKj;
  }
  
  public static int dIg()
  {
    return xKk;
  }
  
  public static void dIh()
  {
    AppMethodBeat.i(75200);
    ae.i("MicroMsg.mix_background.VideoEditStorageUtil", "clean expired task, num:".concat(String.valueOf(xJj.db.delete(d.TABLE, "timeStamp< ?-expiredTime", new String[] { System.currentTimeMillis() }))));
    AppMethodBeat.o(75200);
  }
  
  public static void dIj()
  {
    AppMethodBeat.i(75206);
    f localf = f.xKs;
    f.dIk();
    AppMethodBeat.o(75206);
  }
  
  public static void eS(String paramString, int paramInt)
  {
    AppMethodBeat.i(75199);
    d.g.b.p.h(paramString, "taskId");
    c localc = xJj.awM(paramString);
    if (localc != null)
    {
      localc.field_status = paramInt;
      xJj.a(paramString, localc);
      AppMethodBeat.o(75199);
      return;
    }
    AppMethodBeat.o(75199);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$1"})
  static final class a
    implements Runnable
  {
    a(ja paramja, Context paramContext, ViewGroup paramViewGroup, agh paramagh) {}
    
    public final void run()
    {
      AppMethodBeat.i(75189);
      Object localObject = e.xKl;
      localObject = paramContext;
      ViewGroup localViewGroup = paramViewGroup;
      ja localja = this.xKm;
      d.g.b.p.g(localja, "it");
      e.a((Context)localObject, localViewGroup, new q(localja));
      AppMethodBeat.o(75189);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$2"})
  static final class b
    implements Runnable
  {
    b(ja paramja, Context paramContext, ViewGroup paramViewGroup, agh paramagh) {}
    
    public final void run()
    {
      AppMethodBeat.i(75190);
      Object localObject = e.xKl;
      localObject = paramContext;
      ViewGroup localViewGroup = paramViewGroup;
      ja localja = this.xKm;
      d.g.b.p.g(localja, "it");
      e.a((Context)localObject, localViewGroup, new com.tencent.mm.plugin.recordvideo.ui.editor.item.e(localja));
      AppMethodBeat.o(75190);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$3"})
  static final class c
    implements Runnable
  {
    c(ja paramja, Context paramContext, ViewGroup paramViewGroup, agh paramagh) {}
    
    public final void run()
    {
      AppMethodBeat.i(75191);
      Object localObject = e.xKl;
      localObject = paramContext;
      ViewGroup localViewGroup = paramViewGroup;
      ja localja = this.xKm;
      d.g.b.p.g(localja, "it");
      e.a((Context)localObject, localViewGroup, new k(localja));
      AppMethodBeat.o(75191);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$4"})
  static final class d
    implements Runnable
  {
    d(ja paramja, Context paramContext, ViewGroup paramViewGroup, agh paramagh) {}
    
    public final void run()
    {
      AppMethodBeat.i(75192);
      Object localObject = e.xKl;
      localObject = paramContext;
      ViewGroup localViewGroup = paramViewGroup;
      ja localja = this.xKm;
      d.g.b.p.g(localja, "it");
      e.b((Context)localObject, localViewGroup, new q(localja));
      AppMethodBeat.o(75192);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$5"})
  static final class e
    implements Runnable
  {
    e(ja paramja, Context paramContext, ViewGroup paramViewGroup, agh paramagh) {}
    
    public final void run()
    {
      AppMethodBeat.i(75193);
      long l1 = paramagh.endTime;
      long l2 = paramagh.startTime;
      Object localObject = this.xKm;
      d.g.b.p.g(localObject, "it");
      localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.item.l((ja)localObject);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.l)localObject).zl(l1 - l2);
      e locale = e.xKl;
      e.a(paramContext, paramViewGroup, (com.tencent.mm.plugin.recordvideo.ui.editor.item.l)localObject);
      AppMethodBeat.o(75193);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.e
 * JD-Core Version:    0.7.0.1
 */