package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements h.b
{
  public static Map<String, View> BJe;
  private h.a BHR;
  private View.OnClickListener dec;
  
  static
  {
    AppMethodBeat.i(28032);
    BJe = new HashMap();
    AppMethodBeat.o(28032);
  }
  
  public c(h.a parama)
  {
    AppMethodBeat.i(28029);
    this.dec = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28028);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        com.tencent.mm.plugin.record.ui.a.b localb = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        if (localb.dataType == 0) {
          if (p.d(localb.dKT, localb.msgId))
          {
            Log.i("MicroMsg.SightViewWrapper", "onclick: play sight");
            localObject = new Intent(paramAnonymousView.getContext(), RecordMsgFileUI.class);
            ((Intent)localObject).putExtra("message_id", localb.msgId);
            ((Intent)localObject).putExtra("record_xml", localb.dXH);
            ((Intent)localObject).putExtra("record_data_id", localb.dKT.dLl);
            paramAnonymousView = paramAnonymousView.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28028);
          return;
          localObject = p.g(localb.dKT.dLl, localb.msgId, true);
          j localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX((String)localObject);
          if (localj == null) {}
          for (localObject = "null";; localObject = Integer.valueOf(localj.field_status))
          {
            Log.i("MicroMsg.SightViewWrapper", "onclick: cdnInfo status %s", new Object[] { localObject });
            if ((localj == null) || (2 == localj.field_status) || (3 == localj.field_status)) {
              break label381;
            }
            if (4 != localj.field_status) {
              break;
            }
            h.cD(paramAnonymousView.getContext(), paramAnonymousView.getResources().getString(2131759303));
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
          p.b(localb.dKT, localb.msgId, true);
          continue;
          if (localb.dataType == 1)
          {
            Log.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(localb.qNT.field_id), Long.valueOf(localb.qNT.field_localId), Integer.valueOf(localb.qNT.field_itemStatus) });
            if (localb.qNT.isDone())
            {
              localObject = new hb();
              ((hb)localObject).dLm.type = 14;
              ((hb)localObject).dLm.dLo = localb.dKT;
              EventCenter.instance.publish((IEvent)localObject);
              Log.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", new Object[] { Integer.valueOf(((hb)localObject).dLn.ret) });
              if (((hb)localObject).dLn.ret == 1)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("key_detail_info_id", localb.qNT.field_localId);
                ((Intent)localObject).putExtra("key_detail_data_id", localb.dKT.dLl);
                ((Intent)localObject).putExtra("key_detail_can_delete", false);
                com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.detail.FavoriteFileDetailUI", (Intent)localObject, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28028);
                return;
              }
              if (Util.isNullOrNil(localb.dKT.KuR))
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
              paramAnonymousView = new hb();
              paramAnonymousView.dLm.dFW = localb.qNT.field_localId;
              if (!localb.qNT.cUy()) {
                break label812;
              }
              Log.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
              paramAnonymousView.dLm.type = 15;
              EventCenter.instance.publish(paramAnonymousView);
              break;
              if ((localb.qNT.cUz()) || (localb.qNT.cUy()))
              {
                Log.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
              }
              else
              {
                if ((localb.qNT.isDownloading()) || (localb.qNT.cUx()))
                {
                  Log.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(28028);
                  return;
                }
                Log.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
              }
            }
            label812:
            Log.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
            paramAnonymousView.dLm.type = 16;
            EventCenter.instance.publish(paramAnonymousView);
          }
        }
      }
    };
    this.BHR = parama;
    AppMethodBeat.o(28029);
  }
  
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(28031);
    paramView.setTag(paramb);
    paramView.setOnClickListener(this.dec);
    paramObject = (com.tencent.mm.plugin.sight.decode.a.a)paramView.findViewById(2131302526);
    ImageView localImageView = (ImageView)paramView.findViewById(2131308392);
    MMPinProgressBtn localMMPinProgressBtn = (MMPinProgressBtn)paramView.findViewById(2131306281);
    paramObject.setPosition(paramInt);
    com.tencent.mm.plugin.record.ui.a.c localc1 = (com.tencent.mm.plugin.record.ui.a.c)paramb;
    paramb = this.BHR;
    Map localMap = BJe;
    h.a.c localc = new h.a.c();
    localc.dKT = localc1.dKT;
    if (localc1.dataType == 0)
    {
      localc.BHU = localc1.msgId;
      if (p.d(localc1.dKT, localc1.msgId))
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView = p.c(localc1.dKT, localc1.msgId);
        if (!paramView.equals(paramObject.getVideoPath())) {
          paramObject.setThumbBmp(paramb.a(localc));
        }
        paramObject.e(paramView, false, 0);
        AppMethodBeat.o(28031);
        return;
      }
      paramView = p.g(localc1.dKT.dLl, localc1.msgId, true);
      paramView = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(paramView);
      if ((paramView == null) || (2 == paramView.field_status)) {
        localImageView.setImageResource(2131691480);
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
          localImageView.setImageResource(2131234876);
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
          localImageView.setImageResource(2131691480);
        }
      }
    }
    if (localc1.dataType == 1)
    {
      localMap.put(localc1.dKT.dLl, paramView);
      Log.d("MicroMsg.SightRecordData", "dataId %s, status %s", new Object[] { Long.valueOf(localc1.qNT.field_localId), Integer.valueOf(localc1.qNT.field_itemStatus) });
      localc.BHU = localc1.qNT.field_localId;
      paramView = new hb();
      paramView.dLm.type = 14;
      paramView.dLm.dLo = localc1.dKT;
      EventCenter.instance.publish(paramView);
      if ((!localc1.qNT.isDone()) && (paramView.dLn.ret != 1)) {
        break label754;
      }
      if (paramView.dLn.ret == 1)
      {
        localImageView.setVisibility(8);
        localMMPinProgressBtn.setVisibility(8);
        paramView.dLm.type = 2;
        EventCenter.instance.publish(paramView);
        paramView = paramView.dLn.path;
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
      if (!Util.isNullOrNil(localc1.dKT.KuR)) {
        break label736;
      }
      localImageView.setImageResource(2131234876);
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
      Log.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
      localImageView.setImageResource(2131691480);
      continue;
      label754:
      if ((localc1.qNT.cUz()) || (localc1.qNT.cUy()))
      {
        localImageView.setImageResource(2131691480);
      }
      else
      {
        if (localc1.qNT.isDownloading())
        {
          localImageView.setVisibility(8);
          localMMPinProgressBtn.setVisibility(0);
          localMMPinProgressBtn.gYN();
          paramObject.clear();
          paramObject.setThumbBmp(paramb.a(localc));
          AppMethodBeat.o(28031);
          return;
        }
        Log.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        localImageView.setImageResource(2131691480);
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28030);
    View localView = View.inflate(paramContext, 2131496060, null);
    ((com.tencent.mm.plugin.sight.decode.a.a)localView.findViewById(2131302526)).setDrawableWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 260));
    AppMethodBeat.o(28030);
    return localView;
  }
  
  public final void destroy()
  {
    this.BHR = null;
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.c
 * JD-Core Version:    0.7.0.1
 */