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

public final class ag
  extends LinearLayout
{
  private a HrO;
  private ImageView gyM;
  private String hint;
  private Context mContext;
  private EditText mxw;
  private ImageButton qUx;
  
  public ag(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159103);
    this.mContext = paramContext;
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131492923, this, true);
    this.gyM = ((ImageView)findViewById(2131296417));
    this.gyM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159100);
        if (ag.a(ag.this) != null) {
          ag.a(ag.this).onClickBackBtn(paramAnonymousView);
        }
        AppMethodBeat.o(159100);
      }
    });
    this.mxw = ((EditText)findViewById(2131304413));
    this.mxw.requestFocus();
    this.qUx = ((ImageButton)findViewById(2131298348));
    this.qUx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159101);
        ag.b(ag.this);
        AppMethodBeat.o(159101);
      }
    });
    this.mxw.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(159102);
        if ((paramAnonymousEditable != null) && (paramAnonymousEditable.length() > 0))
        {
          ag.c(ag.this).setVisibility(0);
          AppMethodBeat.o(159102);
          return;
        }
        ag.c(ag.this).setVisibility(8);
        AppMethodBeat.o(159102);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    AppMethodBeat.o(159103);
  }
  
  public final EditText getSearchEditText()
  {
    return this.mxw;
  }
  
  public final void setHint(String paramString)
  {
    this.hint = paramString;
  }
  
  public final void setSearchViewListener(a parama)
  {
    this.HrO = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onClickBackBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.ag
 * JD-Core Version:    0.7.0.1
 */