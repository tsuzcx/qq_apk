package com.tencent.mm.plugin.profile.ui.newbizinfo;

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
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.an.i;
import com.tencent.mm.an.i.b;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.e;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.gjj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
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
  private static final String MXg;
  private com.tencent.mm.api.c MVg;
  private ahl MWY;
  private String MXd;
  private boolean MXe;
  private Bundle MXh;
  private au contact;
  private List<c.a> hcB;
  private c.b hcC;
  private boolean hcJ = false;
  private int pUt;
  private f screen;
  
  static
  {
    AppMethodBeat.i(305722);
    MXg = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/infringement?username=%s&from=1#wechat_redirect";
    AppMethodBeat.o(305722);
  }
  
  private void aRY(final String paramString)
  {
    AppMethodBeat.i(27553);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27547);
        if (NewBizInfoMoreInofUI.a(NewBizInfoMoreInofUI.this) == null)
        {
          Log.w("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar screen is null");
          AppMethodBeat.o(27547);
          return;
        }
        IconWidgetPreference localIconWidgetPreference = (IconWidgetPreference)NewBizInfoMoreInofUI.a(NewBizInfoMoreInofUI.this).bAi("contact_info_kf_worker");
        if ((localIconWidgetPreference != null) && (NewBizInfoMoreInofUI.a(NewBizInfoMoreInofUI.this) != null))
        {
          Bitmap localBitmap = com.tencent.mm.modelavatar.d.a(paramString, false, -1, null);
          if (localBitmap != null)
          {
            Log.d("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar success %s, update screen", new Object[] { paramString });
            localIconWidgetPreference.av(localBitmap);
            NewBizInfoMoreInofUI.a(NewBizInfoMoreInofUI.this).notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(27547);
      }
    }, 2000L);
    AppMethodBeat.o(27553);
  }
  
  private static void c(com.tencent.mm.an.h paramh)
  {
    AppMethodBeat.i(27552);
    long l = System.currentTimeMillis();
    com.tencent.mm.modelavatar.k localk = q.bFE();
    if (localk.LS(paramh.field_openId) == null)
    {
      com.tencent.mm.modelavatar.j localj = new com.tencent.mm.modelavatar.j();
      localj.username = paramh.field_openId;
      localj.osM = paramh.field_headImgUrl;
      localj.gX(false);
      localj.jZY = 3;
      localk.b(localj);
    }
    q.bFG().LC(paramh.field_openId);
    Log.d("MicroMsg.NewBizInfoMoreInofUI", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27552);
  }
  
  private void cv(int paramInt, String paramString)
  {
    AppMethodBeat.i(27556);
    if ((this.MXh == null) || ((this.pUt != 39) && (this.pUt != 56) && (this.pUt != 35) && (this.pUt != 87) && (this.pUt != 88) && (this.pUt != 89) && (this.pUt != 85)))
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
    String str2 = this.MXh.getString("Contact_Ext_Args_Search_Id");
    String str3 = Util.nullAsNil(this.MXh.getString("Contact_Ext_Args_Query_String"));
    int j = this.MXh.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.pUt)
    {
    default: 
      i = 0;
      str1 = Util.nullAsNil(this.MXh.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + Util.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (Util.isNullOrNil(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      Log.v("MicroMsg.NewBizInfoMoreInofUI", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(10866, paramString);
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
  
  private c.a gCq()
  {
    AppMethodBeat.i(27551);
    if ((this.hcB == null) || (this.hcB.size() < 0))
    {
      Log.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
      AppMethodBeat.o(27551);
      return null;
    }
    Iterator localIterator = this.hcB.iterator();
    while (localIterator.hasNext())
    {
      c.a locala = (c.a)localIterator.next();
      if ((locala.hcF.equals("__mp_wording__brandinfo_location")) || (getString(R.l.gBb).equals(locala.title)))
      {
        AppMethodBeat.o(27551);
        return locala;
      }
    }
    Log.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
    AppMethodBeat.o(27551);
    return null;
  }
  
  public final String bGT()
  {
    return "MicroMsg.NewBizInfoMoreInofUI";
  }
  
  public final void e(LinkedList<gjj> paramLinkedList)
  {
    AppMethodBeat.i(27554);
    af.bHg().b(this);
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
    if (!Util.isNullOrNil(this.MXd))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        gjj localgjj = (gjj)localIterator.next();
        if ((localgjj.acfC != null) && (localgjj.acfC.equals(this.MXd)))
        {
          this.screen.eh("contact_info_kf_worker", false);
          this.screen.bAi("contact_info_kf_worker").aS(localgjj.Nickname);
          AppMethodBeat.o(27554);
          return;
        }
      }
    }
    this.screen.eh("contact_info_kf_worker", false);
    this.screen.bAi("contact_info_kf_worker").aS(((gjj)paramLinkedList.get(0)).Nickname);
    AppMethodBeat.o(27554);
  }
  
  public int getResourceId()
  {
    return R.o.hbk;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27550);
    this.screen.eh("biz_placed_to_the_top", true);
    Object localObject2 = g.hU(this.contact.field_username);
    this.hcB = null;
    this.hcC = null;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((com.tencent.mm.api.c)localObject2).dO(false) != null) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.MWY != null)
      {
        localObject1 = new com.tencent.mm.api.c();
        ((com.tencent.mm.api.c)localObject1).field_username = this.contact.field_username;
        ((com.tencent.mm.api.c)localObject1).field_brandFlag = this.MWY.pSt;
        ((com.tencent.mm.api.c)localObject1).field_brandIconURL = this.MWY.pSw;
        ((com.tencent.mm.api.c)localObject1).field_brandInfo = this.MWY.pSv;
        ((com.tencent.mm.api.c)localObject1).field_extInfo = this.MWY.pSu;
        ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).dO(false).getServiceType();
      }
    }
    if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_brandInfo == null) && (((com.tencent.mm.api.c)localObject1).field_extInfo == null) && (this.MWY != null))
    {
      ((com.tencent.mm.api.c)localObject1).field_username = this.contact.field_username;
      ((com.tencent.mm.api.c)localObject1).field_brandFlag = this.MWY.pSt;
      ((com.tencent.mm.api.c)localObject1).field_brandIconURL = this.MWY.pSw;
      ((com.tencent.mm.api.c)localObject1).field_brandInfo = this.MWY.pSv;
      ((com.tencent.mm.api.c)localObject1).field_extInfo = this.MWY.pSu;
      ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).dO(false).getServiceType();
    }
    if (localObject1 != null)
    {
      this.MVg = ((com.tencent.mm.api.c)localObject1);
      this.hcB = ((com.tencent.mm.api.c)localObject1).aAY();
      this.hcC = ((com.tencent.mm.api.c)localObject1).dO(false);
      this.hcJ = this.hcC.aBa();
    }
    boolean bool;
    label385:
    label400:
    Object localObject4;
    Object localObject6;
    int i;
    if (com.tencent.mm.contact.d.rs(this.contact.field_type)) {
      if (this.MVg == null)
      {
        bool = true;
        if (!bool) {
          break label1244;
        }
        localObject1 = (KeyValuePreference)this.screen.bAi("contact_info_wechat_account");
        if (Util.isNullOrNil(this.contact.aJs())) {
          break label1125;
        }
        this.screen.eh("contact_info_wechat_account", false);
        ((KeyValuePreference)localObject1).aS(p.b(this, this.contact.aJs()));
        ((Preference)localObject1).adZP = new Preference.c()
        {
          public final boolean gCr()
          {
            AppMethodBeat.i(27546);
            ClipboardHelper.setText(this.NbS.gBR());
            com.tencent.mm.ui.base.k.cZ(NewBizInfoMoreInofUI.this.getContext(), NewBizInfoMoreInofUI.this.getContext().getString(R.l.app_copy_ok));
            AppMethodBeat.o(27546);
            return true;
          }
        };
        if ((this.hcC == null) || (this.hcC.aBk() == null) || (Util.isNullOrNil(this.hcC.aBk().hdy))) {
          break label1392;
        }
        localObject4 = this.hcC.aBk();
        localObject6 = (KeyValuePreference)this.screen.bAi("contact_info_verifyuser");
        if (localObject6 == null) {
          break label1375;
        }
        ((KeyValuePreference)localObject6).jnr();
        ((KeyValuePreference)localObject6).adZa = false;
        if (!Util.isNullOrNil(((c.b.e)localObject4).hdz)) {
          break label1306;
        }
        i = ((c.b.e)localObject4).hdx;
        switch (i)
        {
        default: 
          Log.w("MicroMsg.NewBizInfoMoreInofUI", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(i) });
          localObject1 = getResources().getString(R.l.gBu);
          label551:
          ((KeyValuePreference)localObject6).JAf = ((String)localObject1);
          label558:
          if (az.a.okR != null)
          {
            localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.okR.vd(this.contact.field_verifyFlag), 2.0F);
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
        ((KeyValuePreference)localObject6).adZh = ((Drawable)localObject2);
        if (((c.b.e)localObject4).hdy == null) {
          break label1364;
        }
        str = ((c.b.e)localObject4).hdB;
        localObject2 = p.b(this, ((c.b.e)localObject4).hdy.trim());
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
          ((KeyValuePreference)localObject6).aS((CharSequence)localObject1);
          if ((this.hcC == null) || (Util.isNullOrNil(this.hcC.aBe()))) {
            break label1502;
          }
          localObject2 = (KeyValuePreference)this.screen.bAi("contact_info_trademark");
          if (localObject2 == null) {
            continue;
          }
          ((KeyValuePreference)localObject2).jnr();
          ((KeyValuePreference)localObject2).adZa = false;
          if (az.a.okR == null) {
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
        ((KeyValuePreference)localObject2).adZh = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).aS(this.hcC.aBe());
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "trademark name : %s, url : %s.", new Object[] { this.hcC.aBe(), this.hcC.aBd() });
        if ((this.hcC != null) && (this.hcC.aBg() != null) && (this.hcC.aBg().size() > 0))
        {
          localObject1 = (KeyValuePreference)this.screen.bAi("contact_info_privilege");
          ((KeyValuePreference)localObject1).jnr();
          ((KeyValuePreference)localObject1).LG(false);
          ((KeyValuePreference)localObject1).jnq();
          localObject2 = this.hcC.aBg().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label1541;
          }
          localObject4 = (c.b.g)((Iterator)localObject2).next();
          localObject6 = (LinearLayout)View.inflate(this, R.i.keyvalue_pref_item, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(R.h.image_iv)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.c.c(getResources(), ((c.b.g)localObject4).iconUrl));
          str = ((c.b.g)localObject4).description;
          getResources().getIdentifier(((c.b.g)localObject4).hdG, "string", getPackageName());
          ((TextView)((LinearLayout)localObject6).findViewById(R.h.summary)).setText(str);
          ((KeyValuePreference)localObject1).lh((View)localObject6);
          continue;
          bool = this.MVg.aAV();
          break;
          if ((!au.bxb(this.contact.field_username)) && (!au.bxa(this.contact.field_username)))
          {
            this.screen.eh("contact_info_wechat_account", false);
            localObject2 = Util.nullAsNil(this.contact.aSW());
            ((KeyValuePreference)localObject1).aS(com.tencent.mm.plugin.profile.c.bG(getContext(), this.contact.field_username) + com.tencent.mm.plugin.profile.c.la(this.contact.field_username, (String)localObject2));
            break label385;
          }
          this.screen.eh("contact_info_wechat_account", true);
          break label385;
          this.screen.eh("contact_info_wechat_account", true);
          break label400;
          localObject1 = getResources().getString(R.l.contact_info_verify_user_title);
          break label551;
          localObject1 = getResources().getString(R.l.gAX);
          break label551;
          localObject1 = getResources().getString(R.l.gAY);
          break label551;
          ((KeyValuePreference)localObject6).JAf = ((c.b.e)localObject4).hdz;
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
          this.screen.eh("contact_info_verifyuser", true);
          continue;
          if ((this.hcC != null) && (this.hcC.aBl() != null) && (!Util.isNullOrNil(this.hcC.aBl().hdH)))
          {
            localObject1 = (KeyValuePreference)this.screen.bAi("contact_info_verifyuser");
            if (localObject1 == null) {
              continue;
            }
            ((KeyValuePreference)localObject1).aS(this.hcC.aBl().hdH);
            continue;
          }
          Log.w("MicroMsg.NewBizInfoMoreInofUI", "has not verify info");
          this.screen.eh("contact_info_verifyuser", true);
          continue;
          label1490:
          localObject1 = null;
          continue;
          label1496:
          bool = false;
          continue;
          label1502:
          Log.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
          this.screen.eh("contact_info_trademark", true);
          continue;
        }
        this.screen.eh("contact_info_privilege", true);
        localObject2 = getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", new Object[] { localObject2, Boolean.valueOf(this.MXe) });
        if (!this.MXe)
        {
          this.MXd = ((String)localObject2);
          if ((this.hcC == null) || (!this.hcC.aBq()) || (this.contact == null)) {
            this.screen.eh("contact_info_kf_worker", true);
          }
        }
        else
        {
          if ((this.hcC == null) || (Util.isNullOrNil(this.hcC.aBp()))) {
            break label3027;
          }
          this.screen.eh("contact_info_service_phone", false);
          localObject1 = this.screen.bAi("contact_info_service_phone");
          if (localObject1 != null)
          {
            ((Preference)localObject1).aS(this.hcC.aBp());
            ((Preference)localObject1).wKL = getResources().getColor(R.e.link_color);
          }
          label1711:
          if ((this.hcC == null) || (this.hcC.aBi() == null)) {
            break label3095;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.bAi("contact_info_reputation");
          if (this.hcC.aBi().hdC <= 0) {
            break label3044;
          }
          ((BizInfoPayInfoIconPreference)localObject1).afF(this.hcC.aBi().hdC);
          label1773:
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.bAi("contact_info_guarantee_info");
          if ((this.hcC.aBi().hdE == null) || (this.hcC.aBi().hdE.size() <= 0)) {
            break label3061;
          }
          ((BizInfoPayInfoIconPreference)localObject1).jv(this.hcC.aBi().hdE);
          label1836:
          localObject1 = (KeyValuePreference)this.screen.bAi("contact_info_scope_of_business");
          if (Util.isNullOrNil(this.hcC.aBi().hdD)) {
            break label3078;
          }
          ((KeyValuePreference)localObject1).aS(this.hcC.aBi().hdD);
          ((KeyValuePreference)localObject1).adZf = 4;
          ((KeyValuePreference)localObject1).LG(false);
          label1896:
          if ((!ab.R(this.contact)) || (this.contact.kai == null) || (this.contact.kai.equals(""))) {
            break label3140;
          }
          localObject1 = (KeyValuePreference)this.screen.bAi("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).aS(Util.nullAs(this.contact.field_weiboNickname, "") + getString(R.l.settings_show_weibo_field, new Object[] { ab.Jc(this.contact.kai) }));
            ((Preference)localObject1).wKL = com.tencent.mm.cd.a.w(this, R.e.link_color);
            ((KeyValuePreference)localObject1).LG(false);
          }
          label2030:
          if ((this.hcC == null) || (!this.hcC.aAZ())) {
            break label3157;
          }
          this.screen.bAi("near_field_service").aBk(R.l.weixin_connect_wifi);
          if (gCq() == null) {
            break label3174;
          }
          this.screen.eh("contact_info_see_locate", false);
        }
        for (;;)
        {
          k = this.screen.cs("contact_info_category2");
          if ((k < 0) || (this.hcB == null) || (this.hcB.size() <= 0)) {
            break label3198;
          }
          i = this.hcB.size() - 1;
          while (i >= 0)
          {
            if ((this.hcB.get(i) != null) && ((!getString(R.l.gAZ).equals(((c.a)this.hcB.get(i)).title)) || (this.hcJ)) && ((!Util.isNullOrNil(((c.a)this.hcB.get(i)).title)) || (!Util.isNullOrNil(((c.a)this.hcB.get(i)).hcF))) && (!((c.a)this.hcB.get(i)).hcF.equals("__mp_wording__brandinfo_location")) && (!getString(R.l.gBb).equals(((c.a)this.hcB.get(i)).title)) && (!((c.a)this.hcB.get(i)).hcF.equals("__mp_wording__brandinfo_history_massmsg")))
            {
              localObject5 = new Preference(this);
              ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
              localObject1 = ((c.a)this.hcB.get(i)).title;
              j = getResources().getIdentifier(((c.a)this.hcB.get(i)).hcF, "string", getPackageName());
              if (j > 0) {
                localObject1 = getString(j);
              }
              localObject2 = localObject1;
              if (this.MVg.aAO()) {
                if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.hcB.get(i)).hcF))
                {
                  localObject2 = localObject1;
                  if (!((String)localObject1).equals(getString(R.l.gpt))) {}
                }
                else
                {
                  localObject2 = getString(R.l.enterprise_brand_history);
                }
              }
              ((Preference)localObject5).setTitle((CharSequence)localObject2);
              if (!Util.isNullOrNil(((c.a)this.hcB.get(i)).description)) {
                ((Preference)localObject5).aS(((c.a)this.hcB.get(i)).description);
              }
              if (!Util.nullAsNil(((c.a)this.hcB.get(i)).hcF).equals("__mp_wording__brandinfo_feedback")) {
                break label3218;
              }
              j = this.screen.cs("contact_info_scope_of_business");
              if (j <= 0) {
                break label3218;
              }
              j += 1;
              this.screen.a((Preference)localObject5, j);
              if (Util.nullAsNil(((c.a)this.hcB.get(i)).hcF).equals("__mp_wording__brandinfo_biz_detail"))
              {
                localObject1 = new PreferenceSmallCategory(this);
                this.screen.a((Preference)localObject1, j);
              }
            }
            i -= 1;
          }
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject1 = af.bHe().MI(this.contact.field_username);
            if (localObject1 == null)
            {
              this.screen.eh("contact_info_kf_worker", true);
              af.bHg().a(this);
              af.bHg().bu(this.contact.field_username, z.bAM());
              this.MXe = true;
              break;
            }
            Log.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", new Object[] { ((com.tencent.mm.an.h)localObject1).field_openId });
            this.screen.eh("contact_info_kf_worker", false);
            localObject2 = (IconWidgetPreference)this.screen.bAi("contact_info_kf_worker");
            ((IconWidgetPreference)localObject2).aS(((com.tencent.mm.an.h)localObject1).field_nickname);
            localObject5 = com.tencent.mm.modelavatar.d.a(((com.tencent.mm.an.h)localObject1).field_openId, false, -1, null);
            if (localObject5 == null)
            {
              c((com.tencent.mm.an.h)localObject1);
              aRY(((com.tencent.mm.an.h)localObject1).field_openId);
              break;
            }
            ((IconWidgetPreference)localObject2).av((Bitmap)localObject5);
            break;
          }
          Object localObject5 = af.bHe();
          localObject1 = ((com.tencent.mm.an.j)localObject5).MH((String)localObject2);
          if ((localObject1 == null) || (com.tencent.mm.an.j.a((com.tencent.mm.an.h)localObject1)))
          {
            af.bHg().a(this);
            af.bHg().m(this.contact.field_username, (String)localObject2, 1);
            this.MXe = true;
          }
          if (localObject1 != null) {
            break label3223;
          }
          Log.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
          localObject1 = ((com.tencent.mm.an.j)localObject5).MI(this.contact.field_username);
          if (localObject1 == null)
          {
            this.screen.eh("contact_info_kf_worker", true);
            break;
          }
          this.screen.eh("contact_info_kf_worker", false);
          localObject2 = (IconWidgetPreference)this.screen.bAi("contact_info_kf_worker");
          ((IconWidgetPreference)localObject2).aS(((com.tencent.mm.an.h)localObject1).field_nickname);
          localObject5 = com.tencent.mm.modelavatar.d.a(((com.tencent.mm.an.h)localObject1).field_openId, false, -1, null);
          if (localObject5 == null)
          {
            c((com.tencent.mm.an.h)localObject1);
            aRY(((com.tencent.mm.an.h)localObject1).field_openId);
          }
          for (;;)
          {
            Log.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", new Object[] { ((com.tencent.mm.an.h)localObject1).field_openId, ((com.tencent.mm.an.h)localObject1).field_nickname });
            break;
            ((IconWidgetPreference)localObject2).av((Bitmap)localObject5);
          }
          label3027:
          this.screen.eh("contact_info_service_phone", true);
          break label1711;
          label3044:
          this.screen.eh("contact_info_reputation", true);
          break label1773;
          this.screen.eh("contact_info_guarantee_info", true);
          break label1836;
          this.screen.eh("contact_info_scope_of_business", true);
          break label1896;
          this.screen.eh("contact_info_reputation", true);
          this.screen.eh("contact_info_guarantee_info", true);
          this.screen.eh("contact_info_scope_of_business", true);
          break label1896;
          label3140:
          this.screen.eh("contact_info_verifyuser_weibo", true);
          break label2030;
          label3157:
          this.screen.eh("near_field_service", true);
          break label2065;
          label3174:
          this.screen.eh("contact_info_see_locate", true);
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
    setMMTitle(R.l.gAT);
    setTitleDividerVis(false);
    hideActionbarLine();
    setBackBtn(new NewBizInfoMoreInofUI.1(this));
    paramBundle = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    String str1 = Util.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    int i = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
    int j = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
    String str2 = getIntent().getStringExtra("Contact_KWeibo");
    String str3 = getIntent().getStringExtra("Contact_KWeiboNick");
    bh.bCz();
    this.contact = com.tencent.mm.model.c.bzA().JE(paramBundle);
    if ((this.contact == null) || ((int)this.contact.maN == 0) || (Util.nullAsNil(this.contact.field_username).length() <= 0))
    {
      this.contact = new au();
      this.contact.setUsername(paramBundle);
      this.contact.AV(str1);
      this.contact.pr(i);
      this.contact.Bs(str2);
      this.contact.pq(j);
      this.contact.Ba(str3);
    }
    for (;;)
    {
      this.MVg = g.hU(this.contact.field_username);
      paramBundle = getIntent().getByteArrayExtra("Contact_customInfo");
      if (paramBundle == null) {
        paramBundle = null;
      }
      try
      {
        for (;;)
        {
          this.MWY = paramBundle;
          this.pUt = getIntent().getIntExtra("Contact_Scene", 9);
          this.MXh = getIntent().getBundleExtra("Contact_Ext_Args");
          initView();
          AppMethodBeat.o(27549);
          return;
          if (i == 0) {
            break;
          }
          this.contact.pr(i);
          break;
          paramBundle = (ahl)new ahl().parseFrom(paramBundle);
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
    AppMethodBeat.i(27555);
    paramPreference = paramPreference.mKey;
    Log.i("MicroMsg.NewBizInfoMoreInofUI", paramPreference + " item has been clicked!");
    Object localObject;
    int i;
    int j;
    if ("contact_info_see_locate".endsWith(paramPreference))
    {
      paramf = gCq();
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
      if (((this.MXh != null) && ((this.pUt == 39) || (this.pUt == 56) || (this.pUt == 35))) || (this.pUt == 87) || (this.pUt == 89) || (this.pUt == 85) || (this.pUt == 88))
      {
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("KFromBizSearch", true);
        ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.MXh);
        paramPreference.putExtra("jsapiargs", (Bundle)localObject);
        if (!com.tencent.mm.contact.d.rs(this.contact.field_type)) {
          break label340;
        }
      }
      label340:
      for (i = 7;; i = 6)
      {
        j = getResources().getIdentifier(paramf.hcF, "string", getPackageName());
        paramf = paramf.title;
        if (j > 0) {
          paramf = getString(j);
        }
        cv(i, paramf);
        com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(27555);
        return true;
      }
    }
    if ("contact_info_verifyuser".endsWith(paramPreference))
    {
      paramf = this.MVg;
      if (paramf == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      localObject = paramf.dO(false);
      if (localObject == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      paramPreference = null;
      if ((((c.b)localObject).aBk() != null) && (!Util.isNullOrNil(((c.b)localObject).aBk().hdA))) {
        paramf = ((c.b)localObject).aBk().hdA;
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
          com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(this.contact.field_username, 1200, this.pUt, 0L, getIntent());
        AppMethodBeat.o(27555);
        return true;
        paramf = paramPreference;
        if (((c.b)localObject).aBl() != null)
        {
          paramf = paramPreference;
          if (!Util.isNullOrNil(((c.b)localObject).aBl().hdI)) {
            paramf = ((c.b)localObject).aBl().hdI;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramPreference))
    {
      paramf = this.MVg;
      if (paramf == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      if ((paramf.dO(false) != null) && (!Util.isNullOrNil(paramf.dO(false).aBd())))
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf.dO(false).aBd());
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
      }
      AppMethodBeat.o(27555);
      return true;
    }
    if ("contact_info_service_phone".equals(paramPreference))
    {
      paramf = paramf.bAi("contact_info_service_phone");
      if ((paramf != null) && (paramf.gBR() != null) && (!Util.isNullOrNil(paramf.gBR().toString())))
      {
        paramf = paramf.gBR().toString();
        com.tencent.mm.ui.base.k.a(this, true, paramf, "", getString(R.l.contact_info_dial), getString(R.l.app_cancel), new NewBizInfoMoreInofUI.4(this, paramf), null);
      }
    }
    if (paramPreference.startsWith("contact_info_bizinfo_external#"))
    {
      i = Util.getInt(paramPreference.replace("contact_info_bizinfo_external#", ""), -1);
      if ((i >= 0) && (i < this.hcB.size()))
      {
        paramf = (c.a)this.hcB.get(i);
        localObject = paramf.url;
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", (String)localObject);
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        paramPreference.putExtra("KPublisherId", "brand_profile");
        paramPreference.putExtra("prePublishId", "brand_profile");
        if (((this.MXh != null) && ((this.pUt == 39) || (this.pUt == 56) || (this.pUt == 35))) || (this.pUt == 87) || (this.pUt == 89) || (this.pUt == 85) || (this.pUt == 88))
        {
          Log.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.MXh);
          paramPreference.putExtra("jsapiargs", (Bundle)localObject);
          if (!com.tencent.mm.contact.d.rs(this.contact.field_type)) {
            break label1090;
          }
        }
        label1090:
        for (i = 7;; i = 6)
        {
          j = getResources().getIdentifier(paramf.hcF, "string", getPackageName());
          paramf = paramf.title;
          if (j > 0) {
            paramf = getString(j);
          }
          cv(i, paramf);
          com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
          AppMethodBeat.o(27555);
          return true;
        }
      }
    }
    if (paramPreference.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.b.a(this).ld(this.contact.kai, this.contact.field_username);
      AppMethodBeat.o(27555);
      return true;
    }
    if (("contact_info_guarantee_info".equals(paramPreference)) && (this.hcC.aBi() != null) && (!Util.isNullOrNil(this.hcC.aBi().hdF)))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", this.hcC.aBi().hdF);
      paramf.putExtra("useJs", true);
      paramf.putExtra("vertical_scroll", true);
      paramf.putExtra("geta8key_scene", 3);
      com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    if ((!"contact_info_expose_btn".equals(paramPreference)) || (this.contact == null) || (Util.isNullOrNil(this.contact.field_username))) {}
    for (;;)
    {
      AppMethodBeat.o(27555);
      return false;
      paramf = new Intent();
      paramf.putExtra("rawUrl", String.format(MXg, new Object[] { this.contact.field_username }));
      paramf.putExtra("showShare", false);
      com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
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