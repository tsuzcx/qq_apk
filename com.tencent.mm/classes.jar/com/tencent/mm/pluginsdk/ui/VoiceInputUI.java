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
import com.tencent.mm.g.a.xx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.base.a(3)
public class VoiceInputUI
  extends MMActivity
  implements com.tencent.mm.ui.tools.g
{
  private MMEditText FmW;
  private VoiceInputFooter FmX;
  private String FmY;
  private long FmZ;
  private boolean Fna;
  private boolean Fnb;
  private View.OnTouchListener Fnc;
  private MenuItem.OnMenuItemClickListener Fnd;
  private VoiceInputFooter.a Fne;
  boolean Fnf;
  h fSZ;
  private String msg;
  private int offset;
  private Button pSk;
  private int textChangeCount;
  private String userCode;
  boolean wfu;
  
  public VoiceInputUI()
  {
    AppMethodBeat.i(31316);
    this.FmZ = 0L;
    this.textChangeCount = 0;
    this.Fna = true;
    this.Fnb = false;
    this.Fnc = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(31310);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/VoiceInputUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
            if (VoiceInputUI.b(VoiceInputUI.this).ffR())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.ffS();
              paramAnonymousView.setVisibility(8);
            }
            if (VoiceInputUI.b(VoiceInputUI.this).ehg())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.bFx();
              paramAnonymousView.setVisibility(8);
            }
            paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
            paramAnonymousView.setVisibility(0);
            if (paramAnonymousView.Fmy != null) {
              paramAnonymousView.Fmy.setImageResource(2131231701);
            }
          }
        }
      }
    };
    this.Fnd = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(31311);
        VoiceInputUI.c(VoiceInputUI.this).setText("");
        VoiceInputUI.d(VoiceInputUI.this);
        VoiceInputUI.this.rH(6);
        AppMethodBeat.o(31311);
        return true;
      }
    };
    this.Fne = new VoiceInputFooter.a()
    {
      public final void ffU()
      {
        AppMethodBeat.i(31313);
        VoiceInputUI.this.rH(8);
        AppMethodBeat.o(31313);
      }
      
      public final void vT(boolean paramAnonymousBoolean)
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
    this.wfu = false;
    this.Fnf = false;
    AppMethodBeat.o(31316);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(31324);
    ae.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    com.tencent.mm.plugin.report.service.g.yxI.c(13905, locallog_13905);
    AppMethodBeat.o(31324);
  }
  
  private void md(int paramInt)
  {
    AppMethodBeat.i(31325);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    localVoiceInputBehavior.textChangeCount = this.textChangeCount;
    localVoiceInputBehavior.textChangeReturn = paramInt;
    if (this.FmZ != 0L)
    {
      localVoiceInputBehavior.textChangeTime = bu.aO(this.FmZ);
      this.FmZ = 0L;
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
      this.FmY = paramBundle.getStringExtra("punctuation");
      this.userCode = paramBundle.getStringExtra("userCode");
    }
    this.FmZ = bu.HQ();
    this.textChangeCount = 0;
    this.Fnb = false;
    this.Fna = true;
    this.FmW = ((MMEditText)findViewById(2131306489));
    this.pSk = ((Button)findViewById(2131306488));
    this.FmW.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(31314);
        ae.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", new Object[] { Boolean.valueOf(VoiceInputUI.f(VoiceInputUI.this)), Boolean.valueOf(VoiceInputUI.g(VoiceInputUI.this)) });
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
    this.pSk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31315);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/VoiceInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new VoiceInputBehavior();
        paramAnonymousView.send = 3;
        VoiceInputUI.b(paramAnonymousView);
        VoiceInputUI.this.rH(7);
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
        VoiceInputUI.this.rH(1);
        AppMethodBeat.o(31309);
        return true;
      }
    });
    this.FmW.setOnTouchListener(this.Fnc);
    this.FmW.aZf(this.msg);
    if (this.offset != -1) {
      this.FmW.setSelection(this.offset);
    }
    this.FmX = ((VoiceInputFooter)findViewById(2131304290));
    VoiceInputFooter localVoiceInputFooter = this.FmX;
    paramBundle = this.FmW;
    String str1 = this.FmY;
    String str2 = this.userCode;
    localVoiceInputFooter.AzX = paramBundle;
    paramBundle.setOnClickListener(new VoiceInputFooter.1(localVoiceInputFooter));
    paramBundle.setOnEditorActionListener(new VoiceInputFooter.2(localVoiceInputFooter));
    if (localVoiceInputFooter.Fmx == null)
    {
      localVoiceInputFooter.Fmx = new n(localVoiceInputFooter.getContext(), true, localVoiceInputFooter.AzX);
      localVoiceInputFooter.Fmx.setCallback(new VoiceInputFooter.6(localVoiceInputFooter));
      localVoiceInputFooter.Fmx.setPortHeightPX(i.iN(localVoiceInputFooter.getContext()));
    }
    localVoiceInputFooter.Fmx.fin();
    n localn = localVoiceInputFooter.Fmx;
    ae.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(localn.Fqs), Boolean.valueOf(localn.Fxt) });
    if (localn.Fxt)
    {
      localn.Fxt = false;
      View localView = localn.findViewById(2131306495);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = localn.Fqs;
      paramBundle = localLayoutParams;
      if (localLayoutParams == null) {
        paramBundle = new LinearLayout.LayoutParams(-1, i);
      }
      paramBundle.height = i;
      localView.setLayoutParams(paramBundle);
      localn.fip();
      localn.requestLayout();
    }
    localVoiceInputFooter.Fmx.setVisibility(8);
    localVoiceInputFooter.Fmx.setToUser(str2);
    localVoiceInputFooter.Fmx.setFullScreenData(str1);
    localVoiceInputFooter.wjA.addView(localVoiceInputFooter.Fmx, -1, 0);
    this.FmX.setVoiceInputFooterListener(this.Fne);
    this.fSZ = new h(this);
    this.fSZ.Lfj = this;
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
      rH(2);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(31322);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(31319);
    super.onPause();
    this.fSZ.close();
    AppMethodBeat.o(31319);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31318);
    super.onResume();
    this.FmW.requestFocus();
    this.fSZ.start();
    AppMethodBeat.o(31318);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(31321);
    rH(3);
    super.onSwipeBack();
    AppMethodBeat.o(31321);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(179756);
    AppMethodBeat.at(this, paramBoolean);
    if (paramBoolean)
    {
      this.fSZ.start();
      AppMethodBeat.o(179756);
      return;
    }
    this.fSZ.close();
    AppMethodBeat.o(179756);
  }
  
  public final void rH(int paramInt)
  {
    AppMethodBeat.i(31323);
    ae.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", new Object[] { Integer.valueOf(paramInt), bu.fpN().toString() });
    this.wfu = true;
    xx localxx;
    if (paramInt == 8)
    {
      md(7);
      localxx = new xx();
      if (paramInt != 7) {
        break label172;
      }
      localxx.dNq.action = 1;
      label73:
      if (!this.Fnb) {
        break label200;
      }
    }
    label172:
    label200:
    for (localxx.dNq.dNr = 1;; localxx.dNq.dNr = 2)
    {
      localxx.dNq.result = this.FmW.getText().toString();
      localxx.dNq.userCode = this.userCode;
      if (this.FmX != null) {
        this.FmX.release();
      }
      com.tencent.mm.sdk.b.a.IvT.l(localxx);
      bu.hideVKB(this.FmW);
      if (this.Fnf) {
        super.finish();
      }
      AppMethodBeat.o(31323);
      return;
      md(paramInt);
      break;
      if (paramInt == 8)
      {
        localxx.dNq.action = 4;
        break label73;
      }
      localxx.dNq.action = 2;
      break label73;
    }
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(179757);
    if (paramInt <= 0)
    {
      this.Fnf = true;
      if (this.wfu)
      {
        super.finish();
        AppMethodBeat.o(179757);
      }
    }
    else
    {
      this.Fnf = false;
    }
    AppMethodBeat.o(179757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI
 * JD-Core Version:    0.7.0.1
 */