package com.tencent.mm.plugin.sns.f;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
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
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = (b.b)this.ovQ.ovI.get(Long.valueOf(this.ovO.eAA));
    int j = ((a)this.ovQ.ovL.owB.get(i)).ovr;
    if (paramView != null) {
      paramView.Of("3:" + j + ":" + this.dpT.getText());
    }
    if (((a)this.ovQ.ovL.owB.get(i)).ovv == 1)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this.ovQ.mContext, SnsCommentUI.class);
      localIntent.putExtra("sns_comment_type", 2);
      localIntent.putExtra("sns_id", this.ovO.eAA);
      localIntent.putExtra("sns_uxinfo", paramView.ovV);
      localIntent.putExtra("action_st_time", paramView.ovW);
      localIntent.putExtra("sns_actionresult", paramView.ovU.toString());
      ((MMActivity)this.ovQ.mContext).startActivity(localIntent);
      this.ovQ.ovI.remove(Long.valueOf(this.ovO.eAA));
      this.ovQ.bEx();
      return;
    }
    this.ovQ.a(paramView);
    this.ovQ.bEx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.b.3
 * JD-Core Version:    0.7.0.1
 */