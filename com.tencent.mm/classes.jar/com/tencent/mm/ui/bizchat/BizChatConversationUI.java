package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;

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
    this.contentView = com.tencent.mm.ui.z.jV(this).inflate(2131493232, null);
    setContentView(this.contentView);
    this.conversationFm = new BizChatConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131302341, this.conversationFm).commit();
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
    implements com.tencent.mm.al.p, n.b
  {
    private LinearLayout JPF;
    private b JPH;
    private com.tencent.mm.al.a.k JPI;
    private int JPJ;
    private com.tencent.mm.al.d JPK;
    private b.a JPL;
    private d.a JPM;
    private e.a JPN;
    private String cRR;
    private TextView emptyTipTv;
    private boolean isCurrentActivity;
    private boolean isDeleteCancel;
    private ListView oam;
    private n.e oao;
    private String oeQ;
    private int oef;
    private int oeg;
    private long oex;
    private com.tencent.mm.ui.base.p tipDialog;
    
    public BizChatConversationFmUI()
    {
      AppMethodBeat.i(33937);
      this.isDeleteCancel = false;
      this.JPJ = 0;
      this.oef = 0;
      this.oeg = 0;
      this.JPL = new b.a()
      {
        public final void a(b.a.b paramAnonymousb)
        {
          AppMethodBeat.i(187097);
          if ((paramAnonymousb != null) && (paramAnonymousb.hUs != null) && (BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this).equals(paramAnonymousb.hUs.field_brandUserName)))
          {
            ae.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).El(paramAnonymousb.hUr);
            if (BizChatConversationUI.BizChatConversationFmUI.n(BizChatConversationUI.BizChatConversationFmUI.this)) {
              BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).ZD();
            }
          }
          AppMethodBeat.o(187097);
        }
      };
      this.JPM = new d.a()
      {
        public final void a(d.a.b paramAnonymousb)
        {
          AppMethodBeat.i(187098);
          if ((paramAnonymousb != null) && (paramAnonymousb.hUC != null) && (BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this).equals(paramAnonymousb.hUC.field_brandUserName)))
          {
            ae.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).El(paramAnonymousb.hUr);
            if (BizChatConversationUI.BizChatConversationFmUI.n(BizChatConversationUI.BizChatConversationFmUI.this)) {
              BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).ZD();
            }
          }
          AppMethodBeat.o(187098);
        }
      };
      this.JPN = new e.a()
      {
        public final void a(e.a.a paramAnonymousa)
        {
          AppMethodBeat.i(187099);
          String str = BizChatConversationUI.BizChatConversationFmUI.d(BizChatConversationUI.BizChatConversationFmUI.this);
          if ((paramAnonymousa != null) && (!bu.isNullOrNil(paramAnonymousa.hSG)) && (paramAnonymousa.hSG.equals(str)))
          {
            int i = BizChatConversationUI.BizChatConversationFmUI.o(BizChatConversationUI.BizChatConversationFmUI.this);
            BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this, com.tencent.mm.ui.g.ch(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), str));
            if (BizChatConversationUI.BizChatConversationFmUI.o(BizChatConversationUI.BizChatConversationFmUI.this) != i) {
              BizChatConversationUI.BizChatConversationFmUI.p(BizChatConversationUI.BizChatConversationFmUI.this);
            }
          }
          AppMethodBeat.o(187099);
        }
      };
      AppMethodBeat.o(33937);
    }
    
    private void Em(long paramLong)
    {
      AppMethodBeat.i(33949);
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      this.ui.startChatting(this.oeQ, localBundle, true);
      AppMethodBeat.o(33949);
    }
    
    private void fDS()
    {
      AppMethodBeat.i(33946);
      String str1 = fDT();
      this.JPJ = com.tencent.mm.ui.g.ch(getContext(), str1);
      Object localObject1;
      CdnImageView localCdnImageView;
      int i;
      Object localObject2;
      if ((this.JPJ == 2) && (this.JPF == null))
      {
        this.JPF = ((LinearLayout)findViewById(2131297432));
        localObject1 = this.JPF.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.ax(getContext(), 2131165256);
        this.JPF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = com.tencent.mm.ui.z.jV(getContext()).inflate(2131493849, this.JPF, false);
        float f = com.tencent.mm.cb.a.ef(getContext());
        localCdnImageView = (CdnImageView)((View)localObject1).findViewById(2131300891);
        i = localCdnImageView.getLayoutParams().height;
        localCdnImageView.getLayoutParams().height = ((int)(i * f));
        localCdnImageView.getLayoutParams().width = ((int)(f * i));
        localCdnImageView.requestLayout();
        localObject2 = (TextView)((View)localObject1).findViewById(2131305948);
        ag.aGy();
        ag.aGy();
        String str2 = com.tencent.mm.al.e.oY(0);
        if ((str2 == null) || (str2.length() <= 0)) {
          break label332;
        }
        ((TextView)localObject2).setText(str2);
      }
      for (;;)
      {
        ag.aGy();
        i = com.tencent.mm.al.e.aFK();
        if (i != 0) {
          ((TextView)localObject2).setTextColor(i);
        }
        ag.aGy();
        localObject2 = com.tencent.mm.al.e.aFJ();
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localCdnImageView.setUrl((String)localObject2);
        }
        this.JPF.addView((View)localObject1);
        ((View)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33927);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            com.tencent.mm.ui.g.t(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), BizChatConversationUI.BizChatConversationFmUI.d(BizChatConversationUI.BizChatConversationFmUI.this), 4);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33927);
          }
        });
        com.tencent.mm.ui.g.s(getContext(), this.oeQ, 4);
        com.tencent.mm.ui.g.ci(getContext(), str1);
        if (this.JPF == null) {
          break label352;
        }
        if (this.JPJ != 2) {
          break;
        }
        this.JPF.setVisibility(0);
        AppMethodBeat.o(33946);
        return;
        label332:
        ((TextView)localObject2).setText(2131758452);
      }
      this.JPF.setVisibility(8);
      label352:
      AppMethodBeat.o(33946);
    }
    
    private String fDT()
    {
      AppMethodBeat.i(33948);
      if (bu.isNullOrNil(this.cRR)) {
        this.cRR = ag.aGp().Ef(this.oeQ).KD();
      }
      String str = this.cRR;
      AppMethodBeat.o(33948);
      return str;
    }
    
    public final void a(int paramInt, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(33945);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (paramn.getType() == 1355)
      {
        paramn = ((o)paramn).aGK();
        paramn = ag.aGr().EQ(paramn.GtU.GLl.FZq);
        if (paramn == null)
        {
          Toast.makeText(ak.getContext(), getString(2131762592), 0).show();
          AppMethodBeat.o(33945);
          return;
        }
        Em(paramn.field_bizChatLocalId);
      }
      AppMethodBeat.o(33945);
    }
    
    public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject) {}
    
    public int getLayoutId()
    {
      return 2131493848;
    }
    
    public String getUserName()
    {
      AppMethodBeat.i(33939);
      if (bu.isNullOrNil(this.cRR))
      {
        str = this.oeQ;
        AppMethodBeat.o(33939);
        return str;
      }
      String str = this.cRR;
      AppMethodBeat.o(33939);
      return str;
    }
    
    public void onActivityCreated(final Bundle paramBundle)
    {
      AppMethodBeat.i(33938);
      super.onActivityCreated(paramBundle);
      this.oeQ = thisActivity().getIntent().getStringExtra("Contact_User");
      ae.i("MicroMsg.BizChatConversationFmUI", "[registerListener]");
      ag.aGs().a(this.JPL, thisActivity().getMainLooper());
      ag.aGr().a(this.JPM, thisActivity().getMainLooper());
      ag.aGy().a(this.JPN, thisActivity().getMainLooper());
      bc.aCg();
      com.tencent.mm.model.c.azL().a(this);
      this.emptyTipTv = ((TextView)findViewById(2131299468));
      this.emptyTipTv.setText(2131761061);
      this.oam = ((ListView)findViewById(2131305951));
      try
      {
        fDS();
        label142:
        this.JPH = new b(thisActivity(), new r.a()
        {
          public final void aSR()
          {
            AppMethodBeat.i(33934);
            BizChatConversationUI.BizChatConversationFmUI.this.setMMTitle(w.zP(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this)));
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
        }, this.oeQ);
        this.JPH.setGetViewPositionCallback(new MMSlideDelView.c()
        {
          public final int dA(View paramAnonymousView)
          {
            AppMethodBeat.i(33935);
            int i = BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).getPositionForView(paramAnonymousView);
            AppMethodBeat.o(33935);
            return i;
          }
        });
        this.JPH.setPerformItemClickListener(new MMSlideDelView.g()
        {
          public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(33936);
            BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(33936);
          }
        });
        this.JPH.a(new MMSlideDelView.f()
        {
          public final void cQ(Object paramAnonymousObject)
          {
            AppMethodBeat.i(33914);
            if (paramAnonymousObject == null)
            {
              ae.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
              AppMethodBeat.o(33914);
              return;
            }
            AppMethodBeat.o(33914);
          }
        });
        this.oam.setAdapter(this.JPH);
        this.oao = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(33930);
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(33930);
              return;
              BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              AppMethodBeat.o(33930);
              return;
              paramAnonymousMenuItem = ag.aGs().sf(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              paramAnonymousMenuItem.field_unReadCount = 1;
              paramAnonymousMenuItem.field_atCount = 0;
              paramAnonymousMenuItem.field_atAll = 0;
              ag.aGs().b(paramAnonymousMenuItem);
              com.tencent.mm.modelstat.b.iqT.V(paramAnonymousMenuItem.field_brandUserName, true);
              AppMethodBeat.o(33930);
              return;
              ag.aGs().sh(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              paramAnonymousMenuItem = ag.aGs().sf(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              com.tencent.mm.modelstat.b.iqT.V(paramAnonymousMenuItem.field_brandUserName, false);
              AppMethodBeat.o(33930);
              return;
              paramAnonymousMenuItem = ag.aGs().sf(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              if (ag.aGs().si(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this)))
              {
                ag.aGs().sk(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
                com.tencent.mm.modelstat.b.iqT.c(true, paramAnonymousMenuItem.field_brandUserName, false);
                AppMethodBeat.o(33930);
                return;
              }
              ag.aGs().sj(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              com.tencent.mm.modelstat.b.iqT.c(true, paramAnonymousMenuItem.field_brandUserName, true);
            }
          }
        };
        paramBundle = new com.tencent.mm.ui.widget.b.a(thisActivity());
        this.oam.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(33931);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, (int)paramAnonymousMotionEvent.getRawX());
              BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this, (int)paramAnonymousMotionEvent.getRawY());
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(33931);
            return false;
          }
        });
        this.oam.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(33932);
            paramBundle.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizChatConversationUI.BizChatConversationFmUI.this, BizChatConversationUI.BizChatConversationFmUI.f(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.g(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.h(BizChatConversationUI.BizChatConversationFmUI.this));
            AppMethodBeat.o(33932);
            return true;
          }
        });
        this.oam.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(33933);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousAdapterView);
            localb.bd(paramAnonymousView);
            localb.mu(paramAnonymousInt);
            localb.rl(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
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
        addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(33916);
            ae.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
            Object localObject = new Intent(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), BizChatSearchUI.class);
            ((Intent)localObject).putExtra("enterprise_biz_name", BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
            ((Intent)localObject).putExtra("biz_chat_search_scene", 1);
            ((Intent)localObject).putExtra("biz_chat_search_text", "");
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousMenuItem = BizChatConversationUI.BizChatConversationFmUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(33916);
            return true;
          }
        });
        addIconOptionMenu(2, 2131755134, 2131689489, new com.tencent.mm.ui.conversation.presenter.b(this.ui, fDT()));
        paramBundle = ag.aGt().eQ(this.oeQ);
        this.JPI = ag.aGt().eP(paramBundle);
        String str = this.oeQ;
        boolean bool;
        if (this.JPI == null)
        {
          bool = true;
          ae.i("MicroMsg.BizChatConversationFmUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
          if ((bu.isNullOrNil(paramBundle)) || (this.JPI == null) || (this.JPI.aGF()) || (bu.isNullOrNil(this.JPI.field_addMemberUrl)))
          {
            ag.aGx();
            com.tencent.mm.al.a.h.a(this.oeQ, this);
            paramBundle = thisActivity();
            getString(2131755906);
            this.tipDialog = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(187095);
                BizChatConversationUI.BizChatConversationFmUI.this.finish();
                AppMethodBeat.o(187095);
              }
            });
          }
          bc.ajU().n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187096);
              ae.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
              LinkedList localLinkedList1 = new LinkedList();
              LinkedList localLinkedList2 = new LinkedList();
              Cursor localCursor = ag.aGs().EN(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              if (localCursor.moveToFirst()) {
                while (!localCursor.isAfterLast())
                {
                  Object localObject = new com.tencent.mm.al.a.a();
                  ((com.tencent.mm.al.a.a)localObject).convertFrom(localCursor);
                  localCursor.moveToNext();
                  localObject = ag.aGr().bd(((com.tencent.mm.al.a.a)localObject).field_bizChatId);
                  if (((com.tencent.mm.al.a.c)localObject).aGF()) {
                    if (((com.tencent.mm.al.a.c)localObject).isGroup()) {
                      localLinkedList2.add(((com.tencent.mm.al.a.c)localObject).field_bizChatServId);
                    } else {
                      localLinkedList1.add(((com.tencent.mm.al.a.c)localObject).field_bizChatServId);
                    }
                  }
                }
              }
              localCursor.close();
              if (localLinkedList2.size() > 0) {
                ag.aGx().b(localLinkedList2, BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              }
              BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, localLinkedList1);
              if (localLinkedList1.size() > 0) {
                ag.aGx().c(localLinkedList1, BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              }
              AppMethodBeat.o(187096);
            }
          }, 300L);
          paramBundle = fDT();
          if (paramBundle == null) {
            break label637;
          }
          ag.aGy();
          com.tencent.mm.al.e.a(paramBundle, null);
          ae.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", new Object[] { paramBundle });
        }
        for (;;)
        {
          this.JPK = ag.aGy().Ea(fDT());
          Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
          {
            public final boolean queueIdle()
            {
              AppMethodBeat.i(33913);
              Object localObject = ag.aGp().Ef(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, ((com.tencent.mm.api.c)localObject).KD());
              int m = BizChatConversationUI.BizChatConversationFmUI.this.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
              int i = -1;
              if (BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this) != null) {
                i = BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getCount();
              }
              localObject = ag.aGy().Ea(BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this));
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
                n = ag.aGy().Ec(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
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
                com.tencent.mm.plugin.report.service.g.yxI.f(12648, new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
                ae.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
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
          if (com.tencent.mm.sdk.platformtools.z.getBooleanExtra(paramBundle, "biz_chat_need_to_jump_to_chatting_ui", false))
          {
            long l = paramBundle.getLongExtra("biz_chat_chat_id", -1L);
            if (l != -1L) {
              Em(l);
            }
          }
          AppMethodBeat.o(33938);
          return;
          bool = false;
          break;
          label637:
          ae.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
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
      auj localauj;
      if (paramIntent != null)
      {
        ae.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
        localObject = paramIntent.getString("enterprise_members");
        localauj = new auj();
        com.tencent.mm.al.a.c localc = new com.tencent.mm.al.a.c();
        if (this.JPI != null)
        {
          paramIntent = this.JPI.field_addMemberUrl;
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.oeQ;
          if (!com.tencent.mm.al.a.e.a(localc, (String)localObject, null, localauj)) {
            break label256;
          }
          if (localc.field_bizChatLocalId == -1L) {
            break label198;
          }
          Em(localc.field_bizChatLocalId);
          paramInt1 = 1;
        }
      }
      for (;;)
      {
        if (paramInt1 == 0)
        {
          Toast.makeText(thisActivity(), getString(2131762592), 0).show();
          AppMethodBeat.o(33944);
          return;
          paramIntent = null;
          break;
          label198:
          ag.aGx();
          paramIntent = com.tencent.mm.al.a.h.a(this.oeQ, localauj, this);
          localObject = thisActivity();
          getString(2131755906);
          this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(187092);
              ag.aGx();
              com.tencent.mm.al.a.h.d(paramIntent);
              AppMethodBeat.o(187092);
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
      paramContextMenuInfo = (com.tencent.mm.al.a.a)this.JPH.getItem(paramView.position);
      this.oex = paramContextMenuInfo.field_bizChatId;
      if (paramContextMenuInfo.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 0, 2131761052);
        ag.aGs();
        if (!com.tencent.mm.al.a.b.c(paramContextMenuInfo)) {
          break label126;
        }
        paramContextMenu.add(paramView.position, 3, 1, 2131761053);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 0, 2, 2131761057);
        AppMethodBeat.o(33943);
        return;
        paramContextMenu.add(paramView.position, 2, 0, 2131761050);
        break;
        label126:
        paramContextMenu.add(paramView.position, 3, 1, 2131761051);
      }
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(33940);
      ae.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
      ag.aGs().a(this.JPL);
      ag.aGr().a(this.JPM);
      ag.aGy().a(this.JPN);
      if (bc.ajM())
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().b(this);
      }
      this.JPH.dhl();
      this.JPH.onDestroy();
      super.onDestroy();
      AppMethodBeat.o(33940);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(33942);
      ae.i("MicroMsg.BizChatConversationFmUI", "on pause");
      bc.aCg();
      com.tencent.mm.model.c.azL().aVc(this.oeQ);
      com.tencent.mm.al.a.b localb = ag.aGs();
      String str = this.oeQ;
      if (bu.isNullOrNil(str)) {
        ae.e("MicroMsg.BizConversationStorage", "brandUserName is null");
      }
      for (;;)
      {
        if (this.JPH != null) {
          this.JPH.onPause();
        }
        this.isCurrentActivity = false;
        bc.getNotification().uI("");
        super.onPause();
        AppMethodBeat.o(33942);
        return;
        str = "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'";
        ae.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", new Object[] { Boolean.valueOf(localb.db.execSQL("BizChatConversation", str)), str });
      }
    }
    
    public void onResume()
    {
      AppMethodBeat.i(33941);
      super.onResume();
      an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.oeQ);
      if ((localan == null) || (!com.tencent.mm.contact.c.lO(localan.field_type)))
      {
        ae.w("MicroMsg.BizChatConversationFmUI", "onResume is not contact now");
        finish();
        AppMethodBeat.o(33941);
        return;
      }
      com.tencent.mm.api.c localc = com.tencent.mm.al.g.eX(this.oeQ);
      if ((localc == null) || (localc.field_enterpriseFather == null) || (!x.An(localc.field_enterpriseFather)))
      {
        ae.w("MicroMsg.BizChatConversationFmUI", "onResume enterpriseFather is invalid");
        finish();
        AppMethodBeat.o(33941);
        return;
      }
      if (localan.Pd()) {
        setTitleMuteIconVisibility(0);
      }
      for (;;)
      {
        this.isCurrentActivity = true;
        this.JPH.a(null, null);
        bc.getNotification().uI(this.oeQ);
        AppMethodBeat.o(33941);
        return;
        setTitleMuteIconVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI
 * JD-Core Version:    0.7.0.1
 */