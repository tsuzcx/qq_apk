package com.tencent.mm.plugin.profile.ui;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.profile.logic.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactProfileMoreUI
  extends MMPreference
  implements com.tencent.mm.plugin.fts.a.l
{
  public b MTQ;
  boolean lKk = false;
  private String luk;
  private String lyn;
  aj lzy;
  private f pkD;
  private au xVS;
  
  public final void b(m paramm)
  {
    AppMethodBeat.i(27041);
    Preference localPreference = this.pkD.bAi("common_chatroom");
    if (paramm.resultCode == 0)
    {
      int i = ((Integer)((o)paramm.HtF.get(0)).HtQ).intValue();
      localPreference.aS(getString(R.l.gBi, new Object[] { Integer.valueOf(i) }));
      localPreference.getExtras().putInt("count", i);
    }
    for (;;)
    {
      this.pkD.notifyDataSetChanged();
      AppMethodBeat.o(27041);
      return;
      localPreference.aS(getString(R.l.gBi, new Object[] { Integer.valueOf(0) }));
    }
  }
  
  public int getResourceId()
  {
    return R.o.hba;
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
    this.lKk = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.lyn = getIntent().getStringExtra("Contact_ChatRoomId");
    this.luk = getIntent().getStringExtra("Contact_User");
    bh.bCz();
    this.xVS = com.tencent.mm.model.c.bzA().JE(this.luk);
    if (!Util.isNullOrNil(this.lyn))
    {
      bh.bCz();
      this.lzy = com.tencent.mm.model.c.bzK().Ju(this.lyn);
    }
    this.MTQ = new b(this, this.xVS);
    f localf = getPreferenceScreen();
    this.pkD = localf;
    paramBundle = this.xVS;
    Object localObject1 = localf.bAi("common_chatroom");
    int i;
    label203:
    Object localObject4;
    if ((au.bwO(paramBundle.field_username)) || (paramBundle.field_username.equals(z.bAM())))
    {
      i = 1;
      if (i == 0) {
        break label919;
      }
      localf.eh("common_chatroom", true);
      paramBundle = this.pkD.bAi("friend_source");
      switch (this.xVS.getSource())
      {
      default: 
        paramBundle.aS(null);
        label445:
        if (Util.isNullOrNil(paramBundle.gBR())) {
          localf.eh("friend_source", true);
        }
        localObject1 = localf.bAi("district");
        localObject4 = new StringBuilder().append(aa.IF(this.xVS.getProvince()));
        if (Util.isNullOrNil(this.xVS.getCity()))
        {
          paramBundle = "";
          label515:
          ((Preference)localObject1).aS(paramBundle);
          if (Util.isNullOrNil(((Preference)localObject1).gBR())) {
            localf.eh("district", true);
          }
          paramBundle = localf.bAi("signature");
          paramBundle.aS(p.b(this, this.xVS.signature));
          if (Util.isNullOrNil(paramBundle.gBR())) {
            localf.eh("district", true);
          }
          paramBundle = this.xVS;
          localObject4 = localf.bAi("weishop");
          if (!z.bAM().equals(paramBundle.field_username)) {
            break label1462;
          }
          bh.bCz();
          paramBundle = (String)com.tencent.mm.model.c.ban().get(at.a.acLe, null);
          label644:
          if (Util.isNullOrNil(paramBundle)) {
            break label1511;
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
        label919:
        label1462:
        paramBundle = null;
      }
      try
      {
        localObject1 = ((JSONObject)localObject1).optString("ShopName");
        if (!Util.isNullOrNil(paramBundle))
        {
          ((Preference)localObject4).aS((CharSequence)localObject1);
          ((Preference)localObject4).wKL = getResources().getColor(R.e.fkT);
          ((Preference)localObject4).getExtras().putString("shopUrl", paramBundle);
        }
        if (!Util.isNullOrNil(((Preference)localObject4).gBR())) {
          break label1492;
        }
        localf.eh("weishop", true);
        localf.eh("contact_info_category_1", true);
        ((CheckBoxPreference)localf.bAi("add_to_black")).setChecked(this.xVS.aSF());
        paramBundle = new ArrayList();
        paramBundle.add(Integer.valueOf(1));
        paramBundle.add(Integer.valueOf(2));
        paramBundle.add(Integer.valueOf(3));
        paramBundle.add(Integer.valueOf(10));
        paramBundle.add(Integer.valueOf(13));
        paramBundle.add(Integer.valueOf(15));
        paramBundle.add(Integer.valueOf(30));
        if ((!d.rs(this.xVS.field_type)) && (paramBundle.contains(Integer.valueOf(this.MTQ.pUt)))) {
          localf.eh("expose", true);
        }
        AppMethodBeat.o(27039);
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject2;
        break label1473;
      }
      i = 0;
      break;
      if (paramBundle.sex == 1)
      {
        ((Preference)localObject1).setTitle(R.l.gBh);
        localObject1 = new com.tencent.mm.plugin.fts.a.a.l();
        ((com.tencent.mm.plugin.fts.a.a.l)localObject1).query = paramBundle.field_username;
        ((com.tencent.mm.plugin.fts.a.a.l)localObject1).HtC = this;
        ((com.tencent.mm.plugin.fts.a.a.l)localObject1).handler = new MMHandler(Looper.getMainLooper());
        ((com.tencent.mm.plugin.fts.a.a.l)localObject1).qRb = 5;
        ((n)h.az(n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.l)localObject1);
        break label203;
      }
      if (paramBundle.sex == 2)
      {
        ((Preference)localObject1).setTitle(R.l.gBg);
      }
      else
      {
        ((Preference)localObject1).setTitle(R.l.gBj);
        continue;
        paramBundle.aBk(R.l.gIc);
        break label445;
        if (this.xVS.aSX() > 1000000)
        {
          paramBundle.aBk(R.l.gCL);
          break label445;
        }
        paramBundle.aBk(R.l.gCK);
        break label445;
        if (this.xVS.aSX() > 1000000)
        {
          paramBundle.aBk(R.l.gCO);
          break label445;
        }
        paramBundle.aBk(R.l.gCN);
        break label445;
        if (this.xVS.aSX() > 1000000)
        {
          paramBundle.aBk(R.l.gCq);
          break label445;
        }
        paramBundle.aBk(R.l.gCn);
        break label445;
        if (this.xVS.aSX() > 1000000)
        {
          paramBundle.aBk(R.l.gCA);
          break label445;
        }
        paramBundle.aBk(R.l.gCz);
        break label445;
        if (this.xVS.aSX() > 1000000)
        {
          paramBundle.aBk(R.l.gCE);
          break label445;
        }
        paramBundle.aBk(R.l.gCD);
        break label445;
        paramBundle.aBk(R.l.gCG);
        break label445;
        if (this.xVS.aSX() > 1000000)
        {
          paramBundle.aBk(R.l.gCu);
          break label445;
        }
        paramBundle.aBk(R.l.gCt);
        break label445;
        if (this.xVS.aSX() > 1000000)
        {
          paramBundle.aBk(R.l.gCR);
          break label445;
        }
        paramBundle.aBk(R.l.gCQ);
        break label445;
        paramBundle.aBk(R.l.gCj);
        break label445;
        paramBundle.aBk(R.l.gcontact_from_source);
        break label445;
        paramBundle.aBk(R.l.gCC);
        break label445;
        if (this.xVS.aSX() > 1000000)
        {
          paramBundle.aBk(R.l.gCU);
          break label445;
        }
        paramBundle.aBk(R.l.gCT);
        break label445;
        if (this.xVS.aSX() > 1000000)
        {
          paramBundle.aBk(R.l.gCU);
          break label445;
        }
        paramBundle.aBk(R.l.gCT);
        break label445;
        if (this.xVS.aSX() > 1000000)
        {
          paramBundle.aBk(R.l.gCl);
          break label445;
        }
        paramBundle.aBk(R.l.gCk);
        break label445;
        if (this.xVS.aSX() > 1000000)
        {
          paramBundle.aBk(R.l.gCI);
          break label445;
        }
        paramBundle.aBk(R.l.gCH);
        break label445;
        paramBundle = "  " + this.xVS.getCity();
        break label515;
        paramBundle = paramBundle.kaq;
        break label644;
        label1473:
        Log.printErrStackTrace("MicroMsg.ContactProfileMoreUI", localJSONException1, "", new Object[0]);
        localObject2 = null;
        continue;
        label1492:
        localf.eh("contact_info_category_1", false);
        continue;
        label1511:
        paramBundle = null;
        Object localObject3 = null;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27040);
    super.onDestroy();
    this.MTQ.destroy();
    AppMethodBeat.o(27040);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(27038);
    if (paramPreference.mKey.equals("common_chatroom"))
    {
      int i = paramPreference.getExtras().getInt("count", 0);
      e.Wg(i);
      if (i > 0)
      {
        paramf = new Intent(this, CommonChatroomInfoUI.class);
        paramf.putExtra("Select_Talker_Name", this.xVS.field_username);
        paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/profile/ui/ContactProfileMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/profile/ui/ContactProfileMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(27038);
      return true;
    }
    if (paramPreference.mKey.equals("weishop"))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", paramPreference.getExtras().getString("shopUrl"));
      paramf.putExtra("geta8key_username", z.bAM());
      com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    for (;;)
    {
      AppMethodBeat.o(27038);
      return false;
      if (paramPreference.mKey.equals("send_to_friend")) {
        this.MTQ.gBb();
      } else if (paramPreference.mKey.equals("add_to_black")) {
        this.MTQ.Ar(false);
      } else if (paramPreference.mKey.equals("expose")) {
        this.MTQ.gBe();
      } else if (paramPreference.mKey.equals("delete_contact")) {
        this.MTQ.gBa();
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