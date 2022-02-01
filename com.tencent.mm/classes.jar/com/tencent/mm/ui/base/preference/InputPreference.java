package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InputPreference
  extends Preference
{
  private String HEM;
  private EditText HEN;
  private Button HEO;
  private a HEP;
  private View.OnClickListener HEQ;
  private TextView.OnEditorActionListener HER;
  private String zSY;
  
  public InputPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142574);
    this.HEQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142572);
        if ((InputPreference.a(InputPreference.this) != null) && (InputPreference.b(InputPreference.this) != null))
        {
          if (InputPreference.b(InputPreference.this).getText() == null)
          {
            InputPreference.a(InputPreference.this);
            AppMethodBeat.o(142572);
            return;
          }
          InputPreference.a(InputPreference.this);
          InputPreference.b(InputPreference.this).getText();
        }
        AppMethodBeat.o(142572);
      }
    };
    this.HER = new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142573);
        if ((3 == paramAnonymousInt) && (InputPreference.a(InputPreference.this) != null) && (InputPreference.b(InputPreference.this) != null))
        {
          if (InputPreference.b(InputPreference.this).getText() == null) {
            InputPreference.a(InputPreference.this);
          }
          for (;;)
          {
            AppMethodBeat.o(142573);
            return true;
            InputPreference.a(InputPreference.this);
            InputPreference.b(InputPreference.this).getText();
          }
        }
        AppMethodBeat.o(142573);
        return false;
      }
    };
    AppMethodBeat.o(142574);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142575);
    super.onBindView(paramView);
    this.HEN = ((EditText)paramView.findViewById(2131299306));
    this.HEN.setHint(this.zSY);
    this.HEN.setOnEditorActionListener(this.HER);
    this.HEO = ((Button)paramView.findViewById(2131297631));
    this.HEO.setText(this.HEM);
    this.HEO.setOnClickListener(this.HEQ);
    AppMethodBeat.o(142575);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.InputPreference
 * JD-Core Version:    0.7.0.1
 */