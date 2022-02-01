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
  private MMActivity fLP;
  private TextView hch;
  private TextView titleTv;
  private LinearLayout wVw;
  private h wVx;
  
  public NewBizInfoAllMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27492);
    this.fLP = ((MMActivity)paramContext);
    AppMethodBeat.o(27492);
  }
  
  public NewBizInfoAllMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27493);
    this.fLP = ((MMActivity)paramContext);
    AppMethodBeat.o(27493);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27494);
    this.wVw = ((LinearLayout)paramView.findViewById(2131302728));
    this.titleTv = ((TextView)paramView.findViewById(2131302736));
    this.hch = ((TextView)paramView.findViewById(2131302729));
    if (this.wVx != null)
    {
      if (!bt.isNullOrNil(this.wVx.field_allArticleWording)) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.wVw.setVisibility(0);
        this.titleTv.setText(this.fLP.getString(2131757594));
        this.hch.setText(this.wVx.field_allArticleWording);
        AppMethodBeat.o(27494);
        return;
      }
    }
    this.wVw.setVisibility(8);
    AppMethodBeat.o(27494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoAllMessagePreference
 * JD-Core Version:    0.7.0.1
 */