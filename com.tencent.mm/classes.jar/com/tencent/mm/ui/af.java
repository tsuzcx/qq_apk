package com.tencent.mm.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class af
  extends LinearLayout
{
  private a FRZ;
  private String hint;
  private EditText lVu;
  private Context mContext;
  private ImageView oPR;
  private ImageButton qlV;
  
  public af(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159103);
    this.mContext = paramContext;
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131492923, this, true);
    this.oPR = ((ImageView)findViewById(2131296417));
    this.oPR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159100);
        if (af.a(af.this) != null) {
          af.a(af.this).onClickBackBtn(paramAnonymousView);
        }
        AppMethodBeat.o(159100);
      }
    });
    this.lVu = ((EditText)findViewById(2131304413));
    this.lVu.requestFocus();
    this.qlV = ((ImageButton)findViewById(2131298348));
    this.qlV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159101);
        af.b(af.this);
        AppMethodBeat.o(159101);
      }
    });
    this.lVu.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(159102);
        if ((paramAnonymousEditable != null) && (paramAnonymousEditable.length() > 0))
        {
          af.c(af.this).setVisibility(0);
          AppMethodBeat.o(159102);
          return;
        }
        af.c(af.this).setVisibility(8);
        AppMethodBeat.o(159102);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    AppMethodBeat.o(159103);
  }
  
  public final EditText getSearchEditText()
  {
    return this.lVu;
  }
  
  public final void setHint(String paramString)
  {
    this.hint = paramString;
  }
  
  public final void setSearchViewListener(a parama)
  {
    this.FRZ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onClickBackBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.af
 * JD-Core Version:    0.7.0.1
 */