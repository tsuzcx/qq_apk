package com.tencent.mm.plugin.teenmode.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
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
  private WeImageView Mug;
  private MMImageView Muh;
  private TextView mNb;
  private TextView mrM;
  
  private static String f(b.a parama, String paramString)
  {
    AppMethodBeat.i(259334);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    parama = ((b)h.ae(b.class)).a(parama, "");
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
    AppMethodBeat.o(259334);
    return parama;
  }
  
  private static String gkC()
  {
    AppMethodBeat.i(259333);
    Object localObject = MMApplicationContext.getContext().getResources().getString(a.g.MsL);
    String str = f(b.a.vJI, (String)localObject);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(259333);
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
    return a.e.MsI;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(259330);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    this.Mug = ((WeImageView)findViewById(a.d.Msi));
    this.Muh = ((MMImageView)findViewById(a.d.Msh));
    this.mNb = ((TextView)findViewById(a.d.title_tv));
    this.mrM = ((TextView)findViewById(a.d.desc_tv));
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
      if ((i > 0) && (this.Mug.getVisibility() == 0))
      {
        this.Mug.setImageDrawable(com.tencent.mm.ci.a.m(getContext(), i));
        this.Mug.setIconColor(com.tencent.mm.ci.a.w(getContext(), j));
      }
      if (!Util.isNullOrNil(str))
      {
        this.mNb.setText(str);
        this.mNb.setContentDescription(str);
      }
      if (!Util.isNullOrNil(paramBundle))
      {
        this.mrM.setText(paramBundle);
        this.mrM.setContentDescription(paramBundle);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(259291);
          SettingsTeenModeMainOther.this.onBackPressed();
          AppMethodBeat.o(259291);
          return true;
        }
      });
      AppMethodBeat.o(259330);
      return;
      i = a.f.icons_outlined_news;
      j = a.a.Orange;
      str = getString(a.g.Mto);
      paramBundle = getString(a.g.MsS);
      continue;
      i = a.f.icons_outlined_searchlogo;
      j = a.a.Red;
      str = getString(a.g.Mtg);
      paramBundle = getString(a.g.MsK);
      continue;
      this.Mug.setVisibility(8);
      this.Muh.setVisibility(0);
      str = getString(a.g.Mti);
      paramBundle = getString(a.g.MsM);
      j = -1;
      i = -1;
      continue;
      i = a.f.icons_outlined_nearby;
      j = a.a.Blue;
      str = getString(a.g.Mtj);
      paramBundle = getString(a.g.MsN);
      continue;
      i = a.f.icons_outlined_live_nearby;
      j = a.a.Blue;
      paramBundle = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
      {
        str = getString(a.g.Mtl);
        paramBundle = getString(a.g.MsP);
      }
      else
      {
        str = getString(a.g.Mtk);
        paramBundle = getString(a.g.MsO);
        continue;
        this.Mug.setImageDrawable(com.tencent.mm.ci.a.m(getContext(), a.f.icons_outlined_float_window_on));
        this.Mug.setIconColor(com.tencent.mm.ci.a.w(getContext(), a.a.room_live_logo_color));
        this.mNb.setText(a.g.Mth);
        this.mrM.setText(gkC());
        this.mrM.setContentDescription(gkC());
        j = -1;
        i = -1;
        continue;
        i = a.f.icons_outlined_shake;
        j = a.a.Blue;
        str = getString(a.g.Mtm);
        paramBundle = getString(a.g.MsQ);
        continue;
        i = a.f.icons_outlined_shop;
        j = a.a.Red;
        str = getString(a.g.Mtn);
        paramBundle = getString(a.g.MsR);
        continue;
        i = a.f.icons_wecoin_entrance;
        j = a.a.Brand;
        str = getString(a.g.Mtp);
        paramBundle = getString(a.g.MsT);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(259332);
    super.onDestroy();
    AppMethodBeat.o(259332);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(259331);
    super.onPause();
    AppMethodBeat.o(259331);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainOther
 * JD-Core Version:    0.7.0.1
 */