package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.k;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s.a;
import java.util.HashMap;
import java.util.LinkedList;

public class BizConversationUI
  extends BaseConversationUI
{
  private View contentView;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38271);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.pluginsdk.h.a(this, this.contentView);
    AppMethodBeat.o(38271);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38270);
    super.onCreate(paramBundle);
    if (!bg.aAc())
    {
      Log.e("MicroMsg.BizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(38270);
      return;
    }
    this.contentView = aa.jQ(this).inflate(2131493308, null);
    setContentView(this.contentView);
    this.conversationFm = new BizConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131304736, this.conversationFm).commit();
    com.tencent.mm.pluginsdk.h.a(this, this.contentView);
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
    private ListView Qbt;
    private a Qbu;
    private String Qbv;
    private az conversation;
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
    private q tipDialog;
    
    public BizConversationFmUI()
    {
      AppMethodBeat.i(38258);
      this.source = 1;
      this.talker = "";
      this.pss = 0L;
      this.ppd = 0;
      this.ppe = 0;
      this.tipDialog = null;
      this.isDeleteCancel = false;
      this.pso = new o.g()
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
            bg.aVF();
            paramAnonymousMenuItem = com.tencent.mm.model.c.aSN().Kn(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
            if (paramAnonymousMenuItem == null)
            {
              Log.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
              AppMethodBeat.o(38244);
              return;
            }
            if (paramAnonymousMenuItem.arE())
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
              ab.F(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this), true);
              AppMethodBeat.o(38244);
              return;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
            ab.E(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this), true);
            AppMethodBeat.o(38244);
            return;
            bg.aVF();
            paramAnonymousMenuItem = com.tencent.mm.model.c.aSN().Kn(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
            com.tencent.mm.ui.tools.b.a(ag.bah().MT(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this)), BizConversationUI.BizConversationFmUI.this.thisActivity(), paramAnonymousMenuItem, 2);
            AppMethodBeat.o(38244);
            return;
            BizConversationUI.BizConversationFmUI.b(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
            AppMethodBeat.o(38244);
            return;
            com.tencent.mm.ui.g.c(BizConversationUI.BizConversationFmUI.this.thisActivity(), new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(234099);
                bg.aVF();
                com.tencent.mm.model.c.aST().bjY(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.this));
                AppMethodBeat.o(234099);
              }
            });
          }
        }
      };
      this.ptp = new BizConversationUI.BizConversationFmUI.10(this);
      AppMethodBeat.o(38258);
    }
    
    public int getLayoutId()
    {
      return 2131496720;
    }
    
    public String getUserName()
    {
      return this.iNV;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      AppMethodBeat.i(38259);
      super.onActivityCreated(paramBundle);
      this.iNV = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
      if (Util.isNullOrNil(this.iNV)) {
        this.iNV = "officialaccounts";
      }
      this.source = thisActivity().getIntent().getIntExtra("biz_enter_source", 1);
      if (Util.nullAsNil(this.iNV).equals("officialaccounts")) {
        com.tencent.mm.plugin.report.service.h.CyF.a(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.source), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      this.Qbv = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
      if (Util.isNullOrNil(this.Qbv)) {
        this.Qbv = getString(2131756714);
      }
      setMMTitle(this.Qbv);
      this.Qbt = ((ListView)findViewById(2131309254));
      this.emptyTipTv = ((TextView)findViewById(2131300096));
      this.emptyTipTv.setText(2131758714);
      setBackBtn(new BizConversationUI.BizConversationFmUI.13(this));
      setToTop(new BizConversationUI.BizConversationFmUI.14(this));
      this.Qbu = new a(thisActivity(), this.iNV, new s.a()
      {
        public final void bnE()
        {
          AppMethodBeat.i(38250);
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getCount());
          AppMethodBeat.o(38250);
        }
      });
      this.Qbu.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dr(View paramAnonymousView)
        {
          AppMethodBeat.i(38251);
          int i = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38251);
          return i;
        }
      });
      this.Qbu.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38252);
          BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(38252);
        }
      });
      this.Qbt.setAdapter(this.Qbu);
      this.pqr = new com.tencent.mm.ui.widget.b.a(thisActivity());
      this.Qbt.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38253);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, (az)BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getItem(paramAnonymousInt));
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this).field_username);
          paramAnonymousAdapterView = BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this);
          if (paramAnonymousAdapterView == null)
          {
            Log.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getCount()) });
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
      this.Qbt.setOnTouchListener(new BizConversationUI.BizConversationFmUI.2(this));
      this.Qbt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38237);
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, (az)BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getItem(paramAnonymousInt));
          BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this).field_username);
          BizConversationUI.BizConversationFmUI.j(BizConversationUI.BizConversationFmUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.g(BizConversationUI.BizConversationFmUI.this), BizConversationUI.BizConversationFmUI.h(BizConversationUI.BizConversationFmUI.this), BizConversationUI.BizConversationFmUI.i(BizConversationUI.BizConversationFmUI.this));
          AppMethodBeat.o(38237);
          return true;
        }
      });
      this.Qbu.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dr(View paramAnonymousView)
        {
          AppMethodBeat.i(38238);
          int i = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38238);
          return i;
        }
      });
      this.Qbu.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38239);
          BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(38239);
        }
      });
      this.Qbu.a(new MMSlideDelView.f()
      {
        public final void cZ(Object paramAnonymousObject)
        {
          AppMethodBeat.i(38240);
          if (paramAnonymousObject == null)
          {
            Log.e("MicroMsg.BizConversationUI", "onItemDel object null");
            AppMethodBeat.o(38240);
            return;
          }
          paramAnonymousObject = paramAnonymousObject.toString();
          BizConversationUI.BizConversationFmUI.b(BizConversationUI.BizConversationFmUI.this, paramAnonymousObject);
          AppMethodBeat.o(38240);
        }
      });
      if ("officialaccounts".equals(this.iNV))
      {
        paramBundle = com.tencent.mm.plugin.bizui.a.a.pfC;
        boolean bool = com.tencent.mm.plugin.bizui.a.a.ckz();
        Log.d("MicroMsg.BizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          addIconOptionMenu(1, 2131766796, 2131689496, new BizConversationUI.BizConversationFmUI.1(this));
        }
      }
      bg.aVF();
      com.tencent.mm.model.c.aST().add(this.Qbu);
      this.pss = System.currentTimeMillis();
      EventCenter.instance.addListener(this.ptp);
      Looper.myQueue().addIdleHandler(new BizConversationUI.BizConversationFmUI.11(this));
      AppMethodBeat.o(38259);
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
      bg.aVF();
      as localas = com.tencent.mm.model.c.aSN().Kn(this.talker);
      if (localas == null)
      {
        Log.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
        AppMethodBeat.o(38264);
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
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(thisActivity(), paramView));
      if (com.tencent.mm.contact.c.oR(localas.field_type))
      {
        if (!localas.arE()) {
          break label208;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131762839);
      }
      for (;;)
      {
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131762835);
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131762843);
        AppMethodBeat.o(38264);
        return;
        label208:
        paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131758117);
      }
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(38260);
      bg.aAk().postToWorker(new Runnable()
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
      EventCenter.instance.removeListener(this.ptp);
      if (bg.aAc())
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().remove(this.Qbu);
      }
      if (this.Qbu != null) {
        this.Qbu.onDestroy();
      }
      super.onDestroy();
      AppMethodBeat.o(38260);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(38262);
      Log.i("MicroMsg.BizConversationUI", "on pause");
      bg.aVF();
      com.tencent.mm.model.c.aST().bka(this.iNV);
      if (this.Qbu != null) {
        this.Qbu.onPause();
      }
      super.onPause();
      AppMethodBeat.o(38262);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(38261);
      Log.v("MicroMsg.BizConversationUI", "on resume");
      if (this.Qbu != null) {
        this.Qbu.onResume();
      }
      super.onResume();
      AppMethodBeat.o(38261);
    }
    
    static final class a
      extends e
    {
      private String dVu;
      HashMap<String, BizConversationUI.BizConversationFmUI.b> pyQ;
      
      public a(Context paramContext, String paramString, s.a parama)
      {
        super(parama);
        AppMethodBeat.i(38254);
        this.dVu = paramString;
        this.pyQ = new HashMap();
        AppMethodBeat.o(38254);
      }
      
      public final void a(az paramaz, int paramInt)
      {
        AppMethodBeat.i(38257);
        bg.aVF();
        a(paramaz, com.tencent.mm.model.c.aST().h(paramaz), paramInt, true);
        AppMethodBeat.o(38257);
      }
      
      protected final void a(az paramaz, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
      {
        AppMethodBeat.i(38256);
        if (paramaz == null)
        {
          AppMethodBeat.o(38256);
          return;
        }
        BizConversationUI.BizConversationFmUI.b localb = (BizConversationUI.BizConversationFmUI.b)this.pyQ.get(paramaz.field_username);
        if (localb == null)
        {
          localb = new BizConversationUI.BizConversationFmUI.b((byte)0);
          this.pyQ.put(paramaz.field_username, localb);
        }
        for (;;)
        {
          if (localb.jkU > 0)
          {
            AppMethodBeat.o(38256);
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
            AppMethodBeat.o(38256);
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
                AppMethodBeat.o(38256);
                return;
              }
              catch (UnsupportedOperationException paramaz)
              {
                Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramaz.getMessage() });
                AppMethodBeat.o(38256);
                return;
              }
              catch (Exception paramaz)
              {
                Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramaz.getMessage() });
              }
            }
          }
          AppMethodBeat.o(38256);
          return;
        }
      }
      
      public final void anp()
      {
        AppMethodBeat.i(38255);
        bg.aVF();
        setCursor(com.tencent.mm.model.c.aST().c(ab.iCF, this.gzY, this.dVu));
        if (this.OFI != null) {
          this.OFI.bnE();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38255);
      }
    }
    
    static final class b
      extends dna
    {
      public int jkU = -1;
      public long seq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI
 * JD-Core Version:    0.7.0.1
 */