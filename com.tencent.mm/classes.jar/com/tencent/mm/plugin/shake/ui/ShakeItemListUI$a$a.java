package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

final class ShakeItemListUI$a$a
{
  TextView fdY;
  ImageView ffK;
  TextView ffL;
  ImageView mDA;
  TextView mDy;
  TextView mDz;
  View obI;
  ImageView obJ;
  TextView obK;
  LinearLayout obL;
  TextView obM;
  
  ShakeItemListUI$a$a(ShakeItemListUI.a parama) {}
  
  public final void clear()
  {
    if (this.ffK != null)
    {
      this.ffK.setImageDrawable(null);
      this.ffK.setVisibility(8);
    }
    if (this.fdY != null)
    {
      this.fdY.setText("");
      this.fdY.setVisibility(8);
    }
    if (this.ffL != null) {
      this.ffL.setVisibility(8);
    }
    if (this.obJ != null) {
      this.obJ.setVisibility(8);
    }
    if (this.mDy != null)
    {
      this.mDy.setText("");
      this.mDy.setVisibility(8);
    }
    if (this.mDz != null)
    {
      this.mDz.setVisibility(8);
      this.obI.setVisibility(8);
    }
    if (this.mDA != null) {
      this.mDA.setVisibility(8);
    }
    if (this.obK != null)
    {
      this.obK.setText("");
      this.obK.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.a.a
 * JD-Core Version:    0.7.0.1
 */