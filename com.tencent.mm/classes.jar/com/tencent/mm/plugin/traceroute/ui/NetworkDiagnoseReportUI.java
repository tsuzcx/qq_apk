package com.tencent.mm.plugin.traceroute.ui;

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
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public class NetworkDiagnoseReportUI
  extends MMActivity
{
  private static String Ahp;
  private boolean Aid = false;
  private Button Aie;
  private Button Aif;
  private ImageView Aig;
  private TextView Aih;
  private TextView Aii;
  private TextView Aij;
  
  public int getLayoutId()
  {
    return 2131495011;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29704);
    setMMTitle("");
    this.Aig = ((ImageView)findViewById(2131304086));
    this.Aih = ((TextView)findViewById(2131304089));
    this.Aii = ((TextView)findViewById(2131304088));
    this.Aid = getIntent().getBooleanExtra("diagnose_result", false);
    if (this.Aid)
    {
      this.Aig.setImageResource(2131233420);
      this.Aih.setText(getString(2131764592));
      this.Aii.setVisibility(0);
      addTextOptionMenu(0, getString(2131758051), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(29699);
          NetworkDiagnoseReportUI.this.finish();
          AppMethodBeat.o(29699);
          return false;
        }
      });
      AppMethodBeat.o(29704);
      return;
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29700);
        NetworkDiagnoseReportUI.this.finish();
        AppMethodBeat.o(29700);
        return true;
      }
    });
    Ahp = getIntent().getStringExtra("diagnose_log_file_path");
    this.Aig.setImageResource(2131233419);
    this.Aih.setText(getString(2131764591));
    if ((Ahp == null) || (i.aSp(Ahp) <= 0L))
    {
      AppMethodBeat.o(29704);
      return;
    }
    this.Aij = ((TextView)findViewById(2131304087));
    this.Aij.setText(getString(2131762546, new Object[] { Ahp.replace("mnt/", "") }));
    findViewById(2131304087).setVisibility(0);
    findViewById(2131304578).setVisibility(0);
    this.Aie = ((Button)findViewById(2131304579));
    this.Aie.setVisibility(0);
    this.Aie.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29701);
        Object localObject = new Intent("android.intent.action.SEND");
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("android.intent.extra.EMAIL", new String[] { "WeChat_Log@qq.com" });
        ((Intent)localObject).putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(NetworkDiagnoseReportUI.this));
        ((Intent)localObject).putExtra("android.intent.extra.STREAM", m.a(NetworkDiagnoseReportUI.this.getContext(), new e(NetworkDiagnoseReportUI.Ahp)));
        ((Intent)localObject).setType("text/plain");
        paramAnonymousView = NetworkDiagnoseReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(29701);
      }
    });
    this.Aif = ((Button)findViewById(2131306429));
    this.Aif.setVisibility(0);
    this.Aif.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29702);
        if (!bs.isNullOrNil(NetworkDiagnoseReportUI.Ahp))
        {
          Object localObject = new e(NetworkDiagnoseReportUI.Ahp);
          if (((e)localObject).exists())
          {
            paramAnonymousView = new Intent("android.intent.action.VIEW");
            m.a(NetworkDiagnoseReportUI.this.getContext(), paramAnonymousView, (e)localObject, "text/plain");
            paramAnonymousView.addFlags(268435456);
            localObject = NetworkDiagnoseReportUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((NetworkDiagnoseReportUI)localObject).startActivity((Intent)paramAnonymousView.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(29702);
      }
    });
    AppMethodBeat.o(29704);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29703);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(29703);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI
 * JD-Core Version:    0.7.0.1
 */