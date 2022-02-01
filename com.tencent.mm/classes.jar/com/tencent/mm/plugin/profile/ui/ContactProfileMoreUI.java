package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
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
  private b Bcm;
  private String goe;
  ah gtd;
  private String gwx;
  boolean gxS = false;
  private f nRm;
  private as rjX;
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(27041);
    Preference localPreference = this.nRm.bmg("common_chatroom");
    if (paramk.resultCode == 0)
    {
      int i = ((Integer)((m)paramk.wXb.get(0)).userData).intValue();
      localPreference.setSummary(getString(2131757865, new Object[] { Integer.valueOf(i) }));
      localPreference.getExtras().putInt("count", i);
    }
    for (;;)
    {
      this.nRm.notifyDataSetChanged();
      AppMethodBeat.o(27041);
      return;
      localPreference.setSummary(getString(2131757865, new Object[] { Integer.valueOf(0) }));
    }
  }
  
  public int getResourceId()
  {
    return 2132017204;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27039);
    super.onCreate(paramBundle);
    setMMTitle(2131755899);
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
    this.gxS = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.gwx = getIntent().getStringExtra("Contact_ChatRoomId");
    this.goe = getIntent().getStringExtra("Contact_User");
    bg.aVF();
    this.rjX = com.tencent.mm.model.c.aSN().Kn(this.goe);
    if (!Util.isNullOrNil(this.gwx))
    {
      bg.aVF();
      this.gtd = com.tencent.mm.model.c.aSX().Kd(this.gwx);
    }
    this.Bcm = new b(this, this.rjX);
    f localf = getPreferenceScreen();
    this.nRm = localf;
    paramBundle = this.rjX;
    Object localObject1 = localf.bmg("common_chatroom");
    int i;
    label202:
    Object localObject4;
    if ((as.bjp(paramBundle.field_username)) || (paramBundle.field_username.equals(z.aTY())))
    {
      i = 1;
      if (i == 0) {
        break label786;
      }
      localf.jdMethod_do("common_chatroom", true);
      paramBundle = this.nRm.bmg("friend_source");
      switch (this.rjX.getSource())
      {
      default: 
        paramBundle.setSummary(null);
        label445:
        if (Util.isNullOrNil(paramBundle.getSummary())) {
          localf.jdMethod_do("friend_source", true);
        }
        localObject1 = localf.bmg("district");
        localObject4 = new StringBuilder().append(aa.It(this.rjX.getProvince()));
        if (Util.isNullOrNil(this.rjX.getCity()))
        {
          paramBundle = "";
          label515:
          ((Preference)localObject1).setSummary(paramBundle);
          if (Util.isNullOrNil(((Preference)localObject1).getSummary())) {
            localf.jdMethod_do("district", true);
          }
          paramBundle = localf.bmg("signature");
          paramBundle.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, this.rjX.signature));
          if (Util.isNullOrNil(paramBundle.getSummary())) {
            localf.jdMethod_do("district", true);
          }
          paramBundle = this.rjX;
          localObject4 = localf.bmg("weishop");
          if (!z.aTY().equals(paramBundle.field_username)) {
            break label1329;
          }
          bg.aVF();
          paramBundle = (String)com.tencent.mm.model.c.azQ().get(ar.a.NVK, null);
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
          ((Preference)localObject4).setSummary((CharSequence)localObject1);
          ((Preference)localObject4).qlp = getResources().getColor(2131100959);
          ((Preference)localObject4).getExtras().putString("shopUrl", paramBundle);
        }
        if (!Util.isNullOrNil(((Preference)localObject4).getSummary())) {
          break label1359;
        }
        localf.jdMethod_do("weishop", true);
        localf.jdMethod_do("contact_info_category_1", true);
        ((CheckBoxPreference)localf.bmg("add_to_black")).setChecked(this.rjX.ary());
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
      if (paramBundle.fuA == 1)
      {
        ((Preference)localObject1).setTitle(2131757862);
        localObject1 = new j();
        ((j)localObject1).query = paramBundle.field_username;
        ((j)localObject1).wWZ = this;
        ((j)localObject1).handler = new MMHandler(Looper.getMainLooper());
        ((j)localObject1).kXb = 5;
        ((n)g.ah(n.class)).search(2, (j)localObject1);
        break label202;
      }
      if (paramBundle.fuA == 2)
      {
        ((Preference)localObject1).setTitle(2131757861);
      }
      else
      {
        ((Preference)localObject1).setTitle(2131757866);
        continue;
        paramBundle.setSummary(2131760782);
        break label445;
        if (this.rjX.arL() > 1000000)
        {
          paramBundle.setSummary(2131758102);
          break label445;
        }
        paramBundle.setSummary(2131758101);
        break label445;
        if (this.rjX.arL() > 1000000)
        {
          paramBundle.setSummary(2131758105);
          break label445;
        }
        paramBundle.setSummary(2131758104);
        break label445;
        if (this.rjX.arL() > 1000000)
        {
          paramBundle.setSummary(2131758082);
          break label445;
        }
        paramBundle.setSummary(2131758079);
        break label445;
        if (this.rjX.arL() > 1000000)
        {
          paramBundle.setSummary(2131758090);
          break label445;
        }
        paramBundle.setSummary(2131758089);
        break label445;
        if (this.rjX.arL() > 1000000)
        {
          paramBundle.setSummary(2131758095);
          break label445;
        }
        paramBundle.setSummary(2131758094);
        break label445;
        paramBundle.setSummary(2131758097);
        break label445;
        if (this.rjX.arL() > 1000000)
        {
          paramBundle.setSummary(2131758086);
          break label445;
        }
        paramBundle.setSummary(2131758085);
        break label445;
        if (this.rjX.arL() > 1000000)
        {
          paramBundle.setSummary(2131758108);
          break label445;
        }
        paramBundle.setSummary(2131758107);
        break label445;
        paramBundle.setSummary(2131758074);
        break label445;
        paramBundle.setSummary(2131761400);
        break label445;
        paramBundle.setSummary(2131758092);
        break label445;
        if (this.rjX.arL() > 1000000)
        {
          paramBundle.setSummary(2131758111);
          break label445;
        }
        paramBundle.setSummary(2131758110);
        break label445;
        if (this.rjX.arL() > 1000000)
        {
          paramBundle.setSummary(2131758111);
          break label445;
        }
        paramBundle.setSummary(2131758110);
        break label445;
        if (this.rjX.arL() > 1000000)
        {
          paramBundle.setSummary(2131758077);
          break label445;
        }
        paramBundle.setSummary(2131758076);
        break label445;
        if (this.rjX.arL() > 1000000)
        {
          paramBundle.setSummary(2131758099);
          break label445;
        }
        paramBundle.setSummary(2131758098);
        break label445;
        paramBundle = "  " + this.rjX.getCity();
        break label515;
        paramBundle = paramBundle.fuW;
        break label644;
        label1340:
        Log.printErrStackTrace("MicroMsg.ContactProfileMoreUI", localJSONException1, "", new Object[0]);
        localObject2 = null;
        continue;
        label1359:
        localf.jdMethod_do("contact_info_category_1", false);
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
    this.Bcm.destroy();
    AppMethodBeat.o(27040);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(27038);
    if (paramPreference.mKey.equals("common_chatroom"))
    {
      int i = paramPreference.getExtras().getInt("count", 0);
      e.Nl(i);
      if (i > 0)
      {
        paramf = new Intent(this, CommonChatroomInfoUI.class);
        paramf.putExtra("Select_Talker_Name", this.rjX.field_username);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/profile/ui/ContactProfileMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactProfileMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(27038);
      return true;
    }
    if (paramPreference.mKey.equals("weishop"))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", paramPreference.getExtras().getString("shopUrl"));
      paramf.putExtra("geta8key_username", z.aTY());
      com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    for (;;)
    {
      AppMethodBeat.o(27038);
      return false;
      if (paramPreference.mKey.equals("send_to_friend")) {
        this.Bcm.eDU();
      } else if (paramPreference.mKey.equals("add_to_black")) {
        this.Bcm.sE(false);
      } else if (paramPreference.mKey.equals("expose")) {
        this.Bcm.eDX();
      } else if (paramPreference.mKey.equals("delete_contact")) {
        this.Bcm.eDT();
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