package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements h.b
{
  public static Map<String, View> nuD = new HashMap();
  private View.OnClickListener kdc = new c.1(this);
  private h.a ntP;
  
  public c(h.a parama)
  {
    this.ntP = parama;
  }
  
  public final void a(View paramView, int paramInt, b paramb)
  {
    paramView.setTag(paramb);
    paramView.setOnClickListener(this.kdc);
    com.tencent.mm.plugin.sight.decode.a.a locala = (com.tencent.mm.plugin.sight.decode.a.a)paramView.findViewById(R.h.image);
    ImageView localImageView = (ImageView)paramView.findViewById(R.h.status_btn);
    MMPinProgressBtn localMMPinProgressBtn = (MMPinProgressBtn)paramView.findViewById(R.h.progress);
    locala.setPosition(paramInt);
    com.tencent.mm.plugin.record.ui.a.c localc1 = (com.tencent.mm.plugin.record.ui.a.c)paramb;
    paramb = this.ntP;
    Map localMap = nuD;
    h.a.c localc = new h.a.c();
    localc.bNt = localc1.bNt;
    if (localc1.aYU == 0)
    {
      localc.ntR = localc1.bIt;
      if (h.d(localc1.bNt, localc1.bIt))
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView = h.c(localc1.bNt, localc1.bIt);
        if (!paramView.equals(locala.getVideoPath())) {
          locala.setThumbBmp(paramb.a(localc));
        }
        locala.aW(paramView, false);
      }
    }
    while (localc1.aYU != 1)
    {
      return;
      paramView = h.h(localc1.bNt.kgC, localc1.bIt, true);
      paramView = n.getRecordMsgCDNStorage().LG(paramView);
      if ((paramView == null) || (2 == paramView.field_status)) {
        localImageView.setImageResource(R.k.shortvideo_play_btn);
      }
      for (;;)
      {
        localImageView.setVisibility(0);
        localMMPinProgressBtn.setVisibility(8);
        locala.clear();
        locala.setThumbBmp(paramb.a(localc));
        return;
        if ((3 == paramView.field_status) || (4 == paramView.field_status))
        {
          localImageView.setImageResource(R.g.sight_chat_error);
        }
        else
        {
          if ((paramView.field_status == 0) || (1 == paramView.field_status))
          {
            localImageView.setVisibility(8);
            localMMPinProgressBtn.setVisibility(0);
            localMMPinProgressBtn.setProgress((int)(paramView.field_offset / Math.max(1, paramView.field_totalLen) * 100.0F));
            locala.clear();
            locala.setThumbBmp(paramb.a(localc));
            return;
          }
          localImageView.setImageResource(R.k.shortvideo_play_btn);
        }
      }
    }
    localMap.put(localc1.bNt.kgC, paramView);
    y.d("MicroMsg.SightRecordData", "dataId %s, status %s", new Object[] { Long.valueOf(localc1.khA.field_localId), Integer.valueOf(localc1.khA.field_itemStatus) });
    localc.ntR = localc1.khA.field_localId;
    paramView = new gf();
    paramView.bNF.type = 14;
    paramView.bNF.bNH = localc1.bNt;
    com.tencent.mm.sdk.b.a.udP.m(paramView);
    if ((localc1.khA.isDone()) || (paramView.bNG.ret == 1))
    {
      if (paramView.bNG.ret == 1)
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView.bNF.type = 2;
        com.tencent.mm.sdk.b.a.udP.m(paramView);
        paramView = paramView.bNG.path;
        if (bk.bl(paramView))
        {
          y.w("MicroMsg.SightRecordData", "videoPath is null!");
          return;
        }
        if (!paramView.equals(locala.getVideoPath())) {
          locala.setThumbBmp(paramb.a(localc));
        }
        locala.aW(paramView, false);
        return;
      }
      if (bk.bl(localc1.bNt.sUG)) {
        localImageView.setImageResource(R.g.sight_chat_error);
      }
    }
    for (;;)
    {
      localImageView.setVisibility(0);
      localMMPinProgressBtn.setVisibility(8);
      locala.clear();
      locala.setThumbBmp(paramb.a(localc));
      return;
      y.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
      localImageView.setImageResource(R.k.shortvideo_play_btn);
      continue;
      if ((localc1.khA.aQb()) || (localc1.khA.aQa()))
      {
        localImageView.setImageResource(R.k.shortvideo_play_btn);
      }
      else
      {
        if (localc1.khA.isDownloading())
        {
          localImageView.setVisibility(8);
          localMMPinProgressBtn.setVisibility(0);
          localMMPinProgressBtn.cJO();
          locala.clear();
          locala.setThumbBmp(paramb.a(localc));
          return;
        }
        y.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        localImageView.setImageResource(R.k.shortvideo_play_btn);
      }
    }
  }
  
  public final View dZ(Context paramContext)
  {
    View localView = View.inflate(paramContext, R.i.record_listitem_sight, null);
    ((com.tencent.mm.plugin.sight.decode.a.a)localView.findViewById(R.h.image)).setDrawableWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 260));
    return localView;
  }
  
  public final void destroy()
  {
    this.ntP = null;
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.c
 * JD-Core Version:    0.7.0.1
 */