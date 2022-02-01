package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference
  extends Preference
{
  private final View.OnTouchListener Fpe;
  int background;
  View.OnClickListener km;
  private View vd;
  
  public ContactListCustomPreference(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(152207);
    this.background = -1;
    this.Fpe = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(217892);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/applet/ContactListCustomPreference$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/applet/ContactListCustomPreference$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(217892);
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
    this.Fpe = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(217892);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/applet/ContactListCustomPreference$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/applet/ContactListCustomPreference$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(217892);
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
    this.Fpe = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(217892);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/applet/ContactListCustomPreference$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/applet/ContactListCustomPreference$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(217892);
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
    if ((this.vd != null) && (this.vd != null))
    {
      localViewGroup.removeAllViews();
      if (this.vd.getParent() != null) {
        ((ViewGroup)this.vd.getParent()).removeAllViews();
      }
      localViewGroup.addView(this.vd);
      if (this.km == null) {
        break label95;
      }
      localViewGroup.setOnClickListener(this.km);
    }
    for (;;)
    {
      if (this.background >= 0) {
        paramView.setBackgroundResource(this.background);
      }
      AppMethodBeat.o(152210);
      return;
      label95:
      localViewGroup.setOnTouchListener(this.Fpe);
    }
  }
  
  public final void setCustomView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.vd = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference
 * JD-Core Version:    0.7.0.1
 */