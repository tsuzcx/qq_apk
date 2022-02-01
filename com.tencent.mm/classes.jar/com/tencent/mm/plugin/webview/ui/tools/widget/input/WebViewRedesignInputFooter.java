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
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMEditText;

public class WebViewRedesignInputFooter
  extends LinearLayout
{
  private boolean EOk;
  private WebViewInputFooter.b QyT;
  public WebViewSmileyPanel QyU;
  private View QyV;
  private View QyW;
  private View QyX;
  public MMEditText QyY;
  public LinearLayout QyZ;
  public boolean Qza;
  private int Qzb;
  public b Qze;
  private WebViewRedesignInputFooter.a Qzf;
  private View Qzg;
  private TextView Qzh;
  private int Qzi;
  public MMActivity iXq;
  private ImageButton rwL;
  public int state;
  
  public WebViewRedesignInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(247357);
    this.state = 0;
    this.Qzb = 2147483647;
    this.Qzi = 2147483647;
    this.EOk = true;
    this.iXq = ((MMActivity)paramContext);
    paramContext = (ViewGroup)View.inflate(this.iXq, c.g.webview_redesign_input_footer, this);
    this.QyZ = ((LinearLayout)paramContext.findViewById(c.f.webview_input_container));
    this.QyW = paramContext.findViewById(c.f.webview_input_send_btn);
    this.QyX = paramContext.findViewById(c.f.webview_input_green_send_btn);
    this.QyV = paramContext.findViewById(c.f.webview_input_send_button_container);
    this.QyY = ((MMEditText)paramContext.findViewById(c.f.webview_input_content_edit));
    this.Qzh = ((TextView)paramContext.findViewById(c.f.webview_tv_word_count_remind));
    this.rwL = ((ImageButton)paramContext.findViewById(c.f.webview_input_smiley_image));
    this.rwL.setOnClickListener(new View.OnClickListener()
    {
      @SuppressLint({"ResourceType"})
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(256884);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this) == 0)
        {
          WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, 1);
          WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).hideVKB();
          if (!WebViewRedesignInputFooter.c(WebViewRedesignInputFooter.this)) {
            WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).requestFocus();
          }
          WebViewRedesignInputFooter.e(WebViewRedesignInputFooter.this);
          WebViewRedesignInputFooter.f(WebViewRedesignInputFooter.this).setImageResource(c.h.icons_outlined_emoji);
          WebViewRedesignInputFooter.g(WebViewRedesignInputFooter.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(256884);
          return;
          WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, 0);
          WebViewRedesignInputFooter.g(WebViewRedesignInputFooter.this);
          WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).requestFocus();
          WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).showVKB();
          WebViewRedesignInputFooter.h(WebViewRedesignInputFooter.this);
        }
      }
    });
    this.QyY.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(225597);
        WebViewRedesignInputFooter.g(WebViewRedesignInputFooter.this);
        WebViewRedesignInputFooter.i(WebViewRedesignInputFooter.this).setVisibility(8);
        WebViewRedesignInputFooter.i(WebViewRedesignInputFooter.this);
        WebViewRedesignInputFooter.f(WebViewRedesignInputFooter.this).setImageResource(c.e.chatting_setmode_biaoqing_btn);
        WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, 0);
        AppMethodBeat.o(225597);
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
        AppMethodBeat.i(225292);
        if ((WebViewRedesignInputFooter.c(WebViewRedesignInputFooter.this)) && (WebViewRedesignInputFooter.j(WebViewRedesignInputFooter.this) != null))
        {
          WebViewRedesignInputFooter.j(WebViewRedesignInputFooter.this).dO("[DELETE_EMOTION]");
          AppMethodBeat.o(225292);
          return;
        }
        if (WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this) != null) {
          WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).hZu();
        }
        AppMethodBeat.o(225292);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(225290);
        try
        {
          if (WebViewRedesignInputFooter.c(WebViewRedesignInputFooter.this))
          {
            WebViewRedesignInputFooter.j(WebViewRedesignInputFooter.this).dO(paramAnonymousString);
            AppMethodBeat.o(225290);
            return;
          }
          WebViewRedesignInputFooter.this.appendText(paramAnonymousString);
          AppMethodBeat.o(225290);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(225290);
        }
      }
    });
    ((LinearLayout)findViewById(c.f.root)).addView(this.QyU, -1, 0);
    this.QyX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(250623);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = c.i(WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this));
        if (WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this) <= 0) {}
        for (int i = 2147483647;; i = WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this))
        {
          paramAnonymousView.axx(i).b(g.a.XSv).Hh(true).a(new c.a()
          {
            public final void abc(String paramAnonymous2String)
            {
              AppMethodBeat.i(218606);
              if (WebViewRedesignInputFooter.k(WebViewRedesignInputFooter.this) != null) {
                WebViewRedesignInputFooter.k(WebViewRedesignInputFooter.this).bmq(WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).getText().toString());
              }
              WebViewRedesignInputFooter.this.hcg();
              AppMethodBeat.o(218606);
            }
            
            public final void abd(String paramAnonymous2String) {}
            
            public final void dN(String paramAnonymous2String) {}
          });
          a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(250623);
          return;
        }
      }
    });
    this.QyY.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(216697);
        if (WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).getText() == null)
        {
          AppMethodBeat.o(216697);
          return;
        }
        WebViewRedesignInputFooter.d(WebViewRedesignInputFooter.this).requestFocus();
        if ((paramAnonymousEditable.length() > 0) && (paramAnonymousEditable.toString().trim().length() > 0)) {}
        for (boolean bool = true;; bool = false)
        {
          WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, bool);
          AppMethodBeat.o(216697);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    AppMethodBeat.o(247357);
  }
  
  private void hch()
  {
    AppMethodBeat.i(247384);
    if (this.QyY != null)
    {
      this.QyY.setFocusable(true);
      this.QyY.setFocusableInTouchMode(true);
      this.QyY.requestFocus();
    }
    AppMethodBeat.o(247384);
  }
  
  public static String hh(String paramString, int paramInt)
  {
    AppMethodBeat.i(247383);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(247383);
      return "";
    }
    int j = 0;
    int k = 0;
    int i = 0;
    while (j < paramString.length())
    {
      k += g.N(paramString.charAt(j));
      if (g.axu(k) > paramInt) {
        break;
      }
      i = j;
      j += 1;
    }
    paramInt = i;
    if (i < paramString.length()) {
      paramInt = i + 1;
    }
    paramString = paramString.substring(0, paramInt);
    AppMethodBeat.o(247383);
    return paramString;
  }
  
  private void showVKB()
  {
    AppMethodBeat.i(247386);
    if (this.iXq != null) {
      this.iXq.showVKB();
    }
    AppMethodBeat.o(247386);
  }
  
  @SuppressLint({"ResourceType"})
  public final void aDL()
  {
    AppMethodBeat.i(247369);
    if (this.QyT != null) {
      this.QyT.gUL();
    }
    this.QyU.setVisibility(8);
    this.rwL.setImageResource(c.h.icons_outlined_emoji);
    this.state = 0;
    AppMethodBeat.o(247369);
  }
  
  public final void appendText(String paramString)
  {
    AppMethodBeat.i(247372);
    this.QyY.bBa(paramString);
    AppMethodBeat.o(247372);
  }
  
  public final int gYK()
  {
    AppMethodBeat.i(247365);
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
      AppMethodBeat.o(247365);
      return i;
    }
    AppMethodBeat.o(247365);
    return 0;
  }
  
  public int getSmilePanelHeight()
  {
    AppMethodBeat.i(247362);
    int i = this.QyU.getHeight();
    AppMethodBeat.o(247362);
    return i;
  }
  
  public final void hce()
  {
    AppMethodBeat.i(247389);
    if (this.QyY != null)
    {
      this.QyY.clearFocus();
      this.QyY.setFocusable(false);
      this.QyY.setFocusableInTouchMode(false);
    }
    AppMethodBeat.o(247389);
  }
  
  public final void hcg()
  {
    AppMethodBeat.i(247371);
    this.QyY.clearComposingText();
    this.QyY.setText("");
    AppMethodBeat.o(247371);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(247395);
    if (this.Qzg != null) {
      this.Qzg.setVisibility(8);
    }
    setVisibility(8);
    String str1 = "";
    String str2 = str1;
    if (this.iXq != null)
    {
      if (this.QyY != null)
      {
        this.iXq.hideVKB(this.QyY);
        str1 = this.QyY.getText().toString();
      }
      this.iXq.hideVKB();
      str2 = str1;
    }
    this.state = 0;
    aDL();
    hce();
    if (this.Qze != null) {
      this.Qze.bmr(str2);
    }
    AppMethodBeat.o(247395);
  }
  
  public boolean isShown()
  {
    AppMethodBeat.i(247396);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(247396);
      return true;
    }
    AppMethodBeat.o(247396);
    return false;
  }
  
  public void setInputShadowView(View paramView)
  {
    AppMethodBeat.i(247359);
    this.Qzg = paramView;
    if (paramView != null) {
      paramView.setOnClickListener(new WebViewRedesignInputFooter.1(this, paramView));
    }
    AppMethodBeat.o(247359);
  }
  
  public void setMaxCount(int paramInt)
  {
    AppMethodBeat.i(247382);
    this.Qzb = 0;
    if (paramInt <= 0)
    {
      this.QyY.setFilters(new InputFilter[0]);
      AppMethodBeat.o(247382);
      return;
    }
    this.Qzb = paramInt;
    this.QyY.setFilters(new InputFilter[] { new g(this.Qzb, g.a.XSv)
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(228978);
        int i = a(paramAnonymousSpanned.toString(), g.a.XSv);
        if ((Util.isNullOrNil(paramAnonymousCharSequence)) && (paramAnonymousInt3 < paramAnonymousInt4))
        {
          paramAnonymousSpanned = paramAnonymousSpanned.toString().substring(0, paramAnonymousInt3) + paramAnonymousSpanned.toString().substring(paramAnonymousInt4);
          paramAnonymousInt4 = a(paramAnonymousSpanned, g.a.XSv);
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
            break label274;
          }
          paramAnonymousSpanned = Util.safeFormatString(WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).getString(c.i.webview_input_reach_max_input_len), new Object[] { Integer.valueOf(WebViewRedesignInputFooter.l(WebViewRedesignInputFooter.this)) });
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setVisibility(0);
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setText(paramAnonymousSpanned);
          paramAnonymousInt1 = Math.max(paramAnonymousInt2 - i, 0);
          if (paramAnonymousInt1 != 0) {
            break label243;
          }
          paramAnonymousSpanned = "";
        }
        for (;;)
        {
          AppMethodBeat.o(228978);
          return paramAnonymousSpanned;
          paramAnonymousSpanned = paramAnonymousSpanned.toString() + paramAnonymousCharSequence.toString();
          break;
          label243:
          paramAnonymousSpanned = paramAnonymousCharSequence;
          if (paramAnonymousInt1 > 0)
          {
            paramAnonymousSpanned = paramAnonymousCharSequence;
            if (paramAnonymousInt4 > paramAnonymousInt1) {
              paramAnonymousSpanned = WebViewRedesignInputFooter.hh(paramAnonymousCharSequence.toString(), paramAnonymousInt1);
            }
          }
        }
        label274:
        if (paramAnonymousInt4 > paramAnonymousInt1)
        {
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setVisibility(0);
          paramAnonymousSpanned = Util.safeFormatString(WebViewRedesignInputFooter.b(WebViewRedesignInputFooter.this).getString(c.i.webview_input_reach_max_input_count), new Object[] { Integer.valueOf(paramAnonymousInt2 - paramAnonymousInt4) });
          WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setText(paramAnonymousSpanned);
          AppMethodBeat.o(228978);
          return paramAnonymousCharSequence;
        }
        WebViewRedesignInputFooter.n(WebViewRedesignInputFooter.this).setVisibility(8);
        AppMethodBeat.o(228978);
        return paramAnonymousCharSequence;
      }
    } });
    AppMethodBeat.o(247382);
  }
  
  public void setOnSmileyChosenListener(WebViewRedesignInputFooter.a parama)
  {
    this.Qzf = parama;
  }
  
  public void setOnSmileyPanelVisibilityChangedListener(WebViewInputFooter.b paramb)
  {
    this.QyT = paramb;
  }
  
  public void setOnTextSendListener(b paramb)
  {
    this.Qze = paramb;
  }
  
  public void setPlaceholder(String paramString)
  {
    AppMethodBeat.i(247376);
    if (this.QyY == null)
    {
      Log.e("MicroMsg.WebViewInputFooter", "contentEditText is null!");
      AppMethodBeat.o(247376);
      return;
    }
    this.QyY.setHint("");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(247376);
      return;
    }
    try
    {
      this.QyY.setHint(paramString);
      AppMethodBeat.o(247376);
      return;
    }
    catch (Exception paramString)
    {
      Log.d("MicroMsg.WebViewInputFooter", "appendPlaceholder, exp = %s", new Object[] { paramString });
      AppMethodBeat.o(247376);
    }
  }
  
  public void setShowRemindWordCount(int paramInt)
  {
    this.Qzi = paramInt;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(247379);
    if (this.QyY == null)
    {
      Log.e("MicroMsg.WebViewInputFooter", "contentEditText is null!");
      AppMethodBeat.o(247379);
      return;
    }
    this.QyY.setText("");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(247379);
      return;
    }
    try
    {
      appendText(paramString);
      this.QyY.setSelection(paramString.length());
      AppMethodBeat.o(247379);
      return;
    }
    catch (Exception paramString)
    {
      Log.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramString });
      AppMethodBeat.o(247379);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(247392);
    setVisibility(0);
    if (this.Qzg != null) {
      this.Qzg.setVisibility(0);
    }
    if (this.QyZ != null) {
      this.QyZ.setVisibility(0);
    }
    if (this.QyY != null)
    {
      this.QyY.setEnabled(true);
      this.QyY.setBackgroundResource(c.e.webview_inputer_edit_bg);
    }
    if (this.QyV != null) {
      this.QyV.setVisibility(0);
    }
    this.Qza = false;
    hch();
    showVKB();
    this.state = 0;
    AppMethodBeat.o(247392);
  }
  
  public static abstract interface b
  {
    public abstract void bmq(String paramString);
    
    public abstract void bmr(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter
 * JD-Core Version:    0.7.0.1
 */