package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.kernel.k;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bx;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.u;
import com.tencent.mm.plugin.brandservice.api.h.a;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.plugin.readerapp.a.b;
import com.tencent.mm.plugin.readerapp.a.c;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.a.f;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.plugin.readerapp.a.h;
import com.tencent.mm.plugin.readerapp.model.d;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.f;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.x.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@k
@com.tencent.mm.ui.widget.pulldown.c(0)
public class ReaderAppUI
  extends MMActivity
{
  private static float density;
  private ListView KNX;
  private MMPullDownView KOb;
  private String Kgd;
  private a<String> NvZ;
  private com.tencent.mm.pluginsdk.ui.f Nwa;
  private int Nwb;
  private int hWJ;
  private View pUv;
  private com.tencent.mm.ui.widget.b.a vEV;
  private u.i vGU;
  
  public ReaderAppUI()
  {
    AppMethodBeat.i(102751);
    this.hWJ = 0;
    this.Kgd = "";
    this.Nwa = null;
    this.Nwb = 0;
    this.vGU = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(161679);
        paramAnonymousInt = paramAnonymousMenuItem.getGroupId();
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(161679);
          return;
          Object localObject1 = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
          if (!Util.isNullOrNil((String)localObject1))
          {
            d.gC((String)localObject1, ReaderAppUI.a(ReaderAppUI.this));
            paramAnonymousMenuItem = d.gFB();
            paramAnonymousInt = ReaderAppUI.a(ReaderAppUI.this);
            localObject1 = "delete from " + com.tencent.mm.model.by.vl(paramAnonymousInt) + " where reserved3 = " + com.tencent.mm.storagebase.h.EQ((String)localObject1);
            Log.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[] { localObject1 });
            if (paramAnonymousMenuItem.omV.execSQL(com.tencent.mm.model.by.vl(paramAnonymousInt), (String)localObject1))
            {
              paramAnonymousMenuItem.vp(paramAnonymousInt);
              paramAnonymousMenuItem.doNotify();
            }
          }
          ReaderAppUI.this.bDL();
          AppMethodBeat.o(161679);
          return;
          if (ReaderAppUI.a(ReaderAppUI.this) == 20)
          {
            paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
            paramAnonymousMenuItem = d.gFB().aP(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
            Object localObject2;
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.size() > 0))
            {
              paramAnonymousMenuItem = (bx)paramAnonymousMenuItem.get(0);
              localObject1 = new k.b();
              ((k.b)localObject1).title = paramAnonymousMenuItem.getTitle();
              ((k.b)localObject1).description = paramAnonymousMenuItem.getDigest();
              ((k.b)localObject1).action = "view";
              ((k.b)localObject1).type = 5;
              ((k.b)localObject1).url = paramAnonymousMenuItem.getUrl();
              localObject2 = k.b.a((k.b)localObject1, null, null);
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("Retr_Msg_content", (String)localObject2);
              ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
              ((Intent)localObject1).putExtra("Retr_Msg_thumb_path", y.bpF(paramAnonymousMenuItem.bCX()));
              ((Intent)localObject1).putExtra("Retr_Msg_Id", 7377812);
              localObject2 = ad.Jo(paramAnonymousMenuItem.omP);
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              localObject2 = ad.bCb().M((String)localObject2, true);
              ((ad.b)localObject2).q("prePublishId", "msg_" + paramAnonymousMenuItem.omP);
              ((ad.b)localObject2).q("preUsername", "newsapp");
              ((ad.b)localObject2).q("preChatName", "newsapp");
              ((ad.b)localObject2).q("preMsgIndex", Integer.valueOf(0));
              ((ad.b)localObject2).q("sendAppMsgScene", Integer.valueOf(1));
              com.tencent.mm.plugin.readerapp.b.a.pFn.j((Intent)localObject1, ReaderAppUI.this);
            }
            AppMethodBeat.o(161679);
            return;
            if (ReaderAppUI.a(ReaderAppUI.this) == 20)
            {
              paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
              localObject1 = d.gFB().aP(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
              if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
              {
                Log.i("MicroMsg.ReaderAppUI", "fav functionId %s, index %d, size %d", new Object[] { paramAnonymousMenuItem, Integer.valueOf(ReaderAppUI.d(ReaderAppUI.this)), Integer.valueOf(((List)localObject1).size()) });
                if (ReaderAppUI.d(ReaderAppUI.this) >= ((List)localObject1).size()) {
                  ReaderAppUI.a(ReaderAppUI.this, 0);
                }
                paramAnonymousMenuItem = (bx)((List)localObject1).get(ReaderAppUI.d(ReaderAppUI.this));
                localObject1 = new dn();
                localObject2 = ad.Jo(paramAnonymousMenuItem.omP);
                ad.b localb = ad.bCb().M((String)localObject2, true);
                localb.q("prePublishId", "msg_" + paramAnonymousMenuItem.omP);
                localb.q("preUsername", "newsapp");
                localb.q("preChatName", "newsapp");
                localb.q("preMsgIndex", Integer.valueOf(0));
                localb.q("sendAppMsgScene", Integer.valueOf(1));
                ((dn)localObject1).hDr.sessionId = ((String)localObject2);
                ReaderAppUI.d(ReaderAppUI.this);
                com.tencent.mm.plugin.readerapp.model.a.a((dn)localObject1, paramAnonymousMenuItem);
                ((dn)localObject1).hDr.hDy = 7;
                ((dn)localObject1).hDr.activity = ReaderAppUI.this;
                ((dn)localObject1).publish();
              }
            }
          }
        }
      }
    };
    AppMethodBeat.o(102751);
  }
  
  private PackageInfo aSz(String paramString)
  {
    AppMethodBeat.i(102759);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(102759);
      return null;
    }
    try
    {
      paramString = getContext().getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(102759);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      Log.printErrStackTrace("MicroMsg.ReaderAppUI", paramString, "", new Object[0]);
      AppMethodBeat.o(102759);
    }
    return null;
  }
  
  public final View.OnClickListener a(final bx parambx, final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(102758);
    if (parambx != null)
    {
      String str1 = aa.aUC(parambx.getUrl());
      String str2 = aa.aUC(paramString);
      String str3 = aa.aUC(parambx.getTitle());
      com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(9), str2, str3, parambx.aVp(), parambx.bCT(), str1, Integer.valueOf(parambx.bDb()), Integer.valueOf(parambx.bCZ()) });
    }
    parambx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(161677);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/readerapp/ui/ReaderAppUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (20 == paramInt1)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(8), paramString, parambx.getTitle() });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("mode", 1);
          localObject = parambx.getUrl();
          paramAnonymousView.putExtra("news_svr_id", parambx.omP);
          paramAnonymousView.putExtra("news_svr_tweetid", parambx.bCT());
          paramAnonymousView.putExtra("rawUrl", ReaderAppUI.a(ReaderAppUI.this, (String)localObject));
          paramAnonymousView.putExtra("title", parambx.getName());
          paramAnonymousView.putExtra("webpageTitle", parambx.getTitle());
          paramAnonymousView.putExtra("key_show_web_page_title", true);
          paramAnonymousView.putExtra("useJs", true);
          paramAnonymousView.putExtra("vertical_scroll", true);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("snsWebSource", 3);
          paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject);
          paramAnonymousView.putExtra("shortUrl", parambx.bCU());
          paramAnonymousView.putExtra("type", parambx.type);
          paramAnonymousView.putExtra("tweetid", parambx.bCT());
          paramAnonymousView.putExtra("geta8key_username", "newsapp");
          paramAnonymousView.putExtra("KPublisherId", "msg_" + Long.toString(parambx.omP));
          paramAnonymousView.putExtra("pre_username", "newsapp");
          paramAnonymousView.putExtra("prePublishId", "msg_" + Long.toString(parambx.omP));
          paramAnonymousView.putExtra("preUsername", "newsapp");
          paramAnonymousView.putExtra("preChatName", "newsapp");
          paramAnonymousView.putExtra("preMsgIndex", paramInt2);
          paramAnonymousView.putExtra("geta8key_scene", 66);
          paramAnonymousView.putExtra("webview_scene_type", 1);
          paramAnonymousView.putExtra("webview_scene_note", aa.aUC(String.format("%d|%d|%s|%s|%s", new Object[] { Integer.valueOf(parambx.bDb()), Integer.valueOf(parambx.bCZ()), parambx.aVp(), paramString, parambx.bCT() })));
          paramAnonymousView.putExtra("bizEnterId", (int)(System.currentTimeMillis() / 1000L));
          paramAnonymousView.putExtra("KOpenArticleSceneFromScene", 0);
          paramAnonymousView.addFlags(536870912);
          com.tencent.mm.plugin.readerapp.b.a.pFn.h(paramAnonymousView, ReaderAppUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(161677);
      }
    };
    AppMethodBeat.o(102758);
    return parambx;
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(102756);
    ScrollView localScrollView = (ScrollView)findViewById(a.e.empty_msg_tip_tv);
    if (this.NvZ.getCount() == 0)
    {
      this.KOb.setVisibility(8);
      localScrollView.setVisibility(0);
    }
    for (;;)
    {
      if ((this.KNX != null) && ((this.NvZ instanceof a))) {
        this.KNX.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161678);
            ((ReaderAppUI.a)ReaderAppUI.c(ReaderAppUI.this)).kB(ReaderAppUI.b(ReaderAppUI.this).getFirstVisiblePosition(), ReaderAppUI.b(ReaderAppUI.this).getLastVisiblePosition());
            AppMethodBeat.o(161678);
          }
        });
      }
      AppMethodBeat.o(102756);
      return;
      localScrollView.setVisibility(8);
      this.KOb.setVisibility(0);
    }
  }
  
  public int getLayoutId()
  {
    return a.f.Nvq;
  }
  
  public void initView()
  {
    AppMethodBeat.i(102757);
    try
    {
      this.Nwa = new com.tencent.mm.pluginsdk.ui.f(Util.convertStreamToString(getAssets().open("chatting/purecolor_chat.xml")), this);
      this.KNX = ((ListView)findViewById(a.e.Nvg));
      this.KOb = ((MMPullDownView)findViewById(a.e.Nvi));
      this.KOb.setIsReturnSuperDispatchWhenCancel(true);
      this.pUv = getLayoutInflater().inflate(a.f.Nvr, null);
      this.KNX.addHeaderView(this.pUv);
      this.NvZ = new a(this, "");
      this.KNX.setOnScrollListener(this.NvZ);
      this.KNX.setAdapter(this.NvZ);
      this.KNX.setTranscriptMode(0);
      registerForContextMenu(this.KNX);
      this.vEV = new com.tencent.mm.ui.widget.b.a(this);
      this.vEV.agjw = true;
      this.KOb.setOnTopLoadDataListener(new MMPullDownView.g()
      {
        public final boolean dsr()
        {
          AppMethodBeat.i(161680);
          if (ReaderAppUI.c(ReaderAppUI.this).dmY())
          {
            ReaderAppUI.b(ReaderAppUI.this).setSelectionFromTop(0, ReaderAppUI.e(ReaderAppUI.this).getTopHeight());
            AppMethodBeat.o(161680);
            return true;
          }
          int i = ReaderAppUI.c(ReaderAppUI.this).getCount();
          int j = ReaderAppUI.c(ReaderAppUI.this).dmZ();
          Log.v("MicroMsg.ReaderAppUI", "onLoadData add count:".concat(String.valueOf(j)));
          ReaderAppUI.c(ReaderAppUI.this).onNotifyChange(null, null);
          int k = ReaderAppUI.c(ReaderAppUI.this).getCount();
          Log.d("MicroMsg.ReaderAppUI", "onTopLoadData nowCount:%d, preCount:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
          if (k > i)
          {
            Log.i("MicroMsg.ReaderAppUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", new Object[] { Integer.valueOf(j + 1), Integer.valueOf(ReaderAppUI.e(ReaderAppUI.this).getTopHeight()) });
            q.a(ReaderAppUI.b(ReaderAppUI.this), j + 1, ReaderAppUI.e(ReaderAppUI.this).getTopHeight(), false, false);
          }
          AppMethodBeat.o(161680);
          return true;
        }
      });
      this.KOb.setTopViewVisible(true);
      this.KOb.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean dsq()
        {
          AppMethodBeat.i(161681);
          View localView = ReaderAppUI.b(ReaderAppUI.this).getChildAt(ReaderAppUI.b(ReaderAppUI.this).getChildCount() - 1);
          if (localView == null)
          {
            AppMethodBeat.o(161681);
            return false;
          }
          if ((localView.getBottom() <= ReaderAppUI.b(ReaderAppUI.this).getHeight()) && (ReaderAppUI.b(ReaderAppUI.this).getLastVisiblePosition() == ReaderAppUI.b(ReaderAppUI.this).getAdapter().getCount() - 1))
          {
            AppMethodBeat.o(161681);
            return true;
          }
          AppMethodBeat.o(161681);
          return false;
        }
      });
      this.KOb.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean dsp()
        {
          AppMethodBeat.i(161682);
          View localView = ReaderAppUI.b(ReaderAppUI.this).getChildAt(ReaderAppUI.b(ReaderAppUI.this).getFirstVisiblePosition());
          if ((localView != null) && (localView.getTop() == 0))
          {
            AppMethodBeat.o(161682);
            return true;
          }
          AppMethodBeat.o(161682);
          return false;
        }
      });
      this.KOb.setIsBottomShowAll(true);
      this.NvZ.a(new x.a()
      {
        public final void bWC()
        {
          AppMethodBeat.i(161683);
          ReaderAppUI.e(ReaderAppUI.this).setIsTopShowAll(ReaderAppUI.c(ReaderAppUI.this).dmY());
          AppMethodBeat.o(161683);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(102724);
          ReaderAppUI.this.finish();
          AppMethodBeat.o(102724);
          return true;
        }
      });
      addIconOptionMenu(0, a.h.actionbar_setting, a.g.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(161684);
          com.tencent.mm.plugin.readerapp.b.a.pFn.c(new Intent().putExtra("Contact_User", ReaderAppUI.f(ReaderAppUI.this)), ReaderAppUI.this);
          AppMethodBeat.o(161684);
          return true;
        }
      });
      this.KNX.setSelection(this.NvZ.getShowCount() - 1 + this.KNX.getHeaderViewsCount());
      AppMethodBeat.o(102757);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ReaderAppUI", localException, "", new Object[0]);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102752);
    super.onCreate(paramBundle);
    this.hWJ = getIntent().getIntExtra("type", 0);
    Log.i("MicroMsg.ReaderAppUI", "[onCreate] readerType:%s", new Object[] { Integer.valueOf(this.hWJ) });
    this.hWJ = 20;
    density = com.tencent.mm.cd.a.getDensity(this);
    long l = System.currentTimeMillis();
    initView();
    Log.i("MicroMsg.ReaderAppUI", "[initView] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.Kgd = bx.vk(this.hWJ);
    if ((20 == this.hWJ) && (ac.b("newsapp", null) > 0)) {
      com.tencent.mm.plugin.report.service.h.OAn.b(13440, new Object[] { Integer.valueOf(2) });
    }
    AppMethodBeat.o(102752);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(102753);
    if (this.NvZ != null)
    {
      this.NvZ.fSd();
      this.NvZ.jhO();
    }
    super.onDestroy();
    AppMethodBeat.o(102753);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(102755);
    super.onPause();
    ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().Cv("");
    d.gFB().remove(this.NvZ);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxO(this.Kgd);
    AppMethodBeat.o(102755);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(102754);
    super.onResume();
    if (this.hWJ == 20) {
      setMMTitle(a.h.hardcode_plugin_readerappnews_nick);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().Cv(this.Kgd);
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().iH(this.Kgd);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxO(this.Kgd);
      d.gFB().add(this.NvZ);
      this.NvZ.onNotifyChange(null, null);
      bDL();
      AppMethodBeat.o(102754);
      return;
      setMMTitle(a.h.NvB);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends a<String>
  {
    private int Nwh;
    private int Nwi;
    private int Nwj;
    int Nwk;
    int Nwl;
    int Nwm;
    private Context context;
    private int lNX;
    private int vGe;
    private int vGf;
    private int vGg;
    private int vGh;
    private int vGj;
    private int wDI;
    
    public a(Context paramContext, String paramString)
    {
      super(paramString);
      AppMethodBeat.i(102732);
      this.Nwh = 0;
      this.vGh = 0;
      this.vGf = 0;
      this.vGg = 0;
      this.Nwi = 0;
      this.Nwj = 0;
      this.Nwk = 0;
      this.Nwl = 1;
      this.Nwm = 2;
      this.context = paramContext;
      this.wDI = 3;
      this.lNX = d.gFB().vn(ReaderAppUI.a(ReaderAppUI.this));
      this.vGh = paramContext.getResources().getDimensionPixelSize(a.c.SmallPadding);
      this.vGf = paramContext.getResources().getDimensionPixelSize(a.c.LargePadding);
      this.Nwh = paramContext.getResources().getDimensionPixelSize(a.c.BasicPaddingSize);
      this.vGg = paramContext.getResources().getDimensionPixelSize(a.c.MiddlePadding);
      this.vGe = paramContext.getResources().getDimensionPixelSize(a.c.chatting_item_biz_sub_item_pic_size);
      this.vGj = paramContext.getResources().getDimensionPixelSize(a.c.chatting_item_biz_line_big_padding);
      this$1 = com.tencent.mm.plugin.bizui.a.a.vtB;
      int i = com.tencent.mm.plugin.bizui.a.a.fK(paramContext);
      int j = com.tencent.mm.cd.a.mt(paramContext);
      if (i < j) {}
      for (;;)
      {
        this.Nwi = ((int)((i - (int)(ReaderAppUI.gFC() * 28.0F)) / 2.35D));
        this.Nwj = ((int)((i - ReaderAppUI.gFC() * 52.0F) / 2.0F) * 4 / 3);
        AppMethodBeat.o(102732);
        return;
        i = j;
      }
    }
    
    private static h.a a(bx parambx)
    {
      AppMethodBeat.i(289299);
      if (parambx == null)
      {
        AppMethodBeat.o(289299);
        return null;
      }
      h.a locala = new h.a();
      locala.url = parambx.getUrl();
      locala.vAZ = 164;
      locala.appId = "wx073f4a4daff0abe8";
      locala.title = parambx.getTitle();
      locala.desc = parambx.getDigest();
      locala.from = "message";
      AppMethodBeat.o(289299);
      return locala;
    }
    
    private void a(a parama, int paramInt, List<bx> paramList)
    {
      AppMethodBeat.i(102743);
      int i = paramList.size();
      if (paramInt == 1) {
        if (Util.isNullOrNil(((bx)paramList.get(0)).bCX()))
        {
          parama.plj.setVisibility(0);
          ad(parama.plj, this.vGf);
        }
      }
      while (paramInt == 1) {
        if (paramInt == i - 1)
        {
          parama.yBS.setPadding(0, this.vGf, 0, this.vGf);
          AppMethodBeat.o(102743);
          return;
          parama.plj.setVisibility(8);
          continue;
          parama.plj.setVisibility(0);
          bx localbx = (bx)paramList.get(paramInt - 1);
          paramList = (bx)paramList.get(paramInt);
          if ((Util.isNullOrNil(localbx.bCX())) || (Util.isNullOrNil(paramList.bCX()))) {
            ad(parama.plj, this.vGf);
          } else {
            ad(parama.plj, this.vGj);
          }
        }
        else
        {
          parama.yBS.setPadding(0, this.vGf, 0, this.vGh);
          AppMethodBeat.o(102743);
          return;
        }
      }
      if (paramInt == i - 1)
      {
        parama.yBS.setPadding(0, this.vGh, 0, this.vGf);
        AppMethodBeat.o(102743);
        return;
      }
      parama.yBS.setPadding(0, this.vGh, 0, this.vGh);
      AppMethodBeat.o(102743);
    }
    
    private static void a(b paramb, a parama)
    {
      AppMethodBeat.i(102731);
      if (paramb == null)
      {
        AppMethodBeat.o(102731);
        return;
      }
      paramb.Nws.addView(parama.vJU);
      paramb.vMK.add(parama);
      AppMethodBeat.o(102731);
    }
    
    private void a(b paramb, List<bx> paramList, int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(102740);
      a locala = new a();
      locala.vJU = View.inflate(this.context, paramInt1, null);
      if (paramInt1 == a.f.Nvv)
      {
        locala.vJU.setBackground(bb.c(ReaderAppUI.this.getResources().getDrawable(a.d.chatting_item_multi_middle), bd.bA(ReaderAppUI.this.getContext(), a.a.item_color_selector)));
        locala.mll = ((TextView)locala.vJU.findViewById(a.e.title));
        locala.vIK = ((ImageView)locala.vJU.findViewById(a.e.cover));
        locala.vMp = locala.vJU.findViewById(a.e.cover_area);
        locala.plj = locala.vJU.findViewById(a.e.top_line);
        locala.yBS = locala.vJU.findViewById(a.e.content_ll);
        a(paramb, locala);
        paramb = (bx)paramList.get(paramInt2);
        a(locala, paramInt2, paramList);
        locala.mll.setText(paramb.getTitle());
        locala.mll.setText(paramb.getTitle());
        if (Util.isNullOrNil(paramb.bCX())) {
          break label386;
        }
        locala.vIK.setVisibility(0);
        a(paramb.bCX(), locala.vIK, this.vGe, this.vGe);
      }
      for (;;)
      {
        paramList = ReaderAppUI.this.a(paramb, ReaderAppUI.a(ReaderAppUI.this), paramInt2, paramString);
        locala.vJU.setOnClickListener(paramList);
        paramList = (com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class);
        if (paramList != null)
        {
          paramList.a(paramb.getUrl(), 164, "wx073f4a4daff0abe8", paramb.getTitle(), paramb.getDigest(), "message", 16);
          paramList.dC(paramb.getUrl(), 16);
        }
        AppMethodBeat.o(102740);
        return;
        if (paramInt1 != a.f.Nvu) {
          break;
        }
        locala.vJU.setBackground(bb.c(ReaderAppUI.this.getResources().getDrawable(a.d.chatting_item_multi_bottom), bd.bA(ReaderAppUI.this.getContext(), a.a.item_color_selector)));
        break;
        label386:
        locala.vMp.setVisibility(8);
      }
    }
    
    private static void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102744);
      paramString = u.Om(paramString);
      com.tencent.mm.modelimage.loader.a locala = r.bKe();
      c.a locala1 = new c.a();
      locala1.oKE = a.b.chatting_item_biz_default_bg;
      locala1.oKp = true;
      locala1 = locala1.eG(paramInt1, paramInt2);
      locala1.oKe = new com.tencent.mm.pluginsdk.ui.applet.n();
      locala1.oKN = new e();
      locala1.fullPath = y.bpF(paramString);
      locala.a(paramString, paramImageView, locala1.bKx(), null, new com.tencent.mm.pluginsdk.ui.applet.m((byte)0));
      AppMethodBeat.o(102744);
    }
    
    private static void ac(View paramView, int paramInt)
    {
      AppMethodBeat.i(102741);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.height = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(102741);
    }
    
    private static void ad(View paramView, int paramInt)
    {
      AppMethodBeat.i(102742);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.rightMargin = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(102742);
    }
    
    private List<bx> agk(int paramInt)
    {
      AppMethodBeat.i(102739);
      Object localObject = getItem(paramInt);
      localObject = d.gFB().aP((String)localObject, 20);
      AppMethodBeat.o(102739);
      return localObject;
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(102736);
      String str = (String)super.getItem(paramInt);
      AppMethodBeat.o(102736);
      return str;
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(102735);
      long l = System.currentTimeMillis();
      this.lNX = d.gFB().vn(20);
      w(d.gFB().vm(this.wDI));
      Log.i("MicroMsg.ReaderAppUI", "[resetCursor] cost:%sms showCount:%s totalCount:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.wDI), Integer.valueOf(this.lNX) });
      super.notifyDataSetChanged();
      AppMethodBeat.o(102735);
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(102733);
      aNy();
      AppMethodBeat.o(102733);
    }
    
    public final boolean dmY()
    {
      return this.wDI >= this.lNX;
    }
    
    public final int dmZ()
    {
      AppMethodBeat.i(102734);
      if (dmY())
      {
        AppMethodBeat.o(102734);
        return 0;
      }
      this.wDI += 3;
      if (this.wDI <= this.lNX)
      {
        AppMethodBeat.o(102734);
        return 3;
      }
      this.wDI = this.lNX;
      int i = this.lNX;
      AppMethodBeat.o(102734);
      return i % 3;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(102737);
      List localList = agk(paramInt);
      if (Util.isNullOrNil(localList))
      {
        Log.e("MicroMsg.ReaderAppUI", "getItemViewType info is null");
        paramInt = this.Nwk;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      if (((bx)localList.get(0)).bCZ() == 1) {}
      for (paramInt = 1; (paramInt != 0) && (localList.size() >= 2); paramInt = 0)
      {
        paramInt = this.Nwl;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      paramInt = this.Nwk;
      AppMethodBeat.o(102737);
      return paramInt;
    }
    
    public final int getShowCount()
    {
      return this.wDI;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102738);
      if (getItemViewType(paramInt) == this.Nwl)
      {
        if (paramView == null)
        {
          paramViewGroup = new b();
          paramView = View.inflate(this.context, a.f.Nvt, null);
          paramViewGroup.vLJ = ((TextView)paramView.findViewById(a.e.Nvp));
          paramViewGroup.lKK = ((ImageView)paramView.findViewById(a.e.avatar_iv));
          paramViewGroup.pRg = ((TextView)paramView.findViewById(a.e.nick_name_tv));
          paramViewGroup.Nwv = new c();
          paramViewGroup.Nwv.vIV = paramView.findViewById(a.e.NuX);
          paramViewGroup.Nwv.gFD();
          paramViewGroup.Nww = new c();
          paramViewGroup.Nww.vIV = paramView.findViewById(a.e.NuY);
          paramViewGroup.Nww.gFD();
          paramView.setTag(paramViewGroup);
          localObject2 = agk(paramInt);
          if ((localObject2 == null) || (((List)localObject2).size() < 2)) {
            break label486;
          }
          paramView.setVisibility(0);
          localObject1 = (bx)((List)localObject2).get(0);
          paramViewGroup.vLJ.setText(com.tencent.mm.pluginsdk.platformtools.f.d(this.context, ((bx)localObject1).time, false));
          localObject3 = new c.a();
          ((c.a)localObject3).oKE = a.d.brand_default_head;
          ((c.a)localObject3).oKo = true;
          ((c.a)localObject3).nrc = true;
          r.bKe().a(((bx)localObject1).bCW(), paramViewGroup.lKK, ((c.a)localObject3).bKx());
          paramViewGroup.pRg.setText(((bx)localObject1).bCV());
          paramViewGroup.pRg.getPaint().setFakeBoldText(true);
          if (ReaderAppUI.i(ReaderAppUI.this) != null)
          {
            paramViewGroup.vLJ.setTextColor(ReaderAppUI.i(ReaderAppUI.this).XYa);
            if (!ReaderAppUI.i(ReaderAppUI.this).XYb) {
              break label461;
            }
            paramViewGroup.vLJ.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).XYc);
            label353:
            if (!ReaderAppUI.i(ReaderAppUI.this).XYd) {
              break label475;
            }
            paramViewGroup.vLJ.setBackgroundResource(a.d.chat_tips_bg);
            paramViewGroup.vLJ.setPadding(this.vGh, this.Nwh, this.vGh, this.Nwh);
          }
          label399:
          localObject2 = (bx)((List)localObject2).get(1);
          paramViewGroup.Nwv.a((bx)localObject1, paramInt, ((bx)localObject1).getTitle());
          paramViewGroup.Nww.a((bx)localObject2, paramInt, ((bx)localObject1).getTitle());
        }
        for (;;)
        {
          AppMethodBeat.o(102738);
          return paramView;
          paramViewGroup = (b)paramView.getTag();
          break;
          label461:
          paramViewGroup.vLJ.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break label353;
          label475:
          paramViewGroup.vLJ.setBackgroundColor(0);
          break label399;
          label486:
          paramView.setVisibility(8);
        }
      }
      if (paramView == null)
      {
        paramViewGroup = new b();
        paramView = View.inflate(this.context, a.f.Nvs, null);
        paramViewGroup.vLJ = ((TextView)paramView.findViewById(a.e.Nve));
        paramViewGroup.Nws = ((ViewGroup)paramView.findViewById(a.e.Nvb));
        paramViewGroup.Nwq = paramView.findViewById(a.e.fuQ);
        paramViewGroup.vJg = paramView.findViewById(a.e.fDM);
        paramViewGroup.vIX = ((ImageView)paramView.findViewById(a.e.press_mask_iv));
        paramViewGroup.Nwu = ((ImageView)paramView.findViewById(a.e.fDN));
        paramViewGroup.mll = ((TextView)paramView.findViewById(a.e.Nvf));
        paramViewGroup.Nwr = ((ImageView)paramView.findViewById(a.e.Nvd));
        paramViewGroup.KNR = ((TextView)paramView.findViewById(a.e.Nvc));
        paramViewGroup.vIV = paramView.findViewById(a.e.gaA);
        paramViewGroup.Nwt = ((MMNeat7extView)paramView.findViewById(a.e.gad));
        paramViewGroup.vMK = new ArrayList();
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject1 = paramViewGroup.vMK.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          paramViewGroup.Nws.removeView(((a)localObject2).vJU);
        }
        paramViewGroup = (b)paramView.getTag();
      }
      paramViewGroup.vMK.clear();
      Object localObject1 = agk(paramInt);
      label923:
      label965:
      int i;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int k = ((List)localObject1).size();
        localObject2 = (bx)((List)localObject1).get(0);
        paramViewGroup.vLJ.setText(com.tencent.mm.pluginsdk.platformtools.f.d(this.context, ((bx)localObject2).time, false));
        if (ReaderAppUI.i(ReaderAppUI.this) != null)
        {
          paramViewGroup.vLJ.setTextColor(ReaderAppUI.i(ReaderAppUI.this).XYa);
          if (ReaderAppUI.i(ReaderAppUI.this).XYb)
          {
            paramViewGroup.vLJ.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).XYc);
            if (!ReaderAppUI.i(ReaderAppUI.this).XYd) {
              break label1460;
            }
            paramViewGroup.vLJ.setBackgroundResource(a.d.chat_tips_bg);
            paramViewGroup.vLJ.setPadding(this.vGh, this.Nwh, this.vGh, this.Nwh);
          }
        }
        else
        {
          localObject3 = ReaderAppUI.this.a((bx)localObject2, ReaderAppUI.a(ReaderAppUI.this), 0, ((bx)localObject2).getTitle());
          paramViewGroup.vIV.setOnClickListener((View.OnClickListener)localObject3);
          if (k != 1) {
            break label1471;
          }
          bool = true;
          paramViewGroup.mll.setText(((bx)localObject2).getTitle());
          paramViewGroup.KNR.setText(((bx)localObject2).getDigest());
          if (Util.isNullOrNil(((bx)localObject2).bCX())) {
            break label1477;
          }
          i = 1;
          label1003:
          paramViewGroup.Nwt.aZ(((bx)localObject2).getTitle());
          localObject3 = paramViewGroup.KNR;
          if ((bool) && (!Util.isNullOrNil(((bx)localObject2).getDigest()))) {
            break label1483;
          }
        }
        label1460:
        label1471:
        label1477:
        label1483:
        for (int j = 8;; j = 0)
        {
          ((TextView)localObject3).setVisibility(j);
          paramViewGroup.Nwu.setVisibility(8);
          if (!bool) {
            break label1489;
          }
          paramViewGroup.vIX.setBackgroundResource(a.d.fns);
          paramViewGroup.Nwq.setVisibility(0);
          paramViewGroup.Nwt.setVisibility(8);
          paramViewGroup.mll.setVisibility(0);
          ac(paramViewGroup.vIX, this.Nwi);
          ac(paramViewGroup.vJg, this.Nwi);
          if (i == 0) {
            break label1591;
          }
          paramViewGroup.vJg.setVisibility(0);
          String str = ((bx)localObject2).bCX();
          localObject3 = paramViewGroup.Nwr;
          i = this.Nwi;
          localObject4 = new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(289244);
              if (!bool)
              {
                paramViewGroup.Nwt.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(a.b.white_text_color));
                paramViewGroup.Nwt.setBackgroundResource(a.d.biz_msg_cover_gradient_mask);
              }
              paramViewGroup.Nwu.setVisibility(0);
              AppMethodBeat.o(289244);
            }
            
            public final void onStart() {}
          };
          str = u.Om(str);
          j = a.d.fmC;
          int m = a.d.fmF;
          float f = ((ImageView)localObject3).getResources().getDimensionPixelSize(a.c.chatting_item_corners_size);
          Object localObject5 = com.tencent.mm.plugin.bizui.a.a.vtB;
          int n = com.tencent.mm.plugin.bizui.a.a.fK(ReaderAppUI.this.getContext()) - (int)(ReaderAppUI.gFC() * 28.0F);
          localObject5 = r.bKe();
          c.a locala = new c.a();
          locala.oKE = m;
          locala.oKp = true;
          locala.oKG = String.valueOf(j);
          locala = locala.eG(n, i);
          locala.oKe = new com.tencent.mm.pluginsdk.ui.applet.n();
          locala.oKN = new e();
          locala.fullPath = y.bpF(str);
          ((com.tencent.mm.modelimage.loader.a)localObject5).a(str, (ImageView)localObject3, locala.bKx(), null, new com.tencent.mm.pluginsdk.ui.applet.m(0, n, i, true, false, f, (m.a)localObject4));
          paramViewGroup.Nwq.setBackground(bb.e(ReaderAppUI.this.getResources().getDrawable(a.d.chatting_item_multbg_bottom_normal), this.context.getResources().getColor(a.b.BG_2)));
          paramViewGroup.Nwq.setPadding(this.vGf, this.vGg, this.vGf, this.vGf);
          paramViewGroup.vIX.setVisibility(0);
          if (k <= 1) {
            break label1724;
          }
          i = 1;
          while (i < k - 1)
          {
            a(paramViewGroup, (List)localObject1, a.f.Nvv, i, ((bx)localObject2).getTitle());
            i += 1;
          }
          paramViewGroup.vLJ.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break;
          paramViewGroup.vLJ.setBackgroundColor(0);
          break label923;
          bool = false;
          break label965;
          i = 0;
          break label1003;
        }
        label1489:
        paramViewGroup.vIX.setBackgroundResource(a.d.fnt);
        localObject3 = paramViewGroup.Nwq;
        if (i != 0) {}
        for (j = 8;; j = 0)
        {
          ((View)localObject3).setVisibility(j);
          paramViewGroup.mll.setVisibility(8);
          paramViewGroup.Nwt.setVisibility(0);
          paramViewGroup.Nwt.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(a.b.light_grey_text_color));
          paramViewGroup.Nwt.setBackgroundResource(a.d.mm_trans);
          paramViewGroup.Nwt.getPaint().setFakeBoldText(true);
          break;
        }
        label1591:
        paramViewGroup.vJg.setVisibility(8);
        paramViewGroup.mll.setVisibility(0);
        localObject3 = paramViewGroup.KNR;
        if (Util.isNullOrNil(((bx)localObject2).getDigest()))
        {
          i = 8;
          label1629:
          ((TextView)localObject3).setVisibility(i);
          if (!bool) {
            break label1692;
          }
          paramViewGroup.Nwq.setBackgroundResource(a.d.NuW);
        }
        for (;;)
        {
          paramViewGroup.Nwq.setPadding(this.vGf, this.vGf, this.vGf, this.vGf);
          paramViewGroup.vIX.setVisibility(8);
          break;
          i = 0;
          break label1629;
          label1692:
          paramViewGroup.Nwq.setBackgroundResource(a.d.chatting_item_multi_top);
        }
        a(paramViewGroup, (List)localObject1, a.f.Nvu, k - 1, ((bx)localObject2).getTitle());
        label1724:
        localObject3 = (com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class);
        if (localObject3 != null)
        {
          ((com.tencent.mm.plugin.brandservice.api.h)localObject3).a(((bx)localObject2).getUrl(), 164, "wx073f4a4daff0abe8", ((bx)localObject2).getTitle(), ((bx)localObject2).getDigest(), "message", 8);
          ((com.tencent.mm.plugin.brandservice.api.h)localObject3).dC(((bx)localObject2).getUrl(), 8);
        }
      }
      paramViewGroup.vIV.setTag(Integer.valueOf(paramInt));
      paramViewGroup.vIV.setTag(a.e.Nvh, Integer.valueOf(0));
      Object localObject2 = ReaderAppUI.h(ReaderAppUI.this);
      Object localObject3 = paramViewGroup.vIV;
      Object localObject4 = ReaderAppUI.this;
      if (((List)localObject1).size() == 1)
      {
        bool = true;
        ((com.tencent.mm.ui.widget.b.a)localObject2).a((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(ReaderAppUI.this));
        paramViewGroup = paramViewGroup.vMK.iterator();
        i = 1;
        label1879:
        if (!paramViewGroup.hasNext()) {
          break label2005;
        }
        localObject3 = (a)paramViewGroup.next();
        ((a)localObject3).vJU.setTag(Integer.valueOf(paramInt));
        ((a)localObject3).vJU.setTag(a.e.Nvh, Integer.valueOf(i));
        localObject2 = ReaderAppUI.h(ReaderAppUI.this);
        localObject3 = ((a)localObject3).vJU;
        localObject4 = ReaderAppUI.this;
        if (((List)localObject1).size() != 1) {
          break label1999;
        }
      }
      label1999:
      for (final boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.ui.widget.b.a)localObject2).a((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(ReaderAppUI.this));
        i += 1;
        break label1879;
        bool = false;
        break;
      }
      label2005:
      AppMethodBeat.o(102738);
      return paramView;
    }
    
    public final int getViewTypeCount()
    {
      return this.Nwm;
    }
    
    public final void kB(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102746);
      Log.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth startPos = %s, endPos = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(102746);
        return;
      }
      com.tencent.mm.plugin.brandservice.api.h localh = (com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class);
      if (localh == null)
      {
        Log.v("MicroMsg.ReaderAppUI", "checkPreauth WebPrefetcher null");
        AppMethodBeat.o(102746);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      while (paramInt1 <= paramInt2)
      {
        List localList = agk(paramInt1 - 1);
        if ((localList != null) && (localList.size() > 0))
        {
          localLinkedList.clear();
          h.a locala = a((bx)localList.get(0));
          if (locala != null)
          {
            localLinkedList.add(locala);
            localh.dC(locala.url, 8);
          }
          if (localLinkedList.size() > 0) {
            localh.z(localLinkedList, 8);
          }
          Log.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authTop = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
          localLinkedList.clear();
          int i = 1;
          while (i < localList.size())
          {
            locala = a((bx)localList.get(i));
            if (locala != null)
            {
              localLinkedList.add(locala);
              localh.dC(locala.url, 16);
            }
            i += 1;
          }
          if (localLinkedList.size() > 0) {
            localh.z(localLinkedList, 16);
          }
          Log.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authCommon = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
        }
        paramInt1 += 1;
      }
      AppMethodBeat.o(102746);
    }
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(102745);
      super.onScrollStateChanged(paramAbsListView, paramInt);
      if ((paramAbsListView != null) && (paramInt == 0)) {
        kB(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition());
      }
      AppMethodBeat.o(102745);
    }
    
    final class a
    {
      TextView mll;
      View plj;
      ImageView vIK;
      View vJU;
      View vMp;
      View yBS;
      
      a() {}
    }
    
    final class b
    {
      TextView KNR;
      View Nwq;
      ImageView Nwr;
      ViewGroup Nws;
      MMNeat7extView Nwt;
      ImageView Nwu;
      ReaderAppUI.a.c Nwv;
      ReaderAppUI.a.c Nww;
      ImageView lKK;
      TextView mll;
      TextView pRg;
      View vIV;
      ImageView vIX;
      View vJg;
      TextView vLJ;
      List<ReaderAppUI.a.a> vMK;
      
      b() {}
    }
    
    final class c
    {
      MMNeat7extView Ilr;
      ImageView NwA;
      TextView NwB;
      View Nwx;
      View Nwy;
      ImageView Nwz;
      ImageView coverIv;
      View vIV;
      
      c() {}
      
      final void a(bx parambx, int paramInt, String paramString)
      {
        AppMethodBeat.i(102730);
        paramString = ReaderAppUI.this.a(parambx, ReaderAppUI.a(ReaderAppUI.this), 0, paramString);
        if (this.vIV == null)
        {
          AppMethodBeat.o(102730);
          return;
        }
        this.vIV.setOnClickListener(paramString);
        this.vIV.setTag(Integer.valueOf(paramInt));
        this.vIV.setTag(a.e.Nvh, Integer.valueOf(paramInt));
        ReaderAppUI.h(ReaderAppUI.this).a(this.vIV, ReaderAppUI.a(ReaderAppUI.this, false), ReaderAppUI.g(ReaderAppUI.this));
        this.Ilr.aZ(parambx.getTitle());
        paramString = com.tencent.mm.message.m.uD(parambx.bDa());
        if (!Util.isNullOrNil(paramString))
        {
          this.NwB.setText(paramString);
          this.Nwx.setVisibility(0);
        }
        for (;;)
        {
          this.Ilr.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(a.b.light_grey_text_color));
          this.Nwy.setBackgroundResource(a.d.mm_trans);
          paramInt = (int)(this.NwB.getTextSize() * 1.7D);
          paramString = this.NwA.getLayoutParams();
          paramString.height = paramInt;
          paramString.width = paramInt;
          this.NwA.setLayoutParams(paramString);
          ReaderAppUI.a.aN(this.coverIv, ReaderAppUI.a.a(ReaderAppUI.a.this));
          ReaderAppUI.a.a(ReaderAppUI.a.this, parambx.bCX(), this.coverIv, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(102728);
              ReaderAppUI.a.c.this.Ilr.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(a.b.white_text_color));
              ReaderAppUI.a.c.this.Nwy.setBackgroundResource(a.d.weishi_cover_gradient_round_mask);
              AppMethodBeat.o(102728);
            }
            
            public final void onStart() {}
          });
          AppMethodBeat.o(102730);
          return;
          this.Nwx.setVisibility(8);
        }
      }
      
      final void gFD()
      {
        AppMethodBeat.i(102729);
        if (this.vIV == null)
        {
          AppMethodBeat.o(102729);
          return;
        }
        this.coverIv = ((ImageView)this.vIV.findViewById(a.e.Nvo));
        this.Nwz = ((ImageView)this.vIV.findViewById(a.e.press_mask_iv));
        this.Ilr = ((MMNeat7extView)this.vIV.findViewById(a.e.gad));
        this.NwB = ((TextView)this.vIV.findViewById(a.e.Nvm));
        this.NwA = ((ImageView)this.vIV.findViewById(a.e.NuZ));
        this.Nwx = this.vIV.findViewById(a.e.Nva);
        this.Nwy = this.vIV.findViewById(a.e.Nvn);
        AppMethodBeat.o(102729);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI
 * JD-Core Version:    0.7.0.1
 */