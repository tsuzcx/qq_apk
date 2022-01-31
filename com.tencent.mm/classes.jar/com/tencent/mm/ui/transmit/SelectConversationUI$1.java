package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.sdk.platformtools.ab;

final class SelectConversationUI$1
  implements d.a
{
  SelectConversationUI$1(SelectConversationUI paramSelectConversationUI) {}
  
  public final void fH(boolean paramBoolean)
  {
    AppMethodBeat.i(35124);
    boolean bool = this.AAp.isFinishing();
    ab.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + paramBoolean + ", isFinishing = " + bool);
    if ((!paramBoolean) && (!bool))
    {
      ReportUtil.ReportArgs localReportArgs = (ReportUtil.ReportArgs)this.AAp.getIntent().getParcelableExtra("Select_Report_Args");
      ReportUtil.a(this.AAp, localReportArgs, false);
      this.AAp.finish();
    }
    AppMethodBeat.o(35124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.1
 * JD-Core Version:    0.7.0.1
 */