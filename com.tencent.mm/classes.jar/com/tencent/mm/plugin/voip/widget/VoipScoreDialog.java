package com.tencent.mm.plugin.voip.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.ui.widget.snackbar.a.c;

@com.tencent.mm.ui.base.a(3)
public class VoipScoreDialog
  extends MMActivity
{
  private ViewGroup UVJ;
  private ImageView[] UVK;
  private int UVL;
  private VoipScoreState Uzi;
  private e alertDialog;
  
  public VoipScoreDialog()
  {
    AppMethodBeat.i(293426);
    this.UVK = new ImageView[5];
    this.alertDialog = null;
    this.UVL = 0;
    AppMethodBeat.o(293426);
  }
  
  public int getLayoutId()
  {
    return b.e.voip_transparent_layout;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(293437);
    super.onCreate(paramBundle);
    this.Uzi = ((VoipScoreState)getIntent().getParcelableExtra("key_score_state"));
    if (this.Uzi == null)
    {
      c.e("MicroMsg.VoipScoreDialog", "onCreate error, scoreState is null", new Object[0]);
      finish();
      AppMethodBeat.o(293437);
      return;
    }
    this.UVJ = ((ViewGroup)View.inflate(this, b.e.voip_score_star_line, null));
    this.UVK[0] = ((ImageView)this.UVJ.findViewById(b.d.score_1));
    this.UVK[1] = ((ImageView)this.UVJ.findViewById(b.d.score_2));
    this.UVK[2] = ((ImageView)this.UVJ.findViewById(b.d.score_3));
    this.UVK[3] = ((ImageView)this.UVJ.findViewById(b.d.score_4));
    this.UVK[4] = ((ImageView)this.UVJ.findViewById(b.d.score_5));
    final int i = 0;
    while (i < this.UVK.length)
    {
      this.UVK[i].setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(293415);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/widget/VoipScoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          VoipScoreDialog.a(VoipScoreDialog.this, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/widget/VoipScoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(293415);
        }
      });
      i += 1;
    }
    paramBundle = new g.a(this);
    paramBundle.bf(this.Uzi.UBB);
    paramBundle.mg(this.UVJ);
    paramBundle.bDI(getString(b.g.voip_score_dialog_reject));
    paramBundle.b(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(293416);
        VoipScoreDialog.b(VoipScoreDialog.this, 1);
        VoipScoreDialog.this.finish();
        AppMethodBeat.o(293416);
      }
    });
    paramBundle.NF(false);
    paramBundle.d(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(293417);
        VoipScoreDialog.this.finish();
        AppMethodBeat.o(293417);
      }
    });
    this.alertDialog = paramBundle.pRv;
    if (this.alertDialog != null)
    {
      this.alertDialog.show();
      AppMethodBeat.o(293437);
      return;
    }
    finish();
    AppMethodBeat.o(293437);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipScoreDialog
 * JD-Core Version:    0.7.0.1
 */