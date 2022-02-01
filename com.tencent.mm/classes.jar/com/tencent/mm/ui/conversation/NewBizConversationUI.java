package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.nr;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.q.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NewBizConversationUI
  extends MMActivity
{
  private ListView HaB;
  private String HaD;
  private a HfH;
  private final int HfI;
  private final int HfJ;
  private am conversation;
  private int dcS;
  private int dep;
  private TextView emptyTipTv;
  private String gWU;
  private boolean isDeleteCancel;
  private int mUE;
  private int mUF;
  private com.tencent.mm.ui.widget.b.a mVN;
  private n.d mXD;
  private long mYd;
  private com.tencent.mm.sdk.b.c mYr;
  private String talker;
  private p tipDialog;
  
  public NewBizConversationUI()
  {
    AppMethodBeat.i(38687);
    this.dep = 1;
    this.talker = "";
    this.mYd = 0L;
    this.mUE = 0;
    this.mUF = 0;
    this.HfI = 1;
    this.HfJ = 2;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.mXD = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(38671);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(38671);
          return;
          az.arV();
          paramAnonymousMenuItem = com.tencent.mm.model.c.apM().aHY(NewBizConversationUI.p(NewBizConversationUI.this));
          if (paramAnonymousMenuItem == null)
          {
            ad.e("MicroMsg.NewBizConversationUI", "changed biz stick status failed, contact is null, talker = " + NewBizConversationUI.p(NewBizConversationUI.this));
            AppMethodBeat.o(38671);
            return;
          }
          if (paramAnonymousMenuItem.ZS())
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
            w.D(NewBizConversationUI.p(NewBizConversationUI.this), true);
          }
          for (;;)
          {
            al localal = new al();
            localal.dcj.userName = paramAnonymousMenuItem.field_username;
            com.tencent.mm.sdk.b.a.ESL.l(localal);
            AppMethodBeat.o(38671);
            return;
            com.tencent.mm.plugin.report.service.h.vKh.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
            w.C(NewBizConversationUI.p(NewBizConversationUI.this), true);
          }
          az.arV();
          paramAnonymousMenuItem = com.tencent.mm.model.c.apM().aHY(NewBizConversationUI.p(NewBizConversationUI.this));
          com.tencent.mm.ui.tools.b.a(com.tencent.mm.am.af.awe().wy(NewBizConversationUI.p(NewBizConversationUI.this)), NewBizConversationUI.this, paramAnonymousMenuItem, 2);
          AppMethodBeat.o(38671);
          return;
          NewBizConversationUI.b(NewBizConversationUI.this, NewBizConversationUI.p(NewBizConversationUI.this));
        }
      }
    };
    this.mYr = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(38687);
  }
  
  private void fcJ()
  {
    AppMethodBeat.i(38689);
    removeAllOptionMenu();
    Object localObject = com.tencent.mm.model.c.d.aty().qu("100045");
    final boolean bool2;
    final int i;
    if ((((com.tencent.mm.storage.c)localObject).isValid()) && ("1".equals(((com.tencent.mm.storage.c)localObject).eJy().get("isOpenSearch"))))
    {
      bool1 = true;
      ad.d("MicroMsg.NewBizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1) {
        addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(38661);
            if (aa.Sa(0)) {
              ((i)g.ab(i.class)).a(aj.getContext(), new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(38660);
                  Intent localIntent = aa.ehS();
                  localIntent.putExtra("title", NewBizConversationUI.this.getString(2131759718));
                  localIntent.putExtra("searchbar_tips", NewBizConversationUI.this.getString(2131759718));
                  localIntent.putExtra("KRightBtn", true);
                  localIntent.putExtra("ftsneedkeyboard", true);
                  localIntent.putExtra("publishIdPrefix", "bs");
                  localIntent.putExtra("ftsType", 2);
                  localIntent.putExtra("ftsbizscene", 11);
                  Object localObject = aa.f(11, true, 2);
                  String str = aa.RY(bt.aGh((String)((Map)localObject).get("scene")));
                  ((Map)localObject).put("sessionId", str);
                  localIntent.putExtra("sessionId", str);
                  localIntent.putExtra("rawUrl", aa.aR((Map)localObject));
                  localIntent.putExtra("key_load_js_without_delay", true);
                  localIntent.addFlags(67108864);
                  str = null;
                  localObject = str;
                  if (Build.VERSION.SDK_INT >= 21)
                  {
                    localObject = str;
                    if (!ai.Eq()) {
                      localObject = ActivityOptions.makeSceneTransitionAnimation(NewBizConversationUI.this, new Pair[0]).toBundle();
                    }
                  }
                  str = ac.avg("bizAccountTopSearch");
                  if (!TextUtils.isEmpty(str)) {
                    localIntent.putExtra("key_search_input_hint", str);
                  }
                  com.tencent.mm.bs.d.a(NewBizConversationUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
                  AppMethodBeat.o(38660);
                }
              });
            }
            for (;;)
            {
              AppMethodBeat.o(38661);
              return true;
              ad.e("MicroMsg.NewBizConversationUI", "fts h5 template not avail");
            }
          }
        });
      }
      localObject = ax.aFD("brandService");
      bool2 = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBS();
      i = ((ax)localObject).decodeInt(fcK(), 0);
      if ((i != 1) || (!bool2) || (!((ax)localObject).decodeBool("NeedShowPayActionBarRedDot", true))) {
        break label188;
      }
    }
    label188:
    for (final boolean bool1 = true;; bool1 = false)
    {
      addIconOptionMenu(0, 2131756634, 2131689493, bool1, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38675);
          if (bool1)
          {
            this.uFq.encode("NeedShowPayActionBarRedDot", false);
            NewBizConversationUI.a(NewBizConversationUI.this);
          }
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NewBizConversationUI.this, 1, false);
          paramAnonymousMenuItem.HrX = new n.c()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(38673);
              paramAnonymous2l.jj(1, 2131756631);
              String str = NewBizConversationUI.12.this.uFq.decodeString("PaySubscribeEntryUrl", "");
              if ((NewBizConversationUI.12.this.HfN == 1) && (!bt.isNullOrNil(str)) && (NewBizConversationUI.12.this.HfO))
              {
                boolean bool = NewBizConversationUI.12.this.uFq.decodeBool("NeedShowPayRedDot", true);
                paramAnonymous2l.a(2, NewBizConversationUI.this.getString(2131756566), bool);
              }
              AppMethodBeat.o(38673);
            }
          };
          paramAnonymousMenuItem.HrY = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(38674);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                ad.w("MicroMsg.NewBizConversationUI", "default onMMMenuItemSelected err");
                AppMethodBeat.o(38674);
                return;
              case 1: 
                localObject = new Intent(NewBizConversationUI.this.getContext(), BizTimeLineNewMsgUI.class);
                ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 2);
                ((Intent)localObject).putExtra("biz_time_line_line_session_id", NewBizConversationUI.b(NewBizConversationUI.this));
                paramAnonymous2MenuItem = NewBizConversationUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(38674);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              Object localObject = ax.aFD("brandService");
              ((ax)localObject).encode("NeedShowPayRedDot", false);
              localObject = ((ax)localObject).decodeString("PaySubscribeEntryUrl", "");
              if (bt.isNullOrNil((String)localObject))
              {
                ad.e("MicroMsg.NewBizConversationUI", "pay entry url is null!");
                AppMethodBeat.o(38674);
                return;
              }
              paramAnonymous2MenuItem.putExtra("rawUrl", (String)localObject);
              paramAnonymous2MenuItem.putExtra("KRightBtn", true);
              com.tencent.mm.bs.d.b(NewBizConversationUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(38674);
            }
          };
          paramAnonymousMenuItem.csG();
          AppMethodBeat.o(38675);
          return true;
        }
      });
      AppMethodBeat.o(38689);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static String fcK()
  {
    AppMethodBeat.i(162388);
    if (g.afw()) {
      g.afz();
    }
    for (String str = com.tencent.mm.kernel.a.aeo();; str = "")
    {
      str = str + ":PaySubscribeEntryOpen";
      AppMethodBeat.o(162388);
      return str;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495762;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38693);
    setMMTitle(this.HaD);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38677);
        NewBizConversationUI.this.finish();
        AppMethodBeat.o(38677);
        return true;
      }
    });
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38678);
        if ((NewBizConversationUI.this.activityHasDestroyed()) || (NewBizConversationUI.this.isFinishing()))
        {
          AppMethodBeat.o(38678);
          return;
        }
        NewBizConversationUI.c(NewBizConversationUI.this);
        AppMethodBeat.o(38678);
      }
    });
    this.HaB = ((ListView)findViewById(2131305951));
    this.emptyTipTv = ((TextView)findViewById(2131299468));
    this.emptyTipTv.setText(2131758419);
    this.HfH = new a(this, this.gWU, new q.a()
    {
      public final void aIp()
      {
        AppMethodBeat.i(38680);
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.g(NewBizConversationUI.this).getCount());
        AppMethodBeat.o(38680);
      }
    });
    this.HfH.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dw(View paramAnonymousView)
      {
        AppMethodBeat.i(38681);
        int i = NewBizConversationUI.h(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38681);
        return i;
      }
    });
    this.HfH.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38682);
        NewBizConversationUI.h(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38682);
      }
    });
    this.HaB.setAdapter(this.HfH);
    this.mVN = new com.tencent.mm.ui.widget.b.a(this);
    this.HaB.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38662);
        NewBizConversationUI.a(NewBizConversationUI.this, (am)NewBizConversationUI.g(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.i(NewBizConversationUI.this).field_username);
        paramAnonymousAdapterView = NewBizConversationUI.i(NewBizConversationUI.this);
        if (paramAnonymousAdapterView == null)
        {
          ad.e("MicroMsg.NewBizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(NewBizConversationUI.g(NewBizConversationUI.this).getCount()) });
          NewBizConversationUI.g(NewBizConversationUI.this).notifyDataSetChanged();
          AppMethodBeat.o(38662);
          return;
        }
        Object localObject = new Intent(NewBizConversationUI.this, ChattingUI.class);
        ((Intent)localObject).putExtra("Chat_User", paramAnonymousAdapterView.field_username);
        ((Intent)localObject).putExtra("finish_direct", true);
        ((Intent)localObject).putExtra("biz_click_item_unread_count", NewBizConversationUI.i(NewBizConversationUI.this).field_unReadCount);
        ((Intent)localObject).putExtra("biz_click_item_position", paramAnonymousInt + 1);
        ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 92);
        ((Intent)localObject).putExtra("specific_chat_from_scene", 6);
        paramAnonymousView = NewBizConversationUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        NewBizConversationUI.g(NewBizConversationUI.this).a(paramAnonymousAdapterView, paramAnonymousInt);
        AppMethodBeat.o(38662);
      }
    });
    this.HaB.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(38663);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(38663);
          return false;
          NewBizConversationUI.b(NewBizConversationUI.this, (int)paramAnonymousMotionEvent.getRawX());
          NewBizConversationUI.c(NewBizConversationUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    this.HaB.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38664);
        NewBizConversationUI.a(NewBizConversationUI.this, (am)NewBizConversationUI.g(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.i(NewBizConversationUI.this).field_username);
        NewBizConversationUI.m(NewBizConversationUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NewBizConversationUI.this, NewBizConversationUI.j(NewBizConversationUI.this), NewBizConversationUI.k(NewBizConversationUI.this), NewBizConversationUI.l(NewBizConversationUI.this));
        AppMethodBeat.o(38664);
        return true;
      }
    });
    this.HfH.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dw(View paramAnonymousView)
      {
        AppMethodBeat.i(38665);
        int i = NewBizConversationUI.h(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38665);
        return i;
      }
    });
    this.HfH.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38666);
        NewBizConversationUI.h(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38666);
      }
    });
    this.HfH.a(new MMSlideDelView.f()
    {
      public final void cO(Object paramAnonymousObject)
      {
        AppMethodBeat.i(38667);
        if (paramAnonymousObject == null)
        {
          ad.e("MicroMsg.NewBizConversationUI", "onItemDel object null");
          AppMethodBeat.o(38667);
          return;
        }
        paramAnonymousObject = paramAnonymousObject.toString();
        NewBizConversationUI.b(NewBizConversationUI.this, paramAnonymousObject);
        AppMethodBeat.o(38667);
      }
    });
    AppMethodBeat.o(38693);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38694);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38694);
      return;
    }
    AppMethodBeat.o(38694);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38688);
    super.onCreate(paramBundle);
    if (!az.afw())
    {
      ad.e("MicroMsg.NewBizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(38688);
      return;
    }
    this.dcS = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.dep = getIntent().getIntExtra("biz_enter_source", 1);
    this.gWU = "officialaccounts";
    com.tencent.mm.plugin.report.service.h.vKh.f(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.dcS), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.dep), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.HaD = getIntent().getStringExtra("enterprise_biz_display_name");
    if (bt.isNullOrNil(this.HaD)) {
      this.HaD = getString(2131756578);
    }
    initView();
    fcJ();
    if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBS())
    {
      paramBundle = new b.a();
      paramBundle.gUU = new nr();
      paramBundle.gUV = new ns();
      paramBundle.uri = "/cgi-bin/mmbiz-bin/timeline/bizstrategy";
      paramBundle.funcId = 1806;
      paramBundle = paramBundle.atI();
      ((nr)paramBundle.gUS.gUX).ReqType = 1;
      x.a(paramBundle, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(38676);
          ad.i("MicroMsg.NewBizConversationUI", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0))
          {
            AppMethodBeat.o(38676);
            return 0;
          }
          paramAnonymousString = (ns)paramAnonymousb.gUT.gUX;
          if ((paramAnonymousString.CLp != null) && (!bt.isNullOrNil(paramAnonymousString.CLp.DWv)))
          {
            paramAnonymousb = ax.aFD("brandService");
            paramAnonymousInt1 = paramAnonymousb.decodeInt(NewBizConversationUI.fcL(), 0);
            paramAnonymousb.encode("PaySubscribeEntryUrl", paramAnonymousString.CLp.DWv);
            paramAnonymousb.encode(NewBizConversationUI.fcL(), paramAnonymousString.CLp.DWu);
            if (paramAnonymousInt1 != paramAnonymousString.CLp.DWu) {
              NewBizConversationUI.a(NewBizConversationUI.this);
            }
          }
          AppMethodBeat.o(38676);
          return 0;
        }
      });
    }
    az.arV();
    com.tencent.mm.model.c.apR().a(this.HfH);
    this.mYd = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.ESL.c(this.mYr);
    AppMethodBeat.o(38688);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(38695);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    az.arV();
    com.tencent.mm.storage.af localaf = com.tencent.mm.model.c.apM().aHY(this.talker);
    if (localaf == null)
    {
      ad.e("MicroMsg.NewBizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38695);
      return;
    }
    String str = localaf.ZX();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (bt.isNullOrNil(localaf.field_nickname)) {
        paramView = getString(2131757293);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramView));
    if (com.tencent.mm.n.b.ls(localaf.field_type))
    {
      if (!localaf.ZS()) {
        break label205;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131756577);
    }
    for (;;)
    {
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131761049);
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131761057);
      AppMethodBeat.o(38695);
      return;
      label205:
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131756576);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38690);
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38679);
        NewBizConversationUI.d(NewBizConversationUI.this);
        NewBizConversationUI.e(NewBizConversationUI.this);
        NewBizConversationUI.f(NewBizConversationUI.this);
        AppMethodBeat.o(38679);
      }
    });
    com.tencent.mm.sdk.b.a.ESL.d(this.mYr);
    if (az.afw())
    {
      az.arV();
      com.tencent.mm.model.c.apR().b(this.HfH);
    }
    if (this.HfH != null) {
      this.HfH.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(38690);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38692);
    ad.i("MicroMsg.NewBizConversationUI", "on pause");
    if (this.HfH != null) {
      this.HfH.onPause();
    }
    super.onPause();
    AppMethodBeat.o(38692);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38691);
    ad.v("MicroMsg.NewBizConversationUI", "on resume");
    if (this.HfH != null) {
      this.HfH.onResume();
    }
    super.onResume();
    AppMethodBeat.o(38691);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends f
  {
    private String dta;
    HashMap<String, NewBizConversationUI.b> mXH;
    
    public a(Context paramContext, String paramString, q.a parama)
    {
      super(parama);
      AppMethodBeat.i(38683);
      this.dta = paramString;
      this.mXH = new HashMap();
      AppMethodBeat.o(38683);
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(38684);
      az.arV();
      setCursor(com.tencent.mm.model.c.apR().c(w.gMn, this.fvP, this.dta));
      if (this.FNn != null) {
        this.FNn.aIp();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38684);
    }
    
    public final void a(am paramam, int paramInt)
    {
      AppMethodBeat.i(38686);
      az.arV();
      a(paramam, com.tencent.mm.model.c.apR().h(paramam), paramInt, true);
      AppMethodBeat.o(38686);
    }
    
    protected final void a(am paramam, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      AppMethodBeat.i(38685);
      if (paramam == null)
      {
        AppMethodBeat.o(38685);
        return;
      }
      NewBizConversationUI.b localb = (NewBizConversationUI.b)this.mXH.get(paramam.field_username);
      if (localb == null)
      {
        localb = new NewBizConversationUI.b((byte)0);
        this.mXH.put(paramam.field_username, localb);
      }
      for (;;)
      {
        if (localb.hsX > 0)
        {
          AppMethodBeat.o(38685);
          return;
        }
        localb.Eew = paramBoolean1;
        if ((localb.Eez) || (paramam.field_unReadCount > 0)) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          localb.Eez = paramBoolean1;
          localb.sdA = (paramInt + 1);
          if (paramBoolean2) {
            localb.hsX = localb.sdA;
          }
          localb.Eey = ((int)(System.currentTimeMillis() / 1000L));
          if (paramam.field_lastSeq != localb.seq) {
            break;
          }
          AppMethodBeat.o(38685);
          return;
        }
        localb.seq = paramam.field_lastSeq;
        paramam = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agq(paramam.field_username);
        if ((paramam != null) && (paramam.eJL()))
        {
          paramam = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramam.field_msgId, paramam.field_content);
          if ((paramam != null) && (!bt.gL(paramam.gKs)) && (!bt.isNullOrNil(((v)paramam.gKs.get(0)).url))) {
            try
            {
              paramam = Uri.parse(((v)paramam.gKs.get(0)).url);
              localb.Eeu = bt.getLong(paramam.getQueryParameter("mid"), 0L);
              localb.Eev = bt.getInt(paramam.getQueryParameter("idx"), 0);
              AppMethodBeat.o(38685);
              return;
            }
            catch (UnsupportedOperationException paramam)
            {
              ad.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramam.getMessage() });
              AppMethodBeat.o(38685);
              return;
            }
            catch (Exception paramam)
            {
              ad.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramam.getMessage() });
            }
          }
        }
        AppMethodBeat.o(38685);
        return;
      }
    }
  }
  
  static final class b
    extends cjd
  {
    public int hsX = -1;
    public long seq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI
 * JD-Core Version:    0.7.0.1
 */