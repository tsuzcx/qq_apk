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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.aw.q;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.q.a;
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
  private int duE;
  private View imc;
  private com.tencent.mm.ui.widget.b.a mVN;
  private n.d mXD;
  private String sSG;
  private ListView twA;
  private MMPullDownView twE;
  private a<String> uVW;
  private com.tencent.mm.pluginsdk.ui.e uVX;
  private int uVY;
  
  public ReaderAppUI()
  {
    AppMethodBeat.i(102751);
    this.duE = 0;
    this.sSG = "";
    this.uVX = null;
    this.uVY = 0;
    this.mXD = new n.d()
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
          if (!bt.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.plugin.readerapp.c.g.ei((String)localObject1, ReaderAppUI.a(ReaderAppUI.this));
            paramAnonymousMenuItem = com.tencent.mm.plugin.readerapp.c.g.dfz();
            paramAnonymousInt = ReaderAppUI.a(ReaderAppUI.this);
            localObject1 = "delete from " + bp.nm(paramAnonymousInt) + " where reserved3 = " + com.tencent.mm.storagebase.h.qj((String)localObject1);
            ad.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[] { localObject1 });
            if (paramAnonymousMenuItem.gPa.execSQL(bp.nm(paramAnonymousInt), (String)localObject1))
            {
              paramAnonymousMenuItem.nq(paramAnonymousInt);
              paramAnonymousMenuItem.doNotify();
            }
          }
          ReaderAppUI.this.refresh();
          AppMethodBeat.o(161679);
          return;
          if (ReaderAppUI.a(ReaderAppUI.this) == 20)
          {
            paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
            paramAnonymousMenuItem = com.tencent.mm.plugin.readerapp.c.g.dfz().Z(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
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
              ((Intent)localObject1).putExtra("Retr_Msg_thumb_path", r.aAK(paramAnonymousMenuItem.asu()));
              ((Intent)localObject1).putExtra("Retr_Msg_Id", 7377812);
              localObject2 = y.tD(paramAnonymousMenuItem.gOU);
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              localObject2 = y.arz().E((String)localObject2, true);
              ((y.b)localObject2).m("prePublishId", "msg_" + paramAnonymousMenuItem.gOU);
              ((y.b)localObject2).m("preUsername", "newsapp");
              ((y.b)localObject2).m("preChatName", "newsapp");
              ((y.b)localObject2).m("preMsgIndex", Integer.valueOf(0));
              ((y.b)localObject2).m("sendAppMsgScene", Integer.valueOf(1));
              com.tencent.mm.plugin.readerapp.b.a.hYt.k((Intent)localObject1, ReaderAppUI.this);
            }
            AppMethodBeat.o(161679);
            return;
            if (ReaderAppUI.a(ReaderAppUI.this) == 20)
            {
              paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
              localObject1 = com.tencent.mm.plugin.readerapp.c.g.dfz().Z(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
              if (!((List)localObject1).isEmpty())
              {
                ad.i("MicroMsg.ReaderAppUI", "fav functionId %s, index %d, size %d", new Object[] { paramAnonymousMenuItem, Integer.valueOf(ReaderAppUI.d(ReaderAppUI.this)), Integer.valueOf(((List)localObject1).size()) });
                if (ReaderAppUI.d(ReaderAppUI.this) >= ((List)localObject1).size()) {
                  ReaderAppUI.a(ReaderAppUI.this, 0);
                }
                paramAnonymousMenuItem = (bo)((List)localObject1).get(ReaderAppUI.d(ReaderAppUI.this));
                localObject1 = new cs();
                localObject2 = y.tD(paramAnonymousMenuItem.gOU);
                y.b localb = y.arz().E((String)localObject2, true);
                localb.m("prePublishId", "msg_" + paramAnonymousMenuItem.gOU);
                localb.m("preUsername", "newsapp");
                localb.m("preChatName", "newsapp");
                localb.m("preMsgIndex", Integer.valueOf(0));
                localb.m("sendAppMsgScene", Integer.valueOf(1));
                ((cs)localObject1).deQ.sessionId = ((String)localObject2);
                ReaderAppUI.d(ReaderAppUI.this);
                com.tencent.mm.plugin.readerapp.c.b.a((cs)localObject1, paramAnonymousMenuItem);
                ((cs)localObject1).deQ.deW = 7;
                ((cs)localObject1).deQ.activity = ReaderAppUI.this;
                com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
              }
            }
          }
        }
      }
    };
    AppMethodBeat.o(102751);
  }
  
  private PackageInfo all(String paramString)
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
      ad.printErrStackTrace("MicroMsg.ReaderAppUI", paramString, "", new Object[0]);
      AppMethodBeat.o(102759);
    }
    return null;
  }
  
  public final View.OnClickListener a(final bo parambo, final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(102758);
    if (parambo != null)
    {
      String str1 = com.tencent.mm.pluginsdk.ui.tools.x.aCL(parambo.getUrl());
      String str2 = com.tencent.mm.pluginsdk.ui.tools.x.aCL(paramString);
      String str3 = com.tencent.mm.pluginsdk.ui.tools.x.aCL(parambo.getTitle());
      com.tencent.mm.plugin.report.service.h.vKh.f(15413, new Object[] { Integer.valueOf(9), str2, str3, parambo.asy(), parambo.asq(), str1, Integer.valueOf(parambo.asz()), Integer.valueOf(parambo.asw()) });
    }
    parambo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(161677);
        if (20 == paramInt1)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(15413, new Object[] { Integer.valueOf(8), paramString, parambo.getTitle() });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("mode", 1);
          Object localObject = parambo.getUrl();
          paramAnonymousView.putExtra("news_svr_id", parambo.gOU);
          paramAnonymousView.putExtra("news_svr_tweetid", parambo.asq());
          paramAnonymousView.putExtra("rawUrl", ReaderAppUI.a(ReaderAppUI.this, (String)localObject));
          paramAnonymousView.putExtra("title", parambo.getName());
          paramAnonymousView.putExtra("webpageTitle", parambo.getTitle());
          paramAnonymousView.putExtra("useJs", true);
          paramAnonymousView.putExtra("vertical_scroll", true);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("snsWebSource", 3);
          paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject);
          paramAnonymousView.putExtra("shortUrl", parambo.asr());
          paramAnonymousView.putExtra("type", parambo.type);
          paramAnonymousView.putExtra("tweetid", parambo.asq());
          paramAnonymousView.putExtra("geta8key_username", "newsapp");
          paramAnonymousView.putExtra("KPublisherId", "msg_" + Long.toString(parambo.gOU));
          paramAnonymousView.putExtra("pre_username", "newsapp");
          paramAnonymousView.putExtra("prePublishId", "msg_" + Long.toString(parambo.gOU));
          paramAnonymousView.putExtra("preUsername", "newsapp");
          paramAnonymousView.putExtra("preChatName", "newsapp");
          paramAnonymousView.putExtra("preMsgIndex", paramInt2);
          paramAnonymousView.putExtra("geta8key_scene", 66);
          paramAnonymousView.putExtra("webview_scene_type", 1);
          paramAnonymousView.putExtra("webview_scene_note", com.tencent.mm.pluginsdk.ui.tools.x.aCL(String.format("%d|%d|%s|%s|%s", new Object[] { Integer.valueOf(parambo.asz()), Integer.valueOf(parambo.asw()), parambo.asy(), paramString, parambo.asq() })));
          paramAnonymousView.putExtra("bizEnterId", (int)(System.currentTimeMillis() / 1000L));
          paramAnonymousView.putExtra("KOpenArticleSceneFromScene", 0);
          paramAnonymousView.addFlags(536870912);
          com.tencent.mm.plugin.readerapp.b.a.hYt.i(paramAnonymousView, ReaderAppUI.this);
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
      this.uVX = new com.tencent.mm.pluginsdk.ui.e(bt.convertStreamToString(getAssets().open("chatting/purecolor_chat.xml")), this);
      this.twA = ((ListView)findViewById(2131303774));
      this.twE = ((MMPullDownView)findViewById(2131303777));
      this.twE.setIsReturnSuperDispatchWhenCancel(true);
      this.imc = getLayoutInflater().inflate(2131495179, null);
      this.twA.addHeaderView(this.imc);
      ((TextView)findViewById(2131299468)).setText(2131762171);
      this.uVW = new a(this, "");
      this.twA.setOnScrollListener(this.uVW);
      this.twA.setAdapter(this.uVW);
      this.twA.setTranscriptMode(0);
      registerForContextMenu(this.twA);
      this.mVN = new com.tencent.mm.ui.widget.b.a(this);
      if (this.uVW.getCount() == 0)
      {
        Object localObject = new Intent(this, ReaderAppIntroUI.class);
        ((Intent)localObject).putExtra("type", this.duE);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
        ad.printErrStackTrace("MicroMsg.ReaderAppUI", localException, "", new Object[0]);
      }
      this.twE.setOnTopLoadDataListener(new MMPullDownView.g()
      {
        public final boolean bPk()
        {
          AppMethodBeat.i(161680);
          if (ReaderAppUI.c(ReaderAppUI.this).bLj())
          {
            ReaderAppUI.b(ReaderAppUI.this).setSelectionFromTop(0, ReaderAppUI.e(ReaderAppUI.this).getTopHeight());
            AppMethodBeat.o(161680);
            return true;
          }
          int i = ReaderAppUI.c(ReaderAppUI.this).getCount();
          int j = ReaderAppUI.c(ReaderAppUI.this).bLk();
          ad.v("MicroMsg.ReaderAppUI", "onLoadData add count:".concat(String.valueOf(j)));
          ReaderAppUI.c(ReaderAppUI.this).a(null, null);
          int k = ReaderAppUI.c(ReaderAppUI.this).getCount();
          ad.d("MicroMsg.ReaderAppUI", "onTopLoadData nowCount:%d, preCount:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
          if (k > i)
          {
            ad.i("MicroMsg.ReaderAppUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", new Object[] { Integer.valueOf(j + 1), Integer.valueOf(ReaderAppUI.e(ReaderAppUI.this).getTopHeight()) });
            com.tencent.mm.pluginsdk.ui.tools.n.a(ReaderAppUI.b(ReaderAppUI.this), j + 1, ReaderAppUI.e(ReaderAppUI.this).getTopHeight(), false);
          }
          AppMethodBeat.o(161680);
          return true;
        }
      });
      this.twE.setTopViewVisible(true);
      this.twE.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean bPj()
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
      this.twE.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean bPi()
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
      this.twE.setIsBottomShowAll(true);
      this.uVW.a(new q.a()
      {
        public final void aIp()
        {
          AppMethodBeat.i(161683);
          ReaderAppUI.e(ReaderAppUI.this).setIsTopShowAll(ReaderAppUI.c(ReaderAppUI.this).bLj());
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
          com.tencent.mm.plugin.readerapp.b.a.hYt.c(new Intent().putExtra("Contact_User", ReaderAppUI.f(ReaderAppUI.this)), ReaderAppUI.this);
          AppMethodBeat.o(161684);
          return true;
        }
      });
      this.twA.setSelection(this.uVW.getShowCount() - 1 + this.twA.getHeaderViewsCount());
      AppMethodBeat.o(102757);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102752);
    super.onCreate(paramBundle);
    this.duE = getIntent().getIntExtra("type", 0);
    ad.i("MicroMsg.ReaderAppUI", "[onCreate] readerType:%s", new Object[] { Integer.valueOf(this.duE) });
    this.duE = 20;
    density = com.tencent.mm.cd.a.getDensity(this);
    long l = System.currentTimeMillis();
    initView();
    ad.i("MicroMsg.ReaderAppUI", "[initView] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.sSG = bo.nl(this.duE);
    if ((20 == this.duE) && (com.tencent.mm.model.x.av("newsapp", null) > 0)) {
      com.tencent.mm.plugin.report.service.h.vKh.f(13440, new Object[] { Integer.valueOf(2) });
    }
    AppMethodBeat.o(102752);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(102753);
    if (this.uVW != null)
    {
      this.uVW.cHX();
      this.uVW.ePu();
    }
    super.onDestroy();
    AppMethodBeat.o(102753);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(102755);
    super.onPause();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().ou("");
    com.tencent.mm.plugin.readerapp.c.g.dfz().remove(this.uVW);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIp(this.sSG);
    AppMethodBeat.o(102755);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(102754);
    super.onResume();
    if (this.duE == 20) {
      setMMTitle(2131760208);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().ou(this.sSG);
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(this.sSG);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIp(this.sSG);
      com.tencent.mm.plugin.readerapp.c.g.dfz().add(this.uVW);
      this.uVW.a(null, null);
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
    if (this.duE == 20)
    {
      i = 2131762179;
      localTextView.setText(i);
      if (this.uVW.getCount() != 0) {
        break label97;
      }
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      if ((this.twA != null) && ((this.uVW instanceof a))) {
        this.twA.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161678);
            ((ReaderAppUI.a)ReaderAppUI.c(ReaderAppUI.this)).gG(ReaderAppUI.b(ReaderAppUI.this).getFirstVisiblePosition(), ReaderAppUI.b(ReaderAppUI.this).getLastVisiblePosition());
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
    private int fwP;
    private int mWB;
    private int mWC;
    private int mWD;
    private int mWE;
    private int mWG;
    private int nCF;
    private Html.ImageGetter uWe;
    private int uWf;
    private int uWg;
    private int uWh;
    int uWi;
    int uWj;
    int uWk;
    
    public a(Context paramContext, String paramString)
    {
      super(paramString);
      AppMethodBeat.i(102732);
      this.uWe = new Html.ImageGetter()
      {
        public final Drawable getDrawable(String paramAnonymousString)
        {
          AppMethodBeat.i(102726);
          int i = bt.getInt(paramAnonymousString, 0);
          paramAnonymousString = ReaderAppUI.this.getResources().getDrawable(i);
          paramAnonymousString.setBounds(0, 0, paramAnonymousString.getIntrinsicWidth(), paramAnonymousString.getIntrinsicHeight());
          AppMethodBeat.o(102726);
          return paramAnonymousString;
        }
      };
      this.uWf = 0;
      this.mWE = 0;
      this.mWC = 0;
      this.mWD = 0;
      this.uWg = 0;
      this.uWh = 0;
      this.uWi = 0;
      this.uWj = 1;
      this.uWk = 2;
      this.context = paramContext;
      this.nCF = 3;
      this.fwP = com.tencent.mm.plugin.readerapp.c.g.dfz().no(ReaderAppUI.a(ReaderAppUI.this));
      this.mWE = paramContext.getResources().getDimensionPixelSize(2131165568);
      this.mWC = paramContext.getResources().getDimensionPixelSize(2131165480);
      this.uWf = paramContext.getResources().getDimensionPixelSize(2131165187);
      this.mWD = paramContext.getResources().getDimensionPixelSize(2131165500);
      this.mWB = paramContext.getResources().getDimensionPixelSize(2131166025);
      this.mWG = paramContext.getResources().getDimensionPixelSize(2131166023);
      int i = com.tencent.mm.cd.a.hV(paramContext);
      int j = com.tencent.mm.cd.a.hW(paramContext);
      if (i < j) {}
      for (;;)
      {
        this.uWg = ((int)((i - (int)(ReaderAppUI.dfA() * 28.0F)) / 2.35D));
        this.uWh = ((int)((i - ReaderAppUI.dfA() * 52.0F) / 2.0F) * 4 / 3);
        AppMethodBeat.o(102732);
        return;
        i = j;
      }
    }
    
    private List<bo> JV(int paramInt)
    {
      AppMethodBeat.i(102739);
      Object localObject = getItem(paramInt);
      localObject = com.tencent.mm.plugin.readerapp.c.g.dfz().Z((String)localObject, 20);
      AppMethodBeat.o(102739);
      return localObject;
    }
    
    private static void V(View paramView, int paramInt)
    {
      AppMethodBeat.i(102741);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.height = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(102741);
    }
    
    private static void W(View paramView, int paramInt)
    {
      AppMethodBeat.i(102742);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.rightMargin = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(102742);
    }
    
    private static d.a a(bo parambo)
    {
      AppMethodBeat.i(192607);
      if (parambo == null)
      {
        AppMethodBeat.o(192607);
        return null;
      }
      d.a locala = new d.a();
      locala.url = parambo.getUrl();
      locala.mSu = 164;
      locala.appId = "wx073f4a4daff0abe8";
      locala.title = parambo.getTitle();
      locala.desc = parambo.getDigest();
      locala.dvh = "message";
      AppMethodBeat.o(192607);
      return locala;
    }
    
    private void a(a parama, int paramInt, List<bo> paramList)
    {
      AppMethodBeat.i(102743);
      int i = paramList.size();
      if (paramInt == 1) {
        if (bt.isNullOrNil(((bo)paramList.get(0)).asu()))
        {
          parama.hIU.setVisibility(0);
          W(parama.hIU, this.mWC);
        }
      }
      while (paramInt == 1) {
        if (paramInt == i - 1)
        {
          parama.mZJ.setPadding(0, this.mWC, 0, this.mWC);
          AppMethodBeat.o(102743);
          return;
          parama.hIU.setVisibility(8);
          continue;
          parama.hIU.setVisibility(0);
          bo localbo = (bo)paramList.get(paramInt - 1);
          paramList = (bo)paramList.get(paramInt);
          if ((bt.isNullOrNil(localbo.asu())) || (bt.isNullOrNil(paramList.asu()))) {
            W(parama.hIU, this.mWC);
          } else {
            W(parama.hIU, this.mWG);
          }
        }
        else
        {
          parama.mZJ.setPadding(0, this.mWC, 0, this.mWE);
          AppMethodBeat.o(102743);
          return;
        }
      }
      if (paramInt == i - 1)
      {
        parama.mZJ.setPadding(0, this.mWE, 0, this.mWC);
        AppMethodBeat.o(102743);
        return;
      }
      parama.mZJ.setPadding(0, this.mWE, 0, this.mWE);
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
      paramb.uWp.addView(parama.mYI);
      paramb.naw.add(parama);
      AppMethodBeat.o(102731);
    }
    
    private void a(b paramb, List<bo> paramList, int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(102740);
      a locala = new a();
      locala.mYI = View.inflate(this.context, paramInt1, null);
      if (paramInt1 == 2131495189)
      {
        locala.mYI.setBackground(am.c(ReaderAppUI.this.getResources().getDrawable(2131231693), ao.jz(ReaderAppUI.this.getContext())));
        locala.fQp = ((TextView)locala.mYI.findViewById(2131305902));
        locala.mZN = ((ImageView)locala.mYI.findViewById(2131298813));
        locala.mZM = locala.mYI.findViewById(2131298814);
        locala.hIU = locala.mYI.findViewById(2131306012);
        locala.mZJ = locala.mYI.findViewById(2131298764);
        a(paramb, locala);
        paramb = (bo)paramList.get(paramInt2);
        a(locala, paramInt2, paramList);
        locala.fQp.setText(paramb.getTitle());
        locala.fQp.setText(paramb.getTitle());
        if (bt.isNullOrNil(paramb.asu())) {
          break label380;
        }
        locala.mZN.setVisibility(0);
        a(paramb.asu(), locala.mZN, this.mWB, this.mWB);
      }
      for (;;)
      {
        paramList = ReaderAppUI.this.a(paramb, ReaderAppUI.a(ReaderAppUI.this), paramInt2, paramString);
        locala.mYI.setOnClickListener(paramList);
        paramList = (com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class);
        if (paramList != null)
        {
          paramList.a(paramb.getUrl(), 164, "wx073f4a4daff0abe8", paramb.getTitle(), paramb.getDigest(), "message", 16);
          paramList.cm(paramb.getUrl(), 16);
        }
        AppMethodBeat.o(102740);
        return;
        if (paramInt1 != 2131495188) {
          break;
        }
        locala.mYI.setBackground(am.c(ReaderAppUI.this.getResources().getDrawable(2131231692), ao.jz(ReaderAppUI.this.getContext())));
        break;
        label380:
        locala.mZM.setVisibility(8);
      }
    }
    
    private static void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102744);
      paramString = q.ys(paramString);
      com.tencent.mm.aw.a.a locala = o.ayJ();
      c.a locala1 = new c.a();
      locala1.hki = 2131100141;
      locala1.hjU = true;
      locala1 = locala1.de(paramInt1, paramInt2);
      locala1.hjJ = new com.tencent.mm.pluginsdk.ui.applet.n();
      locala1.hkr = new com.tencent.mm.pluginsdk.ui.applet.e();
      locala1.gjt = r.aAK(paramString);
      locala.a(paramString, paramImageView, locala1.azc(), null, new com.tencent.mm.pluginsdk.ui.applet.m((byte)0));
      AppMethodBeat.o(102744);
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(102736);
      String str = (String)super.getItem(paramInt);
      AppMethodBeat.o(102736);
      return str;
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(102735);
      long l = System.currentTimeMillis();
      this.fwP = com.tencent.mm.plugin.readerapp.c.g.dfz().no(20);
      setCursor(com.tencent.mm.plugin.readerapp.c.g.dfz().nn(this.nCF));
      ad.i("MicroMsg.ReaderAppUI", "[resetCursor] cost:%sms showCount:%s totalCount:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.nCF), Integer.valueOf(this.fwP) });
      super.notifyDataSetChanged();
      AppMethodBeat.o(102735);
    }
    
    public final void We()
    {
      AppMethodBeat.i(102733);
      Wd();
      AppMethodBeat.o(102733);
    }
    
    public final boolean bLj()
    {
      return this.nCF >= this.fwP;
    }
    
    public final int bLk()
    {
      AppMethodBeat.i(102734);
      if (bLj())
      {
        AppMethodBeat.o(102734);
        return 0;
      }
      this.nCF += 3;
      if (this.nCF <= this.fwP)
      {
        AppMethodBeat.o(102734);
        return 3;
      }
      this.nCF = this.fwP;
      int i = this.fwP;
      AppMethodBeat.o(102734);
      return i % 3;
    }
    
    public final void gG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102746);
      ad.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth startPos = %s, endPos = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(102746);
        return;
      }
      com.tencent.mm.plugin.brandservice.a.d locald = (com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class);
      if (locald == null)
      {
        ad.v("MicroMsg.ReaderAppUI", "checkPreauth WebPrefetcher null");
        AppMethodBeat.o(102746);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      while (paramInt1 <= paramInt2)
      {
        List localList = JV(paramInt1 - 1);
        if ((localList != null) && (localList.size() > 0))
        {
          localLinkedList.clear();
          d.a locala = a((bo)localList.get(0));
          if (locala != null)
          {
            localLinkedList.add(locala);
            locald.cm(locala.url, 8);
          }
          if (localLinkedList.size() > 0) {
            locald.l(localLinkedList, 8);
          }
          ad.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authTop = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
          localLinkedList.clear();
          int i = 1;
          while (i < localList.size())
          {
            locala = a((bo)localList.get(i));
            if (locala != null)
            {
              localLinkedList.add(locala);
              locald.cm(locala.url, 16);
            }
            i += 1;
          }
          if (localLinkedList.size() > 0) {
            locald.l(localLinkedList, 16);
          }
          ad.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authCommon = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
        }
        paramInt1 += 1;
      }
      AppMethodBeat.o(102746);
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(102737);
      List localList = JV(paramInt);
      if (bt.gL(localList))
      {
        ad.e("MicroMsg.ReaderAppUI", "getItemViewType info is null");
        paramInt = this.uWi;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      if (((bo)localList.get(0)).asw() == 1) {}
      for (paramInt = 1; (paramInt != 0) && (localList.size() >= 2); paramInt = 0)
      {
        paramInt = this.uWj;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      paramInt = this.uWi;
      AppMethodBeat.o(102737);
      return paramInt;
    }
    
    public final int getShowCount()
    {
      return this.nCF;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102738);
      if (getItemViewType(paramInt) == this.uWj)
      {
        if (paramView == null)
        {
          paramViewGroup = new b();
          paramView = View.inflate(this.context, 2131495186, null);
          paramViewGroup.sgI = ((TextView)paramView.findViewById(2131306963));
          paramViewGroup.fuj = ((ImageView)paramView.findViewById(2131297008));
          paramViewGroup.iiN = ((TextView)paramView.findViewById(2131302860));
          paramViewGroup.uWs = new c();
          paramViewGroup.uWs.nap = paramView.findViewById(2131298819);
          paramViewGroup.uWs.dfB();
          paramViewGroup.uWt = new c();
          paramViewGroup.uWt.nap = paramView.findViewById(2131298820);
          paramViewGroup.uWt.dfB();
          paramView.setTag(paramViewGroup);
          localObject2 = JV(paramInt);
          if ((localObject2 == null) || (((List)localObject2).size() < 2)) {
            break label486;
          }
          paramView.setVisibility(0);
          localObject1 = (bo)((List)localObject2).get(0);
          paramViewGroup.sgI.setText(com.tencent.mm.pluginsdk.g.h.c(this.context, ((bo)localObject1).time, false));
          localObject3 = new c.a();
          ((c.a)localObject3).hki = 2131231342;
          ((c.a)localObject3).hjT = true;
          ((c.a)localObject3).gkG = true;
          o.ayJ().a(((bo)localObject1).ast(), paramViewGroup.fuj, ((c.a)localObject3).azc());
          paramViewGroup.iiN.setText(((bo)localObject1).ass());
          paramViewGroup.iiN.getPaint().setFakeBoldText(true);
          if (ReaderAppUI.i(ReaderAppUI.this) != null)
          {
            paramViewGroup.sgI.setTextColor(ReaderAppUI.i(ReaderAppUI.this).BUI);
            if (!ReaderAppUI.i(ReaderAppUI.this).BUJ) {
              break label461;
            }
            paramViewGroup.sgI.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).BUK);
            label353:
            if (!ReaderAppUI.i(ReaderAppUI.this).BUL) {
              break label475;
            }
            paramViewGroup.sgI.setBackgroundResource(2131231582);
            paramViewGroup.sgI.setPadding(this.mWE, this.uWf, this.mWE, this.uWf);
          }
          label399:
          localObject2 = (bo)((List)localObject2).get(1);
          paramViewGroup.uWs.a((bo)localObject1, paramInt, ((bo)localObject1).getTitle());
          paramViewGroup.uWt.a((bo)localObject2, paramInt, ((bo)localObject1).getTitle());
        }
        for (;;)
        {
          AppMethodBeat.o(102738);
          return paramView;
          paramViewGroup = (b)paramView.getTag();
          break;
          label461:
          paramViewGroup.sgI.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break label353;
          label475:
          paramViewGroup.sgI.setBackgroundColor(0);
          break label399;
          label486:
          paramView.setVisibility(8);
        }
      }
      if (paramView == null)
      {
        paramViewGroup = new b();
        paramView = View.inflate(this.context, 2131495181, null);
        paramViewGroup.sgI = ((TextView)paramView.findViewById(2131303764));
        paramViewGroup.uWp = ((ViewGroup)paramView.findViewById(2131303759));
        paramViewGroup.isE = paramView.findViewById(2131297444);
        paramViewGroup.naT = paramView.findViewById(2131298818);
        paramViewGroup.mZZ = ((ImageView)paramView.findViewById(2131303387));
        paramViewGroup.uWr = ((ImageView)paramView.findViewById(2131298831));
        paramViewGroup.fQp = ((TextView)paramView.findViewById(2131303765));
        paramViewGroup.uWo = ((ImageView)paramView.findViewById(2131303763));
        paramViewGroup.twu = ((TextView)paramView.findViewById(2131303762));
        paramViewGroup.nap = paramView.findViewById(2131305992);
        paramViewGroup.uWq = ((MMNeat7extView)paramView.findViewById(2131305946));
        paramViewGroup.naw = new ArrayList();
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject1 = paramViewGroup.naw.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          paramViewGroup.uWp.removeView(((a)localObject2).mYI);
        }
        paramViewGroup = (b)paramView.getTag();
      }
      paramViewGroup.naw.clear();
      Object localObject1 = JV(paramInt);
      label923:
      label965:
      int i;
      label1003:
      Object localObject5;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int k = ((List)localObject1).size();
        localObject2 = (bo)((List)localObject1).get(0);
        paramViewGroup.sgI.setText(com.tencent.mm.pluginsdk.g.h.c(this.context, ((bo)localObject2).time, false));
        if (ReaderAppUI.i(ReaderAppUI.this) != null)
        {
          paramViewGroup.sgI.setTextColor(ReaderAppUI.i(ReaderAppUI.this).BUI);
          if (ReaderAppUI.i(ReaderAppUI.this).BUJ)
          {
            paramViewGroup.sgI.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).BUK);
            if (!ReaderAppUI.i(ReaderAppUI.this).BUL) {
              break label1444;
            }
            paramViewGroup.sgI.setBackgroundResource(2131231582);
            paramViewGroup.sgI.setPadding(this.mWE, this.uWf, this.mWE, this.uWf);
          }
        }
        else
        {
          localObject3 = ReaderAppUI.this.a((bo)localObject2, ReaderAppUI.a(ReaderAppUI.this), 0, ((bo)localObject2).getTitle());
          paramViewGroup.nap.setOnClickListener((View.OnClickListener)localObject3);
          if (k != 1) {
            break label1455;
          }
          bool = true;
          paramViewGroup.fQp.setText(((bo)localObject2).getTitle());
          paramViewGroup.twu.setText(((bo)localObject2).getDigest());
          if (bt.isNullOrNil(((bo)localObject2).asu())) {
            break label1461;
          }
          i = 1;
          paramViewGroup.uWq.aq(((bo)localObject2).getTitle());
          localObject3 = paramViewGroup.twu;
          if ((bool) && (!bt.isNullOrNil(((bo)localObject2).getDigest()))) {
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
          paramViewGroup.uWr.setVisibility(8);
          if (!bool) {
            break label1473;
          }
          paramViewGroup.mZZ.setBackgroundResource(2131231708);
          paramViewGroup.isE.setVisibility(0);
          paramViewGroup.uWq.setVisibility(8);
          paramViewGroup.fQp.setVisibility(0);
          V(paramViewGroup.mZZ, this.uWg);
          V(paramViewGroup.naT, this.uWg);
          if (i == 0) {
            break label1575;
          }
          paramViewGroup.naT.setVisibility(0);
          localObject5 = ((bo)localObject2).asu();
          localObject3 = paramViewGroup.uWo;
          i = this.uWg;
          localObject4 = new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(102727);
              if (!bool)
              {
                paramViewGroup.uWq.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131101182));
                paramViewGroup.uWq.setBackgroundResource(2131231208);
              }
              paramViewGroup.uWr.setVisibility(0);
              AppMethodBeat.o(102727);
            }
            
            public final void onStart() {}
          };
          localObject5 = q.ys((String)localObject5);
          float f = ((ImageView)localObject3).getResources().getDimensionPixelSize(2131166028);
          j = com.tencent.mm.cd.a.hV(ReaderAppUI.this.getContext()) - (int)(ReaderAppUI.dfA() * 28.0F);
          com.tencent.mm.aw.a.a locala = o.ayJ();
          c.a locala1 = new c.a();
          locala1.hki = 2131231198;
          locala1.hjU = true;
          locala1.hkk = "2131231189";
          locala1 = locala1.de(j, i);
          locala1.hjJ = new com.tencent.mm.pluginsdk.ui.applet.n();
          locala1.hkr = new com.tencent.mm.pluginsdk.ui.applet.e();
          locala1.gjt = r.aAK((String)localObject5);
          locala.a((String)localObject5, (ImageView)localObject3, locala1.azc(), null, new com.tencent.mm.pluginsdk.ui.applet.m(0, j, i, true, false, f, (m.a)localObject4));
          paramViewGroup.isE.setBackground(am.e(ReaderAppUI.this.getResources().getDrawable(2131231686), ao.aD(ReaderAppUI.this.getContext(), 2130968579)));
          paramViewGroup.isE.setPadding(this.mWC, this.mWD, this.mWC, this.mWC);
          paramViewGroup.mZZ.setVisibility(0);
          if (k <= 1) {
            break label1708;
          }
          i = 1;
          while (i < k - 1)
          {
            a(paramViewGroup, (List)localObject1, 2131495189, i, ((bo)localObject2).getTitle());
            i += 1;
          }
          paramViewGroup.sgI.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break;
          paramViewGroup.sgI.setBackgroundColor(0);
          break label923;
          bool = false;
          break label965;
          i = 0;
          break label1003;
        }
        label1473:
        paramViewGroup.mZZ.setBackgroundResource(2131231710);
        localObject3 = paramViewGroup.isE;
        if (i != 0) {}
        for (j = 8;; j = 0)
        {
          ((View)localObject3).setVisibility(j);
          paramViewGroup.fQp.setVisibility(8);
          paramViewGroup.uWq.setVisibility(0);
          paramViewGroup.uWq.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131100541));
          paramViewGroup.uWq.setBackgroundResource(2131233299);
          paramViewGroup.uWq.getPaint().setFakeBoldText(true);
          break;
        }
        label1575:
        paramViewGroup.naT.setVisibility(8);
        paramViewGroup.fQp.setVisibility(0);
        localObject3 = paramViewGroup.twu;
        if (bt.isNullOrNil(((bo)localObject2).getDigest()))
        {
          i = 8;
          label1613:
          ((TextView)localObject3).setVisibility(i);
          if (!bool) {
            break label1676;
          }
          paramViewGroup.isE.setBackgroundResource(2131231695);
        }
        for (;;)
        {
          paramViewGroup.isE.setPadding(this.mWC, this.mWC, this.mWC, this.mWC);
          paramViewGroup.mZZ.setVisibility(8);
          break;
          i = 0;
          break label1613;
          label1676:
          paramViewGroup.isE.setBackgroundResource(2131231694);
        }
        a(paramViewGroup, (List)localObject1, 2131495188, k - 1, ((bo)localObject2).getTitle());
        label1708:
        localObject3 = (com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class);
        if (localObject3 != null)
        {
          ((com.tencent.mm.plugin.brandservice.a.d)localObject3).a(((bo)localObject2).getUrl(), 164, "wx073f4a4daff0abe8", ((bo)localObject2).getTitle(), ((bo)localObject2).getDigest(), "message", 8);
          ((com.tencent.mm.plugin.brandservice.a.d)localObject3).cm(((bo)localObject2).getUrl(), 8);
        }
      }
      paramViewGroup.nap.setTag(Integer.valueOf(paramInt));
      paramViewGroup.nap.setTag(2131303776, Integer.valueOf(0));
      Object localObject2 = ReaderAppUI.h(ReaderAppUI.this);
      Object localObject3 = paramViewGroup.nap;
      Object localObject4 = ReaderAppUI.this;
      if (((List)localObject1).size() == 1)
      {
        bool = true;
        ((com.tencent.mm.ui.widget.b.a)localObject2).c((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(ReaderAppUI.this));
        paramViewGroup = paramViewGroup.naw.iterator();
        i = 1;
        label1863:
        if (!paramViewGroup.hasNext()) {
          break label1989;
        }
        localObject2 = (a)paramViewGroup.next();
        ((a)localObject2).mYI.setTag(Integer.valueOf(paramInt));
        localObject3 = ReaderAppUI.h(ReaderAppUI.this);
        localObject4 = ((a)localObject2).mYI;
        localObject5 = ReaderAppUI.this;
        if (((List)localObject1).size() != 1) {
          break label1983;
        }
      }
      label1983:
      for (final boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.ui.widget.b.a)localObject3).c((View)localObject4, ReaderAppUI.a((ReaderAppUI)localObject5, bool), ReaderAppUI.g(ReaderAppUI.this));
        ((a)localObject2).mYI.setTag(2131303776, Integer.valueOf(i));
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
      return this.uWk;
    }
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(102745);
      super.onScrollStateChanged(paramAbsListView, paramInt);
      if ((paramAbsListView != null) && (paramInt == 0)) {
        gG(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition());
      }
      AppMethodBeat.o(102745);
    }
    
    final class a
    {
      TextView fQp;
      View hIU;
      View mYI;
      View mZJ;
      View mZM;
      ImageView mZN;
      
      a() {}
    }
    
    final class b
    {
      TextView fQp;
      ImageView fuj;
      TextView iiN;
      View isE;
      ImageView mZZ;
      View naT;
      View nap;
      List<ReaderAppUI.a.a> naw;
      TextView sgI;
      TextView twu;
      ImageView uWo;
      ViewGroup uWp;
      MMNeat7extView uWq;
      ImageView uWr;
      ReaderAppUI.a.c uWs;
      ReaderAppUI.a.c uWt;
      
      b() {}
    }
    
    final class c
    {
      ImageView nMg;
      View nap;
      MMNeat7extView nkc;
      View uWu;
      View uWv;
      ImageView uWw;
      ImageView uWx;
      TextView uWy;
      
      c() {}
      
      final void a(bo parambo, int paramInt, String paramString)
      {
        AppMethodBeat.i(102730);
        paramString = ReaderAppUI.this.a(parambo, ReaderAppUI.a(ReaderAppUI.this), 0, paramString);
        if (this.nap == null)
        {
          AppMethodBeat.o(102730);
          return;
        }
        this.nap.setOnClickListener(paramString);
        ReaderAppUI.h(ReaderAppUI.this).c(this.nap, ReaderAppUI.a(ReaderAppUI.this, false), ReaderAppUI.g(ReaderAppUI.this));
        this.nap.setTag(Integer.valueOf(paramInt));
        this.nap.setTag(2131303776, Integer.valueOf(paramInt));
        this.nkc.aq(parambo.getTitle());
        paramString = com.tencent.mm.ai.m.mV(parambo.asx());
        if (!bt.isNullOrNil(paramString))
        {
          this.uWy.setText(paramString);
          this.uWu.setVisibility(0);
        }
        for (;;)
        {
          this.nkc.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131100541));
          this.uWv.setBackgroundResource(2131233299);
          paramInt = (int)(this.uWy.getTextSize() * 1.7D);
          paramString = this.uWx.getLayoutParams();
          paramString.height = paramInt;
          paramString.width = paramInt;
          this.uWx.setLayoutParams(paramString);
          ReaderAppUI.a.an(this.nMg, ReaderAppUI.a.a(ReaderAppUI.a.this));
          ReaderAppUI.a.a(ReaderAppUI.a.this, parambo.asu(), this.nMg, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(102728);
              ReaderAppUI.a.c.this.nkc.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131101182));
              ReaderAppUI.a.c.this.uWv.setBackgroundResource(2131234756);
              AppMethodBeat.o(102728);
            }
            
            public final void onStart() {}
          });
          AppMethodBeat.o(102730);
          return;
          this.uWu.setVisibility(8);
        }
      }
      
      final void dfB()
      {
        AppMethodBeat.i(102729);
        if (this.nap == null)
        {
          AppMethodBeat.o(102729);
          return;
        }
        this.nMg = ((ImageView)this.nap.findViewById(2131306962));
        this.uWw = ((ImageView)this.nap.findViewById(2131303387));
        this.nkc = ((MMNeat7extView)this.nap.findViewById(2131305946));
        this.uWy = ((TextView)this.nap.findViewById(2131306310));
        this.uWx = ((ImageView)this.nap.findViewById(2131303285));
        this.uWu = this.nap.findViewById(2131303292);
        this.uWv = this.nap.findViewById(2131306959);
        AppMethodBeat.o(102729);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI
 * JD-Core Version:    0.7.0.1
 */