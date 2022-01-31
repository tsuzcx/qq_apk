package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference
  extends Preference
{
  String blZ;
  private final Context context;
  private ImageView qBN;
  private TextView qBO;
  private TextView qBP;
  private TextView qBQ;
  private TextView qBR;
  String qBS;
  String qvn;
  String title;
  
  public VcardContactUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public VcardContactUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(81360);
    super.onBindView(paramView);
    ab.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
    this.qBN = ((ImageView)paramView.findViewById(2131828670));
    this.qBO = ((TextView)paramView.findViewById(2131828671));
    if (this.qBS != null) {
      this.qBO.setText(this.qBS);
    }
    this.qBP = ((TextView)paramView.findViewById(2131828672));
    if (this.blZ != null)
    {
      this.qBP.setText(this.context.getString(2131304476, new Object[] { this.blZ }));
      this.qBP.setVisibility(0);
    }
    this.qBQ = ((TextView)paramView.findViewById(2131828674));
    if (this.qvn != null)
    {
      this.qBQ.setText(this.context.getString(2131304481, new Object[] { this.qvn }));
      this.qBQ.setVisibility(0);
    }
    this.qBR = ((TextView)paramView.findViewById(2131828673));
    if (this.title != null)
    {
      this.qBR.setText(this.context.getString(2131304482, new Object[] { this.title }));
      this.qBR.setVisibility(0);
    }
    AppMethodBeat.o(81360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */