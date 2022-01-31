package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InputPreference
  extends Preference
{
  private String sZk;
  private InputPreference.a sZn;
  private View.OnClickListener sZp;
  private String zrm;
  private EditText zrn;
  private Button zro;
  private TextView.OnEditorActionListener zrp;
  
  public InputPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107197);
    this.sZp = new InputPreference.1(this);
    this.zrp = new InputPreference.2(this);
    AppMethodBeat.o(107197);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(107198);
    super.onBindView(paramView);
    this.zrn = ((EditText)paramView.findViewById(2131820995));
    this.zrn.setHint(this.sZk);
    this.zrn.setOnEditorActionListener(this.zrp);
    this.zro = ((Button)paramView.findViewById(2131820875));
    this.zro.setText(this.zrm);
    this.zro.setOnClickListener(this.sZp);
    AppMethodBeat.o(107198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.InputPreference
 * JD-Core Version:    0.7.0.1
 */