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
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.ui.MMActivity;

public class DiagnosticSettingsUI
  extends MMActivity
  implements View.OnClickListener
{
  private Button wWA;
  private ay wWe;
  private CheckBox wWf;
  private CheckBox wWg;
  private CheckBox wWh;
  private CheckBox wWi;
  private CheckBox wWj;
  private CheckBox wWk;
  private EditText wWl;
  private EditText wWm;
  private EditText wWn;
  private EditText wWo;
  private EditText wWp;
  private EditText wWq;
  private Button wWr;
  private Button wWs;
  private CheckBox wWt;
  private CheckBox wWu;
  private EditText wWv;
  private EditText wWw;
  private EditText wWx;
  private EditText wWy;
  private Button wWz;
  
  public DiagnosticSettingsUI()
  {
    AppMethodBeat.i(124910);
    this.wWe = ay.aRW("diagnostic_storage");
    AppMethodBeat.o(124910);
  }
  
  public int getLayoutId()
  {
    return 2131493707;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(124912);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/performance/diagnostic/DiagnosticSettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    int i = paramView.getId();
    if (2131299073 == i)
    {
      paramView = new StringBuilder("<cmd><diagnostic><MemoryHook enable='");
      if (this.wWf.isChecked())
      {
        i = 1;
        paramView = paramView.append(i).append("' multiprocess='");
        if (!this.wWi.isChecked()) {
          break label380;
        }
        i = 1;
        label90:
        paramView = paramView.append(i).append("' duration='").append(bu.getInt(this.wWn.getText().toString(), 1)).append("' hook='").append(this.wWl.getText().toString()).append("' ignore='").append(this.wWm.getText().toString()).append("' stack='");
        if (!this.wWg.isChecked()) {
          break label385;
        }
        i = 1;
        label171:
        paramView = paramView.append(i).append("' min='").append(bu.getInt(this.wWo.getText().toString(), 0)).append("' max='").append(bu.getInt(this.wWp.getText().toString(), 0)).append("' force='");
        if (!this.wWh.isChecked()) {
          break label390;
        }
        i = 1;
        label238:
        paramView = paramView.append(i).append("' sampling='").append(bu.getDouble(this.wWq.getText().toString(), 1.0D)).append("' extreme='");
        if (!this.wWj.isChecked()) {
          break label395;
        }
        i = 1;
        label283:
        paramView = paramView.append(i).append("' mmap='");
        if (!this.wWk.isChecked()) {
          break label400;
        }
        i = 1;
        label306:
        paramView = i + "'/></diagnostic></cmd>";
        ae.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", new Object[] { paramView });
        com.tencent.mm.plugin.performance.a.a.wWa.aA(bx.M(paramView, "cmd"));
        Toast.makeText(this, "MemoryHook:Confirmed, pls restart process", 0).show();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/performance/diagnostic/DiagnosticSettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(124912);
      return;
      i = 0;
      break;
      label380:
      i = 0;
      break label90;
      label385:
      i = 0;
      break label171;
      label390:
      i = 0;
      break label238;
      label395:
      i = 0;
      break label283;
      label400:
      i = 0;
      break label306;
      if (2131299074 == i)
      {
        com.tencent.mm.plugin.performance.a.a.wWa.aA(bx.M("<cmd><diagnostic><report><memory/></report></diagnostic></cmd>", "cmd"));
        Toast.makeText(this, "MemoryHook:Reported, pls run `logcat |grep MemoryHookLogic` for result", 0).show();
      }
      else
      {
        if (2131308086 == i)
        {
          paramView = new StringBuilder("<cmd><diagnostic><PthreadHook enable='");
          if (this.wWt.isChecked())
          {
            i = 1;
            label465:
            paramView = paramView.append(i).append("' multiprocess='");
            if (!this.wWu.isChecked()) {
              break label623;
            }
          }
          label623:
          for (i = 1;; i = 0)
          {
            paramView = i + "' duration='" + bu.getInt(this.wWy.getText().toString(), 1) + "' hook='" + this.wWv.getText().toString() + "' ignore='" + this.wWw.getText().toString() + "' thread='" + this.wWx.getText().toString() + "'/></diagnostic></cmd>";
            ae.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", new Object[] { paramView });
            com.tencent.mm.plugin.performance.a.a.wWa.aA(bx.M(paramView, "cmd"));
            Toast.makeText(this, "PthreadHook:Confirmed, pls restart process", 0).show();
            break;
            i = 0;
            break label465;
          }
        }
        if (2131308087 == i)
        {
          com.tencent.mm.plugin.performance.a.a.wWa.aA(bx.M("<cmd><diagnostic><report><pthread/></report></diagnostic></cmd>", "cmd"));
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
    this.wWf = ((CheckBox)findViewById(2131299075));
    this.wWg = ((CheckBox)findViewById(2131299080));
    this.wWh = ((CheckBox)findViewById(2131299077));
    this.wWi = ((CheckBox)findViewById(2131299079));
    this.wWj = ((CheckBox)findViewById(2131299076));
    this.wWk = ((CheckBox)findViewById(2131299078));
    this.wWl = ((EditText)findViewById(2131299082));
    this.wWm = ((EditText)findViewById(2131299083));
    this.wWn = ((EditText)findViewById(2131299081));
    this.wWo = ((EditText)findViewById(2131299085));
    this.wWp = ((EditText)findViewById(2131299084));
    this.wWq = ((EditText)findViewById(2131299086));
    this.wWr = ((Button)findViewById(2131299073));
    this.wWs = ((Button)findViewById(2131299074));
    this.wWr.setOnClickListener(this);
    this.wWs.setOnClickListener(this);
    this.wWf.setChecked(this.wWe.decodeBool("MH_KEY_ENABLE_BOOLEAN", false));
    this.wWg.setChecked(this.wWe.decodeBool("MH_KEY_ENABLE_STACKTRACE_BOOLEAN", false));
    this.wWh.setChecked(false);
    this.wWi.setChecked(this.wWe.decodeBool("MH_KEY_MULTI_PROCESS_BOOLEAN", false));
    this.wWj.setChecked(this.wWe.decodeBool("MH_KEY_EXTREME_BOOLEAN", false));
    this.wWk.setChecked(this.wWe.decodeBool("MH_KEY_ENABLE_MMAP_BOOLEAN", false));
    this.wWl.setText(this.wWe.decodeString("MH_KEY_HOOK_SO_STRING", ".*com\\.tencent\\.mm.*\\.so$"));
    this.wWm.setText(this.wWe.decodeString("MH_KEY_IGNORE_SO_STRING", null));
    this.wWn.setText(Long.toString(this.wWe.decodeLong("MH_KEY_DURATION_MILLIS_LONG", 3600000L) / 3600000L));
    this.wWo.setText(Integer.toString(this.wWe.decodeInt("MH_KEY_MIN_TRACE_SIZE_INT", 0)));
    this.wWp.setText(Integer.toString(this.wWe.decodeInt("MH_KEY_MAX_TRACE_SIZE_INT", 0)));
    this.wWq.setText(Double.toString(this.wWe.aRZ("MH_KEY_SAMPLING_DOUBLE")));
    this.wWt = ((CheckBox)findViewById(2131308088));
    this.wWu = ((CheckBox)findViewById(2131308089));
    this.wWv = ((EditText)findViewById(2131308091));
    this.wWw = ((EditText)findViewById(2131308093));
    this.wWx = ((EditText)findViewById(2131308092));
    this.wWy = ((EditText)findViewById(2131308090));
    this.wWz = ((Button)findViewById(2131308086));
    this.wWA = ((Button)findViewById(2131308087));
    this.wWt.setChecked(this.wWe.decodeBool("PH_KEY_ENABLE_BOOLEAN_v2", false));
    this.wWu.setChecked(this.wWe.decodeBool("PH_KEY_MULTI_PROCESS_BOOLEAN", false));
    this.wWv.setText(this.wWe.decodeString("PH_KEY_HOOK_SO_STRING", ".*\\.so$"));
    this.wWw.setText(this.wWe.decodeString("PH_KEY_IGNORE_SO_STRING", null));
    this.wWx.setText(this.wWe.decodeString("PH_KEY_HOOK_THREAD_STRING", ".*"));
    this.wWy.setText(this.wWe.decodeLong("PH_KEY_DURATION_MILLIS_LONG", 3600000L) / 3600000L);
    this.wWz.setOnClickListener(this);
    this.wWA.setOnClickListener(this);
    AppMethodBeat.o(124911);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI
 * JD-Core Version:    0.7.0.1
 */