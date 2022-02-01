package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class MPSmileyFooter
  extends InputPanelLinearLayout
{
  WeImageView Mif;
  private MMEditText Rxv = null;
  LinearLayout Xqh;
  LinearLayout Xqi;
  private int Xqj = 0;
  private boolean Xqk = false;
  private MMActivity activity;
  Context context;
  ChatFooterPanel moD;
  private int moG = -1;
  private int moH = -1;
  int moI = 0;
  private boolean moJ = true;
  
  public MPSmileyFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  private void aWJ()
  {
    AppMethodBeat.i(82259);
    this.moD.onPause();
    this.moD.setVisibility(8);
    AppMethodBeat.o(82259);
  }
  
  private MMActivity getActivity()
  {
    AppMethodBeat.i(82249);
    if (this.activity == null) {
      if (!(this.context instanceof MMActivity)) {
        break label45;
      }
    }
    Object localObject;
    for (this.activity = ((MMActivity)this.context);; this.activity = ((MMActivity)localObject))
    {
      localObject = this.activity;
      AppMethodBeat.o(82249);
      return localObject;
      label45:
      for (localObject = this.context; (!(localObject instanceof MMActivity)) && ((localObject instanceof ContextWrapper)); localObject = ((ContextWrapper)localObject).getBaseContext()) {}
    }
  }
  
  public final void aWI()
  {
    AppMethodBeat.i(82256);
    aWJ();
    setVisibility(8);
    AppMethodBeat.o(82256);
  }
  
  final void aWK()
  {
    AppMethodBeat.i(82261);
    ViewGroup.LayoutParams localLayoutParams = this.Xqh.getLayoutParams();
    localLayoutParams.height = (this.moI + this.Xqj);
    this.Xqh.setLayoutParams(localLayoutParams);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    this.moD.setPortHeightPx(i);
    localLayoutParams = this.moD.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = i;
    }
    AppMethodBeat.o(82261);
  }
  
  final int auT(int paramInt)
  {
    AppMethodBeat.i(82250);
    TypedValue localTypedValue = new TypedValue();
    this.context.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    paramInt = localTypedValue.resourceId;
    AppMethodBeat.o(82250);
    return paramInt;
  }
  
  public final boolean hqp()
  {
    AppMethodBeat.i(82255);
    if (this.moD.getVisibility() == 0)
    {
      AppMethodBeat.o(82255);
      return true;
    }
    AppMethodBeat.o(82255);
    return false;
  }
  
  public final void iCq()
  {
    AppMethodBeat.i(82252);
    if (hqp())
    {
      AppMethodBeat.o(82252);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(82252);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82258);
    super.onConfigurationChanged(paramConfiguration);
    if (this.moD != null) {
      aWK();
    }
    AppMethodBeat.o(82258);
  }
  
  public void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(82260);
    super.onInputPanelChange(paramBoolean, paramInt);
    if ((this.moI != paramInt) && (paramInt != 0))
    {
      this.moI = paramInt;
      j.H(getContext(), paramInt);
      aWK();
    }
    AppMethodBeat.o(82260);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82263);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.moG < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.moG)
    {
      this.moG = paramInt1;
      this.moH = paramInt4;
      AppMethodBeat.o(82263);
      return;
    }
  }
  
  public void setExtraAddHeight(int paramInt)
  {
    this.Xqj = paramInt;
  }
  
  public void setFobbidenWhenLandscape(boolean paramBoolean)
  {
    this.Xqk = paramBoolean;
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(82253);
    this.Rxv = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82245);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (MPSmileyFooter.this.getVisibility() == 8) {
          MPSmileyFooter.this.setVisibility(0);
        }
        if (MPSmileyFooter.this.hqp()) {
          MPSmileyFooter.a(MPSmileyFooter.this);
        }
        a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82245);
      }
    });
    paramMMEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return false;
      }
    });
    AppMethodBeat.o(82253);
  }
  
  public void setSmileHeight(int paramInt)
  {
    AppMethodBeat.i(82264);
    ViewGroup.LayoutParams localLayoutParams = this.Xqh.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.Xqh.setLayoutParams(localLayoutParams);
    paramInt = KeyBoardUtil.getValidPanelHeight(getContext());
    this.moD.setPortHeightPx(paramInt);
    localLayoutParams = this.moD.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = paramInt;
    }
    AppMethodBeat.o(82264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter
 * JD-Core Version:    0.7.0.1
 */