package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements h.b
{
  public static Map<String, View> xte;
  private View.OnClickListener cMV;
  private h.a xrU;
  
  static
  {
    AppMethodBeat.i(28032);
    xte = new HashMap();
    AppMethodBeat.o(28032);
  }
  
  public c(h.a parama)
  {
    AppMethodBeat.i(28029);
    this.cMV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28028);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        com.tencent.mm.plugin.record.ui.a.b localb = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        if (localb.dataType == 0) {
          if (p.d(localb.dsC, localb.msgId))
          {
            ad.i("MicroMsg.SightViewWrapper", "onclick: play sight");
            localObject = new Intent(paramAnonymousView.getContext(), RecordMsgFileUI.class);
            ((Intent)localObject).putExtra("message_id", localb.msgId);
            ((Intent)localObject).putExtra("record_xml", localb.dEP);
            ((Intent)localObject).putExtra("record_data_id", localb.dsC.dsU);
            paramAnonymousView = paramAnonymousView.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28028);
          return;
          localObject = p.g(localb.dsC.dsU, localb.msgId, true);
          j localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq((String)localObject);
          if (localj == null) {}
          for (localObject = "null";; localObject = Integer.valueOf(localj.field_status))
          {
            ad.i("MicroMsg.SightViewWrapper", "onclick: cdnInfo status %s", new Object[] { localObject });
            if ((localj == null) || (2 == localj.field_status) || (3 == localj.field_status)) {
              break label381;
            }
            if (4 != localj.field_status) {
              break;
            }
            h.cl(paramAnonymousView.getContext(), paramAnonymousView.getResources().getString(2131758978));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28028);
            return;
          }
          if ((localj.field_status == 0) || (1 == localj.field_status))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28028);
            return;
          }
          label381:
          p.b(localb.dsC, localb.msgId, true);
          continue;
          if (localb.dataType == 1)
          {
            ad.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(localb.prW.field_id), Long.valueOf(localb.prW.field_localId), Integer.valueOf(localb.prW.field_itemStatus) });
            if (localb.prW.isDone())
            {
              localObject = new gw();
              ((gw)localObject).dsV.type = 14;
              ((gw)localObject).dsV.dsX = localb.dsC;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
              ad.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", new Object[] { Integer.valueOf(((gw)localObject).dsW.ret) });
              if (((gw)localObject).dsW.ret == 1)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("key_detail_info_id", localb.prW.field_localId);
                ((Intent)localObject).putExtra("key_detail_data_id", localb.dsC.dsU);
                ((Intent)localObject).putExtra("key_detail_can_delete", false);
                com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.detail.FavoriteFileDetailUI", (Intent)localObject, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28028);
                return;
              }
              if (bt.isNullOrNil(localb.dsC.GgR))
              {
                ad.w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28028);
                return;
              }
              ad.w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
            }
            for (;;)
            {
              paramAnonymousView = new gw();
              paramAnonymousView.dsV.dnC = localb.prW.field_localId;
              if (!localb.prW.isUploadFailed()) {
                break label812;
              }
              ad.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
              paramAnonymousView.dsV.type = 15;
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
              break;
              if ((localb.prW.cuU()) || (localb.prW.isUploadFailed()))
              {
                ad.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
              }
              else
              {
                if ((localb.prW.isDownloading()) || (localb.prW.cuT()))
                {
                  ad.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(28028);
                  return;
                }
                ad.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
              }
            }
            label812:
            ad.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
            paramAnonymousView.dsV.type = 16;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
          }
        }
      }
    };
    this.xrU = parama;
    AppMethodBeat.o(28029);
  }
  
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(28031);
    paramView.setTag(paramb);
    paramView.setOnClickListener(this.cMV);
    paramObject = (com.tencent.mm.plugin.sight.decode.a.a)paramView.findViewById(2131300914);
    ImageView localImageView = (ImageView)paramView.findViewById(2131305196);
    MMPinProgressBtn localMMPinProgressBtn = (MMPinProgressBtn)paramView.findViewById(2131303515);
    paramObject.setPosition(paramInt);
    com.tencent.mm.plugin.record.ui.a.c localc1 = (com.tencent.mm.plugin.record.ui.a.c)paramb;
    paramb = this.xrU;
    Map localMap = xte;
    h.a.c localc = new h.a.c();
    localc.dsC = localc1.dsC;
    if (localc1.dataType == 0)
    {
      localc.xrW = localc1.msgId;
      if (p.d(localc1.dsC, localc1.msgId))
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView = p.c(localc1.dsC, localc1.msgId);
        if (!paramView.equals(paramObject.getVideoPath())) {
          paramObject.setThumbBmp(paramb.a(localc));
        }
        paramObject.e(paramView, false, 0);
        AppMethodBeat.o(28031);
        return;
      }
      paramView = p.g(localc1.dsC.dsU, localc1.msgId, true);
      paramView = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq(paramView);
      if ((paramView == null) || (2 == paramView.field_status)) {
        localImageView.setImageResource(2131691166);
      }
      for (;;)
      {
        localImageView.setVisibility(0);
        localMMPinProgressBtn.setVisibility(8);
        paramObject.clear();
        paramObject.setThumbBmp(paramb.a(localc));
        AppMethodBeat.o(28031);
        return;
        if ((3 == paramView.field_status) || (4 == paramView.field_status))
        {
          localImageView.setImageResource(2131234034);
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
            AppMethodBeat.o(28031);
            return;
          }
          localImageView.setImageResource(2131691166);
        }
      }
    }
    if (localc1.dataType == 1)
    {
      localMap.put(localc1.dsC.dsU, paramView);
      ad.d("MicroMsg.SightRecordData", "dataId %s, status %s", new Object[] { Long.valueOf(localc1.prW.field_localId), Integer.valueOf(localc1.prW.field_itemStatus) });
      localc.xrW = localc1.prW.field_localId;
      paramView = new gw();
      paramView.dsV.type = 14;
      paramView.dsV.dsX = localc1.dsC;
      com.tencent.mm.sdk.b.a.IbL.l(paramView);
      if ((!localc1.prW.isDone()) && (paramView.dsW.ret != 1)) {
        break label754;
      }
      if (paramView.dsW.ret == 1)
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView.dsV.type = 2;
        com.tencent.mm.sdk.b.a.IbL.l(paramView);
        paramView = paramView.dsW.path;
        if (bt.isNullOrNil(paramView))
        {
          ad.w("MicroMsg.SightRecordData", "videoPath is null!");
          AppMethodBeat.o(28031);
          return;
        }
        if (!paramView.equals(paramObject.getVideoPath())) {
          paramObject.setThumbBmp(paramb.a(localc));
        }
        paramObject.e(paramView, false, 0);
        AppMethodBeat.o(28031);
        return;
      }
      if (!bt.isNullOrNil(localc1.dsC.GgR)) {
        break label736;
      }
      localImageView.setImageResource(2131234034);
    }
    for (;;)
    {
      localImageView.setVisibility(0);
      localMMPinProgressBtn.setVisibility(8);
      paramObject.clear();
      paramObject.setThumbBmp(paramb.a(localc));
      AppMethodBeat.o(28031);
      return;
      label736:
      ad.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
      localImageView.setImageResource(2131691166);
      continue;
      label754:
      if ((localc1.prW.cuU()) || (localc1.prW.isUploadFailed()))
      {
        localImageView.setImageResource(2131691166);
      }
      else
      {
        if (localc1.prW.isDownloading())
        {
          localImageView.setVisibility(8);
          localMMPinProgressBtn.setVisibility(0);
          localMMPinProgressBtn.fLr();
          paramObject.clear();
          paramObject.setThumbBmp(paramb.a(localc));
          AppMethodBeat.o(28031);
          return;
        }
        ad.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        localImageView.setImageResource(2131691166);
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28030);
    View localView = View.inflate(paramContext, 2131495217, null);
    ((com.tencent.mm.plugin.sight.decode.a.a)localView.findViewById(2131300914)).setDrawableWidth(com.tencent.mm.cc.a.fromDPToPix(paramContext, 260));
    AppMethodBeat.o(28030);
    return localView;
  }
  
  public final void destroy()
  {
    this.xrU = null;
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.c
 * JD-Core Version:    0.7.0.1
 */