package com.tencent.mm.plugin.sns.ui.c;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a
{
  public final void a(a.c paramc, int paramInt1, ax paramax, bxk parambxk, int paramInt2, au paramau)
  {
    paramc.pmL.setPosition(paramInt1);
    Object localObject2 = paramax.oOM;
    paramInt2 = parambxk.tNr.sPJ.size();
    if (paramInt2 > 0)
    {
      paramax = (awd)parambxk.tNr.sPJ.get(0);
      switch (parambxk.tNr.sPI)
      {
      }
    }
    for (;;)
    {
      paramau.iep.c(paramc.pmL, paramau.ovx.poQ, paramau.ovx.poz);
      return;
      paramc.pmL.setOnClickListener(paramau.ovx.oPK);
      Object localObject1 = new ao();
      ((ao)localObject1).bMB = ((String)localObject2);
      ((ao)localObject1).index = 0;
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramc.pmL);
      ((ao)localObject1).oYz = ((List)localObject2);
      ((ao)localObject1).oVB = this.oVB;
      ((ao)localObject1).position = paramInt1;
      paramc.pmL.setTag(localObject1);
      paramc.pmL.setVisibility(0);
      localObject1 = af.bDC();
      localObject2 = paramc.pmL;
      paramInt1 = this.mActivity.hashCode();
      az localaz = az.cuY();
      localaz.time = parambxk.mPL;
      ((g)localObject1).b(paramax, (View)localObject2, paramInt1, localaz);
      paramc.oNr.setVisibility(8);
      paramc.eXr.setText(this.mActivity.getString(i.j.sns_photo_collapse_title, new Object[] { Integer.valueOf(paramInt2) }));
      paramc.eXr.setVisibility(0);
      continue;
      paramc.pmL.setTag(new q(parambxk, (String)localObject2));
      paramc.pmL.setOnClickListener(paramau.ovx.poX);
      paramc.oNr.setImageResource(i.i.sns_collapse_video_play);
      paramc.oNr.setVisibility(0);
      paramc.eXr.setVisibility(8);
      localObject1 = af.bDC();
      localObject2 = paramc.pmL;
      paramInt1 = this.mActivity.hashCode();
      localaz = az.cuY();
      localaz.time = parambxk.mPL;
      ((g)localObject1).b(paramax, (View)localObject2, paramInt1, localaz);
    }
  }
  
  public final void d(a.c paramc)
  {
    int i = af.bDN();
    if (paramc.pmI != null) {
      if (!paramc.pns)
      {
        paramc.pmI.setLayoutResource(i.g.sns_media_collapse_item);
        paramc.pnt = paramc.pmI.inflate();
      }
    }
    for (paramc.pns = true;; paramc.pns = true)
    {
      paramc.pmL = ((TagImageView)paramc.pnt.findViewById(i.f.content_preview));
      paramc.oNr = ((ImageView)paramc.pnt.findViewById(i.f.state));
      paramc.eXr = ((TextView)paramc.pnt.findViewById(i.f.content_hint));
      View localView = paramc.pnt;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localView.setLayoutParams(localLayoutParams);
      i.b(paramc.pmL, this.mActivity);
      return;
      paramc.pnt = paramc.kKz.findViewById(i.f.content_collapse_rl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.c
 * JD-Core Version:    0.7.0.1
 */