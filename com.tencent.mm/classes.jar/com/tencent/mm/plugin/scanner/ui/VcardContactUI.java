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
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.scanner.model.al;
import com.tencent.mm.plugin.scanner.model.al.a;
import com.tencent.mm.plugin.scanner.model.al.b;
import com.tencent.mm.plugin.scanner.model.al.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.h.d;
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
  private static ArrayList<String> COQ;
  private static int COS;
  private static int COT;
  private al COP;
  private h COR;
  private f screen;
  
  static
  {
    AppMethodBeat.i(52013);
    COQ = new ArrayList();
    COS = 1;
    COT = 1;
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
        if (!COQ.contains(paramString1 + String.valueOf(str))) {
          COQ.add(paramString1 + String.valueOf(str));
        }
        localVcardContactLinkPreference.setTitle(paramString2);
        localVcardContactLinkPreference.setLayoutResource(2131495538);
        localVcardContactLinkPreference.setSummary(str);
        localVcardContactLinkPreference.BC(false);
        localVcardContactLinkPreference.OYB = true;
        localVcardContactLinkPreference.gLK();
        this.screen.a(localVcardContactLinkPreference, COS);
      }
    }
    AppMethodBeat.o(52009);
  }
  
  private void jQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52010);
    KeyValuePreference localKeyValuePreference = new KeyValuePreference(this);
    localKeyValuePreference.setTitle(paramString2);
    localKeyValuePreference.setLayoutResource(2131495538);
    localKeyValuePreference.BC(false);
    localKeyValuePreference.setSummary(paramString1);
    localKeyValuePreference.OYB = false;
    localKeyValuePreference.gLK();
    this.screen.a(localKeyValuePreference, COT);
    AppMethodBeat.o(52010);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(52008);
    this.COR = new h(this);
    this.screen = getPreferenceScreen();
    this.COP = al.CHN;
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
    this.screen.addPreferencesFromResource(2132017298);
    Object localObject = (VcardContactUserHeaderPreference)this.screen.bmg("v_contact_info_header");
    if (localObject != null)
    {
      al localal = this.COP;
      if (localal != null)
      {
        if (!Util.isNullOrNil(localal.CHw.bGg())) {
          ((VcardContactUserHeaderPreference)localObject).fullName = localal.CHw.bGg();
        }
        if (!Util.isNullOrNil(localal.nickName)) {
          ((VcardContactUserHeaderPreference)localObject).nickName = localal.nickName;
        }
        if (!Util.isNullOrNil(localal.CHK)) {
          ((VcardContactUserHeaderPreference)localObject).CHK = localal.CHK;
        }
        if (!Util.isNullOrNil(localal.title)) {
          ((VcardContactUserHeaderPreference)localObject).title = localal.title;
        }
      }
    }
    this.screen.bmi("c_contact_info_wx_id");
    if (!Util.isNullOrNil(this.COP.lRD))
    {
      localObject = (VcardContactLinkPreference)this.screen.bmg("v_contact_info_photo_uri");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.COP.lRD);
        ((VcardContactLinkPreference)localObject).BC(false);
        ((KeyValuePreference)localObject).OYB = false;
        COS += 2;
        COT += 2;
      }
      localObject = this.COP.CHD;
      if ((localObject != null) && (((al.a)localObject).bGg().length() > 0)) {
        jQ(((al.a)localObject).bGg(), getContext().getString(2131766996));
      }
      localObject = this.COP.CHE;
      if ((localObject != null) && (((al.a)localObject).bGg().length() > 0)) {
        jQ(((al.a)localObject).bGg(), getContext().getString(2131767009));
      }
      localObject = this.COP.CHB;
      if ((localObject != null) && (((al.a)localObject).bGg().length() > 0)) {
        jQ(((al.a)localObject).bGg(), getContext().getString(2131766991));
      }
      localObject = this.COP.CHC;
      if ((localObject != null) && (((al.a)localObject).bGg().length() > 0)) {
        jQ(((al.a)localObject).bGg(), getContext().getString(2131766991));
      }
      localObject = this.COP.CHH;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "WorkTel", getContext().getString(2131767010));
      }
      localObject = this.COP.CHG;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "HomeTel", getContext().getString(2131766998));
      }
      localObject = this.COP.CHI;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "VideoTEL", getContext().getString(2131767007));
      }
      localObject = this.COP.CHJ;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "NormalTel", getContext().getString(2131767001));
      }
      localObject = this.COP.CHF;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "CellTel", getContext().getString(2131766994));
      }
      if (Util.isNullOrNil(this.COP.lRL)) {
        break label1047;
      }
      localObject = (KeyValuePreference)this.screen.bmg("v_contact_info_org");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.COP.lRL);
        ((KeyValuePreference)localObject).BC(false);
        ((KeyValuePreference)localObject).OYB = true;
      }
      label672:
      if (Util.isNullOrNil(this.COP.CHL)) {
        break label1063;
      }
      localObject = (KeyValuePreference)this.screen.bmg("v_contact_info_agent");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.COP.CHL);
        ((KeyValuePreference)localObject).BC(false);
        ((KeyValuePreference)localObject).OYB = true;
      }
      label726:
      if (Util.isNullOrNil(this.COP.url)) {
        break label1079;
      }
      localObject = (VcardContactLinkPreference)this.screen.bmg("v_contact_info_home_page");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.COP.url);
        ((VcardContactLinkPreference)localObject).BC(false);
        ((KeyValuePreference)localObject).OYB = true;
      }
      label780:
      if (Util.isNullOrNil(this.COP.fuD)) {
        break label1108;
      }
      localObject = (VcardContactLinkPreference)this.screen.bmg("v_contact_info_email");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.COP.fuD);
        ((VcardContactLinkPreference)localObject).BC(false);
        ((KeyValuePreference)localObject).OYB = true;
      }
      label834:
      if (Util.isNullOrNil(this.COP.CHA)) {
        break label1124;
      }
      localObject = (KeyValuePreference)this.screen.bmg("v_contact_info_birthday");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.COP.CHA);
        ((KeyValuePreference)localObject).BC(false);
        ((KeyValuePreference)localObject).OYB = true;
      }
      label888:
      if (Util.isNullOrNil(this.COP.CHM)) {
        break label1153;
      }
      localObject = (KeyValuePreference)this.screen.bmg("v_contact_info_remark");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.COP.CHM);
        ((KeyValuePreference)localObject).BC(false);
        ((KeyValuePreference)localObject).OYB = true;
      }
    }
    for (;;)
    {
      if ((this.COP.CHy == null) || (!this.COP.CHy.igV.contains("uri"))) {
        break label1182;
      }
      localObject = (VcardContactLinkPreference)this.screen.bmg("v_contact_info_logo");
      ((VcardContactLinkPreference)localObject).setSummary(this.COP.CHy.CHQ);
      ((KeyValuePreference)localObject).OYB = false;
      ((VcardContactLinkPreference)localObject).BC(false);
      AppMethodBeat.o(52008);
      return;
      this.screen.bmi("v_contact_info_photo_uri");
      this.screen.bmi("v_category_photo_uri");
      break;
      label1047:
      this.screen.bmi("v_contact_info_org");
      break label672;
      label1063:
      this.screen.bmi("v_contact_info_agent");
      break label726;
      label1079:
      this.screen.bmi("v_contact_info_home_page");
      this.screen.bmi("v_category_home_page");
      break label780;
      label1108:
      this.screen.bmi("v_contact_info_email");
      break label834;
      label1124:
      this.screen.bmi("v_contact_info_birthday");
      this.screen.bmi("v_category_birthday");
      break label888;
      label1153:
      this.screen.bmi("v_contact_info_remark");
      this.screen.bmi("v_category_remark");
    }
    label1182:
    this.screen.bmi("v_contact_info_logo");
    this.screen.bmi("v_category_logo");
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
      paramf = getString(2131766990);
      paramPreference = getString(2131766989);
      localObject = new h.d()
      {
        public final void oj(int paramAnonymousInt)
        {
          AppMethodBeat.i(52005);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(52005);
            return;
            cf.aWl().f(10238, new Object[] { Integer.valueOf(1) });
            Object localObject = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
            VcardContactUI.a(VcardContactUI.this, (Intent)localObject);
            VcardContactUI localVcardContactUI = VcardContactUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localVcardContactUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(52005);
            return;
            cf.aWl().f(10239, new Object[] { Integer.valueOf(1) });
            localObject = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
            ((Intent)localObject).setType("vnd.android.cursor.item/person");
            VcardContactUI.a(VcardContactUI.this, (Intent)localObject);
            localVcardContactUI = VcardContactUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localVcardContactUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      };
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf, paramPreference }, "", (h.d)localObject);
      AppMethodBeat.o(52007);
      return true;
    }
    if ((paramPreference.mKey.equals("v_contact_info_photo_uri")) || (paramPreference.mKey.equals("v_contact_info_home_page")) || (paramPreference.mKey.equals("v_contact_info_logo")))
    {
      paramf = paramPreference.getSummary().toString();
      if ((paramf != null) && (paramf.length() > 0) && (URLUtil.isNetworkUrl(paramf)))
      {
        paramPreference = this.COR;
        if (!paramPreference.BiQ.stopped()) {
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
            localObject = (String)g.aAh().azQ().get(46, null);
            if ((localObject == null) || (((String)localObject).length() == 0))
            {
              paramPreference.b(paramf, (int)System.currentTimeMillis(), new byte[0]);
            }
            else
            {
              g.azz().a(233, paramPreference);
              paramPreference.CPb = new l(paramf, null, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
              g.azz().a(paramPreference.CPb, 0);
              paramPreference.BiQ.startTimer(3000L);
            }
          }
        }
      }
    }
    else if ((COQ.contains(paramPreference.mKey)) && (!paramPreference.mKey.toLowerCase().contains("fax")))
    {
      paramPreference = paramPreference.getSummary().toString().trim();
      if ((paramPreference != null) && (paramPreference.length() > 0))
      {
        paramf = getString(2131757871);
        paramPreference = new VcardContactUI.1(this, paramPreference);
        com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf }, "", paramPreference);
        AppMethodBeat.o(52007);
        return true;
      }
    }
    else if (paramPreference.mKey.equals("v_contact_info_email"))
    {
      localObject = paramPreference.getSummary().toString();
      paramf = getContext().getString(2131765209);
      paramPreference = getContext().getString(2131765208);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI
 * JD-Core Version:    0.7.0.1
 */