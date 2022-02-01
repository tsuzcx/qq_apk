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
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter
  extends LinearLayout
{
  private boolean EOk;
  private WebViewInputFooter.c QyR;
  private WebViewInputFooter.a QyS;
  private b QyT;
  private WebViewSmileyPanel QyU;
  private View QyV;
  private View QyW;
  private View QyX;
  MMEditText QyY;
  private LinearLayout QyZ;
  public boolean Qza;
  private int Qzb;
  private MMActivity iXq;
  private ImageButton rwL;
  public int state;
  
  public WebViewInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82316);
    this.state = 0;
    this.Qzb = 2147483647;
    this.EOk = true;
    this.iXq = ((MMActivity)paramContext);
    paramContext = (ViewGroup)View.inflate(this.iXq, c.g.webview_input_footer, this);
    this.QyZ = ((LinearLayout)paramContext.findViewById(c.f.webview_input_container));
    this.QyW = paramContext.findViewById(c.f.webview_input_send_btn);
    this.QyX = paramContext.findViewById(c.f.webview_input_green_send_btn);
    this.QyV = paramContext.findViewById(c.f.webview_input_send_button_container);
    this.QyY = ((MMEditText)paramContext.findViewById(c.f.webview_input_content_edit));
    this.rwL = ((ImageButton)paramContext.findViewById(c.f.webview_input_smiley_image));
    this.rwL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82308);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (WebViewInputFooter.a(WebViewInputFooter.this) == 0)
        {
          WebViewInputFooter.b(WebViewInputFooter.this).hideVKB();
          if (!WebViewInputFooter.c(WebViewInputFooter.this)) {
            WebViewInputFooter.d(WebViewInputFooter.this).requestFocus();
          }
          WebViewInputFooter.e(WebViewInputFooter.this);
          WebViewInputFooter.f(WebViewInputFooter.this).setImageResource(c.h.icons_outlined_emoji);
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
    this.QyY.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(82309);
        WebViewInputFooter.g(WebViewInputFooter.this);
        WebViewInputFooter.i(WebViewInputFooter.this).setVisibility(8);
        WebViewInputFooter.i(WebViewInputFooter.this);
        WebViewInputFooter.f(WebViewInputFooter.this).setImageResource(c.e.chatting_setmode_biaoqing_btn);
        WebViewInputFooter.a(WebViewInputFooter.this, 0);
        AppMethodBeat.o(82309);
        return false;
      }
    });
    this.QyU = new WebViewSmileyPanel(getContext());
    this.QyU.setVisibility(8);
    this.QyU.setBackgroundResource(c.e.white_list_top_line_selector);
    this.QyU.setOnTextOperationListener(new WebViewSmileyPanel.a()
    {
      public final void aDO()
      {
        AppMethodBeat.i(82311);
        if ((WebViewInputFooter.c(WebViewInputFooter.this)) && (WebViewInputFooter.j(WebViewInputFooter.this) != null))
        {
          WebViewInputFooter.j(WebViewInputFooter.this).dO("[DELETE_EMOTION]");
          AppMethodBeat.o(82311);
          return;
        }
        if (WebViewInputFooter.d(WebViewInputFooter.this) != null) {
          WebViewInputFooter.d(WebViewInputFooter.this).hZu();
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
            WebViewInputFooter.j(WebViewInputFooter.this).dO(paramAnonymousString);
            AppMethodBeat.o(82310);
            return;
          }
          WebViewInputFooter.this.QyY.bBa(paramAnonymousString);
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
    ((LinearLayout)findViewById(c.f.root)).addView(this.QyU, -1, 0);
    this.QyX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82314);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        c.i(WebViewInputFooter.d(WebViewInputFooter.this)).axx(WebViewInputFooter.l(WebViewInputFooter.this)).b(g.a.XSt).Hh(true).a(new c.a()
        {
          public final void abc(String paramAnonymous2String)
          {
            AppMethodBeat.i(82312);
            if (WebViewInputFooter.k(WebViewInputFooter.this) != null)
            {
              paramAnonymous2String = WebViewInputFooter.k(WebViewInputFooter.this);
              WebViewInputFooter.d(WebViewInputFooter.this).getText();
              paramAnonymous2String.gUP();
            }
            paramAnonymous2String = WebViewInputFooter.this;
            paramAnonymous2String.QyY.clearComposingText();
            paramAnonymous2String.QyY.setText("");
            AppMethodBeat.o(82312);
          }
          
          public final void abd(String paramAnonymous2String) {}
          
          public final void dN(String paramAnonymous2String)
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
    this.QyY.addTextChangedListener(new TextWatcher()
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
  
  private int gYK()
  {
    AppMethodBeat.i(82317);
    if (this.QyT != null) {
      this.QyT.gUK();
    }
    if (this.QyY != null) {
      this.iXq.hideVKB(this.QyY);
    }
    this.QyU.setVisibility(0);
    this.QyU.cpz();
    ViewGroup.LayoutParams localLayoutParams = this.QyU.getLayoutParams();
    if ((localLayoutParams != null) && (this.EOk))
    {
      localLayoutParams.height = i.getValidPanelHeight(getContext());
      this.QyU.setLayoutParams(localLayoutParams);
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
  
  private void hce()
  {
    AppMethodBeat.i(82321);
    if (this.QyY != null)
    {
      this.QyY.clearFocus();
      this.QyY.setFocusable(false);
      this.QyY.setFocusableInTouchMode(false);
    }
    AppMethodBeat.o(82321);
  }
  
  public final void aDL()
  {
    AppMethodBeat.i(82318);
    if (this.QyT != null) {
      this.QyT.gUL();
    }
    this.QyU.setVisibility(8);
    this.rwL.setImageResource(c.h.icons_outlined_emoji);
    this.state = 0;
    AppMethodBeat.o(82318);
  }
  
  public final int hcf()
  {
    AppMethodBeat.i(82322);
    setVisibility(0);
    if (this.QyZ != null) {
      this.QyZ.setVisibility(8);
    }
    this.Qza = true;
    this.state = 1;
    int i = gYK();
    AppMethodBeat.o(82322);
    return i;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82323);
    setVisibility(8);
    if (this.iXq != null)
    {
      if (this.QyY != null) {
        this.iXq.hideVKB(this.QyY);
      }
      this.iXq.hideVKB();
    }
    this.state = 0;
    aDL();
    hce();
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
    hce();
    if ((this.QyY != null) && (this.iXq != null)) {
      this.iXq.hideVKB(this.QyY);
    }
    this.QyY = null;
    this.QyU.onDestroy();
    removeAllViews();
    this.iXq = null;
    this.QyR = null;
    AppMethodBeat.o(82319);
  }
  
  public final void setMaxCount(int paramInt)
  {
    if (paramInt > 0) {
      this.Qzb = paramInt;
    }
  }
  
  public final void setOnSmileyChosenListener(WebViewInputFooter.a parama)
  {
    this.QyS = parama;
  }
  
  public final void setOnSmileyPanelVisibilityChangedListener(b paramb)
  {
    this.QyT = paramb;
  }
  
  public final void setOnTextSendListener(WebViewInputFooter.c paramc)
  {
    this.QyR = paramc;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(82320);
    this.QyY.setText("");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82320);
      return;
    }
    try
    {
      this.QyY.append(paramString);
      Log.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[] { this.QyY.getText() });
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
  
  public static abstract interface b
  {
    public abstract void gUK();
    
    public abstract void gUL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter
 * JD-Core Version:    0.7.0.1
 */