package com.tencent.mm.plugin.sns.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.cedit.api.d;

final class SnsCommentFooter$13
  implements View.OnClickListener
{
  SnsCommentFooter$13(SnsCommentFooter paramSnsCommentFooter, SnsCommentFooter.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(369914);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    d.a(SnsCommentFooter.b(this.RqJ)).aEg(com.tencent.mm.k.c.aRd()).Nc(true).a(new c.a()
    {
      public final void Tw(String paramAnonymousString)
      {
        int i = 0;
        AppMethodBeat.i(369929);
        if (TextUtils.equals(SnsCommentFooter.b(SnsCommentFooter.13.this.RqJ).getText().toString(), SnsCommentFooter.b(SnsCommentFooter.13.this.RqJ).getPasterContent())) {
          Log.i("MicroMsg.SnsCommentFooter", "paste clip board to send");
        }
        for (int j = 1;; j = 0)
        {
          boolean bool1 = SnsCommentFooter.b(SnsCommentFooter.13.this.RqJ).getSimilarPasteChange();
          paramAnonymousString = SnsCommentFooter.b(SnsCommentFooter.13.this.RqJ).getSimilarPasteSeqStr();
          boolean bool2 = ClipboardHelper.isCopyFromWX(SnsCommentFooter.b(SnsCommentFooter.13.this.RqJ).getText());
          SnsCommentFooter.b(SnsCommentFooter.13.this.RqJ).jFl();
          if (j != 0)
          {
            if (bool2)
            {
              i = 4;
              i |= 0x0;
            }
          }
          else
          {
            if (!bool1) {
              break label228;
            }
            if (!bool2) {
              break label222;
            }
            j = 16;
            label151:
            i = j | i;
          }
          label222:
          label228:
          for (;;)
          {
            com.tencent.mm.plugin.sns.l.a.P(2, i, paramAnonymousString);
            SnsCommentFooter.13.this.akiO.mU(SnsCommentFooter.b(SnsCommentFooter.13.this.RqJ).getText().toString(), "");
            SnsCommentFooter.b(SnsCommentFooter.13.this.RqJ).setText("");
            AppMethodBeat.o(369929);
            return;
            i = 8;
            break;
            j = 32;
            break label151;
          }
        }
      }
      
      public final void Tx(String paramAnonymousString) {}
      
      public final void eY(String paramAnonymousString)
      {
        AppMethodBeat.i(369930);
        k.s(SnsCommentFooter.j(SnsCommentFooter.13.this.RqJ), b.j.sns_upload_post_text_invalid_more, b.j.sns_upload_post_text_invalid_title);
        AppMethodBeat.o(369930);
      }
    });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(369914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.13
 * JD-Core Version:    0.7.0.1
 */