package com.tencent.mm.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.aw.d.a;
import com.tencent.mm.h.a.nu;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.i;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.y.a.a;
import java.util.UUID;

public class ac
  extends a
  implements m.b
{
  private f dnn;
  private a.a nWw = new ac.1(this);
  
  private void czS()
  {
    if (!com.tencent.mm.br.d.SP("sns"))
    {
      this.dnn.bJ("settings_my_album", true);
      return;
    }
    this.dnn.bJ("settings_my_album", false);
  }
  
  private void czT()
  {
    Object localObject1 = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.card.c.b.class);
    if ((localObject1 == null) || ((!((com.tencent.mm.plugin.card.c.b)localObject1).aAJ()) && (!((com.tencent.mm.plugin.card.c.b)localObject1).aAK())) || (!com.tencent.mm.br.d.SP("card")))
    {
      this.dnn.bJ("settings_mm_cardpackage", true);
      return;
    }
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.card.c.b)localObject1).aAL();; localObject1 = "")
    {
      boolean bool1 = com.tencent.mm.y.c.BS().bc(262152, 266256);
      boolean bool2 = com.tencent.mm.y.c.BS().bb(262152, 266256);
      boolean bool3 = com.tencent.mm.y.c.BS().a(ac.a.uoR, ac.a.uoT);
      boolean bool4 = com.tencent.mm.y.c.BS().a(ac.a.uoS, ac.a.uoU);
      this.dnn.bJ("settings_mm_cardpackage", false);
      IconPreference localIconPreference = (IconPreference)this.dnn.add("settings_mm_cardpackage");
      if (localIconPreference == null) {
        break;
      }
      localIconPreference.setTitle(R.l.settings_mm_card_package_new);
      if (bool2)
      {
        localIconPreference.Gt(0);
        localIconPreference.dD(getString(R.l.app_new), R.g.new_tips_bg);
        localIconPreference.Gv(8);
        localIconPreference.setSummary(null);
        localIconPreference.Z(null);
        localIconPreference.Gx(8);
        localIconPreference.dE("", -1);
        localIconPreference.Gu(8);
        return;
      }
      au.Hx();
      String str = (String)com.tencent.mm.model.c.Dz().get(ac.a.upa, "");
      if ((bool4) && (!TextUtils.isEmpty(str)))
      {
        int i = getResources().getDimensionPixelOffset(R.f.card_entrance_icon_height);
        Object localObject2 = new c.a();
        ((c.a)localObject2).eri = com.tencent.mm.compatible.util.e.bkH;
        o.OO();
        ((c.a)localObject2).erB = null;
        ((c.a)localObject2).erf = true;
        ((c.a)localObject2).erD = true;
        ((c.a)localObject2).erd = true;
        ((c.a)localObject2).erm = i;
        ((c.a)localObject2).erl = i;
        localObject2 = ((c.a)localObject2).OV();
        o.ON().a(str, localIconPreference.lZf, (com.tencent.mm.as.a.a.c)localObject2, new ac.2(this, localIconPreference));
        if (!bool1) {
          break label451;
        }
        localIconPreference.Gv(0);
      }
      for (;;)
      {
        if (bool3)
        {
          localIconPreference.dD("", -1);
          localIconPreference.Gt(8);
          if (bool4)
          {
            localIconPreference.setSummary(null);
            if (!com.tencent.mm.platformtools.ah.bl((String)localObject1))
            {
              localIconPreference.ap((String)localObject1, -1, getResources().getColor(R.e.hint_text_color));
              localIconPreference.Gu(0);
              return;
              localIconPreference.Z(null);
              localIconPreference.Gx(8);
              break;
              label451:
              localIconPreference.Gv(8);
              continue;
            }
            localIconPreference.dE("", -1);
            localIconPreference.Gu(8);
            return;
          }
          localIconPreference.dE("", -1);
          localIconPreference.Gu(8);
          if (!com.tencent.mm.platformtools.ah.bl((String)localObject1))
          {
            localIconPreference.setSummary((CharSequence)localObject1);
            return;
          }
          localIconPreference.setSummary(null);
          return;
        }
      }
      localIconPreference.Gu(8);
      localIconPreference.Gt(8);
      localIconPreference.setSummary(null);
      return;
    }
  }
  
  private void czU()
  {
    this.dnn.bJ("more_setting", false);
    final IconPreference localIconPreference = (IconPreference)this.dnn.add("more_setting");
    boolean bool;
    if (localIconPreference != null)
    {
      localIconPreference.Gy(8);
      bool = com.tencent.mm.y.c.BS().bb(262145, 266242);
      if (!bool) {
        break label131;
      }
      localIconPreference.Gt(0);
      localIconPreference.dD(getString(R.l.app_new), R.g.new_tips_bg);
      au.Hx();
      if (((Integer)com.tencent.mm.model.c.Dz().get(9, Integer.valueOf(0))).intValue() != 0)
      {
        if (com.tencent.mm.model.q.Gr()) {
          break label149;
        }
        localIconPreference.setSummary(R.l.safe_device_account_state_unsafe_in_setting);
      }
    }
    for (;;)
    {
      localIconPreference.Gv(8);
      if (!bool) {
        break label159;
      }
      return;
      label131:
      localIconPreference.Gt(8);
      localIconPreference.dD("", -1);
      break;
      label149:
      localIconPreference.setSummary("");
    }
    label159:
    au.Hx();
    int i = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uvq, Integer.valueOf(0))).intValue();
    au.Hx();
    int j = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uvr, Integer.valueOf(0))).intValue();
    if (((((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.c.class)).chg()) || (((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.c.class)).chh()) || (i > j)) && (!bool))
    {
      localIconPreference.Gv(0);
      localIconPreference.Gt(8);
      localIconPreference.dD("", -1);
      return;
    }
    localIconPreference.Gv(8);
    if (com.tencent.mm.y.c.BS().bc(262157, 266261))
    {
      localIconPreference.Gv(0);
      localIconPreference.Gt(8);
      localIconPreference.dD("", -1);
      return;
    }
    localIconPreference.Gv(8);
    if (com.tencent.mm.y.c.BS().bc(262158, 266264))
    {
      localIconPreference.Gv(0);
      localIconPreference.Gt(8);
      localIconPreference.dD("", -1);
      return;
    }
    if (com.tencent.mm.y.c.BS().a(ac.a.uyT, 266264))
    {
      localIconPreference.Gv(0);
      return;
    }
    localIconPreference.Gv(8);
    au.Hx();
    if ((com.tencent.mm.model.c.Dz().getInt(40, 0) & 0x20000) == 0) {}
    for (i = 1;; i = 0)
    {
      if (bk.getInt(com.tencent.mm.m.g.AA().getValue("VoiceprintEntry"), 0) == 1) {
        au.Hx();
      }
      for (bool = ((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uou, Boolean.valueOf(true))).booleanValue();; bool = false)
      {
        if ((bool) && (i != 0))
        {
          y.i("MicroMsg.MoreTabUI", "show voiceprint dot");
          localIconPreference.Gv(0);
          return;
        }
        localIconPreference.Gv(8);
        bm localbm = com.tencent.mm.plugin.y.a.bou().Fr(com.tencent.mm.aw.b.evf);
        if ((localbm != null) && (!localbm.field_isExit))
        {
          com.tencent.mm.plugin.y.a.bot().evv = new d.a()
          {
            public final void e(bm paramAnonymousbm)
            {
              if (paramAnonymousbm.field_tipId == com.tencent.mm.aw.b.evf)
              {
                com.tencent.mm.plugin.y.a.bov();
                if (com.tencent.mm.aw.c.iW(com.tencent.mm.aw.b.evf))
                {
                  localIconPreference.Gv(0);
                  localIconPreference.Gt(8);
                  localIconPreference.dD("", -1);
                }
              }
            }
          };
          return;
        }
        com.tencent.mm.plugin.y.a.bov();
        if (!com.tencent.mm.aw.c.iW(com.tencent.mm.aw.b.evf)) {
          break;
        }
        localIconPreference.Gv(0);
        localIconPreference.Gt(8);
        localIconPreference.dD("", -1);
        return;
      }
    }
  }
  
  private void czV()
  {
    boolean bool1;
    boolean bool2;
    IconPreference localIconPreference;
    if (com.tencent.mm.br.d.SP("emoji"))
    {
      com.tencent.mm.br.d.coz();
      this.dnn.bJ("settings_emoji_store", false);
      bool1 = com.tencent.mm.y.c.BS().bb(262147, 266244);
      bool2 = com.tencent.mm.y.c.BS().bb(262149, 266244);
      localIconPreference = (IconPreference)this.dnn.add("settings_emoji_store");
      if (localIconPreference != null) {}
    }
    else
    {
      this.dnn.bJ("settings_emoji_store", false);
      return;
    }
    if (bool1)
    {
      localIconPreference.Gt(0);
      localIconPreference.dD(getString(R.l.app_new), R.g.new_tips_bg);
    }
    while ((bool2) || (bool1))
    {
      au.Hx();
      String str = (String)com.tencent.mm.model.c.Dz().get(229633, null);
      o.ON().a(str, localIconPreference.lZf, new ac.5(this, localIconPreference));
      return;
      if (bool2)
      {
        localIconPreference.Gt(0);
        localIconPreference.dD(getString(R.l.app_free), R.g.new_tips_bg);
      }
      else
      {
        localIconPreference.Gt(8);
        localIconPreference.dD("", -1);
      }
    }
    localIconPreference.Gx(8);
  }
  
  private void czW()
  {
    boolean bool = com.tencent.mm.model.q.Gs();
    y.d("MicroMsg.MoreTabUI", "wallet status: is open" + bool);
    f localf = this.dnn;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      localf.bJ("settings_mm_wallet", bool);
      this.vdd.notifyDataSetChanged();
      return;
    }
  }
  
  private void czX()
  {
    au.Hx();
    int i = com.tencent.mm.platformtools.ah.h((Integer)com.tencent.mm.model.c.Dz().get(204820, null));
    au.Hx();
    i += com.tencent.mm.platformtools.ah.h((Integer)com.tencent.mm.model.c.Dz().get(204817, null));
    boolean bool3 = com.tencent.mm.y.c.BS().bb(262156, 266248);
    boolean bool4 = com.tencent.mm.y.c.BS().bc(262156, 266248);
    boolean bool5 = com.tencent.mm.y.c.BS().b(ac.a.uxp, ac.a.uxr);
    au.Hx();
    Object localObject = (String)com.tencent.mm.model.c.Dz().get(ac.a.uxs, "");
    IconPreference localIconPreference = (IconPreference)this.dnn.add("settings_mm_wallet");
    if (localIconPreference == null) {
      return;
    }
    y.d("MicroMsg.MoreTabUI", "isShowNew : " + bool3);
    y.d("MicroMsg.MoreTabUI", "isShowDot : " + bool4);
    au.Hx();
    String str1 = (String)com.tencent.mm.model.c.Dz().get(ac.a.uwY, "");
    au.Hx();
    int j = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uwZ, Integer.valueOf(-1))).intValue();
    boolean bool2;
    boolean bool1;
    if (!bool3)
    {
      bool2 = bool4;
      bool1 = bool3;
      if (!bool4) {}
    }
    else
    {
      au.Hx();
      l1 = ((Long)com.tencent.mm.model.c.Dz().get(ac.a.uwW, Long.valueOf(-1L))).longValue();
      long l2 = com.tencent.mm.platformtools.ah.pn(com.tencent.mm.m.g.AA().getValue("PayWalletRedDotExpire"));
      long l3 = System.currentTimeMillis();
      double d = (l3 - l1) / 86400000.0D;
      y.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(86400000L * l2), Long.valueOf(l3), Double.valueOf(d) });
      bool2 = bool4;
      bool1 = bool3;
      if (l1 > 0L)
      {
        bool2 = bool4;
        bool1 = bool3;
        if (l2 > 0L)
        {
          bool2 = bool4;
          bool1 = bool3;
          if (d >= l2)
          {
            bool1 = false;
            com.tencent.mm.y.c.BS().v(262156, false);
            bool2 = false;
          }
        }
      }
    }
    com.tencent.mm.kernel.g.DQ();
    bool3 = ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyK, Boolean.valueOf(false))).booleanValue();
    com.tencent.mm.kernel.g.DQ();
    long l1 = ((Long)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyL, Long.valueOf(0L))).longValue();
    if ((bool3) && (l1 > 0L) && (System.currentTimeMillis() > l1))
    {
      y.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
      bool3 = false;
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyK, Boolean.valueOf(false));
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyL, Long.valueOf(0L));
    }
    for (;;)
    {
      bool2 |= bool3;
      com.tencent.mm.kernel.g.DQ();
      String str2 = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyH, "");
      y.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), str2 });
      y.d("MicroMsg.MoreTabUI", "bankcardDot : " + bool5);
      if (bool5) {
        if (!bk.bl((String)localObject))
        {
          localIconPreference.Gu(0);
          localIconPreference.ap((String)localObject, -1, -7566196);
          localIconPreference.ne(true);
          localIconPreference.Gv(8);
          if ((com.tencent.mm.platformtools.ah.bl(str2)) || (!bool2)) {
            break label1024;
          }
          localIconPreference.setSummary(str2);
          label696:
          localObject = h.nFQ;
          if (!bool2) {
            break label1034;
          }
        }
      }
      label1024:
      label1034:
      for (i = 1;; i = 0)
      {
        ((h)localObject).f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(1) });
        return;
        localIconPreference.dE("", -1);
        localIconPreference.Gu(8);
        localIconPreference.Gv(0);
        break;
        if (bool1)
        {
          localIconPreference.Gt(0);
          localIconPreference.dD(getString(R.l.app_new), R.g.new_tips_bg);
          localIconPreference.Gv(8);
          break;
        }
        if (i > 99)
        {
          localIconPreference.Gt(0);
          localIconPreference.dD(getString(R.l.tab_msg_tip_over), com.tencent.mm.ui.tools.q.hh(getContext()));
          localIconPreference.Gv(8);
          break;
        }
        if (i > 0)
        {
          localIconPreference.Gt(0);
          localIconPreference.dD(String.valueOf(i), com.tencent.mm.ui.tools.q.hh(getContext()));
          localIconPreference.Gv(8);
          break;
        }
        if (bool2)
        {
          localIconPreference.dD("", -1);
          localIconPreference.Gt(8);
          localIconPreference.Gv(0);
          break;
        }
        if (j == 1)
        {
          localIconPreference.dD("", -1);
          localIconPreference.Gt(8);
          localIconPreference.Gu(0);
          localIconPreference.ne(true);
          if (!com.tencent.mm.platformtools.ah.bl(str1)) {
            localIconPreference.ap(str1, -1, Color.parseColor("#888888"));
          }
          localIconPreference.Gy(8);
          break;
        }
        localIconPreference.dD("", -1);
        localIconPreference.Gt(8);
        localIconPreference.Gv(8);
        localIconPreference.Gu(8);
        localIconPreference.dE("", -1);
        break;
        localIconPreference.setSummary("");
        break label696;
      }
    }
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    int i = com.tencent.mm.platformtools.ah.aD(paramObject);
    y.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    au.Hx();
    if ((paramm != com.tencent.mm.model.c.Dz()) || (i <= 0)) {
      y.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
    }
    do
    {
      return;
      if ((204817 == i) || (204820 == i))
      {
        czX();
        return;
      }
      if (40 == i)
      {
        czW();
        return;
      }
    } while (!"208899".equals(Integer.valueOf(paramInt)));
    czV();
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      y.w("MicroMsg.MoreTabUI", "account has not already!");
    }
    boolean bool1;
    int i;
    label494:
    int j;
    do
    {
      return true;
      if (paramPreference.mKey.equals("more_tab_setting_personal_info"))
      {
        paramf = new Intent();
        com.tencent.mm.br.d.b(getContext(), "setting", ".ui.setting.SettingsPersonalInfoUI", paramf);
        return true;
      }
      if (paramPreference.mKey.equals("settings_my_address"))
      {
        paramf = new Intent(getContext(), AddressUI.class);
        paramf.putExtra("Contact_GroupFilter_Type", "@biz.contact");
        startActivity(paramf);
        return true;
      }
      if (paramPreference.mKey.equals("settings_my_add_contact"))
      {
        com.tencent.mm.br.d.b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
        return true;
      }
      if (paramPreference.mKey.equals("settings_mm_wallet"))
      {
        bool1 = com.tencent.mm.y.c.BS().bb(262156, 266248);
        boolean bool2 = com.tencent.mm.y.c.BS().bc(262156, 266248);
        h.nFQ.aC(10958, "9");
        paramf = h.nFQ;
        if ((bool1) || (bool2))
        {
          i = 1;
          paramf.f(13341, new Object[] { Integer.valueOf(i) });
          paramf = UUID.randomUUID().toString();
          h.nFQ.f(14419, new Object[] { paramf, Integer.valueOf(0) });
          paramPreference = new nu();
          paramPreference.bXx.context = getContext();
          Intent localIntent = new Intent();
          localIntent.putExtra("key_wallet_has_red", bool2);
          localIntent.putExtra("key_uuid", paramf);
          paramPreference.bXx.intent = localIntent;
          com.tencent.mm.sdk.b.a.udP.m(paramPreference);
          com.tencent.mm.y.c.BS().bd(262156, 266248);
          com.tencent.mm.y.c.BS().c(ac.a.uxp, ac.a.uxr);
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uwY, "");
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uwZ, Integer.valueOf(-1));
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyK, Boolean.valueOf(false));
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyH, "");
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyI, Boolean.valueOf(false));
          paramf = h.nFQ;
          if (!bool2) {
            break label494;
          }
        }
        for (i = 1;; i = 0)
        {
          paramf.f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(0) });
          return true;
          i = 0;
          break;
        }
      }
      if (paramPreference.mKey.equals("settings_mm_cardpackage"))
      {
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.uoX, "");
        paramf = new Intent();
        paramf.putExtra("key_from_scene", 22);
        y.i("MicroMsg.MoreTabUI", "enter to cardhome");
        com.tencent.mm.br.d.b(getContext(), "card", ".ui.CardHomePageUI", paramf);
        return true;
      }
      if (paramPreference.mKey.equals("settings_my_album"))
      {
        au.Hx();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          s.gM(getContext());
          return true;
        }
        au.Hx();
        paramf = (String)com.tencent.mm.model.c.Dz().get(2, null);
        paramPreference = new Intent();
        paramPreference.putExtra("sns_userName", paramf);
        paramPreference.setFlags(536870912);
        paramPreference.addFlags(67108864);
        au.Hx();
        i = com.tencent.mm.platformtools.ah.h((Integer)com.tencent.mm.model.c.Dz().get(68389, null));
        au.Hx();
        com.tencent.mm.model.c.Dz().o(68389, Integer.valueOf(i + 1));
        com.tencent.mm.br.d.b(getContext(), "sns", ".ui.SnsUserUI", paramPreference);
        return true;
      }
      if (paramPreference.mKey.equals("settings_mm_favorite"))
      {
        h.nFQ.aC(10958, "8");
        h.nFQ.f(14103, new Object[] { Integer.valueOf(0) });
        com.tencent.mm.plugin.fav.a.b.a(getContext(), ".ui.FavoriteIndexUI", new Intent());
        com.tencent.mm.cl.b.afs("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        return true;
      }
      if (paramPreference.mKey.equals("settings_emoji_store"))
      {
        h.nFQ.aC(10958, "7");
        com.tencent.mm.y.c.BS().bd(262147, 266244);
        com.tencent.mm.y.c.BS().bd(262149, 266244);
        paramf = new Intent();
        paramf.putExtra("preceding_scence", 2);
        com.tencent.mm.br.d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", paramf);
        h.nFQ.f(12065, new Object[] { Integer.valueOf(1) });
        ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.boots.a.c.class)).cr(com.tencent.mm.plugin.boots.a.b.hXG, 881);
        return true;
      }
      if (!paramPreference.mKey.equals("more_setting")) {
        break;
      }
      bool1 = com.tencent.mm.y.c.BS().bb(262145, 266242);
      com.tencent.mm.y.c.BS().bd(262145, 266242);
      com.tencent.mm.y.c.BS().bd(262157, 266261);
      com.tencent.mm.y.c.BS().bd(262158, 266264);
      com.tencent.mm.y.c.BS().b(ac.a.uyT, 266264);
      paramPreference = new Intent();
      com.tencent.mm.br.d.b(getContext(), "setting", ".ui.setting.SettingsUI", paramPreference);
      au.Hx();
      i = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uvq, Integer.valueOf(0))).intValue();
      au.Hx();
      j = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uvr, Integer.valueOf(0))).intValue();
    } while ((bool1) || (i <= j));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.uvr, Integer.valueOf(i));
    paramf = (IconPreference)paramf.add("more_setting");
    if (paramf != null) {
      paramf.Gv(8);
    }
    com.tencent.mm.y.c.BS().bd(266260, 266241);
    return true;
    if (paramPreference.mKey.equals("more_uishow"))
    {
      com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.aj.a.a.a.class);
      getContext();
      new Intent();
      return true;
    }
    if (paramPreference.mKey.equals("settings_privacy_agreements"))
    {
      com.tencent.mm.plugin.account.a.b.a.b(getActivity(), getString(R.l.license_read_url, new Object[] { x.cqJ(), com.tencent.mm.kernel.g.DP().Dz().get(274436, null), "setting", Integer.valueOf(0), Integer.valueOf(0) }), 0, true);
      return true;
    }
    return false;
  }
  
  protected final void cxD()
  {
    this.dnn = this.vdd;
    View localView = getView().getRootView().findViewById(R.h.launcher_ui_bottom_tabview);
    int i = com.tencent.mm.compatible.util.a.bh(getContext());
    getView().setPadding(0, i, 0, localView.getHeight());
  }
  
  protected final void cxE()
  {
    this.dnn = this.vdd;
    au.Hx();
    com.tencent.mm.model.c.Dz().a(this);
    com.tencent.mm.y.c.BS().a(this.nWw);
    this.dnn.bJ("more_tab_setting_personal_info", false);
    Object localObject2 = (AccountInfoPreference)this.vdd.add("more_tab_setting_personal_info");
    Object localObject1 = com.tencent.mm.model.q.Gk();
    if (com.tencent.mm.platformtools.ah.bl((String)localObject1))
    {
      localObject1 = com.tencent.mm.model.q.Gj();
      if (ad.aaX((String)localObject1))
      {
        ((AccountInfoPreference)localObject2).shY = null;
        ((AccountInfoPreference)localObject2).userName = com.tencent.mm.model.q.Gj();
        String str = com.tencent.mm.model.q.Gl();
        localObject1 = str;
        if (com.tencent.mm.platformtools.ah.bl(str)) {
          localObject1 = com.tencent.mm.model.q.Gj();
        }
        ((AccountInfoPreference)localObject2).shX = j.b(getContext(), (CharSequence)localObject1);
        ((AccountInfoPreference)this.dnn.add("more_tab_setting_personal_info")).sia = new ac.4(this);
        localObject1 = (IconPreference)this.dnn.add("settings_my_address");
        if (localObject1 != null)
        {
          int i = com.tencent.mm.bh.d.RY().cuU();
          if (i <= 0) {
            break label457;
          }
          ((IconPreference)localObject1).Gt(0);
          ((IconPreference)localObject1).dD(String.valueOf(i), R.g.new_tips_bg);
        }
        label198:
        czS();
        czV();
        czU();
        if (com.tencent.mm.br.d.SP("favorite")) {
          break label473;
        }
        this.dnn.bJ("settings_mm_favorite", true);
        label232:
        czX();
        czW();
        czT();
        if (!com.tencent.mm.kernel.g.DL().q(com.tencent.mm.plugin.aj.a.a.class)) {
          break label489;
        }
        this.dnn.bJ("more_uishow", false);
        label269:
        localObject1 = this.dnn.add("settings_privacy_agreements");
        if (!com.tencent.mm.at.b.mC((String)com.tencent.mm.kernel.g.DP().Dz().get(274436, null))) {
          break label505;
        }
        str = getString(R.l.privacy_detail);
        localObject2 = Spannable.Factory.getInstance().newSpannable(str);
        ((Spannable)localObject2).setSpan(new ForegroundColorSpan(getResources().getColor(R.e.link_color)), ((Spannable)localObject2).length() - str.length(), ((Spannable)localObject2).length(), 33);
        ((Preference)localObject1).setTitle((CharSequence)localObject2);
        this.dnn.bJ("settings_privacy_agreements", false);
      }
    }
    for (;;)
    {
      this.dnn.notifyDataSetChanged();
      localObject1 = findViewById(R.h.loading_tips_area);
      if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8)) {
        new com.tencent.mm.sdk.platformtools.ah(Looper.getMainLooper()).post(new ac.6(this, (View)localObject1));
      }
      return;
      ((AccountInfoPreference)localObject2).shY = ((String)localObject1);
      break;
      ((AccountInfoPreference)localObject2).shY = ((String)localObject1);
      break;
      label457:
      ((IconPreference)localObject1).Gt(8);
      ((IconPreference)localObject1).dD("", -1);
      break label198;
      label473:
      this.dnn.bJ("settings_mm_favorite", false);
      break label232;
      label489:
      this.dnn.bJ("more_uishow", true);
      break label269;
      label505:
      this.dnn.bJ("settings_privacy_agreements", true);
    }
  }
  
  protected final void cxF() {}
  
  protected final void cxG()
  {
    com.tencent.mm.y.c.BS().b(this.nWw);
    au.Hx();
    com.tencent.mm.model.c.Dz().b(this);
  }
  
  protected final void cxH() {}
  
  protected final void cxI() {}
  
  public final void cxK() {}
  
  public final void cxL() {}
  
  public final void cxN() {}
  
  public final void cyy() {}
  
  public final void cyz() {}
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    y.i("MicroMsg.MoreTabUI", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.dnn = this.vdd;
    this.dnn.bJ("more_setting", true);
    this.dnn.bJ("settings_emoji_store", true);
    this.dnn.bJ("settings_mm_wallet", true);
    this.dnn.bJ("settings_mm_cardpackage", true);
    this.dnn.bJ("settings_mm_favorite", true);
    this.dnn.bJ("settings_my_album", true);
    this.dnn.bJ("settings_my_address", true);
    this.dnn.bJ("more_tab_setting_personal_info", true);
    this.dnn.bJ("more_uishow", true);
    this.dnn.bJ("settings_privacy_agreements", true);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((!au.DK()) || (au.CW())) {
      y.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", new Object[] { Boolean.valueOf(au.DK()), Boolean.valueOf(au.CW()) });
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  public final int xj()
  {
    return R.o.more_tab_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ac
 * JD-Core Version:    0.7.0.1
 */