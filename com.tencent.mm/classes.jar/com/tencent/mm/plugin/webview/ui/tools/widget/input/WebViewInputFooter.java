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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter
  extends LinearLayout
{
  private WebViewInputFooter.c JAH;
  private a JAI;
  private b JAJ;
  private WebViewSmileyPanel JAK;
  private View JAL;
  private View JAM;
  private View JAN;
  MMEditText JAO;
  private LinearLayout JAP;
  public boolean JAQ;
  private int JAR;
  private MMActivity gte;
  private ImageButton oui;
  public int state;
  private boolean ziU;
  
  public WebViewInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82316);
    this.state = 0;
    this.JAR = 2147483647;
    this.ziU = true;
    this.gte = ((MMActivity)paramContext);
    paramContext = (ViewGroup)View.inflate(this.gte, 2131497070, this);
    this.JAP = ((LinearLayout)paramContext.findViewById(2131310387));
    this.JAM = paramContext.findViewById(2131310391);
    this.JAN = paramContext.findViewById(2131310390);
    this.JAL = paramContext.findViewById(2131310392);
    this.JAO = ((MMEditText)paramContext.findViewById(2131310388));
    this.oui = ((ImageButton)paramContext.findViewById(2131310393));
    this.oui.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82308);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (WebViewInputFooter.a(WebViewInputFooter.this) == 0)
        {
          WebViewInputFooter.b(WebViewInputFooter.this).hideVKB();
          if (!WebViewInputFooter.c(WebViewInputFooter.this)) {
            WebViewInputFooter.d(WebViewInputFooter.this).requestFocus();
          }
          WebViewInputFooter.e(WebViewInputFooter.this);
          WebViewInputFooter.f(WebViewInputFooter.this).setImageResource(2131690793);
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
    this.JAO.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(82309);
        WebViewInputFooter.g(WebViewInputFooter.this);
        WebViewInputFooter.i(WebViewInputFooter.this).setVisibility(8);
        WebViewInputFooter.i(WebViewInputFooter.this);
        WebViewInputFooter.f(WebViewInputFooter.this).setImageResource(2131231772);
        WebViewInputFooter.a(WebViewInputFooter.this, 0);
        AppMethodBeat.o(82309);
        return false;
      }
    });
    this.JAK = new WebViewSmileyPanel(getContext());
    this.JAK.setVisibility(8);
    this.JAK.setBackgroundResource(2131235785);
    this.JAK.setOnTextOperationListener(new WebViewSmileyPanel.a()
    {
      public final void aHC()
      {
        AppMethodBeat.i(82311);
        if ((WebViewInputFooter.c(WebViewInputFooter.this)) && (WebViewInputFooter.j(WebViewInputFooter.this) != null))
        {
          WebViewInputFooter.j(WebViewInputFooter.this).afZ("[DELETE_EMOTION]");
          AppMethodBeat.o(82311);
          return;
        }
        if (WebViewInputFooter.d(WebViewInputFooter.this) != null) {
          WebViewInputFooter.d(WebViewInputFooter.this).gYD();
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
            WebViewInputFooter.j(WebViewInputFooter.this).afZ(paramAnonymousString);
            AppMethodBeat.o(82310);
            return;
          }
          WebViewInputFooter.this.JAO.bol(paramAnonymousString);
          AppMethodBeat.o(82310);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(82310);
        }
      }
    });
    ((LinearLayout)findViewById(2131307157)).addView(this.JAK, -1, 0);
    this.JAN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82314);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        c.f(WebViewInputFooter.d(WebViewInputFooter.this)).aoq(WebViewInputFooter.l(WebViewInputFooter.this)).a(f.a.Quh).CN(true).a(new c.a()
        {
          public final void Tw(String paramAnonymous2String)
          {
            AppMethodBeat.i(82312);
            if (WebViewInputFooter.k(WebViewInputFooter.this) != null)
            {
              paramAnonymous2String = WebViewInputFooter.k(WebViewInputFooter.this);
              WebViewInputFooter.d(WebViewInputFooter.this).getText();
              paramAnonymous2String.gbU();
            }
            paramAnonymous2String = WebViewInputFooter.this;
            paramAnonymous2String.JAO.clearComposingText();
            paramAnonymous2String.JAO.setText("");
            AppMethodBeat.o(82312);
          }
          
          public final void Tx(String paramAnonymous2String) {}
          
          public final void dv(String paramAnonymous2String)
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
    this.JAO.addTextChangedListener(new TextWatcher()
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
  
  private int gfz()
  {
    AppMethodBeat.i(82317);
    if (this.JAJ != null) {
      this.JAJ.gbP();
    }
    if (this.JAO != null) {
      this.gte.hideVKB(this.JAO);
    }
    this.JAK.setVisibility(0);
    this.JAK.cck();
    ViewGroup.LayoutParams localLayoutParams = this.JAK.getLayoutParams();
    if ((localLayoutParams != null) && (this.ziU))
    {
      localLayoutParams.height = i.getValidPanelHeight(getContext());
      this.JAK.setLayoutParams(localLayoutParams);
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
  
  private void giE()
  {
    AppMethodBeat.i(82321);
    if (this.JAO != null)
    {
      this.JAO.clearFocus();
      this.JAO.setFocusable(false);
      this.JAO.setFocusableInTouchMode(false);
    }
    AppMethodBeat.o(82321);
  }
  
  public final void cbM()
  {
    AppMethodBeat.i(82318);
    if (this.JAJ != null) {
      this.JAJ.gbQ();
    }
    this.JAK.setVisibility(8);
    this.oui.setImageResource(2131690793);
    this.state = 0;
    AppMethodBeat.o(82318);
  }
  
  public final int giF()
  {
    AppMethodBeat.i(82322);
    setVisibility(0);
    if (this.JAP != null) {
      this.JAP.setVisibility(8);
    }
    this.JAQ = true;
    this.state = 1;
    int i = gfz();
    AppMethodBeat.o(82322);
    return i;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82323);
    setVisibility(8);
    if (this.gte != null)
    {
      if (this.JAO != null) {
        this.gte.hideVKB(this.JAO);
      }
      this.gte.hideVKB();
    }
    this.state = 0;
    cbM();
    giE();
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
    giE();
    if ((this.JAO != null) && (this.gte != null)) {
      this.gte.hideVKB(this.JAO);
    }
    this.JAO = null;
    this.JAK.onDestroy();
    removeAllViews();
    this.gte = null;
    this.JAH = null;
    AppMethodBeat.o(82319);
  }
  
  public final void setMaxCount(int paramInt)
  {
    if (paramInt > 0) {
      this.JAR = paramInt;
    }
  }
  
  public final void setOnSmileyChosenListener(a parama)
  {
    this.JAI = parama;
  }
  
  public final void setOnSmileyPanelVisibilityChangedListener(b paramb)
  {
    this.JAJ = paramb;
  }
  
  public final void setOnTextSendListener(WebViewInputFooter.c paramc)
  {
    this.JAH = paramc;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(82320);
    this.JAO.setText("");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82320);
      return;
    }
    try
    {
      this.JAO.append(paramString);
      Log.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[] { this.JAO.getText() });
      AppMethodBeat.o(82320);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramString });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean afZ(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void gbP();
    
    public abstract void gbQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter
 * JD-Core Version:    0.7.0.1
 */