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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.aw.t;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.i
public class ReaderAppUI
  extends MMActivity
{
  private static float density;
  private int dEj;
  private View jfs;
  private com.tencent.mm.ui.widget.b.a nZK;
  private n.e obh;
  private ListView vHS;
  private MMPullDownView vHW;
  private String vdB;
  private a<String> xmu;
  private f xmv;
  private int xmw;
  
  public ReaderAppUI()
  {
    AppMethodBeat.i(102751);
    this.dEj = 0;
    this.vdB = "";
    this.xmv = null;
    this.xmw = 0;
    this.obh = new n.e()
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
            com.tencent.mm.plugin.readerapp.c.g.eI((String)localObject1, ReaderAppUI.a(ReaderAppUI.this));
            paramAnonymousMenuItem = com.tencent.mm.plugin.readerapp.c.g.dDD();
            paramAnonymousInt = ReaderAppUI.a(ReaderAppUI.this);
            localObject1 = "delete from " + com.tencent.mm.model.bq.oA(paramAnonymousInt) + " where reserved3 = " + h.wo((String)localObject1);
            ad.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[] { localObject1 });
            if (paramAnonymousMenuItem.hHS.execSQL(com.tencent.mm.model.bq.oA(paramAnonymousInt), (String)localObject1))
            {
              paramAnonymousMenuItem.oE(paramAnonymousInt);
              paramAnonymousMenuItem.doNotify();
            }
          }
          ReaderAppUI.this.refresh();
          AppMethodBeat.o(161679);
          return;
          if (ReaderAppUI.a(ReaderAppUI.this) == 20)
          {
            paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
            paramAnonymousMenuItem = com.tencent.mm.plugin.readerapp.c.g.dDD().ah(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
            Object localObject2;
            if (paramAnonymousMenuItem.size() > 0)
            {
              paramAnonymousMenuItem = (bp)paramAnonymousMenuItem.get(0);
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
              ((Intent)localObject1).putExtra("Retr_Msg_thumb_path", r.aLC(paramAnonymousMenuItem.aCp()));
              ((Intent)localObject1).putExtra("Retr_Msg_Id", 7377812);
              localObject2 = y.AH(paramAnonymousMenuItem.hHM);
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              localObject2 = y.aBq().F((String)localObject2, true);
              ((y.b)localObject2).k("prePublishId", "msg_" + paramAnonymousMenuItem.hHM);
              ((y.b)localObject2).k("preUsername", "newsapp");
              ((y.b)localObject2).k("preChatName", "newsapp");
              ((y.b)localObject2).k("preMsgIndex", Integer.valueOf(0));
              ((y.b)localObject2).k("sendAppMsgScene", Integer.valueOf(1));
              com.tencent.mm.plugin.readerapp.b.a.iRG.k((Intent)localObject1, ReaderAppUI.this);
            }
            AppMethodBeat.o(161679);
            return;
            if (ReaderAppUI.a(ReaderAppUI.this) == 20)
            {
              paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
              localObject1 = com.tencent.mm.plugin.readerapp.c.g.dDD().ah(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
              if (!((List)localObject1).isEmpty())
              {
                ad.i("MicroMsg.ReaderAppUI", "fav functionId %s, index %d, size %d", new Object[] { paramAnonymousMenuItem, Integer.valueOf(ReaderAppUI.d(ReaderAppUI.this)), Integer.valueOf(((List)localObject1).size()) });
                if (ReaderAppUI.d(ReaderAppUI.this) >= ((List)localObject1).size()) {
                  ReaderAppUI.a(ReaderAppUI.this, 0);
                }
                paramAnonymousMenuItem = (bp)((List)localObject1).get(ReaderAppUI.d(ReaderAppUI.this));
                localObject1 = new cv();
                localObject2 = y.AH(paramAnonymousMenuItem.hHM);
                y.b localb = y.aBq().F((String)localObject2, true);
                localb.k("prePublishId", "msg_" + paramAnonymousMenuItem.hHM);
                localb.k("preUsername", "newsapp");
                localb.k("preChatName", "newsapp");
                localb.k("preMsgIndex", Integer.valueOf(0));
                localb.k("sendAppMsgScene", Integer.valueOf(1));
                ((cv)localObject1).dnG.sessionId = ((String)localObject2);
                ReaderAppUI.d(ReaderAppUI.this);
                com.tencent.mm.plugin.readerapp.c.b.a((cv)localObject1, paramAnonymousMenuItem);
                ((cv)localObject1).dnG.dnM = 7;
                ((cv)localObject1).dnG.activity = ReaderAppUI.this;
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
              }
            }
          }
        }
      }
    };
    AppMethodBeat.o(102751);
  }
  
  private PackageInfo avj(String paramString)
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
  
  public final View.OnClickListener a(final bp parambp, final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(102758);
    if (parambp != null)
    {
      String str1 = com.tencent.mm.pluginsdk.ui.tools.x.aNF(parambp.getUrl());
      String str2 = com.tencent.mm.pluginsdk.ui.tools.x.aNF(paramString);
      String str3 = com.tencent.mm.pluginsdk.ui.tools.x.aNF(parambp.getTitle());
      com.tencent.mm.plugin.report.service.g.yhR.f(15413, new Object[] { Integer.valueOf(9), str2, str3, parambp.afw(), parambp.aCl(), str1, Integer.valueOf(parambp.aCt()), Integer.valueOf(parambp.aCr()) });
    }
    parambp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(161677);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/readerapp/ui/ReaderAppUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (20 == paramInt1)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(15413, new Object[] { Integer.valueOf(8), paramString, parambp.getTitle() });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("mode", 1);
          localObject = parambp.getUrl();
          paramAnonymousView.putExtra("news_svr_id", parambp.hHM);
          paramAnonymousView.putExtra("news_svr_tweetid", parambp.aCl());
          paramAnonymousView.putExtra("rawUrl", ReaderAppUI.a(ReaderAppUI.this, (String)localObject));
          paramAnonymousView.putExtra("title", parambp.getName());
          paramAnonymousView.putExtra("webpageTitle", parambp.getTitle());
          paramAnonymousView.putExtra("key_show_web_page_title", true);
          paramAnonymousView.putExtra("useJs", true);
          paramAnonymousView.putExtra("vertical_scroll", true);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("snsWebSource", 3);
          paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject);
          paramAnonymousView.putExtra("shortUrl", parambp.aCm());
          paramAnonymousView.putExtra("type", parambp.type);
          paramAnonymousView.putExtra("tweetid", parambp.aCl());
          paramAnonymousView.putExtra("geta8key_username", "newsapp");
          paramAnonymousView.putExtra("KPublisherId", "msg_" + Long.toString(parambp.hHM));
          paramAnonymousView.putExtra("pre_username", "newsapp");
          paramAnonymousView.putExtra("prePublishId", "msg_" + Long.toString(parambp.hHM));
          paramAnonymousView.putExtra("preUsername", "newsapp");
          paramAnonymousView.putExtra("preChatName", "newsapp");
          paramAnonymousView.putExtra("preMsgIndex", paramInt2);
          paramAnonymousView.putExtra("geta8key_scene", 66);
          paramAnonymousView.putExtra("webview_scene_type", 1);
          paramAnonymousView.putExtra("webview_scene_note", com.tencent.mm.pluginsdk.ui.tools.x.aNF(String.format("%d|%d|%s|%s|%s", new Object[] { Integer.valueOf(parambp.aCt()), Integer.valueOf(parambp.aCr()), parambp.afw(), paramString, parambp.aCl() })));
          paramAnonymousView.putExtra("bizEnterId", (int)(System.currentTimeMillis() / 1000L));
          paramAnonymousView.putExtra("KOpenArticleSceneFromScene", 0);
          paramAnonymousView.addFlags(536870912);
          com.tencent.mm.plugin.readerapp.b.a.iRG.i(paramAnonymousView, ReaderAppUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(161677);
      }
    };
    AppMethodBeat.o(102758);
    return parambp;
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
      this.xmv = new f(bt.convertStreamToString(getAssets().open("chatting/purecolor_chat.xml")), this);
      this.vHS = ((ListView)findViewById(2131303774));
      this.vHW = ((MMPullDownView)findViewById(2131303777));
      this.vHW.setIsReturnSuperDispatchWhenCancel(true);
      this.jfs = getLayoutInflater().inflate(2131495179, null);
      this.vHS.addHeaderView(this.jfs);
      ((TextView)findViewById(2131299468)).setText(2131762171);
      this.xmu = new a(this, "");
      this.vHS.setOnScrollListener(this.xmu);
      this.vHS.setAdapter(this.xmu);
      this.vHS.setTranscriptMode(0);
      registerForContextMenu(this.vHS);
      this.nZK = new com.tencent.mm.ui.widget.b.a(this);
      this.nZK.Lal = true;
      if (this.xmu.getCount() == 0)
      {
        Object localObject = new Intent(this, ReaderAppIntroUI.class);
        ((Intent)localObject).putExtra("type", this.dEj);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
      this.vHW.setOnTopLoadDataListener(new MMPullDownView.g()
      {
        public final boolean cbd()
        {
          AppMethodBeat.i(161680);
          if (ReaderAppUI.c(ReaderAppUI.this).bXb())
          {
            ReaderAppUI.b(ReaderAppUI.this).setSelectionFromTop(0, ReaderAppUI.e(ReaderAppUI.this).getTopHeight());
            AppMethodBeat.o(161680);
            return true;
          }
          int i = ReaderAppUI.c(ReaderAppUI.this).getCount();
          int j = ReaderAppUI.c(ReaderAppUI.this).bXc();
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
      this.vHW.setTopViewVisible(true);
      this.vHW.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean cbc()
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
      this.vHW.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean cbb()
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
      this.vHW.setIsBottomShowAll(true);
      this.xmu.a(new r.a()
      {
        public final void aSs()
        {
          AppMethodBeat.i(161683);
          ReaderAppUI.e(ReaderAppUI.this).setIsTopShowAll(ReaderAppUI.c(ReaderAppUI.this).bXb());
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
          com.tencent.mm.plugin.readerapp.b.a.iRG.c(new Intent().putExtra("Contact_User", ReaderAppUI.f(ReaderAppUI.this)), ReaderAppUI.this);
          AppMethodBeat.o(161684);
          return true;
        }
      });
      this.vHS.setSelection(this.xmu.getShowCount() - 1 + this.vHS.getHeaderViewsCount());
      AppMethodBeat.o(102757);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102752);
    super.onCreate(paramBundle);
    this.dEj = getIntent().getIntExtra("type", 0);
    ad.i("MicroMsg.ReaderAppUI", "[onCreate] readerType:%s", new Object[] { Integer.valueOf(this.dEj) });
    this.dEj = 20;
    density = com.tencent.mm.cc.a.getDensity(this);
    long l = System.currentTimeMillis();
    initView();
    ad.i("MicroMsg.ReaderAppUI", "[initView] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.vdB = bp.oz(this.dEj);
    if ((20 == this.dEj) && (com.tencent.mm.model.x.aF("newsapp", null) > 0)) {
      com.tencent.mm.plugin.report.service.g.yhR.f(13440, new Object[] { Integer.valueOf(2) });
    }
    AppMethodBeat.o(102752);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(102753);
    if (this.xmu != null)
    {
      this.xmu.det();
      this.xmu.fvg();
    }
    super.onDestroy();
    AppMethodBeat.o(102753);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(102755);
    super.onPause();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().un("");
    com.tencent.mm.plugin.readerapp.c.g.dDD().remove(this.xmu);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTB(this.vdB);
    AppMethodBeat.o(102755);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(102754);
    super.onResume();
    if (this.dEj == 20) {
      setMMTitle(2131760208);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().un(this.vdB);
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(this.vdB);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTB(this.vdB);
      com.tencent.mm.plugin.readerapp.c.g.dDD().add(this.xmu);
      this.xmu.a(null, null);
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
    if (this.dEj == 20)
    {
      i = 2131762179;
      localTextView.setText(i);
      if (this.xmu.getCount() != 0) {
        break label97;
      }
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      if ((this.vHS != null) && ((this.xmu instanceof a))) {
        this.vHS.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161678);
            ((ReaderAppUI.a)ReaderAppUI.c(ReaderAppUI.this)).he(ReaderAppUI.b(ReaderAppUI.this).getFirstVisiblePosition(), ReaderAppUI.b(ReaderAppUI.this).getLastVisiblePosition());
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
    private int fTM;
    private int oIZ;
    private int oaf;
    private int oag;
    private int oah;
    private int oai;
    private int oak;
    private Html.ImageGetter xmC;
    private int xmD;
    private int xmE;
    private int xmF;
    int xmG;
    int xmH;
    int xmI;
    
    public a(Context paramContext, String paramString)
    {
      super(paramString);
      AppMethodBeat.i(102732);
      this.xmC = new Html.ImageGetter()
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
      this.xmD = 0;
      this.oai = 0;
      this.oag = 0;
      this.oah = 0;
      this.xmE = 0;
      this.xmF = 0;
      this.xmG = 0;
      this.xmH = 1;
      this.xmI = 2;
      this.context = paramContext;
      this.oIZ = 3;
      this.fTM = com.tencent.mm.plugin.readerapp.c.g.dDD().oC(ReaderAppUI.a(ReaderAppUI.this));
      this.oai = paramContext.getResources().getDimensionPixelSize(2131165568);
      this.oag = paramContext.getResources().getDimensionPixelSize(2131165480);
      this.xmD = paramContext.getResources().getDimensionPixelSize(2131165187);
      this.oah = paramContext.getResources().getDimensionPixelSize(2131165500);
      this.oaf = paramContext.getResources().getDimensionPixelSize(2131166025);
      this.oak = paramContext.getResources().getDimensionPixelSize(2131166023);
      int i = com.tencent.mm.cc.a.ip(paramContext);
      int j = com.tencent.mm.cc.a.iq(paramContext);
      if (i < j) {}
      for (;;)
      {
        this.xmE = ((int)((i - (int)(ReaderAppUI.dDE() * 28.0F)) / 2.35D));
        this.xmF = ((int)((i - ReaderAppUI.dDE() * 52.0F) / 2.0F) * 4 / 3);
        AppMethodBeat.o(102732);
        return;
        i = j;
      }
    }
    
    private List<bp> Nt(int paramInt)
    {
      AppMethodBeat.i(102739);
      Object localObject = getItem(paramInt);
      localObject = com.tencent.mm.plugin.readerapp.c.g.dDD().ah((String)localObject, 20);
      AppMethodBeat.o(102739);
      return localObject;
    }
    
    private static void X(View paramView, int paramInt)
    {
      AppMethodBeat.i(102741);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.height = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(102741);
    }
    
    private static void Y(View paramView, int paramInt)
    {
      AppMethodBeat.i(102742);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.rightMargin = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(102742);
    }
    
    private static d.a a(bp parambp)
    {
      AppMethodBeat.i(209001);
      if (parambp == null)
      {
        AppMethodBeat.o(209001);
        return null;
      }
      d.a locala = new d.a();
      locala.url = parambp.getUrl();
      locala.nWh = 164;
      locala.appId = "wx073f4a4daff0abe8";
      locala.title = parambp.getTitle();
      locala.desc = parambp.getDigest();
      locala.dET = "message";
      AppMethodBeat.o(209001);
      return locala;
    }
    
    private void a(a parama, int paramInt, List<bp> paramList)
    {
      AppMethodBeat.i(102743);
      int i = paramList.size();
      if (paramInt == 1) {
        if (bt.isNullOrNil(((bp)paramList.get(0)).aCp()))
        {
          parama.iCM.setVisibility(0);
          Y(parama.iCM, this.oag);
        }
      }
      while (paramInt == 1) {
        if (paramInt == i - 1)
        {
          parama.oeQ.setPadding(0, this.oag, 0, this.oag);
          AppMethodBeat.o(102743);
          return;
          parama.iCM.setVisibility(8);
          continue;
          parama.iCM.setVisibility(0);
          bp localbp = (bp)paramList.get(paramInt - 1);
          paramList = (bp)paramList.get(paramInt);
          if ((bt.isNullOrNil(localbp.aCp())) || (bt.isNullOrNil(paramList.aCp()))) {
            Y(parama.iCM, this.oag);
          } else {
            Y(parama.iCM, this.oak);
          }
        }
        else
        {
          parama.oeQ.setPadding(0, this.oag, 0, this.oai);
          AppMethodBeat.o(102743);
          return;
        }
      }
      if (paramInt == i - 1)
      {
        parama.oeQ.setPadding(0, this.oai, 0, this.oag);
        AppMethodBeat.o(102743);
        return;
      }
      parama.oeQ.setPadding(0, this.oai, 0, this.oai);
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
      paramb.xmN.addView(parama.odh);
      paramb.oft.add(parama);
      AppMethodBeat.o(102731);
    }
    
    private void a(b paramb, List<bp> paramList, int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(102740);
      a locala = new a();
      locala.odh = View.inflate(this.context, paramInt1, null);
      if (paramInt1 == 2131495189)
      {
        locala.odh.setBackground(ao.c(ReaderAppUI.this.getResources().getDrawable(2131231693), aq.jV(ReaderAppUI.this.getContext())));
        locala.gnM = ((TextView)locala.odh.findViewById(2131305902));
        locala.ocn = ((ImageView)locala.odh.findViewById(2131298813));
        locala.oeT = locala.odh.findViewById(2131298814);
        locala.iCM = locala.odh.findViewById(2131306012);
        locala.oeQ = locala.odh.findViewById(2131298764);
        a(paramb, locala);
        paramb = (bp)paramList.get(paramInt2);
        a(locala, paramInt2, paramList);
        locala.gnM.setText(paramb.getTitle());
        locala.gnM.setText(paramb.getTitle());
        if (bt.isNullOrNil(paramb.aCp())) {
          break label380;
        }
        locala.ocn.setVisibility(0);
        a(paramb.aCp(), locala.ocn, this.oaf, this.oaf);
      }
      for (;;)
      {
        paramList = ReaderAppUI.this.a(paramb, ReaderAppUI.a(ReaderAppUI.this), paramInt2, paramString);
        locala.odh.setOnClickListener(paramList);
        paramList = (com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class);
        if (paramList != null)
        {
          paramList.a(paramb.getUrl(), 164, "wx073f4a4daff0abe8", paramb.getTitle(), paramb.getDigest(), "message", 16);
          paramList.cu(paramb.getUrl(), 16);
        }
        AppMethodBeat.o(102740);
        return;
        if (paramInt1 != 2131495188) {
          break;
        }
        locala.odh.setBackground(ao.c(ReaderAppUI.this.getResources().getDrawable(2131231692), aq.jV(ReaderAppUI.this.getContext())));
        break;
        label380:
        locala.oeT.setVisibility(8);
      }
    }
    
    private static void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102744);
      paramString = t.FB(paramString);
      com.tencent.mm.aw.a.a locala = q.aIJ();
      c.a locala1 = new c.a();
      locala1.idG = 2131100141;
      locala1.idr = true;
      locala1 = locala1.dh(paramInt1, paramInt2);
      locala1.idg = new com.tencent.mm.pluginsdk.ui.applet.n();
      locala1.idP = new e();
      locala1.hdP = r.aLC(paramString);
      locala.a(paramString, paramImageView, locala1.aJc(), null, new com.tencent.mm.pluginsdk.ui.applet.m((byte)0));
      AppMethodBeat.o(102744);
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(102736);
      String str = (String)super.getItem(paramInt);
      AppMethodBeat.o(102736);
      return str;
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(102735);
      long l = System.currentTimeMillis();
      this.fTM = com.tencent.mm.plugin.readerapp.c.g.dDD().oC(20);
      setCursor(com.tencent.mm.plugin.readerapp.c.g.dDD().oB(this.oIZ));
      ad.i("MicroMsg.ReaderAppUI", "[resetCursor] cost:%sms showCount:%s totalCount:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.oIZ), Integer.valueOf(this.fTM) });
      super.notifyDataSetChanged();
      AppMethodBeat.o(102735);
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(102733);
      Zu();
      AppMethodBeat.o(102733);
    }
    
    public final boolean bXb()
    {
      return this.oIZ >= this.fTM;
    }
    
    public final int bXc()
    {
      AppMethodBeat.i(102734);
      if (bXb())
      {
        AppMethodBeat.o(102734);
        return 0;
      }
      this.oIZ += 3;
      if (this.oIZ <= this.fTM)
      {
        AppMethodBeat.o(102734);
        return 3;
      }
      this.oIZ = this.fTM;
      int i = this.fTM;
      AppMethodBeat.o(102734);
      return i % 3;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(102737);
      List localList = Nt(paramInt);
      if (bt.hj(localList))
      {
        ad.e("MicroMsg.ReaderAppUI", "getItemViewType info is null");
        paramInt = this.xmG;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      if (((bp)localList.get(0)).aCr() == 1) {}
      for (paramInt = 1; (paramInt != 0) && (localList.size() >= 2); paramInt = 0)
      {
        paramInt = this.xmH;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      paramInt = this.xmG;
      AppMethodBeat.o(102737);
      return paramInt;
    }
    
    public final int getShowCount()
    {
      return this.oIZ;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102738);
      if (getItemViewType(paramInt) == this.xmH)
      {
        if (paramView == null)
        {
          paramViewGroup = new b();
          paramView = View.inflate(this.context, 2131495186, null);
          paramViewGroup.umZ = ((TextView)paramView.findViewById(2131306963));
          paramViewGroup.fRd = ((ImageView)paramView.findViewById(2131297008));
          paramViewGroup.jcd = ((TextView)paramView.findViewById(2131302860));
          paramViewGroup.xmQ = new c();
          paramViewGroup.xmQ.ocz = paramView.findViewById(2131298819);
          paramViewGroup.xmQ.dDF();
          paramViewGroup.xmR = new c();
          paramViewGroup.xmR.ocz = paramView.findViewById(2131298820);
          paramViewGroup.xmR.dDF();
          paramView.setTag(paramViewGroup);
          localObject2 = Nt(paramInt);
          if ((localObject2 == null) || (((List)localObject2).size() < 2)) {
            break label486;
          }
          paramView.setVisibility(0);
          localObject1 = (bp)((List)localObject2).get(0);
          paramViewGroup.umZ.setText(com.tencent.mm.pluginsdk.i.i.c(this.context, ((bp)localObject1).time, false));
          localObject3 = new c.a();
          ((c.a)localObject3).idG = 2131231342;
          ((c.a)localObject3).idq = true;
          ((c.a)localObject3).hfi = true;
          q.aIJ().a(((bp)localObject1).aCo(), paramViewGroup.fRd, ((c.a)localObject3).aJc());
          paramViewGroup.jcd.setText(((bp)localObject1).aCn());
          paramViewGroup.jcd.getPaint().setFakeBoldText(true);
          if (ReaderAppUI.i(ReaderAppUI.this) != null)
          {
            paramViewGroup.umZ.setTextColor(ReaderAppUI.i(ReaderAppUI.this).ESd);
            if (!ReaderAppUI.i(ReaderAppUI.this).ESe) {
              break label461;
            }
            paramViewGroup.umZ.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).ESf);
            label353:
            if (!ReaderAppUI.i(ReaderAppUI.this).ESg) {
              break label475;
            }
            paramViewGroup.umZ.setBackgroundResource(2131231582);
            paramViewGroup.umZ.setPadding(this.oai, this.xmD, this.oai, this.xmD);
          }
          label399:
          localObject2 = (bp)((List)localObject2).get(1);
          paramViewGroup.xmQ.a((bp)localObject1, paramInt, ((bp)localObject1).getTitle());
          paramViewGroup.xmR.a((bp)localObject2, paramInt, ((bp)localObject1).getTitle());
        }
        for (;;)
        {
          AppMethodBeat.o(102738);
          return paramView;
          paramViewGroup = (b)paramView.getTag();
          break;
          label461:
          paramViewGroup.umZ.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break label353;
          label475:
          paramViewGroup.umZ.setBackgroundColor(0);
          break label399;
          label486:
          paramView.setVisibility(8);
        }
      }
      if (paramView == null)
      {
        paramViewGroup = new b();
        paramView = View.inflate(this.context, 2131495181, null);
        paramViewGroup.umZ = ((TextView)paramView.findViewById(2131303764));
        paramViewGroup.xmN = ((ViewGroup)paramView.findViewById(2131303759));
        paramViewGroup.jlR = paramView.findViewById(2131297444);
        paramViewGroup.ocL = paramView.findViewById(2131298818);
        paramViewGroup.ocB = ((ImageView)paramView.findViewById(2131303387));
        paramViewGroup.xmP = ((ImageView)paramView.findViewById(2131298831));
        paramViewGroup.gnM = ((TextView)paramView.findViewById(2131303765));
        paramViewGroup.xmM = ((ImageView)paramView.findViewById(2131303763));
        paramViewGroup.vHM = ((TextView)paramView.findViewById(2131303762));
        paramViewGroup.ocz = paramView.findViewById(2131305992);
        paramViewGroup.xmO = ((MMNeat7extView)paramView.findViewById(2131305946));
        paramViewGroup.oft = new ArrayList();
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject1 = paramViewGroup.oft.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          paramViewGroup.xmN.removeView(((a)localObject2).odh);
        }
        paramViewGroup = (b)paramView.getTag();
      }
      paramViewGroup.oft.clear();
      Object localObject1 = Nt(paramInt);
      label923:
      label965:
      int i;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int k = ((List)localObject1).size();
        localObject2 = (bp)((List)localObject1).get(0);
        paramViewGroup.umZ.setText(com.tencent.mm.pluginsdk.i.i.c(this.context, ((bp)localObject2).time, false));
        if (ReaderAppUI.i(ReaderAppUI.this) != null)
        {
          paramViewGroup.umZ.setTextColor(ReaderAppUI.i(ReaderAppUI.this).ESd);
          if (ReaderAppUI.i(ReaderAppUI.this).ESe)
          {
            paramViewGroup.umZ.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).ESf);
            if (!ReaderAppUI.i(ReaderAppUI.this).ESg) {
              break label1444;
            }
            paramViewGroup.umZ.setBackgroundResource(2131231582);
            paramViewGroup.umZ.setPadding(this.oai, this.xmD, this.oai, this.xmD);
          }
        }
        else
        {
          localObject3 = ReaderAppUI.this.a((bp)localObject2, ReaderAppUI.a(ReaderAppUI.this), 0, ((bp)localObject2).getTitle());
          paramViewGroup.ocz.setOnClickListener((View.OnClickListener)localObject3);
          if (k != 1) {
            break label1455;
          }
          bool = true;
          paramViewGroup.gnM.setText(((bp)localObject2).getTitle());
          paramViewGroup.vHM.setText(((bp)localObject2).getDigest());
          if (bt.isNullOrNil(((bp)localObject2).aCp())) {
            break label1461;
          }
          i = 1;
          label1003:
          paramViewGroup.xmO.ar(((bp)localObject2).getTitle());
          localObject3 = paramViewGroup.vHM;
          if ((bool) && (!bt.isNullOrNil(((bp)localObject2).getDigest()))) {
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
          paramViewGroup.xmP.setVisibility(8);
          if (!bool) {
            break label1473;
          }
          paramViewGroup.ocB.setBackgroundResource(2131231708);
          paramViewGroup.jlR.setVisibility(0);
          paramViewGroup.xmO.setVisibility(8);
          paramViewGroup.gnM.setVisibility(0);
          X(paramViewGroup.ocB, this.xmE);
          X(paramViewGroup.ocL, this.xmE);
          if (i == 0) {
            break label1575;
          }
          paramViewGroup.ocL.setVisibility(0);
          String str = ((bp)localObject2).aCp();
          localObject3 = paramViewGroup.xmM;
          i = this.xmE;
          localObject4 = new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(102727);
              if (!bool)
              {
                paramViewGroup.xmO.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131101182));
                paramViewGroup.xmO.setBackgroundResource(2131231208);
              }
              paramViewGroup.xmP.setVisibility(0);
              AppMethodBeat.o(102727);
            }
            
            public final void onStart() {}
          };
          str = t.FB(str);
          float f = ((ImageView)localObject3).getResources().getDimensionPixelSize(2131166028);
          j = com.tencent.mm.cc.a.ip(ReaderAppUI.this.getContext()) - (int)(ReaderAppUI.dDE() * 28.0F);
          com.tencent.mm.aw.a.a locala = q.aIJ();
          c.a locala1 = new c.a();
          locala1.idG = 2131231198;
          locala1.idr = true;
          locala1.idI = "2131231189";
          locala1 = locala1.dh(j, i);
          locala1.idg = new com.tencent.mm.pluginsdk.ui.applet.n();
          locala1.idP = new e();
          locala1.hdP = r.aLC(str);
          locala.a(str, (ImageView)localObject3, locala1.aJc(), null, new com.tencent.mm.pluginsdk.ui.applet.m(0, j, i, true, false, f, (m.a)localObject4));
          paramViewGroup.jlR.setBackground(ao.e(ReaderAppUI.this.getResources().getDrawable(2131231686), this.context.getResources().getColor(2131099650)));
          paramViewGroup.jlR.setPadding(this.oag, this.oah, this.oag, this.oag);
          paramViewGroup.ocB.setVisibility(0);
          if (k <= 1) {
            break label1708;
          }
          i = 1;
          while (i < k - 1)
          {
            a(paramViewGroup, (List)localObject1, 2131495189, i, ((bp)localObject2).getTitle());
            i += 1;
          }
          paramViewGroup.umZ.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break;
          paramViewGroup.umZ.setBackgroundColor(0);
          break label923;
          bool = false;
          break label965;
          i = 0;
          break label1003;
        }
        label1473:
        paramViewGroup.ocB.setBackgroundResource(2131231710);
        localObject3 = paramViewGroup.jlR;
        if (i != 0) {}
        for (j = 8;; j = 0)
        {
          ((View)localObject3).setVisibility(j);
          paramViewGroup.gnM.setVisibility(8);
          paramViewGroup.xmO.setVisibility(0);
          paramViewGroup.xmO.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131100541));
          paramViewGroup.xmO.setBackgroundResource(2131233299);
          paramViewGroup.xmO.getPaint().setFakeBoldText(true);
          break;
        }
        label1575:
        paramViewGroup.ocL.setVisibility(8);
        paramViewGroup.gnM.setVisibility(0);
        localObject3 = paramViewGroup.vHM;
        if (bt.isNullOrNil(((bp)localObject2).getDigest()))
        {
          i = 8;
          label1613:
          ((TextView)localObject3).setVisibility(i);
          if (!bool) {
            break label1676;
          }
          paramViewGroup.jlR.setBackgroundResource(2131231695);
        }
        for (;;)
        {
          paramViewGroup.jlR.setPadding(this.oag, this.oag, this.oag, this.oag);
          paramViewGroup.ocB.setVisibility(8);
          break;
          i = 0;
          break label1613;
          label1676:
          paramViewGroup.jlR.setBackgroundResource(2131231694);
        }
        a(paramViewGroup, (List)localObject1, 2131495188, k - 1, ((bp)localObject2).getTitle());
        label1708:
        localObject3 = (com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class);
        if (localObject3 != null)
        {
          ((com.tencent.mm.plugin.brandservice.a.d)localObject3).a(((bp)localObject2).getUrl(), 164, "wx073f4a4daff0abe8", ((bp)localObject2).getTitle(), ((bp)localObject2).getDigest(), "message", 8);
          ((com.tencent.mm.plugin.brandservice.a.d)localObject3).cu(((bp)localObject2).getUrl(), 8);
        }
      }
      paramViewGroup.ocz.setTag(Integer.valueOf(paramInt));
      paramViewGroup.ocz.setTag(2131303776, Integer.valueOf(0));
      Object localObject2 = ReaderAppUI.h(ReaderAppUI.this);
      Object localObject3 = paramViewGroup.ocz;
      Object localObject4 = ReaderAppUI.this;
      if (((List)localObject1).size() == 1)
      {
        bool = true;
        ((com.tencent.mm.ui.widget.b.a)localObject2).a((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(ReaderAppUI.this));
        paramViewGroup = paramViewGroup.oft.iterator();
        i = 1;
        label1863:
        if (!paramViewGroup.hasNext()) {
          break label1989;
        }
        localObject3 = (a)paramViewGroup.next();
        ((a)localObject3).odh.setTag(Integer.valueOf(paramInt));
        ((a)localObject3).odh.setTag(2131303776, Integer.valueOf(i));
        localObject2 = ReaderAppUI.h(ReaderAppUI.this);
        localObject3 = ((a)localObject3).odh;
        localObject4 = ReaderAppUI.this;
        if (((List)localObject1).size() != 1) {
          break label1983;
        }
      }
      label1983:
      for (final boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.ui.widget.b.a)localObject2).a((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(ReaderAppUI.this));
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
      return this.xmI;
    }
    
    public final void he(int paramInt1, int paramInt2)
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
        List localList = Nt(paramInt1 - 1);
        if ((localList != null) && (localList.size() > 0))
        {
          localLinkedList.clear();
          d.a locala = a((bp)localList.get(0));
          if (locala != null)
          {
            localLinkedList.add(locala);
            locald.cu(locala.url, 8);
          }
          if (localLinkedList.size() > 0) {
            locald.m(localLinkedList, 8);
          }
          ad.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authTop = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
          localLinkedList.clear();
          int i = 1;
          while (i < localList.size())
          {
            locala = a((bp)localList.get(i));
            if (locala != null)
            {
              localLinkedList.add(locala);
              locald.cu(locala.url, 16);
            }
            i += 1;
          }
          if (localLinkedList.size() > 0) {
            locald.m(localLinkedList, 16);
          }
          ad.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authCommon = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
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
        he(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition());
      }
      AppMethodBeat.o(102745);
    }
    
    final class a
    {
      TextView gnM;
      View iCM;
      ImageView ocn;
      View odh;
      View oeQ;
      View oeT;
      
      a() {}
    }
    
    final class b
    {
      ImageView fRd;
      TextView gnM;
      TextView jcd;
      View jlR;
      ImageView ocB;
      View ocL;
      View ocz;
      List<ReaderAppUI.a.a> oft;
      TextView umZ;
      TextView vHM;
      ImageView xmM;
      ViewGroup xmN;
      MMNeat7extView xmO;
      ImageView xmP;
      ReaderAppUI.a.c xmQ;
      ReaderAppUI.a.c xmR;
      
      b() {}
    }
    
    final class c
    {
      ImageView oSB;
      View ocz;
      MMNeat7extView opB;
      View xmS;
      View xmT;
      ImageView xmU;
      ImageView xmV;
      TextView xmW;
      
      c() {}
      
      final void a(bp parambp, int paramInt, String paramString)
      {
        AppMethodBeat.i(102730);
        paramString = ReaderAppUI.this.a(parambp, ReaderAppUI.a(ReaderAppUI.this), 0, paramString);
        if (this.ocz == null)
        {
          AppMethodBeat.o(102730);
          return;
        }
        this.ocz.setOnClickListener(paramString);
        this.ocz.setTag(Integer.valueOf(paramInt));
        this.ocz.setTag(2131303776, Integer.valueOf(paramInt));
        ReaderAppUI.h(ReaderAppUI.this).a(this.ocz, ReaderAppUI.a(ReaderAppUI.this, false), ReaderAppUI.g(ReaderAppUI.this));
        this.opB.ar(parambp.getTitle());
        paramString = com.tencent.mm.ai.m.oi(parambp.aCs());
        if (!bt.isNullOrNil(paramString))
        {
          this.xmW.setText(paramString);
          this.xmS.setVisibility(0);
        }
        for (;;)
        {
          this.opB.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131100541));
          this.xmT.setBackgroundResource(2131233299);
          paramInt = (int)(this.xmW.getTextSize() * 1.7D);
          paramString = this.xmV.getLayoutParams();
          paramString.height = paramInt;
          paramString.width = paramInt;
          this.xmV.setLayoutParams(paramString);
          ReaderAppUI.a.ap(this.oSB, ReaderAppUI.a.a(ReaderAppUI.a.this));
          ReaderAppUI.a.a(ReaderAppUI.a.this, parambp.aCp(), this.oSB, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(102728);
              ReaderAppUI.a.c.this.opB.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131101182));
              ReaderAppUI.a.c.this.xmT.setBackgroundResource(2131234756);
              AppMethodBeat.o(102728);
            }
            
            public final void onStart() {}
          });
          AppMethodBeat.o(102730);
          return;
          this.xmS.setVisibility(8);
        }
      }
      
      final void dDF()
      {
        AppMethodBeat.i(102729);
        if (this.ocz == null)
        {
          AppMethodBeat.o(102729);
          return;
        }
        this.oSB = ((ImageView)this.ocz.findViewById(2131306962));
        this.xmU = ((ImageView)this.ocz.findViewById(2131303387));
        this.opB = ((MMNeat7extView)this.ocz.findViewById(2131305946));
        this.xmW = ((TextView)this.ocz.findViewById(2131306310));
        this.xmV = ((ImageView)this.ocz.findViewById(2131303285));
        this.xmS = this.ocz.findViewById(2131303292);
        this.xmT = this.ocz.findViewById(2131306959);
        AppMethodBeat.o(102729);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI
 * JD-Core Version:    0.7.0.1
 */