package com.tencent.mm.plugin.websearch.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.websearch.a.b;
import com.tencent.mm.plugin.websearch.a.e;
import com.tencent.mm.plugin.websearch.a.f;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.xwalk.core.Log;

public class SOSEditTextView
  extends FTSEditTextView
{
  private View WrA;
  private boolean WrB = false;
  private View WrC;
  private View WrD;
  private a WrE;
  private boolean WrF = false;
  private boolean WrG = false;
  private b WrH;
  private int WrI = 100;
  private View Wrz;
  
  public SOSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SOSEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View getCancelActionLeftView()
  {
    return this.WrD;
  }
  
  public View getCancelTextView()
  {
    return this.WrA;
  }
  
  public int getLayoutById()
  {
    AppMethodBeat.i(315168);
    if (jCA())
    {
      i = a.f.sos_edittext_view;
      AppMethodBeat.o(315168);
      return i;
    }
    int i = a.f.sos_edittext_view_strengthen;
    AppMethodBeat.o(315168);
    return i;
  }
  
  public int getLimitInputLength()
  {
    AppMethodBeat.i(315233);
    int i = ((c)h.az(c.class)).getSosLimitLength();
    i = Math.max(this.WrI, i);
    AppMethodBeat.o(315233);
    return i;
  }
  
  public View getSearchBarCancelTextContainer()
  {
    return this.WrC;
  }
  
  public View getVoiceImageButton()
  {
    return this.Wrz;
  }
  
  public final void init()
  {
    AppMethodBeat.i(116570);
    super.init();
    this.Wrz = findViewById(a.e.common_right_btn_container);
    this.WrA = findViewById(a.e.text_cancel);
    this.WrC = findViewById(a.e.search_bar_cancel_text_container);
    this.WrD = findViewById(a.e.cancel_action_left_view);
    getEditText().setOnFocusChangeListener(null);
    getEditText().setHintTextColor(getResources().getColor(a.b.light_bg_hint_color));
    getEditText().setTextColor(getResources().getColor(a.b.normal_text_color));
    getIconView().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(315161);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/websearch/ui/widget/SOSEditTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (SOSEditTextView.this.getEditText() != null)
        {
          SOSEditTextView.this.getEditText().requestFocus();
          SOSEditTextView.this.showVKB();
        }
        a.a(this, "com/tencent/mm/plugin/websearch/ui/widget/SOSEditTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(315161);
      }
    });
    AppMethodBeat.o(116570);
  }
  
  public final void iqO()
  {
    AppMethodBeat.i(116571);
    getEditText().setOnFocusChangeListener(this.mpk);
    AppMethodBeat.o(116571);
  }
  
  public void setCameraBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(315217);
    if (this.Wrz != null) {
      this.Wrz.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(315217);
  }
  
  public void setCancelBtnForceHide(boolean paramBoolean)
  {
    this.WrF = paramBoolean;
  }
  
  public void setCancelTextViewCallback(a parama)
  {
    this.WrE = parama;
  }
  
  public void setCancelTextViewClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116576);
    if (this.WrA != null) {
      this.WrA.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(116576);
  }
  
  public void setCancelTextViewVisibile(int paramInt)
  {
    AppMethodBeat.i(116575);
    if (this.WrA != null) {
      this.WrA.setVisibility(paramInt);
    }
    AppMethodBeat.o(116575);
  }
  
  public void setCancelVisableChangeListener(b paramb)
  {
    this.WrH = paramb;
  }
  
  public void setCommonRightBtnForceHide(boolean paramBoolean)
  {
    this.WrG = paramBoolean;
  }
  
  public void setCommonRightImageButtonVisibile(int paramInt)
  {
    int i = 8;
    AppMethodBeat.i(315203);
    if (this.Wrz != null)
    {
      if (this.WrB) {
        paramInt = 8;
      }
      if (this.WrG)
      {
        paramInt = i;
        if (this.Wrz.getVisibility() == 8)
        {
          AppMethodBeat.o(315203);
          return;
        }
      }
      this.Wrz.setVisibility(paramInt);
    }
    AppMethodBeat.o(315203);
  }
  
  public void setNeedForceHideCameraIcon(boolean paramBoolean)
  {
    this.WrB = paramBoolean;
  }
  
  public void setSearchBarCancelTextContainerVisibile(int paramInt)
  {
    AppMethodBeat.i(116572);
    if (this.WrC != null)
    {
      if (this.WrF)
      {
        if (this.WrC.getVisibility() == 8)
        {
          Log.i("MicroMsg.FTS.SOSEditTextView", "cancelBtnForceHide， return");
          AppMethodBeat.o(116572);
          return;
        }
        Log.i("MicroMsg.FTS.SOSEditTextView", "cancelBtnForceHide， set Gone");
        paramInt = 8;
      }
      this.WrC.setVisibility(paramInt);
      if (this.WrE != null) {
        this.WrE.z(paramInt, this.WrC);
      }
      if (this.WrH != null) {
        this.WrH.atk(paramInt);
      }
    }
    AppMethodBeat.o(116572);
  }
  
  public void setVoiceBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116574);
    if (this.Wrz != null) {
      this.Wrz.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(116574);
  }
  
  public static abstract interface a
  {
    public abstract boolean z(int paramInt, View paramView);
  }
  
  public static abstract interface b
  {
    public abstract boolean atk(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView
 * JD-Core Version:    0.7.0.1
 */