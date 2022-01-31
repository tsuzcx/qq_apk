package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.e.a;

@a(3)
public class VoipScoreDialog
  extends MMActivity
{
  private ViewGroup tCQ;
  private ImageView[] tCR;
  private c tCS;
  private int tCT;
  private VoipScoreState tvv;
  
  public VoipScoreDialog()
  {
    AppMethodBeat.i(4862);
    this.tCR = new ImageView[5];
    this.tCS = null;
    this.tCT = 0;
    AppMethodBeat.o(4862);
  }
  
  public int getLayoutId()
  {
    return 2130971111;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(4863);
    super.onCreate(paramBundle);
    this.tvv = ((VoipScoreState)getIntent().getParcelableExtra("key_score_state"));
    if (this.tvv == null)
    {
      b.e("MicroMsg.VoipScoreDialog", "onCreate error, scoreState is null", new Object[0]);
      finish();
      AppMethodBeat.o(4863);
      return;
    }
    this.tCQ = ((ViewGroup)View.inflate(this, 2130971110, null));
    this.tCR[0] = ((ImageView)this.tCQ.findViewById(2131828835));
    this.tCR[1] = ((ImageView)this.tCQ.findViewById(2131828836));
    this.tCR[2] = ((ImageView)this.tCQ.findViewById(2131828837));
    this.tCR[3] = ((ImageView)this.tCQ.findViewById(2131828838));
    this.tCR[4] = ((ImageView)this.tCQ.findViewById(2131828839));
    int i = 0;
    while (i < this.tCR.length)
    {
      this.tCR[i].setOnClickListener(new VoipScoreDialog.1(this, i));
      i += 1;
    }
    paramBundle = new e.a(this);
    paramBundle.aj(this.tvv.tyO);
    paramBundle.fv(this.tCQ);
    paramBundle.AHs = getString(2131304730);
    paramBundle.b(new VoipScoreDialog.2(this));
    paramBundle.rI(false);
    paramBundle.b(new VoipScoreDialog.3(this));
    this.tCS = paramBundle.gwf;
    if (this.tCS != null)
    {
      this.tCS.show();
      AppMethodBeat.o(4863);
      return;
    }
    finish();
    AppMethodBeat.o(4863);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipScoreDialog
 * JD-Core Version:    0.7.0.1
 */