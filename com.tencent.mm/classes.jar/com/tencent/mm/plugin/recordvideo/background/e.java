package com.tencent.mm.plugin.recordvideo.background;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.i;
import com.tencent.mm.media.i.i.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.recordvideo.PluginVideoEditor;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.l;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.n;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.t;
import com.tencent.mm.plugin.recordvideo.util.g.a;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.fin;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.bf;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil;", "", "()V", "TAG", "", "damp", "", "getDamp", "()I", "setDamp", "(I)V", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "validAreaRect", "getValidAreaRect", "setValidAreaRect", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "visibleRect", "getVisibleRect", "checkMD5", "", "file", "destMD5", "cleanExpiredTask", "", "cleanNullData", "taskId", "cleanUnAvailableData", "convertBundleToJson", "bundle", "Landroid/os/Bundle;", "convertJsonToBundle", "jsonStr", "getAudioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "storyEditorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getFinderDataEditorItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "baseItemData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "context", "Landroid/content/Context;", "getLastDataIfNoMix", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "limitTime", "", "getRemuxTask", "getStoryCaptureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "getStoryDataEditorItem", "getStoryFileMD5", "Lcom/tencent/mm/protocal/protobuf/StoryEditorFileMD5;", "getUserData", "insertRemuxTask", "videoMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "editorData", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "extraConfig", "expiredTime", "blurBgPath", "scene", "", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "onUnSerializeStoryDataDrawingRect", "", "onUnSerializeStoryDataValidRect", "reStartMix", "reshowEmojiEditorItem", "emojiItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "reshowEmojiItem", "itemLayout", "Landroid/view/ViewGroup;", "item", "reshowLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "reshowLyricsItem", "reshowPositionEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "reshowPositionItem", "reshowStoryDataEditorItem", "reshowStoryDataEditorItemFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "targetWidth", "targetHeight", "targetRotation", "reshowTextEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "reshowTextItem", "reshowTipEditorItem", "reshowTipItem", "serializeStoryDataToByteArray", "timeStamp", "signVideoMixTime", "updateByLocal", "editData", "updateRemuxTaskState", "state", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final Rect LGX;
  private static final d NCY;
  public static final e NDU;
  private static Rect NDV;
  private static Rect NDW;
  private static int NDX;
  
  static
  {
    AppMethodBeat.i(75216);
    NDU = new e();
    NCY = ((PluginVideoEditor)com.tencent.mm.kernel.h.az(PluginVideoEditor.class)).getVideoEditorDataStorage();
    NDV = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
    NDW = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
    LGX = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
    NDX = 54;
    AppMethodBeat.o(75216);
  }
  
  public static com.tencent.mm.plugin.recordvideo.ui.editor.b.g a(ami paramami, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(279511);
    kotlin.g.b.s.u(paramami, "storyEditorProtoData");
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story as frame retriever");
    List localList = (List)new ArrayList();
    Object localObject1 = paramami.Znd;
    kotlin.g.b.s.s(localObject1, "storyEditorProtoData.baseItemData");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i;
    while (localIterator.hasNext())
    {
      localObject1 = (jy)localIterator.next();
      i = ((jy)localObject1).dataType;
      Object localObject2;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYd.value)
      {
        kotlin.g.b.s.s(localObject1, "it");
        localObject1 = new r((jy)localObject1);
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
        if (!((r)localObject1).isValid()) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.h)localObject2).e(null))
        {
          if (localObject1 == null) {
            break label188;
          }
          localList.add(localObject1);
          break;
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.s(paramContext);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject2).b((r)localObject1);
        }
      }
      else
      {
        label188:
        if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYe.value)
        {
          kotlin.g.b.s.s(localObject1, "it");
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jy)localObject1);
          Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the emoji editor item");
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f(paramContext);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject2).a((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1);
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.h)localObject2).e(null);
          if (localObject1 != null) {
            localList.add(localObject1);
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYf.value)
        {
          kotlin.g.b.s.s(localObject1, "it");
          localObject1 = new l((jy)localObject1);
          Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
          localObject2 = new q(paramContext);
          ((q)localObject2).a((l)localObject1);
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.h)localObject2).e(null);
          if (localObject1 != null) {
            localList.add(localObject1);
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYg.value)
        {
          kotlin.g.b.s.s(localObject1, "it");
          localObject1 = new r((jy)localObject1);
          Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
          if (!((r)localObject1).isValid()) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.h)localObject2).e(null))
          {
            if (localObject1 == null) {
              break label460;
            }
            localList.add(localObject1);
            break;
            localObject2 = new t(paramContext);
            ((t)localObject2).b((r)localObject1);
          }
        }
        else
        {
          label460:
          if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYh.value)
          {
            long l1 = paramami.endTime;
            long l2 = paramami.startTime;
            kotlin.g.b.s.s(localObject1, "it");
            localObject1 = new m((jy)localObject1);
            ((m)localObject1).tD(l1 - l2);
            Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
            localObject2 = new n(paramContext);
            ((n)localObject2).c((m)localObject1);
            localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.h)localObject2).e(null);
            if (localObject1 != null) {
              localList.add(localObject1);
            }
          }
        }
      }
    }
    if (localList.size() == 0)
    {
      AppMethodBeat.o(279511);
      return null;
    }
    if ((paramInt2 == 0) || (paramInt1 == 0))
    {
      Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "error width " + paramInt1 + " height " + paramInt2);
      AppMethodBeat.o(279511);
      return null;
    }
    paramContext = com.tencent.mm.plugin.recordvideo.util.g.Obu;
    paramContext = paramami.videoPath;
    kotlin.g.b.s.s(paramContext, "storyEditorProtoData.videoPath");
    paramContext = com.tencent.mm.plugin.recordvideo.util.g.aTF(paramContext);
    if (!paramami.nJW)
    {
      if ((paramContext != null) && (!paramContext.Obv)) {}
      for (i = 1; i != 0; i = 0)
      {
        paramami = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(b(paramami), c(paramami), localList, paramInt1, paramInt2, paramContext.width, paramContext.height, paramInt3, false, null, 768));
        AppMethodBeat.o(279511);
        return paramami;
      }
    }
    paramami = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(b(paramami), c(paramami), localList, paramInt1, paramInt2, 0, 0, paramInt3, false, null, 768));
    AppMethodBeat.o(279511);
    return paramami;
  }
  
  private static fin a(ami paramami)
  {
    AppMethodBeat.i(75207);
    kotlin.g.b.s.u(paramami, "storyEditorProtoData");
    fin localfin = new fin();
    localfin.abJr = y.bub(paramami.Ztf);
    localfin.abJq = y.bub(paramami.nBT);
    if (!Util.isNullOrNil((List)paramami.Zto))
    {
      localfin.abJp = "";
      localfin.abJt = "";
      Iterator localIterator = paramami.Zto.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localfin.abJt = kotlin.g.b.s.X(localfin.abJt, y.bub(str));
      }
    }
    localfin.abJp = y.bub(paramami.videoPath);
    localfin.abJt = "";
    if (com.tencent.matrix.trace.f.c.hm(localfin.abJp)) {
      localfin.abJp = "";
    }
    localfin.abJs = y.bub(paramami.thumbPath);
    AppMethodBeat.o(75207);
    return localfin;
  }
  
  public static String a(VideoMixer paramVideoMixer, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList, apw paramapw, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(75194);
    kotlin.g.b.s.u(paramVideoMixer, "videoMixer");
    kotlin.g.b.s.u(paramList, "editorData");
    kotlin.g.b.s.u(paramapw, "extraConfig");
    try
    {
      long l = System.currentTimeMillis();
      c localc = new c();
      localc.field_taskId = MD5Util.getMD5String((localc.hashCode() & 0x7FFFFFFF) + '#' + l);
      localc.field_timeStamp = l;
      localc.field_mixRetryTime = 0;
      localc.field_baseItemData = a(paramVideoMixer, l, paramList);
      paramList = c.b.NDQ;
      localc.field_status = c.b.gGI();
      l = paramLong;
      if (paramLong > 2592000000L) {
        l = 2592000000L;
      }
      localc.field_expiredTime = l;
      paramList = paramVideoMixer.gGZ();
      localc.field_targetWidth = paramList.videoWidth;
      localc.field_targetHeight = paramList.videoHeight;
      localc.field_videoBitrate = paramList.videoBitrate;
      localc.field_audioBitrate = paramList.audioBitrate;
      localc.field_audioSampleRate = paramList.audioSampleRate;
      localc.field_audioChannelCount = paramList.audioChannelCount;
      localc.field_frameRate = paramList.videoFrameRate;
      localc.field_videoRotate = paramList.nCg;
      localc.field_extraConfig = paramapw.toByteArray();
      paramVideoMixer = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localc.field_reportInfo = com.tencent.mm.plugin.recordvideo.f.c.gJe().gHG();
      localc.field_userData = aO(CaptureDataManager.NHH.rnY);
      paramVideoMixer = paramString;
      if (paramString == null) {
        paramVideoMixer = "";
      }
      localc.field_blurBgPath = paramVideoMixer;
      localc.field_fromScene = paramInt;
      boolean bool = NCY.insert((IAutoDBItem)localc);
      Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramList + ", ret:" + bool);
      paramVideoMixer = a.NDM;
      paramVideoMixer = localc.field_taskId;
      kotlin.g.b.s.s(paramVideoMixer, "videoEditorData.field_taskId");
      a.cz(paramInt, paramVideoMixer);
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
    kotlin.g.b.s.u(paramArrayOfByte1, "baseItemData");
    kotlin.g.b.s.u(paramMixConfig, "mixConfig");
    kotlin.g.b.s.u(paramArrayOfByte2, "extraConfig");
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        localc = new c();
        localc.field_taskId = MD5Util.getMD5String((localc.hashCode() & 0x7FFFFFFF) + '#' + l);
        localc.field_timeStamp = l;
        localc.field_mixRetryTime = 0;
        com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)new ami();
        try
        {
          locala.parseFrom(paramArrayOfByte1);
          paramArrayOfByte1 = locala;
        }
        catch (Exception paramArrayOfByte1)
        {
          boolean bool;
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte1 });
          paramArrayOfByte1 = null;
          continue;
          paramArrayOfByte1 = paramArrayOfByte1.toByteArray();
          continue;
        }
        paramArrayOfByte1 = (ami)paramArrayOfByte1;
        if (paramArrayOfByte1 == null) {
          break label427;
        }
        paramArrayOfByte1.timeStamp = l;
        paramArrayOfByte1.Ztl = a(paramArrayOfByte1);
      }
      catch (Exception paramArrayOfByte1)
      {
        c localc;
        Log.printErrStackTrace("MicroMsg.mix_background.VideoEditStorageUtil", (Throwable)paramArrayOfByte1, "", new Object[0]);
        AppMethodBeat.o(75195);
        return null;
      }
      localc.field_baseItemData = paramArrayOfByte1;
      paramArrayOfByte1 = c.b.NDQ;
      localc.field_status = c.b.gGI();
      localc.field_expiredTime = 2592000000L;
      localc.field_targetWidth = paramMixConfig.videoWidth;
      localc.field_targetHeight = paramMixConfig.videoHeight;
      localc.field_videoBitrate = paramMixConfig.videoBitrate;
      localc.field_audioBitrate = paramMixConfig.audioBitrate;
      localc.field_audioSampleRate = paramMixConfig.audioSampleRate;
      localc.field_audioChannelCount = paramMixConfig.audioChannelCount;
      localc.field_frameRate = paramMixConfig.videoFrameRate;
      localc.field_videoRotate = paramMixConfig.nCg;
      localc.field_extraConfig = paramArrayOfByte2;
      paramArrayOfByte1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localc.field_reportInfo = com.tencent.mm.plugin.recordvideo.f.c.gJe().gHG();
      localc.field_userData = aO(CaptureDataManager.NHH.rnY);
      localc.field_blurBgPath = "";
      localc.field_fromScene = paramInt;
      bool = NCY.insert((IAutoDBItem)localc);
      Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramMixConfig + ", ret:" + bool);
      paramArrayOfByte1 = a.NDM;
      paramArrayOfByte1 = localc.field_taskId;
      kotlin.g.b.s.s(paramArrayOfByte1, "videoEditorData.field_taskId");
      a.cz(paramInt, paramArrayOfByte1);
      paramArrayOfByte1 = localc.field_taskId;
      AppMethodBeat.o(75195);
      return paramArrayOfByte1;
      label427:
      if (paramArrayOfByte1 == null) {
        paramArrayOfByte1 = null;
      }
    }
  }
  
  public static ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> a(LinkedList<jy> paramLinkedList, Context paramContext)
  {
    AppMethodBeat.i(75208);
    kotlin.g.b.s.u(paramLinkedList, "baseItemData");
    kotlin.g.b.s.u(paramContext, "context");
    ArrayList localArrayList = new ArrayList();
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "get the editor data which is waiting for run mixing");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject1 = (jy)paramLinkedList.next();
      int i = ((jy)localObject1).dataType;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYd.value)
      {
        localObject1 = new r((jy)localObject1);
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.s(paramContext).d((r)localObject1));
      }
      else
      {
        Object localObject2;
        if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYe.value)
        {
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jy)localObject1);
          localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1).mgK;
          kotlin.g.b.s.checkNotNull(localObject2);
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e((EmojiInfo)localObject2, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).matrix);
          amh localamh = new amh();
          localamh.start = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.getStart();
          localamh.axI = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.getEnd();
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localObject2).NZv = localamh;
          localObject1 = ah.aiuX;
          localArrayList.add(localObject2);
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYf.value)
        {
          localArrayList.add(new q(paramContext).c(new l((jy)localObject1)));
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYg.value)
        {
          localArrayList.add(new t(paramContext).d(new r((jy)localObject1)));
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYh.value)
        {
          localArrayList.add(new n(paramContext).b(new m((jy)localObject1)));
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYi.value)
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYi;
          localObject1 = ((jy)localObject1).YMl.aaxD.Op;
          kotlin.g.b.s.s(localObject1, "it.itemData.buffer.bytes");
          localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject2, (byte[])localObject1)));
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYj.value)
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYj;
          localObject1 = ((jy)localObject1).YMl.aaxD.Op;
          kotlin.g.b.s.s(localObject1, "it.itemData.buffer.bytes");
          localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject2, (byte[])localObject1)));
        }
      }
    }
    AppMethodBeat.o(75208);
    return localArrayList;
  }
  
  private static final void a(Context paramContext, ViewGroup paramViewGroup, jy paramjy)
  {
    AppMethodBeat.i(279541);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramViewGroup, "$itemLayout");
    kotlin.g.b.s.s(paramjy, "it");
    paramjy = new r(paramjy);
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text item view");
    if (paramjy.isValid())
    {
      paramContext = new com.tencent.mm.plugin.recordvideo.ui.editor.item.s(paramContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      paramViewGroup.addView((View)paramContext, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext.b(paramjy);
    }
    AppMethodBeat.o(279541);
  }
  
  public static void a(ami paramami, Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(75210);
    kotlin.g.b.s.u(paramami, "storyEditorProtoData");
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramViewGroup, "itemLayout");
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story which has editor item");
    Object localObject = paramami.Znd;
    kotlin.g.b.s.s(localObject, "storyEditorProtoData.baseItemData");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      jy localjy = (jy)((Iterator)localObject).next();
      int i = localjy.dataType;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYd.value) {
        MMHandlerThread.postToMainThread(new e..ExternalSyntheticLambda0(paramContext, paramViewGroup, localjy));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYe.value) {
        MMHandlerThread.postToMainThread(new e..ExternalSyntheticLambda1(paramContext, paramViewGroup, localjy));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYf.value) {
        MMHandlerThread.postToMainThread(new e..ExternalSyntheticLambda2(paramContext, paramViewGroup, localjy));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYg.value) {
        MMHandlerThread.postToMainThread(new e..ExternalSyntheticLambda3(paramContext, paramViewGroup, localjy));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYh.value) {
        MMHandlerThread.postToMainThread(new e..ExternalSyntheticLambda4(paramami, localjy, paramContext, paramViewGroup));
      }
    }
    AppMethodBeat.o(75210);
  }
  
  private static final void a(ami paramami, jy paramjy, Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(279576);
    kotlin.g.b.s.u(paramami, "$storyEditorProtoData");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramViewGroup, "$itemLayout");
    long l1 = paramami.endTime;
    long l2 = paramami.startTime;
    kotlin.g.b.s.s(paramjy, "it");
    paramami = new m(paramjy);
    paramami.tD(l1 - l2);
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position item view");
    paramjy = new n(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    paramViewGroup.addView((View)paramjy, (ViewGroup.LayoutParams)paramContext);
    paramjy.c(paramami);
    AppMethodBeat.o(279576);
  }
  
  private static byte[] a(VideoMixer paramVideoMixer, long paramLong, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(75202);
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "is running serialize the videoEditorInfo to bytearray");
    ami localami = new ami();
    Object localObject1 = paramVideoMixer.NEk.NEp;
    float[] arrayOfFloat = paramVideoMixer.NEk.NEA;
    paramVideoMixer = paramVideoMixer.NEk.NEB;
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", kotlin.g.b.s.X("input the timeStamp is ", Long.valueOf(paramLong)));
    Object localObject2;
    if (((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGC == 3)
    {
      localObject2 = i.nDi;
      if (y.ZC(i.a.GQ(((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGx)))
      {
        localObject2 = i.nDi;
        localami.Ztf = i.a.GQ(((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGx);
      }
    }
    localami.timeStamp = paramLong;
    if (((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGz == -1L)
    {
      paramLong = 0L;
      localami.startTime = paramLong;
      localami.endTime = ((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGA;
      localami.thumbPath = ((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGy;
      localami.videoPath = ((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGx;
      localami.nJW = ((com.tencent.mm.plugin.recordvideo.c.c)localObject1).nJW;
      localObject2 = com.tencent.mm.plugin.sight.base.f.aVX(((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGx);
      if ((localObject2 != null) && ((((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGA == -1L) || (((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGA == 0L))) {
        localami.endTime = ((com.tencent.mm.plugin.sight.base.b)localObject2).videoDuration;
      }
      if (!Util.isNullOrNil((List)((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGD))
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.c.f.NGM;
        localami.endTime = com.tencent.mm.plugin.recordvideo.c.f.gHp();
      }
      if (localami.endTime <= 0L) {
        break label564;
      }
    }
    label564:
    for (paramLong = localami.endTime;; paramLong = 0L)
    {
      localami.endTime = paramLong;
      localami.Zto.addAll((Collection)((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGD);
      localami.nxj = ((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGC;
      localami.Ztg = ((int)arrayOfFloat[0]);
      localami.Zti = ((int)arrayOfFloat[1]);
      localami.Zth = ((int)arrayOfFloat[2]);
      localami.Ztj = ((int)arrayOfFloat[3]);
      localami.Znd = new LinkedList();
      if (paramVideoMixer != null)
      {
        localami.Ztq = ((int)paramVideoMixer[0]);
        localami.Zts = ((int)paramVideoMixer[1]);
        localami.Ztr = ((int)paramVideoMixer[2]);
        localami.Ztt = ((int)paramVideoMixer[3]);
      }
      paramVideoMixer = ((com.tencent.mm.plugin.recordvideo.c.c)localObject1).EEx;
      if (paramVideoMixer != null)
      {
        localami.nBT = paramVideoMixer.cachePath;
        localami.NID = paramVideoMixer.NID;
        localami.musicUrl = paramVideoMixer.musicUrl;
        localami.cached = paramVideoMixer.cached;
        localami.NIG = paramVideoMixer.NIG;
        localami.Ztm = paramVideoMixer.position;
        localami.Ztn = paramVideoMixer.NII;
      }
      localami.Ztl = a(localami);
      paramVideoMixer = ((Iterable)paramList).iterator();
      while (paramVideoMixer.hasNext())
      {
        paramList = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramVideoMixer.next();
        localObject1 = new jy();
        ((jy)localObject1).dataType = paramList.NXP.value;
        ((jy)localObject1).YMl = w.aN(paramList.gKs().toByteArray());
        localami.Znd.add(localObject1);
      }
      paramLong = ((com.tencent.mm.plugin.recordvideo.c.c)localObject1).NGz;
      break;
    }
    paramVideoMixer = localami.toByteArray();
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "storyEditorItem " + localami.videoPath + " thumb " + localami.thumbPath + " and result " + y.ZC(localami.thumbPath) + " music " + localami.nBT + " ret " + Util.getSizeKB(paramVideoMixer.length * 1L) + '}');
    kotlin.g.b.s.s(paramVideoMixer, "ret");
    AppMethodBeat.o(75202);
    return paramVideoMixer;
  }
  
  private static String aO(Bundle paramBundle)
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
    kotlin.g.b.s.s(paramBundle, "jsonObject.toString()");
    AppMethodBeat.o(75215);
    return paramBundle;
  }
  
  public static c aSP(String paramString)
  {
    AppMethodBeat.i(75197);
    kotlin.g.b.s.u(paramString, "taskId");
    paramString = NCY.aSO(paramString);
    AppMethodBeat.o(75197);
    return paramString;
  }
  
  public static void aSQ(String paramString)
  {
    AppMethodBeat.i(75198);
    kotlin.g.b.s.u(paramString, "taskId");
    c localc = NCY.aSO(paramString);
    if (localc != null)
    {
      localc.field_mixRetryTime += 1;
      NCY.a(paramString, localc);
    }
    AppMethodBeat.o(75198);
  }
  
  public static void aSR(String paramString)
  {
    AppMethodBeat.i(75203);
    kotlin.g.b.s.u(paramString, "taskId");
    d locald = NCY;
    kotlin.g.b.s.u(paramString, "taskId");
    locald.db.delete(d.ptT, "taskId=?", new String[] { kotlin.g.b.s.X("", paramString) });
    AppMethodBeat.o(75203);
  }
  
  public static void aSS(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(75204);
    kotlin.g.b.s.u(paramString, "taskId");
    paramString = NCY.aSO(paramString);
    localObject2 = (com.tencent.mm.bx.a)new ami();
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.field_baseItemData)
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
          Log.printDebugStack("safeParser", "", new Object[] { paramString });
          paramString = null;
          continue;
          int i = 0;
          continue;
          paramString = ((ami)localObject2).Ztf;
          continue;
          paramString = ((ami)localObject2).nBT;
          continue;
          paramString = ((ami)localObject2).thumbPath;
        }
      }
      localObject2 = (ami)paramString;
      Log.printInfoStack("MicroMsg.mix_background.VideoEditStorageUtil", "cleanUnAvailableData, videoPath " + localObject2 + "?.videoPath", new Object[0]);
      if ((localObject2 == null) || (((ami)localObject2).nJW != true)) {
        break;
      }
      i = 1;
      if (i != 0) {
        y.deleteFile(((ami)localObject2).videoPath);
      }
      if (localObject2 != null) {
        break label187;
      }
      paramString = null;
      y.deleteFile(paramString);
      if (localObject2 != null) {
        break label195;
      }
      paramString = null;
      y.deleteFile(paramString);
      if (localObject2 != null) {
        break label203;
      }
      paramString = localObject1;
      y.deleteFile(paramString);
      AppMethodBeat.o(75204);
      return;
    }
  }
  
  public static void aST(String paramString)
  {
    AppMethodBeat.i(75205);
    kotlin.g.b.s.u(paramString, "taskId");
    paramString = NCY.aSO(paramString);
    if (paramString != null)
    {
      paramString.field_mixRetryTime = 0;
      Object localObject = c.b.NDQ;
      paramString.field_status = c.b.gGI();
      NCY.a(paramString.bQs(), paramString);
      localObject = f.NDY;
      f.a(paramString, null);
    }
    AppMethodBeat.o(75205);
  }
  
  public static apw aSU(String paramString)
  {
    AppMethodBeat.i(279516);
    kotlin.g.b.s.u(paramString, "taskId");
    Object localObject = aSP(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(279516);
      return null;
    }
    paramString = (com.tencent.mm.bx.a)new apw();
    localObject = ((c)localObject).field_extraConfig;
    try
    {
      paramString.parseFrom((byte[])localObject);
      paramString = (apw)paramString;
      AppMethodBeat.o(279516);
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
  
  public static Bundle aSV(String paramString)
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
    kotlin.g.b.s.s(localIterator, "jsonObject.keys()");
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramString.get(str);
      if ((localObject instanceof String))
      {
        localBundle.putString(str, (String)localObject);
      }
      else if ((localObject instanceof Integer))
      {
        kotlin.g.b.s.s(localObject, "value");
        localBundle.putInt(str, ((Number)localObject).intValue());
      }
      else if ((localObject instanceof Long))
      {
        kotlin.g.b.s.s(localObject, "value");
        localBundle.putLong(str, ((Number)localObject).longValue());
      }
      else if ((localObject instanceof Boolean))
      {
        kotlin.g.b.s.s(localObject, "value");
        localBundle.putBoolean(str, ((Boolean)localObject).booleanValue());
      }
      else if ((localObject instanceof Byte))
      {
        kotlin.g.b.s.s(localObject, "value");
        localBundle.putByte(str, ((Number)localObject).byteValue());
      }
      else if ((localObject instanceof Character))
      {
        kotlin.g.b.s.s(localObject, "value");
        localBundle.putChar(str, ((Character)localObject).charValue());
      }
      else if ((localObject instanceof Float))
      {
        kotlin.g.b.s.s(localObject, "value");
        localBundle.putFloat(str, ((Number)localObject).floatValue());
      }
      else if ((localObject instanceof Short))
      {
        kotlin.g.b.s.s(localObject, "value");
        localBundle.putShort(str, ((Number)localObject).shortValue());
      }
      else if ((localObject instanceof Double))
      {
        kotlin.g.b.s.s(localObject, "value");
        localBundle.putDouble(str, ((Number)localObject).doubleValue());
      }
      else
      {
        localBundle.putString(str, localObject.toString());
      }
    }
    AppMethodBeat.o(75214);
    return localBundle;
  }
  
  public static ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> b(LinkedList<jy> paramLinkedList, Context paramContext)
  {
    AppMethodBeat.i(279499);
    kotlin.g.b.s.u(paramLinkedList, "baseItemData");
    kotlin.g.b.s.u(paramContext, "context");
    ArrayList localArrayList = new ArrayList();
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "get the editor data which is waiting for run mixing");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject1 = (jy)paramLinkedList.next();
      int i = ((jy)localObject1).dataType;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYd.value)
      {
        localObject1 = new r((jy)localObject1);
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.s(paramContext).d((r)localObject1));
      }
      else
      {
        Object localObject2;
        if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYe.value)
        {
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jy)localObject1);
          localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1).mgK;
          kotlin.g.b.s.checkNotNull(localObject2);
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e((EmojiInfo)localObject2, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).matrix);
          amh localamh = new amh();
          localamh.start = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.getStart();
          localamh.axI = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.getEnd();
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localObject2).NZv = localamh;
          localObject1 = ah.aiuX;
          localArrayList.add(localObject2);
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYf.value)
        {
          localArrayList.add(new q(paramContext).c(new l((jy)localObject1)));
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYg.value)
        {
          localArrayList.add(new t(paramContext).d(new r((jy)localObject1)));
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYh.value)
        {
          localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.g(paramContext).b(new m((jy)localObject1)));
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYi.value)
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYi;
          localObject1 = ((jy)localObject1).YMl.aaxD.Op;
          kotlin.g.b.s.s(localObject1, "it.itemData.buffer.bytes");
          localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject2, (byte[])localObject1)));
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYj.value)
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYj;
          localObject1 = ((jy)localObject1).YMl.aaxD.Op;
          kotlin.g.b.s.s(localObject1, "it.itemData.buffer.bytes");
          localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject2, (byte[])localObject1)));
        }
      }
    }
    AppMethodBeat.o(279499);
    return localArrayList;
  }
  
  private static final void b(Context paramContext, ViewGroup paramViewGroup, jy paramjy)
  {
    AppMethodBeat.i(279548);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramViewGroup, "$itemLayout");
    kotlin.g.b.s.s(paramjy, "it");
    paramjy = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e(paramjy);
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the emoji item view");
    paramContext = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    paramViewGroup.addView((View)paramContext, (ViewGroup.LayoutParams)localLayoutParams);
    paramContext.a(paramjy);
    paramContext.resume();
    AppMethodBeat.o(279548);
  }
  
  public static float[] b(ami paramami)
  {
    AppMethodBeat.i(75209);
    kotlin.g.b.s.u(paramami, "storyEditorProtoData");
    float f1 = paramami.Ztg;
    float f2 = paramami.Zti;
    float f3 = paramami.Zth;
    float f4 = paramami.Ztj;
    AppMethodBeat.o(75209);
    return new float[] { f1, f2, f3, f4 };
  }
  
  private static final void c(Context paramContext, ViewGroup paramViewGroup, jy paramjy)
  {
    AppMethodBeat.i(279556);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramViewGroup, "$itemLayout");
    kotlin.g.b.s.s(paramjy, "it");
    paramjy = new l(paramjy);
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position item view");
    paramContext = new q(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    paramViewGroup.addView((View)paramContext, (ViewGroup.LayoutParams)localLayoutParams);
    paramContext.a(paramjy);
    AppMethodBeat.o(279556);
  }
  
  public static float[] c(ami paramami)
  {
    AppMethodBeat.i(279501);
    kotlin.g.b.s.u(paramami, "storyEditorProtoData");
    float f1 = paramami.Ztq;
    float f2 = paramami.Zts;
    float f3 = paramami.Ztr;
    float f4 = paramami.Ztt;
    AppMethodBeat.o(279501);
    return new float[] { f1, f2, f3, f4 };
  }
  
  private static final void d(Context paramContext, ViewGroup paramViewGroup, jy paramjy)
  {
    AppMethodBeat.i(279564);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramViewGroup, "$itemLayout");
    kotlin.g.b.s.s(paramjy, "it");
    paramjy = new r(paramjy);
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text item view");
    if (paramjy.isValid())
    {
      paramContext = new t(paramContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      paramViewGroup.addView((View)paramContext, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext.b(paramjy);
    }
    AppMethodBeat.o(279564);
  }
  
  public static void gE(String paramString, int paramInt)
  {
    AppMethodBeat.i(75199);
    kotlin.g.b.s.u(paramString, "taskId");
    c localc = NCY.aSO(paramString);
    if (localc != null)
    {
      localc.field_status = paramInt;
      NCY.a(paramString, localc);
    }
    AppMethodBeat.o(75199);
  }
  
  public static Rect gGL()
  {
    return NDV;
  }
  
  public static Rect gGM()
  {
    return NDW;
  }
  
  public static int gGN()
  {
    return NDX;
  }
  
  public static void gGO()
  {
    AppMethodBeat.i(75200);
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", kotlin.g.b.s.X("clean expired task, num:", Integer.valueOf(NCY.db.delete(d.ptT, "timeStamp< ?-expiredTime", new String[] { kotlin.g.b.s.X("", Long.valueOf(System.currentTimeMillis())) }))));
    AppMethodBeat.o(75200);
  }
  
  public static void gGQ()
  {
    AppMethodBeat.i(75206);
    f localf = f.NDY;
    f.gGR();
    AppMethodBeat.o(75206);
  }
  
  public static Rect getVisibleRect()
  {
    return LGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.e
 * JD-Core Version:    0.7.0.1
 */