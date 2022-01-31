package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bob;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.util.LinkedList;

final class ContactSearchResultUI$2
  implements AdapterView.OnItemClickListener
{
  ContactSearchResultUI$2(ContactSearchResultUI paramContactSearchResultUI, int paramInt) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = paramInt - ContactSearchResultUI.a(this.pxL).getHeaderViewsCount();
    if ((i < 0) || (i >= ContactSearchResultUI.a(this.pxL).getCount())) {}
    ad localad;
    do
    {
      return;
      if (i >= ContactSearchResultUI.b(this.pxL).size())
      {
        paramAdapterView = (bob)ContactSearchResultUI.c(this.pxL).get(paramInt - ContactSearchResultUI.b(this.pxL).size());
        ContactSearchResultUI.a(this.pxL, paramAdapterView);
        return;
      }
      paramAdapterView = (bnk)ContactSearchResultUI.b(this.pxL).get(i);
      paramView = paramAdapterView.sQs.tFO;
      au.Hx();
      localad = c.Fw().abl(paramView);
      if (!a.gR(localad.field_type)) {
        break;
      }
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("Contact_User", paramView);
      paramAdapterView.putExtra("Contact_Scene", 3);
    } while ((paramView == null) || (paramView.length() <= 0));
    if (localad.cua())
    {
      h.nFQ.aC(10298, paramView + ",35");
      paramAdapterView.putExtra("Contact_Scene", 35);
    }
    d.b(this.pxL, "profile", ".ui.ContactInfoUI", paramAdapterView);
    return;
    if ((paramAdapterView.tpg & 0x8) > 0) {
      h.nFQ.aC(10298, paramAdapterView.sQs.tFO + ",35");
    }
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramAdapterView.sQs.tFO);
    paramView.putExtra("Contact_Alias", paramAdapterView.ffm);
    paramView.putExtra("Contact_Nick", paramAdapterView.tmw.tFO);
    paramView.putExtra("Contact_Signature", paramAdapterView.ffk);
    paramView.putExtra("Contact_RegionCode", RegionCodeDecoder.ao(paramAdapterView.ffq, paramAdapterView.ffi, paramAdapterView.ffj));
    paramView.putExtra("Contact_Sex", paramAdapterView.ffh);
    paramView.putExtra("Contact_VUser_Info", paramAdapterView.tph);
    paramView.putExtra("Contact_VUser_Info_Flag", paramAdapterView.tpg);
    paramView.putExtra("Contact_KWeibo_flag", paramAdapterView.tpk);
    paramView.putExtra("Contact_KWeibo", paramAdapterView.tpi);
    paramView.putExtra("Contact_KWeiboNick", paramAdapterView.tpj);
    paramView.putExtra("Contact_KSnsIFlag", paramAdapterView.tpm.ffs);
    paramView.putExtra("Contact_KSnsBgId", paramAdapterView.tpm.ffu);
    paramView.putExtra("Contact_KSnsBgUrl", paramAdapterView.tpm.fft);
    paramView.putExtra("Contact_Scene", 35);
    if (this.pxM != 0) {
      paramView.putExtra("add_more_friend_search_scene", this.pxM);
    }
    if (paramAdapterView.tpn != null) {}
    try
    {
      paramView.putExtra("Contact_customInfo", paramAdapterView.tpn.toByteArray());
      if ((paramAdapterView.tpg & 0x8) > 0) {
        h.nFQ.aC(10298, paramAdapterView.sQs.tFO + ",35");
      }
      d.b(this.pxL, "profile", ".ui.ContactInfoUI", paramView);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ContactSearchResultUI", localIOException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.2
 * JD-Core Version:    0.7.0.1
 */