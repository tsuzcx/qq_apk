package com.tencent.mm.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac
  extends LinearLayout
{
  private String hint;
  private EditText jfo;
  private ImageView lzc;
  private Context mContext;
  private ImageButton mEh;
  private ac.a zeN;
  
  public ac(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(112462);
    this.mContext = paramContext;
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2130968615, this, true);
    this.lzc = ((ImageView)findViewById(2131820989));
    this.lzc.setOnClickListener(new ac.1(this));
    this.jfo = ((EditText)findViewById(2131820990));
    this.jfo.requestFocus();
    this.mEh = ((ImageButton)findViewById(2131820991));
    this.mEh.setOnClickListener(new ac.2(this));
    this.jfo.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(112461);
        if ((paramAnonymousEditable != null) && (paramAnonymousEditable.length() > 0))
        {
          ac.c(ac.this).setVisibility(0);
          AppMethodBeat.o(112461);
          return;
        }
        ac.c(ac.this).setVisibility(8);
        AppMethodBeat.o(112461);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    AppMethodBeat.o(112462);
  }
  
  public final EditText getSearchEditText()
  {
    return this.jfo;
  }
  
  public final void setHint(String paramString)
  {
    this.hint = paramString;
  }
  
  public final void setSearchViewListener(ac.a parama)
  {
    this.zeN = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ac
 * JD-Core Version:    0.7.0.1
 */