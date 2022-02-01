package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendSearchPreference
  extends Preference
{
  private String BCb;
  String BCc;
  private View.OnClickListener BCd;
  View.OnClickListener BCe;
  private View BCf;
  private Context context;
  private TextView jpA;
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29186);
    this.BCb = "";
    this.BCc = "";
    this.BCd = null;
    this.BCe = null;
    this.jpA = null;
    this.BCf = null;
    this.context = paramContext;
    setLayoutResource(2131494820);
    AppMethodBeat.o(29186);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29187);
    super.onBindView(paramView);
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186682);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/subapp/ui/pluginapp/AddFriendSearchPreference$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        a.a(true, this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddFriendSearchPreference$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186682);
        return true;
      }
    });
    this.jpA = ((TextView)paramView.findViewById(2131304596));
    this.jpA.setText(this.BCc);
    this.BCf = paramView.findViewById(2131304432);
    if (this.BCe != null) {
      this.BCf.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(29185);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          a.b("com/tencent/mm/plugin/subapp/ui/pluginapp/AddFriendSearchPreference$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if (paramAnonymousMotionEvent.getAction() == 1) {
            AddFriendSearchPreference.a(AddFriendSearchPreference.this).onClick(paramAnonymousView);
          }
          a.a(true, this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddFriendSearchPreference$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(29185);
          return true;
        }
      });
    }
    ade(8);
    AppMethodBeat.o(29187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference
 * JD-Core Version:    0.7.0.1
 */