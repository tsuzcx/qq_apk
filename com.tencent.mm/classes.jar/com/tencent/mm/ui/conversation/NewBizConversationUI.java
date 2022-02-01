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
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.al.af;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.r.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NewBizConversationUI
  extends MMActivity
{
  private ListView IAT;
  private String IAV;
  private a IGa;
  private final int IGb;
  private final int IGc;
  private com.tencent.mm.storage.ap conversation;
  private int daq;
  private int dbL;
  private TextView emptyTipTv;
  private String hxt;
  private boolean isDeleteCancel;
  private long nAC;
  private com.tencent.mm.sdk.b.c nAQ;
  private n.d nAc;
  private int nwY;
  private int nwZ;
  private com.tencent.mm.ui.widget.b.a nym;
  private String talker;
  private p tipDialog;
  
  public NewBizConversationUI()
  {
    AppMethodBeat.i(38687);
    this.dbL = 1;
    this.talker = "";
    this.nAC = 0L;
    this.nwY = 0;
    this.nwZ = 0;
    this.IGb = 1;
    this.IGc = 2;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.nAc = new n.d()
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
          com.tencent.mm.model.az.ayM();
          paramAnonymousMenuItem = com.tencent.mm.model.c.awB().aNt(NewBizConversationUI.p(NewBizConversationUI.this));
          if (paramAnonymousMenuItem == null)
          {
            ac.e("MicroMsg.NewBizConversationUI", "changed biz stick status failed, contact is null, talker = " + NewBizConversationUI.p(NewBizConversationUI.this));
            AppMethodBeat.o(38671);
            return;
          }
          if (paramAnonymousMenuItem.aaN())
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
            w.E(NewBizConversationUI.p(NewBizConversationUI.this), true);
          }
          for (;;)
          {
            am localam = new am();
            localam.cZI.userName = paramAnonymousMenuItem.field_username;
            com.tencent.mm.sdk.b.a.GpY.l(localam);
            AppMethodBeat.o(38671);
            return;
            com.tencent.mm.plugin.report.service.h.wUl.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
            w.D(NewBizConversationUI.p(NewBizConversationUI.this), true);
          }
          com.tencent.mm.model.az.ayM();
          paramAnonymousMenuItem = com.tencent.mm.model.c.awB().aNt(NewBizConversationUI.p(NewBizConversationUI.this));
          com.tencent.mm.ui.tools.b.a(af.aCW().AE(NewBizConversationUI.p(NewBizConversationUI.this)), NewBizConversationUI.this, paramAnonymousMenuItem, 2);
          AppMethodBeat.o(38671);
          return;
          NewBizConversationUI.b(NewBizConversationUI.this, NewBizConversationUI.p(NewBizConversationUI.this));
        }
      }
    };
    this.nAQ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(38687);
  }
  
  private void fsE()
  {
    AppMethodBeat.i(38689);
    removeAllOptionMenu();
    Object localObject = com.tencent.mm.model.c.d.aAp().tJ("100045");
    final boolean bool2;
    final int i;
    if ((((com.tencent.mm.storage.c)localObject).isValid()) && ("1".equals(((com.tencent.mm.storage.c)localObject).eYV().get("isOpenSearch"))))
    {
      bool1 = true;
      ac.d("MicroMsg.NewBizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1) {
        addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(38661);
            if (z.Uk(0)) {
              ((com.tencent.mm.plugin.websearch.api.h)g.ab(com.tencent.mm.plugin.websearch.api.h.class)).a(com.tencent.mm.sdk.platformtools.ai.getContext(), new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(38660);
                  Intent localIntent = z.exm();
                  localIntent.putExtra("title", NewBizConversationUI.this.getString(2131759718));
                  localIntent.putExtra("searchbar_tips", NewBizConversationUI.this.getString(2131759718));
                  localIntent.putExtra("KRightBtn", true);
                  localIntent.putExtra("ftsneedkeyboard", true);
                  localIntent.putExtra("publishIdPrefix", "bs");
                  localIntent.putExtra("ftsType", 2);
                  localIntent.putExtra("ftsbizscene", 11);
                  Object localObject = z.f(11, true, 2);
                  String str = z.Ui(bs.aLy((String)((Map)localObject).get("scene")));
                  ((Map)localObject).put("sessionId", str);
                  localIntent.putExtra("sessionId", str);
                  localIntent.putExtra("rawUrl", z.aV((Map)localObject));
                  localIntent.putExtra("key_load_js_without_delay", true);
                  localIntent.addFlags(67108864);
                  str = null;
                  localObject = str;
                  if (Build.VERSION.SDK_INT >= 21)
                  {
                    localObject = str;
                    if (!aj.DT()) {
                      localObject = ActivityOptions.makeSceneTransitionAnimation(NewBizConversationUI.this, new Pair[0]).toBundle();
                    }
                  }
                  str = ab.aAx("bizAccountTopSearch");
                  if (!TextUtils.isEmpty(str)) {
                    localIntent.putExtra("key_search_input_hint", str);
                  }
                  com.tencent.mm.br.d.a(NewBizConversationUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
                  AppMethodBeat.o(38660);
                }
              });
            }
            for (;;)
            {
              AppMethodBeat.o(38661);
              return true;
              ac.e("MicroMsg.NewBizConversationUI", "fts h5 template not avail");
            }
          }
        });
      }
      localObject = aw.aKU("brandService");
      bool2 = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIQ();
      i = ((aw)localObject).decodeInt(fsF(), 0);
      if ((i != 1) || (!bool2) || (!((aw)localObject).decodeBool("NeedShowPayActionBarRedDot", true))) {
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
            this.vOh.encode("NeedShowPayActionBarRedDot", false);
            NewBizConversationUI.a(NewBizConversationUI.this);
          }
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NewBizConversationUI.this, 1, false);
          paramAnonymousMenuItem.ISu = new n.c()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(38673);
              paramAnonymous2l.jw(1, 2131756631);
              String str = NewBizConversationUI.12.this.vOh.decodeString("PaySubscribeEntryUrl", "");
              if ((NewBizConversationUI.12.this.IGg == 1) && (!bs.isNullOrNil(str)) && (NewBizConversationUI.12.this.IGh))
              {
                boolean bool = NewBizConversationUI.12.this.vOh.decodeBool("NeedShowPayRedDot", true);
                paramAnonymous2l.a(2, NewBizConversationUI.this.getString(2131756566), bool);
              }
              AppMethodBeat.o(38673);
            }
          };
          paramAnonymousMenuItem.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(38674);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                ac.w("MicroMsg.NewBizConversationUI", "default onMMMenuItemSelected err");
                AppMethodBeat.o(38674);
                return;
              case 1: 
                localObject = new Intent(NewBizConversationUI.this.getContext(), BizTimeLineNewMsgUI.class);
                ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 2);
                ((Intent)localObject).putExtra("biz_time_line_line_session_id", NewBizConversationUI.b(NewBizConversationUI.this));
                paramAnonymous2MenuItem = NewBizConversationUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(38674);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              Object localObject = aw.aKU("brandService");
              ((aw)localObject).encode("NeedShowPayRedDot", false);
              localObject = ((aw)localObject).decodeString("PaySubscribeEntryUrl", "");
              if (bs.isNullOrNil((String)localObject))
              {
                ac.e("MicroMsg.NewBizConversationUI", "pay entry url is null!");
                AppMethodBeat.o(38674);
                return;
              }
              paramAnonymous2MenuItem.putExtra("rawUrl", (String)localObject);
              paramAnonymous2MenuItem.putExtra("KRightBtn", true);
              com.tencent.mm.br.d.b(NewBizConversationUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(38674);
            }
          };
          paramAnonymousMenuItem.cED();
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
  
  private static String fsF()
  {
    AppMethodBeat.i(162388);
    if (g.agM()) {
      g.agP();
    }
    for (String str = com.tencent.mm.kernel.a.afE();; str = "")
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
    setMMTitle(this.IAV);
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
    this.IAT = ((ListView)findViewById(2131305951));
    this.emptyTipTv = ((TextView)findViewById(2131299468));
    this.emptyTipTv.setText(2131758419);
    this.IGa = new a(this, this.hxt, new r.a()
    {
      public final void aPg()
      {
        AppMethodBeat.i(38680);
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.g(NewBizConversationUI.this).getCount());
        AppMethodBeat.o(38680);
      }
    });
    this.IGa.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dy(View paramAnonymousView)
      {
        AppMethodBeat.i(38681);
        int i = NewBizConversationUI.h(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38681);
        return i;
      }
    });
    this.IGa.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38682);
        NewBizConversationUI.h(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38682);
      }
    });
    this.IAT.setAdapter(this.IGa);
    this.nym = new com.tencent.mm.ui.widget.b.a(this);
    this.IAT.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38662);
        NewBizConversationUI.a(NewBizConversationUI.this, (com.tencent.mm.storage.ap)NewBizConversationUI.g(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.i(NewBizConversationUI.this).field_username);
        paramAnonymousAdapterView = NewBizConversationUI.i(NewBizConversationUI.this);
        if (paramAnonymousAdapterView == null)
        {
          ac.e("MicroMsg.NewBizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(NewBizConversationUI.g(NewBizConversationUI.this).getCount()) });
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        NewBizConversationUI.g(NewBizConversationUI.this).a(paramAnonymousAdapterView, paramAnonymousInt);
        AppMethodBeat.o(38662);
      }
    });
    this.IAT.setOnTouchListener(new View.OnTouchListener()
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
    this.IAT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38664);
        NewBizConversationUI.a(NewBizConversationUI.this, (com.tencent.mm.storage.ap)NewBizConversationUI.g(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.i(NewBizConversationUI.this).field_username);
        NewBizConversationUI.m(NewBizConversationUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NewBizConversationUI.this, NewBizConversationUI.j(NewBizConversationUI.this), NewBizConversationUI.k(NewBizConversationUI.this), NewBizConversationUI.l(NewBizConversationUI.this));
        AppMethodBeat.o(38664);
        return true;
      }
    });
    this.IGa.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dy(View paramAnonymousView)
      {
        AppMethodBeat.i(38665);
        int i = NewBizConversationUI.h(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38665);
        return i;
      }
    });
    this.IGa.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38666);
        NewBizConversationUI.h(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38666);
      }
    });
    this.IGa.a(new MMSlideDelView.f()
    {
      public final void cN(Object paramAnonymousObject)
      {
        AppMethodBeat.i(38667);
        if (paramAnonymousObject == null)
        {
          ac.e("MicroMsg.NewBizConversationUI", "onItemDel object null");
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
    if (!com.tencent.mm.model.az.agM())
    {
      ac.e("MicroMsg.NewBizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(38688);
      return;
    }
    this.daq = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.dbL = getIntent().getIntExtra("biz_enter_source", 1);
    this.hxt = "officialaccounts";
    com.tencent.mm.plugin.report.service.h.wUl.f(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.daq), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.dbL), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.IAV = getIntent().getStringExtra("enterprise_biz_display_name");
    if (bs.isNullOrNil(this.IAV)) {
      this.IAV = getString(2131756578);
    }
    initView();
    fsE();
    if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIQ())
    {
      paramBundle = new b.a();
      paramBundle.hvt = new ny();
      paramBundle.hvu = new nz();
      paramBundle.uri = "/cgi-bin/mmbiz-bin/timeline/bizstrategy";
      paramBundle.funcId = 1806;
      paramBundle = paramBundle.aAz();
      ((ny)paramBundle.hvr.hvw).ReqType = 1;
      x.a(paramBundle, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(38676);
          ac.i("MicroMsg.NewBizConversationUI", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0))
          {
            AppMethodBeat.o(38676);
            return 0;
          }
          paramAnonymousString = (nz)paramAnonymousb.hvs.hvw;
          if ((paramAnonymousString.EdS != null) && (!bs.isNullOrNil(paramAnonymousString.EdS.Ftn)))
          {
            paramAnonymousb = aw.aKU("brandService");
            paramAnonymousInt1 = paramAnonymousb.decodeInt(NewBizConversationUI.fsG(), 0);
            paramAnonymousb.encode("PaySubscribeEntryUrl", paramAnonymousString.EdS.Ftn);
            paramAnonymousb.encode(NewBizConversationUI.fsG(), paramAnonymousString.EdS.Ftm);
            if (paramAnonymousInt1 != paramAnonymousString.EdS.Ftm) {
              NewBizConversationUI.a(NewBizConversationUI.this);
            }
          }
          AppMethodBeat.o(38676);
          return 0;
        }
      });
    }
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awG().a(this.IGa);
    this.nAC = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.GpY.c(this.nAQ);
    AppMethodBeat.o(38688);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(38695);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.storage.ai localai = com.tencent.mm.model.c.awB().aNt(this.talker);
    if (localai == null)
    {
      ac.e("MicroMsg.NewBizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38695);
      return;
    }
    String str = localai.aaS();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (bs.isNullOrNil(localai.field_nickname)) {
        paramView = getString(2131757293);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramView));
    if (com.tencent.mm.n.b.ln(localai.field_type))
    {
      if (!localai.aaN()) {
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
    com.tencent.mm.model.az.agU().az(new Runnable()
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
    com.tencent.mm.sdk.b.a.GpY.d(this.nAQ);
    if (com.tencent.mm.model.az.agM())
    {
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awG().b(this.IGa);
    }
    if (this.IGa != null) {
      this.IGa.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(38690);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38692);
    ac.i("MicroMsg.NewBizConversationUI", "on pause");
    if (this.IGa != null) {
      this.IGa.onPause();
    }
    super.onPause();
    AppMethodBeat.o(38692);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38691);
    ac.v("MicroMsg.NewBizConversationUI", "on resume");
    if (this.IGa != null) {
      this.IGa.onResume();
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
    extends e
  {
    private String dqK;
    HashMap<String, NewBizConversationUI.b> nAg;
    
    public a(Context paramContext, String paramString, r.a parama)
    {
      super(parama);
      AppMethodBeat.i(38683);
      this.dqK = paramString;
      this.nAg = new HashMap();
      AppMethodBeat.o(38683);
    }
    
    public final void Xb()
    {
      AppMethodBeat.i(38684);
      com.tencent.mm.model.az.ayM();
      setCursor(com.tencent.mm.model.c.awG().c(w.hmN, this.fzw, this.dqK));
      if (this.HmY != null) {
        this.HmY.aPg();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38684);
    }
    
    public final void a(com.tencent.mm.storage.ap paramap, int paramInt)
    {
      AppMethodBeat.i(38686);
      com.tencent.mm.model.az.ayM();
      a(paramap, com.tencent.mm.model.c.awG().h(paramap), paramInt, true);
      AppMethodBeat.o(38686);
    }
    
    protected final void a(com.tencent.mm.storage.ap paramap, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      AppMethodBeat.i(38685);
      if (paramap == null)
      {
        AppMethodBeat.o(38685);
        return;
      }
      NewBizConversationUI.b localb = (NewBizConversationUI.b)this.nAg.get(paramap.field_username);
      if (localb == null)
      {
        localb = new NewBizConversationUI.b((byte)0);
        this.nAg.put(paramap.field_username, localb);
      }
      for (;;)
      {
        if (localb.hTz > 0)
        {
          AppMethodBeat.o(38685);
          return;
        }
        localb.FBw = paramBoolean1;
        if ((localb.FBz) || (paramap.field_unReadCount > 0)) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          localb.FBz = paramBoolean1;
          localb.tlu = (paramInt + 1);
          if (paramBoolean2) {
            localb.hTz = localb.tlu;
          }
          localb.FBy = ((int)(System.currentTimeMillis() / 1000L));
          if (paramap.field_lastSeq != localb.seq) {
            break;
          }
          AppMethodBeat.o(38685);
          return;
        }
        localb.seq = paramap.field_lastSeq;
        paramap = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk(paramap.field_username);
        if ((paramap != null) && (paramap.eZj()))
        {
          paramap = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramap.field_msgId, paramap.field_content);
          if ((paramap != null) && (!bs.gY(paramap.hkS)) && (!bs.isNullOrNil(((v)paramap.hkS.get(0)).url))) {
            try
            {
              paramap = Uri.parse(((v)paramap.hkS.get(0)).url);
              localb.FBu = bs.getLong(paramap.getQueryParameter("mid"), 0L);
              localb.FBv = bs.getInt(paramap.getQueryParameter("idx"), 0);
              AppMethodBeat.o(38685);
              return;
            }
            catch (UnsupportedOperationException paramap)
            {
              ac.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramap.getMessage() });
              AppMethodBeat.o(38685);
              return;
            }
            catch (Exception paramap)
            {
              ac.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramap.getMessage() });
            }
          }
        }
        AppMethodBeat.o(38685);
        return;
      }
    }
  }
  
  static final class b
    extends cok
  {
    public int hTz = -1;
    public long seq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI
 * JD-Core Version:    0.7.0.1
 */