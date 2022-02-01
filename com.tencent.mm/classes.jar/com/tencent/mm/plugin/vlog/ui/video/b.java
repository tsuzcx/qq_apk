package com.tencent.mm.plugin.vlog.ui.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.h;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.enx;
import com.tencent.mm.protocal.protobuf.jy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/video/CompositionConverter;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editData", "Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getEditData", "()Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getOutputConfig", "()Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "addEditInfo", "", "drawingRect", "Landroid/graphics/Rect;", "validRect", "", "editItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "chooseExportConfig", "path", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewSize", "Landroid/util/Size;", "cropRect", "enableAdaptiveBitrate", "", "getCompositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "resize2Even", "", "value", "videoParamsToOutputConfig", "videoParams", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a UrB;
  final ac TYA;
  final afc TYB;
  final afa TYC;
  
  static
  {
    AppMethodBeat.i(281911);
    UrB = new b.a((byte)0);
    AppMethodBeat.o(281911);
  }
  
  public b(ac paramac)
  {
    AppMethodBeat.i(281886);
    this.TYA = paramac;
    this.TYB = new afc();
    this.TYC = new afa();
    AppMethodBeat.o(281886);
  }
  
  private static int TM(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 2 != 0) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public final void a(Rect paramRect, float[] paramArrayOfFloat, List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(281922);
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
    AppMethodBeat.o(281922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.video.b
 * JD-Core Version:    0.7.0.1
 */