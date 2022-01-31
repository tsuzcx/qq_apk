package com.tencent.mm.plugin.sns.ui;

import android.graphics.BitmapFactory.Options;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.tools.e;

final class SnsBrowseUI$3
  implements ViewTreeObserver.OnPreDrawListener
{
  SnsBrowseUI$3(SnsBrowseUI paramSnsBrowseUI) {}
  
  public final boolean onPreDraw()
  {
    this.oVL.oVy.getViewTreeObserver().removeOnPreDrawListener(this);
    SnsBrowseUI.a(this.oVL, this.oVL.oVy.getWidth());
    SnsBrowseUI.b(this.oVL, this.oVL.oVy.getHeight());
    SnsBrowseUI.c(this.oVL, this.oVL.oVy.getWidth());
    SnsBrowseUI.d(this.oVL, this.oVL.oVy.getHeight());
    af.bDC();
    Object localObject = g.C(this.oVL.oVy.getCntMedia());
    if (localObject != null)
    {
      localObject = c.YU((String)localObject);
      SnsBrowseUI localSnsBrowseUI = this.oVL;
      float f = SnsBrowseUI.b(this.oVL) / ((BitmapFactory.Options)localObject).outWidth;
      SnsBrowseUI.d(localSnsBrowseUI, (int)(((BitmapFactory.Options)localObject).outHeight * f));
      if (SnsBrowseUI.c(this.oVL) > this.oVL.oVy.getHeight()) {
        SnsBrowseUI.d(this.oVL, this.oVL.oVy.getHeight());
      }
    }
    this.oVL.itA.fH(SnsBrowseUI.b(this.oVL), SnsBrowseUI.c(this.oVL));
    this.oVL.itA.a(this.oVL.oVy, SnsBrowseUI.d(this.oVL), null);
    this.oVL.bIx();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBrowseUI.3
 * JD-Core Version:    0.7.0.1
 */