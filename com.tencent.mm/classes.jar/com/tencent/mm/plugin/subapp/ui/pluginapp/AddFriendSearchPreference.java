package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendSearchPreference
  extends Preference
{
  private Context context;
  private TextView iTy;
  private String zSX;
  String zSY;
  private View.OnClickListener zSZ;
  View.OnClickListener zTa;
  private View zTb;
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29186);
    this.zSX = "";
    this.zSY = "";
    this.zSZ = null;
    this.zTa = null;
    this.iTy = null;
    this.zTb = null;
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
        return true;
      }
    });
    this.iTy = ((TextView)paramView.findViewById(2131304596));
    this.iTy.setText(this.zSY);
    this.zTb = paramView.findViewById(2131304432);
    if (this.zTa != null) {
      this.zTb.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(29185);
          if (paramAnonymousMotionEvent.getAction() == 1) {
            AddFriendSearchPreference.a(AddFriendSearchPreference.this).onClick(paramAnonymousView);
          }
          AppMethodBeat.o(29185);
          return true;
        }
      });
    }
    aam(8);
    AppMethodBeat.o(29187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference
 * JD-Core Version:    0.7.0.1
 */