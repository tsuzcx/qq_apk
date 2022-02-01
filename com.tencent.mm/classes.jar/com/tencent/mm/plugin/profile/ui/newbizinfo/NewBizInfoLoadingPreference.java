package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoLoadingPreference
  extends Preference
{
  private ProgressBar fQC;
  private View hFi;
  private MMActivity imP;
  private TextView lEA;
  private boolean paC;
  private int state;
  private boolean uFI;
  private ne uFd;
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27520);
    this.uFI = false;
    this.state = 1;
    this.paC = false;
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(27520);
  }
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27521);
    this.uFI = false;
    this.state = 1;
    this.paC = false;
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(27521);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27522);
    this.hFi = paramView.findViewById(2131302719);
    this.lEA = ((TextView)paramView.findViewById(2131302720));
    this.fQC = ((ProgressBar)paramView.findViewById(2131302722));
    this.paC = true;
    if (this.paC)
    {
      if (this.state == 1)
      {
        this.hFi.setVisibility(0);
        this.fQC.setVisibility(0);
        this.lEA.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      if (this.state == 2)
      {
        this.hFi.setVisibility(0);
        paramView = k.a(this.imP, this.uFd.CKR.CGS, (int)this.lEA.getTextSize(), 1);
        this.lEA.setText(paramView);
        this.lEA.setMovementMethod(LinkMovementMethod.getInstance());
        this.lEA.setVisibility(0);
        this.fQC.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      if (this.state == 3)
      {
        this.hFi.setVisibility(0);
        this.lEA.setText(this.imP.getString(2131757882));
        this.lEA.setVisibility(0);
        this.fQC.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      this.hFi.setVisibility(8);
    }
    AppMethodBeat.o(27522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoLoadingPreference
 * JD-Core Version:    0.7.0.1
 */