package com.tencent.mm.plugin.scanner.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.scanner.util.e.a;
import com.tencent.mm.sdk.platformtools.y;

final class p$1
  implements e.a
{
  p$1(p paramp) {}
  
  public final void n(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.scanner.ScanModeQRCode", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.nMw.nMm = false;
      return;
    case 1: 
      this.nMw.im(true);
      return;
    case 2: 
      this.nMw.im(true);
      return;
    case 3: 
      this.nMw.nLB.bxF();
      return;
    case 4: 
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("geta8key_fullurl");
        if ((paramBundle != null) && ((paramBundle.startsWith("http://login.weixin.qq.com")) || (paramBundle.startsWith("https://login.weixin.qq.com")))) {
          this.nMw.bID = 2;
        }
      }
      break;
    }
    this.nMw.nLB.ix(true);
    this.nMw.nMm = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.1
 * JD-Core Version:    0.7.0.1
 */