package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private String fIQ;
  ac fNS;
  private String fRo;
  boolean fSK = false;
  private f mEx;
  private an pSY;
  private b xeK;
  
  public final void b(com.tencent.mm.plugin.fts.a.a.k paramk)
  {
    AppMethodBeat.i(27041);
    Preference localPreference = this.mEx.aXe("common_chatroom");
    if (paramk.bZU == 0)
    {
      int i = ((Integer)((m)paramk.tGc.get(0)).userData).intValue();
      localPreference.setSummary(getString(2131757637, new Object[] { Integer.valueOf(i) }));
      localPreference.getExtras().putInt("count", i);
    }
    for (;;)
    {
      this.mEx.notifyDataSetChanged();
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
    this.fSK = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.fRo = getIntent().getStringExtra("Contact_ChatRoomId");
    this.fIQ = getIntent().getStringExtra("Contact_User");
    bc.aCg();
    this.pSY = c.azF().BH(this.fIQ);
    if (!bu.isNullOrNil(this.fRo))
    {
      bc.aCg();
      this.fNS = c.azP().Bx(this.fRo);
    }
    this.xeK = new b(this, this.pSY);
    f localf = getPreferenceScreen();
    this.mEx = localf;
    paramBundle = this.pSY;
    Object localObject1 = localf.aXe("common_chatroom");
    int i;
    label202:
    Object localObject4;
    if ((an.aUq(paramBundle.field_username)) || (paramBundle.field_username.equals(v.aAC())))
    {
      i = 1;
      if (i == 0) {
        break label786;
      }
      localf.cT("common_chatroom", true);
      paramBundle = this.mEx.aXe("friend_source");
      switch (this.pSY.getSource())
      {
      default: 
        paramBundle.setSummary(null);
        label445:
        if (bu.ah(paramBundle.getSummary())) {
          localf.cT("friend_source", true);
        }
        localObject1 = localf.aXe("district");
        localObject4 = new StringBuilder().append(w.zR(this.pSY.getProvince()));
        if (bu.isNullOrNil(this.pSY.getCity()))
        {
          paramBundle = "";
          label515:
          ((Preference)localObject1).setSummary(paramBundle);
          if (bu.ah(((Preference)localObject1).getSummary())) {
            localf.cT("district", true);
          }
          paramBundle = localf.aXe("signature");
          paramBundle.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, this.pSY.signature));
          if (bu.ah(paramBundle.getSummary())) {
            localf.cT("district", true);
          }
          paramBundle = this.pSY;
          localObject4 = localf.aXe("weishop");
          if (!v.aAC().equals(paramBundle.field_username)) {
            break label1329;
          }
          bc.aCg();
          paramBundle = (String)c.ajA().get(am.a.INH, null);
          label644:
          if (bu.isNullOrNil(paramBundle)) {
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
        if (!bu.isNullOrNil(paramBundle))
        {
          ((Preference)localObject4).setSummary((CharSequence)localObject1);
          ((Preference)localObject4).oWv = getResources().getColor(2131100763);
          ((Preference)localObject4).getExtras().putString("shopUrl", paramBundle);
        }
        if (!bu.ah(((Preference)localObject4).getSummary())) {
          break label1359;
        }
        localf.cT("weishop", true);
        localf.cT("contact_info_category_1", true);
        ((CheckBoxPreference)localf.aXe("add_to_black")).setChecked(this.pSY.adv());
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
      if (paramBundle.eQV == 1)
      {
        ((Preference)localObject1).setTitle(2131757634);
        localObject1 = new j();
        ((j)localObject1).query = paramBundle.field_username;
        ((j)localObject1).tGa = this;
        ((j)localObject1).handler = new aq(Looper.getMainLooper());
        ((j)localObject1).jUf = 5;
        ((n)g.ad(n.class)).search(2, (j)localObject1);
        break label202;
      }
      if (paramBundle.eQV == 2)
      {
        ((Preference)localObject1).setTitle(2131757633);
      }
      else
      {
        ((Preference)localObject1).setTitle(2131757638);
        continue;
        paramBundle.setSummary(2131759467);
        break label445;
        if (this.pSY.adI() > 1000000)
        {
          paramBundle.setSummary(2131757862);
          break label445;
        }
        paramBundle.setSummary(2131757861);
        break label445;
        if (this.pSY.adI() > 1000000)
        {
          paramBundle.setSummary(2131757865);
          break label445;
        }
        paramBundle.setSummary(2131757864);
        break label445;
        if (this.pSY.adI() > 1000000)
        {
          paramBundle.setSummary(2131757842);
          break label445;
        }
        paramBundle.setSummary(2131757839);
        break label445;
        if (this.pSY.adI() > 1000000)
        {
          paramBundle.setSummary(2131757850);
          break label445;
        }
        paramBundle.setSummary(2131757849);
        break label445;
        if (this.pSY.adI() > 1000000)
        {
          paramBundle.setSummary(2131757855);
          break label445;
        }
        paramBundle.setSummary(2131757854);
        break label445;
        paramBundle.setSummary(2131757857);
        break label445;
        if (this.pSY.adI() > 1000000)
        {
          paramBundle.setSummary(2131757846);
          break label445;
        }
        paramBundle.setSummary(2131757845);
        break label445;
        if (this.pSY.adI() > 1000000)
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
        if (this.pSY.adI() > 1000000)
        {
          paramBundle.setSummary(2131757871);
          break label445;
        }
        paramBundle.setSummary(2131757870);
        break label445;
        if (this.pSY.adI() > 1000000)
        {
          paramBundle.setSummary(2131757871);
          break label445;
        }
        paramBundle.setSummary(2131757870);
        break label445;
        if (this.pSY.adI() > 1000000)
        {
          paramBundle.setSummary(2131757837);
          break label445;
        }
        paramBundle.setSummary(2131757836);
        break label445;
        if (this.pSY.adI() > 1000000)
        {
          paramBundle.setSummary(2131757859);
          break label445;
        }
        paramBundle.setSummary(2131757858);
        break label445;
        paramBundle = "  " + this.pSY.getCity();
        break label515;
        paramBundle = paramBundle.eRt;
        break label644;
        label1340:
        ae.printErrStackTrace("MicroMsg.ContactProfileMoreUI", localJSONException1, "", new Object[0]);
        localObject2 = null;
        continue;
        label1359:
        localf.cT("contact_info_category_1", false);
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
    this.xeK.destroy();
    AppMethodBeat.o(27040);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(27038);
    if (paramPreference.mKey.equals("common_chatroom"))
    {
      int i = paramPreference.getExtras().getInt("count", 0);
      e.Hl(i);
      if (i > 0)
      {
        paramf = new Intent(this, CommonChatroomInfoUI.class);
        paramf.putExtra("Select_Talker_Name", this.pSY.field_username);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/profile/ui/ContactProfileMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactProfileMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(27038);
      return true;
    }
    if (paramPreference.mKey.equals("weishop"))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", paramPreference.getExtras().getString("shopUrl"));
      paramf.putExtra("geta8key_username", v.aAC());
      d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    for (;;)
    {
      AppMethodBeat.o(27038);
      return false;
      if (paramPreference.mKey.equals("send_to_friend")) {
        this.xeK.dDD();
      } else if (paramPreference.mKey.equals("add_to_black")) {
        this.xeK.pw(false);
      } else if (paramPreference.mKey.equals("expose")) {
        this.xeK.dDG();
      } else if (paramPreference.mKey.equals("delete_contact")) {
        this.xeK.dDC();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactProfileMoreUI
 * JD-Core Version:    0.7.0.1
 */