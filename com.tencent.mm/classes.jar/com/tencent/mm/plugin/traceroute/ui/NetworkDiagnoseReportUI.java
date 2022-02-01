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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public class NetworkDiagnoseReportUI
  extends MMActivity
{
  private static String Bzb;
  private boolean BzP = false;
  private Button BzQ;
  private Button BzR;
  private ImageView BzS;
  private TextView BzT;
  private TextView BzU;
  private TextView BzV;
  
  public int getLayoutId()
  {
    return 2131495011;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29704);
    setMMTitle("");
    this.BzS = ((ImageView)findViewById(2131304086));
    this.BzT = ((TextView)findViewById(2131304089));
    this.BzU = ((TextView)findViewById(2131304088));
    this.BzP = getIntent().getBooleanExtra("diagnose_result", false);
    if (this.BzP)
    {
      this.BzS.setImageResource(2131233420);
      this.BzT.setText(getString(2131764592));
      this.BzU.setVisibility(0);
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
    Bzb = getIntent().getStringExtra("diagnose_log_file_path");
    this.BzS.setImageResource(2131233419);
    this.BzT.setText(getString(2131764591));
    if ((Bzb == null) || (i.aYo(Bzb) <= 0L))
    {
      AppMethodBeat.o(29704);
      return;
    }
    this.BzV = ((TextView)findViewById(2131304087));
    this.BzV.setText(getString(2131762546, new Object[] { Bzb.replace("mnt/", "") }));
    findViewById(2131304087).setVisibility(0);
    findViewById(2131304578).setVisibility(0);
    this.BzQ = ((Button)findViewById(2131304579));
    this.BzQ.setVisibility(0);
    this.BzQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29701);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        localObject = new Intent("android.intent.action.SEND");
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("android.intent.extra.EMAIL", new String[] { "WeChat_Log@qq.com" });
        ((Intent)localObject).putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(NetworkDiagnoseReportUI.this));
        ((Intent)localObject).putExtra("android.intent.extra.STREAM", n.a(NetworkDiagnoseReportUI.this.getContext(), new e(NetworkDiagnoseReportUI.Bzb)));
        ((Intent)localObject).setType("text/plain");
        paramAnonymousView = NetworkDiagnoseReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29701);
      }
    });
    this.BzR = ((Button)findViewById(2131306429));
    this.BzR.setVisibility(0);
    this.BzR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29702);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        if (!bt.isNullOrNil(NetworkDiagnoseReportUI.Bzb))
        {
          localObject = new e(NetworkDiagnoseReportUI.Bzb);
          if (((e)localObject).exists())
          {
            paramAnonymousView = new Intent("android.intent.action.VIEW");
            n.a(NetworkDiagnoseReportUI.this.getContext(), paramAnonymousView, (e)localObject, "text/plain");
            paramAnonymousView.addFlags(268435456);
            localObject = NetworkDiagnoseReportUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((NetworkDiagnoseReportUI)localObject).startActivity((Intent)paramAnonymousView.mq(0));
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