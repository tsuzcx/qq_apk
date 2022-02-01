package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMEditText;

public class WebViewRedesignInputFooter
  extends LinearLayout
{
  private WebViewInputFooter.b JAJ;
  private WebViewSmileyPanel JAK;
  public View JAL;
  private View JAM;
  private View JAN;
  public MMEditText JAO;
  public LinearLayout JAP;
  public boolean JAQ;
  private int JAR;
  private b JAU;
  private WebViewRedesignInputFooter.a JAV;
  private TextView JAW;
  private int JAX;
  public MMActivity gte;
  private ImageButton oui;
  public int state;
  private boolean ziU;
  
  public WebViewRedesignInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(212130);
    this.state = 0;
    this.JAR = 2147483647;
    this.JAX = 2147483647;
    this.ziU = true;
    this.gte = ((MMActivity)paramContext);
    paramContext = (ViewGroup)View.inflate(this.gte, 2131497075, this);
    this.JAP = ((LinearLayout)paramContext.findViewById(2131310387));
    this.JAM = paramContext.findViewById(2131310391);
    this.JAN = paramContext.findViewById(2131310390);
    this.JAL = paramContext.findViewById(2131310392);
    this.JAO = ((MMEditText)paramContext.findViewById(2131310388));
    this.JAW = ((TextView)paramContext.findViewById(2131310402));
    this.oui = ((ImageButton)paramContext.findViewById(2131310393));
    this.oui.setOnClickListener(new View.OnClickListener()
    {
      @SuppressLint({"ResourceType"})
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212122);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this) == 0)
        {
          WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).hideVKB();
          if (!WebViewRedesignInputFooter.c(WebViewRedesignInputFooter.this)) {
            WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).requestFocus();
          }
          WebViewRedesignInputFooter.e(WebViewRedesignInputFooter.this);
          WebViewRedesignInputFooter.f(WebViewRedesignInputFooter.this).setImageResource(2131690793);
          WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, 1);
          WebViewRedesignInputFooter.g(WebViewRedesignInputFooter.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212122);
          return;
          WebViewRedesignInputFooter.g(WebViewRedesignInputFooter.this);
          WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).requestFocus();
          WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).showVKB();
          WebViewRedesignInputFooter.h(WebViewRedesignInputFooter.this);
          WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, 0);
        }
      }
    });
    this.JAO.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(212123);
        WebViewRedesignInputFooter.g(WebViewRedesignInputFooter.this);
        WebViewRedesignInputFooter.i(WebViewRedesignInputFooter.this).setVisibility(8);
        WebViewRedesignInputFooter.i(WebViewRedesignInputFooter.this);
        WebViewRedesignInputFooter.f(WebViewRedesignInputFooter.this).setImageResource(2131231772);
        WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, 0);
        AppMethodBeat.o(212123);
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
        AppMethodBeat.i(212125);
        if ((WebViewRedesignInputFooter.c(WebViewRedesignInputFooter.this)) && (WebViewRedesignInputFooter.j(WebViewRedesignInputFooter.this) != null))
        {
          WebViewRedesignInputFooter.j(WebViewRedesignInputFooter.this).afZ("[DELETE_EMOTION]");
          AppMethodBeat.o(212125);
          return;
        }
        if (WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this) != null) {
          WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).gYD();
        }
        AppMethodBeat.o(212125);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(212124);
        try
        {
          if (WebViewRedesignInputFooter.c(WebViewRedesignInputFooter.this))
          {
            WebViewRedesignInputFooter.j(WebViewRedesignInputFooter.this).afZ(paramAnonymousString);
            AppMethodBeat.o(212124);
            return;
          }
          WebViewRedesignInputFooter.this.JAO.bol(paramAnonymousString);
          AppMethodBeat.o(212124);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(212124);
        }
      }
    });
    ((LinearLayout)findViewById(2131307157)).addView(this.JAK, -1, 0);
    this.JAN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212127);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = c.f(WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this));
        if (WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this) <= 0) {}
        for (int i = 2147483647;; i = WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this) * 2)
        {
          paramAnonymousView.aoq(i).a(f.a.Qui).CN(true).a(new c.a()
          {
            public final void Tw(String paramAnonymous2String)
            {
              AppMethodBeat.i(212126);
              if (WebViewRedesignInputFooter.k(WebViewRedesignInputFooter.this) != null) {
                WebViewRedesignInputFooter.k(WebViewRedesignInputFooter.this).bau(WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).getText().toString());
              }
              WebViewRedesignInputFooter.this.clearText();
              AppMethodBeat.o(212126);
            }
            
            public final void Tx(String paramAnonymous2String) {}
            
            public final void dv(String paramAnonymous2String) {}
          });
          a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212127);
          return;
        }
      }
    });
    this.JAO.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(212128);
        if (WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).getText() == null)
        {
          AppMethodBeat.o(212128);
          return;
        }
        WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).requestFocus();
        if ((paramAnonymousEditable.length() > 0) && (paramAnonymousEditable.toString().trim().length() > 0)) {}
        for (boolean bool = true;; bool = false)
        {
          WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, bool);
          AppMethodBeat.o(212128);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    AppMethodBeat.o(212130);
  }
  
  private void giE()
  {
    AppMethodBeat.i(212137);
    if (this.JAO != null)
    {
      this.JAO.clearFocus();
      this.JAO.setFocusable(false);
      this.JAO.setFocusableInTouchMode(false);
    }
    AppMethodBeat.o(212137);
  }
  
  @SuppressLint({"ResourceType"})
  public final void cbM()
  {
    AppMethodBeat.i(212132);
    if (this.JAJ != null) {
      this.JAJ.gbQ();
    }
    this.JAK.setVisibility(8);
    this.oui.setImageResource(2131690793);
    this.state = 0;
    AppMethodBeat.o(212132);
  }
  
  public final void clearText()
  {
    AppMethodBeat.i(212134);
    this.JAO.clearComposingText();
    this.JAO.setText("");
    AppMethodBeat.o(212134);
  }
  
  public final int gfz()
  {
    AppMethodBeat.i(212131);
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
      AppMethodBeat.o(212131);
      return i;
    }
    AppMethodBeat.o(212131);
    return 0;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(212138);
    setVisibility(8);
    String str1 = "";
    String str2 = str1;
    if (this.gte != null)
    {
      if (this.JAO != null)
      {
        this.gte.hideVKB(this.JAO);
        str1 = this.JAO.getText().toString();
      }
      this.gte.hideVKB();
      str2 = str1;
    }
    this.state = 0;
    cbM();
    giE();
    if (this.JAU != null) {
      this.JAU.bav(str2);
    }
    AppMethodBeat.o(212138);
  }
  
  public boolean isShown()
  {
    AppMethodBeat.i(212139);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(212139);
      return true;
    }
    AppMethodBeat.o(212139);
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(212133);
    super.onDetachedFromWindow();
    giE();
    if ((this.JAO != null) && (this.gte != null)) {
      this.gte.hideVKB(this.JAO);
    }
    this.JAO = null;
    this.JAK.onDestroy();
    removeAllViews();
    this.gte = null;
    this.JAU = null;
    AppMethodBeat.o(212133);
  }
  
  public void setMaxCount(int paramInt)
  {
    AppMethodBeat.i(212136);
    this.JAR = 0;
    if (paramInt <= 0)
    {
      this.JAO.setFilters(new InputFilter[0]);
      AppMethodBeat.o(212136);
      return;
    }
    this.JAR = paramInt;
    this.JAO.setFilters(new InputFilter[] { new f(this.JAR * 2, f.a.Qui)
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(212129);
        paramAnonymousInt4 = a(paramAnonymousSpanned.toString(), f.a.Qui) + a(paramAnonymousCharSequence.toString(), f.a.Qui);
        paramAnonymousInt2 = WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this) * 2;
        paramAnonymousInt3 = WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this) * 2 - WebViewRedesignInputFooter.m(WebViewRedesignInputFooter.this) * 2;
        if (paramAnonymousInt3 <= paramAnonymousInt2)
        {
          paramAnonymousInt1 = paramAnonymousInt3;
          if (paramAnonymousInt3 > 0) {}
        }
        else
        {
          paramAnonymousInt1 = paramAnonymousInt2;
        }
        if (paramAnonymousInt4 >= paramAnonymousInt2)
        {
          paramAnonymousCharSequence = Util.safeFormatString(WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).getString(2131768565), new Object[] { Integer.valueOf(WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this)) });
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setVisibility(0);
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setText(paramAnonymousCharSequence);
          AppMethodBeat.o(212129);
          return "";
        }
        if (paramAnonymousInt4 > paramAnonymousInt1)
        {
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setVisibility(0);
          paramAnonymousSpanned = Util.safeFormatString(WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).getString(2131768564), new Object[] { Integer.valueOf((paramAnonymousInt2 - paramAnonymousInt4) / 2) });
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setText(paramAnonymousSpanned);
          AppMethodBeat.o(212129);
          return paramAnonymousCharSequence;
        }
        WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setVisibility(8);
        AppMethodBeat.o(212129);
        return paramAnonymousCharSequence;
      }
    } });
    AppMethodBeat.o(212136);
  }
  
  public void setOnSmileyChosenListener(WebViewRedesignInputFooter.a parama)
  {
    this.JAV = parama;
  }
  
  public void setOnSmileyPanelVisibilityChangedListener(WebViewInputFooter.b paramb)
  {
    this.JAJ = paramb;
  }
  
  public void setOnTextSendListener(b paramb)
  {
    this.JAU = paramb;
  }
  
  public void setShowRemindWordCount(int paramInt)
  {
    this.JAX = paramInt;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(212135);
    this.JAO.setHint("");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(212135);
      return;
    }
    try
    {
      this.JAO.setHint(paramString);
      AppMethodBeat.o(212135);
      return;
    }
    catch (Exception paramString)
    {
      Log.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramString });
      AppMethodBeat.o(212135);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bau(String paramString);
    
    public abstract void bav(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter
 * JD-Core Version:    0.7.0.1
 */