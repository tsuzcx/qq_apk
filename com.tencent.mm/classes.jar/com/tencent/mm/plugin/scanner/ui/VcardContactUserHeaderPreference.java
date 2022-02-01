package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference
  extends Preference
{
  String bVF;
  private final Context context;
  String title;
  String yEK;
  private ImageView yLj;
  private TextView yLk;
  private TextView yLl;
  private TextView yLm;
  private TextView yLn;
  String yLo;
  
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
    ae.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
    this.yLj = ((ImageView)paramView.findViewById(2131306266));
    this.yLk = ((TextView)paramView.findViewById(2131306267));
    if (this.yLo != null) {
      this.yLk.setText(this.yLo);
    }
    this.yLl = ((TextView)paramView.findViewById(2131306268));
    if (this.bVF != null)
    {
      this.yLl.setText(this.context.getString(2131764630, new Object[] { this.bVF }));
      this.yLl.setVisibility(0);
    }
    this.yLm = ((TextView)paramView.findViewById(2131306269));
    if (this.yEK != null)
    {
      this.yLm.setText(this.context.getString(2131764635, new Object[] { this.yEK }));
      this.yLm.setVisibility(0);
    }
    this.yLn = ((TextView)paramView.findViewById(2131306270));
    if (this.title != null)
    {
      this.yLn.setText(this.context.getString(2131764636, new Object[] { this.title }));
      this.yLn.setVisibility(0);
    }
    AppMethodBeat.o(52014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */