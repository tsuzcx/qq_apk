package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.aag;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.base.a(3)
public class VoiceInputUI
  extends MMActivity
  implements com.tencent.mm.ui.tools.h
{
  boolean FeO;
  private boolean ReA;
  private View.OnTouchListener ReB;
  private MenuItem.OnMenuItemClickListener ReC;
  private VoiceInputFooter.a ReD;
  boolean ReE;
  private MMEditText Rev;
  private VoiceInputFooter Rew;
  private String Rex;
  private long Rey;
  private boolean Rez;
  com.tencent.mm.ui.tools.i jij;
  private String msg;
  private int offset;
  private int textChangeCount;
  private Button uMw;
  private String userCode;
  
  public VoiceInputUI()
  {
    AppMethodBeat.i(31316);
    this.Rey = 0L;
    this.textChangeCount = 0;
    this.Rez = true;
    this.ReA = false;
    this.ReB = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(31310);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          VoiceInputUI.a(VoiceInputUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(31310);
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1)
          {
            if (VoiceInputUI.b(VoiceInputUI.this).hjT())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.hjU();
              paramAnonymousView.setVisibility(8);
            }
            if (VoiceInputUI.b(VoiceInputUI.this).fXU())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.aDL();
              paramAnonymousView.setVisibility(8);
            }
            paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
            paramAnonymousView.setVisibility(0);
            if (paramAnonymousView.RdW != null) {
              paramAnonymousView.RdW.setImageResource(R.g.chatting_setmode_biaoqing_btn);
            }
          }
        }
      }
    };
    this.ReC = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(31311);
        VoiceInputUI.c(VoiceInputUI.this).setText("");
        VoiceInputUI.d(VoiceInputUI.this);
        VoiceInputUI.this.aqe(6);
        AppMethodBeat.o(31311);
        return true;
      }
    };
    this.ReD = new VoiceInputFooter.a()
    {
      public final void DW(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31312);
        if (paramAnonymousBoolean)
        {
          VoiceInputUI.e(VoiceInputUI.this).setVisibility(4);
          AppMethodBeat.o(31312);
          return;
        }
        VoiceInputUI.e(VoiceInputUI.this).setVisibility(0);
        AppMethodBeat.o(31312);
      }
      
      public final void hjW()
      {
        AppMethodBeat.i(31313);
        VoiceInputUI.this.aqe(8);
        AppMethodBeat.o(31313);
      }
    };
    this.FeO = false;
    this.ReE = false;
    AppMethodBeat.o(31316);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(31324);
    Log.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    com.tencent.mm.plugin.report.service.h.IzE.c(13905, locallog_13905);
    AppMethodBeat.o(31324);
  }
  
  private void rE(int paramInt)
  {
    AppMethodBeat.i(31325);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    localVoiceInputBehavior.textChangeCount = this.textChangeCount;
    localVoiceInputBehavior.textChangeReturn = paramInt;
    if (this.Rey != 0L)
    {
      localVoiceInputBehavior.textChangeTime = Util.ticksToNow(this.Rey);
      this.Rey = 0L;
    }
    a(localVoiceInputBehavior);
    AppMethodBeat.o(31325);
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(179757);
    if (paramInt <= 0)
    {
      this.ReE = true;
      if (this.FeO)
      {
        super.finish();
        AppMethodBeat.o(179757);
      }
    }
    else
    {
      this.ReE = false;
    }
    AppMethodBeat.o(179757);
  }
  
  public final void aqe(int paramInt)
  {
    AppMethodBeat.i(31323);
    Log.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", new Object[] { Integer.valueOf(paramInt), Util.getStack().toString() });
    this.FeO = true;
    aag localaag;
    if (paramInt == 8)
    {
      rE(7);
      localaag = new aag();
      if (paramInt != 7) {
        break label171;
      }
      localaag.fZx.action = 1;
      label72:
      if (!this.ReA) {
        break label199;
      }
    }
    label171:
    label199:
    for (localaag.fZx.fZy = 1;; localaag.fZx.fZy = 2)
    {
      localaag.fZx.result = this.Rev.getText().toString();
      localaag.fZx.userCode = this.userCode;
      if (this.Rew != null) {
        this.Rew.release();
      }
      EventCenter.instance.publish(localaag);
      Util.hideVKB(this.Rev);
      if (this.ReE) {
        super.finish();
      }
      AppMethodBeat.o(31323);
      return;
      rE(paramInt);
      break;
      if (paramInt == 8)
      {
        localaag.fZx.action = 4;
        break label72;
      }
      localaag.fZx.action = 2;
      break label72;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.elO;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(31317);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.msg = paramBundle.getStringExtra("text");
      this.offset = paramBundle.getIntExtra("offset", -1);
      this.Rex = paramBundle.getStringExtra("punctuation");
      this.userCode = paramBundle.getStringExtra("userCode");
    }
    this.Rey = Util.currentTicks();
    this.textChangeCount = 0;
    this.ReA = false;
    this.Rez = true;
    this.Rev = ((MMEditText)findViewById(R.h.dZX));
    this.uMw = ((Button)findViewById(R.h.dZW));
    this.Rev.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(31314);
        Log.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", new Object[] { Boolean.valueOf(VoiceInputUI.f(VoiceInputUI.this)), Boolean.valueOf(VoiceInputUI.g(VoiceInputUI.this)) });
        if (VoiceInputUI.f(VoiceInputUI.this))
        {
          VoiceInputUI.h(VoiceInputUI.this);
          AppMethodBeat.o(31314);
          return;
        }
        VoiceInputUI.d(VoiceInputUI.this);
        VoiceInputUI.c(VoiceInputUI.this).requestLayout();
        AppMethodBeat.o(31314);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.uMw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31315);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/VoiceInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new VoiceInputBehavior();
        paramAnonymousView.send = 3;
        VoiceInputUI.b(paramAnonymousView);
        VoiceInputUI.this.aqe(7);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31315);
      }
    });
    setMMTitle(getString(R.l.eUS));
    enableOptionMenu(true);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(31309);
        VoiceInputUI.this.aqe(1);
        AppMethodBeat.o(31309);
        return true;
      }
    });
    this.Rev.setOnTouchListener(this.ReB);
    this.Rev.bBa(this.msg);
    if (this.offset != -1) {
      this.Rev.setSelection(this.offset);
    }
    this.Rew = ((VoiceInputFooter)findViewById(R.h.say_footer));
    VoiceInputFooter localVoiceInputFooter = this.Rew;
    paramBundle = this.Rev;
    String str1 = this.Rex;
    String str2 = this.userCode;
    localVoiceInputFooter.KXu = paramBundle;
    paramBundle.setOnClickListener(new VoiceInputFooter.1(localVoiceInputFooter));
    paramBundle.setOnEditorActionListener(new VoiceInputFooter.2(localVoiceInputFooter));
    if (localVoiceInputFooter.RdV == null)
    {
      localVoiceInputFooter.RdV = new n(localVoiceInputFooter.getContext(), true, localVoiceInputFooter.KXu);
      localVoiceInputFooter.RdV.setCallback(new VoiceInputFooter.6(localVoiceInputFooter));
      localVoiceInputFooter.RdV.setPortHeightPX(com.tencent.mm.compatible.util.i.getValidPanelHeight(localVoiceInputFooter.getContext()));
    }
    localVoiceInputFooter.RdV.hmy();
    n localn = localVoiceInputFooter.RdV;
    Log.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(localn.RhU), Boolean.valueOf(localn.Rpa) });
    if (localn.Rpa)
    {
      localn.Rpa = false;
      View localView = localn.findViewById(R.h.eaa);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = localn.RhU;
      paramBundle = localLayoutParams;
      if (localLayoutParams == null) {
        paramBundle = new LinearLayout.LayoutParams(-1, i);
      }
      paramBundle.height = i;
      localView.setLayoutParams(paramBundle);
      localn.hmA();
      localn.requestLayout();
    }
    localVoiceInputFooter.RdV.setVisibility(8);
    localVoiceInputFooter.RdV.setToUser(str2);
    localVoiceInputFooter.RdV.setFullScreenData(str1);
    localVoiceInputFooter.FiY.addView(localVoiceInputFooter.RdV, -1, 0);
    this.Rew.setVoiceInputFooterListener(this.ReD);
    this.jij = new com.tencent.mm.ui.tools.i(this);
    this.jij.XSx = this;
    AppMethodBeat.o(31317);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(31320);
    super.onDestroy();
    AppMethodBeat.o(31320);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(31322);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      aqe(2);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(31322);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(31319);
    super.onPause();
    this.jij.close();
    AppMethodBeat.o(31319);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31318);
    super.onResume();
    this.Rev.requestFocus();
    this.jij.start();
    AppMethodBeat.o(31318);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(31321);
    aqe(3);
    super.onSwipeBack();
    AppMethodBeat.o(31321);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(179756);
    AppMethodBeat.at(this, paramBoolean);
    if (paramBoolean)
    {
      this.jij.start();
      AppMethodBeat.o(179756);
      return;
    }
    this.jij.close();
    AppMethodBeat.o(179756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI
 * JD-Core Version:    0.7.0.1
 */