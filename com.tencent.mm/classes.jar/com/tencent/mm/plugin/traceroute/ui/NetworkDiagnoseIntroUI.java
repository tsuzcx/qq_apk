package com.tencent.mm.plugin.traceroute.ui;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;

public class NetworkDiagnoseIntroUI
  extends MMActivity
{
  private Button TRq;
  private TextView TRr;
  
  public int getLayoutId()
  {
    return R.i.gmu;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29698);
    this.TRq = ((Button)findViewById(R.h.fYa));
    this.TRq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29694);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        bh.bCz();
        if (!c.isSDCardAvailable())
        {
          aa.j(NetworkDiagnoseIntroUI.this, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29694);
          return;
        }
        if (bh.aZW().bFQ() == 0)
        {
          Toast.makeText(NetworkDiagnoseIntroUI.this, NetworkDiagnoseIntroUI.this.getString(R.l.fmt_iap_err), 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29694);
          return;
        }
        localObject = new Intent(NetworkDiagnoseIntroUI.this, NetworkDiagnoseUI.class);
        paramAnonymousView = NetworkDiagnoseIntroUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        NetworkDiagnoseIntroUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29694);
      }
    });
    this.TRr = ((TextView)findViewById(R.h.fPo));
    this.TRr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29695);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("title", NetworkDiagnoseIntroUI.this.getString(R.l.privacy_tip));
        paramAnonymousView.putExtra("rawUrl", NetworkDiagnoseIntroUI.this.getString(R.l.url_agreement, new Object[] { LocaleUtil.getApplicationLanguage(), LocaleUtil.getCurrentCountryCode() }));
        paramAnonymousView.putExtra("showShare", false);
        com.tencent.mm.plugin.traceroute.a.a.pFn.h(paramAnonymousView, NetworkDiagnoseIntroUI.this.getContext());
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