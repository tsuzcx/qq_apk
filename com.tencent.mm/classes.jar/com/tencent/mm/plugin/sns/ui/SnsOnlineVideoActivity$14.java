package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.e.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.k.g;

final class SnsOnlineVideoActivity$14
  implements View.OnClickListener
{
  SnsOnlineVideoActivity$14(SnsOnlineVideoActivity paramSnsOnlineVideoActivity, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98954);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    SnsOnlineVideoActivity.n(this.KVu).setBackground(com.tencent.mm.ci.a.m(this.KVu.getContext(), i.e.sns_second_cut_shape_background_press));
    paramView = com.tencent.mm.plugin.recordvideo.e.a.IeL;
    final boolean bool = com.tencent.mm.plugin.recordvideo.e.a.M(this.KVu.getContext(), "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF");
    if (bool) {}
    for (int i = i.j.app_field_secondcut_jump_tip;; i = i.j.app_field_secondcut_install_tip)
    {
      paramView = g.Kia;
      g.gk(SnsOnlineVideoActivity.o(this.KVu), 2);
      com.tencent.mm.ui.base.h.a(this.KVu.getContext(), i, i.j.app_tip, i.j.app_ok, i.j.app_cancel, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(265178);
          Object localObject;
          if (bool)
          {
            paramAnonymousDialogInterface = i.Ifo;
            paramAnonymousDialogInterface = SnsOnlineVideoActivity.14.this.ove;
            localObject = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
            paramAnonymousDialogInterface = i.am("moments", paramAnonymousDialogInterface, com.tencent.mm.plugin.recordvideo.e.h.fzB());
            localObject = i.Ifo;
            i.ax(SnsOnlineVideoActivity.14.this.KVu.getContext(), paramAnonymousDialogInterface);
          }
          for (;;)
          {
            SnsOnlineVideoActivity.14.this.KVu.cJs();
            paramAnonymousDialogInterface = g.Kia;
            g.gk(SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.14.this.KVu), 3);
            AppMethodBeat.o(265178);
            return;
            paramAnonymousDialogInterface = com.tencent.mm.plugin.recordvideo.e.a.IeL;
            paramAnonymousDialogInterface = SnsOnlineVideoActivity.14.this.KVu.getContext();
            localObject = new StringBuilder();
            com.tencent.mm.plugin.recordvideo.e.h localh = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
            com.tencent.mm.plugin.recordvideo.e.a.aK(paramAnonymousDialogInterface, com.tencent.mm.plugin.recordvideo.e.h.fzC() + "1106");
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(206014);
          SnsOnlineVideoActivity.n(SnsOnlineVideoActivity.14.this.KVu).setBackground(com.tencent.mm.ci.a.m(SnsOnlineVideoActivity.14.this.KVu.getContext(), i.e.sns_second_cut_shape_background));
          AppMethodBeat.o(206014);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98954);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.14
 * JD-Core Version:    0.7.0.1
 */