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
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.s.a;
import java.util.HashMap;
import java.util.LinkedList;

public class NewBizConversationUI
  extends MMActivity
{
  private ListView Qbt;
  private String Qbv;
  private a QgH;
  private final int QgI;
  private final int QgJ;
  private az conversation;
  private int dEb;
  private TextView emptyTipTv;
  private String iNV;
  private boolean isDeleteCancel;
  private int ppd;
  private int ppe;
  private com.tencent.mm.ui.widget.b.a pqr;
  private o.g pso;
  private long pss;
  private IListener ptp;
  private int source;
  private String talker;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public NewBizConversationUI()
  {
    AppMethodBeat.i(38687);
    this.source = 1;
    this.talker = "";
    this.pss = 0L;
    this.ppd = 0;
    this.ppe = 0;
    this.QgI = 1;
    this.QgJ = 2;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.pso = new o.g()
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
          bg.aVF();
          paramAnonymousMenuItem = com.tencent.mm.model.c.aSN().Kn(NewBizConversationUI.p(NewBizConversationUI.this));
          if (paramAnonymousMenuItem == null)
          {
            Log.e("MicroMsg.NewBizConversationUI", "changed biz stick status failed, contact is null, talker = " + NewBizConversationUI.p(NewBizConversationUI.this));
            AppMethodBeat.o(38671);
            return;
          }
          if (paramAnonymousMenuItem.arE())
          {
            h.CyF.a(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
            ab.F(NewBizConversationUI.p(NewBizConversationUI.this), true);
          }
          for (;;)
          {
            ao localao = new ao();
            localao.dDs.userName = paramAnonymousMenuItem.field_username;
            EventCenter.instance.publish(localao);
            AppMethodBeat.o(38671);
            return;
            h.CyF.a(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
            ab.E(NewBizConversationUI.p(NewBizConversationUI.this), true);
          }
          bg.aVF();
          paramAnonymousMenuItem = com.tencent.mm.model.c.aSN().Kn(NewBizConversationUI.p(NewBizConversationUI.this));
          com.tencent.mm.ui.tools.b.a(ag.bah().MT(NewBizConversationUI.p(NewBizConversationUI.this)), NewBizConversationUI.this, paramAnonymousMenuItem, 2);
          AppMethodBeat.o(38671);
          return;
          NewBizConversationUI.b(NewBizConversationUI.this, NewBizConversationUI.p(NewBizConversationUI.this));
          AppMethodBeat.o(38671);
          return;
          com.tencent.mm.ui.g.c(NewBizConversationUI.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(234252);
              bg.aVF();
              com.tencent.mm.model.c.aST().bjW(NewBizConversationUI.p(NewBizConversationUI.this));
              AppMethodBeat.o(234252);
            }
          });
        }
      }
    };
    this.ptp = new NewBizConversationUI.11(this);
    AppMethodBeat.o(38687);
  }
  
  private void gWd()
  {
    final boolean bool1 = true;
    AppMethodBeat.i(38689);
    removeAllOptionMenu();
    Object localObject = com.tencent.mm.plugin.bizui.a.a.pfC;
    final boolean bool2 = com.tencent.mm.plugin.bizui.a.a.ckz();
    boolean bool3 = ((com.tencent.mm.api.q)com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class)).Vu();
    Log.d("MicroMsg.NewBizConversationUI", "open search entrance:%b, isBizTeenModeAllowAll: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool2) && (bool3)) {
      addIconOptionMenu(1, 2131766796, 2131689496, new NewBizConversationUI.1(this));
    }
    localObject = MultiProcessMMKV.getSingleMMKV("brandService");
    bool2 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cle();
    final int i = ((MultiProcessMMKV)localObject).decodeInt(gWe(), 0);
    if ((i == 1) && (bool2) && (((MultiProcessMMKV)localObject).decodeBool("NeedShowPayActionBarRedDot", true))) {}
    for (;;)
    {
      addIconOptionMenu(0, 2131756782, 2131689495, bool1, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38675);
          if (bool1)
          {
            this.Bji.encode("NeedShowPayActionBarRedDot", false);
            NewBizConversationUI.a(NewBizConversationUI.this);
          }
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NewBizConversationUI.this, 1, false);
          paramAnonymousMenuItem.HLX = new o.f()
          {
            public final void onCreateMMMenu(m paramAnonymous2m)
            {
              AppMethodBeat.i(38673);
              paramAnonymous2m.kV(1, 2131756779);
              String str = NewBizConversationUI.12.this.Bji.decodeString("PaySubscribeEntryUrl", "");
              if ((NewBizConversationUI.12.this.QgO == 1) && (!Util.isNullOrNil(str)) && (NewBizConversationUI.12.this.QgP))
              {
                boolean bool = NewBizConversationUI.12.this.Bji.decodeBool("NeedShowPayRedDot", true);
                paramAnonymous2m.a(2, NewBizConversationUI.this.getString(2131756702), bool);
              }
              AppMethodBeat.o(38673);
            }
          };
          paramAnonymousMenuItem.HLY = new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(38674);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                Log.w("MicroMsg.NewBizConversationUI", "default onMMMenuItemSelected err");
                AppMethodBeat.o(38674);
                return;
              case 1: 
                localObject = new Intent(NewBizConversationUI.this.getContext(), BizTimeLineNewMsgUI.class);
                ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 2);
                ((Intent)localObject).putExtra("biz_time_line_line_session_id", NewBizConversationUI.b(NewBizConversationUI.this));
                paramAnonymous2MenuItem = NewBizConversationUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(38674);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              Object localObject = MultiProcessMMKV.getSingleMMKV("brandService");
              ((MultiProcessMMKV)localObject).encode("NeedShowPayRedDot", false);
              localObject = ((MultiProcessMMKV)localObject).decodeString("PaySubscribeEntryUrl", "");
              if (Util.isNullOrNil((String)localObject))
              {
                Log.e("MicroMsg.NewBizConversationUI", "pay entry url is null!");
                AppMethodBeat.o(38674);
                return;
              }
              paramAnonymous2MenuItem.putExtra("rawUrl", (String)localObject);
              paramAnonymous2MenuItem.putExtra("KRightBtn", true);
              com.tencent.mm.br.c.b(NewBizConversationUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(38674);
            }
          };
          paramAnonymousMenuItem.dGm();
          AppMethodBeat.o(38675);
          return true;
        }
      });
      AppMethodBeat.o(38689);
      return;
      bool1 = false;
    }
  }
  
  private static String gWe()
  {
    AppMethodBeat.i(162388);
    if (com.tencent.mm.kernel.g.aAc()) {
      com.tencent.mm.kernel.g.aAf();
    }
    for (String str = com.tencent.mm.kernel.a.ayV();; str = "")
    {
      str = str + ":PaySubscribeEntryOpen";
      AppMethodBeat.o(162388);
      return str;
    }
  }
  
  public int getLayoutId()
  {
    return 2131496720;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38693);
    setMMTitle(this.Qbv);
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
    this.Qbt = ((ListView)findViewById(2131309254));
    this.emptyTipTv = ((TextView)findViewById(2131300096));
    this.emptyTipTv.setText(2131758714);
    this.QgH = new a(this, this.iNV, new s.a()
    {
      public final void bnE()
      {
        AppMethodBeat.i(38680);
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.g(NewBizConversationUI.this).getCount());
        AppMethodBeat.o(38680);
      }
    });
    this.QgH.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dr(View paramAnonymousView)
      {
        AppMethodBeat.i(38681);
        int i = NewBizConversationUI.h(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38681);
        return i;
      }
    });
    this.QgH.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38682);
        NewBizConversationUI.h(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38682);
      }
    });
    this.Qbt.setAdapter(this.QgH);
    this.pqr = new com.tencent.mm.ui.widget.b.a(this);
    this.Qbt.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38662);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        NewBizConversationUI.a(NewBizConversationUI.this, (az)NewBizConversationUI.g(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.i(NewBizConversationUI.this).field_username);
        paramAnonymousAdapterView = NewBizConversationUI.i(NewBizConversationUI.this);
        if (paramAnonymousAdapterView == null)
        {
          Log.e("MicroMsg.NewBizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(NewBizConversationUI.g(NewBizConversationUI.this).getCount()) });
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        NewBizConversationUI.g(NewBizConversationUI.this).a(paramAnonymousAdapterView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(38662);
      }
    });
    this.Qbt.setOnTouchListener(new View.OnTouchListener()
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
    this.Qbt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38664);
        NewBizConversationUI.a(NewBizConversationUI.this, (az)NewBizConversationUI.g(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.i(NewBizConversationUI.this).field_username);
        NewBizConversationUI.m(NewBizConversationUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NewBizConversationUI.this, NewBizConversationUI.j(NewBizConversationUI.this), NewBizConversationUI.k(NewBizConversationUI.this), NewBizConversationUI.l(NewBizConversationUI.this));
        AppMethodBeat.o(38664);
        return true;
      }
    });
    this.QgH.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dr(View paramAnonymousView)
      {
        AppMethodBeat.i(38665);
        int i = NewBizConversationUI.h(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38665);
        return i;
      }
    });
    this.QgH.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38666);
        NewBizConversationUI.h(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38666);
      }
    });
    this.QgH.a(new MMSlideDelView.f()
    {
      public final void cZ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(38667);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.NewBizConversationUI", "onItemDel object null");
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
    if (!bg.aAc())
    {
      Log.e("MicroMsg.NewBizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(38688);
      return;
    }
    this.dEb = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.source = getIntent().getIntExtra("biz_enter_source", 1);
    this.iNV = "officialaccounts";
    h.CyF.a(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.dEb), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.source), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.Qbv = getIntent().getStringExtra("enterprise_biz_display_name");
    if (Util.isNullOrNil(this.Qbv)) {
      this.Qbv = getString(2131756714);
    }
    initView();
    gWd();
    if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cle())
    {
      paramBundle = new d.a();
      paramBundle.iLN = new qc();
      paramBundle.iLO = new qd();
      paramBundle.uri = "/cgi-bin/mmbiz-bin/timeline/bizstrategy";
      paramBundle.funcId = 1806;
      paramBundle = paramBundle.aXF();
      ((qc)paramBundle.iLK.iLR).ReqType = 1;
      aa.a(paramBundle, new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(38676);
          Log.i("MicroMsg.NewBizConversationUI", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0))
          {
            AppMethodBeat.o(38676);
            return 0;
          }
          paramAnonymousString = (qd)paramAnonymousd.iLL.iLR;
          if ((paramAnonymousString.KWW != null) && (!Util.isNullOrNil(paramAnonymousString.KWW.MFT)))
          {
            paramAnonymousd = MultiProcessMMKV.getSingleMMKV("brandService");
            paramAnonymousInt1 = paramAnonymousd.decodeInt(NewBizConversationUI.gWf(), 0);
            paramAnonymousd.encode("PaySubscribeEntryUrl", paramAnonymousString.KWW.MFT);
            paramAnonymousd.encode(NewBizConversationUI.gWf(), paramAnonymousString.KWW.MFS);
            if (paramAnonymousInt1 != paramAnonymousString.KWW.MFS) {
              NewBizConversationUI.a(NewBizConversationUI.this);
            }
          }
          AppMethodBeat.o(38676);
          return 0;
        }
      });
    }
    bg.aVF();
    com.tencent.mm.model.c.aST().add(this.QgH);
    this.pss = System.currentTimeMillis();
    EventCenter.instance.addListener(this.ptp);
    AppMethodBeat.o(38688);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(38695);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    bg.aVF();
    as localas = com.tencent.mm.model.c.aSN().Kn(this.talker);
    if (localas == null)
    {
      Log.e("MicroMsg.NewBizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38695);
      return;
    }
    String str = localas.arJ();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (Util.isNullOrNil(localas.field_nickname)) {
        paramView = getString(2131757507);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(this, paramView));
    if (com.tencent.mm.contact.c.oR(localas.field_type))
    {
      if (!localas.arE()) {
        break label205;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131756713);
    }
    for (;;)
    {
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131762835);
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131762843);
      AppMethodBeat.o(38695);
      return;
      label205:
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131756712);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38690);
    bg.aAk().postToWorker(new Runnable()
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
    EventCenter.instance.removeListener(this.ptp);
    if (bg.aAc())
    {
      bg.aVF();
      com.tencent.mm.model.c.aST().remove(this.QgH);
    }
    if (this.QgH != null) {
      this.QgH.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(38690);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38692);
    Log.i("MicroMsg.NewBizConversationUI", "on pause");
    if (this.QgH != null) {
      this.QgH.onPause();
    }
    super.onPause();
    AppMethodBeat.o(38692);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38691);
    Log.v("MicroMsg.NewBizConversationUI", "on resume");
    if (this.QgH != null) {
      this.QgH.onResume();
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
    private String dVu;
    HashMap<String, NewBizConversationUI.b> pyQ;
    
    public a(Context paramContext, String paramString, s.a parama)
    {
      super(parama);
      AppMethodBeat.i(38683);
      this.dVu = paramString;
      this.pyQ = new HashMap();
      AppMethodBeat.o(38683);
    }
    
    public final void a(az paramaz, int paramInt)
    {
      AppMethodBeat.i(38686);
      bg.aVF();
      a(paramaz, com.tencent.mm.model.c.aST().h(paramaz), paramInt, true);
      AppMethodBeat.o(38686);
    }
    
    protected final void a(az paramaz, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      AppMethodBeat.i(38685);
      if (paramaz == null)
      {
        AppMethodBeat.o(38685);
        return;
      }
      NewBizConversationUI.b localb = (NewBizConversationUI.b)this.pyQ.get(paramaz.field_username);
      if (localb == null)
      {
        localb = new NewBizConversationUI.b((byte)0);
        this.pyQ.put(paramaz.field_username, localb);
      }
      for (;;)
      {
        if (localb.jkU > 0)
        {
          AppMethodBeat.o(38685);
          return;
        }
        localb.MQt = paramBoolean1;
        if ((localb.MQw) || (paramaz.field_unReadCount > 0)) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          localb.MQw = paramBoolean1;
          localb.xNc = (paramInt + 1);
          if (paramBoolean2) {
            localb.jkU = localb.xNc;
          }
          localb.MQv = ((int)(System.currentTimeMillis() / 1000L));
          if (paramaz.field_lastSeq != localb.seq) {
            break;
          }
          AppMethodBeat.o(38685);
          return;
        }
        localb.seq = paramaz.field_lastSeq;
        paramaz = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx(paramaz.field_username);
        if ((paramaz != null) && (paramaz.gAt()))
        {
          paramaz = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramaz.field_msgId, paramaz.field_content);
          if ((paramaz != null) && (!Util.isNullOrNil(paramaz.iAd)) && (!Util.isNullOrNil(((v)paramaz.iAd.get(0)).url))) {
            try
            {
              paramaz = Uri.parse(((v)paramaz.iAd.get(0)).url);
              localb.MQr = Util.getLong(paramaz.getQueryParameter("mid"), 0L);
              localb.MQs = Util.getInt(paramaz.getQueryParameter("idx"), 0);
              AppMethodBeat.o(38685);
              return;
            }
            catch (UnsupportedOperationException paramaz)
            {
              Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramaz.getMessage() });
              AppMethodBeat.o(38685);
              return;
            }
            catch (Exception paramaz)
            {
              Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramaz.getMessage() });
            }
          }
        }
        AppMethodBeat.o(38685);
        return;
      }
    }
    
    public final void anp()
    {
      AppMethodBeat.i(38684);
      bg.aVF();
      setCursor(com.tencent.mm.model.c.aST().c(ab.iCF, this.gzY, this.dVu));
      if (this.OFI != null) {
        this.OFI.bnE();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38684);
    }
  }
  
  static final class b
    extends dna
  {
    public int jkU = -1;
    public long seq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI
 * JD-Core Version:    0.7.0.1
 */