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
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.g.a.xa;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.base.a(3)
public class VoiceInputUI
  extends MMActivity
  implements g
{
  private long DpA;
  private boolean DpB;
  private boolean DpC;
  private View.OnTouchListener DpD;
  private MenuItem.OnMenuItemClickListener DpE;
  private VoiceInputFooter.a DpF;
  boolean DpG;
  private MMEditText Dpx;
  private VoiceInputFooter Dpy;
  private String Dpz;
  private String bIO;
  com.tencent.mm.ui.tools.h fxG;
  private int offset;
  private Button pie;
  private int textChangeCount;
  boolean uQg;
  private String userCode;
  
  public VoiceInputUI()
  {
    AppMethodBeat.i(31316);
    this.DpA = 0L;
    this.textChangeCount = 0;
    this.DpB = true;
    this.DpC = false;
    this.DpD = new View.OnTouchListener()
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
            if (VoiceInputUI.b(VoiceInputUI.this).eNe())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.eNf();
              paramAnonymousView.setVisibility(8);
            }
            if (VoiceInputUI.b(VoiceInputUI.this).dRh())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.bAD();
              paramAnonymousView.setVisibility(8);
            }
            paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
            paramAnonymousView.setVisibility(0);
            if (paramAnonymousView.DoZ != null) {
              paramAnonymousView.DoZ.setImageResource(2131231701);
            }
          }
        }
      }
    };
    this.DpE = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(31311);
        VoiceInputUI.c(VoiceInputUI.this).setText("");
        VoiceInputUI.d(VoiceInputUI.this);
        VoiceInputUI.this.re(6);
        AppMethodBeat.o(31311);
        return true;
      }
    };
    this.DpF = new VoiceInputFooter.a()
    {
      public final void eNh()
      {
        AppMethodBeat.i(31313);
        VoiceInputUI.this.re(8);
        AppMethodBeat.o(31313);
      }
      
      public final void va(boolean paramAnonymousBoolean)
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
    };
    this.uQg = false;
    this.DpG = false;
    AppMethodBeat.o(31316);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(31324);
    ac.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    com.tencent.mm.plugin.report.service.h.wUl.c(13905, locallog_13905);
    AppMethodBeat.o(31324);
  }
  
  private void lA(int paramInt)
  {
    AppMethodBeat.i(31325);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    localVoiceInputBehavior.textChangeCount = this.textChangeCount;
    localVoiceInputBehavior.textChangeReturn = paramInt;
    if (this.DpA != 0L)
    {
      localVoiceInputBehavior.textChangeTime = bs.aO(this.DpA);
      this.DpA = 0L;
    }
    a(localVoiceInputBehavior);
    AppMethodBeat.o(31325);
  }
  
  public int getLayoutId()
  {
    return 2131495860;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(31317);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.bIO = paramBundle.getStringExtra("text");
      this.offset = paramBundle.getIntExtra("offset", -1);
      this.Dpz = paramBundle.getStringExtra("punctuation");
      this.userCode = paramBundle.getStringExtra("userCode");
    }
    this.DpA = bs.Gn();
    this.textChangeCount = 0;
    this.DpC = false;
    this.DpB = true;
    this.Dpx = ((MMEditText)findViewById(2131306489));
    this.pie = ((Button)findViewById(2131306488));
    this.Dpx.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(31314);
        ac.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", new Object[] { Boolean.valueOf(VoiceInputUI.f(VoiceInputUI.this)), Boolean.valueOf(VoiceInputUI.g(VoiceInputUI.this)) });
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
    this.pie.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31315);
        paramAnonymousView = new VoiceInputBehavior();
        paramAnonymousView.send = 3;
        VoiceInputUI.b(paramAnonymousView);
        VoiceInputUI.this.re(7);
        AppMethodBeat.o(31315);
      }
    });
    setMMTitle(getString(2131764729));
    enableOptionMenu(true);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(31309);
        VoiceInputUI.this.re(1);
        AppMethodBeat.o(31309);
        return true;
      }
    });
    this.Dpx.setOnTouchListener(this.DpD);
    this.Dpx.aRF(this.bIO);
    if (this.offset != -1) {
      this.Dpx.setSelection(this.offset);
    }
    this.Dpy = ((VoiceInputFooter)findViewById(2131304290));
    VoiceInputFooter localVoiceInputFooter = this.Dpy;
    paramBundle = this.Dpx;
    String str1 = this.Dpz;
    String str2 = this.userCode;
    localVoiceInputFooter.yRm = paramBundle;
    paramBundle.setOnClickListener(new VoiceInputFooter.1(localVoiceInputFooter));
    paramBundle.setOnEditorActionListener(new VoiceInputFooter.2(localVoiceInputFooter));
    if (localVoiceInputFooter.DoY == null)
    {
      localVoiceInputFooter.DoY = new n(localVoiceInputFooter.getContext(), true, localVoiceInputFooter.yRm);
      localVoiceInputFooter.DoY.setCallback(new VoiceInputFooter.6(localVoiceInputFooter));
      localVoiceInputFooter.DoY.setPortHeightPX(i.iy(localVoiceInputFooter.getContext()));
    }
    localVoiceInputFooter.DoY.ePv();
    n localn = localVoiceInputFooter.DoY;
    ac.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(localn.DsU), Boolean.valueOf(localn.DzM) });
    if (localn.DzM)
    {
      localn.DzM = false;
      View localView = localn.findViewById(2131306495);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = localn.DsU;
      paramBundle = localLayoutParams;
      if (localLayoutParams == null) {
        paramBundle = new LinearLayout.LayoutParams(-1, i);
      }
      paramBundle.height = i;
      localView.setLayoutParams(paramBundle);
      localn.ePx();
      localn.requestLayout();
    }
    localVoiceInputFooter.DoY.setVisibility(8);
    localVoiceInputFooter.DoY.setToUser(str2);
    localVoiceInputFooter.DoY.setFullScreenData(str1);
    localVoiceInputFooter.uUm.addView(localVoiceInputFooter.DoY, -1, 0);
    this.Dpy.setVoiceInputFooterListener(this.DpF);
    this.fxG = new com.tencent.mm.ui.tools.h(this);
    this.fxG.IRL = this;
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
      re(2);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(31322);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(31319);
    super.onPause();
    this.fxG.close();
    AppMethodBeat.o(31319);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31318);
    super.onResume();
    this.Dpx.requestFocus();
    this.fxG.start();
    AppMethodBeat.o(31318);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(31321);
    re(3);
    super.onSwipeBack();
    AppMethodBeat.o(31321);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(179756);
    if (paramBoolean)
    {
      this.fxG.start();
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(179756);
      return;
    }
    this.fxG.close();
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(179756);
  }
  
  public final void re(int paramInt)
  {
    AppMethodBeat.i(31323);
    ac.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", new Object[] { Integer.valueOf(paramInt), bs.eWi().toString() });
    this.uQg = true;
    xa localxa;
    if (paramInt == 8)
    {
      lA(7);
      localxa = new xa();
      if (paramInt != 7) {
        break label172;
      }
      localxa.dzP.action = 1;
      label73:
      if (!this.DpC) {
        break label200;
      }
    }
    label172:
    label200:
    for (localxa.dzP.dzQ = 1;; localxa.dzP.dzQ = 2)
    {
      localxa.dzP.result = this.Dpx.getText().toString();
      localxa.dzP.userCode = this.userCode;
      if (this.Dpy != null) {
        this.Dpy.release();
      }
      com.tencent.mm.sdk.b.a.GpY.l(localxa);
      bs.hideVKB(this.Dpx);
      if (this.DpG) {
        super.finish();
      }
      AppMethodBeat.o(31323);
      return;
      lA(paramInt);
      break;
      if (paramInt == 8)
      {
        localxa.dzP.action = 4;
        break label73;
      }
      localxa.dzP.action = 2;
      break label73;
    }
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(179757);
    if (paramInt <= 0)
    {
      this.DpG = true;
      if (this.uQg)
      {
        super.finish();
        AppMethodBeat.o(179757);
      }
    }
    else
    {
      this.DpG = false;
    }
    AppMethodBeat.o(179757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI
 * JD-Core Version:    0.7.0.1
 */