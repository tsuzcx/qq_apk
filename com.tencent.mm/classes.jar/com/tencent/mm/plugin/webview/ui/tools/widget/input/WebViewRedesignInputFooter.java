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
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMEditText;

public class WebViewRedesignInputFooter
  extends LinearLayout
{
  private WebViewInputFooter.c EKS;
  private WebViewInputFooter.a EKT;
  private WebViewInputFooter.b EKU;
  private WebViewSmileyPanel EKV;
  public View EKW;
  private View EKX;
  private View EKY;
  public MMEditText EKZ;
  public LinearLayout ELa;
  public boolean ELb;
  private int ELc;
  private TextView ELf;
  private int ELg;
  public MMActivity fNT;
  private ImageButton nkD;
  public int state;
  private boolean vNw;
  
  public WebViewRedesignInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199188);
    this.state = 0;
    this.ELc = 2147483647;
    this.ELg = 2147483647;
    this.vNw = true;
    this.fNT = ((MMActivity)paramContext);
    paramContext = (ViewGroup)View.inflate(this.fNT, 2131496533, this);
    this.ELa = ((LinearLayout)paramContext.findViewById(2131306914));
    this.EKX = paramContext.findViewById(2131306918);
    this.EKY = paramContext.findViewById(2131306917);
    this.EKW = paramContext.findViewById(2131306919);
    this.EKZ = ((MMEditText)paramContext.findViewById(2131306915));
    this.ELf = ((TextView)paramContext.findViewById(2131308528));
    this.nkD = ((ImageButton)paramContext.findViewById(2131306920));
    this.nkD.setOnClickListener(new View.OnClickListener()
    {
      @SuppressLint({"ResourceType"})
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(199179);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this) == 0)
        {
          WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).hideVKB();
          if (!WebViewRedesignInputFooter.c(WebViewRedesignInputFooter.this)) {
            WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).requestFocus();
          }
          WebViewRedesignInputFooter.e(WebViewRedesignInputFooter.this);
          WebViewRedesignInputFooter.f(WebViewRedesignInputFooter.this).setImageResource(2131690564);
          WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, 1);
          WebViewRedesignInputFooter.g(WebViewRedesignInputFooter.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(199179);
          return;
          WebViewRedesignInputFooter.g(WebViewRedesignInputFooter.this);
          WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).requestFocus();
          WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).showVKB();
          WebViewRedesignInputFooter.h(WebViewRedesignInputFooter.this);
          WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, 0);
        }
      }
    });
    this.EKZ.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(199180);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        WebViewRedesignInputFooter.g(WebViewRedesignInputFooter.this);
        WebViewRedesignInputFooter.i(WebViewRedesignInputFooter.this).setVisibility(8);
        WebViewRedesignInputFooter.i(WebViewRedesignInputFooter.this);
        WebViewRedesignInputFooter.f(WebViewRedesignInputFooter.this).setImageResource(2131231701);
        WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, 0);
        a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(199180);
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
        AppMethodBeat.i(199182);
        if ((WebViewRedesignInputFooter.c(WebViewRedesignInputFooter.this)) && (WebViewRedesignInputFooter.j(WebViewRedesignInputFooter.this) != null))
        {
          WebViewRedesignInputFooter.j(WebViewRedesignInputFooter.this).Wd("[DELETE_EMOTION]");
          AppMethodBeat.o(199182);
          return;
        }
        if (WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this) != null) {
          WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).fPJ();
        }
        AppMethodBeat.o(199182);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(199181);
        try
        {
          if (WebViewRedesignInputFooter.c(WebViewRedesignInputFooter.this))
          {
            WebViewRedesignInputFooter.j(WebViewRedesignInputFooter.this).Wd(paramAnonymousString);
            AppMethodBeat.o(199181);
            return;
          }
          WebViewRedesignInputFooter.this.EKZ.aZf(paramAnonymousString);
          AppMethodBeat.o(199181);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ae.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(199181);
        }
      }
    });
    ((LinearLayout)findViewById(2131304239)).addView(this.EKV, -1, 0);
    this.EKY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(199185);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = c.d(WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this));
        if (WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this) <= 0) {}
        for (int i = 2147483647;; i = WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this) * 2)
        {
          paramAnonymousView = paramAnonymousView.afD(i);
          paramAnonymousView.njK = f.a.Lfh;
          paramAnonymousView.LiL = true;
          paramAnonymousView.a(new c.a()
          {
            public final void Ky(String paramAnonymous2String)
            {
              AppMethodBeat.i(199183);
              if (WebViewRedesignInputFooter.k(WebViewRedesignInputFooter.this) != null) {
                WebViewRedesignInputFooter.k(WebViewRedesignInputFooter.this).aIp(WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).getText().toString());
              }
              paramAnonymous2String = WebViewRedesignInputFooter.this;
              paramAnonymous2String.EKZ.clearComposingText();
              paramAnonymous2String.EKZ.setText("");
              AppMethodBeat.o(199183);
            }
            
            public final void aUT() {}
            
            public final void cW(String paramAnonymous2String)
            {
              AppMethodBeat.i(199184);
              if (WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this) != null) {
                Toast.makeText(WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this), "exceed max-length", 0).show();
              }
              AppMethodBeat.o(199184);
            }
          });
          a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(199185);
          return;
        }
      }
    });
    this.EKZ.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(199186);
        if (WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).getText() == null)
        {
          AppMethodBeat.o(199186);
          return;
        }
        WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).requestFocus();
        if ((paramAnonymousEditable.length() > 0) && (paramAnonymousEditable.toString().trim().length() > 0)) {}
        for (boolean bool = true;; bool = false)
        {
          WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, bool);
          AppMethodBeat.o(199186);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    AppMethodBeat.o(199188);
  }
  
  private void eZy()
  {
    AppMethodBeat.i(199194);
    if (this.EKZ != null)
    {
      this.EKZ.clearFocus();
      this.EKZ.setFocusable(false);
      this.EKZ.setFocusableInTouchMode(false);
    }
    AppMethodBeat.o(199194);
  }
  
  @SuppressLint({"ResourceType"})
  public final void bFx()
  {
    AppMethodBeat.i(199190);
    if (this.EKU != null) {
      this.EKU.eTe();
    }
    this.EKV.setVisibility(8);
    this.nkD.setImageResource(2131690564);
    this.state = 0;
    AppMethodBeat.o(199190);
  }
  
  public final int eWB()
  {
    AppMethodBeat.i(199189);
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
      AppMethodBeat.o(199189);
      return i;
    }
    AppMethodBeat.o(199189);
    return 0;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(199195);
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
    AppMethodBeat.o(199195);
  }
  
  public boolean isShown()
  {
    AppMethodBeat.i(199196);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(199196);
      return true;
    }
    AppMethodBeat.o(199196);
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(199191);
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
    AppMethodBeat.o(199191);
  }
  
  public void setMaxCount(int paramInt)
  {
    AppMethodBeat.i(199193);
    this.ELc = 0;
    if (paramInt <= 0)
    {
      this.EKZ.setFilters(new InputFilter[0]);
      AppMethodBeat.o(199193);
      return;
    }
    this.ELc = paramInt;
    this.EKZ.setFilters(new InputFilter[] { new f(this.ELc * 2, f.a.Lfh)
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(199187);
        paramAnonymousInt4 = a(paramAnonymousSpanned.toString(), f.a.Lfh) + a(paramAnonymousCharSequence.toString(), f.a.Lfh);
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
          paramAnonymousCharSequence = bu.x(WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).getString(2131767327), new Object[] { Integer.valueOf(WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this)) });
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setVisibility(0);
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setText(paramAnonymousCharSequence);
          AppMethodBeat.o(199187);
          return "";
        }
        if (paramAnonymousInt4 > paramAnonymousInt1)
        {
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setVisibility(0);
          paramAnonymousSpanned = bu.x(WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).getString(2131767326), new Object[] { Integer.valueOf((paramAnonymousInt2 - paramAnonymousInt4) / 2) });
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setText(paramAnonymousSpanned);
          AppMethodBeat.o(199187);
          return paramAnonymousCharSequence;
        }
        WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setVisibility(8);
        AppMethodBeat.o(199187);
        return paramAnonymousCharSequence;
      }
    } });
    AppMethodBeat.o(199193);
  }
  
  public void setOnSmileyChosenListener(WebViewInputFooter.a parama)
  {
    this.EKT = parama;
  }
  
  public void setOnSmileyPanelVisibilityChangedListener(WebViewInputFooter.b paramb)
  {
    this.EKU = paramb;
  }
  
  public void setOnTextSendListener(WebViewInputFooter.c paramc)
  {
    this.EKS = paramc;
  }
  
  public void setShowRemindWordCount(int paramInt)
  {
    this.ELg = paramInt;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(199192);
    this.EKZ.setHint("");
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(199192);
      return;
    }
    try
    {
      this.EKZ.setHint(paramString);
      AppMethodBeat.o(199192);
      return;
    }
    catch (Exception paramString)
    {
      ae.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramString });
      AppMethodBeat.o(199192);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter
 * JD-Core Version:    0.7.0.1
 */