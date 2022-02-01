package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class SummaryTextPreference
  extends Preference
{
  protected TextView aeaq;
  private Typeface aear = null;
  public String aeas = null;
  
  public SummaryTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SummaryTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(251500);
    super.onBindView(paramView);
    this.aeaq = ((TextView)paramView.findViewById(16908304));
    if (this.aear != null) {
      try
      {
        this.aeaq.setTypeface(this.aear);
        AppMethodBeat.o(251500);
        return;
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.SummaryTextPreference", "setTypeface() Exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      }
    }
    if (!TextUtils.isEmpty(this.aeas)) {
      try
      {
        this.aeaq.setTypeface(Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), this.aeas));
        Log.i("MicroMsg.SummaryTextPreference", "setTypeface assets: %s", new Object[] { this.aeas });
        AppMethodBeat.o(251500);
        return;
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.SummaryTextPreference", "setTypeface assets path exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      }
    }
    AppMethodBeat.o(251500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.SummaryTextPreference
 * JD-Core Version:    0.7.0.1
 */