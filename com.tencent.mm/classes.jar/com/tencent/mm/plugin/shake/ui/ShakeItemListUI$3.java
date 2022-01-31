package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class ShakeItemListUI$3
  implements AdapterView.OnItemClickListener
{
  ShakeItemListUI$3(ShakeItemListUI paramShakeItemListUI, int paramInt) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(24722);
    paramAdapterView = (com.tencent.mm.plugin.shake.b.d)ShakeItemListUI.b(this.qPL).getItem(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(24722);
      return;
    }
    paramView = m.cln();
    int i;
    if (paramAdapterView == null)
    {
      ab.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
      i = paramAdapterView.field_type;
      if (i != 4) {
        break label213;
      }
      paramView = new Intent();
      if (!com.tencent.mm.aw.d.aiG()) {
        break label180;
      }
      com.tencent.mm.aw.a.b(i.d(paramAdapterView.field_lvbuffer, 0L));
    }
    for (;;)
    {
      paramView.putExtra("key_scene", 3);
      com.tencent.mm.bq.d.b(this.qPL, "music", ".ui.MusicMainUI", paramView);
      AppMethodBeat.o(24722);
      return;
      paramAdapterView.field_insertBatch = 1;
      paramAdapterView.bsY = 1024;
      if (-1 == paramView.db.update("shakeitem1", paramAdapterView.convertTo(), "shakeItemID=? and insertBatch=?", new String[] { paramAdapterView.field_shakeItemID, "2" })) {
        break;
      }
      paramView.doNotify();
      break;
      label180:
      com.tencent.mm.aw.a.aiu();
      paramView.putExtra("key_mode", 1);
      paramView.putExtra("KGlobalShakeMusic", true);
      com.tencent.mm.aw.a.c(i.d(paramAdapterView.field_lvbuffer, 0L));
    }
    label213:
    if (i == 11)
    {
      if (System.currentTimeMillis() - this.qPL.qPI > 2000L)
      {
        this.qPL.qPI = System.currentTimeMillis();
        if ((paramAdapterView.field_reserved3 == null) || (paramAdapterView.field_reserved3.split(",").length != 3) || (paramAdapterView.field_reserved3.split(",")[0] == null) || (paramAdapterView.field_reserved3.split(",")[0].equals(""))) {
          break label407;
        }
        paramView = paramAdapterView.field_reserved3.split(",");
        localObject = new so();
        ((so)localObject).cIQ.userName = paramView[0];
        ((so)localObject).cIQ.cIS = bo.bf(paramView[1], "");
        ((so)localObject).cIQ.cIT = Integer.parseInt(paramView[2]);
        ((so)localObject).cIQ.scene = 1077;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      }
      for (;;)
      {
        if (ShakeItemListUI.d(this.qPL))
        {
          com.tencent.mm.plugin.shake.d.a.h.a(paramAdapterView);
          com.tencent.mm.plugin.shake.d.a.h.b(paramAdapterView);
        }
        AppMethodBeat.o(24722);
        return;
        paramView = new Intent();
        paramView.putExtra("rawUrl", paramAdapterView.getCity());
        paramView.putExtra("scene", 27);
        paramView.putExtra("stastic_scene", 5);
        com.tencent.mm.bq.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      }
    }
    label407:
    if (k.Do(i))
    {
      k.a(paramAdapterView, this.qPL, true);
      AppMethodBeat.o(24722);
      return;
    }
    paramView = paramAdapterView.field_username;
    aw.aaz();
    Object localObject = c.YA().arw(paramView);
    ab.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramView + " display:" + paramAdapterView.field_nickname + " position:" + paramInt + " contactName" + ((aq)localObject).field_username);
    ab.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.n.a.je(((aq)localObject).field_type) + "  contact:" + localObject);
    if (com.tencent.mm.n.a.je(((aq)localObject).field_type))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramView);
      if (this.qPN == paramAdapterView.field_sex) {}
      for (paramInt = 23;; paramInt = 24)
      {
        localIntent.putExtra("Contact_Scene", paramInt);
        localIntent.putExtra("Sns_from_Scene", 22);
        if ((paramView != null) && (paramView.length() > 0))
        {
          if (((ad)localObject).dwz())
          {
            com.tencent.mm.plugin.report.service.h.qsU.kvStat(10298, paramAdapterView.field_username + "," + localIntent.getIntExtra("Contact_Scene", 23));
            localIntent.putExtra("Contact_Scene", 23);
          }
          com.tencent.mm.plugin.shake.a.gmO.c(localIntent, this.qPL);
        }
        AppMethodBeat.o(24722);
        return;
      }
    }
    ab.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramView + " display:" + paramAdapterView.field_nickname + " position:" + paramInt + " contactName" + ((aq)localObject).field_username);
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramAdapterView.field_username);
    paramView.putExtra("Contact_Nick", paramAdapterView.field_nickname);
    paramView.putExtra("Contact_Distance", paramAdapterView.field_distance);
    paramView.putExtra("Contact_Signature", paramAdapterView.field_signature);
    paramView.putExtra("Contact_Province", paramAdapterView.getProvince());
    paramView.putExtra("Contact_City", paramAdapterView.getCity());
    paramView.putExtra("Contact_Sex", paramAdapterView.field_sex);
    paramView.putExtra("Contact_IsLBSFriend", true);
    paramView.putExtra("Contact_VUser_Info", paramAdapterView.field_reserved3);
    paramView.putExtra("Contact_VUser_Info_Flag", paramAdapterView.field_reserved1);
    if (this.qPN == paramAdapterView.field_sex) {}
    for (paramInt = 23;; paramInt = 24)
    {
      paramView.putExtra("Contact_Scene", paramInt);
      paramView.putExtra("Sns_from_Scene", 22);
      paramView.putExtra("Contact_KSnsIFlag", paramAdapterView.field_snsFlag);
      paramView.putExtra("Contact_KSnsBgUrl", paramAdapterView.field_sns_bgurl);
      if ((paramAdapterView.field_reserved1 & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10298, paramAdapterView.field_username + "," + paramView.getIntExtra("Contact_Scene", 23));
      }
      com.tencent.mm.plugin.shake.a.gmO.c(paramView, this.qPL);
      AppMethodBeat.o(24722);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.3
 * JD-Core Version:    0.7.0.1
 */