package com.tencent.mm.ui.matrix;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.resource.b.a.b;
import com.tencent.matrix.resource.processor.ManualDumpProcessor;
import com.tencent.matrix.resource.processor.ManualDumpProcessor.ManualDumpData;
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
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.i;

public class ManualDumpActivity
  extends MMActivity
  implements View.OnLongClickListener
{
  private String afxm;
  private String afxn;
  private String afxo;
  private TextView afxp;
  private TextView afxq;
  private TextView afxr;
  private TextView afxs;
  private a afxt;
  
  public ManualDumpActivity()
  {
    AppMethodBeat.i(38869);
    this.afxt = a.afxx;
    AppMethodBeat.o(38869);
  }
  
  public int getLayoutId()
  {
    return R.i.glt;
  }
  
  public void mute(View paramView)
  {
    AppMethodBeat.i(249812);
    paramView = (com.tencent.matrix.resource.c)com.tencent.matrix.c.avW().ai(com.tencent.matrix.resource.c.class);
    if (paramView == null)
    {
      AppMethodBeat.o(249812);
      return;
    }
    paramView = paramView.eZq;
    if (paramView == null)
    {
      AppMethodBeat.o(249812);
      return;
    }
    paramView = paramView.fcU;
    if (!(paramView instanceof ManualDumpProcessor))
    {
      AppMethodBeat.o(249812);
      return;
    }
    ((ManualDumpProcessor)paramView).fcC = true;
    Toast.makeText(this, "won't notify you util reboot", 0).show();
    if (this.afxt == a.afxx) {
      this.afxt = a.afxz;
    }
    AppMethodBeat.o(249812);
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
      this.afxr = ((TextView)findViewById(R.h.fMD));
      this.afxq = ((TextView)findViewById(R.h.fJP));
      this.afxp = ((TextView)findViewById(R.h.fME));
      this.afxs = ((TextView)findViewById(R.h.fMF));
      this.afxr.setOnLongClickListener(this);
      this.afxq.setOnLongClickListener(this);
      this.afxp.setOnLongClickListener(this);
      this.afxn = getIntent().getStringExtra("activity");
      this.afxm = getIntent().getStringExtra("ref_key");
      this.afxo = getIntent().getStringExtra("leak_process");
      this.afxr.setText(this.afxn);
      paramBundle = (com.tencent.matrix.resource.c)com.tencent.matrix.c.avW().ai(com.tencent.matrix.resource.c.class);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.eZp;
        paramBundle = "fgCycle:" + paramBundle.azk() + " ms, \nbgCycle:" + paramBundle.azl() + " ms, \ndetect times:" + paramBundle.azm() + "\nyour activity has leaked for more than " + paramBundle.azk() * paramBundle.azm() / 1000.0D / 60.0D + " minutes\n";
        this.afxs.setText(paramBundle);
      }
      Log.i("MicroMsg.ManualDumpActivity", "onCreate:mLeakedActivity:%s, mRefString:%s, mLeakProcess:%s", new Object[] { this.afxn, this.afxm, this.afxo });
      paramBundle = (ManualDumpProcessor.ManualDumpData)getIntent().getParcelableExtra("dump_data");
      localObject = (com.tencent.matrix.resource.c)com.tencent.matrix.c.avW().ai(com.tencent.matrix.resource.c.class);
      if (localObject != null) {
        break;
      }
      Log.e("MicroMsg.ManualDumpActivity", "plugin == null");
      Toast.makeText(this, "plugin == null", 0).show();
      AppMethodBeat.o(38870);
      return;
      if (WeChatEnvironment.hasDebugger()) {
        paramBundle = "Activity Leak" + "(coolassist)";
      }
    }
    if (((com.tencent.matrix.resource.c)localObject).eZq == null)
    {
      Log.e("MicroMsg.ManualDumpActivity", "watcher == null");
      Toast.makeText(this, "watcher == null", 0).show();
      AppMethodBeat.o(38870);
      return;
    }
    Object localObject = ((com.tencent.matrix.resource.c)localObject).eZp.fbd;
    if (localObject != a.b.fbl)
    {
      Log.e("MicroMsg.ManualDumpActivity", "current dump mode [%s] is not MANUAL_DUMP", new Object[] { ((a.b)localObject).name() });
      Toast.makeText(this, "current dump mode [" + ((a.b)localObject).name() + "] is not MANUAL_DUMP, pls confirm that you are in the debug/coolassist env.", 1).show();
      AppMethodBeat.o(38870);
      return;
    }
    System.currentTimeMillis();
    if (paramBundle != null)
    {
      localObject = paramBundle.fcI;
      paramBundle = paramBundle.fcJ;
      Log.i("MicroMsg.ManualDumpActivity", "dump success! leak process = %s, leak activity = %s, leak instance = %s", new Object[] { this.afxo, this.afxn, this.afxm });
      Log.i("MicroMsg.ManualDumpActivity", "dump success! hprof = %s", new Object[] { localObject });
      Log.i("MicroMsg.ManualDumpActivity", "dump success! refChain = %s", new Object[] { paramBundle });
      this.afxq.setText((CharSequence)localObject);
      localObject = this.afxp;
      if (paramBundle == null) {}
      for (paramBundle = "reference is null, pls pull hprof.";; paramBundle = paramBundle.replace(";", ";\n"))
      {
        ((TextView)localObject).setText(paramBundle);
        AppMethodBeat.o(38870);
        return;
      }
    }
    Log.e("MicroMsg.ManualDumpActivity", "analyze failed");
    Toast.makeText(this, "analyze failed", 0).show();
    AppMethodBeat.o(38870);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(249801);
    super.onDestroy();
    a locala = this.afxt;
    com.tencent.mm.plugin.report.service.h.OAn.b(18573, new Object[] { locala.getContent(), String.valueOf(locala.getId()), "0", Integer.valueOf(18), Integer.valueOf(0), BuildInfo.BUILD_TAG, BuildInfo.REV });
    AppMethodBeat.o(249801);
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(249807);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/matrix/ManualDumpActivity", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    if ((paramView instanceof TextView))
    {
      ClipboardHelper.setText(((TextView)paramView).getText().toString());
      k.cZ(this, getString(R.l.app_copy_ok));
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/matrix/ManualDumpActivity", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(249807);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(249803);
    super.onResume();
    AppMethodBeat.o(249803);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void share(final View paramView)
  {
    AppMethodBeat.i(249816);
    paramView = w.a(this, "compressing...", false, 0, null);
    com.tencent.threadpool.h.ahAA.i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249791);
        String str1 = ManualDumpActivity.a(ManualDumpActivity.this).getText().toString();
        final String str2 = str1 + ".zip";
        r.a(new u(str1), str2);
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249789);
            ManualDumpActivity.2.this.xif.dismiss();
            ManualDumpActivity.a(ManualDumpActivity.this, str2);
            AppMethodBeat.o(249789);
          }
        });
        AppMethodBeat.o(249791);
      }
    }, "MicroMsg.ManualDumpActivity");
    if (this.afxt == a.afxx) {
      this.afxt = a.afxy;
    }
    AppMethodBeat.o(249816);
  }
  
  static abstract enum a
  {
    private a() {}
    
    abstract String getContent();
    
    abstract int getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.ManualDumpActivity
 * JD-Core Version:    0.7.0.1
 */