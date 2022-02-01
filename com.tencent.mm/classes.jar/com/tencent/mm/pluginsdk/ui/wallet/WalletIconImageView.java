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
  private int Utm = -1;
  private int Yvs = -1;
  private int Yvt = 0;
  private int Yvu = 4;
  private int Yvv = -1;
  private Drawable Yvw;
  private String Yvx;
  private View.OnClickListener Yvy = null;
  
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
  
  public final void iOU()
  {
    AppMethodBeat.i(72413);
    super.setVisibility(this.Yvu);
    setImageResource(this.Yvs);
    setContentDescription(this.Yvx);
    if (this.Yvt != -1)
    {
      super.setColorFilter(this.Yvt, PorterDuff.Mode.SRC_ATOP);
      setIconColor(this.Yvt);
    }
    if (this.Yvy != null) {
      super.setOnClickListener(this.Yvy);
    }
    AppMethodBeat.o(72413);
  }
  
  public final void setClearBtnDrawableId(int paramInt1, int paramInt2)
  {
    this.Utm = paramInt1;
    this.Yvv = paramInt2;
  }
  
  public void setIconContentDescription(String paramString)
  {
    this.Yvx = paramString;
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(72410);
    this.Yvs = paramInt;
    if (this.Yvs != -1) {
      super.setImageResource(paramInt);
    }
    AppMethodBeat.o(72410);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Yvy = paramOnClickListener;
  }
  
  public void setToClearState(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(72412);
    super.setVisibility(0);
    if (this.Yvw != null)
    {
      if (this.Yvv != -1)
      {
        super.setColorFilter(this.Yvv, PorterDuff.Mode.SRC_ATOP);
        setIconColor(this.Yvv);
      }
      setImageDrawable(this.Yvw);
    }
    for (;;)
    {
      super.setContentDescription(getContext().getString(a.i.clear_btn));
      super.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(72412);
      return;
      if (this.Utm != -1)
      {
        super.setImageResource(this.Utm);
        if (this.Yvv != -1)
        {
          super.setColorFilter(this.Yvv, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.Yvv);
        }
      }
      else
      {
        super.setImageResource(a.e.list_clear);
        if (this.Yvv != -1)
        {
          super.setColorFilter(this.Yvv, PorterDuff.Mode.SRC_ATOP);
          setIconColor(this.Yvv);
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
    this.Yvu = paramInt;
    super.setVisibility(paramInt);
    AppMethodBeat.o(72411);
  }
  
  public void setmUserSetImageIconColor(int paramInt)
  {
    AppMethodBeat.i(174532);
    this.Yvt = paramInt;
    if (paramInt != -1) {
      setIconColor(paramInt);
    }
    AppMethodBeat.o(174532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView
 * JD-Core Version:    0.7.0.1
 */