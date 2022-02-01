package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoLoadingPreference
  extends Preference
{
  private ph BiU;
  private boolean BjA;
  private MMActivity gte;
  private TextView hPW;
  private ProgressBar hbv;
  private View jxm;
  private boolean rFe;
  private int state;
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27520);
    this.BjA = false;
    this.state = 1;
    this.rFe = false;
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(27520);
  }
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27521);
    this.BjA = false;
    this.state = 1;
    this.rFe = false;
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(27521);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27522);
    this.jxm = paramView.findViewById(2131305286);
    this.hPW = ((TextView)paramView.findViewById(2131305287));
    this.hbv = ((ProgressBar)paramView.findViewById(2131305289));
    this.rFe = true;
    if (this.rFe)
    {
      if (this.state == 1)
      {
        this.jxm.setVisibility(0);
        this.hbv.setVisibility(0);
        this.hPW.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      if (this.state == 2)
      {
        this.jxm.setVisibility(0);
        paramView = l.a(this.gte, this.BiU.KWe.KQV, (int)this.hPW.getTextSize(), 1);
        this.hPW.setText(paramView);
        this.hPW.setMovementMethod(LinkMovementMethod.getInstance());
        this.hPW.setVisibility(0);
        this.hbv.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      if (this.state == 3)
      {
        this.jxm.setVisibility(0);
        this.hPW.setText(this.gte.getString(2131758122));
        this.hPW.setVisibility(0);
        this.hbv.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      this.jxm.setVisibility(8);
    }
    AppMethodBeat.o(27522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoLoadingPreference
 * JD-Core Version:    0.7.0.1
 */