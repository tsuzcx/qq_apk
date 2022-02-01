package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputConnection;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter
  extends LinearLayout
{
  private View BwA;
  public MMEditText BwB;
  public LinearLayout BwC;
  public boolean BwD;
  private int BwE;
  private WebViewInputFooter.c Bwu;
  private WebViewInputFooter.a Bwv;
  private b Bww;
  private WebViewSmileyPanel Bwx;
  public View Bwy;
  private View Bwz;
  public MMActivity imP;
  private ImageButton mcY;
  public int state;
  private boolean tqy;
  
  public WebViewInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82316);
    this.state = 0;
    this.BwE = 2147483647;
    this.tqy = true;
    this.imP = ((MMActivity)paramContext);
    paramContext = (ViewGroup)View.inflate(this.imP, 2131496084, this);
    this.BwC = ((LinearLayout)paramContext.findViewById(2131306914));
    this.Bwz = paramContext.findViewById(2131306918);
    this.BwA = paramContext.findViewById(2131306917);
    this.Bwy = paramContext.findViewById(2131306919);
    this.BwB = ((MMEditText)paramContext.findViewById(2131306915));
    this.mcY = ((ImageButton)paramContext.findViewById(2131306920));
    this.mcY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82308);
        if (WebViewInputFooter.a(WebViewInputFooter.this) == 0)
        {
          WebViewInputFooter.b(WebViewInputFooter.this).hideVKB();
          if (!WebViewInputFooter.c(WebViewInputFooter.this)) {
            WebViewInputFooter.d(WebViewInputFooter.this).requestFocus();
          }
          WebViewInputFooter.e(WebViewInputFooter.this);
          WebViewInputFooter.f(WebViewInputFooter.this).setImageResource(2131690564);
          WebViewInputFooter.a(WebViewInputFooter.this, 1);
          WebViewInputFooter.g(WebViewInputFooter.this);
          AppMethodBeat.o(82308);
          return;
        }
        WebViewInputFooter.g(WebViewInputFooter.this);
        WebViewInputFooter.d(WebViewInputFooter.this).requestFocus();
        WebViewInputFooter.b(WebViewInputFooter.this).showVKB();
        WebViewInputFooter.h(WebViewInputFooter.this);
        WebViewInputFooter.a(WebViewInputFooter.this, 0);
        AppMethodBeat.o(82308);
      }
    });
    this.BwB.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(82309);
        WebViewInputFooter.g(WebViewInputFooter.this);
        WebViewInputFooter.i(WebViewInputFooter.this).setVisibility(8);
        WebViewInputFooter.i(WebViewInputFooter.this);
        WebViewInputFooter.f(WebViewInputFooter.this).setImageResource(2131231701);
        WebViewInputFooter.a(WebViewInputFooter.this, 0);
        AppMethodBeat.o(82309);
        return false;
      }
    });
    this.Bwx = new WebViewSmileyPanel(getContext());
    this.Bwx.setVisibility(8);
    this.Bwx.setBackgroundResource(2131234802);
    this.Bwx.setOnTextOperationListener(new WebViewSmileyPanel.a()
    {
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(82310);
        try
        {
          if (WebViewInputFooter.c(WebViewInputFooter.this))
          {
            WebViewInputFooter.j(WebViewInputFooter.this).NL(paramAnonymousString);
            AppMethodBeat.o(82310);
            return;
          }
          WebViewInputFooter.this.BwB.aMd(paramAnonymousString);
          AppMethodBeat.o(82310);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(82310);
        }
      }
      
      public final void btF()
      {
        AppMethodBeat.i(82311);
        if ((WebViewInputFooter.c(WebViewInputFooter.this)) && (WebViewInputFooter.j(WebViewInputFooter.this) != null))
        {
          WebViewInputFooter.j(WebViewInputFooter.this).NL("[DELETE_EMOTION]");
          AppMethodBeat.o(82311);
          return;
        }
        if (WebViewInputFooter.d(WebViewInputFooter.this) != null)
        {
          MMEditText localMMEditText = WebViewInputFooter.d(WebViewInputFooter.this);
          if (localMMEditText.getInputConnection() != null)
          {
            localMMEditText.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
            localMMEditText.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.o(82311);
            return;
          }
          localMMEditText.dispatchKeyEvent(new KeyEvent(0, 67));
          localMMEditText.dispatchKeyEvent(new KeyEvent(1, 67));
        }
        AppMethodBeat.o(82311);
      }
    });
    ((LinearLayout)findViewById(2131304239)).addView(this.Bwx, -1, 0);
    this.BwA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82314);
        paramAnonymousView = com.tencent.mm.ui.tools.b.c.d(WebViewInputFooter.d(WebViewInputFooter.this)).aaj(WebViewInputFooter.l(WebViewInputFooter.this));
        paramAnonymousView.mcf = f.a.Hrl;
        paramAnonymousView.HuM = true;
        paramAnonymousView.a(new c.a()
        {
          public final void CH(String paramAnonymous2String)
          {
            AppMethodBeat.i(82312);
            if (WebViewInputFooter.k(WebViewInputFooter.this) != null) {
              WebViewInputFooter.k(WebViewInputFooter.this).awg(WebViewInputFooter.d(WebViewInputFooter.this).getText().toString());
            }
            paramAnonymous2String = WebViewInputFooter.this;
            paramAnonymous2String.BwB.clearComposingText();
            paramAnonymous2String.BwB.setText("");
            AppMethodBeat.o(82312);
          }
          
          public final void aKr() {}
          
          public final void ck(String paramAnonymous2String)
          {
            AppMethodBeat.i(164038);
            if (WebViewInputFooter.b(WebViewInputFooter.this) != null) {
              Toast.makeText(WebViewInputFooter.b(WebViewInputFooter.this), "exceed max-length", 0).show();
            }
            AppMethodBeat.o(164038);
          }
        });
        AppMethodBeat.o(82314);
      }
    });
    this.BwB.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(82315);
        if (WebViewInputFooter.d(WebViewInputFooter.this).getText() == null)
        {
          AppMethodBeat.o(82315);
          return;
        }
        WebViewInputFooter.d(WebViewInputFooter.this).requestFocus();
        if ((paramAnonymousEditable.length() > 0) && (paramAnonymousEditable.toString().trim().length() > 0)) {}
        for (boolean bool = true;; bool = false)
        {
          WebViewInputFooter.a(WebViewInputFooter.this, bool);
          AppMethodBeat.o(82315);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    AppMethodBeat.o(82316);
  }
  
  private void btD()
  {
    AppMethodBeat.i(82318);
    if (this.Bww != null) {
      this.Bww.elg();
    }
    this.Bwx.setVisibility(8);
    this.mcY.setImageResource(2131690564);
    this.state = 0;
    AppMethodBeat.o(82318);
  }
  
  private int eoC()
  {
    AppMethodBeat.i(82317);
    if (this.Bww != null) {
      this.Bww.elf();
    }
    if (this.BwB != null) {
      this.imP.hideVKB(this.BwB);
    }
    this.Bwx.setVisibility(0);
    Object localObject = this.Bwx;
    if (((WebViewSmileyPanel)localObject).mContentView != null) {
      ((WebViewSmileyPanel)localObject).mContentView.setVisibility(0);
    }
    localObject = this.Bwx.getLayoutParams();
    if ((localObject != null) && (this.tqy))
    {
      ((ViewGroup.LayoutParams)localObject).height = i.in(getContext());
      this.Bwx.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (localObject != null)
    {
      int i = ((ViewGroup.LayoutParams)localObject).height;
      AppMethodBeat.o(82317);
      return i;
    }
    AppMethodBeat.o(82317);
    return 0;
  }
  
  private void err()
  {
    AppMethodBeat.i(82321);
    if (this.BwB != null)
    {
      this.BwB.clearFocus();
      this.BwB.setFocusable(false);
      this.BwB.setFocusableInTouchMode(false);
    }
    AppMethodBeat.o(82321);
  }
  
  public final int ers()
  {
    AppMethodBeat.i(82322);
    setVisibility(0);
    if (this.BwC != null) {
      this.BwC.setVisibility(8);
    }
    this.BwD = true;
    this.state = 1;
    int i = eoC();
    AppMethodBeat.o(82322);
    return i;
  }
  
  public final void ert()
  {
    AppMethodBeat.i(82324);
    if (this.BwD) {
      setVisibility(8);
    }
    this.state = 0;
    btD();
    AppMethodBeat.o(82324);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82323);
    setVisibility(8);
    if (this.imP != null)
    {
      if (this.BwB != null) {
        this.imP.hideVKB(this.BwB);
      }
      this.imP.hideVKB();
    }
    this.state = 0;
    btD();
    err();
    AppMethodBeat.o(82323);
  }
  
  public final boolean isShown()
  {
    AppMethodBeat.i(82325);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(82325);
      return true;
    }
    AppMethodBeat.o(82325);
    return false;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(82319);
    super.onDetachedFromWindow();
    err();
    if ((this.BwB != null) && (this.imP != null)) {
      this.imP.hideVKB(this.BwB);
    }
    this.BwB = null;
    WebViewSmileyPanel localWebViewSmileyPanel = this.Bwx;
    c localc = localWebViewSmileyPanel.BwH;
    localc.BwN = null;
    localc.mfC = null;
    if (localWebViewSmileyPanel.mContentView != null)
    {
      ((ViewGroup)localWebViewSmileyPanel.mContentView.getParent()).removeView(localWebViewSmileyPanel.mContentView);
      ((ViewGroup)localWebViewSmileyPanel.mContentView).removeAllViews();
      localWebViewSmileyPanel.mContentView = null;
    }
    localWebViewSmileyPanel.nqt = null;
    removeAllViews();
    this.imP = null;
    this.Bwu = null;
    AppMethodBeat.o(82319);
  }
  
  public final void setMaxCount(int paramInt)
  {
    if (paramInt > 0) {
      this.BwE = paramInt;
    }
  }
  
  public final void setOnSmileyChosenListener(WebViewInputFooter.a parama)
  {
    this.Bwv = parama;
  }
  
  public final void setOnSmileyPanelVisibilityChangedListener(b paramb)
  {
    this.Bww = paramb;
  }
  
  public final void setOnTextSendListener(WebViewInputFooter.c paramc)
  {
    this.Bwu = paramc;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(82320);
    this.BwB.setText("");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82320);
      return;
    }
    try
    {
      this.BwB.append(paramString);
      ad.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[] { this.BwB.getText() });
      AppMethodBeat.o(82320);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramString });
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void elf();
    
    public abstract void elg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter
 * JD-Core Version:    0.7.0.1
 */