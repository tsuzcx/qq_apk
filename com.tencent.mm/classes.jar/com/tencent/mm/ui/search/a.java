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
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
  extends LinearLayout
{
  private FTSEditTextView Gng;
  private View XLZ;
  private LinearLayout XMa;
  private LinearLayout XMb;
  private View XMc;
  private boolean XMd;
  private TextView XMe;
  private b XMf;
  private a XMg;
  private View xZQ;
  private boolean zEV;
  private WeImageView zoq;
  
  public a(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private a(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(189731);
    this.zEV = false;
    this.XMd = false;
    init();
    AppMethodBeat.o(189731);
  }
  
  public a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(164206);
    this.zEV = false;
    this.XMd = false;
    this.zEV = paramBoolean;
    init();
    AppMethodBeat.o(164206);
  }
  
  private void init()
  {
    AppMethodBeat.i(189741);
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    if (this.zEV) {}
    for (int i = a.h.fts_actionbar_searchview_night_mode;; i = a.h.fts_actionbar_searchview)
    {
      localLayoutInflater.inflate(i, this, true);
      this.XMa = ((LinearLayout)findViewById(a.g.search_container));
      if (this.zEV) {
        this.XMa.setBackgroundColor(getResources().getColor(a.d.Dark_0));
      }
      this.XMb = ((LinearLayout)findViewById(a.g.hot_search_container));
      this.xZQ = findViewById(a.g.cancel_btn);
      this.xZQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164204);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/FTSSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (a.a(a.this) != null) {
            a.a(a.this).onClickBackBtn(paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164204);
        }
      });
      this.zoq = ((WeImageView)findViewById(a.g.search_icon));
      this.zoq.setVisibility(0);
      this.Gng = ((FTSEditTextView)findViewById(a.g.fts_edittext));
      if (this.XMd)
      {
        this.XMc = findViewById(a.g.fts_image_search_btn);
        this.XMc.setVisibility(0);
        this.XMc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(164205);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/FTSSearchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (a.b(a.this) != null) {
              a.b(a.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164205);
          }
        });
      }
      AppMethodBeat.o(189741);
      return;
    }
  }
  
  public final void axr(int paramInt)
  {
    AppMethodBeat.i(189748);
    this.XLZ = findViewById(a.g.back_btn);
    this.XLZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(204971);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/FTSSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (a.a(a.this) != null) {
          a.a(a.this).onClickBackBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204971);
      }
    });
    this.XLZ.setVisibility(0);
    this.xZQ.setVisibility(8);
    paramInt = getResources().getColor(paramInt);
    this.XMa.setBackgroundColor(paramInt);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Gng.getLayoutParams();
    localLayoutParams.width = -2;
    localLayoutParams.setMarginEnd((int)getResources().getDimension(a.e.Edge_2A));
    this.Gng.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(189748);
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    return this.Gng;
  }
  
  public final LinearLayout getSearchContainer()
  {
    return this.XMa;
  }
  
  public final WeImageView getSearchIcon()
  {
    return this.zoq;
  }
  
  public final void l(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(189752);
    this.XMa.setVisibility(8);
    this.XMb.setVisibility(0);
    this.XMe = ((TextView)findViewById(a.g.hot_search_hint_text));
    this.XLZ = findViewById(a.g.back_btn);
    this.XLZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(189861);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/FTSSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (a.a(a.this) != null) {
          a.a(a.this).onClickBackBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(189861);
      }
    });
    this.XMb.setClickable(true);
    this.XMb.setOnClickListener(paramOnClickListener);
    this.XLZ.setVisibility(0);
    this.xZQ.setVisibility(8);
    AppMethodBeat.o(189752);
  }
  
  public final void setImageSearchListener(a parama)
  {
    this.XMg = parama;
  }
  
  public final void setSearchViewListener(b paramb)
  {
    this.XMf = paramb;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void onClickBackBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.search.a
 * JD-Core Version:    0.7.0.1
 */