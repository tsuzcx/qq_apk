package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class y
  extends o
{
  public y(Context paramContext, l paraml, ViewGroup paramViewGroup)
  {
    super(paramContext, paraml, paramViewGroup);
    AppMethodBeat.i(96660);
    this.ynh.jo("canvasId", paraml.yiy);
    this.ynh.jo("canvasExt", paraml.yiz);
    AppMethodBeat.o(96660);
  }
  
  private boolean dKS()
  {
    AppMethodBeat.i(96662);
    if (((l)dKN()).yiB == 1)
    {
      AppMethodBeat.o(96662);
      return true;
    }
    AppMethodBeat.o(96662);
    return false;
  }
  
  private boolean dKT()
  {
    AppMethodBeat.i(96663);
    if (((l)dKN()).yiC == 1)
    {
      AppMethodBeat.o(96663);
      return true;
    }
    AppMethodBeat.o(96663);
    return false;
  }
  
  protected final void dKO()
  {
    AppMethodBeat.i(96661);
    Object localObject2 = (l)dKN();
    Context localContext = this.context;
    Object localObject1 = ((l)localObject2).yiy;
    String str1 = ((l)localObject2).yiz;
    int i = ((l)localObject2).yiA;
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("sns_landig_pages_from_source", 14);
    ((Intent)localObject2).putExtra("sns_landig_pages_origin_from_source", dKH().yjY);
    ((Intent)localObject2).putExtra("sns_landing_pages_xml", "");
    String str3;
    String str2;
    JSONObject localJSONObject;
    if (dKT())
    {
      ((Intent)localObject2).putExtra("sns_landing_pages_canvasid", (String)localObject1);
      ((Intent)localObject2).putExtra("sns_landing_pages_canvas_ext", str1);
      if (dKS())
      {
        localObject1 = new int[2];
        this.ynj.getLocationOnScreen((int[])localObject1);
        ((Intent)localObject2).putExtra("img_gallery_top", localObject1[1]);
        ((Intent)localObject2).putExtra("img_gallery_left", localObject1[0]);
        ((Intent)localObject2).putExtra("img_gallery_width", this.ynj.getWidth());
        ((Intent)localObject2).putExtra("img_gallery_height", this.ynj.getHeight());
      }
      ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", dKS());
      ((Intent)localObject2).putExtra("sns_landing_pages_extra", "");
      ((Intent)localObject2).putExtra("sns_landing_pages_no_store", i);
      ((Intent)localObject2).putExtra("sns_landing_pages_ux_info", dKH().dtx);
      ((Intent)localObject2).putExtra("sns_landing_is_native_sight_ad", dKH().yjZ);
      if (((localContext instanceof Activity)) && (dKT()) && (dKH().bizId == 2))
      {
        str3 = ((Activity)localContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
        str1 = ((Activity)localContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!bs.isNullOrNil(str3))
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
        localJSONObject.put("cid", dKN().yjs);
        if (bs.isNullOrNil(str1)) {
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
      dKM();
      AppMethodBeat.o(96661);
      return;
      ((Intent)localObject2).putExtra("sns_landing_pages_pageid", bs.aLz((String)localObject1));
      break;
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y
 * JD-Core Version:    0.7.0.1
 */