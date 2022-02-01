package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
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
import com.tencent.mm.aj.p;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.i.b;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.api.c.b.f;
import com.tencent.mm.api.c.b.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private List<c.a> cRa;
  private c.b cRb;
  private boolean cRi = false;
  private an contact;
  private int jij;
  private f screen;
  private com.tencent.mm.api.c xfE;
  private aco xhk;
  private String xhp;
  private boolean xhq;
  private Bundle xhs;
  
  private void avZ(final String paramString)
  {
    AppMethodBeat.i(27553);
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27547);
        if (NewBizInfoMoreInofUI.a(NewBizInfoMoreInofUI.this) == null)
        {
          ae.w("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar screen is null");
          AppMethodBeat.o(27547);
          return;
        }
        IconWidgetPreference localIconWidgetPreference = (IconWidgetPreference)NewBizInfoMoreInofUI.a(NewBizInfoMoreInofUI.this).aXe("contact_info_kf_worker");
        if ((localIconWidgetPreference != null) && (NewBizInfoMoreInofUI.a(NewBizInfoMoreInofUI.this) != null))
        {
          Bitmap localBitmap = com.tencent.mm.aj.c.a(paramString, false, -1, null);
          if (localBitmap != null)
          {
            ae.d("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar success %s, update screen", new Object[] { paramString });
            localIconWidgetPreference.aa(localBitmap);
            NewBizInfoMoreInofUI.a(NewBizInfoMoreInofUI.this).notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(27547);
      }
    }, 2000L);
    AppMethodBeat.o(27553);
  }
  
  private void bB(int paramInt, String paramString)
  {
    AppMethodBeat.i(27556);
    if ((this.xhs == null) || ((this.jij != 39) && (this.jij != 56) && (this.jij != 35) && (this.jij != 87) && (this.jij != 88) && (this.jij != 89) && (this.jij != 85)))
    {
      ae.d("MicroMsg.NewBizInfoMoreInofUI", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27556);
      return;
    }
    if (this.contact == null)
    {
      ae.i("MicroMsg.NewBizInfoMoreInofUI", "contact is null.");
      AppMethodBeat.o(27556);
      return;
    }
    String str2 = this.xhs.getString("Contact_Ext_Args_Search_Id");
    String str3 = bu.nullAsNil(this.xhs.getString("Contact_Ext_Args_Query_String"));
    int j = this.xhs.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.jij)
    {
    default: 
      i = 0;
      str1 = bu.nullAsNil(this.xhs.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bu.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bu.isNullOrNil(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      ae.v("MicroMsg.NewBizInfoMoreInofUI", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(10866, paramString);
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
  
  private static void c(com.tencent.mm.al.h paramh)
  {
    AppMethodBeat.i(27552);
    long l = System.currentTimeMillis();
    com.tencent.mm.aj.j localj = p.aEN();
    if (localj.DL(paramh.field_openId) == null)
    {
      com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
      locali.username = paramh.field_openId;
      locali.hPP = paramh.field_headImgUrl;
      locali.eD(false);
      locali.eQU = 3;
      localj.b(locali);
    }
    p.aEP().Dx(paramh.field_openId);
    ae.d("MicroMsg.NewBizInfoMoreInofUI", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27552);
  }
  
  private c.a dEK()
  {
    AppMethodBeat.i(27551);
    if ((this.cRa == null) || (this.cRa.size() < 0))
    {
      ae.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
      AppMethodBeat.o(27551);
      return null;
    }
    Iterator localIterator = this.cRa.iterator();
    while (localIterator.hasNext())
    {
      c.a locala = (c.a)localIterator.next();
      if ((locala.cRe.equals("__mp_wording__brandinfo_location")) || (getString(2131757621).equals(locala.title)))
      {
        AppMethodBeat.o(27551);
        return locala;
      }
    }
    ae.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
    AppMethodBeat.o(27551);
    return null;
  }
  
  public final String aGb()
  {
    return "MicroMsg.NewBizInfoMoreInofUI";
  }
  
  public final void e(LinkedList<ehf> paramLinkedList)
  {
    AppMethodBeat.i(27554);
    ag.aGq().b(this);
    if (this.screen == null)
    {
      ae.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, screen is null");
      AppMethodBeat.o(27554);
      return;
    }
    if (this.contact == null)
    {
      ae.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, contact is null");
      AppMethodBeat.o(27554);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ae.w("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, worker is null");
      AppMethodBeat.o(27554);
      return;
    }
    if (!bu.isNullOrNil(this.xhp))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        ehf localehf = (ehf)localIterator.next();
        if ((localehf.IkU != null) && (localehf.IkU.equals(this.xhp)))
        {
          this.screen.cT("contact_info_kf_worker", false);
          this.screen.aXe("contact_info_kf_worker").setSummary(localehf.Nickname);
          AppMethodBeat.o(27554);
          return;
        }
      }
    }
    this.screen.cT("contact_info_kf_worker", false);
    this.screen.aXe("contact_info_kf_worker").setSummary(((ehf)paramLinkedList.get(0)).Nickname);
    AppMethodBeat.o(27554);
  }
  
  public int getResourceId()
  {
    return 2131951697;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27550);
    this.screen.cT("biz_placed_to_the_top", true);
    Object localObject2 = com.tencent.mm.al.g.eX(this.contact.field_username);
    this.cRa = null;
    this.cRb = null;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((com.tencent.mm.api.c)localObject2).bX(false) != null) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.xhk != null)
      {
        localObject1 = new com.tencent.mm.api.c();
        ((com.tencent.mm.api.c)localObject1).field_username = this.contact.field_username;
        ((com.tencent.mm.api.c)localObject1).field_brandFlag = this.xhk.jgj;
        ((com.tencent.mm.api.c)localObject1).field_brandIconURL = this.xhk.jgm;
        ((com.tencent.mm.api.c)localObject1).field_brandInfo = this.xhk.jgl;
        ((com.tencent.mm.api.c)localObject1).field_extInfo = this.xhk.jgk;
        ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).bX(false).getServiceType();
      }
    }
    if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_brandInfo == null) && (((com.tencent.mm.api.c)localObject1).field_extInfo == null) && (this.xhk != null))
    {
      ((com.tencent.mm.api.c)localObject1).field_username = this.contact.field_username;
      ((com.tencent.mm.api.c)localObject1).field_brandFlag = this.xhk.jgj;
      ((com.tencent.mm.api.c)localObject1).field_brandIconURL = this.xhk.jgm;
      ((com.tencent.mm.api.c)localObject1).field_brandInfo = this.xhk.jgl;
      ((com.tencent.mm.api.c)localObject1).field_extInfo = this.xhk.jgk;
      ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).bX(false).getServiceType();
    }
    if (localObject1 != null)
    {
      this.xfE = ((com.tencent.mm.api.c)localObject1);
      this.cRa = ((com.tencent.mm.api.c)localObject1).KE();
      this.cRb = ((com.tencent.mm.api.c)localObject1).bX(false);
      this.cRi = this.cRb.KG();
    }
    boolean bool;
    label385:
    label400:
    Object localObject4;
    Object localObject6;
    int i;
    if (com.tencent.mm.contact.c.lO(this.contact.field_type)) {
      if (this.xfE == null)
      {
        bool = true;
        if (!bool) {
          break label1230;
        }
        localObject1 = (KeyValuePreference)this.screen.aXe("contact_info_wechat_account");
        if (bu.isNullOrNil(this.contact.VI())) {
          break label1125;
        }
        this.screen.cT("contact_info_wechat_account", false);
        ((KeyValuePreference)localObject1).setSummary(k.c(this, this.contact.VI()));
        ((Preference)localObject1).JOk = new Preference.c()
        {
          public final boolean dEL()
          {
            AppMethodBeat.i(27546);
            ClipboardManager localClipboardManager = (ClipboardManager)ak.getContext().getSystemService("clipboard");
            try
            {
              localClipboardManager.setText(this.xlS.getSummary());
              com.tencent.mm.ui.base.h.cm(NewBizInfoMoreInofUI.this.getContext(), NewBizInfoMoreInofUI.this.getContext().getString(2131755702));
              AppMethodBeat.o(27546);
              return true;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ae.e("MicroMsg.NewBizInfoMoreInofUI", "clip.setText error ");
              }
            }
          }
        };
        if ((this.cRb == null) || (this.cRb.KQ() == null) || (bu.isNullOrNil(this.cRb.KQ().cRX))) {
          break label1378;
        }
        localObject4 = this.cRb.KQ();
        localObject6 = (KeyValuePreference)this.screen.aXe("contact_info_verifyuser");
        if (localObject6 == null) {
          break label1361;
        }
        ((KeyValuePreference)localObject6).fDH();
        ((KeyValuePreference)localObject6).JNz = false;
        if (!bu.isNullOrNil(((c.b.e)localObject4).cRY)) {
          break label1292;
        }
        i = ((c.b.e)localObject4).cRW;
        switch (i)
        {
        default: 
          ae.w("MicroMsg.NewBizInfoMoreInofUI", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(i) });
          localObject1 = getResources().getString(2131757694);
          label551:
          ((KeyValuePreference)localObject6).Jvz = ((String)localObject1);
          label558:
          if (au.a.hII != null)
          {
            localObject1 = BackwardSupportUtil.b.p(au.a.hII.ou(this.contact.field_verifyFlag), 2.0F);
            label585:
            if (localObject1 == null) {
              break label3225;
            }
            localObject2 = com.tencent.mm.sdk.platformtools.h.aaZ(2131690933);
          }
          break;
        }
      }
    }
    label621:
    label1527:
    label3064:
    Object localObject3;
    label1292:
    label3212:
    label3218:
    label3225:
    for (localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject2);; localObject3 = null)
    {
      String str;
      if (localObject1 == null)
      {
        bool = true;
        ae.i("MicroMsg.NewBizInfoMoreInofUI", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
        ((KeyValuePreference)localObject6).JNG = ((Drawable)localObject2);
        if (((c.b.e)localObject4).cRX == null) {
          break label1350;
        }
        str = ((c.b.e)localObject4).cSa;
        localObject2 = k.c(this, ((c.b.e)localObject4).cRX.trim());
        if (bu.isNullOrNil(str)) {
          break label3218;
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
          label1230:
          localObject2 = localIndexOutOfBoundsException2;
        }
        try
        {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-36352), 0, str.length(), 17);
          ((KeyValuePreference)localObject6).setSummary((CharSequence)localObject1);
          if ((this.cRb == null) || (bu.isNullOrNil(this.cRb.KK()))) {
            break label1488;
          }
          localObject2 = (KeyValuePreference)this.screen.aXe("contact_info_trademark");
          if (localObject2 == null) {
            continue;
          }
          ((KeyValuePreference)localObject2).fDH();
          ((KeyValuePreference)localObject2).JNz = false;
          if (au.a.hII == null) {
            break label1476;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.h.aaZ(2131690937);
          if (localObject1 != null) {
            break label1482;
          }
          bool = true;
          ae.i("MicroMsg.NewBizInfoMoreInofUI", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label3212;
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
        ((KeyValuePreference)localObject2).JNG = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.cRb.KK());
        ae.d("MicroMsg.NewBizInfoMoreInofUI", "trademark name : %s, url : %s.", new Object[] { this.cRb.KK(), this.cRb.KJ() });
        if ((this.cRb != null) && (this.cRb.KM() != null) && (this.cRb.KM().size() > 0))
        {
          localObject1 = (KeyValuePreference)this.screen.aXe("contact_info_privilege");
          ((KeyValuePreference)localObject1).fDH();
          ((KeyValuePreference)localObject1).xN(false);
          ((KeyValuePreference)localObject1).fDG();
          localObject2 = this.cRb.KM().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label1527;
          }
          localObject4 = (c.b.g)((Iterator)localObject2).next();
          localObject6 = (LinearLayout)View.inflate(this, 2131494532, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(2131300943)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(getResources(), ((c.b.g)localObject4).iconUrl));
          str = ((c.b.g)localObject4).description;
          getResources().getIdentifier(((c.b.g)localObject4).cSf, "string", getPackageName());
          ((TextView)((LinearLayout)localObject6).findViewById(2131305546)).setText(str);
          ((KeyValuePreference)localObject1).gh((View)localObject6);
          continue;
          bool = this.xfE.KB();
          break;
          if ((!an.aUy(this.contact.field_username)) && (!x.Am(this.contact.field_username)))
          {
            this.screen.cT("contact_info_wechat_account", false);
            localObject2 = bu.nullAsNil(this.contact.adH());
            ((KeyValuePreference)localObject1).setSummary(getContext().getString(2131755760) + (String)localObject2);
            break label385;
          }
          this.screen.cT("contact_info_wechat_account", true);
          break label385;
          this.screen.cT("contact_info_wechat_account", true);
          break label400;
          localObject1 = getResources().getString(2131757895);
          break label551;
          localObject1 = getResources().getString(2131757613);
          break label551;
          localObject1 = getResources().getString(2131757614);
          break label551;
          ((KeyValuePreference)localObject6).Jvz = ((c.b.e)localObject4).cRY;
          break label558;
          localObject1 = null;
          break label585;
          bool = false;
          break label621;
          ae.e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
          continue;
          label1350:
          ae.e("MicroMsg.NewBizInfoMoreInofUI", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
          continue;
          label1361:
          this.screen.cT("contact_info_verifyuser", true);
          continue;
          label1378:
          if ((this.cRb != null) && (this.cRb.KR() != null) && (!bu.isNullOrNil(this.cRb.KR().cSg)))
          {
            localObject1 = (KeyValuePreference)this.screen.aXe("contact_info_verifyuser");
            if (localObject1 == null) {
              continue;
            }
            ((KeyValuePreference)localObject1).setSummary(this.cRb.KR().cSg);
            continue;
          }
          ae.w("MicroMsg.NewBizInfoMoreInofUI", "has not verify info");
          this.screen.cT("contact_info_verifyuser", true);
          continue;
          label1476:
          localObject1 = null;
          continue;
          label1482:
          bool = false;
          continue;
          label1488:
          ae.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
          this.screen.cT("contact_info_trademark", true);
          continue;
        }
        this.screen.cT("contact_info_privilege", true);
        localObject2 = getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        ae.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", new Object[] { localObject2, Boolean.valueOf(this.xhq) });
        if (!this.xhq)
        {
          this.xhp = ((String)localObject2);
          if ((this.cRb == null) || (!this.cRb.KW()) || (this.contact == null)) {
            this.screen.cT("contact_info_kf_worker", true);
          }
        }
        else
        {
          if ((this.cRb == null) || (bu.isNullOrNil(this.cRb.KV()))) {
            break label3013;
          }
          this.screen.cT("contact_info_service_phone", false);
          localObject1 = this.screen.aXe("contact_info_service_phone");
          if (localObject1 != null)
          {
            ((Preference)localObject1).setSummary(this.cRb.KV());
            ((Preference)localObject1).oWv = getResources().getColor(2131100547);
          }
          label1697:
          if ((this.cRb == null) || (this.cRb.KO() == null)) {
            break label3081;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aXe("contact_info_reputation");
          if (this.cRb.KO().cSb <= 0) {
            break label3030;
          }
          ((BizInfoPayInfoIconPreference)localObject1).Nn(this.cRb.KO().cSb);
          label1759:
          localObject1 = (BizInfoPayInfoIconPreference)this.screen.aXe("contact_info_guarantee_info");
          if ((this.cRb.KO().cSd == null) || (this.cRb.KO().cSd.size() <= 0)) {
            break label3047;
          }
          ((BizInfoPayInfoIconPreference)localObject1).eW(this.cRb.KO().cSd);
          label1822:
          localObject1 = (KeyValuePreference)this.screen.aXe("contact_info_scope_of_business");
          if (bu.isNullOrNil(this.cRb.KO().cSc)) {
            break label3064;
          }
          ((KeyValuePreference)localObject1).setSummary(this.cRb.KO().cSc);
          ((KeyValuePreference)localObject1).JNE = 4;
          ((KeyValuePreference)localObject1).xN(false);
          label1882:
          if ((!x.J(this.contact)) || (this.contact.eRj == null) || (this.contact.eRj.equals(""))) {
            break label3126;
          }
          localObject1 = (KeyValuePreference)this.screen.aXe("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(bu.bI(this.contact.field_weiboNickname, "") + getString(2131763406, new Object[] { x.Bg(this.contact.eRj) }));
            ((Preference)localObject1).oWv = com.tencent.mm.cb.a.n(this, 2131100547);
            ((KeyValuePreference)localObject1).xN(false);
          }
          label2016:
          if ((this.cRb == null) || (!this.cRb.KF())) {
            break label3143;
          }
          this.screen.aXe("near_field_service").setSummary(2131766197);
          if (dEK() == null) {
            break label3160;
          }
          this.screen.cT("contact_info_see_locate", false);
        }
        for (;;)
        {
          k = this.screen.indexOf("contact_info_category2");
          if ((k < 0) || (this.cRa == null) || (this.cRa.size() <= 0)) {
            break label3184;
          }
          i = this.cRa.size() - 1;
          while (i >= 0)
          {
            if ((this.cRa.get(i) != null) && ((!getString(2131757619).equals(((c.a)this.cRa.get(i)).title)) || (this.cRi)) && ((!bu.isNullOrNil(((c.a)this.cRa.get(i)).title)) || (!bu.isNullOrNil(((c.a)this.cRa.get(i)).cRe))) && (!((c.a)this.cRa.get(i)).cRe.equals("__mp_wording__brandinfo_location")) && (!getString(2131757621).equals(((c.a)this.cRa.get(i)).title)) && (!((c.a)this.cRa.get(i)).cRe.equals("__mp_wording__brandinfo_history_massmsg")))
            {
              localObject5 = new Preference(this);
              ((Preference)localObject5).setKey("contact_info_bizinfo_external#".concat(String.valueOf(i)));
              localObject1 = ((c.a)this.cRa.get(i)).title;
              j = getResources().getIdentifier(((c.a)this.cRa.get(i)).cRe, "string", getPackageName());
              if (j > 0) {
                localObject1 = getString(j);
              }
              localObject2 = localObject1;
              if (this.xfE.Ku()) {
                if (!"__mp_wording__brandinfo_history_massmsg".equals(((c.a)this.cRa.get(i)).cRe))
                {
                  localObject2 = localObject1;
                  if (!((String)localObject1).equals(getString(2131755016))) {}
                }
                else
                {
                  localObject2 = getString(2131758428);
                }
              }
              ((Preference)localObject5).setTitle((CharSequence)localObject2);
              if (!bu.isNullOrNil(((c.a)this.cRa.get(i)).description)) {
                ((Preference)localObject5).setSummary(((c.a)this.cRa.get(i)).description);
              }
              if (!bu.nullAsNil(((c.a)this.cRa.get(i)).cRe).equals("__mp_wording__brandinfo_feedback")) {
                break label3204;
              }
              j = this.screen.indexOf("contact_info_scope_of_business");
              if (j <= 0) {
                break label3204;
              }
              j += 1;
              this.screen.a((Preference)localObject5, j);
              if (bu.nullAsNil(((c.a)this.cRa.get(i)).cRe).equals("__mp_wording__brandinfo_biz_detail"))
              {
                localObject1 = new PreferenceSmallCategory(this);
                this.screen.a((Preference)localObject1, j);
              }
            }
            i -= 1;
          }
          if (bu.isNullOrNil((String)localObject2))
          {
            localObject1 = ag.aGo().Ez(this.contact.field_username);
            if (localObject1 == null)
            {
              this.screen.cT("contact_info_kf_worker", true);
              ag.aGq().a(this);
              ag.aGq().ba(this.contact.field_username, v.aAC());
              this.xhq = true;
              break;
            }
            ae.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", new Object[] { ((com.tencent.mm.al.h)localObject1).field_openId });
            this.screen.cT("contact_info_kf_worker", false);
            localObject2 = (IconWidgetPreference)this.screen.aXe("contact_info_kf_worker");
            ((IconWidgetPreference)localObject2).setSummary(((com.tencent.mm.al.h)localObject1).field_nickname);
            localObject5 = com.tencent.mm.aj.c.a(((com.tencent.mm.al.h)localObject1).field_openId, false, -1, null);
            if (localObject5 == null)
            {
              c((com.tencent.mm.al.h)localObject1);
              avZ(((com.tencent.mm.al.h)localObject1).field_openId);
              break;
            }
            ((IconWidgetPreference)localObject2).aa((Bitmap)localObject5);
            break;
          }
          Object localObject5 = ag.aGo();
          localObject1 = ((com.tencent.mm.al.j)localObject5).Ey((String)localObject2);
          if ((localObject1 == null) || (com.tencent.mm.al.j.a((com.tencent.mm.al.h)localObject1)))
          {
            ag.aGq().a(this);
            ag.aGq().k(this.contact.field_username, (String)localObject2, 1);
            this.xhq = true;
          }
          if (localObject1 != null) {
            break label3209;
          }
          ae.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
          localObject1 = ((com.tencent.mm.al.j)localObject5).Ez(this.contact.field_username);
          if (localObject1 == null)
          {
            this.screen.cT("contact_info_kf_worker", true);
            break;
          }
          this.screen.cT("contact_info_kf_worker", false);
          localObject2 = (IconWidgetPreference)this.screen.aXe("contact_info_kf_worker");
          ((IconWidgetPreference)localObject2).setSummary(((com.tencent.mm.al.h)localObject1).field_nickname);
          localObject5 = com.tencent.mm.aj.c.a(((com.tencent.mm.al.h)localObject1).field_openId, false, -1, null);
          if (localObject5 == null)
          {
            c((com.tencent.mm.al.h)localObject1);
            avZ(((com.tencent.mm.al.h)localObject1).field_openId);
          }
          for (;;)
          {
            ae.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", new Object[] { ((com.tencent.mm.al.h)localObject1).field_openId, ((com.tencent.mm.al.h)localObject1).field_nickname });
            break;
            ((IconWidgetPreference)localObject2).aa((Bitmap)localObject5);
          }
          label3013:
          this.screen.cT("contact_info_service_phone", true);
          break label1697;
          label3030:
          this.screen.cT("contact_info_reputation", true);
          break label1759;
          label3047:
          this.screen.cT("contact_info_guarantee_info", true);
          break label1822;
          this.screen.cT("contact_info_scope_of_business", true);
          break label1882;
          this.screen.cT("contact_info_reputation", true);
          this.screen.cT("contact_info_guarantee_info", true);
          this.screen.cT("contact_info_scope_of_business", true);
          break label1882;
          label3126:
          this.screen.cT("contact_info_verifyuser_weibo", true);
          break label2016;
          label3143:
          this.screen.cT("near_field_service", true);
          break label2051;
          label3160:
          this.screen.cT("contact_info_see_locate", true);
        }
        AppMethodBeat.o(27550);
        return;
        label3184:
        ae.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
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
    setActionbarColor(getContext().getResources().getColor(2131100705));
    setMMTitle(2131757606);
    setTitleDividerVis(false);
    hideActionbarLine();
    setBackBtn(new NewBizInfoMoreInofUI.1(this));
    paramBundle = bu.nullAsNil(getIntent().getStringExtra("Contact_User"));
    String str1 = bu.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    int i = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
    int j = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
    String str2 = getIntent().getStringExtra("Contact_KWeibo");
    String str3 = getIntent().getStringExtra("Contact_KWeiboNick");
    bc.aCg();
    this.contact = com.tencent.mm.model.c.azF().BH(paramBundle);
    if ((this.contact == null) || ((int)this.contact.ght == 0) || (bu.nullAsNil(this.contact.field_username).length() <= 0))
    {
      this.contact = new an();
      this.contact.setUsername(paramBundle);
      this.contact.tl(str1);
      this.contact.kd(i);
      this.contact.tJ(str2);
      this.contact.kc(j);
      this.contact.tr(str3);
    }
    for (;;)
    {
      this.xfE = com.tencent.mm.al.g.eX(this.contact.field_username);
      paramBundle = getIntent().getByteArrayExtra("Contact_customInfo");
      if (paramBundle == null) {
        paramBundle = null;
      }
      try
      {
        for (;;)
        {
          this.xhk = paramBundle;
          this.jij = getIntent().getIntExtra("Contact_Scene", 9);
          this.xhs = getIntent().getBundleExtra("Contact_Ext_Args");
          initView();
          AppMethodBeat.o(27549);
          return;
          if (i == 0) {
            break;
          }
          this.contact.kd(i);
          break;
          paramBundle = (aco)new aco().parseFrom(paramBundle);
        }
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.NewBizInfoMoreInofUI", paramBundle, "", new Object[0]);
        }
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int i = 6;
    AppMethodBeat.i(27555);
    paramPreference = paramPreference.mKey;
    ae.i("MicroMsg.NewBizInfoMoreInofUI", paramPreference + " item has been clicked!");
    Object localObject;
    int j;
    if ("contact_info_see_locate".endsWith(paramPreference))
    {
      paramf = dEK();
      if (paramf == null)
      {
        ae.e("MicroMsg.NewBizInfoMoreInofUI", "[onPreferenceTreeClick] info is null, err");
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
      if (((this.xhs != null) && ((this.jij == 39) || (this.jij == 56) || (this.jij == 35))) || (this.jij == 87) || (this.jij == 89) || (this.jij == 85) || (this.jij == 88))
      {
        ae.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("KFromBizSearch", true);
        ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.xhs);
        paramPreference.putExtra("jsapiargs", (Bundle)localObject);
        if (!com.tencent.mm.contact.c.lO(this.contact.field_type)) {
          break label343;
        }
      }
      label343:
      for (i = 7;; i = 6)
      {
        j = getResources().getIdentifier(paramf.cRe, "string", getPackageName());
        paramf = paramf.title;
        if (j > 0) {
          paramf = getString(j);
        }
        bB(i, paramf);
        com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(27555);
        return true;
      }
    }
    if ("contact_info_verifyuser".endsWith(paramPreference))
    {
      paramf = this.xfE;
      if (paramf == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      localObject = paramf.bX(false);
      if (localObject == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      paramPreference = null;
      if ((((c.b)localObject).KQ() != null) && (!bu.isNullOrNil(((c.b)localObject).KQ().cRZ))) {
        paramf = ((c.b)localObject).KQ().cRZ;
      }
      for (;;)
      {
        if (!bu.isNullOrNil(paramf))
        {
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("useJs", true);
          paramPreference.putExtra("vertical_scroll", true);
          paramPreference.putExtra("geta8key_scene", 3);
          com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(this.contact.field_username, 1200, this.jij, 0L);
        AppMethodBeat.o(27555);
        return true;
        paramf = paramPreference;
        if (((c.b)localObject).KR() != null)
        {
          paramf = paramPreference;
          if (!bu.isNullOrNil(((c.b)localObject).KR().cSh)) {
            paramf = ((c.b)localObject).KR().cSh;
          }
        }
      }
    }
    if ("contact_info_trademark".endsWith(paramPreference))
    {
      paramf = this.xfE;
      if (paramf == null)
      {
        AppMethodBeat.o(27555);
        return true;
      }
      if ((paramf.bX(false) != null) && (!bu.isNullOrNil(paramf.bX(false).KJ())))
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf.bX(false).KJ());
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
      }
      AppMethodBeat.o(27555);
      return true;
    }
    if ("contact_info_service_phone".equals(paramPreference))
    {
      paramf = paramf.aXe("contact_info_service_phone");
      if ((paramf != null) && (paramf.getSummary() != null) && (!bu.isNullOrNil(paramf.getSummary().toString())))
      {
        paramf = paramf.getSummary().toString();
        com.tencent.mm.ui.base.h.a(this, true, paramf, "", getString(2131757643), getString(2131755691), new NewBizInfoMoreInofUI.4(this, paramf), null);
      }
    }
    if (paramPreference.startsWith("contact_info_bizinfo_external#"))
    {
      j = bu.getInt(paramPreference.replace("contact_info_bizinfo_external#", ""), -1);
      if ((j >= 0) && (j < this.cRa.size()))
      {
        paramf = (c.a)this.cRa.get(j);
        localObject = paramf.url;
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", (String)localObject);
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        paramPreference.putExtra("KPublisherId", "brand_profile");
        paramPreference.putExtra("prePublishId", "brand_profile");
        if (((this.xhs != null) && ((this.jij == 39) || (this.jij == 56) || (this.jij == 35))) || (this.jij == 87) || (this.jij == 89) || (this.jij == 85) || (this.jij == 88))
        {
          ae.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.xhs);
          paramPreference.putExtra("jsapiargs", (Bundle)localObject);
          if (com.tencent.mm.contact.c.lO(this.contact.field_type)) {
            i = 7;
          }
          j = getResources().getIdentifier(paramf.cRe, "string", getPackageName());
          paramf = paramf.title;
          if (j > 0) {
            paramf = getString(j);
          }
          bB(i, paramf);
        }
        com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(27555);
        return true;
      }
    }
    if (paramPreference.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this).iK(this.contact.eRj, this.contact.field_username);
      AppMethodBeat.o(27555);
      return true;
    }
    if (("contact_info_guarantee_info".equals(paramPreference)) && (this.cRb.KO() != null) && (!bu.isNullOrNil(this.cRb.KO().cSe)))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", this.cRb.KO().cSe);
      paramf.putExtra("useJs", true);
      paramf.putExtra("vertical_scroll", true);
      paramf.putExtra("geta8key_scene", 3);
      com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    if ((!"contact_info_expose_btn".equals(paramPreference)) || (this.contact == null) || (bu.isNullOrNil(this.contact.field_username))) {}
    for (;;)
    {
      AppMethodBeat.o(27555);
      return false;
      paramf = new Intent();
      paramf.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[] { this.contact.field_username }));
      paramf.putExtra("showShare", false);
      com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI
 * JD-Core Version:    0.7.0.1
 */