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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class InputPreference
  extends Preference
{
  private String BCc;
  private String JNs;
  private EditText JNt;
  private Button JNu;
  private a JNv;
  private View.OnClickListener JNw;
  private TextView.OnEditorActionListener JNx;
  
  public InputPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142574);
    this.JNw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142572);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/base/preference/InputPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.JNx = new TextView.OnEditorActionListener()
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
    this.JNt = ((EditText)paramView.findViewById(2131299306));
    this.JNt.setHint(this.BCc);
    this.JNt.setOnEditorActionListener(this.JNx);
    this.JNu = ((Button)paramView.findViewById(2131297631));
    this.JNu.setText(this.JNs);
    this.JNu.setOnClickListener(this.JNw);
    AppMethodBeat.o(142575);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.InputPreference
 * JD-Core Version:    0.7.0.1
 */