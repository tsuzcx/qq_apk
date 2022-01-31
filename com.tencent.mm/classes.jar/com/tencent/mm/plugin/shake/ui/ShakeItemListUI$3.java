package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class ShakeItemListUI$3
  implements AdapterView.OnItemClickListener
{
  ShakeItemListUI$3(ShakeItemListUI paramShakeItemListUI, int paramInt) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (com.tencent.mm.plugin.shake.b.d)ShakeItemListUI.b(this.obE).getItem(paramInt);
    if (paramAdapterView == null) {}
    int i;
    for (;;)
    {
      return;
      paramView = com.tencent.mm.plugin.shake.b.m.bzU();
      if (paramAdapterView == null)
      {
        y.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
        i = paramAdapterView.field_type;
        if (i != 4) {
          break label195;
        }
        paramView = new Intent();
        if (!com.tencent.mm.av.d.PD()) {
          break label162;
        }
        com.tencent.mm.av.a.b(i.d(paramAdapterView.field_lvbuffer, 0L));
      }
      for (;;)
      {
        paramView.putExtra("key_scene", 3);
        com.tencent.mm.br.d.b(this.obE, "music", ".ui.MusicMainUI", paramView);
        return;
        paramAdapterView.field_insertBatch = 1;
        paramAdapterView.bcw = 1024;
        if (-1 == paramView.dXw.update("shakeitem1", paramAdapterView.vf(), "shakeItemID=? and insertBatch=?", new String[] { paramAdapterView.field_shakeItemID, "2" })) {
          break;
        }
        paramView.doNotify();
        break;
        label162:
        com.tencent.mm.av.a.Ps();
        paramView.putExtra("key_mode", 1);
        paramView.putExtra("KGlobalShakeMusic", true);
        com.tencent.mm.av.a.c(i.d(paramAdapterView.field_lvbuffer, 0L));
      }
      label195:
      if (i != 11) {
        break;
      }
      if (System.currentTimeMillis() - this.obE.obB > 2000L)
      {
        this.obE.obB = System.currentTimeMillis();
        if ((paramAdapterView.field_reserved3 != null) && (paramAdapterView.field_reserved3.split(",").length == 3) && (paramAdapterView.field_reserved3.split(",")[0] != null) && (!paramAdapterView.field_reserved3.split(",")[0].equals("")))
        {
          paramView = paramAdapterView.field_reserved3.split(",");
          localObject = new rc();
          ((rc)localObject).caq.userName = paramView[0];
          ((rc)localObject).caq.cas = bk.aM(paramView[1], "");
          ((rc)localObject).caq.cat = Integer.parseInt(paramView[2]);
          ((rc)localObject).caq.scene = 1077;
          com.tencent.mm.sdk.b.a.udP.m((b)localObject);
        }
        while (ShakeItemListUI.d(this.obE))
        {
          com.tencent.mm.plugin.shake.d.a.h.a(paramAdapterView);
          com.tencent.mm.plugin.shake.d.a.h.b(paramAdapterView);
          return;
          paramView = new Intent();
          paramView.putExtra("rawUrl", paramAdapterView.getCity());
          paramView.putExtra("scene", 27);
          paramView.putExtra("stastic_scene", 5);
          com.tencent.mm.br.d.b(ae.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
    if (k.xo(i))
    {
      k.a(paramAdapterView, this.obE, true);
      return;
    }
    paramView = paramAdapterView.field_username;
    au.Hx();
    Object localObject = c.Fw().abl(paramView);
    y.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramView + " display:" + paramAdapterView.field_nickname + " position:" + paramInt + " contactName" + ((ao)localObject).field_username);
    y.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.n.a.gR(((ao)localObject).field_type) + "  contact:" + localObject);
    if (com.tencent.mm.n.a.gR(((ao)localObject).field_type))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramView);
      if (this.obG == paramAdapterView.field_sex) {}
      for (paramInt = 23;; paramInt = 24)
      {
        localIntent.putExtra("Contact_Scene", paramInt);
        localIntent.putExtra("Sns_from_Scene", 22);
        if ((paramView == null) || (paramView.length() <= 0)) {
          break;
        }
        if (((ad)localObject).cua())
        {
          com.tencent.mm.plugin.report.service.h.nFQ.aC(10298, paramAdapterView.field_username + "," + localIntent.getIntExtra("Contact_Scene", 23));
          localIntent.putExtra("Contact_Scene", 23);
        }
        com.tencent.mm.plugin.shake.a.eUR.d(localIntent, this.obE);
        return;
      }
    }
    y.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramView + " display:" + paramAdapterView.field_nickname + " position:" + paramInt + " contactName" + ((ao)localObject).field_username);
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
    if (this.obG == paramAdapterView.field_sex) {}
    for (paramInt = 23;; paramInt = 24)
    {
      paramView.putExtra("Contact_Scene", paramInt);
      paramView.putExtra("Sns_from_Scene", 22);
      paramView.putExtra("Contact_KSnsIFlag", paramAdapterView.field_snsFlag);
      paramView.putExtra("Contact_KSnsBgUrl", paramAdapterView.field_sns_bgurl);
      if ((paramAdapterView.field_reserved1 & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.nFQ.aC(10298, paramAdapterView.field_username + "," + paramView.getIntExtra("Contact_Scene", 23));
      }
      com.tencent.mm.plugin.shake.a.eUR.d(paramView, this.obE);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.3
 * JD-Core Version:    0.7.0.1
 */