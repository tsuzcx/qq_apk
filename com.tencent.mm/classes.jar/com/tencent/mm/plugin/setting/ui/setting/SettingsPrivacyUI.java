package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsPrivacyUI
  extends MMPreference
{
  private String diG = "";
  boolean dnS = false;
  private f dnn;
  private HashMap<Integer, Integer> fcv = new HashMap();
  private boolean nTA = false;
  private boolean nVt = true;
  private boolean nVu = false;
  private boolean nVv = false;
  private boolean nVw = false;
  private boolean nVx = true;
  private int nVy = e.e.uHR;
  private int status;
  
  private void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = (TextView)View.inflate(this.mController.uMN, a.g.radio_btn_item, null);
    localTextView.setText(paramInt1);
    localTextView.setTag(Integer.valueOf(paramInt2));
    paramLinearLayout.addView(localTextView);
    localTextView.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(a.h.radio_on, 0, 0, 0);
    }
  }
  
  private void bwF()
  {
    Object localObject = new but();
    if (n.omD != null) {
      localObject = n.omD.MN(this.diG);
    }
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingPrivacy", "userinfo is null");
      return;
    }
    int i = ((but)localObject).tLp;
    localObject = (CheckBoxPreference)this.dnn.add("timeline_stranger_show");
    boolean bool;
    if (localObject != null)
    {
      ((Preference)localObject).vdK = false;
      if ((i & 0x1) > 0)
      {
        bool = true;
        this.nTA = bool;
        if (this.nTA) {
          break label463;
        }
        ((CheckBoxPreference)localObject).rHo = true;
      }
    }
    else
    {
      label101:
      localObject = (IconPreference)this.dnn.add("timeline_recent_show_select");
      if (localObject != null)
      {
        ((Preference)localObject).vdK = false;
        if ((i & 0x200) <= 0) {
          break label472;
        }
        bool = true;
        label138:
        this.nVu = bool;
        if ((i & 0x400) <= 0) {
          break label477;
        }
        bool = true;
        label153:
        this.nVv = bool;
        if ((i & 0x800) <= 0) {
          break label482;
        }
        bool = true;
        label168:
        this.nVw = bool;
        if (!this.nVu) {
          break label487;
        }
        ((IconPreference)localObject).setSummary(a.i.contact_info_feedsapp_recent_select_half_year);
        label188:
        i = ((Integer)g.DP().Dz().get(ac.a.uvu, Integer.valueOf(0))).intValue();
        int j = ((Integer)g.DP().Dz().get(ac.a.uvv, Integer.valueOf(0))).intValue();
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (i <= j) {
          break label516;
        }
        ((IconPreference)localObject).Gv(0);
      }
      label270:
      if ((!d.SP("sns")) || ((q.Gu() & 0x8000) != 0)) {
        break label526;
      }
      bool = true;
      label289:
      this.nVt = bool;
      localObject = new StringBuilder("isSnsOpenEntrance ").append(this.nVt).append(", install ").append(d.SP("sns")).append(", flag ");
      if ((q.Gu() & 0x8000) != 0) {
        break label531;
      }
      bool = true;
      label342:
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingPrivacy", bool);
      if (!this.nVt) {
        break label536;
      }
      this.dnn.bJ("settings_sns_notify", false);
      label376:
      if (this.nVt)
      {
        localObject = (CheckBoxPreference)this.dnn.add("settings_sns_notify");
        if (localObject != null)
        {
          ((Preference)localObject).vdK = false;
          this.nVx = bk.a((Boolean)g.DP().Dz().get(68384, null), true);
          if (!this.nVx) {
            break label552;
          }
        }
      }
    }
    label516:
    label526:
    label531:
    label536:
    label552:
    for (((CheckBoxPreference)localObject).rHo = true;; ((CheckBoxPreference)localObject).rHo = false)
    {
      this.dnn.notifyDataSetChanged();
      return;
      bool = false;
      break;
      label463:
      ((CheckBoxPreference)localObject).rHo = false;
      break label101;
      label472:
      bool = false;
      break label138;
      label477:
      bool = false;
      break label153;
      label482:
      bool = false;
      break label168;
      label487:
      if (this.nVv)
      {
        ((IconPreference)localObject).setSummary(a.i.contact_info_feedsapp_recent_select_three_day);
        break label188;
      }
      ((IconPreference)localObject).setSummary(a.i.contact_info_feedsapp_recent_select_all);
      break label188;
      ((IconPreference)localObject).Gv(8);
      break label270;
      bool = false;
      break label289;
      bool = false;
      break label342;
      this.dnn.bJ("settings_sns_notify", true);
      break label376;
    }
  }
  
  private void bzm()
  {
    Object localObject = new but();
    if (n.omD != null) {
      localObject = n.omD.MN(this.diG);
    }
    for (;;)
    {
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingPrivacy", "userinfo is null");
        return;
      }
      int i = ((Integer)g.DP().Dz().get(ac.a.uvu, Integer.valueOf(0))).intValue();
      if (i > ((Integer)g.DP().Dz().get(ac.a.uvv, Integer.valueOf(0))).intValue())
      {
        g.DP().Dz().c(ac.a.uvv, Integer.valueOf(i));
        bwF();
      }
      c.a locala = new c.a(this.mController.uMN);
      locala.It(a.i.app_cancel);
      locala.Ip(a.i.contact_info_feedsapp_recent_select);
      View localView = View.inflate(this.mController.uMN, a.g.mm_alert_switch, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(a.f.switcher_container);
      SettingsPrivacyUI.2 local2 = new SettingsPrivacyUI.2(this, localLinearLayout);
      i = ((but)localObject).tLp;
      a(localLinearLayout, a.i.contact_info_feedsapp_recent_select_half_year, 1, this.nVu, local2);
      a(localLinearLayout, a.i.contact_info_feedsapp_recent_select_three_day, 0, this.nVv, local2);
      i = a.i.contact_info_feedsapp_recent_select_all;
      if ((!this.nVu) && (!this.nVv)) {}
      for (boolean bool = true;; bool = false)
      {
        a(localLinearLayout, i, 2, bool, local2);
        locala.ei(localView);
        localObject = locala.aoP();
        localLinearLayout.setTag(localObject);
        ((c)localObject).show();
        addDialog((Dialog)localObject);
        return;
      }
    }
  }
  
  private boolean d(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SettingPrivacy", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.status |= paramInt1;
      if (!paramBoolean) {
        break label95;
      }
    }
    label95:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.fcv.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      return true;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  private boolean wb(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  public final com.tencent.mm.ui.base.preference.h a(SharedPreferences paramSharedPreferences)
  {
    return new com.tencent.mm.ui.base.preference.a(this, paramSharedPreferences);
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    paramPreference = paramPreference.mKey;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingPrivacy", paramPreference + " item has been clicked!");
    if (paramPreference.equals("settings_need_verify")) {
      return d(((CheckBoxPreference)paramf.add("settings_need_verify")).isChecked(), 32, 4);
    }
    if (paramPreference.equals("settings_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)paramf.add("settings_recommend_mobilefriends_to_me")).isChecked()) {}
      for (bool1 = true;; bool1 = false) {
        return d(bool1, 256, 7);
      }
    }
    if (paramPreference.equals("settings_about_blacklist"))
    {
      paramf = com.tencent.mm.model.y.il(getString(a.i.group_blacklist));
      paramPreference = new Intent();
      paramPreference.putExtra("filter_type", paramf.getType());
      paramPreference.putExtra("titile", getString(a.i.settings_private_blacklist));
      paramPreference.putExtra("list_attr", 32768);
      b.eUR.f(this, paramPreference);
      return true;
    }
    if (paramPreference.equals("timline_outside_permiss"))
    {
      paramf = new Intent();
      paramf.putExtra("k_sns_tag_id", 4L);
      paramf.putExtra("k_sns_from_settings_about_sns", 1);
      d.b(this, "sns", ".ui.SnsBlackDetailUI", paramf);
    }
    for (;;)
    {
      return false;
      if (paramPreference.equals("edit_timeline_group"))
      {
        d.x(this, "sns", ".ui.SnsTagPartlyUI");
      }
      else if (paramPreference.equals("timeline_black_permiss"))
      {
        paramf = new Intent();
        paramf.putExtra("k_sns_tag_id", 5L);
        paramf.putExtra("k_sns_from_settings_about_sns", 2);
        paramf.putExtra("k_tag_detail_sns_block_scene", 8);
        d.b(this, "sns", ".ui.SnsTagDetailUI", paramf);
      }
      else if (paramPreference.equals("timeline_stranger_show"))
      {
        if (!this.nTA) {}
        for (;;)
        {
          this.nTA = bool1;
          if (n.omD != null) {
            n.omD.aY(this.diG, this.nTA);
          }
          if (n.omD == null) {
            break;
          }
          paramf = n.omD.aZ(this.diG, this.nTA);
          n.omD.a(this.diG, paramf);
          if (paramf != null) {
            break label425;
          }
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingPrivacy", "userinfo in null !");
          return false;
          bool1 = false;
        }
        label425:
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SettingPrivacy", "dancy userinfo " + paramf.toString());
        ((j)g.r(j.class)).Fv().b(new i.a(51, paramf));
      }
      else
      {
        if (paramPreference.equals("settings_find_google_contact"))
        {
          bool1 = bool2;
          if (!((CheckBoxPreference)paramf.add("settings_find_google_contact")).isChecked()) {
            bool1 = true;
          }
          d(bool1, 1048576, 29);
          return true;
        }
        if (paramPreference.equals("settings_add_me_way"))
        {
          startActivity(new Intent(this, SettingsAddMeUI.class));
          return true;
        }
        if (paramPreference.equals("timeline_recent_show_select"))
        {
          bzm();
        }
        else
        {
          if (paramPreference.equals("settings_sns_notify"))
          {
            if (!this.nVx)
            {
              bool1 = true;
              this.nVx = bool1;
              if (!this.nVx) {
                break label652;
              }
              com.tencent.mm.plugin.report.service.h.nFQ.f(14098, new Object[] { Integer.valueOf(3) });
            }
            for (;;)
            {
              g.DP().Dz().o(68384, Boolean.valueOf(this.nVx));
              bwF();
              return true;
              bool1 = false;
              break;
              label652:
              com.tencent.mm.plugin.report.service.h.nFQ.f(14098, new Object[] { Integer.valueOf(4) });
            }
          }
          if (paramPreference.equals("settings_unfamiliar_contact"))
          {
            startActivity(new Intent(this, UnfamiliarContactUI.class));
          }
          else if (paramPreference.equals("settings_privacy_agreements"))
          {
            paramPreference = g.DP().Dz().get(274436, "").toString();
            paramf = paramPreference;
            if (bk.bl(paramPreference)) {
              paramf = com.tencent.mm.sdk.platformtools.x.cqI();
            }
            com.tencent.mm.plugin.account.a.b.a.b(this, getString(a.i.license_read_url, new Object[] { com.tencent.mm.sdk.platformtools.x.cqJ(), paramf, "setting", Integer.valueOf(0), Integer.valueOf(0) }), 0, false);
          }
          else if (paramPreference.equals("settings_auth_manage"))
          {
            startActivity(new Intent(this, SettingsManageAuthUI.class));
          }
        }
      }
    }
  }
  
  protected final void initView()
  {
    boolean bool2 = false;
    setMMTitle(a.i.settings_about_privacy);
    setBackBtn(new SettingsPrivacyUI.3(this));
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status));
    Object localObject1 = (CheckBoxPreference)this.dnn.add("settings_need_verify");
    ((Preference)localObject1).vdK = false;
    ((CheckBoxPreference)localObject1).rHo = wb(32);
    localObject1 = (String)g.DP().Dz().get(6, null);
    Object localObject2 = (CheckBoxPreference)this.dnn.add("settings_recommend_mobilefriends_to_me");
    ((Preference)localObject2).vdK = false;
    boolean bool1;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      if (!wb(256))
      {
        bool1 = true;
        ((CheckBoxPreference)localObject2).rHo = bool1;
      }
    }
    for (;;)
    {
      localObject1 = (CheckBoxPreference)this.dnn.add("settings_find_google_contact");
      ((Preference)localObject1).vdK = false;
      bool1 = bool2;
      if (!wb(1048576)) {
        bool1 = true;
      }
      ((CheckBoxPreference)localObject1).rHo = bool1;
      localObject2 = (String)g.DP().Dz().get(208903, null);
      if ((!bk.fV(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        this.dnn.c((Preference)localObject1);
      }
      if ((!((Boolean)g.DP().Dz().get(335873, Boolean.valueOf(true))).booleanValue()) || (!n.omF.bCo())) {
        this.dnn.bJ("edit_timeline_group", true);
      }
      this.dnn.bJ("settings_unfamiliar_contact", true);
      localObject1 = this.dnn.add("settings_privacy_agreements");
      localObject2 = getString(a.i.privacy_detail);
      Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(getString(a.i.privacy_detail_tip) + (String)localObject2);
      localSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(a.c.link_color)), localSpannable.length() - ((String)localObject2).length(), localSpannable.length(), 33);
      ((Preference)localObject1).setTitle(localSpannable);
      this.dnn.notifyDataSetChanged();
      return;
      bool1 = false;
      break;
      this.dnn.c((Preference)localObject2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    this.status = q.Gn();
    this.diG = q.Gj();
    this.nVx = bk.a((Boolean)g.DP().Dz().get(68384, null), true);
    this.nVy = getIntent().getIntExtra("enter_scene", e.e.uHR);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SettingPrivacy", "sns Notify " + this.nVx);
    initView();
    com.tencent.mm.plugin.report.service.h.nFQ.f(14098, new Object[] { Integer.valueOf(9) });
    if ((this.nVy == e.e.uHS) || (this.nVy == e.e.uHT))
    {
      paramBundle = new but();
      if (n.omD != null) {
        paramBundle = n.omD.MN(this.diG);
      }
      if (paramBundle != null)
      {
        int i = paramBundle.tLp;
        if ((i & 0x200) <= 0) {
          break label228;
        }
        bool1 = true;
        this.nVu = bool1;
        if ((i & 0x400) <= 0) {
          break label233;
        }
        bool1 = true;
        label202:
        this.nVv = bool1;
        if ((i & 0x800) <= 0) {
          break label238;
        }
      }
    }
    label228:
    label233:
    label238:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.nVw = bool1;
      bzm();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label202;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    g.DP().Dz().o(7, Integer.valueOf(this.status));
    Iterator localIterator = this.fcv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new zr();
      ((zr)localObject).sYS = i;
      ((zr)localObject).nfn = j;
      ((j)g.r(j.class)).Fv().b(new i.a(23, (com.tencent.mm.bv.a)localObject));
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SettingPrivacy", "switch  " + i + " " + j);
    }
    this.fcv.clear();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.status = q.Gn();
    bwF();
    if (!this.dnS)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bk.bl(str))
      {
        int i = this.dnn.adf(str);
        setSelection(i - 3);
        new ah().postDelayed(new SettingsPrivacyUI.1(this, i), 10L);
      }
      this.dnS = true;
    }
  }
  
  public final int xj()
  {
    return a.k.settings_about_privacy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI
 * JD-Core Version:    0.7.0.1
 */