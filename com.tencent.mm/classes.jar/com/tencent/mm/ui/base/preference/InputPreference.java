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
import com.tencent.mm.ah.a.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class InputPreference
  extends Preference
{
  private String SIn;
  private String adYT;
  private EditText adYU;
  private Button adYV;
  private a adYW;
  private View.OnClickListener adYX;
  private TextView.OnEditorActionListener adYY;
  
  public InputPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142574);
    this.adYX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142572);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/base/preference/InputPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((InputPreference.a(InputPreference.this) != null) && (InputPreference.b(InputPreference.this) != null))
        {
          if (InputPreference.b(InputPreference.this).getText() != null) {
            break label93;
          }
          InputPreference.a(InputPreference.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/ui/base/preference/InputPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142572);
          return;
          label93:
          InputPreference.a(InputPreference.this);
          InputPreference.b(InputPreference.this).getText();
        }
      }
    };
    this.adYY = new TextView.OnEditorActionListener()
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
    this.adYU = ((EditText)paramView.findViewById(a.g.edittext));
    this.adYU.setHint(this.SIn);
    this.adYU.setOnEditorActionListener(this.adYY);
    this.adYV = ((Button)paramView.findViewById(a.g.button));
    this.adYV.setText(this.adYT);
    this.adYV.setOnClickListener(this.adYX);
    AppMethodBeat.o(142575);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.InputPreference
 * JD-Core Version:    0.7.0.1
 */