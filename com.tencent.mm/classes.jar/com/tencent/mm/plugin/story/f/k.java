package com.tencent.mm.plugin.story.f;

import a.v;
import a.y;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.story.c.a.f.a;
import com.tencent.mm.plugin.story.d.b.b;
import com.tencent.mm.plugin.story.e.c.a.a;
import com.tencent.mm.plugin.story.h.a.d;
import com.tencent.mm.plugin.story.h.a.e;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.q;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.bay;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.protocal.protobuf.cqz;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.am;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/StoryDataProtoUtil;", "", "()V", "TAG", "", "damp", "", "getDamp", "()I", "setDamp", "(I)V", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "checkMD5", "", "file", "destMD5", "checkStoryEditorFileMD5", "storyEditorProtoData", "Lcom/tencent/mm/protocal/protobuf/StoryEditorProtoData;", "cleanDirtyData", "", "cleanNullData", "timeStamp", "", "cleanUnAvailableData", "data", "getAudioCacheInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "getFakeVideoData", "getStoryCaptureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "getStoryDataEditorItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "getStoryFileMD5", "Lcom/tencent/mm/protocal/protobuf/StoryEditorFileMD5;", "insertCompositeVideo", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "view", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "muteOrigin", "mixAudio", "captureInfo", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "insertEditorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "onUnSerializeStoryDataDrawingRect", "", "reshowEmojiEditorItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "viewMatrix", "Landroid/graphics/Matrix;", "validArea", "reshowEmojiItem", "itemLayout", "Landroid/view/ViewGroup;", "reshowLyricsEditorItem", "lyricsList", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "duration", "reshowLyricsItem", "reshowPositionEditorItem", "cityName", "poiName", "reshowPositionItem", "reshowStoryDataEditorItem", "reshowStoryDataEditorItemFrame", "Lcom/tencent/mm/plugin/story/model/mix/StoryFrameRetriever;", "reshowTextEditorItem", "text", "", "textColor", "textBgColor", "reshowTextItem", "reshowTipEditorItem", "marginBottom", "reshowTipItem", "serializeStoryDataToByteArray", "", "signStoryDataMix", "localId", "mixVideoPath", "mixThumbPath", "needExport", "signStoryDataMixEnable", "storyEditorData", "signStoryDataMixError", "signStoryDataMixTime", "plugin-story_release"})
public final class k
{
  private static Rect eTC;
  private static int sCo;
  public static final k sCp;
  
  static
  {
    AppMethodBeat.i(109684);
    sCp = new k();
    eTC = new Rect(0, 0, am.hQ(ah.getContext()).x, am.hQ(ah.getContext()).y);
    sCo = 54;
    AppMethodBeat.o(109684);
  }
  
  private static com.tencent.mm.media.editor.a.b a(List<? extends baz> paramList, Matrix paramMatrix, Context paramContext, long paramLong)
  {
    AppMethodBeat.i(151100);
    ab.i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the position editor item");
    paramContext = new com.tencent.mm.plugin.story.ui.view.editor.item.d(paramContext);
    paramContext.setViewMatrix(paramMatrix);
    paramMatrix = new ArrayList();
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label116:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((baz)localObject2).startTime < paramLong) {}
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
    paramContext.dM((List)paramMatrix);
    paramList = paramContext.UH();
    AppMethodBeat.o(151100);
    return paramList;
  }
  
  public static com.tencent.mm.plugin.story.h.d a(b.b paramb, boolean paramBoolean, AudioCacheInfo paramAudioCacheInfo, com.tencent.mm.plugin.story.e.a parama, long paramLong, chj paramchj)
  {
    AppMethodBeat.i(109669);
    a.f.b.j.q(paramb, "view");
    a.f.b.j.q(parama, "captureInfo");
    a.f.b.j.q(paramchj, "location");
    com.tencent.mm.plugin.story.h.d locald;
    Object localObject;
    int i;
    try
    {
      new com.tencent.mm.ab.a("insertCompositeVideo");
      locald = new com.tencent.mm.plugin.story.h.d();
      locald.field_mixFlag = 0;
      locald.field_mixRetryTime = 0;
      locald.field_timeStamp = paramLong;
      localObject = com.tencent.mm.plugin.story.model.j.svi;
      if (j.b.cAM() != f.a.ssj) {
        break label619;
      }
      i = 1;
    }
    catch (Exception paramb)
    {
      com.tencent.mm.media.g.k.a locala;
      ab.printErrStackTrace("MicroMsg.Media.StoryDataProtoUtil", (Throwable)paramb, "", new Object[0]);
      AppMethodBeat.o(109669);
      return null;
    }
    locald.field_available = i;
    ab.i("MicroMsg.Media.StoryDataProtoUtil", "is running serialize the story to bytearray");
    if (paramBoolean) {
      if (paramAudioCacheInfo == null)
      {
        i = 0;
        label108:
        localObject = new chf();
        ab.i("MicroMsg.Media.StoryDataProtoUtil", "input the timeStamp is ".concat(String.valueOf(paramLong)));
        if (i == 3)
        {
          locala = com.tencent.mm.media.g.k.eXX;
          if (com.tencent.mm.vfs.e.cN(com.tencent.mm.media.g.k.a.mR(parama.ssl)))
          {
            locala = com.tencent.mm.media.g.k.eXX;
            ((chf)localObject).xRY = com.tencent.mm.media.g.k.a.mR(parama.ssl);
          }
        }
        ((chf)localObject).timeStamp = paramLong;
        if (parama.ssn != -1L) {
          break label653;
        }
        paramLong = 0L;
        label195:
        ((chf)localObject).startTime = paramLong;
        ((chf)localObject).endTime = parama.sso;
        ((chf)localObject).thumbPath = parama.ssm;
        ((chf)localObject).videoPath = parama.ssl;
        ((chf)localObject).fbp = parama.fbp;
        ((chf)localObject).sPS = paramchj;
        paramchj = com.tencent.mm.plugin.sight.base.d.Zo(parama.ssl);
        if ((paramchj != null) && ((parama.sso == -1L) || (parama.sso == 0L))) {
          ((chf)localObject).endTime = paramchj.eVA;
        }
        if (!bo.es((List)parama.sss)) {
          ((chf)localObject).endTime = 15000L;
        }
        if (((chf)localObject).endTime <= 0L) {
          break label816;
        }
      }
    }
    label653:
    label816:
    for (paramLong = ((chf)localObject).endTime;; paramLong = 0L)
    {
      ((chf)localObject).endTime = paramLong;
      ((chf)localObject).xSi.addAll((Collection)parama.sss);
      ((chf)localObject).eRn = i;
      ((chf)localObject).xRZ = paramb.getItemContainer().getLeft();
      ((chf)localObject).xSb = paramb.getItemContainer().getTop();
      ((chf)localObject).xSa = paramb.getItemContainer().getRight();
      ((chf)localObject).xSc = paramb.getItemContainer().getBottom();
      ((chf)localObject).xSd = new LinkedList();
      if (paramAudioCacheInfo != null)
      {
        ((chf)localObject).eXm = paramAudioCacheInfo.cachePath;
        ((chf)localObject).swp = paramAudioCacheInfo.swp;
        ((chf)localObject).musicUrl = paramAudioCacheInfo.musicUrl;
        ((chf)localObject).arq = paramAudioCacheInfo.arq;
        ((chf)localObject).sws = paramAudioCacheInfo.sws;
        ((chf)localObject).xSg = paramAudioCacheInfo.position;
        ((chf)localObject).xSh = paramAudioCacheInfo.swu;
      }
      ((chf)localObject).xSf = a((chf)localObject);
      paramb = ((Iterable)paramb.getItemContainer().getAllItemViews()).iterator();
      while (paramb.hasNext())
      {
        paramAudioCacheInfo = ((com.tencent.mm.media.editor.a.h)paramb.next()).UI();
        if (paramAudioCacheInfo != null)
        {
          parama = new hp();
          parama.dataType = paramAudioCacheInfo.eSy.value;
          parama.wuo = aa.ac(paramAudioCacheInfo.UF().toByteArray());
          ((chf)localObject).xSd.add(parama);
          continue;
          label619:
          i = 0;
        }
      }
      while (i == 0)
      {
        i = 0;
        break;
        i = 2;
        break label108;
        if (paramAudioCacheInfo == null)
        {
          i = 1;
          break label108;
        }
        i = 3;
        break label108;
        paramLong = parama.ssn;
        break label195;
        paramb = ((chf)localObject).toByteArray();
        ab.i("MicroMsg.Media.StoryDataProtoUtil", "storyEditorItem " + ((chf)localObject).videoPath + " thumb " + ((chf)localObject).thumbPath + " and result " + com.tencent.mm.vfs.e.cN(((chf)localObject).thumbPath) + " music " + ((chf)localObject).eXm + " ret " + bo.hk(paramb.length * 1L) + '}');
        a.f.b.j.p(paramb, "ret");
        a.f.b.j.q(paramb, "value");
        locald.field_baseItemData = paramb;
        paramb = com.tencent.mm.plugin.story.model.j.svi;
        j.b.cAG().insert((com.tencent.mm.sdk.e.c)locald);
        AppMethodBeat.o(109669);
        return locald;
      }
      i = 1;
      break;
    }
  }
  
  private static che a(chf paramchf)
  {
    AppMethodBeat.i(151099);
    a.f.b.j.q(paramchf, "storyEditorProtoData");
    che localche = new che();
    localche.xRV = com.tencent.mm.a.g.getMD5(paramchf.xRY);
    localche.xRU = com.tencent.mm.a.g.getMD5(paramchf.eXm);
    if (!bo.es((List)paramchf.xSi))
    {
      localche.xRT = "";
      localche.xRX = "";
      Iterator localIterator = paramchf.xSi.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = localche.xRX;
        localche.xRX = (str2 + com.tencent.mm.a.g.getMD5(str1));
      }
    }
    localche.xRT = com.tencent.mm.a.g.getMD5(paramchf.videoPath);
    localche.xRX = "";
    localche.xRW = com.tencent.mm.a.g.getMD5(paramchf.thumbPath);
    AppMethodBeat.o(151099);
    return localche;
  }
  
  public static chk a(b.b paramb, AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(109670);
    a.f.b.j.q(paramb, "view");
    chk localchk = new chk();
    Iterator localIterator = ((Iterable)paramb.getItemContainer().getAllItemViews()).iterator();
    while (localIterator.hasNext())
    {
      paramb = ((com.tencent.mm.media.editor.a.h)localIterator.next()).UI();
      if (paramb != null)
      {
        int i = paramb.eSy.value;
        if (i == com.tencent.mm.media.editor.a.e.eSC.value)
        {
          if (paramb == null)
          {
            paramb = new v("null cannot be cast to non-null type com.tencent.mm.media.editor.item.TextItem");
            AppMethodBeat.o(109670);
            throw paramb;
          }
          localchk.xSp.add(String.valueOf(((com.tencent.mm.media.editor.a.m)paramb).text));
        }
        else
        {
          if (i == com.tencent.mm.media.editor.a.e.eSD.value)
          {
            if (paramb == null)
            {
              paramb = new v("null cannot be cast to non-null type com.tencent.mm.media.editor.item.EmojiItem");
              AppMethodBeat.o(109670);
              throw paramb;
            }
            LinkedList localLinkedList = localchk.xSo;
            paramb = ((com.tencent.mm.media.editor.a.g)paramb).evH;
            if (paramb != null) {}
            for (paramb = paramb.Al();; paramb = null)
            {
              localLinkedList.add(paramb);
              break;
            }
          }
          if (i == com.tencent.mm.media.editor.a.e.eSF.value)
          {
            if (paramb == null)
            {
              paramb = new v("null cannot be cast to non-null type com.tencent.mm.media.editor.item.TextItem");
              AppMethodBeat.o(109670);
              throw paramb;
            }
            localchk.ubk = String.valueOf(((com.tencent.mm.media.editor.a.m)paramb).text);
          }
        }
      }
    }
    if (paramAudioCacheInfo != null)
    {
      localchk.xSn = true;
      localchk.swp = paramAudioCacheInfo.swp;
      localchk.xSg = paramAudioCacheInfo.position;
      localchk.xSm = paramAudioCacheInfo.swu;
    }
    for (;;)
    {
      AppMethodBeat.o(109670);
      return localchk;
      localchk.xSn = false;
    }
  }
  
  public static ArrayList<com.tencent.mm.media.editor.a.b> a(chf paramchf, Context paramContext)
  {
    AppMethodBeat.i(109671);
    a.f.b.j.q(paramchf, "storyEditorProtoData");
    a.f.b.j.q(paramContext, "context");
    ArrayList localArrayList = new ArrayList();
    ab.i("MicroMsg.Media.StoryDataProtoUtil", "get the editor data which is waiting for run mixing");
    paramchf = paramchf.xSd;
    a.f.b.j.p(paramchf, "storyEditorProtoData.baseItemData");
    Iterator localIterator = ((Iterable)paramchf).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (hp)localIterator.next();
      int i = ((hp)localObject1).dataType;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      if (i == com.tencent.mm.media.editor.a.e.eSC.value)
      {
        paramchf = (com.tencent.mm.bv.a)new cjv();
        localObject1 = ((hp)localObject1).wuo;
        a.f.b.j.p(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        a.f.b.j.p(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bv.b)localObject1).getBytes();
        try
        {
          paramchf.parseFrom((byte[])localObject1);
          localObject3 = (cjv)paramchf;
          if (localObject3 == null) {
            continue;
          }
          ab.i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + ((cjv)localObject3).text);
          paramchf = new com.tencent.mm.plugin.story.ui.view.editor.item.g(paramContext).k((CharSequence)((cjv)localObject3).text, ((cjv)localObject3).textColor, ((cjv)localObject3).eTj);
          localObject1 = new Matrix();
          localObject2 = new float[9];
          i = 0;
          localObject3 = ((cjv)localObject3).xpW.xZD;
          a.f.b.j.p(localObject3, "it.matrix.value");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject3).next();
            a.f.b.j.p(localObject4, "data");
            localObject2[i] = ((Float)localObject4).floatValue();
            localObject4 = y.BMg;
            i += 1;
          }
        }
        catch (Exception paramchf)
        {
          for (;;)
          {
            ab.a("safeParser", "", new Object[] { paramchf });
            paramchf = null;
          }
          ((Matrix)localObject1).setValues((float[])localObject2);
          localArrayList.add(new com.tencent.mm.media.editor.a.d(paramchf, (Matrix)localObject1));
        }
      }
      else if (i == com.tencent.mm.media.editor.a.e.eSD.value)
      {
        paramchf = (com.tencent.mm.bv.a)new zh();
        localObject1 = ((hp)localObject1).wuo;
        a.f.b.j.p(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        a.f.b.j.p(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bv.b)localObject1).getBytes();
        try
        {
          paramchf.parseFrom((byte[])localObject1);
          localObject1 = (zh)paramchf;
          if (localObject1 == null) {
            continue;
          }
          ab.i("MicroMsg.Media.StoryDataProtoUtil", "emoji md5 is " + ((zh)localObject1).cqq);
          paramchf = new Matrix();
          localObject2 = new float[9];
          i = 0;
          localObject3 = ((zh)localObject1).wQk.xZD;
          a.f.b.j.p(localObject3, "it.editorMatrix.value");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject3).next();
            a.f.b.j.p(localObject4, "data");
            localObject2[i] = ((Float)localObject4).floatValue();
            localObject4 = y.BMg;
            i += 1;
          }
        }
        catch (Exception paramchf)
        {
          for (;;)
          {
            ab.a("safeParser", "", new Object[] { paramchf });
            paramchf = null;
          }
          paramchf.setValues((float[])localObject2);
          localObject2 = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
          a.f.b.j.p(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
          localObject1 = ((com.tencent.mm.plugin.emoji.b.d)localObject2).getProvider().Ku(((zh)localObject1).cqq);
          a.f.b.j.p(localObject1, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
          localArrayList.add(new com.tencent.mm.media.editor.a.f((EmojiInfo)localObject1, paramchf));
        }
      }
      else if (i == com.tencent.mm.media.editor.a.e.eSE.value)
      {
        paramchf = (com.tencent.mm.bv.a)new bar();
        localObject1 = ((hp)localObject1).wuo;
        a.f.b.j.p(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        a.f.b.j.p(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bv.b)localObject1).getBytes();
        try
        {
          paramchf.parseFrom((byte[])localObject1);
          localObject1 = (bar)paramchf;
          if (localObject1 == null) {
            continue;
          }
          ab.i("MicroMsg.Media.StoryDataProtoUtil", "location data is  " + ((bar)localObject1).eSL + " - " + ((bar)localObject1).eSM + " and matrix is " + ((bar)localObject1).xpW.xZD);
          paramchf = new Matrix();
          localObject2 = new float[9];
          i = 0;
          localObject3 = ((bar)localObject1).xpW.xZD;
          a.f.b.j.p(localObject3, "it.matrix.value");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject3).next();
            a.f.b.j.p(localObject4, "data");
            localObject2[i] = ((Float)localObject4).floatValue();
            localObject4 = y.BMg;
            i += 1;
          }
        }
        catch (Exception paramchf)
        {
          for (;;)
          {
            ab.a("safeParser", "", new Object[] { paramchf });
            paramchf = null;
          }
          paramchf.setValues((float[])localObject2);
          localObject2 = new com.tencent.mm.plugin.story.ui.view.editor.item.f(paramContext);
          localObject3 = ((bar)localObject1).eSL;
          a.f.b.j.p(localObject3, "it.cityName");
          localObject1 = ((bar)localObject1).eSM;
          a.f.b.j.p(localObject1, "it.poiName");
          localArrayList.add(new com.tencent.mm.media.editor.a.d(((com.tencent.mm.plugin.story.ui.view.editor.item.f)localObject2).gS((String)localObject3, (String)localObject1), paramchf));
        }
      }
      else if (i == com.tencent.mm.media.editor.a.e.eSF.value)
      {
        paramchf = (com.tencent.mm.bv.a)new cjv();
        localObject1 = ((hp)localObject1).wuo;
        a.f.b.j.p(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        a.f.b.j.p(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bv.b)localObject1).getBytes();
        try
        {
          paramchf.parseFrom((byte[])localObject1);
          localObject3 = (cjv)paramchf;
          if (localObject3 == null) {
            continue;
          }
          ab.i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + ((cjv)localObject3).text);
          paramchf = new com.tencent.mm.plugin.story.ui.view.editor.item.h(paramContext).k((CharSequence)((cjv)localObject3).text, ((cjv)localObject3).textColor, ((cjv)localObject3).eTj);
          localObject1 = new Matrix();
          localObject2 = new float[9];
          i = 0;
          localObject3 = ((cjv)localObject3).xpW.xZD;
          a.f.b.j.p(localObject3, "it.matrix.value");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject3).next();
            a.f.b.j.p(localObject4, "data");
            localObject2[i] = ((Float)localObject4).floatValue();
            localObject4 = y.BMg;
            i += 1;
          }
        }
        catch (Exception paramchf)
        {
          for (;;)
          {
            ab.a("safeParser", "", new Object[] { paramchf });
            paramchf = null;
          }
          ((Matrix)localObject1).setValues((float[])localObject2);
          localArrayList.add(new com.tencent.mm.media.editor.a.d(paramchf, (Matrix)localObject1));
        }
      }
      else if (i == com.tencent.mm.media.editor.a.e.eSG.value)
      {
        paramchf = (com.tencent.mm.bv.a)new bay();
        localObject1 = ((hp)localObject1).wuo;
        a.f.b.j.p(localObject1, "it.itemData");
        localObject1 = ((SKBuiltinBuffer_t)localObject1).getBuffer();
        a.f.b.j.p(localObject1, "it.itemData.buffer");
        localObject1 = ((com.tencent.mm.bv.b)localObject1).getBytes();
        try
        {
          paramchf.parseFrom((byte[])localObject1);
          localObject1 = (bay)paramchf;
          if (localObject1 != null)
          {
            ab.i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + ((bay)localObject1).xqh.size());
            localObject2 = new com.tencent.mm.plugin.story.ui.view.editor.item.d(paramContext);
            paramchf = ((bay)localObject1).xqh;
            a.f.b.j.p(paramchf, "it.lyricsList");
            ((com.tencent.mm.plugin.story.ui.view.editor.item.d)localObject2).dL((List)paramchf);
            paramchf = new ArrayList();
            localObject3 = (Iterable)((com.tencent.mm.plugin.story.ui.view.editor.item.d)localObject2).getLyricsList();
            i = 0;
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = ((Iterator)localObject3).next();
              if (i < 0) {
                a.a.j.eaS();
              }
              localObject4 = (baz)localObject4;
              Object localObject5 = ((com.tencent.mm.plugin.story.ui.view.editor.item.d)localObject2).getBitmapList().get(i);
              a.f.b.j.p(localObject5, "itemView.bitmapList[index]");
              paramchf.add(new com.tencent.mm.media.editor.a.j((baz)localObject4, (Bitmap)localObject5));
              i += 1;
            }
          }
        }
        catch (Exception paramchf)
        {
          for (;;)
          {
            ab.a("safeParser", "", new Object[] { paramchf });
            paramchf = null;
          }
          localObject2 = new Matrix();
          localObject3 = new float[9];
          i = 0;
          localObject1 = ((bay)localObject1).xpW.xZD;
          a.f.b.j.p(localObject1, "it.matrix.value");
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (Float)((Iterator)localObject1).next();
            a.f.b.j.p(localObject4, "data");
            localObject3[i] = ((Float)localObject4).floatValue();
            localObject4 = y.BMg;
            i += 1;
          }
          ((Matrix)localObject2).setValues((float[])localObject3);
          localArrayList.add(new com.tencent.mm.media.editor.a.k((List)paramchf, (Matrix)localObject2));
        }
      }
    }
    AppMethodBeat.o(109671);
    return localArrayList;
  }
  
  public static void a(long paramLong, com.tencent.mm.plugin.story.h.d paramd)
  {
    AppMethodBeat.i(109677);
    a.f.b.j.q(paramd, "storyEditorData");
    ab.i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMixEnable ".concat(String.valueOf(paramLong)));
    if (paramd.cEN())
    {
      int i = paramd.field_mixFlag;
      Object localObject = a.e.sGg;
      paramd.field_mixFlag = (i | a.e.cEB());
      localObject = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAG().b(paramLong, paramd);
    }
    AppMethodBeat.o(109677);
  }
  
  public static void a(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(109675);
    a.f.b.j.q(paramString1, "mixVideoPath");
    a.f.b.j.q(paramString2, "mixThumbPath");
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    com.tencent.mm.plugin.story.h.d locald = j.b.cAG().mQ(paramLong);
    Object localObject2 = new StringBuilder("signStoryDataMix ").append(paramLong).append(" storyLocalId ");
    if (locald != null) {}
    int i;
    for (localObject1 = Integer.valueOf(locald.field_storyLocalId);; localObject1 = null)
    {
      ab.i("MicroMsg.Media.StoryDataProtoUtil", localObject1 + ", needExport:" + paramBoolean);
      if (locald == null) {
        break label723;
      }
      i = locald.field_mixFlag;
      localObject1 = a.e.sGg;
      if (!com.tencent.mm.ab.b.ck(i, a.e.cEB())) {
        break label723;
      }
      ab.i("MicroMsg.Media.StoryDataProtoUtil", "sign the data " + paramLong + " is mix end");
      i = locald.field_mixFlag;
      localObject1 = a.e.sGg;
      locald.field_mixFlag = (i & (a.e.cEB() ^ 0xFFFFFFFF));
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAG().b(paramLong, locald);
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.story.e.c.ssB;
        com.tencent.mm.plugin.story.e.c.a.acM(paramString1);
      }
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = j.b.cAB().Gb(locald.field_storyLocalId);
      if (localObject1 == null) {
        break label713;
      }
      i = ((com.tencent.mm.plugin.story.h.j)localObject1).field_localFlag;
      localObject2 = a.d.sGd;
      ((com.tencent.mm.plugin.story.h.j)localObject1).field_localFlag = (i & (a.d.cEA() ^ 0xFFFFFFFF));
      ((com.tencent.mm.plugin.story.h.j)localObject1).cEZ();
      localObject2 = q.svz;
      localObject2 = new chl();
      localObject3 = new StringBuilder();
      localObject4 = com.tencent.mm.plugin.story.e.c.ssB;
      localObject3 = ((StringBuilder)localObject3).append(com.tencent.mm.plugin.story.e.c.czO());
      localObject4 = cb.abq() + '-' + bo.yB();
      localObject5 = a.l.d.UTF_8;
      if (localObject4 != null) {
        break;
      }
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(109675);
      throw paramString1;
    }
    Object localObject4 = ((String)localObject4).getBytes((Charset)localObject5);
    a.f.b.j.p(localObject4, "(this as java.lang.String).getBytes(charset)");
    ((chl)localObject2).Id = com.tencent.mm.a.g.w((byte[])localObject4);
    Object localObject3 = com.tencent.mm.plugin.story.model.l.svv;
    localObject3 = com.tencent.mm.plugin.story.model.l.acY(((chl)localObject2).Id);
    localObject4 = com.tencent.mm.plugin.story.model.l.svv;
    localObject4 = com.tencent.mm.plugin.story.model.l.acX(((chl)localObject2).Id);
    Object localObject5 = com.tencent.mm.plugin.story.model.l.svv;
    com.tencent.mm.plugin.story.model.l.adc((String)localObject3);
    localObject5 = com.tencent.mm.plugin.story.model.l.svv;
    com.tencent.mm.plugin.story.model.l.adc((String)localObject4);
    localObject5 = com.tencent.mm.plugin.story.model.l.svv;
    com.tencent.mm.plugin.story.model.l.add((String)localObject3);
    localObject5 = com.tencent.mm.plugin.story.model.l.svv;
    com.tencent.mm.plugin.story.model.l.add((String)localObject4);
    paramLong = com.tencent.mm.vfs.e.C(paramString1, (String)localObject3);
    long l = com.tencent.mm.vfs.e.C(paramString2, (String)localObject4);
    ab.i("MicroMsg.Media.StoryDataProtoUtil", "copy video from " + paramString1 + " to " + (String)localObject3 + ", ret:" + paramLong);
    ab.i("MicroMsg.Media.StoryDataProtoUtil", "copy thumb from " + paramString2 + " to " + (String)localObject4 + ", ret:" + l);
    paramString1 = com.tencent.mm.plugin.sight.base.d.Zo((String)localObject3);
    float f;
    if (paramString1 != null)
    {
      f = paramString1.eVA / 1000.0F;
      ((chl)localObject2).duration = f;
      paramString1 = ((com.tencent.mm.plugin.story.h.j)localObject1).cEY();
      if (paramString1.xSK.wOa.size() != 0) {
        break label736;
      }
      paramString1.xSK.wOa.add(localObject2);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.story.h.j)localObject1).b(paramString1);
      paramString1 = com.tencent.mm.plugin.story.model.j.svi;
      i = j.b.cAB().a(locald.field_storyLocalId, (com.tencent.mm.plugin.story.h.j)localObject1);
      ab.i("MicroMsg.Media.StoryDataProtoUtil", "update mix storyInfo " + locald.field_storyLocalId + " newVideoPath:" + (String)localObject3 + "  newThumbPath:" + (String)localObject4 + " ret:" + i);
      label713:
      paramString1 = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAI().checkPost();
      label723:
      AppMethodBeat.o(109675);
      return;
      f = 0.0F;
      break;
      label736:
      paramString1.xSK.wOa.set(0, localObject2);
    }
  }
  
  public static void a(final chf paramchf, final Context paramContext, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(109672);
    a.f.b.j.q(paramchf, "storyEditorProtoData");
    a.f.b.j.q(paramContext, "context");
    a.f.b.j.q(paramViewGroup, "itemLayout");
    ab.i("MicroMsg.Media.StoryDataProtoUtil", "reshow the fake story which has editor item");
    Object localObject1 = (com.tencent.mm.plugin.story.c.a.c.a)com.tencent.mm.plugin.story.c.a.c.srQ.Uw();
    Object localObject6 = paramchf.videoPath;
    a.f.b.j.p(localObject6, "storyEditorProtoData.videoPath");
    ((com.tencent.mm.plugin.story.c.a.c.a)localObject1).acE((String)localObject6);
    localObject1 = paramchf.xSd;
    a.f.b.j.p(localObject1, "storyEditorProtoData.baseItemData");
    localObject6 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject6).hasNext())
    {
      Object localObject7 = (hp)((Iterator)localObject6).next();
      int i = ((hp)localObject7).dataType;
      float[] arrayOfFloat;
      Object localObject8;
      Float localFloat;
      Object localObject2;
      if (i == com.tencent.mm.media.editor.a.e.eSC.value)
      {
        localObject1 = (com.tencent.mm.bv.a)new cjv();
        localObject7 = ((hp)localObject7).wuo;
        a.f.b.j.p(localObject7, "it.itemData");
        localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
        a.f.b.j.p(localObject7, "it.itemData.buffer");
        localObject7 = ((com.tencent.mm.bv.b)localObject7).getBytes();
        try
        {
          ((com.tencent.mm.bv.a)localObject1).parseFrom((byte[])localObject7);
          localObject1 = (cjv)localObject1;
          if (localObject1 == null) {
            continue;
          }
          ab.i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + ((cjv)localObject1).text);
          localObject7 = new Matrix();
          arrayOfFloat = new float[9];
          i = 0;
          localObject8 = ((cjv)localObject1).xpW.xZD;
          a.f.b.j.p(localObject8, "it.matrix.value");
          localObject8 = ((Iterable)localObject8).iterator();
          while (((Iterator)localObject8).hasNext())
          {
            localFloat = (Float)((Iterator)localObject8).next();
            a.f.b.j.p(localFloat, "data");
            arrayOfFloat[i] = localFloat.floatValue();
            i += 1;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ab.a("safeParser", "", new Object[] { localException1 });
            localObject2 = null;
          }
          ((Matrix)localObject7).setValues(arrayOfFloat);
          al.d((Runnable)new k.a((cjv)localObject2, (Matrix)localObject7, paramContext, paramViewGroup, paramchf));
        }
      }
      else
      {
        Object localObject3;
        if (i == com.tencent.mm.media.editor.a.e.eSD.value)
        {
          localObject2 = (com.tencent.mm.bv.a)new zh();
          localObject7 = ((hp)localObject7).wuo;
          a.f.b.j.p(localObject7, "it.itemData");
          localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
          a.f.b.j.p(localObject7, "it.itemData.buffer");
          localObject7 = ((com.tencent.mm.bv.b)localObject7).getBytes();
          try
          {
            ((com.tencent.mm.bv.a)localObject2).parseFrom((byte[])localObject7);
            localObject2 = (zh)localObject2;
            if (localObject2 == null) {
              continue;
            }
            ab.i("MicroMsg.Media.StoryDataProtoUtil", "emoji md5 is " + ((zh)localObject2).cqq);
            localObject7 = new Matrix();
            arrayOfFloat = new float[9];
            i = 0;
            if (((zh)localObject2).wQl == null) {
              continue;
            }
            localObject8 = ((zh)localObject2).wQl.xZD;
            a.f.b.j.p(localObject8, "it.showMatrix.value");
            localObject8 = ((Iterable)localObject8).iterator();
            while (((Iterator)localObject8).hasNext())
            {
              localFloat = (Float)((Iterator)localObject8).next();
              a.f.b.j.p(localFloat, "data");
              arrayOfFloat[i] = localFloat.floatValue();
              i += 1;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ab.a("safeParser", "", new Object[] { localException2 });
              localObject3 = null;
            }
            ((Matrix)localObject7).setValues(arrayOfFloat);
            al.d((Runnable)new k.b((zh)localObject3, (Matrix)localObject7, new Rect(paramchf.xRZ, paramchf.xSb, paramchf.xSa, paramchf.xSc), paramContext, paramViewGroup, paramchf));
          }
        }
        else
        {
          Object localObject4;
          if (i == com.tencent.mm.media.editor.a.e.eSE.value)
          {
            localObject3 = (com.tencent.mm.bv.a)new bar();
            localObject7 = ((hp)localObject7).wuo;
            a.f.b.j.p(localObject7, "it.itemData");
            localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
            a.f.b.j.p(localObject7, "it.itemData.buffer");
            localObject7 = ((com.tencent.mm.bv.b)localObject7).getBytes();
            try
            {
              ((com.tencent.mm.bv.a)localObject3).parseFrom((byte[])localObject7);
              localObject3 = (bar)localObject3;
              if (localObject3 == null) {
                continue;
              }
              ab.i("MicroMsg.Media.StoryDataProtoUtil", "reshow location data is  " + ((bar)localObject3).eSL + " - " + ((bar)localObject3).eSM + " and matrix is " + ((bar)localObject3).xpW.xZD);
              localObject7 = new Matrix();
              arrayOfFloat = new float[9];
              i = 0;
              localObject8 = ((bar)localObject3).xpW.xZD;
              a.f.b.j.p(localObject8, "it.matrix.value");
              localObject8 = ((Iterable)localObject8).iterator();
              while (((Iterator)localObject8).hasNext())
              {
                localFloat = (Float)((Iterator)localObject8).next();
                a.f.b.j.p(localFloat, "data");
                arrayOfFloat[i] = localFloat.floatValue();
                i += 1;
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                ab.a("safeParser", "", new Object[] { localException3 });
                localObject4 = null;
              }
              ((Matrix)localObject7).setValues(arrayOfFloat);
              al.d((Runnable)new k.c((bar)localObject4, (Matrix)localObject7, paramContext, paramViewGroup, paramchf));
            }
          }
          else
          {
            Object localObject5;
            if (i == com.tencent.mm.media.editor.a.e.eSF.value)
            {
              localObject4 = (com.tencent.mm.bv.a)new cjv();
              localObject7 = ((hp)localObject7).wuo;
              a.f.b.j.p(localObject7, "it.itemData");
              localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
              a.f.b.j.p(localObject7, "it.itemData.buffer");
              localObject7 = ((com.tencent.mm.bv.b)localObject7).getBytes();
              try
              {
                ((com.tencent.mm.bv.a)localObject4).parseFrom((byte[])localObject7);
                localObject4 = (cjv)localObject4;
                if (localObject4 == null) {
                  continue;
                }
                ab.i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + ((cjv)localObject4).text);
                localObject7 = new Matrix();
                arrayOfFloat = new float[9];
                i = 0;
                localObject8 = ((cjv)localObject4).xpW.xZD;
                a.f.b.j.p(localObject8, "it.matrix.value");
                localObject8 = ((Iterable)localObject8).iterator();
                while (((Iterator)localObject8).hasNext())
                {
                  localFloat = (Float)((Iterator)localObject8).next();
                  a.f.b.j.p(localFloat, "data");
                  arrayOfFloat[i] = localFloat.floatValue();
                  i += 1;
                }
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  ab.a("safeParser", "", new Object[] { localException4 });
                  localObject5 = null;
                }
                ((Matrix)localObject7).setValues(arrayOfFloat);
                al.d((Runnable)new k.d((cjv)localObject5, (Matrix)localObject7, paramContext, paramViewGroup, paramchf));
              }
            }
            else if (i == com.tencent.mm.media.editor.a.e.eSG.value)
            {
              localObject5 = (com.tencent.mm.bv.a)new bay();
              localObject7 = ((hp)localObject7).wuo;
              a.f.b.j.p(localObject7, "it.itemData");
              localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
              a.f.b.j.p(localObject7, "it.itemData.buffer");
              localObject7 = ((com.tencent.mm.bv.b)localObject7).getBytes();
              try
              {
                ((com.tencent.mm.bv.a)localObject5).parseFrom((byte[])localObject7);
                localObject5 = (bay)localObject5;
                if (localObject5 != null)
                {
                  ab.i("MicroMsg.Media.StoryDataProtoUtil", "lyrics size is " + ((bay)localObject5).xqh.size());
                  localObject7 = new Matrix();
                  arrayOfFloat = new float[9];
                  i = 0;
                  localObject8 = ((bay)localObject5).xpW.xZD;
                  a.f.b.j.p(localObject8, "it.matrix.value");
                  localObject8 = ((Iterable)localObject8).iterator();
                  while (((Iterator)localObject8).hasNext())
                  {
                    localFloat = (Float)((Iterator)localObject8).next();
                    a.f.b.j.p(localFloat, "data");
                    arrayOfFloat[i] = localFloat.floatValue();
                    i += 1;
                  }
                }
              }
              catch (Exception localException5)
              {
                bay localbay;
                for (;;)
                {
                  ab.a("safeParser", "", new Object[] { localException5 });
                  localbay = null;
                }
                ((Matrix)localObject7).setValues(arrayOfFloat);
                al.d((Runnable)new e(localbay, (Matrix)localObject7, paramContext, paramViewGroup, paramchf));
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(109672);
  }
  
  public static com.tencent.mm.plugin.story.model.e.a b(chf paramchf, Context paramContext)
  {
    AppMethodBeat.i(109673);
    a.f.b.j.q(paramchf, "storyEditorProtoData");
    a.f.b.j.q(paramContext, "context");
    ab.i("MicroMsg.Media.StoryDataProtoUtil", "reshow the fake story as frame retriever");
    com.tencent.mm.plugin.story.c.a.c.a locala = (com.tencent.mm.plugin.story.c.a.c.a)com.tencent.mm.plugin.story.c.a.c.srQ.Uw();
    Object localObject1 = paramchf.videoPath;
    a.f.b.j.p(localObject1, "storyEditorProtoData.videoPath");
    locala.acE((String)localObject1);
    List localList = (List)new ArrayList();
    localObject1 = paramchf.xSd;
    a.f.b.j.p(localObject1, "storyEditorProtoData.baseItemData");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject7 = (hp)localIterator.next();
      i = ((hp)localObject7).dataType;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      Object localObject2;
      int k;
      if (i == com.tencent.mm.media.editor.a.e.eSC.value)
      {
        localObject1 = (com.tencent.mm.bv.a)new cjv();
        localObject7 = ((hp)localObject7).wuo;
        a.f.b.j.p(localObject7, "it.itemData");
        localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
        a.f.b.j.p(localObject7, "it.itemData.buffer");
        localObject7 = ((com.tencent.mm.bv.b)localObject7).getBytes();
        try
        {
          ((com.tencent.mm.bv.a)localObject1).parseFrom((byte[])localObject7);
          localObject7 = (cjv)localObject1;
          if (localObject7 == null) {
            continue;
          }
          ab.i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + ((cjv)localObject7).text);
          localObject1 = new Matrix();
          localObject8 = new float[9];
          i = 0;
          localObject9 = ((cjv)localObject7).xpW.xZD;
          a.f.b.j.p(localObject9, "it.matrix.value");
          localObject9 = ((Iterable)localObject9).iterator();
          while (((Iterator)localObject9).hasNext())
          {
            localObject10 = (Float)((Iterator)localObject9).next();
            a.f.b.j.p(localObject10, "data");
            localObject8[i] = ((Float)localObject10).floatValue();
            localObject10 = y.BMg;
            i += 1;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ab.a("safeParser", "", new Object[] { localException1 });
            localObject2 = null;
          }
          ((Matrix)localObject2).setValues((float[])localObject8);
          localObject8 = (CharSequence)((cjv)localObject7).text;
          j = ((cjv)localObject7).textColor;
          k = ((cjv)localObject7).eTj;
          ab.i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the text editor item");
          if (localObject8 == null) {
            break label406;
          }
        }
        if (a.l.m.ap((CharSequence)localObject8))
        {
          label406:
          i = 1;
          label408:
          if (i == 0) {
            break label438;
          }
        }
        for (localObject2 = null;; localObject2 = ((com.tencent.mm.plugin.story.ui.view.editor.item.g)localObject7).UH())
        {
          if (localObject2 == null) {
            break label468;
          }
          localList.add(localObject2);
          break;
          i = 0;
          break label408;
          label438:
          localObject7 = new com.tencent.mm.plugin.story.ui.view.editor.item.g(paramContext);
          ((com.tencent.mm.plugin.story.ui.view.editor.item.g)localObject7).a((CharSequence)localObject8, j, k, (Matrix)localObject2);
        }
      }
      else
      {
        label468:
        Object localObject3;
        if (i == com.tencent.mm.media.editor.a.e.eSD.value)
        {
          localObject2 = (com.tencent.mm.bv.a)new zh();
          localObject7 = ((hp)localObject7).wuo;
          a.f.b.j.p(localObject7, "it.itemData");
          localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
          a.f.b.j.p(localObject7, "it.itemData.buffer");
          localObject7 = ((com.tencent.mm.bv.b)localObject7).getBytes();
          try
          {
            ((com.tencent.mm.bv.a)localObject2).parseFrom((byte[])localObject7);
            localObject7 = (zh)localObject2;
            if (localObject7 == null) {
              continue;
            }
            ab.i("MicroMsg.Media.StoryDataProtoUtil", "emoji md5 is " + ((zh)localObject7).cqq);
            localObject2 = new Matrix();
            localObject8 = new float[9];
            i = 0;
            if (((zh)localObject7).wQl != null)
            {
              localObject9 = ((zh)localObject7).wQl.xZD;
              a.f.b.j.p(localObject9, "it.showMatrix.value");
              localObject9 = ((Iterable)localObject9).iterator();
              while (((Iterator)localObject9).hasNext())
              {
                localObject10 = (Float)((Iterator)localObject9).next();
                a.f.b.j.p(localObject10, "data");
                localObject8[i] = ((Float)localObject10).floatValue();
                localObject10 = y.BMg;
                i += 1;
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ab.a("safeParser", "", new Object[] { localException2 });
              localObject3 = null;
            }
            ((Matrix)localObject3).setValues((float[])localObject8);
            new Rect(paramchf.xRZ, paramchf.xSb, paramchf.xSa, paramchf.xSc);
            localObject8 = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
            a.f.b.j.p(localObject8, "MMKernel.plugin(IPluginEmoji::class.java)");
            localObject7 = ((com.tencent.mm.plugin.emoji.b.d)localObject8).getProvider().Ku(((zh)localObject7).cqq);
            a.f.b.j.p(localObject7, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
            ab.i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the emoji editor item");
            localObject8 = new com.tencent.mm.plugin.story.ui.view.editor.item.b(paramContext, true);
            ((com.tencent.mm.plugin.story.ui.view.editor.item.b)localObject8).setViewMatrix((Matrix)localObject3);
            ((com.tencent.mm.plugin.story.ui.view.editor.item.b)localObject8).setEmojiInfo((EmojiInfo)localObject7);
            localObject3 = ((com.tencent.mm.plugin.story.ui.view.editor.item.b)localObject8).UH();
            if (localObject3 != null) {
              localList.add(localObject3);
            }
            localObject3 = y.BMg;
          }
        }
        else
        {
          Object localObject4;
          if (i == com.tencent.mm.media.editor.a.e.eSE.value)
          {
            localObject3 = (com.tencent.mm.bv.a)new bar();
            localObject7 = ((hp)localObject7).wuo;
            a.f.b.j.p(localObject7, "it.itemData");
            localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
            a.f.b.j.p(localObject7, "it.itemData.buffer");
            localObject7 = ((com.tencent.mm.bv.b)localObject7).getBytes();
            try
            {
              ((com.tencent.mm.bv.a)localObject3).parseFrom((byte[])localObject7);
              localObject7 = (bar)localObject3;
              if (localObject7 == null) {
                continue;
              }
              ab.i("MicroMsg.Media.StoryDataProtoUtil", "reshow location data is  " + ((bar)localObject7).eSL + " - " + ((bar)localObject7).eSM + " and matrix is " + ((bar)localObject7).xpW.xZD);
              localObject3 = new Matrix();
              localObject8 = new float[9];
              i = 0;
              localObject9 = ((bar)localObject7).xpW.xZD;
              a.f.b.j.p(localObject9, "it.matrix.value");
              localObject9 = ((Iterable)localObject9).iterator();
              while (((Iterator)localObject9).hasNext())
              {
                localObject10 = (Float)((Iterator)localObject9).next();
                a.f.b.j.p(localObject10, "data");
                localObject8[i] = ((Float)localObject10).floatValue();
                localObject10 = y.BMg;
                i += 1;
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                ab.a("safeParser", "", new Object[] { localException3 });
                localObject4 = null;
              }
              ((Matrix)localObject4).setValues((float[])localObject8);
              localObject8 = ((bar)localObject7).eSL;
              a.f.b.j.p(localObject8, "it.cityName");
              localObject7 = ((bar)localObject7).eSM;
              a.f.b.j.p(localObject7, "it.poiName");
              ab.i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the position editor item");
              localObject9 = new com.tencent.mm.plugin.story.ui.view.editor.item.f(paramContext);
              ((com.tencent.mm.plugin.story.ui.view.editor.item.f)localObject9).a((String)localObject8, (String)localObject7, (Matrix)localObject4);
              localObject4 = ((com.tencent.mm.plugin.story.ui.view.editor.item.f)localObject9).UH();
            }
            if (localObject4 != null) {
              localList.add(localObject4);
            }
          }
          else
          {
            Object localObject5;
            if (i == com.tencent.mm.media.editor.a.e.eSF.value)
            {
              localObject4 = (com.tencent.mm.bv.a)new cjv();
              localObject7 = ((hp)localObject7).wuo;
              a.f.b.j.p(localObject7, "it.itemData");
              localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
              a.f.b.j.p(localObject7, "it.itemData.buffer");
              localObject7 = ((com.tencent.mm.bv.b)localObject7).getBytes();
              int m;
              try
              {
                ((com.tencent.mm.bv.a)localObject4).parseFrom((byte[])localObject7);
                localObject7 = (cjv)localObject4;
                if (localObject7 == null) {
                  continue;
                }
                ab.i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + ((cjv)localObject7).text);
                localObject4 = new Matrix();
                localObject8 = new float[9];
                i = 0;
                localObject9 = ((cjv)localObject7).xpW.xZD;
                a.f.b.j.p(localObject9, "it.matrix.value");
                localObject9 = ((Iterable)localObject9).iterator();
                while (((Iterator)localObject9).hasNext())
                {
                  localObject10 = (Float)((Iterator)localObject9).next();
                  a.f.b.j.p(localObject10, "data");
                  localObject8[i] = ((Float)localObject10).floatValue();
                  localObject10 = y.BMg;
                  i += 1;
                }
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  ab.a("safeParser", "", new Object[] { localException4 });
                  localObject5 = null;
                }
                ((Matrix)localObject5).setValues((float[])localObject8);
                localObject8 = (CharSequence)((cjv)localObject7).text;
                j = ((cjv)localObject7).textColor;
                k = ((cjv)localObject7).eTj;
                m = ((cjv)localObject7).eTk;
                ab.i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the text editor item");
                if (localObject8 == null) {
                  break label1484;
                }
              }
              if (a.l.m.ap((CharSequence)localObject8))
              {
                label1484:
                i = 1;
                label1486:
                if (i == 0) {
                  break label1516;
                }
              }
              for (localObject5 = null;; localObject5 = ((com.tencent.mm.plugin.story.ui.view.editor.item.h)localObject7).UH())
              {
                if (localObject5 == null) {
                  break label1548;
                }
                localList.add(localObject5);
                break;
                i = 0;
                break label1486;
                label1516:
                localObject7 = new com.tencent.mm.plugin.story.ui.view.editor.item.h(paramContext);
                ((com.tencent.mm.plugin.story.ui.view.editor.item.h)localObject7).a((CharSequence)localObject8, j, k, m, (Matrix)localObject5);
              }
            }
            else
            {
              label1548:
              if (i == com.tencent.mm.media.editor.a.e.eSG.value)
              {
                localObject5 = (com.tencent.mm.bv.a)new bay();
                localObject7 = ((hp)localObject7).wuo;
                a.f.b.j.p(localObject7, "it.itemData");
                localObject7 = ((SKBuiltinBuffer_t)localObject7).getBuffer();
                a.f.b.j.p(localObject7, "it.itemData.buffer");
                localObject7 = ((com.tencent.mm.bv.b)localObject7).getBytes();
                Object localObject6;
                try
                {
                  ((com.tencent.mm.bv.a)localObject5).parseFrom((byte[])localObject7);
                  localObject7 = (bay)localObject5;
                  if (localObject7 == null) {
                    continue;
                  }
                  ab.i("MicroMsg.Media.StoryDataProtoUtil", "lyrics size is " + ((bay)localObject7).xqh.size());
                  localObject5 = new Matrix();
                  localObject8 = new float[9];
                  i = 0;
                  localObject9 = ((bay)localObject7).xpW.xZD;
                  a.f.b.j.p(localObject9, "it.matrix.value");
                  localObject9 = ((Iterable)localObject9).iterator();
                  while (((Iterator)localObject9).hasNext())
                  {
                    localObject10 = (Float)((Iterator)localObject9).next();
                    a.f.b.j.p(localObject10, "data");
                    localObject8[i] = ((Float)localObject10).floatValue();
                    localObject10 = y.BMg;
                    i += 1;
                  }
                }
                catch (Exception localException5)
                {
                  for (;;)
                  {
                    ab.a("safeParser", "", new Object[] { localException5 });
                    localObject6 = null;
                  }
                  ((Matrix)localObject6).setValues((float[])localObject8);
                  long l1 = paramchf.endTime;
                  long l2 = paramchf.startTime;
                  localObject7 = ((bay)localObject7).xqh;
                  a.f.b.j.p(localObject7, "it.lyricsList");
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
    int i = locala.eWL;
    if ((i == 270) || (i == 90))
    {
      j = 1;
      if (j == 0) {
        break label1916;
      }
      i = locala.eRv;
      label1883:
      if (j == 0) {
        break label1925;
      }
    }
    label1925:
    for (int j = locala.eRu;; j = locala.eRv)
    {
      if (localList.size() != 0) {
        break label1934;
      }
      AppMethodBeat.o(109673);
      return null;
      j = 0;
      break;
      label1916:
      i = locala.eRu;
      break label1883;
    }
    label1934:
    if ((i == 0) || (j == 0))
    {
      ab.i("MicroMsg.Media.StoryDataProtoUtil", "error width " + i + " height " + j);
      AppMethodBeat.o(109673);
      return null;
    }
    paramContext = com.tencent.mm.plugin.story.e.c.ssB;
    paramContext = paramchf.videoPath;
    a.f.b.j.p(paramContext, "storyEditorProtoData.videoPath");
    paramContext = com.tencent.mm.plugin.story.e.c.a.acN(paramContext);
    if ((!paramchf.fbp) && (paramContext != null) && (!paramContext.ssC))
    {
      paramchf = new com.tencent.mm.plugin.story.model.e.a(b(paramchf), localList, i, j, paramContext.width, paramContext.height, 0);
      AppMethodBeat.o(109673);
      return paramchf;
    }
    paramchf = new com.tencent.mm.plugin.story.model.e.a(b(paramchf), localList, i, j, 0, 0, 0);
    AppMethodBeat.o(109673);
    return paramchf;
  }
  
  public static float[] b(chf paramchf)
  {
    AppMethodBeat.i(109674);
    a.f.b.j.q(paramchf, "storyEditorProtoData");
    float f1 = paramchf.xRZ;
    float f2 = paramchf.xSb;
    float f3 = paramchf.xSa;
    float f4 = paramchf.xSc;
    AppMethodBeat.o(109674);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static void c(chf paramchf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(109682);
    ab.b("MicroMsg.Media.StoryDataProtoUtil", "cleanUnAvailableData, videoPath " + paramchf + "?.videoPath", new Object[0]);
    if ((paramchf != null) && (paramchf.fbp == true)) {
      com.tencent.mm.vfs.e.deleteFile(paramchf.videoPath);
    }
    if (paramchf != null)
    {
      localObject1 = paramchf.xRY;
      com.tencent.mm.vfs.e.deleteFile((String)localObject1);
      if (paramchf == null) {
        break label116;
      }
    }
    label116:
    for (Object localObject1 = paramchf.eXm;; localObject1 = null)
    {
      com.tencent.mm.vfs.e.deleteFile((String)localObject1);
      localObject1 = localObject2;
      if (paramchf != null) {
        localObject1 = paramchf.thumbPath;
      }
      com.tencent.mm.vfs.e.deleteFile((String)localObject1);
      AppMethodBeat.o(109682);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static Rect cCr()
  {
    return eTC;
  }
  
  public static int cCs()
  {
    return sCo;
  }
  
  public static void cCt()
  {
    sCo = 0;
  }
  
  public static void cCu()
  {
    AppMethodBeat.i(109679);
    ab.i("MicroMsg.Media.StoryDataProtoUtil", "run clean dirty data which is the ismixed equals true");
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAG();
    localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    Object localObject2 = j.b.cAG();
    localObject1 = new ArrayList();
    localObject2 = ((com.tencent.mm.plugin.story.h.e)localObject2).db;
    Object localObject3 = new StringBuilder("mixFlag&");
    a.e locale = a.e.sGg;
    localObject2 = ((com.tencent.mm.sdk.e.e)localObject2).query("StoryEditorInfo", null, a.e.cEB() + "=0", null, null, null, null);
    if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst()))
    {
      do
      {
        localObject3 = new com.tencent.mm.plugin.story.h.d();
        ((com.tencent.mm.plugin.story.h.d)localObject3).convertFrom((Cursor)localObject2);
        ((ArrayList)localObject1).add(Long.valueOf(((com.tencent.mm.plugin.story.h.d)localObject3).field_timeStamp));
      } while (((Cursor)localObject2).moveToNext());
      ((Cursor)localObject2).close();
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      ab.i("MicroMsg.Media.StoryDataProtoUtil", "delete the source data which is mix up");
      a.f.b.j.p(localObject2, "i");
      c(mE(((Long)localObject2).longValue()));
    }
    AppMethodBeat.o(109679);
  }
  
  public static boolean gP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(109683);
    a.f.b.j.q(paramString1, "file");
    paramString1 = com.tencent.mm.a.g.getMD5(paramString1);
    if ((paramString1 != null) && (paramString2 != null) && (a.l.m.I(paramString2, paramString1, true)))
    {
      AppMethodBeat.o(109683);
      return true;
    }
    AppMethodBeat.o(109683);
    return false;
  }
  
  public static void mC(long paramLong)
  {
    AppMethodBeat.i(109676);
    ab.i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMixError ".concat(String.valueOf(paramLong)));
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    localObject1 = j.b.cAG().mQ(paramLong);
    if ((localObject1 != null) && (((com.tencent.mm.plugin.story.h.d)localObject1).cEN()))
    {
      int i = ((com.tencent.mm.plugin.story.h.d)localObject1).field_mixFlag;
      Object localObject2 = a.e.sGg;
      ((com.tencent.mm.plugin.story.h.d)localObject1).field_mixFlag = (i & (a.e.cEB() ^ 0xFFFFFFFF));
      i = ((com.tencent.mm.plugin.story.h.d)localObject1).field_mixFlag;
      localObject2 = a.e.sGg;
      ((com.tencent.mm.plugin.story.h.d)localObject1).field_mixFlag = (i | a.e.cEC());
      localObject2 = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAG().b(paramLong, (com.tencent.mm.plugin.story.h.d)localObject1);
      localObject2 = com.tencent.mm.plugin.story.model.j.svi;
      localObject2 = j.b.cAB().Gb(((com.tencent.mm.plugin.story.h.d)localObject1).field_storyLocalId);
      if (localObject2 != null)
      {
        ((com.tencent.mm.plugin.story.h.j)localObject2).csL();
        j.b localb = com.tencent.mm.plugin.story.model.j.svi;
        j.b.cAB().a(((com.tencent.mm.plugin.story.h.d)localObject1).field_storyLocalId, (com.tencent.mm.plugin.story.h.j)localObject2);
      }
    }
    AppMethodBeat.o(109676);
  }
  
  public static void mD(long paramLong)
  {
    AppMethodBeat.i(109678);
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    localObject = j.b.cAG().mQ(paramLong);
    if ((localObject != null) && (((com.tencent.mm.plugin.story.h.d)localObject).cEN()))
    {
      ((com.tencent.mm.plugin.story.h.d)localObject).field_mixRetryTime += 1;
      j.b localb = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAG().b(paramLong, (com.tencent.mm.plugin.story.h.d)localObject);
    }
    AppMethodBeat.o(109678);
  }
  
  public static chf mE(long paramLong)
  {
    AppMethodBeat.i(109680);
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    Object localObject3 = j.b.cAG().db.query("StoryEditorInfo", null, "timeStamp=".concat(String.valueOf(paramLong)), null, null, null, null);
    if (localObject3 != null) {
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new com.tencent.mm.plugin.story.h.d();
        ((com.tencent.mm.plugin.story.h.d)localObject1).convertFrom((Cursor)localObject3);
        ((Cursor)localObject3).close();
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((com.tencent.mm.plugin.story.h.d)localObject1).cEN()))
      {
        ab.i("MicroMsg.Media.StoryDataProtoUtil", "is running mix and use the editor data to show " + ((com.tencent.mm.plugin.story.h.d)localObject1).field_mixFlag);
        localObject3 = new chf();
        try
        {
          localObject1 = ((com.tencent.mm.plugin.story.h.d)localObject1).field_baseItemData;
          a.f.b.j.p(localObject1, "field_baseItemData");
          ((chf)localObject3).parseFrom((byte[])localObject1);
          AppMethodBeat.o(109680);
          return localObject3;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.Media.StoryDataProtoUtil", (Throwable)localException, "", new Object[0]);
          }
        }
      }
      ab.i("MicroMsg.Media.StoryDataProtoUtil", "has no editor data ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(109680);
      return null;
      Object localObject2 = null;
      break;
      localObject2 = null;
    }
  }
  
  public static void mF(long paramLong)
  {
    AppMethodBeat.i(109681);
    ab.i("MicroMsg.Media.StoryDataProtoUtil", "run clean null data");
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAG().db.delete("StoryEditorInfo", "timeStamp=".concat(String.valueOf(paramLong)), null);
    AppMethodBeat.o(109681);
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$reshowStoryDataEditorItem$1$5$2", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$$special$$inlined$let$lambda$5"})
  static final class e
    implements Runnable
  {
    e(bay parambay, Matrix paramMatrix, Context paramContext, ViewGroup paramViewGroup, chf paramchf) {}
    
    public final void run()
    {
      AppMethodBeat.i(151098);
      long l1 = paramchf.endTime;
      long l2 = paramchf.startTime;
      Object localObject = k.sCp;
      localObject = this.sCx.xqh;
      a.f.b.j.p(localObject, "it.lyricsList");
      k.a((List)localObject, this.sCr, paramContext, paramViewGroup, l1 - l2);
      AppMethodBeat.o(151098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.k
 * JD-Core Version:    0.7.0.1
 */