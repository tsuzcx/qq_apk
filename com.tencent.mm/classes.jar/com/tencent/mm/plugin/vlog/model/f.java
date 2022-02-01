package com.tencent.mm.plugin.vlog.model;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.plugin.vlog.model.local.a.c;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.dmc;
import com.tencent.mm.protocal.protobuf.enx;
import com.tencent.mm.protocal.protobuf.fxt;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/CompositionInfoConverter;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editData", "Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getEditData", "()Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "magicProtoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MagicInfoProto;", "getMagicProtoList", "()Ljava/util/LinkedList;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getOutputConfig", "()Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "templateInfo", "Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "getTemplateInfo", "()Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "setTemplateInfo", "(Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;)V", "addEditInfo", "", "drawingRect", "Landroid/graphics/Rect;", "validRect", "", "editItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "addMagicInfo", "magicList", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "addTemplateInfo", "template", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "chooseExportConfig", "path", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewSize", "Landroid/util/Size;", "cropRect", "enableAdaptiveBitrate", "", "enableFullscreen", "getCompositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final String TAG;
  public static final a TYz;
  private final ac TYA;
  private final afc TYB;
  private final afa TYC;
  private final LinkedList<dmc> TYD;
  private fxt TYE;
  
  static
  {
    AppMethodBeat.i(283404);
    TYz = new a((byte)0);
    TAG = "MicroMsg.CompositionInfoConverter";
    AppMethodBeat.o(283404);
  }
  
  public f(ac paramac)
  {
    AppMethodBeat.i(283382);
    this.TYA = paramac;
    this.TYB = new afc();
    this.TYC = new afa();
    this.TYD = new LinkedList();
    AppMethodBeat.o(283382);
  }
  
  public final afc a(String paramString, VideoTransPara paramVideoTransPara, Size paramSize, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(283434);
    s.u(paramString, "path");
    s.u(paramVideoTransPara, "videoTransPara");
    s.u(paramSize, "previewSize");
    s.u(paramRect, "cropRect");
    Object localObject1 = new VideoTransPara(paramVideoTransPara);
    int j = ((VideoTransPara)localObject1).width;
    int k = (int)(j * (paramSize.getHeight() / paramSize.getWidth()));
    ((VideoTransPara)localObject1).width = j;
    ((VideoTransPara)localObject1).height = k;
    this.TYB.outputPath = paramString;
    this.TYB.HJN = a.TM(paramSize.getWidth());
    this.TYB.HJO = a.TM(paramSize.getHeight());
    this.TYB.Znq = 1.0F;
    paramString = this.TYB;
    Object localObject2 = new enx();
    h.a(paramRect, (enx)localObject2);
    Object localObject3 = ah.aiuX;
    paramString.Znp = ((enx)localObject2);
    if (paramBoolean2)
    {
      this.TYB.nxO = a.TM(j);
      this.TYB.nxP = a.TM(k);
      a.a(paramVideoTransPara, this.TYB);
      localObject2 = (Iterable)this.TYA.TDz;
      paramString = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
    }
    label227:
    int i;
    label327:
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label329;
      }
      localObject3 = ((Iterator)localObject2).next();
      if (((ad)localObject3).type == 2) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label327;
        }
        paramString.add(localObject3);
        break label227;
        this.TYB.nxO = a.TM(((VideoTransPara)localObject1).width);
        this.TYB.nxP = a.TM(((VideoTransPara)localObject1).width * paramRect.height() / paramRect.width());
        break;
      }
    }
    label329:
    if (((List)paramString).size() == 1)
    {
      paramString = ((Iterable)this.TYA.TDz).iterator();
      if (paramString.hasNext())
      {
        localObject2 = paramString.next();
        if (((ad)localObject2).type == 2)
        {
          i = 1;
          if (i == 0) {
            break label1104;
          }
          paramString = (ad)localObject2;
          paramString = MultiMediaVideoChecker.ObB.aTG(paramString.path);
          if ((paramString != null) && (paramString.width > 0) && (paramString.height > 0) && (paramString.eGw > 0.0F))
          {
            if ((paramString.hYK != 0) && (paramString.hYK != 180)) {
              break label1127;
            }
            i = paramString.width;
            label465:
            if (this.TYB.nxO > i)
            {
              Log.i(TAG, "outputConfig.targetWidth(" + this.TYB.nxO + ") > widthLimit(" + i + ')');
              if (paramBoolean2) {
                break label1136;
              }
              this.TYB.nxO = a.TM(i);
              this.TYB.nxP = a.TM((int)(1.0D * paramRect.height() / paramRect.width() * this.TYB.nxO));
              Log.i(TAG, "update targetSize:[" + this.TYB.nxO + ", " + this.TYB.nxP + ']');
            }
            if ((paramString.hYK != 0) && (paramString.hYK != 180)) {
              break label1180;
            }
            j = paramString.height;
            Log.i(TAG, "previewSize:" + paramSize + ", videoParam.width:" + ((VideoTransPara)localObject1).width + ", heightLimit:" + j);
            if ((paramBoolean2) && (i > j))
            {
              k = Math.min(j, ((VideoTransPara)localObject1).width);
              if (paramSize.getHeight() >= k) {
                break label1189;
              }
              this.TYB.Znq = (k / this.TYB.nxP);
              Log.i(TAG, s.X("[widescreen] update outputScale:", Float.valueOf(this.TYB.Znq)));
            }
            if (!this.TYA.CWm)
            {
              if (this.TYB.audioBitrate > paramString.audioBitrate) {
                this.TYB.audioBitrate = paramString.audioBitrate;
              }
              if ((this.TYB.audioSampleRate > paramString.audioSampleRate) && (paramString.audioSampleRate > 1000)) {
                this.TYB.audioSampleRate = paramString.audioSampleRate;
              }
            }
            this.TYB.fps = Math.min(this.TYB.fps, (int)paramString.eGw);
            this.TYB.audioChannelCount = Math.min(paramString.audioChannelCount, 2);
          }
        }
      }
    }
    for (;;)
    {
      label393:
      label574:
      this.TYB.audioChannelCount = Math.min(this.TYB.audioChannelCount, 2);
      label647:
      if (paramBoolean1) {
        a.a(a.a(this.TYA, paramVideoTransPara, this.TYB.nxO, this.TYB.nxP, this.TYC.Znd.isEmpty()), this.TYB);
      }
      label769:
      Log.i(TAG, "getExportConfig: origin: " + this.TYB.HJN + ", " + this.TYB.HJO + ", " + this.TYB.Znp + " target: " + this.TYB.nxO + ", " + this.TYB.nxP + ", audio:" + this.TYB.audioChannelCount + ',' + this.TYB.audioBitrate + ',' + this.TYB.audioSampleRate + ", cropRect:" + paramRect);
      paramString = this.TYB;
      AppMethodBeat.o(283434);
      return paramString;
      i = 0;
      break label393;
      label1104:
      break;
      paramString = (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
      AppMethodBeat.o(283434);
      throw paramString;
      label1127:
      i = paramString.height;
      break label465;
      label1136:
      this.TYB.nxO = a.TM(i);
      this.TYB.nxP = a.TM((int)(1.0D * k / j * this.TYB.nxO));
      break label574;
      label1180:
      j = paramString.width;
      break label647;
      label1189:
      this.TYB.nxP = a.TM(k);
      paramSize = this.TYB;
      float f = k;
      paramSize.nxO = a.TM((int)(i * f / j));
      Log.i(TAG, "[widescreen] update targetSize:[" + this.TYB.nxO + ", " + this.TYB.nxP + ']');
      break label769;
      paramSize = (Iterable)this.TYA.TDz;
      paramString = (Collection)new ArrayList();
      paramSize = paramSize.iterator();
      label1367:
      while (paramSize.hasNext())
      {
        localObject1 = paramSize.next();
        if (((ad)localObject1).type == 2) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1367;
          }
          paramString.add(localObject1);
          break;
        }
      }
      paramString = (Iterable)paramString;
      label1441:
      if (!((Collection)paramString).isEmpty())
      {
        paramString = paramString.iterator();
        label1396:
        if (paramString.hasNext())
        {
          paramSize = (ad)paramString.next();
          paramSize = MultiMediaVideoChecker.ObB.aTG(paramSize.path);
          if ((paramSize != null) && (paramSize.audioChannelCount == 1))
          {
            i = 1;
            if (i == 0) {
              break label1469;
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1477;
        }
        this.TYB.audioChannelCount = 1;
        break;
        i = 0;
        break label1441;
        label1469:
        break label1396;
      }
      label1477:
      this.TYB.audioChannelCount = 2;
    }
  }
  
  public final void a(Rect paramRect, float[] paramArrayOfFloat, List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(283445);
    s.u(paramRect, "drawingRect");
    s.u(paramArrayOfFloat, "validRect");
    s.u(paramList, "editItems");
    this.TYC.Znc = new enx();
    Object localObject = this.TYC.Znc;
    s.s(localObject, "editData.drawingRect");
    h.a(paramRect, (enx)localObject);
    this.TYC.Znf = new enx();
    paramRect = new Rect((int)paramArrayOfFloat[0], (int)paramArrayOfFloat[1], (int)paramArrayOfFloat[2], (int)paramArrayOfFloat[3]);
    paramArrayOfFloat = this.TYC.Znf;
    s.s(paramArrayOfFloat, "editData.validRect");
    h.a(paramRect, paramArrayOfFloat);
    paramRect = this.TYC.Znd;
    paramList = (Iterable)paramList;
    paramArrayOfFloat = (Collection)new ArrayList(p.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramList.next();
      jy localjy = new jy();
      localjy.dataType = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).NXP.value;
      localjy.YMl = w.aN(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).gKs().toByteArray());
      paramArrayOfFloat.add(localjy);
    }
    paramRect.addAll((Collection)paramArrayOfFloat);
    AppMethodBeat.o(283445);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(283459);
    s.u(paramc, "template");
    this.TYE = h.b(paramc);
    AppMethodBeat.o(283459);
  }
  
  public final afb hQn()
  {
    AppMethodBeat.i(283468);
    afb localafb = h.a(this.TYA, this.TYB);
    localafb.TYC = this.TYC;
    localafb.Znk.addAll((Collection)this.TYD);
    localafb.Znl = this.TYE;
    if (this.TYE != null) {
      localafb.Uax = false;
    }
    AppMethodBeat.o(283468);
    return localafb;
  }
  
  public final void lH(List<com.tencent.mm.plugin.vlog.model.effect.b> paramList)
  {
    AppMethodBeat.i(283452);
    s.u(paramList, "magicList");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.vlog.model.effect.b)paramList.next();
      LinkedList localLinkedList = this.TYD;
      dmc localdmc = new dmc();
      localdmc.path = ((com.tencent.mm.plugin.vlog.model.effect.b)localObject).Ubx.LWN;
      localdmc.start = ((com.tencent.mm.plugin.vlog.model.effect.b)localObject).start;
      localdmc.axI = ((com.tencent.mm.plugin.vlog.model.effect.b)localObject).axI;
      localObject = ah.aiuX;
      localLinkedList.add(localdmc);
    }
    AppMethodBeat.o(283452);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/CompositionInfoConverter$Companion;", "", "()V", "MONO_CHANNEL_COUNT", "", "STEREO_CHANNEL_COUNT", "TAG", "", "abaResultToOutputConfig", "", "abaResult", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getABAResult", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "targetWidth", "targetHeight", "addStickers", "", "Lcom/tencent/mm/videocomposition/VideoComposition;", "resize2Even", "value", "videoParamsToOutputConfig", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int TM(int paramInt)
    {
      int i = paramInt;
      if (paramInt % 2 != 0) {
        i = paramInt - 1;
      }
      return i;
    }
    
    public static a a(ac paramac, VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(283528);
      s.u(paramac, "composition");
      s.u(paramVideoTransPara, "videoParams");
      paramac = (Iterable)paramac.TDz;
      Object localObject = (Collection)new ArrayList();
      Iterator localIterator = paramac.iterator();
      label122:
      while (localIterator.hasNext())
      {
        paramac = (ad)localIterator.next();
        if (paramac.type == 2) {}
        for (paramac = new b(paramac.path, paramac.UaI.TDw, paramac.UaI.TDx);; paramac = null)
        {
          if (paramac == null) {
            break label122;
          }
          ((Collection)localObject).add(paramac);
          break;
        }
      }
      paramac = (List)localObject;
      localObject = c.TXW;
      paramac = c.a(paramac, paramVideoTransPara, paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(283528);
      return paramac;
    }
    
    public static void a(VideoTransPara paramVideoTransPara, afc paramafc)
    {
      AppMethodBeat.i(283549);
      s.u(paramVideoTransPara, "videoParams");
      s.u(paramafc, "outputConfig");
      paramafc.videoBitrate = paramVideoTransPara.videoBitrate;
      paramafc.fps = paramVideoTransPara.fps;
      paramafc.nCd = paramVideoTransPara.nCd;
      paramafc.audioBitrate = paramVideoTransPara.audioBitrate;
      paramafc.audioSampleRate = paramVideoTransPara.audioSampleRate;
      paramafc.audioChannelCount = paramVideoTransPara.audioChannelCount;
      paramafc.oCb = paramVideoTransPara.oCb;
      AppMethodBeat.o(283549);
    }
    
    public static void a(a parama, afc paramafc)
    {
      AppMethodBeat.i(283540);
      s.u(parama, "abaResult");
      s.u(paramafc, "outputConfig");
      if (parama.errCode == 0)
      {
        if ((parama.width > 0) && (parama.height > 0) && (parama.bitrate > 0))
        {
          paramafc.nxO = parama.width;
          paramafc.nxP = parama.height;
          paramafc.videoBitrate = parama.bitrate;
          Log.i(f.access$getTAG$cp(), "video abaResult, width:" + paramafc.nxO + ", height:" + paramafc.nxP + ", " + paramafc.videoBitrate);
        }
        parama = parama.Gbz;
        if (parama != null)
        {
          parama = parama.transToList();
          if (parama != null) {
            paramafc.Znr.addAll((Collection)parama);
          }
        }
      }
      AppMethodBeat.o(283540);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.f
 * JD-Core Version:    0.7.0.1
 */