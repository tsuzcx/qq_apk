package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.sns.ad.adxml.d;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.r;
import com.tencent.mm.plugin.sns.storage.al;
import com.tencent.mm.plugin.sns.storage.am;
import com.tencent.mm.protocal.protobuf.cdt;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class SnsAdNativeLandingPagesPreviewUI
  extends MMActivity
{
  private int xOq;
  
  private static String bg(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(98313);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      AppMethodBeat.o(98313);
      return "";
    }
    try
    {
      paramString1 = (String)XmlParser.parseXml(paramString1, paramString2, null).get(paramString3);
      AppMethodBeat.o(98313);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.e("SnsAdNativeLandingPagesPreviewUI", "getXmlValueByTag exp=" + paramString1.toString());
      AppMethodBeat.o(98313);
    }
    return "";
  }
  
  private static boolean j(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(98311);
    if ((!Util.isNullOrNil(paramString)) && (ar.aZB(paramString)))
    {
      paramString = ar.aZC(paramString);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(98311);
        return false;
      }
      paramIntent.putExtra("sns_landing_pages_xml", "");
      paramIntent.putExtra("sns_landing_pages_too_large_xml_path", paramString);
    }
    AppMethodBeat.o(98311);
    return true;
  }
  
  private boolean k(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(98312);
    Object localObject = paramIntent.getStringExtra("sns_landing_pages_extra_param");
    if (com.tencent.mm.plugin.sns.ad.i.a.ajx(this.xOq)) {
      com.tencent.mm.plugin.sns.ad.i.a.gN((String)localObject, 6);
    }
    if (l.aZJ(paramString))
    {
      if (com.tencent.mm.plugin.sns.ad.i.a.ajx(this.xOq)) {
        com.tencent.mm.plugin.sns.ad.i.a.gN((String)localObject, 7);
      }
      paramIntent.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
      paramIntent.setClass(this, SnsAdNativeLandingPagesUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesPreviewUI", "openCanvas", "(Landroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesPreviewUI", "openCanvas", "(Landroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      if (paramIntent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false)) {
        overridePendingTransition(0, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(98312);
        return true;
        if (ADXml.isTwistAdCanvas(paramString)) {
          overridePendingTransition(0, 0);
        } else if (ADXml.isShakeAdCanvas(paramString)) {
          overridePendingTransition(0, 0);
        } else if (ADXml.isSimpleSharedShakeAd(paramString)) {
          overridePendingTransition(0, 0);
        } else if (d.aWh(paramString)) {
          overridePendingTransition(0, 0);
        } else if (IntentUtil.getIntExtra(paramIntent, "sns_landing_page_from_bonus", 0) > 0) {
          overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
        } else {
          overridePendingTransition(b.a.slide_right_in, b.a.slide_left_out);
        }
      }
    }
    Log.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, ".concat(String.valueOf(paramString)));
    try
    {
      localObject = bg(paramString, "adxml", ".adxml.adCanvasInfo.shareWebUrl");
      paramIntent = (Intent)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        Log.e("SnsAdNativeLandingPagesPreviewUI", "shareWebUrl is empty");
        paramIntent = bg(paramString, "adxml", ".adxml.adActionLink");
      }
      paramString = bg(paramString, "adxml", ".adxml.originUxInfo");
      Log.i("SnsAdNativeLandingPagesPreviewUI", "jumpUrl=" + paramIntent + ", uxInfo=" + paramString);
      paramIntent = t.lY(paramIntent, paramString);
      if (!TextUtils.isEmpty(paramIntent))
      {
        Log.i("SnsAdNativeLandingPagesPreviewUI", "jump WebViewUI, url=".concat(String.valueOf(paramIntent)));
        paramString = new Intent();
        paramString.putExtra("rawUrl", paramIntent);
        paramString.putExtra("showShare", true);
        com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramString);
        finish();
        overridePendingTransition(b.a.slide_right_in, b.a.slide_left_out);
        AppMethodBeat.o(98312);
        return true;
      }
    }
    finally
    {
      Log.i("SnsAdNativeLandingPagesPreviewUI", "jump WebViewUI exp=" + paramIntent.toString());
      AppMethodBeat.o(98312);
    }
    return false;
  }
  
  public int getLayoutId()
  {
    return b.g.sns_ad_native_landing_pages_preview_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98310);
    super.onCreate(paramBundle);
    ar.bs(this);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      finish();
      AppMethodBeat.o(98310);
      return;
    }
    Object localObject = localIntent.getStringExtra("sns_landing_pages_xml");
    final int i;
    final long l;
    final String str1;
    final String str2;
    label165:
    label174:
    final View localView;
    if (localIntent.hasExtra("sns_landing_pages_canvasid"))
    {
      i = 1;
      l = localIntent.getLongExtra("sns_landing_pages_pageid", 0L);
      str1 = localIntent.getStringExtra("sns_landing_pages_canvasid");
      str2 = localIntent.getStringExtra("sns_landing_pages_canvas_ext");
      this.xOq = localIntent.getIntExtra("sns_landig_pages_from_source", 0);
      if (com.tencent.mm.plugin.sns.ad.i.a.ajx(this.xOq)) {
        com.tencent.mm.plugin.sns.ad.i.a.gN(localIntent.getStringExtra("sns_landing_pages_extra_param"), 5);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label450;
      }
      paramBundle = (Bundle)localObject;
      if (localIntent.getIntExtra("sns_landing_pages_no_store", 0) != 1)
      {
        if (i != 1) {
          break label437;
        }
        paramBundle = r.hkH().r(str1, str2, 0, 0);
        localIntent.putExtra("sns_landing_pages_xml", paramBundle);
      }
      if (!TextUtils.isEmpty(paramBundle)) {
        break label598;
      }
      localView = findViewById(b.f.progressbar);
      localView.setVisibility(0);
      localObject = new c.a();
      if ((i != 0) || (l <= 0L)) {
        break label474;
      }
      paramBundle = m.aXl(localIntent.getStringExtra("sns_landing_pages_ad_info"));
      if (!TextUtils.isEmpty(paramBundle)) {
        break label626;
      }
      Log.w("SnsAdNativeLandingPagesPreviewUI", "parse uxinfo from adinfoxml failed, source=" + this.xOq);
      paramBundle = Util.nullAsNil(localIntent.getStringExtra("sns_landing_pages_ux_info"));
    }
    label437:
    label450:
    label474:
    label626:
    for (;;)
    {
      Log.i("SnsAdNativeLandingPagesPreviewUI", "GetAdCanvasInfoReq, pageId=" + l + ", source=" + this.xOq + ", uxInfo=" + paramBundle);
      ((c.a)localObject).otE = new cdt();
      ((c.a)localObject).otF = new cdu();
      ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
      ((c.a)localObject).funcId = 1286;
      localObject = ((c.a)localObject).bEF();
      cdt localcdt = (cdt)c.b.b(((com.tencent.mm.am.c)localObject).otB);
      localcdt.mdA = l;
      localcdt.uxInfo = paramBundle;
      localcdt.enterScene = this.xOq;
      paramBundle = (Bundle)localObject;
      for (;;)
      {
        z.a(paramBundle, new z.a()
        {
          public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
          {
            AppMethodBeat.i(98309);
            localView.setVisibility(8);
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              if (i == 1) {
                Log.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail canvas id %s, canvas ext %s, errType %d,errCode %s", new Object[] { str1, str2, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              }
            }
            r localr;
            String str;
            do
            {
              do
              {
                for (;;)
                {
                  SnsAdNativeLandingPagesPreviewUI.this.finish();
                  AppMethodBeat.o(98309);
                  return 0;
                  Log.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail page id %d, errType %d,errCode %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                }
                if (i != 1) {
                  break;
                }
                paramAnonymousp = ((cob)c.c.b(paramAnonymousc.otC)).aavn.ZV();
                Log.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo canvasid %s, canvasext %s, xml %s", new Object[] { str1, str2, paramAnonymousp });
              } while (TextUtils.isEmpty(paramAnonymousp));
              this.val$intent.putExtra("sns_landing_pages_xml", paramAnonymousp);
              if (!SnsAdNativeLandingPagesPreviewUI.l(this.val$intent, paramAnonymousp))
              {
                SnsAdNativeLandingPagesPreviewUI.this.finish();
                AppMethodBeat.o(98309);
                return 0;
              }
              SnsAdNativeLandingPagesPreviewUI.a(SnsAdNativeLandingPagesPreviewUI.this, this.val$intent, paramAnonymousp);
              localr = r.hkH();
              paramAnonymousc = str1;
              str = str2;
            } while ((TextUtils.isEmpty(paramAnonymousp)) || (TextUtils.isEmpty(paramAnonymousc)));
            if (!Util.isNullOrNil(str)) {}
            for (paramAnonymousString = paramAnonymousc + str;; paramAnonymousString = paramAnonymousc)
            {
              localr.QXZ.put(paramAnonymousString, paramAnonymousp);
              paramAnonymousString = new al();
              paramAnonymousString.field_canvasId = paramAnonymousc;
              paramAnonymousString.field_canvasXml = paramAnonymousp;
              paramAnonymousString.field_canvasExt = str;
              localr.QXY.a(paramAnonymousString);
              break;
              paramAnonymousString = (cdu)c.c.b(paramAnonymousc.otC);
              Log.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(l), paramAnonymousString.aaoc });
              if (TextUtils.isEmpty(paramAnonymousString.aaoc)) {
                break;
              }
              this.val$intent.putExtra("sns_landing_pages_xml", paramAnonymousString.aaoc);
              if (!SnsAdNativeLandingPagesPreviewUI.l(this.val$intent, paramAnonymousString.aaoc))
              {
                SnsAdNativeLandingPagesPreviewUI.this.finish();
                AppMethodBeat.o(98309);
                return 0;
              }
              SnsAdNativeLandingPagesPreviewUI.a(SnsAdNativeLandingPagesPreviewUI.this, this.val$intent, paramAnonymousString.aaoc);
              r.hkH().ag(l, paramAnonymousString.aaoc);
              break;
            }
          }
        }, false, this);
        AppMethodBeat.o(98310);
        return;
        i = 0;
        break;
        paramBundle = r.hkH().y(l, 0, 0);
        break label165;
        paramBundle = (Bundle)localObject;
        if (j(localIntent, (String)localObject)) {
          break label174;
        }
        finish();
        AppMethodBeat.o(98310);
        return;
        if ((i != 1) || (Util.isNullOrNil(str1))) {
          break label579;
        }
        Log.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, canvasId:%s", new Object[] { str1 });
        ((c.a)localObject).otE = new coa();
        ((c.a)localObject).otF = new cob();
        ((c.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
        ((c.a)localObject).funcId = 1890;
        paramBundle = ((c.a)localObject).bEF();
        localObject = (coa)c.b.b(paramBundle.otB);
        ((coa)localObject).YEY = str1;
        ((coa)localObject).aavm = str2;
      }
      Log.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, or pageId!");
      finish();
      AppMethodBeat.o(98310);
      return;
      if (k(localIntent, paramBundle))
      {
        AppMethodBeat.o(98310);
        return;
      }
      finish();
      AppMethodBeat.o(98310);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesPreviewUI
 * JD-Core Version:    0.7.0.1
 */