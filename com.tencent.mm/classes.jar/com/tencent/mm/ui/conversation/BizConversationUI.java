package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.z;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BizConversationUI
  extends BaseConversationUI
{
  private View contentView;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38271);
    super.onConfigurationChanged(paramConfiguration);
    h.a(this, this.contentView);
    AppMethodBeat.o(38271);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38270);
    super.onCreate(paramBundle);
    if (!bc.ajM())
    {
      ae.e("MicroMsg.BizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(38270);
      return;
    }
    this.contentView = z.jV(this).inflate(2131493232, null);
    setContentView(this.contentView);
    this.conversationFm = new BizConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131302341, this.conversationFm).commit();
    h.a(this, this.contentView);
    AppMethodBeat.o(38270);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class BizConversationFmUI
    extends BaseConversationUI.BaseConversationFmUI
  {
    private ListView KOt;
    private a KOu;
    private String KOv;
    private au conversation;
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
    
    public BizConversationFmUI()
    {
      AppMethodBeat.i(38258);
      this.doj = 1;
      this.talker = "";
      this.ohx = 0L;
      this.oef = 0;
      this.oeg = 0;
      this.tipDialog = null;
      this.isDeleteCancel = false;
      this.ogY = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(38244);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(38244);
            return;
            bc.aCg();
            paramAnonymousMenuItem = com.tencent.mm.model.c.azF().BH(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
            if (paramAnonymousMenuItem == null)
            {
              ae.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
              AppMethodBeat.o(38244);
              return;
            }
            if (paramAnonymousMenuItem.adB())
            {
              com.tencent.mm.plugin.report.service.g.yxI.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
              x.E(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this), true);
              AppMethodBeat.o(38244);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
            x.D(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this), true);
            AppMethodBeat.o(38244);
            return;
            bc.aCg();
            paramAnonymousMenuItem = com.tencent.mm.model.c.azF().BH(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
            com.tencent.mm.ui.tools.b.a(ag.aGp().Ef(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this)), BizConversationUI.BizConversationFmUI.this.thisActivity(), paramAnonymousMenuItem, 2);
            AppMethodBeat.o(38244);
            return;
            BizConversationUI.BizConversationFmUI.b(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
          }
        }
      };
      this.ohN = new com.tencent.mm.sdk.b.c() {};
      AppMethodBeat.o(38258);
    }
    
    public int getLayoutId()
    {
      return 2131495762;
    }
    
    public String getUserName()
    {
      return this.hSG;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      AppMethodBeat.i(38259);
      super.onActivityCreated(paramBundle);
      this.hSG = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
      if (bu.isNullOrNil(this.hSG)) {
        this.hSG = "officialaccounts";
      }
      this.doj = thisActivity().getIntent().getIntExtra("biz_enter_source", 1);
      if (bu.nullAsNil(this.hSG).equals("officialaccounts")) {
        com.tencent.mm.plugin.report.service.g.yxI.f(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.doj), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      this.KOv = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
      if (bu.isNullOrNil(this.KOv)) {
        this.KOv = getString(2131756578);
      }
      setMMTitle(this.KOv);
      this.KOt = ((ListView)findViewById(2131305951));
      this.emptyTipTv = ((TextView)findViewById(2131299468));
      this.emptyTipTv.setText(2131758419);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38248);
          BizConversationUI.BizConversationFmUI.this.finish();
          AppMethodBeat.o(38248);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38249);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38249);
        }
      });
      this.KOu = new a(thisActivity(), this.hSG, new r.a()
      {
        public final void aSR()
        {
          AppMethodBeat.i(38250);
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getCount());
          AppMethodBeat.o(38250);
        }
      });
      this.KOu.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
        {
          AppMethodBeat.i(38251);
          int i = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38251);
          return i;
        }
      });
      this.KOu.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38252);
          BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(38252);
        }
      });
      this.KOt.setAdapter(this.KOu);
      this.ofu = new com.tencent.mm.ui.widget.b.a(thisActivity());
      this.KOt.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38253);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, (au)BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getItem(paramAnonymousInt));
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this).field_username);
          paramAnonymousAdapterView = BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this);
          if (paramAnonymousAdapterView == null)
          {
            ae.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getCount()) });
            BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38253);
            return;
          }
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt("biz_click_item_unread_count", BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this).field_unReadCount);
          paramAnonymousView.putInt("biz_click_item_position", paramAnonymousInt + 1);
          paramAnonymousView.putInt("KOpenArticleSceneFromScene", 131);
          paramAnonymousView.putInt("specific_chat_from_scene", 1);
          BizConversationUI.BizConversationFmUI.this.ui.startChatting(paramAnonymousAdapterView.field_username, paramAnonymousView, true);
          BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).a(paramAnonymousAdapterView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38253);
        }
      });
      this.KOt.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(38236);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(38236);
            return false;
            BizConversationUI.BizConversationFmUI.b(BizConversationUI.BizConversationFmUI.this, (int)paramAnonymousMotionEvent.getRawX());
            BizConversationUI.BizConversationFmUI.c(BizConversationUI.BizConversationFmUI.this, (int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.KOt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38237);
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, (au)BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getItem(paramAnonymousInt));
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this).field_username);
          BizConversationUI.BizConversationFmUI.j(BizConversationUI.BizConversationFmUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.g(BizConversationUI.BizConversationFmUI.this), BizConversationUI.BizConversationFmUI.h(BizConversationUI.BizConversationFmUI.this), BizConversationUI.BizConversationFmUI.i(BizConversationUI.BizConversationFmUI.this));
          AppMethodBeat.o(38237);
          return true;
        }
      });
      this.KOu.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
        {
          AppMethodBeat.i(38238);
          int i = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38238);
          return i;
        }
      });
      this.KOu.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38239);
          BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(38239);
        }
      });
      this.KOu.a(new MMSlideDelView.f()
      {
        public final void cQ(Object paramAnonymousObject)
        {
          AppMethodBeat.i(38240);
          if (paramAnonymousObject == null)
          {
            ae.e("MicroMsg.BizConversationUI", "onItemDel object null");
            AppMethodBeat.o(38240);
            return;
          }
          paramAnonymousObject = paramAnonymousObject.toString();
          BizConversationUI.BizConversationFmUI.b(BizConversationUI.BizConversationFmUI.this, paramAnonymousObject);
          AppMethodBeat.o(38240);
        }
      });
      if ("officialaccounts".equals(this.hSG))
      {
        paramBundle = com.tencent.mm.model.c.d.aDI().xi("100045");
        if ((!paramBundle.isValid()) || (!"1".equals(paramBundle.fsy().get("isOpenSearch")))) {
          break label619;
        }
      }
      label619:
      for (boolean bool = true;; bool = false)
      {
        ae.d("MicroMsg.BizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(38235);
              if (ad.WK(0)) {
                ((com.tencent.mm.plugin.websearch.api.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.i.class)).a(ak.getContext(), new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(38234);
                    Intent localIntent = ad.ePM();
                    localIntent.putExtra("title", BizConversationUI.BizConversationFmUI.this.getString(2131759718));
                    localIntent.putExtra("searchbar_tips", BizConversationUI.BizConversationFmUI.this.getString(2131759718));
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
                        localObject = ActivityOptions.makeSceneTransitionAnimation(BizConversationUI.BizConversationFmUI.this.thisActivity(), new Pair[0]).toBundle();
                      }
                    }
                    com.tencent.mm.br.d.a(BizConversationUI.BizConversationFmUI.this.thisActivity(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
                    AppMethodBeat.o(38234);
                  }
                });
              }
              for (;;)
              {
                AppMethodBeat.o(38235);
                return true;
                ae.e("MicroMsg.BizConversationUI", "fts h5 template not avail");
              }
            }
          });
        }
        bc.aCg();
        com.tencent.mm.model.c.azL().a(this.KOu);
        this.ohx = System.currentTimeMillis();
        com.tencent.mm.sdk.b.a.IvT.c(this.ohN);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(38246);
            Looper.myQueue().removeIdleHandler(this);
            com.tencent.mm.cp.d.fWU();
            AppMethodBeat.o(38246);
            return false;
          }
        });
        AppMethodBeat.o(38259);
        return;
      }
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(38263);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if ((this.talker != null) && (!this.talker.isEmpty())) {
        this.talker = "";
      }
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(38263);
        return;
      }
      AppMethodBeat.o(38263);
    }
    
    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(38264);
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      bc.aCg();
      an localan = com.tencent.mm.model.c.azF().BH(this.talker);
      if (localan == null)
      {
        ae.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
        AppMethodBeat.o(38264);
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
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(thisActivity(), paramView));
      if (com.tencent.mm.contact.c.lO(localan.field_type))
      {
        if (!localan.adB()) {
          break label208;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131761053);
      }
      for (;;)
      {
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131761049);
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131761057);
        AppMethodBeat.o(38264);
        return;
        label208:
        paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131757877);
      }
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(38260);
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38247);
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this);
          BizConversationUI.BizConversationFmUI.b(BizConversationUI.BizConversationFmUI.this);
          BizConversationUI.BizConversationFmUI.c(BizConversationUI.BizConversationFmUI.this);
          AppMethodBeat.o(38247);
        }
      });
      com.tencent.mm.sdk.b.a.IvT.d(this.ohN);
      if (bc.ajM())
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().b(this.KOu);
      }
      if (this.KOu != null) {
        this.KOu.onDestroy();
      }
      super.onDestroy();
      AppMethodBeat.o(38260);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(38262);
      ae.i("MicroMsg.BizConversationUI", "on pause");
      bc.aCg();
      com.tencent.mm.model.c.azL().aVc(this.hSG);
      if (this.KOu != null) {
        this.KOu.onPause();
      }
      super.onPause();
      AppMethodBeat.o(38262);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(38261);
      ae.v("MicroMsg.BizConversationUI", "on resume");
      if (this.KOu != null) {
        this.KOu.onResume();
      }
      super.onResume();
      AppMethodBeat.o(38261);
    }
    
    static final class a
      extends e
    {
      private String dDG;
      HashMap<String, BizConversationUI.BizConversationFmUI.b> ohc;
      
      public a(Context paramContext, String paramString, r.a parama)
      {
        super(parama);
        AppMethodBeat.i(38254);
        this.dDG = paramString;
        this.ohc = new HashMap();
        AppMethodBeat.o(38254);
      }
      
      public final void ZD()
      {
        AppMethodBeat.i(38255);
        bc.aCg();
        setCursor(com.tencent.mm.model.c.azL().c(x.hHV, this.fUR, this.dDG));
        if (this.Jvn != null) {
          this.Jvn.aSR();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38255);
      }
      
      public final void a(au paramau, int paramInt)
      {
        AppMethodBeat.i(38257);
        bc.aCg();
        a(paramau, com.tencent.mm.model.c.azL().h(paramau), paramInt, true);
        AppMethodBeat.o(38257);
      }
      
      protected final void a(au paramau, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
      {
        AppMethodBeat.i(38256);
        if (paramau == null)
        {
          AppMethodBeat.o(38256);
          return;
        }
        BizConversationUI.BizConversationFmUI.b localb = (BizConversationUI.BizConversationFmUI.b)this.ohc.get(paramau.field_username);
        if (localb == null)
        {
          localb = new BizConversationUI.BizConversationFmUI.b((byte)0);
          this.ohc.put(paramau.field_username, localb);
        }
        for (;;)
        {
          if (localb.ipN > 0)
          {
            AppMethodBeat.o(38256);
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
            AppMethodBeat.o(38256);
            return;
          }
          localb.seq = paramau.field_lastSeq;
          paramau = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().arc(paramau.field_username);
          if ((paramau != null) && (paramau.fta()))
          {
            paramau = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramau.field_msgId, paramau.field_content);
            if ((paramau != null) && (!bu.ht(paramau.hFT)) && (!bu.isNullOrNil(((v)paramau.hFT.get(0)).url))) {
              try
              {
                paramau = Uri.parse(((v)paramau.hFT.get(0)).url);
                localb.HFh = bu.getLong(paramau.getQueryParameter("mid"), 0L);
                localb.HFi = bu.getInt(paramau.getQueryParameter("idx"), 0);
                AppMethodBeat.o(38256);
                return;
              }
              catch (UnsupportedOperationException paramau)
              {
                ae.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramau.getMessage() });
                AppMethodBeat.o(38256);
                return;
              }
              catch (Exception paramau)
              {
                ae.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramau.getMessage() });
              }
            }
          }
          AppMethodBeat.o(38256);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI
 * JD-Core Version:    0.7.0.1
 */