package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.plugin.scanner.model.s;
import com.tencent.mm.plugin.scanner.model.s.a;
import com.tencent.mm.plugin.scanner.model.s.b;
import com.tencent.mm.plugin.scanner.model.s.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VcardContactUI
  extends MMPreference
{
  private static ArrayList<String> qBH;
  private static int qBJ;
  private static int qBK;
  private s qBG;
  private r qBI;
  private f screen;
  
  static
  {
    AppMethodBeat.i(81359);
    qBH = new ArrayList();
    qBJ = 1;
    qBK = 1;
    AppMethodBeat.o(81359);
  }
  
  private static void a(List<String> paramList, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(81357);
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
    AppMethodBeat.o(81357);
  }
  
  private void c(List<String> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(81355);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        VcardContactLinkPreference localVcardContactLinkPreference = new VcardContactLinkPreference(this);
        localVcardContactLinkPreference.setKey(paramString1 + String.valueOf(str));
        if (!qBH.contains(paramString1 + String.valueOf(str))) {
          qBH.add(paramString1 + String.valueOf(str));
        }
        localVcardContactLinkPreference.setTitle(paramString2);
        localVcardContactLinkPreference.setLayoutResource(2130970179);
        localVcardContactLinkPreference.setSummary(str);
        localVcardContactLinkPreference.qJ(false);
        localVcardContactLinkPreference.zrr = true;
        localVcardContactLinkPreference.dEO();
        this.screen.a(localVcardContactLinkPreference, qBJ);
      }
    }
    AppMethodBeat.o(81355);
  }
  
  private void gd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(81356);
    KeyValuePreference localKeyValuePreference = new KeyValuePreference(this);
    localKeyValuePreference.setTitle(paramString2);
    localKeyValuePreference.setLayoutResource(2130970179);
    localKeyValuePreference.qJ(false);
    localKeyValuePreference.setSummary(paramString1);
    localKeyValuePreference.zrr = false;
    localKeyValuePreference.dEO();
    this.screen.a(localKeyValuePreference, qBK);
    AppMethodBeat.o(81356);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(81352);
    this.qBI = new r(this);
    this.screen = getPreferenceScreen();
    this.qBG = s.qvq;
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(81347);
        VcardContactUI.this.finish();
        AppMethodBeat.o(81347);
        return true;
      }
    });
    setMMTitle("");
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131165309);
    Object localObject = (VcardContactUserHeaderPreference)this.screen.atx("v_contact_info_header");
    if (localObject != null)
    {
      s locals = this.qBG;
      if (locals != null)
      {
        if (!bo.isNullOrNil(locals.quZ.aCR())) {
          ((VcardContactUserHeaderPreference)localObject).qBS = locals.quZ.aCR();
        }
        if (!bo.isNullOrNil(locals.blZ)) {
          ((VcardContactUserHeaderPreference)localObject).blZ = locals.blZ;
        }
        if (!bo.isNullOrNil(locals.qvn)) {
          ((VcardContactUserHeaderPreference)localObject).qvn = locals.qvn;
        }
        if (!bo.isNullOrNil(locals.title)) {
          ((VcardContactUserHeaderPreference)localObject).title = locals.title;
        }
      }
    }
    this.screen.aty("c_contact_info_wx_id");
    if (!bo.isNullOrNil(this.qBG.hJS))
    {
      localObject = (VcardContactLinkPreference)this.screen.atx("v_contact_info_photo_uri");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.qBG.hJS);
        ((VcardContactLinkPreference)localObject).qJ(false);
        ((KeyValuePreference)localObject).zrr = false;
        qBJ += 2;
        qBK += 2;
      }
      localObject = this.qBG.qvg;
      if ((localObject != null) && (((s.a)localObject).aCR().length() > 0)) {
        gd(((s.a)localObject).aCR(), getContext().getString(2131304472));
      }
      localObject = this.qBG.qvh;
      if ((localObject != null) && (((s.a)localObject).aCR().length() > 0)) {
        gd(((s.a)localObject).aCR(), getContext().getString(2131304485));
      }
      localObject = this.qBG.qve;
      if ((localObject != null) && (((s.a)localObject).aCR().length() > 0)) {
        gd(((s.a)localObject).aCR(), getContext().getString(2131304467));
      }
      localObject = this.qBG.qvf;
      if ((localObject != null) && (((s.a)localObject).aCR().length() > 0)) {
        gd(((s.a)localObject).aCR(), getContext().getString(2131304467));
      }
      localObject = this.qBG.qvk;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        c((List)localObject, "WorkTel", getContext().getString(2131304486));
      }
      localObject = this.qBG.qvj;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        c((List)localObject, "HomeTel", getContext().getString(2131304474));
      }
      localObject = this.qBG.qvl;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        c((List)localObject, "VideoTEL", getContext().getString(2131304483));
      }
      localObject = this.qBG.qvm;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        c((List)localObject, "NormalTel", getContext().getString(2131304477));
      }
      localObject = this.qBG.qvi;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        c((List)localObject, "CellTel", getContext().getString(2131304470));
      }
      if (bo.isNullOrNil(this.qBG.hKb)) {
        break label1047;
      }
      localObject = (KeyValuePreference)this.screen.atx("v_contact_info_org");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.qBG.hKb);
        ((KeyValuePreference)localObject).qJ(false);
        ((KeyValuePreference)localObject).zrr = true;
      }
      label672:
      if (bo.isNullOrNil(this.qBG.qvo)) {
        break label1063;
      }
      localObject = (KeyValuePreference)this.screen.atx("v_contact_info_agent");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.qBG.qvo);
        ((KeyValuePreference)localObject).qJ(false);
        ((KeyValuePreference)localObject).zrr = true;
      }
      label726:
      if (bo.isNullOrNil(this.qBG.url)) {
        break label1079;
      }
      localObject = (VcardContactLinkPreference)this.screen.atx("v_contact_info_home_page");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.qBG.url);
        ((VcardContactLinkPreference)localObject).qJ(false);
        ((KeyValuePreference)localObject).zrr = true;
      }
      label780:
      if (bo.isNullOrNil(this.qBG.dqF)) {
        break label1108;
      }
      localObject = (VcardContactLinkPreference)this.screen.atx("v_contact_info_email");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.qBG.dqF);
        ((VcardContactLinkPreference)localObject).qJ(false);
        ((KeyValuePreference)localObject).zrr = true;
      }
      label834:
      if (bo.isNullOrNil(this.qBG.qvd)) {
        break label1124;
      }
      localObject = (KeyValuePreference)this.screen.atx("v_contact_info_birthday");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.qBG.qvd);
        ((KeyValuePreference)localObject).qJ(false);
        ((KeyValuePreference)localObject).zrr = true;
      }
      label888:
      if (bo.isNullOrNil(this.qBG.qvp)) {
        break label1153;
      }
      localObject = (KeyValuePreference)this.screen.atx("v_contact_info_remark");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.qBG.qvp);
        ((KeyValuePreference)localObject).qJ(false);
        ((KeyValuePreference)localObject).zrr = true;
      }
    }
    for (;;)
    {
      if ((this.qBG.qvb == null) || (!this.qBG.qvb.qvt.contains("uri"))) {
        break label1182;
      }
      localObject = (VcardContactLinkPreference)this.screen.atx("v_contact_info_logo");
      ((VcardContactLinkPreference)localObject).setSummary(this.qBG.qvb.qvu);
      ((KeyValuePreference)localObject).zrr = false;
      ((VcardContactLinkPreference)localObject).qJ(false);
      AppMethodBeat.o(81352);
      return;
      this.screen.aty("v_contact_info_photo_uri");
      this.screen.aty("v_category_photo_uri");
      break;
      label1047:
      this.screen.aty("v_contact_info_org");
      break label672;
      label1063:
      this.screen.aty("v_contact_info_agent");
      break label726;
      label1079:
      this.screen.aty("v_contact_info_home_page");
      this.screen.aty("v_category_home_page");
      break label780;
      label1108:
      this.screen.aty("v_contact_info_email");
      break label834;
      label1124:
      this.screen.aty("v_contact_info_birthday");
      this.screen.aty("v_category_birthday");
      break label888;
      label1153:
      this.screen.aty("v_contact_info_remark");
      this.screen.aty("v_category_remark");
    }
    label1182:
    this.screen.aty("v_contact_info_logo");
    this.screen.aty("v_category_logo");
    AppMethodBeat.o(81352);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(81349);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(81349);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(81350);
    Object localObject;
    if (paramPreference.mKey.equals("add_vcard_contact"))
    {
      paramf = getString(2131304466);
      paramPreference = getString(2131304465);
      localObject = new h.c()
      {
        public final void iA(int paramAnonymousInt)
        {
          AppMethodBeat.i(81348);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(81348);
            return;
            bv.abc().c(10238, new Object[] { Integer.valueOf(1) });
            Intent localIntent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
            VcardContactUI.a(VcardContactUI.this, localIntent);
            VcardContactUI.this.startActivity(localIntent);
            AppMethodBeat.o(81348);
            return;
            bv.abc().c(10239, new Object[] { Integer.valueOf(1) });
            localIntent = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
            localIntent.setType("vnd.android.cursor.item/person");
            VcardContactUI.a(VcardContactUI.this, localIntent);
            VcardContactUI.this.startActivity(localIntent);
          }
        }
      };
      h.a(this, "", new String[] { paramf, paramPreference }, "", (h.c)localObject);
      AppMethodBeat.o(81350);
      return true;
    }
    if ((paramPreference.mKey.equals("v_contact_info_photo_uri")) || (paramPreference.mKey.equals("v_contact_info_home_page")) || (paramPreference.mKey.equals("v_contact_info_logo")))
    {
      paramf = paramPreference.getSummary().toString();
      if ((paramf != null) && (paramf.length() > 0))
      {
        paramPreference = this.qBI;
        if (!paramPreference.pDa.dtj()) {
          ab.e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
        }
        for (;;)
        {
          AppMethodBeat.o(81350);
          return true;
          if ((paramf == null) || (paramf.length() == 0))
          {
            ab.e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
          }
          else
          {
            paramPreference.url = paramf;
            localObject = (String)g.RL().Ru().get(46, null);
            if ((localObject == null) || (((String)localObject).length() == 0))
            {
              paramPreference.c(paramf, (int)System.currentTimeMillis(), new byte[0]);
            }
            else
            {
              g.Rc().a(233, paramPreference);
              paramPreference.qBT = new j(paramf, null, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
              g.Rc().a(paramPreference.qBT, 0);
              paramPreference.pDa.ag(3000L, 3000L);
            }
          }
        }
      }
    }
    else if ((qBH.contains(paramPreference.mKey)) && (!paramPreference.mKey.toLowerCase().contains("fax")))
    {
      paramPreference = paramPreference.getSummary().toString().trim();
      if ((paramPreference != null) && (paramPreference.length() > 0))
      {
        paramf = getString(2131298584);
        paramPreference = new VcardContactUI.1(this, paramPreference);
        h.a(this, "", new String[] { paramf }, "", paramPreference);
        AppMethodBeat.o(81350);
        return true;
      }
    }
    else if (paramPreference.mKey.equals("v_contact_info_email"))
    {
      localObject = paramPreference.getSummary().toString();
      paramf = getContext().getString(2131303109);
      paramPreference = getContext().getString(2131303108);
      localObject = new VcardContactUI.2(this, (String)localObject);
      h.a(this, "", new String[] { paramf, paramPreference }, "", (h.c)localObject);
    }
    AppMethodBeat.o(81350);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI
 * JD-Core Version:    0.7.0.1
 */