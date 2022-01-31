package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.az;
import java.util.LinkedList;

final class SnsCommentDetailUI$22
  implements View.OnAttachStateChangeListener
{
  boolean rPA = false;
  
  SnsCommentDetailUI$22(SnsCommentDetailUI paramSnsCommentDetailUI, TimeLineObject paramTimeLineObject, n paramn, LinkedList paramLinkedList) {}
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(38802);
    ab.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[] { Boolean.valueOf(this.rPA) });
    if (!this.rPA)
    {
      AppMethodBeat.o(38802);
      return;
    }
    this.rPA = false;
    if (this.rPB == null)
    {
      AppMethodBeat.o(38802);
      return;
    }
    if (this.rFG == null)
    {
      AppMethodBeat.o(38802);
      return;
    }
    if (this.rPu.rPq == null)
    {
      AppMethodBeat.o(38802);
      return;
    }
    paramView = SnsCommentDetailUI.D(this.rPu);
    PhotosContent localPhotosContent = this.rPu.rPq;
    TimeLineObject localTimeLineObject = this.rPB;
    String str = this.rFG.csH();
    SnsCommentDetailUI.B(this.rPu);
    paramView.a(localPhotosContent, localTimeLineObject, str, this.rPu.hashCode(), SnsCommentDetailUI.C(this.rPu), -1, this.rFG.Ex(32), false, az.yNT, this.rPC, this.rFG.getSnsId());
    AppMethodBeat.o(38802);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(38803);
    ab.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
    this.rPA = true;
    AppMethodBeat.o(38803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.22
 * JD-Core Version:    0.7.0.1
 */