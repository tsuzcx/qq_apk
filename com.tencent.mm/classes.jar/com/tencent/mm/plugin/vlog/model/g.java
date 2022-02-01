package com.tencent.mm.plugin.vlog.model;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.plugin.vlog.model.local.a.c;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.fbj;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/CompositionInfoConverter;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editData", "Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getEditData", "()Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "magicProtoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MagicInfoProto;", "getMagicProtoList", "()Ljava/util/LinkedList;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getOutputConfig", "()Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "templateInfo", "Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "getTemplateInfo", "()Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "setTemplateInfo", "(Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;)V", "addEditInfo", "", "drawingRect", "Landroid/graphics/Rect;", "validRect", "", "editItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "addMagicInfo", "magicList", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "addTemplateInfo", "template", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "chooseExportConfig", "path", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewSize", "Landroid/util/Size;", "cropRect", "enableAdaptiveBitrate", "", "enableFullscreen", "getCompositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "Companion", "plugin-vlog_release"})
public final class g
{
  public static final a Nlc;
  private static final String TAG = "MicroMsg.CompositionInfoConverter";
  private final acv NkX;
  private final act NkY;
  private final LinkedList<cuw> NkZ;
  private fbj Nla;
  private final ac Nlb;
  
  static
  {
    AppMethodBeat.i(227019);
    Nlc = new a((byte)0);
    TAG = "MicroMsg.CompositionInfoConverter";
    AppMethodBeat.o(227019);
  }
  
  public g(ac paramac)
  {
    AppMethodBeat.i(227017);
    this.Nlb = paramac;
    this.NkX = new acv();
    this.NkY = new act();
    this.NkZ = new LinkedList();
    AppMethodBeat.o(227017);
  }
  
  public final acv a(String paramString, VideoTransPara paramVideoTransPara, Size paramSize, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(226993);
    p.k(paramString, "path");
    p.k(paramVideoTransPara, "videoTransPara");
    p.k(paramSize, "previewSize");
    p.k(paramRect, "cropRect");
    Object localObject1 = new VideoTransPara(paramVideoTransPara);
    int j = ((VideoTransPara)localObject1).width;
    int k = (int)(j * (paramSize.getHeight() / paramSize.getWidth()));
    ((VideoTransPara)localObject1).width = j;
    ((VideoTransPara)localObject1).height = k;
    this.NkX.uVk = paramString;
    this.NkX.BXA = a.QC(paramSize.getWidth());
    this.NkX.BXB = a.QC(paramSize.getHeight());
    this.NkX.SoE = 1.0F;
    paramString = this.NkX;
    Object localObject2 = new duz();
    i.a(paramRect, (duz)localObject2);
    paramString.SoD = ((duz)localObject2);
    if (paramBoolean2)
    {
      this.NkX.targetWidth = a.QC(j);
      this.NkX.targetHeight = a.QC(k);
      a.a(paramVideoTransPara, this.NkX);
      localObject2 = (Iterable)this.Nlb.MQY;
      paramString = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
    }
    label222:
    int i;
    label322:
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label324;
      }
      Object localObject3 = ((Iterator)localObject2).next();
      if (((ad)localObject3).type == 2) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label322;
        }
        paramString.add(localObject3);
        break label222;
        this.NkX.targetWidth = a.QC(((VideoTransPara)localObject1).width);
        this.NkX.targetHeight = a.QC(((VideoTransPara)localObject1).width * paramRect.height() / paramRect.width());
        break;
      }
    }
    label324:
    if (((List)paramString).size() == 1)
    {
      paramString = ((Iterable)this.Nlb.MQY).iterator();
      if (paramString.hasNext())
      {
        localObject2 = paramString.next();
        if (((ad)localObject2).type == 2)
        {
          i = 1;
          if (i == 0) {
            break label1106;
          }
          paramString = (ad)localObject2;
          paramString = MultiMediaVideoChecker.NmA.bfs(paramString.path);
          if ((paramString != null) && (paramString.width > 0) && (paramString.height > 0) && (paramString.cLa > 0.0F))
          {
            if ((paramString.fSM != 0) && (paramString.fSM != 180)) {
              break label1129;
            }
            i = paramString.width;
            label460:
            if (this.NkX.targetWidth > i)
            {
              Log.i(TAG, "outputConfig.targetWidth(" + this.NkX.targetWidth + ") > widthLimit(" + i + ')');
              if (paramBoolean2) {
                break label1138;
              }
              this.NkX.targetWidth = a.QC(i);
              this.NkX.targetHeight = a.QC((int)(1.0D * paramRect.height() / paramRect.width() * this.NkX.targetWidth));
              Log.i(TAG, "update targetSize:[" + this.NkX.targetWidth + ", " + this.NkX.targetHeight + ']');
            }
            if ((paramString.fSM != 0) && (paramString.fSM != 180)) {
              break label1182;
            }
            j = paramString.height;
            Log.i(TAG, "previewSize:" + paramSize + ", videoParam.width:" + ((VideoTransPara)localObject1).width + ", heightLimit:" + j);
            if ((paramBoolean2) && (i > j))
            {
              k = Math.min(j, ((VideoTransPara)localObject1).width);
              if (paramSize.getHeight() >= k) {
                break label1191;
              }
              this.NkX.SoE = (k / this.NkX.targetHeight);
              Log.i(TAG, "[widescreen] update outputScale:" + this.NkX.SoE);
            }
            if (!this.Nlb.ynt)
            {
              if (this.NkX.audioBitrate > paramString.audioBitrate) {
                this.NkX.audioBitrate = paramString.audioBitrate;
              }
              if ((this.NkX.audioSampleRate > paramString.audioSampleRate) && (paramString.audioSampleRate > 1000)) {
                this.NkX.audioSampleRate = paramString.audioSampleRate;
              }
            }
            this.NkX.fps = Math.min(this.NkX.fps, (int)paramString.cLa);
            this.NkX.audioChannelCount = Math.min(paramString.audioChannelCount, 2);
          }
        }
      }
    }
    for (;;)
    {
      label388:
      label569:
      this.NkX.audioChannelCount = Math.min(this.NkX.audioChannelCount, 2);
      label642:
      label771:
      if (paramBoolean1) {
        a.a(a.a(this.Nlb, paramVideoTransPara, this.NkX.targetWidth, this.NkX.targetHeight, this.NkY.Sor.isEmpty()), this.NkX);
      }
      Log.i(TAG, "getExportConfig: origin: " + this.NkX.BXA + ", " + this.NkX.BXB + ", " + this.NkX.SoD + " target: " + this.NkX.targetWidth + ", " + this.NkX.targetHeight + ", audio:" + this.NkX.audioChannelCount + ',' + this.NkX.audioBitrate + ',' + this.NkX.audioSampleRate + ", cropRect:" + paramRect);
      paramString = this.NkX;
      AppMethodBeat.o(226993);
      return paramString;
      i = 0;
      break label388;
      label1106:
      break;
      paramString = (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
      AppMethodBeat.o(226993);
      throw paramString;
      label1129:
      i = paramString.height;
      break label460;
      label1138:
      this.NkX.targetWidth = a.QC(i);
      this.NkX.targetHeight = a.QC((int)(1.0D * k / j * this.NkX.targetWidth));
      break label569;
      label1182:
      j = paramString.width;
      break label642;
      label1191:
      this.NkX.targetHeight = a.QC(k);
      paramSize = this.NkX;
      float f = k;
      paramSize.targetWidth = a.QC((int)(i * f / j));
      Log.i(TAG, "[widescreen] update targetSize:[" + this.NkX.targetWidth + ", " + this.NkX.targetHeight + ']');
      break label771;
      paramSize = (Iterable)this.Nlb.MQY;
      paramString = (Collection)new ArrayList();
      paramSize = paramSize.iterator();
      label1369:
      while (paramSize.hasNext())
      {
        localObject1 = paramSize.next();
        if (((ad)localObject1).type == 2) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1369;
          }
          paramString.add(localObject1);
          break;
        }
      }
      paramString = (Iterable)paramString;
      label1443:
      if (!((Collection)paramString).isEmpty())
      {
        paramString = paramString.iterator();
        label1398:
        if (paramString.hasNext())
        {
          paramSize = (ad)paramString.next();
          paramSize = MultiMediaVideoChecker.NmA.bfs(paramSize.path);
          if ((paramSize != null) && (paramSize.audioChannelCount == 1))
          {
            i = 1;
            if (i == 0) {
              break label1471;
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1479;
        }
        this.NkX.audioChannelCount = 1;
        break;
        i = 0;
        break label1443;
        label1471:
        break label1398;
      }
      label1479:
      this.NkX.audioChannelCount = 2;
    }
  }
  
  public final void a(Rect paramRect, float[] paramArrayOfFloat, List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(227001);
    p.k(paramRect, "drawingRect");
    p.k(paramArrayOfFloat, "validRect");
    p.k(paramList, "editItems");
    this.NkY.Soq = new duz();
    Object localObject = this.NkY.Soq;
    p.j(localObject, "editData.drawingRect");
    i.a(paramRect, (duz)localObject);
    this.NkY.Sot = new duz();
    paramRect = new Rect((int)paramArrayOfFloat[0], (int)paramArrayOfFloat[1], (int)paramArrayOfFloat[2], (int)paramArrayOfFloat[3]);
    paramArrayOfFloat = this.NkY.Sot;
    p.j(paramArrayOfFloat, "editData.validRect");
    i.a(paramRect, paramArrayOfFloat);
    paramRect = this.NkY.Sor;
    paramList = (Iterable)paramList;
    paramArrayOfFloat = (Collection)new ArrayList(j.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramList.next();
      jc localjc = new jc();
      localjc.dataType = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).Ibt.value;
      localjc.ROY = z.aN(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).fyG().toByteArray());
      paramArrayOfFloat.add(localjc);
    }
    paramRect.addAll((Collection)paramArrayOfFloat);
    AppMethodBeat.o(227001);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(227009);
    p.k(paramc, "template");
    this.Nla = i.b(paramc);
    AppMethodBeat.o(227009);
  }
  
  public final acu gsR()
  {
    AppMethodBeat.i(227014);
    acu localacu = i.a(this.Nlb, this.NkX);
    localacu.NkY = this.NkY;
    localacu.Soy.addAll((Collection)this.NkZ);
    localacu.Soz = this.Nla;
    if (this.Nla != null) {
      localacu.NmU = false;
    }
    AppMethodBeat.o(227014);
    return localacu;
  }
  
  public final void iB(List<com.tencent.mm.plugin.vlog.model.effect.b> paramList)
  {
    AppMethodBeat.i(227005);
    p.k(paramList, "magicList");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.vlog.model.effect.b localb = (com.tencent.mm.plugin.vlog.model.effect.b)paramList.next();
      LinkedList localLinkedList = this.NkZ;
      cuw localcuw = new cuw();
      localcuw.path = localb.NnS.GaM;
      localcuw.start = localb.start;
      localcuw.aYz = localb.aYz;
      localLinkedList.add(localcuw);
    }
    AppMethodBeat.o(227005);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/CompositionInfoConverter$Companion;", "", "()V", "MONO_CHANNEL_COUNT", "", "STEREO_CHANNEL_COUNT", "TAG", "", "abaResultToOutputConfig", "", "abaResult", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getABAResult", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "targetWidth", "targetHeight", "addStickers", "", "Lcom/tencent/mm/videocomposition/VideoComposition;", "resize2Even", "value", "videoParamsToOutputConfig", "plugin-vlog_release"})
  public static final class a
  {
    public static int QC(int paramInt)
    {
      int i = paramInt;
      if (paramInt % 2 != 0) {
        i = paramInt - 1;
      }
      return i;
    }
    
    public static a a(ac paramac, VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(241622);
      p.k(paramac, "composition");
      p.k(paramVideoTransPara, "videoParams");
      paramac = (Iterable)paramac.MQY;
      Object localObject = (Collection)new ArrayList();
      Iterator localIterator = paramac.iterator();
      label122:
      while (localIterator.hasNext())
      {
        paramac = (ad)localIterator.next();
        if (paramac.type == 2) {}
        for (paramac = new b(paramac.path, paramac.Nng.MQV, paramac.Nng.MQW);; paramac = null)
        {
          if (paramac == null) {
            break label122;
          }
          ((Collection)localObject).add(paramac);
          break;
        }
      }
      paramac = (List)localObject;
      localObject = c.NkB;
      paramac = c.a(paramac, paramVideoTransPara, paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(241622);
      return paramac;
    }
    
    public static void a(VideoTransPara paramVideoTransPara, acv paramacv)
    {
      AppMethodBeat.i(241626);
      p.k(paramVideoTransPara, "videoParams");
      p.k(paramacv, "outputConfig");
      paramacv.videoBitrate = paramVideoTransPara.videoBitrate;
      paramacv.fps = paramVideoTransPara.fps;
      paramacv.kXt = paramVideoTransPara.kXt;
      paramacv.audioBitrate = paramVideoTransPara.audioBitrate;
      paramacv.audioSampleRate = paramVideoTransPara.audioSampleRate;
      paramacv.audioChannelCount = paramVideoTransPara.audioChannelCount;
      paramacv.lJz = paramVideoTransPara.lJz;
      AppMethodBeat.o(241626);
    }
    
    public static void a(a parama, acv paramacv)
    {
      AppMethodBeat.i(241624);
      p.k(parama, "abaResult");
      p.k(paramacv, "outputConfig");
      if (parama.errCode == 0)
      {
        if ((parama.width > 0) && (parama.height > 0) && (parama.bitrate > 0))
        {
          paramacv.targetWidth = parama.width;
          paramacv.targetHeight = parama.height;
          paramacv.videoBitrate = parama.bitrate;
          Log.i(g.access$getTAG$cp(), "video abaResult, width:" + paramacv.targetWidth + ", height:" + paramacv.targetHeight + ", " + paramacv.videoBitrate);
        }
        parama = parama.Azu;
        if (parama != null)
        {
          parama = e.X(parama);
          if (parama != null)
          {
            paramacv.SoF.addAll((Collection)parama);
            AppMethodBeat.o(241624);
            return;
          }
        }
      }
      AppMethodBeat.o(241624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.g
 * JD-Core Version:    0.7.0.1
 */