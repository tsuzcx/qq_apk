package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class t
  extends k
{
  public t(Context paramContext, j paramj, ViewGroup paramViewGroup)
  {
    super(paramContext, paramj, paramViewGroup);
  }
  
  private boolean cro()
  {
    AppMethodBeat.i(37242);
    if (((j)cri()).rrZ == 1)
    {
      AppMethodBeat.o(37242);
      return true;
    }
    AppMethodBeat.o(37242);
    return false;
  }
  
  private boolean crp()
  {
    AppMethodBeat.i(37243);
    if (((j)cri()).rsa == 1)
    {
      AppMethodBeat.o(37243);
      return true;
    }
    AppMethodBeat.o(37243);
    return false;
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(37241);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_landig_pages_from_source", 14);
    localIntent.putExtra("sns_landig_pages_origin_from_source", crc().rtf);
    localIntent.putExtra("sns_landing_pages_xml", "");
    String str2;
    String str1;
    JSONObject localJSONObject;
    if (crp())
    {
      localIntent.putExtra("sns_landing_pages_canvasid", paramString1);
      localIntent.putExtra("sns_landing_pages_canvas_ext", paramString2);
      if (cro())
      {
        paramString1 = new int[2];
        this.rvr.getLocationOnScreen(paramString1);
        localIntent.putExtra("img_gallery_top", paramString1[1]);
        localIntent.putExtra("img_gallery_left", paramString1[0]);
        localIntent.putExtra("img_gallery_width", this.rvr.getWidth());
        localIntent.putExtra("img_gallery_height", this.rvr.getHeight());
      }
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", cro());
      localIntent.putExtra("sns_landing_pages_extra", "");
      localIntent.putExtra("sns_landing_pages_no_store", paramInt);
      localIntent.putExtra("sns_landing_pages_ux_info", crc().cFe);
      localIntent.putExtra("sns_landing_is_native_sight_ad", crc().rtg);
      if (((paramContext instanceof Activity)) && (crp()) && (crc().rth == 2))
      {
        str2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
        paramString2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!bo.isNullOrNil(str2))
        {
          str1 = String.valueOf(System.currentTimeMillis() / 1000L);
          localJSONObject = new JSONObject();
        }
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("sessionId", str1);
        localJSONObject.put("cid", cri().rsI);
        if (bo.isNullOrNil(paramString2)) {
          continue;
        }
        paramString1 = paramString2;
        localJSONObject.put("adBuffer", paramString1);
        localJSONObject.put("preSessionId", str2);
      }
      catch (Exception paramString1)
      {
        continue;
      }
      localIntent.putExtra("sns_landing_pages_search_extra", localJSONObject.toString());
      localIntent.putExtra("sns_landing_pages_sessionId", str1);
      localIntent.putExtra("sns_landing_pages_ad_buffer", paramString2);
      if ((paramContext instanceof Activity))
      {
        paramString1 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_rawSnsId");
        paramString2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_share_sns_id");
        localIntent.putExtra("sns_landing_pages_rawSnsId", paramString1);
        localIntent.putExtra("sns_landing_pages_share_sns_id", paramString2);
      }
      d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
      AppMethodBeat.o(37241);
      return;
      localIntent.putExtra("sns_landing_pages_pageid", bo.apW(paramString1));
      break;
      paramString1 = "";
    }
  }
  
  protected final void e(Button paramButton)
  {
    AppMethodBeat.i(37240);
    paramButton.setOnClickListener(new t.1(this));
    AppMethodBeat.o(37240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t
 * JD-Core Version:    0.7.0.1
 */