package com.tencent.mm.plugin.readerapp.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.plugin.readerapp.a.c;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class ReaderAppUI$a$2
  implements e.a
{
  ReaderAppUI$a$2(ReaderAppUI.a parama, boolean paramBoolean, ReaderAppUI.a.b paramb) {}
  
  public final void onFinish()
  {
    if (!this.npa)
    {
      this.npb.npe.setTextColor(this.noZ.noS.mController.uMN.getResources().getColor(a.a.white));
      this.npb.npe.setBackgroundResource(a.c.biz_msg_cover_gradient_mask);
    }
    this.npb.npf.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a.2
 * JD-Core Version:    0.7.0.1
 */