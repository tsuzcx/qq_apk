package com.tencent.mm.plugin.sns.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.storage.az;
import java.util.LinkedList;

final class SnsTimeLineUI$51
  implements Runnable
{
  SnsTimeLineUI$51(SnsTimeLineUI paramSnsTimeLineUI, LayoutInflater paramLayoutInflater, bxk parambxk, n paramn, long paramLong) {}
  
  public final void run()
  {
    View localView = this.iyh.inflate(i.g.sns_header_collapse_item, SnsTimeLineUI.y(this.pfC), false);
    SnsTimeLineUI.y(this.pfC).addView(localView);
    if (SnsTimeLineUI.y(this.pfC).getChildCount() > 0) {
      SnsTimeLineUI.y(this.pfC).setVisibility(0);
    }
    Object localObject = (ImageView)localView.findViewById(i.f.sns_notify_preview);
    TextView localTextView = (TextView)localView.findViewById(i.f.sns_notify_tips);
    if (this.oXd.tNr.sPJ.size() > 0)
    {
      awd localawd = (awd)this.oXd.tNr.sPJ.get(0);
      g localg = af.bDC();
      int i = this.pfC.hashCode();
      az localaz = az.cuY();
      localaz.time = this.oXd.mPL;
      localg.b(localawd, (View)localObject, i, localaz);
    }
    if (this.oXd.tNr.sPI == 1)
    {
      localTextView.setText(i.j.sns_photo_collapse);
      localObject = this.pfC.getString(i.j.sns_photo_collapse_hint);
    }
    for (;;)
    {
      localView.setOnClickListener(new SnsTimeLineUI.51.1(this, (String)localObject));
      return;
      if (this.oXd.tNr.sPI == 15)
      {
        localTextView.setText(i.j.sns_sight_collapse);
        localObject = this.pfC.getString(i.j.sns_sight_collapse_hint);
      }
      else
      {
        localObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.51
 * JD-Core Version:    0.7.0.1
 */