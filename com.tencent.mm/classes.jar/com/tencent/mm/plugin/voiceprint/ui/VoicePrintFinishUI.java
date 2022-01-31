package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class VoicePrintFinishUI
  extends MMActivity
{
  private TextView haW;
  private TextView pMv;
  private Button pMw;
  private ImageView pMx;
  private int pMy;
  
  protected final int getLayoutId()
  {
    return R.i.voice_print_finish;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    y.i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    this.pMy = getIntent().getIntExtra("kscene_type", 73);
    y.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", new Object[] { Integer.valueOf(this.pMy) });
    this.haW = ((TextView)findViewById(R.h.voice_print_title));
    this.pMv = ((TextView)findViewById(R.h.voice_print_title_tip));
    this.pMw = ((Button)findViewById(R.h.right_btn));
    this.pMx = ((ImageView)findViewById(R.h.voice_print_sucesss_icon));
    switch (this.pMy)
    {
    }
    for (;;)
    {
      this.pMw.setOnClickListener(new VoicePrintFinishUI.1(this));
      setBackBtn(new VoicePrintFinishUI.2(this));
      return;
      this.haW.setText(R.l.voice_regeist_finish);
      this.pMv.setText(R.l.voice_regeist_finish_tip);
      this.pMx.setVisibility(0);
      this.pMw.setText(R.l.settings_voiceprint_unlock);
      continue;
      this.haW.setVisibility(8);
      this.pMv.setText(R.l.voice_unlock_ok_tip);
      this.pMx.setVisibility(0);
      this.pMw.setText(R.l.settings_voiceprint_unlock_finish);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintFinishUI
 * JD-Core Version:    0.7.0.1
 */