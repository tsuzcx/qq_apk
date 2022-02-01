package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;

public class PreferenceInfoCategory
  extends Preference
{
  public int advq;
  public View.OnClickListener aeam;
  public View.OnClickListener aean;
  public a aeao;
  
  public PreferenceInfoCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreferenceInfoCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142661);
    this.aeam = null;
    this.aean = null;
    this.aeao = null;
    this.advq = 0;
    setLayoutResource(a.h.mm_preference_info_qrcode);
    AppMethodBeat.o(142661);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142662);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(16908310);
    if (localTextView == null)
    {
      AppMethodBeat.o(142662);
      return;
    }
    if ((getTitle() == null) || (getTitle().length() <= 0)) {
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      if (this.aeao != null) {
        this.aeao.ar(getTitle());
      }
      paramView = (ImageView)paramView.findViewById(a.g.add_my_qrcode);
      paramView.setOnClickListener(this.aeam);
      if (this.advq > 0) {
        paramView.setImageResource(this.advq);
      }
      AppMethodBeat.o(142662);
      return;
      localTextView.setVisibility(0);
      localTextView.setText(getTitle());
      localTextView.setOnClickListener(this.aean);
    }
  }
  
  public static abstract interface a
  {
    public abstract void ar(CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PreferenceInfoCategory
 * JD-Core Version:    0.7.0.1
 */