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
  private int BVB = -1;
  private int FlG = -1;
  private int FlH = 0;
  private int FlI = 4;
  private int FlJ = -1;
  private Drawable FlK;
  private View.OnClickListener FlL = null;
  
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
  
  public final void ffz()
  {
    AppMethodBeat.i(72413);
    super.setVisibility(this.FlI);
    setImageResource(this.FlG);
    if (this.FlH != -1)
    {
      super.setColorFilter(this.FlH, PorterDuff.Mode.SRC_ATOP);
      setIconColor(this.FlH);
    }
    if (this.FlL != null) {
      super.setOnClickListener(this.FlL);
    }
    AppMethodBeat.o(72413);
  }
  
  public final void setClearBtnDrawableId$255f295(int paramInt)
  {
    this.BVB = 2131690372;
    this.FlJ = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(72410);
    this.FlG = paramInt;
    if (this.FlG != -1) {
      super.setImageResource(paramInt);
    }
    AppMethodBeat.o(72410);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.FlL = paramOnClickListener;
  }
  
  public void setToClearState(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(72412);
    super.setVisibility(0);
    if (this.FlK != null)
    {
      if (this.FlJ != -1)
      {
        super.setColorFilter(this.FlJ, PorterDuff.Mode.SRC_ATOP);
        setIconColor(this.FlJ);
      }
      setImageDrawable(this.FlK);
    }
    for (;;)
    {
      super.setContentDescription(getContext().getString(2131757419));
      super.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(72412);
      return;
      if (this.BVB != -1)
      {
        super.setImageResource(this.BVB);
        if (this.FlJ != -1)
        {
          super.setColorFilter(this.FlJ, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.FlJ);
        }
      }
      else
      {
        super.setImageResource(2131232862);
        if (this.FlJ != -1)
        {
          super.setColorFilter(this.FlJ, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.FlJ);
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
    this.FlI = paramInt;
    super.setVisibility(paramInt);
    AppMethodBeat.o(72411);
  }
  
  public void setmUserSetImageIconColor(int paramInt)
  {
    AppMethodBeat.i(174532);
    this.FlH = paramInt;
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