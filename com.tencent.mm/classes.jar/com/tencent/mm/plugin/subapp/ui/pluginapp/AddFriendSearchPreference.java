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
  private String FMN;
  String FMO;
  private View.OnClickListener FMP;
  View.OnClickListener FMQ;
  private View FMR;
  private Context context;
  private TextView knK;
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29186);
    this.FMN = "";
    this.FMO = "";
    this.FMP = null;
    this.FMQ = null;
    this.knK = null;
    this.FMR = null;
    this.context = paramContext;
    setLayoutResource(2131495554);
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
    this.knK = ((TextView)paramView.findViewById(2131307643));
    this.knK.setText(this.FMO);
    this.FMR = paramView.findViewById(2131307404);
    if (this.FMQ != null) {
      this.FMR.setOnTouchListener(new View.OnTouchListener()
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
    alO(8);
    AppMethodBeat.o(29187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference
 * JD-Core Version:    0.7.0.1
 */