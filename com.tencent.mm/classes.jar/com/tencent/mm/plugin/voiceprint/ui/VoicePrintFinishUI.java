package com.tencent.mm.plugin.voiceprint.ui;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class VoicePrintFinishUI
  extends MMActivity
{
  private TextView MYG;
  private Button Uuo;
  private ImageView Uup;
  private int Uuq;
  private TextView sUt;
  
  public int getLayoutId()
  {
    return R.i.goU;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29889);
    Log.i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
    super.onCreate(paramBundle);
    hideTitleView();
    this.Uuq = getIntent().getIntExtra("kscene_type", 73);
    Log.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", new Object[] { Integer.valueOf(this.Uuq) });
    this.sUt = ((TextView)findViewById(R.h.gcV));
    this.MYG = ((TextView)findViewById(R.h.gcX));
    this.Uuo = ((Button)findViewById(R.h.right_btn));
    this.Uup = ((ImageView)findViewById(R.h.gcU));
    switch (this.Uuq)
    {
    }
    for (;;)
    {
      this.Uuo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29887);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          if (VoicePrintFinishUI.a(VoicePrintFinishUI.this) == 72)
          {
            localObject = new Intent();
            ((Intent)localObject).setClass(VoicePrintFinishUI.this, VoiceUnLockUI.class);
            ((Intent)localObject).putExtra("kscene_type", 73);
            paramAnonymousView = VoicePrintFinishUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      this.sUt.setText(R.l.gYm);
      this.MYG.setText(R.l.gYn);
      this.Uup.setVisibility(0);
      this.Uuo.setText(R.l.gVa);
      continue;
      this.sUt.setVisibility(8);
      this.MYG.setText(R.l.gYz);
      this.Uup.setVisibility(0);
      this.Uuo.setText(R.l.gVb);
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