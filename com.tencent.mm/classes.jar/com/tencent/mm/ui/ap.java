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
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;

public final class ap
  extends LinearLayout
{
  private EditText adJH;
  private ap.a adJI;
  private String hint;
  private Context mContext;
  private ImageButton mpf;
  private ImageView nfU;
  
  public ap(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159103);
    this.mContext = paramContext;
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(a.g.actionbar_search, this, true);
    this.nfU = ((ImageView)findViewById(a.f.actionbar_up_indicator_btn));
    this.nfU.setOnClickListener(new ap.1(this));
    this.adJH = ((EditText)findViewById(a.f.search_edit));
    this.adJH.requestFocus();
    this.mpf = ((ImageButton)findViewById(a.f.clear_btn));
    this.mpf.setOnClickListener(new ap.2(this));
    this.adJH.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(159102);
        if ((paramAnonymousEditable != null) && (paramAnonymousEditable.length() > 0))
        {
          ap.c(ap.this).setVisibility(0);
          AppMethodBeat.o(159102);
          return;
        }
        ap.c(ap.this).setVisibility(8);
        AppMethodBeat.o(159102);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    AppMethodBeat.o(159103);
  }
  
  public final EditText getSearchEditText()
  {
    return this.adJH;
  }
  
  public final void setHint(String paramString)
  {
    this.hint = paramString;
  }
  
  public final void setSearchViewListener(ap.a parama)
  {
    this.adJI = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ap
 * JD-Core Version:    0.7.0.1
 */