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
import com.tencent.mm.g.a.xt;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.base.a(3)
public class VoiceInputUI
  extends MMActivity
  implements com.tencent.mm.ui.tools.g
{
  private MMEditText EUB;
  private VoiceInputFooter EUC;
  private String EUD;
  private long EUE;
  private boolean EUF;
  private boolean EUG;
  private View.OnTouchListener EUH;
  private MenuItem.OnMenuItemClickListener EUI;
  private VoiceInputFooter.a EUJ;
  boolean EUK;
  h fQT;
  private String msg;
  private int offset;
  private Button pLF;
  private int textChangeCount;
  private String userCode;
  boolean vTq;
  
  public VoiceInputUI()
  {
    AppMethodBeat.i(31316);
    this.EUE = 0L;
    this.textChangeCount = 0;
    this.EUF = true;
    this.EUG = false;
    this.EUH = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(31310);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/VoiceInputUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (paramAnonymousMotionEvent.getAction() == 0) {
          VoiceInputUI.a(VoiceInputUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/VoiceInputUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(31310);
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1)
          {
            if (VoiceInputUI.b(VoiceInputUI.this).fcd())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.fce();
              paramAnonymousView.setVisibility(8);
            }
            if (VoiceInputUI.b(VoiceInputUI.this).edz())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.bEF();
              paramAnonymousView.setVisibility(8);
            }
            paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
            paramAnonymousView.setVisibility(0);
            if (paramAnonymousView.EUd != null) {
              paramAnonymousView.EUd.setImageResource(2131231701);
            }
          }
        }
      }
    };
    this.EUI = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(31311);
        VoiceInputUI.c(VoiceInputUI.this).setText("");
        VoiceInputUI.d(VoiceInputUI.this);
        VoiceInputUI.this.rE(6);
        AppMethodBeat.o(31311);
        return true;
      }
    };
    this.EUJ = new VoiceInputFooter.a()
    {
      public final void fcg()
      {
        AppMethodBeat.i(31313);
        VoiceInputUI.this.rE(8);
        AppMethodBeat.o(31313);
      }
      
      public final void vL(boolean paramAnonymousBoolean)
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
    this.vTq = false;
    this.EUK = false;
    AppMethodBeat.o(31316);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(31324);
    ad.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    com.tencent.mm.plugin.report.service.g.yhR.c(13905, locallog_13905);
    AppMethodBeat.o(31324);
  }
  
  private void ma(int paramInt)
  {
    AppMethodBeat.i(31325);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    localVoiceInputBehavior.textChangeCount = this.textChangeCount;
    localVoiceInputBehavior.textChangeReturn = paramInt;
    if (this.EUE != 0L)
    {
      localVoiceInputBehavior.textChangeTime = bt.aO(this.EUE);
      this.EUE = 0L;
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
      this.msg = paramBundle.getStringExtra("text");
      this.offset = paramBundle.getIntExtra("offset", -1);
      this.EUD = paramBundle.getStringExtra("punctuation");
      this.userCode = paramBundle.getStringExtra("userCode");
    }
    this.EUE = bt.HI();
    this.textChangeCount = 0;
    this.EUG = false;
    this.EUF = true;
    this.EUB = ((MMEditText)findViewById(2131306489));
    this.pLF = ((Button)findViewById(2131306488));
    this.EUB.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(31314);
        ad.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", new Object[] { Boolean.valueOf(VoiceInputUI.f(VoiceInputUI.this)), Boolean.valueOf(VoiceInputUI.g(VoiceInputUI.this)) });
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
    this.pLF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31315);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/VoiceInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new VoiceInputBehavior();
        paramAnonymousView.send = 3;
        VoiceInputUI.b(paramAnonymousView);
        VoiceInputUI.this.rE(7);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        VoiceInputUI.this.rE(1);
        AppMethodBeat.o(31309);
        return true;
      }
    });
    this.EUB.setOnTouchListener(this.EUH);
    this.EUB.aXD(this.msg);
    if (this.offset != -1) {
      this.EUB.setSelection(this.offset);
    }
    this.EUC = ((VoiceInputFooter)findViewById(2131304290));
    VoiceInputFooter localVoiceInputFooter = this.EUC;
    paramBundle = this.EUB;
    String str1 = this.EUD;
    String str2 = this.userCode;
    localVoiceInputFooter.AiM = paramBundle;
    paramBundle.setOnClickListener(new VoiceInputFooter.1(localVoiceInputFooter));
    paramBundle.setOnEditorActionListener(new VoiceInputFooter.2(localVoiceInputFooter));
    if (localVoiceInputFooter.EUc == null)
    {
      localVoiceInputFooter.EUc = new n(localVoiceInputFooter.getContext(), true, localVoiceInputFooter.AiM);
      localVoiceInputFooter.EUc.setCallback(new VoiceInputFooter.6(localVoiceInputFooter));
      localVoiceInputFooter.EUc.setPortHeightPX(i.iI(localVoiceInputFooter.getContext()));
    }
    localVoiceInputFooter.EUc.fex();
    n localn = localVoiceInputFooter.EUc;
    ad.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(localn.EXY), Boolean.valueOf(localn.FeV) });
    if (localn.FeV)
    {
      localn.FeV = false;
      View localView = localn.findViewById(2131306495);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = localn.EXY;
      paramBundle = localLayoutParams;
      if (localLayoutParams == null) {
        paramBundle = new LinearLayout.LayoutParams(-1, i);
      }
      paramBundle.height = i;
      localView.setLayoutParams(paramBundle);
      localn.fez();
      localn.requestLayout();
    }
    localVoiceInputFooter.EUc.setVisibility(8);
    localVoiceInputFooter.EUc.setToUser(str2);
    localVoiceInputFooter.EUc.setFullScreenData(str1);
    localVoiceInputFooter.vXw.addView(localVoiceInputFooter.EUc, -1, 0);
    this.EUC.setVoiceInputFooterListener(this.EUJ);
    this.fQT = new h(this);
    this.fQT.KIP = this;
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
      rE(2);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(31322);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(31319);
    super.onPause();
    this.fQT.close();
    AppMethodBeat.o(31319);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31318);
    super.onResume();
    this.EUB.requestFocus();
    this.fQT.start();
    AppMethodBeat.o(31318);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(31321);
    rE(3);
    super.onSwipeBack();
    AppMethodBeat.o(31321);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(179756);
    if (paramBoolean)
    {
      this.fQT.start();
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(179756);
      return;
    }
    this.fQT.close();
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(179756);
  }
  
  public final void rE(int paramInt)
  {
    AppMethodBeat.i(31323);
    ad.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", new Object[] { Integer.valueOf(paramInt), bt.flS().toString() });
    this.vTq = true;
    xt localxt;
    if (paramInt == 8)
    {
      ma(7);
      localxt = new xt();
      if (paramInt != 7) {
        break label172;
      }
      localxt.dMb.action = 1;
      label73:
      if (!this.EUG) {
        break label200;
      }
    }
    label172:
    label200:
    for (localxt.dMb.dMc = 1;; localxt.dMb.dMc = 2)
    {
      localxt.dMb.result = this.EUB.getText().toString();
      localxt.dMb.userCode = this.userCode;
      if (this.EUC != null) {
        this.EUC.release();
      }
      com.tencent.mm.sdk.b.a.IbL.l(localxt);
      bt.hideVKB(this.EUB);
      if (this.EUK) {
        super.finish();
      }
      AppMethodBeat.o(31323);
      return;
      ma(paramInt);
      break;
      if (paramInt == 8)
      {
        localxt.dMb.action = 4;
        break label73;
      }
      localxt.dMb.action = 2;
      break label73;
    }
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(179757);
    if (paramInt <= 0)
    {
      this.EUK = true;
      if (this.vTq)
      {
        super.finish();
        AppMethodBeat.o(179757);
      }
    }
    else
    {
      this.EUK = false;
    }
    AppMethodBeat.o(179757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI
 * JD-Core Version:    0.7.0.1
 */