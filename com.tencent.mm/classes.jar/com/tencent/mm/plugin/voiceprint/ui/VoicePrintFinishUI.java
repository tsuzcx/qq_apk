package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class VoicePrintFinishUI
  extends MMActivity
{
  private TextView iJG;
  private TextView pBu;
  private Button tsq;
  private ImageView tsr;
  private int tss;
  
  public int getLayoutId()
  {
    return 2130971092;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26207);
    ab.i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
    super.onCreate(paramBundle);
    hideTitleView();
    this.tss = getIntent().getIntExtra("kscene_type", 73);
    ab.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", new Object[] { Integer.valueOf(this.tss) });
    this.iJG = ((TextView)findViewById(2131828763));
    this.pBu = ((TextView)findViewById(2131823889));
    this.tsq = ((Button)findViewById(2131823890));
    this.tsr = ((ImageView)findViewById(2131823888));
    switch (this.tss)
    {
    }
    for (;;)
    {
      this.tsq.setOnClickListener(new VoicePrintFinishUI.1(this));
      setBackBtn(new VoicePrintFinishUI.2(this));
      AppMethodBeat.o(26207);
      return;
      this.iJG.setText(2131304580);
      this.pBu.setText(2131304581);
      this.tsr.setVisibility(0);
      this.tsq.setText(2131303519);
      continue;
      this.iJG.setVisibility(8);
      this.pBu.setText(2131304603);
      this.tsr.setVisibility(0);
      this.tsq.setText(2131303520);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26208);
    super.onDestroy();
    AppMethodBeat.o(26208);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintFinishUI
 * JD-Core Version:    0.7.0.1
 */