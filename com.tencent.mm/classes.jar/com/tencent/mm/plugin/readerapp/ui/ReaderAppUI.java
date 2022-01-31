package com.tencent.mm.plugin.readerapp.ui;

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
import com.tencent.mm.model.al;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.a.f;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

@com.tencent.mm.kernel.j
public class ReaderAppUI
  extends MMActivity
{
  private static float density;
  private int bWp = 0;
  private View fhl;
  private com.tencent.mm.ui.widget.b.a iep;
  private n.d ifj = new ReaderAppUI.2(this);
  private String lGG = "";
  private ListView mbv;
  private MMPullDownView mbz;
  private a<String> noN;
  private e noO = null;
  private int noP = 0;
  private ReaderAppUI.b noQ;
  
  private PackageInfo LA(String paramString)
  {
    if (paramString.length() == 0) {
      return null;
    }
    try
    {
      paramString = this.mController.uMN.getPackageManager().getPackageInfo(paramString, 0);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      y.printErrStackTrace("MicroMsg.ReaderAppUI", paramString, "", new Object[0]);
    }
    return null;
  }
  
  public final View.OnClickListener a(bj parambj, int paramInt1, int paramInt2, String paramString)
  {
    ReaderAppUI.b localb = this.noQ;
    String str = parambj.getTitle();
    Object localObject;
    if (!com.tencent.mm.sdk.platformtools.bk.bl(paramString))
    {
      if (!localb.npg.containsKey(paramString)) {
        break label80;
      }
      localObject = (Set)localb.npg.get(paramString);
    }
    for (;;)
    {
      if (!com.tencent.mm.sdk.platformtools.bk.bl(str)) {
        ((Set)localObject).add(str);
      }
      return new ReaderAppUI.9(this, paramInt1, paramString, parambj, paramInt2);
      label80:
      localObject = new HashSet();
      localb.npg.put(paramString, localObject);
    }
  }
  
  protected final int getLayoutId()
  {
    return a.e.reader_app;
  }
  
  protected final void initView()
  {
    try
    {
      this.noO = new e(com.tencent.mm.sdk.platformtools.bk.convertStreamToString(getAssets().open("chatting/purecolor_chat.xml")));
      this.mbv = ((ListView)findViewById(a.d.reader_history_lv));
      this.mbz = ((MMPullDownView)findViewById(a.d.reader_pull_down_view));
      this.fhl = getLayoutInflater().inflate(a.e.reader_app_header, null);
      this.mbv.addHeaderView(this.fhl);
      ((TextView)findViewById(a.d.empty_msg_tip_tv)).setText(a.g.readerapp_empty_msg_tip);
      if (this.bWp == 20)
      {
        this.noN = new ReaderAppUI.a(this, this, "");
        this.mbv.setOnScrollListener(this.noN);
        this.mbv.setAdapter(this.noN);
        this.mbv.setTranscriptMode(0);
        registerForContextMenu(this.mbv);
        this.iep = new com.tencent.mm.ui.widget.b.a(this);
        if (this.noN.getCount() != 0) {
          break label255;
        }
        Intent localIntent = new Intent(this, ReaderAppIntroUI.class);
        localIntent.putExtra("type", this.bWp);
        startActivity(localIntent);
        finish();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ReaderAppUI", localException, "", new Object[0]);
        continue;
        if (this.bWp == 11) {
          this.noN = new ReaderAppUI.c(this, this, "");
        }
      }
      label255:
      this.mbz.setOnTopLoadDataListener(new ReaderAppUI.3(this));
      this.mbz.setTopViewVisible(true);
      this.mbz.setAtBottomCallBack(new ReaderAppUI.4(this));
      this.mbz.setAtTopCallBack(new ReaderAppUI.5(this));
      this.mbz.setIsBottomShowAll(true);
      this.noN.uMi = new ReaderAppUI.6(this);
      setBackBtn(new ReaderAppUI.7(this));
      addIconOptionMenu(0, a.g.actionbar_setting, a.f.actionbar_setting_icon, new ReaderAppUI.8(this));
      this.mbv.setSelection(this.noN.getShowCount() - 1 + this.mbv.getHeaderViewsCount());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.bWp = getIntent().getIntExtra("type", 0);
    density = com.tencent.mm.cb.a.getDensity(this);
    this.noQ = new ReaderAppUI.b();
    long l = System.currentTimeMillis();
    initView();
    y.i("MicroMsg.ReaderAppUI", "[initView] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.lGG = bj.hS(this.bWp);
    if ((20 == this.bWp) && (t.Q("newsapp", null) > 0)) {
      h.nFQ.f(13440, new Object[] { Integer.valueOf(2) });
    }
  }
  
  public void onDestroy()
  {
    if (this.noN != null)
    {
      this.noN.bcS();
      this.noN.uMi = null;
    }
    if (this.noQ != null)
    {
      ReaderAppUI.b localb = this.noQ;
      if (!localb.npg.isEmpty())
      {
        Iterator localIterator = localb.npg.entrySet().iterator();
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
          h.nFQ.f(15413, new Object[] { Integer.valueOf(9), str1, localStringBuilder.toString() });
        }
        localb.npg.clear();
      }
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().ew("");
    com.tencent.mm.plugin.readerapp.c.g.buZ().d(this.noN);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abx(this.lGG);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.bWp == 20) {
      setMMTitle(a.g.hardcode_plugin_readerappnews_nick);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().ew(this.lGG);
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(this.lGG);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abx(this.lGG);
      com.tencent.mm.plugin.readerapp.c.g.buZ().c(this.noN);
      this.noN.a(null, null);
      refresh();
      return;
      setMMTitle(a.g.hardcode_plugin_readerappweibo_nick);
    }
  }
  
  public final void refresh()
  {
    TextView localTextView = (TextView)findViewById(a.d.empty_msg_tip_tv);
    if (this.bWp == 20) {}
    for (int i = a.g.readerapp_news_intro;; i = a.g.readerapp_weibo_intro)
    {
      localTextView.setText(i);
      if (this.noN.getCount() != 0) {
        break;
      }
      localTextView.setVisibility(0);
      return;
    }
    localTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI
 * JD-Core Version:    0.7.0.1
 */