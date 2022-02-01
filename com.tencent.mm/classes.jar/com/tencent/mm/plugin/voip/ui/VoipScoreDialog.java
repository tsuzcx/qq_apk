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
  private VoipScoreState GWj;
  private ViewGroup Hfh;
  private ImageView[] Hfi;
  private int Hfj;
  private d alertDialog;
  
  public VoipScoreDialog()
  {
    AppMethodBeat.i(115385);
    this.Hfi = new ImageView[5];
    this.alertDialog = null;
    this.Hfj = 0;
    AppMethodBeat.o(115385);
  }
  
  public int getLayoutId()
  {
    return 2131496861;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(115386);
    super.onCreate(paramBundle);
    this.GWj = ((VoipScoreState)getIntent().getParcelableExtra("key_score_state"));
    if (this.GWj == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("MicroMsg.VoipScoreDialog", "onCreate error, scoreState is null", new Object[0]);
      finish();
      AppMethodBeat.o(115386);
      return;
    }
    this.Hfh = ((ViewGroup)View.inflate(this, 2131496860, null));
    this.Hfi[0] = ((ImageView)this.Hfh.findViewById(2131307283));
    this.Hfi[1] = ((ImageView)this.Hfh.findViewById(2131307284));
    this.Hfi[2] = ((ImageView)this.Hfh.findViewById(2131307285));
    this.Hfi[3] = ((ImageView)this.Hfh.findViewById(2131307286));
    this.Hfi[4] = ((ImageView)this.Hfh.findViewById(2131307287));
    final int i = 0;
    while (i < this.Hfi.length)
    {
      this.Hfi[i].setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115379);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipScoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          VoipScoreDialog.a(VoipScoreDialog.this, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipScoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115379);
        }
      });
      i += 1;
    }
    paramBundle = new f.a(this);
    paramBundle.aC(this.GWj.GYP);
    paramBundle.hu(this.Hfh);
    paramBundle.boA(getString(2131767353));
    paramBundle.b(new f.c()
    {
      public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(115380);
        VoipScoreDialog.b(VoipScoreDialog.this, 1);
        VoipScoreDialog.this.finish();
        AppMethodBeat.o(115380);
      }
    });
    paramBundle.Dq(false);
    paramBundle.b(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(115381);
        VoipScoreDialog.this.finish();
        AppMethodBeat.o(115381);
      }
    });
    this.alertDialog = paramBundle.kdo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipScoreDialog
 * JD-Core Version:    0.7.0.1
 */