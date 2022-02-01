package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.a.d;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference
  extends Preference
{
  private final View.OnTouchListener YcM;
  int background;
  View.OnClickListener dpY;
  private View dyK;
  
  public ContactListCustomPreference(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(152207);
    this.background = -1;
    this.YcM = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    };
    setLayoutResource(a.d.mm_preference_contact_list_custom);
    AppMethodBeat.o(152207);
  }
  
  public ContactListCustomPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152208);
    this.background = -1;
    this.YcM = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    };
    setLayoutResource(a.d.mm_preference_contact_list_custom);
    AppMethodBeat.o(152208);
  }
  
  public ContactListCustomPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152209);
    this.background = -1;
    this.YcM = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    };
    setLayoutResource(a.d.mm_preference_contact_list_custom);
    AppMethodBeat.o(152209);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(152210);
    ViewGroup localViewGroup = (ViewGroup)paramView;
    if ((this.dyK != null) && (this.dyK != null))
    {
      localViewGroup.removeAllViews();
      if (this.dyK.getParent() != null) {
        ((ViewGroup)this.dyK.getParent()).removeAllViews();
      }
      localViewGroup.addView(this.dyK);
      if (this.dpY == null) {
        break label95;
      }
      localViewGroup.setOnClickListener(this.dpY);
    }
    for (;;)
    {
      if (this.background >= 0) {
        paramView.setBackgroundResource(this.background);
      }
      AppMethodBeat.o(152210);
      return;
      label95:
      localViewGroup.setOnTouchListener(this.YcM);
    }
  }
  
  public final void setCustomView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.dyK = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference
 * JD-Core Version:    0.7.0.1
 */