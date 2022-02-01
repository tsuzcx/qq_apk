package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.URLUtil;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.l.k;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.plugin.scanner.model.aj.a;
import com.tencent.mm.plugin.scanner.model.aj.b;
import com.tencent.mm.plugin.scanner.model.aj.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VcardContactUI
  extends MMPreference
{
  private static ArrayList<String> IUs;
  private static int IUu;
  private static int IUv;
  private aj IUr;
  private h IUt;
  private com.tencent.mm.ui.base.preference.f screen;
  
  static
  {
    AppMethodBeat.i(52013);
    IUs = new ArrayList();
    IUu = 1;
    IUv = 1;
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
  
  private void h(List<String> paramList, String paramString1, String paramString2)
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
        if (!IUs.contains(paramString1 + String.valueOf(str))) {
          IUs.add(paramString1 + String.valueOf(str));
        }
        localVcardContactLinkPreference.setTitle(paramString2);
        localVcardContactLinkPreference.setLayoutResource(l.g.mm_preference);
        localVcardContactLinkPreference.aF(str);
        localVcardContactLinkPreference.FU(false);
        localVcardContactLinkPreference.WrK = true;
        localVcardContactLinkPreference.hKO();
        this.screen.a(localVcardContactLinkPreference, IUu);
      }
    }
    AppMethodBeat.o(52009);
  }
  
  private void ki(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52010);
    KeyValuePreference localKeyValuePreference = new KeyValuePreference(this);
    localKeyValuePreference.setTitle(paramString2);
    localKeyValuePreference.setLayoutResource(l.g.mm_preference);
    localKeyValuePreference.FU(false);
    localKeyValuePreference.aF(paramString1);
    localKeyValuePreference.WrK = false;
    localKeyValuePreference.hKO();
    this.screen.a(localKeyValuePreference, IUv);
    AppMethodBeat.o(52010);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(52008);
    this.IUt = new h(this);
    this.screen = getPreferenceScreen();
    this.IUr = aj.IMZ;
    setBackBtn(new VcardContactUI.3(this));
    setMMTitle("");
    this.screen.removeAll();
    this.screen.auC(l.k.IFL);
    Object localObject = (VcardContactUserHeaderPreference)this.screen.byG("v_contact_info_header");
    if (localObject != null)
    {
      aj localaj = this.IUr;
      if (localaj != null)
      {
        if (!Util.isNullOrNil(localaj.IMI.bRQ())) {
          ((VcardContactUserHeaderPreference)localObject).fullName = localaj.IMI.bRQ();
        }
        if (!Util.isNullOrNil(localaj.nickName)) {
          ((VcardContactUserHeaderPreference)localObject).nickName = localaj.nickName;
        }
        if (!Util.isNullOrNil(localaj.IMW)) {
          ((VcardContactUserHeaderPreference)localObject).IMW = localaj.IMW;
        }
        if (!Util.isNullOrNil(localaj.title)) {
          ((VcardContactUserHeaderPreference)localObject).title = localaj.title;
        }
      }
    }
    this.screen.byI("c_contact_info_wx_id");
    if (!Util.isNullOrNil(this.IUr.oOi))
    {
      localObject = (VcardContactLinkPreference)this.screen.byG("v_contact_info_photo_uri");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).aF(this.IUr.oOi);
        ((VcardContactLinkPreference)localObject).FU(false);
        ((KeyValuePreference)localObject).WrK = false;
        IUu += 2;
        IUv += 2;
      }
      localObject = this.IUr.IMP;
      if ((localObject != null) && (((aj.a)localObject).bRQ().length() > 0)) {
        ki(((aj.a)localObject).bRQ(), getContext().getString(l.i.IFA));
      }
      localObject = this.IUr.IMQ;
      if ((localObject != null) && (((aj.a)localObject).bRQ().length() > 0)) {
        ki(((aj.a)localObject).bRQ(), getContext().getString(l.i.IFH));
      }
      localObject = this.IUr.IMN;
      if ((localObject != null) && (((aj.a)localObject).bRQ().length() > 0)) {
        ki(((aj.a)localObject).bRQ(), getContext().getString(l.i.IFy));
      }
      localObject = this.IUr.IMO;
      if ((localObject != null) && (((aj.a)localObject).bRQ().length() > 0)) {
        ki(((aj.a)localObject).bRQ(), getContext().getString(l.i.IFy));
      }
      localObject = this.IUr.IMT;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        h((List)localObject, "WorkTel", getContext().getString(l.i.IFI));
      }
      localObject = this.IUr.IMS;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        h((List)localObject, "HomeTel", getContext().getString(l.i.IFB));
      }
      localObject = this.IUr.IMU;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        h((List)localObject, "VideoTEL", getContext().getString(l.i.IFG));
      }
      localObject = this.IUr.IMV;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        h((List)localObject, "NormalTel", getContext().getString(l.i.IFD));
      }
      localObject = this.IUr.IMR;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        h((List)localObject, "CellTel", getContext().getString(l.i.IFz));
      }
      if (Util.isNullOrNil(this.IUr.oOq)) {
        break label1047;
      }
      localObject = (KeyValuePreference)this.screen.byG("v_contact_info_org");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).aF(this.IUr.oOq);
        ((KeyValuePreference)localObject).FU(false);
        ((KeyValuePreference)localObject).WrK = true;
      }
      label672:
      if (Util.isNullOrNil(this.IUr.IMX)) {
        break label1063;
      }
      localObject = (KeyValuePreference)this.screen.byG("v_contact_info_agent");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).aF(this.IUr.IMX);
        ((KeyValuePreference)localObject).FU(false);
        ((KeyValuePreference)localObject).WrK = true;
      }
      label726:
      if (Util.isNullOrNil(this.IUr.url)) {
        break label1079;
      }
      localObject = (VcardContactLinkPreference)this.screen.byG("v_contact_info_home_page");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).aF(this.IUr.url);
        ((VcardContactLinkPreference)localObject).FU(false);
        ((KeyValuePreference)localObject).WrK = true;
      }
      label780:
      if (Util.isNullOrNil(this.IUr.hDf)) {
        break label1108;
      }
      localObject = (VcardContactLinkPreference)this.screen.byG("v_contact_info_email");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).aF(this.IUr.hDf);
        ((VcardContactLinkPreference)localObject).FU(false);
        ((KeyValuePreference)localObject).WrK = true;
      }
      label834:
      if (Util.isNullOrNil(this.IUr.IMM)) {
        break label1124;
      }
      localObject = (KeyValuePreference)this.screen.byG("v_contact_info_birthday");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).aF(this.IUr.IMM);
        ((KeyValuePreference)localObject).FU(false);
        ((KeyValuePreference)localObject).WrK = true;
      }
      label888:
      if (Util.isNullOrNil(this.IUr.IMY)) {
        break label1153;
      }
      localObject = (KeyValuePreference)this.screen.byG("v_contact_info_remark");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).aF(this.IUr.IMY);
        ((KeyValuePreference)localObject).FU(false);
        ((KeyValuePreference)localObject).WrK = true;
      }
    }
    for (;;)
    {
      if ((this.IUr.IMK == null) || (!this.IUr.IMK.kVJ.contains("uri"))) {
        break label1182;
      }
      localObject = (VcardContactLinkPreference)this.screen.byG("v_contact_info_logo");
      ((VcardContactLinkPreference)localObject).aF(this.IUr.IMK.INc);
      ((KeyValuePreference)localObject).WrK = false;
      ((VcardContactLinkPreference)localObject).FU(false);
      AppMethodBeat.o(52008);
      return;
      this.screen.byI("v_contact_info_photo_uri");
      this.screen.byI("v_category_photo_uri");
      break;
      label1047:
      this.screen.byI("v_contact_info_org");
      break label672;
      label1063:
      this.screen.byI("v_contact_info_agent");
      break label726;
      label1079:
      this.screen.byI("v_contact_info_home_page");
      this.screen.byI("v_category_home_page");
      break label780;
      label1108:
      this.screen.byI("v_contact_info_email");
      break label834;
      label1124:
      this.screen.byI("v_contact_info_birthday");
      this.screen.byI("v_category_birthday");
      break label888;
      label1153:
      this.screen.byI("v_contact_info_remark");
      this.screen.byI("v_category_remark");
    }
    label1182:
    this.screen.byI("v_contact_info_logo");
    this.screen.byI("v_category_logo");
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
      paramf = getString(l.i.IFx);
      paramPreference = getString(l.i.IFw);
      localObject = new VcardContactUI.4(this);
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf, paramPreference }, "", (h.d)localObject);
      AppMethodBeat.o(52007);
      return true;
    }
    if ((paramPreference.mKey.equals("v_contact_info_photo_uri")) || (paramPreference.mKey.equals("v_contact_info_home_page")) || (paramPreference.mKey.equals("v_contact_info_logo")))
    {
      paramf = paramPreference.fqw().toString();
      if ((paramf != null) && (paramf.length() > 0) && (URLUtil.isNetworkUrl(paramf)))
      {
        paramPreference = this.IUt;
        if (!paramPreference.Hdq.stopped()) {
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
            localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().b(46, null);
            if ((localObject == null) || (((String)localObject).length() == 0))
            {
              paramPreference.b(paramf, l.boo(), new byte[0]);
            }
            else
            {
              com.tencent.mm.kernel.h.aGY().a(233, paramPreference);
              paramPreference.IUD = new l(paramf, null, 4, 0, l.boo(), new byte[0]);
              com.tencent.mm.kernel.h.aGY().a(paramPreference.IUD, 0);
              paramPreference.Hdq.startTimer(3000L);
            }
          }
        }
      }
    }
    else if ((IUs.contains(paramPreference.mKey)) && (!paramPreference.mKey.toLowerCase().contains("fax")))
    {
      paramPreference = paramPreference.fqw().toString().trim();
      if ((paramPreference != null) && (paramPreference.length() > 0))
      {
        paramf = getString(l.i.contact_info_dial);
        paramPreference = new VcardContactUI.1(this, paramPreference);
        com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf }, "", paramPreference);
        AppMethodBeat.o(52007);
        return true;
      }
    }
    else if (paramPreference.mKey.equals("v_contact_info_email"))
    {
      localObject = paramPreference.fqw().toString();
      paramf = getContext().getString(l.i.IFv);
      paramPreference = getContext().getString(l.i.IFu);
      localObject = new VcardContactUI.2(this, (String)localObject);
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf, paramPreference }, "", (h.d)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI
 * JD-Core Version:    0.7.0.1
 */