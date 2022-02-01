package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.am.e;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.g;
import com.tencent.mm.ao.i;
import com.tencent.mm.ao.i.b;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.fmr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.c;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMoreInofUI
  extends MMPreference
  implements i.b
{
  private static final String GZd;
  private com.tencent.mm.api.c GXj;
  private aez GYV;
  private String GZa;
  private boolean GZb;
  private Bundle GZe;
  private as contact;
  private List<c.a> eZb;
  private c.b eZc;
  private boolean eZj = false;
  private int mXL;
  private f screen;
  
  static
  {
    AppMethodBeat.i(287586);
    GZd = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/infringement?username=%s&from=1#wechat_redirect";
    AppMethodBeat.o(287586);
  }
  
  private void aUQ(String paramString)
  {
    AppMethodBeat.i(27553);
    MMHandlerThread.postToMainThreadDelayed(new NewBizInfoMoreInofUI.3(this, paramString), 2000L);
    AppMethodBeat.o(27553);
  }
  
  private void bN(int paramInt, String paramString)
  {
    AppMethodBeat.i(27556);
    if ((this.GZe == null) || ((this.mXL != 39) && (this.mXL != 56) && (this.mXL != 35) && (this.mXL != 87) && (this.mXL != 88) && (this.mXL != 89) && (this.mXL != 85)))
    {
      Log.d("MicroMsg.NewBizInfoMoreInofUI", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27556);
      return;
    }
    if (this.contact == null)
    {
      Log.i("MicroMsg.NewBizInfoMoreInofUI", "contact is null.");
      AppMethodBeat.o(27556);
      return;
    }
    String str2 = this.GZe.getString("Contact_Ext_Args_Search_Id");
    String str3 = Util.nullAsNil(this.GZe.getString("Contact_Ext_Args_Query_String"));
    int j = this.GZe.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.mXL)
    {
    default: 
      i = 0;
      str1 = Util.nullAsNil(this.GZe.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + Util.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (Util.isNullOrNil(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      Log.v("MicroMsg.NewBizInfoMoreInofUI", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10866, paramString);
      AppMethodBeat.o(27556);
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
  
  private static void c(com.tencent.mm.ao.h paramh)
  {
    AppMethodBeat.i(27552);
    long l = System.currentTimeMillis();
    k localk = q.bhP();
    if (localk.TS(paramh.field_openId) == null)
    {
      com.tencent.mm.am.j localj = new com.tencent.mm.am.j();
      localj.username = paramh.field_openId;
      localj.lBd = paramh.field_headImgUrl;
      localj.gg(false);
      localj.hDc = 3;
      localk.b(localj);
    }
    q.bhR().Rv(paramh.field_openId);
    Log.d("MicroMsg.NewBizInfoMoreInofUI", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27552);
  }
  
  private c.a fqX()
  {
    AppMethodBeat.i(27551);
    if ((this.eZb == null) || (this.eZb.size() < 0))
    {
      Log.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
      AppMethodBeat.o(27551);
      return null;
    }
    Iterator localIterator = this.eZb.iterator();
    while (localIterator.hasNext())
    {
      c.a locala = (c.a)localIterator.next();
      if ((locala.eZf.equals("__mp_wording__brandinfo_location")) || (getString(R.l.eyj).equals(locala.title)))
      {
        AppMethodBeat.o(27551);
        return locala;
      }
    }
    Log.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
    AppMethodBeat.o(27551);
    return null;
  }
  
  public final String bjj()
  {
    return "MicroMsg.NewBizInfoMoreInofUI";
  }
  
  public final void e(LinkedList<fmr> paramLinkedList)
  {
    AppMethodBeat.i(27554);
    af.bjw().b(this);
    if (this.screen == null)
    {
      Log.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, screen is null");
      AppMethodBeat.o(27554);
      return;
    }
    if (this.contact == null)
    {
      Log.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, contact is null");
      AppMethodBeat.o(27554);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.w("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, worker is null");
      AppMethodBeat.o(27554);
      return;
    }
    if (!Util.isNullOrNil(this.GZa))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        fmr localfmr = (fmr)localIterator.next();
        if ((localfmr.ULp != null) && (localfmr.ULp.equals(this.GZa)))
        {
          this.screen.dz("contact_info_kf_worker", false);
          this.screen.byG("contact_info_kf_worker").aF(localfmr.Nickname);
          AppMethodBeat.o(27554);
          return;
        }
      }
    }
    this.screen.dz("contact_info_kf_worker", false);
    this.screen.byG("contact_info_kf_worker").aF(((fmr)paramLinkedList.get(0)).Nickname);
    AppMethodBeat.o(27554);
  }
  
  public int getResourceId()
  {
    return R.o.eXJ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27550);
    this.screen.dz("biz_placed_to_the_top", true);
    Object localObject2 = g.gu(this.contact.field_username);
    this.eZb = null;
    this.eZc = null;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((com.tencent.mm.api.c)localObject2).dc(false) != null) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.GYV != null)
      {
        localObject1 = new com.tencent.mm.api.c();
        ((com.tencent.mm.api.c)localObject1).field_username = this.contact.field_username;
        ((com.tencent.mm.api.c)localObject1).field_brandFlag = this.GYV.mVM;
        ((com.tencent.mm.api.c)localObject1).field_brandIconURL = this.GYV.mVP;
        ((com.tencent.mm.api.c)localObject1).field_brandInfo = this.GYV.mVO;
        ((com.tencent.mm.api.c)localObject1).field_extInfo = this.GYV.mVN;
        ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).dc(false).getServiceType();
      }
    }
    if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_brandInfo == null) && (((com.tencent.mm.api.c)localObject1).field_extInfo == null) && (this.GYV != null))
    {
      ((com.tencent.mm.api.c)localObject1).field_username = this.contact.field_username;
      ((com.tencent.mm.api.c)localObject1).field_brandFlag = this.GYV.mVM;
      ((com.tencent.mm.api.c)localObject1).field_brandIconURL = this.GYV.mVP;
      ((com.tencent.mm.api.c)localObject1).field_brandInfo = this.GYV.mVO;
      ((com.tencent.mm.api.c)localObject1).field_extInfo = this.GYV.mVN;
      ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).dc(false).getServiceType();
    }
    if (localObject1 != null)
    {
      this.GXj = ((com.tencent.mm.api.c)localObject1);
      this.eZb = ((com.tencent.mm.api.c)localObject1).Zg();
      this.eZc = ((com.tencent.mm.api.c)localObject1).dc(false);
      this.eZj = this.eZc.Zi();
    }
    boolean bool;
    label385:
    label400:
    Object localObject4;
    Object localObject6;
    int i;
    if (com.tencent.mm.contact.d.rk(this.contact.field_type)) {
      if (this.GXj == null)
      {
        bool = true;
        if (!bool) {
          break label1244;
        }
        localObject1 = (KeyValuePreference)this.screen.byG("contact_info_wechat_account");
        if (Util.isNullOrNil(this.contact.apf())) {
          break label1125;
        }
        this.screen.dz("contact_info_wechat_account", false);
        ((KeyValuePreference)localObject1).aF(l.c(this, this.contact.apf()));
        ((Preference)localObject1).Wsz = new Preference.c()
        {
          public final boolean fqY()
          {
            AppMethodBeat.i(27546);
            ClipboardHelper.setText(this.Hem.fqw());
            com.tencent.mm.ui.base.h.cO(NewBizInfoMoreInofUI.this.getContext(), NewBizInfoMoreInofUI.this.getContext().getString(R.l.app_copy_ok));
            AppMethodBeat.o(27546);
            return true;
          }
        };
        if ((this.eZc == null) || (this.eZc.Zs() == null) || (Util.isNullOrNil(this.eZc.Zs().eZX))) {
          break label1392;
        }
        localObject4 = this.eZc.Zs();
        localObject6 = (KeyValuePreference)this.screen.byG("contact_info_verifyuser");
        if (localObject6 == null) {
          break label1375;
        }
        ((KeyValuePreference)localObject6).hKO();
        ((KeyValuePreference)localObject6).WrK = false;
        if (!Util.isNullOrNil(((c.b.e)localObject4).eZY)) {
          break label1306;
        }
        i = ((c.b.e)localObject4).eZW;
        switch (i)
        {
        default: 
          Log.w("MicroMsg.NewBizInfoMoreInofUI", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(i) });
          localObject1 = getResources().getString(R.l.eyC);
          label551:
          ((KeyValuePreference)localObject6).DJc = ((String)localObject1);
          label558:
          if (az.a.ltt != null)
          {
            localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.ltt.uS(this.contact.field_verifyFlag), 2.0F);
            label585:
            if (localObject1 == null) {
              break label3239;
            }
            localObject2 = BitmapUtil.getBitmapNative(R.k.new_biz_certified);
          }
          break;
        }
      }
    }
    label621:
    label1392:
    label3061:
    label3198:
    Object localObject3;
    label1306:
    label3226:
    label3232:
    label3239:
    for (localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject2);; localObject3 = null)
    {
      String str;
      if (localObject1 == null)
      {
        bool = true;
        Log.i("MicroMsg.NewBizInfoMoreInofUI", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
        ((KeyValuePreference)localObject6).WrR = ((Drawable)localObject2);
        if (((c.b.e)localObject4).eZX == null) {
          break label1364;
        }
        str = ((c.b.e)localObject4).faa;
        localObject2 = l.c(this, ((c.b.e)localObject4).eZX.trim());
        if (Util.isNullOrNil(str)) {
          break label3232;
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = new SpannableString(str + " " + localObject2);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
        {
          label1125:
          localObject1 = localObject2;
          label1244:
          localObject2 = localIndexOutOfBoundsException2;
        }
        try
        {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-36352), 0, str.length(), 17);
          ((KeyValuePreference)localObject6).aF((CharSequence)localObject1);
          if ((this.eZc == null) || (Util.isNullOrNil(this.eZc.Zm()))) {
            break label1502;
          }
          localObject2 = (KeyValuePreference)this.screen.byG("contact_info_trademark");
          if (localObject2 == null) {
            continue;
          }
          ((KeyValuePreference)localObject2).hKO();
          ((KeyValuePreference)localObject2).WrK = false;
          if (az.a.ltt == null) {
            break label1490;
          }
          localObject1 = BitmapUtil.getBitmapNative(R.k.new_biz_trademark_protection);
          if (localObject1 != null) {
            break label1496;
          }
          bool = true;
          Log.i("MicroMsg.NewBizInfoMoreInofUI", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label3226;
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
        ((KeyValuePreference)localObject2).WrR = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).aF(this.eZc.Zm());
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "trademark name : %s, url : %s.", new Object[] { this.eZc.Zm(), this.eZc.Zl() });
        if ((this.eZc != null) && (this.eZc.Zo() != null) && (this.eZc.Zo().size() > 0))
        {
          localObject1 = (KeyValuePreference)this.screen.byG("contact_info_privilege");
          ((KeyValuePreference)localObject1).hKO();
          ((KeyValuePreference)localObject1).FU(false);
          ((KeyValuePreference)localObject1).hKN();
          localObject2 = this.eZc.Zo().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label1541;
          }
          localObject4 = (c.b.g)((Iterator)localObject2).next();
          localObject6 = (LinearLayout)View.inflate(this, R.i.keyvalue_pref_item, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(R.h.image_iv)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(getResources(), ((c.b.g)localObject4).iconUrl));
          str = ((c.b.g)localObject4).description;
          getResources().getIdentifier(((c.b.g)localObject4).faf, "string", getPackageName());
          ((TextView)((LinearLayout)localObject6).findViewById(R.h.summary)).setText(str);
          ((KeyValuePreference)localObject1).hK((View)localObject6);
          continue;
          bool = this.GXj.Zd();
          break;
          if ((!as.bvU(this.contact.field_username)) && (!ab.Qk(this.contact.field_username)))
          {
            this.screen.dz("contact_info_wechat_account", false);
            localObject2 = Util.nullAsNil(this.contact.ayt());
            ((KeyValuePreference)localObject1).aF(com.tencent.mm.plugin.profile.c.bE(getContext(), this.contact.field_username) + com.tencent.mm.plugin.profile.c.jG(this.contact.field_username, (String)localObject2));
            break label385;
          }
          this.screen.dz("contact_info_wechat_account", true);
          break label385;
          this.screen.dz("contact_info_wechat_account", true);
          break label400;
          localObject1 = getResources().getString(R.l.contact_info_verify_user_title);
          break label551;
          localObject1 = getResources().getString(R.l.eyf);
          break label551;
          localObject1 = getResources().getString(R.l.eyg);
          break label551;
          ((KeyValuePreference)localObject6).DJc = ((c.b.e)localObject4).eZY;
          break label558;
          localObject1 = null;
          break label585;
          bool = false;
          break label621;
          Log.e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
          continue;
          label1364:
          Log.e("MicroMsg.NewBizInfoMoreInofUI", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
          continue;
          label1375:
          this.screen.dz("contact_info_verifyuser", true);
          continue;
          if ((this.eZc != null) && (this.eZc.Zt() != null) && (!Util.isNullOrNil(this.eZc.Zt().fag)))
          {
            localObject1 = (KeyValuePreference)this.screen.byG("contact_info_verifyuser");
            if (localObject1 == null) {
              continue;
            }
            ((KeyValuePreference)localObject1).aF(this.eZc.Zt().fag);
            continue;
          }
          Log.w("MicroMsg.NewBizInfoMoreInofUI", "has not verify info");
          this.screen.dz("contact_info_verifyuser", true);
          continue;
          label1490:
          localObject1 = null;
          continue;
          label1496:
          bool = false;
          continue;
          label1502:
          Log.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
          this.screen.dz("contact_info_trademark", true);
          continue;
        }
        this.screen.dz("contact_info_privilege", true);
        localObject2 = getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", new Object[] { localObject2, Boolean.valueOf(this.GZb) });
        if (!this.GZb)
        {
          this.GZa = ((String)localObject2);
          if ((this.eZc == null) || (!this.eZc.Zy()) || (this.contact == null)) {
            this.screen.dz("contact_info_kf_worker", true);
          }
        }
        else
        {
          if ((this.eZc == null) || (Util.isNullOrNil(this.eZc.Zx()))) {
            break label3027;
          }
          this.screen.dz("contact_info_service_phone", false);
          localObject1 = this.screen.byG("contact_info_service_phone");
          if (localObject1 != null)
          {
            ((Preference)localObject1).aF(this.eZc.Zx());
            ((Preference)localObject1).tHk = getResources().getColor(R.e.link_color);
          }
          label1711:
          if ((this.eZc == null) || (this.eZc.Zq() == null)) {
            break label3095;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.byG("contact_info_reputation");
          if (this.eZc.Zq().fab <= 0) {
            break label3044;
          }
          ((BizInfoPayInfoIconPreference)localObject1).abm(this.eZc.Zq().fab);
          label1773:
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.byG("contact_info_guarantee_info");
          if ((this.eZc.Zq().fad == null) || (this.eZc.Zq().fad.size() <= 0)) {
            break label3061;
          }
          ((BizInfoPayInfoIconPreference)localObject1).gv(this.eZc.Zq().fad);
          label1836:
          localObject1 = (KeyValuePreference)this.screen.byG("contact_info_scope_of_business");
          if (Util.isNullOrNil(this.eZc.Zq().fac)) {
            break label3078;
          }
          ((KeyValuePreference)localObject1).aF(this.eZc.Zq().fac);
          ((KeyValuePreference)localObject1).WrP = 4;
          ((KeyValuePreference)localObject1).FU(false);
          label1896:
          if ((!ab.Q(this.contact)) || (this.contact.hDm == null) || (this.contact.hDm.equals(""))) {
            break label3140;
          }
          localObject1 = (KeyValuePreference)this.screen.byG("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).aF(Util.nullAs(this.contact.field_weiboNickname, "") + getString(R.l.settings_show_weibo_field, new Object[] { ab.Re(this.contact.hDm) }));
            ((Preference)localObject1).tHk = com.tencent.mm.ci.a.w(this, R.e.link_color);
            ((KeyValuePreference)localObject1).FU(false);
          }
          label2030:
          if ((this.eZc == null) || (!this.eZc.Zh())) {
            break label3157;
          }
          this.screen.byG("near_field_service").auI(R.l.eVR);
          if (fqX() == null) {
            break label3174;
          }
          this.screen.dz("contact_info_see_locate", false);
        }
        for (;;)
        {
          k = this.screen.bf("contact_info_category2");
          if ((k < 0) || (this.eZb == null) || (this.eZb.size() <= 0)) {
            break label3198;
          }
          i = this.eZb.size() - 1;
          while (i >= 0)
          {
            if ((this.eZb.get(i) != null) && ((!getString(R.l.eyh).equals(((c.a)this.eZb.get(i)).title)) || (this.eZj)) && ((!Util.isNullOrNil(((c.a)this.eZb.get(i)).title)) || (!Util.isNullOrNil(((c.a)this.eZb.get(i)).eZf))) && (!((c.a)this.eZb.get(i)).eZf.equals("__mp_wording__brandinfo_location")) && (!getString(R.l.eyj).equals(((c.a)this.eZb.get(i)).title)) && (!((c.a)this.eZb.get(i)).eZf.equals("__mp_wording__brandinfo_history_massmsg")))
            {
              localObject5 = new Preference(this);
              ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
              localObject1 = ((c.a)this.eZb.get(i)).title;
              j = getResources().getIdentifier(((c.a)this.eZb.get(i)).eZf, "string", getPackageName());
              if (j > 0) {
                localObject1 = getString(j);
              }
              localObject2 = localObject1;
              if (this.GXj.YW()) {
                if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.eZb.get(i)).eZf))
                {
                  localObject2 = localObject1;
                  if (!((String)localObject1).equals(getString(R.l.emq))) {}
                }
                else
                {
                  localObject2 = getString(R.l.eCj);
                }
              }
              ((Preference)localObject5).setTitle((CharSequence)localObject2);
              if (!Util.isNullOrNil(((c.a)this.eZb.get(i)).description)) {
                ((Preference)localObject5).aF(((c.a)this.eZb.get(i)).description);
              }
              if (!Util.nullAsNil(((c.a)this.eZb.get(i)).eZf).equals("__mp_wording__brandinfo_feedback")) {
                break label3218;
              }
              j = this.screen.bf("contact_info_scope_of_business");
              if (j <= 0) {
                break label3218;
              }
              j += 1;
              this.screen.a((Preference)localObject5, j);
              if (Util.nullAsNil(((c.a)this.eZb.get(i)).eZf).equals("__mp_wording__brandinfo_biz_detail"))
              {
                localObject1 = new PreferenceSmallCategory(this);
                this.screen.a((Preference)localObject1, j);
              }
            }
            i -= 1;
          }
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject1 = af.bju().UJ(this.contact.field_username);
            if (localObject1 == null)
            {
              this.screen.dz("contact_info_kf_worker", true);
              af.bjw().a(this);
              af.bjw().bj(this.contact.field_username, z.bcZ());
              this.GZb = true;
              break;
            }
            Log.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", new Object[] { ((com.tencent.mm.ao.h)localObject1).field_openId });
            this.screen.dz("contact_info_kf_worker", false);
            localObject2 = (IconWidgetPreference)this.screen.byG("contact_info_kf_worker");
            ((IconWidgetPreference)localObject2).aF(((com.tencent.mm.ao.h)localObject1).field_nickname);
            localObject5 = com.tencent.mm.am.d.a(((com.tencent.mm.ao.h)localObject1).field_openId, false, -1, null);
            if (localObject5 == null)
            {
              c((com.tencent.mm.ao.h)localObject1);
              aUQ(((com.tencent.mm.ao.h)localObject1).field_openId);
              break;
            }
            ((IconWidgetPreference)localObject2).ai((Bitmap)localObject5);
            break;
          }
          Object localObject5 = af.bju();
          localObject1 = ((com.tencent.mm.ao.j)localObject5).UI((String)localObject2);
          if ((localObject1 == null) || (com.tencent.mm.ao.j.a((com.tencent.mm.ao.h)localObject1)))
          {
            af.bjw().a(this);
            af.bjw().j(this.contact.field_username, (String)localObject2, 1);
            this.GZb = true;
          }
          if (localObject1 != null) {
            break label3223;
          }
          Log.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
          localObject1 = ((com.tencent.mm.ao.j)localObject5).UJ(this.contact.field_username);
          if (localObject1 == null)
          {
            this.screen.dz("contact_info_kf_worker", true);
            break;
          }
          this.screen.dz("contact_info_kf_worker", false);
          localObject2 = (IconWidgetPreference)this.screen.byG("contact_info_kf_worker");
          ((IconWidgetPreference)localObject2).aF(((com.tencent.mm.ao.h)localObject1).field_nickname);
          localObject5 = com.tencent.mm.am.d.a(((com.tencent.mm.ao.h)localObject1).field_openId, false, -1, null);
          if (localObject5 == null)
          {
            c((com.tencent.mm.ao.h)localObject1);
            aUQ(((com.tencent.mm.ao.h)localObject1).field_openId);
          }
          for (;;)
          {
            Log.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", new Object[] { ((com.tencent.mm.ao.h)localObject1).field_openId, ((com.tencent.mm.ao.h)localObject1).field_nickname });
            break;
            ((IconWidgetPreference)localObject2).ai((Bitmap)localObject5);
          }
          label3027:
          this.screen.dz("contact_info_service_phone", true);
          break label1711;
          label3044:
          this.screen.dz("contact_info_reputation", true);
          break label1773;
          this.screen.dz("contact_info_guarantee_info", true);
          break label1836;
          this.screen.dz("contact_info_scope_of_business", true);
          break label1896;
          this.screen.dz("contact_info_reputation", true);
          this.screen.dz("contact_info_guarantee_info", true);
          this.screen.dz("contact_info_scope_of_business", true);
          break label1896;
          label3140:
          this.screen.dz("contact_info_verifyuser_weibo", true);
          break label2030;
          label3157:
          this.screen.dz("near_field_service", true);
          break label2065;
          label3174:
          this.screen.dz("contact_info_see_locate", true);
        }
        AppMethodBeat.o(27550);
        return;
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
        AppMethodBeat.o(27550);
        return;
        localObject1 = localIndexOutOfBoundsException1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27549);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setActionbarColor(getContext().getResources().getColor(R.e.normal_actionbar_color));
    setMMTitle(R.l.exZ);
    setTitleDividerVis(false);
    hideActionbarLine();
    setBackBtn(new NewBizInfoMoreInofUI.1(this));
    paramBundle = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    String str1 = Util.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    int i = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
    int j = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
    String str2 = getIntent().getStringExtra("Contact_KWeibo");
    String str3 = getIntent().getStringExtra("Contact_KWeiboNick");
    bh.beI();
    this.contact = com.tencent.mm.model.c.bbL().RG(paramBundle);
    if ((this.contact == null) || ((int)this.contact.jxt == 0) || (Util.nullAsNil(this.contact.field_username).length() <= 0))
    {
      this.contact = new as();
      this.contact.setUsername(paramBundle);
      this.contact.Iq(str1);
      this.contact.ps(i);
      this.contact.IN(str2);
      this.contact.pr(j);
      this.contact.Iv(str3);
    }
    for (;;)
    {
      this.GXj = g.gu(this.contact.field_username);
      paramBundle = getIntent().getByteArrayExtra("Contact_customInfo");
      if (paramBundle == null) {
        paramBundle = null;
      }
      try
      {
        for (;;)
        {
          this.GYV = paramBundle;
          this.mXL = getIntent().getIntExtra("Contact_Scene", 9);
          this.GZe = getIntent().getBundleExtra("Contact_Ext_Args");
          initView();
          AppMethodBeat.o(27549);
          return;
          if (i == 0) {
            break;
          }
          this.contact.ps(i);
          break;
          paramBundle = (aez)new aez().parseFrom(paramBundle);
        }
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NewBizInfoMoreInofUI", paramBundle, "", new Object[0]);
        }
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int i = 6;
    AppMethodBeat.i(27555);
    paramPreference = paramPreference.mKey;
    Log.i("MicroMsg.NewBizInfoMoreInofUI", paramPreference + " item has been clicked!");
    Object localObject;
    int j;
    if ("contact_info_see_locate".endsWith(paramPreference))
    {
      paramf = fqX();
      if (paramf == null)
      {
        Log.e("MicroMsg.NewBizInfoMoreInofUI", "[onPreferenceTreeClick] info is null, err");
        AppMethodBeat.o(27555);
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
      if (((this.GZe != null) && ((this.mXL == 39) || (this.mXL == 56) || (this.mXL == 35))) || (this.mXL == 87) || (this.mXL == 89) || (this.mXL == 85) || (this.mXL == 88))
      {
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("KFromBizSearch", true);
        ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.GZe);
        paramPreference.putExtra("jsapiargs", (Bundle)localObject);
        if (!com.tencent.mm.contact.d.rk(this.contact.field_type)) {
          break label343;
        }
      }
      label343:
      for (i = 7;; i = 6)
      {
        j = getResources().getIdentifier(paramf.eZf, "string", getPackageName());
        paramf = paramf.title;
        if (j > 0) {
          paramf = getString(j);
        }
        bN(i, paramf);
        com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(27555);
        return true;
      }
    }
    if ("contact_info_verifyuser".endsWith(paramPreference))
    {
      paramf = this.GXj;
      if (paramf == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      localObject = paramf.dc(false);
      if (localObject == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      paramPreference = null;
      if ((((c.b)localObject).Zs() != null) && (!Util.isNullOrNil(((c.b)localObject).Zs().eZZ))) {
        paramf = ((c.b)localObject).Zs().eZZ;
      }
      for (;;)
      {
        if (!Util.isNullOrNil(paramf))
        {
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("useJs", true);
          paramPreference.putExtra("vertical_scroll", true);
          paramPreference.putExtra("geta8key_scene", 3);
          com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 1200, this.mXL, 0L);
        AppMethodBeat.o(27555);
        return true;
        paramf = paramPreference;
        if (((c.b)localObject).Zt() != null)
        {
          paramf = paramPreference;
          if (!Util.isNullOrNil(((c.b)localObject).Zt().fah)) {
            paramf = ((c.b)localObject).Zt().fah;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramPreference))
    {
      paramf = this.GXj;
      if (paramf == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      if ((paramf.dc(false) != null) && (!Util.isNullOrNil(paramf.dc(false).Zl())))
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf.dc(false).Zl());
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
      }
      AppMethodBeat.o(27555);
      return true;
    }
    if ("contact_info_service_phone".equals(paramPreference))
    {
      paramf = paramf.byG("contact_info_service_phone");
      if ((paramf != null) && (paramf.fqw() != null) && (!Util.isNullOrNil(paramf.fqw().toString())))
      {
        paramf = paramf.fqw().toString();
        com.tencent.mm.ui.base.h.a(this, true, paramf, "", getString(R.l.contact_info_dial), getString(R.l.app_cancel), new NewBizInfoMoreInofUI.4(this, paramf), null);
      }
    }
    if (paramPreference.startsWith("contact_info_bizinfo_external#"))
    {
      j = Util.getInt(paramPreference.replace("contact_info_bizinfo_external#", ""), -1);
      if ((j >= 0) && (j < this.eZb.size()))
      {
        paramf = (c.a)this.eZb.get(j);
        localObject = paramf.url;
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", (String)localObject);
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        paramPreference.putExtra("KPublisherId", "brand_profile");
        paramPreference.putExtra("prePublishId", "brand_profile");
        if (((this.GZe != null) && ((this.mXL == 39) || (this.mXL == 56) || (this.mXL == 35))) || (this.mXL == 87) || (this.mXL == 89) || (this.mXL == 85) || (this.mXL == 88))
        {
          Log.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.GZe);
          paramPreference.putExtra("jsapiargs", (Bundle)localObject);
          if (com.tencent.mm.contact.d.rk(this.contact.field_type)) {
            i = 7;
          }
          j = getResources().getIdentifier(paramf.eZf, "string", getPackageName());
          paramf = paramf.title;
          if (j > 0) {
            paramf = getString(j);
          }
          bN(i, paramf);
        }
        com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(27555);
        return true;
      }
    }
    if (paramPreference.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this).jI(this.contact.hDm, this.contact.field_username);
      AppMethodBeat.o(27555);
      return true;
    }
    if (("contact_info_guarantee_info".equals(paramPreference)) && (this.eZc.Zq() != null) && (!Util.isNullOrNil(this.eZc.Zq().fae)))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", this.eZc.Zq().fae);
      paramf.putExtra("useJs", true);
      paramf.putExtra("vertical_scroll", true);
      paramf.putExtra("geta8key_scene", 3);
      com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    if ((!"contact_info_expose_btn".equals(paramPreference)) || (this.contact == null) || (Util.isNullOrNil(this.contact.field_username))) {}
    for (;;)
    {
      AppMethodBeat.o(27555);
      return false;
      paramf = new Intent();
      paramf.putExtra("rawUrl", String.format(GZd, new Object[] { this.contact.field_username }));
      paramf.putExtra("showShare", false);
      com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
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