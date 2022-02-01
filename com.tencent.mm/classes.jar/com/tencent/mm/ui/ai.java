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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class ai
  extends LinearLayout
{
  private a OKG;
  private ImageView hNZ;
  private ImageButton hey;
  private String hint;
  private Context mContext;
  private EditText ooo;
  
  public ai(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159103);
    this.mContext = paramContext;
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131492942, this, true);
    this.hNZ = ((ImageView)findViewById(2131296449));
    this.hNZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159100);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/SearchBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ai.a(ai.this) != null) {
          ai.a(ai.this).onClickBackBtn(paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/ui/SearchBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159100);
      }
    });
    this.ooo = ((EditText)findViewById(2131307379));
    this.ooo.requestFocus();
    this.hey = ((ImageButton)findViewById(2131298744));
    this.hey.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159101);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/SearchBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ai.b(ai.this);
        a.a(this, "com/tencent/mm/ui/SearchBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159101);
      }
    });
    this.ooo.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(159102);
        if ((paramAnonymousEditable != null) && (paramAnonymousEditable.length() > 0))
        {
          ai.c(ai.this).setVisibility(0);
          AppMethodBeat.o(159102);
          return;
        }
        ai.c(ai.this).setVisibility(8);
        AppMethodBeat.o(159102);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    AppMethodBeat.o(159103);
  }
  
  public final EditText getSearchEditText()
  {
    return this.ooo;
  }
  
  public final void setHint(String paramString)
  {
    this.hint = paramString;
  }
  
  public final void setSearchViewListener(a parama)
  {
    this.OKG = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onClickBackBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ai
 * JD-Core Version:    0.7.0.1
 */