package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.a.f;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ib;
import com.tencent.mm.h.a.jd;
import com.tencent.mm.h.a.jd.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e;

final class ac$d
  extends c.a
{
  ImageView vBN;
  TextView vEC;
  LinearLayout vFd;
  TextView vFe;
  ProgressBar vFf;
  ImageView vFg;
  ProgressBar vFh;
  ImageView vFi;
  
  public static void a(d paramd, bi parambi, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.c.a parama, ac.c paramc, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramd == null) {
      return;
    }
    paramd.vFd.setVisibility(8);
    int i = com.tencent.mm.cb.a.fromDPToPix(parama.vtz.getContext(), 236);
    int j = com.tencent.mm.cb.a.fromDPToPix(parama.vtz.getContext(), 90);
    paramd.vFe.setMaxLines(1);
    paramd.vEC.setMaxLines(1);
    paramd.vEC.setText("");
    Object localObject2;
    ImageView localImageView;
    com.tencent.mm.as.g localg;
    int k;
    int m;
    if (d.SP("location"))
    {
      y.d("MicroMsg.LocationItemHolder", "plugin found!");
      localObject2 = new jd();
      ((jd)localObject2).bRx.bRs = 1;
      ((jd)localObject2).bRx.bFH = parambi;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject2);
      localObject1 = ((jd)localObject2).bRy.bOn;
      localObject2 = ((jd)localObject2).bRy.bRA;
      if (((localObject1 == null) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("")) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("err_not_started"))))
      {
        y.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
        paramd.vFh.setVisibility(8);
        paramd.vFd.setVisibility(0);
        paramd.vFe.setText(R.l.location_conversation);
        paramd.vEC.setText("");
        localImageView = paramd.vFg;
        localg = o.OJ();
        k = R.g.location_msg;
        m = R.g.map_bg_mask_normal;
        if (!paramBoolean) {
          break label654;
        }
      }
    }
    label654:
    for (Object localObject1 = "location_backgroup_key_from";; localObject1 = "location_backgroup_key_tor")
    {
      Bitmap localBitmap = (Bitmap)localg.enW.get(localObject1);
      if (localBitmap != null)
      {
        localObject2 = localBitmap;
        if (!localBitmap.isRecycled()) {}
      }
      else
      {
        localObject2 = c.C(k, m, i, j);
        localg.enW.f(localObject1, localObject2);
      }
      localImageView.setImageBitmap((Bitmap)localObject2);
      localObject1 = new ib();
      ((ib)localObject1).bQd.bFH = parambi;
      ((ib)localObject1).bQd.w = i;
      ((ib)localObject1).bQd.h = j;
      ((ib)localObject1).bQd.bQi = R.g.map_bg_mask_normal;
      ((ib)localObject1).bQd.bQf = paramd.vFg;
      ((ib)localObject1).bQd.bQh = paramd.vFf;
      ((ib)localObject1).bQd.bQg = paramd.vFi;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
      paramd.igg.setTag(new aw(parambi, parama.cFE(), paramInt, null, '\000'));
      paramd.igg.setOnClickListener(paramc);
      paramd.igg.setOnLongClickListener(paramOnLongClickListener);
      paramd.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
      return;
      paramd.vFh.setVisibility(8);
      paramd.vFd.setVisibility(0);
      y.d("MicroMsg.LocationItemHolder", "location info : " + (String)localObject1);
      if (b((String)localObject2, parama))
      {
        paramd.vFe.setVisibility(0);
        paramd.vFe.setText((CharSequence)localObject2);
        if ((localObject1 == null) || (((String)localObject1).equals("")))
        {
          paramd.vEC.setVisibility(8);
          break;
        }
        paramd.vEC.setVisibility(0);
        paramd.vEC.setText((CharSequence)localObject1);
        break;
      }
      paramd.vFe.setMaxLines(2);
      paramd.vFe.setText((CharSequence)localObject1);
      paramd.vEC.setVisibility(8);
      break;
      paramd.vFf.setVisibility(0);
      paramd.vFd.setVisibility(8);
      break;
    }
  }
  
  private static boolean b(String paramString, com.tencent.mm.ui.chatting.c.a parama)
  {
    return (paramString != null) && (!paramString.equals("")) && (!paramString.equals(parama.vtz.getMMResources().getString(R.l.location_selected)));
  }
  
  public final c.a s(View paramView, boolean paramBoolean)
  {
    super.dN(paramView);
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.vEC = ((TextView)paramView.findViewById(R.h.chatting_location_info));
    this.vFe = ((TextView)paramView.findViewById(R.h.chatting_location_title));
    this.vFd = ((LinearLayout)paramView.findViewById(R.h.chatting_location_panel));
    this.vFf = ((ProgressBar)paramView.findViewById(R.h.chatting_load_progress));
    this.igg = paramView.findViewById(R.h.chatting_click_area);
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    this.vFg = ((ImageView)paramView.findViewById(R.h.chatting_location_bg));
    this.vFh = ((ProgressBar)paramView.findViewById(R.h.chatting_location_address_progress));
    this.vFi = ((ImageView)paramView.findViewById(R.h.chatting_content_pin));
    if (!paramBoolean)
    {
      this.vBa = ((ImageView)paramView.findViewById(R.h.chatting_state_iv));
      this.vBN = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
    this.vFe.setTextSize(1, 16.0F);
    this.vEC.setTextSize(1, 12.0F);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.d
 * JD-Core Version:    0.7.0.1
 */