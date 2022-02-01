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
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiInfo;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil;", "", "()V", "TAG", "", "damp", "", "getDamp", "()I", "setDamp", "(I)V", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "validAreaRect", "getValidAreaRect", "setValidAreaRect", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "checkMD5", "", "file", "destMD5", "checkVideoEditorFileMD5", "storyEditorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "cleanExpiredTask", "", "cleanNullData", "taskId", "cleanUnAvailableData", "convertBundleToJson", "bundle", "Landroid/os/Bundle;", "convertJsonToBundle", "jsonStr", "deleteRemuxTask", "getAudioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getExtrConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getLastDataIfNoMix", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "limitTime", "", "getRemuxTask", "getStoryCaptureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "getStoryDataEditorItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "baseItemData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "context", "Landroid/content/Context;", "getStoryFileMD5", "Lcom/tencent/mm/protocal/protobuf/StoryEditorFileMD5;", "getUserData", "insertRemuxTask", "videoMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "editorDatas", "", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "extraConfig", "expiredTime", "blurBgPath", "scene", "", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "onUnSerializeStoryDataDrawingRect", "", "reStartMix", "reshowEmojiEditorItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "viewMatrix", "Landroid/graphics/Matrix;", "reshowEmojiItem", "itemLayout", "Landroid/view/ViewGroup;", "reshowLyricsEditorItem", "lyricsList", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "duration", "reshowLyricsItem", "reshowPositionEditorItem", "cityName", "poiName", "longitude", "", "latitude", "reshowPositionItem", "reshowStoryDataEditorItem", "reshowStoryDataEditorItemFrame", "Lcom/tencent/mm/plugin/recordvideo/background/StoryFrameRetriever;", "targetWidth", "targetHeight", "targetRotation", "reshowTextEditorItem", "text", "", "textColor", "textBgColor", "reshowTextItem", "reshowTipEditorItem", "marginBottom", "reshowTipItem", "serializeStoryDataToByteArray", "timeStamp", "signVideoMixTime", "updateByLocal", "editData", "updateRemuxTaskState", "state", "IVideoEditStorage", "plugin-recordvideo_release"})
public final class g
{
  private static Rect gQo;
  private static final f wlq;
  private static Rect wmv;
  private static int wmw;
  public static final g wmx;
  
  static
  {
    AppMethodBeat.i(75216);
    wmx = new g();
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(PluginVideoEditor.class);
    d.g.b.k.g(locala, "MMKernel.plugin(PluginVideoEditor::class.java)");
    wlq = ((PluginVideoEditor)locala).getVideoEditorDataStorage();
    gQo = new Rect(0, 0, com.tencent.mm.ui.ap.cl(ai.getContext()).x, com.tencent.mm.ui.ap.cl(ai.getContext()).y);
    wmv = new Rect(0, 0, com.tencent.mm.ui.ap.cl(ai.getContext()).x, com.tencent.mm.ui.ap.cl(ai.getContext()).y);
    wmw = 54;
    AppMethodBeat.o(75216);
  }
  
  private static com.tencent.mm.media.editor.a.b a(List<? extends brn> paramList, Matrix paramMatrix, Context paramContext, long paramLong)
  {
    AppMethodBeat.i(75212);
    ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
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
      if (((brn)localObject2).startTime < paramLong) {}
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
    paramContext.eW((List)paramMatrix);
    paramList = paramContext.c(null);
    AppMethodBeat.o(75212);
    return paramList;
  }
  
  public static d a(adp paramadp, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(75211);
    d.g.b.k.h(paramadp, "storyEditorProtoData");
    d.g.b.k.h(paramContext, "context");
    ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story as frame retriever");
    List localList = (List)new ArrayList();
    Object localObject1 = paramadp.Esi;
    d.g.b.k.g(localObject1, "storyEditorProtoData.baseItemData");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject7 = (it)localIterator.next();
      int i = ((it)localObject7).dataType;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      Object localObject2;
      int j;
      int k;
      if (i == com.tencent.mm.media.editor.a.e.gPo.value)
      {
        localObject1 = (com.tencent.mm.bw.a)new dgz();
        localObject7 = ((it)localObject7).DWE;
        d.g.b.k.g(localObject7, "it.itemData");
        localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
        d.g.b.k.g(localObject7, "it.itemData.buffer");
        localObject7 = ((com.tencent.mm.bw.b)localObject7).getBytes();
        try
        {
          ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject7);
          localObject7 = (dgz)localObject1;
          if (localObject7 == null) {
            continue;
          }
          ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((dgz)localObject7).text);
          localObject1 = new Matrix();
          localObject8 = new float[9];
          i = 0;
          localObject9 = ((dgz)localObject7).Fgu.EHU;
          d.g.b.k.g(localObject9, "it.matrix.value");
          localObject9 = ((Iterable)localObject9).iterator();
          while (((Iterator)localObject9).hasNext())
          {
            localObject10 = (Float)((Iterator)localObject9).next();
            d.g.b.k.g(localObject10, "data");
            localObject8[i] = ((Float)localObject10).floatValue();
            localObject10 = y.KTp;
            i += 1;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ac.l("safeParser", "", new Object[] { localException1 });
            localObject2 = null;
          }
          ((Matrix)localObject2).setValues((float[])localObject8);
          localObject8 = (CharSequence)((dgz)localObject7).text;
          j = ((dgz)localObject7).textColor;
          k = ((dgz)localObject7).gPV;
          ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
          if (localObject8 == null) {
            break label381;
          }
        }
        if (n.aD((CharSequence)localObject8))
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
        if (i == com.tencent.mm.media.editor.a.e.gPp.value)
        {
          localObject2 = (com.tencent.mm.bw.a)new adt();
          localObject7 = ((it)localObject7).DWE;
          d.g.b.k.g(localObject7, "it.itemData");
          localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
          d.g.b.k.g(localObject7, "it.itemData.buffer");
          localObject7 = ((com.tencent.mm.bw.b)localObject7).getBytes();
          try
          {
            ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject7);
            localObject7 = (adt)localObject2;
            if (localObject7 == null) {
              continue;
            }
            ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "emoji md5 is " + ((adt)localObject7).md5);
            localObject2 = new Matrix();
            localObject8 = new float[9];
            i = 0;
            if (((adt)localObject7).EwA != null)
            {
              localObject9 = ((adt)localObject7).EwA.EHU;
              d.g.b.k.g(localObject9, "it.showMatrix.value");
              localObject9 = ((Iterable)localObject9).iterator();
              while (((Iterator)localObject9).hasNext())
              {
                localObject10 = (Float)((Iterator)localObject9).next();
                d.g.b.k.g(localObject10, "data");
                localObject8[i] = ((Float)localObject10).floatValue();
                localObject10 = y.KTp;
                i += 1;
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ac.l("safeParser", "", new Object[] { localException2 });
              localObject3 = null;
            }
            ((Matrix)localObject3).setValues((float[])localObject8);
            localObject8 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
            d.g.b.k.g(localObject8, "MMKernel.plugin(IPluginEmoji::class.java)");
            localObject7 = ((com.tencent.mm.plugin.emoji.b.d)localObject8).getProvider().XM(((adt)localObject7).md5);
            d.g.b.k.g(localObject7, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
            ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the emoji editor item");
            localObject8 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(paramContext, true);
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject8).setViewMatrix((Matrix)localObject3);
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject8).setEmojiInfo((EmojiInfo)localObject7);
            localObject3 = ((com.tencent.mm.media.editor.a.h)localObject8).c(null);
            if (localObject3 != null) {
              localList.add(localObject3);
            }
            localObject3 = y.KTp;
          }
        }
        else
        {
          Object localObject4;
          if (i == com.tencent.mm.media.editor.a.e.gPq.value)
          {
            localObject3 = (com.tencent.mm.bw.a)new brf();
            localObject7 = ((it)localObject7).DWE;
            d.g.b.k.g(localObject7, "it.itemData");
            localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
            d.g.b.k.g(localObject7, "it.itemData.buffer");
            localObject7 = ((com.tencent.mm.bw.b)localObject7).getBytes();
            try
            {
              ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject7);
              localObject7 = (brf)localObject3;
              if (localObject7 == null) {
                continue;
              }
              ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow location data is  " + ((brf)localObject7).gPx + " - " + ((brf)localObject7).gPy + " and matrix is " + ((brf)localObject7).Fgu.EHU);
              localObject3 = new Matrix();
              localObject8 = new float[9];
              i = 0;
              localObject9 = ((brf)localObject7).Fgu.EHU;
              d.g.b.k.g(localObject9, "it.matrix.value");
              localObject9 = ((Iterable)localObject9).iterator();
              while (((Iterator)localObject9).hasNext())
              {
                localObject10 = (Float)((Iterator)localObject9).next();
                d.g.b.k.g(localObject10, "data");
                localObject8[i] = ((Float)localObject10).floatValue();
                localObject10 = y.KTp;
                i += 1;
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                ac.l("safeParser", "", new Object[] { localException3 });
                localObject4 = null;
              }
              ((Matrix)localObject4).setValues((float[])localObject8);
              localObject8 = ((brf)localObject7).gPx;
              d.g.b.k.g(localObject8, "it.cityName");
              localObject9 = ((brf)localObject7).gPy;
              d.g.b.k.g(localObject9, "it.poiName");
              float f1 = ((brf)localObject7).doB;
              float f2 = ((brf)localObject7).dmL;
              ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
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
            if (i == com.tencent.mm.media.editor.a.e.gPr.value)
            {
              localObject4 = (com.tencent.mm.bw.a)new dgz();
              localObject7 = ((it)localObject7).DWE;
              d.g.b.k.g(localObject7, "it.itemData");
              localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
              d.g.b.k.g(localObject7, "it.itemData.buffer");
              localObject7 = ((com.tencent.mm.bw.b)localObject7).getBytes();
              int m;
              try
              {
                ((com.tencent.mm.bw.a)localObject4).parseFrom((byte[])localObject7);
                localObject7 = (dgz)localObject4;
                if (localObject7 == null) {
                  continue;
                }
                ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((dgz)localObject7).text);
                localObject4 = new Matrix();
                localObject8 = new float[9];
                i = 0;
                localObject9 = ((dgz)localObject7).Fgu.EHU;
                d.g.b.k.g(localObject9, "it.matrix.value");
                localObject9 = ((Iterable)localObject9).iterator();
                while (((Iterator)localObject9).hasNext())
                {
                  localObject10 = (Float)((Iterator)localObject9).next();
                  d.g.b.k.g(localObject10, "data");
                  localObject8[i] = ((Float)localObject10).floatValue();
                  localObject10 = y.KTp;
                  i += 1;
                }
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  ac.l("safeParser", "", new Object[] { localException4 });
                  localObject5 = null;
                }
                ((Matrix)localObject5).setValues((float[])localObject8);
                localObject8 = (CharSequence)((dgz)localObject7).text;
                j = ((dgz)localObject7).textColor;
                k = ((dgz)localObject7).gPV;
                m = ((dgz)localObject7).gPW;
                ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
                if (localObject8 == null) {
                  break label1482;
                }
              }
              if (n.aD((CharSequence)localObject8))
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
              if (i == com.tencent.mm.media.editor.a.e.gPs.value)
              {
                localObject5 = (com.tencent.mm.bw.a)new brm();
                localObject7 = ((it)localObject7).DWE;
                d.g.b.k.g(localObject7, "it.itemData");
                localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
                d.g.b.k.g(localObject7, "it.itemData.buffer");
                localObject7 = ((com.tencent.mm.bw.b)localObject7).getBytes();
                Object localObject6;
                try
                {
                  ((com.tencent.mm.bw.a)localObject5).parseFrom((byte[])localObject7);
                  localObject7 = (brm)localObject5;
                  if (localObject7 == null) {
                    continue;
                  }
                  ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "lyrics size is " + ((brm)localObject7).FgG.size());
                  localObject5 = new Matrix();
                  localObject8 = new float[9];
                  i = 0;
                  localObject9 = ((brm)localObject7).Fgu.EHU;
                  d.g.b.k.g(localObject9, "it.matrix.value");
                  localObject9 = ((Iterable)localObject9).iterator();
                  while (((Iterator)localObject9).hasNext())
                  {
                    localObject10 = (Float)((Iterator)localObject9).next();
                    d.g.b.k.g(localObject10, "data");
                    localObject8[i] = ((Float)localObject10).floatValue();
                    localObject10 = y.KTp;
                    i += 1;
                  }
                }
                catch (Exception localException5)
                {
                  for (;;)
                  {
                    ac.l("safeParser", "", new Object[] { localException5 });
                    localObject6 = null;
                  }
                  ((Matrix)localObject6).setValues((float[])localObject8);
                  long l1 = paramadp.endTime;
                  long l2 = paramadp.startTime;
                  localObject7 = ((brm)localObject7).FgG;
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
      ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "error width " + paramInt1 + " height " + paramInt2);
      AppMethodBeat.o(75211);
      return null;
    }
    paramContext = com.tencent.mm.plugin.recordvideo.e.c.wDO;
    paramContext = paramadp.videoPath;
    d.g.b.k.g(paramContext, "storyEditorProtoData.videoPath");
    paramContext = com.tencent.mm.plugin.recordvideo.e.c.arc(paramContext);
    if ((!paramadp.hbH) && (paramContext != null) && (!paramContext.wDP))
    {
      paramadp = new d(b(paramadp), localList, paramInt1, paramInt2, paramContext.width, paramContext.height, paramInt3, false, null, 384);
      AppMethodBeat.o(75211);
      return paramadp;
    }
    paramadp = new d(b(paramadp), localList, paramInt1, paramInt2, 0, 0, paramInt3, false, null, 384);
    AppMethodBeat.o(75211);
    return paramadp;
  }
  
  private static ddt a(adp paramadp)
  {
    AppMethodBeat.i(75207);
    d.g.b.k.h(paramadp, "storyEditorProtoData");
    ddt localddt = new ddt();
    localddt.FNv = i.aKe(paramadp.Ewg);
    localddt.FNu = i.aKe(paramadp.gUk);
    if (!bs.gY((List)paramadp.Ewp))
    {
      localddt.FNt = "";
      localddt.FNx = "";
      Iterator localIterator = paramadp.Ewp.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = localddt.FNx;
        localddt.FNx = (str2 + i.aKe(str1));
      }
    }
    localddt.FNt = i.aKe(paramadp.videoPath);
    localddt.FNx = "";
    if (com.tencent.matrix.trace.g.b.cX(localddt.FNt)) {
      localddt.FNt = "";
    }
    localddt.FNw = i.aKe(paramadp.thumbPath);
    AppMethodBeat.o(75207);
    return localddt;
  }
  
  public static String a(VideoMixer paramVideoMixer, List<com.tencent.mm.media.editor.a.a> paramList, afq paramafq, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(75194);
    d.g.b.k.h(paramVideoMixer, "videoMixer");
    d.g.b.k.h(paramList, "editorDatas");
    d.g.b.k.h(paramafq, "extraConfig");
    try
    {
      long l = System.currentTimeMillis();
      e locale = new e();
      locale.field_taskId = ah.dg((locale.hashCode() & 0x7FFFFFFF) + '#' + l);
      locale.field_timeStamp = l;
      locale.field_mixRetryTime = 0;
      locale.field_baseItemData = a(paramVideoMixer, l, paramList);
      paramList = e.b.wmt;
      locale.field_status = e.b.duo();
      l = paramLong;
      if (paramLong > 2592000000L) {
        l = 2592000000L;
      }
      locale.field_expiredTime = l;
      paramList = paramVideoMixer.duF();
      locale.field_targetWidth = paramList.videoWidth;
      locale.field_targetHeight = paramList.videoHeight;
      locale.field_videoBitrate = paramList.videoBitrate;
      locale.field_audioBitrate = paramList.audioBitrate;
      locale.field_audioSampleRate = paramList.audioSampleRate;
      locale.field_audioChannelCount = paramList.gOt;
      locale.field_frameRate = paramList.videoFrameRate;
      locale.field_videoRotate = paramList.gTI;
      locale.field_extraConfig = paramafq.toByteArray();
      paramVideoMixer = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      locale.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.c.dwq().dvo();
      paramVideoMixer = CaptureDataManager.wqi;
      d.g.b.k.g(paramVideoMixer, "CaptureDataManager.INSTANCE");
      locale.field_userData = ag(paramVideoMixer.getExtData());
      paramVideoMixer = paramString;
      if (paramString == null) {
        paramVideoMixer = "";
      }
      locale.field_blurBgPath = paramVideoMixer;
      locale.field_fromScene = paramInt;
      boolean bool = wlq.insert((com.tencent.mm.sdk.e.c)locale);
      ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramList + ", ret:" + bool);
      paramVideoMixer = a.wme;
      paramVideoMixer = locale.field_taskId;
      d.g.b.k.g(paramVideoMixer, "videoEditorData.field_taskId");
      a.bz(paramInt, paramVideoMixer);
      paramVideoMixer = locale.field_taskId;
      AppMethodBeat.o(75194);
      return paramVideoMixer;
    }
    catch (Exception paramVideoMixer)
    {
      ac.printErrStackTrace("MicroMsg.mix_background.VideoEditStorageUtil", (Throwable)paramVideoMixer, "", new Object[0]);
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
      e locale = new e();
      locale.field_taskId = ah.dg((locale.hashCode() & 0x7FFFFFFF) + '#' + l);
      locale.field_timeStamp = l;
      locale.field_mixRetryTime = 0;
      com.tencent.mm.bw.a locala = (com.tencent.mm.bw.a)new adp();
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
          ac.l("safeParser", "", new Object[] { paramArrayOfByte1 });
          paramArrayOfByte1 = null;
          continue;
          paramArrayOfByte1 = null;
        }
      }
      paramArrayOfByte1 = (adp)paramArrayOfByte1;
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1.timeStamp = l;
        paramArrayOfByte1.Ewm = a(paramArrayOfByte1);
      }
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1 = paramArrayOfByte1.toByteArray();
        locale.field_baseItemData = paramArrayOfByte1;
        paramArrayOfByte1 = e.b.wmt;
        locale.field_status = e.b.duo();
        locale.field_expiredTime = 2592000000L;
        locale.field_targetWidth = paramMixConfig.videoWidth;
        locale.field_targetHeight = paramMixConfig.videoHeight;
        locale.field_videoBitrate = paramMixConfig.videoBitrate;
        locale.field_audioBitrate = paramMixConfig.audioBitrate;
        locale.field_audioSampleRate = paramMixConfig.audioSampleRate;
        locale.field_audioChannelCount = paramMixConfig.gOt;
        locale.field_frameRate = paramMixConfig.videoFrameRate;
        locale.field_videoRotate = paramMixConfig.gTI;
        locale.field_extraConfig = paramArrayOfByte2;
        paramArrayOfByte1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        locale.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.c.dwq().dvo();
        paramArrayOfByte1 = CaptureDataManager.wqi;
        d.g.b.k.g(paramArrayOfByte1, "CaptureDataManager.INSTANCE");
        locale.field_userData = ag(paramArrayOfByte1.getExtData());
        locale.field_blurBgPath = "";
        locale.field_fromScene = paramInt;
        bool = wlq.insert((com.tencent.mm.sdk.e.c)locale);
        ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + paramMixConfig + ", ret:" + bool);
        paramArrayOfByte1 = a.wme;
        paramArrayOfByte1 = locale.field_taskId;
        d.g.b.k.g(paramArrayOfByte1, "videoEditorData.field_taskId");
        a.bz(paramInt, paramArrayOfByte1);
        paramArrayOfByte1 = locale.field_taskId;
        AppMethodBeat.o(75195);
        return paramArrayOfByte1;
      }
      return null;
    }
    catch (Exception paramArrayOfByte1)
    {
      ac.printErrStackTrace("MicroMsg.mix_background.VideoEditStorageUtil", (Throwable)paramArrayOfByte1, "", new Object[0]);
      AppMethodBeat.o(75195);
    }
  }
  
  public static ArrayList<com.tencent.mm.media.editor.a.b> a(LinkedList<it> paramLinkedList, Context paramContext)
  {
    AppMethodBeat.i(75208);
    d.g.b.k.h(paramLinkedList, "baseItemData");
    d.g.b.k.h(paramContext, "context");
    ArrayList localArrayList = new ArrayList();
    ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "get the editor data which is waiting for run mixing");
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (it)localIterator.next();
      int i = ((it)localObject1).dataType;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      if (i == com.tencent.mm.media.editor.a.e.gPo.value)
      {
        paramLinkedList = (com.tencent.mm.bw.a)new dgz();
        localObject1 = ((it)localObject1).DWE;
        d.g.b.k.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.k.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bw.b)localObject1).getBytes();
        try
        {
          paramLinkedList.parseFrom((byte[])localObject1);
          localObject3 = (dgz)paramLinkedList;
          if (localObject3 == null) {
            continue;
          }
          ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((dgz)localObject3).text);
          paramLinkedList = new com.tencent.mm.plugin.recordvideo.ui.editor.item.g(paramContext).l((CharSequence)((dgz)localObject3).text, ((dgz)localObject3).textColor, ((dgz)localObject3).gPV);
          localObject1 = new Matrix();
          localObject2 = new float[9];
          i = 0;
          localObject3 = ((dgz)localObject3).Fgu.EHU;
          d.g.b.k.g(localObject3, "it.matrix.value");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject3).next();
            d.g.b.k.g(localObject4, "data");
            localObject2[i] = ((Float)localObject4).floatValue();
            localObject4 = y.KTp;
            i += 1;
          }
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            ac.l("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
          }
          ((Matrix)localObject1).setValues((float[])localObject2);
          localArrayList.add(new com.tencent.mm.media.editor.a.d(paramLinkedList, (Matrix)localObject1));
        }
      }
      else if (i == com.tencent.mm.media.editor.a.e.gPp.value)
      {
        paramLinkedList = (com.tencent.mm.bw.a)new adt();
        localObject1 = ((it)localObject1).DWE;
        d.g.b.k.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.k.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bw.b)localObject1).getBytes();
        try
        {
          paramLinkedList.parseFrom((byte[])localObject1);
          localObject1 = (adt)paramLinkedList;
          if (localObject1 == null) {
            continue;
          }
          ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "emoji md5 is " + ((adt)localObject1).md5);
          paramLinkedList = new Matrix();
          localObject2 = new float[9];
          i = 0;
          localObject3 = ((adt)localObject1).Ewz.EHU;
          d.g.b.k.g(localObject3, "it.editorMatrix.value");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject3).next();
            d.g.b.k.g(localObject4, "data");
            localObject2[i] = ((Float)localObject4).floatValue();
            localObject4 = y.KTp;
            i += 1;
          }
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            ac.l("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
          }
          paramLinkedList.setValues((float[])localObject2);
          localObject2 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
          d.g.b.k.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
          localObject1 = ((com.tencent.mm.plugin.emoji.b.d)localObject2).getProvider().XM(((adt)localObject1).md5);
          d.g.b.k.g(localObject1, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
          localArrayList.add(new com.tencent.mm.media.editor.a.f((EmojiInfo)localObject1, paramLinkedList));
        }
      }
      else if (i == com.tencent.mm.media.editor.a.e.gPq.value)
      {
        paramLinkedList = (com.tencent.mm.bw.a)new brf();
        localObject1 = ((it)localObject1).DWE;
        d.g.b.k.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.k.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bw.b)localObject1).getBytes();
        try
        {
          paramLinkedList.parseFrom((byte[])localObject1);
          paramLinkedList = (brf)paramLinkedList;
          if (paramLinkedList == null) {
            continue;
          }
          ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "location data is  " + paramLinkedList.gPx + " - " + paramLinkedList.gPy + " and matrix is " + paramLinkedList.Fgu.EHU);
          localObject1 = new Matrix();
          localObject2 = new float[9];
          i = 0;
          localObject3 = paramLinkedList.Fgu.EHU;
          d.g.b.k.g(localObject3, "it.matrix.value");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject3).next();
            d.g.b.k.g(localObject4, "data");
            localObject2[i] = ((Float)localObject4).floatValue();
            localObject4 = y.KTp;
            i += 1;
          }
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            ac.l("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
          }
          ((Matrix)localObject1).setValues((float[])localObject2);
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f(paramContext);
          localObject3 = paramLinkedList.gPx;
          d.g.b.k.g(localObject3, "it.cityName");
          localObject4 = paramLinkedList.gPy;
          d.g.b.k.g(localObject4, "it.poiName");
          localArrayList.add(new com.tencent.mm.media.editor.a.d(((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject2).a((String)localObject3, (String)localObject4, paramLinkedList.doB, paramLinkedList.dmL), (Matrix)localObject1));
        }
      }
      else if (i == com.tencent.mm.media.editor.a.e.gPr.value)
      {
        paramLinkedList = (com.tencent.mm.bw.a)new dgz();
        localObject1 = ((it)localObject1).DWE;
        d.g.b.k.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.k.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bw.b)localObject1).getBytes();
        try
        {
          paramLinkedList.parseFrom((byte[])localObject1);
          localObject3 = (dgz)paramLinkedList;
          if (localObject3 == null) {
            continue;
          }
          ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((dgz)localObject3).text);
          paramLinkedList = new com.tencent.mm.plugin.recordvideo.ui.editor.item.h(paramContext).l((CharSequence)((dgz)localObject3).text, ((dgz)localObject3).textColor, ((dgz)localObject3).gPV);
          localObject1 = new Matrix();
          localObject2 = new float[9];
          i = 0;
          localObject3 = ((dgz)localObject3).Fgu.EHU;
          d.g.b.k.g(localObject3, "it.matrix.value");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject3).next();
            d.g.b.k.g(localObject4, "data");
            localObject2[i] = ((Float)localObject4).floatValue();
            localObject4 = y.KTp;
            i += 1;
          }
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            ac.l("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
          }
          ((Matrix)localObject1).setValues((float[])localObject2);
          localArrayList.add(new com.tencent.mm.media.editor.a.d(paramLinkedList, (Matrix)localObject1));
        }
      }
      else if (i == com.tencent.mm.media.editor.a.e.gPs.value)
      {
        paramLinkedList = (com.tencent.mm.bw.a)new brm();
        localObject1 = ((it)localObject1).DWE;
        d.g.b.k.g(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        d.g.b.k.g(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bw.b)localObject1).getBytes();
        try
        {
          paramLinkedList.parseFrom((byte[])localObject1);
          localObject1 = (brm)paramLinkedList;
          if (localObject1 != null)
          {
            ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((brm)localObject1).FgG.size());
            localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e(paramContext);
            paramLinkedList = ((brm)localObject1).FgG;
            d.g.b.k.g(paramLinkedList, "it.lyricsList");
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject2).eV((List)paramLinkedList);
            paramLinkedList = new ArrayList();
            localObject3 = ((Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject2).getLyricsList()).iterator();
            i = 0;
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = ((Iterator)localObject3).next();
              if (i < 0) {
                d.a.j.fOc();
              }
              localObject4 = (brn)localObject4;
              Object localObject5 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject2).getBitmapList().get(i);
              d.g.b.k.g(localObject5, "itemView.bitmapList[index]");
              paramLinkedList.add(new com.tencent.mm.media.editor.a.j((brn)localObject4, (Bitmap)localObject5));
              i += 1;
            }
          }
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            ac.l("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
          }
          localObject2 = new Matrix();
          localObject3 = new float[9];
          i = 0;
          localObject1 = ((brm)localObject1).Fgu.EHU;
          d.g.b.k.g(localObject1, "it.matrix.value");
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject1).next();
            d.g.b.k.g(localObject4, "data");
            localObject3[i] = ((Float)localObject4).floatValue();
            localObject4 = y.KTp;
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
  
  public static void a(final adp paramadp, final Context paramContext, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(75210);
    d.g.b.k.h(paramadp, "storyEditorProtoData");
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramViewGroup, "itemLayout");
    ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story which has editor item");
    Object localObject1 = paramadp.Esi;
    d.g.b.k.g(localObject1, "storyEditorProtoData.baseItemData");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject7 = (it)localIterator.next();
      int i = ((it)localObject7).dataType;
      float[] arrayOfFloat;
      Object localObject8;
      Object localObject9;
      Object localObject2;
      if (i == com.tencent.mm.media.editor.a.e.gPo.value)
      {
        localObject1 = (com.tencent.mm.bw.a)new dgz();
        localObject7 = ((it)localObject7).DWE;
        d.g.b.k.g(localObject7, "it.itemData");
        localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
        d.g.b.k.g(localObject7, "it.itemData.buffer");
        localObject7 = ((com.tencent.mm.bw.b)localObject7).getBytes();
        try
        {
          ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject7);
          localObject1 = (dgz)localObject1;
          if (localObject1 == null) {
            continue;
          }
          ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((dgz)localObject1).text);
          localObject7 = new Matrix();
          arrayOfFloat = new float[9];
          i = 0;
          localObject8 = ((dgz)localObject1).Fgu.EHU;
          d.g.b.k.g(localObject8, "it.matrix.value");
          localObject8 = ((Iterable)localObject8).iterator();
          while (((Iterator)localObject8).hasNext())
          {
            localObject9 = (Float)((Iterator)localObject8).next();
            d.g.b.k.g(localObject9, "data");
            arrayOfFloat[i] = ((Float)localObject9).floatValue();
            localObject9 = y.KTp;
            i += 1;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ac.l("safeParser", "", new Object[] { localException1 });
            localObject2 = null;
          }
          ((Matrix)localObject7).setValues(arrayOfFloat);
          com.tencent.mm.sdk.platformtools.ap.f((Runnable)new a((dgz)localObject2, (Matrix)localObject7, paramContext, paramViewGroup, paramadp));
          localObject2 = y.KTp;
        }
      }
      else
      {
        Object localObject3;
        if (i == com.tencent.mm.media.editor.a.e.gPp.value)
        {
          localObject2 = (com.tencent.mm.bw.a)new adt();
          localObject7 = ((it)localObject7).DWE;
          d.g.b.k.g(localObject7, "it.itemData");
          localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
          d.g.b.k.g(localObject7, "it.itemData.buffer");
          localObject7 = ((com.tencent.mm.bw.b)localObject7).getBytes();
          try
          {
            ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject7);
            localObject2 = (adt)localObject2;
            if (localObject2 == null) {
              continue;
            }
            ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "emoji md5 is " + ((adt)localObject2).md5);
            localObject7 = new Matrix();
            arrayOfFloat = new float[9];
            i = 0;
            if (((adt)localObject2).EwA != null)
            {
              localObject8 = ((adt)localObject2).EwA.EHU;
              d.g.b.k.g(localObject8, "it.showMatrix.value");
              localObject8 = ((Iterable)localObject8).iterator();
              while (((Iterator)localObject8).hasNext())
              {
                localObject9 = (Float)((Iterator)localObject8).next();
                d.g.b.k.g(localObject9, "data");
                arrayOfFloat[i] = ((Float)localObject9).floatValue();
                localObject9 = y.KTp;
                i += 1;
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ac.l("safeParser", "", new Object[] { localException2 });
              localObject3 = null;
            }
            ((Matrix)localObject7).setValues(arrayOfFloat);
            com.tencent.mm.sdk.platformtools.ap.f((Runnable)new b((adt)localObject3, (Matrix)localObject7, paramContext, paramViewGroup, paramadp));
            localObject3 = y.KTp;
          }
        }
        else
        {
          Object localObject4;
          if (i == com.tencent.mm.media.editor.a.e.gPq.value)
          {
            localObject3 = (com.tencent.mm.bw.a)new brf();
            localObject7 = ((it)localObject7).DWE;
            d.g.b.k.g(localObject7, "it.itemData");
            localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
            d.g.b.k.g(localObject7, "it.itemData.buffer");
            localObject7 = ((com.tencent.mm.bw.b)localObject7).getBytes();
            try
            {
              ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject7);
              localObject3 = (brf)localObject3;
              if (localObject3 == null) {
                continue;
              }
              ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow location data is  " + ((brf)localObject3).gPx + " - " + ((brf)localObject3).gPy + " and matrix is " + ((brf)localObject3).Fgu.EHU);
              localObject7 = new Matrix();
              arrayOfFloat = new float[9];
              i = 0;
              localObject8 = ((brf)localObject3).Fgu.EHU;
              d.g.b.k.g(localObject8, "it.matrix.value");
              localObject8 = ((Iterable)localObject8).iterator();
              while (((Iterator)localObject8).hasNext())
              {
                localObject9 = (Float)((Iterator)localObject8).next();
                d.g.b.k.g(localObject9, "data");
                arrayOfFloat[i] = ((Float)localObject9).floatValue();
                localObject9 = y.KTp;
                i += 1;
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                ac.l("safeParser", "", new Object[] { localException3 });
                localObject4 = null;
              }
              ((Matrix)localObject7).setValues(arrayOfFloat);
              com.tencent.mm.sdk.platformtools.ap.f((Runnable)new c((brf)localObject4, (Matrix)localObject7, paramContext, paramViewGroup, paramadp));
              localObject4 = y.KTp;
            }
          }
          else
          {
            Object localObject5;
            if (i == com.tencent.mm.media.editor.a.e.gPr.value)
            {
              localObject4 = (com.tencent.mm.bw.a)new dgz();
              localObject7 = ((it)localObject7).DWE;
              d.g.b.k.g(localObject7, "it.itemData");
              localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
              d.g.b.k.g(localObject7, "it.itemData.buffer");
              localObject7 = ((com.tencent.mm.bw.b)localObject7).getBytes();
              try
              {
                ((com.tencent.mm.bw.a)localObject4).parseFrom((byte[])localObject7);
                localObject4 = (dgz)localObject4;
                if (localObject4 == null) {
                  continue;
                }
                ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "text string is " + ((dgz)localObject4).text);
                localObject7 = new Matrix();
                arrayOfFloat = new float[9];
                i = 0;
                localObject8 = ((dgz)localObject4).Fgu.EHU;
                d.g.b.k.g(localObject8, "it.matrix.value");
                localObject8 = ((Iterable)localObject8).iterator();
                while (((Iterator)localObject8).hasNext())
                {
                  localObject9 = (Float)((Iterator)localObject8).next();
                  d.g.b.k.g(localObject9, "data");
                  arrayOfFloat[i] = ((Float)localObject9).floatValue();
                  localObject9 = y.KTp;
                  i += 1;
                }
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  ac.l("safeParser", "", new Object[] { localException4 });
                  localObject5 = null;
                }
                ((Matrix)localObject7).setValues(arrayOfFloat);
                com.tencent.mm.sdk.platformtools.ap.f((Runnable)new d((dgz)localObject5, (Matrix)localObject7, paramContext, paramViewGroup, paramadp));
                localObject5 = y.KTp;
              }
            }
            else if (i == com.tencent.mm.media.editor.a.e.gPs.value)
            {
              localObject5 = (com.tencent.mm.bw.a)new brm();
              localObject7 = ((it)localObject7).DWE;
              d.g.b.k.g(localObject7, "it.itemData");
              localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
              d.g.b.k.g(localObject7, "it.itemData.buffer");
              localObject7 = ((com.tencent.mm.bw.b)localObject7).getBytes();
              try
              {
                ((com.tencent.mm.bw.a)localObject5).parseFrom((byte[])localObject7);
                localObject5 = (brm)localObject5;
                if (localObject5 != null)
                {
                  ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "lyrics size is " + ((brm)localObject5).FgG.size());
                  localObject7 = new Matrix();
                  arrayOfFloat = new float[9];
                  i = 0;
                  localObject8 = ((brm)localObject5).Fgu.EHU;
                  d.g.b.k.g(localObject8, "it.matrix.value");
                  localObject8 = ((Iterable)localObject8).iterator();
                  while (((Iterator)localObject8).hasNext())
                  {
                    localObject9 = (Float)((Iterator)localObject8).next();
                    d.g.b.k.g(localObject9, "data");
                    arrayOfFloat[i] = ((Float)localObject9).floatValue();
                    localObject9 = y.KTp;
                    i += 1;
                  }
                }
              }
              catch (Exception localException5)
              {
                for (;;)
                {
                  ac.l("safeParser", "", new Object[] { localException5 });
                  localObject6 = null;
                }
                ((Matrix)localObject7).setValues(arrayOfFloat);
                com.tencent.mm.sdk.platformtools.ap.f((Runnable)new e((brm)localObject6, (Matrix)localObject7, paramContext, paramViewGroup, paramadp));
                Object localObject6 = y.KTp;
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
    ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "is running serialize the videoEditorInfo to bytearray");
    adp localadp = new adp();
    Object localObject1 = paramVideoMixer.wna;
    paramVideoMixer = paramVideoMixer.wnb;
    ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "input the timeStamp is ".concat(String.valueOf(paramLong)));
    Object localObject2;
    if (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).wpe == 3)
    {
      localObject2 = com.tencent.mm.media.h.j.gVb;
      if (i.eA(j.a.vp(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).woZ)))
      {
        localObject2 = com.tencent.mm.media.h.j.gVb;
        localadp.Ewg = j.a.vp(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).woZ);
      }
    }
    localadp.timeStamp = paramLong;
    if (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).wpb == -1L)
    {
      paramLong = 0L;
      localadp.startTime = paramLong;
      localadp.endTime = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).wpc;
      localadp.thumbPath = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).wpa;
      localadp.videoPath = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).woZ;
      localadp.hbH = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).hbH;
      localObject2 = com.tencent.mm.plugin.sight.base.e.asx(((com.tencent.mm.plugin.recordvideo.b.c)localObject1).woZ);
      if ((localObject2 != null) && ((((com.tencent.mm.plugin.recordvideo.b.c)localObject1).wpc == -1L) || (((com.tencent.mm.plugin.recordvideo.b.c)localObject1).wpc == 0L))) {
        localadp.endTime = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
      }
      if (!bs.gY((List)((com.tencent.mm.plugin.recordvideo.b.c)localObject1).wpg))
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.b.e.wps;
        localadp.endTime = com.tencent.mm.plugin.recordvideo.b.e.duT();
      }
      if (localadp.endTime <= 0L) {
        break label505;
      }
    }
    label505:
    for (paramLong = localadp.endTime;; paramLong = 0L)
    {
      localadp.endTime = paramLong;
      localadp.Ewp.addAll((Collection)((com.tencent.mm.plugin.recordvideo.b.c)localObject1).wpg);
      localadp.gNK = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).wpe;
      localadp.Ewh = ((int)paramVideoMixer[0]);
      localadp.Ewj = ((int)paramVideoMixer[1]);
      localadp.Ewi = ((int)paramVideoMixer[2]);
      localadp.Ewk = ((int)paramVideoMixer[3]);
      localadp.Esi = new LinkedList();
      paramVideoMixer = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).wpf;
      if (paramVideoMixer != null)
      {
        localadp.gUk = paramVideoMixer.cachePath;
        localadp.wri = paramVideoMixer.wri;
        localadp.musicUrl = paramVideoMixer.musicUrl;
        localadp.aMR = paramVideoMixer.aMR;
        localadp.wrl = paramVideoMixer.wrl;
        localadp.Ewn = paramVideoMixer.position;
        localadp.Ewo = paramVideoMixer.wrn;
      }
      localadp.Ewm = a(localadp);
      paramVideoMixer = ((Iterable)paramList).iterator();
      while (paramVideoMixer.hasNext())
      {
        paramList = (com.tencent.mm.media.editor.a.a)paramVideoMixer.next();
        localObject1 = new it();
        ((it)localObject1).dataType = paramList.gPj.value;
        ((it)localObject1).DWE = z.al(paramList.aqw().toByteArray());
        localadp.Esi.add(localObject1);
      }
      paramLong = ((com.tencent.mm.plugin.recordvideo.b.c)localObject1).wpb;
      break;
    }
    paramVideoMixer = localadp.toByteArray();
    ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "storyEditorItem " + localadp.videoPath + " thumb " + localadp.thumbPath + " and result " + i.eA(localadp.thumbPath) + " music " + localadp.gUk + " ret " + bs.qz(paramVideoMixer.length * 1L) + '}');
    d.g.b.k.g(paramVideoMixer, "ret");
    AppMethodBeat.o(75202);
    return paramVideoMixer;
  }
  
  private static String ag(Bundle paramBundle)
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
  
  public static void aqA(String paramString)
  {
    AppMethodBeat.i(75203);
    d.g.b.k.h(paramString, "taskId");
    f localf = wlq;
    d.g.b.k.h(paramString, "taskId");
    localf.db.delete(f.TABLE, "taskId=?", new String[] { String.valueOf(paramString) });
    AppMethodBeat.o(75203);
  }
  
  public static void aqB(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(75204);
    d.g.b.k.h(paramString, "taskId");
    paramString = wlq.aqx(paramString);
    Object localObject2 = (com.tencent.mm.bw.a)new adp();
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
          ac.l("safeParser", "", new Object[] { paramString });
          paramString = null;
          continue;
          paramString = null;
          continue;
          paramString = null;
        }
      }
      localObject2 = (adp)paramString;
      ac.m("MicroMsg.mix_background.VideoEditStorageUtil", "cleanUnAvailableData, videoPath " + localObject2 + "?.videoPath", new Object[0]);
      if ((localObject2 != null) && (((adp)localObject2).hbH == true)) {
        i.deleteFile(((adp)localObject2).videoPath);
      }
      if (localObject2 == null) {
        break;
      }
      paramString = ((adp)localObject2).Ewg;
      i.deleteFile(paramString);
      if (localObject2 == null) {
        break label192;
      }
      paramString = ((adp)localObject2).gUk;
      i.deleteFile(paramString);
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = ((adp)localObject2).thumbPath;
      }
      i.deleteFile(paramString);
      AppMethodBeat.o(75204);
      return;
    }
  }
  
  public static void aqC(String paramString)
  {
    AppMethodBeat.i(75205);
    d.g.b.k.h(paramString, "taskId");
    paramString = wlq.aqx(paramString);
    if (paramString != null)
    {
      paramString.field_mixRetryTime = 0;
      Object localObject = e.b.wmt;
      paramString.field_status = e.b.duo();
      wlq.a(paramString.aLs(), paramString);
      localObject = h.wmI;
      h.a(paramString, null);
    }
    AppMethodBeat.o(75205);
  }
  
  public static afq aqD(String paramString)
  {
    AppMethodBeat.i(75213);
    d.g.b.k.h(paramString, "taskId");
    Object localObject = aqy(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(75213);
      return null;
    }
    paramString = (com.tencent.mm.bw.a)new afq();
    localObject = ((e)localObject).field_extraConfig;
    try
    {
      paramString.parseFrom((byte[])localObject);
      paramString = (afq)paramString;
      AppMethodBeat.o(75213);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.l("safeParser", "", new Object[] { paramString });
        paramString = null;
      }
    }
  }
  
  public static Bundle aqE(String paramString)
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
  
  public static e aqy(String paramString)
  {
    AppMethodBeat.i(75197);
    d.g.b.k.h(paramString, "taskId");
    paramString = wlq.aqx(paramString);
    AppMethodBeat.o(75197);
    return paramString;
  }
  
  public static void aqz(String paramString)
  {
    AppMethodBeat.i(75198);
    d.g.b.k.h(paramString, "taskId");
    e locale = wlq.aqx(paramString);
    if (locale != null)
    {
      locale.field_mixRetryTime += 1;
      wlq.a(paramString, locale);
      AppMethodBeat.o(75198);
      return;
    }
    AppMethodBeat.o(75198);
  }
  
  public static float[] b(adp paramadp)
  {
    AppMethodBeat.i(75209);
    d.g.b.k.h(paramadp, "storyEditorProtoData");
    float f1 = paramadp.Ewh;
    float f2 = paramadp.Ewj;
    float f3 = paramadp.Ewi;
    float f4 = paramadp.Ewk;
    AppMethodBeat.o(75209);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static Rect dur()
  {
    return gQo;
  }
  
  public static Rect dus()
  {
    return wmv;
  }
  
  public static int dut()
  {
    return wmw;
  }
  
  public static void duu()
  {
    AppMethodBeat.i(75200);
    ac.i("MicroMsg.mix_background.VideoEditStorageUtil", "clean expired task, num:".concat(String.valueOf(wlq.db.delete(f.TABLE, "timeStamp< ?-expiredTime", new String[] { System.currentTimeMillis() }))));
    AppMethodBeat.o(75200);
  }
  
  public static void duw()
  {
    AppMethodBeat.i(75206);
    h localh = h.wmI;
    h.dux();
    AppMethodBeat.o(75206);
  }
  
  public static void er(String paramString, int paramInt)
  {
    AppMethodBeat.i(75199);
    d.g.b.k.h(paramString, "taskId");
    e locale = wlq.aqx(paramString);
    if (locale != null)
    {
      locale.field_status = paramInt;
      wlq.a(paramString, locale);
      AppMethodBeat.o(75199);
      return;
    }
    AppMethodBeat.o(75199);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$1$2", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$$special$$inlined$let$lambda$1"})
  static final class a
    implements Runnable
  {
    a(dgz paramdgz, Matrix paramMatrix, Context paramContext, ViewGroup paramViewGroup, adp paramadp) {}
    
    public final void run()
    {
      AppMethodBeat.i(75189);
      g localg = g.wmx;
      g.a((CharSequence)this.wmy.text, this.wmy.textColor, this.wmy.gPV, this.wmz, paramContext, paramViewGroup);
      AppMethodBeat.o(75189);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$2$2", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$$special$$inlined$let$lambda$2"})
  static final class b
    implements Runnable
  {
    b(adt paramadt, Matrix paramMatrix, Context paramContext, ViewGroup paramViewGroup, adp paramadp) {}
    
    public final void run()
    {
      AppMethodBeat.i(75190);
      Object localObject = g.wmx;
      localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
      localObject = ((com.tencent.mm.plugin.emoji.b.d)localObject).getProvider().XM(this.wmC.md5);
      d.g.b.k.g(localObject, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
      g.a((EmojiInfo)localObject, this.wmz, paramContext, paramViewGroup);
      AppMethodBeat.o(75190);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$3$2", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$$special$$inlined$let$lambda$3"})
  static final class c
    implements Runnable
  {
    c(brf parambrf, Matrix paramMatrix, Context paramContext, ViewGroup paramViewGroup, adp paramadp) {}
    
    public final void run()
    {
      AppMethodBeat.i(75191);
      Object localObject = g.wmx;
      localObject = this.wmD.gPx;
      d.g.b.k.g(localObject, "it.cityName");
      String str = this.wmD.gPy;
      d.g.b.k.g(str, "it.poiName");
      g.a((String)localObject, str, this.wmD.doB, this.wmD.dmL, this.wmz, paramContext, paramViewGroup);
      AppMethodBeat.o(75191);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$4$2", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$$special$$inlined$let$lambda$4"})
  static final class d
    implements Runnable
  {
    d(dgz paramdgz, Matrix paramMatrix, Context paramContext, ViewGroup paramViewGroup, adp paramadp) {}
    
    public final void run()
    {
      AppMethodBeat.i(75192);
      g localg = g.wmx;
      g.a((CharSequence)this.wmy.text, this.wmy.textColor, this.wmy.gPV, this.wmy.gPW, this.wmz, paramContext, paramViewGroup);
      AppMethodBeat.o(75192);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$5$2", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$$special$$inlined$let$lambda$5"})
  static final class e
    implements Runnable
  {
    e(brm parambrm, Matrix paramMatrix, Context paramContext, ViewGroup paramViewGroup, adp paramadp) {}
    
    public final void run()
    {
      AppMethodBeat.i(75193);
      long l1 = paramadp.endTime;
      long l2 = paramadp.startTime;
      Object localObject = g.wmx;
      localObject = this.wmE.FgG;
      d.g.b.k.g(localObject, "it.lyricsList");
      g.a((List)localObject, this.wmz, paramContext, paramViewGroup, l1 - l2);
      AppMethodBeat.o(75193);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.g
 * JD-Core Version:    0.7.0.1
 */