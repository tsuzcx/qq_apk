package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoAllMessagePreference
  extends Preference
{
  private MMActivity cmc;
  private TextView nUz;
  private LinearLayout pDs;
  private h pDt;
  private TextView titleTv;
  
  public NewBizInfoAllMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23842);
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(23842);
  }
  
  public NewBizInfoAllMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23843);
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(23843);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23844);
    this.pDs = ((LinearLayout)paramView.findViewById(2131823036));
    this.titleTv = ((TextView)paramView.findViewById(2131823037));
    this.nUz = ((TextView)paramView.findViewById(2131823038));
    if (this.pDt != null)
    {
      if (!bo.isNullOrNil(this.pDt.field_allArticleWording)) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.pDs.setVisibility(0);
        this.titleTv.setText(this.cmc.getString(2131298535));
        this.nUz.setText(this.pDt.field_allArticleWording);
        AppMethodBeat.o(23844);
        return;
      }
    }
    this.pDs.setVisibility(8);
    AppMethodBeat.o(23844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoAllMessagePreference
 * JD-Core Version:    0.7.0.1
 */