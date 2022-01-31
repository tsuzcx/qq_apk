package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.w;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m;
import com.tencent.mm.protocal.protobuf.afn;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class SnsAdNativeLandingPagesPreviewUI
  extends MMActivity
{
  private static boolean f(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(38609);
    if ((!bo.isNullOrNil(paramString)) && (ae.abl(paramString)))
    {
      paramString = ae.abm(paramString);
      if (bo.isNullOrNil(paramString))
      {
        AppMethodBeat.o(38609);
        return false;
      }
      paramIntent.putExtra("sns_landing_pages_xml", "");
      paramIntent.putExtra("sns_landing_pages_too_large_xml_path", paramString);
    }
    AppMethodBeat.o(38609);
    return true;
  }
  
  private boolean g(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(38610);
    if (i.abq(paramString))
    {
      paramIntent.setClass(this, SnsAdNativeLandingPagesUI.class);
      startActivity(paramIntent);
      finish();
      if (paramIntent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false)) {
        overridePendingTransition(0, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(38610);
        return true;
        overridePendingTransition(2131034266, 2131034263);
      }
    }
    ab.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, ".concat(String.valueOf(paramString)));
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
        overridePendingTransition(2131034266, 2131034263);
        AppMethodBeat.o(38610);
        return true;
      }
    }
    AppMethodBeat.o(38610);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130970794;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38608);
    super.onCreate(paramBundle);
    ae.ai(this);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      finish();
      AppMethodBeat.o(38608);
      return;
    }
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
        break label293;
      }
      paramBundle = (Bundle)localObject;
      if (localIntent.getIntExtra("sns_landing_pages_no_store", 0) != 1)
      {
        if (i != 1) {
          break label280;
        }
        paramBundle = m.csa().k(str1, str2, 0, 0);
        label124:
        localIntent.putExtra("sns_landing_pages_xml", paramBundle);
      }
      label133:
      if (!TextUtils.isEmpty(paramBundle)) {
        break label434;
      }
      localObject = findViewById(2131821246);
      ((View)localObject).setVisibility(0);
      paramBundle = new b.a();
      if ((i != 0) || (l <= 0L)) {
        break label316;
      }
      ab.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, pageId:%d", new Object[] { Long.valueOf(l) });
      paramBundle.fsX = new afn();
      paramBundle.fsY = new afo();
      paramBundle.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
      paramBundle.funcId = 1286;
      paramBundle = paramBundle.ado();
      ((afn)paramBundle.fsV.fta).wYK = l;
    }
    for (;;)
    {
      w.a(paramBundle, new SnsAdNativeLandingPagesPreviewUI.1(this, (View)localObject, i, str1, str2, l, localIntent), false, this);
      AppMethodBeat.o(38608);
      return;
      i = 0;
      break;
      label280:
      paramBundle = m.csa().m(l, 0, 0);
      break label124;
      label293:
      paramBundle = (Bundle)localObject;
      if (f(localIntent, (String)localObject)) {
        break label133;
      }
      finish();
      AppMethodBeat.o(38608);
      return;
      label316:
      if ((i != 1) || (bo.isNullOrNil(str1))) {
        break label416;
      }
      ab.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, canvasId:%s", new Object[] { str1 });
      paramBundle.fsX = new amq();
      paramBundle.fsY = new amr();
      paramBundle.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
      paramBundle.funcId = 1890;
      paramBundle = paramBundle.ado();
      amq localamq = (amq)paramBundle.fsV.fta;
      localamq.xdo = str1;
      localamq.xdp = str2;
    }
    label416:
    ab.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, or pageId!");
    finish();
    AppMethodBeat.o(38608);
    return;
    label434:
    if (g(localIntent, paramBundle))
    {
      AppMethodBeat.o(38608);
      return;
    }
    finish();
    AppMethodBeat.o(38608);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesPreviewUI
 * JD-Core Version:    0.7.0.1
 */