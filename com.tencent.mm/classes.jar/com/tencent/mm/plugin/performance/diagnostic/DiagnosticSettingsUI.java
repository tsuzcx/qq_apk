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
import com.tencent.mm.plugin.performance.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.ui.MMActivity;

public class DiagnosticSettingsUI
  extends MMActivity
  implements View.OnClickListener
{
  private CheckBox vAg;
  private CheckBox vAh;
  private CheckBox vAi;
  private CheckBox vAj;
  private CheckBox vAk;
  private CheckBox vAl;
  private EditText vAm;
  private EditText vAn;
  private EditText vAo;
  private EditText vAp;
  private EditText vAq;
  private EditText vAr;
  private Button vAs;
  private Button vAt;
  private aw vAu;
  
  public DiagnosticSettingsUI()
  {
    AppMethodBeat.i(124910);
    this.vAu = aw.aKT("diagnostic_memory_hook_stg");
    AppMethodBeat.o(124910);
  }
  
  public int getLayoutId()
  {
    return 2131493707;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(124912);
    int i = paramView.getId();
    if (2131299073 == i)
    {
      paramView = new StringBuilder("<cmd><diagnostic><MemoryHook enable='");
      if (this.vAg.isChecked())
      {
        i = 1;
        paramView = paramView.append(i).append("' multiprocess='");
        if (!this.vAj.isChecked()) {
          break label339;
        }
        i = 1;
        label61:
        paramView = paramView.append(i).append("' duration='").append(bs.getInt(this.vAo.getText().toString(), 1)).append("' hook='").append(this.vAm.getText().toString()).append("' ignore='").append(this.vAn.getText().toString()).append("' stack='");
        if (!this.vAh.isChecked()) {
          break label344;
        }
        i = 1;
        label142:
        paramView = paramView.append(i).append("' min='").append(bs.getInt(this.vAp.getText().toString(), 0)).append("' max='").append(bs.getInt(this.vAq.getText().toString(), 0)).append("' force='");
        if (!this.vAi.isChecked()) {
          break label349;
        }
        i = 1;
        label209:
        paramView = paramView.append(i).append("' sampling='").append(bs.getDouble(this.vAr.getText().toString(), 1.0D)).append("' extreme='");
        if (!this.vAk.isChecked()) {
          break label354;
        }
        i = 1;
        label254:
        paramView = paramView.append(i).append("' mmap='");
        if (!this.vAl.isChecked()) {
          break label359;
        }
      }
      label339:
      label344:
      label349:
      label354:
      label359:
      for (i = 1;; i = 0)
      {
        paramView = i + "'/></diagnostic></cmd>";
        ac.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", new Object[] { paramView });
        a.vAc.ap(bv.L(paramView, "cmd"));
        Toast.makeText(this, "MemoryHook:Confirmed, pls restart process", 0).show();
        AppMethodBeat.o(124912);
        return;
        i = 0;
        break;
        i = 0;
        break label61;
        i = 0;
        break label142;
        i = 0;
        break label209;
        i = 0;
        break label254;
      }
    }
    if (2131299074 == i)
    {
      a.vAc.ap(bv.L("<cmd><diagnostic><report><memory/></report></diagnostic></cmd>", "cmd"));
      Toast.makeText(this, "MemoryHook:Reported, pls run `logcat |grep MemoryHookLogic` for result", 0).show();
    }
    AppMethodBeat.o(124912);
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
    this.vAg = ((CheckBox)findViewById(2131299075));
    this.vAh = ((CheckBox)findViewById(2131299080));
    this.vAi = ((CheckBox)findViewById(2131299077));
    this.vAj = ((CheckBox)findViewById(2131299079));
    this.vAk = ((CheckBox)findViewById(2131299076));
    this.vAl = ((CheckBox)findViewById(2131299078));
    this.vAm = ((EditText)findViewById(2131299082));
    this.vAn = ((EditText)findViewById(2131299083));
    this.vAo = ((EditText)findViewById(2131299081));
    this.vAp = ((EditText)findViewById(2131299085));
    this.vAq = ((EditText)findViewById(2131299084));
    this.vAr = ((EditText)findViewById(2131299086));
    this.vAs = ((Button)findViewById(2131299073));
    this.vAt = ((Button)findViewById(2131299074));
    this.vAs.setOnClickListener(this);
    this.vAt.setOnClickListener(this);
    this.vAg.setChecked(this.vAu.decodeBool("MH_KEY_ENABLE_BOOLEAN", false));
    this.vAh.setChecked(this.vAu.decodeBool("MH_KEY_ENABLE_STACKTRACE_BOOLEAN", false));
    this.vAi.setChecked(false);
    this.vAj.setChecked(this.vAu.decodeBool("MH_KEY_MULTI_PROCESS_BOOLEAN", false));
    this.vAk.setChecked(this.vAu.decodeBool("MH_KEY_EXTREME_BOOLEAN", false));
    this.vAl.setChecked(this.vAu.decodeBool("MH_KEY_ENABLE_MMAP_BOOLEAN", false));
    this.vAm.setText(this.vAu.decodeString("MH_KEY_HOOK_SO_STRING", ".*com\\.tencent\\.mm.*\\.so$"));
    this.vAn.setText(this.vAu.decodeString("MH_KEY_IGNORE_SO_STRING", null));
    this.vAo.setText(Long.toString(this.vAu.decodeLong("MH_KEY_DURATION_MILLIS_LONG", 3600000L) / 3600000L));
    this.vAp.setText(Integer.toString(this.vAu.decodeInt("MH_KEY_MIN_TRACE_SIZE_INT", 0)));
    this.vAq.setText(Integer.toString(this.vAu.decodeInt("MH_KEY_MAX_TRACE_SIZE_INT", 0)));
    this.vAr.setText(Double.toString(this.vAu.aKW("MH_KEY_SAMPLING_DOUBLE")));
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