package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.s;

public class HelperHeaderPreference
  extends Preference
{
  private HelperHeaderPreference.a waT;
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(79801);
    this.waT = new HelperHeaderPreference.a();
    AppMethodBeat.o(79801);
  }
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(79802);
    this.waT = new HelperHeaderPreference.a();
    AppMethodBeat.o(79802);
  }
  
  public final void aB(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79804);
    this.waT.cDt = paramString1;
    this.waT.elx = paramString2;
    this.waT.hint = paramString3;
    super.callChangeListener(null);
    AppMethodBeat.o(79804);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(79803);
    ImageView localImageView = (ImageView)paramView.findViewById(2131821210);
    TextView localTextView1 = (TextView)paramView.findViewById(2131824328);
    TextView localTextView2 = (TextView)paramView.findViewById(2131823254);
    TextView localTextView3 = (TextView)paramView.findViewById(2131826741);
    TextView localTextView4 = (TextView)paramView.findViewById(2131826740);
    View localView = paramView.findViewById(2131823104);
    localTextView4.setText(2131299864);
    if (localImageView != null) {
      a.b.c(localImageView, this.waT.cDt);
    }
    if (localTextView1 != null) {
      switch (this.waT.status)
      {
      }
    }
    for (;;)
    {
      if (localTextView2 != null) {
        localTextView2.setText(this.waT.elx);
      }
      if (localTextView3 != null) {
        localTextView3.setText(this.waT.hint);
      }
      super.onBindView(paramView);
      localView.getViewTreeObserver().addOnPreDrawListener(new HelperHeaderPreference.1(this, localView));
      AppMethodBeat.o(79803);
      return;
      localTextView1.setVisibility(0);
      localTextView1.setTextColor(s.iD(this.mContext));
      localTextView1.setText(2131303378);
      continue;
      localTextView1.setVisibility(0);
      localTextView1.setTextColor(s.iE(this.mContext));
      localTextView1.setText(2131303386);
      continue;
      localTextView1.setVisibility(8);
    }
  }
  
  public final void sb(int paramInt)
  {
    AppMethodBeat.i(79805);
    this.waT.status = paramInt;
    super.callChangeListener(null);
    AppMethodBeat.o(79805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference
 * JD-Core Version:    0.7.0.1
 */