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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter
  extends LinearLayout
{
  private WebViewInputFooter.c COC;
  private WebViewInputFooter.a COD;
  private b COE;
  private WebViewSmileyPanel COF;
  public View COG;
  private View COH;
  private View COI;
  public MMEditText COJ;
  public LinearLayout COK;
  public boolean COL;
  private int COM;
  public MMActivity iMV;
  private ImageButton mEW;
  public int state;
  private boolean uyP;
  
  public WebViewInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82316);
    this.state = 0;
    this.COM = 2147483647;
    this.uyP = true;
    this.iMV = ((MMActivity)paramContext);
    paramContext = (ViewGroup)View.inflate(this.iMV, 2131496084, this);
    this.COK = ((LinearLayout)paramContext.findViewById(2131306914));
    this.COH = paramContext.findViewById(2131306918);
    this.COI = paramContext.findViewById(2131306917);
    this.COG = paramContext.findViewById(2131306919);
    this.COJ = ((MMEditText)paramContext.findViewById(2131306915));
    this.mEW = ((ImageButton)paramContext.findViewById(2131306920));
    this.mEW.setOnClickListener(new View.OnClickListener()
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
    this.COJ.setOnTouchListener(new View.OnTouchListener()
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
    this.COF = new WebViewSmileyPanel(getContext());
    this.COF.setVisibility(8);
    this.COF.setBackgroundResource(2131234802);
    this.COF.setOnTextOperationListener(new WebViewSmileyPanel.a()
    {
      public final void amb()
      {
        AppMethodBeat.i(82311);
        if ((WebViewInputFooter.c(WebViewInputFooter.this)) && (WebViewInputFooter.j(WebViewInputFooter.this) != null))
        {
          WebViewInputFooter.j(WebViewInputFooter.this).RU("[DELETE_EMOTION]");
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
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(82310);
        try
        {
          if (WebViewInputFooter.c(WebViewInputFooter.this))
          {
            WebViewInputFooter.j(WebViewInputFooter.this).RU(paramAnonymousString);
            AppMethodBeat.o(82310);
            return;
          }
          WebViewInputFooter.this.COJ.aRF(paramAnonymousString);
          AppMethodBeat.o(82310);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ac.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(82310);
        }
      }
    });
    ((LinearLayout)findViewById(2131304239)).addView(this.COF, -1, 0);
    this.COI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82314);
        paramAnonymousView = com.tencent.mm.ui.tools.b.c.d(WebViewInputFooter.d(WebViewInputFooter.this)).acw(WebViewInputFooter.l(WebViewInputFooter.this));
        paramAnonymousView.mEd = f.a.IRI;
        paramAnonymousView.IVj = true;
        paramAnonymousView.a(new c.a()
        {
          public final void GK(String paramAnonymous2String)
          {
            AppMethodBeat.i(82312);
            if (WebViewInputFooter.k(WebViewInputFooter.this) != null) {
              WebViewInputFooter.k(WebViewInputFooter.this).aBy(WebViewInputFooter.d(WebViewInputFooter.this).getText().toString());
            }
            paramAnonymous2String = WebViewInputFooter.this;
            paramAnonymous2String.COJ.clearComposingText();
            paramAnonymous2String.COJ.setText("");
            AppMethodBeat.o(82312);
          }
          
          public final void aRi() {}
          
          public final void ca(String paramAnonymous2String)
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
    this.COJ.addTextChangedListener(new TextWatcher()
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
  
  private void bAD()
  {
    AppMethodBeat.i(82318);
    if (this.COE != null) {
      this.COE.eAC();
    }
    this.COF.setVisibility(8);
    this.mEW.setImageResource(2131690564);
    this.state = 0;
    AppMethodBeat.o(82318);
  }
  
  private int eDX()
  {
    AppMethodBeat.i(82317);
    if (this.COE != null) {
      this.COE.eAB();
    }
    if (this.COJ != null) {
      this.iMV.hideVKB(this.COJ);
    }
    this.COF.setVisibility(0);
    Object localObject = this.COF;
    if (((WebViewSmileyPanel)localObject).mContentView != null) {
      ((WebViewSmileyPanel)localObject).mContentView.setVisibility(0);
    }
    localObject = this.COF.getLayoutParams();
    if ((localObject != null) && (this.uyP))
    {
      ((ViewGroup.LayoutParams)localObject).height = i.iy(getContext());
      this.COF.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
  
  private void eGL()
  {
    AppMethodBeat.i(82321);
    if (this.COJ != null)
    {
      this.COJ.clearFocus();
      this.COJ.setFocusable(false);
      this.COJ.setFocusableInTouchMode(false);
    }
    AppMethodBeat.o(82321);
  }
  
  public final int eGM()
  {
    AppMethodBeat.i(82322);
    setVisibility(0);
    if (this.COK != null) {
      this.COK.setVisibility(8);
    }
    this.COL = true;
    this.state = 1;
    int i = eDX();
    AppMethodBeat.o(82322);
    return i;
  }
  
  public final void eGN()
  {
    AppMethodBeat.i(82324);
    if (this.COL) {
      setVisibility(8);
    }
    this.state = 0;
    bAD();
    AppMethodBeat.o(82324);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82323);
    setVisibility(8);
    if (this.iMV != null)
    {
      if (this.COJ != null) {
        this.iMV.hideVKB(this.COJ);
      }
      this.iMV.hideVKB();
    }
    this.state = 0;
    bAD();
    eGL();
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
    eGL();
    if ((this.COJ != null) && (this.iMV != null)) {
      this.iMV.hideVKB(this.COJ);
    }
    this.COJ = null;
    WebViewSmileyPanel localWebViewSmileyPanel = this.COF;
    c localc = localWebViewSmileyPanel.COP;
    localc.COV = null;
    localc.mHB = null;
    if (localWebViewSmileyPanel.mContentView != null)
    {
      ((ViewGroup)localWebViewSmileyPanel.mContentView.getParent()).removeView(localWebViewSmileyPanel.mContentView);
      ((ViewGroup)localWebViewSmileyPanel.mContentView).removeAllViews();
      localWebViewSmileyPanel.mContentView = null;
    }
    localWebViewSmileyPanel.nTt = null;
    removeAllViews();
    this.iMV = null;
    this.COC = null;
    AppMethodBeat.o(82319);
  }
  
  public final void setMaxCount(int paramInt)
  {
    if (paramInt > 0) {
      this.COM = paramInt;
    }
  }
  
  public final void setOnSmileyChosenListener(WebViewInputFooter.a parama)
  {
    this.COD = parama;
  }
  
  public final void setOnSmileyPanelVisibilityChangedListener(b paramb)
  {
    this.COE = paramb;
  }
  
  public final void setOnTextSendListener(WebViewInputFooter.c paramc)
  {
    this.COC = paramc;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(82320);
    this.COJ.setText("");
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82320);
      return;
    }
    try
    {
      this.COJ.append(paramString);
      ac.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[] { this.COJ.getText() });
      AppMethodBeat.o(82320);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramString });
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void eAB();
    
    public abstract void eAC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter
 * JD-Core Version:    0.7.0.1
 */