package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.by;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.scanner.model.ae.a;
import com.tencent.mm.plugin.scanner.model.ae.b;
import com.tencent.mm.plugin.scanner.model.ae.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static ArrayList<String> xhc;
  private static int xhe;
  private static int xhf;
  private f screen;
  private com.tencent.mm.plugin.scanner.model.ae xhb;
  private i xhd;
  
  static
  {
    AppMethodBeat.i(52013);
    xhc = new ArrayList();
    xhe = 1;
    xhf = 1;
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
  
  private void f(List<String> paramList, String paramString1, String paramString2)
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
        if (!xhc.contains(paramString1 + String.valueOf(str))) {
          xhc.add(paramString1 + String.valueOf(str));
        }
        localVcardContactLinkPreference.setTitle(paramString2);
        localVcardContactLinkPreference.setLayoutResource(2131494804);
        localVcardContactLinkPreference.setSummary(str);
        localVcardContactLinkPreference.wV(false);
        localVcardContactLinkPreference.HET = true;
        localVcardContactLinkPreference.fjq();
        this.screen.a(localVcardContactLinkPreference, xhe);
      }
    }
    AppMethodBeat.o(52009);
  }
  
  private void iO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52010);
    KeyValuePreference localKeyValuePreference = new KeyValuePreference(this);
    localKeyValuePreference.setTitle(paramString2);
    localKeyValuePreference.setLayoutResource(2131494804);
    localKeyValuePreference.wV(false);
    localKeyValuePreference.setSummary(paramString1);
    localKeyValuePreference.HET = false;
    localKeyValuePreference.fjq();
    this.screen.a(localKeyValuePreference, xhf);
    AppMethodBeat.o(52010);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(52008);
    this.xhd = new i(this);
    this.screen = getPreferenceScreen();
    this.xhb = com.tencent.mm.plugin.scanner.model.ae.xaP;
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(52004);
        VcardContactUI.this.finish();
        AppMethodBeat.o(52004);
        return true;
      }
    });
    setMMTitle("");
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951753);
    Object localObject = (VcardContactUserHeaderPreference)this.screen.aPN("v_contact_info_header");
    if (localObject != null)
    {
      com.tencent.mm.plugin.scanner.model.ae localae = this.xhb;
      if (localae != null)
      {
        if (!bs.isNullOrNil(localae.xay.bgx())) {
          ((VcardContactUserHeaderPreference)localObject).xhn = localae.xay.bgx();
        }
        if (!bs.isNullOrNil(localae.bLs)) {
          ((VcardContactUserHeaderPreference)localObject).bLs = localae.bLs;
        }
        if (!bs.isNullOrNil(localae.xaM)) {
          ((VcardContactUserHeaderPreference)localObject).xaM = localae.xaM;
        }
        if (!bs.isNullOrNil(localae.title)) {
          ((VcardContactUserHeaderPreference)localObject).title = localae.title;
        }
      }
    }
    this.screen.aPO("c_contact_info_wx_id");
    if (!bs.isNullOrNil(this.xhb.kow))
    {
      localObject = (VcardContactLinkPreference)this.screen.aPN("v_contact_info_photo_uri");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.xhb.kow);
        ((VcardContactLinkPreference)localObject).wV(false);
        ((KeyValuePreference)localObject).HET = false;
        xhe += 2;
        xhf += 2;
      }
      localObject = this.xhb.xaF;
      if ((localObject != null) && (((ae.a)localObject).bgx().length() > 0)) {
        iO(((ae.a)localObject).bgx(), getContext().getString(2131764626));
      }
      localObject = this.xhb.xaG;
      if ((localObject != null) && (((ae.a)localObject).bgx().length() > 0)) {
        iO(((ae.a)localObject).bgx(), getContext().getString(2131764639));
      }
      localObject = this.xhb.xaD;
      if ((localObject != null) && (((ae.a)localObject).bgx().length() > 0)) {
        iO(((ae.a)localObject).bgx(), getContext().getString(2131764621));
      }
      localObject = this.xhb.xaE;
      if ((localObject != null) && (((ae.a)localObject).bgx().length() > 0)) {
        iO(((ae.a)localObject).bgx(), getContext().getString(2131764621));
      }
      localObject = this.xhb.xaJ;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        f((List)localObject, "WorkTel", getContext().getString(2131764640));
      }
      localObject = this.xhb.xaI;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        f((List)localObject, "HomeTel", getContext().getString(2131764628));
      }
      localObject = this.xhb.xaK;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        f((List)localObject, "VideoTEL", getContext().getString(2131764637));
      }
      localObject = this.xhb.xaL;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        f((List)localObject, "NormalTel", getContext().getString(2131764631));
      }
      localObject = this.xhb.xaH;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        f((List)localObject, "CellTel", getContext().getString(2131764624));
      }
      if (bs.isNullOrNil(this.xhb.koE)) {
        break label1047;
      }
      localObject = (KeyValuePreference)this.screen.aPN("v_contact_info_org");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.xhb.koE);
        ((KeyValuePreference)localObject).wV(false);
        ((KeyValuePreference)localObject).HET = true;
      }
      label672:
      if (bs.isNullOrNil(this.xhb.xaN)) {
        break label1063;
      }
      localObject = (KeyValuePreference)this.screen.aPN("v_contact_info_agent");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.xhb.xaN);
        ((KeyValuePreference)localObject).wV(false);
        ((KeyValuePreference)localObject).HET = true;
      }
      label726:
      if (bs.isNullOrNil(this.xhb.url)) {
        break label1079;
      }
      localObject = (VcardContactLinkPreference)this.screen.aPN("v_contact_info_home_page");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.xhb.url);
        ((VcardContactLinkPreference)localObject).wV(false);
        ((KeyValuePreference)localObject).HET = true;
      }
      label780:
      if (bs.isNullOrNil(this.xhb.exO)) {
        break label1108;
      }
      localObject = (VcardContactLinkPreference)this.screen.aPN("v_contact_info_email");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.xhb.exO);
        ((VcardContactLinkPreference)localObject).wV(false);
        ((KeyValuePreference)localObject).HET = true;
      }
      label834:
      if (bs.isNullOrNil(this.xhb.xaC)) {
        break label1124;
      }
      localObject = (KeyValuePreference)this.screen.aPN("v_contact_info_birthday");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.xhb.xaC);
        ((KeyValuePreference)localObject).wV(false);
        ((KeyValuePreference)localObject).HET = true;
      }
      label888:
      if (bs.isNullOrNil(this.xhb.xaO)) {
        break label1153;
      }
      localObject = (KeyValuePreference)this.screen.aPN("v_contact_info_remark");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.xhb.xaO);
        ((KeyValuePreference)localObject).wV(false);
        ((KeyValuePreference)localObject).HET = true;
      }
    }
    for (;;)
    {
      if ((this.xhb.xaA == null) || (!this.xhb.xaA.gSN.contains("uri"))) {
        break label1182;
      }
      localObject = (VcardContactLinkPreference)this.screen.aPN("v_contact_info_logo");
      ((VcardContactLinkPreference)localObject).setSummary(this.xhb.xaA.xaS);
      ((KeyValuePreference)localObject).HET = false;
      ((VcardContactLinkPreference)localObject).wV(false);
      AppMethodBeat.o(52008);
      return;
      this.screen.aPO("v_contact_info_photo_uri");
      this.screen.aPO("v_category_photo_uri");
      break;
      label1047:
      this.screen.aPO("v_contact_info_org");
      break label672;
      label1063:
      this.screen.aPO("v_contact_info_agent");
      break label726;
      label1079:
      this.screen.aPO("v_contact_info_home_page");
      this.screen.aPO("v_category_home_page");
      break label780;
      label1108:
      this.screen.aPO("v_contact_info_email");
      break label834;
      label1124:
      this.screen.aPO("v_contact_info_birthday");
      this.screen.aPO("v_category_birthday");
      break label888;
      label1153:
      this.screen.aPO("v_contact_info_remark");
      this.screen.aPO("v_category_remark");
    }
    label1182:
    this.screen.aPO("v_contact_info_logo");
    this.screen.aPO("v_category_logo");
    AppMethodBeat.o(52008);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(52006);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(52006);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(52007);
    Object localObject;
    if (paramPreference.mKey.equals("add_vcard_contact"))
    {
      paramf = getString(2131764620);
      paramPreference = getString(2131764619);
      localObject = new h.c()
      {
        public final void kG(int paramAnonymousInt)
        {
          AppMethodBeat.i(52005);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(52005);
            return;
            by.azu().d(10238, new Object[] { Integer.valueOf(1) });
            Object localObject = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
            VcardContactUI.a(VcardContactUI.this, (Intent)localObject);
            VcardContactUI localVcardContactUI = VcardContactUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localVcardContactUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(52005);
            return;
            by.azu().d(10239, new Object[] { Integer.valueOf(1) });
            localObject = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
            ((Intent)localObject).setType("vnd.android.cursor.item/person");
            VcardContactUI.a(VcardContactUI.this, (Intent)localObject);
            localVcardContactUI = VcardContactUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localVcardContactUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      };
      h.a(this, "", new String[] { paramf, paramPreference }, "", (h.c)localObject);
      AppMethodBeat.o(52007);
      return true;
    }
    if ((paramPreference.mKey.equals("v_contact_info_photo_uri")) || (paramPreference.mKey.equals("v_contact_info_home_page")) || (paramPreference.mKey.equals("v_contact_info_logo")))
    {
      paramf = paramPreference.getSummary().toString();
      if ((paramf != null) && (paramf.length() > 0) && (URLUtil.isNetworkUrl(paramf)))
      {
        paramPreference = this.xhd;
        if (!paramPreference.vNQ.eVs()) {
          ac.e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
        }
        for (;;)
        {
          AppMethodBeat.o(52007);
          return true;
          if ((paramf == null) || (paramf.length() == 0))
          {
            ac.e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
          }
          else
          {
            paramPreference.url = paramf;
            localObject = (String)g.agR().agA().get(46, null);
            if ((localObject == null) || (((String)localObject).length() == 0))
            {
              paramPreference.b(paramf, (int)System.currentTimeMillis(), new byte[0]);
            }
            else
            {
              g.agi().a(233, paramPreference);
              paramPreference.xho = new k(paramf, null, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
              g.agi().a(paramPreference.xho, 0);
              paramPreference.vNQ.au(3000L, 3000L);
            }
          }
        }
      }
    }
    else if ((xhc.contains(paramPreference.mKey)) && (!paramPreference.mKey.toLowerCase().contains("fax")))
    {
      paramPreference = paramPreference.getSummary().toString().trim();
      if ((paramPreference != null) && (paramPreference.length() > 0))
      {
        paramf = getString(2131757643);
        paramPreference = new VcardContactUI.1(this, paramPreference);
        h.a(this, "", new String[] { paramf }, "", paramPreference);
        AppMethodBeat.o(52007);
        return true;
      }
    }
    else if (paramPreference.mKey.equals("v_contact_info_email"))
    {
      localObject = paramPreference.getSummary().toString();
      paramf = getContext().getString(2131763058);
      paramPreference = getContext().getString(2131763057);
      localObject = new VcardContactUI.2(this, (String)localObject);
      h.a(this, "", new String[] { paramf, paramPreference }, "", (h.c)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI
 * JD-Core Version:    0.7.0.1
 */