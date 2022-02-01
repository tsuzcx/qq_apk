package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;

public class WebViewSearchContentInputFooter
  extends LinearLayout
{
  private View EKL;
  private EditText EKM;
  private View EKN;
  private View EKO;
  private TextView EKP;
  private a EKQ;
  private View mXI;
  
  public WebViewSearchContentInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82297);
    init();
    AppMethodBeat.o(82297);
  }
  
  public WebViewSearchContentInputFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(82298);
    init();
    AppMethodBeat.o(82298);
  }
  
  private void init()
  {
    AppMethodBeat.i(82299);
    View localView = inflate(getContext(), 2131496088, this);
    this.EKM = ((EditText)localView.findViewById(2131299306));
    this.mXI = localView.findViewById(2131298364);
    this.EKN = localView.findViewById(2131303374);
    this.EKO = localView.findViewById(2131302856);
    this.EKP = ((TextView)localView.findViewById(2131301000));
    this.EKL = localView.findViewById(2131301030);
    this.mXI.setOnClickListener(new WebViewSearchContentInputFooter.1(this));
    this.EKN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82291);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (WebViewSearchContentInputFooter.c(WebViewSearchContentInputFooter.this) != null) {
          WebViewSearchContentInputFooter.c(WebViewSearchContentInputFooter.this).eTg();
        }
        a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82291);
      }
    });
    this.EKO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82292);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (WebViewSearchContentInputFooter.c(WebViewSearchContentInputFooter.this) != null) {
          WebViewSearchContentInputFooter.c(WebViewSearchContentInputFooter.this).eTh();
        }
        a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82292);
      }
    });
    this.EKM.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(82293);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
        if (WebViewSearchContentInputFooter.c(WebViewSearchContentInputFooter.this) != null) {
          WebViewSearchContentInputFooter.c(WebViewSearchContentInputFooter.this).c(paramAnonymousInt, paramAnonymousKeyEvent);
        }
        if ((paramAnonymousInt == 66) && (WebViewSearchContentInputFooter.c(WebViewSearchContentInputFooter.this) != null))
        {
          paramAnonymousView = paramAnonymousView.getContext();
          if ((paramAnonymousView instanceof MMActivity)) {
            ((MMActivity)paramAnonymousView).hideVKB(WebViewSearchContentInputFooter.d(WebViewSearchContentInputFooter.this));
          }
          WebViewSearchContentInputFooter.c(WebViewSearchContentInputFooter.this).b(WebViewSearchContentInputFooter.this);
          a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(82293);
          return true;
        }
        a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(82293);
        return false;
      }
    });
    this.EKM.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(82294);
        if ((!paramAnonymousBoolean) && (WebViewSearchContentInputFooter.c(WebViewSearchContentInputFooter.this) != null))
        {
          paramAnonymousView = paramAnonymousView.getContext();
          if ((paramAnonymousView instanceof MMActivity)) {
            ((MMActivity)paramAnonymousView).hideVKB(WebViewSearchContentInputFooter.d(WebViewSearchContentInputFooter.this));
          }
        }
        WebViewSearchContentInputFooter.e(WebViewSearchContentInputFooter.this).setSelected(paramAnonymousBoolean);
        AppMethodBeat.o(82294);
      }
    });
    this.EKM.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(82295);
        if (WebViewSearchContentInputFooter.c(WebViewSearchContentInputFooter.this) != null)
        {
          WebViewSearchContentInputFooter.a locala = WebViewSearchContentInputFooter.c(WebViewSearchContentInputFooter.this);
          WebViewSearchContentInputFooter localWebViewSearchContentInputFooter = WebViewSearchContentInputFooter.this;
          if (paramAnonymousCharSequence != null) {
            paramAnonymousCharSequence.toString();
          }
          locala.a(localWebViewSearchContentInputFooter);
        }
        AppMethodBeat.o(82295);
      }
    });
    this.EKM.setSelectAllOnFocus(true);
    reset();
    AppMethodBeat.o(82299);
  }
  
  public final void C(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(82305);
    if (!paramBoolean)
    {
      AppMethodBeat.o(82305);
      return;
    }
    Object localObject = this.EKP;
    if (paramInt2 == 0)
    {
      paramInt1 = 0;
      ((TextView)localObject).setText(String.format("%d/%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      localObject = this.EKO;
      if (paramInt2 <= 0) {
        break label108;
      }
      paramBoolean = true;
      label70:
      ((View)localObject).setEnabled(paramBoolean);
      localObject = this.EKN;
      if (paramInt2 <= 0) {
        break label113;
      }
    }
    label108:
    label113:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((View)localObject).setEnabled(paramBoolean);
      AppMethodBeat.o(82305);
      return;
      paramInt1 += 1;
      break;
      paramBoolean = false;
      break label70;
    }
  }
  
  public final void eZx()
  {
    AppMethodBeat.i(82301);
    this.EKM.setText("");
    AppMethodBeat.o(82301);
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(82306);
    String str = this.EKM.getText().toString();
    AppMethodBeat.o(82306);
    return str;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82304);
    Context localContext = this.EKM.getContext();
    if ((localContext instanceof MMActivity)) {
      ((MMActivity)localContext).hideVKB(this.EKM);
    }
    this.EKM.clearFocus();
    setVisibility(8);
    if (this.EKQ != null) {
      this.EKQ.eTf();
    }
    AppMethodBeat.o(82304);
  }
  
  public boolean isShown()
  {
    AppMethodBeat.i(82302);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(82302);
      return true;
    }
    AppMethodBeat.o(82302);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(82300);
    this.EKP.setText("");
    this.EKN.setEnabled(false);
    this.EKO.setEnabled(false);
    AppMethodBeat.o(82300);
  }
  
  public void setActionDelegate(a parama)
  {
    this.EKQ = parama;
  }
  
  public final void show()
  {
    AppMethodBeat.i(82303);
    setVisibility(0);
    this.EKM.requestFocus();
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(82296);
        MMActivity.showVKB((Activity)WebViewSearchContentInputFooter.this.getContext());
        AppMethodBeat.o(82296);
      }
    }, 100L);
    AppMethodBeat.o(82303);
  }
  
  public static abstract interface a
  {
    public abstract void a(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter);
    
    public abstract void b(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter);
    
    public abstract boolean c(int paramInt, KeyEvent paramKeyEvent);
    
    public abstract void eTf();
    
    public abstract void eTg();
    
    public abstract void eTh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter
 * JD-Core Version:    0.7.0.1
 */