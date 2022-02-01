package com.tencent.mm.pluginsdk.ui.wallet;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class WalletIconImageView
  extends WeImageView
{
  private int GRb = -1;
  private int Kxi = -1;
  private int Kxj = 0;
  private int Kxk = 4;
  private int Kxl = -1;
  private Drawable Kxm;
  private View.OnClickListener Kxn = null;
  
  public WalletIconImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WalletIconImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletIconImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void gsP()
  {
    AppMethodBeat.i(72413);
    super.setVisibility(this.Kxk);
    setImageResource(this.Kxi);
    if (this.Kxj != -1)
    {
      super.setColorFilter(this.Kxj, PorterDuff.Mode.SRC_ATOP);
      setIconColor(this.Kxj);
    }
    if (this.Kxn != null) {
      super.setOnClickListener(this.Kxn);
    }
    AppMethodBeat.o(72413);
  }
  
  public final void setClearBtnDrawableId$255f295(int paramInt)
  {
    this.GRb = 2131690515;
    this.Kxl = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(72410);
    this.Kxi = paramInt;
    if (this.Kxi != -1) {
      super.setImageResource(paramInt);
    }
    AppMethodBeat.o(72410);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Kxn = paramOnClickListener;
  }
  
  public void setToClearState(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(72412);
    super.setVisibility(0);
    if (this.Kxm != null)
    {
      if (this.Kxl != -1)
      {
        super.setColorFilter(this.Kxl, PorterDuff.Mode.SRC_ATOP);
        setIconColor(this.Kxl);
      }
      setImageDrawable(this.Kxm);
    }
    for (;;)
    {
      super.setContentDescription(getContext().getString(2131757636));
      super.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(72412);
      return;
      if (this.GRb != -1)
      {
        super.setImageResource(this.GRb);
        if (this.Kxl != -1)
        {
          super.setColorFilter(this.Kxl, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.Kxl);
        }
      }
      else
      {
        super.setImageResource(2131233321);
        if (this.Kxl != -1)
        {
          super.setColorFilter(this.Kxl, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.Kxl);
        }
        else
        {
          super.setColorFilter(getResources().getColor(2131099749), PorterDuff.Mode.SRC_ATOP);
          setIconColor(getResources().getColor(2131099749));
        }
      }
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(72411);
    this.Kxk = paramInt;
    super.setVisibility(paramInt);
    AppMethodBeat.o(72411);
  }
  
  public void setmUserSetImageIconColor(int paramInt)
  {
    AppMethodBeat.i(174532);
    this.Kxj = paramInt;
    if (paramInt != -1) {
      setIconColor(paramInt);
    }
    AppMethodBeat.o(174532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView
 * JD-Core Version:    0.7.0.1
 */