package com.tencent.mm.plugin.record.ui.viewWrappers;

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
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.model.q;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements h.b
{
  public static Map<String, View> NCP;
  private h.a NBA;
  private View.OnClickListener fhU;
  
  static
  {
    AppMethodBeat.i(28032);
    NCP = new HashMap();
    AppMethodBeat.o(28032);
  }
  
  public c(h.a parama)
  {
    AppMethodBeat.i(28029);
    this.fhU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28028);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        com.tencent.mm.plugin.record.ui.a.b localb = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        if (localb.dataType == 0) {
          if (q.d(localb.hIy, localb.msgId))
          {
            Log.i("MicroMsg.SightViewWrapper", "onclick: play sight");
            localObject = new Intent(paramAnonymousView.getContext(), RecordMsgFileUI.class);
            ((Intent)localObject).putExtra("message_id", localb.msgId);
            ((Intent)localObject).putExtra("record_xml", localb.hXv);
            ((Intent)localObject).putExtra("record_data_id", localb.hIy.hIQ);
            paramAnonymousView = paramAnonymousView.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28028);
          return;
          localObject = q.f(localb.hIy.hIQ, localb.msgId, true);
          j localj = ((com.tencent.mm.plugin.record.a.a)h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG((String)localObject);
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
            k.cZ(paramAnonymousView.getContext(), paramAnonymousView.getResources().getString(R.l.favorite_record_video_error));
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
          q.b(localb.hIy, localb.msgId, true);
          continue;
          if (localb.dataType == 1)
          {
            Log.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(localb.xvD.field_id), Long.valueOf(localb.xvD.field_localId), Integer.valueOf(localb.xvD.field_itemStatus) });
            if (localb.xvD.isDone())
            {
              localObject = new ht();
              ((ht)localObject).hIR.type = 14;
              ((ht)localObject).hIR.hIT = localb.hIy;
              ((ht)localObject).publish();
              Log.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", new Object[] { Integer.valueOf(((ht)localObject).hIS.ret) });
              if (((ht)localObject).hIS.ret == 1)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("key_detail_info_id", localb.xvD.field_localId);
                ((Intent)localObject).putExtra("key_detail_data_id", localb.hIy.hIQ);
                ((Intent)localObject).putExtra("key_detail_can_delete", false);
                com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.detail.FavoriteFileDetailUI", (Intent)localObject, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28028);
                return;
              }
              if (Util.isNullOrNil(localb.hIy.Ysw))
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
              paramAnonymousView = new ht();
              paramAnonymousView.hIR.hDn = localb.xvD.field_localId;
              if (!localb.xvD.dQp()) {
                break label807;
              }
              Log.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
              paramAnonymousView.hIR.type = 15;
              paramAnonymousView.publish();
              break;
              if ((localb.xvD.dQq()) || (localb.xvD.dQp()))
              {
                Log.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
              }
              else
              {
                if ((localb.xvD.isDownloading()) || (localb.xvD.dQo()))
                {
                  Log.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(28028);
                  return;
                }
                Log.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
              }
            }
            label807:
            Log.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
            paramAnonymousView.hIR.type = 16;
            paramAnonymousView.publish();
          }
        }
      }
    };
    this.NBA = parama;
    AppMethodBeat.o(28029);
  }
  
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(28031);
    paramView.setTag(paramb);
    paramView.setOnClickListener(this.fhU);
    paramObject = (com.tencent.mm.plugin.sight.decode.model.a)paramView.findViewById(R.h.image);
    ImageView localImageView = (ImageView)paramView.findViewById(R.h.status_btn);
    MMPinProgressBtn localMMPinProgressBtn = (MMPinProgressBtn)paramView.findViewById(R.h.progress);
    paramObject.setPosition(paramInt);
    com.tencent.mm.plugin.record.ui.a.c localc1 = (com.tencent.mm.plugin.record.ui.a.c)paramb;
    paramb = this.NBA;
    Map localMap = NCP;
    h.a.c localc = new h.a.c();
    localc.hIy = localc1.hIy;
    if (localc1.dataType == 0)
    {
      localc.NBD = localc1.msgId;
      if (q.d(localc1.hIy, localc1.msgId))
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView = q.c(localc1.hIy, localc1.msgId);
        if (!paramView.equals(paramObject.getVideoPath())) {
          paramObject.setThumbBmp(paramb.a(localc));
        }
        paramObject.e(paramView, false, 0);
        AppMethodBeat.o(28031);
        return;
      }
      paramView = q.f(localc1.hIy.hIQ, localc1.msgId, true);
      paramView = ((com.tencent.mm.plugin.record.a.a)h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG(paramView);
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
      localMap.put(localc1.hIy.hIQ, paramView);
      Log.d("MicroMsg.SightRecordData", "dataId %s, status %s", new Object[] { Long.valueOf(localc1.xvD.field_localId), Integer.valueOf(localc1.xvD.field_itemStatus) });
      localc.NBD = localc1.xvD.field_localId;
      paramView = new ht();
      paramView.hIR.type = 14;
      paramView.hIR.hIT = localc1.hIy;
      paramView.publish();
      if ((!localc1.xvD.isDone()) && (paramView.hIS.ret != 1)) {
        break label756;
      }
      if (paramView.hIS.ret == 1)
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView.hIR.type = 2;
        paramView.publish();
        paramView = paramView.hIS.path;
        if (Util.isNullOrNil(paramView))
        {
          Log.w("MicroMsg.SightRecordData", "videoPath is null!");
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
      if (!Util.isNullOrNil(localc1.hIy.Ysw)) {
        break label737;
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
      label737:
      Log.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
      localImageView.setImageResource(R.k.shortvideo_play_btn);
      continue;
      label756:
      if ((localc1.xvD.dQq()) || (localc1.xvD.dQp()))
      {
        localImageView.setImageResource(R.k.shortvideo_play_btn);
      }
      else
      {
        if (localc1.xvD.isDownloading())
        {
          localImageView.setVisibility(8);
          localMMPinProgressBtn.setVisibility(0);
          localMMPinProgressBtn.jEN();
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
    View localView = View.inflate(paramContext, R.i.gnu, null);
    ((com.tencent.mm.plugin.sight.decode.model.a)localView.findViewById(R.h.image)).setDrawableWidth(com.tencent.mm.cd.a.fromDPToPix(paramContext, 260));
    AppMethodBeat.o(28030);
    return localView;
  }
  
  public final void destroy()
  {
    this.NBA = null;
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.viewWrappers.c
 * JD-Core Version:    0.7.0.1
 */