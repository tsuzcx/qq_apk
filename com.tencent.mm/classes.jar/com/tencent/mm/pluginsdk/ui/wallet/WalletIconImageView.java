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
  private int Awg = -1;
  private int DGA = 0;
  private int DGB = 4;
  private int DGC = -1;
  private Drawable DGD;
  private View.OnClickListener DGE = null;
  private int DGz = -1;
  
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
  
  public final void eQv()
  {
    AppMethodBeat.i(72413);
    super.setVisibility(this.DGB);
    setImageResource(this.DGz);
    if (this.DGA != -1)
    {
      super.setColorFilter(this.DGA, PorterDuff.Mode.SRC_ATOP);
      setIconColor(this.DGA);
    }
    if (this.DGE != null) {
      super.setOnClickListener(this.DGE);
    }
    AppMethodBeat.o(72413);
  }
  
  public final void setClearBtnDrawableId$255f295(int paramInt)
  {
    this.Awg = 2131690372;
    this.DGC = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(72410);
    this.DGz = paramInt;
    if (this.DGz != -1) {
      super.setImageResource(paramInt);
    }
    AppMethodBeat.o(72410);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.DGE = paramOnClickListener;
  }
  
  public void setToClearState(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(72412);
    super.setVisibility(0);
    if (this.DGD != null)
    {
      if (this.DGC != -1)
      {
        super.setColorFilter(this.DGC, PorterDuff.Mode.SRC_ATOP);
        setIconColor(this.DGC);
      }
      setImageDrawable(this.DGD);
    }
    for (;;)
    {
      super.setContentDescription(getContext().getString(2131757419));
      super.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(72412);
      return;
      if (this.Awg != -1)
      {
        super.setImageResource(this.Awg);
        if (this.DGC != -1)
        {
          super.setColorFilter(this.DGC, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.DGC);
        }
      }
      else
      {
        super.setImageResource(2131232862);
        if (this.DGC != -1)
        {
          super.setColorFilter(this.DGC, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.DGC);
        }
        else
        {
          super.setColorFilter(getResources().getColor(2131099735), PorterDuff.Mode.SRC_ATOP);
          setIconColor(getResources().getColor(2131099735));
        }
      }
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(72411);
    this.DGB = paramInt;
    super.setVisibility(paramInt);
    AppMethodBeat.o(72411);
  }
  
  public void setmUserSetImageIconColor(int paramInt)
  {
    AppMethodBeat.i(174532);
    this.DGA = paramInt;
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