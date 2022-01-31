package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public abstract class BaseVoicePrintUI
  extends MMActivity
{
  private boolean odV = false;
  private final ap oee = new ap(new BaseVoicePrintUI.3(this), true);
  Button trL;
  View trM;
  VoicePrintVolumeMeter trN;
  VoiceTipInfoView trO;
  p trP = null;
  String trQ = null;
  private boolean trR = false;
  private View trS;
  private boolean trT = false;
  private final p.a trU = new BaseVoicePrintUI.1(this);
  ap trV = new ap(new BaseVoicePrintUI.4(this), true);
  private ak trW = new ak(Looper.getMainLooper(), new BaseVoicePrintUI.5(this));
  String tru = null;
  
  protected final void GY(int paramInt)
  {
    this.trO.bRO();
    this.trO.setErr(paramInt);
    this.trO.cLz();
  }
  
  protected abstract void bMe();
  
  protected final void cLk()
  {
    al.p(new BaseVoicePrintUI.7(this), 1300L);
  }
  
  protected final void cLl()
  {
    if ((this.trS.getVisibility() == 4) || (this.trS.getVisibility() == 8)) {
      return;
    }
    if (this.trT)
    {
      this.trS.setVisibility(4);
      return;
    }
    this.trT = true;
    a.a(this.trS, this, new BaseVoicePrintUI.9(this));
  }
  
  protected final void cLm()
  {
    GY(2131304564);
  }
  
  protected abstract void cLn();
  
  public int getLayoutId()
  {
    return 2130971094;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hideTitleView();
    this.trO = ((VoiceTipInfoView)findViewById(2131828767));
    this.trL = ((Button)findViewById(2131828769));
    this.trM = findViewById(2131824810);
    this.trN = ((VoicePrintVolumeMeter)findViewById(2131824811));
    this.trS = findViewById(2131828770);
    this.trO.cLA();
    this.trN.setArchView(this.trL);
    this.trP = new p();
    this.trP.trG = this.trU;
    this.trL.setOnTouchListener(new BaseVoicePrintUI.10(this));
    findViewById(2131823924).setOnClickListener(new BaseVoicePrintUI.2(this));
    bMe();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.trN;
    ((VoicePrintVolumeMeter)localObject).tsx.stopTimer();
    ((VoicePrintVolumeMeter)localObject).tsw.oNc.getLooper().quit();
    ab.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
    ab.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
    localObject = new File(m.bE("voice_pt_voice_print_record.rec", false));
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    localObject = new File(m.bE("voice_pt_voice_print_noise_detect.rec", false));
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
 * JD-Core Version:    0.7.0.1
 */