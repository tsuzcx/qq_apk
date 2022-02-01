package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.f;
import com.tencent.mm.am.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.s;
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
    if (!com.tencent.mm.model.ba.ajx())
    {
      ad.e("MicroMsg.BizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(38270);
      return;
    }
    this.contentView = z.jO(this).inflate(2131493232, null);
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
    private ListView KrZ;
    private a Ksa;
    private String Ksb;
    private at conversation;
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
    
    public BizConversationFmUI()
    {
      AppMethodBeat.i(38258);
      this.dnh = 1;
      this.talker = "";
      this.obJ = 0L;
      this.nYw = 0;
      this.nYx = 0;
      this.tipDialog = null;
      this.isDeleteCancel = false;
      this.obh = new n.e()
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
            com.tencent.mm.model.ba.aBQ();
            paramAnonymousMenuItem = com.tencent.mm.model.c.azp().Bf(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
            if (paramAnonymousMenuItem == null)
            {
              ad.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
              AppMethodBeat.o(38244);
              return;
            }
            if (paramAnonymousMenuItem.adq())
            {
              com.tencent.mm.plugin.report.service.g.yhR.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
              w.E(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this), true);
              AppMethodBeat.o(38244);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
            w.D(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this), true);
            AppMethodBeat.o(38244);
            return;
            com.tencent.mm.model.ba.aBQ();
            paramAnonymousMenuItem = com.tencent.mm.model.c.azp().Bf(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
            com.tencent.mm.ui.tools.b.a(ag.aFZ().DD(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this)), BizConversationUI.BizConversationFmUI.this.thisActivity(), paramAnonymousMenuItem, 2);
            AppMethodBeat.o(38244);
            return;
            BizConversationUI.BizConversationFmUI.b(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
          }
        }
      };
      this.obZ = new BizConversationUI.BizConversationFmUI.10(this);
      AppMethodBeat.o(38258);
    }
    
    public int getLayoutId()
    {
      return 2131495762;
    }
    
    public String getUserName()
    {
      return this.hPO;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      AppMethodBeat.i(38259);
      super.onActivityCreated(paramBundle);
      this.hPO = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
      if (bt.isNullOrNil(this.hPO)) {
        this.hPO = "officialaccounts";
      }
      this.dnh = thisActivity().getIntent().getIntExtra("biz_enter_source", 1);
      if (bt.nullAsNil(this.hPO).equals("officialaccounts")) {
        com.tencent.mm.plugin.report.service.g.yhR.f(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.dnh), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      this.Ksb = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
      if (bt.isNullOrNil(this.Ksb)) {
        this.Ksb = getString(2131756578);
      }
      setMMTitle(this.Ksb);
      this.KrZ = ((ListView)findViewById(2131305951));
      this.emptyTipTv = ((TextView)findViewById(2131299468));
      this.emptyTipTv.setText(2131758419);
      setBackBtn(new BizConversationUI.BizConversationFmUI.13(this));
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38249);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38249);
        }
      });
      this.Ksa = new a(thisActivity(), this.hPO, new r.a()
      {
        public final void aSs()
        {
          AppMethodBeat.i(38250);
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getCount());
          AppMethodBeat.o(38250);
        }
      });
      this.Ksa.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
        {
          AppMethodBeat.i(38251);
          int i = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38251);
          return i;
        }
      });
      this.Ksa.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38252);
          BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(38252);
        }
      });
      this.KrZ.setAdapter(this.Ksa);
      this.nZK = new com.tencent.mm.ui.widget.b.a(thisActivity());
      this.KrZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38253);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, (at)BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getItem(paramAnonymousInt));
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this).field_username);
          paramAnonymousAdapterView = BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this);
          if (paramAnonymousAdapterView == null)
          {
            ad.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getCount()) });
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
      this.KrZ.setOnTouchListener(new BizConversationUI.BizConversationFmUI.2(this));
      this.KrZ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38237);
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, (at)BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getItem(paramAnonymousInt));
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this).field_username);
          BizConversationUI.BizConversationFmUI.j(BizConversationUI.BizConversationFmUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.g(BizConversationUI.BizConversationFmUI.this), BizConversationUI.BizConversationFmUI.h(BizConversationUI.BizConversationFmUI.this), BizConversationUI.BizConversationFmUI.i(BizConversationUI.BizConversationFmUI.this));
          AppMethodBeat.o(38237);
          return true;
        }
      });
      this.Ksa.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
        {
          AppMethodBeat.i(38238);
          int i = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38238);
          return i;
        }
      });
      this.Ksa.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38239);
          BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(38239);
        }
      });
      this.Ksa.a(new MMSlideDelView.f()
      {
        public final void cP(Object paramAnonymousObject)
        {
          AppMethodBeat.i(38240);
          if (paramAnonymousObject == null)
          {
            ad.e("MicroMsg.BizConversationUI", "onItemDel object null");
            AppMethodBeat.o(38240);
            return;
          }
          paramAnonymousObject = paramAnonymousObject.toString();
          BizConversationUI.BizConversationFmUI.b(BizConversationUI.BizConversationFmUI.this, paramAnonymousObject);
          AppMethodBeat.o(38240);
        }
      });
      if ("officialaccounts".equals(this.hPO))
      {
        paramBundle = com.tencent.mm.model.c.d.aDs().wz("100045");
        if ((!paramBundle.isValid()) || (!"1".equals(paramBundle.foF().get("isOpenSearch")))) {
          break label619;
        }
      }
      label619:
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.BizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          addIconOptionMenu(1, 2131764452, 2131689494, new BizConversationUI.BizConversationFmUI.1(this));
        }
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().a(this.Ksa);
        this.obJ = System.currentTimeMillis();
        com.tencent.mm.sdk.b.a.IbL.c(this.obZ);
        Looper.myQueue().addIdleHandler(new BizConversationUI.BizConversationFmUI.11(this));
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
      com.tencent.mm.model.ba.aBQ();
      am localam = com.tencent.mm.model.c.azp().Bf(this.talker);
      if (localam == null)
      {
        ad.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
        AppMethodBeat.o(38264);
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
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(thisActivity(), paramView));
      if (com.tencent.mm.o.b.lM(localam.field_type))
      {
        if (!localam.adq()) {
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
      com.tencent.mm.model.ba.ajF().ay(new Runnable()
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
      com.tencent.mm.sdk.b.a.IbL.d(this.obZ);
      if (com.tencent.mm.model.ba.ajx())
      {
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().b(this.Ksa);
      }
      if (this.Ksa != null) {
        this.Ksa.onDestroy();
      }
      super.onDestroy();
      AppMethodBeat.o(38260);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(38262);
      ad.i("MicroMsg.BizConversationUI", "on pause");
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().aTB(this.hPO);
      if (this.Ksa != null) {
        this.Ksa.onPause();
      }
      super.onPause();
      AppMethodBeat.o(38262);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(38261);
      ad.v("MicroMsg.BizConversationUI", "on resume");
      if (this.Ksa != null) {
        this.Ksa.onResume();
      }
      super.onResume();
      AppMethodBeat.o(38261);
    }
    
    static final class a
      extends e
    {
      private String dCB;
      HashMap<String, BizConversationUI.BizConversationFmUI.b> obm;
      
      public a(Context paramContext, String paramString, r.a parama)
      {
        super(parama);
        AppMethodBeat.i(38254);
        this.dCB = paramString;
        this.obm = new HashMap();
        AppMethodBeat.o(38254);
      }
      
      public final void Zu()
      {
        AppMethodBeat.i(38255);
        com.tencent.mm.model.ba.aBQ();
        setCursor(com.tencent.mm.model.c.azv().c(w.hFd, this.fSL, this.dCB));
        if (this.JaF != null) {
          this.JaF.aSs();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38255);
      }
      
      public final void a(at paramat, int paramInt)
      {
        AppMethodBeat.i(38257);
        com.tencent.mm.model.ba.aBQ();
        a(paramat, com.tencent.mm.model.c.azv().h(paramat), paramInt, true);
        AppMethodBeat.o(38257);
      }
      
      protected final void a(at paramat, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
      {
        AppMethodBeat.i(38256);
        if (paramat == null)
        {
          AppMethodBeat.o(38256);
          return;
        }
        BizConversationUI.BizConversationFmUI.b localb = (BizConversationUI.BizConversationFmUI.b)this.obm.get(paramat.field_username);
        if (localb == null)
        {
          localb = new BizConversationUI.BizConversationFmUI.b((byte)0);
          this.obm.put(paramat.field_username, localb);
        }
        for (;;)
        {
          if (localb.imT > 0)
          {
            AppMethodBeat.o(38256);
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
            AppMethodBeat.o(38256);
            return;
          }
          localb.seq = paramat.field_lastSeq;
          paramat = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().apX(paramat.field_username);
          if ((paramat != null) && (paramat.fpd()))
          {
            paramat = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramat.field_msgId, paramat.field_content);
            if ((paramat != null) && (!bt.hj(paramat.hDb)) && (!bt.isNullOrNil(((v)paramat.hDb.get(0)).url))) {
              try
              {
                paramat = Uri.parse(((v)paramat.hDb.get(0)).url);
                localb.HlH = bt.getLong(paramat.getQueryParameter("mid"), 0L);
                localb.HlI = bt.getInt(paramat.getQueryParameter("idx"), 0);
                AppMethodBeat.o(38256);
                return;
              }
              catch (UnsupportedOperationException paramat)
              {
                ad.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramat.getMessage() });
                AppMethodBeat.o(38256);
                return;
              }
              catch (Exception paramat)
              {
                ad.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramat.getMessage() });
              }
            }
          }
          AppMethodBeat.o(38256);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI
 * JD-Core Version:    0.7.0.1
 */