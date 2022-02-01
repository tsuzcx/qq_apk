package com.tencent.mm.pluginsdk.ui.wallet;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class WalletIconImageView
  extends WeImageView
{
  private int NHm = -1;
  private int RyW = -1;
  private int RyX = 0;
  private int RyY = 4;
  private int RyZ = -1;
  private Drawable Rza;
  private View.OnClickListener Rzb = null;
  
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
  
  public final void hoc()
  {
    AppMethodBeat.i(72413);
    super.setVisibility(this.RyY);
    setImageResource(this.RyW);
    if (this.RyX != -1)
    {
      super.setColorFilter(this.RyX, PorterDuff.Mode.SRC_ATOP);
      setIconColor(this.RyX);
    }
    if (this.Rzb != null) {
      super.setOnClickListener(this.Rzb);
    }
    AppMethodBeat.o(72413);
  }
  
  public final void setClearBtnDrawableId(int paramInt1, int paramInt2)
  {
    this.NHm = paramInt1;
    this.RyZ = paramInt2;
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(72410);
    this.RyW = paramInt;
    if (this.RyW != -1) {
      super.setImageResource(paramInt);
    }
    AppMethodBeat.o(72410);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Rzb = paramOnClickListener;
  }
  
  public void setToClearState(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(72412);
    super.setVisibility(0);
    if (this.Rza != null)
    {
      if (this.RyZ != -1)
      {
        super.setColorFilter(this.RyZ, PorterDuff.Mode.SRC_ATOP);
        setIconColor(this.RyZ);
      }
      setImageDrawable(this.Rza);
    }
    for (;;)
    {
      super.setContentDescription(getContext().getString(a.i.clear_btn));
      super.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(72412);
      return;
      if (this.NHm != -1)
      {
        super.setImageResource(this.NHm);
        if (this.RyZ != -1)
        {
          super.setColorFilter(this.RyZ, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.RyZ);
        }
      }
      else
      {
        super.setImageResource(a.e.list_clear);
        if (this.RyZ != -1)
        {
          super.setColorFilter(this.RyZ, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.RyZ);
        }
        else
        {
          super.setColorFilter(getResources().getColor(a.c.FG_2), PorterDuff.Mode.SRC_ATOP);
          setIconColor(getResources().getColor(a.c.FG_2));
        }
      }
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(72411);
    this.RyY = paramInt;
    super.setVisibility(paramInt);
    AppMethodBeat.o(72411);
  }
  
  public void setmUserSetImageIconColor(int paramInt)
  {
    AppMethodBeat.i(174532);
    this.RyX = paramInt;
    if (paramInt != -1) {
      setIconColor(paramInt);
    }
    AppMethodBeat.o(174532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView
 * JD-Core Version:    0.7.0.1
 */