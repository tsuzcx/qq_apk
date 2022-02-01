package com.tencent.mm.plugin.vlog.model;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/CompositionInfoConverter;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "TAG", "", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editData", "Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getEditData", "()Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getOutputConfig", "()Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "abaResultToOutputConfig", "", "abaResult", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition$ABAResult;", "addEditInfo", "drawingRect", "", "editItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "chooseExportConfig", "path", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewSize", "Landroid/util/Size;", "cropRect", "Landroid/graphics/Rect;", "enableAdaptiveBitrate", "", "getCompositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "videoParamsToOutputConfig", "videoParams", "plugin-vlog_release"})
public final class b
{
  public final yp AmP;
  public final yn AmQ;
  public final r AmR;
  public final String TAG;
  
  public b(r paramr)
  {
    AppMethodBeat.i(207502);
    this.AmR = paramr;
    this.TAG = "MicroMsg.CompositionInfoConverter";
    this.AmP = new yp();
    this.AmQ = new yn();
    AppMethodBeat.o(207502);
  }
  
  public final void a(r.a parama, yp paramyp)
  {
    AppMethodBeat.i(207501);
    k.h(parama, "abaResult");
    k.h(paramyp, "outputConfig");
    if (parama.errCode == 0)
    {
      if ((parama.width > 0) && (parama.height > 0) && (parama.bitrate > 0))
      {
        paramyp.gNU = parama.width;
        paramyp.gNV = parama.height;
        paramyp.videoBitrate = parama.bitrate;
        ac.i(this.TAG, "video abaResult, width:" + paramyp.gNU + ", height:" + paramyp.gNV + ", " + paramyp.videoBitrate);
      }
      parama = parama.rMF;
      if (parama != null)
      {
        parama = d.a.e.P(parama);
        if (parama != null)
        {
          paramyp.Esq.addAll((Collection)parama);
          AppMethodBeat.o(207501);
          return;
        }
      }
    }
    AppMethodBeat.o(207501);
  }
  
  public final void a(float[] paramArrayOfFloat, List<? extends com.tencent.mm.media.editor.a.a> paramList)
  {
    AppMethodBeat.i(207500);
    k.h(paramArrayOfFloat, "drawingRect");
    k.h(paramList, "editItems");
    this.AmQ.Esh = new cnb();
    paramArrayOfFloat = new Rect((int)paramArrayOfFloat[0], (int)paramArrayOfFloat[1], (int)paramArrayOfFloat[2], (int)paramArrayOfFloat[3]);
    Object localObject = this.AmQ.Esh;
    k.g(localObject, "editData.drawingRect");
    c.a(paramArrayOfFloat, (cnb)localObject);
    paramArrayOfFloat = this.AmQ.Esi;
    localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.media.editor.a.a locala = (com.tencent.mm.media.editor.a.a)((Iterator)localObject).next();
      it localit = new it();
      localit.dataType = locala.gPj.value;
      localit.DWE = z.al(locala.aqw().toByteArray());
      paramList.add(localit);
    }
    paramArrayOfFloat.addAll((Collection)paramList);
    AppMethodBeat.o(207500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.b
 * JD-Core Version:    0.7.0.1
 */