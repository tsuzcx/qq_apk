package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.d.a;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.d.b.d;
import com.tencent.mm.aj.d.b.e;
import com.tencent.mm.aj.d.b.f;
import com.tencent.mm.aj.d.b.g;
import com.tencent.mm.aj.g;
import com.tencent.mm.aj.h.a;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMoreInofUI
  extends MMPreference
  implements h.a
{
  private ad contact;
  private List<d.a> fuX;
  private d.b fuY;
  private boolean fvf = false;
  private int gyR;
  private com.tencent.mm.aj.d pyd;
  private wc pzI;
  private String pzN;
  private boolean pzO;
  private Bundle pzQ;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void Xe(final String paramString)
  {
    AppMethodBeat.i(23906);
    al.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23898);
        if (NewBizInfoMoreInofUI.a(NewBizInfoMoreInofUI.this) == null)
        {
          ab.w("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar screen is null");
          AppMethodBeat.o(23898);
          return;
        }
        IconWidgetPreference localIconWidgetPreference = (IconWidgetPreference)NewBizInfoMoreInofUI.a(NewBizInfoMoreInofUI.this).atx("contact_info_kf_worker");
        if ((localIconWidgetPreference != null) && (NewBizInfoMoreInofUI.a(NewBizInfoMoreInofUI.this) != null))
        {
          Bitmap localBitmap = b.b(paramString, false, -1);
          if (localBitmap != null)
          {
            ab.d("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar success %s, update screen", new Object[] { paramString });
            localIconWidgetPreference.M(localBitmap);
            NewBizInfoMoreInofUI.a(NewBizInfoMoreInofUI.this).notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(23898);
      }
    }, 2000L);
    AppMethodBeat.o(23906);
  }
  
  private void aV(int paramInt, String paramString)
  {
    AppMethodBeat.i(23911);
    if ((this.pzQ == null) || ((this.gyR != 39) && (this.gyR != 56) && (this.gyR != 35) && (this.gyR != 87) && (this.gyR != 88) && (this.gyR != 89) && (this.gyR != 85)))
    {
      ab.d("MicroMsg.NewBizInfoMoreInofUI", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(23911);
      return;
    }
    if (this.contact == null)
    {
      ab.i("MicroMsg.NewBizInfoMoreInofUI", "contact is null.");
      AppMethodBeat.o(23911);
      return;
    }
    String str2 = this.pzQ.getString("Contact_Ext_Args_Search_Id");
    String str3 = bo.nullAsNil(this.pzQ.getString("Contact_Ext_Args_Query_String"));
    int j = this.pzQ.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.gyR)
    {
    default: 
      i = 0;
      str1 = bo.nullAsNil(this.pzQ.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bo.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bo.isNullOrNil(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      ab.v("MicroMsg.NewBizInfoMoreInofUI", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10866, paramString);
      AppMethodBeat.o(23911);
      return;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      i = 5;
      break;
    }
  }
  
  private static void c(g paramg)
  {
    AppMethodBeat.i(23905);
    long l = System.currentTimeMillis();
    com.tencent.mm.ah.i locali = o.adg();
    if (locali.rj(paramg.field_openId) == null)
    {
      com.tencent.mm.ah.h localh = new com.tencent.mm.ah.h();
      localh.username = paramg.field_openId;
      localh.fsk = paramg.field_headImgUrl;
      localh.cM(false);
      localh.dqB = 3;
      locali.b(localh);
    }
    o.adi().qV(paramg.field_openId);
    ab.d("MicroMsg.NewBizInfoMoreInofUI", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(23905);
  }
  
  private d.a ccR()
  {
    AppMethodBeat.i(23903);
    if ((this.fuX == null) || (this.fuX.size() < 0))
    {
      ab.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
      AppMethodBeat.o(23903);
      return null;
    }
    Iterator localIterator = this.fuX.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      if ((locala.fvb.equals("__mp_wording__brandinfo_location")) || (getString(2131298562).equals(locala.title)))
      {
        AppMethodBeat.o(23903);
        return locala;
      }
    }
    ab.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
    AppMethodBeat.o(23903);
    return null;
  }
  
  public final String aeZ()
  {
    return "MicroMsg.NewBizInfoMoreInofUI";
  }
  
  public final void e(LinkedList<czd> paramLinkedList)
  {
    AppMethodBeat.i(23907);
    z.afj().b(this);
    if (this.screen == null)
    {
      ab.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, screen is null");
      AppMethodBeat.o(23907);
      return;
    }
    if (this.contact == null)
    {
      ab.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, contact is null");
      AppMethodBeat.o(23907);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ab.w("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, worker is null");
      AppMethodBeat.o(23907);
      return;
    }
    if (!bo.isNullOrNil(this.pzN))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        czd localczd = (czd)localIterator.next();
        if ((localczd.ygd != null) && (localczd.ygd.equals(this.pzN)))
        {
          this.screen.cl("contact_info_kf_worker", false);
          this.screen.atx("contact_info_kf_worker").setSummary(localczd.Nickname);
          AppMethodBeat.o(23907);
          return;
        }
      }
    }
    this.screen.cl("contact_info_kf_worker", false);
    this.screen.atx("contact_info_kf_worker").setSummary(((czd)paramLinkedList.get(0)).Nickname);
    AppMethodBeat.o(23907);
  }
  
  public int getResourceId()
  {
    return 2131165254;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23901);
    this.screen.cl("biz_placed_to_the_top", true);
    Object localObject2 = com.tencent.mm.aj.f.rS(this.contact.field_username);
    this.fuX = null;
    this.fuY = null;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((com.tencent.mm.aj.d)localObject2).cU(false) != null) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.pzI != null)
      {
        localObject1 = new com.tencent.mm.aj.d();
        ((com.tencent.mm.aj.d)localObject1).field_username = this.contact.field_username;
        ((com.tencent.mm.aj.d)localObject1).field_brandFlag = this.pzI.gxd;
        ((com.tencent.mm.aj.d)localObject1).field_brandIconURL = this.pzI.gxg;
        ((com.tencent.mm.aj.d)localObject1).field_brandInfo = this.pzI.gxf;
        ((com.tencent.mm.aj.d)localObject1).field_extInfo = this.pzI.gxe;
        ((com.tencent.mm.aj.d)localObject1).field_type = ((com.tencent.mm.aj.d)localObject1).cU(false).getServiceType();
      }
    }
    if ((localObject1 != null) && (((com.tencent.mm.aj.d)localObject1).field_brandInfo == null) && (((com.tencent.mm.aj.d)localObject1).field_extInfo == null) && (this.pzI != null))
    {
      ((com.tencent.mm.aj.d)localObject1).field_username = this.contact.field_username;
      ((com.tencent.mm.aj.d)localObject1).field_brandFlag = this.pzI.gxd;
      ((com.tencent.mm.aj.d)localObject1).field_brandIconURL = this.pzI.gxg;
      ((com.tencent.mm.aj.d)localObject1).field_brandInfo = this.pzI.gxf;
      ((com.tencent.mm.aj.d)localObject1).field_extInfo = this.pzI.gxe;
      ((com.tencent.mm.aj.d)localObject1).field_type = ((com.tencent.mm.aj.d)localObject1).cU(false).getServiceType();
    }
    if (localObject1 != null)
    {
      this.pyd = ((com.tencent.mm.aj.d)localObject1);
      this.fuX = ((com.tencent.mm.aj.d)localObject1).aep();
      this.fuY = ((com.tencent.mm.aj.d)localObject1).cU(false);
      this.fvf = this.fuY.aer();
    }
    boolean bool;
    label383:
    Object localObject4;
    label398:
    Object localObject6;
    int i;
    if (com.tencent.mm.n.a.je(this.contact.field_type)) {
      if (this.pyd == null)
      {
        bool = true;
        if (!bool) {
          break label1224;
        }
        localObject1 = (KeyValuePreference)this.screen.atx("contact_info_wechat_account");
        if (bo.isNullOrNil(this.contact.Hq())) {
          break label1121;
        }
        this.screen.cl("contact_info_wechat_account", false);
        ((KeyValuePreference)localObject1).setSummary(j.b(this, this.contact.Hq()));
        ((Preference)localObject1).zsd = new NewBizInfoMoreInofUI.2(this, (KeyValuePreference)localObject1);
        if ((this.fuY == null) || (this.fuY.aeB() == null) || (bo.isNullOrNil(this.fuY.aeB().fvS))) {
          break label1370;
        }
        localObject4 = this.fuY.aeB();
        localObject6 = (KeyValuePreference)this.screen.atx("contact_info_verifyuser");
        if (localObject6 == null) {
          break label1354;
        }
        ((KeyValuePreference)localObject6).dEO();
        ((KeyValuePreference)localObject6).zrr = false;
        if (!bo.isNullOrNil(((d.b.d)localObject4).fvT)) {
          break label1285;
        }
        i = ((d.b.d)localObject4).fvR;
        switch (i)
        {
        default: 
          ab.w("MicroMsg.NewBizInfoMoreInofUI", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(i) });
          localObject1 = getResources().getString(2131298633);
          label547:
          ((KeyValuePreference)localObject6).zaD = ((String)localObject1);
          label554:
          if (ao.a.flK != null)
          {
            localObject1 = BackwardSupportUtil.b.k(ao.a.flK.kx(this.contact.field_verifyFlag), 2.0F);
            label581:
            if (localObject1 == null) {
              break label3194;
            }
            localObject2 = com.tencent.mm.sdk.platformtools.d.Na(2131231766);
          }
          break;
        }
      }
    }
    label617:
    label1516:
    label2038:
    label3194:
    Object localObject3;
    for (localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject2);; localObject3 = null)
    {
      String str;
      if (localObject1 == null)
      {
        bool = true;
        ab.i("MicroMsg.NewBizInfoMoreInofUI", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
        ((KeyValuePreference)localObject6).zrz = ((Drawable)localObject2);
        if (((d.b.d)localObject4).fvS == null) {
          break label1343;
        }
        str = ((d.b.d)localObject4).fvV;
        localObject2 = j.b(this, ((d.b.d)localObject4).fvS.trim());
        if (bo.isNullOrNil(str)) {
          break label3187;
        }
      }
      for (;;)
      {
        label1285:
        try
        {
          localObject1 = new SpannableString(str + " " + localObject2);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
        {
          label1121:
          localObject1 = localObject2;
          label1224:
          localObject2 = localIndexOutOfBoundsException2;
        }
        try
        {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-36352), 0, str.length(), 17);
          ((KeyValuePreference)localObject6).setSummary((CharSequence)localObject1);
          if ((this.fuY == null) || (bo.isNullOrNil(this.fuY.aev()))) {
            break label1479;
          }
          localObject2 = (KeyValuePreference)this.screen.atx("contact_info_trademark");
          if (localObject2 == null) {
            continue;
          }
          ((KeyValuePreference)localObject2).dEO();
          ((KeyValuePreference)localObject2).zrr = false;
          if (ao.a.flK == null) {
            break label1467;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.d.Na(2131231770);
          if (localObject1 != null) {
            break label1473;
          }
          bool = true;
          ab.i("MicroMsg.NewBizInfoMoreInofUI", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label3181;
          }
          localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
        {
          for (;;)
          {
            int k;
            continue;
            int j = k;
          }
          localObject1 = null;
          continue;
        }
        ((KeyValuePreference)localObject2).zrz = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.fuY.aev());
        ab.d("MicroMsg.NewBizInfoMoreInofUI", "trademark name : %s, url : %s.", new Object[] { this.fuY.aev(), this.fuY.aeu() });
        if ((this.fuY != null) && (this.fuY.aex() != null) && (this.fuY.aex().size() > 0))
        {
          localObject1 = (KeyValuePreference)this.screen.atx("contact_info_privilege");
          ((KeyValuePreference)localObject1).dEO();
          ((KeyValuePreference)localObject1).qJ(false);
          ((KeyValuePreference)localObject1).dEN();
          localObject2 = this.fuY.aex().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label1516;
          }
          localObject4 = (d.b.f)((Iterator)localObject2).next();
          localObject6 = (LinearLayout)View.inflate(this, 2130969952, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(2131822243)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(getResources(), ((d.b.f)localObject4).iconUrl));
          str = ((d.b.f)localObject4).description;
          getResources().getIdentifier(((d.b.f)localObject4).fwa, "string", getPackageName());
          ((TextView)((LinearLayout)localObject6).findViewById(2131821890)).setText(str);
          ((KeyValuePreference)localObject1).eO((View)localObject6);
          continue;
          bool = this.pyd.aem();
          break;
          if ((!ad.ari(this.contact.field_username)) && (!t.nS(this.contact.field_username)))
          {
            this.screen.cl("contact_info_wechat_account", false);
            localObject2 = bo.nullAsNil(this.contact.Og());
            ((KeyValuePreference)localObject1).setSummary(getContext().getString(2131296950) + (String)localObject2);
            break label383;
          }
          this.screen.cl("contact_info_wechat_account", true);
          break label383;
          this.screen.cl("contact_info_wechat_account", true);
          break label398;
          localObject1 = getResources().getString(2131298827);
          break label547;
          localObject1 = getResources().getString(2131298554);
          break label547;
          localObject1 = getResources().getString(2131298555);
          break label547;
          ((KeyValuePreference)localObject6).zaD = ((d.b.d)localObject4).fvT;
          break label554;
          localObject1 = null;
          break label581;
          bool = false;
          break label617;
          ab.e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
          continue;
          label1343:
          ab.e("MicroMsg.NewBizInfoMoreInofUI", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
          continue;
          label1354:
          this.screen.cl("contact_info_verifyuser", true);
          continue;
          label1370:
          if ((this.fuY != null) && (this.fuY.aeC() != null) && (!bo.isNullOrNil(this.fuY.aeC().fwb)))
          {
            localObject1 = (KeyValuePreference)this.screen.atx("contact_info_verifyuser");
            if (localObject1 == null) {
              continue;
            }
            ((KeyValuePreference)localObject1).setSummary(this.fuY.aeC().fwb);
            continue;
          }
          ab.w("MicroMsg.NewBizInfoMoreInofUI", "has not verify info");
          this.screen.cl("contact_info_verifyuser", true);
          continue;
          label1467:
          localObject1 = null;
          continue;
          label1473:
          bool = false;
          continue;
          label1479:
          ab.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
          this.screen.cl("contact_info_trademark", true);
          continue;
        }
        this.screen.cl("contact_info_privilege", true);
        localObject2 = getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        ab.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", new Object[] { localObject2, Boolean.valueOf(this.pzO) });
        if (!this.pzO)
        {
          this.pzN = ((String)localObject2);
          if ((this.fuY == null) || (!this.fuY.aeH()) || (this.contact == null)) {
            this.screen.cl("contact_info_kf_worker", true);
          }
        }
        else
        {
          if ((this.fuY == null) || (bo.isNullOrNil(this.fuY.aeG()))) {
            break label2992;
          }
          this.screen.cl("contact_info_service_phone", false);
          localObject1 = this.screen.atx("contact_info_service_phone");
          if (localObject1 != null)
          {
            ((Preference)localObject1).setSummary(this.fuY.aeG());
            ((Preference)localObject1).kCA = getResources().getColor(2131690214);
          }
          label1684:
          if ((this.fuY == null) || (this.fuY.aez() == null)) {
            break label3056;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.atx("contact_info_reputation");
          if (this.fuY.aez().fvW <= 0) {
            break label3008;
          }
          ((BizInfoPayInfoIconPreference)localObject1).Bt(this.fuY.aez().fvW);
          label1746:
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.atx("contact_info_guarantee_info");
          if ((this.fuY.aez().fvY == null) || (this.fuY.aez().fvY.size() <= 0)) {
            break label3024;
          }
          ((BizInfoPayInfoIconPreference)localObject1).cA(this.fuY.aez().fvY);
          label1809:
          localObject1 = (KeyValuePreference)this.screen.atx("contact_info_scope_of_business");
          if (bo.isNullOrNil(this.fuY.aez().fvX)) {
            break label3040;
          }
          ((KeyValuePreference)localObject1).setSummary(this.fuY.aez().fvX);
          ((KeyValuePreference)localObject1).zrx = 4;
          ((KeyValuePreference)localObject1).qJ(false);
          label1869:
          if ((!t.w(this.contact)) || (this.contact.dqO == null) || (this.contact.dqO.equals(""))) {
            break label3098;
          }
          localObject1 = (KeyValuePreference)this.screen.atx("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(bo.bf(this.contact.field_weiboNickname, "") + getString(2131303424, new Object[] { t.oK(this.contact.dqO) }));
            ((Preference)localObject1).kCA = com.tencent.mm.cb.a.m(this, 2131690214);
            ((KeyValuePreference)localObject1).qJ(false);
          }
          label2003:
          if ((this.fuY == null) || (!this.fuY.aeq())) {
            break label3114;
          }
          this.screen.atx("near_field_service").setSummary(2131305950);
          if (ccR() == null) {
            break label3130;
          }
          this.screen.cl("contact_info_see_locate", false);
        }
        for (;;)
        {
          k = this.screen.indexOf("contact_info_category2");
          if ((k < 0) || (this.fuX == null) || (this.fuX.size() <= 0)) {
            break label3153;
          }
          i = this.fuX.size() - 1;
          while (i >= 0)
          {
            if ((this.fuX.get(i) != null) && ((!getString(2131298560).equals(((d.a)this.fuX.get(i)).title)) || (this.fvf)) && ((!bo.isNullOrNil(((d.a)this.fuX.get(i)).title)) || (!bo.isNullOrNil(((d.a)this.fuX.get(i)).fvb))) && (!((d.a)this.fuX.get(i)).fvb.equals("__mp_wording__brandinfo_location")) && (!getString(2131298562).equals(((d.a)this.fuX.get(i)).title)) && (!((d.a)this.fuX.get(i)).fvb.equals("__mp_wording__brandinfo_history_massmsg")))
            {
              localObject5 = new Preference(this);
              ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
              localObject1 = ((d.a)this.fuX.get(i)).title;
              j = getResources().getIdentifier(((d.a)this.fuX.get(i)).fvb, "string", getPackageName());
              if (j > 0) {
                localObject1 = getString(j);
              }
              localObject2 = localObject1;
              if (this.pyd.aef()) {
                if (!"__mp_wording__brandinfo_history_massmsg".equals(((d.a)this.fuX.get(i)).fvb))
                {
                  localObject2 = localObject1;
                  if (!((String)localObject1).equals(getString(2131296336))) {}
                }
                else
                {
                  localObject2 = getString(2131299301);
                }
              }
              ((Preference)localObject5).setTitle((CharSequence)localObject2);
              if (!bo.isNullOrNil(((d.a)this.fuX.get(i)).description)) {
                ((Preference)localObject5).setSummary(((d.a)this.fuX.get(i)).description);
              }
              if (!bo.nullAsNil(((d.a)this.fuX.get(i)).fvb).equals("__mp_wording__brandinfo_feedback")) {
                break label3173;
              }
              j = this.screen.indexOf("contact_info_scope_of_business");
              if (j <= 0) {
                break label3173;
              }
              j += 1;
              this.screen.a((Preference)localObject5, j);
              if (bo.nullAsNil(((d.a)this.fuX.get(i)).fvb).equals("__mp_wording__brandinfo_biz_detail"))
              {
                localObject1 = new PreferenceSmallCategory(this);
                this.screen.a((Preference)localObject1, j);
              }
            }
            i -= 1;
          }
          if (bo.isNullOrNil((String)localObject2))
          {
            localObject1 = z.afh().sc(this.contact.field_username);
            if (localObject1 == null)
            {
              this.screen.cl("contact_info_kf_worker", true);
              z.afj().a(this);
              z.afj().aB(this.contact.field_username, r.Zn());
              this.pzO = true;
              break;
            }
            ab.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", new Object[] { ((g)localObject1).field_openId });
            this.screen.cl("contact_info_kf_worker", false);
            localObject2 = (IconWidgetPreference)this.screen.atx("contact_info_kf_worker");
            ((IconWidgetPreference)localObject2).setSummary(((g)localObject1).field_nickname);
            localObject5 = b.b(((g)localObject1).field_openId, false, -1);
            if (localObject5 == null)
            {
              c((g)localObject1);
              Xe(((g)localObject1).field_openId);
              break;
            }
            ((IconWidgetPreference)localObject2).M((Bitmap)localObject5);
            break;
          }
          Object localObject5 = z.afh();
          localObject1 = ((com.tencent.mm.aj.i)localObject5).sb((String)localObject2);
          if ((localObject1 == null) || (com.tencent.mm.aj.i.a((g)localObject1)))
          {
            z.afj().a(this);
            z.afj().aC(this.contact.field_username, (String)localObject2);
            this.pzO = true;
          }
          if (localObject1 != null) {
            break label3178;
          }
          ab.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
          localObject1 = ((com.tencent.mm.aj.i)localObject5).sc(this.contact.field_username);
          if (localObject1 == null)
          {
            this.screen.cl("contact_info_kf_worker", true);
            break;
          }
          this.screen.cl("contact_info_kf_worker", false);
          localObject2 = (IconWidgetPreference)this.screen.atx("contact_info_kf_worker");
          ((IconWidgetPreference)localObject2).setSummary(((g)localObject1).field_nickname);
          localObject5 = b.b(((g)localObject1).field_openId, false, -1);
          if (localObject5 == null)
          {
            c((g)localObject1);
            Xe(((g)localObject1).field_openId);
          }
          for (;;)
          {
            ab.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", new Object[] { ((g)localObject1).field_openId, ((g)localObject1).field_nickname });
            break;
            ((IconWidgetPreference)localObject2).M((Bitmap)localObject5);
          }
          label2992:
          this.screen.cl("contact_info_service_phone", true);
          break label1684;
          label3008:
          this.screen.cl("contact_info_reputation", true);
          break label1746;
          label3024:
          this.screen.cl("contact_info_guarantee_info", true);
          break label1809;
          label3040:
          this.screen.cl("contact_info_scope_of_business", true);
          break label1869;
          label3056:
          this.screen.cl("contact_info_reputation", true);
          this.screen.cl("contact_info_guarantee_info", true);
          this.screen.cl("contact_info_scope_of_business", true);
          break label1869;
          label3098:
          this.screen.cl("contact_info_verifyuser_weibo", true);
          break label2003;
          label3114:
          this.screen.cl("near_field_service", true);
          break label2038;
          label3130:
          this.screen.cl("contact_info_see_locate", true);
        }
        AppMethodBeat.o(23901);
        return;
        label3153:
        ab.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
        AppMethodBeat.o(23901);
        return;
        label3173:
        label3178:
        label3181:
        label3187:
        localObject1 = localIndexOutOfBoundsException1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23900);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setActionbarColor(a.pDd);
    setMMTitle(2131298547);
    setMMTitleColor(-16777216);
    setTitleDividerVis(false);
    hideActionbarLine();
    setIsDarkActionbarBg(false);
    setBackBtn(new NewBizInfoMoreInofUI.1(this), 2131230737);
    paramBundle = bo.nullAsNil(getIntent().getStringExtra("Contact_User"));
    String str1 = bo.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    int i = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
    int j = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
    String str2 = getIntent().getStringExtra("Contact_KWeibo");
    String str3 = getIntent().getStringExtra("Contact_KWeiboNick");
    aw.aaz();
    this.contact = com.tencent.mm.model.c.YA().arw(paramBundle);
    if ((this.contact == null) || ((int)this.contact.euF == 0) || (bo.nullAsNil(this.contact.field_username).length() <= 0))
    {
      this.contact = new ad();
      this.contact.setUsername(paramBundle);
      this.contact.jm(str1);
      this.contact.hu(i);
      this.contact.jJ(str2);
      this.contact.ht(j);
      this.contact.js(str3);
    }
    for (;;)
    {
      this.pyd = com.tencent.mm.aj.f.rS(this.contact.field_username);
      paramBundle = getIntent().getByteArrayExtra("Contact_customInfo");
      if (paramBundle == null) {
        paramBundle = null;
      }
      try
      {
        for (;;)
        {
          this.pzI = paramBundle;
          this.gyR = getIntent().getIntExtra("Contact_Scene", 9);
          this.pzQ = getIntent().getBundleExtra("Contact_Ext_Args");
          initView();
          AppMethodBeat.o(23900);
          return;
          if (i == 0) {
            break;
          }
          this.contact.hu(i);
          break;
          paramBundle = (wc)new wc().parseFrom(paramBundle);
        }
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.NewBizInfoMoreInofUI", paramBundle, "", new Object[0]);
        }
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 6;
    AppMethodBeat.i(23910);
    paramPreference = paramPreference.mKey;
    ab.i("MicroMsg.NewBizInfoMoreInofUI", paramPreference + " item has been clicked!");
    Object localObject;
    int j;
    if ("contact_info_see_locate".endsWith(paramPreference))
    {
      paramf = ccR();
      if (paramf == null)
      {
        ab.e("MicroMsg.NewBizInfoMoreInofUI", "[onPreferenceTreeClick] info is null, err");
        AppMethodBeat.o(23910);
        return false;
      }
      localObject = paramf.url;
      paramPreference = new Intent();
      paramPreference.putExtra("rawUrl", (String)localObject);
      paramPreference.putExtra("useJs", true);
      paramPreference.putExtra("vertical_scroll", true);
      paramPreference.putExtra("geta8key_scene", 3);
      paramPreference.putExtra("KPublisherId", "brand_profile");
      paramPreference.putExtra("prePublishId", "brand_profile");
      if (((this.pzQ != null) && ((this.gyR == 39) || (this.gyR == 56) || (this.gyR == 35))) || (this.gyR == 87) || (this.gyR == 89) || (this.gyR == 85) || (this.gyR == 88))
      {
        ab.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("KFromBizSearch", true);
        ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.pzQ);
        paramPreference.putExtra("jsapiargs", (Bundle)localObject);
        if (!com.tencent.mm.n.a.je(this.contact.field_type)) {
          break label343;
        }
      }
      label343:
      for (i = 7;; i = 6)
      {
        j = getResources().getIdentifier(paramf.fvb, "string", getPackageName());
        paramf = paramf.title;
        if (j > 0) {
          paramf = getString(j);
        }
        aV(i, paramf);
        com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(23910);
        return true;
      }
    }
    if ("contact_info_verifyuser".endsWith(paramPreference))
    {
      paramf = this.pyd;
      if (paramf == null)
      {
        AppMethodBeat.o(23910);
        return true;
      }
      localObject = paramf.cU(false);
      if (localObject == null)
      {
        AppMethodBeat.o(23910);
        return true;
      }
      paramPreference = null;
      if ((((d.b)localObject).aeB() != null) && (!bo.isNullOrNil(((d.b)localObject).aeB().fvU))) {
        paramf = ((d.b)localObject).aeB().fvU;
      }
      for (;;)
      {
        if (!bo.isNullOrNil(paramf))
        {
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("useJs", true);
          paramPreference.putExtra("vertical_scroll", true);
          paramPreference.putExtra("geta8key_scene", 3);
          com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(this.contact.field_username, 1200);
        AppMethodBeat.o(23910);
        return true;
        paramf = paramPreference;
        if (((d.b)localObject).aeC() != null)
        {
          paramf = paramPreference;
          if (!bo.isNullOrNil(((d.b)localObject).aeC().fwc)) {
            paramf = ((d.b)localObject).aeC().fwc;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramPreference))
    {
      paramf = this.pyd;
      if (paramf == null)
      {
        AppMethodBeat.o(23910);
        return true;
      }
      if ((paramf.cU(false) != null) && (!bo.isNullOrNil(paramf.cU(false).aeu())))
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf.cU(false).aeu());
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
      }
      AppMethodBeat.o(23910);
      return true;
    }
    if ("contact_info_service_phone".equals(paramPreference))
    {
      paramf = paramf.atx("contact_info_service_phone");
      if ((paramf != null) && (paramf.getSummary() != null) && (!bo.isNullOrNil(paramf.getSummary().toString())))
      {
        paramf = paramf.getSummary().toString();
        com.tencent.mm.ui.base.h.a(this, true, paramf, "", getString(2131298584), getString(2131296888), new NewBizInfoMoreInofUI.4(this, paramf), null);
      }
    }
    if (paramPreference.startsWith("contact_info_bizinfo_external#"))
    {
      j = bo.getInt(paramPreference.replace("contact_info_bizinfo_external#", ""), -1);
      if ((j >= 0) && (j < this.fuX.size()))
      {
        paramf = (d.a)this.fuX.get(j);
        localObject = paramf.url;
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", (String)localObject);
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        paramPreference.putExtra("KPublisherId", "brand_profile");
        paramPreference.putExtra("prePublishId", "brand_profile");
        if (((this.pzQ != null) && ((this.gyR == 39) || (this.gyR == 56) || (this.gyR == 35))) || (this.gyR == 87) || (this.gyR == 89) || (this.gyR == 85) || (this.gyR == 88))
        {
          ab.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.pzQ);
          paramPreference.putExtra("jsapiargs", (Bundle)localObject);
          if (com.tencent.mm.n.a.je(this.contact.field_type)) {
            i = 7;
          }
          j = getResources().getIdentifier(paramf.fvb, "string", getPackageName());
          paramf = paramf.title;
          if (j > 0) {
            paramf = getString(j);
          }
          aV(i, paramf);
        }
        com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(23910);
        return true;
      }
    }
    if (paramPreference.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this).fN(this.contact.dqO, this.contact.field_username);
      AppMethodBeat.o(23910);
      return true;
    }
    if (("contact_info_guarantee_info".equals(paramPreference)) && (this.fuY.aez() != null) && (!bo.isNullOrNil(this.fuY.aez().fvZ)))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", this.fuY.aez().fvZ);
      paramf.putExtra("useJs", true);
      paramf.putExtra("vertical_scroll", true);
      paramf.putExtra("geta8key_scene", 3);
      com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    if ((!"contact_info_expose_btn".equals(paramPreference)) || (this.contact == null) || (bo.isNullOrNil(this.contact.field_username))) {}
    for (;;)
    {
      AppMethodBeat.o(23910);
      return false;
      paramf = new Intent();
      paramf.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[] { this.contact.field_username }));
      paramf.putExtra("showShare", false);
      com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI
 * JD-Core Version:    0.7.0.1
 */