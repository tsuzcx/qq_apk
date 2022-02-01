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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class VoicePrintFinishUI
  extends MMActivity
{
  private TextView BgP;
  private int Fex;
  private Button GSc;
  private ImageView GSd;
  private TextView mPa;
  
  public int getLayoutId()
  {
    return 2131496842;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29889);
    Log.i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
    super.onCreate(paramBundle);
    hideTitleView();
    this.Fex = getIntent().getIntExtra("kscene_type", 73);
    Log.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", new Object[] { Integer.valueOf(this.Fex) });
    this.mPa = ((TextView)findViewById(2131309974));
    this.BgP = ((TextView)findViewById(2131309976));
    this.GSc = ((Button)findViewById(2131307087));
    this.GSd = ((ImageView)findViewById(2131309973));
    switch (this.Fex)
    {
    }
    for (;;)
    {
      this.GSc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29887);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          if (VoicePrintFinishUI.a(VoicePrintFinishUI.this) == 72)
          {
            localObject = new Intent();
            ((Intent)localObject).setClass(VoicePrintFinishUI.this, VoiceUnLockUI.class);
            ((Intent)localObject).putExtra("kscene_type", 73);
            paramAnonymousView = VoicePrintFinishUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
      this.mPa.setText(2131767190);
      this.BgP.setText(2131767191);
      this.GSd.setVisibility(0);
      this.GSc.setText(2131765686);
      continue;
      this.mPa.setVisibility(8);
      this.BgP.setText(2131767216);
      this.GSd.setVisibility(0);
      this.GSc.setText(2131765687);
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