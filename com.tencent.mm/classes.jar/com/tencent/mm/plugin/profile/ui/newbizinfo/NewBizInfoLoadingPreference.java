package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoLoadingPreference
  extends Preference
{
  private boolean HdW;
  private pd Hdu;
  private View fyN;
  private MMActivity iXq;
  private ProgressBar jMF;
  private TextView kEs;
  private int state;
  private boolean vkO;
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27520);
    this.HdW = false;
    this.state = 1;
    this.vkO = false;
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(27520);
  }
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27521);
    this.HdW = false;
    this.state = 1;
    this.vkO = false;
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(27521);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27522);
    this.fyN = paramView.findViewById(R.h.dNr);
    this.kEs = ((TextView)paramView.findViewById(R.h.dNs));
    this.jMF = ((ProgressBar)paramView.findViewById(R.h.dNt));
    this.vkO = true;
    if (this.vkO)
    {
      if (this.state == 1)
      {
        this.fyN.setVisibility(0);
        this.jMF.setVisibility(0);
        this.kEs.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      if (this.state == 2)
      {
        this.fyN.setVisibility(0);
        paramView = l.f(this.iXq, this.Hdu.RXs.RRT, (int)this.kEs.getTextSize());
        this.kEs.setText(paramView);
        this.kEs.setMovementMethod(LinkMovementMethod.getInstance());
        this.kEs.setVisibility(0);
        this.jMF.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      if (this.state == 3)
      {
        this.fyN.setVisibility(0);
        this.kEs.setText(this.iXq.getString(R.l.eAh));
        this.kEs.setVisibility(0);
        this.jMF.setVisibility(8);
        AppMethodBeat.o(27522);
        return;
      }
      this.fyN.setVisibility(8);
    }
    AppMethodBeat.o(27522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoLoadingPreference
 * JD-Core Version:    0.7.0.1
 */