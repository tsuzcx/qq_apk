package com.tencent.mm.plugin.traceroute.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;

public class NetworkDiagnoseIntroUI
  extends MMActivity
{
  private Button GrS;
  private TextView GrT;
  
  public int getLayoutId()
  {
    return 2131495840;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29698);
    this.GrS = ((Button)findViewById(2131308364));
    this.GrS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29694);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        bg.aVF();
        if (!c.isSDCardAvailable())
        {
          u.g(NetworkDiagnoseIntroUI.this, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29694);
          return;
        }
        if (bg.azz().aYS() == 0)
        {
          Toast.makeText(NetworkDiagnoseIntroUI.this, NetworkDiagnoseIntroUI.this.getString(2131760826), 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29694);
          return;
        }
        localObject = new Intent(NetworkDiagnoseIntroUI.this, NetworkDiagnoseUI.class);
        paramAnonymousView = NetworkDiagnoseIntroUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        NetworkDiagnoseIntroUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29694);
      }
    });
    this.GrT = ((TextView)findViewById(2131305269));
    this.GrT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29695);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("title", NetworkDiagnoseIntroUI.this.getString(2131764022));
        paramAnonymousView.putExtra("rawUrl", NetworkDiagnoseIntroUI.this.getString(2131766959, new Object[] { LocaleUtil.getApplicationLanguage(), LocaleUtil.getCurrentCountryCode() }));
        paramAnonymousView.putExtra("showShare", false);
        com.tencent.mm.plugin.traceroute.a.a.jRt.i(paramAnonymousView, NetworkDiagnoseIntroUI.this.getContext());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29695);
      }
    });
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29696);
        NetworkDiagnoseIntroUI.this.finish();
        AppMethodBeat.o(29696);
        return true;
      }
    });
    AppMethodBeat.o(29698);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29697);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(29697);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI
 * JD-Core Version:    0.7.0.1
 */