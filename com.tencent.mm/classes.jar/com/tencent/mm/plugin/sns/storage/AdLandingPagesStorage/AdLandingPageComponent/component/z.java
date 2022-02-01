package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class z
  extends q
{
  public z(Context paramContext, m paramm, ViewGroup paramViewGroup)
  {
    super(paramContext, paramm, paramViewGroup);
    AppMethodBeat.i(96660);
    this.KqQ.kQ("canvasId", paramm.Klw);
    this.KqQ.kQ("canvasExt", paramm.Klx);
    AppMethodBeat.o(96660);
  }
  
  private boolean fRx()
  {
    AppMethodBeat.i(96662);
    if (((m)this.KqB).Klz == 1)
    {
      AppMethodBeat.o(96662);
      return true;
    }
    AppMethodBeat.o(96662);
    return false;
  }
  
  private boolean fRy()
  {
    AppMethodBeat.i(96663);
    if (((m)this.KqB).KlA == 1)
    {
      AppMethodBeat.o(96663);
      return true;
    }
    AppMethodBeat.o(96663);
    return false;
  }
  
  protected final void fRb()
  {
    AppMethodBeat.i(96661);
    Object localObject2 = (m)this.KqB;
    if (this.KqU) {}
    for (int i = 20;; i = 14)
    {
      Context localContext = this.context;
      Object localObject1 = ((m)localObject2).Klw;
      String str1 = ((m)localObject2).Klx;
      int j = ((m)localObject2).Kly;
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("sns_landig_pages_from_source", i);
      ((Intent)localObject2).putExtra("sns_landig_pages_origin_from_source", fRp().Knp);
      ((Intent)localObject2).putExtra("sns_landing_pages_xml", "");
      String str3;
      String str2;
      JSONObject localJSONObject;
      if (fRy())
      {
        ((Intent)localObject2).putExtra("sns_landing_pages_canvasid", (String)localObject1);
        ((Intent)localObject2).putExtra("sns_landing_pages_canvas_ext", str1);
        if (fRx())
        {
          localObject1 = new int[2];
          this.KqS.getLocationOnScreen((int[])localObject1);
          ((Intent)localObject2).putExtra("img_gallery_top", localObject1[1]);
          ((Intent)localObject2).putExtra("img_gallery_left", localObject1[0]);
          ((Intent)localObject2).putExtra("img_gallery_width", this.KqS.getWidth());
          ((Intent)localObject2).putExtra("img_gallery_height", this.KqS.getHeight());
        }
        ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", fRx());
        ((Intent)localObject2).putExtra("sns_landing_pages_extra", "");
        ((Intent)localObject2).putExtra("sns_landing_pages_no_store", j);
        ((Intent)localObject2).putExtra("sns_landing_pages_ux_info", fRp().uxInfo);
        ((Intent)localObject2).putExtra("sns_landing_is_native_sight_ad", fRp().Knq);
        if (((localContext instanceof Activity)) && (fRy()) && (fRp().bizId == 2))
        {
          str3 = ((Activity)localContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
          str1 = ((Activity)localContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
          if (!Util.isNullOrNil(str3))
          {
            str2 = String.valueOf(System.currentTimeMillis() / 1000L);
            localJSONObject = new JSONObject();
          }
        }
      }
      for (;;)
      {
        try
        {
          localJSONObject.put("sessionId", str2);
          localJSONObject.put("cid", ((r)this.KqB).KmB);
          if (Util.isNullOrNil(str1)) {
            continue;
          }
          localObject1 = str1;
          localJSONObject.put("adBuffer", localObject1);
          localJSONObject.put("preSessionId", str3);
        }
        catch (Exception localException)
        {
          continue;
        }
        ((Intent)localObject2).putExtra("sns_landing_pages_search_extra", localJSONObject.toString());
        ((Intent)localObject2).putExtra("sns_landing_pages_sessionId", str2);
        ((Intent)localObject2).putExtra("sns_landing_pages_ad_buffer", str1);
        if ((localContext instanceof Activity))
        {
          localObject1 = ((Activity)localContext).getIntent().getStringExtra("sns_landing_pages_rawSnsId");
          str1 = ((Activity)localContext).getIntent().getStringExtra("sns_landing_pages_share_sns_id");
          ((Intent)localObject2).putExtra("sns_landing_pages_rawSnsId", (String)localObject1);
          ((Intent)localObject2).putExtra("sns_landing_pages_share_sns_id", str1);
        }
        if ((this.KqV) && ((localContext instanceof Activity))) {
          ((Intent)localObject2).putExtra("sns_landing_page_from_bonus", 1);
        }
        c.b(localContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject2);
        fRu();
        fRc();
        AppMethodBeat.o(96661);
        return;
        ((Intent)localObject2).putExtra("sns_landing_pages_pageid", Util.safeParseLong((String)localObject1));
        break;
        localObject1 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z
 * JD-Core Version:    0.7.0.1
 */