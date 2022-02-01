package com.tencent.mm.plugin.teenmode.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.protocal.protobuf.erb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsTeenModeMainFinder
  extends MMActivity
{
  private WeImageView MtY;
  private WeImageView MtZ;
  private WeImageView Mua;
  private LinearLayout Mub;
  private int Muc = 0;
  
  private static String d(b.a parama, String paramString)
  {
    AppMethodBeat.i(259630);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    parama = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(parama, "");
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
        Log.printErrStackTrace("MicroMsg.SettingsTeenModeMainFinder", parama, "", new Object[0]);
        parama = paramString;
      }
    }
    Log.i("MicroMsg.SettingsTeenModeMainFinder", "[getServerConfigTitle] title=%s", new Object[] { parama });
    AppMethodBeat.o(259630);
    return parama;
  }
  
  private static String e(b.a parama, String paramString)
  {
    AppMethodBeat.i(259632);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    parama = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(parama, "");
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
        Log.printErrStackTrace("MicroMsg.SettingsTeenModeMainFinder", parama, "", new Object[0]);
        parama = paramString;
      }
    }
    Log.i("MicroMsg.SettingsTeenModeMainFinder", "[getServerConfigTitle] title=%s", new Object[] { parama });
    AppMethodBeat.o(259632);
    return parama;
  }
  
  public static String gkA()
  {
    AppMethodBeat.i(259627);
    Object localObject = MMApplicationContext.getContext().getResources().getString(a.g.Mts);
    String str = d(b.a.vJG, (String)localObject);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(259627);
      return localObject;
      localObject = str;
    }
  }
  
  private static String gkB()
  {
    AppMethodBeat.i(259631);
    Object localObject = MMApplicationContext.getContext().getResources().getString(a.g.Mtf);
    String str = e(b.a.vJH, (String)localObject);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(259631);
      return localObject;
      localObject = str;
    }
  }
  
  private void gkx()
  {
    AppMethodBeat.i(259621);
    Log.d("MicroMsg.SettingsTeenModeMainFinder", "doSaveConfig: %s", new Object[] { Integer.valueOf(this.Muc) });
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoY, Integer.valueOf(this.Muc));
    AppMethodBeat.o(259621);
  }
  
  public static String gky()
  {
    AppMethodBeat.i(259623);
    Object localObject = MMApplicationContext.getContext().getResources().getString(a.g.Mtr);
    String str = d(b.a.vJJ, (String)localObject);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(259623);
      return localObject;
      localObject = str;
    }
  }
  
  public static String gkz()
  {
    AppMethodBeat.i(259625);
    Object localObject = MMApplicationContext.getContext().getResources().getString(a.g.Mte);
    String str = d(b.a.vJF, (String)localObject);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(259625);
      return localObject;
      localObject = str;
    }
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(259619);
    TextView localTextView1 = (TextView)findViewById(a.d.Msw);
    TextView localTextView2 = (TextView)findViewById(a.d.MsA);
    TextView localTextView3 = (TextView)findViewById(a.d.Msy);
    TextView localTextView4 = (TextView)findViewById(a.d.Msf);
    localTextView4.setContentDescription(gkB());
    localTextView4.setText(gkB());
    localTextView1.setContentDescription(gky());
    localTextView1.setText(gky());
    localTextView2.setContentDescription(gkz());
    localTextView2.setText(gkz());
    localTextView3.setContentDescription(getString(a.g.Mts));
    localTextView3.setText(gkA());
    this.MtY.setVisibility(8);
    this.MtZ.setVisibility(8);
    this.Mua.setVisibility(8);
    this.Mub.setVisibility(4);
    switch (this.Muc)
    {
    }
    for (;;)
    {
      gkx();
      AppMethodBeat.o(259619);
      return;
      this.MtY.setVisibility(0);
      localTextView1.setContentDescription(getString(a.g.Mtd) + gky());
      continue;
      this.MtZ.setVisibility(0);
      this.Mub.setVisibility(0);
      localTextView2.setContentDescription(getString(a.g.Mtd) + gkz());
      continue;
      this.Mua.setVisibility(0);
      localTextView3.setContentDescription(getString(a.g.Mtd) + gkA());
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.e.MsG;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(259616);
    super.onBackPressed();
    AppMethodBeat.o(259616);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(259611);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    this.MtY = ((WeImageView)findViewById(a.d.Msv));
    this.MtZ = ((WeImageView)findViewById(a.d.Msz));
    this.Mua = ((WeImageView)findViewById(a.d.Msx));
    this.Mub = ((LinearLayout)findViewById(a.d.Msc));
    this.Muc = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).dYS();
    updateStatus();
    ((View)this.MtY.getParent()).setOnClickListener(new SettingsTeenModeMainFinder.1(this));
    ((View)this.MtZ.getParent()).setOnClickListener(new SettingsTeenModeMainFinder.2(this));
    ((View)this.Mua.getParent()).setOnClickListener(new SettingsTeenModeMainFinder.3(this));
    this.Mub.setOnClickListener(new SettingsTeenModeMainFinder.4(this));
    setBackBtn(new SettingsTeenModeMainFinder.5(this));
    AppMethodBeat.o(259611);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(259615);
    Log.d("MicroMsg.SettingsTeenModeMainFinder", "doLog: %s", new Object[] { Integer.valueOf(this.Muc) });
    erb localerb = new erb();
    localerb.Utn = this.Muc;
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eRY().b(new k.a(223, localerb));
    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gkt();
    super.onDestroy();
    AppMethodBeat.o(259615);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(259613);
    super.onPause();
    AppMethodBeat.o(259613);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainFinder
 * JD-Core Version:    0.7.0.1
 */