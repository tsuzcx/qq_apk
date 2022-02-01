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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.av.t;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private int dFo;
  private View jil;
  private com.tencent.mm.ui.widget.b.a ofu;
  private n.e ogY;
  private ListView vTW;
  private MMPullDownView vUa;
  private String vpM;
  private a<String> xCr;
  private f xCs;
  private int xCt;
  
  public ReaderAppUI()
  {
    AppMethodBeat.i(102751);
    this.dFo = 0;
    this.vpM = "";
    this.xCs = null;
    this.xCt = 0;
    this.ogY = new n.e()
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
          if (!bu.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.plugin.readerapp.c.g.eQ((String)localObject1, ReaderAppUI.a(ReaderAppUI.this));
            paramAnonymousMenuItem = com.tencent.mm.plugin.readerapp.c.g.dGU();
            paramAnonymousInt = ReaderAppUI.a(ReaderAppUI.this);
            localObject1 = "delete from " + bs.oD(paramAnonymousInt) + " where reserved3 = " + h.wX((String)localObject1);
            ae.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[] { localObject1 });
            if (paramAnonymousMenuItem.hKK.execSQL(bs.oD(paramAnonymousInt), (String)localObject1))
            {
              paramAnonymousMenuItem.oH(paramAnonymousInt);
              paramAnonymousMenuItem.doNotify();
            }
          }
          ReaderAppUI.this.refresh();
          AppMethodBeat.o(161679);
          return;
          if (ReaderAppUI.a(ReaderAppUI.this) == 20)
          {
            paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
            paramAnonymousMenuItem = com.tencent.mm.plugin.readerapp.c.g.dGU().ai(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
            Object localObject2;
            if (paramAnonymousMenuItem.size() > 0)
            {
              paramAnonymousMenuItem = (com.tencent.mm.model.br)paramAnonymousMenuItem.get(0);
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
              ((Intent)localObject1).putExtra("Retr_Msg_thumb_path", r.aMY(paramAnonymousMenuItem.aCF()));
              ((Intent)localObject1).putExtra("Retr_Msg_Id", 7377812);
              localObject2 = z.Br(paramAnonymousMenuItem.hKE);
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              localObject2 = z.aBG().F((String)localObject2, true);
              ((z.b)localObject2).k("prePublishId", "msg_" + paramAnonymousMenuItem.hKE);
              ((z.b)localObject2).k("preUsername", "newsapp");
              ((z.b)localObject2).k("preChatName", "newsapp");
              ((z.b)localObject2).k("preMsgIndex", Integer.valueOf(0));
              ((z.b)localObject2).k("sendAppMsgScene", Integer.valueOf(1));
              com.tencent.mm.plugin.readerapp.b.a.iUz.k((Intent)localObject1, ReaderAppUI.this);
            }
            AppMethodBeat.o(161679);
            return;
            if (ReaderAppUI.a(ReaderAppUI.this) == 20)
            {
              paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
              localObject1 = com.tencent.mm.plugin.readerapp.c.g.dGU().ai(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
              if (!((List)localObject1).isEmpty())
              {
                ae.i("MicroMsg.ReaderAppUI", "fav functionId %s, index %d, size %d", new Object[] { paramAnonymousMenuItem, Integer.valueOf(ReaderAppUI.d(ReaderAppUI.this)), Integer.valueOf(((List)localObject1).size()) });
                if (ReaderAppUI.d(ReaderAppUI.this) >= ((List)localObject1).size()) {
                  ReaderAppUI.a(ReaderAppUI.this, 0);
                }
                paramAnonymousMenuItem = (com.tencent.mm.model.br)((List)localObject1).get(ReaderAppUI.d(ReaderAppUI.this));
                localObject1 = new cw();
                localObject2 = z.Br(paramAnonymousMenuItem.hKE);
                z.b localb = z.aBG().F((String)localObject2, true);
                localb.k("prePublishId", "msg_" + paramAnonymousMenuItem.hKE);
                localb.k("preUsername", "newsapp");
                localb.k("preChatName", "newsapp");
                localb.k("preMsgIndex", Integer.valueOf(0));
                localb.k("sendAppMsgScene", Integer.valueOf(1));
                ((cw)localObject1).doL.sessionId = ((String)localObject2);
                ReaderAppUI.d(ReaderAppUI.this);
                com.tencent.mm.plugin.readerapp.c.b.a((cw)localObject1, paramAnonymousMenuItem);
                ((cw)localObject1).doL.doR = 7;
                ((cw)localObject1).doL.activity = ReaderAppUI.this;
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
              }
            }
          }
        }
      }
    };
    AppMethodBeat.o(102751);
  }
  
  private PackageInfo awy(String paramString)
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
      ae.printErrStackTrace("MicroMsg.ReaderAppUI", paramString, "", new Object[0]);
      AppMethodBeat.o(102759);
    }
    return null;
  }
  
  public final View.OnClickListener a(final com.tencent.mm.model.br parambr, final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(102758);
    if (parambr != null)
    {
      String str1 = x.aPc(parambr.getUrl());
      String str2 = x.aPc(paramString);
      String str3 = x.aPc(parambr.getTitle());
      com.tencent.mm.plugin.report.service.g.yxI.f(15413, new Object[] { Integer.valueOf(9), str2, str3, parambr.afK(), parambr.aCB(), str1, Integer.valueOf(parambr.aCJ()), Integer.valueOf(parambr.aCH()) });
    }
    parambr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(161677);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/readerapp/ui/ReaderAppUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (20 == paramInt1)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(15413, new Object[] { Integer.valueOf(8), paramString, parambr.getTitle() });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("mode", 1);
          localObject = parambr.getUrl();
          paramAnonymousView.putExtra("news_svr_id", parambr.hKE);
          paramAnonymousView.putExtra("news_svr_tweetid", parambr.aCB());
          paramAnonymousView.putExtra("rawUrl", ReaderAppUI.a(ReaderAppUI.this, (String)localObject));
          paramAnonymousView.putExtra("title", parambr.getName());
          paramAnonymousView.putExtra("webpageTitle", parambr.getTitle());
          paramAnonymousView.putExtra("key_show_web_page_title", true);
          paramAnonymousView.putExtra("useJs", true);
          paramAnonymousView.putExtra("vertical_scroll", true);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("snsWebSource", 3);
          paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject);
          paramAnonymousView.putExtra("shortUrl", parambr.aCC());
          paramAnonymousView.putExtra("type", parambr.type);
          paramAnonymousView.putExtra("tweetid", parambr.aCB());
          paramAnonymousView.putExtra("geta8key_username", "newsapp");
          paramAnonymousView.putExtra("KPublisherId", "msg_" + Long.toString(parambr.hKE));
          paramAnonymousView.putExtra("pre_username", "newsapp");
          paramAnonymousView.putExtra("prePublishId", "msg_" + Long.toString(parambr.hKE));
          paramAnonymousView.putExtra("preUsername", "newsapp");
          paramAnonymousView.putExtra("preChatName", "newsapp");
          paramAnonymousView.putExtra("preMsgIndex", paramInt2);
          paramAnonymousView.putExtra("geta8key_scene", 66);
          paramAnonymousView.putExtra("webview_scene_type", 1);
          paramAnonymousView.putExtra("webview_scene_note", x.aPc(String.format("%d|%d|%s|%s|%s", new Object[] { Integer.valueOf(parambr.aCJ()), Integer.valueOf(parambr.aCH()), parambr.afK(), paramString, parambr.aCB() })));
          paramAnonymousView.putExtra("bizEnterId", (int)(System.currentTimeMillis() / 1000L));
          paramAnonymousView.putExtra("KOpenArticleSceneFromScene", 0);
          paramAnonymousView.addFlags(536870912);
          com.tencent.mm.plugin.readerapp.b.a.iUz.i(paramAnonymousView, ReaderAppUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(161677);
      }
    };
    AppMethodBeat.o(102758);
    return parambr;
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
      this.xCs = new f(bu.convertStreamToString(getAssets().open("chatting/purecolor_chat.xml")), this);
      this.vTW = ((ListView)findViewById(2131303774));
      this.vUa = ((MMPullDownView)findViewById(2131303777));
      this.vUa.setIsReturnSuperDispatchWhenCancel(true);
      this.jil = getLayoutInflater().inflate(2131495179, null);
      this.vTW.addHeaderView(this.jil);
      ((TextView)findViewById(2131299468)).setText(2131762171);
      this.xCr = new a(this, "");
      this.vTW.setOnScrollListener(this.xCr);
      this.vTW.setAdapter(this.xCr);
      this.vTW.setTranscriptMode(0);
      registerForContextMenu(this.vTW);
      this.ofu = new com.tencent.mm.ui.widget.b.a(this);
      this.ofu.LwJ = true;
      if (this.xCr.getCount() == 0)
      {
        Object localObject = new Intent(this, ReaderAppIntroUI.class);
        ((Intent)localObject).putExtra("type", this.dFo);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
        ae.printErrStackTrace("MicroMsg.ReaderAppUI", localException, "", new Object[0]);
      }
      this.vUa.setOnTopLoadDataListener(new MMPullDownView.g()
      {
        public final boolean ccs()
        {
          AppMethodBeat.i(161680);
          if (ReaderAppUI.c(ReaderAppUI.this).bYq())
          {
            ReaderAppUI.b(ReaderAppUI.this).setSelectionFromTop(0, ReaderAppUI.e(ReaderAppUI.this).getTopHeight());
            AppMethodBeat.o(161680);
            return true;
          }
          int i = ReaderAppUI.c(ReaderAppUI.this).getCount();
          int j = ReaderAppUI.c(ReaderAppUI.this).bYr();
          ae.v("MicroMsg.ReaderAppUI", "onLoadData add count:".concat(String.valueOf(j)));
          ReaderAppUI.c(ReaderAppUI.this).a(null, null);
          int k = ReaderAppUI.c(ReaderAppUI.this).getCount();
          ae.d("MicroMsg.ReaderAppUI", "onTopLoadData nowCount:%d, preCount:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
          if (k > i)
          {
            ae.i("MicroMsg.ReaderAppUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", new Object[] { Integer.valueOf(j + 1), Integer.valueOf(ReaderAppUI.e(ReaderAppUI.this).getTopHeight()) });
            com.tencent.mm.pluginsdk.ui.tools.n.a(ReaderAppUI.b(ReaderAppUI.this), j + 1, ReaderAppUI.e(ReaderAppUI.this).getTopHeight(), false);
          }
          AppMethodBeat.o(161680);
          return true;
        }
      });
      this.vUa.setTopViewVisible(true);
      this.vUa.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean ccr()
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
      this.vUa.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean ccq()
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
      this.vUa.setIsBottomShowAll(true);
      this.xCr.a(new r.a()
      {
        public final void aSR()
        {
          AppMethodBeat.i(161683);
          ReaderAppUI.e(ReaderAppUI.this).setIsTopShowAll(ReaderAppUI.c(ReaderAppUI.this).bYq());
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
          com.tencent.mm.plugin.readerapp.b.a.iUz.c(new Intent().putExtra("Contact_User", ReaderAppUI.f(ReaderAppUI.this)), ReaderAppUI.this);
          AppMethodBeat.o(161684);
          return true;
        }
      });
      this.vTW.setSelection(this.xCr.getShowCount() - 1 + this.vTW.getHeaderViewsCount());
      AppMethodBeat.o(102757);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102752);
    super.onCreate(paramBundle);
    this.dFo = getIntent().getIntExtra("type", 0);
    ae.i("MicroMsg.ReaderAppUI", "[onCreate] readerType:%s", new Object[] { Integer.valueOf(this.dFo) });
    this.dFo = 20;
    density = com.tencent.mm.cb.a.getDensity(this);
    long l = System.currentTimeMillis();
    initView();
    ae.i("MicroMsg.ReaderAppUI", "[initView] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.vpM = com.tencent.mm.model.br.oC(this.dFo);
    if ((20 == this.dFo) && (y.aG("newsapp", null) > 0)) {
      com.tencent.mm.plugin.report.service.g.yxI.f(13440, new Object[] { Integer.valueOf(2) });
    }
    AppMethodBeat.o(102752);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(102753);
    if (this.xCr != null)
    {
      this.xCr.dhl();
      this.xCr.fzh();
    }
    super.onDestroy();
    AppMethodBeat.o(102753);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(102755);
    super.onPause();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().uI("");
    com.tencent.mm.plugin.readerapp.c.g.dGU().remove(this.xCr);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVc(this.vpM);
    AppMethodBeat.o(102755);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(102754);
    super.onResume();
    if (this.dFo == 20) {
      setMMTitle(2131760208);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().uI(this.vpM);
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(this.vpM);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVc(this.vpM);
      com.tencent.mm.plugin.readerapp.c.g.dGU().add(this.xCr);
      this.xCr.a(null, null);
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
    if (this.dFo == 20)
    {
      i = 2131762179;
      localTextView.setText(i);
      if (this.xCr.getCount() != 0) {
        break label97;
      }
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      if ((this.vTW != null) && ((this.xCr instanceof a))) {
        this.vTW.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161678);
            ((ReaderAppUI.a)ReaderAppUI.c(ReaderAppUI.this)).hg(ReaderAppUI.b(ReaderAppUI.this).getFirstVisiblePosition(), ReaderAppUI.b(ReaderAppUI.this).getLastVisiblePosition());
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
    private int fVS;
    private int oPB;
    private int ofV;
    private int ofW;
    private int ofX;
    private int ofY;
    private int oga;
    private int xCA;
    private int xCB;
    private int xCC;
    int xCD;
    int xCE;
    int xCF;
    private Html.ImageGetter xCz;
    
    public a(Context paramContext, String paramString)
    {
      super(paramString);
      AppMethodBeat.i(102732);
      this.xCz = new Html.ImageGetter()
      {
        public final Drawable getDrawable(String paramAnonymousString)
        {
          AppMethodBeat.i(102726);
          int i = bu.getInt(paramAnonymousString, 0);
          paramAnonymousString = ReaderAppUI.this.getResources().getDrawable(i);
          paramAnonymousString.setBounds(0, 0, paramAnonymousString.getIntrinsicWidth(), paramAnonymousString.getIntrinsicHeight());
          AppMethodBeat.o(102726);
          return paramAnonymousString;
        }
      };
      this.xCA = 0;
      this.ofY = 0;
      this.ofW = 0;
      this.ofX = 0;
      this.xCB = 0;
      this.xCC = 0;
      this.xCD = 0;
      this.xCE = 1;
      this.xCF = 2;
      this.context = paramContext;
      this.oPB = 3;
      this.fVS = com.tencent.mm.plugin.readerapp.c.g.dGU().oF(ReaderAppUI.a(ReaderAppUI.this));
      this.ofY = paramContext.getResources().getDimensionPixelSize(2131165568);
      this.ofW = paramContext.getResources().getDimensionPixelSize(2131165480);
      this.xCA = paramContext.getResources().getDimensionPixelSize(2131165187);
      this.ofX = paramContext.getResources().getDimensionPixelSize(2131165500);
      this.ofV = paramContext.getResources().getDimensionPixelSize(2131166025);
      this.oga = paramContext.getResources().getDimensionPixelSize(2131166023);
      int i = com.tencent.mm.cb.a.iu(paramContext);
      int j = com.tencent.mm.cb.a.iv(paramContext);
      if (i < j) {}
      for (;;)
      {
        this.xCB = ((int)((i - (int)(ReaderAppUI.dGV() * 28.0F)) / 2.35D));
        this.xCC = ((int)((i - ReaderAppUI.dGV() * 52.0F) / 2.0F) * 4 / 3);
        AppMethodBeat.o(102732);
        return;
        i = j;
      }
    }
    
    private List<com.tencent.mm.model.br> NZ(int paramInt)
    {
      AppMethodBeat.i(102739);
      Object localObject = getItem(paramInt);
      localObject = com.tencent.mm.plugin.readerapp.c.g.dGU().ai((String)localObject, 20);
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
    
    private static d.a a(com.tencent.mm.model.br parambr)
    {
      AppMethodBeat.i(209363);
      if (parambr == null)
      {
        AppMethodBeat.o(209363);
        return null;
      }
      d.a locala = new d.a();
      locala.url = parambr.getUrl();
      locala.obQ = 164;
      locala.appId = "wx073f4a4daff0abe8";
      locala.title = parambr.getTitle();
      locala.desc = parambr.getDigest();
      locala.dFY = "message";
      AppMethodBeat.o(209363);
      return locala;
    }
    
    private void a(a parama, int paramInt, List<com.tencent.mm.model.br> paramList)
    {
      AppMethodBeat.i(102743);
      int i = paramList.size();
      if (paramInt == 1) {
        if (bu.isNullOrNil(((com.tencent.mm.model.br)paramList.get(0)).aCF()))
        {
          parama.iFF.setVisibility(0);
          Y(parama.iFF, this.ofW);
        }
      }
      while (paramInt == 1) {
        if (paramInt == i - 1)
        {
          parama.okQ.setPadding(0, this.ofW, 0, this.ofW);
          AppMethodBeat.o(102743);
          return;
          parama.iFF.setVisibility(8);
          continue;
          parama.iFF.setVisibility(0);
          com.tencent.mm.model.br localbr = (com.tencent.mm.model.br)paramList.get(paramInt - 1);
          paramList = (com.tencent.mm.model.br)paramList.get(paramInt);
          if ((bu.isNullOrNil(localbr.aCF())) || (bu.isNullOrNil(paramList.aCF()))) {
            Y(parama.iFF, this.ofW);
          } else {
            Y(parama.iFF, this.oga);
          }
        }
        else
        {
          parama.okQ.setPadding(0, this.ofW, 0, this.ofY);
          AppMethodBeat.o(102743);
          return;
        }
      }
      if (paramInt == i - 1)
      {
        parama.okQ.setPadding(0, this.ofY, 0, this.ofW);
        AppMethodBeat.o(102743);
        return;
      }
      parama.okQ.setPadding(0, this.ofY, 0, this.ofY);
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
      paramb.xCK.addView(parama.oiV);
      paramb.ols.add(parama);
      AppMethodBeat.o(102731);
    }
    
    private void a(b paramb, List<com.tencent.mm.model.br> paramList, int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(102740);
      a locala = new a();
      locala.oiV = View.inflate(this.context, paramInt1, null);
      if (paramInt1 == 2131495189)
      {
        locala.oiV.setBackground(ao.c(ReaderAppUI.this.getResources().getDrawable(2131231693), aq.kc(ReaderAppUI.this.getContext())));
        locala.gqi = ((TextView)locala.oiV.findViewById(2131305902));
        locala.oic = ((ImageView)locala.oiV.findViewById(2131298813));
        locala.okT = locala.oiV.findViewById(2131298814);
        locala.iFF = locala.oiV.findViewById(2131306012);
        locala.okQ = locala.oiV.findViewById(2131298764);
        a(paramb, locala);
        paramb = (com.tencent.mm.model.br)paramList.get(paramInt2);
        a(locala, paramInt2, paramList);
        locala.gqi.setText(paramb.getTitle());
        locala.gqi.setText(paramb.getTitle());
        if (bu.isNullOrNil(paramb.aCF())) {
          break label380;
        }
        locala.oic.setVisibility(0);
        a(paramb.aCF(), locala.oic, this.ofV, this.ofV);
      }
      for (;;)
      {
        paramList = ReaderAppUI.this.a(paramb, ReaderAppUI.a(ReaderAppUI.this), paramInt2, paramString);
        locala.oiV.setOnClickListener(paramList);
        paramList = (com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class);
        if (paramList != null)
        {
          paramList.a(paramb.getUrl(), 164, "wx073f4a4daff0abe8", paramb.getTitle(), paramb.getDigest(), "message", 16);
          paramList.cy(paramb.getUrl(), 16);
        }
        AppMethodBeat.o(102740);
        return;
        if (paramInt1 != 2131495188) {
          break;
        }
        locala.oiV.setBackground(ao.c(ReaderAppUI.this.getResources().getDrawable(2131231692), aq.kc(ReaderAppUI.this.getContext())));
        break;
        label380:
        locala.okT.setVisibility(8);
      }
    }
    
    private static void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102744);
      paramString = t.Gd(paramString);
      com.tencent.mm.av.a.a locala = q.aJb();
      c.a locala1 = new c.a();
      locala1.igy = 2131100141;
      locala1.igk = true;
      locala1 = locala1.dh(paramInt1, paramInt2);
      locala1.ifZ = new com.tencent.mm.pluginsdk.ui.applet.n();
      locala1.igH = new e();
      locala1.hgD = r.aMY(paramString);
      locala.a(paramString, paramImageView, locala1.aJu(), null, new com.tencent.mm.pluginsdk.ui.applet.m((byte)0));
      AppMethodBeat.o(102744);
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(102736);
      String str = (String)super.getItem(paramInt);
      AppMethodBeat.o(102736);
      return str;
    }
    
    public final void ZD()
    {
      AppMethodBeat.i(102735);
      long l = System.currentTimeMillis();
      this.fVS = com.tencent.mm.plugin.readerapp.c.g.dGU().oF(20);
      setCursor(com.tencent.mm.plugin.readerapp.c.g.dGU().oE(this.oPB));
      ae.i("MicroMsg.ReaderAppUI", "[resetCursor] cost:%sms showCount:%s totalCount:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.oPB), Integer.valueOf(this.fVS) });
      super.notifyDataSetChanged();
      AppMethodBeat.o(102735);
    }
    
    public final void ZE()
    {
      AppMethodBeat.i(102733);
      ZD();
      AppMethodBeat.o(102733);
    }
    
    public final boolean bYq()
    {
      return this.oPB >= this.fVS;
    }
    
    public final int bYr()
    {
      AppMethodBeat.i(102734);
      if (bYq())
      {
        AppMethodBeat.o(102734);
        return 0;
      }
      this.oPB += 3;
      if (this.oPB <= this.fVS)
      {
        AppMethodBeat.o(102734);
        return 3;
      }
      this.oPB = this.fVS;
      int i = this.fVS;
      AppMethodBeat.o(102734);
      return i % 3;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(102737);
      List localList = NZ(paramInt);
      if (bu.ht(localList))
      {
        ae.e("MicroMsg.ReaderAppUI", "getItemViewType info is null");
        paramInt = this.xCD;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      if (((com.tencent.mm.model.br)localList.get(0)).aCH() == 1) {}
      for (paramInt = 1; (paramInt != 0) && (localList.size() >= 2); paramInt = 0)
      {
        paramInt = this.xCE;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      paramInt = this.xCD;
      AppMethodBeat.o(102737);
      return paramInt;
    }
    
    public final int getShowCount()
    {
      return this.oPB;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102738);
      if (getItemViewType(paramInt) == this.xCE)
      {
        if (paramView == null)
        {
          paramViewGroup = new b();
          paramView = View.inflate(this.context, 2131495186, null);
          paramViewGroup.okL = ((TextView)paramView.findViewById(2131306963));
          paramViewGroup.fTj = ((ImageView)paramView.findViewById(2131297008));
          paramViewGroup.jeW = ((TextView)paramView.findViewById(2131302860));
          paramViewGroup.xCN = new c();
          paramViewGroup.xCN.oio = paramView.findViewById(2131298819);
          paramViewGroup.xCN.dGW();
          paramViewGroup.xCO = new c();
          paramViewGroup.xCO.oio = paramView.findViewById(2131298820);
          paramViewGroup.xCO.dGW();
          paramView.setTag(paramViewGroup);
          localObject2 = NZ(paramInt);
          if ((localObject2 == null) || (((List)localObject2).size() < 2)) {
            break label486;
          }
          paramView.setVisibility(0);
          localObject1 = (com.tencent.mm.model.br)((List)localObject2).get(0);
          paramViewGroup.okL.setText(com.tencent.mm.pluginsdk.i.i.c(this.context, ((com.tencent.mm.model.br)localObject1).time, false));
          localObject3 = new c.a();
          ((c.a)localObject3).igy = 2131231342;
          ((c.a)localObject3).igj = true;
          ((c.a)localObject3).hhW = true;
          q.aJb().a(((com.tencent.mm.model.br)localObject1).aCE(), paramViewGroup.fTj, ((c.a)localObject3).aJu());
          paramViewGroup.jeW.setText(((com.tencent.mm.model.br)localObject1).aCD());
          paramViewGroup.jeW.getPaint().setFakeBoldText(true);
          if (ReaderAppUI.i(ReaderAppUI.this) != null)
          {
            paramViewGroup.okL.setTextColor(ReaderAppUI.i(ReaderAppUI.this).Fky);
            if (!ReaderAppUI.i(ReaderAppUI.this).Fkz) {
              break label461;
            }
            paramViewGroup.okL.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).FkA);
            label353:
            if (!ReaderAppUI.i(ReaderAppUI.this).FkB) {
              break label475;
            }
            paramViewGroup.okL.setBackgroundResource(2131231582);
            paramViewGroup.okL.setPadding(this.ofY, this.xCA, this.ofY, this.xCA);
          }
          label399:
          localObject2 = (com.tencent.mm.model.br)((List)localObject2).get(1);
          paramViewGroup.xCN.a((com.tencent.mm.model.br)localObject1, paramInt, ((com.tencent.mm.model.br)localObject1).getTitle());
          paramViewGroup.xCO.a((com.tencent.mm.model.br)localObject2, paramInt, ((com.tencent.mm.model.br)localObject1).getTitle());
        }
        for (;;)
        {
          AppMethodBeat.o(102738);
          return paramView;
          paramViewGroup = (b)paramView.getTag();
          break;
          label461:
          paramViewGroup.okL.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break label353;
          label475:
          paramViewGroup.okL.setBackgroundColor(0);
          break label399;
          label486:
          paramView.setVisibility(8);
        }
      }
      if (paramView == null)
      {
        paramViewGroup = new b();
        paramView = View.inflate(this.context, 2131495181, null);
        paramViewGroup.okL = ((TextView)paramView.findViewById(2131303764));
        paramViewGroup.xCK = ((ViewGroup)paramView.findViewById(2131303759));
        paramViewGroup.joL = paramView.findViewById(2131297444);
        paramViewGroup.oiA = paramView.findViewById(2131298818);
        paramViewGroup.oiq = ((ImageView)paramView.findViewById(2131303387));
        paramViewGroup.xCM = ((ImageView)paramView.findViewById(2131298831));
        paramViewGroup.gqi = ((TextView)paramView.findViewById(2131303765));
        paramViewGroup.xCJ = ((ImageView)paramView.findViewById(2131303763));
        paramViewGroup.vTQ = ((TextView)paramView.findViewById(2131303762));
        paramViewGroup.oio = paramView.findViewById(2131305992);
        paramViewGroup.xCL = ((MMNeat7extView)paramView.findViewById(2131305946));
        paramViewGroup.ols = new ArrayList();
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject1 = paramViewGroup.ols.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          paramViewGroup.xCK.removeView(((a)localObject2).oiV);
        }
        paramViewGroup = (b)paramView.getTag();
      }
      paramViewGroup.ols.clear();
      Object localObject1 = NZ(paramInt);
      label923:
      label965:
      int i;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int k = ((List)localObject1).size();
        localObject2 = (com.tencent.mm.model.br)((List)localObject1).get(0);
        paramViewGroup.okL.setText(com.tencent.mm.pluginsdk.i.i.c(this.context, ((com.tencent.mm.model.br)localObject2).time, false));
        if (ReaderAppUI.i(ReaderAppUI.this) != null)
        {
          paramViewGroup.okL.setTextColor(ReaderAppUI.i(ReaderAppUI.this).Fky);
          if (ReaderAppUI.i(ReaderAppUI.this).Fkz)
          {
            paramViewGroup.okL.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).FkA);
            if (!ReaderAppUI.i(ReaderAppUI.this).FkB) {
              break label1444;
            }
            paramViewGroup.okL.setBackgroundResource(2131231582);
            paramViewGroup.okL.setPadding(this.ofY, this.xCA, this.ofY, this.xCA);
          }
        }
        else
        {
          localObject3 = ReaderAppUI.this.a((com.tencent.mm.model.br)localObject2, ReaderAppUI.a(ReaderAppUI.this), 0, ((com.tencent.mm.model.br)localObject2).getTitle());
          paramViewGroup.oio.setOnClickListener((View.OnClickListener)localObject3);
          if (k != 1) {
            break label1455;
          }
          bool = true;
          paramViewGroup.gqi.setText(((com.tencent.mm.model.br)localObject2).getTitle());
          paramViewGroup.vTQ.setText(((com.tencent.mm.model.br)localObject2).getDigest());
          if (bu.isNullOrNil(((com.tencent.mm.model.br)localObject2).aCF())) {
            break label1461;
          }
          i = 1;
          label1003:
          paramViewGroup.xCL.aq(((com.tencent.mm.model.br)localObject2).getTitle());
          localObject3 = paramViewGroup.vTQ;
          if ((bool) && (!bu.isNullOrNil(((com.tencent.mm.model.br)localObject2).getDigest()))) {
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
          paramViewGroup.xCM.setVisibility(8);
          if (!bool) {
            break label1473;
          }
          paramViewGroup.oiq.setBackgroundResource(2131231708);
          paramViewGroup.joL.setVisibility(0);
          paramViewGroup.xCL.setVisibility(8);
          paramViewGroup.gqi.setVisibility(0);
          X(paramViewGroup.oiq, this.xCB);
          X(paramViewGroup.oiA, this.xCB);
          if (i == 0) {
            break label1575;
          }
          paramViewGroup.oiA.setVisibility(0);
          String str = ((com.tencent.mm.model.br)localObject2).aCF();
          localObject3 = paramViewGroup.xCJ;
          i = this.xCB;
          localObject4 = new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(102727);
              if (!bool)
              {
                paramViewGroup.xCL.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131101182));
                paramViewGroup.xCL.setBackgroundResource(2131231208);
              }
              paramViewGroup.xCM.setVisibility(0);
              AppMethodBeat.o(102727);
            }
            
            public final void onStart() {}
          };
          str = t.Gd(str);
          float f = ((ImageView)localObject3).getResources().getDimensionPixelSize(2131166028);
          j = com.tencent.mm.cb.a.iu(ReaderAppUI.this.getContext()) - (int)(ReaderAppUI.dGV() * 28.0F);
          com.tencent.mm.av.a.a locala = q.aJb();
          c.a locala1 = new c.a();
          locala1.igy = 2131231198;
          locala1.igk = true;
          locala1.igA = "2131231189";
          locala1 = locala1.dh(j, i);
          locala1.ifZ = new com.tencent.mm.pluginsdk.ui.applet.n();
          locala1.igH = new e();
          locala1.hgD = r.aMY(str);
          locala.a(str, (ImageView)localObject3, locala1.aJu(), null, new com.tencent.mm.pluginsdk.ui.applet.m(0, j, i, true, false, f, (m.a)localObject4));
          paramViewGroup.joL.setBackground(ao.e(ReaderAppUI.this.getResources().getDrawable(2131231686), this.context.getResources().getColor(2131099650)));
          paramViewGroup.joL.setPadding(this.ofW, this.ofX, this.ofW, this.ofW);
          paramViewGroup.oiq.setVisibility(0);
          if (k <= 1) {
            break label1708;
          }
          i = 1;
          while (i < k - 1)
          {
            a(paramViewGroup, (List)localObject1, 2131495189, i, ((com.tencent.mm.model.br)localObject2).getTitle());
            i += 1;
          }
          paramViewGroup.okL.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break;
          paramViewGroup.okL.setBackgroundColor(0);
          break label923;
          bool = false;
          break label965;
          i = 0;
          break label1003;
        }
        label1473:
        paramViewGroup.oiq.setBackgroundResource(2131231710);
        localObject3 = paramViewGroup.joL;
        if (i != 0) {}
        for (j = 8;; j = 0)
        {
          ((View)localObject3).setVisibility(j);
          paramViewGroup.gqi.setVisibility(8);
          paramViewGroup.xCL.setVisibility(0);
          paramViewGroup.xCL.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131100541));
          paramViewGroup.xCL.setBackgroundResource(2131233299);
          paramViewGroup.xCL.getPaint().setFakeBoldText(true);
          break;
        }
        label1575:
        paramViewGroup.oiA.setVisibility(8);
        paramViewGroup.gqi.setVisibility(0);
        localObject3 = paramViewGroup.vTQ;
        if (bu.isNullOrNil(((com.tencent.mm.model.br)localObject2).getDigest()))
        {
          i = 8;
          label1613:
          ((TextView)localObject3).setVisibility(i);
          if (!bool) {
            break label1676;
          }
          paramViewGroup.joL.setBackgroundResource(2131231695);
        }
        for (;;)
        {
          paramViewGroup.joL.setPadding(this.ofW, this.ofW, this.ofW, this.ofW);
          paramViewGroup.oiq.setVisibility(8);
          break;
          i = 0;
          break label1613;
          label1676:
          paramViewGroup.joL.setBackgroundResource(2131231694);
        }
        a(paramViewGroup, (List)localObject1, 2131495188, k - 1, ((com.tencent.mm.model.br)localObject2).getTitle());
        label1708:
        localObject3 = (com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class);
        if (localObject3 != null)
        {
          ((com.tencent.mm.plugin.brandservice.a.d)localObject3).a(((com.tencent.mm.model.br)localObject2).getUrl(), 164, "wx073f4a4daff0abe8", ((com.tencent.mm.model.br)localObject2).getTitle(), ((com.tencent.mm.model.br)localObject2).getDigest(), "message", 8);
          ((com.tencent.mm.plugin.brandservice.a.d)localObject3).cy(((com.tencent.mm.model.br)localObject2).getUrl(), 8);
        }
      }
      paramViewGroup.oio.setTag(Integer.valueOf(paramInt));
      paramViewGroup.oio.setTag(2131303776, Integer.valueOf(0));
      Object localObject2 = ReaderAppUI.h(ReaderAppUI.this);
      Object localObject3 = paramViewGroup.oio;
      Object localObject4 = ReaderAppUI.this;
      if (((List)localObject1).size() == 1)
      {
        bool = true;
        ((com.tencent.mm.ui.widget.b.a)localObject2).a((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(ReaderAppUI.this));
        paramViewGroup = paramViewGroup.ols.iterator();
        i = 1;
        label1863:
        if (!paramViewGroup.hasNext()) {
          break label1989;
        }
        localObject3 = (a)paramViewGroup.next();
        ((a)localObject3).oiV.setTag(Integer.valueOf(paramInt));
        ((a)localObject3).oiV.setTag(2131303776, Integer.valueOf(i));
        localObject2 = ReaderAppUI.h(ReaderAppUI.this);
        localObject3 = ((a)localObject3).oiV;
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
      return this.xCF;
    }
    
    public final void hg(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102746);
      ae.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth startPos = %s, endPos = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(102746);
        return;
      }
      com.tencent.mm.plugin.brandservice.a.d locald = (com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class);
      if (locald == null)
      {
        ae.v("MicroMsg.ReaderAppUI", "checkPreauth WebPrefetcher null");
        AppMethodBeat.o(102746);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      while (paramInt1 <= paramInt2)
      {
        List localList = NZ(paramInt1 - 1);
        if ((localList != null) && (localList.size() > 0))
        {
          localLinkedList.clear();
          d.a locala = a((com.tencent.mm.model.br)localList.get(0));
          if (locala != null)
          {
            localLinkedList.add(locala);
            locald.cy(locala.url, 8);
          }
          if (localLinkedList.size() > 0) {
            locald.m(localLinkedList, 8);
          }
          ae.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authTop = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
          localLinkedList.clear();
          int i = 1;
          while (i < localList.size())
          {
            locala = a((com.tencent.mm.model.br)localList.get(i));
            if (locala != null)
            {
              localLinkedList.add(locala);
              locald.cy(locala.url, 16);
            }
            i += 1;
          }
          if (localLinkedList.size() > 0) {
            locald.m(localLinkedList, 16);
          }
          ae.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authCommon = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
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
        hg(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition());
      }
      AppMethodBeat.o(102745);
    }
    
    final class a
    {
      TextView gqi;
      View iFF;
      View oiV;
      ImageView oic;
      View okQ;
      View okT;
      
      a() {}
    }
    
    final class b
    {
      ImageView fTj;
      TextView gqi;
      TextView jeW;
      View joL;
      View oiA;
      View oio;
      ImageView oiq;
      TextView okL;
      List<ReaderAppUI.a.a> ols;
      TextView vTQ;
      ImageView xCJ;
      ViewGroup xCK;
      MMNeat7extView xCL;
      ImageView xCM;
      ReaderAppUI.a.c xCN;
      ReaderAppUI.a.c xCO;
      
      b() {}
    }
    
    final class c
    {
      ImageView oZd;
      View oio;
      MMNeat7extView ovt;
      View xCP;
      View xCQ;
      ImageView xCR;
      ImageView xCS;
      TextView xCT;
      
      c() {}
      
      final void a(com.tencent.mm.model.br parambr, int paramInt, String paramString)
      {
        AppMethodBeat.i(102730);
        paramString = ReaderAppUI.this.a(parambr, ReaderAppUI.a(ReaderAppUI.this), 0, paramString);
        if (this.oio == null)
        {
          AppMethodBeat.o(102730);
          return;
        }
        this.oio.setOnClickListener(paramString);
        this.oio.setTag(Integer.valueOf(paramInt));
        this.oio.setTag(2131303776, Integer.valueOf(paramInt));
        ReaderAppUI.h(ReaderAppUI.this).a(this.oio, ReaderAppUI.a(ReaderAppUI.this, false), ReaderAppUI.g(ReaderAppUI.this));
        this.ovt.aq(parambr.getTitle());
        paramString = com.tencent.mm.ah.m.ol(parambr.aCI());
        if (!bu.isNullOrNil(paramString))
        {
          this.xCT.setText(paramString);
          this.xCP.setVisibility(0);
        }
        for (;;)
        {
          this.ovt.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131100541));
          this.xCQ.setBackgroundResource(2131233299);
          paramInt = (int)(this.xCT.getTextSize() * 1.7D);
          paramString = this.xCS.getLayoutParams();
          paramString.height = paramInt;
          paramString.width = paramInt;
          this.xCS.setLayoutParams(paramString);
          ReaderAppUI.a.ap(this.oZd, ReaderAppUI.a.a(ReaderAppUI.a.this));
          ReaderAppUI.a.a(ReaderAppUI.a.this, parambr.aCF(), this.oZd, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(102728);
              ReaderAppUI.a.c.this.ovt.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131101182));
              ReaderAppUI.a.c.this.xCQ.setBackgroundResource(2131234756);
              AppMethodBeat.o(102728);
            }
            
            public final void onStart() {}
          });
          AppMethodBeat.o(102730);
          return;
          this.xCP.setVisibility(8);
        }
      }
      
      final void dGW()
      {
        AppMethodBeat.i(102729);
        if (this.oio == null)
        {
          AppMethodBeat.o(102729);
          return;
        }
        this.oZd = ((ImageView)this.oio.findViewById(2131306962));
        this.xCR = ((ImageView)this.oio.findViewById(2131303387));
        this.ovt = ((MMNeat7extView)this.oio.findViewById(2131305946));
        this.xCT = ((TextView)this.oio.findViewById(2131306310));
        this.xCS = ((ImageView)this.oio.findViewById(2131303285));
        this.xCP = this.oio.findViewById(2131303292);
        this.xCQ = this.oio.findViewById(2131306959);
        AppMethodBeat.o(102729);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI
 * JD-Core Version:    0.7.0.1
 */