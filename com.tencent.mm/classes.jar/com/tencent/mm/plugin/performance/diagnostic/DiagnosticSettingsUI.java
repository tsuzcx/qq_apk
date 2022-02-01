package com.tencent.mm.plugin.performance.diagnostic;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.b.a;
import com.tencent.mm.plugin.performance.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;

public class DiagnosticSettingsUI
  extends MMActivity
  implements View.OnClickListener
{
  private CheckBox GLX;
  private CheckBox GLY;
  private CheckBox GLZ;
  private com.tencent.mm.plugin.performance.diagnostic.c.a GMA;
  private CheckBox GMa;
  private CheckBox GMb;
  private CheckBox GMc;
  private CheckBox GMd;
  private CheckBox GMe;
  private EditText GMf;
  private EditText GMg;
  private EditText GMh;
  private EditText GMi;
  private EditText GMj;
  private EditText GMk;
  private EditText GMl;
  private Button GMm;
  private Button GMn;
  private CheckBox GMo;
  private CheckBox GMp;
  private CheckBox GMq;
  private CheckBox GMr;
  private CheckBox GMs;
  private EditText GMt;
  private EditText GMu;
  private EditText GMv;
  private EditText GMw;
  private Button GMx;
  private Button GMy;
  private com.tencent.mm.plugin.performance.diagnostic.b.a GMz;
  
  public DiagnosticSettingsUI()
  {
    AppMethodBeat.i(124910);
    AppMethodBeat.o(124910);
  }
  
  public int getLayoutId()
  {
    return b.b.diagnostic_setttings_ui;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(124912);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/performance/diagnostic/DiagnosticSettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i = paramView.getId();
    if (b.a.diag_bt_memory_confirm == i) {
      if (this.GMc.isChecked())
      {
        paramView = "all";
        localObject = new StringBuilder("<cmd><diagnostic><MemoryHook enable='");
        if (!this.GLX.isChecked()) {
          break label465;
        }
        i = 1;
        label81:
        paramView = ((StringBuilder)localObject).append(i).append("' process='").append(paramView).append("' source='push' duration='").append(Util.getInt(this.GMh.getText().toString(), 1)).append("' stacklog='").append(Util.getInt(this.GMl.getText().toString(), 52428800)).append("' hook='").append(this.GMf.getText().toString()).append("' ignore='").append(this.GMg.getText().toString()).append("' stack='");
        if (!this.GLY.isChecked()) {
          break label470;
        }
        i = 1;
        label194:
        paramView = paramView.append(i).append("' min='").append(Util.getInt(this.GMi.getText().toString(), 0)).append("' max='").append(Util.getInt(this.GMj.getText().toString(), 0)).append("' sampling='").append(Util.getDouble(this.GMk.getText().toString(), 1.0D)).append("' extreme='");
        if (!this.GMd.isChecked()) {
          break label475;
        }
        i = 1;
        label283:
        paramView = paramView.append(i).append("' mmap='");
        if (!this.GMe.isChecked()) {
          break label480;
        }
        i = 1;
        label306:
        paramView = i + "'/></diagnostic></cmd>";
        Log.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", new Object[] { paramView });
        com.tencent.mm.plugin.performance.a.a.GLp.aUm(paramView);
        Toast.makeText(this, "MemoryHook:Confirmed, pls restart process", 0).show();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/performance/diagnostic/DiagnosticSettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(124912);
      return;
      localObject = new StringBuilder();
      if (this.GLZ.isChecked())
      {
        paramView = "mm;";
        label392:
        localObject = ((StringBuilder)localObject).append(paramView);
        if (!this.GMa.isChecked()) {
          break label451;
        }
        paramView = "appbrand;";
        label412:
        localObject = ((StringBuilder)localObject).append(paramView);
        if (!this.GMb.isChecked()) {
          break label458;
        }
      }
      label451:
      label458:
      for (paramView = "tools;";; paramView = "")
      {
        paramView = paramView;
        break;
        paramView = "";
        break label392;
        paramView = "";
        break label412;
      }
      label465:
      i = 0;
      break label81;
      label470:
      i = 0;
      break label194;
      label475:
      i = 0;
      break label283;
      label480:
      i = 0;
      break label306;
      if (b.a.diag_bt_memory_report == i)
      {
        com.tencent.mm.plugin.performance.a.a.GLp.au(XmlParser.parseXml("<cmd><diagnostic><report><MemoryHook/></report></diagnostic></cmd>", "cmd", null));
        Toast.makeText(this, "MemoryHook:Reported, pls run `logcat |grep MemoryHookLogic` for result", 0).show();
      }
      else
      {
        if (b.a.diag_bt_pthread_confirm == i)
        {
          if (this.GMs.isChecked())
          {
            paramView = "all";
            localObject = new StringBuilder("<cmd><diagnostic><PthreadHook enable='");
            if (!this.GMo.isChecked()) {
              break label798;
            }
          }
          label784:
          label791:
          label798:
          for (i = 1;; i = 0)
          {
            paramView = i + "' source='push' process='" + paramView + "' duration='" + Util.getInt(this.GMw.getText().toString(), 1) + "' hook='" + this.GMt.getText().toString() + "' ignore='" + this.GMu.getText().toString() + "' thread='" + this.GMv.getText().toString() + "'/></diagnostic></cmd>";
            Log.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", new Object[] { paramView });
            com.tencent.mm.plugin.performance.a.a.GLp.aUm(paramView);
            Toast.makeText(this, "PthreadHook:Confirmed, pls restart process", 0).show();
            break;
            localObject = new StringBuilder();
            if (this.GMp.isChecked())
            {
              paramView = "mm;";
              label725:
              localObject = ((StringBuilder)localObject).append(paramView);
              if (!this.GMq.isChecked()) {
                break label784;
              }
              paramView = "appbrand;";
              label745:
              localObject = ((StringBuilder)localObject).append(paramView);
              if (!this.GMr.isChecked()) {
                break label791;
              }
            }
            for (paramView = "tools;";; paramView = "")
            {
              paramView = paramView;
              break;
              paramView = "";
              break label725;
              paramView = "";
              break label745;
            }
          }
        }
        if (b.a.diag_bt_pthread_report == i)
        {
          com.tencent.mm.plugin.performance.a.a.GLp.aUm("<cmd><diagnostic><report><PthreadHook/></report></diagnostic></cmd>");
          Toast.makeText(this, "PthreadHook:Reported, pls run `logcat |grep PthreadHookLogic` for result", 0).show();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(124911);
    getWindow().setSoftInputMode(32);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(124909);
        DiagnosticSettingsUI.this.finish();
        AppMethodBeat.o(124909);
        return true;
      }
    });
    setMMTitle("诊断模式");
    this.GMz = ((com.tencent.mm.plugin.performance.diagnostic.b.b)com.tencent.mm.plugin.performance.a.a.GLp.bn(com.tencent.mm.plugin.performance.diagnostic.b.b.class)).GNl;
    this.GMA = ((com.tencent.mm.plugin.performance.diagnostic.c.b)com.tencent.mm.plugin.performance.a.a.GLp.bn(com.tencent.mm.plugin.performance.diagnostic.c.b.class)).GNu;
    this.GLX = ((CheckBox)findViewById(b.a.diag_cb_memory_enable));
    this.GLY = ((CheckBox)findViewById(b.a.diag_cb_memory_stacktrace));
    this.GLZ = ((CheckBox)findViewById(b.a.diag_cb_memory_process_mm));
    this.GMa = ((CheckBox)findViewById(b.a.diag_cb_memory_process_appbrand));
    this.GMb = ((CheckBox)findViewById(b.a.diag_cb_memory_process_tools));
    this.GMc = ((CheckBox)findViewById(b.a.diag_cb_memory_process_all));
    this.GMd = ((CheckBox)findViewById(b.a.diag_cb_memory_extreme));
    this.GMe = ((CheckBox)findViewById(b.a.diag_cb_memory_mmap));
    this.GLZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201756);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.a(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(201756);
      }
    });
    this.GMa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(200869);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.a(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(200869);
      }
    });
    this.GMb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201243);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.a(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(201243);
      }
    });
    this.GMc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201329);
        if (paramAnonymousBoolean)
        {
          DiagnosticSettingsUI.b(DiagnosticSettingsUI.this).setChecked(false);
          DiagnosticSettingsUI.c(DiagnosticSettingsUI.this).setChecked(false);
          DiagnosticSettingsUI.d(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(201329);
      }
    });
    this.GMf = ((EditText)findViewById(b.a.diag_et_memory_hook));
    this.GMg = ((EditText)findViewById(b.a.diag_et_memory_ignore));
    this.GMh = ((EditText)findViewById(b.a.diag_et_memory_duration));
    this.GMi = ((EditText)findViewById(b.a.diag_et_memory_min));
    this.GMj = ((EditText)findViewById(b.a.diag_et_memory_max));
    this.GMk = ((EditText)findViewById(b.a.diag_et_memory_sampling));
    this.GMl = ((EditText)findViewById(b.a.diag_et_memory_stack_log_threshold));
    this.GMm = ((Button)findViewById(b.a.diag_bt_memory_confirm));
    this.GMn = ((Button)findViewById(b.a.diag_bt_memory_report));
    this.GMm.setOnClickListener(this);
    this.GMn.setOnClickListener(this);
    this.GLX.setChecked(this.GMz.fnB());
    this.GLY.setChecked(this.GMz.fnO());
    this.GLZ.setChecked(this.GMz.getTargetProcess().contains("mm"));
    this.GMa.setChecked(this.GMz.getTargetProcess().contains("appbrand"));
    this.GMb.setChecked(this.GMz.getTargetProcess().contains("tools"));
    this.GMc.setChecked(this.GMz.getTargetProcess().contains("all"));
    this.GMd.setChecked(this.GMz.fnS());
    this.GMe.setChecked(this.GMz.fnT());
    this.GMf.setText(this.GMz.aUr(".*com\\.tencent\\.mm.*\\.so$"));
    this.GMg.setText(this.GMz.fnN());
    this.GMh.setText(Long.toString(this.GMz.aba(1)));
    this.GMi.setText(Integer.toString(this.GMz.fnP()));
    this.GMj.setText(Integer.toString(this.GMz.fnQ()));
    this.GMk.setText(Double.toString(this.GMz.fnR()));
    this.GMo = ((CheckBox)findViewById(b.a.diag_cb_pthread_enable));
    this.GMp = ((CheckBox)findViewById(b.a.diag_cb_pthread_process_mm));
    this.GMq = ((CheckBox)findViewById(b.a.diag_cb_pthread_process_appbrand));
    this.GMr = ((CheckBox)findViewById(b.a.diag_cb_pthread_process_tools));
    this.GMs = ((CheckBox)findViewById(b.a.diag_cb_pthread_process_all));
    this.GMt = ((EditText)findViewById(b.a.diag_et_pthread_hook_so));
    this.GMu = ((EditText)findViewById(b.a.diag_et_pthread_ignore_so));
    this.GMv = ((EditText)findViewById(b.a.diag_et_pthread_hook_thread_name));
    this.GMw = ((EditText)findViewById(b.a.diag_et_pthread_duration));
    this.GMx = ((Button)findViewById(b.a.diag_bt_pthread_confirm));
    this.GMy = ((Button)findViewById(b.a.diag_bt_pthread_report));
    this.GMp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(200606);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.e(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(200606);
      }
    });
    this.GMq.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(202379);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.e(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(202379);
      }
    });
    this.GMr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201629);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.e(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(201629);
      }
    });
    this.GMs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(200576);
        if (paramAnonymousBoolean)
        {
          DiagnosticSettingsUI.f(DiagnosticSettingsUI.this).setChecked(false);
          DiagnosticSettingsUI.g(DiagnosticSettingsUI.this).setChecked(false);
          DiagnosticSettingsUI.h(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(200576);
      }
    });
    this.GMo.setChecked(this.GMA.fnB());
    this.GMt.setText(this.GMA.aUr(".*\\.so$"));
    this.GMu.setText(this.GMA.fnN());
    this.GMv.setText(this.GMA.aUs(".*"));
    this.GMw.setText(Integer.toString(this.GMA.aba(1)));
    this.GMp.setChecked(this.GMA.getTargetProcess().contains("mm"));
    this.GMq.setChecked(this.GMA.getTargetProcess().contains("appbrand"));
    this.GMr.setChecked(this.GMA.getTargetProcess().contains("tools"));
    this.GMs.setChecked(this.GMA.getTargetProcess().contains("all"));
    this.GMx.setOnClickListener(this);
    this.GMy.setOnClickListener(this);
    AppMethodBeat.o(124911);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI
 * JD-Core Version:    0.7.0.1
 */