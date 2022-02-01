package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.bhs;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class SnsAdNativeLandingPagesPreviewUI
  extends MMActivity
{
  private static String aU(String paramString1, String paramString2, String paramString3)
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
  
  private static boolean i(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(98311);
    if ((!Util.isNullOrNil(paramString)) && (ap.aQb(paramString)))
    {
      paramString = ap.aQc(paramString);
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
  
  private boolean j(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(98312);
    if (i.aQg(paramString))
    {
      paramIntent.setClass(this, SnsAdNativeLandingPagesUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesPreviewUI", "openCanvas", "(Landroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesPreviewUI", "openCanvas", "(Landroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      if (paramIntent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false)) {
        overridePendingTransition(0, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(98312);
        return true;
        if (ADXml.k.aPT(paramString)) {
          overridePendingTransition(0, 0);
        } else if (IntentUtil.getIntExtra(paramIntent, "sns_landing_page_from_bonus", 0) > 0) {
          overridePendingTransition(2130772132, 2130771986);
        } else {
          overridePendingTransition(2130772169, 2130772166);
        }
      }
    }
    Log.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, ".concat(String.valueOf(paramString)));
    Object localObject = aU(paramString, "adxml", ".adxml.adActionLink");
    paramIntent = (Intent)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Log.e("SnsAdNativeLandingPagesPreviewUI", "adActionLink is empty");
      paramIntent = aU(paramString, "adxml", ".adxml.adCanvasInfo.shareWebUrl");
    }
    Log.i("SnsAdNativeLandingPagesPreviewUI", "jumpUrl=".concat(String.valueOf(paramIntent)));
    if (!TextUtils.isEmpty(paramIntent))
    {
      paramString = new Intent();
      paramString.putExtra("rawUrl", paramIntent);
      paramString.putExtra("showShare", true);
      c.b(this, "webview", ".ui.tools.WebViewUI", paramString);
      finish();
      overridePendingTransition(2130772169, 2130772166);
      AppMethodBeat.o(98312);
      return true;
    }
    AppMethodBeat.o(98312);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131496400;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98310);
    super.onCreate(paramBundle);
    ap.aK(this);
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
        paramBundle = m.feB().n(str1, str2, 0, 0);
        label126:
        localIntent.putExtra("sns_landing_pages_xml", paramBundle);
      }
      label135:
      if (!TextUtils.isEmpty(paramBundle)) {
        break label439;
      }
      localObject = findViewById(2131306302);
      ((View)localObject).setVisibility(0);
      paramBundle = new d.a();
      if ((i != 0) || (l <= 0L)) {
        break label321;
      }
      Log.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, pageId:%d", new Object[] { Long.valueOf(l) });
      paramBundle.iLN = new bhr();
      paramBundle.iLO = new bhs();
      paramBundle.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
      paramBundle.funcId = 1286;
      paramBundle = paramBundle.aXF();
      ((bhr)paramBundle.iLK.iLR).gTg = l;
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
                Log.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail page id %d, errType %d,errCode %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              }
              if (i != 1) {
                break;
              }
              paramAnonymousq = ((brc)paramAnonymousd.iLL.iLR).LYD.yO();
              Log.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo canvasid %s, canvasext %s, xml %s", new Object[] { str1, str2, paramAnonymousq });
            } while (TextUtils.isEmpty(paramAnonymousq));
            this.val$intent.putExtra("sns_landing_pages_xml", paramAnonymousq);
            if (!SnsAdNativeLandingPagesPreviewUI.k(this.val$intent, paramAnonymousq))
            {
              SnsAdNativeLandingPagesPreviewUI.this.finish();
              AppMethodBeat.o(98309);
              return 0;
            }
            SnsAdNativeLandingPagesPreviewUI.a(SnsAdNativeLandingPagesPreviewUI.this, this.val$intent, paramAnonymousq);
            localm = m.feB();
            paramAnonymousd = str1;
            str = str2;
          } while ((TextUtils.isEmpty(paramAnonymousq)) || (TextUtils.isEmpty(paramAnonymousd)));
          if (!Util.isNullOrNil(str)) {}
          for (paramAnonymousString = paramAnonymousd + str;; paramAnonymousString = paramAnonymousd)
          {
            localm.ElZ.put(paramAnonymousString, paramAnonymousq);
            paramAnonymousString = new ab();
            paramAnonymousString.field_canvasId = paramAnonymousd;
            paramAnonymousString.field_canvasXml = paramAnonymousq;
            paramAnonymousString.field_canvasExt = str;
            localm.ElY.a(paramAnonymousString);
            break;
            paramAnonymousString = (bhs)paramAnonymousd.iLL.iLR;
            Log.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(l), paramAnonymousString.LSf });
            if (TextUtils.isEmpty(paramAnonymousString.LSf)) {
              break;
            }
            this.val$intent.putExtra("sns_landing_pages_xml", paramAnonymousString.LSf);
            if (!SnsAdNativeLandingPagesPreviewUI.k(this.val$intent, paramAnonymousString.LSf))
            {
              SnsAdNativeLandingPagesPreviewUI.this.finish();
              AppMethodBeat.o(98309);
              return 0;
            }
            SnsAdNativeLandingPagesPreviewUI.a(SnsAdNativeLandingPagesPreviewUI.this, this.val$intent, paramAnonymousString.LSf);
            m.feB().J(l, paramAnonymousString.LSf);
            break;
          }
        }
      }, false, this);
      AppMethodBeat.o(98310);
      return;
      i = 0;
      break;
      label285:
      paramBundle = m.feB().p(l, 0, 0);
      break label126;
      label298:
      paramBundle = (Bundle)localObject;
      if (i(localIntent, (String)localObject)) {
        break label135;
      }
      finish();
      AppMethodBeat.o(98310);
      return;
      label321:
      if ((i != 1) || (Util.isNullOrNil(str1))) {
        break label421;
      }
      Log.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, canvasId:%s", new Object[] { str1 });
      paramBundle.iLN = new brb();
      paramBundle.iLO = new brc();
      paramBundle.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
      paramBundle.funcId = 1890;
      paramBundle = paramBundle.aXF();
      brb localbrb = (brb)paramBundle.iLK.iLR;
      localbrb.LYB = str1;
      localbrb.LYC = str2;
    }
    label421:
    Log.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, or pageId!");
    finish();
    AppMethodBeat.o(98310);
    return;
    label439:
    if (j(localIntent, paramBundle))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesPreviewUI
 * JD-Core Version:    0.7.0.1
 */