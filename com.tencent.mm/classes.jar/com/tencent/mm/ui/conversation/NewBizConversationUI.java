package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import com.tencent.mm.al.x;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.r.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NewBizConversationUI
  extends MMActivity
{
  private ListView KrZ;
  private String Ksb;
  private a Kxg;
  private final int Kxh;
  private final int Kxi;
  private at conversation;
  private int dlK;
  private int dnh;
  private TextView emptyTipTv;
  private String hPO;
  private boolean isDeleteCancel;
  private int nYw;
  private int nYx;
  private com.tencent.mm.ui.widget.b.a nZK;
  private long obJ;
  private com.tencent.mm.sdk.b.c obZ;
  private n.e obh;
  private String talker;
  private p tipDialog;
  
  public NewBizConversationUI()
  {
    AppMethodBeat.i(38687);
    this.dnh = 1;
    this.talker = "";
    this.obJ = 0L;
    this.nYw = 0;
    this.nYx = 0;
    this.Kxh = 1;
    this.Kxi = 2;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.obh = new n.e()
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
          com.tencent.mm.model.ba.aBQ();
          paramAnonymousMenuItem = com.tencent.mm.model.c.azp().Bf(NewBizConversationUI.p(NewBizConversationUI.this));
          if (paramAnonymousMenuItem == null)
          {
            ad.e("MicroMsg.NewBizConversationUI", "changed biz stick status failed, contact is null, talker = " + NewBizConversationUI.p(NewBizConversationUI.this));
            AppMethodBeat.o(38671);
            return;
          }
          if (paramAnonymousMenuItem.adq())
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
            w.E(NewBizConversationUI.p(NewBizConversationUI.this), true);
          }
          for (;;)
          {
            com.tencent.mm.g.a.am localam = new com.tencent.mm.g.a.am();
            localam.dla.userName = paramAnonymousMenuItem.field_username;
            com.tencent.mm.sdk.b.a.IbL.l(localam);
            AppMethodBeat.o(38671);
            return;
            com.tencent.mm.plugin.report.service.g.yhR.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
            w.D(NewBizConversationUI.p(NewBizConversationUI.this), true);
          }
          com.tencent.mm.model.ba.aBQ();
          paramAnonymousMenuItem = com.tencent.mm.model.c.azp().Bf(NewBizConversationUI.p(NewBizConversationUI.this));
          com.tencent.mm.ui.tools.b.a(ag.aFZ().DD(NewBizConversationUI.p(NewBizConversationUI.this)), NewBizConversationUI.this, paramAnonymousMenuItem, 2);
          AppMethodBeat.o(38671);
          return;
          NewBizConversationUI.b(NewBizConversationUI.this, NewBizConversationUI.p(NewBizConversationUI.this));
        }
      }
    };
    this.obZ = new NewBizConversationUI.11(this);
    AppMethodBeat.o(38687);
  }
  
  private void fJs()
  {
    AppMethodBeat.i(38689);
    removeAllOptionMenu();
    Object localObject = com.tencent.mm.model.c.d.aDs().wz("100045");
    final boolean bool2;
    final int i;
    if ((((com.tencent.mm.storage.c)localObject).isValid()) && ("1".equals(((com.tencent.mm.storage.c)localObject).foF().get("isOpenSearch"))))
    {
      bool1 = true;
      ad.d("MicroMsg.NewBizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1) {
        addIconOptionMenu(1, 2131764452, 2131689494, new NewBizConversationUI.1(this));
      }
      localObject = ax.aQA("brandService");
      bool2 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNh();
      i = ((ax)localObject).decodeInt(fJt(), 0);
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
            this.wVq.encode("NeedShowPayActionBarRedDot", false);
            NewBizConversationUI.a(NewBizConversationUI.this);
          }
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NewBizConversationUI.this, 1, false);
          paramAnonymousMenuItem.KJy = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(38673);
              paramAnonymous2l.jI(1, 2131756631);
              String str = NewBizConversationUI.12.this.wVq.decodeString("PaySubscribeEntryUrl", "");
              if ((NewBizConversationUI.12.this.Kxm == 1) && (!bt.isNullOrNil(str)) && (NewBizConversationUI.12.this.Kxn))
              {
                boolean bool = NewBizConversationUI.12.this.wVq.decodeBool("NeedShowPayRedDot", true);
                paramAnonymous2l.a(2, NewBizConversationUI.this.getString(2131756566), bool);
              }
              AppMethodBeat.o(38673);
            }
          };
          paramAnonymousMenuItem.KJz = new n.e()
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
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(38674);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              Object localObject = ax.aQA("brandService");
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
          paramAnonymousMenuItem.cMW();
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
  
  private static String fJt()
  {
    AppMethodBeat.i(162388);
    if (com.tencent.mm.kernel.g.ajx()) {
      com.tencent.mm.kernel.g.ajA();
    }
    for (String str = com.tencent.mm.kernel.a.aiq();; str = "")
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
    setMMTitle(this.Ksb);
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
    this.KrZ = ((ListView)findViewById(2131305951));
    this.emptyTipTv = ((TextView)findViewById(2131299468));
    this.emptyTipTv.setText(2131758419);
    this.Kxg = new a(this, this.hPO, new r.a()
    {
      public final void aSs()
      {
        AppMethodBeat.i(38680);
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.g(NewBizConversationUI.this).getCount());
        AppMethodBeat.o(38680);
      }
    });
    this.Kxg.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(38681);
        int i = NewBizConversationUI.h(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38681);
        return i;
      }
    });
    this.Kxg.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38682);
        NewBizConversationUI.h(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38682);
      }
    });
    this.KrZ.setAdapter(this.Kxg);
    this.nZK = new com.tencent.mm.ui.widget.b.a(this);
    this.KrZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38662);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        NewBizConversationUI.a(NewBizConversationUI.this, (at)NewBizConversationUI.g(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.i(NewBizConversationUI.this).field_username);
        paramAnonymousAdapterView = NewBizConversationUI.i(NewBizConversationUI.this);
        if (paramAnonymousAdapterView == null)
        {
          ad.e("MicroMsg.NewBizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(NewBizConversationUI.g(NewBizConversationUI.this).getCount()) });
          NewBizConversationUI.g(NewBizConversationUI.this).notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38662);
          return;
        }
        localObject = new Intent(NewBizConversationUI.this, ChattingUI.class);
        ((Intent)localObject).putExtra("Chat_User", paramAnonymousAdapterView.field_username);
        ((Intent)localObject).putExtra("finish_direct", true);
        ((Intent)localObject).putExtra("biz_click_item_unread_count", NewBizConversationUI.i(NewBizConversationUI.this).field_unReadCount);
        ((Intent)localObject).putExtra("biz_click_item_position", paramAnonymousInt + 1);
        ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 92);
        ((Intent)localObject).putExtra("specific_chat_from_scene", 6);
        paramAnonymousView = NewBizConversationUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        NewBizConversationUI.g(NewBizConversationUI.this).a(paramAnonymousAdapterView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(38662);
      }
    });
    this.KrZ.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(38663);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/NewBizConversationUI$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/NewBizConversationUI$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(38663);
          return false;
          NewBizConversationUI.b(NewBizConversationUI.this, (int)paramAnonymousMotionEvent.getRawX());
          NewBizConversationUI.c(NewBizConversationUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    this.KrZ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38664);
        NewBizConversationUI.a(NewBizConversationUI.this, (at)NewBizConversationUI.g(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.i(NewBizConversationUI.this).field_username);
        NewBizConversationUI.m(NewBizConversationUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NewBizConversationUI.this, NewBizConversationUI.j(NewBizConversationUI.this), NewBizConversationUI.k(NewBizConversationUI.this), NewBizConversationUI.l(NewBizConversationUI.this));
        AppMethodBeat.o(38664);
        return true;
      }
    });
    this.Kxg.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(38665);
        int i = NewBizConversationUI.h(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38665);
        return i;
      }
    });
    this.Kxg.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38666);
        NewBizConversationUI.h(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38666);
      }
    });
    this.Kxg.a(new MMSlideDelView.f()
    {
      public final void cP(Object paramAnonymousObject)
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
    if (!com.tencent.mm.model.ba.ajx())
    {
      ad.e("MicroMsg.NewBizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(38688);
      return;
    }
    this.dlK = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.dnh = getIntent().getIntExtra("biz_enter_source", 1);
    this.hPO = "officialaccounts";
    com.tencent.mm.plugin.report.service.g.yhR.f(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.dlK), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.dnh), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.Ksb = getIntent().getStringExtra("enterprise_biz_display_name");
    if (bt.isNullOrNil(this.Ksb)) {
      this.Ksb = getString(2131756578);
    }
    initView();
    fJs();
    if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNh())
    {
      paramBundle = new b.a();
      paramBundle.hNM = new pd();
      paramBundle.hNN = new pe();
      paramBundle.uri = "/cgi-bin/mmbiz-bin/timeline/bizstrategy";
      paramBundle.funcId = 1806;
      paramBundle = paramBundle.aDC();
      ((pd)paramBundle.hNK.hNQ).ReqType = 1;
      x.a(paramBundle, new NewBizConversationUI.13(this));
    }
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azv().a(this.Kxg);
    this.obJ = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.IbL.c(this.obZ);
    AppMethodBeat.o(38688);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(38695);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.storage.am localam = com.tencent.mm.model.c.azp().Bf(this.talker);
    if (localam == null)
    {
      ad.e("MicroMsg.NewBizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38695);
      return;
    }
    String str = localam.adv();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (bt.isNullOrNil(localam.field_nickname)) {
        paramView = getString(2131757293);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(k.c(this, paramView));
    if (com.tencent.mm.o.b.lM(localam.field_type))
    {
      if (!localam.adq()) {
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
    com.tencent.mm.model.ba.ajF().ay(new Runnable()
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
    com.tencent.mm.sdk.b.a.IbL.d(this.obZ);
    if (com.tencent.mm.model.ba.ajx())
    {
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().b(this.Kxg);
    }
    if (this.Kxg != null) {
      this.Kxg.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(38690);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38692);
    ad.i("MicroMsg.NewBizConversationUI", "on pause");
    if (this.Kxg != null) {
      this.Kxg.onPause();
    }
    super.onPause();
    AppMethodBeat.o(38692);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38691);
    ad.v("MicroMsg.NewBizConversationUI", "on resume");
    if (this.Kxg != null) {
      this.Kxg.onResume();
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
    private String dCB;
    HashMap<String, NewBizConversationUI.b> obm;
    
    public a(Context paramContext, String paramString, r.a parama)
    {
      super(parama);
      AppMethodBeat.i(38683);
      this.dCB = paramString;
      this.obm = new HashMap();
      AppMethodBeat.o(38683);
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(38684);
      com.tencent.mm.model.ba.aBQ();
      setCursor(com.tencent.mm.model.c.azv().c(w.hFd, this.fSL, this.dCB));
      if (this.JaF != null) {
        this.JaF.aSs();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38684);
    }
    
    public final void a(at paramat, int paramInt)
    {
      AppMethodBeat.i(38686);
      com.tencent.mm.model.ba.aBQ();
      a(paramat, com.tencent.mm.model.c.azv().h(paramat), paramInt, true);
      AppMethodBeat.o(38686);
    }
    
    protected final void a(at paramat, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      AppMethodBeat.i(38685);
      if (paramat == null)
      {
        AppMethodBeat.o(38685);
        return;
      }
      NewBizConversationUI.b localb = (NewBizConversationUI.b)this.obm.get(paramat.field_username);
      if (localb == null)
      {
        localb = new NewBizConversationUI.b((byte)0);
        this.obm.put(paramat.field_username, localb);
      }
      for (;;)
      {
        if (localb.imT > 0)
        {
          AppMethodBeat.o(38685);
          return;
        }
        localb.HlJ = paramBoolean1;
        if ((localb.HlM) || (paramat.field_unReadCount > 0)) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          localb.HlM = paramBoolean1;
          localb.ujD = (paramInt + 1);
          if (paramBoolean2) {
            localb.imT = localb.ujD;
          }
          localb.HlL = ((int)(System.currentTimeMillis() / 1000L));
          if (paramat.field_lastSeq != localb.seq) {
            break;
          }
          AppMethodBeat.o(38685);
          return;
        }
        localb.seq = paramat.field_lastSeq;
        paramat = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apX(paramat.field_username);
        if ((paramat != null) && (paramat.fpd()))
        {
          paramat = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramat.field_msgId, paramat.field_content);
          if ((paramat != null) && (!bt.hj(paramat.hDb)) && (!bt.isNullOrNil(((v)paramat.hDb.get(0)).url))) {
            try
            {
              paramat = Uri.parse(((v)paramat.hDb.get(0)).url);
              localb.HlH = bt.getLong(paramat.getQueryParameter("mid"), 0L);
              localb.HlI = bt.getInt(paramat.getQueryParameter("idx"), 0);
              AppMethodBeat.o(38685);
              return;
            }
            catch (UnsupportedOperationException paramat)
            {
              ad.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramat.getMessage() });
              AppMethodBeat.o(38685);
              return;
            }
            catch (Exception paramat)
            {
              ad.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramat.getMessage() });
            }
          }
        }
        AppMethodBeat.o(38685);
        return;
      }
    }
  }
  
  static final class b
    extends ctn
  {
    public int imT = -1;
    public long seq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI
 * JD-Core Version:    0.7.0.1
 */