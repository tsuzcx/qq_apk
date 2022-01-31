package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.h.a.sx;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.base.a(3)
public class VoiceInputUI
  extends MMActivity
{
  private String bHk;
  private String ccx;
  private Button jfy;
  private int offset;
  private boolean sbA = false;
  private View.OnTouchListener sbB = new VoiceInputUI.2(this);
  private MenuItem.OnMenuItemClickListener sbC = new VoiceInputUI.3(this);
  private VoiceInputFooter.a sbD = new VoiceInputUI.4(this);
  private MMEditText sbv;
  private VoiceInputFooter sbw;
  private String sbx;
  private long sby = 0L;
  private boolean sbz = true;
  private int textChangeCount = 0;
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    y.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    h.nFQ.c(13905, locallog_13905);
  }
  
  private void jdMethod_if(int paramInt)
  {
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    localVoiceInputBehavior.textChangeCount = this.textChangeCount;
    localVoiceInputBehavior.textChangeReturn = paramInt;
    if (this.sby != 0L)
    {
      localVoiceInputBehavior.textChangeTime = bk.cp(this.sby);
      this.sby = 0L;
    }
    a(localVoiceInputBehavior);
  }
  
  public final void DX(int paramInt)
  {
    y.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", new Object[] { Integer.valueOf(paramInt), bk.csb().toString() });
    sx localsx;
    if (paramInt == 8)
    {
      jdMethod_if(7);
      localsx = new sx();
      if (paramInt != 7) {
        break label180;
      }
      localsx.ccv.action = 1;
      label61:
      if (!this.sbA) {
        break label208;
      }
    }
    label180:
    label208:
    for (localsx.ccv.ccw = 1;; localsx.ccv.ccw = 2)
    {
      localsx.ccv.result = this.sbv.getText().toString();
      localsx.ccv.ccx = this.ccx;
      if (this.sbw != null)
      {
        VoiceInputFooter localVoiceInputFooter = this.sbw;
        if (localVoiceInputFooter.jpC != null)
        {
          localVoiceInputFooter.jpC.sj();
          localVoiceInputFooter.jpC.destroy();
        }
        if (localVoiceInputFooter.saW != null) {
          localVoiceInputFooter.saW.destroy();
        }
      }
      com.tencent.mm.sdk.b.a.udP.m(localsx);
      bk.hideVKB(this.sbv);
      super.finish();
      return;
      jdMethod_if(paramInt);
      break;
      if (paramInt == 8)
      {
        localsx.ccv.action = 4;
        break label61;
      }
      localsx.ccv.action = 2;
      break label61;
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.voice_input_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.bHk = paramBundle.getStringExtra("text");
      this.offset = paramBundle.getIntExtra("offset", -1);
      this.sbx = paramBundle.getStringExtra("punctuation");
      this.ccx = paramBundle.getStringExtra("userCode");
    }
    this.sby = bk.UZ();
    this.textChangeCount = 0;
    this.sbA = false;
    this.sbz = true;
    this.sbv = ((MMEditText)findViewById(R.h.voice_input_ui_text_edit));
    this.jfy = ((Button)findViewById(R.h.voice_input_ui_send_btn));
    this.sbv.addTextChangedListener(new VoiceInputUI.5(this));
    this.jfy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new VoiceInputBehavior();
        paramAnonymousView.send = 3;
        VoiceInputUI.b(paramAnonymousView);
        VoiceInputUI.this.DX(7);
      }
    });
    setMMTitle(getString(R.l.voice_input_ui_eidt_content));
    enableOptionMenu(true);
    setBackBtn(new VoiceInputUI.1(this));
    this.sbv.setOnTouchListener(this.sbB);
    this.sbv.aex(this.bHk);
    if (this.offset != -1) {
      this.sbv.setSelection(this.offset);
    }
    this.sbw = ((VoiceInputFooter)findViewById(R.h.say_footer));
    paramBundle = this.sbw;
    MMEditText localMMEditText = this.sbv;
    String str1 = this.sbx;
    String str2 = this.ccx;
    paramBundle.pdp = localMMEditText;
    localMMEditText.setOnClickListener(new VoiceInputFooter.1(paramBundle));
    localMMEditText.setOnEditorActionListener(new VoiceInputFooter.2(paramBundle));
    if (paramBundle.saW == null)
    {
      paramBundle.saW = new n(paramBundle.getContext(), true, paramBundle.pdp);
      paramBundle.saW.setCallback(new VoiceInputFooter.6(paramBundle));
      paramBundle.saW.setPortHeightPX(j.fy(paramBundle.getContext()));
    }
    paramBundle.saW.cnP();
    paramBundle.saW.cmX();
    paramBundle.saW.setVisibility(8);
    paramBundle.saW.setToUser(str2);
    paramBundle.saW.setFullScreenData(str1);
    paramBundle.mqY.addView(paramBundle.saW, -1, 0);
    this.sbw.setVoiceInputFooterListener(this.sbD);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      DX(2);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.sbv.requestFocus();
  }
  
  public void onSwipeBack()
  {
    DX(3);
    super.onSwipeBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI
 * JD-Core Version:    0.7.0.1
 */