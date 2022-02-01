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
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.n;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.s;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.t;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ax;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil;", "", "()V", "TAG", "", "damp", "", "getDamp", "()I", "setDamp", "(I)V", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "validAreaRect", "getValidAreaRect", "setValidAreaRect", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "visibleRect", "getVisibleRect", "checkMD5", "", "file", "destMD5", "cleanExpiredTask", "", "cleanNullData", "taskId", "cleanUnAvailableData", "convertBundleToJson", "bundle", "Landroid/os/Bundle;", "convertJsonToBundle", "jsonStr", "getAudioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "storyEditorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getFinderDataEditorItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "baseItemData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "context", "Landroid/content/Context;", "getLastDataIfNoMix", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "limitTime", "", "getRemuxTask", "getStoryCaptureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "getStoryDataEditorItem", "getStoryFileMD5", "Lcom/tencent/mm/protocal/protobuf/StoryEditorFileMD5;", "getUserData", "insertRemuxTask", "videoMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "editorData", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "extraConfig", "expiredTime", "blurBgPath", "scene", "", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "onUnSerializeStoryDataDrawingRect", "", "onUnSerializeStoryDataValidRect", "reStartMix", "reshowEmojiEditorItem", "emojiItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "reshowEmojiItem", "itemLayout", "Landroid/view/ViewGroup;", "item", "reshowLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "reshowLyricsItem", "reshowPositionEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "reshowPositionItem", "reshowStoryDataEditorItem", "reshowStoryDataEditorItemFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "targetWidth", "targetHeight", "targetRotation", "reshowTextEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "reshowTextItem", "reshowTipEditorItem", "reshowTipItem", "serializeStoryDataToByteArray", "timeStamp", "signVideoMixTime", "updateByLocal", "editData", "updateRemuxTaskState", "state", "plugin-recordvideo_release"})
public final class e
{
  private static final Rect FLS;
  private static final d HFw;
  private static Rect HGw;
  private static Rect HGx;
  private static int HGy;
  public static final e HGz;
  
  static
  {
    AppMethodBeat.i(75216);
    HGz = new e();
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.ag(PluginVideoEditor.class);
    p.j(locala, "MMKernel.plugin(PluginVideoEditor::class.java)");
    HFw = ((PluginVideoEditor)locala).getVideoEditorDataStorage();
    HGw = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
    HGx = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
    FLS = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
    HGy = 54;
    AppMethodBeat.o(75216);
  }
  
  public static com.tencent.mm.plugin.recordvideo.ui.editor.b.g a(ajd paramajd, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(216525);
    p.k(paramajd, "storyEditorProtoData");
    p.k(paramContext, "context");
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story as frame retriever");
    List localList = (List)new ArrayList();
    Object localObject1 = paramajd.Sor;
    p.j(localObject1, "storyEditorProtoData.baseItemData");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (jc)localIterator.next();
      int i = ((jc)localObject1).dataType;
      Object localObject2;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbG.value)
      {
        p.j(localObject1, "it");
        localObject1 = new r((jc)localObject1);
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
        if (!((r)localObject1).isValid()) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.h)localObject2).c(null))
        {
          if (localObject1 == null) {
            break label185;
          }
          localList.add(localObject1);
          break;
          localObject2 = new s(paramContext);
          ((s)localObject2).b((r)localObject1);
        }
      }
      else
      {
        label185:
        if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbH.value)
        {
          p.j(localObject1, "it");
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jc)localObject1);
          Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the emoji editor item");
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f(paramContext);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject2).a((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1);
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.h)localObject2).c(null);
          if (localObject1 != null) {
            localList.add(localObject1);
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbI.value)
        {
          p.j(localObject1, "it");
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.l((jc)localObject1);
          Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
          localObject2 = new q(paramContext);
          ((q)localObject2).a((com.tencent.mm.plugin.recordvideo.ui.editor.item.l)localObject1);
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.h)localObject2).c(null);
          if (localObject1 != null) {
            localList.add(localObject1);
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbJ.value)
        {
          p.j(localObject1, "it");
          localObject1 = new r((jc)localObject1);
          Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
          if (!((r)localObject1).isValid()) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.h)localObject2).c(null))
          {
            if (localObject1 == null) {
              break label448;
            }
            localList.add(localObject1);
            break;
            localObject2 = new t(paramContext);
            ((t)localObject2).b((r)localObject1);
          }
        }
        else
        {
          label448:
          if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbK.value)
          {
            long l1 = paramajd.endTime;
            long l2 = paramajd.startTime;
            p.j(localObject1, "it");
            localObject1 = new m((jc)localObject1);
            ((m)localObject1).PD(l1 - l2);
            Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
            localObject2 = new n(paramContext);
            ((n)localObject2).c((m)localObject1);
            localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.h)localObject2).c(null);
            if (localObject1 != null) {
              localList.add(localObject1);
            }
          }
        }
      }
    }
    if (localList.size() == 0)
    {
      AppMethodBeat.o(216525);
      return null;
    }
    if ((paramInt2 == 0) || (paramInt1 == 0))
    {
      Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "error width " + paramInt1 + " height " + paramInt2);
      AppMethodBeat.o(216525);
      return null;
    }
    paramContext = com.tencent.mm.plugin.recordvideo.e.e.Ife;
    paramContext = paramajd.videoPath;
    p.j(paramContext, "storyEditorProtoData.videoPath");
    paramContext = com.tencent.mm.plugin.recordvideo.e.e.aWt(paramContext);
    if ((!paramajd.lfl) && (paramContext != null) && (!paramContext.Iff))
    {
      paramajd = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(b(paramajd), c(paramajd), localList, paramInt1, paramInt2, paramContext.width, paramContext.height, paramInt3, false, null, 768));
      AppMethodBeat.o(216525);
      return paramajd;
    }
    paramajd = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(b(paramajd), c(paramajd), localList, paramInt1, paramInt2, 0, 0, paramInt3, false, null, 768));
    AppMethodBeat.o(216525);
    return paramajd;
  }
  
  private static enp a(ajd paramajd)
  {
    AppMethodBeat.i(75207);
    p.k(paramajd, "storyEditorProtoData");
    enp localenp = new enp();
    localenp.Uqs = u.buc(paramajd.Stv);
    localenp.Uqr = u.buc(paramajd.kXi);
    if (!Util.isNullOrNil((List)paramajd.StE))
    {
      localenp.Uqq = "";
      localenp.Uqu = "";
      Iterator localIterator = paramajd.StE.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = localenp.Uqu;
        localenp.Uqu = (str2 + u.buc(str1));
      }
    }
    localenp.Uqq = u.buc(paramajd.videoPath);
    localenp.Uqu = "";
    if (com.tencent.matrix.trace.g.b.fK(localenp.Uqq)) {
      localenp.Uqq = "";
    }
    localenp.Uqt = u.buc(paramajd.thumbPath);
    AppMethodBeat.o(75207);
    return localenp;
  }
  
  public static String a(VideoMixer paramVideoMixer, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList, ame paramame, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(75194);
    p.k(paramVideoMixer, "videoMixer");
    p.k(paramList, "editorData");
    p.k(paramame, "extraConfig");
    try
    {
      long l = System.currentTimeMillis();
      c localc = new c();
      localc.field_taskId = MD5Util.getMD5String((localc.hashCode() & 0x7FFFFFFF) + '#' + l);
      localc.field_timeStamp = l;
      localc.field_mixRetryTime = 0;
      localc.field_baseItemData = a(paramVideoMixer, l, paramList);
      paramList = c.b.HGu;
      localc.field_status = c.b.fuS();
      l = paramLong;
      if (paramLong > 2592000000L) {
        l = 2592000000L;
      }
      localc.field_expiredTime = l;
      paramList = paramVideoMixer.fvj();
      localc.field_targetWidth = paramList.videoWidth;
      localc.field_targetHeight = paramList.videoHeight;
      localc.field_videoBitrate = paramList.videoBitrate;
      localc.field_audioBitrate = paramList.audioBitrate;
      localc.field_audioSampleRate = paramList.audioSampleRate;
      localc.field_audioChannelCount = paramList.audioChannelCount;
      localc.field_frameRate = paramList.videoFrameRate;
      localc.field_videoRotate = paramList.kWG;
      localc.field_extraConfig = paramame.toByteArray();
      paramVideoMixer = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      localc.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.c.fxp().fvY();
      paramVideoMixer = CaptureDataManager.HKJ;
      p.j(paramVideoMixer, "CaptureDataManager.INSTANCE");
      localc.field_userData = aq(paramVideoMixer.getExtData());
      paramVideoMixer = paramString;
      if (paramString == null) {
        paramVideoMixer = "";
      }
      localc.field_blurBgPath = paramVideoMixer;
      localc.field_fromScene = paramInt;
      boolean bool = HFw.insert((IAutoDBItem)localc);
      Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramList + ", ret:" + bool);
      paramVideoMixer = a.HGl;
      paramVideoMixer = localc.field_taskId;
      p.j(paramVideoMixer, "videoEditorData.field_taskId");
      a.bR(paramInt, paramVideoMixer);
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
    p.k(paramArrayOfByte1, "baseItemData");
    p.k(paramMixConfig, "mixConfig");
    p.k(paramArrayOfByte2, "extraConfig");
    try
    {
      long l = System.currentTimeMillis();
      c localc = new c();
      localc.field_taskId = MD5Util.getMD5String((localc.hashCode() & 0x7FFFFFFF) + '#' + l);
      localc.field_timeStamp = l;
      localc.field_mixRetryTime = 0;
      com.tencent.mm.cd.a locala = (com.tencent.mm.cd.a)new ajd();
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
      paramArrayOfByte1 = (ajd)paramArrayOfByte1;
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1.timeStamp = l;
        paramArrayOfByte1.StB = a(paramArrayOfByte1);
      }
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1 = paramArrayOfByte1.toByteArray();
        localc.field_baseItemData = paramArrayOfByte1;
        paramArrayOfByte1 = c.b.HGu;
        localc.field_status = c.b.fuS();
        localc.field_expiredTime = 2592000000L;
        localc.field_targetWidth = paramMixConfig.videoWidth;
        localc.field_targetHeight = paramMixConfig.videoHeight;
        localc.field_videoBitrate = paramMixConfig.videoBitrate;
        localc.field_audioBitrate = paramMixConfig.audioBitrate;
        localc.field_audioSampleRate = paramMixConfig.audioSampleRate;
        localc.field_audioChannelCount = paramMixConfig.audioChannelCount;
        localc.field_frameRate = paramMixConfig.videoFrameRate;
        localc.field_videoRotate = paramMixConfig.kWG;
        localc.field_extraConfig = paramArrayOfByte2;
        paramArrayOfByte1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        localc.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.c.fxp().fvY();
        paramArrayOfByte1 = CaptureDataManager.HKJ;
        p.j(paramArrayOfByte1, "CaptureDataManager.INSTANCE");
        localc.field_userData = aq(paramArrayOfByte1.getExtData());
        localc.field_blurBgPath = "";
        localc.field_fromScene = paramInt;
        bool = HFw.insert((IAutoDBItem)localc);
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramMixConfig + ", ret:" + bool);
        paramArrayOfByte1 = a.HGl;
        paramArrayOfByte1 = localc.field_taskId;
        p.j(paramArrayOfByte1, "videoEditorData.field_taskId");
        a.bR(paramInt, paramArrayOfByte1);
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
  
  public static ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> a(LinkedList<jc> paramLinkedList, Context paramContext)
  {
    AppMethodBeat.i(75208);
    p.k(paramLinkedList, "baseItemData");
    p.k(paramContext, "context");
    ArrayList localArrayList = new ArrayList();
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "get the editor data which is waiting for run mixing");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject2 = (jc)paramLinkedList.next();
      int i = ((jc)localObject2).dataType;
      Object localObject1;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbG.value)
      {
        localObject1 = new r((jc)localObject2);
        localArrayList.add(new s(paramContext).d((r)localObject1));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbH.value)
      {
        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jc)localObject2);
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1).jHh;
        if (localObject2 == null) {
          p.iCn();
        }
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e((EmojiInfo)localObject2, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).aHZ);
        ajc localajc = new ajc();
        localajc.start = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.getStart();
        localajc.aYz = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.getEnd();
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localObject2).IcZ = localajc;
        localArrayList.add(localObject2);
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbI.value)
      {
        localArrayList.add(new q(paramContext).c(new com.tencent.mm.plugin.recordvideo.ui.editor.item.l((jc)localObject2)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbJ.value)
      {
        localArrayList.add(new t(paramContext).d(new r((jc)localObject2)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbK.value)
      {
        localArrayList.add(new n(paramContext).b(new m((jc)localObject2)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbL.value)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbL;
        localObject2 = ((jc)localObject2).ROY;
        p.j(localObject2, "it.itemData");
        localObject2 = ((eae)localObject2).Tkb;
        p.j(localObject2, "it.itemData.buffer");
        localObject2 = ((com.tencent.mm.cd.b)localObject2).UH;
        p.j(localObject2, "it.itemData.buffer.bytes");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject1, (byte[])localObject2)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbM.value)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbM;
        localObject2 = ((jc)localObject2).ROY;
        p.j(localObject2, "it.itemData");
        localObject2 = ((eae)localObject2).Tkb;
        p.j(localObject2, "it.itemData.buffer");
        localObject2 = ((com.tencent.mm.cd.b)localObject2).UH;
        p.j(localObject2, "it.itemData.buffer.bytes");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject1, (byte[])localObject2)));
      }
    }
    AppMethodBeat.o(75208);
    return localArrayList;
  }
  
  public static void a(final ajd paramajd, final Context paramContext, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(75210);
    p.k(paramajd, "storyEditorProtoData");
    p.k(paramContext, "context");
    p.k(paramViewGroup, "itemLayout");
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story which has editor item");
    Object localObject = paramajd.Sor;
    p.j(localObject, "storyEditorProtoData.baseItemData");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      jc localjc = (jc)((Iterator)localObject).next();
      int i = localjc.dataType;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbG.value) {
        MMHandlerThread.postToMainThread((Runnable)new a(localjc, paramContext, paramViewGroup, paramajd));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbH.value) {
        MMHandlerThread.postToMainThread((Runnable)new b(localjc, paramContext, paramViewGroup, paramajd));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbI.value) {
        MMHandlerThread.postToMainThread((Runnable)new c(localjc, paramContext, paramViewGroup, paramajd));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbJ.value) {
        MMHandlerThread.postToMainThread((Runnable)new d(localjc, paramContext, paramViewGroup, paramajd));
      } else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbK.value) {
        MMHandlerThread.postToMainThread((Runnable)new e(localjc, paramContext, paramViewGroup, paramajd));
      }
    }
    AppMethodBeat.o(75210);
  }
  
  private static byte[] a(VideoMixer paramVideoMixer, long paramLong, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(75202);
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "is running serialize the videoEditorInfo to bytearray");
    ajd localajd = new ajd();
    Object localObject1 = paramVideoMixer.HHa.HGS;
    float[] arrayOfFloat = paramVideoMixer.HHa.HHg;
    paramVideoMixer = paramVideoMixer.HHa.HHh;
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "input the timeStamp is ".concat(String.valueOf(paramLong)));
    Object localObject2;
    if (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJD == 3)
    {
      localObject2 = j.kYa;
      if (u.agG(j.a.OA(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJy)))
      {
        localObject2 = j.kYa;
        localajd.Stv = j.a.OA(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJy);
      }
    }
    localajd.timeStamp = paramLong;
    if (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJA == -1L)
    {
      paramLong = 0L;
      localajd.startTime = paramLong;
      localajd.endTime = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJB;
      localajd.thumbPath = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJz;
      localajd.videoPath = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJy;
      localajd.lfl = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).lfl;
      localObject2 = com.tencent.mm.plugin.sight.base.f.aYg(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJy);
      if ((localObject2 != null) && ((((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJB == -1L) || (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJB == 0L))) {
        localajd.endTime = ((com.tencent.mm.plugin.sight.base.b)localObject2).videoDuration;
      }
      if (!Util.isNullOrNil((List)((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJE))
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.b.f.HJU;
        localajd.endTime = com.tencent.mm.plugin.recordvideo.b.f.fvB();
      }
      if (localajd.endTime <= 0L) {
        break label564;
      }
    }
    label564:
    for (paramLong = localajd.endTime;; paramLong = 0L)
    {
      localajd.endTime = paramLong;
      localajd.StE.addAll((Collection)((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJE);
      localajd.kRX = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJD;
      localajd.Stw = ((int)arrayOfFloat[0]);
      localajd.Sty = ((int)arrayOfFloat[1]);
      localajd.Stx = ((int)arrayOfFloat[2]);
      localajd.Stz = ((int)arrayOfFloat[3]);
      localajd.Sor = new LinkedList();
      if (paramVideoMixer != null)
      {
        localajd.StG = ((int)paramVideoMixer[0]);
        localajd.StI = ((int)paramVideoMixer[1]);
        localajd.StH = ((int)paramVideoMixer[2]);
        localajd.StJ = ((int)paramVideoMixer[3]);
      }
      paramVideoMixer = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).zBD;
      if (paramVideoMixer != null)
      {
        localajd.kXi = paramVideoMixer.cachePath;
        localajd.HLC = paramVideoMixer.HLC;
        localajd.musicUrl = paramVideoMixer.musicUrl;
        localajd.aGs = paramVideoMixer.aGs;
        localajd.HLF = paramVideoMixer.HLF;
        localajd.StC = paramVideoMixer.position;
        localajd.StD = paramVideoMixer.HLI;
      }
      localajd.StB = a(localajd);
      paramVideoMixer = ((Iterable)paramList).iterator();
      while (paramVideoMixer.hasNext())
      {
        paramList = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramVideoMixer.next();
        localObject1 = new jc();
        ((jc)localObject1).dataType = paramList.Ibt.value;
        ((jc)localObject1).ROY = z.aN(paramList.fyG().toByteArray());
        localajd.Sor.add(localObject1);
      }
      paramLong = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).HJA;
      break;
    }
    paramVideoMixer = localajd.toByteArray();
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "storyEditorItem " + localajd.videoPath + " thumb " + localajd.thumbPath + " and result " + u.agG(localajd.thumbPath) + " music " + localajd.kXi + " ret " + Util.getSizeKB(paramVideoMixer.length * 1L) + '}');
    p.j(paramVideoMixer, "ret");
    AppMethodBeat.o(75202);
    return paramVideoMixer;
  }
  
  public static c aVH(String paramString)
  {
    AppMethodBeat.i(75197);
    p.k(paramString, "taskId");
    paramString = HFw.aVG(paramString);
    AppMethodBeat.o(75197);
    return paramString;
  }
  
  public static void aVI(String paramString)
  {
    AppMethodBeat.i(75198);
    p.k(paramString, "taskId");
    c localc = HFw.aVG(paramString);
    if (localc != null)
    {
      localc.field_mixRetryTime += 1;
      HFw.a(paramString, localc);
      AppMethodBeat.o(75198);
      return;
    }
    AppMethodBeat.o(75198);
  }
  
  public static void aVJ(String paramString)
  {
    AppMethodBeat.i(75203);
    p.k(paramString, "taskId");
    d locald = HFw;
    p.k(paramString, "taskId");
    locald.db.delete(d.Alf, "taskId=?", new String[] { String.valueOf(paramString) });
    AppMethodBeat.o(75203);
  }
  
  public static void aVK(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(75204);
    p.k(paramString, "taskId");
    paramString = HFw.aVG(paramString);
    Object localObject2 = (com.tencent.mm.cd.a)new ajd();
    if (paramString != null) {}
    for (paramString = paramString.field_baseItemData;; paramString = null)
    {
      try
      {
        ((com.tencent.mm.cd.a)localObject2).parseFrom(paramString);
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
      localObject2 = (ajd)paramString;
      Log.printInfoStack("MicroMsg.mix_background.VideoEditStorageUtil", "cleanUnAvailableData, videoPath " + localObject2 + "?.videoPath", new Object[0]);
      if ((localObject2 != null) && (((ajd)localObject2).lfl == true)) {
        u.deleteFile(((ajd)localObject2).videoPath);
      }
      if (localObject2 == null) {
        break;
      }
      paramString = ((ajd)localObject2).Stv;
      u.deleteFile(paramString);
      if (localObject2 == null) {
        break label192;
      }
      paramString = ((ajd)localObject2).kXi;
      u.deleteFile(paramString);
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = ((ajd)localObject2).thumbPath;
      }
      u.deleteFile(paramString);
      AppMethodBeat.o(75204);
      return;
    }
  }
  
  public static void aVL(String paramString)
  {
    AppMethodBeat.i(75205);
    p.k(paramString, "taskId");
    paramString = HFw.aVG(paramString);
    if (paramString != null)
    {
      paramString.field_mixRetryTime = 0;
      Object localObject = c.b.HGu;
      paramString.field_status = c.b.fuS();
      HFw.a(paramString.bsL(), paramString);
      localObject = f.HGG;
      f.a(paramString, null);
    }
    AppMethodBeat.o(75205);
  }
  
  public static ame aVM(String paramString)
  {
    AppMethodBeat.i(216526);
    p.k(paramString, "taskId");
    Object localObject = aVH(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(216526);
      return null;
    }
    paramString = (com.tencent.mm.cd.a)new ame();
    localObject = ((c)localObject).field_extraConfig;
    try
    {
      paramString.parseFrom((byte[])localObject);
      paramString = (ame)paramString;
      AppMethodBeat.o(216526);
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
  
  public static Bundle aVN(String paramString)
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
    p.j(localIterator, "jsonObject.keys()");
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
  
  private static String aq(Bundle paramBundle)
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
    p.j(paramBundle, "jsonObject.toString()");
    AppMethodBeat.o(75215);
    return paramBundle;
  }
  
  public static ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> b(LinkedList<jc> paramLinkedList, Context paramContext)
  {
    AppMethodBeat.i(216519);
    p.k(paramLinkedList, "baseItemData");
    p.k(paramContext, "context");
    ArrayList localArrayList = new ArrayList();
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "get the editor data which is waiting for run mixing");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject2 = (jc)paramLinkedList.next();
      int i = ((jc)localObject2).dataType;
      Object localObject1;
      if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbG.value)
      {
        localObject1 = new r((jc)localObject2);
        localArrayList.add(new s(paramContext).d((r)localObject1));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbH.value)
      {
        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jc)localObject2);
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1).jHh;
        if (localObject2 == null) {
          p.iCn();
        }
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e((EmojiInfo)localObject2, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).aHZ);
        ajc localajc = new ajc();
        localajc.start = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.getStart();
        localajc.aYz = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.getEnd();
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localObject2).IcZ = localajc;
        localArrayList.add(localObject2);
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbI.value)
      {
        localArrayList.add(new q(paramContext).c(new com.tencent.mm.plugin.recordvideo.ui.editor.item.l((jc)localObject2)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbJ.value)
      {
        localArrayList.add(new t(paramContext).d(new r((jc)localObject2)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbK.value)
      {
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.g(paramContext).b(new m((jc)localObject2)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbL.value)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbL;
        localObject2 = ((jc)localObject2).ROY;
        p.j(localObject2, "it.itemData");
        localObject2 = ((eae)localObject2).Tkb;
        p.j(localObject2, "it.itemData.buffer");
        localObject2 = ((com.tencent.mm.cd.b)localObject2).UH;
        p.j(localObject2, "it.itemData.buffer.bytes");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject1, (byte[])localObject2)));
      }
      else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbM.value)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbM;
        localObject2 = ((jc)localObject2).ROY;
        p.j(localObject2, "it.itemData");
        localObject2 = ((eae)localObject2).Tkb;
        p.j(localObject2, "it.itemData.buffer");
        localObject2 = ((com.tencent.mm.cd.b)localObject2).UH;
        p.j(localObject2, "it.itemData.buffer.bytes");
        localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject1, (byte[])localObject2)));
      }
    }
    AppMethodBeat.o(216519);
    return localArrayList;
  }
  
  public static float[] b(ajd paramajd)
  {
    AppMethodBeat.i(75209);
    p.k(paramajd, "storyEditorProtoData");
    float f1 = paramajd.Stw;
    float f2 = paramajd.Sty;
    float f3 = paramajd.Stx;
    float f4 = paramajd.Stz;
    AppMethodBeat.o(75209);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static float[] c(ajd paramajd)
  {
    AppMethodBeat.i(216522);
    p.k(paramajd, "storyEditorProtoData");
    float f1 = paramajd.StG;
    float f2 = paramajd.StI;
    float f3 = paramajd.StH;
    float f4 = paramajd.StJ;
    AppMethodBeat.o(216522);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static void fM(String paramString, int paramInt)
  {
    AppMethodBeat.i(75199);
    p.k(paramString, "taskId");
    c localc = HFw.aVG(paramString);
    if (localc != null)
    {
      localc.field_status = paramInt;
      HFw.a(paramString, localc);
      AppMethodBeat.o(75199);
      return;
    }
    AppMethodBeat.o(75199);
  }
  
  public static Rect fuV()
  {
    return HGw;
  }
  
  public static Rect fuW()
  {
    return HGx;
  }
  
  public static int fuX()
  {
    return HGy;
  }
  
  public static void fuY()
  {
    AppMethodBeat.i(75200);
    Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "clean expired task, num:".concat(String.valueOf(HFw.db.delete(d.Alf, "timeStamp< ?-expiredTime", new String[] { System.currentTimeMillis() }))));
    AppMethodBeat.o(75200);
  }
  
  public static void fva()
  {
    AppMethodBeat.i(75206);
    f localf = f.HGG;
    f.fvb();
    AppMethodBeat.o(75206);
  }
  
  public static Rect getVisibleRect()
  {
    return FLS;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$1"})
  static final class a
    implements Runnable
  {
    a(jc paramjc, Context paramContext, ViewGroup paramViewGroup, ajd paramajd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75189);
      Object localObject = e.HGz;
      localObject = paramContext;
      ViewGroup localViewGroup = paramViewGroup;
      jc localjc = this.HGA;
      p.j(localjc, "it");
      e.a((Context)localObject, localViewGroup, new r(localjc));
      AppMethodBeat.o(75189);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$2"})
  static final class b
    implements Runnable
  {
    b(jc paramjc, Context paramContext, ViewGroup paramViewGroup, ajd paramajd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75190);
      Object localObject = e.HGz;
      localObject = paramContext;
      ViewGroup localViewGroup = paramViewGroup;
      jc localjc = this.HGA;
      p.j(localjc, "it");
      e.a((Context)localObject, localViewGroup, new com.tencent.mm.plugin.recordvideo.ui.editor.item.e(localjc));
      AppMethodBeat.o(75190);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$3"})
  static final class c
    implements Runnable
  {
    c(jc paramjc, Context paramContext, ViewGroup paramViewGroup, ajd paramajd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75191);
      Object localObject = e.HGz;
      localObject = paramContext;
      ViewGroup localViewGroup = paramViewGroup;
      jc localjc = this.HGA;
      p.j(localjc, "it");
      e.a((Context)localObject, localViewGroup, new com.tencent.mm.plugin.recordvideo.ui.editor.item.l(localjc));
      AppMethodBeat.o(75191);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$4"})
  static final class d
    implements Runnable
  {
    d(jc paramjc, Context paramContext, ViewGroup paramViewGroup, ajd paramajd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75192);
      Object localObject = e.HGz;
      localObject = paramContext;
      ViewGroup localViewGroup = paramViewGroup;
      jc localjc = this.HGA;
      p.j(localjc, "it");
      e.b((Context)localObject, localViewGroup, new r(localjc));
      AppMethodBeat.o(75192);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$5"})
  static final class e
    implements Runnable
  {
    e(jc paramjc, Context paramContext, ViewGroup paramViewGroup, ajd paramajd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75193);
      long l1 = paramajd.endTime;
      long l2 = paramajd.startTime;
      Object localObject = this.HGA;
      p.j(localObject, "it");
      localObject = new m((jc)localObject);
      ((m)localObject).PD(l1 - l2);
      e locale = e.HGz;
      e.a(paramContext, paramViewGroup, (m)localObject);
      AppMethodBeat.o(75193);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.e
 * JD-Core Version:    0.7.0.1
 */