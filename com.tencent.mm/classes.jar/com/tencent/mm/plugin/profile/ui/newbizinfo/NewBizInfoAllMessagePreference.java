package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoAllMessagePreference
  extends Preference
{
  private LinearLayout Bjo;
  private h Bjp;
  private MMActivity gte;
  private TextView hXK;
  private TextView titleTv;
  
  public NewBizInfoAllMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27492);
    this.gte = ((MMActivity)paramContext);
    AppMethodBeat.o(27492);
  }
  
  public NewBizInfoAllMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27493);
    this.gte = ((MMActivity)paramContext);
    AppMethodBeat.o(27493);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27494);
    this.Bjo = ((LinearLayout)paramView.findViewById(2131305295));
    this.titleTv = ((TextView)paramView.findViewById(2131305303));
    this.hXK = ((TextView)paramView.findViewById(2131305296));
    if (this.Bjp != null)
    {
      if (!Util.isNullOrNil(this.Bjp.field_allArticleWording)) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.Bjo.setVisibility(0);
        this.titleTv.setText(this.gte.getString(2131757821));
        this.hXK.setText(this.Bjp.field_allArticleWording);
        AppMethodBeat.o(27494);
        return;
      }
    }
    this.Bjo.setVisibility(8);
    AppMethodBeat.o(27494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoAllMessagePreference
 * JD-Core Version:    0.7.0.1
 */