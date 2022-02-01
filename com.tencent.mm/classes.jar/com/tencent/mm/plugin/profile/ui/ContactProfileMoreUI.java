package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactProfileMoreUI
  extends MMPreference
  implements com.tencent.mm.plugin.fts.a.l
{
  private b GWl;
  private String iSn;
  ah iXp;
  private String jaK;
  boolean jhU = false;
  private f mrf;
  private as uNk;
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(27041);
    Preference localPreference = this.mrf.byG("common_chatroom");
    if (paramk.resultCode == 0)
    {
      int i = ((Integer)((m)paramk.BIW.get(0)).BJh).intValue();
      localPreference.aF(getString(R.l.eyq, new Object[] { Integer.valueOf(i) }));
      localPreference.getExtras().putInt("count", i);
    }
    for (;;)
    {
      this.mrf.notifyDataSetChanged();
      AppMethodBeat.o(27041);
      return;
      localPreference.aF(getString(R.l.eyq, new Object[] { Integer.valueOf(0) }));
    }
  }
  
  public int getResourceId()
  {
    return R.o.eXz;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27039);
    super.onCreate(paramBundle);
    setMMTitle(R.l.app_more);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27037);
        ContactProfileMoreUI.this.finish();
        AppMethodBeat.o(27037);
        return true;
      }
    });
    this.jhU = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.jaK = getIntent().getStringExtra("Contact_ChatRoomId");
    this.iSn = getIntent().getStringExtra("Contact_User");
    bh.beI();
    this.uNk = com.tencent.mm.model.c.bbL().RG(this.iSn);
    if (!Util.isNullOrNil(this.jaK))
    {
      bh.beI();
      this.iXp = com.tencent.mm.model.c.bbV().Rw(this.jaK);
    }
    this.GWl = new b(this, this.uNk);
    f localf = getPreferenceScreen();
    this.mrf = localf;
    paramBundle = this.uNk;
    Object localObject1 = localf.byG("common_chatroom");
    int i;
    label203:
    Object localObject4;
    if ((as.bvK(paramBundle.field_username)) || (paramBundle.field_username.equals(z.bcZ())))
    {
      i = 1;
      if (i == 0) {
        break label786;
      }
      localf.dz("common_chatroom", true);
      paramBundle = this.mrf.byG("friend_source");
      switch (this.uNk.getSource())
      {
      default: 
        paramBundle.aF(null);
        label445:
        if (Util.isNullOrNil(paramBundle.fqw())) {
          localf.dz("friend_source", true);
        }
        localObject1 = localf.byG("district");
        localObject4 = new StringBuilder().append(aa.PL(this.uNk.getProvince()));
        if (Util.isNullOrNil(this.uNk.getCity()))
        {
          paramBundle = "";
          label515:
          ((Preference)localObject1).aF(paramBundle);
          if (Util.isNullOrNil(((Preference)localObject1).fqw())) {
            localf.dz("district", true);
          }
          paramBundle = localf.byG("signature");
          paramBundle.aF(com.tencent.mm.pluginsdk.ui.span.l.c(this, this.uNk.signature));
          if (Util.isNullOrNil(paramBundle.fqw())) {
            localf.dz("district", true);
          }
          paramBundle = this.uNk;
          localObject4 = localf.byG("weishop");
          if (!z.bcZ().equals(paramBundle.field_username)) {
            break label1329;
          }
          bh.beI();
          paramBundle = (String)com.tencent.mm.model.c.aHp().get(ar.a.VjK, null);
          label644:
          if (Util.isNullOrNil(paramBundle)) {
            break label1378;
          }
        }
        break;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramBundle);
        paramBundle = ((JSONObject)localObject1).optString("ShopUrl");
      }
      catch (JSONException localJSONException1)
      {
        label786:
        label1329:
        paramBundle = null;
      }
      try
      {
        localObject1 = ((JSONObject)localObject1).optString("ShopName");
        if (!Util.isNullOrNil(paramBundle))
        {
          ((Preference)localObject4).aF((CharSequence)localObject1);
          ((Preference)localObject4).tHk = getResources().getColor(R.e.dkE);
          ((Preference)localObject4).getExtras().putString("shopUrl", paramBundle);
        }
        if (!Util.isNullOrNil(((Preference)localObject4).fqw())) {
          break label1359;
        }
        localf.dz("weishop", true);
        localf.dz("contact_info_category_1", true);
        ((CheckBoxPreference)localf.byG("add_to_black")).setChecked(this.uNk.ayc());
        AppMethodBeat.o(27039);
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject2;
        break label1340;
      }
      i = 0;
      break;
      if (paramBundle.sex == 1)
      {
        ((Preference)localObject1).setTitle(R.l.eyp);
        localObject1 = new j();
        ((j)localObject1).query = paramBundle.field_username;
        ((j)localObject1).BIU = this;
        ((j)localObject1).handler = new MMHandler(Looper.getMainLooper());
        ((j)localObject1).nRn = 5;
        ((n)h.ag(n.class)).search(2, (j)localObject1);
        break label203;
      }
      if (paramBundle.sex == 2)
      {
        ((Preference)localObject1).setTitle(R.l.eyo);
      }
      else
      {
        ((Preference)localObject1).setTitle(R.l.eyr);
        continue;
        paramBundle.auI(R.l.eFi);
        break label445;
        if (this.uNk.ayu() > 1000000)
        {
          paramBundle.auI(R.l.ezU);
          break label445;
        }
        paramBundle.auI(R.l.ezT);
        break label445;
        if (this.uNk.ayu() > 1000000)
        {
          paramBundle.auI(R.l.ezX);
          break label445;
        }
        paramBundle.auI(R.l.ezW);
        break label445;
        if (this.uNk.ayu() > 1000000)
        {
          paramBundle.auI(R.l.ezB);
          break label445;
        }
        paramBundle.auI(R.l.ezy);
        break label445;
        if (this.uNk.ayu() > 1000000)
        {
          paramBundle.auI(R.l.ezJ);
          break label445;
        }
        paramBundle.auI(R.l.ezI);
        break label445;
        if (this.uNk.ayu() > 1000000)
        {
          paramBundle.auI(R.l.ezN);
          break label445;
        }
        paramBundle.auI(R.l.ezM);
        break label445;
        paramBundle.auI(R.l.ezP);
        break label445;
        if (this.uNk.ayu() > 1000000)
        {
          paramBundle.auI(R.l.ezF);
          break label445;
        }
        paramBundle.auI(R.l.ezE);
        break label445;
        if (this.uNk.ayu() > 1000000)
        {
          paramBundle.auI(R.l.eAa);
          break label445;
        }
        paramBundle.auI(R.l.ezZ);
        break label445;
        paramBundle.auI(R.l.ezu);
        break label445;
        paramBundle.auI(R.l.gcontact_from_source);
        break label445;
        paramBundle.auI(R.l.ezL);
        break label445;
        if (this.uNk.ayu() > 1000000)
        {
          paramBundle.auI(R.l.eAd);
          break label445;
        }
        paramBundle.auI(R.l.eAc);
        break label445;
        if (this.uNk.ayu() > 1000000)
        {
          paramBundle.auI(R.l.eAd);
          break label445;
        }
        paramBundle.auI(R.l.eAc);
        break label445;
        if (this.uNk.ayu() > 1000000)
        {
          paramBundle.auI(R.l.ezw);
          break label445;
        }
        paramBundle.auI(R.l.ezv);
        break label445;
        if (this.uNk.ayu() > 1000000)
        {
          paramBundle.auI(R.l.ezR);
          break label445;
        }
        paramBundle.auI(R.l.ezQ);
        break label445;
        paramBundle = "  " + this.uNk.getCity();
        break label515;
        paramBundle = paramBundle.hDv;
        break label644;
        label1340:
        Log.printErrStackTrace("MicroMsg.ContactProfileMoreUI", localJSONException1, "", new Object[0]);
        localObject2 = null;
        continue;
        label1359:
        localf.dz("contact_info_category_1", false);
        continue;
        label1378:
        paramBundle = null;
        Object localObject3 = null;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27040);
    super.onDestroy();
    this.GWl.destroy();
    AppMethodBeat.o(27040);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(27038);
    if (paramPreference.mKey.equals("common_chatroom"))
    {
      int i = paramPreference.getExtras().getInt("count", 0);
      e.Sz(i);
      if (i > 0)
      {
        paramf = new Intent(this, CommonChatroomInfoUI.class);
        paramf.putExtra("Select_Talker_Name", this.uNk.field_username);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/profile/ui/ContactProfileMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/profile/ui/ContactProfileMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(27038);
      return true;
    }
    if (paramPreference.mKey.equals("weishop"))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", paramPreference.getExtras().getString("shopUrl"));
      paramf.putExtra("geta8key_username", z.bcZ());
      com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    for (;;)
    {
      AppMethodBeat.o(27038);
      return false;
      if (paramPreference.mKey.equals("send_to_friend")) {
        this.GWl.fpN();
      } else if (paramPreference.mKey.equals("add_to_black")) {
        this.GWl.vV(false);
      } else if (paramPreference.mKey.equals("expose")) {
        this.GWl.fpQ();
      } else if (paramPreference.mKey.equals("delete_contact")) {
        this.GWl.fpM();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactProfileMoreUI
 * JD-Core Version:    0.7.0.1
 */