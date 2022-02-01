package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jt;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.b.j;
import com.tencent.mm.protocal.protobuf.fmh;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsTeenModeMainFinder
  extends MMActivity
{
  private WeImageView TaP;
  private WeImageView TaR;
  private LinearLayout TaS;
  private int TaT = 2;
  
  private static String d(c.a parama, String paramString)
  {
    AppMethodBeat.i(279373);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    parama = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(parama, "");
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
    AppMethodBeat.o(279373);
    return parama;
  }
  
  private static String e(c.a parama, String paramString)
  {
    AppMethodBeat.i(279384);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    parama = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(parama, "");
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
    AppMethodBeat.o(279384);
    return parama;
  }
  
  private void hFa()
  {
    AppMethodBeat.i(279356);
    Log.d("MicroMsg.SettingsTeenModeMainFinder", "doSaveConfig: %s", new Object[] { Integer.valueOf(this.TaT) });
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acQu, Integer.valueOf(this.TaT));
    AppMethodBeat.o(279356);
  }
  
  public static String hFb()
  {
    AppMethodBeat.i(279361);
    Object localObject = MMApplicationContext.getContext().getResources().getString(a.g.SXP);
    String str = d(c.a.zac, (String)localObject);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(279361);
      return localObject;
      localObject = str;
    }
  }
  
  public static String hFc()
  {
    AppMethodBeat.i(279365);
    Object localObject = MMApplicationContext.getContext().getResources().getString(a.g.SXQ);
    String str = d(c.a.yZY, (String)localObject);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(279365);
      return localObject;
      localObject = str;
    }
  }
  
  private static String hFd()
  {
    AppMethodBeat.i(279375);
    Object localObject = MMApplicationContext.getContext().getResources().getString(a.g.SXC);
    String str = e(c.a.yZZ, (String)localObject);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(279375);
      return localObject;
      localObject = str;
    }
  }
  
  private static String hFe()
  {
    AppMethodBeat.i(279379);
    Object localObject = MMApplicationContext.getContext().getResources().getString(a.g.SXB);
    String str = e(c.a.zaa, (String)localObject);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(279379);
      return localObject;
      localObject = str;
    }
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(279303);
    TextView localTextView1 = (TextView)findViewById(a.d.SWc);
    TextView localTextView2 = (TextView)findViewById(a.d.SWe);
    TextView localTextView3 = (TextView)findViewById(a.d.SVF);
    localTextView1.setContentDescription(hFb());
    localTextView1.setText(hFb());
    localTextView2.setContentDescription(getString(a.g.SXQ));
    localTextView2.setText(hFc());
    this.TaP.setVisibility(8);
    this.TaR.setVisibility(8);
    this.TaS.setVisibility(4);
    switch (this.TaT)
    {
    }
    for (;;)
    {
      hFa();
      AppMethodBeat.o(279303);
      return;
      this.TaP.setVisibility(0);
      localTextView3.setContentDescription(hFd());
      localTextView3.setText(hFd());
      localTextView1.setContentDescription(getString(a.g.SXz) + hFb());
      continue;
      this.TaR.setVisibility(0);
      localTextView3.setContentDescription(hFe());
      localTextView3.setText(hFe());
      localTextView2.setContentDescription(getString(a.g.SXz) + hFc());
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.e.SWq;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(279415);
    super.onBackPressed();
    AppMethodBeat.o(279415);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279400);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    this.TaP = ((WeImageView)findViewById(a.d.SWb));
    this.TaR = ((WeImageView)findViewById(a.d.SWd));
    this.TaS = ((LinearLayout)findViewById(a.d.SVB));
    this.TaT = ((d)com.tencent.mm.kernel.h.ax(d.class)).eZD();
    updateStatus();
    ((View)this.TaP.getParent()).setOnClickListener(new SettingsTeenModeMainFinder.1(this));
    ((View)this.TaR.getParent()).setOnClickListener(new SettingsTeenModeMainFinder.2(this));
    this.TaS.setOnClickListener(new SettingsTeenModeMainFinder.3(this));
    setBackBtn(new SettingsTeenModeMainFinder.4(this));
    AppMethodBeat.o(279400);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(279409);
    Log.d("MicroMsg.SettingsTeenModeMainFinder", "doLog: %s", new Object[] { Integer.valueOf(this.TaT) });
    fmh localfmh = new fmh();
    localfmh.abMB = this.TaT;
    if (j.hEy().hFb != null)
    {
      localfmh.aajK = new gol();
      localfmh.aajK.df(j.hEy().hFb.getBytes());
    }
    localfmh.aajL = j.hEy().qfP;
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaT().b(new k.a(223, localfmh));
    ((d)com.tencent.mm.kernel.h.ax(d.class)).hEs();
    new jt().publish();
    super.onDestroy();
    AppMethodBeat.o(279409);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(279404);
    super.onPause();
    AppMethodBeat.o(279404);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainFinder
 * JD-Core Version:    0.7.0.1
 */