package com.tencent.mm.ui.bizchat;

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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.a.b.a;
import com.tencent.mm.an.a.b.a.b;
import com.tencent.mm.an.a.d.a;
import com.tencent.mm.an.a.d.a.b;
import com.tencent.mm.an.a.l;
import com.tencent.mm.an.a.o;
import com.tencent.mm.an.e.a;
import com.tencent.mm.an.e.a.a;
import com.tencent.mm.an.f;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI;
import com.tencent.mm.ui.i;
import com.tencent.mm.ui.x.a;
import java.util.LinkedList;

public class BizChatConversationUI
  extends BaseBizConversationUI
{
  private View contentView;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(33957);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.pluginsdk.h.b(this, this.contentView);
    AppMethodBeat.o(33957);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33956);
    super.onCreate(paramBundle);
    this.contentView = com.tencent.mm.ui.af.mU(this).inflate(R.i.geL, null);
    setContentView(this.contentView);
    this.conversationFm = new BizChatConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(R.h.fOk, this.conversationFm).FW();
    com.tencent.mm.pluginsdk.h.b(this, this.contentView);
    AppMethodBeat.o(33956);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class BizChatConversationFmUI
    extends BaseConversationUI.BaseConversationFmUI
    implements com.tencent.mm.an.p, MStorageEx.IOnStorageChange
  {
    private LinearLayout aebp;
    private b aebq;
    private com.tencent.mm.an.a.k aebr;
    private int aebs;
    private com.tencent.mm.an.d aebt;
    private b.a aebu;
    private d.a aebv;
    private e.a aebw;
    private TextView emptyTipTv;
    private String hds;
    private boolean isCurrentActivity;
    private boolean isDeleteCancel;
    private w tipDialog;
    private long vEb;
    private String vEu;
    private ListView vzp;
    private u.i vzr;
    private int x_down;
    private int y_down;
    
    public BizChatConversationFmUI()
    {
      AppMethodBeat.i(33937);
      this.isDeleteCancel = false;
      this.aebs = 0;
      this.x_down = 0;
      this.y_down = 0;
      this.aebu = new b.a()
      {
        public final void a(b.a.b paramAnonymousb)
        {
          AppMethodBeat.i(250747);
          if ((paramAnonymousb != null) && (paramAnonymousb.oxC != null) && (BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this).equals(paramAnonymousb.oxC.field_brandUserName)))
          {
            Log.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).zF(paramAnonymousb.oxB);
            if (BizChatConversationUI.BizChatConversationFmUI.n(BizChatConversationUI.BizChatConversationFmUI.this)) {
              BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).aNy();
            }
          }
          AppMethodBeat.o(250747);
        }
      };
      this.aebv = new d.a()
      {
        public final void a(d.a.b paramAnonymousb)
        {
          AppMethodBeat.i(250746);
          if ((paramAnonymousb != null) && (paramAnonymousb.oxM != null) && (BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this).equals(paramAnonymousb.oxM.field_brandUserName)))
          {
            Log.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).zF(paramAnonymousb.oxB);
            if (BizChatConversationUI.BizChatConversationFmUI.n(BizChatConversationUI.BizChatConversationFmUI.this)) {
              BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).aNy();
            }
          }
          AppMethodBeat.o(250746);
        }
      };
      this.aebw = new e.a()
      {
        public final void a(e.a.a paramAnonymousa)
        {
          AppMethodBeat.i(250742);
          String str = BizChatConversationUI.BizChatConversationFmUI.d(BizChatConversationUI.BizChatConversationFmUI.this);
          if ((paramAnonymousa != null) && (!Util.isNullOrNil(paramAnonymousa.ovT)) && (paramAnonymousa.ovT.equals(str)))
          {
            int i = BizChatConversationUI.BizChatConversationFmUI.o(BizChatConversationUI.BizChatConversationFmUI.this);
            BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this, i.cT(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), str));
            if (BizChatConversationUI.BizChatConversationFmUI.o(BizChatConversationUI.BizChatConversationFmUI.this) != i) {
              BizChatConversationUI.BizChatConversationFmUI.p(BizChatConversationUI.BizChatConversationFmUI.this);
            }
          }
          AppMethodBeat.o(250742);
        }
      };
      AppMethodBeat.o(33937);
    }
    
    private void jnJ()
    {
      AppMethodBeat.i(33946);
      String str1 = jnK();
      this.aebs = i.cT(getContext(), str1);
      Object localObject1;
      CdnImageView localCdnImageView;
      int i;
      Object localObject2;
      if ((this.aebs == 2) && (this.aebp == null))
      {
        this.aebp = ((LinearLayout)findViewById(R.h.bottom_bar));
        localObject1 = this.aebp.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.br(getContext(), R.f.DefaultTabbarHeight);
        this.aebp.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = com.tencent.mm.ui.af.mU(getContext()).inflate(R.i.enterprise_wework_view, this.aebp, false);
        float f = com.tencent.mm.cd.a.getScaleSize(getContext());
        localCdnImageView = (CdnImageView)((View)localObject1).findViewById(R.h.icon_iv);
        i = localCdnImageView.getLayoutParams().height;
        localCdnImageView.getLayoutParams().height = ((int)(i * f));
        localCdnImageView.getLayoutParams().width = ((int)(f * i));
        localCdnImageView.requestLayout();
        localObject2 = (TextView)((View)localObject1).findViewById(R.h.title_tv);
        com.tencent.mm.an.af.bHq();
        com.tencent.mm.an.af.bHq();
        String str2 = com.tencent.mm.an.e.vO(0);
        if ((str2 == null) || (str2.length() <= 0)) {
          break label332;
        }
        ((TextView)localObject2).setText(str2);
      }
      for (;;)
      {
        com.tencent.mm.an.af.bHq();
        i = com.tencent.mm.an.e.bGC();
        if (i != 0) {
          ((TextView)localObject2).setTextColor(i);
        }
        com.tencent.mm.an.af.bHq();
        localObject2 = com.tencent.mm.an.e.bGB();
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localCdnImageView.setUrl((String)localObject2);
        }
        this.aebp.addView((View)localObject1);
        ((View)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33927);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            i.w(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), BizChatConversationUI.BizChatConversationFmUI.d(BizChatConversationUI.BizChatConversationFmUI.this), 4);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33927);
          }
        });
        i.v(getContext(), this.vEu, 4);
        i.cU(getContext(), str1);
        if (this.aebp == null) {
          break label352;
        }
        if (this.aebs != 2) {
          break;
        }
        this.aebp.setVisibility(0);
        AppMethodBeat.o(33946);
        return;
        label332:
        ((TextView)localObject2).setText(R.l.enterprise_wework_create_chat);
      }
      this.aebp.setVisibility(8);
      label352:
      AppMethodBeat.o(33946);
    }
    
    private String jnK()
    {
      AppMethodBeat.i(33948);
      if (Util.isNullOrNil(this.hds))
      {
        localObject = com.tencent.mm.an.af.bHf().Mn(this.vEu);
        if (localObject != null) {
          this.hds = ((com.tencent.mm.api.c)localObject).aAX();
        }
      }
      Object localObject = this.hds;
      AppMethodBeat.o(33948);
      return localObject;
    }
    
    private void zG(long paramLong)
    {
      AppMethodBeat.i(33949);
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      this.ui.startChatting(this.vEu, localBundle, true);
      AppMethodBeat.o(33949);
    }
    
    public final void a(int paramInt, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(33945);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (paramp.getType() == 1355)
      {
        paramp = ((o)paramp).bHE();
        paramp = com.tencent.mm.an.af.bHh().MZ(paramp.ZpT.aajx.YRJ);
        if (paramp == null)
        {
          Toast.makeText(MMApplicationContext.getContext(), getString(R.l.gTv), 0).show();
          AppMethodBeat.o(33945);
          return;
        }
        zG(paramp.field_bizChatLocalId);
      }
      AppMethodBeat.o(33945);
    }
    
    public int getLayoutId()
    {
      return R.i.enterprise_conversation;
    }
    
    public String getUserName()
    {
      AppMethodBeat.i(33939);
      if (Util.isNullOrNil(this.hds))
      {
        str = this.vEu;
        AppMethodBeat.o(33939);
        return str;
      }
      String str = this.hds;
      AppMethodBeat.o(33939);
      return str;
    }
    
    public void onActivityCreated(final Bundle paramBundle)
    {
      AppMethodBeat.i(33938);
      super.onActivityCreated(paramBundle);
      this.vEu = thisActivity().getIntent().getStringExtra("Contact_User");
      Log.i("MicroMsg.BizChatConversationFmUI", "[registerListener]");
      com.tencent.mm.an.af.bHi().a(this.aebu, thisActivity().getMainLooper());
      com.tencent.mm.an.af.bHh().a(this.aebv, thisActivity().getMainLooper());
      com.tencent.mm.an.af.bHq().a(this.aebw, thisActivity().getMainLooper());
      bh.bCz();
      com.tencent.mm.model.c.bzG().add(this);
      this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
      this.emptyTipTv.setText(R.l.gNl);
      this.vzp = ((ListView)findViewById(R.h.tmessage_lv));
      try
      {
        jnJ();
        label142:
        this.aebq = new b(thisActivity(), new x.a()
        {
          public final void bWC()
          {
            AppMethodBeat.i(33934);
            BizChatConversationUI.BizChatConversationFmUI.this.setMMTitle(aa.getDisplayName(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this)));
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
        }, this.vEu);
        this.aebq.setGetViewPositionCallback(new MMSlideDelView.c()
        {
          public final int eB(View paramAnonymousView)
          {
            AppMethodBeat.i(33935);
            int i = BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).getPositionForView(paramAnonymousView);
            AppMethodBeat.o(33935);
            return i;
          }
        });
        this.aebq.setPerformItemClickListener(new MMSlideDelView.g()
        {
          public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(33936);
            BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(33936);
          }
        });
        this.aebq.a(new MMSlideDelView.f()
        {
          public final void es(Object paramAnonymousObject)
          {
            AppMethodBeat.i(33914);
            if (paramAnonymousObject == null)
            {
              Log.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
              AppMethodBeat.o(33914);
              return;
            }
            AppMethodBeat.o(33914);
          }
        });
        this.vzp.setAdapter(this.aebq);
        this.vzr = new u.i()
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
              com.tencent.mm.ui.h.c(BizChatConversationUI.BizChatConversationFmUI.this.thisActivity(), new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(250767);
                  com.tencent.mm.an.af.bHi().iE(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
                  if (com.tencent.mm.an.af.bHi().MU(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this)) <= 0)
                  {
                    bh.bCz();
                    com.tencent.mm.model.c.bzG().bxK(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
                  }
                  AppMethodBeat.o(250767);
                }
              });
              AppMethodBeat.o(33930);
              return;
              paramAnonymousMenuItem = com.tencent.mm.an.af.bHi().iD(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              if (paramAnonymousMenuItem != null)
              {
                paramAnonymousMenuItem.field_unReadCount = 1;
                paramAnonymousMenuItem.field_atCount = 0;
                paramAnonymousMenuItem.field_atAll = 0;
                com.tencent.mm.an.af.bHi().b(paramAnonymousMenuItem);
                com.tencent.mm.modelstat.b.oUZ.ab(paramAnonymousMenuItem.field_brandUserName, true);
                AppMethodBeat.o(33930);
                return;
                com.tencent.mm.an.af.bHi().iF(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
                paramAnonymousMenuItem = com.tencent.mm.an.af.bHi().iD(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
                if (paramAnonymousMenuItem != null)
                {
                  com.tencent.mm.modelstat.b.oUZ.ab(paramAnonymousMenuItem.field_brandUserName, false);
                  AppMethodBeat.o(33930);
                  return;
                  paramAnonymousMenuItem = com.tencent.mm.an.af.bHi().iD(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
                  if (com.tencent.mm.an.af.bHi().iG(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this)))
                  {
                    com.tencent.mm.an.af.bHi().iI(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
                    if (paramAnonymousMenuItem != null)
                    {
                      com.tencent.mm.modelstat.b.oUZ.c(true, paramAnonymousMenuItem.field_brandUserName, false);
                      AppMethodBeat.o(33930);
                    }
                  }
                  else
                  {
                    com.tencent.mm.an.af.bHi().iH(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
                    if (paramAnonymousMenuItem != null) {
                      com.tencent.mm.modelstat.b.oUZ.c(true, paramAnonymousMenuItem.field_brandUserName, true);
                    }
                  }
                }
              }
            }
          }
        };
        paramBundle = new com.tencent.mm.ui.widget.b.a(thisActivity());
        this.vzp.setOnTouchListener(new View.OnTouchListener()
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
        this.vzp.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(33932);
            paramBundle.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizChatConversationUI.BizChatConversationFmUI.this, BizChatConversationUI.BizChatConversationFmUI.f(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.g(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.h(BizChatConversationUI.BizChatConversationFmUI.this));
            AppMethodBeat.o(33932);
            return true;
          }
        });
        this.vzp.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(33933);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousAdapterView);
            localb.cH(paramAnonymousView);
            localb.sc(paramAnonymousInt);
            localb.hB(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
            paramAnonymousAdapterView = (com.tencent.mm.an.a.a)BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getItem(paramAnonymousInt);
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
        addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(33916);
            Log.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
            Object localObject = new Intent(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), BizChatSearchUI.class);
            ((Intent)localObject).putExtra("enterprise_biz_name", BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
            ((Intent)localObject).putExtra("biz_chat_search_scene", 1);
            ((Intent)localObject).putExtra("biz_chat_search_text", "");
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousMenuItem = BizChatConversationUI.BizChatConversationFmUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(33916);
            return true;
          }
        });
        addIconOptionMenu(2, R.l.actionbar_title_new_group_chat, R.k.actionbar_icon_dark_add, new com.tencent.mm.ui.conversation.presenter.b(this.ui, jnK()));
        paramBundle = com.tencent.mm.an.af.bHj().hN(this.vEu);
        this.aebr = com.tencent.mm.an.af.bHj().hM(paramBundle);
        String str = this.vEu;
        boolean bool;
        if (this.aebr == null)
        {
          bool = true;
          Log.i("MicroMsg.BizChatConversationFmUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
          if ((Util.isNullOrNil(paramBundle)) || (this.aebr == null) || (this.aebr.bHy()) || (Util.isNullOrNil(this.aebr.field_addMemberUrl)))
          {
            com.tencent.mm.an.af.bHp();
            com.tencent.mm.an.a.h.a(this.vEu, this);
            paramBundle = thisActivity();
            getString(R.l.app_tip);
            this.tipDialog = com.tencent.mm.ui.base.k.a(paramBundle, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(250752);
                BizChatConversationUI.BizChatConversationFmUI.this.finish();
                AppMethodBeat.o(250752);
              }
            });
          }
          bh.baH().postToWorkerDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(250754);
              Log.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
              LinkedList localLinkedList1 = new LinkedList();
              LinkedList localLinkedList2 = new LinkedList();
              Cursor localCursor = com.tencent.mm.an.af.bHi().MW(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              if (localCursor.moveToFirst()) {
                while (!localCursor.isAfterLast())
                {
                  Object localObject = new com.tencent.mm.an.a.a();
                  ((com.tencent.mm.an.a.a)localObject).convertFrom(localCursor);
                  localCursor.moveToNext();
                  localObject = com.tencent.mm.an.af.bHh().dW(((com.tencent.mm.an.a.a)localObject).field_bizChatId);
                  if ((localObject != null) && (((com.tencent.mm.an.a.c)localObject).bHy())) {
                    if (((com.tencent.mm.an.a.c)localObject).bHx()) {
                      localLinkedList2.add(((com.tencent.mm.an.a.c)localObject).field_bizChatServId);
                    } else {
                      localLinkedList1.add(((com.tencent.mm.an.a.c)localObject).field_bizChatServId);
                    }
                  }
                }
              }
              localCursor.close();
              if (localLinkedList2.size() > 0) {
                com.tencent.mm.an.af.bHp().b(localLinkedList2, BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              }
              BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, localLinkedList1);
              if (localLinkedList1.size() > 0) {
                com.tencent.mm.an.af.bHp().c(localLinkedList1, BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              }
              AppMethodBeat.o(250754);
            }
          }, 300L);
          paramBundle = jnK();
          if (paramBundle == null) {
            break label639;
          }
          com.tencent.mm.an.af.bHq();
          com.tencent.mm.an.e.a(paramBundle, null);
          Log.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", new Object[] { paramBundle });
        }
        for (;;)
        {
          this.aebt = com.tencent.mm.an.af.bHq().Mi(jnK());
          Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
          {
            public final boolean queueIdle()
            {
              AppMethodBeat.i(33913);
              Object localObject = com.tencent.mm.an.af.bHf().Mn(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              if (localObject == null)
              {
                Log.e("MicroMsg.BizChatConversationFmUI", "report bizInfo is null");
                AppMethodBeat.o(33913);
                return false;
              }
              BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, ((com.tencent.mm.api.c)localObject).aAX());
              int m = BizChatConversationUI.BizChatConversationFmUI.this.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
              int i = -1;
              if (BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this) != null) {
                i = BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getCount();
              }
              localObject = com.tencent.mm.an.af.bHq().Mi(BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this));
              int j;
              int k;
              label131:
              int n;
              long l1;
              if (localObject != null)
              {
                j = ((com.tencent.mm.an.d)localObject).field_qyUin;
                if (localObject == null) {
                  break label360;
                }
                k = ((com.tencent.mm.an.d)localObject).field_userUin;
                n = com.tencent.mm.an.af.bHq().Mk(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
                if (localObject == null) {
                  break label365;
                }
                l1 = ((com.tencent.mm.an.d)localObject).field_wwCorpId;
                label158:
                if (localObject == null) {
                  break label371;
                }
              }
              label360:
              label365:
              label371:
              for (long l2 = ((com.tencent.mm.an.d)localObject).field_wwUserVid;; l2 = 0L)
              {
                com.tencent.mm.plugin.report.service.h.OAn.b(12648, new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
                Log.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
                AppMethodBeat.o(33913);
                return false;
                j = 0;
                break;
                k = 0;
                break label131;
                l1 = 0L;
                break label158;
              }
            }
          });
          paramBundle = thisActivity().getIntent();
          if (IntentUtil.getBooleanExtra(paramBundle, "biz_chat_need_to_jump_to_chatting_ui", false))
          {
            long l = paramBundle.getLongExtra("biz_chat_chat_id", -1L);
            if (l != -1L) {
              zG(l);
            }
          }
          AppMethodBeat.o(33938);
          return;
          bool = false;
          break;
          label639:
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
      cam localcam;
      if (paramIntent != null)
      {
        Log.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
        localObject = paramIntent.getString("enterprise_members");
        localcam = new cam();
        com.tencent.mm.an.a.c localc = new com.tencent.mm.an.a.c();
        if (this.aebr != null)
        {
          paramIntent = this.aebr.field_addMemberUrl;
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.vEu;
          if (!com.tencent.mm.an.a.e.a(localc, (String)localObject, null, localcam)) {
            break label258;
          }
          if (localc.field_bizChatLocalId == -1L) {
            break label198;
          }
          zG(localc.field_bizChatLocalId);
          paramInt1 = 1;
        }
      }
      for (;;)
      {
        if (paramInt1 == 0)
        {
          Toast.makeText(thisActivity(), getString(R.l.gTv), 0).show();
          AppMethodBeat.o(33944);
          return;
          paramIntent = null;
          break;
          label198:
          com.tencent.mm.an.af.bHp();
          paramIntent = com.tencent.mm.an.a.h.a(this.vEu, localcam, this);
          localObject = thisActivity();
          getString(R.l.app_tip);
          this.tipDialog = com.tencent.mm.ui.base.k.a((Context)localObject, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(250761);
              com.tencent.mm.an.af.bHp();
              com.tencent.mm.an.a.h.d(paramIntent);
              AppMethodBeat.o(250761);
            }
          });
          paramInt1 = 1;
          continue;
          label258:
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
      paramContextMenuInfo = (com.tencent.mm.an.a.a)this.aebq.getItem(paramView.position);
      this.vEb = paramContextMenuInfo.field_bizChatId;
      if (paramContextMenuInfo.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 1, R.l.gNf);
        com.tencent.mm.an.af.bHi();
        if (!com.tencent.mm.an.a.b.c(paramContextMenuInfo)) {
          break label126;
        }
        paramContextMenu.add(paramView.position, 3, 2, R.l.gNg);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 0, 3, R.l.main_delete);
        AppMethodBeat.o(33943);
        return;
        paramContextMenu.add(paramView.position, 2, 1, R.l.gNd);
        break;
        label126:
        paramContextMenu.add(paramView.position, 3, 2, R.l.gNe);
      }
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(33940);
      Log.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
      com.tencent.mm.an.af.bHi().a(this.aebu);
      com.tencent.mm.an.af.bHh().a(this.aebv);
      com.tencent.mm.an.af.bHq().a(this.aebw);
      if (bh.baz())
      {
        bh.bCz();
        com.tencent.mm.model.c.bzG().remove(this);
      }
      this.aebq.fSd();
      this.aebq.onDestroy();
      super.onDestroy();
      AppMethodBeat.o(33940);
    }
    
    public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject) {}
    
    public void onPause()
    {
      AppMethodBeat.i(33942);
      Log.i("MicroMsg.BizChatConversationFmUI", "on pause");
      bh.bCz();
      com.tencent.mm.model.c.bzG().bxO(this.vEu);
      com.tencent.mm.an.a.b localb = com.tencent.mm.an.af.bHi();
      String str = this.vEu;
      if (Util.isNullOrNil(str)) {
        Log.e("MicroMsg.BizConversationStorage", "brandUserName is null");
      }
      for (;;)
      {
        if (this.aebq != null) {
          this.aebq.onPause();
        }
        this.isCurrentActivity = false;
        bh.getNotification().Cv("");
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
      au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.vEu);
      if ((localau == null) || (!com.tencent.mm.contact.d.rs(localau.field_type)))
      {
        Log.w("MicroMsg.BizChatConversationFmUI", "onResume is not contact now");
        finish();
        AppMethodBeat.o(33941);
        return;
      }
      com.tencent.mm.api.c localc = g.hU(this.vEu);
      if ((localc == null) || (localc.field_enterpriseFather == null) || (!ab.IR(localc.field_enterpriseFather)))
      {
        Log.w("MicroMsg.BizChatConversationFmUI", "onResume enterpriseFather is invalid");
        finish();
        AppMethodBeat.o(33941);
        return;
      }
      if (localau.aGe()) {
        setTitleMuteIconVisibility(0);
      }
      for (;;)
      {
        this.isCurrentActivity = true;
        this.aebq.onNotifyChange(null, null);
        bh.getNotification().Cv(this.vEu);
        AppMethodBeat.o(33941);
        return;
        setTitleMuteIconVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI
 * JD-Core Version:    0.7.0.1
 */