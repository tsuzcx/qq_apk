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
  private int Cnc = -1;
  private int FEe = -1;
  private int FEf = 0;
  private int FEg = 4;
  private int FEh = -1;
  private Drawable FEi;
  private View.OnClickListener FEj = null;
  
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
  
  public final void fjp()
  {
    AppMethodBeat.i(72413);
    super.setVisibility(this.FEg);
    setImageResource(this.FEe);
    if (this.FEf != -1)
    {
      super.setColorFilter(this.FEf, PorterDuff.Mode.SRC_ATOP);
      setIconColor(this.FEf);
    }
    if (this.FEj != null) {
      super.setOnClickListener(this.FEj);
    }
    AppMethodBeat.o(72413);
  }
  
  public final void setClearBtnDrawableId$255f295(int paramInt)
  {
    this.Cnc = 2131690372;
    this.FEh = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(72410);
    this.FEe = paramInt;
    if (this.FEe != -1) {
      super.setImageResource(paramInt);
    }
    AppMethodBeat.o(72410);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.FEj = paramOnClickListener;
  }
  
  public void setToClearState(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(72412);
    super.setVisibility(0);
    if (this.FEi != null)
    {
      if (this.FEh != -1)
      {
        super.setColorFilter(this.FEh, PorterDuff.Mode.SRC_ATOP);
        setIconColor(this.FEh);
      }
      setImageDrawable(this.FEi);
    }
    for (;;)
    {
      super.setContentDescription(getContext().getString(2131757419));
      super.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(72412);
      return;
      if (this.Cnc != -1)
      {
        super.setImageResource(this.Cnc);
        if (this.FEh != -1)
        {
          super.setColorFilter(this.FEh, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.FEh);
        }
      }
      else
      {
        super.setImageResource(2131232862);
        if (this.FEh != -1)
        {
          super.setColorFilter(this.FEh, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.FEh);
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
    this.FEg = paramInt;
    super.setVisibility(paramInt);
    AppMethodBeat.o(72411);
  }
  
  public void setmUserSetImageIconColor(int paramInt)
  {
    AppMethodBeat.i(174532);
    this.FEf = paramInt;
    if (paramInt != -1) {
      setIconColor(paramInt);
    }
    AppMethodBeat.o(174532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView
 * JD-Core Version:    0.7.0.1
 */