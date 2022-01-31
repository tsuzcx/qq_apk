package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import java.util.LinkedList;

final class SnsCommentDetailUI$22
  implements View.OnAttachStateChangeListener
{
  boolean oXc = false;
  
  SnsCommentDetailUI$22(SnsCommentDetailUI paramSnsCommentDetailUI, bxk parambxk, n paramn, LinkedList paramLinkedList) {}
  
  public final void onViewAttachedToWindow(View paramView)
  {
    y.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[] { Boolean.valueOf(this.oXc) });
    if (!this.oXc) {}
    do
    {
      return;
      this.oXc = false;
    } while ((this.oXd == null) || (this.oNX == null) || (this.oWW.oWS == null));
    paramView = SnsCommentDetailUI.D(this.oWW);
    PhotosContent localPhotosContent = this.oWW.oWS;
    bxk localbxk = this.oXd;
    String str = this.oNX.bGE();
    SnsCommentDetailUI.B(this.oWW);
    int i = this.oWW.hashCode();
    int j = SnsCommentDetailUI.C(this.oWW);
    this.oNX.yr(32);
    paramView.a(localPhotosContent, localbxk, str, i, j, -1, false, az.uBJ, this.oXe);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    y.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
    this.oXc = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.22
 * JD-Core Version:    0.7.0.1
 */