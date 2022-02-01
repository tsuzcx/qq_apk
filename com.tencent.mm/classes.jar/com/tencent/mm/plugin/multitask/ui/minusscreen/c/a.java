package com.tencent.mm.plugin.multitask.ui.minusscreen.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitask.f.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/helper/MultiTaskManager;", "", "()V", "Companion", "ui-multitask_release"})
public final class a
{
  public static final a Aeo;
  private static final String TAG = "MultiTaskManager";
  
  static
  {
    AppMethodBeat.i(236503);
    Aeo = new a((byte)0);
    TAG = "MultiTaskManager";
    AppMethodBeat.o(236503);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/helper/MultiTaskManager$Companion;", "", "()V", "EVENTDATA", "", "EVENTTYPE", "TAG", "getTAG", "()Ljava/lang/String;", "convertBallInfo2MultiTaskInfo", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "extraBallInfo", "Landroid/os/Bundle;", "ui-multitask_release"})
  public static final class a
  {
    public static void a(MultiTaskInfo paramMultiTaskInfo, BallInfo paramBallInfo, Bundle paramBundle)
    {
      AppMethodBeat.i(258183);
      p.h(paramMultiTaskInfo, "multiTaskInfo");
      p.h(paramBallInfo, "ballInfo");
      p.h(paramBundle, "extraBallInfo");
      try
      {
        i = paramBallInfo.type;
        switch (i)
        {
        default: 
          AppMethodBeat.o(258183);
          return;
        }
      }
      catch (Throwable paramMultiTaskInfo)
      {
        Log.printErrStackTrace(a.access$getTAG$cp(), paramMultiTaskInfo, "convertBallInfo2MultiTaskInfo", new Object[0]);
        AppMethodBeat.o(258183);
        return;
      }
      paramBallInfo = new fah();
      b.a(paramBundle, paramBallInfo);
      paramMultiTaskInfo.field_data = paramBallInfo.toByteArray();
      AppMethodBeat.o(258183);
      return;
      paramBundle = new er();
      paramBundle.appId = paramBallInfo.jkf.getString("appId");
      paramBundle.username = paramBallInfo.jkf.getString("username");
      paramBundle.iOo = paramBallInfo.jkf.getInt("versionType");
      paramMultiTaskInfo.field_data = paramBundle.toByteArray();
      paramBundle = paramMultiTaskInfo.field_showData;
      if (paramBundle != null) {
        paramBundle.MwR = paramBallInfo.icon;
      }
      paramMultiTaskInfo = paramMultiTaskInfo.field_showData;
      if (paramMultiTaskInfo != null)
      {
        paramMultiTaskInfo.nickname = paramBallInfo.name;
        AppMethodBeat.o(258183);
        return;
      }
      AppMethodBeat.o(258183);
      return;
      paramBallInfo = paramBundle.getString("eventData");
      int i = paramBundle.getInt("eventType");
      paramBundle = new ctx();
      paramBundle.Mzh = paramBallInfo;
      paramBundle.dRq = i;
      paramMultiTaskInfo.field_data = paramBundle.toByteArray();
      AppMethodBeat.o(258183);
      return;
      aoe localaoe = new aoe();
      b.a(paramBundle, localaoe);
      paramMultiTaskInfo.field_showData.gCr = localaoe.gCr;
      paramMultiTaskInfo.field_showData.title = paramBallInfo.name;
      paramMultiTaskInfo.field_data = localaoe.toByteArray();
      AppMethodBeat.o(258183);
      return;
      paramBallInfo = new fah();
      b.a(paramBundle, paramBallInfo);
      paramMultiTaskInfo.field_data = paramBallInfo.toByteArray();
      AppMethodBeat.o(258183);
      return;
      paramMultiTaskInfo.field_data = paramBundle.getByteArray("key_context");
      AppMethodBeat.o(258183);
      return;
      paramMultiTaskInfo.field_data = paramBallInfo.getByteArrayExtra("KEY_FLOAT_BALL_INFO");
      paramMultiTaskInfo.erh().title = paramBallInfo.name;
      paramMultiTaskInfo.erh().MwR = paramBallInfo.icon;
      AppMethodBeat.o(258183);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.c.a
 * JD-Core Version:    0.7.0.1
 */