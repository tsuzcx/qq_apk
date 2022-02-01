package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoLoadingPreference
  extends Preference
{
  private MMActivity fLP;
  private TextView gUs;
  private ProgressBar gnZ;
  private View ize;
  private boolean qhs;
  private int state;
  private boolean wVI;
  private oi wVd;
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27520);
    this.wVI = false;
    this.state = 1;
    this.qhs = false;
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(27520);
  }
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27521);
    this.wVI = false;
    this.state = 1;
    this.qhs = false;
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(27521);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27522);
    this.ize = paramView.findViewById(2131302719);
    this.gUs = ((TextView)paramView.findViewById(2131302720));
    this.gnZ = ((ProgressBar)paramView.findViewById(2131302722));
    this.qhs = true;
    if (this.qhs)
    {
      if (this.state == 1)
      {
        this.ize.setVisibility(0);
        this.gnZ.setVisibility(0);
        this.gUs.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      if (this.state == 2)
      {
        this.ize.setVisibility(0);
        paramView = k.a(this.fLP, this.wVd.FJC.FEO, (int)this.gUs.getTextSize(), 1);
        this.gUs.setText(paramView);
        this.gUs.setMovementMethod(LinkMovementMethod.getInstance());
        this.gUs.setVisibility(0);
        this.gnZ.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      if (this.state == 3)
      {
        this.ize.setVisibility(0);
        this.gUs.setText(this.fLP.getString(2131757882));
        this.gUs.setVisibility(0);
        this.gnZ.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      this.ize.setVisibility(8);
    }
    AppMethodBeat.o(27522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoLoadingPreference
 * JD-Core Version:    0.7.0.1
 */