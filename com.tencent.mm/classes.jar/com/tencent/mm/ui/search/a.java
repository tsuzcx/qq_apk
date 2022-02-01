package com.tencent.mm.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends LinearLayout
{
  public ImageView BVS;
  private FTSEditTextView Hlg;
  public View Hlh;
  private boolean Hli;
  private b Hlj;
  private a Hlk;
  private View sUG;
  
  public a(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(164206);
    this.Hli = paramBoolean;
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494183, this, true);
    this.sUG = findViewById(2131297690);
    this.sUG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164204);
        if (a.a(a.this) != null) {
          a.a(a.this).onClickBackBtn(paramAnonymousView);
        }
        AppMethodBeat.o(164204);
      }
    });
    this.BVS = ((ImageView)findViewById(2131304422));
    this.BVS.setVisibility(0);
    this.Hlg = ((FTSEditTextView)findViewById(2131300315));
    if (this.Hli)
    {
      this.Hlh = findViewById(2131300316);
      this.Hlh.setVisibility(0);
      this.Hlh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164205);
          if (a.b(a.this) != null) {
            a.b(a.this).onClickSearchButton(paramAnonymousView);
          }
          AppMethodBeat.o(164205);
        }
      });
    }
    AppMethodBeat.o(164206);
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    return this.Hlg;
  }
  
  public final void setImageSearchListener(a parama)
  {
    this.Hlk = parama;
  }
  
  public final void setSearchViewListener(b paramb)
  {
    this.Hlj = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void onClickSearchButton(View paramView);
  }
  
  public static abstract interface b
  {
    public abstract void onClickBackBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.search.a
 * JD-Core Version:    0.7.0.1
 */