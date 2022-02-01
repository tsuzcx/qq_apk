package com.tencent.mm.plugin.sns.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.aj.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.axf;

final class SnsCommentDetailUI$31
  implements aj.b
{
  SnsCommentDetailUI$31(SnsCommentDetailUI paramSnsCommentDetailUI, long paramLong, TimeLineObject paramTimeLineObject, axf paramaxf) {}
  
  public final void a(long paramLong, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(203526);
    paramObject = SnsCommentDetailUI.y(this.ECd).findViewById(2131301031);
    View localView = SnsCommentDetailUI.y(this.ECd).findViewById(2131300979);
    ImageView localImageView = (ImageView)SnsCommentDetailUI.y(this.ECd).findViewById(2131308127);
    if (this.ECs == paramLong) {
      if (paramInt == 2)
      {
        if ((this.ECp.ContentObj != null) && (this.ECp.ContentObj.Lpc != null)) {
          this.ECp.ContentObj.Lpc.liveStatus = paramInt;
        }
        paramObject.setVisibility(8);
        localView.setVisibility(0);
        if (!TextUtils.isEmpty(this.ECt.coverUrl)) {
          paramObject = this.ECt.coverUrl;
        }
      }
    }
    for (;;)
    {
      ((aj)g.ah(aj.class)).getFinderUtilApi().g(localImageView, paramObject);
      AppMethodBeat.o(203526);
      return;
      if (!TextUtils.isEmpty(this.ECt.headUrl))
      {
        paramObject = this.ECt.headUrl;
        continue;
        if (paramInt == 1)
        {
          if ((this.ECp.ContentObj != null) && (this.ECp.ContentObj.Lpc != null)) {
            this.ECp.ContentObj.Lpc.liveStatus = paramInt;
          }
          paramObject.setVisibility(0);
          localView.setVisibility(8);
        }
        AppMethodBeat.o(203526);
      }
      else
      {
        paramObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.31
 * JD-Core Version:    0.7.0.1
 */