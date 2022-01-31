package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.z;
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
  private String eaX;
  u efi;
  private String egF;
  boolean egW = false;
  private f iLA;
  private ad lpe;
  private b pxo;
  
  public final void b(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(23425);
    Preference localPreference = this.iLA.atx("common_chatroom");
    if (paramj.bpE == 0)
    {
      int i = ((Integer)((com.tencent.mm.plugin.fts.a.a.l)paramj.mSW.get(0)).userData).intValue();
      localPreference.setSummary(getString(2131298578, new Object[] { Integer.valueOf(i) }));
      localPreference.getExtras().putInt("count", i);
    }
    for (;;)
    {
      this.iLA.notifyDataSetChanged();
      AppMethodBeat.o(23425);
      return;
      localPreference.setSummary(getString(2131298578, new Object[] { Integer.valueOf(0) }));
    }
  }
  
  public int getResourceId()
  {
    return 2131165230;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23424);
    super.onCreate(paramBundle);
    setMMTitle(2131296998);
    setBackBtn(new ContactProfileMoreUI.1(this));
    this.egW = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.egF = getIntent().getStringExtra("Contact_ChatRoomId");
    this.eaX = getIntent().getStringExtra("Contact_User");
    aw.aaz();
    this.lpe = c.YA().arw(this.eaX);
    if (!bo.isNullOrNil(this.egF))
    {
      aw.aaz();
      this.efi = c.YJ().oU(this.egF);
    }
    this.pxo = new b(this, this.lpe);
    f localf = getPreferenceScreen();
    this.iLA = localf;
    paramBundle = this.lpe;
    Object localObject1 = localf.atx("common_chatroom");
    int i;
    label201:
    Object localObject4;
    if ((ad.arf(paramBundle.field_username)) || (paramBundle.field_username.equals(r.Zn())))
    {
      i = 1;
      if (i == 0) {
        break label781;
      }
      localf.cl("common_chatroom", true);
      paramBundle = this.iLA.atx("friend_source");
      switch (this.lpe.getSource())
      {
      default: 
        paramBundle.setSummary(null);
        label445:
        if (bo.aa(paramBundle.getSummary())) {
          localf.cl("friend_source", true);
        }
        localObject1 = localf.atx("district");
        localObject4 = new StringBuilder().append(s.nG(this.lpe.getProvince()));
        if (bo.isNullOrNil(this.lpe.getCity()))
        {
          paramBundle = "";
          label514:
          ((Preference)localObject1).setSummary(paramBundle);
          if (bo.aa(((Preference)localObject1).getSummary())) {
            localf.cl("district", true);
          }
          paramBundle = localf.atx("signature");
          paramBundle.setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this, this.lpe.signature));
          if (bo.aa(paramBundle.getSummary())) {
            localf.cl("district", true);
          }
          paramBundle = this.lpe;
          localObject4 = localf.atx("weishop");
          if (!r.Zn().equals(paramBundle.field_username)) {
            break label1324;
          }
          aw.aaz();
          paramBundle = (String)c.Ru().get(ac.a.yAI, null);
          label641:
          if (bo.isNullOrNil(paramBundle)) {
            break label1372;
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
        label781:
        label1324:
        paramBundle = null;
      }
      try
      {
        localObject1 = ((JSONObject)localObject1).optString("ShopName");
        if (!bo.isNullOrNil(paramBundle))
        {
          ((Preference)localObject4).setSummary((CharSequence)localObject1);
          ((Preference)localObject4).kCA = getResources().getColor(2131690782);
          ((Preference)localObject4).getExtras().putString("shopUrl", paramBundle);
        }
        if (!bo.aa(((Preference)localObject4).getSummary())) {
          break label1354;
        }
        localf.cl("weishop", true);
        localf.cl("contact_info_category_1", true);
        ((CheckBoxPreference)localf.atx("add_to_black")).vxW = this.lpe.NW();
        AppMethodBeat.o(23424);
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject2;
        break label1335;
      }
      i = 0;
      break;
      if (paramBundle.dqC == 1)
      {
        ((Preference)localObject1).setTitle(2131298575);
        localObject1 = new i();
        ((i)localObject1).query = paramBundle.field_username;
        ((i)localObject1).mSU = this;
        ((i)localObject1).handler = new ak(Looper.getMainLooper());
        ((i)localObject1).hdl = 5;
        ((n)g.G(n.class)).search(2, (i)localObject1);
        break label201;
      }
      if (paramBundle.dqC == 2)
      {
        ((Preference)localObject1).setTitle(2131298574);
      }
      else
      {
        ((Preference)localObject1).setTitle(2131298579);
        continue;
        paramBundle.setSummary(2131300001);
        break label445;
        if (this.lpe.Oh() > 1000000)
        {
          paramBundle.setSummary(2131298799);
          break label445;
        }
        paramBundle.setSummary(2131298798);
        break label445;
        if (this.lpe.Oh() > 1000000)
        {
          paramBundle.setSummary(2131298802);
          break label445;
        }
        paramBundle.setSummary(2131298801);
        break label445;
        if (this.lpe.Oh() > 1000000)
        {
          paramBundle.setSummary(2131298779);
          break label445;
        }
        paramBundle.setSummary(2131298776);
        break label445;
        if (this.lpe.Oh() > 1000000)
        {
          paramBundle.setSummary(2131298787);
          break label445;
        }
        paramBundle.setSummary(2131298786);
        break label445;
        if (this.lpe.Oh() > 1000000)
        {
          paramBundle.setSummary(2131298792);
          break label445;
        }
        paramBundle.setSummary(2131298791);
        break label445;
        paramBundle.setSummary(2131298794);
        break label445;
        if (this.lpe.Oh() > 1000000)
        {
          paramBundle.setSummary(2131298783);
          break label445;
        }
        paramBundle.setSummary(2131298782);
        break label445;
        if (this.lpe.Oh() > 1000000)
        {
          paramBundle.setSummary(2131298805);
          break label445;
        }
        paramBundle.setSummary(2131298804);
        break label445;
        paramBundle.setSummary(2131298771);
        break label445;
        paramBundle.setSummary(2131300486);
        break label445;
        paramBundle.setSummary(2131298789);
        break label445;
        if (this.lpe.Oh() > 1000000)
        {
          paramBundle.setSummary(2131298808);
          break label445;
        }
        paramBundle.setSummary(2131298807);
        break label445;
        if (this.lpe.Oh() > 1000000)
        {
          paramBundle.setSummary(2131298808);
          break label445;
        }
        paramBundle.setSummary(2131298807);
        break label445;
        if (this.lpe.Oh() > 1000000)
        {
          paramBundle.setSummary(2131298774);
          break label445;
        }
        paramBundle.setSummary(2131298773);
        break label445;
        if (this.lpe.Oh() > 1000000)
        {
          paramBundle.setSummary(2131298796);
          break label445;
        }
        paramBundle.setSummary(2131298795);
        break label445;
        paramBundle = "  " + this.lpe.getCity();
        break label514;
        paramBundle = paramBundle.dqY;
        break label641;
        label1335:
        ab.printErrStackTrace("MicroMsg.ContactProfileMoreUI", localJSONException1, "", new Object[0]);
        localObject2 = null;
        continue;
        label1354:
        localf.cl("contact_info_category_1", false);
        continue;
        label1372:
        paramBundle = null;
        Object localObject3 = null;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(23423);
    if (paramPreference.mKey.equals("common_chatroom"))
    {
      int i = paramPreference.getExtras().getInt("count", 0);
      e.wr(i);
      if (i > 0)
      {
        paramf = new Intent(this, CommonChatroomInfoUI.class);
        paramf.putExtra("Select_Talker_Name", this.lpe.field_username);
        startActivity(paramf);
      }
      AppMethodBeat.o(23423);
      return true;
    }
    if (paramPreference.mKey.equals("weishop"))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", paramPreference.getExtras().getString("shopUrl"));
      paramf.putExtra("geta8key_username", r.Zn());
      d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    for (;;)
    {
      AppMethodBeat.o(23423);
      return false;
      if (paramPreference.mKey.equals("send_to_friend")) {
        this.pxo.cbM();
      } else if (paramPreference.mKey.equals("add_to_black")) {
        this.pxo.ka(false);
      } else if (paramPreference.mKey.equals("expose")) {
        this.pxo.cbN();
      } else if (paramPreference.mKey.equals("delete_contact")) {
        this.pxo.cbL();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactProfileMoreUI
 * JD-Core Version:    0.7.0.1
 */