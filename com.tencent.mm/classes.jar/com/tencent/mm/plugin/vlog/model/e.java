package com.tencent.mm.plugin.vlog.model;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.bxn;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/CompositionInfoConverter;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editData", "Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getEditData", "()Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "magicProtoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MagicInfoProto;", "getMagicProtoList", "()Ljava/util/LinkedList;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getOutputConfig", "()Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "templateInfo", "Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "getTemplateInfo", "()Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "setTemplateInfo", "(Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;)V", "addEditInfo", "", "drawingRect", "Landroid/graphics/Rect;", "validRect", "", "editItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "addMagicInfo", "magicList", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "addTemplateInfo", "template", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "chooseExportConfig", "path", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewSize", "Landroid/util/Size;", "cropRect", "enableAdaptiveBitrate", "", "getCompositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "videoParamsToOutputConfig", "videoParams", "Companion", "plugin-vlog_release"})
public final class e
{
  public static final a BFe;
  private static final String TAG = "MicroMsg.CompositionInfoConverter";
  public final aao BEZ;
  public final aam BFa;
  public final LinkedList<bxn> BFb;
  public dvx BFc;
  public final v BFd;
  
  static
  {
    AppMethodBeat.i(195702);
    BFe = new a((byte)0);
    TAG = "MicroMsg.CompositionInfoConverter";
    AppMethodBeat.o(195702);
  }
  
  public e(v paramv)
  {
    AppMethodBeat.i(195701);
    this.BFd = paramv;
    this.BEZ = new aao();
    this.BFa = new aam();
    this.BFb = new LinkedList();
    AppMethodBeat.o(195701);
  }
  
  public final void a(Rect paramRect, float[] paramArrayOfFloat, List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(195699);
    p.h(paramRect, "drawingRect");
    p.h(paramArrayOfFloat, "validRect");
    p.h(paramList, "editItems");
    this.BFa.FZq = new cse();
    Object localObject = this.BFa.FZq;
    p.g(localObject, "editData.drawingRect");
    f.a(paramRect, (cse)localObject);
    this.BFa.FZt = new cse();
    paramRect = new Rect((int)paramArrayOfFloat[0], (int)paramArrayOfFloat[1], (int)paramArrayOfFloat[2], (int)paramArrayOfFloat[3]);
    paramArrayOfFloat = this.BFa.FZt;
    p.g(paramArrayOfFloat, "editData.validRect");
    f.a(paramRect, paramArrayOfFloat);
    paramRect = this.BFa.FZr;
    paramList = (Iterable)paramList;
    paramArrayOfFloat = (Collection)new ArrayList(j.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramList.next();
      ja localja = new ja();
      localja.dataType = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).xNC.value;
      localja.FCa = z.al(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).dHT().toByteArray());
      paramArrayOfFloat.add(localja);
    }
    paramRect.addAll((Collection)paramArrayOfFloat);
    AppMethodBeat.o(195699);
  }
  
  public final void gB(List<com.tencent.mm.plugin.vlog.model.effect.b> paramList)
  {
    AppMethodBeat.i(195700);
    p.h(paramList, "magicList");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.vlog.model.effect.b localb = (com.tencent.mm.plugin.vlog.model.effect.b)paramList.next();
      LinkedList localLinkedList = this.BFb;
      bxn localbxn = new bxn();
      localbxn.path = localb.BHg.xPf;
      localbxn.start = localb.start;
      localbxn.bpc = localb.bpc;
      localLinkedList.add(localbxn);
    }
    AppMethodBeat.o(195700);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/CompositionInfoConverter$Companion;", "", "()V", "MONO_CHANNEL_COUNT", "", "STEREO_CHANNEL_COUNT", "TAG", "", "abaResultToOutputConfig", "", "abaResult", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getABAResult", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "targetWidth", "targetHeight", "plugin-vlog_release"})
  public static final class a
  {
    public static a a(v paramv, VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(195696);
      p.h(paramv, "composition");
      p.h(paramVideoTransPara, "videoParams");
      paramv = (Iterable)paramv.BGl;
      Object localObject = (Collection)new ArrayList();
      Iterator localIterator = paramv.iterator();
      label122:
      while (localIterator.hasNext())
      {
        paramv = (w)localIterator.next();
        if (paramv.type == 2) {}
        for (paramv = new b(paramv.path, paramv.BGw.HCU, paramv.BGw.HCV);; paramv = null)
        {
          if (paramv == null) {
            break label122;
          }
          ((Collection)localObject).add(paramv);
          break;
        }
      }
      paramv = (List)localObject;
      localObject = c.BES;
      paramv = c.a(paramv, paramVideoTransPara, paramInt1, paramInt2);
      AppMethodBeat.o(195696);
      return paramv;
    }
    
    public static void a(a parama, aao paramaao)
    {
      AppMethodBeat.i(195697);
      p.h(parama, "abaResult");
      p.h(paramaao, "outputConfig");
      if (parama.errCode == 0)
      {
        if ((parama.width > 0) && (parama.height > 0) && (parama.bitrate > 0))
        {
          paramaao.targetWidth = parama.width;
          paramaao.targetHeight = parama.height;
          paramaao.videoBitrate = parama.bitrate;
          ad.i(e.access$getTAG$cp(), "video abaResult, width:" + paramaao.targetWidth + ", height:" + paramaao.targetHeight + ", " + paramaao.videoBitrate);
        }
        parama = parama.sIH;
        if (parama != null)
        {
          parama = d.a.e.P(parama);
          if (parama != null)
          {
            paramaao.FZC.addAll((Collection)parama);
            AppMethodBeat.o(195697);
            return;
          }
        }
      }
      AppMethodBeat.o(195697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.e
 * JD-Core Version:    0.7.0.1
 */