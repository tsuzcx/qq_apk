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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter
  extends LinearLayout
{
  private WebViewInputFooter.c EsC;
  private WebViewInputFooter.a EsD;
  private b EsE;
  private WebViewSmileyPanel EsF;
  public View EsG;
  private View EsH;
  private View EsI;
  public MMEditText EsJ;
  public LinearLayout EsK;
  public boolean EsL;
  private int EsM;
  public MMActivity fLP;
  private ImageButton nfv;
  public int state;
  private boolean vBs;
  
  public WebViewInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82316);
    this.state = 0;
    this.EsM = 2147483647;
    this.vBs = true;
    this.fLP = ((MMActivity)paramContext);
    paramContext = (ViewGroup)View.inflate(this.fLP, 2131496084, this);
    this.EsK = ((LinearLayout)paramContext.findViewById(2131306914));
    this.EsH = paramContext.findViewById(2131306918);
    this.EsI = paramContext.findViewById(2131306917);
    this.EsG = paramContext.findViewById(2131306919);
    this.EsJ = ((MMEditText)paramContext.findViewById(2131306915));
    this.nfv = ((ImageButton)paramContext.findViewById(2131306920));
    this.nfv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82308);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82308);
          return;
          WebViewInputFooter.g(WebViewInputFooter.this);
          WebViewInputFooter.d(WebViewInputFooter.this).requestFocus();
          WebViewInputFooter.b(WebViewInputFooter.this).showVKB();
          WebViewInputFooter.h(WebViewInputFooter.this);
          WebViewInputFooter.a(WebViewInputFooter.this, 0);
        }
      }
    });
    this.EsJ.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(82309);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        WebViewInputFooter.g(WebViewInputFooter.this);
        WebViewInputFooter.i(WebViewInputFooter.this).setVisibility(8);
        WebViewInputFooter.i(WebViewInputFooter.this);
        WebViewInputFooter.f(WebViewInputFooter.this).setImageResource(2131231701);
        WebViewInputFooter.a(WebViewInputFooter.this, 0);
        a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(82309);
        return false;
      }
    });
    this.EsF = new WebViewSmileyPanel(getContext());
    this.EsF.setVisibility(8);
    this.EsF.setBackgroundResource(2131234802);
    this.EsF.setOnTextOperationListener(new WebViewSmileyPanel.a()
    {
      public final void aoO()
      {
        AppMethodBeat.i(82311);
        if ((WebViewInputFooter.c(WebViewInputFooter.this)) && (WebViewInputFooter.j(WebViewInputFooter.this) != null))
        {
          WebViewInputFooter.j(WebViewInputFooter.this).Vr("[DELETE_EMOTION]");
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
            WebViewInputFooter.j(WebViewInputFooter.this).Vr(paramAnonymousString);
            AppMethodBeat.o(82310);
            return;
          }
          WebViewInputFooter.this.EsJ.aXD(paramAnonymousString);
          AppMethodBeat.o(82310);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(82310);
        }
      }
    });
    ((LinearLayout)findViewById(2131304239)).addView(this.EsF, -1, 0);
    this.EsI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82314);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = com.tencent.mm.ui.tools.b.c.d(WebViewInputFooter.d(WebViewInputFooter.this)).aeU(WebViewInputFooter.l(WebViewInputFooter.this));
        paramAnonymousView.neC = f.a.KIM;
        paramAnonymousView.KMn = true;
        paramAnonymousView.a(new c.a()
        {
          public final void JZ(String paramAnonymous2String)
          {
            AppMethodBeat.i(82312);
            if (WebViewInputFooter.k(WebViewInputFooter.this) != null) {
              WebViewInputFooter.k(WebViewInputFooter.this).aGV(WebViewInputFooter.d(WebViewInputFooter.this).getText().toString());
            }
            paramAnonymous2String = WebViewInputFooter.this;
            paramAnonymous2String.EsJ.clearComposingText();
            paramAnonymous2String.EsJ.setText("");
            AppMethodBeat.o(82312);
          }
          
          public final void aUu() {}
          
          public final void cU(String paramAnonymous2String)
          {
            AppMethodBeat.i(164038);
            if (WebViewInputFooter.b(WebViewInputFooter.this) != null) {
              Toast.makeText(WebViewInputFooter.b(WebViewInputFooter.this), "exceed max-length", 0).show();
            }
            AppMethodBeat.o(164038);
          }
        });
        a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82314);
      }
    });
    this.EsJ.addTextChangedListener(new TextWatcher()
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
  
  private void bEF()
  {
    AppMethodBeat.i(82318);
    if (this.EsE != null) {
      this.EsE.ePs();
    }
    this.EsF.setVisibility(8);
    this.nfv.setImageResource(2131690564);
    this.state = 0;
    AppMethodBeat.o(82318);
  }
  
  private int eSP()
  {
    AppMethodBeat.i(82317);
    if (this.EsE != null) {
      this.EsE.ePr();
    }
    if (this.EsJ != null) {
      this.fLP.hideVKB(this.EsJ);
    }
    this.EsF.setVisibility(0);
    Object localObject = this.EsF;
    if (((WebViewSmileyPanel)localObject).mContentView != null) {
      ((WebViewSmileyPanel)localObject).mContentView.setVisibility(0);
    }
    localObject = this.EsF.getLayoutParams();
    if ((localObject != null) && (this.vBs))
    {
      ((ViewGroup.LayoutParams)localObject).height = i.iI(getContext());
      this.EsF.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
  
  private void eVL()
  {
    AppMethodBeat.i(82321);
    if (this.EsJ != null)
    {
      this.EsJ.clearFocus();
      this.EsJ.setFocusable(false);
      this.EsJ.setFocusableInTouchMode(false);
    }
    AppMethodBeat.o(82321);
  }
  
  public final int eVM()
  {
    AppMethodBeat.i(82322);
    setVisibility(0);
    if (this.EsK != null) {
      this.EsK.setVisibility(8);
    }
    this.EsL = true;
    this.state = 1;
    int i = eSP();
    AppMethodBeat.o(82322);
    return i;
  }
  
  public final void eVN()
  {
    AppMethodBeat.i(82324);
    if (this.EsL) {
      setVisibility(8);
    }
    this.state = 0;
    bEF();
    AppMethodBeat.o(82324);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82323);
    setVisibility(8);
    if (this.fLP != null)
    {
      if (this.EsJ != null) {
        this.fLP.hideVKB(this.EsJ);
      }
      this.fLP.hideVKB();
    }
    this.state = 0;
    bEF();
    eVL();
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
    eVL();
    if ((this.EsJ != null) && (this.fLP != null)) {
      this.fLP.hideVKB(this.EsJ);
    }
    this.EsJ = null;
    WebViewSmileyPanel localWebViewSmileyPanel = this.EsF;
    c localc = localWebViewSmileyPanel.EsP;
    localc.EsV = null;
    localc.nhZ = null;
    if (localWebViewSmileyPanel.mContentView != null)
    {
      ((ViewGroup)localWebViewSmileyPanel.mContentView.getParent()).removeView(localWebViewSmileyPanel.mContentView);
      ((ViewGroup)localWebViewSmileyPanel.mContentView).removeAllViews();
      localWebViewSmileyPanel.mContentView = null;
    }
    localWebViewSmileyPanel.owO = null;
    removeAllViews();
    this.fLP = null;
    this.EsC = null;
    AppMethodBeat.o(82319);
  }
  
  public final void setMaxCount(int paramInt)
  {
    if (paramInt > 0) {
      this.EsM = paramInt;
    }
  }
  
  public final void setOnSmileyChosenListener(WebViewInputFooter.a parama)
  {
    this.EsD = parama;
  }
  
  public final void setOnSmileyPanelVisibilityChangedListener(b paramb)
  {
    this.EsE = paramb;
  }
  
  public final void setOnTextSendListener(WebViewInputFooter.c paramc)
  {
    this.EsC = paramc;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(82320);
    this.EsJ.setText("");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82320);
      return;
    }
    try
    {
      this.EsJ.append(paramString);
      ad.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[] { this.EsJ.getText() });
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
    public abstract void ePr();
    
    public abstract void ePs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter
 * JD-Core Version:    0.7.0.1
 */