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
import com.tencent.mm.am.a.b.a;
import com.tencent.mm.am.a.b.a.b;
import com.tencent.mm.am.a.d.a.b;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.d.a.a;
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI;
import com.tencent.mm.ui.q.a;
import java.util.LinkedList;

public class BizChatConversationUI
  extends BaseBizConversationUI
{
  private View contentView;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(33957);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.pluginsdk.g.a(this, this.contentView);
    AppMethodBeat.o(33957);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33956);
    super.onCreate(paramBundle);
    this.contentView = com.tencent.mm.ui.y.js(this).inflate(2131493232, null);
    setContentView(this.contentView);
    this.conversationFm = new BizChatConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131302341, this.conversationFm).commit();
    com.tencent.mm.pluginsdk.g.a(this, this.contentView);
    AppMethodBeat.o(33956);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class BizChatConversationFmUI
    extends BaseConversationUI.BaseConversationFmUI
    implements com.tencent.mm.am.o, n.b
  {
    private LinearLayout Ghk;
    private b Ghl;
    private com.tencent.mm.am.a.k Ghm;
    private int Ghn;
    private com.tencent.mm.am.c Gho;
    private b.a Ghp;
    private com.tencent.mm.am.a.d.a Ghq;
    private com.tencent.mm.am.d.a Ghr;
    private String cIV;
    private TextView emptyTipTv;
    private boolean isCurrentActivity;
    private boolean isDeleteCancel;
    private ListView mRu;
    private n.d mRw;
    private int mUE;
    private int mUF;
    private long mUQ;
    private String mVj;
    private p tipDialog;
    
    public BizChatConversationFmUI()
    {
      AppMethodBeat.i(33937);
      this.isDeleteCancel = false;
      this.Ghn = 0;
      this.mUE = 0;
      this.mUF = 0;
      this.Ghp = new b.a()
      {
        public final void a(b.a.b paramAnonymousb)
        {
          AppMethodBeat.i(191441);
          if ((paramAnonymousb != null) && (paramAnonymousb.gYG != null) && (BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this).equals(paramAnonymousb.gYG.field_brandUserName)))
          {
            ad.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).wt(paramAnonymousb.gYF);
            if (BizChatConversationUI.BizChatConversationFmUI.n(BizChatConversationUI.BizChatConversationFmUI.this)) {
              BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).Wd();
            }
          }
          AppMethodBeat.o(191441);
        }
      };
      this.Ghq = new com.tencent.mm.am.a.d.a()
      {
        public final void a(d.a.b paramAnonymousb)
        {
          AppMethodBeat.i(191442);
          if ((paramAnonymousb != null) && (paramAnonymousb.gYQ != null) && (BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this).equals(paramAnonymousb.gYQ.field_brandUserName)))
          {
            ad.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).wt(paramAnonymousb.gYF);
            if (BizChatConversationUI.BizChatConversationFmUI.n(BizChatConversationUI.BizChatConversationFmUI.this)) {
              BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).Wd();
            }
          }
          AppMethodBeat.o(191442);
        }
      };
      this.Ghr = new com.tencent.mm.am.d.a()
      {
        public final void a(d.a.a paramAnonymousa)
        {
          AppMethodBeat.i(191443);
          String str = BizChatConversationUI.BizChatConversationFmUI.d(BizChatConversationUI.BizChatConversationFmUI.this);
          if ((paramAnonymousa != null) && (!bt.isNullOrNil(paramAnonymousa.gWU)) && (paramAnonymousa.gWU.equals(str)))
          {
            int i = BizChatConversationUI.BizChatConversationFmUI.o(BizChatConversationUI.BizChatConversationFmUI.this);
            BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this, com.tencent.mm.ui.g.ca(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), str));
            if (BizChatConversationUI.BizChatConversationFmUI.o(BizChatConversationUI.BizChatConversationFmUI.this) != i) {
              BizChatConversationUI.BizChatConversationFmUI.p(BizChatConversationUI.BizChatConversationFmUI.this);
            }
          }
          AppMethodBeat.o(191443);
        }
      };
      AppMethodBeat.o(33937);
    }
    
    private void eTO()
    {
      AppMethodBeat.i(33946);
      String str1 = eTP();
      this.Ghn = com.tencent.mm.ui.g.ca(getContext(), str1);
      Object localObject1;
      CdnImageView localCdnImageView;
      int i;
      Object localObject2;
      if ((this.Ghn == 2) && (this.Ghk == null))
      {
        this.Ghk = ((LinearLayout)findViewById(2131297432));
        localObject1 = this.Ghk.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.ao(getContext(), 2131165256);
        this.Ghk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = com.tencent.mm.ui.y.js(getContext()).inflate(2131493849, this.Ghk, false);
        float f = com.tencent.mm.cd.a.dT(getContext());
        localCdnImageView = (CdnImageView)((View)localObject1).findViewById(2131300891);
        i = localCdnImageView.getLayoutParams().height;
        localCdnImageView.getLayoutParams().height = ((int)(i * f));
        localCdnImageView.getLayoutParams().width = ((int)(f * i));
        localCdnImageView.requestLayout();
        localObject2 = (TextView)((View)localObject1).findViewById(2131305948);
        com.tencent.mm.am.af.awn();
        com.tencent.mm.am.af.awn();
        String str2 = com.tencent.mm.am.d.nG(0);
        if ((str2 == null) || (str2.length() <= 0)) {
          break label332;
        }
        ((TextView)localObject2).setText(str2);
      }
      for (;;)
      {
        com.tencent.mm.am.af.awn();
        i = com.tencent.mm.am.d.avy();
        if (i != 0) {
          ((TextView)localObject2).setTextColor(i);
        }
        com.tencent.mm.am.af.awn();
        localObject2 = com.tencent.mm.am.d.avx();
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localCdnImageView.setUrl((String)localObject2);
        }
        this.Ghk.addView((View)localObject1);
        ((View)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33927);
            com.tencent.mm.ui.g.u(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), BizChatConversationUI.BizChatConversationFmUI.d(BizChatConversationUI.BizChatConversationFmUI.this), 4);
            AppMethodBeat.o(33927);
          }
        });
        com.tencent.mm.ui.g.t(getContext(), this.mVj, 4);
        com.tencent.mm.ui.g.cb(getContext(), str1);
        if (this.Ghk == null) {
          break label352;
        }
        if (this.Ghn != 2) {
          break;
        }
        this.Ghk.setVisibility(0);
        AppMethodBeat.o(33946);
        return;
        label332:
        ((TextView)localObject2).setText(2131758452);
      }
      this.Ghk.setVisibility(8);
      label352:
      AppMethodBeat.o(33946);
    }
    
    private String eTP()
    {
      AppMethodBeat.i(33948);
      if (bt.isNullOrNil(this.cIV)) {
        this.cIV = com.tencent.mm.am.af.awe().wy(this.mVj).Jm();
      }
      String str = this.cIV;
      AppMethodBeat.o(33948);
      return str;
    }
    
    private void wu(long paramLong)
    {
      AppMethodBeat.i(33949);
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      this.ui.startChatting(this.mVj, localBundle, true);
      AppMethodBeat.o(33949);
    }
    
    public final void a(int paramInt, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(33945);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (paramn.getType() == 1355)
      {
        paramn = ((com.tencent.mm.am.a.o)paramn).awz();
        paramn = com.tencent.mm.am.af.awg().xj(paramn.DaY.DnW.CIJ);
        if (paramn == null)
        {
          Toast.makeText(aj.getContext(), getString(2131762592), 0).show();
          AppMethodBeat.o(33945);
          return;
        }
        wu(paramn.field_bizChatLocalId);
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
      if (bt.isNullOrNil(this.cIV))
      {
        str = this.mVj;
        AppMethodBeat.o(33939);
        return str;
      }
      String str = this.cIV;
      AppMethodBeat.o(33939);
      return str;
    }
    
    public void onActivityCreated(final Bundle paramBundle)
    {
      AppMethodBeat.i(33938);
      super.onActivityCreated(paramBundle);
      this.mVj = thisActivity().getIntent().getStringExtra("Contact_User");
      ad.i("MicroMsg.BizChatConversationFmUI", "[registerListener]");
      com.tencent.mm.am.af.awh().a(this.Ghp, thisActivity().getMainLooper());
      com.tencent.mm.am.af.awg().a(this.Ghq, thisActivity().getMainLooper());
      com.tencent.mm.am.af.awn().a(this.Ghr, thisActivity().getMainLooper());
      az.arV();
      com.tencent.mm.model.c.apR().a(this);
      this.emptyTipTv = ((TextView)findViewById(2131299468));
      this.emptyTipTv.setText(2131761061);
      this.mRu = ((ListView)findViewById(2131305951));
      try
      {
        eTO();
        label142:
        this.Ghl = new b(thisActivity(), new q.a()
        {
          public final void aIp()
          {
            AppMethodBeat.i(33934);
            BizChatConversationUI.BizChatConversationFmUI.this.setMMTitle(v.sh(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this)));
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
        }, this.mVj);
        this.Ghl.setGetViewPositionCallback(new MMSlideDelView.c()
        {
          public final int dw(View paramAnonymousView)
          {
            AppMethodBeat.i(33935);
            int i = BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).getPositionForView(paramAnonymousView);
            AppMethodBeat.o(33935);
            return i;
          }
        });
        this.Ghl.setPerformItemClickListener(new MMSlideDelView.g()
        {
          public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(33936);
            BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(33936);
          }
        });
        this.Ghl.a(new MMSlideDelView.f()
        {
          public final void cO(Object paramAnonymousObject)
          {
            AppMethodBeat.i(33914);
            if (paramAnonymousObject == null)
            {
              ad.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
              AppMethodBeat.o(33914);
              return;
            }
            AppMethodBeat.o(33914);
          }
        });
        this.mRu.setAdapter(this.Ghl);
        this.mRw = new n.d()
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
              paramAnonymousMenuItem = com.tencent.mm.am.af.awh().mf(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              paramAnonymousMenuItem.field_unReadCount = 1;
              paramAnonymousMenuItem.field_atCount = 0;
              paramAnonymousMenuItem.field_atAll = 0;
              com.tencent.mm.am.af.awh().b(paramAnonymousMenuItem);
              com.tencent.mm.modelstat.b.huc.U(paramAnonymousMenuItem.field_brandUserName, true);
              AppMethodBeat.o(33930);
              return;
              com.tencent.mm.am.af.awh().mh(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              paramAnonymousMenuItem = com.tencent.mm.am.af.awh().mf(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              com.tencent.mm.modelstat.b.huc.U(paramAnonymousMenuItem.field_brandUserName, false);
              AppMethodBeat.o(33930);
              return;
              paramAnonymousMenuItem = com.tencent.mm.am.af.awh().mf(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              if (com.tencent.mm.am.af.awh().mi(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this)))
              {
                com.tencent.mm.am.af.awh().mk(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
                com.tencent.mm.modelstat.b.huc.c(true, paramAnonymousMenuItem.field_brandUserName, false);
                AppMethodBeat.o(33930);
                return;
              }
              com.tencent.mm.am.af.awh().mj(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              com.tencent.mm.modelstat.b.huc.c(true, paramAnonymousMenuItem.field_brandUserName, true);
            }
          }
        };
        paramBundle = new com.tencent.mm.ui.widget.b.a(thisActivity());
        this.mRu.setOnTouchListener(new View.OnTouchListener()
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
        this.mRu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(33932);
            paramBundle.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizChatConversationUI.BizChatConversationFmUI.this, BizChatConversationUI.BizChatConversationFmUI.f(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.g(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.h(BizChatConversationUI.BizChatConversationFmUI.this));
            AppMethodBeat.o(33932);
            return true;
          }
        });
        this.mRu.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(33933);
            paramAnonymousAdapterView = (com.tencent.mm.am.a.a)BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getItem(paramAnonymousInt);
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this, paramAnonymousAdapterView.field_bizChatId);
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
            ad.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
            Object localObject = new Intent(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), BizChatSearchUI.class);
            ((Intent)localObject).putExtra("enterprise_biz_name", BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
            ((Intent)localObject).putExtra("biz_chat_search_scene", 1);
            ((Intent)localObject).putExtra("biz_chat_search_text", "");
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousMenuItem = BizChatConversationUI.BizChatConversationFmUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(33916);
            return true;
          }
        });
        addIconOptionMenu(2, 2131755134, 2131689489, new com.tencent.mm.ui.conversation.presenter.b(this.ui, eTP()));
        paramBundle = com.tencent.mm.am.af.awi().eb(this.mVj);
        this.Ghm = com.tencent.mm.am.af.awi().ea(paramBundle);
        String str = this.mVj;
        boolean bool;
        if (this.Ghm == null)
        {
          bool = true;
          ad.i("MicroMsg.BizChatConversationFmUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
          if ((bt.isNullOrNil(paramBundle)) || (this.Ghm == null) || (this.Ghm.awu()) || (bt.isNullOrNil(this.Ghm.field_addMemberUrl)))
          {
            com.tencent.mm.am.af.awm();
            com.tencent.mm.am.a.h.a(this.mVj, this);
            paramBundle = thisActivity();
            getString(2131755906);
            this.tipDialog = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(191439);
                BizChatConversationUI.BizChatConversationFmUI.this.finish();
                AppMethodBeat.o(191439);
              }
            });
          }
          az.afE().m(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(191440);
              ad.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
              LinkedList localLinkedList1 = new LinkedList();
              LinkedList localLinkedList2 = new LinkedList();
              Cursor localCursor = com.tencent.mm.am.af.awh().xg(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              if (localCursor.moveToFirst()) {
                while (!localCursor.isAfterLast())
                {
                  Object localObject = new com.tencent.mm.am.a.a();
                  ((com.tencent.mm.am.a.a)localObject).convertFrom(localCursor);
                  localCursor.moveToNext();
                  localObject = com.tencent.mm.am.af.awg().bg(((com.tencent.mm.am.a.a)localObject).field_bizChatId);
                  if (((com.tencent.mm.am.a.c)localObject).awu()) {
                    if (((com.tencent.mm.am.a.c)localObject).isGroup()) {
                      localLinkedList2.add(((com.tencent.mm.am.a.c)localObject).field_bizChatServId);
                    } else {
                      localLinkedList1.add(((com.tencent.mm.am.a.c)localObject).field_bizChatServId);
                    }
                  }
                }
              }
              localCursor.close();
              if (localLinkedList2.size() > 0) {
                com.tencent.mm.am.af.awm().a(localLinkedList2, BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              }
              BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, localLinkedList1);
              if (localLinkedList1.size() > 0) {
                com.tencent.mm.am.af.awm().b(localLinkedList1, BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              }
              AppMethodBeat.o(191440);
            }
          }, 300L);
          paramBundle = eTP();
          if (paramBundle == null) {
            break label637;
          }
          com.tencent.mm.am.af.awn();
          com.tencent.mm.am.d.a(paramBundle, null);
          ad.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", new Object[] { paramBundle });
        }
        for (;;)
        {
          this.Gho = com.tencent.mm.am.af.awn().wt(eTP());
          Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
          {
            public final boolean queueIdle()
            {
              AppMethodBeat.i(33913);
              Object localObject = com.tencent.mm.am.af.awe().wy(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, ((com.tencent.mm.api.c)localObject).Jm());
              int m = BizChatConversationUI.BizChatConversationFmUI.this.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
              int i = -1;
              if (BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this) != null) {
                i = BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getCount();
              }
              localObject = com.tencent.mm.am.af.awn().wt(BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this));
              int j;
              int k;
              label112:
              int n;
              long l1;
              if (localObject != null)
              {
                j = ((com.tencent.mm.am.c)localObject).field_qyUin;
                if (localObject == null) {
                  break label341;
                }
                k = ((com.tencent.mm.am.c)localObject).field_userUin;
                n = com.tencent.mm.am.af.awn().wv(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
                if (localObject == null) {
                  break label346;
                }
                l1 = ((com.tencent.mm.am.c)localObject).field_wwCorpId;
                label139:
                if (localObject == null) {
                  break label352;
                }
              }
              label341:
              label346:
              label352:
              for (long l2 = ((com.tencent.mm.am.c)localObject).field_wwUserVid;; l2 = 0L)
              {
                com.tencent.mm.plugin.report.service.h.vKh.f(12648, new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
                ad.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
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
          if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(paramBundle, "biz_chat_need_to_jump_to_chatting_ui", false))
          {
            long l = paramBundle.getLongExtra("biz_chat_chat_id", -1L);
            if (l != -1L) {
              wu(l);
            }
          }
          AppMethodBeat.o(33938);
          return;
          bool = false;
          break;
          label637:
          ad.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
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
      amv localamv;
      if (paramIntent != null)
      {
        ad.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
        localObject = paramIntent.getString("enterprise_members");
        localamv = new amv();
        com.tencent.mm.am.a.c localc = new com.tencent.mm.am.a.c();
        if (this.Ghm != null)
        {
          paramIntent = this.Ghm.field_addMemberUrl;
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.mVj;
          if (!com.tencent.mm.am.a.e.a(localc, (String)localObject, null, localamv)) {
            break label256;
          }
          if (localc.field_bizChatLocalId == -1L) {
            break label198;
          }
          wu(localc.field_bizChatLocalId);
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
          com.tencent.mm.am.af.awm();
          paramIntent = com.tencent.mm.am.a.h.a(this.mVj, localamv, this);
          localObject = thisActivity();
          getString(2131755906);
          this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(191436);
              com.tencent.mm.am.af.awm();
              com.tencent.mm.am.a.h.d(paramIntent);
              AppMethodBeat.o(191436);
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
      paramContextMenuInfo = (com.tencent.mm.am.a.a)this.Ghl.getItem(paramView.position);
      this.mUQ = paramContextMenuInfo.field_bizChatId;
      if (paramContextMenuInfo.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 0, 2131761052);
        com.tencent.mm.am.af.awh();
        if (!com.tencent.mm.am.a.b.c(paramContextMenuInfo)) {
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
      ad.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
      com.tencent.mm.am.af.awh().a(this.Ghp);
      com.tencent.mm.am.af.awg().a(this.Ghq);
      com.tencent.mm.am.af.awn().a(this.Ghr);
      if (az.afw())
      {
        az.arV();
        com.tencent.mm.model.c.apR().b(this);
      }
      this.Ghl.cHX();
      this.Ghl.onDestroy();
      super.onDestroy();
      AppMethodBeat.o(33940);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(33942);
      ad.i("MicroMsg.BizChatConversationFmUI", "on pause");
      az.arV();
      com.tencent.mm.model.c.apR().aIp(this.mVj);
      com.tencent.mm.am.a.b localb = com.tencent.mm.am.af.awh();
      String str = this.mVj;
      if (bt.isNullOrNil(str)) {
        ad.e("MicroMsg.BizConversationStorage", "brandUserName is null");
      }
      for (;;)
      {
        if (this.Ghl != null) {
          this.Ghl.onPause();
        }
        this.isCurrentActivity = false;
        az.getNotification().ou("");
        super.onPause();
        AppMethodBeat.o(33942);
        return;
        str = "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'";
        ad.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", new Object[] { Boolean.valueOf(localb.db.execSQL("BizChatConversation", str)), str });
      }
    }
    
    public void onResume()
    {
      AppMethodBeat.i(33941);
      super.onResume();
      com.tencent.mm.storage.af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.mVj);
      if ((localaf == null) || (!com.tencent.mm.n.b.ls(localaf.field_type)))
      {
        ad.w("MicroMsg.BizChatConversationFmUI", "onResume is not contact now");
        finish();
        AppMethodBeat.o(33941);
        return;
      }
      com.tencent.mm.api.c localc = f.ei(this.mVj);
      if ((localc == null) || (localc.field_enterpriseFather == null) || (!w.sD(localc.field_enterpriseFather)))
      {
        ad.w("MicroMsg.BizChatConversationFmUI", "onResume enterpriseFather is invalid");
        finish();
        AppMethodBeat.o(33941);
        return;
      }
      if (localaf.Ny()) {
        setTitleMuteIconVisibility(0);
      }
      for (;;)
      {
        this.isCurrentActivity = true;
        this.Ghl.a(null, null);
        az.getNotification().ou(this.mVj);
        AppMethodBeat.o(33941);
        return;
        setTitleMuteIconVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI
 * JD-Core Version:    0.7.0.1
 */