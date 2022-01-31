package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.MMActivity;

public class WebViewSearchContentInputFooter
  extends LinearLayout
{
  private View rCV;
  private EditText rCW;
  private View rCX;
  private View rCY;
  private View rCZ;
  private TextView rDa;
  private WebViewSearchContentInputFooter.a rDb;
  
  public WebViewSearchContentInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public WebViewSearchContentInputFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    View localView = inflate(getContext(), R.i.webview_search_content_input_footer, this);
    this.rCW = ((EditText)localView.findViewById(R.h.edittext));
    this.rCX = localView.findViewById(R.h.close_btn);
    this.rCY = localView.findViewById(R.h.pre_word_v);
    this.rCZ = localView.findViewById(R.h.next_word_v);
    this.rDa = ((TextView)localView.findViewById(R.h.index_tv));
    this.rCV = localView.findViewById(R.h.input_footer_container);
    this.rCX.setOnClickListener(new WebViewSearchContentInputFooter.1(this));
    this.rCY.setOnClickListener(new WebViewSearchContentInputFooter.2(this));
    this.rCZ.setOnClickListener(new WebViewSearchContentInputFooter.3(this));
    this.rCW.setOnKeyListener(new WebViewSearchContentInputFooter.4(this));
    this.rCW.setOnFocusChangeListener(new WebViewSearchContentInputFooter.5(this));
    this.rCW.addTextChangedListener(new WebViewSearchContentInputFooter.6(this));
    this.rCW.setSelectAllOnFocus(true);
    reset();
  }
  
  public final void cgS()
  {
    this.rCW.setText("");
  }
  
  public String getSearchContent()
  {
    return this.rCW.getText().toString();
  }
  
  public final void hide()
  {
    Context localContext = this.rCW.getContext();
    if ((localContext instanceof MMActivity)) {
      ((MMActivity)localContext).hideVKB(this.rCW);
    }
    this.rCW.clearFocus();
    setVisibility(8);
    if (this.rDb != null) {
      this.rDb.cbg();
    }
  }
  
  public boolean isShown()
  {
    return getVisibility() == 0;
  }
  
  public final void q(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = true;
    if (!paramBoolean) {
      return;
    }
    Object localObject = this.rDa;
    if (paramInt2 == 0)
    {
      paramInt1 = 0;
      ((TextView)localObject).setText(String.format("%d/%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      localObject = this.rCZ;
      if (paramInt2 <= 0) {
        break label93;
      }
      paramBoolean = true;
      label60:
      ((View)localObject).setEnabled(paramBoolean);
      localObject = this.rCY;
      if (paramInt2 <= 0) {
        break label98;
      }
    }
    label93:
    label98:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((View)localObject).setEnabled(paramBoolean);
      return;
      paramInt1 += 1;
      break;
      paramBoolean = false;
      break label60;
    }
  }
  
  public final void reset()
  {
    this.rDa.setText("");
    this.rCY.setEnabled(false);
    this.rCZ.setEnabled(false);
  }
  
  public void setActionDelegate(WebViewSearchContentInputFooter.a parama)
  {
    this.rDb = parama;
  }
  
  public final void show()
  {
    setVisibility(0);
    if (this.rDb != null) {
      this.rDb.onShow();
    }
    this.rCW.requestFocus();
    postDelayed(new WebViewSearchContentInputFooter.7(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter
 * JD-Core Version:    0.7.0.1
 */