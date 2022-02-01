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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.k;

public class NetworkDiagnoseReportUI
  extends MMActivity
{
  private static String BQz;
  private boolean BRn = false;
  private Button BRo;
  private Button BRp;
  private ImageView BRq;
  private TextView BRr;
  private TextView BRs;
  private TextView BRt;
  
  public int getLayoutId()
  {
    return 2131495011;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29704);
    setMMTitle("");
    this.BRq = ((ImageView)findViewById(2131304086));
    this.BRr = ((TextView)findViewById(2131304089));
    this.BRs = ((TextView)findViewById(2131304088));
    this.BRn = getIntent().getBooleanExtra("diagnose_result", false);
    if (this.BRn)
    {
      this.BRq.setImageResource(2131233420);
      this.BRr.setText(getString(2131764592));
      this.BRs.setVisibility(0);
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
    BQz = getIntent().getStringExtra("diagnose_log_file_path");
    this.BRq.setImageResource(2131233419);
    this.BRr.setText(getString(2131764591));
    if ((BQz == null) || (com.tencent.mm.vfs.o.aZR(BQz) <= 0L))
    {
      AppMethodBeat.o(29704);
      return;
    }
    this.BRt = ((TextView)findViewById(2131304087));
    this.BRt.setText(getString(2131762546, new Object[] { BQz.replace("mnt/", "") }));
    findViewById(2131304087).setVisibility(0);
    findViewById(2131304578).setVisibility(0);
    this.BRo = ((Button)findViewById(2131304579));
    this.BRo.setVisibility(0);
    this.BRo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29701);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = new Intent("android.intent.action.SEND");
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("android.intent.extra.EMAIL", new String[] { "WeChat_Log@qq.com" });
        ((Intent)localObject).putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(NetworkDiagnoseReportUI.this));
        ((Intent)localObject).putExtra("android.intent.extra.STREAM", com.tencent.mm.sdk.platformtools.o.a(NetworkDiagnoseReportUI.this.getContext(), new k(NetworkDiagnoseReportUI.BQz)));
        ((Intent)localObject).setType("text/plain");
        paramAnonymousView = NetworkDiagnoseReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29701);
      }
    });
    this.BRp = ((Button)findViewById(2131306429));
    this.BRp.setVisibility(0);
    this.BRp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29702);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        if (!bu.isNullOrNil(NetworkDiagnoseReportUI.BQz))
        {
          localObject = new k(NetworkDiagnoseReportUI.BQz);
          if (((k)localObject).exists())
          {
            paramAnonymousView = new Intent("android.intent.action.VIEW");
            com.tencent.mm.sdk.platformtools.o.a(NetworkDiagnoseReportUI.this.getContext(), paramAnonymousView, (k)localObject, "text/plain");
            paramAnonymousView.addFlags(268435456);
            localObject = NetworkDiagnoseReportUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((NetworkDiagnoseReportUI)localObject).startActivity((Intent)paramAnonymousView.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI
 * JD-Core Version:    0.7.0.1
 */