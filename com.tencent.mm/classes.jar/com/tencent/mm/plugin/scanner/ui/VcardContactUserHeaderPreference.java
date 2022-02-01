package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference
  extends Preference
{
  String bNK;
  private final Context context;
  String title;
  String vQf;
  String vWA;
  private ImageView vWv;
  private TextView vWw;
  private TextView vWx;
  private TextView vWy;
  private TextView vWz;
  
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
    ad.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
    this.vWv = ((ImageView)paramView.findViewById(2131306266));
    this.vWw = ((TextView)paramView.findViewById(2131306267));
    if (this.vWA != null) {
      this.vWw.setText(this.vWA);
    }
    this.vWx = ((TextView)paramView.findViewById(2131306268));
    if (this.bNK != null)
    {
      this.vWx.setText(this.context.getString(2131764630, new Object[] { this.bNK }));
      this.vWx.setVisibility(0);
    }
    this.vWy = ((TextView)paramView.findViewById(2131306269));
    if (this.vQf != null)
    {
      this.vWy.setText(this.context.getString(2131764635, new Object[] { this.vQf }));
      this.vWy.setVisibility(0);
    }
    this.vWz = ((TextView)paramView.findViewById(2131306270));
    if (this.title != null)
    {
      this.vWz.setText(this.context.getString(2131764636, new Object[] { this.title }));
      this.vWz.setVisibility(0);
    }
    AppMethodBeat.o(52014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */