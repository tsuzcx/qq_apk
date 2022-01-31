package com.tencent.mm.ui.base;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.y;

final class MMTagPanel$5
  implements TextView.OnEditorActionListener
{
  MMTagPanel$5(MMTagPanel paramMMTagPanel) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    y.d("MicroMsg.MMTagPanel", "on action %d, %s", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.5
 * JD-Core Version:    0.7.0.1
 */