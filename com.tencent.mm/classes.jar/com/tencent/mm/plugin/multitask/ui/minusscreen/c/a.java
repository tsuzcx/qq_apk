package com.tencent.mm.plugin.multitask.ui.minusscreen.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitask.f.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.protocal.protobuf.ghm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/helper/MultiTaskManager;", "", "()V", "Companion", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a LGb;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(304430);
    LGb = new a((byte)0);
    TAG = "MultiTaskManager";
    AppMethodBeat.o(304430);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/helper/MultiTaskManager$Companion;", "", "()V", "EVENTDATA", "", "EVENTTYPE", "KEY_FLOAT_BALL_INFO", "TAG", "getTAG", "()Ljava/lang/String;", "convertBallInfo2MultiTaskInfo", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "extraBallInfo", "Landroid/os/Bundle;", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(MultiTaskInfo paramMultiTaskInfo, BallInfo paramBallInfo, Bundle paramBundle)
    {
      AppMethodBeat.i(304445);
      s.u(paramMultiTaskInfo, "multiTaskInfo");
      s.u(paramBallInfo, "ballInfo");
      s.u(paramBundle, "extraBallInfo");
      for (;;)
      {
        int i;
        try
        {
          i = paramBallInfo.type;
          switch (i)
          {
          default: 
            AppMethodBeat.o(304445);
            return;
          }
        }
        finally
        {
          Log.printErrStackTrace(a.access$getTAG$cp(), paramMultiTaskInfo, "convertBallInfo2MultiTaskInfo", new Object[0]);
          AppMethodBeat.o(304445);
          return;
        }
        paramBallInfo = new ghm();
        b.a(paramBundle, paramBallInfo);
        paramMultiTaskInfo.field_data = paramBallInfo.toByteArray();
        AppMethodBeat.o(304445);
        return;
        paramBundle = new fi();
        paramBundle.appId = paramBallInfo.oSS.getString("appId");
        paramBundle.username = paramBallInfo.oSS.getString("username");
        paramBundle.euz = paramBallInfo.oSS.getInt("versionType");
        paramMultiTaskInfo.field_data = paramBundle.toByteArray();
        paramBundle = paramMultiTaskInfo.field_showData;
        if (paramBundle != null) {
          paramBundle.aaXP = paramBallInfo.icon;
        }
        paramMultiTaskInfo = paramMultiTaskInfo.field_showData;
        if (paramMultiTaskInfo != null)
        {
          paramMultiTaskInfo.nickname = paramBallInfo.name;
          AppMethodBeat.o(304445);
          return;
          paramBallInfo = paramBundle.getString("eventData");
          i = paramBundle.getInt("eventType");
          paramBundle = new dur();
          paramBundle.abaD = paramBallInfo;
          paramBundle.hQm = i;
          paramMultiTaskInfo.field_data = paramBundle.toByteArray();
          AppMethodBeat.o(304445);
          return;
          asy localasy = new asy();
          if (paramBundle != null)
          {
            localasy.ZDe = paramBundle.getString("app_type");
            localasy.ZDf = paramBundle.getString("app_media_id");
            localasy.ZDg = paramBundle.getLong("app_msg_id");
            localasy.ZDh = paramBundle.getBoolean("app_show_share");
            localasy.scene = paramBundle.getInt("scene");
            localasy.ZDd = paramBundle.getBoolean("ifAppAttachDownloadUI");
            localasy.filePath = paramBundle.getString("filePath");
            localasy.lPJ = paramBundle.getString("fileExt");
            localasy.appId = paramBundle.getString("appId");
            localasy.processName = paramBundle.getString("processName");
            localasy.rvh = paramBundle.getBoolean("showMenu");
          }
          paramMultiTaskInfo.field_showData.lPJ = localasy.lPJ;
          paramMultiTaskInfo.field_showData.title = paramBallInfo.name;
          paramMultiTaskInfo.field_data = localasy.toByteArray();
          AppMethodBeat.o(304445);
          return;
          paramBallInfo = new ghm();
          b.a(paramBundle, paramBallInfo);
          paramMultiTaskInfo.field_data = paramBallInfo.toByteArray();
          AppMethodBeat.o(304445);
          return;
          paramMultiTaskInfo.field_data = paramBundle.getByteArray("key_context");
          AppMethodBeat.o(304445);
          return;
          paramMultiTaskInfo.field_data = paramBallInfo.getByteArrayExtra("KEY_FLOAT_BALL_INFO");
          paramMultiTaskInfo.gkh().title = paramBallInfo.name;
          paramMultiTaskInfo.gkh().aaXP = paramBallInfo.icon;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.c.a
 * JD-Core Version:    0.7.0.1
 */