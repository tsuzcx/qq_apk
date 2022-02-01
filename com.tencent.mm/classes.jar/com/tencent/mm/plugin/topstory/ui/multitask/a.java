package com.tencent.mm.plugin.topstory.ui.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/topstory/ui/multitask/TopStoryMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isSupportExitToMultiTask", "", "()Z", "isSupportSwipeToMultiTask", "isSupportSwipeToHome", "onCreate", "", "multiTaskType", "", "multiTaskId", "updateFloatBallData", "topStoryVideoContext", "Lcom/tencent/mm/protocal/protobuf/TopStoryVideoContext;", "currentVideoInfo", "Lcom/tencent/mm/protocal/protobuf/TopStoryVideoInfo;", "ui-topstory_release"})
public final class a
  extends c
{
  private final String TAG = "MicroMsg.TopStoryMultiTaskHelper";
  
  public a(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(236421);
    super.G(paramInt, paramString);
    AppMethodBeat.o(236421);
  }
  
  public final void a(eit parameit, eiw parameiw)
  {
    AppMethodBeat.i(236422);
    p.h(parameit, "topStoryVideoContext");
    p.h(parameiw, "currentVideoInfo");
    Log.i(this.TAG, "updateFloatBallData contextId:%s videoId:%s", new Object[] { parameit.sGQ, parameiw.psI });
    eiv localeiv = new eiv();
    localeiv.NhX = parameit.NhX;
    localeiv.NhY = parameit.NhY;
    if (Util.isNullOrNil(parameit.hes)) {}
    for (localeiv.NhZ = parameit.NhZ;; localeiv.NhZ = parameit.hes)
    {
      localeiv.Nia = parameit.Nia;
      localeiv.Nid = parameit.Nid;
      localeiv.sGQ = parameit.sGQ;
      localeiv.Nik = parameit.Nik;
      localeiv.offset = parameit.offset;
      localeiv.Nib = parameit.Nib;
      localeiv.scene = parameit.scene;
      localeiv.dDv = parameit.dDv;
      localeiv.IDO = parameiw.IDO;
      localeiv.Mub.add(parameiw);
      try
      {
        parameit = this.Abp;
        if (parameit != null)
        {
          parameit = parameit.erh();
          if (parameit != null) {
            parameit.title = parameiw.title;
          }
        }
        parameit = this.Abp;
        if (parameit != null) {
          parameit.field_data = localeiv.toByteArray();
        }
        eqX();
        AppMethodBeat.o(236422);
        return;
      }
      catch (Exception parameit)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)parameit, "updateFloatBallData exception:%s", new Object[] { parameit });
        AppMethodBeat.o(236422);
      }
    }
  }
  
  public final boolean bPp()
  {
    return true;
  }
  
  public final boolean bPs()
  {
    return true;
  }
  
  public final boolean dki()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.multitask.a
 * JD-Core Version:    0.7.0.1
 */