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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public class NetworkDiagnoseReportUI
  extends MMActivity
{
  private static String yTA;
  private boolean yUo = false;
  private Button yUp;
  private Button yUq;
  private ImageView yUr;
  private TextView yUs;
  private TextView yUt;
  private TextView yUu;
  
  public int getLayoutId()
  {
    return 2131495011;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29704);
    setMMTitle("");
    this.yUr = ((ImageView)findViewById(2131304086));
    this.yUs = ((TextView)findViewById(2131304089));
    this.yUt = ((TextView)findViewById(2131304088));
    this.yUo = getIntent().getBooleanExtra("diagnose_result", false);
    if (this.yUo)
    {
      this.yUr.setImageResource(2131233420);
      this.yUs.setText(getString(2131764592));
      this.yUt.setVisibility(0);
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
    yTA = getIntent().getStringExtra("diagnose_log_file_path");
    this.yUr.setImageResource(2131233419);
    this.yUs.setText(getString(2131764591));
    if ((yTA == null) || (i.aMN(yTA) <= 0L))
    {
      AppMethodBeat.o(29704);
      return;
    }
    this.yUu = ((TextView)findViewById(2131304087));
    this.yUu.setText(getString(2131762546, new Object[] { yTA.replace("mnt/", "") }));
    findViewById(2131304087).setVisibility(0);
    findViewById(2131304578).setVisibility(0);
    this.yUp = ((Button)findViewById(2131304579));
    this.yUp.setVisibility(0);
    this.yUp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29701);
        Object localObject = new Intent("android.intent.action.SEND");
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("android.intent.extra.EMAIL", new String[] { "WeChat_Log@qq.com" });
        ((Intent)localObject).putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(NetworkDiagnoseReportUI.this));
        ((Intent)localObject).putExtra("android.intent.extra.STREAM", m.a(NetworkDiagnoseReportUI.this.getContext(), new e(NetworkDiagnoseReportUI.yTA)));
        ((Intent)localObject).setType("text/plain");
        paramAnonymousView = NetworkDiagnoseReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(29701);
      }
    });
    this.yUq = ((Button)findViewById(2131306429));
    this.yUq.setVisibility(0);
    this.yUq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29702);
        if (!bt.isNullOrNil(NetworkDiagnoseReportUI.yTA))
        {
          Object localObject = new e(NetworkDiagnoseReportUI.yTA);
          if (((e)localObject).exists())
          {
            paramAnonymousView = new Intent("android.intent.action.VIEW");
            m.a(NetworkDiagnoseReportUI.this.getContext(), paramAnonymousView, (e)localObject, "text/plain");
            paramAnonymousView.addFlags(268435456);
            localObject = NetworkDiagnoseReportUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((NetworkDiagnoseReportUI)localObject).startActivity((Intent)paramAnonymousView.lS(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI
 * JD-Core Version:    0.7.0.1
 */