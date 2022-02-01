package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference
  extends Preference
{
  String OTZ;
  private ImageView Pdq;
  private TextView Pdr;
  private TextView Pds;
  private TextView Pdt;
  private TextView Pdu;
  private final Context context;
  String fullName;
  String nickName;
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
    AppMethodBeat.i(52014);
    super.onBindView(paramView);
    Log.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
    this.Pdq = ((ImageView)paramView.findViewById(l.f.OJP));
    this.Pdr = ((TextView)paramView.findViewById(l.f.OJQ));
    if (this.fullName != null) {
      this.Pdr.setText(this.fullName);
    }
    this.Pds = ((TextView)paramView.findViewById(l.f.OJR));
    if (this.nickName != null)
    {
      this.Pds.setText(this.context.getString(l.i.OLL, new Object[] { this.nickName }));
      this.Pds.setVisibility(0);
    }
    this.Pdt = ((TextView)paramView.findViewById(l.f.OJS));
    if (this.OTZ != null)
    {
      this.Pdt.setText(this.context.getString(l.i.OLN, new Object[] { this.OTZ }));
      this.Pdt.setVisibility(0);
    }
    this.Pdu = ((TextView)paramView.findViewById(l.f.OJT));
    if (this.title != null)
    {
      this.Pdu.setText(this.context.getString(l.i.OLO, new Object[] { this.title }));
      this.Pdu.setVisibility(0);
    }
    AppMethodBeat.o(52014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */