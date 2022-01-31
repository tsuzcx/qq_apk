package com.tencent.mm.plugin.sns.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.storage.az;
import java.util.LinkedList;

final class SnsTimeLineUI$60
  implements Runnable
{
  SnsTimeLineUI$60(SnsTimeLineUI paramSnsTimeLineUI, LayoutInflater paramLayoutInflater, TimeLineObject paramTimeLineObject, n paramn, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(145620);
    View localView = this.kBo.inflate(2130970828, SnsTimeLineUI.F(this.rYv), false);
    SnsTimeLineUI.F(this.rYv).addView(localView);
    if (SnsTimeLineUI.F(this.rYv).getChildCount() > 0) {
      SnsTimeLineUI.F(this.rYv).setVisibility(0);
    }
    Object localObject = (ImageView)localView.findViewById(2131827996);
    TextView localTextView = (TextView)localView.findViewById(2131827997);
    if (localTextView == null)
    {
      AppMethodBeat.o(145620);
      return;
    }
    if (this.rPB.xTS.wOa.size() > 0)
    {
      bcs localbcs = (bcs)this.rPB.xTS.wOa.get(0);
      g localg = ag.cpc();
      int i = this.rYv.hashCode();
      az localaz = az.dxB();
      localaz.oLs = this.rPB.CreateTime;
      localg.b(localbcs, (View)localObject, i, localaz);
    }
    if (this.rPB.xTS.wNZ == 1)
    {
      localTextView.setText(2131303921);
      localObject = this.rYv.getString(2131303922);
    }
    for (;;)
    {
      localView.setOnClickListener(new SnsTimeLineUI.60.1(this, (String)localObject));
      AppMethodBeat.o(145620);
      return;
      if (this.rPB.xTS.wNZ == 15)
      {
        localTextView.setText(2131303959);
        localObject = this.rYv.getString(2131303960);
      }
      else
      {
        localObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.60
 * JD-Core Version:    0.7.0.1
 */