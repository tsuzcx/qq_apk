package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference
  extends Preference
{
  private final View.OnTouchListener BZo;
  int background;
  View.OnClickListener hs;
  private View sk;
  
  public ContactListCustomPreference(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(152207);
    this.background = -1;
    this.BZo = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    };
    setLayoutResource(2131494817);
    AppMethodBeat.o(152207);
  }
  
  public ContactListCustomPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152208);
    this.background = -1;
    this.BZo = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    };
    setLayoutResource(2131494817);
    AppMethodBeat.o(152208);
  }
  
  public ContactListCustomPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152209);
    this.background = -1;
    this.BZo = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    };
    setLayoutResource(2131494817);
    AppMethodBeat.o(152209);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(152210);
    ViewGroup localViewGroup = (ViewGroup)paramView;
    if ((this.sk != null) && (this.sk != null))
    {
      localViewGroup.removeAllViews();
      if (this.sk.getParent() != null) {
        ((ViewGroup)this.sk.getParent()).removeAllViews();
      }
      localViewGroup.addView(this.sk);
      if (this.hs == null) {
        break label95;
      }
      localViewGroup.setOnClickListener(this.hs);
    }
    for (;;)
    {
      if (this.background >= 0) {
        paramView.setBackgroundResource(this.background);
      }
      AppMethodBeat.o(152210);
      return;
      label95:
      localViewGroup.setOnTouchListener(this.BZo);
    }
  }
  
  public final void setCustomView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.sk = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference
 * JD-Core Version:    0.7.0.1
 */