package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.URLUtil;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.l.k;
import com.tencent.mm.plugin.scanner.model.as;
import com.tencent.mm.plugin.scanner.model.as.a;
import com.tencent.mm.plugin.scanner.model.as.b;
import com.tencent.mm.plugin.scanner.model.as.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VcardContactUI
  extends MMPreference
{
  private static ArrayList<String> Pdk;
  private static int Pdm;
  private static int Pdn;
  private as Pdj;
  private h Pdl;
  private com.tencent.mm.ui.base.preference.f screen;
  
  static
  {
    AppMethodBeat.i(52013);
    Pdk = new ArrayList();
    Pdm = 1;
    Pdn = 1;
    AppMethodBeat.o(52013);
  }
  
  private static void a(List<String> paramList, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52011);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (paramInt2 == 1)
      {
        paramIntent.putExtra("phone", str);
        paramIntent.putExtra("phone_type", paramInt1);
      }
      else if (paramInt2 == 2)
      {
        paramIntent.putExtra("secondary_phone", str);
        paramIntent.putExtra("phone_type", paramInt1);
      }
      else if (paramInt2 == 3)
      {
        paramIntent.putExtra("tertiary_phone", str);
        paramIntent.putExtra("phone_type", paramInt1);
      }
    }
    AppMethodBeat.o(52011);
  }
  
  private void g(List<String> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(52009);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        VcardContactLinkPreference localVcardContactLinkPreference = new VcardContactLinkPreference(this);
        localVcardContactLinkPreference.setKey(paramString1 + String.valueOf(str));
        if (!Pdk.contains(paramString1 + String.valueOf(str))) {
          Pdk.add(paramString1 + String.valueOf(str));
        }
        localVcardContactLinkPreference.setTitle(paramString2);
        localVcardContactLinkPreference.setLayoutResource(l.g.mm_preference);
        localVcardContactLinkPreference.aS(str);
        localVcardContactLinkPreference.LG(false);
        localVcardContactLinkPreference.adZa = true;
        localVcardContactLinkPreference.jnr();
        this.screen.a(localVcardContactLinkPreference, Pdm);
      }
    }
    AppMethodBeat.o(52009);
  }
  
  private void lH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52010);
    KeyValuePreference localKeyValuePreference = new KeyValuePreference(this);
    localKeyValuePreference.setTitle(paramString2);
    localKeyValuePreference.setLayoutResource(l.g.mm_preference);
    localKeyValuePreference.LG(false);
    localKeyValuePreference.aS(paramString1);
    localKeyValuePreference.adZa = false;
    localKeyValuePreference.jnr();
    this.screen.a(localKeyValuePreference, Pdn);
    AppMethodBeat.o(52010);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(52008);
    this.Pdl = new h(this);
    this.screen = getPreferenceScreen();
    this.Pdj = as.OUc;
    setBackBtn(new VcardContactUI.3(this));
    setMMTitle("");
    this.screen.removeAll();
    this.screen.aBe(l.k.OLU);
    Object localObject = (VcardContactUserHeaderPreference)this.screen.bAi("v_contact_info_header");
    if (localObject != null)
    {
      as localas = this.Pdj;
      if (localas != null)
      {
        if (!Util.isNullOrNil(localas.OTL.crV())) {
          ((VcardContactUserHeaderPreference)localObject).fullName = localas.OTL.crV();
        }
        if (!Util.isNullOrNil(localas.nickName)) {
          ((VcardContactUserHeaderPreference)localObject).nickName = localas.nickName;
        }
        if (!Util.isNullOrNil(localas.OTZ)) {
          ((VcardContactUserHeaderPreference)localObject).OTZ = localas.OTZ;
        }
        if (!Util.isNullOrNil(localas.title)) {
          ((VcardContactUserHeaderPreference)localObject).title = localas.title;
        }
      }
    }
    this.screen.bAk("c_contact_info_wx_id");
    if (!Util.isNullOrNil(this.Pdj.rRV))
    {
      localObject = (VcardContactLinkPreference)this.screen.bAi("v_contact_info_photo_uri");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).aS(this.Pdj.rRV);
        ((VcardContactLinkPreference)localObject).LG(false);
        ((KeyValuePreference)localObject).adZa = false;
        Pdm += 2;
        Pdn += 2;
      }
      localObject = this.Pdj.OTS;
      if ((localObject != null) && (((as.a)localObject).crV().length() > 0)) {
        lH(((as.a)localObject).crV(), getContext().getString(l.i.OLJ));
      }
      localObject = this.Pdj.OTT;
      if ((localObject != null) && (((as.a)localObject).crV().length() > 0)) {
        lH(((as.a)localObject).crV(), getContext().getString(l.i.OLQ));
      }
      localObject = this.Pdj.OTQ;
      if ((localObject != null) && (((as.a)localObject).crV().length() > 0)) {
        lH(((as.a)localObject).crV(), getContext().getString(l.i.OLH));
      }
      localObject = this.Pdj.OTR;
      if ((localObject != null) && (((as.a)localObject).crV().length() > 0)) {
        lH(((as.a)localObject).crV(), getContext().getString(l.i.OLH));
      }
      localObject = this.Pdj.OTW;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "WorkTel", getContext().getString(l.i.OLR));
      }
      localObject = this.Pdj.OTV;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "HomeTel", getContext().getString(l.i.OLK));
      }
      localObject = this.Pdj.OTX;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "VideoTEL", getContext().getString(l.i.OLP));
      }
      localObject = this.Pdj.OTY;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "NormalTel", getContext().getString(l.i.OLM));
      }
      localObject = this.Pdj.OTU;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "CellTel", getContext().getString(l.i.OLI));
      }
      if (Util.isNullOrNil(this.Pdj.rSd)) {
        break label1047;
      }
      localObject = (KeyValuePreference)this.screen.bAi("v_contact_info_org");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).aS(this.Pdj.rSd);
        ((KeyValuePreference)localObject).LG(false);
        ((KeyValuePreference)localObject).adZa = true;
      }
      label672:
      if (Util.isNullOrNil(this.Pdj.OUa)) {
        break label1063;
      }
      localObject = (KeyValuePreference)this.screen.bAi("v_contact_info_agent");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).aS(this.Pdj.OUa);
        ((KeyValuePreference)localObject).LG(false);
        ((KeyValuePreference)localObject).adZa = true;
      }
      label726:
      if (Util.isNullOrNil(this.Pdj.url)) {
        break label1079;
      }
      localObject = (VcardContactLinkPreference)this.screen.bAi("v_contact_info_home_page");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).aS(this.Pdj.url);
        ((VcardContactLinkPreference)localObject).LG(false);
        ((KeyValuePreference)localObject).adZa = true;
      }
      label780:
      if (Util.isNullOrNil(this.Pdj.kab)) {
        break label1108;
      }
      localObject = (VcardContactLinkPreference)this.screen.bAi("v_contact_info_email");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).aS(this.Pdj.kab);
        ((VcardContactLinkPreference)localObject).LG(false);
        ((KeyValuePreference)localObject).adZa = true;
      }
      label834:
      if (Util.isNullOrNil(this.Pdj.OTP)) {
        break label1124;
      }
      localObject = (KeyValuePreference)this.screen.bAi("v_contact_info_birthday");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).aS(this.Pdj.OTP);
        ((KeyValuePreference)localObject).LG(false);
        ((KeyValuePreference)localObject).adZa = true;
      }
      label888:
      if (Util.isNullOrNil(this.Pdj.OUb)) {
        break label1153;
      }
      localObject = (KeyValuePreference)this.screen.bAi("v_contact_info_remark");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).aS(this.Pdj.OUb);
        ((KeyValuePreference)localObject).LG(false);
        ((KeyValuePreference)localObject).adZa = true;
      }
    }
    for (;;)
    {
      if ((this.Pdj.OTN == null) || (!this.Pdj.OTN.nBd.contains("uri"))) {
        break label1182;
      }
      localObject = (VcardContactLinkPreference)this.screen.bAi("v_contact_info_logo");
      ((VcardContactLinkPreference)localObject).aS(this.Pdj.OTN.OUf);
      ((KeyValuePreference)localObject).adZa = false;
      ((VcardContactLinkPreference)localObject).LG(false);
      AppMethodBeat.o(52008);
      return;
      this.screen.bAk("v_contact_info_photo_uri");
      this.screen.bAk("v_category_photo_uri");
      break;
      label1047:
      this.screen.bAk("v_contact_info_org");
      break label672;
      label1063:
      this.screen.bAk("v_contact_info_agent");
      break label726;
      label1079:
      this.screen.bAk("v_contact_info_home_page");
      this.screen.bAk("v_category_home_page");
      break label780;
      label1108:
      this.screen.bAk("v_contact_info_email");
      break label834;
      label1124:
      this.screen.bAk("v_contact_info_birthday");
      this.screen.bAk("v_category_birthday");
      break label888;
      label1153:
      this.screen.bAk("v_contact_info_remark");
      this.screen.bAk("v_category_remark");
    }
    label1182:
    this.screen.bAk("v_contact_info_logo");
    this.screen.bAk("v_category_logo");
    AppMethodBeat.o(52008);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(52006);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(52006);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(52007);
    Object localObject;
    if (paramPreference.mKey.equals("add_vcard_contact"))
    {
      paramf = getString(l.i.OLG);
      paramPreference = getString(l.i.OLF);
      localObject = new VcardContactUI.4(this);
      k.a(this, "", new String[] { paramf, paramPreference }, "", (k.d)localObject);
      AppMethodBeat.o(52007);
      return true;
    }
    if ((paramPreference.mKey.equals("v_contact_info_photo_uri")) || (paramPreference.mKey.equals("v_contact_info_home_page")) || (paramPreference.mKey.equals("v_contact_info_logo")))
    {
      paramf = paramPreference.gBR().toString();
      if ((paramf != null) && (paramf.length() > 0) && (URLUtil.isNetworkUrl(paramf)))
      {
        paramPreference = this.Pdl;
        if (!paramPreference.NbJ.stopped()) {
          Log.e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
        }
        for (;;)
        {
          AppMethodBeat.o(52007);
          return true;
          if ((paramf == null) || (paramf.length() == 0))
          {
            Log.e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
          }
          else
          {
            paramPreference.url = paramf;
            localObject = (String)com.tencent.mm.kernel.h.baE().ban().d(46, null);
            if ((localObject == null) || (((String)localObject).length() == 0))
            {
              paramPreference.b(paramf, n.bMd(), new byte[0]);
            }
            else
            {
              com.tencent.mm.kernel.h.aZW().a(233, paramPreference);
              paramPreference.Pdv = new n(paramf, null, 4, 0, n.bMd(), new byte[0]);
              com.tencent.mm.kernel.h.aZW().a(paramPreference.Pdv, 0);
              paramPreference.NbJ.startTimer(3000L);
            }
          }
        }
      }
    }
    else if ((Pdk.contains(paramPreference.mKey)) && (!paramPreference.mKey.toLowerCase().contains("fax")))
    {
      paramPreference = paramPreference.gBR().toString().trim();
      if ((paramPreference != null) && (paramPreference.length() > 0))
      {
        paramf = getString(l.i.contact_info_dial);
        paramPreference = new VcardContactUI.1(this, paramPreference);
        k.a(this, "", new String[] { paramf }, "", paramPreference);
        AppMethodBeat.o(52007);
        return true;
      }
    }
    else if (paramPreference.mKey.equals("v_contact_info_email"))
    {
      localObject = paramPreference.gBR().toString();
      paramf = getContext().getString(l.i.OLE);
      paramPreference = getContext().getString(l.i.OLD);
      localObject = new VcardContactUI.2(this, (String)localObject);
      k.a(this, "", new String[] { paramf, paramPreference }, "", (k.d)localObject);
    }
    AppMethodBeat.o(52007);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI
 * JD-Core Version:    0.7.0.1
 */