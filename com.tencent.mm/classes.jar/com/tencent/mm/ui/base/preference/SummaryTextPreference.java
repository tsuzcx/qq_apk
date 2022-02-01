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
  protected TextView WsX;
  private Typeface WsY = null;
  public String WsZ = null;
  
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
    AppMethodBeat.i(189676);
    super.onBindView(paramView);
    this.WsX = ((TextView)paramView.findViewById(16908304));
    if (this.WsY != null) {
      try
      {
        this.WsX.setTypeface(this.WsY);
        AppMethodBeat.o(189676);
        return;
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.SummaryTextPreference", "setTypeface() Exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      }
    }
    if (!TextUtils.isEmpty(this.WsZ)) {
      try
      {
        this.WsX.setTypeface(Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), this.WsZ));
        Log.i("MicroMsg.SummaryTextPreference", "setTypeface assets: %s", new Object[] { this.WsZ });
        AppMethodBeat.o(189676);
        return;
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.SummaryTextPreference", "setTypeface assets path exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      }
    }
    AppMethodBeat.o(189676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.SummaryTextPreference
 * JD-Core Version:    0.7.0.1
 */