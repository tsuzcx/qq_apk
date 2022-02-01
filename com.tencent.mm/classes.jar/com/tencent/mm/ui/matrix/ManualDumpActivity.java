package com.tencent.mm.ui.matrix;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.resource.b.a.b;
import com.tencent.matrix.resource.c;
import com.tencent.matrix.resource.processor.ManualDumpProcessor;
import com.tencent.matrix.resource.processor.ManualDumpProcessor.ManualDumpProcessorHelper;
import com.tencent.matrix.resource.processor.ManualDumpProcessor.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.b.r;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.vfs.q;

public class ManualDumpActivity
  extends MMActivity
  implements View.OnLongClickListener
{
  private String XKA;
  private TextView XKB;
  private TextView XKC;
  private TextView XKD;
  private TextView XKE;
  private String XKy;
  String XKz;
  
  public ManualDumpActivity()
  {
    AppMethodBeat.i(38869);
    AppMethodBeat.o(38869);
  }
  
  public static void XT()
  {
    AppMethodBeat.i(290795);
    Log.v("MicroMsg.ManualDumpActivity", "triggering gc...");
    Runtime.getRuntime().gc();
    try
    {
      Thread.sleep(100L);
      label24:
      Runtime.getRuntime().runFinalization();
      Log.v("MicroMsg.ManualDumpActivity", "gc was triggered.");
      AppMethodBeat.o(290795);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label24;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.eiu;
  }
  
  public void mute(View paramView)
  {
    AppMethodBeat.i(290792);
    paramView = (c)com.tencent.matrix.b.Vu().Y(c.class);
    if (paramView == null)
    {
      AppMethodBeat.o(290792);
      return;
    }
    paramView = paramView.daQ;
    if (paramView == null)
    {
      AppMethodBeat.o(290792);
      return;
    }
    paramView = paramView.dej;
    if (!(paramView instanceof ManualDumpProcessor))
    {
      AppMethodBeat.o(290792);
      return;
    }
    ((ManualDumpProcessor)paramView).ddS = true;
    com.tencent.mm.plugin.report.service.h.IzE.a(18573, new Object[] { this.XKz, "mute", Integer.valueOf(0), Integer.valueOf(14), Integer.valueOf(0), BuildInfo.BUILD_TAG, BuildInfo.REV });
    Toast.makeText(this, "won't notify you util reboot", 0).show();
    AppMethodBeat.o(290792);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(38871);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(38871);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38870);
    super.onCreate(paramBundle);
    paramBundle = "Activity Leak";
    if (BuildInfo.DEBUG) {
      paramBundle = "Activity Leak" + "(debug)";
    }
    for (;;)
    {
      setMMTitle(paramBundle);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38863);
          ManualDumpActivity.this.finish();
          AppMethodBeat.o(38863);
          return true;
        }
      });
      this.XKD = ((TextView)findViewById(R.h.dLa));
      this.XKC = ((TextView)findViewById(R.h.dIx));
      this.XKB = ((TextView)findViewById(R.h.dLb));
      this.XKE = ((TextView)findViewById(R.h.dLc));
      this.XKD.setOnLongClickListener(this);
      this.XKC.setOnLongClickListener(this);
      this.XKB.setOnLongClickListener(this);
      this.XKz = getIntent().getStringExtra("activity");
      this.XKy = getIntent().getStringExtra("ref_key");
      this.XKA = getIntent().getStringExtra("leak_process");
      this.XKD.setText(this.XKz);
      paramBundle = (c)com.tencent.matrix.b.Vu().Y(c.class);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.daP;
        paramBundle = "fgCycle:" + paramBundle.XE() + " ms, \nbgCycle:" + paramBundle.XF() + " ms, \ndetect times:" + paramBundle.XG() + "\nyour activity has leaked for more than " + paramBundle.XE() * paramBundle.XG() / 1000.0D / 60.0D + " minutes\n";
        this.XKE.setText(paramBundle);
      }
      Log.i("MicroMsg.ManualDumpActivity", "onCreate:mLeakedActivity:%s, mRefString:%s, mLeakProcess:%s", new Object[] { this.XKz, this.XKy, this.XKA });
      AppMethodBeat.o(38870);
      return;
      if (WeChatEnvironment.hasDebugger()) {
        paramBundle = "Activity Leak" + "(coolassist)";
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(290791);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/matrix/ManualDumpActivity", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    if ((paramView instanceof TextView))
    {
      ClipboardHelper.setText(((TextView)paramView).getText().toString());
      com.tencent.mm.ui.base.h.cO(this, getString(R.l.app_copy_ok));
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/matrix/ManualDumpActivity", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(290791);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(290790);
    super.onResume();
    com.tencent.e.h.ZvG.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(212495);
        ManualDumpActivity localManualDumpActivity = ManualDumpActivity.this;
        Object localObject = (c)com.tencent.matrix.b.Vu().Y(c.class);
        if (localObject == null)
        {
          Log.e("MicroMsg.ManualDumpActivity", "plugin == null");
          Toast.makeText(localManualDumpActivity, "plugin == null", 0).show();
          AppMethodBeat.o(212495);
          return;
        }
        if (((c)localObject).daQ == null)
        {
          Log.e("MicroMsg.ManualDumpActivity", "watcher == null");
          Toast.makeText(localManualDumpActivity, "watcher == null", 0).show();
          AppMethodBeat.o(212495);
          return;
        }
        localObject = ((c)localObject).daP.dcD;
        if (localObject != a.b.dcK)
        {
          Log.e("MicroMsg.ManualDumpActivity", "current dump mode [%s] is not MANUAL_DUMP", new Object[] { ((a.b)localObject).name() });
          Toast.makeText(localManualDumpActivity, "current dump mode [" + ((a.b)localObject).name() + "] is not MANUAL_DUMP, pls confirm that you are in the debug/coolassist env.", 1).show();
          AppMethodBeat.o(212495);
          return;
        }
        localObject = s.a(localManualDumpActivity, "dumping...", false, 0, null);
        long l = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.IzE.a(18573, new Object[] { localManualDumpActivity.XKz, "clicked", Integer.valueOf(0), Integer.valueOf(11), Integer.valueOf(0), BuildInfo.BUILD_TAG, BuildInfo.REV });
        com.tencent.e.h.ZvG.o(new ManualDumpActivity.3(localManualDumpActivity, l, (ProgressDialog)localObject), 500L);
        AppMethodBeat.o(212495);
      }
    }, 500L);
    AppMethodBeat.o(290790);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void share(final View paramView)
  {
    AppMethodBeat.i(290794);
    paramView = s.a(this, "compressing...", false, 0, null);
    com.tencent.e.h.ZvG.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(242214);
        String str1 = ManualDumpActivity.d(ManualDumpActivity.this).getText().toString();
        final String str2 = str1 + ".zip";
        r.a(new q(str1), str2);
        com.tencent.e.h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249115);
            ManualDumpActivity.4.this.ucb.dismiss();
            ManualDumpActivity.a(ManualDumpActivity.this, str2);
            AppMethodBeat.o(249115);
          }
        });
        AppMethodBeat.o(242214);
      }
    }, "MicroMsg.ManualDumpActivity");
    AppMethodBeat.o(290794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.ManualDumpActivity
 * JD-Core Version:    0.7.0.1
 */