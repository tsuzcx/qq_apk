package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsCommentFooter$9$1
  implements c.a
{
  SnsCommentFooter$9$1(SnsCommentFooter.9 param9) {}
  
  public final void eP(String paramString)
  {
    this.oXU.oXT.OZ(SnsCommentFooter.d(this.oXU.oXQ).getText().toString());
    SnsCommentFooter.d(this.oXU.oXQ).setText("");
  }
  
  public final void xB() {}
  
  public final void xC()
  {
    h.h(SnsCommentFooter.j(this.oXU.oXQ), i.j.sns_upload_post_text_invalid_more, i.j.sns_upload_post_text_invalid_title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.9.1
 * JD-Core Version:    0.7.0.1
 */