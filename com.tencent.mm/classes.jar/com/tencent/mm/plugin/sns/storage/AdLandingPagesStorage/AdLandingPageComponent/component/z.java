package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class z
  extends p
{
  public z(Context paramContext, l paraml, ViewGroup paramViewGroup)
  {
    super(paramContext, paraml, paramViewGroup);
    AppMethodBeat.i(96660);
    this.zEb.jB("canvasId", paraml.zyG);
    this.zEb.jB("canvasExt", paraml.zyH);
    AppMethodBeat.o(96660);
  }
  
  private boolean dXj()
  {
    AppMethodBeat.i(96662);
    if (((l)dXf()).zyJ == 1)
    {
      AppMethodBeat.o(96662);
      return true;
    }
    AppMethodBeat.o(96662);
    return false;
  }
  
  private boolean dXk()
  {
    AppMethodBeat.i(96663);
    if (((l)dXf()).zyK == 1)
    {
      AppMethodBeat.o(96663);
      return true;
    }
    AppMethodBeat.o(96663);
    return false;
  }
  
  protected final void dXg()
  {
    AppMethodBeat.i(96661);
    Object localObject2 = (l)dXf();
    if (this.zEf) {}
    for (int i = 20;; i = 14)
    {
      Context localContext = this.context;
      Object localObject1 = ((l)localObject2).zyG;
      String str1 = ((l)localObject2).zyH;
      int j = ((l)localObject2).zyI;
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("sns_landig_pages_from_source", i);
      ((Intent)localObject2).putExtra("sns_landig_pages_origin_from_source", dWZ().zAN);
      ((Intent)localObject2).putExtra("sns_landing_pages_xml", "");
      String str3;
      String str2;
      JSONObject localJSONObject;
      if (dXk())
      {
        ((Intent)localObject2).putExtra("sns_landing_pages_canvasid", (String)localObject1);
        ((Intent)localObject2).putExtra("sns_landing_pages_canvas_ext", str1);
        if (dXj())
        {
          localObject1 = new int[2];
          this.zEd.getLocationOnScreen((int[])localObject1);
          ((Intent)localObject2).putExtra("img_gallery_top", localObject1[1]);
          ((Intent)localObject2).putExtra("img_gallery_left", localObject1[0]);
          ((Intent)localObject2).putExtra("img_gallery_width", this.zEd.getWidth());
          ((Intent)localObject2).putExtra("img_gallery_height", this.zEd.getHeight());
        }
        ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", dXj());
        ((Intent)localObject2).putExtra("sns_landing_pages_extra", "");
        ((Intent)localObject2).putExtra("sns_landing_pages_no_store", j);
        ((Intent)localObject2).putExtra("sns_landing_pages_ux_info", dWZ().dFy);
        ((Intent)localObject2).putExtra("sns_landing_is_native_sight_ad", dWZ().zAO);
        if (((localContext instanceof Activity)) && (dXk()) && (dWZ().bizId == 2))
        {
          str3 = ((Activity)localContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
          str1 = ((Activity)localContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
          if (!bt.isNullOrNil(str3))
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
          localJSONObject.put("cid", dXf().zAg);
          if (bt.isNullOrNil(str1)) {
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
        d.b(localContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject2);
        dXe();
        AppMethodBeat.o(96661);
        return;
        ((Intent)localObject2).putExtra("sns_landing_pages_pageid", bt.aRf((String)localObject1));
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