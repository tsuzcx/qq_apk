package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
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
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.snackbar.a.c;

@com.tencent.mm.ui.base.a(3)
public class VoipScoreDialog
  extends MMActivity
{
  private VoipScoreState NMw;
  private ViewGroup NVY;
  private ImageView[] NVZ;
  private int NWa;
  private d alertDialog;
  
  public VoipScoreDialog()
  {
    AppMethodBeat.i(115385);
    this.NVZ = new ImageView[5];
    this.alertDialog = null;
    this.NWa = 0;
    AppMethodBeat.o(115385);
  }
  
  public int getLayoutId()
  {
    return b.e.voip_transparent_layout;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(115386);
    super.onCreate(paramBundle);
    this.NMw = ((VoipScoreState)getIntent().getParcelableExtra("key_score_state"));
    if (this.NMw == null)
    {
      c.e("MicroMsg.VoipScoreDialog", "onCreate error, scoreState is null", new Object[0]);
      finish();
      AppMethodBeat.o(115386);
      return;
    }
    this.NVY = ((ViewGroup)View.inflate(this, b.e.voip_score_star_line, null));
    this.NVZ[0] = ((ImageView)this.NVY.findViewById(b.d.score_1));
    this.NVZ[1] = ((ImageView)this.NVY.findViewById(b.d.score_2));
    this.NVZ[2] = ((ImageView)this.NVY.findViewById(b.d.score_3));
    this.NVZ[3] = ((ImageView)this.NVY.findViewById(b.d.score_4));
    this.NVZ[4] = ((ImageView)this.NVY.findViewById(b.d.score_5));
    final int i = 0;
    while (i < this.NVZ.length)
    {
      this.NVZ[i].setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115379);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipScoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          VoipScoreDialog.a(VoipScoreDialog.this, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipScoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115379);
        }
      });
      i += 1;
    }
    paramBundle = new f.a(this);
    paramBundle.aR(this.NMw.NPc);
    paramBundle.iK(this.NVY);
    paramBundle.bBp(getString(b.g.voip_score_dialog_reject));
    paramBundle.b(new f.c()
    {
      public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(115380);
        VoipScoreDialog.b(VoipScoreDialog.this, 1);
        VoipScoreDialog.this.finish();
        AppMethodBeat.o(115380);
      }
    });
    paramBundle.HL(false);
    paramBundle.b(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(115381);
        VoipScoreDialog.this.finish();
        AppMethodBeat.o(115381);
      }
    });
    this.alertDialog = paramBundle.mUO;
    if (this.alertDialog != null)
    {
      this.alertDialog.show();
      AppMethodBeat.o(115386);
      return;
    }
    finish();
    AppMethodBeat.o(115386);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipScoreDialog
 * JD-Core Version:    0.7.0.1
 */