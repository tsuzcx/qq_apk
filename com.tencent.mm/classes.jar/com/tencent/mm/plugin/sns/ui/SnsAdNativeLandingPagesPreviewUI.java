package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m;
import com.tencent.mm.protocal.c.aav;
import com.tencent.mm.protocal.c.aaw;
import com.tencent.mm.protocal.c.ahp;
import com.tencent.mm.protocal.c.ahq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class SnsAdNativeLandingPagesPreviewUI
  extends MMActivity
{
  private static boolean f(Intent paramIntent, String paramString)
  {
    if ((!bk.bl(paramString)) && (ad.Os(paramString)))
    {
      paramString = ad.Ot(paramString);
      if (bk.bl(paramString)) {
        return false;
      }
      paramIntent.putExtra("sns_landing_pages_xml", "");
      paramIntent.putExtra("sns_landing_pages_too_large_xml_path", paramString);
    }
    return true;
  }
  
  private boolean g(Intent paramIntent, String paramString)
  {
    if (i.Ow(paramString))
    {
      paramIntent.setClass(this, SnsAdNativeLandingPagesUI.class);
      startActivity(paramIntent);
      finish();
      if (paramIntent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false))
      {
        overridePendingTransition(0, 0);
        return true;
      }
      overridePendingTransition(i.a.slide_right_in, i.a.slide_left_out);
      return true;
    }
    y.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, " + paramString);
    int i = paramString.indexOf("<shareWebUrl>");
    if (i >= 0)
    {
      int j = paramString.indexOf("</shareWebUrl>");
      if (j > i + 13)
      {
        paramIntent = paramString.substring(i + 13, j);
        paramString = new Intent();
        paramString.putExtra("rawUrl", paramIntent);
        paramString.putExtra("showShare", true);
        d.b(this, "webview", ".ui.tools.WebViewUI", paramString);
        finish();
        overridePendingTransition(i.a.slide_right_in, i.a.slide_left_out);
        return true;
      }
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_ad_native_landing_pages_preview_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ad.N(this);
    Intent localIntent = getIntent();
    if (localIntent == null) {
      finish();
    }
    label114:
    label123:
    do
    {
      return;
      Object localObject = localIntent.getStringExtra("sns_landing_pages_xml");
      int i;
      long l;
      String str1;
      String str2;
      if (localIntent.hasExtra("sns_landing_pages_canvasid"))
      {
        i = 1;
        l = localIntent.getLongExtra("sns_landing_pages_pageid", 0L);
        str1 = localIntent.getStringExtra("sns_landing_pages_canvasid");
        str2 = localIntent.getStringExtra("sns_landing_pages_canvas_ext");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label277;
        }
        paramBundle = (Bundle)localObject;
        if (localIntent.getIntExtra("sns_landing_pages_no_store", 0) != 1)
        {
          if (i != 1) {
            break label264;
          }
          paramBundle = m.bFY().k(str1, str2, 0, 0);
          localIntent.putExtra("sns_landing_pages_xml", paramBundle);
        }
        if (!TextUtils.isEmpty(paramBundle)) {
          continue;
        }
        localObject = findViewById(i.f.progressbar);
        ((View)localObject).setVisibility(0);
        paramBundle = new b.a();
        if ((i != 0) || (l <= 0L)) {
          break label295;
        }
        y.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, pageId:%d", new Object[] { Long.valueOf(l) });
        paramBundle.ecH = new aav();
        paramBundle.ecI = new aaw();
        paramBundle.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
        paramBundle.ecG = 1286;
        paramBundle = paramBundle.Kt();
        ((aav)paramBundle.ecE.ecN).tat = l;
      }
      for (;;)
      {
        w.a(paramBundle, new SnsAdNativeLandingPagesPreviewUI.1(this, (View)localObject, i, str1, str2, l, localIntent));
        return;
        i = 0;
        break;
        paramBundle = m.bFY().i(l, 0, 0);
        break label114;
        paramBundle = (Bundle)localObject;
        if (f(localIntent, (String)localObject)) {
          break label123;
        }
        finish();
        return;
        if ((i != 1) || (bk.bl(str1))) {
          break label395;
        }
        y.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, canvasId:%s", new Object[] { str1 });
        paramBundle.ecH = new ahp();
        paramBundle.ecI = new ahq();
        paramBundle.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
        paramBundle.ecG = 1890;
        paramBundle = paramBundle.Kt();
        ahp localahp = (ahp)paramBundle.ecE.ecN;
        localahp.tfd = str1;
        localahp.tfe = str2;
      }
      y.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, or pageId!");
      finish();
      return;
    } while (g(localIntent, paramBundle));
    label264:
    label277:
    label295:
    finish();
    label395:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesPreviewUI
 * JD-Core Version:    0.7.0.1
 */