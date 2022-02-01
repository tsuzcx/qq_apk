package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.f;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsTeenModeMainOther
  extends MMActivity
{
  private WeImageView TaX;
  private MMImageView TaY;
  private TextView pJJ;
  private TextView plr;
  
  private static String f(c.a parama, String paramString)
  {
    AppMethodBeat.i(278987);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    parama = ((c)h.ax(c.class)).a(parama, "");
    try
    {
      JSONObject localJSONObject = new JSONObject(parama);
      parama = paramString;
      if (localJSONObject.has(str)) {
        parama = localJSONObject.getString(str);
      }
    }
    catch (JSONException parama)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SettingsTeenModeMainOther", parama, "", new Object[0]);
        parama = paramString;
      }
    }
    Log.i("MicroMsg.SettingsTeenModeMainOther", "[getServerConfigTitle] title=%s", new Object[] { parama });
    AppMethodBeat.o(278987);
    return parama;
  }
  
  private static String hFf()
  {
    AppMethodBeat.i(278982);
    Object localObject = MMApplicationContext.getContext().getResources().getString(a.g.SWB);
    String str = f(c.a.zab, (String)localObject);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(278982);
      return localObject;
      localObject = str;
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.e.SWs;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279022);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    this.TaX = ((WeImageView)findViewById(a.d.SVN));
    this.TaY = ((MMImageView)findViewById(a.d.SVI));
    this.pJJ = ((TextView)findViewById(a.d.title_tv));
    this.plr = ((TextView)findViewById(a.d.desc_tv));
    int i = getIntent().getIntExtra("biz_type", 0);
    Log.i("MicroMsg.SettingsTeenModeMainOther", "type:%s", new Object[] { Integer.valueOf(i) });
    String str = "";
    paramBundle = "";
    int j;
    switch (i)
    {
    default: 
      j = -1;
      i = -1;
    }
    for (;;)
    {
      if ((i > 0) && (this.TaX.getVisibility() == 0))
      {
        this.TaX.setImageDrawable(com.tencent.mm.cd.a.m(getContext(), i));
        this.TaX.setIconColor(com.tencent.mm.cd.a.w(getContext(), j));
      }
      if (!Util.isNullOrNil(str))
      {
        this.pJJ.setText(str);
        this.pJJ.setContentDescription(str);
      }
      if (!Util.isNullOrNil(paramBundle))
      {
        this.plr.setText(paramBundle);
        this.plr.setContentDescription(paramBundle);
      }
      setBackBtn(new SettingsTeenModeMainOther.1(this));
      AppMethodBeat.o(279022);
      return;
      i = a.f.icons_outlined_news;
      j = a.a.Orange;
      str = getString(a.g.SXM);
      paramBundle = getString(a.g.SWI);
      continue;
      i = a.f.icons_outlined_searchlogo;
      j = a.a.Red;
      str = getString(a.g.SXD);
      paramBundle = getString(a.g.SWA);
      continue;
      this.TaX.setVisibility(8);
      this.TaY.setVisibility(0);
      str = getString(a.g.SXG);
      paramBundle = getString(a.g.SWC);
      j = -1;
      i = -1;
      continue;
      i = a.f.icons_outlined_nearby;
      j = a.a.Blue;
      str = getString(a.g.SXH);
      paramBundle = getString(a.g.SWD);
      continue;
      i = a.f.icons_outlined_live_nearby;
      j = a.a.Blue;
      paramBundle = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
      {
        str = getString(a.g.SXJ);
        paramBundle = getString(a.g.SWF);
      }
      else
      {
        str = getString(a.g.SXI);
        paramBundle = getString(a.g.SWE);
        continue;
        this.TaX.setImageDrawable(com.tencent.mm.cd.a.m(getContext(), a.f.icons_outlined_float_window_on));
        this.TaX.setIconColor(com.tencent.mm.cd.a.w(getContext(), a.a.room_live_logo_color));
        this.pJJ.setText(a.g.SXF);
        this.plr.setText(hFf());
        this.plr.setContentDescription(hFf());
        j = -1;
        i = -1;
        continue;
        i = a.f.icons_outlined_shake;
        j = a.a.Blue;
        str = getString(a.g.SXK);
        paramBundle = getString(a.g.SWG);
        continue;
        i = a.f.icons_outlined_shop;
        j = a.a.Red;
        str = getString(a.g.SXL);
        paramBundle = getString(a.g.SWH);
        continue;
        i = a.f.icons_wecoin_entrance;
        j = a.a.Brand;
        str = getString(a.g.SXN);
        paramBundle = getString(a.g.SWJ);
        continue;
        i = a.f.icons_outlined_emoji;
        j = a.a.Orange;
        str = getString(a.g.SXE);
        paramBundle = getString(a.g.SXt);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(279035);
    super.onDestroy();
    AppMethodBeat.o(279035);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(279029);
    super.onPause();
    AppMethodBeat.o(279029);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainOther
 * JD-Core Version:    0.7.0.1
 */