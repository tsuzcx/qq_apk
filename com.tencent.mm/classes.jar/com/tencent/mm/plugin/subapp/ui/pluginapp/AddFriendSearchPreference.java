package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendSearchPreference
  extends Preference
{
  private String SIm;
  String SIn;
  private View.OnClickListener SIo;
  View.OnClickListener SIp;
  private View SIq;
  private Context context;
  private TextView qcL;
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29186);
    this.SIm = "";
    this.SIn = "";
    this.SIo = null;
    this.SIp = null;
    this.qcL = null;
    this.SIq = null;
    this.context = paramContext;
    setLayoutResource(R.i.glM);
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
        return true;
      }
    });
    this.qcL = ((TextView)paramView.findViewById(R.h.fVV));
    this.qcL.setText(this.SIn);
    this.qcL.setContentDescription(this.SIn);
    this.SIq = paramView.findViewById(R.h.search_ll);
    if (this.SIp != null) {
      this.SIq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(292051);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/subapp/ui/pluginapp/AddFriendSearchPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          AddFriendSearchPreference.a(AddFriendSearchPreference.this).onClick(paramAnonymousView);
          a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddFriendSearchPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(292051);
        }
      });
    }
    aBq(8);
    AppMethodBeat.o(29187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference
 * JD-Core Version:    0.7.0.1
 */