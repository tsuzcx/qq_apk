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
  private int Cog = -1;
  private int Coh = 0;
  private int Coi = 4;
  private int Coj = -1;
  private Drawable Cok;
  private View.OnClickListener Col = null;
  private int zdA = -1;
  
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
  
  public final void eBb()
  {
    AppMethodBeat.i(72413);
    super.setVisibility(this.Coi);
    setImageResource(this.Cog);
    if (this.Coh != -1)
    {
      super.setColorFilter(this.Coh, PorterDuff.Mode.SRC_ATOP);
      setIconColor(this.Coh);
    }
    if (this.Col != null) {
      super.setOnClickListener(this.Col);
    }
    AppMethodBeat.o(72413);
  }
  
  public final void setClearBtnDrawableId$255f295(int paramInt)
  {
    this.zdA = 2131690372;
    this.Coj = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(72410);
    this.Cog = paramInt;
    if (this.Cog != -1) {
      super.setImageResource(paramInt);
    }
    AppMethodBeat.o(72410);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Col = paramOnClickListener;
  }
  
  public void setToClearState(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(72412);
    super.setVisibility(0);
    if (this.Cok != null)
    {
      if (this.Coj != -1)
      {
        super.setColorFilter(this.Coj, PorterDuff.Mode.SRC_ATOP);
        setIconColor(this.Coj);
      }
      setImageDrawable(this.Cok);
    }
    for (;;)
    {
      super.setContentDescription(getContext().getString(2131757419));
      super.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(72412);
      return;
      if (this.zdA != -1)
      {
        super.setImageResource(this.zdA);
        if (this.Coj != -1)
        {
          super.setColorFilter(this.Coj, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.Coj);
        }
      }
      else
      {
        super.setImageResource(2131232862);
        if (this.Coj != -1)
        {
          super.setColorFilter(this.Coj, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.Coj);
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
    this.Coi = paramInt;
    super.setVisibility(paramInt);
    AppMethodBeat.o(72411);
  }
  
  public void setmUserSetImageIconColor(int paramInt)
  {
    AppMethodBeat.i(174532);
    this.Coh = paramInt;
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