package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter
  extends LinearLayout
{
  public MMActivity bER;
  private ImageButton huY;
  private boolean lXR = true;
  private WebViewInputFooter.c rDd;
  private WebViewInputFooter.a rDe;
  private b rDf;
  private WebViewSmileyPanel rDg;
  public View rDh;
  private View rDi;
  private View rDj;
  public MMEditText rDk;
  public LinearLayout rDl;
  public boolean rDm;
  private int rDn = 2147483647;
  public int state = 0;
  
  public WebViewInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    paramContext = (ViewGroup)View.inflate(this.bER, R.i.webview_input_footer, this);
    this.rDl = ((LinearLayout)paramContext.findViewById(R.h.webview_input_container));
    this.rDi = paramContext.findViewById(R.h.webview_input_send_btn);
    this.rDj = paramContext.findViewById(R.h.webview_input_green_send_btn);
    this.rDh = paramContext.findViewById(R.h.webview_input_send_button_container);
    this.rDk = ((MMEditText)paramContext.findViewById(R.h.webview_input_content_edit));
    this.huY = ((ImageButton)paramContext.findViewById(R.h.webview_input_smiley_image));
    this.huY.setOnClickListener(new WebViewInputFooter.1(this));
    this.rDk.setOnTouchListener(new WebViewInputFooter.2(this));
    this.rDg = new WebViewSmileyPanel(getContext());
    this.rDg.setVisibility(8);
    this.rDg.setBackgroundResource(R.g.bottombar_bg);
    this.rDg.setOnTextOperationListener(new WebViewInputFooter.3(this));
    ((LinearLayout)findViewById(R.h.root)).addView(this.rDg, -1, 0);
    this.rDj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = com.tencent.mm.ui.tools.a.c.d(WebViewInputFooter.d(WebViewInputFooter.this)).Ig(WebViewInputFooter.l(WebViewInputFooter.this));
        paramAnonymousView.huj = f.a.wcS;
        paramAnonymousView.wfM = true;
        paramAnonymousView.a(new WebViewInputFooter.4.1(this));
      }
    });
    this.rDk.addTextChangedListener(new WebViewInputFooter.5(this));
  }
  
  private int cdV()
  {
    int i = 0;
    if (this.rDf != null) {
      this.rDf.cbe();
    }
    if (this.rDk != null) {
      this.bER.hideVKB(this.rDk);
    }
    this.rDg.setVisibility(0);
    Object localObject = this.rDg;
    if (((WebViewSmileyPanel)localObject).QR != null) {
      ((WebViewSmileyPanel)localObject).QR.setVisibility(0);
    }
    localObject = this.rDg.getLayoutParams();
    if ((localObject != null) && (this.lXR))
    {
      ((ViewGroup.LayoutParams)localObject).height = j.fy(getContext());
      this.rDg.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (localObject != null) {
      i = ((ViewGroup.LayoutParams)localObject).height;
    }
    return i;
  }
  
  private void cgT()
  {
    if (this.rDk != null)
    {
      this.rDk.clearFocus();
      this.rDk.setFocusable(false);
      this.rDk.setFocusableInTouchMode(false);
    }
  }
  
  private void hideSmileyPanel()
  {
    if (this.rDf != null) {
      this.rDf.cbf();
    }
    this.rDg.setVisibility(8);
    this.huY.setImageResource(R.k.textfield_icon_emoji_normal);
    this.state = 0;
  }
  
  public final int cgU()
  {
    setVisibility(0);
    if (this.rDl != null) {
      this.rDl.setVisibility(8);
    }
    this.rDm = true;
    this.state = 1;
    return cdV();
  }
  
  public final void cgV()
  {
    if (this.rDm) {
      setVisibility(8);
    }
    this.state = 0;
    hideSmileyPanel();
  }
  
  public final void hide()
  {
    setVisibility(8);
    if (this.bER != null)
    {
      if (this.rDk != null) {
        this.bER.hideVKB(this.rDk);
      }
      this.bER.XM();
    }
    this.state = 0;
    hideSmileyPanel();
    cgT();
  }
  
  public final boolean isShown()
  {
    return getVisibility() == 0;
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    cgT();
    if ((this.rDk != null) && (this.bER != null)) {
      this.bER.hideVKB(this.rDk);
    }
    this.rDk = null;
    WebViewSmileyPanel localWebViewSmileyPanel = this.rDg;
    c localc = localWebViewSmileyPanel.rDq;
    localc.rDw = null;
    localc.hxz = null;
    if (localWebViewSmileyPanel.QR != null)
    {
      ((ViewGroup)localWebViewSmileyPanel.QR.getParent()).removeView(localWebViewSmileyPanel.QR);
      ((ViewGroup)localWebViewSmileyPanel.QR).removeAllViews();
      localWebViewSmileyPanel.QR = null;
    }
    localWebViewSmileyPanel.hxN = null;
    removeAllViews();
    this.bER = null;
    this.rDd = null;
  }
  
  public final void setMaxCount(int paramInt)
  {
    if (paramInt > 0) {
      this.rDn = paramInt;
    }
  }
  
  public final void setOnSmileyChosenListener(WebViewInputFooter.a parama)
  {
    this.rDe = parama;
  }
  
  public final void setOnSmileyPanelVisibilityChangedListener(b paramb)
  {
    this.rDf = paramb;
  }
  
  public final void setOnTextSendListener(WebViewInputFooter.c paramc)
  {
    this.rDd = paramc;
  }
  
  public final void setText(String paramString)
  {
    this.rDk.setText("");
    if (bk.bl(paramString)) {
      return;
    }
    try
    {
      this.rDk.append(paramString);
      y.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[] { this.rDk.getText() });
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramString });
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void cbe();
    
    public abstract void cbf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter
 * JD-Core Version:    0.7.0.1
 */