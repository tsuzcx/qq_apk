package com.tencent.mm.plugin.topstory.ui.b.a;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.c;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.fog;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/topstory/ui/multitask/uic/TopStoryMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onMultiTaskItemClick", "", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "", "ui-topstory_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
{
  private final String TAG;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(271675);
    this.TAG = "MicroMsg.TopStory.TopStoryMultiTaskUIC";
    AppMethodBeat.o(271675);
  }
  
  public a(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(271678);
    this.TAG = "MicroMsg.TopStory.TopStoryMultiTaskUIC";
    AppMethodBeat.o(271678);
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, Object paramObject)
  {
    paramObject = null;
    AppMethodBeat.i(271685);
    s.u(paramMultiTaskInfo, "info");
    s.u(paramdrt, "animateData");
    paramView = paramMultiTaskInfo.field_data;
    Object localObject = new fog();
    try
    {
      ((fog)localObject).parseFrom(paramView);
      if (((fog)localObject).aaUM.size() > 0)
      {
        paramMultiTaskInfo = new foe();
        paramMultiTaskInfo.scene = ((fog)localObject).scene;
        paramMultiTaskInfo.abOl = ((fog)localObject).abOl;
        paramMultiTaskInfo.abOk = ((foh)((fog)localObject).aaUM.get(0));
        paramView = paramMultiTaskInfo.abOk;
        if (paramView == null)
        {
          paramView = null;
          paramMultiTaskInfo.abOf = paramView;
          paramMultiTaskInfo.abOh = ((fog)localObject).abOh;
          paramMultiTaskInfo.abOg = ((fog)localObject).abOg;
          paramMultiTaskInfo.abOi = ((fog)localObject).abOi;
          paramMultiTaskInfo.abOj = ((fog)localObject).abOj;
          paramMultiTaskInfo.zIO = ((fog)localObject).zIO;
          paramMultiTaskInfo.abOs = ((fog)localObject).abOs;
          paramMultiTaskInfo.offset = ((fog)localObject).offset;
          paramMultiTaskInfo.hAB = ((fog)localObject).hAB;
          paramMultiTaskInfo.Wol = ((fog)localObject).Wol;
          localObject = this.TAG;
          String str = paramMultiTaskInfo.zIO;
          paramView = paramMultiTaskInfo.abOk;
          if (paramView != null) {
            break label295;
          }
          paramView = paramObject;
          Log.i((String)localObject, "handleBallInfoClicked, contextId:%s videoId:%s", new Object[] { str, paramView });
          aj.a((Context)getActivity(), paramMultiTaskInfo, paramdrt);
          getActivity().overridePendingTransition(0, 0);
          AppMethodBeat.o(271685);
        }
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramView, "handleBallInfoClicked exception:%s", new Object[] { paramView });
        continue;
        paramView = paramView.Ido;
        continue;
        label295:
        paramView = paramView.Ido;
      }
      Log.e(this.TAG, "handleBallInfoClicked, cache video list size == 0");
      AppMethodBeat.o(271685);
    }
  }
  
  public final a.b eDe()
  {
    return a.b.LDq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.b.a.a
 * JD-Core Version:    0.7.0.1
 */