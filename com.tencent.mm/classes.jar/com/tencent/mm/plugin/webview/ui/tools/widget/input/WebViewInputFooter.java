package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter
  extends LinearLayout
{
  public MMActivity cmc;
  private ImageButton jnj;
  private boolean oxq;
  public int state;
  private WebViewInputFooter.c vtp;
  private WebViewInputFooter.a vtq;
  private b vtr;
  private WebViewSmileyPanel vts;
  public View vtt;
  private View vtu;
  private View vtv;
  public MMEditText vtw;
  public LinearLayout vtx;
  public boolean vty;
  private int vtz;
  
  public WebViewInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(10083);
    this.state = 0;
    this.vtz = 2147483647;
    this.oxq = true;
    this.cmc = ((MMActivity)paramContext);
    paramContext = (ViewGroup)View.inflate(this.cmc, 2130971302, this);
    this.vtx = ((LinearLayout)paramContext.findViewById(2131829537));
    this.vtu = paramContext.findViewById(2131829541);
    this.vtv = paramContext.findViewById(2131829542);
    this.vtt = paramContext.findViewById(2131829540);
    this.vtw = ((MMEditText)paramContext.findViewById(2131829538));
    this.jnj = ((ImageButton)paramContext.findViewById(2131829539));
    this.jnj.setOnClickListener(new WebViewInputFooter.1(this));
    this.vtw.setOnTouchListener(new WebViewInputFooter.2(this));
    this.vts = new WebViewSmileyPanel(getContext());
    this.vts.setVisibility(8);
    this.vts.setBackgroundResource(2130838022);
    this.vts.setOnTextOperationListener(new WebViewInputFooter.3(this));
    ((LinearLayout)findViewById(2131821003)).addView(this.vts, -1, 0);
    this.vtv.setOnClickListener(new WebViewInputFooter.4(this));
    this.vtw.addTextChangedListener(new WebViewInputFooter.5(this));
    AppMethodBeat.o(10083);
  }
  
  private void aRm()
  {
    AppMethodBeat.i(10085);
    if (this.vtr != null) {
      this.vtr.dbi();
    }
    this.vts.setVisibility(8);
    this.jnj.setImageResource(2131231506);
    this.state = 0;
    AppMethodBeat.o(10085);
  }
  
  private int daT()
  {
    AppMethodBeat.i(10084);
    if (this.vtr != null) {
      this.vtr.dbh();
    }
    if (this.vtw != null) {
      this.cmc.hideVKB(this.vtw);
    }
    this.vts.setVisibility(0);
    Object localObject = this.vts;
    if (((WebViewSmileyPanel)localObject).Qz != null) {
      ((WebViewSmileyPanel)localObject).Qz.setVisibility(0);
    }
    localObject = this.vts.getLayoutParams();
    if ((localObject != null) && (this.oxq))
    {
      ((ViewGroup.LayoutParams)localObject).height = j.gL(getContext());
      this.vts.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (localObject != null)
    {
      int i = ((ViewGroup.LayoutParams)localObject).height;
      AppMethodBeat.o(10084);
      return i;
    }
    AppMethodBeat.o(10084);
    return 0;
  }
  
  private void dha()
  {
    AppMethodBeat.i(10088);
    if (this.vtw != null)
    {
      this.vtw.clearFocus();
      this.vtw.setFocusable(false);
      this.vtw.setFocusableInTouchMode(false);
    }
    AppMethodBeat.o(10088);
  }
  
  public final int dhb()
  {
    AppMethodBeat.i(10089);
    setVisibility(0);
    if (this.vtx != null) {
      this.vtx.setVisibility(8);
    }
    this.vty = true;
    this.state = 1;
    int i = daT();
    AppMethodBeat.o(10089);
    return i;
  }
  
  public final void dhc()
  {
    AppMethodBeat.i(10091);
    if (this.vty) {
      setVisibility(8);
    }
    this.state = 0;
    aRm();
    AppMethodBeat.o(10091);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(10090);
    setVisibility(8);
    if (this.cmc != null)
    {
      if (this.vtw != null) {
        this.cmc.hideVKB(this.vtw);
      }
      this.cmc.hideVKB();
    }
    this.state = 0;
    aRm();
    dha();
    AppMethodBeat.o(10090);
  }
  
  public final boolean isShown()
  {
    AppMethodBeat.i(10092);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(10092);
      return true;
    }
    AppMethodBeat.o(10092);
    return false;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(10086);
    super.onDetachedFromWindow();
    dha();
    if ((this.vtw != null) && (this.cmc != null)) {
      this.cmc.hideVKB(this.vtw);
    }
    this.vtw = null;
    WebViewSmileyPanel localWebViewSmileyPanel = this.vts;
    c localc = localWebViewSmileyPanel.vtC;
    localc.vtI = null;
    localc.jpJ = null;
    if (localWebViewSmileyPanel.Qz != null)
    {
      ((ViewGroup)localWebViewSmileyPanel.Qz.getParent()).removeView(localWebViewSmileyPanel.Qz);
      ((ViewGroup)localWebViewSmileyPanel.Qz).removeAllViews();
      localWebViewSmileyPanel.Qz = null;
    }
    localWebViewSmileyPanel.jpX = null;
    removeAllViews();
    this.cmc = null;
    this.vtp = null;
    AppMethodBeat.o(10086);
  }
  
  public final void setMaxCount(int paramInt)
  {
    if (paramInt > 0) {
      this.vtz = paramInt;
    }
  }
  
  public final void setOnSmileyChosenListener(WebViewInputFooter.a parama)
  {
    this.vtq = parama;
  }
  
  public final void setOnSmileyPanelVisibilityChangedListener(b paramb)
  {
    this.vtr = paramb;
  }
  
  public final void setOnTextSendListener(WebViewInputFooter.c paramc)
  {
    this.vtp = paramc;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(10087);
    this.vtw.setText("");
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(10087);
      return;
    }
    try
    {
      this.vtw.append(paramString);
      ab.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[] { this.vtw.getText() });
      AppMethodBeat.o(10087);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramString });
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void dbh();
    
    public abstract void dbi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter
 * JD-Core Version:    0.7.0.1
 */