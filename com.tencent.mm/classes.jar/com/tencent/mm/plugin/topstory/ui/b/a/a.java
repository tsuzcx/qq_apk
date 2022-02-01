package com.tencent.mm.plugin.topstory.ui.b.a;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.c;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esx;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/topstory/ui/multitask/uic/TopStoryMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onMultiTaskItemClick", "", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "", "ui-topstory_release"})
public final class a
  extends c
{
  private final String TAG;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(202875);
    this.TAG = "MicroMsg.TopStory.TopStoryMultiTaskUIC";
    AppMethodBeat.o(202875);
  }
  
  public a(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(202877);
    this.TAG = "MicroMsg.TopStory.TopStoryMultiTaskUIC";
    AppMethodBeat.o(202877);
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, dal paramdal, Object paramObject)
  {
    AppMethodBeat.i(202872);
    p.k(paramMultiTaskInfo, "info");
    p.k(paramdal, "animateData");
    paramMultiTaskInfo = paramMultiTaskInfo.field_data;
    paramView = new esx();
    try
    {
      paramView.parseFrom(paramMultiTaskInfo);
      if (paramView.TFg.size() > 0)
      {
        paramMultiTaskInfo = new esv();
        paramMultiTaskInfo.scene = paramView.scene;
        paramMultiTaskInfo.UuJ = paramView.UuJ;
        paramMultiTaskInfo.UuI = ((esy)paramView.TFg.get(0));
        paramMultiTaskInfo.UuD = paramMultiTaskInfo.UuI.Crh;
        paramMultiTaskInfo.UuF = paramView.UuF;
        paramMultiTaskInfo.UuE = paramView.UuE;
        paramMultiTaskInfo.UuG = paramView.UuG;
        paramMultiTaskInfo.UuH = paramView.UuH;
        paramMultiTaskInfo.wmL = paramView.wmL;
        paramMultiTaskInfo.UuQ = paramView.UuQ;
        paramMultiTaskInfo.offset = paramView.offset;
        paramMultiTaskInfo.fwe = paramView.fwe;
        paramMultiTaskInfo.Pye = paramView.Pye;
        Log.i(this.TAG, "handleBallInfoClicked, contextId:%s videoId:%s", new Object[] { paramMultiTaskInfo.wmL, paramMultiTaskInfo.UuI.Crh });
        ai.a((Context)getActivity(), paramMultiTaskInfo, paramdal);
        getActivity().overridePendingTransition(0, 0);
        AppMethodBeat.o(202872);
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
      AppMethodBeat.o(202872);
    }
  }
  
  public final a.b dKp()
  {
    return a.b.FHX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.b.a.a
 * JD-Core Version:    0.7.0.1
 */