package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class VoiceReCreatePromptUI
  extends MMActivity
  implements View.OnClickListener
{
  private View AxD = null;
  
  public int getLayoutId()
  {
    return 2131495866;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(29904);
    paramView = new Intent(this, VoiceCreateUI.class);
    paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramView.aeD(), "com/tencent/mm/plugin/voiceprint/ui/VoiceReCreatePromptUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramView.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceReCreatePromptUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(29904);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29902);
    super.onCreate(paramBundle);
    hideTitleView();
    this.AxD = findViewById(2131303910);
    this.AxD.setOnClickListener(this);
    AppMethodBeat.o(29902);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29903);
    super.onDestroy();
    AppMethodBeat.o(29903);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceReCreatePromptUI
 * JD-Core Version:    0.7.0.1
 */