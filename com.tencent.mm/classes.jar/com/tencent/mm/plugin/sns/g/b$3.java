package com.tencent.mm.plugin.sns.g;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.ui.MMActivity;
import java.util.List;
import java.util.Map;

final class b$3
  implements View.OnClickListener
{
  b$3(b paramb, com.tencent.mm.plugin.sns.data.b paramb1, TextView paramTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36759);
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = (b.b)this.rkL.rkD.get(Long.valueOf(this.rkJ.cIo));
    int j = ((a)this.rkL.rkG.rlv.get(i)).rkm;
    if (paramView != null) {
      paramView.aaZ("3:" + j + ":" + this.ehq.getText());
    }
    if (((a)this.rkL.rkG.rlv.get(i)).rkq == 1)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this.rkL.mContext, SnsCommentUI.class);
      localIntent.putExtra("sns_comment_type", 2);
      localIntent.putExtra("sns_id", this.rkJ.cIo);
      localIntent.putExtra("sns_uxinfo", paramView.cFe);
      localIntent.putExtra("action_st_time", paramView.rkQ);
      localIntent.putExtra("sns_actionresult", paramView.rkP.toString());
      ((MMActivity)this.rkL.mContext).startActivity(localIntent);
      this.rkL.rkD.remove(Long.valueOf(this.rkJ.cIo));
      this.rkL.cpX();
      AppMethodBeat.o(36759);
      return;
    }
    this.rkL.a(paramView);
    this.rkL.cpX();
    AppMethodBeat.o(36759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.b.3
 * JD-Core Version:    0.7.0.1
 */