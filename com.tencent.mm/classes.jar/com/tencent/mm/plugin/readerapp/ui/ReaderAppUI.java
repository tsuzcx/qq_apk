package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html.ImageGetter;
import android.text.TextPaint;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@i
public class ReaderAppUI
  extends MMActivity
{
  private static float density;
  private int dsp;
  private View iMi;
  private n.d nAc;
  private com.tencent.mm.ui.widget.b.a nym;
  private ListView uES;
  private MMPullDownView uEW;
  private String uaS;
  private a<String> weL;
  private com.tencent.mm.pluginsdk.ui.e weM;
  private int weN;
  
  public ReaderAppUI()
  {
    AppMethodBeat.i(102751);
    this.dsp = 0;
    this.uaS = "";
    this.weM = null;
    this.weN = 0;
    this.nAc = new n.d()
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
          if (!bs.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.plugin.readerapp.c.g.ep((String)localObject1, ReaderAppUI.a(ReaderAppUI.this));
            paramAnonymousMenuItem = com.tencent.mm.plugin.readerapp.c.g.dtg();
            paramAnonymousInt = ReaderAppUI.a(ReaderAppUI.this);
            localObject1 = "delete from " + bp.oa(paramAnonymousInt) + " where reserved3 = " + com.tencent.mm.storagebase.h.ty((String)localObject1);
            ac.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[] { localObject1 });
            if (paramAnonymousMenuItem.hpA.execSQL(bp.oa(paramAnonymousInt), (String)localObject1))
            {
              paramAnonymousMenuItem.oe(paramAnonymousInt);
              paramAnonymousMenuItem.doNotify();
            }
          }
          ReaderAppUI.this.refresh();
          AppMethodBeat.o(161679);
          return;
          if (ReaderAppUI.a(ReaderAppUI.this) == 20)
          {
            paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
            paramAnonymousMenuItem = com.tencent.mm.plugin.readerapp.c.g.dtg().ad(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
            Object localObject2;
            if (paramAnonymousMenuItem.size() > 0)
            {
              paramAnonymousMenuItem = (bo)paramAnonymousMenuItem.get(0);
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
              ((Intent)localObject1).putExtra("Retr_Msg_thumb_path", r.aGc(paramAnonymousMenuItem.azl()));
              ((Intent)localObject1).putExtra("Retr_Msg_Id", 7377812);
              localObject2 = y.xJ(paramAnonymousMenuItem.hpu);
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              localObject2 = y.ayq().F((String)localObject2, true);
              ((y.b)localObject2).l("prePublishId", "msg_" + paramAnonymousMenuItem.hpu);
              ((y.b)localObject2).l("preUsername", "newsapp");
              ((y.b)localObject2).l("preChatName", "newsapp");
              ((y.b)localObject2).l("preMsgIndex", Integer.valueOf(0));
              ((y.b)localObject2).l("sendAppMsgScene", Integer.valueOf(1));
              com.tencent.mm.plugin.readerapp.b.a.iyx.k((Intent)localObject1, ReaderAppUI.this);
            }
            AppMethodBeat.o(161679);
            return;
            if (ReaderAppUI.a(ReaderAppUI.this) == 20)
            {
              paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
              localObject1 = com.tencent.mm.plugin.readerapp.c.g.dtg().ad(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
              if (!((List)localObject1).isEmpty())
              {
                ac.i("MicroMsg.ReaderAppUI", "fav functionId %s, index %d, size %d", new Object[] { paramAnonymousMenuItem, Integer.valueOf(ReaderAppUI.d(ReaderAppUI.this)), Integer.valueOf(((List)localObject1).size()) });
                if (ReaderAppUI.d(ReaderAppUI.this) >= ((List)localObject1).size()) {
                  ReaderAppUI.a(ReaderAppUI.this, 0);
                }
                paramAnonymousMenuItem = (bo)((List)localObject1).get(ReaderAppUI.d(ReaderAppUI.this));
                localObject1 = new cs();
                localObject2 = y.xJ(paramAnonymousMenuItem.hpu);
                y.b localb = y.ayq().F((String)localObject2, true);
                localb.l("prePublishId", "msg_" + paramAnonymousMenuItem.hpu);
                localb.l("preUsername", "newsapp");
                localb.l("preChatName", "newsapp");
                localb.l("preMsgIndex", Integer.valueOf(0));
                localb.l("sendAppMsgScene", Integer.valueOf(1));
                ((cs)localObject1).dck.sessionId = ((String)localObject2);
                ReaderAppUI.d(ReaderAppUI.this);
                com.tencent.mm.plugin.readerapp.c.b.a((cs)localObject1, paramAnonymousMenuItem);
                ((cs)localObject1).dck.dcq = 7;
                ((cs)localObject1).dck.activity = ReaderAppUI.this;
                com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
              }
            }
          }
        }
      }
    };
    AppMethodBeat.o(102751);
  }
  
  private PackageInfo aqk(String paramString)
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
      ac.printErrStackTrace("MicroMsg.ReaderAppUI", paramString, "", new Object[0]);
      AppMethodBeat.o(102759);
    }
    return null;
  }
  
  public final View.OnClickListener a(final bo parambo, final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(102758);
    if (parambo != null)
    {
      String str1 = com.tencent.mm.pluginsdk.ui.tools.x.aId(parambo.getUrl());
      String str2 = com.tencent.mm.pluginsdk.ui.tools.x.aId(paramString);
      String str3 = com.tencent.mm.pluginsdk.ui.tools.x.aId(parambo.getTitle());
      com.tencent.mm.plugin.report.service.h.wUl.f(15413, new Object[] { Integer.valueOf(9), str2, str3, parambo.azp(), parambo.azh(), str1, Integer.valueOf(parambo.azq()), Integer.valueOf(parambo.azn()) });
    }
    parambo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(161677);
        if (20 == paramInt1)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(15413, new Object[] { Integer.valueOf(8), paramString, parambo.getTitle() });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("mode", 1);
          Object localObject = parambo.getUrl();
          paramAnonymousView.putExtra("news_svr_id", parambo.hpu);
          paramAnonymousView.putExtra("news_svr_tweetid", parambo.azh());
          paramAnonymousView.putExtra("rawUrl", ReaderAppUI.a(ReaderAppUI.this, (String)localObject));
          paramAnonymousView.putExtra("title", parambo.getName());
          paramAnonymousView.putExtra("webpageTitle", parambo.getTitle());
          paramAnonymousView.putExtra("key_show_web_page_title", true);
          paramAnonymousView.putExtra("useJs", true);
          paramAnonymousView.putExtra("vertical_scroll", true);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("snsWebSource", 3);
          paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject);
          paramAnonymousView.putExtra("shortUrl", parambo.azi());
          paramAnonymousView.putExtra("type", parambo.type);
          paramAnonymousView.putExtra("tweetid", parambo.azh());
          paramAnonymousView.putExtra("geta8key_username", "newsapp");
          paramAnonymousView.putExtra("KPublisherId", "msg_" + Long.toString(parambo.hpu));
          paramAnonymousView.putExtra("pre_username", "newsapp");
          paramAnonymousView.putExtra("prePublishId", "msg_" + Long.toString(parambo.hpu));
          paramAnonymousView.putExtra("preUsername", "newsapp");
          paramAnonymousView.putExtra("preChatName", "newsapp");
          paramAnonymousView.putExtra("preMsgIndex", paramInt2);
          paramAnonymousView.putExtra("geta8key_scene", 66);
          paramAnonymousView.putExtra("webview_scene_type", 1);
          paramAnonymousView.putExtra("webview_scene_note", com.tencent.mm.pluginsdk.ui.tools.x.aId(String.format("%d|%d|%s|%s|%s", new Object[] { Integer.valueOf(parambo.azq()), Integer.valueOf(parambo.azn()), parambo.azp(), paramString, parambo.azh() })));
          paramAnonymousView.putExtra("bizEnterId", (int)(System.currentTimeMillis() / 1000L));
          paramAnonymousView.putExtra("KOpenArticleSceneFromScene", 0);
          paramAnonymousView.addFlags(536870912);
          com.tencent.mm.plugin.readerapp.b.a.iyx.i(paramAnonymousView, ReaderAppUI.this);
        }
        AppMethodBeat.o(161677);
      }
    };
    AppMethodBeat.o(102758);
    return parambo;
  }
  
  public int getLayoutId()
  {
    return 2131495175;
  }
  
  public void initView()
  {
    AppMethodBeat.i(102757);
    try
    {
      this.weM = new com.tencent.mm.pluginsdk.ui.e(bs.convertStreamToString(getAssets().open("chatting/purecolor_chat.xml")), this);
      this.uES = ((ListView)findViewById(2131303774));
      this.uEW = ((MMPullDownView)findViewById(2131303777));
      this.uEW.setIsReturnSuperDispatchWhenCancel(true);
      this.iMi = getLayoutInflater().inflate(2131495179, null);
      this.uES.addHeaderView(this.iMi);
      ((TextView)findViewById(2131299468)).setText(2131762171);
      this.weL = new a(this, "");
      this.uES.setOnScrollListener(this.weL);
      this.uES.setAdapter(this.weL);
      this.uES.setTranscriptMode(0);
      registerForContextMenu(this.uES);
      this.nym = new com.tencent.mm.ui.widget.b.a(this);
      if (this.weL.getCount() == 0)
      {
        Object localObject = new Intent(this, ReaderAppIntroUI.class);
        ((Intent)localObject).putExtra("type", this.dsp);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(102757);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ReaderAppUI", localException, "", new Object[0]);
      }
      this.uEW.setOnTopLoadDataListener(new MMPullDownView.g()
      {
        public final boolean bWA()
        {
          AppMethodBeat.i(161680);
          if (ReaderAppUI.c(ReaderAppUI.this).bSw())
          {
            ReaderAppUI.b(ReaderAppUI.this).setSelectionFromTop(0, ReaderAppUI.e(ReaderAppUI.this).getTopHeight());
            AppMethodBeat.o(161680);
            return true;
          }
          int i = ReaderAppUI.c(ReaderAppUI.this).getCount();
          int j = ReaderAppUI.c(ReaderAppUI.this).bSx();
          ac.v("MicroMsg.ReaderAppUI", "onLoadData add count:".concat(String.valueOf(j)));
          ReaderAppUI.c(ReaderAppUI.this).a(null, null);
          int k = ReaderAppUI.c(ReaderAppUI.this).getCount();
          ac.d("MicroMsg.ReaderAppUI", "onTopLoadData nowCount:%d, preCount:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
          if (k > i)
          {
            ac.i("MicroMsg.ReaderAppUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", new Object[] { Integer.valueOf(j + 1), Integer.valueOf(ReaderAppUI.e(ReaderAppUI.this).getTopHeight()) });
            com.tencent.mm.pluginsdk.ui.tools.n.a(ReaderAppUI.b(ReaderAppUI.this), j + 1, ReaderAppUI.e(ReaderAppUI.this).getTopHeight(), false);
          }
          AppMethodBeat.o(161680);
          return true;
        }
      });
      this.uEW.setTopViewVisible(true);
      this.uEW.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean bWz()
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
      this.uEW.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean bWy()
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
      this.uEW.setIsBottomShowAll(true);
      this.weL.a(new r.a()
      {
        public final void aPg()
        {
          AppMethodBeat.i(161683);
          ReaderAppUI.e(ReaderAppUI.this).setIsTopShowAll(ReaderAppUI.c(ReaderAppUI.this).bSw());
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
      addIconOptionMenu(0, 2131755131, 2131689511, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(161684);
          com.tencent.mm.plugin.readerapp.b.a.iyx.c(new Intent().putExtra("Contact_User", ReaderAppUI.f(ReaderAppUI.this)), ReaderAppUI.this);
          AppMethodBeat.o(161684);
          return true;
        }
      });
      this.uES.setSelection(this.weL.getShowCount() - 1 + this.uES.getHeaderViewsCount());
      AppMethodBeat.o(102757);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102752);
    super.onCreate(paramBundle);
    this.dsp = getIntent().getIntExtra("type", 0);
    ac.i("MicroMsg.ReaderAppUI", "[onCreate] readerType:%s", new Object[] { Integer.valueOf(this.dsp) });
    this.dsp = 20;
    density = com.tencent.mm.cc.a.getDensity(this);
    long l = System.currentTimeMillis();
    initView();
    ac.i("MicroMsg.ReaderAppUI", "[initView] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.uaS = bo.nZ(this.dsp);
    if ((20 == this.dsp) && (com.tencent.mm.model.x.aD("newsapp", null) > 0)) {
      com.tencent.mm.plugin.report.service.h.wUl.f(13440, new Object[] { Integer.valueOf(2) });
    }
    AppMethodBeat.o(102752);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(102753);
    if (this.weL != null)
    {
      this.weL.cVi();
      this.weL.feY();
    }
    super.onDestroy();
    AppMethodBeat.o(102753);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(102755);
    super.onPause();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().rA("");
    com.tencent.mm.plugin.readerapp.c.g.dtg().remove(this.weL);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNK(this.uaS);
    AppMethodBeat.o(102755);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(102754);
    super.onResume();
    if (this.dsp == 20) {
      setMMTitle(2131760208);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().rA(this.uaS);
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(this.uaS);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNK(this.uaS);
      com.tencent.mm.plugin.readerapp.c.g.dtg().add(this.weL);
      this.weL.a(null, null);
      refresh();
      AppMethodBeat.o(102754);
      return;
      setMMTitle(2131760211);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(102756);
    TextView localTextView = (TextView)findViewById(2131299468);
    int i;
    if (this.dsp == 20)
    {
      i = 2131762179;
      localTextView.setText(i);
      if (this.weL.getCount() != 0) {
        break label97;
      }
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      if ((this.uES != null) && ((this.weL instanceof a))) {
        this.uES.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161678);
            ((ReaderAppUI.a)ReaderAppUI.c(ReaderAppUI.this)).gN(ReaderAppUI.b(ReaderAppUI.this).getFirstVisiblePosition(), ReaderAppUI.b(ReaderAppUI.this).getLastVisiblePosition());
            AppMethodBeat.o(161678);
          }
        });
      }
      AppMethodBeat.o(102756);
      return;
      i = 2131762185;
      break;
      label97:
      localTextView.setVisibility(8);
    }
  }
  
  final class a
    extends a<String>
  {
    private Context context;
    private int fAw;
    private int nza;
    private int nzb;
    private int nzc;
    private int nzd;
    private int nzf;
    private int ofG;
    private Html.ImageGetter weT;
    private int weU;
    private int weV;
    private int weW;
    int weX;
    int weY;
    int weZ;
    
    public a(Context paramContext, String paramString)
    {
      super(paramString);
      AppMethodBeat.i(102732);
      this.weT = new Html.ImageGetter()
      {
        public final Drawable getDrawable(String paramAnonymousString)
        {
          AppMethodBeat.i(102726);
          int i = bs.getInt(paramAnonymousString, 0);
          paramAnonymousString = ReaderAppUI.this.getResources().getDrawable(i);
          paramAnonymousString.setBounds(0, 0, paramAnonymousString.getIntrinsicWidth(), paramAnonymousString.getIntrinsicHeight());
          AppMethodBeat.o(102726);
          return paramAnonymousString;
        }
      };
      this.weU = 0;
      this.nzd = 0;
      this.nzb = 0;
      this.nzc = 0;
      this.weV = 0;
      this.weW = 0;
      this.weX = 0;
      this.weY = 1;
      this.weZ = 2;
      this.context = paramContext;
      this.ofG = 3;
      this.fAw = com.tencent.mm.plugin.readerapp.c.g.dtg().oc(ReaderAppUI.a(ReaderAppUI.this));
      this.nzd = paramContext.getResources().getDimensionPixelSize(2131165568);
      this.nzb = paramContext.getResources().getDimensionPixelSize(2131165480);
      this.weU = paramContext.getResources().getDimensionPixelSize(2131165187);
      this.nzc = paramContext.getResources().getDimensionPixelSize(2131165500);
      this.nza = paramContext.getResources().getDimensionPixelSize(2131166025);
      this.nzf = paramContext.getResources().getDimensionPixelSize(2131166023);
      int i = com.tencent.mm.cc.a.ig(paramContext);
      int j = com.tencent.mm.cc.a.ih(paramContext);
      if (i < j) {}
      for (;;)
      {
        this.weV = ((int)((i - (int)(ReaderAppUI.dth() * 28.0F)) / 2.35D));
        this.weW = ((int)((i - ReaderAppUI.dth() * 52.0F) / 2.0F) * 4 / 3);
        AppMethodBeat.o(102732);
        return;
        i = j;
      }
    }
    
    private List<bo> LU(int paramInt)
    {
      AppMethodBeat.i(102739);
      Object localObject = getItem(paramInt);
      localObject = com.tencent.mm.plugin.readerapp.c.g.dtg().ad((String)localObject, 20);
      AppMethodBeat.o(102739);
      return localObject;
    }
    
    private static void W(View paramView, int paramInt)
    {
      AppMethodBeat.i(102741);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.height = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(102741);
    }
    
    private static void X(View paramView, int paramInt)
    {
      AppMethodBeat.i(102742);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.rightMargin = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(102742);
    }
    
    private static d.a a(bo parambo)
    {
      AppMethodBeat.i(194867);
      if (parambo == null)
      {
        AppMethodBeat.o(194867);
        return null;
      }
      d.a locala = new d.a();
      locala.url = parambo.getUrl();
      locala.nuJ = 164;
      locala.appId = "wx073f4a4daff0abe8";
      locala.title = parambo.getTitle();
      locala.desc = parambo.getDigest();
      locala.dsT = "message";
      AppMethodBeat.o(194867);
      return locala;
    }
    
    private void a(a parama, int paramInt, List<bo> paramList)
    {
      AppMethodBeat.i(102743);
      int i = paramList.size();
      if (paramInt == 1) {
        if (bs.isNullOrNil(((bo)paramList.get(0)).azl()))
        {
          parama.ijv.setVisibility(0);
          X(parama.ijv, this.nzb);
        }
      }
      while (paramInt == 1) {
        if (paramInt == i - 1)
        {
          parama.nCh.setPadding(0, this.nzb, 0, this.nzb);
          AppMethodBeat.o(102743);
          return;
          parama.ijv.setVisibility(8);
          continue;
          parama.ijv.setVisibility(0);
          bo localbo = (bo)paramList.get(paramInt - 1);
          paramList = (bo)paramList.get(paramInt);
          if ((bs.isNullOrNil(localbo.azl())) || (bs.isNullOrNil(paramList.azl()))) {
            X(parama.ijv, this.nzb);
          } else {
            X(parama.ijv, this.nzf);
          }
        }
        else
        {
          parama.nCh.setPadding(0, this.nzb, 0, this.nzd);
          AppMethodBeat.o(102743);
          return;
        }
      }
      if (paramInt == i - 1)
      {
        parama.nCh.setPadding(0, this.nzd, 0, this.nzb);
        AppMethodBeat.o(102743);
        return;
      }
      parama.nCh.setPadding(0, this.nzd, 0, this.nzd);
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
      paramb.wfe.addView(parama.nBh);
      paramb.nCU.add(parama);
      AppMethodBeat.o(102731);
    }
    
    private void a(b paramb, List<bo> paramList, int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(102740);
      a locala = new a();
      locala.nBh = View.inflate(this.context, paramInt1, null);
      if (paramInt1 == 2131495189)
      {
        locala.nBh.setBackground(am.c(ReaderAppUI.this.getResources().getDrawable(2131231693), ao.jK(ReaderAppUI.this.getContext())));
        locala.fUk = ((TextView)locala.nBh.findViewById(2131305902));
        locala.nCl = ((ImageView)locala.nBh.findViewById(2131298813));
        locala.nCk = locala.nBh.findViewById(2131298814);
        locala.ijv = locala.nBh.findViewById(2131306012);
        locala.nCh = locala.nBh.findViewById(2131298764);
        a(paramb, locala);
        paramb = (bo)paramList.get(paramInt2);
        a(locala, paramInt2, paramList);
        locala.fUk.setText(paramb.getTitle());
        locala.fUk.setText(paramb.getTitle());
        if (bs.isNullOrNil(paramb.azl())) {
          break label380;
        }
        locala.nCl.setVisibility(0);
        a(paramb.azl(), locala.nCl, this.nza, this.nza);
      }
      for (;;)
      {
        paramList = ReaderAppUI.this.a(paramb, ReaderAppUI.a(ReaderAppUI.this), paramInt2, paramString);
        locala.nBh.setOnClickListener(paramList);
        paramList = (com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class);
        if (paramList != null)
        {
          paramList.a(paramb.getUrl(), 164, "wx073f4a4daff0abe8", paramb.getTitle(), paramb.getDigest(), "message", 16);
          paramList.cr(paramb.getUrl(), 16);
        }
        AppMethodBeat.o(102740);
        return;
        if (paramInt1 != 2131495188) {
          break;
        }
        locala.nBh.setBackground(am.c(ReaderAppUI.this.getResources().getDrawable(2131231692), ao.jK(ReaderAppUI.this.getContext())));
        break;
        label380:
        locala.nCk.setVisibility(8);
      }
    }
    
    private static void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102744);
      paramString = q.Cx(paramString);
      com.tencent.mm.av.a.a locala = o.aFB();
      c.a locala1 = new c.a();
      locala1.hKL = 2131100141;
      locala1.hKx = true;
      locala1 = locala1.de(paramInt1, paramInt2);
      locala1.hKm = new com.tencent.mm.pluginsdk.ui.applet.n();
      locala1.hKU = new com.tencent.mm.pluginsdk.ui.applet.e();
      locala1.gKe = r.aGc(paramString);
      locala.a(paramString, paramImageView, locala1.aFT(), null, new com.tencent.mm.pluginsdk.ui.applet.m((byte)0));
      AppMethodBeat.o(102744);
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(102736);
      String str = (String)super.getItem(paramInt);
      AppMethodBeat.o(102736);
      return str;
    }
    
    public final void Xb()
    {
      AppMethodBeat.i(102735);
      long l = System.currentTimeMillis();
      this.fAw = com.tencent.mm.plugin.readerapp.c.g.dtg().oc(20);
      setCursor(com.tencent.mm.plugin.readerapp.c.g.dtg().ob(this.ofG));
      ac.i("MicroMsg.ReaderAppUI", "[resetCursor] cost:%sms showCount:%s totalCount:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.ofG), Integer.valueOf(this.fAw) });
      super.notifyDataSetChanged();
      AppMethodBeat.o(102735);
    }
    
    public final void Xc()
    {
      AppMethodBeat.i(102733);
      Xb();
      AppMethodBeat.o(102733);
    }
    
    public final boolean bSw()
    {
      return this.ofG >= this.fAw;
    }
    
    public final int bSx()
    {
      AppMethodBeat.i(102734);
      if (bSw())
      {
        AppMethodBeat.o(102734);
        return 0;
      }
      this.ofG += 3;
      if (this.ofG <= this.fAw)
      {
        AppMethodBeat.o(102734);
        return 3;
      }
      this.ofG = this.fAw;
      int i = this.fAw;
      AppMethodBeat.o(102734);
      return i % 3;
    }
    
    public final void gN(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102746);
      ac.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth startPos = %s, endPos = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(102746);
        return;
      }
      com.tencent.mm.plugin.brandservice.a.d locald = (com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class);
      if (locald == null)
      {
        ac.v("MicroMsg.ReaderAppUI", "checkPreauth WebPrefetcher null");
        AppMethodBeat.o(102746);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      while (paramInt1 <= paramInt2)
      {
        List localList = LU(paramInt1 - 1);
        if ((localList != null) && (localList.size() > 0))
        {
          localLinkedList.clear();
          d.a locala = a((bo)localList.get(0));
          if (locala != null)
          {
            localLinkedList.add(locala);
            locald.cr(locala.url, 8);
          }
          if (localLinkedList.size() > 0) {
            locald.l(localLinkedList, 8);
          }
          ac.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authTop = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
          localLinkedList.clear();
          int i = 1;
          while (i < localList.size())
          {
            locala = a((bo)localList.get(i));
            if (locala != null)
            {
              localLinkedList.add(locala);
              locald.cr(locala.url, 16);
            }
            i += 1;
          }
          if (localLinkedList.size() > 0) {
            locald.l(localLinkedList, 16);
          }
          ac.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authCommon = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
        }
        paramInt1 += 1;
      }
      AppMethodBeat.o(102746);
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(102737);
      List localList = LU(paramInt);
      if (bs.gY(localList))
      {
        ac.e("MicroMsg.ReaderAppUI", "getItemViewType info is null");
        paramInt = this.weX;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      if (((bo)localList.get(0)).azn() == 1) {}
      for (paramInt = 1; (paramInt != 0) && (localList.size() >= 2); paramInt = 0)
      {
        paramInt = this.weY;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      paramInt = this.weX;
      AppMethodBeat.o(102737);
      return paramInt;
    }
    
    public final int getShowCount()
    {
      return this.ofG;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102738);
      if (getItemViewType(paramInt) == this.weY)
      {
        if (paramView == null)
        {
          paramViewGroup = new b();
          paramView = View.inflate(this.context, 2131495186, null);
          paramViewGroup.toC = ((TextView)paramView.findViewById(2131306963));
          paramViewGroup.fxQ = ((ImageView)paramView.findViewById(2131297008));
          paramViewGroup.iIU = ((TextView)paramView.findViewById(2131302860));
          paramViewGroup.wfh = new c();
          paramViewGroup.wfh.nCN = paramView.findViewById(2131298819);
          paramViewGroup.wfh.dti();
          paramViewGroup.wfi = new c();
          paramViewGroup.wfi.nCN = paramView.findViewById(2131298820);
          paramViewGroup.wfi.dti();
          paramView.setTag(paramViewGroup);
          localObject2 = LU(paramInt);
          if ((localObject2 == null) || (((List)localObject2).size() < 2)) {
            break label486;
          }
          paramView.setVisibility(0);
          localObject1 = (bo)((List)localObject2).get(0);
          paramViewGroup.toC.setText(com.tencent.mm.pluginsdk.g.h.c(this.context, ((bo)localObject1).time, false));
          localObject3 = new c.a();
          ((c.a)localObject3).hKL = 2131231342;
          ((c.a)localObject3).hKw = true;
          ((c.a)localObject3).gLt = true;
          o.aFB().a(((bo)localObject1).azk(), paramViewGroup.fxQ, ((c.a)localObject3).aFT());
          paramViewGroup.iIU.setText(((bo)localObject1).azj());
          paramViewGroup.iIU.getPaint().setFakeBoldText(true);
          if (ReaderAppUI.i(ReaderAppUI.this) != null)
          {
            paramViewGroup.toC.setTextColor(ReaderAppUI.i(ReaderAppUI.this).DmY);
            if (!ReaderAppUI.i(ReaderAppUI.this).DmZ) {
              break label461;
            }
            paramViewGroup.toC.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).Dna);
            label353:
            if (!ReaderAppUI.i(ReaderAppUI.this).Dnb) {
              break label475;
            }
            paramViewGroup.toC.setBackgroundResource(2131231582);
            paramViewGroup.toC.setPadding(this.nzd, this.weU, this.nzd, this.weU);
          }
          label399:
          localObject2 = (bo)((List)localObject2).get(1);
          paramViewGroup.wfh.a((bo)localObject1, paramInt, ((bo)localObject1).getTitle());
          paramViewGroup.wfi.a((bo)localObject2, paramInt, ((bo)localObject1).getTitle());
        }
        for (;;)
        {
          AppMethodBeat.o(102738);
          return paramView;
          paramViewGroup = (b)paramView.getTag();
          break;
          label461:
          paramViewGroup.toC.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break label353;
          label475:
          paramViewGroup.toC.setBackgroundColor(0);
          break label399;
          label486:
          paramView.setVisibility(8);
        }
      }
      if (paramView == null)
      {
        paramViewGroup = new b();
        paramView = View.inflate(this.context, 2131495181, null);
        paramViewGroup.toC = ((TextView)paramView.findViewById(2131303764));
        paramViewGroup.wfe = ((ViewGroup)paramView.findViewById(2131303759));
        paramViewGroup.iSJ = paramView.findViewById(2131297444);
        paramViewGroup.nDr = paramView.findViewById(2131298818);
        paramViewGroup.nCx = ((ImageView)paramView.findViewById(2131303387));
        paramViewGroup.wfg = ((ImageView)paramView.findViewById(2131298831));
        paramViewGroup.fUk = ((TextView)paramView.findViewById(2131303765));
        paramViewGroup.wfd = ((ImageView)paramView.findViewById(2131303763));
        paramViewGroup.uEM = ((TextView)paramView.findViewById(2131303762));
        paramViewGroup.nCN = paramView.findViewById(2131305992);
        paramViewGroup.wff = ((MMNeat7extView)paramView.findViewById(2131305946));
        paramViewGroup.nCU = new ArrayList();
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject1 = paramViewGroup.nCU.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          paramViewGroup.wfe.removeView(((a)localObject2).nBh);
        }
        paramViewGroup = (b)paramView.getTag();
      }
      paramViewGroup.nCU.clear();
      Object localObject1 = LU(paramInt);
      label923:
      label965:
      int i;
      label1003:
      Object localObject5;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int k = ((List)localObject1).size();
        localObject2 = (bo)((List)localObject1).get(0);
        paramViewGroup.toC.setText(com.tencent.mm.pluginsdk.g.h.c(this.context, ((bo)localObject2).time, false));
        if (ReaderAppUI.i(ReaderAppUI.this) != null)
        {
          paramViewGroup.toC.setTextColor(ReaderAppUI.i(ReaderAppUI.this).DmY);
          if (ReaderAppUI.i(ReaderAppUI.this).DmZ)
          {
            paramViewGroup.toC.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).Dna);
            if (!ReaderAppUI.i(ReaderAppUI.this).Dnb) {
              break label1444;
            }
            paramViewGroup.toC.setBackgroundResource(2131231582);
            paramViewGroup.toC.setPadding(this.nzd, this.weU, this.nzd, this.weU);
          }
        }
        else
        {
          localObject3 = ReaderAppUI.this.a((bo)localObject2, ReaderAppUI.a(ReaderAppUI.this), 0, ((bo)localObject2).getTitle());
          paramViewGroup.nCN.setOnClickListener((View.OnClickListener)localObject3);
          if (k != 1) {
            break label1455;
          }
          bool = true;
          paramViewGroup.fUk.setText(((bo)localObject2).getTitle());
          paramViewGroup.uEM.setText(((bo)localObject2).getDigest());
          if (bs.isNullOrNil(((bo)localObject2).azl())) {
            break label1461;
          }
          i = 1;
          paramViewGroup.wff.ar(((bo)localObject2).getTitle());
          localObject3 = paramViewGroup.uEM;
          if ((bool) && (!bs.isNullOrNil(((bo)localObject2).getDigest()))) {
            break label1467;
          }
        }
        label1444:
        label1455:
        label1461:
        label1467:
        for (int j = 8;; j = 0)
        {
          ((TextView)localObject3).setVisibility(j);
          paramViewGroup.wfg.setVisibility(8);
          if (!bool) {
            break label1473;
          }
          paramViewGroup.nCx.setBackgroundResource(2131231708);
          paramViewGroup.iSJ.setVisibility(0);
          paramViewGroup.wff.setVisibility(8);
          paramViewGroup.fUk.setVisibility(0);
          W(paramViewGroup.nCx, this.weV);
          W(paramViewGroup.nDr, this.weV);
          if (i == 0) {
            break label1575;
          }
          paramViewGroup.nDr.setVisibility(0);
          localObject5 = ((bo)localObject2).azl();
          localObject3 = paramViewGroup.wfd;
          i = this.weV;
          localObject4 = new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(102727);
              if (!bool)
              {
                paramViewGroup.wff.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131101182));
                paramViewGroup.wff.setBackgroundResource(2131231208);
              }
              paramViewGroup.wfg.setVisibility(0);
              AppMethodBeat.o(102727);
            }
            
            public final void onStart() {}
          };
          localObject5 = q.Cx((String)localObject5);
          float f = ((ImageView)localObject3).getResources().getDimensionPixelSize(2131166028);
          j = com.tencent.mm.cc.a.ig(ReaderAppUI.this.getContext()) - (int)(ReaderAppUI.dth() * 28.0F);
          com.tencent.mm.av.a.a locala = o.aFB();
          c.a locala1 = new c.a();
          locala1.hKL = 2131231198;
          locala1.hKx = true;
          locala1.hKN = "2131231189";
          locala1 = locala1.de(j, i);
          locala1.hKm = new com.tencent.mm.pluginsdk.ui.applet.n();
          locala1.hKU = new com.tencent.mm.pluginsdk.ui.applet.e();
          locala1.gKe = r.aGc((String)localObject5);
          locala.a((String)localObject5, (ImageView)localObject3, locala1.aFT(), null, new com.tencent.mm.pluginsdk.ui.applet.m(0, j, i, true, false, f, (m.a)localObject4));
          paramViewGroup.iSJ.setBackground(am.e(ReaderAppUI.this.getResources().getDrawable(2131231686), ao.aJ(ReaderAppUI.this.getContext(), 2130968579)));
          paramViewGroup.iSJ.setPadding(this.nzb, this.nzc, this.nzb, this.nzb);
          paramViewGroup.nCx.setVisibility(0);
          if (k <= 1) {
            break label1708;
          }
          i = 1;
          while (i < k - 1)
          {
            a(paramViewGroup, (List)localObject1, 2131495189, i, ((bo)localObject2).getTitle());
            i += 1;
          }
          paramViewGroup.toC.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break;
          paramViewGroup.toC.setBackgroundColor(0);
          break label923;
          bool = false;
          break label965;
          i = 0;
          break label1003;
        }
        label1473:
        paramViewGroup.nCx.setBackgroundResource(2131231710);
        localObject3 = paramViewGroup.iSJ;
        if (i != 0) {}
        for (j = 8;; j = 0)
        {
          ((View)localObject3).setVisibility(j);
          paramViewGroup.fUk.setVisibility(8);
          paramViewGroup.wff.setVisibility(0);
          paramViewGroup.wff.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131100541));
          paramViewGroup.wff.setBackgroundResource(2131233299);
          paramViewGroup.wff.getPaint().setFakeBoldText(true);
          break;
        }
        label1575:
        paramViewGroup.nDr.setVisibility(8);
        paramViewGroup.fUk.setVisibility(0);
        localObject3 = paramViewGroup.uEM;
        if (bs.isNullOrNil(((bo)localObject2).getDigest()))
        {
          i = 8;
          label1613:
          ((TextView)localObject3).setVisibility(i);
          if (!bool) {
            break label1676;
          }
          paramViewGroup.iSJ.setBackgroundResource(2131231695);
        }
        for (;;)
        {
          paramViewGroup.iSJ.setPadding(this.nzb, this.nzb, this.nzb, this.nzb);
          paramViewGroup.nCx.setVisibility(8);
          break;
          i = 0;
          break label1613;
          label1676:
          paramViewGroup.iSJ.setBackgroundResource(2131231694);
        }
        a(paramViewGroup, (List)localObject1, 2131495188, k - 1, ((bo)localObject2).getTitle());
        label1708:
        localObject3 = (com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class);
        if (localObject3 != null)
        {
          ((com.tencent.mm.plugin.brandservice.a.d)localObject3).a(((bo)localObject2).getUrl(), 164, "wx073f4a4daff0abe8", ((bo)localObject2).getTitle(), ((bo)localObject2).getDigest(), "message", 8);
          ((com.tencent.mm.plugin.brandservice.a.d)localObject3).cr(((bo)localObject2).getUrl(), 8);
        }
      }
      paramViewGroup.nCN.setTag(Integer.valueOf(paramInt));
      paramViewGroup.nCN.setTag(2131303776, Integer.valueOf(0));
      Object localObject2 = ReaderAppUI.h(ReaderAppUI.this);
      Object localObject3 = paramViewGroup.nCN;
      Object localObject4 = ReaderAppUI.this;
      if (((List)localObject1).size() == 1)
      {
        bool = true;
        ((com.tencent.mm.ui.widget.b.a)localObject2).c((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(ReaderAppUI.this));
        paramViewGroup = paramViewGroup.nCU.iterator();
        i = 1;
        label1863:
        if (!paramViewGroup.hasNext()) {
          break label1989;
        }
        localObject2 = (a)paramViewGroup.next();
        ((a)localObject2).nBh.setTag(Integer.valueOf(paramInt));
        localObject3 = ReaderAppUI.h(ReaderAppUI.this);
        localObject4 = ((a)localObject2).nBh;
        localObject5 = ReaderAppUI.this;
        if (((List)localObject1).size() != 1) {
          break label1983;
        }
      }
      label1983:
      for (final boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.ui.widget.b.a)localObject3).c((View)localObject4, ReaderAppUI.a((ReaderAppUI)localObject5, bool), ReaderAppUI.g(ReaderAppUI.this));
        ((a)localObject2).nBh.setTag(2131303776, Integer.valueOf(i));
        i += 1;
        break label1863;
        bool = false;
        break;
      }
      label1989:
      AppMethodBeat.o(102738);
      return paramView;
    }
    
    public final int getViewTypeCount()
    {
      return this.weZ;
    }
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(102745);
      super.onScrollStateChanged(paramAbsListView, paramInt);
      if ((paramAbsListView != null) && (paramInt == 0)) {
        gN(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition());
      }
      AppMethodBeat.o(102745);
    }
    
    final class a
    {
      TextView fUk;
      View ijv;
      View nBh;
      View nCh;
      View nCk;
      ImageView nCl;
      
      a() {}
    }
    
    final class b
    {
      TextView fUk;
      ImageView fxQ;
      TextView iIU;
      View iSJ;
      View nCN;
      List<ReaderAppUI.a.a> nCU;
      ImageView nCx;
      View nDr;
      TextView toC;
      TextView uEM;
      ImageView wfd;
      ViewGroup wfe;
      MMNeat7extView wff;
      ImageView wfg;
      ReaderAppUI.a.c wfh;
      ReaderAppUI.a.c wfi;
      
      b() {}
    }
    
    final class c
    {
      View nCN;
      MMNeat7extView nMV;
      ImageView opg;
      View wfj;
      View wfk;
      ImageView wfl;
      ImageView wfm;
      TextView wfn;
      
      c() {}
      
      final void a(bo parambo, int paramInt, String paramString)
      {
        AppMethodBeat.i(102730);
        paramString = ReaderAppUI.this.a(parambo, ReaderAppUI.a(ReaderAppUI.this), 0, paramString);
        if (this.nCN == null)
        {
          AppMethodBeat.o(102730);
          return;
        }
        this.nCN.setOnClickListener(paramString);
        ReaderAppUI.h(ReaderAppUI.this).c(this.nCN, ReaderAppUI.a(ReaderAppUI.this, false), ReaderAppUI.g(ReaderAppUI.this));
        this.nCN.setTag(Integer.valueOf(paramInt));
        this.nCN.setTag(2131303776, Integer.valueOf(paramInt));
        this.nMV.ar(parambo.getTitle());
        paramString = com.tencent.mm.ah.m.nJ(parambo.azo());
        if (!bs.isNullOrNil(paramString))
        {
          this.wfn.setText(paramString);
          this.wfj.setVisibility(0);
        }
        for (;;)
        {
          this.nMV.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131100541));
          this.wfk.setBackgroundResource(2131233299);
          paramInt = (int)(this.wfn.getTextSize() * 1.7D);
          paramString = this.wfm.getLayoutParams();
          paramString.height = paramInt;
          paramString.width = paramInt;
          this.wfm.setLayoutParams(paramString);
          ReaderAppUI.a.ao(this.opg, ReaderAppUI.a.a(ReaderAppUI.a.this));
          ReaderAppUI.a.a(ReaderAppUI.a.this, parambo.azl(), this.opg, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(102728);
              ReaderAppUI.a.c.this.nMV.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131101182));
              ReaderAppUI.a.c.this.wfk.setBackgroundResource(2131234756);
              AppMethodBeat.o(102728);
            }
            
            public final void onStart() {}
          });
          AppMethodBeat.o(102730);
          return;
          this.wfj.setVisibility(8);
        }
      }
      
      final void dti()
      {
        AppMethodBeat.i(102729);
        if (this.nCN == null)
        {
          AppMethodBeat.o(102729);
          return;
        }
        this.opg = ((ImageView)this.nCN.findViewById(2131306962));
        this.wfl = ((ImageView)this.nCN.findViewById(2131303387));
        this.nMV = ((MMNeat7extView)this.nCN.findViewById(2131305946));
        this.wfn = ((TextView)this.nCN.findViewById(2131306310));
        this.wfm = ((ImageView)this.nCN.findViewById(2131303285));
        this.wfj = this.nCN.findViewById(2131303292);
        this.wfk = this.nCN.findViewById(2131306959);
        AppMethodBeat.o(102729);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI
 * JD-Core Version:    0.7.0.1
 */