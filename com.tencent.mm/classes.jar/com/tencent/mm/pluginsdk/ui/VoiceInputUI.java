package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.base.a(3)
public class VoiceInputUI
  extends MMActivity
{
  private String bjm;
  private Button loq;
  private int offset;
  private int textChangeCount;
  private String userCode;
  private MMEditText vSC;
  private VoiceInputFooter vSD;
  private String vSE;
  private long vSF;
  private boolean vSG;
  private boolean vSH;
  private View.OnTouchListener vSI;
  private MenuItem.OnMenuItemClickListener vSJ;
  private VoiceInputFooter.a vSK;
  
  public VoiceInputUI()
  {
    AppMethodBeat.i(27613);
    this.vSF = 0L;
    this.textChangeCount = 0;
    this.vSG = true;
    this.vSH = false;
    this.vSI = new VoiceInputUI.2(this);
    this.vSJ = new VoiceInputUI.3(this);
    this.vSK = new VoiceInputUI.4(this);
    AppMethodBeat.o(27613);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(27621);
    ab.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    h.qsU.c(13905, locallog_13905);
    AppMethodBeat.o(27621);
  }
  
  private void kS(int paramInt)
  {
    AppMethodBeat.i(27622);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    localVoiceInputBehavior.textChangeCount = this.textChangeCount;
    localVoiceInputBehavior.textChangeReturn = paramInt;
    if (this.vSF != 0L)
    {
      localVoiceInputBehavior.textChangeTime = bo.av(this.vSF);
      this.vSF = 0L;
    }
    a(localVoiceInputBehavior);
    AppMethodBeat.o(27622);
  }
  
  public int getLayoutId()
  {
    return 2130971090;
  }
  
  public final void ni(int paramInt)
  {
    AppMethodBeat.i(27620);
    ab.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", new Object[] { Integer.valueOf(paramInt), bo.dtY().toString() });
    uq localuq;
    if (paramInt == 8)
    {
      kS(7);
      localuq = new uq();
      if (paramInt != 7) {
        break label159;
      }
      localuq.cLe.action = 1;
      label67:
      if (!this.vSH) {
        break label187;
      }
    }
    label159:
    label187:
    for (localuq.cLe.cLf = 1;; localuq.cLe.cLf = 2)
    {
      localuq.cLe.result = this.vSC.getText().toString();
      localuq.cLe.userCode = this.userCode;
      if (this.vSD != null) {
        this.vSD.release();
      }
      com.tencent.mm.sdk.b.a.ymk.l(localuq);
      bo.hideVKB(this.vSC);
      super.finish();
      AppMethodBeat.o(27620);
      return;
      kS(paramInt);
      break;
      if (paramInt == 8)
      {
        localuq.cLe.action = 4;
        break label67;
      }
      localuq.cLe.action = 2;
      break label67;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27614);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.bjm = paramBundle.getStringExtra("text");
      this.offset = paramBundle.getIntExtra("offset", -1);
      this.vSE = paramBundle.getStringExtra("punctuation");
      this.userCode = paramBundle.getStringExtra("userCode");
    }
    this.vSF = bo.yB();
    this.textChangeCount = 0;
    this.vSH = false;
    this.vSG = true;
    this.vSC = ((MMEditText)findViewById(2131828760));
    this.loq = ((Button)findViewById(2131828759));
    this.vSC.addTextChangedListener(new VoiceInputUI.5(this));
    this.loq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27612);
        paramAnonymousView = new VoiceInputBehavior();
        paramAnonymousView.send = 3;
        VoiceInputUI.b(paramAnonymousView);
        VoiceInputUI.this.ni(7);
        AppMethodBeat.o(27612);
      }
    });
    setMMTitle(getString(2131304558));
    enableOptionMenu(true);
    setBackBtn(new VoiceInputUI.1(this));
    this.vSC.setOnTouchListener(this.vSI);
    this.vSC.avk(this.bjm);
    if (this.offset != -1) {
      this.vSC.setSelection(this.offset);
    }
    this.vSD = ((VoiceInputFooter)findViewById(2131828085));
    VoiceInputFooter localVoiceInputFooter = this.vSD;
    paramBundle = this.vSC;
    String str1 = this.vSE;
    String str2 = this.userCode;
    localVoiceInputFooter.kju = paramBundle;
    paramBundle.setOnClickListener(new VoiceInputFooter.1(localVoiceInputFooter));
    paramBundle.setOnEditorActionListener(new VoiceInputFooter.2(localVoiceInputFooter));
    if (localVoiceInputFooter.vSd == null)
    {
      localVoiceInputFooter.vSd = new n(localVoiceInputFooter.getContext(), true, localVoiceInputFooter.kju);
      localVoiceInputFooter.vSd.setCallback(new VoiceInputFooter.6(localVoiceInputFooter));
      localVoiceInputFooter.vSd.setPortHeightPX(j.gL(localVoiceInputFooter.getContext()));
    }
    localVoiceInputFooter.vSd.doW();
    n localn = localVoiceInputFooter.vSd;
    ab.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(localn.vVr), Boolean.valueOf(localn.vZV) });
    if (localn.vZV)
    {
      localn.vZV = false;
      View localView = localn.findViewById(2131828747);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = localn.vVr;
      paramBundle = localLayoutParams;
      if (localLayoutParams == null) {
        paramBundle = new LinearLayout.LayoutParams(-1, i);
      }
      paramBundle.height = i;
      localView.setLayoutParams(paramBundle);
      localn.doY();
      localn.requestLayout();
    }
    localVoiceInputFooter.vSd.setVisibility(8);
    localVoiceInputFooter.vSd.setToUser(str2);
    localVoiceInputFooter.vSd.setFullScreenData(str1);
    localVoiceInputFooter.oQN.addView(localVoiceInputFooter.vSd, -1, 0);
    this.vSD.setVoiceInputFooterListener(this.vSK);
    AppMethodBeat.o(27614);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27617);
    super.onDestroy();
    AppMethodBeat.o(27617);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27619);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      ni(2);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(27619);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27616);
    super.onPause();
    AppMethodBeat.o(27616);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27615);
    super.onResume();
    this.vSC.requestFocus();
    AppMethodBeat.o(27615);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(27618);
    ni(3);
    super.onSwipeBack();
    AppMethodBeat.o(27618);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI
 * JD-Core Version:    0.7.0.1
 */