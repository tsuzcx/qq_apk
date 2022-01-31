package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.o;
import com.tencent.mm.ai.d.a;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.d.b.d;
import com.tencent.mm.ai.d.b.e;
import com.tencent.mm.ai.d.b.f;
import com.tencent.mm.ai.d.b.g;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.cln;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.c;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.statusbar.DrawStatusBarPreference;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMoreInofUI
  extends DrawStatusBarPreference
  implements h.a
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private ad dnp;
  private List<d.a> eeV;
  private d.b eeW;
  private boolean efd = false;
  private int fhj;
  private com.tencent.mm.ai.d mVy;
  private sg mWN;
  private String mWS;
  private boolean mWT;
  private Bundle mWV;
  
  private void KU(String paramString)
  {
    ai.l(new NewBizInfoMoreInofUI.3(this, paramString), 2000L);
  }
  
  private void az(int paramInt, String paramString)
  {
    if ((this.mWV == null) || ((this.fhj != 39) && (this.fhj != 56) && (this.fhj != 35) && (this.fhj != 87) && (this.fhj != 88) && (this.fhj != 89) && (this.fhj != 85)))
    {
      y.d("MicroMsg.NewBizInfoMoreInofUI", "mExtArgs is null or the add contact action is not from biz search.");
      return;
    }
    if (this.dnp == null)
    {
      y.i("MicroMsg.NewBizInfoMoreInofUI", "contact is null.");
      return;
    }
    String str2 = this.mWV.getString("Contact_Ext_Args_Search_Id");
    String str3 = bk.pm(this.mWV.getString("Contact_Ext_Args_Query_String"));
    int j = this.mWV.getInt("Contact_Ext_Args_Index");
    int i;
    String str1;
    switch (this.fhj)
    {
    default: 
      i = 0;
      str1 = bk.pm(this.mWV.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bk.pm(this.dnp.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bk.bl(paramString)) {
        break;
      }
    }
    for (paramString = str2 + "," + paramString + "," + str1;; paramString = str2 + ",," + str1)
    {
      y.v("MicroMsg.NewBizInfoMoreInofUI", "report 10866: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10866, paramString);
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
  
  private d.a bsT()
  {
    Object localObject;
    if ((this.eeV == null) || (this.eeV.size() < 0))
    {
      y.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.eeV.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        d.a locala = (d.a)localIterator.next();
        localObject = locala;
        if (locala.eeZ.equals("__mp_wording__brandinfo_location")) {
          break;
        }
        if (getString(R.l.contact_info_biz_see_location).equals(locala.title)) {
          return locala;
        }
      }
    }
    y.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
    return null;
  }
  
  private static void c(g paramg)
  {
    long l = System.currentTimeMillis();
    com.tencent.mm.ag.i locali = o.Kh();
    if (locali.kp(paramg.field_openId) == null)
    {
      com.tencent.mm.ag.h localh = new com.tencent.mm.ag.h();
      localh.username = paramg.field_openId;
      localh.ebS = paramg.field_headImgUrl;
      localh.bK(false);
      localh.cCq = 3;
      locali.a(localh);
    }
    o.Kj().kc(paramg.field_openId);
    y.d("MicroMsg.NewBizInfoMoreInofUI", "downloadKFAvatar, %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public final String Mq()
  {
    return "MicroMsg.NewBizInfoMoreInofUI";
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 7;
    boolean bool2 = true;
    paramPreference = paramPreference.mKey;
    y.i("MicroMsg.NewBizInfoMoreInofUI", paramPreference + " item has been clicked!");
    boolean bool1;
    if ("contact_info_see_locate".endsWith(paramPreference))
    {
      paramf = bsT();
      if (paramf == null)
      {
        y.e("MicroMsg.NewBizInfoMoreInofUI", "[onPreferenceTreeClick] info is null, err");
        bool1 = false;
      }
    }
    Object localObject;
    int j;
    label332:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              localObject = paramf.url;
              paramPreference = new Intent();
              paramPreference.putExtra("rawUrl", (String)localObject);
              paramPreference.putExtra("useJs", true);
              paramPreference.putExtra("vertical_scroll", true);
              paramPreference.putExtra("geta8key_scene", 3);
              paramPreference.putExtra("KPublisherId", "brand_profile");
              paramPreference.putExtra("prePublishId", "brand_profile");
              if (((this.mWV != null) && ((this.fhj == 39) || (this.fhj == 56) || (this.fhj == 35))) || (this.fhj == 87) || (this.fhj == 89) || (this.fhj == 85) || (this.fhj == 88))
              {
                y.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
                localObject = new Bundle();
                ((Bundle)localObject).putBoolean("KFromBizSearch", true);
                ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.mWV);
                paramPreference.putExtra("jsapiargs", (Bundle)localObject);
                if (!com.tencent.mm.n.a.gR(this.dnp.field_type)) {
                  break label332;
                }
              }
              for (i = 7;; i = 6)
              {
                j = getResources().getIdentifier(paramf.eeZ, "string", getPackageName());
                paramf = paramf.title;
                if (j > 0) {
                  paramf = getString(j);
                }
                az(i, paramf);
                com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
                return true;
              }
              if (!"contact_info_verifyuser".endsWith(paramPreference)) {
                break;
              }
              paramf = this.mVy;
              bool1 = bool2;
            } while (paramf == null);
            localObject = paramf.bS(false);
            bool1 = bool2;
          } while (localObject == null);
          paramPreference = null;
          if ((((d.b)localObject).LT() != null) && (!bk.bl(((d.b)localObject).LT().efS))) {
            paramf = ((d.b)localObject).LT().efS;
          }
          for (;;)
          {
            if (!bk.bl(paramf))
            {
              paramPreference = new Intent();
              paramPreference.putExtra("rawUrl", paramf);
              paramPreference.putExtra("useJs", true);
              paramPreference.putExtra("vertical_scroll", true);
              paramPreference.putExtra("geta8key_scene", 3);
              com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(this.dnp.field_username, 1200);
            return true;
            paramf = paramPreference;
            if (((d.b)localObject).LU() != null)
            {
              paramf = paramPreference;
              if (!bk.bl(((d.b)localObject).LU().ega)) {
                paramf = ((d.b)localObject).LU().ega;
              }
            }
          }
          if (!"contact_info_trademark".endsWith(paramPreference)) {
            break;
          }
          paramf = this.mVy;
          bool1 = bool2;
        } while (paramf == null);
        bool1 = bool2;
      } while (paramf.bS(false) == null);
      bool1 = bool2;
    } while (bk.bl(paramf.bS(false).LM()));
    paramPreference = new Intent();
    paramPreference.putExtra("rawUrl", paramf.bS(false).LM());
    paramPreference.putExtra("useJs", true);
    paramPreference.putExtra("vertical_scroll", true);
    paramPreference.putExtra("geta8key_scene", 3);
    com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
    return true;
    if ("contact_info_service_phone".equals(paramPreference))
    {
      paramf = paramf.add("contact_info_service_phone");
      if ((paramf != null) && (paramf.getSummary() != null) && (!bk.bl(paramf.getSummary().toString())))
      {
        paramf = paramf.getSummary().toString();
        com.tencent.mm.ui.base.h.a(this, true, paramf, "", getString(R.l.contact_info_dial), getString(R.l.app_cancel), new NewBizInfoMoreInofUI.4(this, paramf), null);
      }
    }
    if (paramPreference.startsWith("contact_info_bizinfo_external#"))
    {
      j = bk.getInt(paramPreference.replace("contact_info_bizinfo_external#", ""), -1);
      if ((j >= 0) && (j < this.eeV.size()))
      {
        paramf = (d.a)this.eeV.get(j);
        localObject = paramf.url;
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", (String)localObject);
        paramPreference.putExtra("useJs", true);
        paramPreference.putExtra("vertical_scroll", true);
        paramPreference.putExtra("geta8key_scene", 3);
        paramPreference.putExtra("KPublisherId", "brand_profile");
        paramPreference.putExtra("prePublishId", "brand_profile");
        if (((this.mWV != null) && ((this.fhj == 39) || (this.fhj == 56) || (this.fhj == 35))) || (this.fhj == 87) || (this.fhj == 89) || (this.fhj == 85) || (this.fhj == 88))
        {
          y.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("KFromBizSearch", true);
          ((Bundle)localObject).putBundle("KBizSearchExtArgs", this.mWV);
          paramPreference.putExtra("jsapiargs", (Bundle)localObject);
          if (!com.tencent.mm.n.a.gR(this.dnp.field_type)) {
            break label1052;
          }
        }
        for (;;)
        {
          j = getResources().getIdentifier(paramf.eeZ, "string", getPackageName());
          paramf = paramf.title;
          if (j > 0) {
            paramf = getString(j);
          }
          az(i, paramf);
          com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
          return true;
          label1052:
          i = 6;
        }
      }
    }
    if (paramPreference.equals("contact_info_verifyuser_weibo"))
    {
      new com.tencent.mm.plugin.profile.ui.a.a(this).ep(this.dnp.cCE, this.dnp.field_username);
      return true;
    }
    if (("contact_info_guarantee_info".equals(paramPreference)) && (this.eeW.LR() != null) && (!bk.bl(this.eeW.LR().efX)))
    {
      paramf = new Intent();
      paramf.putExtra("rawUrl", this.eeW.LR().efX);
      paramf.putExtra("useJs", true);
      paramf.putExtra("vertical_scroll", true);
      paramf.putExtra("geta8key_scene", 3);
      com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
    if ((!"contact_info_expose_btn".equals(paramPreference)) || (this.dnp == null) || (bk.bl(this.dnp.field_username))) {}
    for (;;)
    {
      return false;
      paramf = new Intent();
      paramf.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[] { this.dnp.field_username }));
      paramf.putExtra("showShare", false);
      com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
  }
  
  public final void e(LinkedList<cln> paramLinkedList)
  {
    z.Mz().b(this);
    if (this.dnn == null)
    {
      y.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, screen is null");
      return;
    }
    if (this.dnp == null)
    {
      y.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, contact is null");
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      y.w("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, worker is null");
      return;
    }
    if (!bk.bl(this.mWS))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        cln localcln = (cln)localIterator.next();
        if ((localcln.tYK != null) && (localcln.tYK.equals(this.mWS)))
        {
          this.dnn.bJ("contact_info_kf_worker", false);
          this.dnn.add("contact_info_kf_worker").setSummary(localcln.tqh);
          return;
        }
      }
    }
    this.dnn.bJ("contact_info_kf_worker", false);
    this.dnn.add("contact_info_kf_worker").setSummary(((cln)paramLinkedList.get(0)).tqh);
  }
  
  protected final void initView()
  {
    this.dnn.bJ("biz_placed_to_the_top", true);
    Object localObject2 = com.tencent.mm.ai.f.kX(this.dnp.field_username);
    this.eeV = null;
    this.eeW = null;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((com.tencent.mm.ai.d)localObject2).bS(false) != null) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.mWN != null)
      {
        localObject1 = new com.tencent.mm.ai.d();
        ((com.tencent.mm.ai.d)localObject1).field_username = this.dnp.field_username;
        ((com.tencent.mm.ai.d)localObject1).field_brandFlag = this.mWN.ffv;
        ((com.tencent.mm.ai.d)localObject1).field_brandIconURL = this.mWN.ffy;
        ((com.tencent.mm.ai.d)localObject1).field_brandInfo = this.mWN.ffx;
        ((com.tencent.mm.ai.d)localObject1).field_extInfo = this.mWN.ffw;
        ((com.tencent.mm.ai.d)localObject1).field_type = ((com.tencent.mm.ai.d)localObject1).bS(false).LW();
      }
    }
    if ((localObject1 != null) && (((com.tencent.mm.ai.d)localObject1).field_brandInfo == null) && (((com.tencent.mm.ai.d)localObject1).field_extInfo == null) && (this.mWN != null))
    {
      ((com.tencent.mm.ai.d)localObject1).field_username = this.dnp.field_username;
      ((com.tencent.mm.ai.d)localObject1).field_brandFlag = this.mWN.ffv;
      ((com.tencent.mm.ai.d)localObject1).field_brandIconURL = this.mWN.ffy;
      ((com.tencent.mm.ai.d)localObject1).field_brandInfo = this.mWN.ffx;
      ((com.tencent.mm.ai.d)localObject1).field_extInfo = this.mWN.ffw;
      ((com.tencent.mm.ai.d)localObject1).field_type = ((com.tencent.mm.ai.d)localObject1).bS(false).LW();
    }
    if (localObject1 != null)
    {
      this.mVy = ((com.tencent.mm.ai.d)localObject1);
      this.eeV = ((com.tencent.mm.ai.d)localObject1).LH();
      this.eeW = ((com.tencent.mm.ai.d)localObject1).bS(false);
      this.efd = this.eeW.LJ();
    }
    boolean bool;
    label377:
    Object localObject4;
    label392:
    Object localObject6;
    int i;
    if (com.tencent.mm.n.a.gR(this.dnp.field_type)) {
      if (this.mVy == null)
      {
        bool = true;
        if (!bool) {
          break label1223;
        }
        localObject1 = (KeyValuePreference)this.dnn.add("contact_info_wechat_account");
        if (bk.bl(this.dnp.vk())) {
          break label1117;
        }
        this.dnn.bJ("contact_info_wechat_account", false);
        ((KeyValuePreference)localObject1).setSummary(j.b(this, this.dnp.vk()));
        ((Preference)localObject1).vdD = new Preference.c()
        {
          public final boolean bsU()
          {
            ClipboardManager localClipboardManager = (ClipboardManager)NewBizInfoMoreInofUI.this.mController.uMN.getSystemService("clipboard");
            try
            {
              localClipboardManager.setText(this.nac.getSummary());
              com.tencent.mm.ui.base.h.bC(NewBizInfoMoreInofUI.this.mController.uMN, NewBizInfoMoreInofUI.this.mController.uMN.getString(R.l.app_copy_ok));
              return true;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                y.e("MicroMsg.NewBizInfoMoreInofUI", "clip.setText error ");
              }
            }
          }
        };
        if ((this.eeW == null) || (this.eeW.LT() == null) || (bk.bl(this.eeW.LT().efQ))) {
          break label1369;
        }
        localObject4 = this.eeW.LT();
        localObject6 = (KeyValuePreference)this.dnn.add("contact_info_verifyuser");
        if (localObject6 == null) {
          break label1353;
        }
        ((KeyValuePreference)localObject6).cBw();
        ((KeyValuePreference)localObject6).vcS = false;
        if (!bk.bl(((d.b.d)localObject4).efR)) {
          break label1284;
        }
        i = ((d.b.d)localObject4).efP;
        switch (i)
        {
        default: 
          y.w("MicroMsg.NewBizInfoMoreInofUI", "getVerifyStr, error type %d", new Object[] { Integer.valueOf(i) });
          localObject1 = getResources().getString(R.l.contact_info_isnot_verify_user_title);
          label543:
          ((KeyValuePreference)localObject6).uME = ((String)localObject1);
          label550:
          if (am.a.dVA != null)
          {
            localObject1 = BackwardSupportUtil.b.e(am.a.dVA.hL(this.dnp.field_verifyFlag), 2.0F);
            label577:
            if (localObject1 == null) {
              break label3186;
            }
            localObject2 = com.tencent.mm.sdk.platformtools.c.EX(R.k.new_biz_certified);
          }
          break;
        }
      }
    }
    label613:
    label1515:
    label2037:
    Object localObject3;
    label1117:
    label3045:
    label3173:
    label3179:
    label3186:
    for (localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject2);; localObject3 = null)
    {
      String str;
      if (localObject1 == null)
      {
        bool = true;
        y.i("MicroMsg.NewBizInfoMoreInofUI", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
        ((KeyValuePreference)localObject6).vda = ((Drawable)localObject2);
        if (((d.b.d)localObject4).efQ == null) {
          break label1342;
        }
        str = ((d.b.d)localObject4).efT;
        localObject2 = j.b(this, ((d.b.d)localObject4).efQ.trim());
        if (bk.bl(str)) {
          break label3179;
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
          localObject1 = localObject2;
          localObject2 = localIndexOutOfBoundsException2;
        }
        try
        {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-36352), 0, str.length(), 17);
          ((KeyValuePreference)localObject6).setSummary((CharSequence)localObject1);
          if ((this.eeW == null) || (bk.bl(this.eeW.LN()))) {
            break label1478;
          }
          localObject2 = (KeyValuePreference)this.dnn.add("contact_info_trademark");
          if (localObject2 == null) {
            continue;
          }
          ((KeyValuePreference)localObject2).cBw();
          ((KeyValuePreference)localObject2).vcS = false;
          if (am.a.dVA == null) {
            break label1466;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.c.EX(R.k.new_biz_trademark_protection);
          if (localObject1 != null) {
            break label1472;
          }
          bool = true;
          y.i("MicroMsg.NewBizInfoMoreInofUI", "trademark bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label3173;
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
        ((KeyValuePreference)localObject2).vda = ((Drawable)localObject1);
        ((KeyValuePreference)localObject2).setSummary(this.eeW.LN());
        y.d("MicroMsg.NewBizInfoMoreInofUI", "trademark name : %s, url : %s.", new Object[] { this.eeW.LN(), this.eeW.LM() });
        if ((this.eeW != null) && (this.eeW.LP() != null) && (this.eeW.LP().size() > 0))
        {
          localObject1 = (KeyValuePreference)this.dnn.add("contact_info_privilege");
          ((KeyValuePreference)localObject1).cBw();
          ((KeyValuePreference)localObject1).nf(false);
          ((KeyValuePreference)localObject1).cBv();
          localObject2 = this.eeW.LP().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label1515;
          }
          localObject4 = (d.b.f)((Iterator)localObject2).next();
          localObject6 = (LinearLayout)View.inflate(this, R.i.keyvalue_pref_item, null);
          ((ImageView)((LinearLayout)localObject6).findViewById(R.h.image_iv)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.a(getResources(), ((d.b.f)localObject4).iconUrl));
          str = ((d.b.f)localObject4).description;
          getResources().getIdentifier(((d.b.f)localObject4).efY, "string", getPackageName());
          ((TextView)((LinearLayout)localObject6).findViewById(R.h.summary)).setText(str);
          ((KeyValuePreference)localObject1).dF((View)localObject6);
          continue;
          bool = this.mVy.LE();
          break;
          if ((!ad.aaX(this.dnp.field_username)) && (!com.tencent.mm.model.s.hj(this.dnp.field_username)))
          {
            this.dnn.bJ("contact_info_wechat_account", false);
            localObject2 = bk.pm(this.dnp.Br());
            ((KeyValuePreference)localObject1).setSummary(this.mController.uMN.getString(R.l.app_field_username) + (String)localObject2);
            break label377;
          }
          this.dnn.bJ("contact_info_wechat_account", true);
          break label377;
          this.dnn.bJ("contact_info_wechat_account", true);
          break label392;
          localObject1 = getResources().getString(R.l.contact_info_verify_user_title);
          break label543;
          localObject1 = getResources().getString(R.l.contact_info_biz_new_sweibo_verify);
          break label543;
          localObject1 = getResources().getString(R.l.contact_info_biz_new_tweibo_verify);
          break label543;
          ((KeyValuePreference)localObject6).uME = ((d.b.d)localObject4).efR;
          break label550;
          localObject1 = null;
          break label577;
          bool = false;
          break label613;
          y.e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", new Object[] { ((IndexOutOfBoundsException)localObject2).getMessage() });
          continue;
          y.e("MicroMsg.NewBizInfoMoreInofUI", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
          continue;
          this.dnn.bJ("contact_info_verifyuser", true);
          continue;
          if ((this.eeW != null) && (this.eeW.LU() != null) && (!bk.bl(this.eeW.LU().efZ)))
          {
            localObject1 = (KeyValuePreference)this.dnn.add("contact_info_verifyuser");
            if (localObject1 == null) {
              continue;
            }
            ((KeyValuePreference)localObject1).setSummary(this.eeW.LU().efZ);
            continue;
          }
          y.w("MicroMsg.NewBizInfoMoreInofUI", "has not verify info");
          this.dnn.bJ("contact_info_verifyuser", true);
          continue;
          localObject1 = null;
          continue;
          bool = false;
          continue;
          y.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
          this.dnn.bJ("contact_info_trademark", true);
          continue;
        }
        this.dnn.bJ("contact_info_privilege", true);
        localObject2 = getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        y.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", new Object[] { localObject2, Boolean.valueOf(this.mWT) });
        if (!this.mWT)
        {
          this.mWS = ((String)localObject2);
          if ((this.eeW == null) || (!this.eeW.Ma()) || (this.dnp == null)) {
            this.dnn.bJ("contact_info_kf_worker", true);
          }
        }
        else
        {
          if ((this.eeW == null) || (bk.bl(this.eeW.LZ()))) {
            break label2997;
          }
          this.dnn.bJ("contact_info_service_phone", false);
          localObject1 = this.dnn.add("contact_info_service_phone");
          if (localObject1 != null)
          {
            ((Preference)localObject1).setSummary(this.eeW.LZ());
            ((Preference)localObject1).izu = getResources().getColor(R.e.link_color);
          }
          if ((this.eeW == null) || (this.eeW.LR() == null)) {
            break label3061;
          }
          localObject1 = (BizInfoPayInfoIconPreference)this.dnn.add("contact_info_reputation");
          if (this.eeW.LR().efU <= 0) {
            break label3013;
          }
          ((BizInfoPayInfoIconPreference)localObject1).vT(this.eeW.LR().efU);
          localObject1 = (BizInfoPayInfoIconPreference)this.dnn.add("contact_info_guarantee_info");
          if ((this.eeW.LR().efW == null) || (this.eeW.LR().efW.size() <= 0)) {
            break label3029;
          }
          ((BizInfoPayInfoIconPreference)localObject1).bX(this.eeW.LR().efW);
          localObject1 = (KeyValuePreference)this.dnn.add("contact_info_scope_of_business");
          if (bk.bl(this.eeW.LR().efV)) {
            break label3045;
          }
          ((KeyValuePreference)localObject1).setSummary(this.eeW.LR().efV);
          ((KeyValuePreference)localObject1).vcY = 4;
          ((KeyValuePreference)localObject1).nf(false);
          if ((!com.tencent.mm.model.s.w(this.dnp)) || (this.dnp.cCE == null) || (this.dnp.cCE.equals(""))) {
            break label3103;
          }
          localObject1 = (KeyValuePreference)this.dnn.add("contact_info_verifyuser_weibo");
          if (localObject1 != null)
          {
            ((KeyValuePreference)localObject1).setSummary(bk.aM(this.dnp.field_weiboNickname, "") + getString(R.l.settings_show_weibo_field, new Object[] { com.tencent.mm.model.s.ib(this.dnp.cCE) }));
            ((Preference)localObject1).izu = com.tencent.mm.cb.a.i(this, R.e.link_color);
            ((KeyValuePreference)localObject1).nf(false);
          }
          if ((this.eeW == null) || (!this.eeW.LI())) {
            break label3119;
          }
          this.dnn.add("near_field_service").setSummary(R.l.weixin_connect_wifi);
          if (bsT() == null) {
            break label3135;
          }
          this.dnn.bJ("contact_info_see_locate", false);
        }
        for (;;)
        {
          k = this.dnn.indexOf("contact_info_category2");
          if ((k < 0) || (this.eeV == null) || (this.eeV.size() <= 0)) {
            break label3151;
          }
          i = this.eeV.size() - 1;
          while (i >= 0)
          {
            if ((this.eeV.get(i) != null) && ((!getString(R.l.contact_info_biz_participants).equals(((d.a)this.eeV.get(i)).title)) || (this.efd)) && ((!bk.bl(((d.a)this.eeV.get(i)).title)) || (!bk.bl(((d.a)this.eeV.get(i)).eeZ))) && (!((d.a)this.eeV.get(i)).eeZ.equals("__mp_wording__brandinfo_location")) && (!getString(R.l.contact_info_biz_see_location).equals(((d.a)this.eeV.get(i)).title)) && (!((d.a)this.eeV.get(i)).eeZ.equals("__mp_wording__brandinfo_history_massmsg")))
            {
              localObject5 = new Preference(this);
              ((Preference)localObject5).setKey("contact_info_bizinfo_external#" + i);
              localObject1 = ((d.a)this.eeV.get(i)).title;
              j = getResources().getIdentifier(((d.a)this.eeV.get(i)).eeZ, "string", getPackageName());
              if (j > 0) {
                localObject1 = getString(j);
              }
              localObject2 = localObject1;
              if (this.mVy.Lx()) {
                if (!"__mp_wording__brandinfo_history_massmsg".equals(((d.a)this.eeV.get(i)).eeZ))
                {
                  localObject2 = localObject1;
                  if (!((String)localObject1).equals(getString(R.l.__mp_wording__brandinfo_history_massmsg))) {}
                }
                else
                {
                  localObject2 = getString(R.l.enterprise_brand_history);
                }
              }
              ((Preference)localObject5).setTitle((CharSequence)localObject2);
              if (!bk.bl(((d.a)this.eeV.get(i)).description)) {
                ((Preference)localObject5).setSummary(((d.a)this.eeV.get(i)).description);
              }
              if (!bk.pm(((d.a)this.eeV.get(i)).eeZ).equals("__mp_wording__brandinfo_feedback")) {
                break label3165;
              }
              j = this.dnn.indexOf("contact_info_scope_of_business");
              if (j <= 0) {
                break label3165;
              }
              j += 1;
              this.dnn.a((Preference)localObject5, j);
              if (bk.pm(((d.a)this.eeV.get(i)).eeZ).equals("__mp_wording__brandinfo_biz_detail"))
              {
                localObject1 = new PreferenceSmallCategory(this);
                this.dnn.a((Preference)localObject1, j);
              }
            }
            i -= 1;
          }
          if (bk.bl((String)localObject2))
          {
            localObject1 = z.Mx().lh(this.dnp.field_username);
            if (localObject1 == null)
            {
              this.dnn.bJ("contact_info_kf_worker", true);
              z.Mz().a(this);
              z.Mz().al(this.dnp.field_username, q.Gj());
              this.mWT = true;
              break;
            }
            y.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", new Object[] { ((g)localObject1).field_openId });
            this.dnn.bJ("contact_info_kf_worker", false);
            localObject2 = (IconWidgetPreference)this.dnn.add("contact_info_kf_worker");
            ((IconWidgetPreference)localObject2).setSummary(((g)localObject1).field_nickname);
            localObject5 = b.a(((g)localObject1).field_openId, false, -1);
            if (localObject5 == null)
            {
              c((g)localObject1);
              KU(((g)localObject1).field_openId);
              break;
            }
            ((IconWidgetPreference)localObject2).C((Bitmap)localObject5);
            break;
          }
          Object localObject5 = z.Mx();
          localObject1 = ((com.tencent.mm.ai.i)localObject5).lg((String)localObject2);
          if ((localObject1 == null) || (com.tencent.mm.ai.i.a((g)localObject1)))
          {
            z.Mz().a(this);
            z.Mz().am(this.dnp.field_username, (String)localObject2);
            this.mWT = true;
          }
          if (localObject1 != null) {
            break label3170;
          }
          y.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
          localObject1 = ((com.tencent.mm.ai.i)localObject5).lh(this.dnp.field_username);
          if (localObject1 == null)
          {
            this.dnn.bJ("contact_info_kf_worker", true);
            break;
          }
          this.dnn.bJ("contact_info_kf_worker", false);
          localObject2 = (IconWidgetPreference)this.dnn.add("contact_info_kf_worker");
          ((IconWidgetPreference)localObject2).setSummary(((g)localObject1).field_nickname);
          localObject5 = b.a(((g)localObject1).field_openId, false, -1);
          if (localObject5 == null)
          {
            c((g)localObject1);
            KU(((g)localObject1).field_openId);
          }
          for (;;)
          {
            y.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", new Object[] { ((g)localObject1).field_openId, ((g)localObject1).field_nickname });
            break;
            ((IconWidgetPreference)localObject2).C((Bitmap)localObject5);
          }
          this.dnn.bJ("contact_info_service_phone", true);
          break label1683;
          this.dnn.bJ("contact_info_reputation", true);
          break label1745;
          this.dnn.bJ("contact_info_guarantee_info", true);
          break label1808;
          this.dnn.bJ("contact_info_scope_of_business", true);
          break label1868;
          label3061:
          this.dnn.bJ("contact_info_reputation", true);
          this.dnn.bJ("contact_info_guarantee_info", true);
          this.dnn.bJ("contact_info_scope_of_business", true);
          break label1868;
          this.dnn.bJ("contact_info_verifyuser_weibo", true);
          break label2002;
          this.dnn.bJ("near_field_service", true);
          break label2037;
          this.dnn.bJ("contact_info_see_locate", true);
        }
        y.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
        return;
        localObject1 = localIndexOutOfBoundsException1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    ta(a.mZx);
    if (Build.VERSION.SDK_INT >= 21) {
      com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, getWindow().getStatusBarColor(), com.tencent.mm.ui.statusbar.d.c(getWindow()));
    }
    setMMTitle(R.l.contact_info_biz_more);
    oX(-16777216);
    com.tencent.mm.ui.s.czy();
    czo();
    mS(false);
    setBackBtn(new NewBizInfoMoreInofUI.1(this), R.k.actionbar_icon_dark_back);
    paramBundle = bk.pm(getIntent().getStringExtra("Contact_User"));
    String str1 = bk.pm(getIntent().getStringExtra("Contact_Alias"));
    int i = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
    int j = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
    String str2 = getIntent().getStringExtra("Contact_KWeibo");
    String str3 = getIntent().getStringExtra("Contact_KWeiboNick");
    au.Hx();
    this.dnp = com.tencent.mm.model.c.Fw().abl(paramBundle);
    if ((this.dnp == null) || ((int)this.dnp.dBe == 0) || (bk.pm(this.dnp.field_username).length() <= 0))
    {
      this.dnp = new ad();
      this.dnp.setUsername(paramBundle);
      this.dnp.cZ(str1);
      this.dnp.fi(i);
      this.dnp.dD(str2);
      this.dnp.fh(j);
      this.dnp.dn(str3);
    }
    for (;;)
    {
      this.mVy = com.tencent.mm.ai.f.kX(this.dnp.field_username);
      paramBundle = getIntent().getByteArrayExtra("Contact_customInfo");
      if (paramBundle == null) {
        paramBundle = null;
      }
      try
      {
        for (;;)
        {
          this.mWN = paramBundle;
          this.fhj = getIntent().getIntExtra("Contact_Scene", 9);
          this.mWV = getIntent().getBundleExtra("Contact_Ext_Args");
          initView();
          return;
          if (i == 0) {
            break;
          }
          this.dnp.fi(i);
          break;
          paramBundle = (sg)new sg().aH(paramBundle);
        }
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.NewBizInfoMoreInofUI", paramBundle, "", new Object[0]);
        }
      }
    }
  }
  
  public final int xj()
  {
    return R.o.newbizinfo_more_info_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI
 * JD-Core Version:    0.7.0.1
 */