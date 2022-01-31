package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class WebViewSearchContentInputFooter
  extends LinearLayout
{
  private View vth;
  private EditText vti;
  private View vtj;
  private View vtk;
  private View vtl;
  private TextView vtm;
  private WebViewSearchContentInputFooter.a vtn;
  
  public WebViewSearchContentInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(10065);
    init();
    AppMethodBeat.o(10065);
  }
  
  public WebViewSearchContentInputFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(10066);
    init();
    AppMethodBeat.o(10066);
  }
  
  private void init()
  {
    AppMethodBeat.i(10067);
    View localView = inflate(getContext(), 2130971306, this);
    this.vti = ((EditText)localView.findViewById(2131820995));
    this.vtj = localView.findViewById(2131826502);
    this.vtk = localView.findViewById(2131829554);
    this.vtl = localView.findViewById(2131829555);
    this.vtm = ((TextView)localView.findViewById(2131829553));
    this.vth = localView.findViewById(2131829552);
    this.vtj.setOnClickListener(new WebViewSearchContentInputFooter.1(this));
    this.vtk.setOnClickListener(new WebViewSearchContentInputFooter.2(this));
    this.vtl.setOnClickListener(new WebViewSearchContentInputFooter.3(this));
    this.vti.setOnKeyListener(new WebViewSearchContentInputFooter.4(this));
    this.vti.setOnFocusChangeListener(new WebViewSearchContentInputFooter.5(this));
    this.vti.addTextChangedListener(new WebViewSearchContentInputFooter.6(this));
    this.vti.setSelectAllOnFocus(true);
    reset();
    AppMethodBeat.o(10067);
  }
  
  public final void dgZ()
  {
    AppMethodBeat.i(10069);
    this.vti.setText("");
    AppMethodBeat.o(10069);
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(10074);
    String str = this.vti.getText().toString();
    AppMethodBeat.o(10074);
    return str;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(10072);
    Context localContext = this.vti.getContext();
    if ((localContext instanceof MMActivity)) {
      ((MMActivity)localContext).hideVKB(this.vti);
    }
    this.vti.clearFocus();
    setVisibility(8);
    if (this.vtn != null) {
      this.vtn.dbj();
    }
    AppMethodBeat.o(10072);
  }
  
  public boolean isShown()
  {
    AppMethodBeat.i(10070);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(10070);
      return true;
    }
    AppMethodBeat.o(10070);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(10068);
    this.vtm.setText("");
    this.vtk.setEnabled(false);
    this.vtl.setEnabled(false);
    AppMethodBeat.o(10068);
  }
  
  public void setActionDelegate(WebViewSearchContentInputFooter.a parama)
  {
    this.vtn = parama;
  }
  
  public final void show()
  {
    AppMethodBeat.i(10071);
    setVisibility(0);
    this.vti.requestFocus();
    postDelayed(new WebViewSearchContentInputFooter.7(this), 100L);
    AppMethodBeat.o(10071);
  }
  
  public final void t(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(10073);
    if (!paramBoolean)
    {
      AppMethodBeat.o(10073);
      return;
    }
    Object localObject = this.vtm;
    if (paramInt2 == 0)
    {
      paramInt1 = 0;
      ((TextView)localObject).setText(String.format("%d/%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      localObject = this.vtl;
      if (paramInt2 <= 0) {
        break label111;
      }
      paramBoolean = true;
      label72:
      ((View)localObject).setEnabled(paramBoolean);
      localObject = this.vtk;
      if (paramInt2 <= 0) {
        break label116;
      }
    }
    label111:
    label116:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((View)localObject).setEnabled(paramBoolean);
      AppMethodBeat.o(10073);
      return;
      paramInt1 += 1;
      break;
      paramBoolean = false;
      break label72;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter
 * JD-Core Version:    0.7.0.1
 */