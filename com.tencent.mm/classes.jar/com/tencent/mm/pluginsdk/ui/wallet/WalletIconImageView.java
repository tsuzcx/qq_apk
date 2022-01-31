package com.tencent.mm.pluginsdk.ui.wallet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WalletIconImageView
  extends ImageView
{
  private int ni = 4;
  private int wgn = -1;
  private View.OnClickListener wgo = null;
  
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
  
  public final void dpM()
  {
    AppMethodBeat.i(48768);
    super.setVisibility(this.ni);
    super.setImageResource(this.wgn);
    if (this.wgo != null) {
      super.setOnClickListener(this.wgo);
    }
    AppMethodBeat.o(48768);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(48765);
    this.wgn = paramInt;
    super.setImageResource(paramInt);
    AppMethodBeat.o(48765);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.wgo = paramOnClickListener;
  }
  
  public void setToClearState(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(48767);
    super.setVisibility(0);
    super.setImageResource(2130839272);
    super.setContentDescription(getContext().getString(2131298408));
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(48767);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(48766);
    this.ni = paramInt;
    super.setVisibility(paramInt);
    AppMethodBeat.o(48766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView
 * JD-Core Version:    0.7.0.1
 */