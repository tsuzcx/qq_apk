package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Map;

public class WebViewRedesignInputFooter
  extends LinearLayout
{
  private ViewGroup CAj;
  public View FPs;
  private boolean KIJ;
  private WebViewInputFooter.b XrL;
  public WebViewSmileyPanel XrM;
  private View XrN;
  public MMEditText XrQ;
  public boolean XrS;
  private int XrT;
  public b XrW;
  private WebViewRedesignInputFooter.a XrX;
  private View XrY;
  private Button XrZ;
  private TextView Xsa;
  private boolean Xsb;
  private int Xsc;
  public MMActivity lzt;
  public int state;
  private ImageButton uHP;
  private Button xUY;
  
  public WebViewRedesignInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(298093);
    this.state = 0;
    this.XrT = 2147483647;
    this.Xsc = 2147483647;
    this.KIJ = true;
    this.lzt = ((MMActivity)paramContext);
    iCH();
    AppMethodBeat.o(298093);
  }
  
  private void ct(Map<String, String> paramMap)
  {
    AppMethodBeat.i(298128);
    iCH();
    setVisibility(0);
    if (this.XrY != null) {
      this.XrY.setVisibility(0);
    }
    if (this.FPs != null) {
      this.FPs.setVisibility(0);
    }
    if (this.XrQ != null)
    {
      this.XrQ.setEnabled(true);
      this.XrQ.setBackgroundResource(c.e.webview_inputer_edit_bg);
    }
    if (this.XrN != null) {
      this.XrN.setVisibility(0);
    }
    paramMap = (String)paramMap.get("sendButtonWord");
    if (!Util.isNullOrNil(paramMap))
    {
      this.xUY.setText(paramMap);
      this.XrZ.setText(paramMap);
    }
    this.XrS = false;
    iCG();
    showVKB();
    this.state = 0;
    AppMethodBeat.o(298128);
  }
  
  private void cu(Map<String, String> paramMap)
  {
    AppMethodBeat.i(298143);
    iCI();
    setVisibility(0);
    Object localObject = (TextView)this.CAj.findViewById(c.f.left_top_word);
    TextView localTextView = (TextView)this.CAj.findViewById(c.f.left_right_word);
    String str1 = (String)paramMap.get("leftWords");
    String str2 = (String)paramMap.get("rightWords");
    String str3 = (String)paramMap.get("editBoxHeight");
    try
    {
      i = Integer.parseInt(str3);
      ((TextView)localObject).setText(str1);
      localTextView.setText(str2);
      localTextView.setOnClickListener(new WebViewRedesignInputFooter.9(this));
      o.F(localTextView, 0.5F);
      if (this.XrY != null) {
        this.XrY.setVisibility(0);
      }
      if (this.FPs != null) {
        this.FPs.setVisibility(0);
      }
      if (this.XrQ != null)
      {
        this.XrQ.setEnabled(true);
        this.XrQ.setBackgroundResource(c.e.webview_inputer_edit_bg);
        if (i > 0)
        {
          localObject = this.XrQ.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.cd.a.fromDPToPix(this.lzt, i);
          this.XrQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.XrN != null) {
        this.XrN.setVisibility(0);
      }
      paramMap = (String)paramMap.get("sendButtonWord");
      if (!Util.isNullOrNil(paramMap))
      {
        this.xUY.setText(paramMap);
        this.XrZ.setText(paramMap);
      }
      this.XrS = false;
      iCG();
      showVKB();
      this.state = 0;
      AppMethodBeat.o(298143);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  private void iCD()
  {
    AppMethodBeat.i(298098);
    if (this.uHP != null)
    {
      this.uHP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(298054);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this) == 0)
          {
            WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, 1);
            WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).hideVKB();
            if (!WebViewRedesignInputFooter.c(WebViewRedesignInputFooter.this)) {
              WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).requestFocus();
            }
            WebViewRedesignInputFooter.e(WebViewRedesignInputFooter.this);
            WebViewRedesignInputFooter.f(WebViewRedesignInputFooter.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(298054);
            return;
            WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, 0);
            WebViewRedesignInputFooter.f(WebViewRedesignInputFooter.this);
            WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).requestFocus();
            WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).showVKB();
            WebViewRedesignInputFooter.g(WebViewRedesignInputFooter.this);
          }
        }
      });
      o.F(this.uHP, 0.5F);
    }
    this.XrM = new WebViewSmileyPanel(getContext());
    this.XrM.setVisibility(8);
    this.XrM.setBackgroundResource(c.e.white_list_top_line_selector);
    this.XrM.setOnTextOperationListener(new WebViewSmileyPanel.a()
    {
      public final void aWM()
      {
        AppMethodBeat.i(298059);
        if ((WebViewRedesignInputFooter.c(WebViewRedesignInputFooter.this)) && (WebViewRedesignInputFooter.h(WebViewRedesignInputFooter.this) != null) && (WebViewRedesignInputFooter.h(WebViewRedesignInputFooter.this).eZ("[DELETE_EMOTION]")))
        {
          AppMethodBeat.o(298059);
          return;
        }
        if (WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this) != null) {
          WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).jED();
        }
        AppMethodBeat.o(298059);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(298057);
        try
        {
          if (WebViewRedesignInputFooter.c(WebViewRedesignInputFooter.this))
          {
            WebViewRedesignInputFooter.h(WebViewRedesignInputFooter.this).eZ(paramAnonymousString);
            AppMethodBeat.o(298057);
            return;
          }
          WebViewRedesignInputFooter.this.appendText(paramAnonymousString);
          AppMethodBeat.o(298057);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(298057);
        }
      }
    });
    ((LinearLayout)findViewById(c.f.root)).addView(this.XrM, -1, 0);
    if (this.XrZ != null) {
      this.XrZ.setOnClickListener(new WebViewRedesignInputFooter.4(this));
    }
    if (this.XrQ != null) {
      this.XrQ.addTextChangedListener(new WebViewRedesignInputFooter.5(this));
    }
    AppMethodBeat.o(298098);
  }
  
  private void iCE()
  {
    AppMethodBeat.i(298102);
    if (this.XrL != null) {
      this.XrL.iuu();
    }
    this.state = 0;
    this.XrM.setVisibility(8);
    this.Xsb = false;
    AppMethodBeat.o(298102);
  }
  
  private void iCG()
  {
    AppMethodBeat.i(298113);
    if (this.XrQ != null)
    {
      this.XrQ.setFocusable(true);
      this.XrQ.setFocusableInTouchMode(true);
      this.XrQ.requestFocus();
    }
    AppMethodBeat.o(298113);
  }
  
  private void iCH()
  {
    AppMethodBeat.i(298154);
    removeAllViews();
    this.CAj = ((ViewGroup)View.inflate(this.lzt, c.g.webview_redesign_input_footer_default, this));
    this.FPs = this.CAj.findViewById(c.f.webview_input_container);
    this.xUY = ((Button)this.CAj.findViewById(c.f.webview_input_send_btn));
    this.XrZ = ((Button)this.CAj.findViewById(c.f.webview_input_green_send_btn));
    this.XrN = this.CAj.findViewById(c.f.webview_input_send_button_container);
    this.XrQ = ((MMEditText)this.CAj.findViewById(c.f.webview_input_content_edit));
    this.Xsa = ((TextView)this.CAj.findViewById(c.f.webview_tv_word_count_remind));
    this.uHP = ((ImageButton)this.CAj.findViewById(c.f.webview_input_smiley_image));
    this.KIJ = true;
    iCD();
    AppMethodBeat.o(298154);
  }
  
  private void iCI()
  {
    AppMethodBeat.i(298166);
    removeAllViews();
    this.CAj = ((ViewGroup)View.inflate(this.lzt, c.g.webview_redesign_input_footer_for_write_message, this));
    this.FPs = this.CAj.findViewById(c.f.webview_input_container);
    this.XrQ = ((MMEditText)this.CAj.findViewById(c.f.webview_input_content_edit));
    this.Xsa = ((TextView)this.CAj.findViewById(c.f.webview_tv_word_count_remind));
    this.uHP = ((ImageButton)this.CAj.findViewById(c.f.webview_input_smiley_image));
    this.xUY = ((Button)this.CAj.findViewById(c.f.webview_input_send_btn));
    this.XrZ = ((Button)this.CAj.findViewById(c.f.webview_input_green_send_btn));
    this.XrN = this.CAj.findViewById(c.f.webview_input_send_button_container);
    this.KIJ = true;
    iCD();
    AppMethodBeat.o(298166);
  }
  
  public static CharSequence j(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(298109);
    if (Util.isNullOrNil(paramCharSequence))
    {
      AppMethodBeat.o(298109);
      return "";
    }
    Object localObject1 = paramCharSequence.toString();
    int j = 0;
    int k = 0;
    int i = 0;
    while (j < ((String)localObject1).length())
    {
      k += g.G(((String)localObject1).charAt(j));
      if (g.aEd(k) > paramInt) {
        break;
      }
      i = j;
      j += 1;
    }
    if (i < ((String)localObject1).length()) {}
    for (paramInt = i + 1;; paramInt = i) {
      for (;;)
      {
        try
        {
          if (!(paramCharSequence instanceof SpannableString)) {
            continue;
          }
          localObject1 = (k[])((SpannableString)paramCharSequence).getSpans(0, paramCharSequence.length(), k.class);
          j = localObject1.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          Object localObject2 = localObject1[i];
          if ((paramInt >= localObject2.end) || (paramInt < localObject2.start)) {
            continue;
          }
          i = localObject2.end;
          paramInt = i;
        }
        catch (Exception localException)
        {
          continue;
        }
        paramCharSequence = paramCharSequence.subSequence(0, paramInt);
        AppMethodBeat.o(298109);
        return paramCharSequence;
        i += 1;
      }
    }
  }
  
  private void showVKB()
  {
    AppMethodBeat.i(298120);
    if (this.lzt != null) {
      this.lzt.showVKB();
    }
    AppMethodBeat.o(298120);
  }
  
  public final void appendText(String paramString)
  {
    AppMethodBeat.i(298332);
    if (paramString == null)
    {
      AppMethodBeat.o(298332);
      return;
    }
    if (g.bCy(this.XrQ.getText() + paramString) <= this.XrT) {
      this.XrQ.bDt(paramString);
    }
    AppMethodBeat.o(298332);
  }
  
  public final void cs(Map<String, String> paramMap)
  {
    AppMethodBeat.i(298368);
    String str = (String)paramMap.get("showType");
    if (!Util.isNullOrNil(str)) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt(str);
        if (i != 1) {
          break;
        }
        cu(paramMap);
        AppMethodBeat.o(298368);
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
      int i = 0;
    }
    ct(paramMap);
    AppMethodBeat.o(298368);
  }
  
  public int getInputFooterHeightWhenPanelHide()
  {
    AppMethodBeat.i(298303);
    if (this.Xsb)
    {
      i = getHeight();
      int j = this.XrM.getHeight();
      AppMethodBeat.o(298303);
      return i - j;
    }
    int i = getHeight();
    AppMethodBeat.o(298303);
    return i;
  }
  
  public int getSmilePanelHeight()
  {
    AppMethodBeat.i(298297);
    int i = this.XrM.getHeight();
    AppMethodBeat.o(298297);
    return i;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(298373);
    if (this.XrY != null) {
      this.XrY.setVisibility(8);
    }
    setVisibility(8);
    String str1 = "";
    String str2 = str1;
    if (this.lzt != null)
    {
      if (this.XrQ != null)
      {
        this.lzt.hideVKB(this.XrQ);
        str1 = this.XrQ.getText().toString();
      }
      this.lzt.hideVKB();
      str2 = str1;
    }
    this.state = 0;
    wi(false);
    iCB();
    if (this.XrW != null) {
      this.XrW.blT(str2);
    }
    AppMethodBeat.o(298373);
  }
  
  public final void iCB()
  {
    AppMethodBeat.i(298362);
    if (this.XrQ != null)
    {
      this.XrQ.clearFocus();
      this.XrQ.setFocusable(false);
      this.XrQ.setFocusableInTouchMode(false);
    }
    AppMethodBeat.o(298362);
  }
  
  public final void iCF()
  {
    AppMethodBeat.i(298325);
    this.XrQ.clearComposingText();
    this.XrQ.setText("");
    AppMethodBeat.o(298325);
  }
  
  public boolean isShown()
  {
    AppMethodBeat.i(298376);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(298376);
      return true;
    }
    AppMethodBeat.o(298376);
    return false;
  }
  
  public final int iyH()
  {
    AppMethodBeat.i(298310);
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
    this.uHP.setImageResource(c.h.icons_outlined_keyboard);
    if (localLayoutParams != null)
    {
      int i = localLayoutParams.height;
      AppMethodBeat.o(298310);
      return i;
    }
    AppMethodBeat.o(298310);
    return 0;
  }
  
  public void setInputShadowView(View paramView)
  {
    AppMethodBeat.i(298291);
    this.XrY = paramView;
    if (paramView != null) {
      paramView.setOnClickListener(new WebViewRedesignInputFooter.1(this, paramView));
    }
    AppMethodBeat.o(298291);
  }
  
  public void setMaxCount(int paramInt)
  {
    AppMethodBeat.i(298357);
    this.XrT = 0;
    if (paramInt <= 0)
    {
      this.XrQ.setFilters(new InputFilter[0]);
      AppMethodBeat.o(298357);
      return;
    }
    this.XrT = paramInt;
    this.XrQ.setFilters(new InputFilter[] { new g(this.XrT, g.a.afIJ)
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(298075);
        if (paramAnonymousCharSequence == null)
        {
          AppMethodBeat.o(298075);
          return "";
        }
        int i = a(paramAnonymousSpanned.toString(), g.a.afIJ);
        if ((Util.isNullOrNil(paramAnonymousCharSequence)) && (paramAnonymousInt3 < paramAnonymousInt4))
        {
          paramAnonymousSpanned = paramAnonymousSpanned.toString().substring(0, paramAnonymousInt3) + paramAnonymousSpanned.toString().substring(paramAnonymousInt4);
          paramAnonymousInt4 = a(paramAnonymousSpanned, g.a.afIJ);
          paramAnonymousInt2 = WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this);
          paramAnonymousInt3 = WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this) - WebViewRedesignInputFooter.m(WebViewRedesignInputFooter.this);
          if (paramAnonymousInt3 <= paramAnonymousInt2)
          {
            paramAnonymousInt1 = paramAnonymousInt3;
            if (paramAnonymousInt3 > 0) {}
          }
          else
          {
            paramAnonymousInt1 = paramAnonymousInt2;
          }
          if (paramAnonymousInt4 < paramAnonymousInt2) {
            break label306;
          }
          paramAnonymousSpanned = Util.safeFormatString(WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).getString(c.i.webview_input_reach_max_input_len), new Object[] { Integer.valueOf(WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this)) });
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setVisibility(0);
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setText(paramAnonymousSpanned);
          paramAnonymousInt1 = Math.max(paramAnonymousInt2 - i, 0);
          if (paramAnonymousInt1 != 0) {
            break label255;
          }
          paramAnonymousSpanned = "";
        }
        for (;;)
        {
          AppMethodBeat.o(298075);
          return paramAnonymousSpanned;
          paramAnonymousSpanned = paramAnonymousSpanned.toString() + paramAnonymousCharSequence.toString();
          break;
          label255:
          paramAnonymousSpanned = paramAnonymousCharSequence;
          if (paramAnonymousInt1 > 0)
          {
            paramAnonymousSpanned = paramAnonymousCharSequence;
            if (paramAnonymousInt4 > paramAnonymousInt1) {
              paramAnonymousSpanned = WebViewRedesignInputFooter.j(com.tencent.mm.ui.i.c.b.c(WebViewRedesignInputFooter.this.getContext(), paramAnonymousCharSequence.toString(), WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).getTextSize()), paramAnonymousInt1);
            }
          }
        }
        label306:
        if (paramAnonymousInt4 > paramAnonymousInt1)
        {
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setVisibility(0);
          paramAnonymousSpanned = Util.safeFormatString(WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).getString(c.i.webview_input_reach_max_input_count), new Object[] { Integer.valueOf(paramAnonymousInt2 - paramAnonymousInt4) });
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setText(paramAnonymousSpanned);
          AppMethodBeat.o(298075);
          return paramAnonymousCharSequence;
        }
        WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setVisibility(8);
        AppMethodBeat.o(298075);
        return paramAnonymousCharSequence;
      }
    } });
    AppMethodBeat.o(298357);
  }
  
  public void setOnSmileyChosenListener(WebViewRedesignInputFooter.a parama)
  {
    this.XrX = parama;
  }
  
  public void setOnSmileyPanelVisibilityChangedListener(WebViewInputFooter.b paramb)
  {
    this.XrL = paramb;
  }
  
  public void setOnTextSendListener(b paramb)
  {
    this.XrW = paramb;
  }
  
  public void setPlaceholder(String paramString)
  {
    AppMethodBeat.i(298339);
    if (this.XrQ == null)
    {
      Log.e("MicroMsg.WebViewInputFooter", "contentEditText is null!");
      AppMethodBeat.o(298339);
      return;
    }
    this.XrQ.setHint("");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(298339);
      return;
    }
    try
    {
      this.XrQ.setHint(paramString);
      AppMethodBeat.o(298339);
      return;
    }
    catch (Exception paramString)
    {
      Log.d("MicroMsg.WebViewInputFooter", "appendPlaceholder, exp = %s", new Object[] { paramString });
      AppMethodBeat.o(298339);
    }
  }
  
  public void setShowRemindWordCount(int paramInt)
  {
    this.Xsc = paramInt;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(298344);
    if (this.XrQ == null)
    {
      Log.e("MicroMsg.WebViewInputFooter", "contentEditText is null!");
      AppMethodBeat.o(298344);
      return;
    }
    this.XrQ.setText("");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(298344);
      return;
    }
    try
    {
      appendText(paramString);
      this.XrQ.setSelection(paramString.length());
      AppMethodBeat.o(298344);
      return;
    }
    catch (Exception paramString)
    {
      Log.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramString });
      AppMethodBeat.o(298344);
    }
  }
  
  public final void wi(boolean paramBoolean)
  {
    AppMethodBeat.i(298319);
    this.uHP.setImageResource(c.h.icons_outlined_emoji);
    if (paramBoolean)
    {
      this.Xsb = true;
      h.ahAA.o(new WebViewRedesignInputFooter.7(this), 300L);
      AppMethodBeat.o(298319);
      return;
    }
    iCE();
    AppMethodBeat.o(298319);
  }
  
  public static abstract interface b
  {
    public abstract void blS(String paramString);
    
    public abstract void blT(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter
 * JD-Core Version:    0.7.0.1
 */