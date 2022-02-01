package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements h.b
{
  public static Map<String, View> wli;
  private View.OnClickListener cBW;
  private h.a wkd;
  
  static
  {
    AppMethodBeat.i(28032);
    wli = new HashMap();
    AppMethodBeat.o(28032);
  }
  
  public c(h.a parama)
  {
    AppMethodBeat.i(28029);
    this.cBW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28028);
        com.tencent.mm.plugin.record.ui.a.b localb = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        Object localObject;
        if (localb.dataType == 0)
        {
          if (n.d(localb.dhe, localb.msgId))
          {
            ac.i("MicroMsg.SightViewWrapper", "onclick: play sight");
            localObject = new Intent(paramAnonymousView.getContext(), RecordMsgFileUI.class);
            ((Intent)localObject).putExtra("message_id", localb.msgId);
            ((Intent)localObject).putExtra("record_xml", localb.dsP);
            ((Intent)localObject).putExtra("record_data_id", localb.dhe.dhw);
            paramAnonymousView = paramAnonymousView.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(28028);
            return;
          }
          localObject = n.h(localb.dhe.dhw, localb.msgId, true);
          i locali = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr((String)localObject);
          if (locali == null) {}
          for (localObject = "null";; localObject = Integer.valueOf(locali.field_status))
          {
            ac.i("MicroMsg.SightViewWrapper", "onclick: cdnInfo status %s", new Object[] { localObject });
            if ((locali == null) || (2 == locali.field_status) || (3 == locali.field_status)) {
              break label316;
            }
            if (4 != locali.field_status) {
              break;
            }
            h.cg(paramAnonymousView.getContext(), paramAnonymousView.getResources().getString(2131758978));
            AppMethodBeat.o(28028);
            return;
          }
          if ((locali.field_status == 0) || (1 == locali.field_status))
          {
            AppMethodBeat.o(28028);
            return;
          }
          label316:
          n.b(localb.dhe, localb.msgId, true);
          AppMethodBeat.o(28028);
          return;
        }
        if (localb.dataType == 1)
        {
          ac.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(localb.oOo.field_id), Long.valueOf(localb.oOo.field_localId), Integer.valueOf(localb.oOo.field_itemStatus) });
          if (localb.oOo.isDone())
          {
            localObject = new gt();
            ((gt)localObject).dhx.type = 14;
            ((gt)localObject).dhx.dhz = localb.dhe;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            ac.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", new Object[] { Integer.valueOf(((gt)localObject).dhy.ret) });
            if (((gt)localObject).dhy.ret == 1)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("key_detail_info_id", localb.oOo.field_localId);
              ((Intent)localObject).putExtra("key_detail_data_id", localb.dhe.dhw);
              ((Intent)localObject).putExtra("key_detail_can_delete", false);
              com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.detail.FavoriteFileDetailUI", (Intent)localObject, 1);
              AppMethodBeat.o(28028);
              return;
            }
            if (bs.isNullOrNil(localb.dhe.Ezf))
            {
              ac.w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
              AppMethodBeat.o(28028);
              return;
            }
            ac.w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
          }
          for (;;)
          {
            paramAnonymousView = new gt();
            paramAnonymousView.dhx.dcg = localb.oOo.field_localId;
            if (!localb.oOo.isUploadFailed()) {
              break;
            }
            ac.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
            paramAnonymousView.dhx.type = 15;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
            AppMethodBeat.o(28028);
            return;
            if ((localb.oOo.cpp()) || (localb.oOo.isUploadFailed()))
            {
              ac.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
            }
            else
            {
              if ((localb.oOo.isDownloading()) || (localb.oOo.cpo()))
              {
                ac.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                AppMethodBeat.o(28028);
                return;
              }
              ac.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
            }
          }
          ac.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
          paramAnonymousView.dhx.type = 16;
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
        }
        AppMethodBeat.o(28028);
      }
    };
    this.wkd = parama;
    AppMethodBeat.o(28029);
  }
  
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(28031);
    paramView.setTag(paramb);
    paramView.setOnClickListener(this.cBW);
    paramObject = (com.tencent.mm.plugin.sight.decode.a.a)paramView.findViewById(2131300914);
    ImageView localImageView = (ImageView)paramView.findViewById(2131305196);
    MMPinProgressBtn localMMPinProgressBtn = (MMPinProgressBtn)paramView.findViewById(2131303515);
    paramObject.setPosition(paramInt);
    com.tencent.mm.plugin.record.ui.a.c localc1 = (com.tencent.mm.plugin.record.ui.a.c)paramb;
    paramb = this.wkd;
    Map localMap = wli;
    h.a.c localc = new h.a.c();
    localc.dhe = localc1.dhe;
    if (localc1.dataType == 0)
    {
      localc.wkf = localc1.msgId;
      if (n.d(localc1.dhe, localc1.msgId))
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView = n.c(localc1.dhe, localc1.msgId);
        if (!paramView.equals(paramObject.getVideoPath())) {
          paramObject.setThumbBmp(paramb.a(localc));
        }
        paramObject.e(paramView, false, 0);
        AppMethodBeat.o(28031);
        return;
      }
      paramView = n.h(localc1.dhe.dhw, localc1.msgId, true);
      paramView = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr(paramView);
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
      localMap.put(localc1.dhe.dhw, paramView);
      ac.d("MicroMsg.SightRecordData", "dataId %s, status %s", new Object[] { Long.valueOf(localc1.oOo.field_localId), Integer.valueOf(localc1.oOo.field_itemStatus) });
      localc.wkf = localc1.oOo.field_localId;
      paramView = new gt();
      paramView.dhx.type = 14;
      paramView.dhx.dhz = localc1.dhe;
      com.tencent.mm.sdk.b.a.GpY.l(paramView);
      if ((!localc1.oOo.isDone()) && (paramView.dhy.ret != 1)) {
        break label754;
      }
      if (paramView.dhy.ret == 1)
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView.dhx.type = 2;
        com.tencent.mm.sdk.b.a.GpY.l(paramView);
        paramView = paramView.dhy.path;
        if (bs.isNullOrNil(paramView))
        {
          ac.w("MicroMsg.SightRecordData", "videoPath is null!");
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
      if (!bs.isNullOrNil(localc1.dhe.Ezf)) {
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
      ac.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
      localImageView.setImageResource(2131691166);
      continue;
      label754:
      if ((localc1.oOo.cpp()) || (localc1.oOo.isUploadFailed()))
      {
        localImageView.setImageResource(2131691166);
      }
      else
      {
        if (localc1.oOo.isDownloading())
        {
          localImageView.setVisibility(8);
          localMMPinProgressBtn.setVisibility(0);
          localMMPinProgressBtn.fuE();
          paramObject.clear();
          paramObject.setThumbBmp(paramb.a(localc));
          AppMethodBeat.o(28031);
          return;
        }
        ac.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
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
    this.wkd = null;
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.c
 * JD-Core Version:    0.7.0.1
 */