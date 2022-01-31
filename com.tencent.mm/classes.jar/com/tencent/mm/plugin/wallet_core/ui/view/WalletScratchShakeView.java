package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mm.pluginsdk.i.c;
import com.tencent.mm.sdk.platformtools.y;

public class WalletScratchShakeView
  extends FrameLayout
{
  WalletScratchShakeView.b qIq;
  boolean qIr;
  boolean qIs;
  private WalletScratchShakeView.a qIt;
  
  public WalletScratchShakeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WalletScratchShakeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onDestroy()
  {
    if (this.qIq != null)
    {
      WalletScratchShakeView.b localb = this.qIq;
      y.i("MicroMsg.WalletScratchShakeView", "onDestroy");
      if (localb.mBT != null) {
        localb.mBT.aFJ();
      }
    }
  }
  
  public void setScratchShakeCallback(WalletScratchShakeView.a parama)
  {
    this.qIt = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView
 * JD-Core Version:    0.7.0.1
 */