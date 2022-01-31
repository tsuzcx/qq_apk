package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference
  extends Preference
{
  int background;
  View.OnClickListener qaq;
  private final View.OnTouchListener vUh;
  private View veX;
  
  public ContactListCustomPreference(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(79759);
    this.background = -1;
    this.vUh = new ContactListCustomPreference.1(this);
    setLayoutResource(2130970192);
    AppMethodBeat.o(79759);
  }
  
  public ContactListCustomPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(79760);
    this.background = -1;
    this.vUh = new ContactListCustomPreference.1(this);
    setLayoutResource(2130970192);
    AppMethodBeat.o(79760);
  }
  
  public ContactListCustomPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(79761);
    this.background = -1;
    this.vUh = new ContactListCustomPreference.1(this);
    setLayoutResource(2130970192);
    AppMethodBeat.o(79761);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(79762);
    ViewGroup localViewGroup = (ViewGroup)paramView;
    if ((this.veX != null) && (this.veX != null))
    {
      localViewGroup.removeAllViews();
      if (this.veX.getParent() != null) {
        ((ViewGroup)this.veX.getParent()).removeAllViews();
      }
      localViewGroup.addView(this.veX);
      if (this.qaq == null) {
        break label95;
      }
      localViewGroup.setOnClickListener(this.qaq);
    }
    for (;;)
    {
      if (this.background >= 0) {
        paramView.setBackgroundResource(this.background);
      }
      AppMethodBeat.o(79762);
      return;
      label95:
      localViewGroup.setOnTouchListener(this.vUh);
    }
  }
  
  public final void setCustomView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.veX = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference
 * JD-Core Version:    0.7.0.1
 */