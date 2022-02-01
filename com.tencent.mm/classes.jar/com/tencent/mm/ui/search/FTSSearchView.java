package com.tencent.mm.ui.search;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class FTSSearchView
  extends LinearLayout
{
  private boolean ANb;
  public View CxW;
  private WeImageView EqX;
  public FTSEditTextView Mhl;
  public View afCn;
  public LinearLayout afCo;
  public LinearLayout afCp;
  private View afCq;
  private boolean afCr;
  public TextView afCs;
  private b afCt;
  private a afCu;
  
  public FTSSearchView(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  public FTSSearchView(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(250018);
    this.ANb = false;
    this.afCr = false;
    init();
    AppMethodBeat.o(250018);
  }
  
  public FTSSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(250009);
    this.ANb = false;
    init();
    AppMethodBeat.o(250009);
  }
  
  public FTSSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(250013);
    this.ANb = false;
    init();
    AppMethodBeat.o(250013);
  }
  
  public FTSSearchView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(164206);
    this.ANb = false;
    this.afCr = false;
    this.ANb = paramBoolean;
    init();
    AppMethodBeat.o(164206);
  }
  
  private void init()
  {
    AppMethodBeat.i(250023);
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    if (this.ANb) {}
    for (int i = a.h.fts_actionbar_searchview_night_mode;; i = a.h.fts_actionbar_searchview)
    {
      localLayoutInflater.inflate(i, this, true);
      this.afCo = ((LinearLayout)findViewById(a.g.search_container));
      if (this.ANb) {
        this.afCo.setBackgroundColor(getResources().getColor(a.d.Dark_0));
      }
      this.afCp = ((LinearLayout)findViewById(a.g.hot_search_container));
      this.CxW = findViewById(a.g.cancel_btn);
      this.CxW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164204);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/search/FTSSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (FTSSearchView.a(FTSSearchView.this) != null) {
            FTSSearchView.a(FTSSearchView.this).onClickBackBtn(paramAnonymousView);
          }
          a.a(this, "com/tencent/mm/ui/search/FTSSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164204);
        }
      });
      this.EqX = ((WeImageView)findViewById(a.g.search_icon));
      this.EqX.setVisibility(0);
      this.Mhl = ((FTSEditTextView)findViewById(a.g.fts_edittext));
      if (this.afCr)
      {
        this.afCq = findViewById(a.g.fts_image_search_btn);
        this.afCq.setVisibility(0);
        this.afCq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(164205);
            b localb = new b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/ui/search/FTSSearchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (FTSSearchView.b(FTSSearchView.this) != null) {
              FTSSearchView.b(FTSSearchView.this);
            }
            a.a(this, "com/tencent/mm/ui/search/FTSSearchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164205);
          }
        });
      }
      this.EqX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(250012);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/search/FTSSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          FTSSearchView.c(FTSSearchView.this).aWT();
          FTSSearchView.c(FTSSearchView.this).aWS();
          a.a(this, "com/tencent/mm/ui/search/FTSSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(250012);
        }
      });
      AppMethodBeat.o(250023);
      return;
    }
  }
  
  public FTSEditTextView getFtsEditText()
  {
    return this.Mhl;
  }
  
  public LinearLayout getSearchContainer()
  {
    return this.afCo;
  }
  
  public WeImageView getSearchIcon()
  {
    return this.EqX;
  }
  
  public void setImageSearchListener(a parama)
  {
    this.afCu = parama;
  }
  
  public void setSearchViewListener(b paramb)
  {
    this.afCt = paramb;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void onClickBackBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.search.FTSSearchView
 * JD-Core Version:    0.7.0.1
 */