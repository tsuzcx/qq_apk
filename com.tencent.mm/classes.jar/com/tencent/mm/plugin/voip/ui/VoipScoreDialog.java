package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.snackbar.a.c;

@a(3)
public class VoipScoreDialog
  extends MMActivity
{
  private VoipScoreState CaW;
  private ViewGroup CjN;
  private ImageView[] CjO;
  private d CjP;
  private int CjQ;
  
  public VoipScoreDialog()
  {
    AppMethodBeat.i(115385);
    this.CjO = new ImageView[5];
    this.CjP = null;
    this.CjQ = 0;
    AppMethodBeat.o(115385);
  }
  
  public int getLayoutId()
  {
    return 2131495881;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(115386);
    super.onCreate(paramBundle);
    this.CaW = ((VoipScoreState)getIntent().getParcelableExtra("key_score_state"));
    if (this.CaW == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("MicroMsg.VoipScoreDialog", "onCreate error, scoreState is null", new Object[0]);
      finish();
      AppMethodBeat.o(115386);
      return;
    }
    this.CjN = ((ViewGroup)View.inflate(this, 2131495880, null));
    this.CjO[0] = ((ImageView)this.CjN.findViewById(2131304349));
    this.CjO[1] = ((ImageView)this.CjN.findViewById(2131304350));
    this.CjO[2] = ((ImageView)this.CjN.findViewById(2131304351));
    this.CjO[3] = ((ImageView)this.CjN.findViewById(2131304352));
    this.CjO[4] = ((ImageView)this.CjN.findViewById(2131304353));
    int i = 0;
    while (i < this.CjO.length)
    {
      this.CjO[i].setOnClickListener(new VoipScoreDialog.1(this, i));
      i += 1;
    }
    paramBundle = new f.a(this);
    paramBundle.av(this.CaW.CdC);
    paramBundle.hb(this.CjN);
    paramBundle.aXS(getString(2131764912));
    paramBundle.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(115380);
        VoipScoreDialog.b(VoipScoreDialog.this, 1);
        VoipScoreDialog.this.finish();
        AppMethodBeat.o(115380);
      }
    });
    paramBundle.yU(false);
    paramBundle.b(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(115381);
        VoipScoreDialog.this.finish();
        AppMethodBeat.o(115381);
      }
    });
    this.CjP = paramBundle.jcs;
    if (this.CjP != null)
    {
      this.CjP.show();
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