package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference
  extends Preference
{
  String bLs;
  private final Context context;
  String title;
  String xaM;
  private ImageView xhi;
  private TextView xhj;
  private TextView xhk;
  private TextView xhl;
  private TextView xhm;
  String xhn;
  
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
    ac.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
    this.xhi = ((ImageView)paramView.findViewById(2131306266));
    this.xhj = ((TextView)paramView.findViewById(2131306267));
    if (this.xhn != null) {
      this.xhj.setText(this.xhn);
    }
    this.xhk = ((TextView)paramView.findViewById(2131306268));
    if (this.bLs != null)
    {
      this.xhk.setText(this.context.getString(2131764630, new Object[] { this.bLs }));
      this.xhk.setVisibility(0);
    }
    this.xhl = ((TextView)paramView.findViewById(2131306269));
    if (this.xaM != null)
    {
      this.xhl.setText(this.context.getString(2131764635, new Object[] { this.xaM }));
      this.xhl.setVisibility(0);
    }
    this.xhm = ((TextView)paramView.findViewById(2131306270));
    if (this.title != null)
    {
      this.xhm.setText(this.context.getString(2131764636, new Object[] { this.title }));
      this.xhm.setVisibility(0);
    }
    AppMethodBeat.o(52014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */