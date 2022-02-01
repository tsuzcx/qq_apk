package com.tencent.mm.plugin.multitask.ui.minusscreen.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitask.f.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.fky;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/helper/MultiTaskManager$Companion;", "", "()V", "EVENTDATA", "", "EVENTTYPE", "TAG", "getTAG", "()Ljava/lang/String;", "convertBallInfo2MultiTaskInfo", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "extraBallInfo", "Landroid/os/Bundle;", "ui-multitask_release"})
public final class a$a
{
  public static void a(MultiTaskInfo paramMultiTaskInfo, BallInfo paramBallInfo, Bundle paramBundle)
  {
    AppMethodBeat.i(196881);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    p.k(paramBallInfo, "ballInfo");
    p.k(paramBundle, "extraBallInfo");
    try
    {
      i = paramBallInfo.type;
      switch (i)
      {
      default: 
        AppMethodBeat.o(196881);
        return;
      }
    }
    catch (Throwable paramMultiTaskInfo)
    {
      Log.printErrStackTrace(a.access$getTAG$cp(), paramMultiTaskInfo, "convertBallInfo2MultiTaskInfo", new Object[0]);
      AppMethodBeat.o(196881);
      return;
    }
    paramBallInfo = new fky();
    b.a(paramBundle, paramBallInfo);
    paramMultiTaskInfo.field_data = paramBallInfo.toByteArray();
    AppMethodBeat.o(196881);
    return;
    paramBundle = new eo();
    paramBundle.appId = paramBallInfo.mab.getString("appId");
    paramBundle.username = paramBallInfo.mab.getString("username");
    paramBundle.cBU = paramBallInfo.mab.getInt("versionType");
    paramMultiTaskInfo.field_data = paramBundle.toByteArray();
    paramBundle = paramMultiTaskInfo.field_showData;
    if (paramBundle != null) {
      paramBundle.TIg = paramBallInfo.icon;
    }
    paramMultiTaskInfo = paramMultiTaskInfo.field_showData;
    if (paramMultiTaskInfo != null)
    {
      paramMultiTaskInfo.nickname = paramBallInfo.name;
      AppMethodBeat.o(196881);
      return;
    }
    AppMethodBeat.o(196881);
    return;
    paramBallInfo = paramBundle.getString("eventData");
    int i = paramBundle.getInt("eventType");
    paramBundle = new dcy();
    paramBundle.TKK = paramBallInfo;
    paramBundle.fKG = i;
    paramMultiTaskInfo.field_data = paramBundle.toByteArray();
    AppMethodBeat.o(196881);
    return;
    apf localapf = new apf();
    b.a(paramBundle, localapf);
    paramMultiTaskInfo.field_showData.jmx = localapf.jmx;
    paramMultiTaskInfo.field_showData.title = paramBallInfo.name;
    paramMultiTaskInfo.field_data = localapf.toByteArray();
    AppMethodBeat.o(196881);
    return;
    paramBallInfo = new fky();
    b.a(paramBundle, paramBallInfo);
    paramMultiTaskInfo.field_data = paramBallInfo.toByteArray();
    AppMethodBeat.o(196881);
    return;
    paramMultiTaskInfo.field_data = paramBundle.getByteArray("key_context");
    AppMethodBeat.o(196881);
    return;
    paramMultiTaskInfo.field_data = paramBallInfo.aou("KEY_FLOAT_BALL_INFO");
    paramMultiTaskInfo.fbc().title = paramBallInfo.name;
    paramMultiTaskInfo.fbc().TIg = paramBallInfo.icon;
    AppMethodBeat.o(196881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.c.a.a
 * JD-Core Version:    0.7.0.1
 */