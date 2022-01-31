package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(25516);
    int i = paramInt - ContactSearchResultUI.a(this.sZz).getHeaderViewsCount();
    if ((i < 0) || (i >= ContactSearchResultUI.a(this.sZz).getCount()))
    {
      AppMethodBeat.o(25516);
      return;
    }
    if (i >= ContactSearchResultUI.b(this.sZz).size())
    {
      paramAdapterView = (bxw)ContactSearchResultUI.c(this.sZz).get(paramInt - ContactSearchResultUI.b(this.sZz).size());
      ContactSearchResultUI.a(this.sZz, paramAdapterView);
      AppMethodBeat.o(25516);
      return;
    }
    paramAdapterView = (bxf)ContactSearchResultUI.b(this.sZz).get(i);
    paramView = paramAdapterView.wOT.xJE;
    aw.aaz();
    ad localad = c.YA().arw(paramView);
    if (a.je(localad.field_type))
    {
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("Contact_User", paramView);
      paramAdapterView.putExtra("Contact_Scene", 3);
      if ((paramView != null) && (paramView.length() > 0))
      {
        if (localad.dwz())
        {
          h.qsU.kvStat(10298, paramView + ",35");
          paramAdapterView.putExtra("Contact_Scene", 35);
        }
        d.b(this.sZz, "profile", ".ui.ContactInfoUI", paramAdapterView);
      }
      AppMethodBeat.o(25516);
      return;
    }
    if ((paramAdapterView.xpe & 0x8) > 0) {
      h.qsU.kvStat(10298, paramAdapterView.wOT.xJE + ",35");
    }
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramAdapterView.wOT.xJE);
    paramView.putExtra("Contact_Alias", paramAdapterView.gwU);
    paramView.putExtra("Contact_Nick", paramAdapterView.xmi.xJE);
    paramView.putExtra("Contact_Signature", paramAdapterView.gwS);
    paramView.putExtra("Contact_RegionCode", RegionCodeDecoder.aF(paramAdapterView.gwY, paramAdapterView.gwQ, paramAdapterView.gwR));
    paramView.putExtra("Contact_Sex", paramAdapterView.gwP);
    paramView.putExtra("Contact_VUser_Info", paramAdapterView.xpf);
    paramView.putExtra("Contact_VUser_Info_Flag", paramAdapterView.xpe);
    paramView.putExtra("Contact_KWeibo_flag", paramAdapterView.xpi);
    paramView.putExtra("Contact_KWeibo", paramAdapterView.xpg);
    paramView.putExtra("Contact_KWeiboNick", paramAdapterView.xph);
    paramView.putExtra("Contact_KSnsIFlag", paramAdapterView.xpk.gxa);
    paramView.putExtra("Contact_KSnsBgId", paramAdapterView.xpk.gxc);
    paramView.putExtra("Contact_KSnsBgUrl", paramAdapterView.xpk.gxb);
    paramView.putExtra("Contact_Scene", 35);
    if (this.sZA != 0) {
      paramView.putExtra("add_more_friend_search_scene", this.sZA);
    }
    if (paramAdapterView.xpl != null) {}
    try
    {
      paramView.putExtra("Contact_customInfo", paramAdapterView.xpl.toByteArray());
      if ((paramAdapterView.xpe & 0x8) > 0) {
        h.qsU.kvStat(10298, paramAdapterView.wOT.xJE + ",35");
      }
      d.b(this.sZz, "profile", ".ui.ContactInfoUI", paramView);
      AppMethodBeat.o(25516);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ContactSearchResultUI", localIOException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.2
 * JD-Core Version:    0.7.0.1
 */