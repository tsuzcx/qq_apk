package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.b.a;
import com.tencent.mm.al.a.b.a.b;
import com.tencent.mm.al.a.d.a;
import com.tencent.mm.al.a.d.a.b;
import com.tencent.mm.al.a.o;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.a.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.p;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI;
import com.tencent.mm.ui.s.a;

public class BizChatConversationUI
  extends BaseBizConversationUI
{
  private View contentView;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(33957);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.pluginsdk.h.a(this, this.contentView);
    AppMethodBeat.o(33957);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33956);
    super.onCreate(paramBundle);
    this.contentView = com.tencent.mm.ui.aa.jQ(this).inflate(2131493308, null);
    setContentView(this.contentView);
    this.conversationFm = new BizChatConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131304736, this.conversationFm).commit();
    com.tencent.mm.pluginsdk.h.a(this, this.contentView);
    AppMethodBeat.o(33956);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class BizChatConversationFmUI
    extends BaseConversationUI.BaseConversationFmUI
    implements p, MStorageEx.IOnStorageChange
  {
    private LinearLayout PaK;
    private b PaL;
    private com.tencent.mm.al.a.k PaM;
    private int PaN;
    private com.tencent.mm.al.d PaO;
    private b.a PaP;
    private d.a PaQ;
    private e.a PaR;
    private String dik;
    private TextView emptyTipTv;
    private boolean isCurrentActivity;
    private boolean isDeleteCancel;
    private ListView pli;
    private o.g plk;
    private String ppO;
    private int ppd;
    private int ppe;
    private long ppv;
    private com.tencent.mm.ui.base.q tipDialog;
    
    public BizChatConversationFmUI()
    {
      AppMethodBeat.i(33937);
      this.isDeleteCancel = false;
      this.PaN = 0;
      this.ppd = 0;
      this.ppe = 0;
      this.PaP = new b.a()
      {
        public final void a(b.a.b paramAnonymousb)
        {
          AppMethodBeat.i(232781);
          if ((paramAnonymousb != null) && (paramAnonymousb.iPF != null) && (BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this).equals(paramAnonymousb.iPF.field_brandUserName)))
          {
            Log.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).Np(paramAnonymousb.iPE);
            if (BizChatConversationUI.BizChatConversationFmUI.n(BizChatConversationUI.BizChatConversationFmUI.this)) {
              BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).anp();
            }
          }
          AppMethodBeat.o(232781);
        }
      };
      this.PaQ = new d.a()
      {
        public final void a(d.a.b paramAnonymousb)
        {
          AppMethodBeat.i(232782);
          if ((paramAnonymousb != null) && (paramAnonymousb.iPP != null) && (BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this).equals(paramAnonymousb.iPP.field_brandUserName)))
          {
            Log.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).Np(paramAnonymousb.iPE);
            if (BizChatConversationUI.BizChatConversationFmUI.n(BizChatConversationUI.BizChatConversationFmUI.this)) {
              BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).anp();
            }
          }
          AppMethodBeat.o(232782);
        }
      };
      this.PaR = new e.a()
      {
        public final void a(e.a.a paramAnonymousa)
        {
          AppMethodBeat.i(232783);
          String str = BizChatConversationUI.BizChatConversationFmUI.d(BizChatConversationUI.BizChatConversationFmUI.this);
          if ((paramAnonymousa != null) && (!Util.isNullOrNil(paramAnonymousa.iNV)) && (paramAnonymousa.iNV.equals(str)))
          {
            int i = BizChatConversationUI.BizChatConversationFmUI.o(BizChatConversationUI.BizChatConversationFmUI.this);
            BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this, com.tencent.mm.ui.h.cy(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), str));
            if (BizChatConversationUI.BizChatConversationFmUI.o(BizChatConversationUI.BizChatConversationFmUI.this) != i) {
              BizChatConversationUI.BizChatConversationFmUI.p(BizChatConversationUI.BizChatConversationFmUI.this);
            }
          }
          AppMethodBeat.o(232783);
        }
      };
      AppMethodBeat.o(33937);
    }
    
    private void Nq(long paramLong)
    {
      AppMethodBeat.i(33949);
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      this.ui.startChatting(this.ppO, localBundle, true);
      AppMethodBeat.o(33949);
    }
    
    private void gLZ()
    {
      AppMethodBeat.i(33946);
      String str1 = gMa();
      this.PaN = com.tencent.mm.ui.h.cy(getContext(), str1);
      Object localObject1;
      CdnImageView localCdnImageView;
      int i;
      Object localObject2;
      if ((this.PaN == 2) && (this.PaK == null))
      {
        this.PaK = ((LinearLayout)findViewById(2131297662));
        localObject1 = this.PaK.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.aG(getContext(), 2131165260);
        this.PaK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = com.tencent.mm.ui.aa.jQ(getContext()).inflate(2131494004, this.PaK, false);
        float f = com.tencent.mm.cb.a.ez(getContext());
        localCdnImageView = (CdnImageView)((View)localObject1).findViewById(2131302497);
        i = localCdnImageView.getLayoutParams().height;
        localCdnImageView.getLayoutParams().height = ((int)(i * f));
        localCdnImageView.getLayoutParams().width = ((int)(f * i));
        localCdnImageView.requestLayout();
        localObject2 = (TextView)((View)localObject1).findViewById(2131309249);
        ag.bar();
        ag.bar();
        String str2 = com.tencent.mm.al.e.sM(0);
        if ((str2 == null) || (str2.length() <= 0)) {
          break label332;
        }
        ((TextView)localObject2).setText(str2);
      }
      for (;;)
      {
        ag.bar();
        i = com.tencent.mm.al.e.aZC();
        if (i != 0) {
          ((TextView)localObject2).setTextColor(i);
        }
        ag.bar();
        localObject2 = com.tencent.mm.al.e.aZB();
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localCdnImageView.setUrl((String)localObject2);
        }
        this.PaK.addView((View)localObject1);
        ((View)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33927);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            com.tencent.mm.ui.h.s(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), BizChatConversationUI.BizChatConversationFmUI.d(BizChatConversationUI.BizChatConversationFmUI.this), 4);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33927);
          }
        });
        com.tencent.mm.ui.h.r(getContext(), this.ppO, 4);
        com.tencent.mm.ui.h.cz(getContext(), str1);
        if (this.PaK == null) {
          break label352;
        }
        if (this.PaN != 2) {
          break;
        }
        this.PaK.setVisibility(0);
        AppMethodBeat.o(33946);
        return;
        label332:
        ((TextView)localObject2).setText(2131758750);
      }
      this.PaK.setVisibility(8);
      label352:
      AppMethodBeat.o(33946);
    }
    
    private String gMa()
    {
      AppMethodBeat.i(33948);
      if (Util.isNullOrNil(this.dik)) {
        this.dik = ag.bah().MT(this.ppO).UN();
      }
      String str = this.dik;
      AppMethodBeat.o(33948);
      return str;
    }
    
    public final void a(int paramInt, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(33945);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (paramq.getType() == 1355)
      {
        paramq = ((o)paramq).baD();
        paramq = ag.baj().NE(paramq.Lpw.LPp.KTl);
        if (paramq == null)
        {
          Toast.makeText(MMApplicationContext.getContext(), getString(2131764672), 0).show();
          AppMethodBeat.o(33945);
          return;
        }
        Nq(paramq.field_bizChatLocalId);
      }
      AppMethodBeat.o(33945);
    }
    
    public int getLayoutId()
    {
      return 2131494003;
    }
    
    public String getUserName()
    {
      AppMethodBeat.i(33939);
      if (Util.isNullOrNil(this.dik))
      {
        str = this.ppO;
        AppMethodBeat.o(33939);
        return str;
      }
      String str = this.dik;
      AppMethodBeat.o(33939);
      return str;
    }
    
    public void onActivityCreated(final Bundle paramBundle)
    {
      AppMethodBeat.i(33938);
      super.onActivityCreated(paramBundle);
      this.ppO = thisActivity().getIntent().getStringExtra("Contact_User");
      Log.i("MicroMsg.BizChatConversationFmUI", "[registerListener]");
      ag.bak().a(this.PaP, thisActivity().getMainLooper());
      ag.baj().a(this.PaQ, thisActivity().getMainLooper());
      ag.bar().a(this.PaR, thisActivity().getMainLooper());
      bg.aVF();
      com.tencent.mm.model.c.aST().add(this);
      this.emptyTipTv = ((TextView)findViewById(2131300096));
      this.emptyTipTv.setText(2131762847);
      this.pli = ((ListView)findViewById(2131309254));
      try
      {
        gLZ();
        label142:
        this.PaL = new b(thisActivity(), new s.a()
        {
          public final void bnE()
          {
            AppMethodBeat.i(33934);
            BizChatConversationUI.BizChatConversationFmUI.this.setMMTitle(com.tencent.mm.model.aa.getDisplayName(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this)));
            if (BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getCount() <= 0)
            {
              BizChatConversationUI.BizChatConversationFmUI.i(BizChatConversationUI.BizChatConversationFmUI.this).setVisibility(0);
              BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).setVisibility(8);
              AppMethodBeat.o(33934);
              return;
            }
            BizChatConversationUI.BizChatConversationFmUI.i(BizChatConversationUI.BizChatConversationFmUI.this).setVisibility(8);
            if (BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this) != null) {
              BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).setVisibility(0);
            }
            AppMethodBeat.o(33934);
          }
        }, this.ppO);
        this.PaL.setGetViewPositionCallback(new MMSlideDelView.c()
        {
          public final int dr(View paramAnonymousView)
          {
            AppMethodBeat.i(33935);
            int i = BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).getPositionForView(paramAnonymousView);
            AppMethodBeat.o(33935);
            return i;
          }
        });
        this.PaL.setPerformItemClickListener(new MMSlideDelView.g()
        {
          public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(33936);
            BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(33936);
          }
        });
        this.PaL.a(new BizChatConversationUI.BizChatConversationFmUI.2(this));
        this.pli.setAdapter(this.PaL);
        this.plk = new BizChatConversationUI.BizChatConversationFmUI.14(this);
        paramBundle = new com.tencent.mm.ui.widget.b.a(thisActivity());
        this.pli.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(33931);
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, (int)paramAnonymousMotionEvent.getRawX());
              BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this, (int)paramAnonymousMotionEvent.getRawY());
            }
            AppMethodBeat.o(33931);
            return false;
          }
        });
        this.pli.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(33932);
            paramBundle.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizChatConversationUI.BizChatConversationFmUI.this, BizChatConversationUI.BizChatConversationFmUI.f(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.g(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.h(BizChatConversationUI.BizChatConversationFmUI.this));
            AppMethodBeat.o(33932);
            return true;
          }
        });
        this.pli.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(33933);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousAdapterView);
            localb.bm(paramAnonymousView);
            localb.pH(paramAnonymousInt);
            localb.zo(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
            paramAnonymousAdapterView = (com.tencent.mm.al.a.a)BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getItem(paramAnonymousInt);
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this, paramAnonymousAdapterView.field_bizChatId);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(33933);
          }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(33915);
            BizChatConversationUI.BizChatConversationFmUI.this.finish();
            AppMethodBeat.o(33915);
            return true;
          }
        });
        addIconOptionMenu(1, 2131766796, 2131689496, new BizChatConversationUI.BizChatConversationFmUI.4(this));
        addIconOptionMenu(2, 2131755152, 2131689491, new com.tencent.mm.ui.conversation.presenter.b(this.ui, gMa()));
        paramBundle = ag.bal().fC(this.ppO);
        this.PaM = ag.bal().fB(paramBundle);
        String str = this.ppO;
        boolean bool;
        if (this.PaM == null)
        {
          bool = true;
          Log.i("MicroMsg.BizChatConversationFmUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
          if ((Util.isNullOrNil(paramBundle)) || (this.PaM == null) || (this.PaM.bay()) || (Util.isNullOrNil(this.PaM.field_addMemberUrl)))
          {
            ag.baq();
            com.tencent.mm.al.a.h.a(this.ppO, this);
            paramBundle = thisActivity();
            getString(2131755998);
            this.tipDialog = com.tencent.mm.ui.base.h.a(paramBundle, getString(2131756029), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(232779);
                BizChatConversationUI.BizChatConversationFmUI.this.finish();
                AppMethodBeat.o(232779);
              }
            });
          }
          bg.aAk().postToWorkerDelayed(new BizChatConversationUI.BizChatConversationFmUI.9(this), 300L);
          paramBundle = gMa();
          if (paramBundle == null) {
            break label637;
          }
          ag.bar();
          com.tencent.mm.al.e.a(paramBundle, null);
          Log.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", new Object[] { paramBundle });
        }
        for (;;)
        {
          this.PaO = ag.bar().MO(gMa());
          Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
          {
            public final boolean queueIdle()
            {
              AppMethodBeat.i(33913);
              Object localObject = ag.bah().MT(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, ((com.tencent.mm.api.c)localObject).UN());
              int m = BizChatConversationUI.BizChatConversationFmUI.this.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
              int i = -1;
              if (BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this) != null) {
                i = BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getCount();
              }
              localObject = ag.bar().MO(BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this));
              int j;
              int k;
              label112:
              int n;
              long l1;
              if (localObject != null)
              {
                j = ((com.tencent.mm.al.d)localObject).field_qyUin;
                if (localObject == null) {
                  break label341;
                }
                k = ((com.tencent.mm.al.d)localObject).field_userUin;
                n = ag.bar().MQ(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
                if (localObject == null) {
                  break label346;
                }
                l1 = ((com.tencent.mm.al.d)localObject).field_wwCorpId;
                label139:
                if (localObject == null) {
                  break label352;
                }
              }
              label341:
              label346:
              label352:
              for (long l2 = ((com.tencent.mm.al.d)localObject).field_wwUserVid;; l2 = 0L)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(12648, new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
                Log.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
                AppMethodBeat.o(33913);
                return false;
                j = 0;
                break;
                k = 0;
                break label112;
                l1 = 0L;
                break label139;
              }
            }
          });
          paramBundle = thisActivity().getIntent();
          if (IntentUtil.getBooleanExtra(paramBundle, "biz_chat_need_to_jump_to_chatting_ui", false))
          {
            long l = paramBundle.getLongExtra("biz_chat_chat_id", -1L);
            if (l != -1L) {
              Nq(l);
            }
          }
          AppMethodBeat.o(33938);
          return;
          bool = false;
          break;
          label637:
          Log.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
        }
      }
      catch (NullPointerException paramBundle)
      {
        break label142;
      }
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
    {
      AppMethodBeat.i(33944);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(33944);
        return;
      }
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(33944);
        return;
      }
      paramIntent = paramIntent.getBundleExtra("result_data");
      Object localObject;
      bfs localbfs;
      if (paramIntent != null)
      {
        Log.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
        localObject = paramIntent.getString("enterprise_members");
        localbfs = new bfs();
        com.tencent.mm.al.a.c localc = new com.tencent.mm.al.a.c();
        if (this.PaM != null)
        {
          paramIntent = this.PaM.field_addMemberUrl;
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.ppO;
          if (!com.tencent.mm.al.a.e.a(localc, (String)localObject, null, localbfs)) {
            break label256;
          }
          if (localc.field_bizChatLocalId == -1L) {
            break label198;
          }
          Nq(localc.field_bizChatLocalId);
          paramInt1 = 1;
        }
      }
      for (;;)
      {
        if (paramInt1 == 0)
        {
          Toast.makeText(thisActivity(), getString(2131764672), 0).show();
          AppMethodBeat.o(33944);
          return;
          paramIntent = null;
          break;
          label198:
          ag.baq();
          paramIntent = com.tencent.mm.al.a.h.a(this.ppO, localbfs, this);
          localObject = thisActivity();
          getString(2131755998);
          this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, getString(2131756029), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(232776);
              ag.baq();
              com.tencent.mm.al.a.h.d(paramIntent);
              AppMethodBeat.o(232776);
            }
          });
          paramInt1 = 1;
          continue;
          label256:
          paramInt1 = 0;
          continue;
        }
        AppMethodBeat.o(33944);
        return;
        paramInt1 = 0;
      }
    }
    
    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(33943);
      paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenuInfo = (com.tencent.mm.al.a.a)this.PaL.getItem(paramView.position);
      this.ppv = paramContextMenuInfo.field_bizChatId;
      if (paramContextMenuInfo.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 1, 2131762838);
        ag.bak();
        if (!com.tencent.mm.al.a.b.c(paramContextMenuInfo)) {
          break label126;
        }
        paramContextMenu.add(paramView.position, 3, 2, 2131762839);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 0, 3, 2131762843);
        AppMethodBeat.o(33943);
        return;
        paramContextMenu.add(paramView.position, 2, 1, 2131762836);
        break;
        label126:
        paramContextMenu.add(paramView.position, 3, 2, 2131762837);
      }
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(33940);
      Log.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
      ag.bak().a(this.PaP);
      ag.baj().a(this.PaQ);
      ag.bar().a(this.PaR);
      if (bg.aAc())
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().remove(this);
      }
      this.PaL.ebf();
      this.PaL.onDestroy();
      super.onDestroy();
      AppMethodBeat.o(33940);
    }
    
    public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject) {}
    
    public void onPause()
    {
      AppMethodBeat.i(33942);
      Log.i("MicroMsg.BizChatConversationFmUI", "on pause");
      bg.aVF();
      com.tencent.mm.model.c.aST().bka(this.ppO);
      com.tencent.mm.al.a.b localb = ag.bak();
      String str = this.ppO;
      if (Util.isNullOrNil(str)) {
        Log.e("MicroMsg.BizConversationStorage", "brandUserName is null");
      }
      for (;;)
      {
        if (this.PaL != null) {
          this.PaL.onPause();
        }
        this.isCurrentActivity = false;
        bg.getNotification().CY("");
        super.onPause();
        AppMethodBeat.o(33942);
        return;
        str = "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'";
        Log.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", new Object[] { Boolean.valueOf(localb.db.execSQL("BizChatConversation", str)), str });
      }
    }
    
    public void onResume()
    {
      AppMethodBeat.i(33941);
      super.onResume();
      as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.ppO);
      if ((localas == null) || (!com.tencent.mm.contact.c.oR(localas.field_type)))
      {
        Log.w("MicroMsg.BizChatConversationFmUI", "onResume is not contact now");
        finish();
        AppMethodBeat.o(33941);
        return;
      }
      com.tencent.mm.api.c localc = com.tencent.mm.al.g.fJ(this.ppO);
      if ((localc == null) || (localc.field_enterpriseFather == null) || (!ab.IS(localc.field_enterpriseFather)))
      {
        Log.w("MicroMsg.BizChatConversationFmUI", "onResume enterpriseFather is invalid");
        finish();
        AppMethodBeat.o(33941);
        return;
      }
      if (localas.Zx()) {
        setTitleMuteIconVisibility(0);
      }
      for (;;)
      {
        this.isCurrentActivity = true;
        this.PaL.onNotifyChange(null, null);
        bg.getNotification().CY(this.ppO);
        AppMethodBeat.o(33941);
        return;
        setTitleMuteIconVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI
 * JD-Core Version:    0.7.0.1
 */