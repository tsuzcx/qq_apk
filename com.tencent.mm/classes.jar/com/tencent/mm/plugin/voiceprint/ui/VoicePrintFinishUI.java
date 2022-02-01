package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public class VoicePrintFinishUI
  extends MMActivity
{
  private int ACq;
  private Button BWC;
  private ImageView BWD;
  private TextView lCL;
  private TextView wTc;
  
  public int getLayoutId()
  {
    return 2131495862;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29889);
    ad.i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
    super.onCreate(paramBundle);
    hideTitleView();
    this.ACq = getIntent().getIntExtra("kscene_type", 73);
    ad.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", new Object[] { Integer.valueOf(this.ACq) });
    this.lCL = ((TextView)findViewById(2131306514));
    this.wTc = ((TextView)findViewById(2131306516));
    this.BWC = ((Button)findViewById(2131304179));
    this.BWD = ((ImageView)findViewById(2131306513));
    switch (this.ACq)
    {
    }
    for (;;)
    {
      this.BWC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29887);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          if (VoicePrintFinishUI.a(VoicePrintFinishUI.this) == 72)
          {
            localObject = new Intent();
            ((Intent)localObject).setClass(VoicePrintFinishUI.this, VoiceUnLockUI.class);
            ((Intent)localObject).putExtra("kscene_type", 73);
            paramAnonymousView = VoicePrintFinishUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          VoicePrintFinishUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29887);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(29888);
          VoicePrintFinishUI.this.finish();
          AppMethodBeat.o(29888);
          return true;
        }
      });
      AppMethodBeat.o(29889);
      return;
      this.lCL.setText(2131764753);
      this.wTc.setText(2131764754);
      this.BWD.setVisibility(0);
      this.BWC.setText(2131763501);
      continue;
      this.lCL.setVisibility(8);
      this.wTc.setText(2131764779);
      this.BWD.setVisibility(0);
      this.BWC.setText(2131763502);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29890);
    super.onDestroy();
    AppMethodBeat.o(29890);
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