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
import com.tencent.mm.al.af;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r.a;
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
    com.tencent.mm.pluginsdk.g.a(this, this.contentView);
    AppMethodBeat.o(38271);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38270);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.model.az.agM())
    {
      ac.e("MicroMsg.BizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(38270);
      return;
    }
    this.contentView = com.tencent.mm.ui.z.jD(this).inflate(2131493232, null);
    setContentView(this.contentView);
    this.conversationFm = new BizConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131302341, this.conversationFm).commit();
    com.tencent.mm.pluginsdk.g.a(this, this.contentView);
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
    private ListView IAT;
    private a IAU;
    private String IAV;
    private com.tencent.mm.storage.ap conversation;
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
    private com.tencent.mm.ui.base.p tipDialog;
    
    public BizConversationFmUI()
    {
      AppMethodBeat.i(38258);
      this.dbL = 1;
      this.talker = "";
      this.nAC = 0L;
      this.nwY = 0;
      this.nwZ = 0;
      this.tipDialog = null;
      this.isDeleteCancel = false;
      this.nAc = new n.d()
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
            com.tencent.mm.model.az.ayM();
            paramAnonymousMenuItem = com.tencent.mm.model.c.awB().aNt(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
            if (paramAnonymousMenuItem == null)
            {
              ac.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
              AppMethodBeat.o(38244);
              return;
            }
            if (paramAnonymousMenuItem.aaN())
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
              w.E(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this), true);
              AppMethodBeat.o(38244);
              return;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
            w.D(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this), true);
            AppMethodBeat.o(38244);
            return;
            com.tencent.mm.model.az.ayM();
            paramAnonymousMenuItem = com.tencent.mm.model.c.awB().aNt(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
            com.tencent.mm.ui.tools.b.a(af.aCW().AE(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this)), BizConversationUI.BizConversationFmUI.this.thisActivity(), paramAnonymousMenuItem, 2);
            AppMethodBeat.o(38244);
            return;
            BizConversationUI.BizConversationFmUI.b(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
          }
        }
      };
      this.nAQ = new com.tencent.mm.sdk.b.c() {};
      AppMethodBeat.o(38258);
    }
    
    public int getLayoutId()
    {
      return 2131495762;
    }
    
    public String getUserName()
    {
      return this.hxt;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      AppMethodBeat.i(38259);
      super.onActivityCreated(paramBundle);
      this.hxt = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
      if (bs.isNullOrNil(this.hxt)) {
        this.hxt = "officialaccounts";
      }
      this.dbL = thisActivity().getIntent().getIntExtra("biz_enter_source", 1);
      if (bs.nullAsNil(this.hxt).equals("officialaccounts")) {
        com.tencent.mm.plugin.report.service.h.wUl.f(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.dbL), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      this.IAV = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
      if (bs.isNullOrNil(this.IAV)) {
        this.IAV = getString(2131756578);
      }
      setMMTitle(this.IAV);
      this.IAT = ((ListView)findViewById(2131305951));
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
          paramAnonymousView = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(38249);
        }
      });
      this.IAU = new a(thisActivity(), this.hxt, new r.a()
      {
        public final void aPg()
        {
          AppMethodBeat.i(38250);
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getCount());
          AppMethodBeat.o(38250);
        }
      });
      this.IAU.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dy(View paramAnonymousView)
        {
          AppMethodBeat.i(38251);
          int i = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38251);
          return i;
        }
      });
      this.IAU.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38252);
          BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(38252);
        }
      });
      this.IAT.setAdapter(this.IAU);
      this.nym = new com.tencent.mm.ui.widget.b.a(thisActivity());
      this.IAT.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38253);
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, (com.tencent.mm.storage.ap)BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getItem(paramAnonymousInt));
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this).field_username);
          paramAnonymousAdapterView = BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this);
          if (paramAnonymousAdapterView == null)
          {
            ac.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getCount()) });
            BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).notifyDataSetChanged();
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
          AppMethodBeat.o(38253);
        }
      });
      this.IAT.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(38236);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(38236);
            return false;
            BizConversationUI.BizConversationFmUI.b(BizConversationUI.BizConversationFmUI.this, (int)paramAnonymousMotionEvent.getRawX());
            BizConversationUI.BizConversationFmUI.c(BizConversationUI.BizConversationFmUI.this, (int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.IAT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38237);
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, (com.tencent.mm.storage.ap)BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getItem(paramAnonymousInt));
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this).field_username);
          BizConversationUI.BizConversationFmUI.j(BizConversationUI.BizConversationFmUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.g(BizConversationUI.BizConversationFmUI.this), BizConversationUI.BizConversationFmUI.h(BizConversationUI.BizConversationFmUI.this), BizConversationUI.BizConversationFmUI.i(BizConversationUI.BizConversationFmUI.this));
          AppMethodBeat.o(38237);
          return true;
        }
      });
      this.IAU.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dy(View paramAnonymousView)
        {
          AppMethodBeat.i(38238);
          int i = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38238);
          return i;
        }
      });
      this.IAU.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38239);
          BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(38239);
        }
      });
      this.IAU.a(new MMSlideDelView.f()
      {
        public final void cN(Object paramAnonymousObject)
        {
          AppMethodBeat.i(38240);
          if (paramAnonymousObject == null)
          {
            ac.e("MicroMsg.BizConversationUI", "onItemDel object null");
            AppMethodBeat.o(38240);
            return;
          }
          paramAnonymousObject = paramAnonymousObject.toString();
          BizConversationUI.BizConversationFmUI.b(BizConversationUI.BizConversationFmUI.this, paramAnonymousObject);
          AppMethodBeat.o(38240);
        }
      });
      if ("officialaccounts".equals(this.hxt))
      {
        paramBundle = com.tencent.mm.model.c.d.aAp().tJ("100045");
        if ((!paramBundle.isValid()) || (!"1".equals(paramBundle.eYV().get("isOpenSearch")))) {
          break label619;
        }
      }
      label619:
      for (boolean bool = true;; bool = false)
      {
        ac.d("MicroMsg.BizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(38235);
              if (com.tencent.mm.plugin.websearch.api.z.Uk(0)) {
                ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.h.class)).a(com.tencent.mm.sdk.platformtools.ai.getContext(), new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(38234);
                    Intent localIntent = com.tencent.mm.plugin.websearch.api.z.exm();
                    localIntent.putExtra("title", BizConversationUI.BizConversationFmUI.this.getString(2131759718));
                    localIntent.putExtra("searchbar_tips", BizConversationUI.BizConversationFmUI.this.getString(2131759718));
                    localIntent.putExtra("KRightBtn", true);
                    localIntent.putExtra("ftsneedkeyboard", true);
                    localIntent.putExtra("publishIdPrefix", "bs");
                    localIntent.putExtra("ftsType", 2);
                    localIntent.putExtra("ftsbizscene", 11);
                    Object localObject = com.tencent.mm.plugin.websearch.api.z.f(11, true, 2);
                    String str = com.tencent.mm.plugin.websearch.api.z.Ui(bs.aLy((String)((Map)localObject).get("scene")));
                    ((Map)localObject).put("sessionId", str);
                    localIntent.putExtra("sessionId", str);
                    localIntent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.api.z.aV((Map)localObject));
                    localIntent.putExtra("key_load_js_without_delay", true);
                    localIntent.addFlags(67108864);
                    str = null;
                    localObject = str;
                    if (Build.VERSION.SDK_INT >= 21)
                    {
                      localObject = str;
                      if (!aj.DT()) {
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
                ac.e("MicroMsg.BizConversationUI", "fts h5 template not avail");
              }
            }
          });
        }
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().a(this.IAU);
        this.nAC = System.currentTimeMillis();
        com.tencent.mm.sdk.b.a.GpY.c(this.nAQ);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(38246);
            Looper.myQueue().removeIdleHandler(this);
            com.tencent.mm.cq.d.fBf();
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
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.storage.ai localai = com.tencent.mm.model.c.awB().aNt(this.talker);
      if (localai == null)
      {
        ac.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
        AppMethodBeat.o(38264);
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
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(thisActivity(), paramView));
      if (com.tencent.mm.n.b.ln(localai.field_type))
      {
        if (!localai.aaN()) {
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
      com.tencent.mm.model.az.agU().az(new Runnable()
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
      com.tencent.mm.sdk.b.a.GpY.d(this.nAQ);
      if (com.tencent.mm.model.az.agM())
      {
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().b(this.IAU);
      }
      if (this.IAU != null) {
        this.IAU.onDestroy();
      }
      super.onDestroy();
      AppMethodBeat.o(38260);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(38262);
      ac.i("MicroMsg.BizConversationUI", "on pause");
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awG().aNK(this.hxt);
      if (this.IAU != null) {
        this.IAU.onPause();
      }
      super.onPause();
      AppMethodBeat.o(38262);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(38261);
      ac.v("MicroMsg.BizConversationUI", "on resume");
      if (this.IAU != null) {
        this.IAU.onResume();
      }
      super.onResume();
      AppMethodBeat.o(38261);
    }
    
    static final class a
      extends e
    {
      private String dqK;
      HashMap<String, BizConversationUI.BizConversationFmUI.b> nAg;
      
      public a(Context paramContext, String paramString, r.a parama)
      {
        super(parama);
        AppMethodBeat.i(38254);
        this.dqK = paramString;
        this.nAg = new HashMap();
        AppMethodBeat.o(38254);
      }
      
      public final void Xb()
      {
        AppMethodBeat.i(38255);
        com.tencent.mm.model.az.ayM();
        setCursor(com.tencent.mm.model.c.awG().c(w.hmN, this.fzw, this.dqK));
        if (this.HmY != null) {
          this.HmY.aPg();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38255);
      }
      
      public final void a(com.tencent.mm.storage.ap paramap, int paramInt)
      {
        AppMethodBeat.i(38257);
        com.tencent.mm.model.az.ayM();
        a(paramap, com.tencent.mm.model.c.awG().h(paramap), paramInt, true);
        AppMethodBeat.o(38257);
      }
      
      protected final void a(com.tencent.mm.storage.ap paramap, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
      {
        AppMethodBeat.i(38256);
        if (paramap == null)
        {
          AppMethodBeat.o(38256);
          return;
        }
        BizConversationUI.BizConversationFmUI.b localb = (BizConversationUI.BizConversationFmUI.b)this.nAg.get(paramap.field_username);
        if (localb == null)
        {
          localb = new BizConversationUI.BizConversationFmUI.b((byte)0);
          this.nAg.put(paramap.field_username, localb);
        }
        for (;;)
        {
          if (localb.hTz > 0)
          {
            AppMethodBeat.o(38256);
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
            AppMethodBeat.o(38256);
            return;
          }
          localb.seq = paramap.field_lastSeq;
          paramap = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk(paramap.field_username);
          if ((paramap != null) && (paramap.eZj()))
          {
            paramap = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramap.field_msgId, paramap.field_content);
            if ((paramap != null) && (!bs.gY(paramap.hkS)) && (!bs.isNullOrNil(((v)paramap.hkS.get(0)).url))) {
              try
              {
                paramap = Uri.parse(((v)paramap.hkS.get(0)).url);
                localb.FBu = bs.getLong(paramap.getQueryParameter("mid"), 0L);
                localb.FBv = bs.getInt(paramap.getQueryParameter("idx"), 0);
                AppMethodBeat.o(38256);
                return;
              }
              catch (UnsupportedOperationException paramap)
              {
                ac.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramap.getMessage() });
                AppMethodBeat.o(38256);
                return;
              }
              catch (Exception paramap)
              {
                ac.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramap.getMessage() });
              }
            }
          }
          AppMethodBeat.o(38256);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI
 * JD-Core Version:    0.7.0.1
 */