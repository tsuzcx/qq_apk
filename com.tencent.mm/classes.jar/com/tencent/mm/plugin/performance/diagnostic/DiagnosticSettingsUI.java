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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMActivity;

public class DiagnosticSettingsUI
  extends MMActivity
  implements View.OnClickListener
{
  private ax urA;
  private CheckBox urm;
  private CheckBox urn;
  private CheckBox uro;
  private CheckBox urp;
  private CheckBox urq;
  private CheckBox urr;
  private EditText urs;
  private EditText urt;
  private EditText uru;
  private EditText urv;
  private EditText urw;
  private EditText urx;
  private Button ury;
  private Button urz;
  
  public DiagnosticSettingsUI()
  {
    AppMethodBeat.i(124910);
    this.urA = ax.aFC("diagnostic_memory_hook_stg");
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
      if (this.urm.isChecked())
      {
        i = 1;
        paramView = paramView.append(i).append("' multiprocess='");
        if (!this.urp.isChecked()) {
          break label339;
        }
        i = 1;
        label61:
        paramView = paramView.append(i).append("' duration='").append(bt.getInt(this.uru.getText().toString(), 1)).append("' hook='").append(this.urs.getText().toString()).append("' ignore='").append(this.urt.getText().toString()).append("' stack='");
        if (!this.urn.isChecked()) {
          break label344;
        }
        i = 1;
        label142:
        paramView = paramView.append(i).append("' min='").append(bt.getInt(this.urv.getText().toString(), 0)).append("' max='").append(bt.getInt(this.urw.getText().toString(), 0)).append("' force='");
        if (!this.uro.isChecked()) {
          break label349;
        }
        i = 1;
        label209:
        paramView = paramView.append(i).append("' sampling='").append(bt.getDouble(this.urx.getText().toString(), 1.0D)).append("' extreme='");
        if (!this.urq.isChecked()) {
          break label354;
        }
        i = 1;
        label254:
        paramView = paramView.append(i).append("' mmap='");
        if (!this.urr.isChecked()) {
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
        ad.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", new Object[] { paramView });
        a.urg.an(bw.K(paramView, "cmd"));
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
      a.urg.an(bw.K("<cmd><diagnostic><report><memory/></report></diagnostic></cmd>", "cmd"));
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
    this.urm = ((CheckBox)findViewById(2131299075));
    this.urn = ((CheckBox)findViewById(2131299080));
    this.uro = ((CheckBox)findViewById(2131299077));
    this.urp = ((CheckBox)findViewById(2131299079));
    this.urq = ((CheckBox)findViewById(2131299076));
    this.urr = ((CheckBox)findViewById(2131299078));
    this.urs = ((EditText)findViewById(2131299082));
    this.urt = ((EditText)findViewById(2131299083));
    this.uru = ((EditText)findViewById(2131299081));
    this.urv = ((EditText)findViewById(2131299085));
    this.urw = ((EditText)findViewById(2131299084));
    this.urx = ((EditText)findViewById(2131299086));
    this.ury = ((Button)findViewById(2131299073));
    this.urz = ((Button)findViewById(2131299074));
    this.ury.setOnClickListener(this);
    this.urz.setOnClickListener(this);
    this.urm.setChecked(this.urA.decodeBool("MH_KEY_ENABLE_BOOLEAN", false));
    this.urn.setChecked(this.urA.decodeBool("MH_KEY_ENABLE_STACKTRACE_BOOLEAN", false));
    this.uro.setChecked(false);
    this.urp.setChecked(this.urA.decodeBool("MH_KEY_MULTI_PROCESS_BOOLEAN", false));
    this.urq.setChecked(this.urA.decodeBool("MH_KEY_EXTREME_BOOLEAN", false));
    this.urr.setChecked(this.urA.decodeBool("MH_KEY_ENABLE_MMAP_BOOLEAN", false));
    this.urs.setText(this.urA.decodeString("MH_KEY_HOOK_SO_STRING", ".*com\\.tencent\\.mm.*\\.so$"));
    this.urt.setText(this.urA.decodeString("MH_KEY_IGNORE_SO_STRING", null));
    this.uru.setText(Long.toString(this.urA.decodeLong("MH_KEY_DURATION_MILLIS_LONG", 3600000L) / 3600000L));
    this.urv.setText(Integer.toString(this.urA.decodeInt("MH_KEY_MIN_TRACE_SIZE_INT", 0)));
    this.urw.setText(Integer.toString(this.urA.decodeInt("MH_KEY_MAX_TRACE_SIZE_INT", 0)));
    this.urx.setText(Double.toString(this.urA.aFF("MH_KEY_SAMPLING_DOUBLE")));
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