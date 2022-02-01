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
  private ImageView ETp;
  private FTSEditTextView KCG;
  private View KCH;
  private boolean KCI;
  private b KCJ;
  private a KCK;
  private View vfC;
  
  public a(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private a(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(186490);
    this.KCI = false;
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494183, this, true);
    this.vfC = findViewById(2131297690);
    this.vfC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164204);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (a.a(a.this) != null) {
          a.a(a.this).onClickBackBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164204);
      }
    });
    this.ETp = ((ImageView)findViewById(2131304422));
    this.ETp.setVisibility(0);
    this.KCG = ((FTSEditTextView)findViewById(2131300315));
    if (this.KCI)
    {
      this.KCH = findViewById(2131300316);
      this.KCH.setVisibility(0);
      this.KCH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164205);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSSearchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (a.b(a.this) != null) {
            a.b(a.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164205);
        }
      });
    }
    AppMethodBeat.o(186490);
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    return this.KCG;
  }
  
  public final void setImageSearchListener(a parama)
  {
    this.KCK = parama;
  }
  
  public final void setSearchViewListener(b paramb)
  {
    this.KCJ = paramb;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void onClickBackBtn(View paramView);
  }
  
  public static abstract interface c
    extends Comparable
  {
    public abstract String getTagName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.search.a
 * JD-Core Version:    0.7.0.1
 */