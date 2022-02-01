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
import com.tencent.mm.autogen.a.acd;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.base.a(3)
public class VoiceInputUI
  extends MMActivity
  implements com.tencent.mm.ui.tools.h
{
  boolean Lax;
  private MMEditText YaA;
  private VoiceInputFooter YaB;
  private String YaC;
  private long YaD;
  private boolean YaE;
  private boolean YaF;
  private View.OnTouchListener YaG;
  private MenuItem.OnMenuItemClickListener YaH;
  private VoiceInputFooter.a YaI;
  boolean YaJ;
  private String ifG;
  i lKz;
  private String msg;
  private int offset;
  private int textChangeCount;
  private Button xUY;
  
  public VoiceInputUI()
  {
    AppMethodBeat.i(31316);
    this.YaD = 0L;
    this.textChangeCount = 0;
    this.YaE = true;
    this.YaF = false;
    this.YaG = new View.OnTouchListener()
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
            if (VoiceInputUI.b(VoiceInputUI.this).iKL())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.iKM();
              paramAnonymousView.setVisibility(8);
            }
            if (VoiceInputUI.b(VoiceInputUI.this).hqp())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.aWJ();
              paramAnonymousView.setVisibility(8);
            }
            paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
            paramAnonymousView.setVisibility(0);
            if (paramAnonymousView.Yac != null) {
              paramAnonymousView.Yac.setImageResource(R.g.chatting_setmode_biaoqing_btn);
            }
          }
        }
      }
    };
    this.YaH = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(31311);
        VoiceInputUI.c(VoiceInputUI.this).setText("");
        VoiceInputUI.d(VoiceInputUI.this);
        VoiceInputUI.this.awi(6);
        AppMethodBeat.o(31311);
        return true;
      }
    };
    this.YaI = new VoiceInputFooter.a()
    {
      public final void JF(boolean paramAnonymousBoolean)
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
      
      public final void iKO()
      {
        AppMethodBeat.i(31313);
        VoiceInputUI.this.awi(8);
        AppMethodBeat.o(31313);
      }
    };
    this.Lax = false;
    this.YaJ = false;
    AppMethodBeat.o(31316);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(31324);
    Log.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    com.tencent.mm.plugin.report.service.h.OAn.c(13905, locallog_13905);
    AppMethodBeat.o(31324);
  }
  
  private void rG(int paramInt)
  {
    AppMethodBeat.i(31325);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    localVoiceInputBehavior.textChangeCount = this.textChangeCount;
    localVoiceInputBehavior.textChangeReturn = paramInt;
    if (this.YaD != 0L)
    {
      localVoiceInputBehavior.textChangeTime = Util.ticksToNow(this.YaD);
      this.YaD = 0L;
    }
    a(localVoiceInputBehavior);
    AppMethodBeat.o(31325);
  }
  
  public final void awi(int paramInt)
  {
    AppMethodBeat.i(31323);
    Log.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", new Object[] { Integer.valueOf(paramInt), Util.getStack().toString() });
    this.Lax = true;
    acd localacd;
    if (paramInt == 8)
    {
      rG(7);
      localacd = new acd();
      if (paramInt != 7) {
        break label168;
      }
      localacd.ifE.action = 1;
      label72:
      if (!this.YaF) {
        break label196;
      }
    }
    label168:
    label196:
    for (localacd.ifE.ifF = 1;; localacd.ifE.ifF = 2)
    {
      localacd.ifE.result = this.YaA.getText().toString();
      localacd.ifE.ifG = this.ifG;
      if (this.YaB != null) {
        this.YaB.release();
      }
      localacd.publish();
      Util.hideVKB(this.YaA);
      if (this.YaJ) {
        super.finish();
      }
      AppMethodBeat.o(31323);
      return;
      rG(paramInt);
      break;
      if (paramInt == 8)
      {
        localacd.ifE.action = 4;
        break label72;
      }
      localacd.ifE.action = 2;
      break label72;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.goS;
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
      this.YaC = paramBundle.getStringExtra("punctuation");
      this.ifG = paramBundle.getStringExtra("userCode");
    }
    this.YaD = Util.currentTicks();
    this.textChangeCount = 0;
    this.YaF = false;
    this.YaE = true;
    this.YaA = ((MMEditText)findViewById(R.h.gcL));
    this.xUY = ((Button)findViewById(R.h.gcK));
    this.YaA.addTextChangedListener(new TextWatcher()
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
    this.xUY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31315);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/VoiceInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new VoiceInputBehavior();
        paramAnonymousView.send = 3;
        VoiceInputUI.b(paramAnonymousView);
        VoiceInputUI.this.awi(7);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31315);
      }
    });
    setMMTitle(getString(R.l.gXT));
    enableOptionMenu(true);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(31309);
        VoiceInputUI.this.awi(1);
        AppMethodBeat.o(31309);
        return true;
      }
    });
    this.YaA.setOnTouchListener(this.YaG);
    this.YaA.bDt(this.msg);
    if (this.offset != -1) {
      this.YaA.setSelection(this.offset);
    }
    this.YaB = ((VoiceInputFooter)findViewById(R.h.say_footer));
    VoiceInputFooter localVoiceInputFooter = this.YaB;
    paramBundle = this.YaA;
    String str1 = this.YaC;
    String str2 = this.ifG;
    localVoiceInputFooter.Rxv = paramBundle;
    paramBundle.setOnClickListener(new VoiceInputFooter.1(localVoiceInputFooter));
    paramBundle.setOnEditorActionListener(new VoiceInputFooter.2(localVoiceInputFooter));
    if (localVoiceInputFooter.Yab == null)
    {
      localVoiceInputFooter.Yab = new n(localVoiceInputFooter.getContext(), true, localVoiceInputFooter.Rxv);
      localVoiceInputFooter.Yab.setCallback(new VoiceInputFooter.6(localVoiceInputFooter));
      localVoiceInputFooter.Yab.setPortHeightPX(j.getValidPanelHeight(localVoiceInputFooter.getContext()));
    }
    localVoiceInputFooter.Yab.iNo();
    n localn = localVoiceInputFooter.Yab;
    Log.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(localn.Yea), Boolean.valueOf(localn.Ylr) });
    if (localn.Ylr)
    {
      localn.Ylr = false;
      View localView = localn.findViewById(R.h.gcO);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = localn.Yea;
      paramBundle = localLayoutParams;
      if (localLayoutParams == null) {
        paramBundle = new LinearLayout.LayoutParams(-1, i);
      }
      paramBundle.height = i;
      localView.setLayoutParams(paramBundle);
      localn.iNq();
      localn.requestLayout();
    }
    localVoiceInputFooter.Yab.setVisibility(8);
    localVoiceInputFooter.Yab.setToUser(str2);
    localVoiceInputFooter.Yab.setFullScreenData(str1);
    localVoiceInputFooter.ybr.addView(localVoiceInputFooter.Yab, -1, 0);
    this.YaB.setVoiceInputFooterListener(this.YaI);
    this.lKz = new i(this);
    this.lKz.afIL = this;
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
      awi(2);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(31322);
    return bool;
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(179757);
    if (paramInt <= 0)
    {
      this.YaJ = true;
      if (this.Lax)
      {
        super.finish();
        AppMethodBeat.o(179757);
      }
    }
    else
    {
      this.YaJ = false;
    }
    AppMethodBeat.o(179757);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(31319);
    super.onPause();
    this.lKz.close();
    AppMethodBeat.o(31319);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31318);
    super.onResume();
    this.YaA.requestFocus();
    this.lKz.start();
    AppMethodBeat.o(31318);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(31321);
    awi(3);
    super.onSwipeBack();
    AppMethodBeat.o(31321);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(179756);
    AppMethodBeat.at(this, paramBoolean);
    if (paramBoolean)
    {
      this.lKz.start();
      AppMethodBeat.o(179756);
      return;
    }
    this.lKz.close();
    AppMethodBeat.o(179756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI
 * JD-Core Version:    0.7.0.1
 */