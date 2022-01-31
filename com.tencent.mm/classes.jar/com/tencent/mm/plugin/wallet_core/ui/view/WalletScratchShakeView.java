package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.sdk.platformtools.ab;

public class WalletScratchShakeView
  extends FrameLayout
{
  WalletScratchShakeView.b uwY;
  boolean uwZ;
  boolean uxa;
  private WalletScratchShakeView.a uxb;
  
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
    AppMethodBeat.i(47936);
    if (this.uwY != null)
    {
      WalletScratchShakeView.b localb = this.uwY;
      ab.i("MicroMsg.WalletScratchShakeView", "onDestroy");
      if (localb.shakeSensor != null) {
        localb.shakeSensor.bjf();
      }
    }
    AppMethodBeat.o(47936);
  }
  
  public void setScratchShakeCallback(WalletScratchShakeView.a parama)
  {
    this.uxb = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView
 * JD-Core Version:    0.7.0.1
 */