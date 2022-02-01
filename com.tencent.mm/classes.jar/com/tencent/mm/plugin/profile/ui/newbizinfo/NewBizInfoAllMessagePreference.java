package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoAllMessagePreference
  extends Preference
{
  private LinearLayout HdJ;
  private g HdK;
  private MMActivity iXq;
  private TextView kMp;
  private TextView titleTv;
  
  public NewBizInfoAllMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27492);
    this.iXq = ((MMActivity)paramContext);
    AppMethodBeat.o(27492);
  }
  
  public NewBizInfoAllMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27493);
    this.iXq = ((MMActivity)paramContext);
    AppMethodBeat.o(27493);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27494);
    this.HdJ = ((LinearLayout)paramView.findViewById(R.h.dNz));
    this.titleTv = ((TextView)paramView.findViewById(R.h.dNG));
    this.kMp = ((TextView)paramView.findViewById(R.h.dNA));
    if (this.HdK != null)
    {
      if (!Util.isNullOrNil(this.HdK.field_allArticleWording)) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.HdJ.setVisibility(0);
        this.titleTv.setText(this.iXq.getString(R.l.exT));
        this.kMp.setText(this.HdK.field_allArticleWording);
        AppMethodBeat.o(27494);
        return;
      }
    }
    this.HdJ.setVisibility(8);
    AppMethodBeat.o(27494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoAllMessagePreference
 * JD-Core Version:    0.7.0.1
 */