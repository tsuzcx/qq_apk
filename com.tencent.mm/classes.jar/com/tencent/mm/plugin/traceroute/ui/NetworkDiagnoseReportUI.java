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
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public class NetworkDiagnoseReportUI
  extends MMActivity
{
  private static String Grg;
  private boolean GrV = false;
  private Button GrW;
  private Button GrX;
  private ImageView GrY;
  private TextView GrZ;
  private TextView Gsa;
  private TextView Gsb;
  
  public int getLayoutId()
  {
    return 2131495841;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29704);
    setMMTitle("");
    this.GrY = ((ImageView)findViewById(2131306952));
    this.GrZ = ((TextView)findViewById(2131306955));
    this.Gsa = ((TextView)findViewById(2131306954));
    this.GrV = getIntent().getBooleanExtra("diagnose_result", false);
    if (this.GrV)
    {
      this.GrY.setImageResource(2131234222);
      this.GrZ.setText(getString(2131766950));
      this.Gsa.setVisibility(0);
      addTextOptionMenu(0, getString(2131758311), new MenuItem.OnMenuItemClickListener()
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
    Grg = getIntent().getStringExtra("diagnose_log_file_path");
    this.GrY.setImageResource(2131234221);
    this.GrZ.setText(getString(2131766949));
    if ((Grg == null) || (s.boW(Grg) <= 0L))
    {
      AppMethodBeat.o(29704);
      return;
    }
    this.Gsb = ((TextView)findViewById(2131306953));
    this.Gsb.setText(getString(2131764613, new Object[] { Grg.replace("mnt/", "") }));
    findViewById(2131306953).setVisibility(0);
    findViewById(2131307620).setVisibility(0);
    this.GrW = ((Button)findViewById(2131307624));
    this.GrW.setVisibility(0);
    this.GrW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29701);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = new Intent("android.intent.action.SEND");
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("android.intent.extra.EMAIL", new String[] { "WeChat_Log@qq.com" });
        ((Intent)localObject).putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(NetworkDiagnoseReportUI.this));
        ((Intent)localObject).putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(NetworkDiagnoseReportUI.this.getContext(), new o(NetworkDiagnoseReportUI.Grg)));
        ((Intent)localObject).setType("text/plain");
        paramAnonymousView = NetworkDiagnoseReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29701);
      }
    });
    this.GrX = ((Button)findViewById(2131309861));
    this.GrX.setVisibility(0);
    this.GrX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29702);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if (!Util.isNullOrNil(NetworkDiagnoseReportUI.Grg))
        {
          localObject = new o(NetworkDiagnoseReportUI.Grg);
          if (((o)localObject).exists())
          {
            paramAnonymousView = new Intent("android.intent.action.VIEW");
            FileProviderHelper.setIntentDataAndType(NetworkDiagnoseReportUI.this.getContext(), paramAnonymousView, (o)localObject, "text/plain", false);
            paramAnonymousView.addFlags(268435456);
            localObject = NetworkDiagnoseReportUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((NetworkDiagnoseReportUI)localObject).startActivity((Intent)paramAnonymousView.pG(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI
 * JD-Core Version:    0.7.0.1
 */