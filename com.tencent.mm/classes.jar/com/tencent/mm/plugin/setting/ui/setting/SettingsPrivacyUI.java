package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.g;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsPrivacyUI
  extends MMPreference
{
  private String dZZ;
  boolean efp;
  private HashMap<Integer, Integer> guf;
  private boolean qHA;
  private boolean qJA;
  private boolean qJB;
  private boolean qJC;
  private boolean qJD;
  private boolean qJE;
  private boolean qJF;
  private cid qJG;
  private int qJH;
  private boolean qJz;
  private f screen;
  private int status;
  
  public SettingsPrivacyUI()
  {
    AppMethodBeat.i(127411);
    this.guf = new HashMap();
    this.dZZ = "";
    this.qJz = true;
    this.qHA = false;
    this.qJA = false;
    this.qJB = false;
    this.qJC = false;
    this.qJD = false;
    this.qJE = true;
    this.qJF = true;
    this.qJG = null;
    this.efp = false;
    this.qJH = e.g.yVe;
    AppMethodBeat.o(127411);
  }
  
  private boolean BF(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(127419);
    TextView localTextView = (TextView)View.inflate(getContext(), 2130970500, null);
    localTextView.setText(paramInt1);
    localTextView.setTag(Integer.valueOf(paramInt2));
    paramLinearLayout.addView(localTextView);
    localTextView.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2131231906, 0, 0, 0);
    }
    AppMethodBeat.o(127419);
  }
  
  private void ccF()
  {
    AppMethodBeat.i(127422);
    Object localObject = new cfj();
    cid localcid = ((com.tencent.mm.plugin.story.api.e)g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (com.tencent.mm.plugin.sns.b.n.raR != null) {
      localObject = com.tencent.mm.plugin.sns.b.n.raR.Zu(this.dZZ);
    }
    label132:
    label176:
    label197:
    label219:
    label355:
    label740:
    for (;;)
    {
      if (localObject == null)
      {
        ab.e("MicroMsg.SettingPrivacy", "userinfo is null");
        AppMethodBeat.o(127422);
        return;
      }
      int i = ((cfj)localObject).xPN;
      int j = ((cfj)localObject).xPO;
      localObject = (CheckBoxPreference)this.screen.atx("timeline_stranger_show");
      boolean bool;
      if (localObject != null)
      {
        ((Preference)localObject).zsk = false;
        if ((i & 0x1) > 0)
        {
          bool = true;
          this.qHA = bool;
          if (this.qHA) {
            break label606;
          }
          ((CheckBoxPreference)localObject).vxW = true;
        }
      }
      else
      {
        localObject = (IconPreference)this.screen.atx("timeline_recent_show_select");
        if (localObject != null)
        {
          ((Preference)localObject).zsk = false;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label615;
          }
          bool = true;
          this.qJA = bool;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label620;
          }
          bool = true;
          this.qJB = bool;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label625;
          }
          bool = true;
          this.qJD = bool;
          if ((i & 0x800) <= 0) {
            break label630;
          }
          bool = true;
          label234:
          this.qJC = bool;
          if (!this.qJA) {
            break label635;
          }
          ((IconPreference)localObject).setSummary(2131298611);
          label253:
          i = ((Integer)g.RL().Ru().get(ac.a.yFB, Integer.valueOf(0))).intValue();
          j = ((Integer)g.RL().Ru().get(ac.a.yFC, Integer.valueOf(0))).intValue();
          ab.i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i <= j) {
            break label682;
          }
          ((IconPreference)localObject).ON(0);
        }
        if ((!d.ahR("sns")) || ((r.Zy() & 0x8000) != 0)) {
          break label692;
        }
        bool = true;
        this.qJz = bool;
        localObject = new StringBuilder("isSnsOpenEntrance ").append(this.qJz).append(", install ").append(d.ahR("sns")).append(", flag ");
        if ((r.Zy() & 0x8000) != 0) {
          break label697;
        }
        bool = true;
        ab.i("MicroMsg.SettingPrivacy", bool);
        if (!this.qJz) {
          break label702;
        }
        this.screen.cl("settings_sns_notify", false);
        this.screen.cl("settings_story_notify", false);
        if (this.qJz)
        {
          localObject = (CheckBoxPreference)this.screen.atx("settings_sns_notify");
          if (localObject != null)
          {
            ((Preference)localObject).zsk = false;
            this.qJE = bo.a((Boolean)g.RL().Ru().get(68384, null), true);
            if (!this.qJE) {
              break label731;
            }
            ((CheckBoxPreference)localObject).vxW = true;
          }
          localObject = (CheckBoxPreference)this.screen.atx("settings_story_notify");
          if (localObject != null)
          {
            ((Preference)localObject).zsk = false;
            if (localcid.xSO != 0) {
              break label740;
            }
            bool = true;
            this.qJF = bool;
            if (!this.qJF) {
              break label745;
            }
          }
        }
      }
      label615:
      label745:
      for (((CheckBoxPreference)localObject).vxW = true;; ((CheckBoxPreference)localObject).vxW = false)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(127422);
        return;
        bool = false;
        break;
        ((CheckBoxPreference)localObject).vxW = false;
        break label132;
        bool = false;
        break label176;
        label620:
        bool = false;
        break label197;
        label625:
        bool = false;
        break label219;
        label630:
        bool = false;
        break label234;
        label635:
        if (this.qJB)
        {
          ((IconPreference)localObject).setSummary(2131298613);
          break label253;
        }
        if (this.qJD)
        {
          ((IconPreference)localObject).setSummary(2131298612);
          break label253;
        }
        ((IconPreference)localObject).setSummary(2131298610);
        break label253;
        ((IconPreference)localObject).ON(8);
        break label335;
        bool = false;
        break label355;
        bool = false;
        break label411;
        this.screen.cl("settings_sns_notify", true);
        this.screen.cl("settings_story_notify", true);
        break label458;
        ((CheckBoxPreference)localObject).vxW = false;
        break label530;
        bool = false;
        break label568;
      }
    }
  }
  
  private void ckw()
  {
    AppMethodBeat.i(127418);
    Object localObject1 = new cfj();
    if (com.tencent.mm.plugin.sns.b.n.raR != null) {
      localObject1 = com.tencent.mm.plugin.sns.b.n.raR.Zu(this.dZZ);
    }
    if (localObject1 == null)
    {
      ab.e("MicroMsg.SettingPrivacy", "userinfo is null");
      AppMethodBeat.o(127418);
      return;
    }
    int i = ((Integer)g.RL().Ru().get(ac.a.yFB, Integer.valueOf(0))).intValue();
    if (i > ((Integer)g.RL().Ru().get(ac.a.yFC, Integer.valueOf(0))).intValue())
    {
      g.RL().Ru().set(ac.a.yFC, Integer.valueOf(i));
      ccF();
    }
    Object localObject2 = new c.a(getContext());
    ((c.a)localObject2).Rj(2131296888);
    ((c.a)localObject2).Rb(2131298609);
    View localView = View.inflate(getContext(), 2130970146, null);
    localObject1 = (LinearLayout)localView.findViewById(2131826156);
    SettingsPrivacyUI.2 local2 = new SettingsPrivacyUI.2(this, (LinearLayout)localObject1);
    a((LinearLayout)localObject1, 2131298611, 1, this.qJA, local2);
    a((LinearLayout)localObject1, 2131298612, 3, this.qJD, local2);
    a((LinearLayout)localObject1, 2131298613, 0, this.qJB, local2);
    if ((!this.qJA) && (!this.qJB) && (!this.qJD)) {}
    for (boolean bool = true;; bool = false)
    {
      a((LinearLayout)localObject1, 2131298610, 2, bool, local2);
      ((c.a)localObject2).fu(localView);
      localObject2 = ((c.a)localObject2).aLZ();
      ((LinearLayout)localObject1).setTag(localObject2);
      ((c)localObject2).show();
      addDialog((Dialog)localObject2);
      AppMethodBeat.o(127418);
      return;
    }
  }
  
  private boolean h(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127421);
    ab.d("MicroMsg.SettingPrivacy", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.status |= paramInt1;
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.guf.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      AppMethodBeat.o(127421);
      return true;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(127412);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(127412);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return 2131165271;
  }
  
  public void initView()
  {
    boolean bool2 = false;
    AppMethodBeat.i(127420);
    setMMTitle(2131303191);
    setBackBtn(new SettingsPrivacyUI.3(this));
    ab.v("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status));
    Object localObject1 = (CheckBoxPreference)this.screen.atx("settings_need_verify");
    ((Preference)localObject1).zsk = false;
    ((CheckBoxPreference)localObject1).vxW = BF(32);
    localObject1 = (String)g.RL().Ru().get(6, null);
    Object localObject2 = (CheckBoxPreference)this.screen.atx("settings_recommend_mobilefriends_to_me");
    ((Preference)localObject2).zsk = false;
    boolean bool1;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      if (!BF(256))
      {
        bool1 = true;
        ((CheckBoxPreference)localObject2).vxW = bool1;
      }
    }
    for (;;)
    {
      localObject1 = (CheckBoxPreference)this.screen.atx("settings_find_google_contact");
      ((Preference)localObject1).zsk = false;
      bool1 = bool2;
      if (!BF(1048576)) {
        bool1 = true;
      }
      ((CheckBoxPreference)localObject1).vxW = bool1;
      localObject2 = (String)g.RL().Ru().get(208903, null);
      if ((!bo.hl(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        this.screen.d((Preference)localObject1);
      }
      if ((!((Boolean)g.RL().Ru().get(335873, Boolean.TRUE)).booleanValue()) || (!com.tencent.mm.plugin.sns.b.n.raT.cnO())) {
        this.screen.cl("edit_timeline_group", true);
      }
      this.screen.cl("settings_unfamiliar_contact", true);
      localObject1 = this.screen.atx("settings_privacy_agreements");
      localObject2 = getString(2131302168);
      Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(getString(2131302169) + (String)localObject2);
      localSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(2131690214)), localSpannable.length() - ((String)localObject2).length(), localSpannable.length(), 33);
      ((Preference)localObject1).setTitle(localSpannable);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(127420);
      return;
      bool1 = false;
      break;
      this.screen.d((Preference)localObject2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(127413);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.status = r.Zr();
    this.dZZ = r.Zn();
    this.qJE = bo.a((Boolean)g.RL().Ru().get(68384, null), true);
    this.qJG = ((com.tencent.mm.plugin.story.api.e)g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (this.qJG.xSO == 0)
    {
      bool1 = true;
      this.qJF = bool1;
      this.qJH = getIntent().getIntExtra("enter_scene", e.g.yVe);
      ab.d("MicroMsg.SettingPrivacy", "sns Notify:%s, story Notify:%s", new Object[] { Boolean.valueOf(this.qJE), Boolean.valueOf(this.qJF) });
      initView();
      com.tencent.mm.plugin.report.service.h.qsU.e(14098, new Object[] { Integer.valueOf(9) });
      if ((this.qJH == e.g.yVf) || (this.qJH == e.g.yVg))
      {
        paramBundle = new cfj();
        if (com.tencent.mm.plugin.sns.b.n.raR != null) {
          paramBundle = com.tencent.mm.plugin.sns.b.n.raR.Zu(this.dZZ);
        }
        if (paramBundle != null)
        {
          int i = paramBundle.xPN;
          int j = paramBundle.xPO;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label337;
          }
          bool1 = true;
          label249:
          this.qJA = bool1;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label343;
          }
          bool1 = true;
          label272:
          this.qJB = bool1;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label349;
          }
          bool1 = true;
          label296:
          this.qJD = bool1;
          if ((i & 0x800) <= 0) {
            break label355;
          }
        }
      }
    }
    label337:
    label343:
    label349:
    label355:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.qJC = bool1;
      ckw();
      AppMethodBeat.o(127413);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label249;
      bool1 = false;
      break label272;
      bool1 = false;
      break label296;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127416);
    super.onDestroy();
    AppMethodBeat.o(127416);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127415);
    super.onPause();
    g.RL().Ru().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.guf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new aek();
      ((aek)localObject).wXn = i;
      ((aek)localObject).pKC = j;
      ((j)g.E(j.class)).Yz().c(new j.a(23, (com.tencent.mm.bv.a)localObject));
      ab.d("MicroMsg.SettingPrivacy", "switch  " + i + " " + j);
    }
    this.guf.clear();
    AppMethodBeat.o(127415);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(127417);
    paramPreference = paramPreference.mKey;
    ab.i("MicroMsg.SettingPrivacy", paramPreference + " item has been clicked!");
    getDefaultSharedPreferences();
    if (paramPreference.equals("settings_need_verify"))
    {
      bool1 = h(((CheckBoxPreference)paramf.atx("settings_need_verify")).isChecked(), 32, 4);
      AppMethodBeat.o(127417);
      return bool1;
    }
    if (paramPreference.equals("settings_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)paramf.atx("settings_recommend_mobilefriends_to_me")).isChecked()) {}
      for (bool1 = true;; bool1 = false)
      {
        bool1 = h(bool1, 256, 7);
        AppMethodBeat.o(127417);
        return bool1;
      }
    }
    if (paramPreference.equals("settings_about_blacklist"))
    {
      paramf = com.tencent.mm.model.z.oS(getString(2131300540));
      paramPreference = new Intent();
      paramPreference.putExtra("filter_type", paramf.getType());
      paramPreference.putExtra("titile", getString(2131303391));
      paramPreference.putExtra("list_attr", 32768);
      b.gmO.h(this, paramPreference);
      AppMethodBeat.o(127417);
      return true;
    }
    if (paramPreference.equals("timline_outside_permiss"))
    {
      paramf = new Intent();
      paramf.putExtra("k_sns_tag_id", 4L);
      paramf.putExtra("k_sns_from_settings_about_sns", 1);
      d.b(this, "sns", ".ui.SnsBlackDetailUI", paramf);
    }
    label471:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(127417);
        return false;
        if (paramPreference.equals("edit_timeline_group"))
        {
          d.H(this, "sns", ".ui.SnsTagPartlyUI");
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
          if (!this.qHA) {}
          for (;;)
          {
            this.qHA = bool1;
            if (com.tencent.mm.plugin.sns.b.n.raR != null) {
              com.tencent.mm.plugin.sns.b.n.raR.bn(this.dZZ, this.qHA);
            }
            if (com.tencent.mm.plugin.sns.b.n.raR == null) {
              break;
            }
            paramf = com.tencent.mm.plugin.sns.b.n.raR.bo(this.dZZ, this.qHA);
            com.tencent.mm.plugin.sns.b.n.raR.a(this.dZZ, paramf);
            if (paramf != null) {
              break label471;
            }
            ab.e("MicroMsg.SettingPrivacy", "userinfo in null !");
            AppMethodBeat.o(127417);
            return false;
            bool1 = false;
          }
          ab.d("MicroMsg.SettingPrivacy", "dancy userinfo " + paramf.toString());
          ((j)g.E(j.class)).Yz().c(new j.a(51, paramf));
        }
        else
        {
          if (paramPreference.equals("settings_find_google_contact"))
          {
            bool1 = bool2;
            if (!((CheckBoxPreference)paramf.atx("settings_find_google_contact")).isChecked()) {
              bool1 = true;
            }
            h(bool1, 1048576, 29);
            AppMethodBeat.o(127417);
            return true;
          }
          if (paramPreference.equals("settings_add_me_way"))
          {
            startActivity(new Intent(this, SettingsAddMeUI.class));
            AppMethodBeat.o(127417);
            return true;
          }
          if (paramPreference.equals("timeline_recent_show_select"))
          {
            ckw();
          }
          else
          {
            if (paramPreference.equals("settings_sns_notify"))
            {
              getDefaultSharedPreferences();
              if (!this.qJE)
              {
                bool1 = true;
                this.qJE = bool1;
                if (!this.qJE) {
                  break label721;
                }
                com.tencent.mm.plugin.report.service.h.qsU.e(14098, new Object[] { Integer.valueOf(3) });
              }
              for (;;)
              {
                g.RL().Ru().set(68384, Boolean.valueOf(this.qJE));
                ccF();
                AppMethodBeat.o(127417);
                return true;
                bool1 = false;
                break;
                com.tencent.mm.plugin.report.service.h.qsU.e(14098, new Object[] { Integer.valueOf(4) });
              }
            }
            if (paramPreference.equals("settings_unfamiliar_contact"))
            {
              startActivity(new Intent(this, UnfamiliarContactUI.class));
            }
            else if (paramPreference.equals("settings_privacy_agreements"))
            {
              paramPreference = g.RL().Ru().get(274436, "").toString();
              paramf = paramPreference;
              if (bo.isNullOrNil(paramPreference)) {
                paramf = aa.dsF();
              }
              com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131306182, new Object[] { aa.dsG(), paramf, "setting", Integer.valueOf(0), Integer.valueOf(0) }), 0, false);
            }
            else
            {
              if (!paramPreference.equals("settings_auth_manage")) {
                break;
              }
              startActivity(new Intent(this, SettingsManageAuthUI.class));
            }
          }
        }
      }
    } while (!paramPreference.equals("settings_story_notify"));
    label721:
    if (!this.qJF)
    {
      bool1 = true;
      this.qJF = bool1;
      if (!this.qJF) {
        break label1000;
      }
    }
    label1000:
    for (this.qJG.xSO = 0;; this.qJG.xSO = 1)
    {
      ((com.tencent.mm.plugin.story.api.e)g.G(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(this.dZZ, this.qJG);
      ((j)g.E(j.class)).Yz().c(new j.a(71, this.qJG));
      ccF();
      AppMethodBeat.o(127417);
      return true;
      bool1 = false;
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127414);
    super.onResume();
    this.status = r.Zr();
    ccF();
    if (!this.efp)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bo.isNullOrNil(str))
      {
        int i = this.screen.atz(str);
        setSelection(i - 3);
        new ak().postDelayed(new SettingsPrivacyUI.1(this, i), 10L);
      }
      this.efp = true;
    }
    AppMethodBeat.o(127414);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI
 * JD-Core Version:    0.7.0.1
 */