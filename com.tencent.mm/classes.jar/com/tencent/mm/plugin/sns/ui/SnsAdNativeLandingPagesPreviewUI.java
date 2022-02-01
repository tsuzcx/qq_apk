package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class SnsAdNativeLandingPagesPreviewUI
  extends MMActivity
{
  private static String aJ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(98313);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      AppMethodBeat.o(98313);
      return "";
    }
    try
    {
      paramString1 = (String)bx.M(paramString1, paramString2).get(paramString3);
      AppMethodBeat.o(98313);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ae.e("SnsAdNativeLandingPagesPreviewUI", "getXmlValueByTag exp=" + paramString1.toString());
      AppMethodBeat.o(98313);
    }
    return "";
  }
  
  private static boolean h(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(98311);
    if ((!bu.isNullOrNil(paramString)) && (an.aBh(paramString)))
    {
      paramString = an.aBi(paramString);
      if (bu.isNullOrNil(paramString))
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
    if (i.aBm(paramString))
    {
      paramIntent.setClass(this, SnsAdNativeLandingPagesUI.class);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesPreviewUI", "openCanvas", "(Landroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesPreviewUI", "openCanvas", "(Landroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      if (paramIntent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false)) {
        overridePendingTransition(0, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(98312);
        return true;
        if (z.getIntExtra(paramIntent, "sns_landing_page_from_bonus", 0) > 0) {
          overridePendingTransition(2130772108, 2130771986);
        } else {
          overridePendingTransition(2130772144, 2130772141);
        }
      }
    }
    ae.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, ".concat(String.valueOf(paramString)));
    String str = aJ(paramString, "adxml", ".adxml.adActionLink");
    paramIntent = str;
    if (TextUtils.isEmpty(str))
    {
      ae.e("SnsAdNativeLandingPagesPreviewUI", "adActionLink is empty");
      paramIntent = aJ(paramString, "adxml", ".adxml.adCanvasInfo.shareWebUrl");
    }
    ae.i("SnsAdNativeLandingPagesPreviewUI", "jumpUrl=".concat(String.valueOf(paramIntent)));
    if (!TextUtils.isEmpty(paramIntent))
    {
      paramString = new Intent();
      paramString.putExtra("rawUrl", paramIntent);
      paramString.putExtra("showShare", true);
      d.b(this, "webview", ".ui.tools.WebViewUI", paramString);
      finish();
      overridePendingTransition(2130772144, 2130772141);
      AppMethodBeat.o(98312);
      return true;
    }
    AppMethodBeat.o(98312);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131495514;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98310);
    super.onCreate(paramBundle);
    an.aG(this);
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
    if (localIntent.hasExtra("sns_landing_pages_canvasid"))
    {
      i = 1;
      l = localIntent.getLongExtra("sns_landing_pages_pageid", 0L);
      str1 = localIntent.getStringExtra("sns_landing_pages_canvasid");
      str2 = localIntent.getStringExtra("sns_landing_pages_canvas_ext");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label298;
      }
      paramBundle = (Bundle)localObject;
      if (localIntent.getIntExtra("sns_landing_pages_no_store", 0) != 1)
      {
        if (i != 1) {
          break label285;
        }
        paramBundle = m.ebK().n(str1, str2, 0, 0);
        label126:
        localIntent.putExtra("sns_landing_pages_xml", paramBundle);
      }
      label135:
      if (!TextUtils.isEmpty(paramBundle)) {
        break label439;
      }
      localObject = findViewById(2131303535);
      ((View)localObject).setVisibility(0);
      paramBundle = new b.a();
      if ((i != 0) || (l <= 0L)) {
        break label321;
      }
      ae.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, pageId:%d", new Object[] { Long.valueOf(l) });
      paramBundle.hQF = new awh();
      paramBundle.hQG = new awi();
      paramBundle.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
      paramBundle.funcId = 1286;
      paramBundle = paramBundle.aDS();
      ((awh)paramBundle.hQD.hQJ).GNZ = l;
    }
    for (;;)
    {
      x.a(paramBundle, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(98309);
          this.val$progressBar.setVisibility(8);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            if (i == 1) {
              ae.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail canvas id %s, canvas ext %s, errType %d,errCode %s", new Object[] { str1, str2, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            }
          }
          m localm;
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
                ae.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail page id %d, errType %d,errCode %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              }
              if (i != 1) {
                break;
              }
              paramAnonymousn = ((bfg)paramAnonymousb.hQE.hQJ).GUl.fjO();
              ae.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo canvasid %s, canvasext %s, xml %s", new Object[] { str1, str2, paramAnonymousn });
            } while (TextUtils.isEmpty(paramAnonymousn));
            this.val$intent.putExtra("sns_landing_pages_xml", paramAnonymousn);
            if (!SnsAdNativeLandingPagesPreviewUI.j(this.val$intent, paramAnonymousn))
            {
              SnsAdNativeLandingPagesPreviewUI.this.finish();
              AppMethodBeat.o(98309);
              return 0;
            }
            SnsAdNativeLandingPagesPreviewUI.a(SnsAdNativeLandingPagesPreviewUI.this, this.val$intent, paramAnonymousn);
            localm = m.ebK();
            paramAnonymousb = str1;
            str = str2;
          } while ((TextUtils.isEmpty(paramAnonymousn)) || (TextUtils.isEmpty(paramAnonymousb)));
          if (!bu.isNullOrNil(str)) {}
          for (paramAnonymousString = paramAnonymousb + str;; paramAnonymousString = paramAnonymousb)
          {
            localm.AdC.put(paramAnonymousString, paramAnonymousn);
            paramAnonymousString = new aa();
            paramAnonymousString.field_canvasId = paramAnonymousb;
            paramAnonymousString.field_canvasXml = paramAnonymousn;
            paramAnonymousString.field_canvasExt = str;
            localm.AdB.a(paramAnonymousString);
            break;
            paramAnonymousString = (awi)paramAnonymousb.hQE.hQJ;
            ae.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(l), paramAnonymousString.GOa });
            if (TextUtils.isEmpty(paramAnonymousString.GOa)) {
              break;
            }
            this.val$intent.putExtra("sns_landing_pages_xml", paramAnonymousString.GOa);
            if (!SnsAdNativeLandingPagesPreviewUI.j(this.val$intent, paramAnonymousString.GOa))
            {
              SnsAdNativeLandingPagesPreviewUI.this.finish();
              AppMethodBeat.o(98309);
              return 0;
            }
            SnsAdNativeLandingPagesPreviewUI.a(SnsAdNativeLandingPagesPreviewUI.this, this.val$intent, paramAnonymousString.GOa);
            m.ebK().D(l, paramAnonymousString.GOa);
            break;
          }
        }
      }, false, this);
      AppMethodBeat.o(98310);
      return;
      i = 0;
      break;
      label285:
      paramBundle = m.ebK().q(l, 0, 0);
      break label126;
      label298:
      paramBundle = (Bundle)localObject;
      if (h(localIntent, (String)localObject)) {
        break label135;
      }
      finish();
      AppMethodBeat.o(98310);
      return;
      label321:
      if ((i != 1) || (bu.isNullOrNil(str1))) {
        break label421;
      }
      ae.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, canvasId:%s", new Object[] { str1 });
      paramBundle.hQF = new bff();
      paramBundle.hQG = new bfg();
      paramBundle.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
      paramBundle.funcId = 1890;
      paramBundle = paramBundle.aDS();
      bff localbff = (bff)paramBundle.hQD.hQJ;
      localbff.GUj = str1;
      localbff.GUk = str2;
    }
    label421:
    ae.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, or pageId!");
    finish();
    AppMethodBeat.o(98310);
    return;
    label439:
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