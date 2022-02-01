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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public class VoicePrintFinishUI
  extends MMActivity
{
  private TextView kEu;
  private TextView uDc;
  private int xXv;
  private Button zeB;
  private ImageView zeC;
  
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
    this.xXv = getIntent().getIntExtra("kscene_type", 73);
    ad.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", new Object[] { Integer.valueOf(this.xXv) });
    this.kEu = ((TextView)findViewById(2131306514));
    this.uDc = ((TextView)findViewById(2131306516));
    this.zeB = ((Button)findViewById(2131304179));
    this.zeC = ((ImageView)findViewById(2131306513));
    switch (this.xXv)
    {
    }
    for (;;)
    {
      this.zeB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29887);
          if (VoicePrintFinishUI.a(VoicePrintFinishUI.this) == 72)
          {
            Object localObject = new Intent();
            ((Intent)localObject).setClass(VoicePrintFinishUI.this, VoiceUnLockUI.class);
            ((Intent)localObject).putExtra("kscene_type", 73);
            paramAnonymousView = VoicePrintFinishUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          VoicePrintFinishUI.this.finish();
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
      this.kEu.setText(2131764753);
      this.uDc.setText(2131764754);
      this.zeC.setVisibility(0);
      this.zeB.setText(2131763501);
      continue;
      this.kEu.setVisibility(8);
      this.uDc.setText(2131764779);
      this.zeC.setVisibility(0);
      this.zeB.setText(2131763502);
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