package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter
  extends LinearLayout
{
  private c EKS;
  private a EKT;
  private b EKU;
  private WebViewSmileyPanel EKV;
  private View EKW;
  private View EKX;
  private View EKY;
  MMEditText EKZ;
  private LinearLayout ELa;
  public boolean ELb;
  private int ELc;
  private MMActivity fNT;
  private ImageButton nkD;
  public int state;
  private boolean vNw;
  
  public WebViewInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82316);
    this.state = 0;
    this.ELc = 2147483647;
    this.vNw = true;
    this.fNT = ((MMActivity)paramContext);
    paramContext = (ViewGroup)View.inflate(this.fNT, 2131496084, this);
    this.ELa = ((LinearLayout)paramContext.findViewById(2131306914));
    this.EKX = paramContext.findViewById(2131306918);
    this.EKY = paramContext.findViewById(2131306917);
    this.EKW = paramContext.findViewById(2131306919);
    this.EKZ = ((MMEditText)paramContext.findViewById(2131306915));
    this.nkD = ((ImageButton)paramContext.findViewById(2131306920));
    this.nkD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82308);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.EKZ.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(82309);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
    this.EKV = new WebViewSmileyPanel(getContext());
    this.EKV.setVisibility(8);
    this.EKV.setBackgroundResource(2131234802);
    this.EKV.setOnTextOperationListener(new WebViewSmileyPanel.a()
    {
      public final void apc()
      {
        AppMethodBeat.i(82311);
        if ((WebViewInputFooter.c(WebViewInputFooter.this)) && (WebViewInputFooter.j(WebViewInputFooter.this) != null))
        {
          WebViewInputFooter.j(WebViewInputFooter.this).Wd("[DELETE_EMOTION]");
          AppMethodBeat.o(82311);
          return;
        }
        if (WebViewInputFooter.d(WebViewInputFooter.this) != null) {
          WebViewInputFooter.d(WebViewInputFooter.this).fPJ();
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
            WebViewInputFooter.j(WebViewInputFooter.this).Wd(paramAnonymousString);
            AppMethodBeat.o(82310);
            return;
          }
          WebViewInputFooter.this.EKZ.aZf(paramAnonymousString);
          AppMethodBeat.o(82310);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ae.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(82310);
        }
      }
    });
    ((LinearLayout)findViewById(2131304239)).addView(this.EKV, -1, 0);
    this.EKY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82314);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = c.d(WebViewInputFooter.d(WebViewInputFooter.this)).afD(WebViewInputFooter.l(WebViewInputFooter.this));
        paramAnonymousView.njK = f.a.Lfg;
        paramAnonymousView.LiL = true;
        paramAnonymousView.a(new c.a()
        {
          public final void Ky(String paramAnonymous2String)
          {
            AppMethodBeat.i(82312);
            if (WebViewInputFooter.k(WebViewInputFooter.this) != null) {
              WebViewInputFooter.k(WebViewInputFooter.this).aIp(WebViewInputFooter.d(WebViewInputFooter.this).getText().toString());
            }
            paramAnonymous2String = WebViewInputFooter.this;
            paramAnonymous2String.EKZ.clearComposingText();
            paramAnonymous2String.EKZ.setText("");
            AppMethodBeat.o(82312);
          }
          
          public final void aUT() {}
          
          public final void cW(String paramAnonymous2String)
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
    this.EKZ.addTextChangedListener(new TextWatcher()
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
  
  private int eWB()
  {
    AppMethodBeat.i(82317);
    if (this.EKU != null) {
      this.EKU.eTd();
    }
    if (this.EKZ != null) {
      this.fNT.hideVKB(this.EKZ);
    }
    this.EKV.setVisibility(0);
    this.EKV.bFU();
    ViewGroup.LayoutParams localLayoutParams = this.EKV.getLayoutParams();
    if ((localLayoutParams != null) && (this.vNw))
    {
      localLayoutParams.height = i.iN(getContext());
      this.EKV.setLayoutParams(localLayoutParams);
    }
    if (localLayoutParams != null)
    {
      int i = localLayoutParams.height;
      AppMethodBeat.o(82317);
      return i;
    }
    AppMethodBeat.o(82317);
    return 0;
  }
  
  private void eZy()
  {
    AppMethodBeat.i(82321);
    if (this.EKZ != null)
    {
      this.EKZ.clearFocus();
      this.EKZ.setFocusable(false);
      this.EKZ.setFocusableInTouchMode(false);
    }
    AppMethodBeat.o(82321);
  }
  
  public final void bFx()
  {
    AppMethodBeat.i(82318);
    if (this.EKU != null) {
      this.EKU.eTe();
    }
    this.EKV.setVisibility(8);
    this.nkD.setImageResource(2131690564);
    this.state = 0;
    AppMethodBeat.o(82318);
  }
  
  public final int eZz()
  {
    AppMethodBeat.i(82322);
    setVisibility(0);
    if (this.ELa != null) {
      this.ELa.setVisibility(8);
    }
    this.ELb = true;
    this.state = 1;
    int i = eWB();
    AppMethodBeat.o(82322);
    return i;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82323);
    setVisibility(8);
    if (this.fNT != null)
    {
      if (this.EKZ != null) {
        this.fNT.hideVKB(this.EKZ);
      }
      this.fNT.hideVKB();
    }
    this.state = 0;
    bFx();
    eZy();
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
    eZy();
    if ((this.EKZ != null) && (this.fNT != null)) {
      this.fNT.hideVKB(this.EKZ);
    }
    this.EKZ = null;
    this.EKV.onDestroy();
    removeAllViews();
    this.fNT = null;
    this.EKS = null;
    AppMethodBeat.o(82319);
  }
  
  public final void setMaxCount(int paramInt)
  {
    if (paramInt > 0) {
      this.ELc = paramInt;
    }
  }
  
  public final void setOnSmileyChosenListener(a parama)
  {
    this.EKT = parama;
  }
  
  public final void setOnSmileyPanelVisibilityChangedListener(b paramb)
  {
    this.EKU = paramb;
  }
  
  public final void setOnTextSendListener(c paramc)
  {
    this.EKS = paramc;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(82320);
    this.EKZ.setText("");
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82320);
      return;
    }
    try
    {
      this.EKZ.append(paramString);
      ae.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[] { this.EKZ.getText() });
      AppMethodBeat.o(82320);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramString });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean Wd(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void eTd();
    
    public abstract void eTe();
  }
  
  public static abstract interface c
  {
    public abstract void aIp(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter
 * JD-Core Version:    0.7.0.1
 */