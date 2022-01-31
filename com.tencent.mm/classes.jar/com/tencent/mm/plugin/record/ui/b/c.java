package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements h.b
{
  public static Map<String, View> qas;
  private View.OnClickListener bTw;
  private h.a pZw;
  
  static
  {
    AppMethodBeat.i(24366);
    qas = new HashMap();
    AppMethodBeat.o(24366);
  }
  
  public c(h.a parama)
  {
    AppMethodBeat.i(24363);
    this.bTw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24362);
        com.tencent.mm.plugin.record.ui.a.b localb = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        Object localObject;
        if (localb.dataType == 0)
        {
          if (n.d(localb.cuL, localb.cpO))
          {
            ab.i("MicroMsg.SightViewWrapper", "onclick: play sight");
            localObject = new Intent(paramAnonymousView.getContext(), RecordMsgFileUI.class);
            ((Intent)localObject).putExtra("message_id", localb.cpO);
            ((Intent)localObject).putExtra("record_xml", localb.cEB);
            ((Intent)localObject).putExtra("record_data_id", localb.cuL.mBq);
            paramAnonymousView.getContext().startActivity((Intent)localObject);
            AppMethodBeat.o(24362);
            return;
          }
          localObject = n.h(localb.cuL.mBq, localb.cpO, true);
          i locali = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR((String)localObject);
          if (locali == null) {}
          for (localObject = "null";; localObject = Integer.valueOf(locali.field_status))
          {
            ab.i("MicroMsg.SightViewWrapper", "onclick: cdnInfo status %s", new Object[] { localObject });
            if ((locali == null) || (2 == locali.field_status) || (3 == locali.field_status)) {
              break label259;
            }
            if (4 != locali.field_status) {
              break;
            }
            h.bO(paramAnonymousView.getContext(), paramAnonymousView.getResources().getString(2131299804));
            AppMethodBeat.o(24362);
            return;
          }
          if ((locali.field_status == 0) || (1 == locali.field_status))
          {
            AppMethodBeat.o(24362);
            return;
          }
          label259:
          n.b(localb.cuL, localb.cpO, true);
          AppMethodBeat.o(24362);
          return;
        }
        if (localb.dataType == 1)
        {
          ab.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(localb.mCk.field_id), Long.valueOf(localb.mCk.field_localId), Integer.valueOf(localb.mCk.field_itemStatus) });
          if (localb.mCk.isDone())
          {
            localObject = new gi();
            ((gi)localObject).cuX.type = 14;
            ((gi)localObject).cuX.cuZ = localb.cuL;
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
            ab.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", new Object[] { Integer.valueOf(((gi)localObject).cuY.ret) });
            if (((gi)localObject).cuY.ret == 1)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("key_detail_info_id", localb.mCk.field_localId);
              ((Intent)localObject).putExtra("key_detail_data_id", localb.cuL.mBq);
              ((Intent)localObject).putExtra("key_detail_can_delete", false);
              com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.detail.FavoriteFileDetailUI", (Intent)localObject, 1);
              AppMethodBeat.o(24362);
              return;
            }
            if (bo.isNullOrNil(localb.cuL.wSC))
            {
              ab.w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
              AppMethodBeat.o(24362);
              return;
            }
            ab.w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
          }
          for (;;)
          {
            paramAnonymousView = new gi();
            paramAnonymousView.cuX.cpM = localb.mCk.field_localId;
            if (!localb.mCk.bwp()) {
              break;
            }
            ab.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
            paramAnonymousView.cuX.type = 15;
            com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousView);
            AppMethodBeat.o(24362);
            return;
            if ((localb.mCk.bwq()) || (localb.mCk.bwp()))
            {
              ab.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
            }
            else
            {
              if ((localb.mCk.isDownloading()) || (localb.mCk.bwo()))
              {
                ab.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                AppMethodBeat.o(24362);
                return;
              }
              ab.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
            }
          }
          ab.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
          paramAnonymousView.cuX.type = 16;
          com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousView);
        }
        AppMethodBeat.o(24362);
      }
    };
    this.pZw = parama;
    AppMethodBeat.o(24363);
  }
  
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(153637);
    paramView.setTag(paramb);
    paramView.setOnClickListener(this.bTw);
    paramObject = (com.tencent.mm.plugin.sight.decode.a.a)paramView.findViewById(2131820629);
    ImageView localImageView = (ImageView)paramView.findViewById(2131820996);
    MMPinProgressBtn localMMPinProgressBtn = (MMPinProgressBtn)paramView.findViewById(2131821404);
    paramObject.setPosition(paramInt);
    com.tencent.mm.plugin.record.ui.a.c localc1 = (com.tencent.mm.plugin.record.ui.a.c)paramb;
    paramb = this.pZw;
    Map localMap = qas;
    h.a.c localc = new h.a.c();
    localc.cuL = localc1.cuL;
    if (localc1.dataType == 0)
    {
      localc.pZy = localc1.cpO;
      if (n.d(localc1.cuL, localc1.cpO))
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView = n.c(localc1.cuL, localc1.cpO);
        if (!paramView.equals(paramObject.getVideoPath())) {
          paramObject.setThumbBmp(paramb.a(localc));
        }
        paramObject.bl(paramView, false);
        AppMethodBeat.o(153637);
        return;
      }
      paramView = n.h(localc1.cuL.mBq, localc1.cpO, true);
      paramView = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR(paramView);
      if ((paramView == null) || (2 == paramView.field_status)) {
        localImageView.setImageResource(2131231980);
      }
      for (;;)
      {
        localImageView.setVisibility(0);
        localMMPinProgressBtn.setVisibility(8);
        paramObject.clear();
        paramObject.setThumbBmp(paramb.a(localc));
        AppMethodBeat.o(153637);
        return;
        if ((3 == paramView.field_status) || (4 == paramView.field_status))
        {
          localImageView.setImageResource(2130840321);
        }
        else
        {
          if ((paramView.field_status == 0) || (1 == paramView.field_status))
          {
            localImageView.setVisibility(8);
            localMMPinProgressBtn.setVisibility(0);
            localMMPinProgressBtn.setProgress((int)(paramView.field_offset / Math.max(1, paramView.field_totalLen) * 100.0F));
            paramObject.clear();
            paramObject.setThumbBmp(paramb.a(localc));
            AppMethodBeat.o(153637);
            return;
          }
          localImageView.setImageResource(2131231980);
        }
      }
    }
    if (localc1.dataType == 1)
    {
      localMap.put(localc1.cuL.mBq, paramView);
      ab.d("MicroMsg.SightRecordData", "dataId %s, status %s", new Object[] { Long.valueOf(localc1.mCk.field_localId), Integer.valueOf(localc1.mCk.field_itemStatus) });
      localc.pZy = localc1.mCk.field_localId;
      paramView = new gi();
      paramView.cuX.type = 14;
      paramView.cuX.cuZ = localc1.cuL;
      com.tencent.mm.sdk.b.a.ymk.l(paramView);
      if ((!localc1.mCk.isDone()) && (paramView.cuY.ret != 1)) {
        break label745;
      }
      if (paramView.cuY.ret == 1)
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView.cuX.type = 2;
        com.tencent.mm.sdk.b.a.ymk.l(paramView);
        paramView = paramView.cuY.path;
        if (bo.isNullOrNil(paramView))
        {
          ab.w("MicroMsg.SightRecordData", "videoPath is null!");
          AppMethodBeat.o(153637);
          return;
        }
        if (!paramView.equals(paramObject.getVideoPath())) {
          paramObject.setThumbBmp(paramb.a(localc));
        }
        paramObject.bl(paramView, false);
        AppMethodBeat.o(153637);
        return;
      }
      if (!bo.isNullOrNil(localc1.cuL.wSC)) {
        break label727;
      }
      localImageView.setImageResource(2130840321);
    }
    for (;;)
    {
      localImageView.setVisibility(0);
      localMMPinProgressBtn.setVisibility(8);
      paramObject.clear();
      paramObject.setThumbBmp(paramb.a(localc));
      AppMethodBeat.o(153637);
      return;
      label727:
      ab.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
      localImageView.setImageResource(2131231980);
      continue;
      label745:
      if ((localc1.mCk.bwq()) || (localc1.mCk.bwp()))
      {
        localImageView.setImageResource(2131231980);
      }
      else
      {
        if (localc1.mCk.isDownloading())
        {
          localImageView.setVisibility(8);
          localMMPinProgressBtn.setVisibility(0);
          localMMPinProgressBtn.dOF();
          paramObject.clear();
          paramObject.setThumbBmp(paramb.a(localc));
          AppMethodBeat.o(153637);
          return;
        }
        ab.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        localImageView.setImageResource(2131231980);
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(24364);
    View localView = View.inflate(paramContext, 2130970542, null);
    ((com.tencent.mm.plugin.sight.decode.a.a)localView.findViewById(2131820629)).setDrawableWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 260));
    AppMethodBeat.o(24364);
    return localView;
  }
  
  public final void destroy()
  {
    this.pZw = null;
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.c
 * JD-Core Version:    0.7.0.1
 */