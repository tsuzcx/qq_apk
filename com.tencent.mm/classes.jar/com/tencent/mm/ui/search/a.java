package com.tencent.mm.ui.search;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
  extends LinearLayout
{
  private FTSEditTextView Awv;
  private WeImageView OxK;
  private View QnU;
  private LinearLayout QnV;
  private LinearLayout QnW;
  private View QnX;
  private boolean QnY;
  private TextView QnZ;
  private b Qoa;
  private a Qob;
  private View uvi;
  
  public a(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private a(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(205358);
    this.QnY = false;
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494737, this, true);
    this.QnV = ((LinearLayout)findViewById(2131307371));
    this.QnW = ((LinearLayout)findViewById(2131302355));
    this.uvi = findViewById(2131297963);
    this.uvi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164204);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (a.a(a.this) != null) {
          a.a(a.this).onClickBackBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164204);
      }
    });
    this.OxK = ((WeImageView)findViewById(2131307390));
    this.OxK.setVisibility(0);
    this.Awv = ((FTSEditTextView)findViewById(2131301807));
    if (this.QnY)
    {
      this.QnX = findViewById(2131301808);
      this.QnX.setVisibility(0);
      this.QnX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164205);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSSearchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (a.b(a.this) != null) {
            a.b(a.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164205);
        }
      });
    }
    AppMethodBeat.o(205358);
  }
  
  public final void gXh()
  {
    AppMethodBeat.i(205359);
    this.QnU = findViewById(2131297163);
    this.QnU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205356);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (a.a(a.this) != null) {
          a.a(a.this).onClickBackBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205356);
      }
    });
    this.QnU.setVisibility(0);
    this.uvi.setVisibility(8);
    int i = getResources().getColor(2131099689);
    this.QnV.setBackgroundColor(i);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Awv.getLayoutParams();
    localLayoutParams.width = -2;
    localLayoutParams.setMarginEnd((int)getResources().getDimension(2131165296));
    this.Awv.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(205359);
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    return this.Awv;
  }
  
  public final LinearLayout getSearchContainer()
  {
    return this.QnV;
  }
  
  public final WeImageView getSearchIcon()
  {
    return this.OxK;
  }
  
  public final void j(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(205360);
    this.QnV.setVisibility(8);
    this.QnW.setVisibility(0);
    this.QnZ = ((TextView)findViewById(2131302356));
    this.QnU = findViewById(2131297163);
    this.QnU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205357);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (a.a(a.this) != null) {
          a.a(a.this).onClickBackBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205357);
      }
    });
    this.QnW.setClickable(true);
    this.QnW.setOnClickListener(paramOnClickListener);
    this.QnU.setVisibility(0);
    this.uvi.setVisibility(8);
    AppMethodBeat.o(205360);
  }
  
  public final void setImageSearchListener(a parama)
  {
    this.Qob = parama;
  }
  
  public final void setSearchViewListener(b paramb)
  {
    this.Qoa = paramb;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void onClickBackBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.search.a
 * JD-Core Version:    0.7.0.1
 */