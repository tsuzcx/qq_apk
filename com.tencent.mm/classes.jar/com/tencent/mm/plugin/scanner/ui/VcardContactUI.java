package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.scanner.a.p.a;
import com.tencent.mm.plugin.scanner.a.p.b;
import com.tencent.mm.plugin.scanner.a.p.c;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VcardContactUI
  extends MMPreference
{
  private static ArrayList<String> nNX = new ArrayList();
  private static int nNZ = 1;
  private static int nOa = 1;
  private f dnn;
  private com.tencent.mm.plugin.scanner.a.p nNW;
  private r nNY;
  
  private static void a(List<String> paramList, Intent paramIntent, int paramInt1, int paramInt2)
  {
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
  }
  
  private void b(List<String> paramList, String paramString1, String paramString2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        VcardContactLinkPreference localVcardContactLinkPreference = new VcardContactLinkPreference(this);
        localVcardContactLinkPreference.setKey(paramString1 + String.valueOf(str));
        if (!nNX.contains(paramString1 + String.valueOf(str))) {
          nNX.add(paramString1 + String.valueOf(str));
        }
        localVcardContactLinkPreference.setTitle(paramString2);
        localVcardContactLinkPreference.setLayoutResource(R.i.mm_preference);
        localVcardContactLinkPreference.setSummary(str);
        localVcardContactLinkPreference.nf(false);
        localVcardContactLinkPreference.vcS = true;
        localVcardContactLinkPreference.cBw();
        this.dnn.a(localVcardContactLinkPreference, nNZ);
      }
    }
  }
  
  private void eC(String paramString1, String paramString2)
  {
    KeyValuePreference localKeyValuePreference = new KeyValuePreference(this);
    localKeyValuePreference.setTitle(paramString2);
    localKeyValuePreference.setLayoutResource(R.i.mm_preference);
    localKeyValuePreference.nf(false);
    localKeyValuePreference.setSummary(paramString1);
    localKeyValuePreference.vcS = false;
    localKeyValuePreference.cBw();
    this.dnn.a(localKeyValuePreference, nOa);
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    Object localObject;
    if (paramPreference.mKey.equals("add_vcard_contact"))
    {
      paramf = getString(R.l.v_contact_add_new_contact);
      paramPreference = getString(R.l.v_contact_add_exist_contact);
      localObject = new VcardContactUI.4(this);
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf, paramPreference }, "", (h.c)localObject);
      return true;
    }
    if ((paramPreference.mKey.equals("v_contact_info_photo_uri")) || (paramPreference.mKey.equals("v_contact_info_home_page")) || (paramPreference.mKey.equals("v_contact_info_logo")))
    {
      paramf = paramPreference.getSummary().toString();
      if ((paramf != null) && (paramf.length() > 0))
      {
        paramPreference = this.nNY;
        if (!paramPreference.mZu.crl()) {
          y.e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
        }
        for (;;)
        {
          return true;
          if ((paramf == null) || (paramf.length() == 0))
          {
            y.e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
          }
          else
          {
            paramPreference.url = paramf;
            au.Hx();
            localObject = (String)c.Dz().get(46, null);
            if ((localObject == null) || (((String)localObject).length() == 0))
            {
              paramPreference.c(paramf, (int)System.currentTimeMillis(), new byte[0]);
            }
            else
            {
              au.Dk().a(233, paramPreference);
              paramPreference.nOj = new com.tencent.mm.modelsimple.h(paramf, null, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
              au.Dk().a(paramPreference.nOj, 0);
              paramPreference.mZu.S(3000L, 3000L);
            }
          }
        }
      }
    }
    else if ((nNX.contains(paramPreference.mKey)) && (!paramPreference.mKey.toLowerCase().contains("fax")))
    {
      paramPreference = paramPreference.getSummary().toString().trim();
      if ((paramPreference != null) && (paramPreference.length() > 0))
      {
        paramf = getString(R.l.chatting_phone_use);
        paramPreference = new VcardContactUI.1(this, paramPreference);
        com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf }, "", paramPreference);
        return true;
      }
    }
    else if (paramPreference.mKey.equals("v_contact_info_email"))
    {
      localObject = paramPreference.getSummary().toString();
      paramf = this.mController.uMN.getString(R.l.send_mail_by_qqmail);
      paramPreference = this.mController.uMN.getString(R.l.send_mail_by_default_account);
      localObject = new VcardContactUI.2(this, (String)localObject);
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf, paramPreference }, "", (h.c)localObject);
    }
    return false;
  }
  
  protected final void initView()
  {
    this.nNY = new r(this);
    this.dnn = this.vdd;
    this.nNW = com.tencent.mm.plugin.scanner.a.p.nHQ;
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        VcardContactUI.this.finish();
        return true;
      }
    });
    setMMTitle("");
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(R.o.vcard_contact_info_pref);
    Object localObject = (VcardContactUserHeaderPreference)this.dnn.add("v_contact_info_header");
    if (localObject != null)
    {
      com.tencent.mm.plugin.scanner.a.p localp = this.nNW;
      if (localp != null)
      {
        if (!bk.bl(localp.nHz.acH())) {
          ((VcardContactUserHeaderPreference)localObject).nOi = localp.nHz.acH();
        }
        if (!bk.bl(localp.aVr)) {
          ((VcardContactUserHeaderPreference)localObject).aVr = localp.aVr;
        }
        if (!bk.bl(localp.nHN)) {
          ((VcardContactUserHeaderPreference)localObject).nHN = localp.nHN;
        }
        if (!bk.bl(localp.title)) {
          ((VcardContactUserHeaderPreference)localObject).title = localp.title;
        }
      }
    }
    this.dnn.ade("c_contact_info_wx_id");
    if (!bk.bl(this.nNW.fGC))
    {
      localObject = (VcardContactLinkPreference)this.dnn.add("v_contact_info_photo_uri");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.nNW.fGC);
        ((VcardContactLinkPreference)localObject).nf(false);
        ((KeyValuePreference)localObject).vcS = false;
        nNZ += 2;
        nOa += 2;
      }
      localObject = this.nNW.nHG;
      if ((localObject != null) && (((p.a)localObject).acH().length() > 0)) {
        eC(((p.a)localObject).acH(), this.mController.uMN.getString(R.l.v_contact_home_address));
      }
      localObject = this.nNW.nHH;
      if ((localObject != null) && (((p.a)localObject).acH().length() > 0)) {
        eC(((p.a)localObject).acH(), this.mController.uMN.getString(R.l.v_contact_work_address));
      }
      localObject = this.nNW.nHE;
      if ((localObject != null) && (((p.a)localObject).acH().length() > 0)) {
        eC(((p.a)localObject).acH(), this.mController.uMN.getString(R.l.v_contact_address));
      }
      localObject = this.nNW.nHF;
      if ((localObject != null) && (((p.a)localObject).acH().length() > 0)) {
        eC(((p.a)localObject).acH(), this.mController.uMN.getString(R.l.v_contact_address));
      }
      localObject = this.nNW.nHK;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        b((List)localObject, "WorkTel", this.mController.uMN.getString(R.l.v_contact_work_tel));
      }
      localObject = this.nNW.nHJ;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        b((List)localObject, "HomeTel", this.mController.uMN.getString(R.l.v_contact_home_tel));
      }
      localObject = this.nNW.nHL;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        b((List)localObject, "VideoTEL", this.mController.uMN.getString(R.l.v_contact_video_tel));
      }
      localObject = this.nNW.nHM;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        b((List)localObject, "NormalTel", this.mController.uMN.getString(R.l.v_contact_normal_tel));
      }
      localObject = this.nNW.nHI;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        b((List)localObject, "CellTel", this.mController.uMN.getString(R.l.v_contact_cell_tel));
      }
      if (bk.bl(this.nNW.fGL)) {
        break label1062;
      }
      localObject = (KeyValuePreference)this.dnn.add("v_contact_info_org");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.nNW.fGL);
        ((KeyValuePreference)localObject).nf(false);
        ((KeyValuePreference)localObject).vcS = true;
      }
      label693:
      if (bk.bl(this.nNW.nHO)) {
        break label1078;
      }
      localObject = (KeyValuePreference)this.dnn.add("v_contact_info_agent");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.nNW.nHO);
        ((KeyValuePreference)localObject).nf(false);
        ((KeyValuePreference)localObject).vcS = true;
      }
      label747:
      if (bk.bl(this.nNW.url)) {
        break label1094;
      }
      localObject = (VcardContactLinkPreference)this.dnn.add("v_contact_info_home_page");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.nNW.url);
        ((VcardContactLinkPreference)localObject).nf(false);
        ((KeyValuePreference)localObject).vcS = true;
      }
      label801:
      if (bk.bl(this.nNW.cCt)) {
        break label1123;
      }
      localObject = (VcardContactLinkPreference)this.dnn.add("v_contact_info_email");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.nNW.cCt);
        ((VcardContactLinkPreference)localObject).nf(false);
        ((KeyValuePreference)localObject).vcS = true;
      }
      label855:
      if (bk.bl(this.nNW.nHD)) {
        break label1139;
      }
      localObject = (KeyValuePreference)this.dnn.add("v_contact_info_birthday");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.nNW.nHD);
        ((KeyValuePreference)localObject).nf(false);
        ((KeyValuePreference)localObject).vcS = true;
      }
      label909:
      if (bk.bl(this.nNW.nHP)) {
        break label1168;
      }
      localObject = (KeyValuePreference)this.dnn.add("v_contact_info_remark");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.nNW.nHP);
        ((KeyValuePreference)localObject).nf(false);
        ((KeyValuePreference)localObject).vcS = true;
      }
    }
    for (;;)
    {
      if ((this.nNW.nHB == null) || (!this.nNW.nHB.nHT.contains("uri"))) {
        break label1197;
      }
      localObject = (VcardContactLinkPreference)this.dnn.add("v_contact_info_logo");
      ((VcardContactLinkPreference)localObject).setSummary(this.nNW.nHB.nHU);
      ((KeyValuePreference)localObject).vcS = false;
      ((VcardContactLinkPreference)localObject).nf(false);
      return;
      this.dnn.ade("v_contact_info_photo_uri");
      this.dnn.ade("v_category_photo_uri");
      break;
      label1062:
      this.dnn.ade("v_contact_info_org");
      break label693;
      label1078:
      this.dnn.ade("v_contact_info_agent");
      break label747;
      label1094:
      this.dnn.ade("v_contact_info_home_page");
      this.dnn.ade("v_category_home_page");
      break label801;
      label1123:
      this.dnn.ade("v_contact_info_email");
      break label855;
      label1139:
      this.dnn.ade("v_contact_info_birthday");
      this.dnn.ade("v_category_birthday");
      break label909;
      label1168:
      this.dnn.ade("v_contact_info_remark");
      this.dnn.ade("v_category_remark");
    }
    label1197:
    this.dnn.ade("v_contact_info_logo");
    this.dnn.ade("v_category_logo");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public final int xj()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI
 * JD-Core Version:    0.7.0.1
 */