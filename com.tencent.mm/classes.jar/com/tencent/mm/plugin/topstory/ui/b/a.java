package com.tencent.mm.plugin.topstory.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.fog;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/topstory/ui/multitask/TopStoryMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isSupportExitToMultiTask", "", "()Z", "isSupportSwipeToMultiTask", "isSupportSwipeToHome", "onCreate", "", "multiTaskType", "", "multiTaskId", "updateFloatBallData", "topStoryVideoContext", "Lcom/tencent/mm/protocal/protobuf/TopStoryVideoContext;", "currentVideoInfo", "Lcom/tencent/mm/protocal/protobuf/TopStoryVideoInfo;", "ui-topstory_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
{
  private final String TAG = "MicroMsg.TopStoryMultiTaskHelper";
  
  public a(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(271679);
    super.J(paramInt, paramString);
    AppMethodBeat.o(271679);
  }
  
  public final void a(foe paramfoe, foh paramfoh)
  {
    AppMethodBeat.i(271687);
    s.u(paramfoe, "topStoryVideoContext");
    s.u(paramfoh, "currentVideoInfo");
    Log.i(this.TAG, "updateFloatBallData contextId:%s videoId:%s", new Object[] { paramfoe.zIO, paramfoh.Ido });
    fog localfog = new fog();
    localfog.abOf = paramfoe.abOf;
    localfog.abOg = paramfoe.abOg;
    if (Util.isNullOrNil(paramfoe.mpa)) {
      localfog.abOh = paramfoe.abOh;
    }
    for (;;)
    {
      localfog.abOi = paramfoe.abOi;
      localfog.abOl = paramfoe.abOl;
      localfog.zIO = paramfoe.zIO;
      localfog.abOs = paramfoe.abOs;
      localfog.offset = paramfoe.offset;
      localfog.abOj = paramfoe.abOj;
      localfog.scene = paramfoe.scene;
      localfog.hAB = paramfoe.hAB;
      localfog.Wol = paramfoh.Wol;
      localfog.aaUM.add(paramfoh);
      try
      {
        paramfoe = this.LCE;
        if (paramfoe == null) {}
        for (paramfoe = null;; paramfoe = paramfoe.gkh())
        {
          if (paramfoe != null) {
            paramfoe.title = paramfoh.title;
          }
          paramfoe = this.LCE;
          if (paramfoe != null) {
            paramfoe.field_data = localfog.toByteArray();
          }
          gjW();
          AppMethodBeat.o(271687);
          return;
          localfog.abOh = paramfoe.mpa;
          break;
        }
        return;
      }
      catch (Exception paramfoe)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramfoe, "updateFloatBallData exception:%s", new Object[] { paramfoe });
        AppMethodBeat.o(271687);
      }
    }
  }
  
  public final boolean cBZ()
  {
    return true;
  }
  
  public final boolean cCc()
  {
    return true;
  }
  
  public final boolean eCI()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.b.a
 * JD-Core Version:    0.7.0.1
 */