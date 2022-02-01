package com.tencent.mm.plugin.vlog.ui.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/video/CompositionConverter;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editData", "Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getEditData", "()Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getOutputConfig", "()Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "addEditInfo", "", "drawingRect", "Landroid/graphics/Rect;", "validRect", "", "editItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "chooseExportConfig", "path", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewSize", "Landroid/util/Size;", "cropRect", "enableAdaptiveBitrate", "", "getCompositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "resize2Even", "", "value", "videoParamsToOutputConfig", "videoParams", "Companion", "plugin-vlog_release"})
public final class b
{
  public static final a NFs;
  final acv NkX;
  final act NkY;
  final ac Nlb;
  
  static
  {
    AppMethodBeat.i(226221);
    NFs = new a((byte)0);
    AppMethodBeat.o(226221);
  }
  
  public b(ac paramac)
  {
    AppMethodBeat.i(226220);
    this.Nlb = paramac;
    this.NkX = new acv();
    this.NkY = new act();
    AppMethodBeat.o(226220);
  }
  
  private static int QC(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 2 != 0) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public final void a(Rect paramRect, float[] paramArrayOfFloat, List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(226214);
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
    AppMethodBeat.o(226214);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/video/CompositionConverter$Companion;", "", "()V", "MONO_CHANNEL_COUNT", "", "STEREO_CHANNEL_COUNT", "TAG", "", "abaResultToOutputConfig", "", "abaResult", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getABAResult", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "targetWidth", "targetHeight", "addStickers", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.video.b
 * JD-Core Version:    0.7.0.1
 */