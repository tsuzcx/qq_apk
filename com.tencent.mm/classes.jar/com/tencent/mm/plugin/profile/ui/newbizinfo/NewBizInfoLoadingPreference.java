package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoLoadingPreference
  extends Preference
{
  private ProgressBar fUx;
  private TextView gAI;
  private MMActivity iMV;
  private View ifK;
  private boolean pDN;
  private int state;
  private nl vNU;
  private boolean vOz;
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27520);
    this.vOz = false;
    this.state = 1;
    this.pDN = false;
    this.iMV = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(27520);
  }
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27521);
    this.vOz = false;
    this.state = 1;
    this.pDN = false;
    this.iMV = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(27521);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27522);
    this.ifK = paramView.findViewById(2131302719);
    this.gAI = ((TextView)paramView.findViewById(2131302720));
    this.fUx = ((ProgressBar)paramView.findViewById(2131302722));
    this.pDN = true;
    if (this.pDN)
    {
      if (this.state == 1)
      {
        this.ifK.setVisibility(0);
        this.fUx.setVisibility(0);
        this.gAI.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      if (this.state == 2)
      {
        this.ifK.setVisibility(0);
        paramView = k.a(this.iMV, this.vNU.Edt.DZs, (int)this.gAI.getTextSize(), 1);
        this.gAI.setText(paramView);
        this.gAI.setMovementMethod(LinkMovementMethod.getInstance());
        this.gAI.setVisibility(0);
        this.fUx.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      if (this.state == 3)
      {
        this.ifK.setVisibility(0);
        this.gAI.setText(this.iMV.getString(2131757882));
        this.gAI.setVisibility(0);
        this.fUx.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      this.ifK.setVisibility(8);
    }
    AppMethodBeat.o(27522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoLoadingPreference
 * JD-Core Version:    0.7.0.1
 */