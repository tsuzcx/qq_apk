package com.tencent.mm.plugin.vlog.model;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.vlog.model.local.a.c;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.jn;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/CompositionInfoConverter;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editData", "Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getEditData", "()Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "magicProtoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MagicInfoProto;", "getMagicProtoList", "()Ljava/util/LinkedList;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getOutputConfig", "()Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "templateInfo", "Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "getTemplateInfo", "()Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "setTemplateInfo", "(Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;)V", "addEditInfo", "", "drawingRect", "Landroid/graphics/Rect;", "validRect", "", "editItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "addMagicInfo", "magicList", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "addTemplateInfo", "template", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "chooseExportConfig", "path", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewSize", "Landroid/util/Size;", "cropRect", "enableAdaptiveBitrate", "", "enableFullscreen", "getCompositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "resize2Even", "", "value", "videoParamsToOutputConfig", "videoParams", "Companion", "plugin-vlog_release"})
public final class g
{
  public static final a GxB;
  private static final String TAG = "MicroMsg.CompositionInfoConverter";
  private final ac GxA;
  private final aco Gxw;
  private final acm Gxx;
  private final LinkedList<clz> Gxy;
  private eqy Gxz;
  
  static
  {
    AppMethodBeat.i(190510);
    GxB = new a((byte)0);
    TAG = "MicroMsg.CompositionInfoConverter";
    AppMethodBeat.o(190510);
  }
  
  public g(ac paramac)
  {
    AppMethodBeat.i(190509);
    this.GxA = paramac;
    this.Gxw = new aco();
    this.Gxx = new acm();
    this.Gxy = new LinkedList();
    AppMethodBeat.o(190509);
  }
  
  private static int Lt(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 2 != 0) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public final aco a(String paramString, VideoTransPara paramVideoTransPara, Size paramSize, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(190503);
    p.h(paramString, "path");
    p.h(paramVideoTransPara, "videoTransPara");
    p.h(paramSize, "previewSize");
    p.h(paramRect, "cropRect");
    Object localObject = new VideoTransPara(paramVideoTransPara);
    int i = ((VideoTransPara)localObject).width;
    int j = (int)(i * (paramSize.getHeight() / paramSize.getWidth()));
    ((VideoTransPara)localObject).width = i;
    ((VideoTransPara)localObject).height = j;
    this.Gxw.rpE = paramString;
    this.Gxw.xlg = Lt(paramSize.getWidth());
    this.Gxw.xlh = Lt(paramSize.getHeight());
    paramString = this.Gxw;
    paramSize = new dlh();
    i.a(paramRect, paramSize);
    paramString.Lnm = paramSize;
    if (paramBoolean2)
    {
      this.Gxw.targetWidth = Lt(i);
      this.Gxw.targetHeight = Lt(j);
      paramString = this.Gxw;
      paramString.videoBitrate = paramVideoTransPara.videoBitrate;
      paramString.fps = paramVideoTransPara.fps;
      paramString.iiH = paramVideoTransPara.iiH;
      paramString.audioBitrate = paramVideoTransPara.audioBitrate;
      paramString.audioSampleRate = paramVideoTransPara.audioSampleRate;
      paramString.audioChannelCount = paramVideoTransPara.audioChannelCount;
      paramString.iTg = paramVideoTransPara.iTg;
      paramSize = (Iterable)this.GxA.Gzn;
      paramString = (Collection)new ArrayList();
      paramSize = paramSize.iterator();
    }
    label261:
    label359:
    for (;;)
    {
      if (!paramSize.hasNext()) {
        break label361;
      }
      localObject = paramSize.next();
      if (((ad)localObject).type == 2) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label359;
        }
        paramString.add(localObject);
        break label261;
        this.Gxw.targetWidth = Lt(((VideoTransPara)localObject).width);
        this.Gxw.targetHeight = Lt(((VideoTransPara)localObject).width * paramRect.height() / paramRect.width());
        break;
      }
    }
    label361:
    if (((List)paramString).size() == 1)
    {
      paramString = ((Iterable)this.GxA.Gzn).iterator();
      if (paramString.hasNext())
      {
        paramSize = paramString.next();
        if (((ad)paramSize).type == 2)
        {
          i = 1;
          if (i == 0) {
            break label900;
          }
          paramString = (ad)paramSize;
          paramString = MultiMediaVideoChecker.GyY.aTV(paramString.path);
          if ((paramString != null) && (paramString.width > 0) && (paramString.height > 0) && (paramString.cKu > 0.0F))
          {
            if ((!paramBoolean2) && (this.Gxw.targetWidth > paramString.width))
            {
              this.Gxw.targetWidth = Lt(paramString.width);
              this.Gxw.targetHeight = Lt((int)(1.0D * paramRect.height() / paramRect.width() * this.Gxw.targetWidth));
            }
            if (!this.GxA.BNS)
            {
              if (this.Gxw.audioBitrate > paramString.audioBitrate) {
                this.Gxw.audioBitrate = paramString.audioBitrate;
              }
              if ((this.Gxw.audioSampleRate > paramString.audioSampleRate) && (paramString.audioSampleRate > 1000)) {
                this.Gxw.audioSampleRate = paramString.audioSampleRate;
              }
            }
            this.Gxw.fps = Math.min(this.Gxw.fps, (int)paramString.cKu);
            this.Gxw.audioChannelCount = Math.min(paramString.audioChannelCount, 2);
          }
        }
      }
    }
    for (;;)
    {
      label423:
      this.Gxw.audioChannelCount = Math.min(this.Gxw.audioChannelCount, 2);
      if (paramBoolean1) {
        a.a(a.a(this.GxA, paramVideoTransPara, this.Gxw.targetWidth, this.Gxw.targetHeight, this.Gxx.Lna.isEmpty()), this.Gxw);
      }
      this.Gxw.Lnn = (this.Gxw.targetWidth * 1.0F / this.Gxw.xlg);
      Log.i(TAG, "getExportConfig: origin: " + this.Gxw.xlg + ", " + this.Gxw.xlh + ", " + this.Gxw.Lnm + " target: " + this.Gxw.targetWidth + ", " + this.Gxw.targetHeight + ", audio:" + this.Gxw.audioChannelCount + ',' + this.Gxw.audioBitrate + ',' + this.Gxw.audioSampleRate + ", cropRect:" + paramRect);
      paramString = this.Gxw;
      AppMethodBeat.o(190503);
      return paramString;
      i = 0;
      break label423;
      label900:
      break;
      paramString = (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
      AppMethodBeat.o(190503);
      throw paramString;
      paramSize = (Iterable)this.GxA.Gzn;
      paramString = (Collection)new ArrayList();
      paramSize = paramSize.iterator();
      label1008:
      while (paramSize.hasNext())
      {
        localObject = paramSize.next();
        if (((ad)localObject).type == 2) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1008;
          }
          paramString.add(localObject);
          break;
        }
      }
      paramString = (Iterable)paramString;
      if (!((Collection)paramString).isEmpty())
      {
        paramString = paramString.iterator();
        label1037:
        if (paramString.hasNext())
        {
          paramSize = (ad)paramString.next();
          paramSize = MultiMediaVideoChecker.GyY.aTV(paramSize.path);
          if ((paramSize != null) && (paramSize.audioChannelCount == 1))
          {
            i = 1;
            label1082:
            if (i == 0) {
              break label1110;
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1118;
        }
        this.Gxw.audioChannelCount = 1;
        break;
        i = 0;
        break label1082;
        label1110:
        break label1037;
      }
      label1118:
      this.Gxw.audioChannelCount = 2;
    }
  }
  
  public final void a(Rect paramRect, float[] paramArrayOfFloat, List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(190505);
    p.h(paramRect, "drawingRect");
    p.h(paramArrayOfFloat, "validRect");
    p.h(paramList, "editItems");
    this.Gxx.LmZ = new dlh();
    Object localObject = this.Gxx.LmZ;
    p.g(localObject, "editData.drawingRect");
    i.a(paramRect, (dlh)localObject);
    this.Gxx.Lnc = new dlh();
    paramRect = new Rect((int)paramArrayOfFloat[0], (int)paramArrayOfFloat[1], (int)paramArrayOfFloat[2], (int)paramArrayOfFloat[3]);
    paramArrayOfFloat = this.Gxx.Lnc;
    p.g(paramArrayOfFloat, "editData.validRect");
    i.a(paramRect, paramArrayOfFloat);
    paramRect = this.Gxx.Lna;
    paramList = (Iterable)paramList;
    paramArrayOfFloat = (Collection)new ArrayList(j.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramList.next();
      jn localjn = new jn();
      localjn.dataType = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).Cex.value;
      localjn.KOd = z.aC(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).eMk().toByteArray());
      paramArrayOfFloat.add(localjn);
    }
    paramRect.addAll((Collection)paramArrayOfFloat);
    AppMethodBeat.o(190505);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(190507);
    p.h(paramc, "template");
    this.Gxz = i.b(paramc);
    AppMethodBeat.o(190507);
  }
  
  public final acn fAQ()
  {
    AppMethodBeat.i(190508);
    acn localacn = i.a(this.GxA, this.Gxw);
    localacn.Gxx = this.Gxx;
    localacn.Lnh.addAll((Collection)this.Gxy);
    localacn.Lni = this.Gxz;
    if (this.Gxz != null) {
      localacn.Gzo = false;
    }
    AppMethodBeat.o(190508);
    return localacn;
  }
  
  public final void hM(List<com.tencent.mm.plugin.vlog.model.effect.b> paramList)
  {
    AppMethodBeat.i(190506);
    p.h(paramList, "magicList");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.vlog.model.effect.b localb = (com.tencent.mm.plugin.vlog.model.effect.b)paramList.next();
      LinkedList localLinkedList = this.Gxy;
      clz localclz = new clz();
      localclz.path = localb.GAm.Cga;
      localclz.start = localb.start;
      localclz.boX = localb.boX;
      localLinkedList.add(localclz);
    }
    AppMethodBeat.o(190506);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/CompositionInfoConverter$Companion;", "", "()V", "MONO_CHANNEL_COUNT", "", "STEREO_CHANNEL_COUNT", "TAG", "", "abaResultToOutputConfig", "", "abaResult", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getABAResult", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "targetWidth", "targetHeight", "addStickers", "", "plugin-vlog_release"})
  public static final class a
  {
    public static a a(ac paramac, VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(190501);
      p.h(paramac, "composition");
      p.h(paramVideoTransPara, "videoParams");
      paramac = (Iterable)paramac.Gzn;
      Object localObject = (Collection)new ArrayList();
      Iterator localIterator = paramac.iterator();
      label122:
      while (localIterator.hasNext())
      {
        paramac = (ad)localIterator.next();
        if (paramac.type == 2) {}
        for (paramac = new b(paramac.path, paramac.GzA.GGz, paramac.GzA.GGA);; paramac = null)
        {
          if (paramac == null) {
            break label122;
          }
          ((Collection)localObject).add(paramac);
          break;
        }
      }
      paramac = (List)localObject;
      localObject = c.GwZ;
      paramac = c.a(paramac, paramVideoTransPara, paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(190501);
      return paramac;
    }
    
    public static void a(a parama, aco paramaco)
    {
      AppMethodBeat.i(190502);
      p.h(parama, "abaResult");
      p.h(paramaco, "outputConfig");
      if (parama.errCode == 0)
      {
        if ((parama.width > 0) && (parama.height > 0) && (parama.bitrate > 0))
        {
          paramaco.targetWidth = parama.width;
          paramaco.targetHeight = parama.height;
          paramaco.videoBitrate = parama.bitrate;
          Log.i(g.access$getTAG$cp(), "video abaResult, width:" + paramaco.targetWidth + ", height:" + paramaco.targetHeight + ", " + paramaco.videoBitrate);
        }
        parama = parama.vRR;
        if (parama != null)
        {
          parama = e.Y(parama);
          if (parama != null)
          {
            paramaco.Lno.addAll((Collection)parama);
            AppMethodBeat.o(190502);
            return;
          }
        }
      }
      AppMethodBeat.o(190502);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.g
 * JD-Core Version:    0.7.0.1
 */