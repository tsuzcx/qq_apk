package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.f.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.a.c.a;

final class SnsCommentUI$2$1
  implements c.a
{
  SnsCommentUI$2$1(SnsCommentUI.2 param2) {}
  
  public final void eP(String paramString)
  {
    String str1 = SnsCommentUI.b(this.oYa.oXZ).getText().toString().trim();
    SnsCommentUI.b(this.oYa.oXZ).setText("");
    if (str1.length() > 0) {
      switch (SnsCommentUI.a(this.oYa.oXZ))
      {
      }
    }
    long l1;
    long l2;
    long l3;
    do
    {
      return;
      this.oYa.oXZ.XM();
      SnsCommentUI.a(this.oYa.oXZ, str1);
      return;
      this.oYa.oXZ.XM();
      SnsCommentUI.b(this.oYa.oXZ, str1);
      return;
      this.oYa.oXZ.XM();
      l1 = this.oYa.oXZ.getIntent().getLongExtra("sns_id", 0L);
      l2 = this.oYa.oXZ.getIntent().getLongExtra("action_st_time", 0L);
      paramString = bk.aM(this.oYa.oXZ.getIntent().getStringExtra("sns_uxinfo"), "");
      str2 = bk.aM(this.oYa.oXZ.getIntent().getStringExtra("sns_actionresult"), "");
      str1 = str2 + "|4:1:" + str1;
      l3 = System.currentTimeMillis();
      localObject = af.bDx().bEz();
    } while ((localObject == null) || (!((com.tencent.mm.plugin.sns.f.h)localObject).bEA()));
    String str2 = ((com.tencent.mm.plugin.sns.f.h)localObject).ovZ;
    Object localObject = ((com.tencent.mm.plugin.sns.f.h)localObject).ovY;
    y.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + l1 + " uxinfo:" + paramString + " actionresult: " + str1 + " " + l2 + " " + l3);
    com.tencent.mm.plugin.report.service.h.nFQ.f(11988, new Object[] { str2, localObject, "", "", i.fN(l1), paramString, str1, Long.valueOf(l2 / 1000L), Long.valueOf(l3 / 1000L) });
    SnsCommentUI.c(this.oYa.oXZ);
    this.oYa.oXZ.finish();
  }
  
  public final void xB() {}
  
  public final void xC()
  {
    com.tencent.mm.ui.base.h.h(this.oYa.oXZ, i.j.sns_upload_post_text_invalid_more, i.j.sns_upload_post_text_invalid_title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentUI.2.1
 * JD-Core Version:    0.7.0.1
 */