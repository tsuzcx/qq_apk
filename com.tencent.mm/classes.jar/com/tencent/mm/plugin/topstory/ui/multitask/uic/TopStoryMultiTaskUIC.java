package com.tencent.mm.plugin.topstory.ui.multitask.uic;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/topstory/ui/multitask/uic/TopStoryMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onMultiTaskItemClick", "", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "", "ui-topstory_release"})
public final class TopStoryMultiTaskUIC
  extends MultiTaskUIComponent
{
  private final String TAG;
  
  public TopStoryMultiTaskUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(236427);
    this.TAG = "MicroMsg.TopStory.TopStoryMultiTaskUIC";
    AppMethodBeat.o(236427);
  }
  
  public TopStoryMultiTaskUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(236426);
    this.TAG = "MicroMsg.TopStory.TopStoryMultiTaskUIC";
    AppMethodBeat.o(236426);
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, Object paramObject)
  {
    AppMethodBeat.i(236425);
    p.h(paramMultiTaskInfo, "info");
    p.h(paramcrq, "animateData");
    paramMultiTaskInfo = paramMultiTaskInfo.field_data;
    paramView = new eiv();
    try
    {
      paramView.parseFrom(paramMultiTaskInfo);
      if (paramView.Mub.size() > 0)
      {
        paramMultiTaskInfo = new eit();
        paramMultiTaskInfo.scene = paramView.scene;
        paramMultiTaskInfo.Nid = paramView.Nid;
        paramMultiTaskInfo.Nic = ((eiw)paramView.Mub.get(0));
        paramMultiTaskInfo.NhX = paramMultiTaskInfo.Nic.psI;
        paramMultiTaskInfo.NhZ = paramView.NhZ;
        paramMultiTaskInfo.NhY = paramView.NhY;
        paramMultiTaskInfo.Nia = paramView.Nia;
        paramMultiTaskInfo.Nib = paramView.Nib;
        paramMultiTaskInfo.sGQ = paramView.sGQ;
        paramMultiTaskInfo.Nik = paramView.Nik;
        paramMultiTaskInfo.offset = paramView.offset;
        paramMultiTaskInfo.dDv = paramView.dDv;
        paramMultiTaskInfo.IDO = paramView.IDO;
        Log.i(this.TAG, "handleBallInfoClicked, contextId:%s videoId:%s", new Object[] { paramMultiTaskInfo.sGQ, paramMultiTaskInfo.Nic.psI });
        ai.a((Context)getActivity(), paramMultiTaskInfo, paramcrq);
        getActivity().overridePendingTransition(0, 0);
        AppMethodBeat.o(236425);
        return;
      }
    }
    catch (Exception paramMultiTaskInfo)
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramMultiTaskInfo, "handleBallInfoClicked exception:%s", new Object[] { paramMultiTaskInfo });
      }
      Log.e(this.TAG, "handleBallInfoClicked, cache video list size == 0");
      AppMethodBeat.o(236425);
    }
  }
  
  public final a.b dks()
  {
    return a.b.Ach;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.multitask.uic.TopStoryMultiTaskUIC
 * JD-Core Version:    0.7.0.1
 */