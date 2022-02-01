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
import com.tencent.mm.g.a.wp;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.base.a(3)
public class VoiceInputUI
  extends MMActivity
  implements g
{
  private MMEditText BXg;
  private VoiceInputFooter BXh;
  private String BXi;
  private long BXj;
  private boolean BXk;
  private boolean BXl;
  private View.OnTouchListener BXm;
  private MenuItem.OnMenuItemClickListener BXn;
  private VoiceInputFooter.a BXo;
  boolean BXp;
  private String bLg;
  com.tencent.mm.ui.tools.h ftZ;
  private Button oEE;
  private int offset;
  boolean tHK;
  private int textChangeCount;
  private String userCode;
  
  public VoiceInputUI()
  {
    AppMethodBeat.i(31316);
    this.BXj = 0L;
    this.textChangeCount = 0;
    this.BXk = true;
    this.BXl = false;
    this.BXm = new View.OnTouchListener()
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
            if (VoiceInputUI.b(VoiceInputUI.this).exK())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.exL();
              paramAnonymousView.setVisibility(8);
            }
            if (VoiceInputUI.b(VoiceInputUI.this).dCK())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.btD();
              paramAnonymousView.setVisibility(8);
            }
            paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
            paramAnonymousView.setVisibility(0);
            if (paramAnonymousView.BWI != null) {
              paramAnonymousView.BWI.setImageResource(2131231701);
            }
          }
        }
      }
    };
    this.BXn = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(31311);
        VoiceInputUI.c(VoiceInputUI.this).setText("");
        VoiceInputUI.d(VoiceInputUI.this);
        VoiceInputUI.this.qr(6);
        AppMethodBeat.o(31311);
        return true;
      }
    };
    this.BXo = new VoiceInputFooter.a()
    {
      public final void exN()
      {
        AppMethodBeat.i(31313);
        VoiceInputUI.this.qr(8);
        AppMethodBeat.o(31313);
      }
      
      public final void tZ(boolean paramAnonymousBoolean)
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
    this.tHK = false;
    this.BXp = false;
    AppMethodBeat.o(31316);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(31324);
    ad.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    com.tencent.mm.plugin.report.service.h.vKh.c(13905, locallog_13905);
    AppMethodBeat.o(31324);
  }
  
  private void lI(int paramInt)
  {
    AppMethodBeat.i(31325);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    localVoiceInputBehavior.textChangeCount = this.textChangeCount;
    localVoiceInputBehavior.textChangeReturn = paramInt;
    if (this.BXj != 0L)
    {
      localVoiceInputBehavior.textChangeTime = bt.aS(this.BXj);
      this.BXj = 0L;
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
      this.bLg = paramBundle.getStringExtra("text");
      this.offset = paramBundle.getIntExtra("offset", -1);
      this.BXi = paramBundle.getStringExtra("punctuation");
      this.userCode = paramBundle.getStringExtra("userCode");
    }
    this.BXj = bt.GC();
    this.textChangeCount = 0;
    this.BXl = false;
    this.BXk = true;
    this.BXg = ((MMEditText)findViewById(2131306489));
    this.oEE = ((Button)findViewById(2131306488));
    this.BXg.addTextChangedListener(new TextWatcher()
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
    this.oEE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31315);
        paramAnonymousView = new VoiceInputBehavior();
        paramAnonymousView.send = 3;
        VoiceInputUI.b(paramAnonymousView);
        VoiceInputUI.this.qr(7);
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
        VoiceInputUI.this.qr(1);
        AppMethodBeat.o(31309);
        return true;
      }
    });
    this.BXg.setOnTouchListener(this.BXm);
    this.BXg.aMd(this.bLg);
    if (this.offset != -1) {
      this.BXg.setSelection(this.offset);
    }
    this.BXh = ((VoiceInputFooter)findViewById(2131304290));
    VoiceInputFooter localVoiceInputFooter = this.BXh;
    paramBundle = this.BXg;
    String str1 = this.BXi;
    String str2 = this.userCode;
    localVoiceInputFooter.xEy = paramBundle;
    paramBundle.setOnClickListener(new VoiceInputFooter.1(localVoiceInputFooter));
    paramBundle.setOnEditorActionListener(new VoiceInputFooter.2(localVoiceInputFooter));
    if (localVoiceInputFooter.BWH == null)
    {
      localVoiceInputFooter.BWH = new n(localVoiceInputFooter.getContext(), true, localVoiceInputFooter.xEy);
      localVoiceInputFooter.BWH.setCallback(new VoiceInputFooter.6(localVoiceInputFooter));
      localVoiceInputFooter.BWH.setPortHeightPX(i.in(localVoiceInputFooter.getContext()));
    }
    localVoiceInputFooter.BWH.eAb();
    n localn = localVoiceInputFooter.BWH;
    ad.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(localn.CaE), Boolean.valueOf(localn.Chv) });
    if (localn.Chv)
    {
      localn.Chv = false;
      View localView = localn.findViewById(2131306495);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = localn.CaE;
      paramBundle = localLayoutParams;
      if (localLayoutParams == null) {
        paramBundle = new LinearLayout.LayoutParams(-1, i);
      }
      paramBundle.height = i;
      localView.setLayoutParams(paramBundle);
      localn.eAd();
      localn.requestLayout();
    }
    localVoiceInputFooter.BWH.setVisibility(8);
    localVoiceInputFooter.BWH.setToUser(str2);
    localVoiceInputFooter.BWH.setFullScreenData(str1);
    localVoiceInputFooter.tLI.addView(localVoiceInputFooter.BWH, -1, 0);
    this.BXh.setVoiceInputFooterListener(this.BXo);
    this.ftZ = new com.tencent.mm.ui.tools.h(this);
    this.ftZ.Hro = this;
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
      qr(2);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(31322);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(31319);
    super.onPause();
    this.ftZ.close();
    AppMethodBeat.o(31319);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31318);
    super.onResume();
    this.BXg.requestFocus();
    this.ftZ.start();
    AppMethodBeat.o(31318);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(31321);
    qr(3);
    super.onSwipeBack();
    AppMethodBeat.o(31321);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(179756);
    if (paramBoolean)
    {
      this.ftZ.start();
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(179756);
      return;
    }
    this.ftZ.close();
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(179756);
  }
  
  public final void qr(int paramInt)
  {
    AppMethodBeat.i(31323);
    ad.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", new Object[] { Integer.valueOf(paramInt), bt.eGN().toString() });
    this.tHK = true;
    wp localwp;
    if (paramInt == 8)
    {
      lI(7);
      localwp = new wp();
      if (paramInt != 7) {
        break label172;
      }
      localwp.dCb.action = 1;
      label73:
      if (!this.BXl) {
        break label200;
      }
    }
    label172:
    label200:
    for (localwp.dCb.dCc = 1;; localwp.dCb.dCc = 2)
    {
      localwp.dCb.result = this.BXg.getText().toString();
      localwp.dCb.userCode = this.userCode;
      if (this.BXh != null) {
        this.BXh.release();
      }
      com.tencent.mm.sdk.b.a.ESL.l(localwp);
      bt.hideVKB(this.BXg);
      if (this.BXp) {
        super.finish();
      }
      AppMethodBeat.o(31323);
      return;
      lI(paramInt);
      break;
      if (paramInt == 8)
      {
        localwp.dCb.action = 4;
        break label73;
      }
      localwp.dCb.action = 2;
      break label73;
    }
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(179757);
    if (paramInt <= 0)
    {
      this.BXp = true;
      if (this.tHK)
      {
        super.finish();
        AppMethodBeat.o(179757);
      }
    }
    else
    {
      this.BXp = false;
    }
    AppMethodBeat.o(179757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI
 * JD-Core Version:    0.7.0.1
 */