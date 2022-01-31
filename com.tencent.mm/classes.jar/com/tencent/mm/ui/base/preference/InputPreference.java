package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ac.a.g;

public class InputPreference
  extends Preference
{
  private View.OnClickListener pxB = new InputPreference.1(this);
  private String pxw;
  private InputPreference.a pxz;
  private String vcM;
  private EditText vcN;
  private Button vcO;
  private TextView.OnEditorActionListener vcP = new InputPreference.2(this);
  
  public InputPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.vcN = ((EditText)paramView.findViewById(a.g.edittext));
    this.vcN.setHint(this.pxw);
    this.vcN.setOnEditorActionListener(this.vcP);
    this.vcO = ((Button)paramView.findViewById(a.g.button));
    this.vcO.setText(this.vcM);
    this.vcO.setOnClickListener(this.pxB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.InputPreference
 * JD-Core Version:    0.7.0.1
 */