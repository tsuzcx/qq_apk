package com.tencent.mm.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public final class a
  extends LinearLayout
{
  private ImageView FlK;
  private FTSEditTextView KZa;
  private View KZb;
  private boolean KZc;
  private b KZd;
  private a KZe;
  private View vrJ;
  
  public a(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private a(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(193747);
    this.KZc = false;
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494183, this, true);
    this.vrJ = findViewById(2131297690);
    this.vrJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164204);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (a.a(a.this) != null) {
          a.a(a.this).onClickBackBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164204);
      }
    });
    this.FlK = ((ImageView)findViewById(2131304422));
    this.FlK.setVisibility(0);
    this.KZa = ((FTSEditTextView)findViewById(2131300315));
    if (this.KZc)
    {
      this.KZb = findViewById(2131300316);
      this.KZb.setVisibility(0);
      this.KZb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164205);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSSearchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (a.b(a.this) != null) {
            a.b(a.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164205);
        }
      });
    }
    AppMethodBeat.o(193747);
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    return this.KZa;
  }
  
  public final void setImageSearchListener(a parama)
  {
    this.KZe = parama;
  }
  
  public final void setSearchViewListener(b paramb)
  {
    this.KZd = paramb;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void onClickBackBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.search.a
 * JD-Core Version:    0.7.0.1
 */