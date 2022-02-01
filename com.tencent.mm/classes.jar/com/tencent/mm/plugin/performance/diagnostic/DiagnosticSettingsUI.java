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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;

public class DiagnosticSettingsUI
  extends MMActivity
  implements View.OnClickListener
{
  private CheckBox ASD;
  private CheckBox ASE;
  private CheckBox ASF;
  private CheckBox ASG;
  private CheckBox ASH;
  private CheckBox ASI;
  private CheckBox ASJ;
  private CheckBox ASK;
  private EditText ASL;
  private EditText ASM;
  private EditText ASN;
  private EditText ASO;
  private EditText ASP;
  private EditText ASQ;
  private EditText ASR;
  private Button ASS;
  private Button AST;
  private CheckBox ASU;
  private CheckBox ASV;
  private CheckBox ASW;
  private CheckBox ASX;
  private CheckBox ASY;
  private EditText ASZ;
  private EditText ATa;
  private EditText ATb;
  private EditText ATc;
  private Button ATd;
  private Button ATe;
  private com.tencent.mm.plugin.performance.diagnostic.b.a ATf;
  private com.tencent.mm.plugin.performance.diagnostic.c.a ATg;
  
  public DiagnosticSettingsUI()
  {
    AppMethodBeat.i(124910);
    AppMethodBeat.o(124910);
  }
  
  public int getLayoutId()
  {
    return 2131493839;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(124912);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/performance/diagnostic/DiagnosticSettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    int i = paramView.getId();
    if (2131299579 == i) {
      if (this.ASI.isChecked())
      {
        paramView = "all";
        localObject = new StringBuilder("<cmd><diagnostic><MemoryHook enable='");
        if (!this.ASD.isChecked()) {
          break label464;
        }
        i = 1;
        label80:
        paramView = ((StringBuilder)localObject).append(i).append("' process='").append(paramView).append("' source='push' duration='").append(Util.getInt(this.ASN.getText().toString(), 1)).append("' stacklog='").append(Util.getInt(this.ASR.getText().toString(), 52428800)).append("' hook='").append(this.ASL.getText().toString()).append("' ignore='").append(this.ASM.getText().toString()).append("' stack='");
        if (!this.ASE.isChecked()) {
          break label469;
        }
        i = 1;
        label193:
        paramView = paramView.append(i).append("' min='").append(Util.getInt(this.ASO.getText().toString(), 0)).append("' max='").append(Util.getInt(this.ASP.getText().toString(), 0)).append("' sampling='").append(Util.getDouble(this.ASQ.getText().toString(), 1.0D)).append("' extreme='");
        if (!this.ASJ.isChecked()) {
          break label474;
        }
        i = 1;
        label282:
        paramView = paramView.append(i).append("' mmap='");
        if (!this.ASK.isChecked()) {
          break label479;
        }
        i = 1;
        label305:
        paramView = i + "'/></diagnostic></cmd>";
        Log.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", new Object[] { paramView });
        com.tencent.mm.plugin.performance.a.a.ASb.aJQ(paramView);
        Toast.makeText(this, "MemoryHook:Confirmed, pls restart process", 0).show();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/performance/diagnostic/DiagnosticSettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(124912);
      return;
      localObject = new StringBuilder();
      if (this.ASF.isChecked())
      {
        paramView = "mm;";
        label391:
        localObject = ((StringBuilder)localObject).append(paramView);
        if (!this.ASG.isChecked()) {
          break label450;
        }
        paramView = "appbrand;";
        label411:
        localObject = ((StringBuilder)localObject).append(paramView);
        if (!this.ASH.isChecked()) {
          break label457;
        }
      }
      label450:
      label457:
      for (paramView = "tools;";; paramView = "")
      {
        paramView = paramView;
        break;
        paramView = "";
        break label391;
        paramView = "";
        break label411;
      }
      label464:
      i = 0;
      break label80;
      label469:
      i = 0;
      break label193;
      label474:
      i = 0;
      break label282;
      label479:
      i = 0;
      break label305;
      if (2131299580 == i)
      {
        com.tencent.mm.plugin.performance.a.a.ASb.aA(XmlParser.parseXml("<cmd><diagnostic><report><MemoryHook/></report></diagnostic></cmd>", "cmd", null));
        Toast.makeText(this, "MemoryHook:Reported, pls run `logcat |grep MemoryHookLogic` for result", 0).show();
      }
      else
      {
        if (2131299581 == i)
        {
          if (this.ASY.isChecked())
          {
            paramView = "all";
            localObject = new StringBuilder("<cmd><diagnostic><PthreadHook enable='");
            if (!this.ASU.isChecked()) {
              break label797;
            }
          }
          label783:
          label790:
          label797:
          for (i = 1;; i = 0)
          {
            paramView = i + "' source='push' process='" + paramView + "' duration='" + Util.getInt(this.ATc.getText().toString(), 1) + "' hook='" + this.ASZ.getText().toString() + "' ignore='" + this.ATa.getText().toString() + "' thread='" + this.ATb.getText().toString() + "'/></diagnostic></cmd>";
            Log.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", new Object[] { paramView });
            com.tencent.mm.plugin.performance.a.a.ASb.aJQ(paramView);
            Toast.makeText(this, "PthreadHook:Confirmed, pls restart process", 0).show();
            break;
            localObject = new StringBuilder();
            if (this.ASV.isChecked())
            {
              paramView = "mm;";
              label724:
              localObject = ((StringBuilder)localObject).append(paramView);
              if (!this.ASW.isChecked()) {
                break label783;
              }
              paramView = "appbrand;";
              label744:
              localObject = ((StringBuilder)localObject).append(paramView);
              if (!this.ASX.isChecked()) {
                break label790;
              }
            }
            for (paramView = "tools;";; paramView = "")
            {
              paramView = paramView;
              break;
              paramView = "";
              break label724;
              paramView = "";
              break label744;
            }
          }
        }
        if (2131299582 == i)
        {
          com.tencent.mm.plugin.performance.a.a.ASb.aJQ("<cmd><diagnostic><report><PthreadHook/></report></diagnostic></cmd>");
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
    this.ATf = ((com.tencent.mm.plugin.performance.diagnostic.b.b)com.tencent.mm.plugin.performance.a.a.ASb.aT(com.tencent.mm.plugin.performance.diagnostic.b.b.class)).ATQ;
    this.ATg = ((com.tencent.mm.plugin.performance.diagnostic.c.b)com.tencent.mm.plugin.performance.a.a.ASb.aT(com.tencent.mm.plugin.performance.diagnostic.c.b.class)).ATZ;
    this.ASD = ((CheckBox)findViewById(2131299583));
    this.ASE = ((CheckBox)findViewById(2131299590));
    this.ASF = ((CheckBox)findViewById(2131299588));
    this.ASG = ((CheckBox)findViewById(2131299587));
    this.ASH = ((CheckBox)findViewById(2131299589));
    this.ASI = ((CheckBox)findViewById(2131299586));
    this.ASJ = ((CheckBox)findViewById(2131299584));
    this.ASK = ((CheckBox)findViewById(2131299585));
    this.ASF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201031);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.a(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(201031);
      }
    });
    this.ASG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201032);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.a(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(201032);
      }
    });
    this.ASH.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201033);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.a(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(201033);
      }
    });
    this.ASI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201034);
        if (paramAnonymousBoolean)
        {
          DiagnosticSettingsUI.b(DiagnosticSettingsUI.this).setChecked(false);
          DiagnosticSettingsUI.c(DiagnosticSettingsUI.this).setChecked(false);
          DiagnosticSettingsUI.d(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(201034);
      }
    });
    this.ASL = ((EditText)findViewById(2131299597));
    this.ASM = ((EditText)findViewById(2131299598));
    this.ASN = ((EditText)findViewById(2131299596));
    this.ASO = ((EditText)findViewById(2131299600));
    this.ASP = ((EditText)findViewById(2131299599));
    this.ASQ = ((EditText)findViewById(2131299601));
    this.ASR = ((EditText)findViewById(2131299602));
    this.ASS = ((Button)findViewById(2131299579));
    this.AST = ((Button)findViewById(2131299580));
    this.ASS.setOnClickListener(this);
    this.AST.setOnClickListener(this);
    this.ASD.setChecked(this.ATf.eBO());
    this.ASE.setChecked(this.ATf.eCb());
    this.ASF.setChecked(this.ATf.getTargetProcess().contains("mm"));
    this.ASG.setChecked(this.ATf.getTargetProcess().contains("appbrand"));
    this.ASH.setChecked(this.ATf.getTargetProcess().contains("tools"));
    this.ASI.setChecked(this.ATf.getTargetProcess().contains("all"));
    this.ASJ.setChecked(this.ATf.eCf());
    this.ASK.setChecked(this.ATf.eCg());
    this.ASL.setText(this.ATf.aJV(".*com\\.tencent\\.mm.*\\.so$"));
    this.ASM.setText(this.ATf.eCa());
    this.ASN.setText(Long.toString(this.ATf.Up(1)));
    this.ASO.setText(Integer.toString(this.ATf.eCc()));
    this.ASP.setText(Integer.toString(this.ATf.eCd()));
    this.ASQ.setText(Double.toString(this.ATf.eCe()));
    this.ASU = ((CheckBox)findViewById(2131299591));
    this.ASV = ((CheckBox)findViewById(2131299594));
    this.ASW = ((CheckBox)findViewById(2131299593));
    this.ASX = ((CheckBox)findViewById(2131299595));
    this.ASY = ((CheckBox)findViewById(2131299592));
    this.ASZ = ((EditText)findViewById(2131299604));
    this.ATa = ((EditText)findViewById(2131299606));
    this.ATb = ((EditText)findViewById(2131299605));
    this.ATc = ((EditText)findViewById(2131299603));
    this.ATd = ((Button)findViewById(2131299581));
    this.ATe = ((Button)findViewById(2131299582));
    this.ASV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201035);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.e(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(201035);
      }
    });
    this.ASW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201036);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.e(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(201036);
      }
    });
    this.ASX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201037);
        if (paramAnonymousBoolean) {
          DiagnosticSettingsUI.e(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(201037);
      }
    });
    this.ASY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201038);
        if (paramAnonymousBoolean)
        {
          DiagnosticSettingsUI.f(DiagnosticSettingsUI.this).setChecked(false);
          DiagnosticSettingsUI.g(DiagnosticSettingsUI.this).setChecked(false);
          DiagnosticSettingsUI.h(DiagnosticSettingsUI.this).setChecked(false);
        }
        AppMethodBeat.o(201038);
      }
    });
    this.ASU.setChecked(this.ATg.eBO());
    this.ASZ.setText(this.ATg.aJV(".*\\.so$"));
    this.ATa.setText(this.ATg.eCa());
    this.ATb.setText(this.ATg.aJW(".*"));
    this.ATc.setText(Integer.toString(this.ATg.Up(1)));
    this.ASV.setChecked(this.ATg.getTargetProcess().contains("mm"));
    this.ASW.setChecked(this.ATg.getTargetProcess().contains("appbrand"));
    this.ASX.setChecked(this.ATg.getTargetProcess().contains("tools"));
    this.ASY.setChecked(this.ATg.getTargetProcess().contains("all"));
    this.ATd.setOnClickListener(this);
    this.ATe.setOnClickListener(this);
    AppMethodBeat.o(124911);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI
 * JD-Core Version:    0.7.0.1
 */