package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.bf.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.j
public class SingleChatInfoUI
  extends MMPreference
  implements com.tencent.mm.bf.a
{
  private static boolean isDeleteCancel = false;
  private AppBrandLoadIconPreference dnC;
  private SharedPreferences dnD = null;
  private boolean dnJ;
  private int dnM = -1;
  private boolean dnO = false;
  private com.tencent.mm.pluginsdk.ui.d dnR = new com.tencent.mm.pluginsdk.ui.d(new SingleChatInfoUI.1(this));
  boolean dnS = false;
  private String dnW = "";
  private f dnn;
  private ad dnp;
  private ContactListExpandPreference dnv;
  private CheckBoxPreference dnw;
  private CheckBoxPreference dny;
  private com.tencent.mm.sdk.platformtools.ah handler = new com.tencent.mm.sdk.platformtools.ah(Looper.getMainLooper());
  private String talker;
  
  private void b(ProgressDialog paramProgressDialog)
  {
    com.tencent.mm.model.bd.a(this.dnp.field_username, new SingleChatInfoUI.7(this, paramProgressDialog));
    this.handler.post(new SingleChatInfoUI.9(this));
  }
  
  private void xr()
  {
    if (this.dnD == null) {
      this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    this.dnJ = this.dnp.Bj();
    if (this.dnJ)
    {
      setTitleMuteIconVisibility(0);
      if (this.dnw != null) {
        this.dnD.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.dnn.notifyDataSetChanged();
      return;
      setTitleMuteIconVisibility(8);
      if (this.dnw != null) {
        this.dnD.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  public final com.tencent.mm.ui.base.preference.h a(SharedPreferences paramSharedPreferences)
  {
    return new com.tencent.mm.ui.base.preference.a(this, paramSharedPreferences);
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    boolean bool = true;
    paramf = paramPreference.mKey;
    if (paramf.equals("room_notify_new_msg")) {
      if (!this.dnJ)
      {
        this.dnJ = bool;
        if (!this.dnJ) {
          break label147;
        }
        com.tencent.mm.model.s.o(this.dnp);
        label43:
        this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.talker);
        if (this.dnD == null) {
          this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.dnD.edit().putBoolean("room_notify_new_msg", this.dnJ).commit();
        xr();
      }
    }
    label147:
    do
    {
      do
      {
        return false;
        bool = false;
        break;
        com.tencent.mm.model.s.p(this.dnp);
        break label43;
        if (!paramf.equals("room_placed_to_the_top")) {
          break label274;
        }
        paramf = getSharedPreferences(this.dnW, 0);
      } while (this.dnp == null);
      au.Hx();
      if (c.FB().abD(this.dnp.field_username)) {
        com.tencent.mm.model.s.u(this.dnp.field_username, true);
      }
      for (;;)
      {
        paramf = paramf.edit();
        au.Hx();
        paramf.putBoolean("room_placed_to_the_top", c.FB().abD(this.dnp.field_username)).commit();
        return false;
        com.tencent.mm.model.s.t(this.dnp.field_username, true);
      }
      if (paramf.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.dnp.field_username);
        com.tencent.mm.br.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
        return false;
      }
      if (paramf.equals("room_search_chatting_content"))
      {
        paramf = new Intent();
        paramf.putExtra("detail_username", this.talker);
        com.tencent.mm.plugin.fts.a.d.b(this, ".ui.FTSChattingConvUI", paramf);
        com.tencent.mm.plugin.report.service.h.nFQ.f(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        return false;
      }
      if (paramf.equals("room_clear_chatting_history"))
      {
        paramf = getString(R.l.fmt_delcontactmsg_confirm, new Object[] { this.dnp.Bq() });
        com.tencent.mm.ui.base.h.a(this.mController.uMN, paramf, "", getString(R.l.app_clear), getString(R.l.app_cancel), new SingleChatInfoUI.8(this), null, R.e.alert_btn_color_warn);
        return false;
      }
      if (paramf.equals("room_expose"))
      {
        paramf = new Intent();
        paramf.putExtra("k_username", this.talker);
        paramf.putExtra("showShare", false);
        paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(39) }));
        com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
        return false;
      }
    } while (!paramf.equals("chat_app_brand"));
    label274:
    paramf = new Intent();
    paramf.putExtra("Chat_User", this.talker);
    com.tencent.mm.br.d.e(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
    com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 25L, 1L, true);
    return false;
  }
  
  public final void i(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1.equals(this.talker)) && (this.dnv != null)) {
      this.dnv.notifyChanged();
    }
  }
  
  protected final void initView()
  {
    this.dnn = this.vdd;
    setMMTitle(getString(R.l.roominfo_name));
    this.dnv = ((ContactListExpandPreference)this.dnn.add("roominfo_contact_anchor"));
    this.dnv.a(this.dnn, this.dnv.mKey);
    this.dnv.lS(true).lT(false);
    if ((this.dnp != null) && (this.dnp.field_deleteFlag == 1)) {
      this.dnv.lS(false);
    }
    if ((!com.tencent.mm.ui.contact.s.cHQ()) && (this.dnp != null) && (ad.aaU(this.dnp.field_username))) {
      this.dnv.lS(false);
    }
    this.dnw = ((CheckBoxPreference)this.dnn.add("room_notify_new_msg"));
    this.dny = ((CheckBoxPreference)this.dnn.add("room_placed_to_the_top"));
    if (this.dnD == null) {
      this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    Object localObject;
    if (this.dnp != null)
    {
      localObject = this.dnD.edit();
      au.Hx();
      ((SharedPreferences.Editor)localObject).putBoolean("room_placed_to_the_top", c.FB().abD(this.dnp.field_username)).commit();
      this.dnJ = this.dnp.Bj();
      this.dnD.edit().putBoolean("room_notify_new_msg", this.dnJ).commit();
    }
    for (;;)
    {
      au.Hx();
      this.dnM = c.Fy().HS(this.talker);
      this.dnC = ((AppBrandLoadIconPreference)this.dnn.add("chat_app_brand"));
      this.dnC.drJ = this.talker;
      if ((this.dnp != null) && (ad.aaU(this.dnp.field_username))) {
        this.dnn.c(this.dnC);
      }
      this.dnn.notifyDataSetChanged();
      if (this.dnv != null)
      {
        localObject = new LinkedList();
        ((List)localObject).add(this.talker);
        this.dnv.s(this.talker, (List)localObject);
        this.lwE.setOnScrollListener(this.dnR);
        this.dnv.a(this.dnR);
        this.dnv.a(new SingleChatInfoUI.3(this));
      }
      setBackBtn(new SingleChatInfoUI.4(this));
      return;
      this.dnD.edit().putBoolean("room_notify_new_msg", false).commit();
      this.dnJ = false;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while (paramInt2 != -1);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (com.tencent.mm.bf.g.eEV != null) {
      com.tencent.mm.bf.g.eEV.a(this);
    }
    this.talker = getIntent().getStringExtra("Single_Chat_Talker");
    this.dnO = getIntent().getBooleanExtra("fromChatting", false);
    this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.talker);
    this.dnW = (getPackageName() + "_preferences");
    initView();
  }
  
  public void onDestroy()
  {
    
    if (com.tencent.mm.bf.g.eEV != null) {
      com.tencent.mm.bf.g.eEV.b(this);
    }
    if (this.dnC != null) {
      AppBrandLoadIconPreference.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    xr();
    Object localObject;
    if (this.dnv != null)
    {
      localObject = new LinkedList();
      ((List)localObject).add(this.talker);
      this.dnv.s(this.talker, (List)localObject);
    }
    this.dnn.notifyDataSetChanged();
    super.onResume();
    if (!this.dnS)
    {
      localObject = getIntent().getStringExtra("need_matte_high_light_item");
      if (!com.tencent.mm.platformtools.ah.bl((String)localObject))
      {
        int i = this.dnn.adf((String)localObject);
        setSelection(i - 3);
        new com.tencent.mm.sdk.platformtools.ah().postDelayed(new SingleChatInfoUI.2(this, i), 10L);
      }
      this.dnS = true;
    }
  }
  
  public final int xj()
  {
    return R.o.roominfo_single_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI
 * JD-Core Version:    0.7.0.1
 */