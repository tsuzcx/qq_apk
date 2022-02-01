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
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
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
  private ListView KOt;
  private String KOv;
  private a KTA;
  private final int KTB;
  private final int KTC;
  private au conversation;
  private int dmM;
  private int doj;
  private TextView emptyTipTv;
  private String hSG;
  private boolean isDeleteCancel;
  private int oef;
  private int oeg;
  private com.tencent.mm.ui.widget.b.a ofu;
  private n.e ogY;
  private com.tencent.mm.sdk.b.c ohN;
  private long ohx;
  private String talker;
  private p tipDialog;
  
  public NewBizConversationUI()
  {
    AppMethodBeat.i(38687);
    this.doj = 1;
    this.talker = "";
    this.ohx = 0L;
    this.oef = 0;
    this.oeg = 0;
    this.KTB = 1;
    this.KTC = 2;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.ogY = new n.e()
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
          bc.aCg();
          paramAnonymousMenuItem = com.tencent.mm.model.c.azF().BH(NewBizConversationUI.p(NewBizConversationUI.this));
          if (paramAnonymousMenuItem == null)
          {
            ae.e("MicroMsg.NewBizConversationUI", "changed biz stick status failed, contact is null, talker = " + NewBizConversationUI.p(NewBizConversationUI.this));
            AppMethodBeat.o(38671);
            return;
          }
          if (paramAnonymousMenuItem.adB())
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
            com.tencent.mm.model.x.E(NewBizConversationUI.p(NewBizConversationUI.this), true);
          }
          for (;;)
          {
            am localam = new am();
            localam.dmc.userName = paramAnonymousMenuItem.field_username;
            com.tencent.mm.sdk.b.a.IvT.l(localam);
            AppMethodBeat.o(38671);
            return;
            com.tencent.mm.plugin.report.service.g.yxI.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
            com.tencent.mm.model.x.D(NewBizConversationUI.p(NewBizConversationUI.this), true);
          }
          bc.aCg();
          paramAnonymousMenuItem = com.tencent.mm.model.c.azF().BH(NewBizConversationUI.p(NewBizConversationUI.this));
          com.tencent.mm.ui.tools.b.a(ag.aGp().Ef(NewBizConversationUI.p(NewBizConversationUI.this)), NewBizConversationUI.this, paramAnonymousMenuItem, 2);
          AppMethodBeat.o(38671);
          return;
          NewBizConversationUI.b(NewBizConversationUI.this, NewBizConversationUI.p(NewBizConversationUI.this));
        }
      }
    };
    this.ohN = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(38687);
  }
  
  private void fNJ()
  {
    AppMethodBeat.i(38689);
    removeAllOptionMenu();
    Object localObject = com.tencent.mm.model.c.d.aDI().xi("100045");
    final boolean bool2;
    final int i;
    if ((((com.tencent.mm.storage.c)localObject).isValid()) && ("1".equals(((com.tencent.mm.storage.c)localObject).fsy().get("isOpenSearch"))))
    {
      bool1 = true;
      ae.d("MicroMsg.NewBizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1) {
        addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(38661);
            if (ad.WK(0)) {
              ((com.tencent.mm.plugin.websearch.api.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.i.class)).a(ak.getContext(), new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(38660);
                  Intent localIntent = ad.ePM();
                  localIntent.putExtra("title", NewBizConversationUI.this.getString(2131759718));
                  localIntent.putExtra("searchbar_tips", NewBizConversationUI.this.getString(2131759718));
                  localIntent.putExtra("KRightBtn", true);
                  localIntent.putExtra("ftsneedkeyboard", true);
                  localIntent.putExtra("publishIdPrefix", "bs");
                  localIntent.putExtra("ftsType", 2);
                  localIntent.putExtra("ftsbizscene", 11);
                  Object localObject = ad.f(11, true, 2);
                  String str = ad.WI(bu.aSB((String)((Map)localObject).get("scene")));
                  ((Map)localObject).put("sessionId", str);
                  localIntent.putExtra("sessionId", str);
                  localIntent.putExtra("rawUrl", ad.be((Map)localObject));
                  localIntent.putExtra("key_load_js_without_delay", true);
                  localIntent.addFlags(67108864);
                  str = null;
                  localObject = str;
                  if (Build.VERSION.SDK_INT >= 21)
                  {
                    localObject = str;
                    if (!al.isDarkMode()) {
                      localObject = ActivityOptions.makeSceneTransitionAnimation(NewBizConversationUI.this, new Pair[0]).toBundle();
                    }
                  }
                  str = af.aHl("bizAccountTopSearch");
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
              ae.e("MicroMsg.NewBizConversationUI", "fts h5 template not avail");
            }
          }
        });
      }
      localObject = ay.aRX("brandService");
      bool2 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOf();
      i = ((ay)localObject).decodeInt(fNK(), 0);
      if ((i != 1) || (!bool2) || (!((ay)localObject).decodeBool("NeedShowPayActionBarRedDot", true))) {
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
            this.xlh.encode("NeedShowPayActionBarRedDot", false);
            NewBizConversationUI.a(NewBizConversationUI.this);
          }
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NewBizConversationUI.this, 1, false);
          paramAnonymousMenuItem.LfS = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(38673);
              paramAnonymous2l.jM(1, 2131756631);
              String str = NewBizConversationUI.12.this.xlh.decodeString("PaySubscribeEntryUrl", "");
              if ((NewBizConversationUI.12.this.KTG == 1) && (!bu.isNullOrNil(str)) && (NewBizConversationUI.12.this.KTH))
              {
                boolean bool = NewBizConversationUI.12.this.xlh.decodeBool("NeedShowPayRedDot", true);
                paramAnonymous2l.a(2, NewBizConversationUI.this.getString(2131756566), bool);
              }
              AppMethodBeat.o(38673);
            }
          };
          paramAnonymousMenuItem.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(38674);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                ae.w("MicroMsg.NewBizConversationUI", "default onMMMenuItemSelected err");
                AppMethodBeat.o(38674);
                return;
              case 1: 
                localObject = new Intent(NewBizConversationUI.this.getContext(), BizTimeLineNewMsgUI.class);
                ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 2);
                ((Intent)localObject).putExtra("biz_time_line_line_session_id", NewBizConversationUI.b(NewBizConversationUI.this));
                paramAnonymous2MenuItem = NewBizConversationUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(38674);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              Object localObject = ay.aRX("brandService");
              ((ay)localObject).encode("NeedShowPayRedDot", false);
              localObject = ((ay)localObject).decodeString("PaySubscribeEntryUrl", "");
              if (bu.isNullOrNil((String)localObject))
              {
                ae.e("MicroMsg.NewBizConversationUI", "pay entry url is null!");
                AppMethodBeat.o(38674);
                return;
              }
              paramAnonymous2MenuItem.putExtra("rawUrl", (String)localObject);
              paramAnonymous2MenuItem.putExtra("KRightBtn", true);
              com.tencent.mm.br.d.b(NewBizConversationUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(38674);
            }
          };
          paramAnonymousMenuItem.cPF();
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
  
  private static String fNK()
  {
    AppMethodBeat.i(162388);
    if (com.tencent.mm.kernel.g.ajM()) {
      com.tencent.mm.kernel.g.ajP();
    }
    for (String str = com.tencent.mm.kernel.a.aiF();; str = "")
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
    setMMTitle(this.KOv);
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
    this.KOt = ((ListView)findViewById(2131305951));
    this.emptyTipTv = ((TextView)findViewById(2131299468));
    this.emptyTipTv.setText(2131758419);
    this.KTA = new a(this, this.hSG, new r.a()
    {
      public final void aSR()
      {
        AppMethodBeat.i(38680);
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.g(NewBizConversationUI.this).getCount());
        AppMethodBeat.o(38680);
      }
    });
    this.KTA.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(38681);
        int i = NewBizConversationUI.h(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38681);
        return i;
      }
    });
    this.KTA.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38682);
        NewBizConversationUI.h(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38682);
      }
    });
    this.KOt.setAdapter(this.KTA);
    this.ofu = new com.tencent.mm.ui.widget.b.a(this);
    this.KOt.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38662);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        NewBizConversationUI.a(NewBizConversationUI.this, (au)NewBizConversationUI.g(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.i(NewBizConversationUI.this).field_username);
        paramAnonymousAdapterView = NewBizConversationUI.i(NewBizConversationUI.this);
        if (paramAnonymousAdapterView == null)
        {
          ae.e("MicroMsg.NewBizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(NewBizConversationUI.g(NewBizConversationUI.this).getCount()) });
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
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        NewBizConversationUI.g(NewBizConversationUI.this).a(paramAnonymousAdapterView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(38662);
      }
    });
    this.KOt.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(38663);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/NewBizConversationUI$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
    this.KOt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38664);
        NewBizConversationUI.a(NewBizConversationUI.this, (au)NewBizConversationUI.g(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.i(NewBizConversationUI.this).field_username);
        NewBizConversationUI.m(NewBizConversationUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NewBizConversationUI.this, NewBizConversationUI.j(NewBizConversationUI.this), NewBizConversationUI.k(NewBizConversationUI.this), NewBizConversationUI.l(NewBizConversationUI.this));
        AppMethodBeat.o(38664);
        return true;
      }
    });
    this.KTA.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(38665);
        int i = NewBizConversationUI.h(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38665);
        return i;
      }
    });
    this.KTA.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38666);
        NewBizConversationUI.h(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38666);
      }
    });
    this.KTA.a(new MMSlideDelView.f()
    {
      public final void cQ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(38667);
        if (paramAnonymousObject == null)
        {
          ae.e("MicroMsg.NewBizConversationUI", "onItemDel object null");
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
    if (!bc.ajM())
    {
      ae.e("MicroMsg.NewBizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(38688);
      return;
    }
    this.dmM = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.doj = getIntent().getIntExtra("biz_enter_source", 1);
    this.hSG = "officialaccounts";
    com.tencent.mm.plugin.report.service.g.yxI.f(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.dmM), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.doj), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.KOv = getIntent().getStringExtra("enterprise_biz_display_name");
    if (bu.isNullOrNil(this.KOv)) {
      this.KOv = getString(2131756578);
    }
    initView();
    fNJ();
    if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOf())
    {
      paramBundle = new b.a();
      paramBundle.hQF = new pf();
      paramBundle.hQG = new pg();
      paramBundle.uri = "/cgi-bin/mmbiz-bin/timeline/bizstrategy";
      paramBundle.funcId = 1806;
      paramBundle = paramBundle.aDS();
      ((pf)paramBundle.hQD.hQJ).ReqType = 1;
      com.tencent.mm.ak.x.a(paramBundle, new NewBizConversationUI.13(this));
    }
    bc.aCg();
    com.tencent.mm.model.c.azL().a(this.KTA);
    this.ohx = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.IvT.c(this.ohN);
    AppMethodBeat.o(38688);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(38695);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    bc.aCg();
    an localan = com.tencent.mm.model.c.azF().BH(this.talker);
    if (localan == null)
    {
      ae.e("MicroMsg.NewBizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38695);
      return;
    }
    String str = localan.adG();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (bu.isNullOrNil(localan.field_nickname)) {
        paramView = getString(2131757293);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramView));
    if (com.tencent.mm.contact.c.lO(localan.field_type))
    {
      if (!localan.adB()) {
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
    bc.ajU().aw(new Runnable()
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
    com.tencent.mm.sdk.b.a.IvT.d(this.ohN);
    if (bc.ajM())
    {
      bc.aCg();
      com.tencent.mm.model.c.azL().b(this.KTA);
    }
    if (this.KTA != null) {
      this.KTA.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(38690);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38692);
    ae.i("MicroMsg.NewBizConversationUI", "on pause");
    if (this.KTA != null) {
      this.KTA.onPause();
    }
    super.onPause();
    AppMethodBeat.o(38692);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38691);
    ae.v("MicroMsg.NewBizConversationUI", "on resume");
    if (this.KTA != null) {
      this.KTA.onResume();
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
    private String dDG;
    HashMap<String, NewBizConversationUI.b> ohc;
    
    public a(Context paramContext, String paramString, r.a parama)
    {
      super(parama);
      AppMethodBeat.i(38683);
      this.dDG = paramString;
      this.ohc = new HashMap();
      AppMethodBeat.o(38683);
    }
    
    public final void ZD()
    {
      AppMethodBeat.i(38684);
      bc.aCg();
      setCursor(com.tencent.mm.model.c.azL().c(com.tencent.mm.model.x.hHV, this.fUR, this.dDG));
      if (this.Jvn != null) {
        this.Jvn.aSR();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38684);
    }
    
    public final void a(au paramau, int paramInt)
    {
      AppMethodBeat.i(38686);
      bc.aCg();
      a(paramau, com.tencent.mm.model.c.azL().h(paramau), paramInt, true);
      AppMethodBeat.o(38686);
    }
    
    protected final void a(au paramau, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      AppMethodBeat.i(38685);
      if (paramau == null)
      {
        AppMethodBeat.o(38685);
        return;
      }
      NewBizConversationUI.b localb = (NewBizConversationUI.b)this.ohc.get(paramau.field_username);
      if (localb == null)
      {
        localb = new NewBizConversationUI.b((byte)0);
        this.ohc.put(paramau.field_username, localb);
      }
      for (;;)
      {
        if (localb.ipN > 0)
        {
          AppMethodBeat.o(38685);
          return;
        }
        localb.HFj = paramBoolean1;
        if ((localb.HFm) || (paramau.field_unReadCount > 0)) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          localb.HFm = paramBoolean1;
          localb.uvb = (paramInt + 1);
          if (paramBoolean2) {
            localb.ipN = localb.uvb;
          }
          localb.HFl = ((int)(System.currentTimeMillis() / 1000L));
          if (paramau.field_lastSeq != localb.seq) {
            break;
          }
          AppMethodBeat.o(38685);
          return;
        }
        localb.seq = paramau.field_lastSeq;
        paramau = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arc(paramau.field_username);
        if ((paramau != null) && (paramau.fta()))
        {
          paramau = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramau.field_msgId, paramau.field_content);
          if ((paramau != null) && (!bu.ht(paramau.hFT)) && (!bu.isNullOrNil(((v)paramau.hFT.get(0)).url))) {
            try
            {
              paramau = Uri.parse(((v)paramau.hFT.get(0)).url);
              localb.HFh = bu.getLong(paramau.getQueryParameter("mid"), 0L);
              localb.HFi = bu.getInt(paramau.getQueryParameter("idx"), 0);
              AppMethodBeat.o(38685);
              return;
            }
            catch (UnsupportedOperationException paramau)
            {
              ae.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramau.getMessage() });
              AppMethodBeat.o(38685);
              return;
            }
            catch (Exception paramau)
            {
              ae.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramau.getMessage() });
            }
          }
        }
        AppMethodBeat.o(38685);
        return;
      }
    }
  }
  
  static final class b
    extends cuh
  {
    public int ipN = -1;
    public long seq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI
 * JD-Core Version:    0.7.0.1
 */