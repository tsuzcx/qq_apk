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
import com.tencent.mm.model.cb;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.scanner.model.ai;
import com.tencent.mm.plugin.scanner.model.ai.a;
import com.tencent.mm.plugin.scanner.model.ai.b;
import com.tencent.mm.plugin.scanner.model.ai.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
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
  private static ArrayList<String> yLd;
  private static int yLf;
  private static int yLg;
  private f screen;
  private ai yLc;
  private i yLe;
  
  static
  {
    AppMethodBeat.i(52013);
    yLd = new ArrayList();
    yLf = 1;
    yLg = 1;
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
        if (!yLd.contains(paramString1 + String.valueOf(str))) {
          yLd.add(paramString1 + String.valueOf(str));
        }
        localVcardContactLinkPreference.setTitle(paramString2);
        localVcardContactLinkPreference.setLayoutResource(2131494804);
        localVcardContactLinkPreference.setSummary(str);
        localVcardContactLinkPreference.xN(false);
        localVcardContactLinkPreference.JNz = true;
        localVcardContactLinkPreference.fDH();
        this.screen.a(localVcardContactLinkPreference, yLf);
      }
    }
    AppMethodBeat.o(52009);
  }
  
  private void jf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52010);
    KeyValuePreference localKeyValuePreference = new KeyValuePreference(this);
    localKeyValuePreference.setTitle(paramString2);
    localKeyValuePreference.setLayoutResource(2131494804);
    localKeyValuePreference.xN(false);
    localKeyValuePreference.setSummary(paramString1);
    localKeyValuePreference.JNz = false;
    localKeyValuePreference.fDH();
    this.screen.a(localKeyValuePreference, yLg);
    AppMethodBeat.o(52010);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(52008);
    this.yLe = new i(this);
    this.screen = getPreferenceScreen();
    this.yLc = ai.yEN;
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
    Object localObject = (VcardContactUserHeaderPreference)this.screen.aXe("v_contact_info_header");
    if (localObject != null)
    {
      ai localai = this.yLc;
      if (localai != null)
      {
        if (!bu.isNullOrNil(localai.yEw.bkK())) {
          ((VcardContactUserHeaderPreference)localObject).yLo = localai.yEw.bkK();
        }
        if (!bu.isNullOrNil(localai.bVF)) {
          ((VcardContactUserHeaderPreference)localObject).bVF = localai.bVF;
        }
        if (!bu.isNullOrNil(localai.yEK)) {
          ((VcardContactUserHeaderPreference)localObject).yEK = localai.yEK;
        }
        if (!bu.isNullOrNil(localai.title)) {
          ((VcardContactUserHeaderPreference)localObject).title = localai.title;
        }
      }
    }
    this.screen.aXf("c_contact_info_wx_id");
    if (!bu.isNullOrNil(this.yLc.kML))
    {
      localObject = (VcardContactLinkPreference)this.screen.aXe("v_contact_info_photo_uri");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.yLc.kML);
        ((VcardContactLinkPreference)localObject).xN(false);
        ((KeyValuePreference)localObject).JNz = false;
        yLf += 2;
        yLg += 2;
      }
      localObject = this.yLc.yED;
      if ((localObject != null) && (((ai.a)localObject).bkK().length() > 0)) {
        jf(((ai.a)localObject).bkK(), getContext().getString(2131764626));
      }
      localObject = this.yLc.yEE;
      if ((localObject != null) && (((ai.a)localObject).bkK().length() > 0)) {
        jf(((ai.a)localObject).bkK(), getContext().getString(2131764639));
      }
      localObject = this.yLc.yEB;
      if ((localObject != null) && (((ai.a)localObject).bkK().length() > 0)) {
        jf(((ai.a)localObject).bkK(), getContext().getString(2131764621));
      }
      localObject = this.yLc.yEC;
      if ((localObject != null) && (((ai.a)localObject).bkK().length() > 0)) {
        jf(((ai.a)localObject).bkK(), getContext().getString(2131764621));
      }
      localObject = this.yLc.yEH;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "WorkTel", getContext().getString(2131764640));
      }
      localObject = this.yLc.yEG;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "HomeTel", getContext().getString(2131764628));
      }
      localObject = this.yLc.yEI;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "VideoTEL", getContext().getString(2131764637));
      }
      localObject = this.yLc.yEJ;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "NormalTel", getContext().getString(2131764631));
      }
      localObject = this.yLc.yEF;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        g((List)localObject, "CellTel", getContext().getString(2131764624));
      }
      if (bu.isNullOrNil(this.yLc.kMT)) {
        break label1047;
      }
      localObject = (KeyValuePreference)this.screen.aXe("v_contact_info_org");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.yLc.kMT);
        ((KeyValuePreference)localObject).xN(false);
        ((KeyValuePreference)localObject).JNz = true;
      }
      label672:
      if (bu.isNullOrNil(this.yLc.yEL)) {
        break label1063;
      }
      localObject = (KeyValuePreference)this.screen.aXe("v_contact_info_agent");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.yLc.yEL);
        ((KeyValuePreference)localObject).xN(false);
        ((KeyValuePreference)localObject).JNz = true;
      }
      label726:
      if (bu.isNullOrNil(this.yLc.url)) {
        break label1079;
      }
      localObject = (VcardContactLinkPreference)this.screen.aXe("v_contact_info_home_page");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.yLc.url);
        ((VcardContactLinkPreference)localObject).xN(false);
        ((KeyValuePreference)localObject).JNz = true;
      }
      label780:
      if (bu.isNullOrNil(this.yLc.eQY)) {
        break label1108;
      }
      localObject = (VcardContactLinkPreference)this.screen.aXe("v_contact_info_email");
      if (localObject != null)
      {
        ((VcardContactLinkPreference)localObject).setSummary(this.yLc.eQY);
        ((VcardContactLinkPreference)localObject).xN(false);
        ((KeyValuePreference)localObject).JNz = true;
      }
      label834:
      if (bu.isNullOrNil(this.yLc.yEA)) {
        break label1124;
      }
      localObject = (KeyValuePreference)this.screen.aXe("v_contact_info_birthday");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.yLc.yEA);
        ((KeyValuePreference)localObject).xN(false);
        ((KeyValuePreference)localObject).JNz = true;
      }
      label888:
      if (bu.isNullOrNil(this.yLc.yEM)) {
        break label1153;
      }
      localObject = (KeyValuePreference)this.screen.aXe("v_contact_info_remark");
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).setSummary(this.yLc.yEM);
        ((KeyValuePreference)localObject).xN(false);
        ((KeyValuePreference)localObject).JNz = true;
      }
    }
    for (;;)
    {
      if ((this.yLc.yEy == null) || (!this.yLc.yEy.hnC.contains("uri"))) {
        break label1182;
      }
      localObject = (VcardContactLinkPreference)this.screen.aXe("v_contact_info_logo");
      ((VcardContactLinkPreference)localObject).setSummary(this.yLc.yEy.yEQ);
      ((KeyValuePreference)localObject).JNz = false;
      ((VcardContactLinkPreference)localObject).xN(false);
      AppMethodBeat.o(52008);
      return;
      this.screen.aXf("v_contact_info_photo_uri");
      this.screen.aXf("v_category_photo_uri");
      break;
      label1047:
      this.screen.aXf("v_contact_info_org");
      break label672;
      label1063:
      this.screen.aXf("v_contact_info_agent");
      break label726;
      label1079:
      this.screen.aXf("v_contact_info_home_page");
      this.screen.aXf("v_category_home_page");
      break label780;
      label1108:
      this.screen.aXf("v_contact_info_email");
      break label834;
      label1124:
      this.screen.aXf("v_contact_info_birthday");
      this.screen.aXf("v_category_birthday");
      break label888;
      label1153:
      this.screen.aXf("v_contact_info_remark");
      this.screen.aXf("v_category_remark");
    }
    label1182:
    this.screen.aXf("v_contact_info_logo");
    this.screen.aXf("v_category_logo");
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
        public final void lh(int paramAnonymousInt)
        {
          AppMethodBeat.i(52005);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(52005);
            return;
            cb.aCN().d(10238, new Object[] { Integer.valueOf(1) });
            Object localObject = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
            VcardContactUI.a(VcardContactUI.this, (Intent)localObject);
            VcardContactUI localVcardContactUI = VcardContactUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localVcardContactUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(52005);
            return;
            cb.aCN().d(10239, new Object[] { Integer.valueOf(1) });
            localObject = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
            ((Intent)localObject).setType("vnd.android.cursor.item/person");
            VcardContactUI.a(VcardContactUI.this, (Intent)localObject);
            localVcardContactUI = VcardContactUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localVcardContactUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
        paramPreference = this.yLe;
        if (!paramPreference.xkQ.foU()) {
          ae.e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
        }
        for (;;)
        {
          AppMethodBeat.o(52007);
          return true;
          if ((paramf == null) || (paramf.length() == 0))
          {
            ae.e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
          }
          else
          {
            paramPreference.url = paramf;
            localObject = (String)g.ajR().ajA().get(46, null);
            if ((localObject == null) || (((String)localObject).length() == 0))
            {
              paramPreference.b(paramf, (int)System.currentTimeMillis(), new byte[0]);
            }
            else
            {
              g.ajj().a(233, paramPreference);
              paramPreference.yLp = new l(paramf, null, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
              g.ajj().a(paramPreference.yLp, 0);
              paramPreference.xkQ.ay(3000L, 3000L);
            }
          }
        }
      }
    }
    else if ((yLd.contains(paramPreference.mKey)) && (!paramPreference.mKey.toLowerCase().contains("fax")))
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