package com.tencent.mm.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ae;

final class ClearCacheUI$3$1
  implements Runnable
{
  ClearCacheUI$3$1(ClearCacheUI.3 param3) {}
  
  public final void run()
  {
    Toast.makeText(ae.getContext(), ae.getContext().getString(R.l.clear_cache_finish), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.ClearCacheUI.3.1
 * JD-Core Version:    0.7.0.1
 */