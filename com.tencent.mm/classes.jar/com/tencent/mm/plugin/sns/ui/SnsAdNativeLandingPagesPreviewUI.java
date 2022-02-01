package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.byy;
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
  private int JCO;
  
  private static String aO(String paramString1, String paramString2, String paramString3)
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
  
  private static boolean h(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(98311);
    if ((!Util.isNullOrNil(paramString)) && (ao.bba(paramString)))
    {
      paramString = ao.bbb(paramString);
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
  
  private boolean i(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(98312);
    Object localObject = paramIntent.getStringExtra("sns_landing_pages_extra_param");
    if (com.tencent.mm.plugin.sns.ad.h.a.aeP(this.JCO)) {
      com.tencent.mm.plugin.sns.ad.h.a.fU((String)localObject, 6);
    }
    if (i.bbf(paramString))
    {
      if (com.tencent.mm.plugin.sns.ad.h.a.aeP(this.JCO)) {
        com.tencent.mm.plugin.sns.ad.h.a.fU((String)localObject, 7);
      }
      paramIntent.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
      paramIntent.setClass(this, SnsAdNativeLandingPagesUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesPreviewUI", "openCanvas", "(Landroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
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
        } else if (IntentUtil.getIntExtra(paramIntent, "sns_landing_page_from_bonus", 0) > 0) {
          overridePendingTransition(i.a.push_up_in, i.a.anim_not_change);
        } else {
          overridePendingTransition(i.a.slide_right_in, i.a.slide_left_out);
        }
      }
    }
    Log.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, ".concat(String.valueOf(paramString)));
    localObject = aO(paramString, "adxml", ".adxml.adActionLink");
    paramIntent = (Intent)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Log.e("SnsAdNativeLandingPagesPreviewUI", "adActionLink is empty");
      paramIntent = aO(paramString, "adxml", ".adxml.adCanvasInfo.shareWebUrl");
    }
    Log.i("SnsAdNativeLandingPagesPreviewUI", "jumpUrl=".concat(String.valueOf(paramIntent)));
    if (!TextUtils.isEmpty(paramIntent))
    {
      paramString = new Intent();
      paramString.putExtra("rawUrl", paramIntent);
      paramString.putExtra("showShare", true);
      com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", paramString);
      finish();
      overridePendingTransition(i.a.slide_right_in, i.a.slide_left_out);
      AppMethodBeat.o(98312);
      return true;
    }
    AppMethodBeat.o(98312);
    return false;
  }
  
  public int getLayoutId()
  {
    return i.g.sns_ad_native_landing_pages_preview_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98310);
    super.onCreate(paramBundle);
    ao.aQ(this);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      finish();
      AppMethodBeat.o(98310);
      return;
    }
    Object localObject1 = localIntent.getStringExtra("sns_landing_pages_xml");
    final int i;
    final long l;
    final String str1;
    final String str2;
    label165:
    label174:
    Object localObject2;
    if (localIntent.hasExtra("sns_landing_pages_canvasid"))
    {
      i = 1;
      l = localIntent.getLongExtra("sns_landing_pages_pageid", 0L);
      str1 = localIntent.getStringExtra("sns_landing_pages_canvasid");
      str2 = localIntent.getStringExtra("sns_landing_pages_canvas_ext");
      this.JCO = localIntent.getIntExtra("sns_landig_pages_from_source", 0);
      if (com.tencent.mm.plugin.sns.ad.h.a.aeP(this.JCO)) {
        com.tencent.mm.plugin.sns.ad.h.a.fU(localIntent.getStringExtra("sns_landing_pages_extra_param"), 5);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label398;
      }
      paramBundle = (Bundle)localObject1;
      if (localIntent.getIntExtra("sns_landing_pages_no_store", 0) != 1)
      {
        if (i != 1) {
          break label385;
        }
        paramBundle = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.fSv().n(str1, str2, 0, 0);
        localIntent.putExtra("sns_landing_pages_xml", paramBundle);
      }
      if (!TextUtils.isEmpty(paramBundle)) {
        break label541;
      }
      localObject1 = findViewById(i.f.progressbar);
      ((View)localObject1).setVisibility(0);
      paramBundle = new d.a();
      if ((i != 0) || (l <= 0L)) {
        break label422;
      }
      localObject2 = com.tencent.mm.plugin.sns.data.m.aZa(localIntent.getStringExtra("sns_landing_pages_ad_info"));
      Log.i("SnsAdNativeLandingPagesPreviewUI", "GetAdCanvasInfoReq, pageId=" + l + ", source=" + this.JCO + ", uxInfo=" + (String)localObject2);
      paramBundle.lBU = new bpc();
      paramBundle.lBV = new bpd();
      paramBundle.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
      paramBundle.funcId = 1286;
      paramBundle = paramBundle.bgN();
      bpc localbpc = (bpc)d.b.b(paramBundle.lBR);
      localbpc.jDF = l;
      localbpc.uxInfo = ((String)localObject2);
      localbpc.enterScene = this.JCO;
    }
    for (;;)
    {
      aa.a(paramBundle, new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(98309);
          this.val$progressBar.setVisibility(8);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            if (i == 1) {
              Log.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail canvas id %s, canvas ext %s, errType %d,errCode %s", new Object[] { str1, str2, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            }
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m localm;
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
              paramAnonymousq = ((byy)d.c.b(paramAnonymousd.lBS)).ThX.Ap();
              Log.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo canvasid %s, canvasext %s, xml %s", new Object[] { str1, str2, paramAnonymousq });
            } while (TextUtils.isEmpty(paramAnonymousq));
            this.val$intent.putExtra("sns_landing_pages_xml", paramAnonymousq);
            if (!SnsAdNativeLandingPagesPreviewUI.j(this.val$intent, paramAnonymousq))
            {
              SnsAdNativeLandingPagesPreviewUI.this.finish();
              AppMethodBeat.o(98309);
              return 0;
            }
            SnsAdNativeLandingPagesPreviewUI.a(SnsAdNativeLandingPagesPreviewUI.this, this.val$intent, paramAnonymousq);
            localm = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.fSv();
            paramAnonymousd = str1;
            str = str2;
          } while ((TextUtils.isEmpty(paramAnonymousq)) || (TextUtils.isEmpty(paramAnonymousd)));
          if (!Util.isNullOrNil(str)) {}
          for (paramAnonymousString = paramAnonymousd + str;; paramAnonymousString = paramAnonymousd)
          {
            localm.Kzh.put(paramAnonymousString, paramAnonymousq);
            paramAnonymousString = new ab();
            paramAnonymousString.field_canvasId = paramAnonymousd;
            paramAnonymousString.field_canvasXml = paramAnonymousq;
            paramAnonymousString.field_canvasExt = str;
            localm.Kzg.a(paramAnonymousString);
            break;
            paramAnonymousString = (bpd)d.c.b(paramAnonymousd.lBS);
            Log.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(l), paramAnonymousString.TaQ });
            if (TextUtils.isEmpty(paramAnonymousString.TaQ)) {
              break;
            }
            this.val$intent.putExtra("sns_landing_pages_xml", paramAnonymousString.TaQ);
            if (!SnsAdNativeLandingPagesPreviewUI.j(this.val$intent, paramAnonymousString.TaQ))
            {
              SnsAdNativeLandingPagesPreviewUI.this.finish();
              AppMethodBeat.o(98309);
              return 0;
            }
            SnsAdNativeLandingPagesPreviewUI.a(SnsAdNativeLandingPagesPreviewUI.this, this.val$intent, paramAnonymousString.TaQ);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.fSv().R(l, paramAnonymousString.TaQ);
            break;
          }
        }
      }, false, this);
      AppMethodBeat.o(98310);
      return;
      i = 0;
      break;
      label385:
      paramBundle = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.fSv().q(l, 0, 0);
      break label165;
      label398:
      paramBundle = (Bundle)localObject1;
      if (h(localIntent, (String)localObject1)) {
        break label174;
      }
      finish();
      AppMethodBeat.o(98310);
      return;
      label422:
      if ((i != 1) || (Util.isNullOrNil(str1))) {
        break label522;
      }
      Log.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, canvasId:%s", new Object[] { str1 });
      paramBundle.lBU = new byx();
      paramBundle.lBV = new byy();
      paramBundle.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
      paramBundle.funcId = 1890;
      paramBundle = paramBundle.bgN();
      localObject2 = (byx)d.b.b(paramBundle.lBR);
      ((byx)localObject2).RHW = str1;
      ((byx)localObject2).ThW = str2;
    }
    label522:
    Log.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, or pageId!");
    finish();
    AppMethodBeat.o(98310);
    return;
    label541:
    if (i(localIntent, paramBundle))
    {
      AppMethodBeat.o(98310);
      return;
    }
    finish();
    AppMethodBeat.o(98310);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesPreviewUI
 * JD-Core Version:    0.7.0.1
 */