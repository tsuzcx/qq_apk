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
  private ImageView Doj;
  private View ILA;
  private boolean ILB;
  private b ILC;
  private a ILD;
  private FTSEditTextView ILz;
  private View ucS;
  
  public a(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private a(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(197200);
    this.ILB = false;
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494183, this, true);
    this.ucS = findViewById(2131297690);
    this.ucS.setOnClickListener(new View.OnClickListener()
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
    this.Doj = ((ImageView)findViewById(2131304422));
    this.Doj.setVisibility(0);
    this.ILz = ((FTSEditTextView)findViewById(2131300315));
    if (this.ILB)
    {
      this.ILA = findViewById(2131300316);
      this.ILA.setVisibility(0);
      this.ILA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164205);
          if (a.b(a.this) != null) {
            a.b(a.this);
          }
          AppMethodBeat.o(164205);
        }
      });
    }
    AppMethodBeat.o(197200);
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    return this.ILz;
  }
  
  public final void setImageSearchListener(a parama)
  {
    this.ILD = parama;
  }
  
  public final void setSearchViewListener(b paramb)
  {
    this.ILC = paramb;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void onClickBackBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.search.a
 * JD-Core Version:    0.7.0.1
 */