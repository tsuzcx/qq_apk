package com.tencent.mm.plugin.topstory.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esx;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/topstory/ui/multitask/TopStoryMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isSupportExitToMultiTask", "", "()Z", "isSupportSwipeToMultiTask", "isSupportSwipeToHome", "onCreate", "", "multiTaskType", "", "multiTaskId", "updateFloatBallData", "topStoryVideoContext", "Lcom/tencent/mm/protocal/protobuf/TopStoryVideoContext;", "currentVideoInfo", "Lcom/tencent/mm/protocal/protobuf/TopStoryVideoInfo;", "ui-topstory_release"})
public final class a
  extends c
{
  private final String TAG = "MicroMsg.TopStoryMultiTaskHelper";
  
  public a(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(206116);
    super.I(paramInt, paramString);
    AppMethodBeat.o(206116);
  }
  
  public final void a(esv paramesv, esy paramesy)
  {
    AppMethodBeat.i(206119);
    p.k(paramesv, "topStoryVideoContext");
    p.k(paramesy, "currentVideoInfo");
    Log.i(this.TAG, "updateFloatBallData contextId:%s videoId:%s", new Object[] { paramesv.wmL, paramesy.Crh });
    esx localesx = new esx();
    localesx.UuD = paramesv.UuD;
    localesx.UuE = paramesv.UuE;
    if (Util.isNullOrNil(paramesv.jQi)) {}
    for (localesx.UuF = paramesv.UuF;; localesx.UuF = paramesv.jQi)
    {
      localesx.UuG = paramesv.UuG;
      localesx.UuJ = paramesv.UuJ;
      localesx.wmL = paramesv.wmL;
      localesx.UuQ = paramesv.UuQ;
      localesx.offset = paramesv.offset;
      localesx.UuH = paramesv.UuH;
      localesx.scene = paramesv.scene;
      localesx.fwe = paramesv.fwe;
      localesx.Pye = paramesy.Pye;
      localesx.TFg.add(paramesy);
      try
      {
        paramesv = this.FHd;
        if (paramesv != null)
        {
          paramesv = paramesv.fbc();
          if (paramesv != null) {
            paramesv.title = paramesy.title;
          }
        }
        paramesv = this.FHd;
        if (paramesv != null) {
          paramesv.field_data = localesx.toByteArray();
        }
        faR();
        AppMethodBeat.o(206119);
        return;
      }
      catch (Exception paramesv)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramesv, "updateFloatBallData exception:%s", new Object[] { paramesv });
        AppMethodBeat.o(206119);
      }
    }
  }
  
  public final boolean cbG()
  {
    return true;
  }
  
  public final boolean cbJ()
  {
    return true;
  }
  
  public final boolean dJN()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.b.a
 * JD-Core Version:    0.7.0.1
 */