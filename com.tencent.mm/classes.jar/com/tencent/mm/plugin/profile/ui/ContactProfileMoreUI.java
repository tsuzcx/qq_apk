package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactProfileMoreUI
  extends MMPreference
  implements l
{
  private String flk;
  w fql;
  private String fss;
  boolean ftK = false;
  private f lxI;
  private af oFt;
  private b uyW;
  
  public final void b(com.tencent.mm.plugin.fts.a.a.k paramk)
  {
    AppMethodBeat.i(27041);
    Preference localPreference = this.lxI.aKk("common_chatroom");
    if (paramk.bRZ == 0)
    {
      int i = ((Integer)((m)paramk.rpQ.get(0)).userData).intValue();
      localPreference.setSummary(getString(2131757637, new Object[] { Integer.valueOf(i) }));
      localPreference.getExtras().putInt("count", i);
    }
    for (;;)
    {
      this.lxI.notifyDataSetChanged();
      AppMethodBeat.o(27041);
      return;
      localPreference.setSummary(getString(2131757637, new Object[] { Integer.valueOf(0) }));
    }
  }
  
  public int getResourceId()
  {
    return 2131951666;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27039);
    super.onCreate(paramBundle);
    setMMTitle(2131755815);
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
    this.ftK = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.fss = getIntent().getStringExtra("Contact_ChatRoomId");
    this.flk = getIntent().getStringExtra("Contact_User");
    az.arV();
    this.oFt = c.apM().aHY(this.flk);
    if (!bt.isNullOrNil(this.fss))
    {
      az.arV();
      this.fql = c.apV().tH(this.fss);
    }
    this.uyW = new b(this, this.oFt);
    f localf = getPreferenceScreen();
    this.lxI = localf;
    paramBundle = this.oFt;
    Object localObject1 = localf.aKk("common_chatroom");
    int i;
    label202:
    Object localObject4;
    if ((af.aHH(paramBundle.field_username)) || (paramBundle.field_username.equals(u.aqG())))
    {
      i = 1;
      if (i == 0) {
        break label786;
      }
      localf.cE("common_chatroom", true);
      paramBundle = this.lxI.aKk("friend_source");
      switch (this.oFt.getSource())
      {
      default: 
        paramBundle.setSummary(null);
        label445:
        if (bt.ai(paramBundle.getSummary())) {
          localf.cE("friend_source", true);
        }
        localObject1 = localf.aKk("district");
        localObject4 = new StringBuilder().append(v.sj(this.oFt.getProvince()));
        if (bt.isNullOrNil(this.oFt.getCity()))
        {
          paramBundle = "";
          label515:
          ((Preference)localObject1).setSummary(paramBundle);
          if (bt.ai(((Preference)localObject1).getSummary())) {
            localf.cE("district", true);
          }
          paramBundle = localf.aKk("signature");
          paramBundle.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, this.oFt.signature));
          if (bt.ai(paramBundle.getSummary())) {
            localf.cE("district", true);
          }
          paramBundle = this.oFt;
          localObject4 = localf.aKk("weishop");
          if (!u.aqG().equals(paramBundle.field_username)) {
            break label1329;
          }
          az.arV();
          paramBundle = (String)c.afk().get(ae.a.Fje, null);
          label644:
          if (bt.isNullOrNil(paramBundle)) {
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
        if (!bt.isNullOrNil(paramBundle))
        {
          ((Preference)localObject4).setSummary((CharSequence)localObject1);
          ((Preference)localObject4).nJy = getResources().getColor(2131100763);
          ((Preference)localObject4).getExtras().putString("shopUrl", paramBundle);
        }
        if (!bt.ai(((Preference)localObject4).getSummary())) {
          break label1359;
        }
        localf.cE("weishop", true);
        localf.cE("contact_info_category_1", true);
        ((CheckBoxPreference)localf.aKk("add_to_black")).lG = this.oFt.ZM();
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
      if (paramBundle.evp == 1)
      {
        ((Preference)localObject1).setTitle(2131757634);
        localObject1 = new j();
        ((j)localObject1).query = paramBundle.field_username;
        ((j)localObject1).rpO = this;
        ((j)localObject1).handler = new ap(Looper.getMainLooper());
        ((j)localObject1).iWB = 5;
        ((n)g.ad(n.class)).search(2, (j)localObject1);
        break label202;
      }
      if (paramBundle.evp == 2)
      {
        ((Preference)localObject1).setTitle(2131757633);
      }
      else
      {
        ((Preference)localObject1).setTitle(2131757638);
        continue;
        paramBundle.setSummary(2131759467);
        break label445;
        if (this.oFt.ZZ() > 1000000)
        {
          paramBundle.setSummary(2131757862);
          break label445;
        }
        paramBundle.setSummary(2131757861);
        break label445;
        if (this.oFt.ZZ() > 1000000)
        {
          paramBundle.setSummary(2131757865);
          break label445;
        }
        paramBundle.setSummary(2131757864);
        break label445;
        if (this.oFt.ZZ() > 1000000)
        {
          paramBundle.setSummary(2131757842);
          break label445;
        }
        paramBundle.setSummary(2131757839);
        break label445;
        if (this.oFt.ZZ() > 1000000)
        {
          paramBundle.setSummary(2131757850);
          break label445;
        }
        paramBundle.setSummary(2131757849);
        break label445;
        if (this.oFt.ZZ() > 1000000)
        {
          paramBundle.setSummary(2131757855);
          break label445;
        }
        paramBundle.setSummary(2131757854);
        break label445;
        paramBundle.setSummary(2131757857);
        break label445;
        if (this.oFt.ZZ() > 1000000)
        {
          paramBundle.setSummary(2131757846);
          break label445;
        }
        paramBundle.setSummary(2131757845);
        break label445;
        if (this.oFt.ZZ() > 1000000)
        {
          paramBundle.setSummary(2131757868);
          break label445;
        }
        paramBundle.setSummary(2131757867);
        break label445;
        paramBundle.setSummary(2131757834);
        break label445;
        paramBundle.setSummary(2131760022);
        break label445;
        paramBundle.setSummary(2131757852);
        break label445;
        if (this.oFt.ZZ() > 1000000)
        {
          paramBundle.setSummary(2131757871);
          break label445;
        }
        paramBundle.setSummary(2131757870);
        break label445;
        if (this.oFt.ZZ() > 1000000)
        {
          paramBundle.setSummary(2131757871);
          break label445;
        }
        paramBundle.setSummary(2131757870);
        break label445;
        if (this.oFt.ZZ() > 1000000)
        {
          paramBundle.setSummary(2131757837);
          break label445;
        }
        paramBundle.setSummary(2131757836);
        break label445;
        if (this.oFt.ZZ() > 1000000)
        {
          paramBundle.setSummary(2131757859);
          break label445;
        }
        paramBundle.setSummary(2131757858);
        break label445;
        paramBundle = "  " + this.oFt.getCity();
        break label515;
        paramBundle = paramBundle.evN;
        break label644;
        label1340:
        ad.printErrStackTrace("MicroMsg.ContactProfileMoreUI", localJSONException1, "", new Object[0]);
        localObject2 = null;
        continue;
        label1359:
        localf.cE("contact_info_category_1", false);
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
    this.uyW.destroy();
    AppMethodBeat.o(27040);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(27038);
    if (paramPreference.mKey.equals("common_chatroom"))
    {
      int i = paramPreference.getExtras().getInt("count", 0);
      e.DD(i);
      if (i > 0)
      {
        paramf = new Intent(this, CommonChatroomInfoUI.class);
        paramf.putExtra("Select_Talker_Name", this.oFt.field_username);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/profile/ui/ContactProfileMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactProfileMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(27038);
      return true;
    }
    if (paramPreference.mKey.equals("weishop"))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", paramPreference.getExtras().getString("shopUrl"));
      paramf.putExtra("geta8key_username", u.aqG());
      d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    for (;;)
    {
      AppMethodBeat.o(27038);
      return false;
      if (paramPreference.mKey.equals("send_to_friend")) {
        this.uyW.dcb();
      } else if (paramPreference.mKey.equals("add_to_black")) {
        this.uyW.nV(false);
      } else if (paramPreference.mKey.equals("expose")) {
        this.uyW.dce();
      } else if (paramPreference.mKey.equals("delete_contact")) {
        this.uyW.dca();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactProfileMoreUI
 * JD-Core Version:    0.7.0.1
 */