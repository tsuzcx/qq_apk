package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements h.b
{
  public static Map<String, View> HFn;
  private h.a HDY;
  private View.OnClickListener dig;
  
  static
  {
    AppMethodBeat.i(28032);
    HFn = new HashMap();
    AppMethodBeat.o(28032);
  }
  
  public c(h.a parama)
  {
    AppMethodBeat.i(28029);
    this.dig = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28028);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        com.tencent.mm.plugin.record.ui.a.b localb = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        if (localb.dataType == 0) {
          if (p.d(localb.fDI, localb.msgId))
          {
            Log.i("MicroMsg.SightViewWrapper", "onclick: play sight");
            localObject = new Intent(paramAnonymousView.getContext(), RecordMsgFileUI.class);
            ((Intent)localObject).putExtra("message_id", localb.msgId);
            ((Intent)localObject).putExtra("record_xml", localb.fRy);
            ((Intent)localObject).putExtra("record_data_id", localb.fDI.fEa);
            paramAnonymousView = paramAnonymousView.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28028);
          return;
          localObject = p.f(localb.fDI.fEa, localb.msgId, true);
          j localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy((String)localObject);
          if (localj == null) {}
          for (localObject = "null";; localObject = Integer.valueOf(localj.field_status))
          {
            Log.i("MicroMsg.SightViewWrapper", "onclick: cdnInfo status %s", new Object[] { localObject });
            if ((localj == null) || (2 == localj.field_status) || (3 == localj.field_status)) {
              break label382;
            }
            if (4 != localj.field_status) {
              break;
            }
            com.tencent.mm.ui.base.h.cO(paramAnonymousView.getContext(), paramAnonymousView.getResources().getString(R.l.favorite_record_video_error));
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
          label382:
          p.b(localb.fDI, localb.msgId, true);
          continue;
          if (localb.dataType == 1)
          {
            Log.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(localb.upg.field_id), Long.valueOf(localb.upg.field_localId), Integer.valueOf(localb.upg.field_itemStatus) });
            if (localb.upg.isDone())
            {
              localObject = new hi();
              ((hi)localObject).fEb.type = 14;
              ((hi)localObject).fEb.fEd = localb.fDI;
              EventCenter.instance.publish((IEvent)localObject);
              Log.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", new Object[] { Integer.valueOf(((hi)localObject).fEc.ret) });
              if (((hi)localObject).fEc.ret == 1)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("key_detail_info_id", localb.upg.field_localId);
                ((Intent)localObject).putExtra("key_detail_data_id", localb.fDI.fEa);
                ((Intent)localObject).putExtra("key_detail_can_delete", false);
                com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.detail.FavoriteFileDetailUI", (Intent)localObject, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28028);
                return;
              }
              if (Util.isNullOrNil(localb.fDI.Rwb))
              {
                Log.w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28028);
                return;
              }
              Log.w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
            }
            for (;;)
            {
              paramAnonymousView = new hi();
              paramAnonymousView.fEb.fyE = localb.upg.field_localId;
              if (!localb.upg.djE()) {
                break label813;
              }
              Log.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
              paramAnonymousView.fEb.type = 15;
              EventCenter.instance.publish(paramAnonymousView);
              break;
              if ((localb.upg.djF()) || (localb.upg.djE()))
              {
                Log.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
              }
              else
              {
                if ((localb.upg.isDownloading()) || (localb.upg.djD()))
                {
                  Log.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(28028);
                  return;
                }
                Log.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
              }
            }
            label813:
            Log.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
            paramAnonymousView.fEb.type = 16;
            EventCenter.instance.publish(paramAnonymousView);
          }
        }
      }
    };
    this.HDY = parama;
    AppMethodBeat.o(28029);
  }
  
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(28031);
    paramView.setTag(paramb);
    paramView.setOnClickListener(this.dig);
    paramObject = (com.tencent.mm.plugin.sight.decode.a.a)paramView.findViewById(R.h.image);
    ImageView localImageView = (ImageView)paramView.findViewById(R.h.status_btn);
    MMPinProgressBtn localMMPinProgressBtn = (MMPinProgressBtn)paramView.findViewById(R.h.progress);
    paramObject.setPosition(paramInt);
    com.tencent.mm.plugin.record.ui.a.c localc1 = (com.tencent.mm.plugin.record.ui.a.c)paramb;
    paramb = this.HDY;
    Map localMap = HFn;
    h.a.c localc = new h.a.c();
    localc.fDI = localc1.fDI;
    if (localc1.dataType == 0)
    {
      localc.HEb = localc1.msgId;
      if (p.d(localc1.fDI, localc1.msgId))
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView = p.c(localc1.fDI, localc1.msgId);
        if (!paramView.equals(paramObject.getVideoPath())) {
          paramObject.setThumbBmp(paramb.a(localc));
        }
        paramObject.f(paramView, false, 0);
        AppMethodBeat.o(28031);
        return;
      }
      paramView = p.f(localc1.fDI.fEa, localc1.msgId, true);
      paramView = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy(paramView);
      if ((paramView == null) || (2 == paramView.field_status)) {
        localImageView.setImageResource(R.k.shortvideo_play_btn);
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
          localImageView.setImageResource(R.g.sight_chat_error);
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
          localImageView.setImageResource(R.k.shortvideo_play_btn);
        }
      }
    }
    if (localc1.dataType == 1)
    {
      localMap.put(localc1.fDI.fEa, paramView);
      Log.d("MicroMsg.SightRecordData", "dataId %s, status %s", new Object[] { Long.valueOf(localc1.upg.field_localId), Integer.valueOf(localc1.upg.field_itemStatus) });
      localc.HEb = localc1.upg.field_localId;
      paramView = new hi();
      paramView.fEb.type = 14;
      paramView.fEb.fEd = localc1.fDI;
      EventCenter.instance.publish(paramView);
      if ((!localc1.upg.isDone()) && (paramView.fEc.ret != 1)) {
        break label762;
      }
      if (paramView.fEc.ret == 1)
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView.fEb.type = 2;
        EventCenter.instance.publish(paramView);
        paramView = paramView.fEc.path;
        if (Util.isNullOrNil(paramView))
        {
          Log.w("MicroMsg.SightRecordData", "videoPath is null!");
          AppMethodBeat.o(28031);
          return;
        }
        if (!paramView.equals(paramObject.getVideoPath())) {
          paramObject.setThumbBmp(paramb.a(localc));
        }
        paramObject.f(paramView, false, 0);
        AppMethodBeat.o(28031);
        return;
      }
      if (!Util.isNullOrNil(localc1.fDI.Rwb)) {
        break label743;
      }
      localImageView.setImageResource(R.g.sight_chat_error);
    }
    for (;;)
    {
      localImageView.setVisibility(0);
      localMMPinProgressBtn.setVisibility(8);
      paramObject.clear();
      paramObject.setThumbBmp(paramb.a(localc));
      AppMethodBeat.o(28031);
      return;
      label743:
      Log.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
      localImageView.setImageResource(R.k.shortvideo_play_btn);
      continue;
      label762:
      if ((localc1.upg.djF()) || (localc1.upg.djE()))
      {
        localImageView.setImageResource(R.k.shortvideo_play_btn);
      }
      else
      {
        if (localc1.upg.isDownloading())
        {
          localImageView.setVisibility(8);
          localMMPinProgressBtn.setVisibility(0);
          localMMPinProgressBtn.hZF();
          paramObject.clear();
          paramObject.setThumbBmp(paramb.a(localc));
          AppMethodBeat.o(28031);
          return;
        }
        Log.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        localImageView.setImageResource(R.k.shortvideo_play_btn);
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28030);
    View localView = View.inflate(paramContext, R.i.ekp, null);
    ((com.tencent.mm.plugin.sight.decode.a.a)localView.findViewById(R.h.image)).setDrawableWidth(com.tencent.mm.ci.a.fromDPToPix(paramContext, 260));
    AppMethodBeat.o(28030);
    return localView;
  }
  
  public final void destroy()
  {
    this.HDY = null;
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.c
 * JD-Core Version:    0.7.0.1
 */