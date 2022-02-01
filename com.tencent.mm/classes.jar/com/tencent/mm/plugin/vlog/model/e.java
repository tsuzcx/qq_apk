package com.tencent.mm.plugin.vlog.model;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/CompositionInfoConverter;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editData", "Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getEditData", "()Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "magicProtoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MagicInfoProto;", "getMagicProtoList", "()Ljava/util/LinkedList;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getOutputConfig", "()Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "templateInfo", "Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "getTemplateInfo", "()Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "setTemplateInfo", "(Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;)V", "addEditInfo", "", "drawingRect", "Landroid/graphics/Rect;", "validRect", "", "editItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "addMagicInfo", "magicList", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "addTemplateInfo", "template", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "chooseExportConfig", "path", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewSize", "Landroid/util/Size;", "cropRect", "enableAdaptiveBitrate", "", "getCompositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "videoParamsToOutputConfig", "videoParams", "Companion", "plugin-vlog_release"})
public final class e
{
  public static final a BWC;
  private static final String TAG = "MicroMsg.CompositionInfoConverter";
  public dws BWA;
  public final v BWB;
  public final aar BWx;
  public final aap BWy;
  public final LinkedList<byh> BWz;
  
  static
  {
    AppMethodBeat.i(191159);
    BWC = new a((byte)0);
    TAG = "MicroMsg.CompositionInfoConverter";
    AppMethodBeat.o(191159);
  }
  
  public e(v paramv)
  {
    AppMethodBeat.i(191158);
    this.BWB = paramv;
    this.BWx = new aar();
    this.BWy = new aap();
    this.BWz = new LinkedList();
    AppMethodBeat.o(191158);
  }
  
  public final void a(Rect paramRect, float[] paramArrayOfFloat, List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(191156);
    p.h(paramRect, "drawingRect");
    p.h(paramArrayOfFloat, "validRect");
    p.h(paramList, "editItems");
    this.BWy.GrQ = new csy();
    Object localObject = this.BWy.GrQ;
    p.g(localObject, "editData.drawingRect");
    f.a(paramRect, (csy)localObject);
    this.BWy.GrT = new csy();
    paramRect = new Rect((int)paramArrayOfFloat[0], (int)paramArrayOfFloat[1], (int)paramArrayOfFloat[2], (int)paramArrayOfFloat[3]);
    paramArrayOfFloat = this.BWy.GrT;
    p.g(paramArrayOfFloat, "editData.validRect");
    f.a(paramRect, paramArrayOfFloat);
    paramRect = this.BWy.GrR;
    paramList = (Iterable)paramList;
    paramArrayOfFloat = (Collection)new ArrayList(j.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramList.next();
      ja localja = new ja();
      localja.dataType = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).ydv.value;
      localja.FUv = z.al(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).dLk().toByteArray());
      paramArrayOfFloat.add(localja);
    }
    paramRect.addAll((Collection)paramArrayOfFloat);
    AppMethodBeat.o(191156);
  }
  
  public final void gK(List<com.tencent.mm.plugin.vlog.model.effect.b> paramList)
  {
    AppMethodBeat.i(191157);
    p.h(paramList, "magicList");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.vlog.model.effect.b localb = (com.tencent.mm.plugin.vlog.model.effect.b)paramList.next();
      LinkedList localLinkedList = this.BWz;
      byh localbyh = new byh();
      localbyh.path = localb.BYF.yeY;
      localbyh.start = localb.start;
      localbyh.bpc = localb.bpc;
      localLinkedList.add(localbyh);
    }
    AppMethodBeat.o(191157);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/CompositionInfoConverter$Companion;", "", "()V", "MONO_CHANNEL_COUNT", "", "STEREO_CHANNEL_COUNT", "TAG", "", "abaResultToOutputConfig", "", "abaResult", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getABAResult", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "targetWidth", "targetHeight", "addStickers", "", "plugin-vlog_release"})
  public static final class a
  {
    public static a a(v paramv, VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(191153);
      p.h(paramv, "composition");
      p.h(paramVideoTransPara, "videoParams");
      paramv = (Iterable)paramv.BXJ;
      Object localObject = (Collection)new ArrayList();
      Iterator localIterator = paramv.iterator();
      label122:
      while (localIterator.hasNext())
      {
        paramv = (w)localIterator.next();
        if (paramv.type == 2) {}
        for (paramv = new b(paramv.path, paramv.BXV.HWH, paramv.BXV.HWI);; paramv = null)
        {
          if (paramv == null) {
            break label122;
          }
          ((Collection)localObject).add(paramv);
          break;
        }
      }
      paramv = (List)localObject;
      localObject = c.BWq;
      paramv = c.a(paramv, paramVideoTransPara, paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(191153);
      return paramv;
    }
    
    public static void a(a parama, aar paramaar)
    {
      AppMethodBeat.i(191154);
      p.h(parama, "abaResult");
      p.h(paramaar, "outputConfig");
      if (parama.errCode == 0)
      {
        if ((parama.width > 0) && (parama.height > 0) && (parama.bitrate > 0))
        {
          paramaar.targetWidth = parama.width;
          paramaar.targetHeight = parama.height;
          paramaar.videoBitrate = parama.bitrate;
          ae.i(e.access$getTAG$cp(), "video abaResult, width:" + paramaar.targetWidth + ", height:" + paramaar.targetHeight + ", " + paramaar.videoBitrate);
        }
        parama = parama.sTT;
        if (parama != null)
        {
          parama = d.a.e.Q(parama);
          if (parama != null)
          {
            paramaar.Gsc.addAll((Collection)parama);
            AppMethodBeat.o(191154);
            return;
          }
        }
      }
      AppMethodBeat.o(191154);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.e
 * JD-Core Version:    0.7.0.1
 */