package com.tencent.mm.plugin.vlog.model;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.dxv;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/CompositionInfoConverter;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "TAG", "", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editData", "Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getEditData", "()Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getOutputConfig", "()Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "abaResultToOutputConfig", "", "abaResult", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition$ABAResult;", "addEditInfo", "drawingRect", "", "editItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "chooseExportConfig", "path", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewSize", "Landroid/util/Size;", "cropRect", "Landroid/graphics/Rect;", "enableAdaptiveBitrate", "", "getCompositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "videoParamsToOutputConfig", "videoParams", "plugin-vlog_release"})
public final class l
{
  public final dxx Lqd;
  public final dxv Lqe;
  public final v Lqf;
  public final String TAG;
  
  public l(v paramv)
  {
    AppMethodBeat.i(200815);
    this.Lqf = paramv;
    this.TAG = "MicroMsg.CompositionInfoConverter";
    this.Lqd = new dxx();
    this.Lqe = new dxv();
    AppMethodBeat.o(200815);
  }
  
  public final void a(v.a parama, dxx paramdxx)
  {
    AppMethodBeat.i(200814);
    k.h(parama, "abaResult");
    k.h(paramdxx, "outputConfig");
    if (parama.errCode == 0)
    {
      if ((parama.width > 0) && (parama.height > 0) && (parama.bitrate > 0))
      {
        paramdxx.gnh = parama.width;
        paramdxx.gni = parama.height;
        paramdxx.videoBitrate = parama.bitrate;
        ad.i(this.TAG, "video abaResult, width:" + paramdxx.gnh + ", height:" + paramdxx.gni + ", " + paramdxx.videoBitrate);
      }
      parama = parama.qQH;
      if (parama != null)
      {
        parama = d.a.e.P(parama);
        if (parama != null)
        {
          paramdxx.LwY.addAll((Collection)parama);
          AppMethodBeat.o(200814);
          return;
        }
      }
    }
    AppMethodBeat.o(200814);
  }
  
  public final void a(float[] paramArrayOfFloat, List<? extends com.tencent.mm.media.editor.a.a> paramList)
  {
    AppMethodBeat.i(200813);
    k.h(paramArrayOfFloat, "drawingRect");
    k.h(paramList, "editItems");
    this.Lqe.LwQ = new ebn();
    paramArrayOfFloat = new Rect((int)paramArrayOfFloat[0], (int)paramArrayOfFloat[1], (int)paramArrayOfFloat[2], (int)paramArrayOfFloat[3]);
    Object localObject = this.Lqe.LwQ;
    k.g(localObject, "editData.drawingRect");
    m.a(paramArrayOfFloat, (ebn)localObject);
    paramArrayOfFloat = this.Lqe.Dde;
    localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.media.editor.a.a locala = (com.tencent.mm.media.editor.a.a)((Iterator)localObject).next();
      in localin = new in();
      localin.dataType = locala.goB.value;
      localin.CEe = z.am(locala.ajx().toByteArray());
      paramList.add(localin);
    }
    paramArrayOfFloat.addAll((Collection)paramList);
    AppMethodBeat.o(200813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.l
 * JD-Core Version:    0.7.0.1
 */