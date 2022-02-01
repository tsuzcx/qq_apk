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
  String bVF;
  private final Context context;
  String title;
  String yoL;
  private ImageView yvj;
  private TextView yvk;
  private TextView yvl;
  private TextView yvm;
  private TextView yvn;
  String yvo;
  
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
    this.yvj = ((ImageView)paramView.findViewById(2131306266));
    this.yvk = ((TextView)paramView.findViewById(2131306267));
    if (this.yvo != null) {
      this.yvk.setText(this.yvo);
    }
    this.yvl = ((TextView)paramView.findViewById(2131306268));
    if (this.bVF != null)
    {
      this.yvl.setText(this.context.getString(2131764630, new Object[] { this.bVF }));
      this.yvl.setVisibility(0);
    }
    this.yvm = ((TextView)paramView.findViewById(2131306269));
    if (this.yoL != null)
    {
      this.yvm.setText(this.context.getString(2131764635, new Object[] { this.yoL }));
      this.yvm.setVisibility(0);
    }
    this.yvn = ((TextView)paramView.findViewById(2131306270));
    if (this.title != null)
    {
      this.yvn.setText(this.context.getString(2131764636, new Object[] { this.title }));
      this.yvn.setVisibility(0);
    }
    AppMethodBeat.o(52014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */