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
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendSearchPreference
  extends Preference
{
  private String MgP;
  String MgQ;
  private View.OnClickListener MgR;
  View.OnClickListener MgS;
  private View MgT;
  private Context context;
  private TextView nfC;
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29186);
    this.MgP = "";
    this.MgQ = "";
    this.MgR = null;
    this.MgS = null;
    this.nfC = null;
    this.MgT = null;
    this.context = paramContext;
    setLayoutResource(R.i.eiN);
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
    this.nfC = ((TextView)paramView.findViewById(R.h.dTN));
    this.nfC.setText(this.MgQ);
    this.MgT = paramView.findViewById(R.h.search_ll);
    if (this.MgS != null) {
      this.MgT.setOnTouchListener(new View.OnTouchListener()
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
    auO(8);
    AppMethodBeat.o(29187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference
 * JD-Core Version:    0.7.0.1
 */