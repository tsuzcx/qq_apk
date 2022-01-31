package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.an;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bm;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

@i
public class ReaderAppUI
  extends MMActivity
{
  private static float density;
  private int cEc;
  private View gyT;
  private com.tencent.mm.ui.widget.c.a jVd;
  private n.d jWw;
  private ListView oBW;
  private MMPullDownView oCa;
  private String odT;
  private a<String> pUb;
  private e pUc;
  private int pUd;
  private ReaderAppUI.b pUe;
  
  public ReaderAppUI()
  {
    AppMethodBeat.i(76845);
    this.cEc = 0;
    this.odT = "";
    this.pUc = null;
    this.pUd = 0;
    this.jWw = new ReaderAppUI.2(this);
    AppMethodBeat.o(76845);
  }
  
  private PackageInfo XK(String paramString)
  {
    AppMethodBeat.i(76854);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(76854);
      return null;
    }
    try
    {
      paramString = getContext().getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(76854);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      ab.printErrStackTrace("MicroMsg.ReaderAppUI", paramString, "", new Object[0]);
      AppMethodBeat.o(76854);
    }
    return null;
  }
  
  public final View.OnClickListener a(bl parambl, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(76853);
    ReaderAppUI.b localb = this.pUe;
    String str = parambl.getTitle();
    Object localObject;
    if (!bo.isNullOrNil(paramString))
    {
      if (!localb.pUu.containsKey(paramString)) {
        break label92;
      }
      localObject = (Set)localb.pUu.get(paramString);
    }
    for (;;)
    {
      if (!bo.isNullOrNil(str)) {
        ((Set)localObject).add(str);
      }
      parambl = new ReaderAppUI.9(this, paramInt1, paramString, parambl, paramInt2);
      AppMethodBeat.o(76853);
      return parambl;
      label92:
      localObject = new HashSet();
      localb.pUu.put(paramString, localObject);
    }
  }
  
  public int getLayoutId()
  {
    return 2130970502;
  }
  
  public void initView()
  {
    AppMethodBeat.i(76852);
    try
    {
      this.pUc = new e(bo.convertStreamToString(getAssets().open("chatting/purecolor_chat.xml")));
      this.oBW = ((ListView)findViewById(2131827016));
      this.oCa = ((MMPullDownView)findViewById(2131827015));
      this.gyT = getLayoutInflater().inflate(2130970506, null);
      this.oBW.addHeaderView(this.gyT);
      ((TextView)findViewById(2131821852)).setText(2131302290);
      if (this.cEc == 20)
      {
        this.pUb = new ReaderAppUI.a(this, this, "");
        this.oBW.setOnScrollListener(this.pUb);
        this.oBW.setAdapter(this.pUb);
        this.oBW.setTranscriptMode(0);
        registerForContextMenu(this.oBW);
        this.jVd = new com.tencent.mm.ui.widget.c.a(this);
        if (this.pUb.getCount() != 0) {
          break label267;
        }
        Intent localIntent = new Intent(this, ReaderAppIntroUI.class);
        localIntent.putExtra("type", this.cEc);
        startActivity(localIntent);
        finish();
        AppMethodBeat.o(76852);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ReaderAppUI", localException, "", new Object[0]);
        continue;
        if (this.cEc == 11) {
          this.pUb = new ReaderAppUI.c(this, this, "");
        }
      }
      label267:
      this.oCa.setOnTopLoadDataListener(new ReaderAppUI.3(this));
      this.oCa.setTopViewVisible(true);
      this.oCa.setAtBottomCallBack(new ReaderAppUI.4(this));
      this.oCa.setAtTopCallBack(new ReaderAppUI.5(this));
      this.oCa.setIsBottomShowAll(true);
      this.pUb.a(new ReaderAppUI.6(this));
      setBackBtn(new ReaderAppUI.7(this));
      addIconOptionMenu(0, 2131296404, 2131230758, new ReaderAppUI.8(this));
      this.oBW.setSelection(this.pUb.getShowCount() - 1 + this.oBW.getHeaderViewsCount());
      AppMethodBeat.o(76852);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(76846);
    super.onCreate(paramBundle);
    this.cEc = getIntent().getIntExtra("type", 0);
    ab.i("MicroMsg.ReaderAppUI", "[onCreate] readerType:%s", new Object[] { Integer.valueOf(this.cEc) });
    this.cEc = 20;
    density = com.tencent.mm.cb.a.getDensity(this);
    this.pUe = new ReaderAppUI.b();
    long l = System.currentTimeMillis();
    initView();
    ab.i("MicroMsg.ReaderAppUI", "[initView] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.odT = bl.kF(this.cEc);
    if ((20 == this.cEc) && (u.ag("newsapp", null) > 0)) {
      h.qsU.e(13440, new Object[] { Integer.valueOf(2) });
    }
    disableMultiTouch();
    AppMethodBeat.o(76846);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(76847);
    if (this.pUb != null)
    {
      this.pUb.bKb();
      this.pUb.dAW();
    }
    if (this.pUe != null)
    {
      ReaderAppUI.b localb = this.pUe;
      if (!localb.pUu.isEmpty())
      {
        Iterator localIterator = localb.pUu.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          String str1 = (String)((Map.Entry)localObject).getKey();
          StringBuilder localStringBuilder = new StringBuilder();
          localObject = ((Set)((Map.Entry)localObject).getValue()).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str2 = (String)((Iterator)localObject).next();
            if (localStringBuilder.length() <= 0) {
              localStringBuilder.append(str2);
            } else {
              localStringBuilder.append("||").append(str2);
            }
          }
          h.qsU.e(15413, new Object[] { Integer.valueOf(9), str1, localStringBuilder.toString() });
        }
        localb.pUu.clear();
      }
    }
    super.onDestroy();
    AppMethodBeat.o(76847);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(76849);
    super.onPause();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().kD("");
    com.tencent.mm.plugin.readerapp.c.g.cfl().remove(this.pUb);
    ((j)com.tencent.mm.kernel.g.E(j.class)).YF().arJ(this.odT);
    AppMethodBeat.o(76849);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(76848);
    super.onResume();
    if (this.cEc == 20) {
      setMMTitle(2131300614);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().kD(this.odT);
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(this.odT);
      ((j)com.tencent.mm.kernel.g.E(j.class)).YF().arJ(this.odT);
      com.tencent.mm.plugin.readerapp.c.g.cfl().add(this.pUb);
      this.pUb.a(null, null);
      refresh();
      AppMethodBeat.o(76848);
      return;
      setMMTitle(2131300617);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(76850);
    TextView localTextView = (TextView)findViewById(2131821852);
    if (this.cEc == 20) {}
    for (int i = 2131302298;; i = 2131302304)
    {
      localTextView.setText(i);
      if (this.pUb.getCount() != 0) {
        break;
      }
      localTextView.setVisibility(0);
      AppMethodBeat.o(76850);
      return;
    }
    localTextView.setVisibility(8);
    AppMethodBeat.o(76850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI
 * JD-Core Version:    0.7.0.1
 */