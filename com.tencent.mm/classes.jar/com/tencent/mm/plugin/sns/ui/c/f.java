package com.tencent.mm.plugin.sns.ui.c;

import android.app.Activity;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.av.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.az;
import java.util.LinkedList;

public final class f
  extends a
{
  public final void a(a.c paramc, int paramInt1, ax paramax, bxk parambxk, int paramInt2, au paramau)
  {
    String str = paramax.oOM;
    if (!parambxk.tNr.sPJ.isEmpty())
    {
      paramc.pmL.setPosition(paramInt1);
      paramc.pci.setVisibility(0);
      paramax = (awd)parambxk.tNr.sPJ.get(0);
      Object localObject1 = af.bDC();
      Object localObject2 = paramc.pmL;
      paramInt1 = i.i.app_attach_file_icon_music;
      paramInt2 = this.mActivity.hashCode();
      az localaz = az.cuY();
      localaz.time = parambxk.mPL;
      ((g)localObject1).a(paramax, (View)localObject2, paramInt1, paramInt2, localaz);
      paramc.oNr.setPressed(false);
      localObject1 = parambxk.lsK;
      if (com.tencent.mm.av.a.Pu())
      {
        localObject2 = com.tencent.mm.av.a.Pw();
        if ((localObject2 != null) && (com.tencent.mm.av.a.d((e)localObject2)) && (((String)localObject1).equals(((e)localObject2).eux)))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label343;
          }
          paramc.oNr.setImageResource(i.e.music_pauseicon);
          label172:
          paramc.pmL.setTag(new q(parambxk, str));
          paramc.pmL.setOnClickListener(paramau.oWp.pka);
          paramc.pci.setTag(new q(parambxk, str));
          paramau.iep.c(paramc.pci, paramau.ovx.poO, paramau.ovx.poz);
          paramc.pci.setOnClickListener(paramau.oWp.pbU);
          parambxk = paramax.kRN;
          if (bk.bl(parambxk)) {
            break label356;
          }
          paramc.pmM.setVisibility(0);
          paramc.pmM.setText(parambxk);
        }
      }
      for (;;)
      {
        paramax = paramax.bGw;
        if (bk.bl(paramax)) {
          break label367;
        }
        paramc.eXr.setVisibility(0);
        paramax = new SpannableString(paramax);
        paramc.eXr.setText(paramax, TextView.BufferType.SPANNABLE);
        return;
        paramInt1 = 0;
        break;
        label343:
        paramc.oNr.setImageResource(i.e.music_playicon);
        break label172;
        label356:
        paramc.pmM.setVisibility(4);
      }
      label367:
      paramc.eXr.setVisibility(8);
      return;
    }
    paramc.pci.setVisibility(8);
  }
  
  public final void d(a.c paramc)
  {
    if (paramc.pmI != null)
    {
      paramc.pmI.setLayoutResource(i.g.sns_media_sub_item2);
      paramc.pnr = ((ViewStub)paramc.kKz.findViewById(i.f.images_keeper_li));
      if ((!paramc.pns) && (paramc.pnr != null)) {
        paramc.pnt = paramc.pnr.inflate();
      }
    }
    for (paramc.pns = true;; paramc.pns = true)
    {
      paramc.pci = paramc.pnt;
      paramc.pci.findViewById(i.f.state).setOnTouchListener(this.owd.oPc);
      paramc.pmL = ((TagImageView)paramc.pci.findViewById(i.f.image_left));
      paramc.oNr = ((ImageView)paramc.pci.findViewById(i.f.state));
      paramc.pmM = ((TextView)paramc.pci.findViewById(i.f.righttext));
      paramc.eXr = ((TextView)paramc.pci.findViewById(i.f.titletext));
      paramc.eXr.setTextColor(this.mActivity.getResources().getColor(i.c.sns_link_color));
      paramc.eXr.setMaxLines(1);
      i.b(paramc.pmL, this.mActivity);
      return;
      paramc.pnt = paramc.kKz.findViewById(i.f.media_content_rl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.f
 * JD-Core Version:    0.7.0.1
 */