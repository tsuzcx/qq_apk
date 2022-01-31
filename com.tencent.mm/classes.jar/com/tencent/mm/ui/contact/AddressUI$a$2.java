package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.voicesearch.b;
import java.io.IOException;

final class AddressUI$a$2
  implements AdapterView.OnItemClickListener
{
  AddressUI$a$2(AddressUI.a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = new StringBuilder("onItemClick ").append(paramInt);
    if (AddressUI.a.g(this.vJs) == null)
    {
      paramAdapterView = AddressUI.a.g(this.vJs);
      y.i("MicroMsg.AddressUI", paramAdapterView);
      if ((paramInt != 0) || ("@biz.contact".equals(AddressUI.a.h(this.vJs)))) {
        break label82;
      }
    }
    label82:
    Object localObject;
    label349:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramAdapterView = Boolean.valueOf(AddressUI.a.g(this.vJs).wiO);
                break;
              } while (paramInt < AddressUI.a.c(this.vJs).getHeaderViewsCount());
              paramInt -= AddressUI.a.c(this.vJs).getHeaderViewsCount();
              if ((AddressUI.a.g(this.vJs) == null) || (!AddressUI.a.g(this.vJs).wiO)) {
                break label823;
              }
              boolean bool1 = AddressUI.a.g(this.vJs).sk(paramInt);
              boolean bool2 = AddressUI.a.g(this.vJs).Ik(paramInt);
              y.i("MicroMsg.AddressUI", "onItemClick " + bool2);
              if (bool2)
              {
                AddressUI.a.g(this.vJs).aet("");
                return;
              }
              if (!bool1) {
                break label663;
              }
              paramView = AddressUI.a.g(this.vJs).Ii(paramInt);
              paramAdapterView = paramView.sQs.tFO;
              au.Hx();
              localObject = c.Fw().abl(paramAdapterView);
              if (!com.tencent.mm.n.a.gR(((ao)localObject).field_type)) {
                break label349;
              }
              paramView = new Intent();
              paramView.putExtra("Contact_User", paramAdapterView);
              paramView.putExtra("Contact_Scene", 3);
            } while ((paramAdapterView == null) || (paramAdapterView.length() <= 0));
            if (((ad)localObject).cua()) {
              h.nFQ.aC(10298, paramAdapterView + ",3");
            }
            e.a(paramView, paramAdapterView);
            paramView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
            d.b(this.vJs.getContext(), "profile", ".ui.ContactInfoUI", paramView);
            return;
            localObject = new Intent();
            ((Intent)localObject).putExtra("Contact_User", paramView.sQs.tFO);
            ((Intent)localObject).putExtra("Contact_Alias", paramView.ffm);
            ((Intent)localObject).putExtra("Contact_Nick", paramView.tmw.tFO);
            ((Intent)localObject).putExtra("Contact_Signature", paramView.ffk);
            ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.ao(paramView.ffq, paramView.ffi, paramView.ffj));
            ((Intent)localObject).putExtra("Contact_Sex", paramView.ffh);
            ((Intent)localObject).putExtra("Contact_VUser_Info", paramView.tph);
            ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramView.tpg);
            ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramView.tpk);
            ((Intent)localObject).putExtra("Contact_KWeibo", paramView.tpi);
            ((Intent)localObject).putExtra("Contact_KWeiboNick", paramView.tpj);
            ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramView.tpm.ffs);
            ((Intent)localObject).putExtra("Contact_KSnsBgId", paramView.tpm.ffu);
            ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramView.tpm.fft);
            if (paramView.tpn != null) {}
            try
            {
              ((Intent)localObject).putExtra("Contact_customInfo", paramView.tpn.toByteArray());
              if ((paramView.tpg & 0x8) > 0) {
                h.nFQ.aC(10298, paramAdapterView + ",3");
              }
              ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
              d.b(this.vJs.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
              return;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                y.printErrStackTrace("MicroMsg.AddressUI", localIOException, "", new Object[0]);
              }
            }
            paramAdapterView = AddressUI.a.g(this.vJs).Ij(paramInt);
            if (paramAdapterView == null)
            {
              y.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(AddressUI.a.g(this.vJs).getCount()), Integer.valueOf(paramInt) });
              return;
            }
            paramAdapterView = paramAdapterView.field_username;
            if (s.hK(paramAdapterView))
            {
              paramAdapterView = new Intent(this.vJs.getContext(), AddressUI.class);
              paramAdapterView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
              this.vJs.startActivity(paramAdapterView);
              return;
            }
            paramView = new Intent();
            paramView.putExtra("Contact_User", paramAdapterView);
            paramView.putExtra("Contact_Scene", 3);
            paramView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
          } while ((paramAdapterView == null) || (paramAdapterView.length() <= 0));
          d.b(this.vJs.getContext(), "profile", ".ui.ContactInfoUI", paramView);
          return;
          paramAdapterView = (f)AddressUI.a.a(this.vJs).FC(paramInt);
        } while (paramAdapterView == null);
        paramAdapterView = paramAdapterView.field_username;
        paramView = this.vJs;
      } while ((paramAdapterView == null) || (paramAdapterView.length() <= 0));
      if (s.hK(paramAdapterView))
      {
        y.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAdapterView });
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", paramAdapterView);
      if (s.hi(paramAdapterView)) {
        ((Intent)localObject).putExtra("Is_group_card", true);
      }
    } while ((paramAdapterView == null) || (paramAdapterView.length() <= 0));
    label663:
    label823:
    e.a((Intent)localObject, paramAdapterView);
    ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
    d.b(paramView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.a.2
 * JD-Core Version:    0.7.0.1
 */