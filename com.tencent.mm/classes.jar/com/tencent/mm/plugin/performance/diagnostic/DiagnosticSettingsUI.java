package com.tencent.mm.plugin.performance.diagnostic;

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
  private CheckBox MIT;
  private CheckBox MIU;
  private CheckBox MIV;
  private CheckBox MIW;
  private CheckBox MIX;
  private CheckBox MIY;
  private CheckBox MIZ;
  private CheckBox MJa;
  private EditText MJb;
  private EditText MJc;
  private EditText MJd;
  private EditText MJe;
  private EditText MJf;
  private EditText MJg;
  private EditText MJh;
  private Button MJi;
  private Button MJj;
  private CheckBox MJk;
  private CheckBox MJl;
  private CheckBox MJm;
  private CheckBox MJn;
  private CheckBox MJo;
  private EditText MJp;
  private EditText MJq;
  private EditText MJr;
  private EditText MJs;
  private Button MJt;
  private Button MJu;
  private com.tencent.mm.plugin.performance.diagnostic.b.a MJv;
  private com.tencent.mm.plugin.performance.diagnostic.c.a MJw;
  
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/performance/diagnostic/DiagnosticSettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i = paramView.getId();
    if (b.a.diag_bt_memory_confirm == i) {
      if (this.MIY.isChecked())
      {
        paramView = "all";
        localObject = new StringBuilder("<cmd><diagnostic><MemoryHook enable='");
        if (!this.MIT.isChecked()) {
          break label465;
        }
        i = 1;
        label81:
        paramView = ((StringBuilder)localObject).append(i).append("' process='").append(paramView).append("' source='push' duration='").append(Util.getInt(this.MJd.getText().toString(), 1)).append("' stacklog='").append(Util.getInt(this.MJh.getText().toString(), 52428800)).append("' hook='").append(this.MJb.getText().toString()).append("' ignore='").append(this.MJc.getText().toString()).append("' stack='");
        if (!this.MIU.isChecked()) {
          break label470;
        }
        i = 1;
        label194:
        paramView = paramView.append(i).append("' min='").append(Util.getInt(this.MJe.getText().toString(), 0)).append("' max='").append(Util.getInt(this.MJf.getText().toString(), 0)).append("' sampling='").append(Util.getDouble(this.MJg.getText().toString(), 1.0D)).append("' extreme='");
        if (!this.MIZ.isChecked()) {
          break label475;
        }
        i = 1;
        label283:
        paramView = paramView.append(i).append("' mmap='");
        if (!this.MJa.isChecked()) {
          break label480;
        }
        i = 1;
        label306:
        paramView = i + "'/></diagnostic></cmd>";
        Log.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", new Object[] { paramView });
        com.tencent.mm.plugin.performance.a.a.MIk.aRq(paramView);
        Toast.makeText(this, "MemoryHook:Confirmed, pls restart process", 0).show();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/performance/diagnostic/DiagnosticSettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(124912);
      return;
      localObject = new StringBuilder();
      if (this.MIV.isChecked())
      {
        paramView = "mm;";
        label392:
        localObject = ((StringBuilder)localObject).append(paramView);
        if (!this.MIW.isChecked()) {
          break label451;
        }
        paramView = "appbrand;";
        label412:
        localObject = ((StringBuilder)localObject).append(paramView);
        if (!this.MIX.isChecked()) {
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
        com.tencent.mm.plugin.performance.a.a.MIk.aK(XmlParser.parseXml("<cmd><diagnostic><report><MemoryHook/></report></diagnostic></cmd>", "cmd", null));
        Toast.makeText(this, "MemoryHook:Reported, pls run `logcat |grep MemoryHookLogic` for result", 0).show();
      }
      else
      {
        if (b.a.diag_bt_pthread_confirm == i)
        {
          if (this.MJo.isChecked())
          {
            paramView = "all";
            localObject = new StringBuilder("<cmd><diagnostic><PthreadHook enable='");
            if (!this.MJk.isChecked()) {
              break label798;
            }
          }
          label784:
          label791:
          label798:
          for (i = 1;; i = 0)
          {
            paramView = i + "' source='push' process='" + paramView + "' duration='" + Util.getInt(this.MJs.getText().toString(), 1) + "' hook='" + this.MJp.getText().toString() + "' ignore='" + this.MJq.getText().toString() + "' thread='" + this.MJr.getText().toString() + "'/></diagnostic></cmd>";
            Log.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", new Object[] { paramView });
            com.tencent.mm.plugin.performance.a.a.MIk.aRq(paramView);
            Toast.makeText(this, "PthreadHook:Confirmed, pls restart process", 0).show();
            break;
            localObject = new StringBuilder();
            if (this.MJl.isChecked())
            {
              paramView = "mm;";
              label725:
              localObject = ((StringBuilder)localObject).append(paramView);
              if (!this.MJm.isChecked()) {
                break label784;
              }
              paramView = "appbrand;";
              label745:
              localObject = ((StringBuilder)localObject).append(paramView);
              if (!this.MJn.isChecked()) {
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
          com.tencent.mm.plugin.performance.a.a.MIk.aRq("<cmd><diagnostic><report><PthreadHook/></report></diagnostic></cmd>");
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
    this.MJv = ((com.tencent.mm.plugin.performance.diagnostic.b.b)com.tencent.mm.plugin.performance.a.a.MIk.bX(com.tencent.mm.plugin.performance.diagnostic.b.b.class)).MKD;
    this.MJw = ((com.tencent.mm.plugin.performance.diagnostic.c.b)com.tencent.mm.plugin.performance.a.a.MIk.bX(com.tencent.mm.plugin.performance.diagnostic.c.b.class)).MKM;
    this.MIT = ((CheckBox)findViewById(b.a.diag_cb_memory_enable));
    this.MIU = ((CheckBox)findViewById(b.a.diag_cb_memory_stacktrace));
    this.MIV = ((CheckBox)findViewById(b.a.diag_cb_memory_process_mm));
    this.MIW = ((CheckBox)findViewById(b.a.diag_cb_memory_process_appbrand));
    this.MIX = ((CheckBox)findViewById(b.a.diag_cb_memory_process_tools));
    this.MIY = ((CheckBox)findViewById(b.a.diag_cb_memory_process_all));
    this.MIZ = ((CheckBox)findViewById(b.a.diag_cb_memory_extreme));
    this.MJa = ((CheckBox)findViewById(b.a.diag_cb_memory_mmap));
    this.MIV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(300917);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.a(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(300917);
      }
    });
    this.MIW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(300914);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.a(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(300914);
      }
    });
    this.MIX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(300913);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.a(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(300913);
      }
    });
    this.MIY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(300915);
        if (paramAnonymousBoolean)
        {
          DiagnosticSettingsUI.b(DiagnosticSettingsUI.this).setChecked(false);
          DiagnosticSettingsUI.c(DiagnosticSettingsUI.this).setChecked(false);
          DiagnosticSettingsUI.d(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(300915);
      }
    });
    this.MJb = ((EditText)findViewById(b.a.diag_et_memory_hook));
    this.MJc = ((EditText)findViewById(b.a.diag_et_memory_ignore));
    this.MJd = ((EditText)findViewById(b.a.diag_et_memory_duration));
    this.MJe = ((EditText)findViewById(b.a.diag_et_memory_min));
    this.MJf = ((EditText)findViewById(b.a.diag_et_memory_max));
    this.MJg = ((EditText)findViewById(b.a.diag_et_memory_sampling));
    this.MJh = ((EditText)findViewById(b.a.diag_et_memory_stack_log_threshold));
    this.MJi = ((Button)findViewById(b.a.diag_bt_memory_confirm));
    this.MJj = ((Button)findViewById(b.a.diag_bt_memory_report));
    this.MJi.setOnClickListener(this);
    this.MJj.setOnClickListener(this);
    this.MIT.setChecked(this.MJv.gyp());
    this.MIU.setChecked(this.MJv.gyK());
    this.MIV.setChecked(this.MJv.getTargetProcess().contains("mm"));
    this.MIW.setChecked(this.MJv.getTargetProcess().contains("appbrand"));
    this.MIX.setChecked(this.MJv.getTargetProcess().contains("tools"));
    this.MIY.setChecked(this.MJv.getTargetProcess().contains("all"));
    this.MIZ.setChecked(this.MJv.gyO());
    this.MJa.setChecked(this.MJv.gyP());
    this.MJb.setText(this.MJv.aRz(".*com\\.tencent\\.mm.*\\.so$"));
    this.MJc.setText(this.MJv.gyJ());
    this.MJd.setText(Long.toString(this.MJv.aft(1)));
    this.MJe.setText(Integer.toString(this.MJv.gyL()));
    this.MJf.setText(Integer.toString(this.MJv.gyM()));
    this.MJg.setText(Double.toString(this.MJv.gyN()));
    this.MJk = ((CheckBox)findViewById(b.a.diag_cb_pthread_enable));
    this.MJl = ((CheckBox)findViewById(b.a.diag_cb_pthread_process_mm));
    this.MJm = ((CheckBox)findViewById(b.a.diag_cb_pthread_process_appbrand));
    this.MJn = ((CheckBox)findViewById(b.a.diag_cb_pthread_process_tools));
    this.MJo = ((CheckBox)findViewById(b.a.diag_cb_pthread_process_all));
    this.MJp = ((EditText)findViewById(b.a.diag_et_pthread_hook_so));
    this.MJq = ((EditText)findViewById(b.a.diag_et_pthread_ignore_so));
    this.MJr = ((EditText)findViewById(b.a.diag_et_pthread_hook_thread_name));
    this.MJs = ((EditText)findViewById(b.a.diag_et_pthread_duration));
    this.MJt = ((Button)findViewById(b.a.diag_bt_pthread_confirm));
    this.MJu = ((Button)findViewById(b.a.diag_bt_pthread_report));
    this.MJl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(300916);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.e(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(300916);
      }
    });
    this.MJm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(300903);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.e(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(300903);
      }
    });
    this.MJn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(300898);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.e(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(300898);
      }
    });
    this.MJo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(300900);
        if (paramAnonymousBoolean)
        {
          DiagnosticSettingsUI.f(DiagnosticSettingsUI.this).setChecked(false);
          DiagnosticSettingsUI.g(DiagnosticSettingsUI.this).setChecked(false);
          DiagnosticSettingsUI.h(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(300900);
      }
    });
    this.MJk.setChecked(this.MJw.gyp());
    this.MJp.setText(this.MJw.aRz(".*\\.so$"));
    this.MJq.setText(this.MJw.gyJ());
    this.MJr.setText(this.MJw.aRA(".*"));
    this.MJs.setText(Integer.toString(this.MJw.aft(1)));
    this.MJl.setChecked(this.MJw.getTargetProcess().contains("mm"));
    this.MJm.setChecked(this.MJw.getTargetProcess().contains("appbrand"));
    this.MJn.setChecked(this.MJw.getTargetProcess().contains("tools"));
    this.MJo.setChecked(this.MJw.getTargetProcess().contains("all"));
    this.MJt.setOnClickListener(this);
    this.MJu.setOnClickListener(this);
    AppMethodBeat.o(124911);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI
 * JD-Core Version:    0.7.0.1
 */