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
  private final View.OnTouchListener RgJ;
  private View bFK;
  int background;
  View.OnClickListener bwV;
  
  public ContactListCustomPreference(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(152207);
    this.background = -1;
    this.RgJ = new View.OnTouchListener()
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
    this.RgJ = new View.OnTouchListener()
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
    this.RgJ = new View.OnTouchListener()
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
    if ((this.bFK != null) && (this.bFK != null))
    {
      localViewGroup.removeAllViews();
      if (this.bFK.getParent() != null) {
        ((ViewGroup)this.bFK.getParent()).removeAllViews();
      }
      localViewGroup.addView(this.bFK);
      if (this.bwV == null) {
        break label95;
      }
      localViewGroup.setOnClickListener(this.bwV);
    }
    for (;;)
    {
      if (this.background >= 0) {
        paramView.setBackgroundResource(this.background);
      }
      AppMethodBeat.o(152210);
      return;
      label95:
      localViewGroup.setOnTouchListener(this.RgJ);
    }
  }
  
  public final void setCustomView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.bFK = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference
 * JD-Core Version:    0.7.0.1
 */