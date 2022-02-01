package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoAllMessagePreference
  extends Preference
{
  private MMActivity imP;
  private TextView sIt;
  private TextView titleTv;
  private LinearLayout uFv;
  private h uFw;
  
  public NewBizInfoAllMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27492);
    this.imP = ((MMActivity)paramContext);
    AppMethodBeat.o(27492);
  }
  
  public NewBizInfoAllMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27493);
    this.imP = ((MMActivity)paramContext);
    AppMethodBeat.o(27493);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27494);
    this.uFv = ((LinearLayout)paramView.findViewById(2131302728));
    this.titleTv = ((TextView)paramView.findViewById(2131302736));
    this.sIt = ((TextView)paramView.findViewById(2131302729));
    if (this.uFw != null)
    {
      if (!bt.isNullOrNil(this.uFw.field_allArticleWording)) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.uFv.setVisibility(0);
        this.titleTv.setText(this.imP.getString(2131757594));
        this.sIt.setText(this.uFw.field_allArticleWording);
        AppMethodBeat.o(27494);
        return;
      }
    }
    this.uFv.setVisibility(8);
    AppMethodBeat.o(27494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoAllMessagePreference
 * JD-Core Version:    0.7.0.1
 */