package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    com.tencent.mm.plugin.record.ui.a.b localb = (com.tencent.mm.plugin.record.ui.a.b)paramView.getTag();
    Object localObject;
    if (localb.aYU == 0) {
      if (com.tencent.mm.plugin.record.b.h.d(localb.bNt, localb.bIt))
      {
        y.i("MicroMsg.SightViewWrapper", "onclick: play sight");
        localObject = new Intent(paramView.getContext(), RecordMsgFileUI.class);
        ((Intent)localObject).putExtra("message_id", localb.bIt);
        ((Intent)localObject).putExtra("record_xml", localb.bWL);
        ((Intent)localObject).putExtra("record_data_id", localb.bNt.kgC);
        paramView.getContext().startActivity((Intent)localObject);
      }
    }
    label225:
    while (localb.aYU != 1)
    {
      f localf;
      do
      {
        return;
        localObject = com.tencent.mm.plugin.record.b.h.h(localb.bNt.kgC, localb.bIt, true);
        localf = n.getRecordMsgCDNStorage().LG((String)localObject);
        if (localf == null) {}
        for (localObject = "null";; localObject = Integer.valueOf(localf.field_status))
        {
          y.i("MicroMsg.SightViewWrapper", "onclick: cdnInfo status %s", new Object[] { localObject });
          if ((localf == null) || (2 == localf.field_status) || (3 == localf.field_status)) {
            break label225;
          }
          if (4 != localf.field_status) {
            break;
          }
          com.tencent.mm.ui.base.h.bC(paramView.getContext(), paramView.getResources().getString(R.l.favorite_record_video_error));
          return;
        }
      } while ((localf.field_status == 0) || (1 == localf.field_status));
      com.tencent.mm.plugin.record.b.h.b(localb.bNt, localb.bIt, true);
      return;
    }
    y.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(localb.khA.field_id), Long.valueOf(localb.khA.field_localId), Integer.valueOf(localb.khA.field_itemStatus) });
    if (localb.khA.isDone())
    {
      localObject = new gf();
      ((gf)localObject).bNF.type = 14;
      ((gf)localObject).bNF.bNH = localb.bNt;
      a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      y.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", new Object[] { Integer.valueOf(((gf)localObject).bNG.ret) });
      if (((gf)localObject).bNG.ret == 1)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_detail_info_id", localb.khA.field_localId);
        ((Intent)localObject).putExtra("key_detail_data_id", localb.bNt.kgC);
        ((Intent)localObject).putExtra("key_detail_can_delete", false);
        com.tencent.mm.plugin.fav.a.b.b(paramView.getContext(), ".ui.detail.FavoriteFileDetailUI", (Intent)localObject, 1);
        return;
      }
      if (bk.bl(localb.bNt.sUG))
      {
        y.w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
        return;
      }
      y.w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
    }
    for (;;)
    {
      paramView = new gf();
      paramView.bNF.bIr = localb.khA.field_localId;
      if (!localb.khA.aQa()) {
        break;
      }
      y.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
      paramView.bNF.type = 15;
      a.udP.m(paramView);
      return;
      if ((localb.khA.aQb()) || (localb.khA.aQa()))
      {
        y.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
      }
      else
      {
        if ((localb.khA.isDownloading()) || (localb.khA.aPZ()))
        {
          y.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
          return;
        }
        y.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
      }
    }
    y.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
    paramView.bNF.type = 16;
    a.udP.m(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.c.1
 * JD-Core Version:    0.7.0.1
 */