package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PreferenceInfoCategory
  extends Preference
{
  public int yUp;
  public View.OnClickListener zst;
  public View.OnClickListener zsu;
  
  public PreferenceInfoCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreferenceInfoCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107281);
    this.zst = null;
    this.zsu = null;
    this.yUp = 0;
    setLayoutResource(2130970240);
    AppMethodBeat.o(107281);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(107282);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(16908310);
    if (localTextView == null)
    {
      AppMethodBeat.o(107282);
      return;
    }
    if ((getTitle() == null) || (getTitle().length() <= 0)) {
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (ImageView)paramView.findViewById(2131826242);
      paramView.setOnClickListener(this.zst);
      if (this.yUp > 0) {
        paramView.setImageResource(this.yUp);
      }
      AppMethodBeat.o(107282);
      return;
      localTextView.setVisibility(0);
      localTextView.setText(getTitle());
      localTextView.setOnClickListener(this.zsu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PreferenceInfoCategory
 * JD-Core Version:    0.7.0.1
 */