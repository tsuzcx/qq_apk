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
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoLoadingPreference
  extends Preference
{
  private MMActivity fNT;
  private TextView gXb;
  private ProgressBar gqv;
  private View iBX;
  private boolean qnX;
  private int state;
  private ok xkU;
  private boolean xlz;
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27520);
    this.xlz = false;
    this.state = 1;
    this.qnX = false;
    this.fNT = ((MMActivity)paramContext);
    this.qnX = false;
    AppMethodBeat.o(27520);
  }
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27521);
    this.xlz = false;
    this.state = 1;
    this.qnX = false;
    this.fNT = ((MMActivity)paramContext);
    this.qnX = false;
    AppMethodBeat.o(27521);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27522);
    this.iBX = paramView.findViewById(2131302719);
    this.gXb = ((TextView)paramView.findViewById(2131302720));
    this.gqv = ((ProgressBar)paramView.findViewById(2131302722));
    this.qnX = true;
    if (this.qnX)
    {
      if (this.state == 1)
      {
        this.iBX.setVisibility(0);
        this.gqv.setVisibility(0);
        this.gXb.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      if (this.state == 2)
      {
        this.iBX.setVisibility(0);
        paramView = k.a(this.fNT, this.xkU.Gcb.FXj, (int)this.gXb.getTextSize(), 1);
        this.gXb.setText(paramView);
        this.gXb.setMovementMethod(LinkMovementMethod.getInstance());
        this.gXb.setVisibility(0);
        this.gqv.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      if (this.state == 3)
      {
        this.iBX.setVisibility(0);
        this.gXb.setText(this.fNT.getString(2131757882));
        this.gXb.setVisibility(0);
        this.gqv.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      this.iBX.setVisibility(8);
    }
    AppMethodBeat.o(27522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoLoadingPreference
 * JD-Core Version:    0.7.0.1
 */