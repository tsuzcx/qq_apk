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
import com.tencent.mm.al.a.d.a.b;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.af;
import com.tencent.mm.al.d.a.a;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.z;
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
    this.contentView = z.jD(this).inflate(2131493232, null);
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
    implements com.tencent.mm.al.o, n.b
  {
    private LinearLayout HGZ;
    private b HHa;
    private com.tencent.mm.al.a.k HHb;
    private int HHc;
    private com.tencent.mm.al.c HHd;
    private b.a HHe;
    private com.tencent.mm.al.a.d.a HHf;
    private com.tencent.mm.al.d.a HHg;
    private String cGc;
    private TextView emptyTipTv;
    private boolean isCurrentActivity;
    private boolean isDeleteCancel;
    private ListView ntK;
    private n.d ntM;
    private int nwY;
    private int nwZ;
    private String nxJ;
    private long nxq;
    private p tipDialog;
    
    public BizChatConversationFmUI()
    {
      AppMethodBeat.i(33937);
      this.isDeleteCancel = false;
      this.HHc = 0;
      this.nwY = 0;
      this.nwZ = 0;
      this.HHe = new b.a()
      {
        public final void a(b.a.b paramAnonymousb)
        {
          AppMethodBeat.i(196379);
          if ((paramAnonymousb != null) && (paramAnonymousb.hzf != null) && (BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this).equals(paramAnonymousb.hzf.field_brandUserName)))
          {
            ac.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).AW(paramAnonymousb.hze);
            if (BizChatConversationUI.BizChatConversationFmUI.n(BizChatConversationUI.BizChatConversationFmUI.this)) {
              BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).Xb();
            }
          }
          AppMethodBeat.o(196379);
        }
      };
      this.HHf = new com.tencent.mm.al.a.d.a()
      {
        public final void a(d.a.b paramAnonymousb)
        {
          AppMethodBeat.i(196380);
          if ((paramAnonymousb != null) && (paramAnonymousb.hzp != null) && (BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this).equals(paramAnonymousb.hzp.field_brandUserName)))
          {
            ac.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).AW(paramAnonymousb.hze);
            if (BizChatConversationUI.BizChatConversationFmUI.n(BizChatConversationUI.BizChatConversationFmUI.this)) {
              BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).Xb();
            }
          }
          AppMethodBeat.o(196380);
        }
      };
      this.HHg = new com.tencent.mm.al.d.a()
      {
        public final void a(d.a.a paramAnonymousa)
        {
          AppMethodBeat.i(196381);
          String str = BizChatConversationUI.BizChatConversationFmUI.d(BizChatConversationUI.BizChatConversationFmUI.this);
          if ((paramAnonymousa != null) && (!bs.isNullOrNil(paramAnonymousa.hxt)) && (paramAnonymousa.hxt.equals(str)))
          {
            int i = BizChatConversationUI.BizChatConversationFmUI.o(BizChatConversationUI.BizChatConversationFmUI.this);
            BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this, com.tencent.mm.ui.g.cb(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), str));
            if (BizChatConversationUI.BizChatConversationFmUI.o(BizChatConversationUI.BizChatConversationFmUI.this) != i) {
              BizChatConversationUI.BizChatConversationFmUI.p(BizChatConversationUI.BizChatConversationFmUI.this);
            }
          }
          AppMethodBeat.o(196381);
        }
      };
      AppMethodBeat.o(33937);
    }
    
    private void AX(long paramLong)
    {
      AppMethodBeat.i(33949);
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      this.ui.startChatting(this.nxJ, localBundle, true);
      AppMethodBeat.o(33949);
    }
    
    private void fjB()
    {
      AppMethodBeat.i(33946);
      String str1 = fjC();
      this.HHc = com.tencent.mm.ui.g.cb(getContext(), str1);
      Object localObject1;
      CdnImageView localCdnImageView;
      int i;
      Object localObject2;
      if ((this.HHc == 2) && (this.HGZ == null))
      {
        this.HGZ = ((LinearLayout)findViewById(2131297432));
        localObject1 = this.HGZ.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cc.a.au(getContext(), 2131165256);
        this.HGZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = z.jD(getContext()).inflate(2131493849, this.HGZ, false);
        float f = com.tencent.mm.cc.a.eb(getContext());
        localCdnImageView = (CdnImageView)((View)localObject1).findViewById(2131300891);
        i = localCdnImageView.getLayoutParams().height;
        localCdnImageView.getLayoutParams().height = ((int)(i * f));
        localCdnImageView.getLayoutParams().width = ((int)(f * i));
        localCdnImageView.requestLayout();
        localObject2 = (TextView)((View)localObject1).findViewById(2131305948);
        af.aDf();
        af.aDf();
        String str2 = com.tencent.mm.al.d.ou(0);
        if ((str2 == null) || (str2.length() <= 0)) {
          break label332;
        }
        ((TextView)localObject2).setText(str2);
      }
      for (;;)
      {
        af.aDf();
        i = com.tencent.mm.al.d.aCr();
        if (i != 0) {
          ((TextView)localObject2).setTextColor(i);
        }
        af.aDf();
        localObject2 = com.tencent.mm.al.d.aCq();
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localCdnImageView.setUrl((String)localObject2);
        }
        this.HGZ.addView((View)localObject1);
        ((View)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33927);
            com.tencent.mm.ui.g.u(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), BizChatConversationUI.BizChatConversationFmUI.d(BizChatConversationUI.BizChatConversationFmUI.this), 4);
            AppMethodBeat.o(33927);
          }
        });
        com.tencent.mm.ui.g.t(getContext(), this.nxJ, 4);
        com.tencent.mm.ui.g.cc(getContext(), str1);
        if (this.HGZ == null) {
          break label352;
        }
        if (this.HHc != 2) {
          break;
        }
        this.HGZ.setVisibility(0);
        AppMethodBeat.o(33946);
        return;
        label332:
        ((TextView)localObject2).setText(2131758452);
      }
      this.HGZ.setVisibility(8);
      label352:
      AppMethodBeat.o(33946);
    }
    
    private String fjC()
    {
      AppMethodBeat.i(33948);
      if (bs.isNullOrNil(this.cGc)) {
        this.cGc = af.aCW().AE(this.nxJ).IV();
      }
      String str = this.cGc;
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
        paramn = ((com.tencent.mm.al.a.o)paramn).aDr();
        paramn = af.aCY().Bp(paramn.EtV.EIW.Ebl);
        if (paramn == null)
        {
          Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), getString(2131762592), 0).show();
          AppMethodBeat.o(33945);
          return;
        }
        AX(paramn.field_bizChatLocalId);
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
      if (bs.isNullOrNil(this.cGc))
      {
        str = this.nxJ;
        AppMethodBeat.o(33939);
        return str;
      }
      String str = this.cGc;
      AppMethodBeat.o(33939);
      return str;
    }
    
    public void onActivityCreated(final Bundle paramBundle)
    {
      AppMethodBeat.i(33938);
      super.onActivityCreated(paramBundle);
      this.nxJ = thisActivity().getIntent().getStringExtra("Contact_User");
      ac.i("MicroMsg.BizChatConversationFmUI", "[registerListener]");
      af.aCZ().a(this.HHe, thisActivity().getMainLooper());
      af.aCY().a(this.HHf, thisActivity().getMainLooper());
      af.aDf().a(this.HHg, thisActivity().getMainLooper());
      az.ayM();
      com.tencent.mm.model.c.awG().a(this);
      this.emptyTipTv = ((TextView)findViewById(2131299468));
      this.emptyTipTv.setText(2131761061);
      this.ntK = ((ListView)findViewById(2131305951));
      try
      {
        fjB();
        label142:
        this.HHa = new b(thisActivity(), new r.a()
        {
          public final void aPg()
          {
            AppMethodBeat.i(33934);
            BizChatConversationUI.BizChatConversationFmUI.this.setMMTitle(v.wk(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this)));
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
        }, this.nxJ);
        this.HHa.setGetViewPositionCallback(new MMSlideDelView.c()
        {
          public final int dy(View paramAnonymousView)
          {
            AppMethodBeat.i(33935);
            int i = BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).getPositionForView(paramAnonymousView);
            AppMethodBeat.o(33935);
            return i;
          }
        });
        this.HHa.setPerformItemClickListener(new MMSlideDelView.g()
        {
          public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(33936);
            BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(33936);
          }
        });
        this.HHa.a(new MMSlideDelView.f()
        {
          public final void cN(Object paramAnonymousObject)
          {
            AppMethodBeat.i(33914);
            if (paramAnonymousObject == null)
            {
              ac.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
              AppMethodBeat.o(33914);
              return;
            }
            AppMethodBeat.o(33914);
          }
        });
        this.ntK.setAdapter(this.HHa);
        this.ntM = new n.d()
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
              paramAnonymousMenuItem = af.aCZ().pT(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              paramAnonymousMenuItem.field_unReadCount = 1;
              paramAnonymousMenuItem.field_atCount = 0;
              paramAnonymousMenuItem.field_atAll = 0;
              af.aCZ().b(paramAnonymousMenuItem);
              com.tencent.mm.modelstat.b.hUE.V(paramAnonymousMenuItem.field_brandUserName, true);
              AppMethodBeat.o(33930);
              return;
              af.aCZ().pV(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              paramAnonymousMenuItem = af.aCZ().pT(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              com.tencent.mm.modelstat.b.hUE.V(paramAnonymousMenuItem.field_brandUserName, false);
              AppMethodBeat.o(33930);
              return;
              paramAnonymousMenuItem = af.aCZ().pT(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              if (af.aCZ().pW(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this)))
              {
                af.aCZ().pY(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
                com.tencent.mm.modelstat.b.hUE.c(true, paramAnonymousMenuItem.field_brandUserName, false);
                AppMethodBeat.o(33930);
                return;
              }
              af.aCZ().pX(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              com.tencent.mm.modelstat.b.hUE.c(true, paramAnonymousMenuItem.field_brandUserName, true);
            }
          }
        };
        paramBundle = new com.tencent.mm.ui.widget.b.a(thisActivity());
        this.ntK.setOnTouchListener(new View.OnTouchListener()
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
        this.ntK.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(33932);
            paramBundle.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizChatConversationUI.BizChatConversationFmUI.this, BizChatConversationUI.BizChatConversationFmUI.f(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.g(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.h(BizChatConversationUI.BizChatConversationFmUI.this));
            AppMethodBeat.o(33932);
            return true;
          }
        });
        this.ntK.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(33933);
            paramAnonymousAdapterView = (com.tencent.mm.al.a.a)BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getItem(paramAnonymousInt);
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
            ac.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
            Object localObject = new Intent(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), BizChatSearchUI.class);
            ((Intent)localObject).putExtra("enterprise_biz_name", BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
            ((Intent)localObject).putExtra("biz_chat_search_scene", 1);
            ((Intent)localObject).putExtra("biz_chat_search_text", "");
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousMenuItem = BizChatConversationUI.BizChatConversationFmUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(33916);
            return true;
          }
        });
        addIconOptionMenu(2, 2131755134, 2131689489, new com.tencent.mm.ui.conversation.presenter.b(this.ui, fjC()));
        paramBundle = af.aDa().dQ(this.nxJ);
        this.HHb = af.aDa().dP(paramBundle);
        String str = this.nxJ;
        boolean bool;
        if (this.HHb == null)
        {
          bool = true;
          ac.i("MicroMsg.BizChatConversationFmUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
          if ((bs.isNullOrNil(paramBundle)) || (this.HHb == null) || (this.HHb.aDm()) || (bs.isNullOrNil(this.HHb.field_addMemberUrl)))
          {
            af.aDe();
            com.tencent.mm.al.a.h.a(this.nxJ, this);
            paramBundle = thisActivity();
            getString(2131755906);
            this.tipDialog = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(196377);
                BizChatConversationUI.BizChatConversationFmUI.this.finish();
                AppMethodBeat.o(196377);
              }
            });
          }
          az.agU().m(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(196378);
              ac.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
              LinkedList localLinkedList1 = new LinkedList();
              LinkedList localLinkedList2 = new LinkedList();
              Cursor localCursor = af.aCZ().Bm(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              if (localCursor.moveToFirst()) {
                while (!localCursor.isAfterLast())
                {
                  Object localObject = new com.tencent.mm.al.a.a();
                  ((com.tencent.mm.al.a.a)localObject).convertFrom(localCursor);
                  localCursor.moveToNext();
                  localObject = af.aCY().bd(((com.tencent.mm.al.a.a)localObject).field_bizChatId);
                  if (((com.tencent.mm.al.a.c)localObject).aDm()) {
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
                af.aDe().b(localLinkedList2, BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              }
              BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, localLinkedList1);
              if (localLinkedList1.size() > 0) {
                af.aDe().c(localLinkedList1, BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              }
              AppMethodBeat.o(196378);
            }
          }, 300L);
          paramBundle = fjC();
          if (paramBundle == null) {
            break label637;
          }
          af.aDf();
          com.tencent.mm.al.d.a(paramBundle, null);
          ac.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", new Object[] { paramBundle });
        }
        for (;;)
        {
          this.HHd = af.aDf().Az(fjC());
          Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
          {
            public final boolean queueIdle()
            {
              AppMethodBeat.i(33913);
              Object localObject = af.aCW().AE(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, ((com.tencent.mm.api.c)localObject).IV());
              int m = BizChatConversationUI.BizChatConversationFmUI.this.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
              int i = -1;
              if (BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this) != null) {
                i = BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getCount();
              }
              localObject = af.aDf().Az(BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this));
              int j;
              int k;
              label112:
              int n;
              long l1;
              if (localObject != null)
              {
                j = ((com.tencent.mm.al.c)localObject).field_qyUin;
                if (localObject == null) {
                  break label341;
                }
                k = ((com.tencent.mm.al.c)localObject).field_userUin;
                n = af.aDf().AB(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
                if (localObject == null) {
                  break label346;
                }
                l1 = ((com.tencent.mm.al.c)localObject).field_wwCorpId;
                label139:
                if (localObject == null) {
                  break label352;
                }
              }
              label341:
              label346:
              label352:
              for (long l2 = ((com.tencent.mm.al.c)localObject).field_wwUserVid;; l2 = 0L)
              {
                com.tencent.mm.plugin.report.service.h.wUl.f(12648, new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
                ac.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
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
          if (x.getBooleanExtra(paramBundle, "biz_chat_need_to_jump_to_chatting_ui", false))
          {
            long l = paramBundle.getLongExtra("biz_chat_chat_id", -1L);
            if (l != -1L) {
              AX(l);
            }
          }
          AppMethodBeat.o(33938);
          return;
          bool = false;
          break;
          label637:
          ac.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
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
      apz localapz;
      if (paramIntent != null)
      {
        ac.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
        localObject = paramIntent.getString("enterprise_members");
        localapz = new apz();
        com.tencent.mm.al.a.c localc = new com.tencent.mm.al.a.c();
        if (this.HHb != null)
        {
          paramIntent = this.HHb.field_addMemberUrl;
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.nxJ;
          if (!com.tencent.mm.al.a.e.a(localc, (String)localObject, null, localapz)) {
            break label256;
          }
          if (localc.field_bizChatLocalId == -1L) {
            break label198;
          }
          AX(localc.field_bizChatLocalId);
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
          af.aDe();
          paramIntent = com.tencent.mm.al.a.h.a(this.nxJ, localapz, this);
          localObject = thisActivity();
          getString(2131755906);
          this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(196374);
              af.aDe();
              com.tencent.mm.al.a.h.d(paramIntent);
              AppMethodBeat.o(196374);
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
      paramContextMenuInfo = (com.tencent.mm.al.a.a)this.HHa.getItem(paramView.position);
      this.nxq = paramContextMenuInfo.field_bizChatId;
      if (paramContextMenuInfo.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 0, 2131761052);
        af.aCZ();
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
      ac.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
      af.aCZ().a(this.HHe);
      af.aCY().a(this.HHf);
      af.aDf().a(this.HHg);
      if (az.agM())
      {
        az.ayM();
        com.tencent.mm.model.c.awG().b(this);
      }
      this.HHa.cVi();
      this.HHa.onDestroy();
      super.onDestroy();
      AppMethodBeat.o(33940);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(33942);
      ac.i("MicroMsg.BizChatConversationFmUI", "on pause");
      az.ayM();
      com.tencent.mm.model.c.awG().aNK(this.nxJ);
      com.tencent.mm.al.a.b localb = af.aCZ();
      String str = this.nxJ;
      if (bs.isNullOrNil(str)) {
        ac.e("MicroMsg.BizConversationStorage", "brandUserName is null");
      }
      for (;;)
      {
        if (this.HHa != null) {
          this.HHa.onPause();
        }
        this.isCurrentActivity = false;
        az.getNotification().rA("");
        super.onPause();
        AppMethodBeat.o(33942);
        return;
        str = "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'";
        ac.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", new Object[] { Boolean.valueOf(localb.db.execSQL("BizChatConversation", str)), str });
      }
    }
    
    public void onResume()
    {
      AppMethodBeat.i(33941);
      super.onResume();
      com.tencent.mm.storage.ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.nxJ);
      if ((localai == null) || (!com.tencent.mm.n.b.ln(localai.field_type)))
      {
        ac.w("MicroMsg.BizChatConversationFmUI", "onResume is not contact now");
        finish();
        AppMethodBeat.o(33941);
        return;
      }
      com.tencent.mm.api.c localc = f.dX(this.nxJ);
      if ((localc == null) || (localc.field_enterpriseFather == null) || (!w.wG(localc.field_enterpriseFather)))
      {
        ac.w("MicroMsg.BizChatConversationFmUI", "onResume enterpriseFather is invalid");
        finish();
        AppMethodBeat.o(33941);
        return;
      }
      if (localai.Nw()) {
        setTitleMuteIconVisibility(0);
      }
      for (;;)
      {
        this.isCurrentActivity = true;
        this.HHa.a(null, null);
        az.getNotification().rA(this.nxJ);
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