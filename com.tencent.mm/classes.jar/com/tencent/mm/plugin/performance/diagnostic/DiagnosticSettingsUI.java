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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMActivity;

public class DiagnosticSettingsUI
  extends MMActivity
  implements View.OnClickListener
{
  private EditText wGA;
  private EditText wGB;
  private EditText wGC;
  private EditText wGD;
  private Button wGE;
  private Button wGF;
  private CheckBox wGG;
  private CheckBox wGH;
  private EditText wGI;
  private EditText wGJ;
  private EditText wGK;
  private EditText wGL;
  private Button wGM;
  private Button wGN;
  private ax wGr;
  private CheckBox wGs;
  private CheckBox wGt;
  private CheckBox wGu;
  private CheckBox wGv;
  private CheckBox wGw;
  private CheckBox wGx;
  private EditText wGy;
  private EditText wGz;
  
  public DiagnosticSettingsUI()
  {
    AppMethodBeat.i(124910);
    this.wGr = ax.aQz("diagnostic_storage");
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/performance/diagnostic/DiagnosticSettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    int i = paramView.getId();
    if (2131299073 == i)
    {
      paramView = new StringBuilder("<cmd><diagnostic><MemoryHook enable='");
      if (this.wGs.isChecked())
      {
        i = 1;
        paramView = paramView.append(i).append("' multiprocess='");
        if (!this.wGv.isChecked()) {
          break label380;
        }
        i = 1;
        label90:
        paramView = paramView.append(i).append("' duration='").append(bt.getInt(this.wGA.getText().toString(), 1)).append("' hook='").append(this.wGy.getText().toString()).append("' ignore='").append(this.wGz.getText().toString()).append("' stack='");
        if (!this.wGt.isChecked()) {
          break label385;
        }
        i = 1;
        label171:
        paramView = paramView.append(i).append("' min='").append(bt.getInt(this.wGB.getText().toString(), 0)).append("' max='").append(bt.getInt(this.wGC.getText().toString(), 0)).append("' force='");
        if (!this.wGu.isChecked()) {
          break label390;
        }
        i = 1;
        label238:
        paramView = paramView.append(i).append("' sampling='").append(bt.getDouble(this.wGD.getText().toString(), 1.0D)).append("' extreme='");
        if (!this.wGw.isChecked()) {
          break label395;
        }
        i = 1;
        label283:
        paramView = paramView.append(i).append("' mmap='");
        if (!this.wGx.isChecked()) {
          break label400;
        }
        i = 1;
        label306:
        paramView = i + "'/></diagnostic></cmd>";
        ad.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", new Object[] { paramView });
        com.tencent.mm.plugin.performance.a.a.wGn.au(bw.M(paramView, "cmd"));
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
        com.tencent.mm.plugin.performance.a.a.wGn.au(bw.M("<cmd><diagnostic><report><memory/></report></diagnostic></cmd>", "cmd"));
        Toast.makeText(this, "MemoryHook:Reported, pls run `logcat |grep MemoryHookLogic` for result", 0).show();
      }
      else
      {
        if (2131308086 == i)
        {
          paramView = new StringBuilder("<cmd><diagnostic><PthreadHook enable='");
          if (this.wGG.isChecked())
          {
            i = 1;
            label465:
            paramView = paramView.append(i).append("' multiprocess='");
            if (!this.wGH.isChecked()) {
              break label623;
            }
          }
          label623:
          for (i = 1;; i = 0)
          {
            paramView = i + "' duration='" + bt.getInt(this.wGL.getText().toString(), 1) + "' hook='" + this.wGI.getText().toString() + "' ignore='" + this.wGJ.getText().toString() + "' thread='" + this.wGK.getText().toString() + "'/></diagnostic></cmd>";
            ad.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", new Object[] { paramView });
            com.tencent.mm.plugin.performance.a.a.wGn.au(bw.M(paramView, "cmd"));
            Toast.makeText(this, "PthreadHook:Confirmed, pls restart process", 0).show();
            break;
            i = 0;
            break label465;
          }
        }
        if (2131308087 == i)
        {
          com.tencent.mm.plugin.performance.a.a.wGn.au(bw.M("<cmd><diagnostic><report><pthread/></report></diagnostic></cmd>", "cmd"));
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
    this.wGs = ((CheckBox)findViewById(2131299075));
    this.wGt = ((CheckBox)findViewById(2131299080));
    this.wGu = ((CheckBox)findViewById(2131299077));
    this.wGv = ((CheckBox)findViewById(2131299079));
    this.wGw = ((CheckBox)findViewById(2131299076));
    this.wGx = ((CheckBox)findViewById(2131299078));
    this.wGy = ((EditText)findViewById(2131299082));
    this.wGz = ((EditText)findViewById(2131299083));
    this.wGA = ((EditText)findViewById(2131299081));
    this.wGB = ((EditText)findViewById(2131299085));
    this.wGC = ((EditText)findViewById(2131299084));
    this.wGD = ((EditText)findViewById(2131299086));
    this.wGE = ((Button)findViewById(2131299073));
    this.wGF = ((Button)findViewById(2131299074));
    this.wGE.setOnClickListener(this);
    this.wGF.setOnClickListener(this);
    this.wGs.setChecked(this.wGr.decodeBool("MH_KEY_ENABLE_BOOLEAN", false));
    this.wGt.setChecked(this.wGr.decodeBool("MH_KEY_ENABLE_STACKTRACE_BOOLEAN", false));
    this.wGu.setChecked(false);
    this.wGv.setChecked(this.wGr.decodeBool("MH_KEY_MULTI_PROCESS_BOOLEAN", false));
    this.wGw.setChecked(this.wGr.decodeBool("MH_KEY_EXTREME_BOOLEAN", false));
    this.wGx.setChecked(this.wGr.decodeBool("MH_KEY_ENABLE_MMAP_BOOLEAN", false));
    this.wGy.setText(this.wGr.decodeString("MH_KEY_HOOK_SO_STRING", ".*com\\.tencent\\.mm.*\\.so$"));
    this.wGz.setText(this.wGr.decodeString("MH_KEY_IGNORE_SO_STRING", null));
    this.wGA.setText(Long.toString(this.wGr.decodeLong("MH_KEY_DURATION_MILLIS_LONG", 3600000L) / 3600000L));
    this.wGB.setText(Integer.toString(this.wGr.decodeInt("MH_KEY_MIN_TRACE_SIZE_INT", 0)));
    this.wGC.setText(Integer.toString(this.wGr.decodeInt("MH_KEY_MAX_TRACE_SIZE_INT", 0)));
    this.wGD.setText(Double.toString(this.wGr.aQC("MH_KEY_SAMPLING_DOUBLE")));
    this.wGG = ((CheckBox)findViewById(2131308088));
    this.wGH = ((CheckBox)findViewById(2131308089));
    this.wGI = ((EditText)findViewById(2131308091));
    this.wGJ = ((EditText)findViewById(2131308093));
    this.wGK = ((EditText)findViewById(2131308092));
    this.wGL = ((EditText)findViewById(2131308090));
    this.wGM = ((Button)findViewById(2131308086));
    this.wGN = ((Button)findViewById(2131308087));
    this.wGG.setChecked(this.wGr.decodeBool("PH_KEY_ENABLE_BOOLEAN_v2", false));
    this.wGH.setChecked(this.wGr.decodeBool("PH_KEY_MULTI_PROCESS_BOOLEAN", false));
    this.wGI.setText(this.wGr.decodeString("PH_KEY_HOOK_SO_STRING", ".*\\.so$"));
    this.wGJ.setText(this.wGr.decodeString("PH_KEY_IGNORE_SO_STRING", null));
    this.wGK.setText(this.wGr.decodeString("PH_KEY_HOOK_THREAD_STRING", ".*"));
    this.wGL.setText(this.wGr.decodeLong("PH_KEY_DURATION_MILLIS_LONG", 3600000L) / 3600000L);
    this.wGM.setOnClickListener(this);
    this.wGN.setOnClickListener(this);
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