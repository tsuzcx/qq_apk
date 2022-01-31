package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.b.c.a;

final class SnsCommentUI$2$1
  implements c.a
{
  SnsCommentUI$2$1(SnsCommentUI.2 param2) {}
  
  public final void JU() {}
  
  public final void kY(String paramString)
  {
    AppMethodBeat.i(38915);
    String str1 = SnsCommentUI.b(this.rQt.rQs).getText().toString().trim();
    SnsCommentUI.b(this.rQt.rQs).setText("");
    if (str1.length() > 0) {
      switch (SnsCommentUI.a(this.rQt.rQs))
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(38915);
      return;
      this.rQt.rQs.hideVKB();
      SnsCommentUI.a(this.rQt.rQs, str1);
      AppMethodBeat.o(38915);
      return;
      this.rQt.rQs.hideVKB();
      SnsCommentUI.b(this.rQt.rQs, str1);
      AppMethodBeat.o(38915);
      return;
      this.rQt.rQs.hideVKB();
      long l1 = this.rQt.rQs.getIntent().getLongExtra("sns_id", 0L);
      long l2 = this.rQt.rQs.getIntent().getLongExtra("action_st_time", 0L);
      paramString = bo.bf(this.rQt.rQs.getIntent().getStringExtra("sns_uxinfo"), "");
      String str2 = bo.bf(this.rQt.rQs.getIntent().getStringExtra("sns_actionresult"), "");
      str1 = str2 + "|4:1:" + str1;
      long l3 = System.currentTimeMillis();
      Object localObject = ag.coX().cqb();
      if ((localObject == null) || (!((com.tencent.mm.plugin.sns.g.h)localObject).cqc()))
      {
        AppMethodBeat.o(38915);
        return;
      }
      str2 = ((com.tencent.mm.plugin.sns.g.h)localObject).rkT;
      localObject = ((com.tencent.mm.plugin.sns.g.h)localObject).rkS;
      ab.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + l1 + " uxinfo:" + paramString + " actionresult: " + str1 + " " + l2 + " " + l3);
      com.tencent.mm.plugin.report.service.h.qsU.e(11988, new Object[] { str2, localObject, "", "", i.lq(l1), paramString, str1, Long.valueOf(l2 / 1000L), Long.valueOf(l3 / 1000L) });
      SnsCommentUI.c(this.rQt.rQs);
      this.rQt.rQs.finish();
    }
  }
  
  public final void vn()
  {
    AppMethodBeat.i(38916);
    com.tencent.mm.ui.base.h.h(this.rQt.rQs, 2131304037, 2131304038);
    AppMethodBeat.o(38916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentUI.2.1
 * JD-Core Version:    0.7.0.1
 */