package com.tencent.mm.plugin.recordvideo.background;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.j.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.recordvideo.PluginVideoEditor;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.protocal.protobuf.dks;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ap;
import com.tencent.mm.vfs.i;
import d.l;
import d.n.n;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil;", "", "()V", "TAG", "", "damp", "", "getDamp", "()I", "setDamp", "(I)V", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "validAreaRect", "getValidAreaRect", "setValidAreaRect", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "checkMD5", "", "file", "destMD5", "checkVideoEditorFileMD5", "storyEditorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "cleanExpiredTask", "", "cleanNullData", "taskId", "cleanUnAvailableData", "convertBundleToJson", "bundle", "Landroid/os/Bundle;", "convertJsonToBundle", "jsonStr", "deleteRemuxTask", "getAudioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getExtrConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getLastDataIfNoMix", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "limitTime", "", "getRemuxTask", "getStoryCaptureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "getStoryDataEditorItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "baseItemData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "context", "Landroid/content/Context;", "getStoryFileMD5", "Lcom/tencent/mm/protocal/protobuf/StoryEditorFileMD5;", "getUserData", "insertRemuxTask", "videoMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "editorDatas", "", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "extraConfig", "expiredTime", "blurBgPath", "scene", "", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "onUnSerializeStoryDataDrawingRect", "", "reStartMix", "reshowEmojiEditorItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "viewMatrix", "Landroid/graphics/Matrix;", "reshowEmojiItem", "itemLayout", "Landroid/view/ViewGroup;", "reshowLyricsEditorItem", "lyricsList", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "duration", "reshowLyricsItem", "reshowPositionEditorItem", "cityName", "poiName", "longitude", "", "latitude", "reshowPositionItem", "reshowStoryDataEditorItem", "reshowStoryDataEditorItemFrame", "Lcom/tencent/mm/plugin/recordvideo/background/StoryFrameRetriever;", "targetWidth", "targetHeight", "targetRotation", "reshowTextEditorItem", "text", "", "textColor", "textBgColor", "reshowTextItem", "reshowTipEditorItem", "marginBottom", "reshowTipItem", "serializeStoryDataToByteArray", "timeStamp", "signVideoMixTime", "updateByLocal", "editData", "updateRemuxTaskState", "state", "IVideoEditStorage", "plugin-recordvideo_release"})
public final class f
{
  private static Rect gpG;
  private static final e vcx;
  private static Rect vdF;
  private static int vdG;
  public static final f vdH;
  
  static
  {
    AppMethodBeat.i(75216);
    vdH = new f();
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(PluginVideoEditor.class);
    d.g.b.k.g(locala, "MMKernel.plugin(PluginVideoEditor::class.java)");
    vcx = ((PluginVideoEditor)locala).getVideoEditorDataStorage();
    gpG = new Rect(0, 0, ap.cf(aj.getContext()).x, ap.cf(aj.getContext()).y);
    vdF = new Rect(0, 0, ap.cf(aj.getContext()).x, ap.cf(aj.getContext()).y);
    vdG = 54;
    AppMethodBeat.o(75216);
  }
  
  private static com.tencent.mm.media.editor.a.b a(List<? extends bmx> paramList, Matrix paramMatrix, Context paramContext, long paramLong)
  {
    AppMethodBeat.i(75212);
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
    paramContext = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e(paramContext);
    paramContext.setViewMatrix(paramMatrix);
    paramMatrix = new ArrayList();
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label116:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((bmx)localObject2).startTime < paramLong) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label116;
        }
        paramList.add(localObject2);
        break;
      }
    }
    paramMatrix.addAll((Collection)paramList);
    paramContext.eQ((List)paramMatrix);
    paramList = paramContext.c(null);
    AppMethodBeat.o(75212);
    return paramList;
  }
  
  public static c a(acq paramacq, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(75211);
    d.g.b.k.h(paramacq, "storyEditorProtoData");
    d.g.b.k.h(paramContext, "context");
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story as frame retriever");
    List localList = (List)new ArrayList();
    Object localObject1 = paramacq.Dde;
    d.g.b.k.g(localObject1, "storyEditorProtoData.baseItemData");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject7 = (in)localIterator.next();
      int i = ((in)localObject7).dataType;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      Object localObject2;
      int j;
      int k;
      if (i == com.tencent.mm.media.editor.a.e.goG.value)
      {
        localObject1 = (com.tencent.mm.bx.a)new dbn();
        localObject7 = ((in)localObject7).CEe;
        d.g.b.k.g(localObject7, "it.itemData");
        localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
        d.g.b.k.g(localObject7, "it.itemData.buffer");
        localObject7 = ((com.tencent.mm.bx.b)localObject7).getBytes();
        try
        {
          ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject7);
          localObject7 = (dbn)localObject1;
          if (localObject7 == null) {
            continue;
          }
          ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((dbn)localObject7).text);
          localObject1 = new Matrix();
          localObject8 = new float[9];
          i = 0;
          localObject9 = ((dbn)localObject7).DKf.DmV;
          d.g.b.k.g(localObject9, "it.matrix.value");
          localObject9 = ((Iterable)localObject9).iterator();
          while (((Iterator)localObject9).hasNext())
          {
            localObject10 = (Float)((Iterator)localObject9).next();
            d.g.b.k.g(localObject10, "data");
            localObject8[i] = ((Float)localObject10).floatValue();
            localObject10 = y.JfV;
            i += 1;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ad.l("safeParser", "", new Object[] { localException1 });
            localObject2 = null;
          }
          ((Matrix)localObject2).setValues((float[])localObject8);
          localObject8 = (CharSequence)((dbn)localObject7).text;
          j = ((dbn)localObject7).textColor;
          k = ((dbn)localObject7).gpn;
          ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
          if (localObject8 == null) {
            break label381;
          }
        }
        if (n.aC((CharSequence)localObject8))
        {
          label381:
          i = 1;
          label384:
          if (i == 0) {
            break label416;
          }
        }
        for (localObject2 = null;; localObject2 = ((com.tencent.mm.media.editor.a.h)localObject7).c(null))
        {
          if (localObject2 == null) {
            break label450;
          }
          localList.add(localObject2);
          break;
          i = 0;
          break label384;
          label416:
          localObject7 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.g(paramContext);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject7).a((CharSequence)localObject8, j, k, (Matrix)localObject2);
        }
      }
      else
      {
        label450:
        Object localObject3;
        if (i == com.tencent.mm.media.editor.a.e.goH.value)
        {
          localObject2 = (com.tencent.mm.bx.a)new acu();
          localObject7 = ((in)localObject7).CEe;
          d.g.b.k.g(localObject7, "it.itemData");
          localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
          d.g.b.k.g(localObject7, "it.itemData.buffer");
          localObject7 = ((com.tencent.mm.bx.b)localObject7).getBytes();
          try
          {
            ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject7);
            localObject7 = (acu)localObject2;
            if (localObject7 == null) {
              continue;
            }
            ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "emoji md5 is " + ((acu)localObject7).md5);
            localObject2 = new Matrix();
            localObject8 = new float[9];
            i = 0;
            if (((acu)localObject7).Ddu != null)
            {
              localObject9 = ((acu)localObject7).Ddu.DmV;
              d.g.b.k.g(localObject9, "it.showMatrix.value");
              localObject9 = ((Iterable)localObject9).iterator();
              while (((Iterator)localObject9).hasNext())
              {
                localObject10 = (Float)((Iterator)localObject9).next();
                d.g.b.k.g(localObject10, "data");
                localObject8[i] = ((Float)localObject10).floatValue();
                localObject10 = y.JfV;
                i += 1;
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ad.l("safeParser", "", new Object[] { localException2 });
              localObject3 = null;
            }
            ((Matrix)localObject3).setValues((float[])localObject8);
            localObject8 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
            d.g.b.k.g(localObject8, "MMKernel.plugin(IPluginEmoji::class.java)");
            localObject7 = ((com.tencent.mm.plugin.emoji.b.d)localObject8).getProvider().TA(((acu)localObject7).md5);
            d.g.b.k.g(localObject7, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
            ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the emoji editor item");
            localObject8 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(paramContext, true);
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject8).setViewMatrix((Matrix)localObject3);
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject8).setEmojiInfo((EmojiInfo)localObject7);
            localObject3 = ((com.tencent.mm.media.editor.a.h)localObject8).c(null);
            if (localObject3 != null) {
              localList.add(localObject3);
            }
            localObject3 = y.JfV;
          }
        }
        else
        {
          Object localObject4;
          if (i == com.tencent.mm.media.editor.a.e.goI.value)
          {
            localObject3 = (com.tencent.mm.bx.a)new bmp();
            localObject7 = ((in)localObject7).CEe;
            d.g.b.k.g(localObject7, "it.itemData");
            localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
            d.g.b.k.g(localObject7, "it.itemData.buffer");
            localObject7 = ((com.tencent.mm.bx.b)localObject7).getBytes();
            try
            {
              ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject7);
              localObject7 = (bmp)localObject3;
              if (localObject7 == null) {
                continue;
              }
              ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow location data is  " + ((bmp)localObject7).goP + " - " + ((bmp)localObject7).goQ + " and matrix is " + ((bmp)localObject7).DKf.DmV);
              localObject3 = new Matrix();
              localObject8 = new float[9];
              i = 0;
              localObject9 = ((bmp)localObject7).DKf.DmV;
              d.g.b.k.g(localObject9, "it.matrix.value");
              localObject9 = ((Iterable)localObject9).iterator();
              while (((Iterator)localObject9).hasNext())
              {
                localObject10 = (Float)((Iterator)localObject9).next();
                d.g.b.k.g(localObject10, "data");
                localObject8[i] = ((Float)localObject10).floatValue();
                localObject10 = y.JfV;
                i += 1;
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                ad.l("safeParser", "", new Object[] { localException3 });
                localObject4 = null;
              }
              ((Matrix)localObject4).setValues((float[])localObject8);
              localObject8 = ((bmp)localObject7).goP;
              d.g.b.k.g(localObject8, "it.cityName");
              localObject9 = ((bmp)localObject7).goQ;
              d.g.b.k.g(localObject9, "it.poiName");
              float f1 = ((bmp)localObject7).dqQ;
              float f2 = ((bmp)localObject7).dpb;
              ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
              localObject7 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f(paramContext);
              ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject7).a((String)localObject8, (String)localObject9, f1, f2, (Matrix)localObject4);
              localObject4 = ((com.tencent.mm.media.editor.a.h)localObject7).c(null);
            }
            if (localObject4 != null) {
              localList.add(localObject4);
            }
          }
          else
          {
            Object localObject5;
            if (i == com.tencent.mm.media.editor.a.e.goJ.value)
            {
              localObject4 = (com.tencent.mm.bx.a)new dbn();
              localObject7 = ((in)localObject7).CEe;
              d.g.b.k.g(localObject7, "it.itemData");
              localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
              d.g.b.k.g(localObject7, "it.itemData.buffer");
              localObject7 = ((com.tencent.mm.bx.b)localObject7).getBytes();
              int m;
              try
              {
                ((com.tencent.mm.bx.a)localObject4).parseFrom((byte[])localObject7);
                localObject7 = (dbn)localObject4;
                if (localObject7 == null) {
                  continue;
                }
                ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((dbn)localObject7).text);
                localObject4 = new Matrix();
                localObject8 = new float[9];
                i = 0;
                localObject9 = ((dbn)localObject7).DKf.DmV;
                d.g.b.k.g(localObject9, "it.matrix.value");
                localObject9 = ((Iterable)localObject9).iterator();
                while (((Iterator)localObject9).hasNext())
                {
                  localObject10 = (Float)((Iterator)localObject9).next();
                  d.g.b.k.g(localObject10, "data");
                  localObject8[i] = ((Float)localObject10).floatValue();
                  localObject10 = y.JfV;
                  i += 1;
                }
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  ad.l("safeParser", "", new Object[] { localException4 });
                  localObject5 = null;
                }
                ((Matrix)localObject5).setValues((float[])localObject8);
                localObject8 = (CharSequence)((dbn)localObject7).text;
                j = ((dbn)localObject7).textColor;
                k = ((dbn)localObject7).gpn;
                m = ((dbn)localObject7).gpo;
                ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
                if (localObject8 == null) {
                  break label1482;
                }
              }
              if (n.aC((CharSequence)localObject8))
              {
                label1482:
                i = 1;
                label1485:
                if (i == 0) {
                  break label1517;
                }
              }
              for (localObject5 = null;; localObject5 = ((com.tencent.mm.media.editor.a.h)localObject7).c(null))
              {
                if (localObject5 == null) {
                  break label1553;
                }
                localList.add(localObject5);
                break;
                i = 0;
                break label1485;
                label1517:
                localObject7 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.h(paramContext);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.h)localObject7).a((CharSequence)localObject8, j, k, m, (Matrix)localObject5);
              }
            }
            else
            {
              label1553:
              if (i == com.tencent.mm.media.editor.a.e.goK.value)
              {
                localObject5 = (com.tencent.mm.bx.a)new bmw();
                localObject7 = ((in)localObject7).CEe;
                d.g.b.k.g(localObject7, "it.itemData");
                localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
                d.g.b.k.g(localObject7, "it.itemData.buffer");
                localObject7 = ((com.tencent.mm.bx.b)localObject7).getBytes();
                Object localObject6;
                try
                {
                  ((com.tencent.mm.bx.a)localObject5).parseFrom((byte[])localObject7);
                  localObject7 = (bmw)localObject5;
                  if (localObject7 == null) {
                    continue;
                  }
                  ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "lyrics size is " + ((bmw)localObject7).DKq.size());
                  localObject5 = new Matrix();
                  localObject8 = new float[9];
                  i = 0;
                  localObject9 = ((bmw)localObject7).DKf.DmV;
                  d.g.b.k.g(localObject9, "it.matrix.value");
                  localObject9 = ((Iterable)localObject9).iterator();
                  while (((Iterator)localObject9).hasNext())
                  {
                    localObject10 = (Float)((Iterator)localObject9).next();
                    d.g.b.k.g(localObject10, "data");
                    localObject8[i] = ((Float)localObject10).floatValue();
                    localObject10 = y.JfV;
                    i += 1;
                  }
                }
                catch (Exception localException5)
                {
                  for (;;)
                  {
                    ad.l("safeParser", "", new Object[] { localException5 });
                    localObject6 = null;
                  }
                  ((Matrix)localObject6).setValues((float[])localObject8);
                  long l1 = paramacq.endTime;
                  long l2 = paramacq.startTime;
                  localObject7 = ((bmw)localObject7).DKq;
                  d.g.b.k.g(localObject7, "it.lyricsList");
                  localObject6 = a((List)localObject7, (Matrix)localObject6, paramContext, l1 - l2);
                }
                if (localObject6 != null) {
                  localList.add(localObject6);
                }
              }
            }
          }
        }
      }
    }
    if (localList.size() == 0)
    {
      AppMethodBeat.o(75211);
      return null;
    }
    if ((paramInt2 == 0) || (paramInt1 == 0))
    {
      ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "error width " + paramInt1 + " height " + paramInt2);
      AppMethodBeat.o(75211);
      return null;
    }
    paramContext = com.tencent.mm.plugin.recordvideo.e.c.vtL;
    paramContext = paramacq.videoPath;
    d.g.b.k.g(paramContext, "storyEditorProtoData.videoPath");
    paramContext = com.tencent.mm.plugin.recordvideo.e.c.alZ(paramContext);
    if ((!paramacq.gBl) && (paramContext != null) && (!paramContext.vtM))
    {
      paramacq = new c(b(paramacq), localList, paramInt1, paramInt2, paramContext.width, paramContext.height, paramInt3, false, null, 384);
      AppMethodBeat.o(75211);
      return paramacq;
    }
    paramacq = new c(b(paramacq), localList, paramInt1, paramInt2, 0, 0, paramInt3, false, null, 384);
    AppMethodBeat.o(75211);
    return paramacq;
  }
  
  private static cyh a(acq paramacq)
  {
    AppMethodBeat.i(75207);
    d.g.b.k.h(paramacq, "storyEditorProtoData");
    cyh localcyh = new cyh();
    localcyh.Eqt = i.aEN(paramacq.DcZ);
    localcyh.Eqs = i.aEN(paramacq.gtC);
    if (!bt.gL((List)paramacq.Ddj))
    {
      localcyh.Eqr = "";
      localcyh.Eqv = "";
      Iterator localIterator = paramacq.Ddj.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = localcyh.Eqv;
        localcyh.Eqv = (str2 + i.aEN(str1));
      }
    }
    localcyh.Eqr = i.aEN(paramacq.videoPath);
    localcyh.Eqv = "";
    if (com.tencent.matrix.trace.g.b.dq(localcyh.Eqr)) {
      localcyh.Eqr = "";
    }
    localcyh.Equ = i.aEN(paramacq.thumbPath);
    AppMethodBeat.o(75207);
    return localcyh;
  }
  
  public static String a(VideoMixer paramVideoMixer, List<com.tencent.mm.media.editor.a.a> paramList, aer paramaer, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(75194);
    d.g.b.k.h(paramVideoMixer, "videoMixer");
    d.g.b.k.h(paramList, "editorDatas");
    d.g.b.k.h(paramaer, "extraConfig");
    try
    {
      long l = System.currentTimeMillis();
      d locald = new d();
      locald.field_taskId = ai.du((locald.hashCode() & 0x7FFFFFFF) + '#' + l);
      locald.field_timeStamp = l;
      locald.field_mixRetryTime = 0;
      locald.field_baseItemData = a(paramVideoMixer, l, paramList);
      paramList = d.b.vdD;
      locald.field_status = d.b.dgG();
      l = paramLong;
      if (paramLong > 2592000000L) {
        l = 2592000000L;
      }
      locald.field_expiredTime = l;
      paramList = paramVideoMixer.dgX();
      locald.field_targetWidth = paramList.videoWidth;
      locald.field_targetHeight = paramList.videoHeight;
      locald.field_videoBitrate = paramList.videoBitrate;
      locald.field_audioBitrate = paramList.audioBitrate;
      locald.field_audioSampleRate = paramList.audioSampleRate;
      locald.field_audioChannelCount = paramList.gnH;
      locald.field_frameRate = paramList.videoFrameRate;
      locald.field_videoRotate = paramList.gta;
      locald.field_extraConfig = paramaer.toByteArray();
      paramVideoMixer = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      locald.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.b.dix().dhG();
      paramVideoMixer = CaptureDataManager.vhw;
      d.g.b.k.g(paramVideoMixer, "CaptureDataManager.INSTANCE");
      locald.field_userData = ac(paramVideoMixer.getExtData());
      paramVideoMixer = paramString;
      if (paramString == null) {
        paramVideoMixer = "";
      }
      locald.field_blurBgPath = paramVideoMixer;
      locald.field_fromScene = paramInt;
      boolean bool = vcx.insert((com.tencent.mm.sdk.e.c)locald);
      ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramList + ", ret:" + bool);
      paramVideoMixer = a.vdo;
      paramVideoMixer = locald.field_taskId;
      d.g.b.k.g(paramVideoMixer, "videoEditorData.field_taskId");
      a.bu(paramInt, paramVideoMixer);
      paramVideoMixer = locald.field_taskId;
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
    d.g.b.k.h(paramArrayOfByte1, "baseItemData");
    d.g.b.k.h(paramMixConfig, "mixConfig");
    d.g.b.k.h(paramArrayOfByte2, "extraConfig");
    try
    {
      long l = System.currentTimeMillis();
      d locald = new d();
      locald.field_taskId = ai.du((locald.hashCode() & 0x7FFFFFFF) + '#' + l);
      locald.field_timeStamp = l;
      locald.field_mixRetryTime = 0;
      com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)new acq();
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
      paramArrayOfByte1 = (acq)paramArrayOfByte1;
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1.timeStamp = l;
        paramArrayOfByte1.Ddg = a(paramArrayOfByte1);
      }
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1 = paramArrayOfByte1.toByteArray();
        locald.field_baseItemData = paramArrayOfByte1;
        paramArrayOfByte1 = d.b.vdD;
        locald.field_status = d.b.dgG();
        locald.field_expiredTime = 2592000000L;
        locald.field_targetWidth = paramMixConfig.videoWidth;
        locald.field_targetHeight = paramMixConfig.videoHeight;
        locald.field_videoBitrate = paramMixConfig.videoBitrate;
        locald.field_audioBitrate = paramMixConfig.audioBitrate;
        locald.field_audioSampleRate = paramMixConfig.audioSampleRate;
        locald.field_audioChannelCount = paramMixConfig.gnH;
        locald.field_frameRate = paramMixConfig.videoFrameRate;
        locald.field_videoRotate = paramMixConfig.gta;
        locald.field_extraConfig = paramArrayOfByte2;
        paramArrayOfByte1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        locald.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.b.dix().dhG();
        paramArrayOfByte1 = CaptureDataManager.vhw;
        d.g.b.k.g(paramArrayOfByte1, "CaptureDataManager.INSTANCE");
        locald.field_userData = ac(paramArrayOfByte1.getExtData());
        locald.field_blurBgPath = "";
        locald.field_fromScene = paramInt;
        bool = vcx.insert((com.tencent.mm.sdk.e.c)locald);
        ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramMixConfig + ", ret:" + bool);
        paramArrayOfByte1 = a.vdo;
        paramArrayOfByte1 = locald.field_taskId;
        d.g.b.k.g(paramArrayOfByte1, "videoEditorData.field_taskId");
        a.bu(paramInt, paramArrayOfByte1);
        paramArrayOfByte1 = locald.field_taskId;
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
  
  public static ArrayList<com.tencent.mm.media.editor.a.b> a(LinkedList<in> paramLinkedList, Context paramContext)
  {
    AppMethodBeat.i(75208);
    d.g.b.k.h(paramLinkedList, "baseItemData");
    d.g.b.k.h(paramContext, "context");
    ArrayList localArrayList = new ArrayList();
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "get the editor data which is waiting for run mixing");
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (in)localIterator.next();
      int i = ((in)localObject1).dataType;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      if (i == com.tencent.mm.media.editor.a.e.goG.value)
      {
        paramLinkedList = (com.tencent.mm.bx.a)new dbn();
        localObject1 = ((in)localObject1).CEe;
        d.g.b.k.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.k.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bx.b)localObject1).getBytes();
        try
        {
          paramLinkedList.parseFrom((byte[])localObject1);
          localObject3 = (dbn)paramLinkedList;
          if (localObject3 == null) {
            continue;
          }
          ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((dbn)localObject3).text);
          paramLinkedList = new com.tencent.mm.plugin.recordvideo.ui.editor.item.g(paramContext).k((CharSequence)((dbn)localObject3).text, ((dbn)localObject3).textColor, ((dbn)localObject3).gpn);
          localObject1 = new Matrix();
          localObject2 = new float[9];
          i = 0;
          localObject3 = ((dbn)localObject3).DKf.DmV;
          d.g.b.k.g(localObject3, "it.matrix.value");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject3).next();
            d.g.b.k.g(localObject4, "data");
            localObject2[i] = ((Float)localObject4).floatValue();
            localObject4 = y.JfV;
            i += 1;
          }
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            ad.l("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
          }
          ((Matrix)localObject1).setValues((float[])localObject2);
          localArrayList.add(new com.tencent.mm.media.editor.a.d(paramLinkedList, (Matrix)localObject1));
        }
      }
      else if (i == com.tencent.mm.media.editor.a.e.goH.value)
      {
        paramLinkedList = (com.tencent.mm.bx.a)new acu();
        localObject1 = ((in)localObject1).CEe;
        d.g.b.k.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.k.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bx.b)localObject1).getBytes();
        try
        {
          paramLinkedList.parseFrom((byte[])localObject1);
          localObject1 = (acu)paramLinkedList;
          if (localObject1 == null) {
            continue;
          }
          ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "emoji md5 is " + ((acu)localObject1).md5);
          paramLinkedList = new Matrix();
          localObject2 = new float[9];
          i = 0;
          localObject3 = ((acu)localObject1).Ddt.DmV;
          d.g.b.k.g(localObject3, "it.editorMatrix.value");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject3).next();
            d.g.b.k.g(localObject4, "data");
            localObject2[i] = ((Float)localObject4).floatValue();
            localObject4 = y.JfV;
            i += 1;
          }
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            ad.l("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
          }
          paramLinkedList.setValues((float[])localObject2);
          localObject2 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
          d.g.b.k.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
          localObject1 = ((com.tencent.mm.plugin.emoji.b.d)localObject2).getProvider().TA(((acu)localObject1).md5);
          d.g.b.k.g(localObject1, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
          localArrayList.add(new com.tencent.mm.media.editor.a.f((EmojiInfo)localObject1, paramLinkedList));
        }
      }
      else if (i == com.tencent.mm.media.editor.a.e.goI.value)
      {
        paramLinkedList = (com.tencent.mm.bx.a)new bmp();
        localObject1 = ((in)localObject1).CEe;
        d.g.b.k.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.k.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bx.b)localObject1).getBytes();
        try
        {
          paramLinkedList.parseFrom((byte[])localObject1);
          paramLinkedList = (bmp)paramLinkedList;
          if (paramLinkedList == null) {
            continue;
          }
          ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "location data is  " + paramLinkedList.goP + " - " + paramLinkedList.goQ + " and matrix is " + paramLinkedList.DKf.DmV);
          localObject1 = new Matrix();
          localObject2 = new float[9];
          i = 0;
          localObject3 = paramLinkedList.DKf.DmV;
          d.g.b.k.g(localObject3, "it.matrix.value");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject3).next();
            d.g.b.k.g(localObject4, "data");
            localObject2[i] = ((Float)localObject4).floatValue();
            localObject4 = y.JfV;
            i += 1;
          }
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            ad.l("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
          }
          ((Matrix)localObject1).setValues((float[])localObject2);
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f(paramContext);
          localObject3 = paramLinkedList.goP;
          d.g.b.k.g(localObject3, "it.cityName");
          localObject4 = paramLinkedList.goQ;
          d.g.b.k.g(localObject4, "it.poiName");
          localArrayList.add(new com.tencent.mm.media.editor.a.d(((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject2).a((String)localObject3, (String)localObject4, paramLinkedList.dqQ, paramLinkedList.dpb), (Matrix)localObject1));
        }
      }
      else if (i == com.tencent.mm.media.editor.a.e.goJ.value)
      {
        paramLinkedList = (com.tencent.mm.bx.a)new dbn();
        localObject1 = ((in)localObject1).CEe;
        d.g.b.k.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.k.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bx.b)localObject1).getBytes();
        try
        {
          paramLinkedList.parseFrom((byte[])localObject1);
          localObject3 = (dbn)paramLinkedList;
          if (localObject3 == null) {
            continue;
          }
          ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((dbn)localObject3).text);
          paramLinkedList = new com.tencent.mm.plugin.recordvideo.ui.editor.item.h(paramContext).k((CharSequence)((dbn)localObject3).text, ((dbn)localObject3).textColor, ((dbn)localObject3).gpn);
          localObject1 = new Matrix();
          localObject2 = new float[9];
          i = 0;
          localObject3 = ((dbn)localObject3).DKf.DmV;
          d.g.b.k.g(localObject3, "it.matrix.value");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject3).next();
            d.g.b.k.g(localObject4, "data");
            localObject2[i] = ((Float)localObject4).floatValue();
            localObject4 = y.JfV;
            i += 1;
          }
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            ad.l("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
          }
          ((Matrix)localObject1).setValues((float[])localObject2);
          localArrayList.add(new com.tencent.mm.media.editor.a.d(paramLinkedList, (Matrix)localObject1));
        }
      }
      else if (i == com.tencent.mm.media.editor.a.e.goK.value)
      {
        paramLinkedList = (com.tencent.mm.bx.a)new bmw();
        localObject1 = ((in)localObject1).CEe;
        d.g.b.k.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.k.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bx.b)localObject1).getBytes();
        try
        {
          paramLinkedList.parseFrom((byte[])localObject1);
          localObject1 = (bmw)paramLinkedList;
          if (localObject1 != null)
          {
            ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((bmw)localObject1).DKq.size());
            localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e(paramContext);
            paramLinkedList = ((bmw)localObject1).DKq;
            d.g.b.k.g(paramLinkedList, "it.lyricsList");
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject2).eP((List)paramLinkedList);
            paramLinkedList = new ArrayList();
            localObject3 = ((Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject2).getLyricsList()).iterator();
            i = 0;
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = ((Iterator)localObject3).next();
              if (i < 0) {
                d.a.j.fvx();
              }
              localObject4 = (bmx)localObject4;
              Object localObject5 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject2).getBitmapList().get(i);
              d.g.b.k.g(localObject5, "itemView.bitmapList[index]");
              paramLinkedList.add(new com.tencent.mm.media.editor.a.j((bmx)localObject4, (Bitmap)localObject5));
              i += 1;
            }
          }
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            ad.l("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
          }
          localObject2 = new Matrix();
          localObject3 = new float[9];
          i = 0;
          localObject1 = ((bmw)localObject1).DKf.DmV;
          d.g.b.k.g(localObject1, "it.matrix.value");
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject1).next();
            d.g.b.k.g(localObject4, "data");
            localObject3[i] = ((Float)localObject4).floatValue();
            localObject4 = y.JfV;
            i += 1;
          }
          ((Matrix)localObject2).setValues((float[])localObject3);
          localArrayList.add(new com.tencent.mm.media.editor.a.k((List)paramLinkedList, (Matrix)localObject2));
        }
      }
    }
    AppMethodBeat.o(75208);
    return localArrayList;
  }
  
  public static void a(final acq paramacq, final Context paramContext, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(75210);
    d.g.b.k.h(paramacq, "storyEditorProtoData");
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramViewGroup, "itemLayout");
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story which has editor item");
    Object localObject1 = paramacq.Dde;
    d.g.b.k.g(localObject1, "storyEditorProtoData.baseItemData");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject7 = (in)localIterator.next();
      int i = ((in)localObject7).dataType;
      float[] arrayOfFloat;
      Object localObject8;
      Object localObject9;
      Object localObject2;
      if (i == com.tencent.mm.media.editor.a.e.goG.value)
      {
        localObject1 = (com.tencent.mm.bx.a)new dbn();
        localObject7 = ((in)localObject7).CEe;
        d.g.b.k.g(localObject7, "it.itemData");
        localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
        d.g.b.k.g(localObject7, "it.itemData.buffer");
        localObject7 = ((com.tencent.mm.bx.b)localObject7).getBytes();
        try
        {
          ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject7);
          localObject1 = (dbn)localObject1;
          if (localObject1 == null) {
            continue;
          }
          ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((dbn)localObject1).text);
          localObject7 = new Matrix();
          arrayOfFloat = new float[9];
          i = 0;
          localObject8 = ((dbn)localObject1).DKf.DmV;
          d.g.b.k.g(localObject8, "it.matrix.value");
          localObject8 = ((Iterable)localObject8).iterator();
          while (((Iterator)localObject8).hasNext())
          {
            localObject9 = (Float)((Iterator)localObject8).next();
            d.g.b.k.g(localObject9, "data");
            arrayOfFloat[i] = ((Float)localObject9).floatValue();
            localObject9 = y.JfV;
            i += 1;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ad.l("safeParser", "", new Object[] { localException1 });
            localObject2 = null;
          }
          ((Matrix)localObject7).setValues(arrayOfFloat);
          aq.f((Runnable)new a((dbn)localObject2, (Matrix)localObject7, paramContext, paramViewGroup, paramacq));
          localObject2 = y.JfV;
        }
      }
      else
      {
        Object localObject3;
        if (i == com.tencent.mm.media.editor.a.e.goH.value)
        {
          localObject2 = (com.tencent.mm.bx.a)new acu();
          localObject7 = ((in)localObject7).CEe;
          d.g.b.k.g(localObject7, "it.itemData");
          localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
          d.g.b.k.g(localObject7, "it.itemData.buffer");
          localObject7 = ((com.tencent.mm.bx.b)localObject7).getBytes();
          try
          {
            ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject7);
            localObject2 = (acu)localObject2;
            if (localObject2 == null) {
              continue;
            }
            ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "emoji md5 is " + ((acu)localObject2).md5);
            localObject7 = new Matrix();
            arrayOfFloat = new float[9];
            i = 0;
            if (((acu)localObject2).Ddu != null)
            {
              localObject8 = ((acu)localObject2).Ddu.DmV;
              d.g.b.k.g(localObject8, "it.showMatrix.value");
              localObject8 = ((Iterable)localObject8).iterator();
              while (((Iterator)localObject8).hasNext())
              {
                localObject9 = (Float)((Iterator)localObject8).next();
                d.g.b.k.g(localObject9, "data");
                arrayOfFloat[i] = ((Float)localObject9).floatValue();
                localObject9 = y.JfV;
                i += 1;
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ad.l("safeParser", "", new Object[] { localException2 });
              localObject3 = null;
            }
            ((Matrix)localObject7).setValues(arrayOfFloat);
            aq.f((Runnable)new b((acu)localObject3, (Matrix)localObject7, paramContext, paramViewGroup, paramacq));
            localObject3 = y.JfV;
          }
        }
        else
        {
          Object localObject4;
          if (i == com.tencent.mm.media.editor.a.e.goI.value)
          {
            localObject3 = (com.tencent.mm.bx.a)new bmp();
            localObject7 = ((in)localObject7).CEe;
            d.g.b.k.g(localObject7, "it.itemData");
            localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
            d.g.b.k.g(localObject7, "it.itemData.buffer");
            localObject7 = ((com.tencent.mm.bx.b)localObject7).getBytes();
            try
            {
              ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject7);
              localObject3 = (bmp)localObject3;
              if (localObject3 == null) {
                continue;
              }
              ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow location data is  " + ((bmp)localObject3).goP + " - " + ((bmp)localObject3).goQ + " and matrix is " + ((bmp)localObject3).DKf.DmV);
              localObject7 = new Matrix();
              arrayOfFloat = new float[9];
              i = 0;
              localObject8 = ((bmp)localObject3).DKf.DmV;
              d.g.b.k.g(localObject8, "it.matrix.value");
              localObject8 = ((Iterable)localObject8).iterator();
              while (((Iterator)localObject8).hasNext())
              {
                localObject9 = (Float)((Iterator)localObject8).next();
                d.g.b.k.g(localObject9, "data");
                arrayOfFloat[i] = ((Float)localObject9).floatValue();
                localObject9 = y.JfV;
                i += 1;
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                ad.l("safeParser", "", new Object[] { localException3 });
                localObject4 = null;
              }
              ((Matrix)localObject7).setValues(arrayOfFloat);
              aq.f((Runnable)new c((bmp)localObject4, (Matrix)localObject7, paramContext, paramViewGroup, paramacq));
              localObject4 = y.JfV;
            }
          }
          else
          {
            Object localObject5;
            if (i == com.tencent.mm.media.editor.a.e.goJ.value)
            {
              localObject4 = (com.tencent.mm.bx.a)new dbn();
              localObject7 = ((in)localObject7).CEe;
              d.g.b.k.g(localObject7, "it.itemData");
              localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
              d.g.b.k.g(localObject7, "it.itemData.buffer");
              localObject7 = ((com.tencent.mm.bx.b)localObject7).getBytes();
              try
              {
                ((com.tencent.mm.bx.a)localObject4).parseFrom((byte[])localObject7);
                localObject4 = (dbn)localObject4;
                if (localObject4 == null) {
                  continue;
                }
                ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((dbn)localObject4).text);
                localObject7 = new Matrix();
                arrayOfFloat = new float[9];
                i = 0;
                localObject8 = ((dbn)localObject4).DKf.DmV;
                d.g.b.k.g(localObject8, "it.matrix.value");
                localObject8 = ((Iterable)localObject8).iterator();
                while (((Iterator)localObject8).hasNext())
                {
                  localObject9 = (Float)((Iterator)localObject8).next();
                  d.g.b.k.g(localObject9, "data");
                  arrayOfFloat[i] = ((Float)localObject9).floatValue();
                  localObject9 = y.JfV;
                  i += 1;
                }
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  ad.l("safeParser", "", new Object[] { localException4 });
                  localObject5 = null;
                }
                ((Matrix)localObject7).setValues(arrayOfFloat);
                aq.f((Runnable)new d((dbn)localObject5, (Matrix)localObject7, paramContext, paramViewGroup, paramacq));
                localObject5 = y.JfV;
              }
            }
            else if (i == com.tencent.mm.media.editor.a.e.goK.value)
            {
              localObject5 = (com.tencent.mm.bx.a)new bmw();
              localObject7 = ((in)localObject7).CEe;
              d.g.b.k.g(localObject7, "it.itemData");
              localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
              d.g.b.k.g(localObject7, "it.itemData.buffer");
              localObject7 = ((com.tencent.mm.bx.b)localObject7).getBytes();
              try
              {
                ((com.tencent.mm.bx.a)localObject5).parseFrom((byte[])localObject7);
                localObject5 = (bmw)localObject5;
                if (localObject5 != null)
                {
                  ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "lyrics size is " + ((bmw)localObject5).DKq.size());
                  localObject7 = new Matrix();
                  arrayOfFloat = new float[9];
                  i = 0;
                  localObject8 = ((bmw)localObject5).DKf.DmV;
                  d.g.b.k.g(localObject8, "it.matrix.value");
                  localObject8 = ((Iterable)localObject8).iterator();
                  while (((Iterator)localObject8).hasNext())
                  {
                    localObject9 = (Float)((Iterator)localObject8).next();
                    d.g.b.k.g(localObject9, "data");
                    arrayOfFloat[i] = ((Float)localObject9).floatValue();
                    localObject9 = y.JfV;
                    i += 1;
                  }
                }
              }
              catch (Exception localException5)
              {
                for (;;)
                {
                  ad.l("safeParser", "", new Object[] { localException5 });
                  localObject6 = null;
                }
                ((Matrix)localObject7).setValues(arrayOfFloat);
                aq.f((Runnable)new e((bmw)localObject6, (Matrix)localObject7, paramContext, paramViewGroup, paramacq));
                Object localObject6 = y.JfV;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(75210);
  }
  
  private static byte[] a(VideoMixer paramVideoMixer, long paramLong, List<com.tencent.mm.media.editor.a.a> paramList)
  {
    AppMethodBeat.i(75202);
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "is running serialize the videoEditorInfo to bytearray");
    acq localacq = new acq();
    Object localObject1 = paramVideoMixer.vel;
    paramVideoMixer = paramVideoMixer.vem;
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "input the timeStamp is ".concat(String.valueOf(paramLong)));
    Object localObject2;
    if (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgs == 3)
    {
      localObject2 = com.tencent.mm.media.h.j.guw;
      if (i.eK(j.a.rn(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgn)))
      {
        localObject2 = com.tencent.mm.media.h.j.guw;
        localacq.DcZ = j.a.rn(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgn);
      }
    }
    localacq.timeStamp = paramLong;
    if (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgp == -1L)
    {
      paramLong = 0L;
      localacq.startTime = paramLong;
      localacq.endTime = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgq;
      localacq.thumbPath = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgo;
      localacq.videoPath = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgn;
      localacq.gBl = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).gBl;
      localObject2 = com.tencent.mm.plugin.sight.base.e.ano(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgn);
      if ((localObject2 != null) && ((((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgq == -1L) || (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgq == 0L))) {
        localacq.endTime = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
      }
      if (!bt.gL((List)((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgu))
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.b.e.vgG;
        localacq.endTime = com.tencent.mm.plugin.recordvideo.b.e.dhm();
      }
      if (localacq.endTime <= 0L) {
        break label505;
      }
    }
    label505:
    for (paramLong = localacq.endTime;; paramLong = 0L)
    {
      localacq.endTime = paramLong;
      localacq.Ddj.addAll((Collection)((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgu);
      localacq.gmX = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgs;
      localacq.Dda = ((int)paramVideoMixer[0]);
      localacq.Ddc = ((int)paramVideoMixer[1]);
      localacq.Ddb = ((int)paramVideoMixer[2]);
      localacq.Ddd = ((int)paramVideoMixer[3]);
      localacq.Dde = new LinkedList();
      paramVideoMixer = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgt;
      if (paramVideoMixer != null)
      {
        localacq.gtC = paramVideoMixer.cachePath;
        localacq.viz = paramVideoMixer.viz;
        localacq.musicUrl = paramVideoMixer.musicUrl;
        localacq.aMb = paramVideoMixer.aMb;
        localacq.viC = paramVideoMixer.viC;
        localacq.Ddh = paramVideoMixer.position;
        localacq.Ddi = paramVideoMixer.viE;
      }
      localacq.Ddg = a(localacq);
      paramVideoMixer = ((Iterable)paramList).iterator();
      while (paramVideoMixer.hasNext())
      {
        paramList = (com.tencent.mm.media.editor.a.a)paramVideoMixer.next();
        localObject1 = new in();
        ((in)localObject1).dataType = paramList.goB.value;
        ((in)localObject1).CEe = z.am(paramList.ajx().toByteArray());
        localacq.Dde.add(localObject1);
      }
      paramLong = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).vgp;
      break;
    }
    paramVideoMixer = localacq.toByteArray();
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "storyEditorItem " + localacq.videoPath + " thumb " + localacq.thumbPath + " and result " + i.eK(localacq.thumbPath) + " music " + localacq.gtC + " ret " + bt.mK(paramVideoMixer.length * 1L) + '}');
    d.g.b.k.g(paramVideoMixer, "ret");
    AppMethodBeat.o(75202);
    return paramVideoMixer;
  }
  
  private static String ac(Bundle paramBundle)
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
    d.g.b.k.g(paramBundle, "jsonObject.toString()");
    AppMethodBeat.o(75215);
    return paramBundle;
  }
  
  public static void alA(String paramString)
  {
    AppMethodBeat.i(75198);
    d.g.b.k.h(paramString, "taskId");
    d locald = vcx.aly(paramString);
    if (locald != null)
    {
      locald.field_mixRetryTime += 1;
      vcx.a(paramString, locald);
      AppMethodBeat.o(75198);
      return;
    }
    AppMethodBeat.o(75198);
  }
  
  public static void alB(String paramString)
  {
    AppMethodBeat.i(75203);
    d.g.b.k.h(paramString, "taskId");
    e locale = vcx;
    d.g.b.k.h(paramString, "taskId");
    locale.db.delete(e.TABLE, "taskId=?", new String[] { String.valueOf(paramString) });
    AppMethodBeat.o(75203);
  }
  
  public static void alC(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(75204);
    d.g.b.k.h(paramString, "taskId");
    paramString = vcx.aly(paramString);
    Object localObject2 = (com.tencent.mm.bx.a)new acq();
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
      localObject2 = (acq)paramString;
      ad.m("MicroMsg.mix_background.VideoEditStorageUtil", "cleanUnAvailableData, videoPath " + localObject2 + "?.videoPath", new Object[0]);
      if ((localObject2 != null) && (((acq)localObject2).gBl == true)) {
        i.deleteFile(((acq)localObject2).videoPath);
      }
      if (localObject2 == null) {
        break;
      }
      paramString = ((acq)localObject2).DcZ;
      i.deleteFile(paramString);
      if (localObject2 == null) {
        break label192;
      }
      paramString = ((acq)localObject2).gtC;
      i.deleteFile(paramString);
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = ((acq)localObject2).thumbPath;
      }
      i.deleteFile(paramString);
      AppMethodBeat.o(75204);
      return;
    }
  }
  
  public static void alD(String paramString)
  {
    AppMethodBeat.i(75205);
    d.g.b.k.h(paramString, "taskId");
    paramString = vcx.aly(paramString);
    if (paramString != null)
    {
      paramString.field_mixRetryTime = 0;
      Object localObject = d.b.vdD;
      paramString.field_status = d.b.dgG();
      vcx.a(paramString.aEB(), paramString);
      localObject = g.vdS;
      g.a(paramString, null);
    }
    AppMethodBeat.o(75205);
  }
  
  public static aer alE(String paramString)
  {
    AppMethodBeat.i(75213);
    d.g.b.k.h(paramString, "taskId");
    Object localObject = alz(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(75213);
      return null;
    }
    paramString = (com.tencent.mm.bx.a)new aer();
    localObject = ((d)localObject).field_extraConfig;
    try
    {
      paramString.parseFrom((byte[])localObject);
      paramString = (aer)paramString;
      AppMethodBeat.o(75213);
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
  
  public static Bundle alF(String paramString)
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
    d.g.b.k.g(localIterator, "jsonObject.keys()");
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
  
  public static d alz(String paramString)
  {
    AppMethodBeat.i(75197);
    d.g.b.k.h(paramString, "taskId");
    paramString = vcx.aly(paramString);
    AppMethodBeat.o(75197);
    return paramString;
  }
  
  public static float[] b(acq paramacq)
  {
    AppMethodBeat.i(75209);
    d.g.b.k.h(paramacq, "storyEditorProtoData");
    float f1 = paramacq.Dda;
    float f2 = paramacq.Ddc;
    float f3 = paramacq.Ddb;
    float f4 = paramacq.Ddd;
    AppMethodBeat.o(75209);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static Rect dgJ()
  {
    return gpG;
  }
  
  public static Rect dgK()
  {
    return vdF;
  }
  
  public static int dgL()
  {
    return vdG;
  }
  
  public static void dgM()
  {
    AppMethodBeat.i(75200);
    ad.i("MicroMsg.mix_background.VideoEditStorageUtil", "clean expired task, num:".concat(String.valueOf(vcx.db.delete(e.TABLE, "timeStamp< ?-expiredTime", new String[] { System.currentTimeMillis() }))));
    AppMethodBeat.o(75200);
  }
  
  public static void dgO()
  {
    AppMethodBeat.i(75206);
    g localg = g.vdS;
    g.dgP();
    AppMethodBeat.o(75206);
  }
  
  public static void ek(String paramString, int paramInt)
  {
    AppMethodBeat.i(75199);
    d.g.b.k.h(paramString, "taskId");
    d locald = vcx.aly(paramString);
    if (locald != null)
    {
      locald.field_status = paramInt;
      vcx.a(paramString, locald);
      AppMethodBeat.o(75199);
      return;
    }
    AppMethodBeat.o(75199);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$1$2", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$$special$$inlined$let$lambda$1"})
  static final class a
    implements Runnable
  {
    a(dbn paramdbn, Matrix paramMatrix, Context paramContext, ViewGroup paramViewGroup, acq paramacq) {}
    
    public final void run()
    {
      AppMethodBeat.i(75189);
      f localf = f.vdH;
      f.a((CharSequence)this.vdI.text, this.vdI.textColor, this.vdI.gpn, this.vdJ, paramContext, paramViewGroup);
      AppMethodBeat.o(75189);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$2$2", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$$special$$inlined$let$lambda$2"})
  static final class b
    implements Runnable
  {
    b(acu paramacu, Matrix paramMatrix, Context paramContext, ViewGroup paramViewGroup, acq paramacq) {}
    
    public final void run()
    {
      AppMethodBeat.i(75190);
      Object localObject = f.vdH;
      localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
      localObject = ((com.tencent.mm.plugin.emoji.b.d)localObject).getProvider().TA(this.vdM.md5);
      d.g.b.k.g(localObject, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
      f.a((EmojiInfo)localObject, this.vdJ, paramContext, paramViewGroup);
      AppMethodBeat.o(75190);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$3$2", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$$special$$inlined$let$lambda$3"})
  static final class c
    implements Runnable
  {
    c(bmp parambmp, Matrix paramMatrix, Context paramContext, ViewGroup paramViewGroup, acq paramacq) {}
    
    public final void run()
    {
      AppMethodBeat.i(75191);
      Object localObject = f.vdH;
      localObject = this.vdN.goP;
      d.g.b.k.g(localObject, "it.cityName");
      String str = this.vdN.goQ;
      d.g.b.k.g(str, "it.poiName");
      f.a((String)localObject, str, this.vdN.dqQ, this.vdN.dpb, this.vdJ, paramContext, paramViewGroup);
      AppMethodBeat.o(75191);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$4$2", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$$special$$inlined$let$lambda$4"})
  static final class d
    implements Runnable
  {
    d(dbn paramdbn, Matrix paramMatrix, Context paramContext, ViewGroup paramViewGroup, acq paramacq) {}
    
    public final void run()
    {
      AppMethodBeat.i(75192);
      f localf = f.vdH;
      f.a((CharSequence)this.vdI.text, this.vdI.textColor, this.vdI.gpn, this.vdI.gpo, this.vdJ, paramContext, paramViewGroup);
      AppMethodBeat.o(75192);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$5$2", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$$special$$inlined$let$lambda$5"})
  static final class e
    implements Runnable
  {
    e(bmw parambmw, Matrix paramMatrix, Context paramContext, ViewGroup paramViewGroup, acq paramacq) {}
    
    public final void run()
    {
      AppMethodBeat.i(75193);
      long l1 = paramacq.endTime;
      long l2 = paramacq.startTime;
      Object localObject = f.vdH;
      localObject = this.vdO.DKq;
      d.g.b.k.g(localObject, "it.lyricsList");
      f.a((List)localObject, this.vdJ, paramContext, paramViewGroup, l1 - l2);
      AppMethodBeat.o(75193);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.f
 * JD-Core Version:    0.7.0.1
 */