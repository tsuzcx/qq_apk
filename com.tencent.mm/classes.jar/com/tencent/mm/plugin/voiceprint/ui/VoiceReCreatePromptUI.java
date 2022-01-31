package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class VoiceReCreatePromptUI
  extends MMActivity
  implements View.OnClickListener
{
  private View pMT = null;
  
  protected final int getLayoutId()
  {
    return R.i.voice_print_recreate_prompt;
  }
  
  public void onClick(View paramView)
  {
    startActivity(new Intent(this, VoiceCreateUI.class));
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    this.pMT = findViewById(R.h.recreate_button);
    this.pMT.setOnClickListener(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceReCreatePromptUI
 * JD-Core Version:    0.7.0.1
 */