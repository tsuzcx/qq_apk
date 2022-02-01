package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter
  extends LinearLayout
{
  private boolean KIJ;
  private WebViewInputFooter.c XrJ;
  private WebViewInputFooter.a XrK;
  private b XrL;
  private WebViewSmileyPanel XrM;
  private View XrN;
  private View XrO;
  private View XrP;
  MMEditText XrQ;
  private LinearLayout XrR;
  public boolean XrS;
  private int XrT;
  private MMActivity lzt;
  public int state;
  private ImageButton uHP;
  
  public WebViewInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82316);
    this.state = 0;
    this.XrT = 2147483647;
    this.KIJ = true;
    this.lzt = ((MMActivity)paramContext);
    paramContext = (ViewGroup)View.inflate(this.lzt, c.g.webview_input_footer, this);
    this.XrR = ((LinearLayout)paramContext.findViewById(c.f.webview_input_container));
    this.XrO = paramContext.findViewById(c.f.webview_input_send_btn);
    this.XrP = paramContext.findViewById(c.f.webview_input_green_send_btn);
    this.XrN = paramContext.findViewById(c.f.webview_input_send_button_container);
    this.XrQ = ((MMEditText)paramContext.findViewById(c.f.webview_input_content_edit));
    this.uHP = ((ImageButton)paramContext.findViewById(c.f.webview_input_smiley_image));
    this.uHP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82308);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    this.XrQ.setOnTouchListener(new View.OnTouchListener()
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
    this.XrM = new WebViewSmileyPanel(getContext());
    this.XrM.setVisibility(8);
    this.XrM.setBackgroundResource(c.e.white_list_top_line_selector);
    this.XrM.setOnTextOperationListener(new WebViewSmileyPanel.a()
    {
      public final void aWM()
      {
        AppMethodBeat.i(82311);
        if ((WebViewInputFooter.c(WebViewInputFooter.this)) && (WebViewInputFooter.j(WebViewInputFooter.this) != null) && (WebViewInputFooter.j(WebViewInputFooter.this).eZ("[DELETE_EMOTION]")))
        {
          AppMethodBeat.o(82311);
          return;
        }
        if (WebViewInputFooter.d(WebViewInputFooter.this) != null) {
          WebViewInputFooter.d(WebViewInputFooter.this).jED();
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
            WebViewInputFooter.j(WebViewInputFooter.this).eZ(paramAnonymousString);
            AppMethodBeat.o(82310);
            return;
          }
          WebViewInputFooter.this.XrQ.bDt(paramAnonymousString);
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
    ((LinearLayout)findViewById(c.f.root)).addView(this.XrM, -1, 0);
    this.XrP.setOnClickListener(new WebViewInputFooter.4(this));
    this.XrQ.addTextChangedListener(new WebViewInputFooter.5(this));
    AppMethodBeat.o(82316);
  }
  
  private void iCB()
  {
    AppMethodBeat.i(82321);
    if (this.XrQ != null)
    {
      this.XrQ.clearFocus();
      this.XrQ.setFocusable(false);
      this.XrQ.setFocusableInTouchMode(false);
    }
    AppMethodBeat.o(82321);
  }
  
  private int iyH()
  {
    AppMethodBeat.i(82317);
    if (this.XrL != null) {
      this.XrL.iut();
    }
    if (this.XrQ != null) {
      this.lzt.hideVKB(this.XrQ);
    }
    this.XrM.setVisibility(0);
    this.XrM.cSc();
    ViewGroup.LayoutParams localLayoutParams = this.XrM.getLayoutParams();
    if ((localLayoutParams != null) && (this.KIJ))
    {
      localLayoutParams.height = j.getValidPanelHeight(getContext());
      this.XrM.setLayoutParams(localLayoutParams);
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
  
  public final void aWJ()
  {
    AppMethodBeat.i(82318);
    if (this.XrL != null) {
      this.XrL.iuu();
    }
    this.XrM.setVisibility(8);
    this.uHP.setImageResource(c.h.icons_outlined_emoji);
    this.state = 0;
    AppMethodBeat.o(82318);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82323);
    setVisibility(8);
    if (this.lzt != null)
    {
      if (this.XrQ != null) {
        this.lzt.hideVKB(this.XrQ);
      }
      this.lzt.hideVKB();
    }
    this.state = 0;
    aWJ();
    iCB();
    AppMethodBeat.o(82323);
  }
  
  public final int iCC()
  {
    AppMethodBeat.i(82322);
    setVisibility(0);
    if (this.XrR != null) {
      this.XrR.setVisibility(8);
    }
    this.XrS = true;
    this.state = 1;
    int i = iyH();
    AppMethodBeat.o(82322);
    return i;
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
    iCB();
    if ((this.XrQ != null) && (this.lzt != null)) {
      this.lzt.hideVKB(this.XrQ);
    }
    this.XrQ = null;
    this.XrM.onDestroy();
    removeAllViews();
    this.lzt = null;
    this.XrJ = null;
    AppMethodBeat.o(82319);
  }
  
  public final void setMaxCount(int paramInt)
  {
    if (paramInt > 0) {
      this.XrT = paramInt;
    }
  }
  
  public final void setOnSmileyChosenListener(WebViewInputFooter.a parama)
  {
    this.XrK = parama;
  }
  
  public final void setOnSmileyPanelVisibilityChangedListener(b paramb)
  {
    this.XrL = paramb;
  }
  
  public final void setOnTextSendListener(WebViewInputFooter.c paramc)
  {
    this.XrJ = paramc;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(82320);
    this.XrQ.setText("");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82320);
      return;
    }
    try
    {
      this.XrQ.append(paramString);
      Log.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[] { this.XrQ.getText() });
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
    public abstract void iut();
    
    public abstract void iuu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter
 * JD-Core Version:    0.7.0.1
 */