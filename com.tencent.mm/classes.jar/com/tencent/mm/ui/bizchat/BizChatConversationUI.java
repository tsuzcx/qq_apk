package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.Context;
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
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.b.a;
import com.tencent.mm.aj.a.d.a;
import com.tencent.mm.aj.c.a;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.protobuf.aeh;
import com.tencent.mm.protocal.protobuf.kp;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.mm.ui.p.a;
import java.util.HashMap;

public class BizChatConversationUI
  extends BaseConversationUI
{
  private View contentView;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(30099);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.pluginsdk.f.a(this, this.contentView);
    AppMethodBeat.o(30099);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30098);
    super.onCreate(paramBundle);
    this.contentView = com.tencent.mm.ui.w.hM(this).inflate(2130968894, null);
    setContentView(this.contentView);
    this.conversationFm = new BizChatConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131821947, this.conversationFm).commit();
    com.tencent.mm.pluginsdk.f.a(this, this.contentView);
    AppMethodBeat.o(30098);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class BizChatConversationFmUI
    extends BaseConversationUI.BaseConversationFmUI
    implements com.tencent.mm.aj.n, n.b
  {
    private TextView emptyTipTv;
    private String fvM;
    private boolean isCurrentActivity;
    private boolean isDeleteCancel;
    private ListView jSl;
    private n.d jSn;
    private String jUE;
    private com.tencent.mm.ui.tools.m jUd;
    private int jUm;
    private int jUn;
    private long jUy;
    private p tipDialog;
    private LinearLayout zto;
    private b ztp;
    private com.tencent.mm.aj.a.j ztq;
    private int ztr;
    private b.a zts;
    private d.a ztt;
    private c.a ztu;
    
    public BizChatConversationFmUI()
    {
      AppMethodBeat.i(30079);
      this.isDeleteCancel = false;
      this.ztr = 0;
      this.jUm = 0;
      this.jUn = 0;
      this.zts = new BizChatConversationUI.BizChatConversationFmUI.11(this);
      this.ztt = new BizChatConversationUI.BizChatConversationFmUI.13(this);
      this.ztu = new BizChatConversationUI.BizChatConversationFmUI.14(this);
      AppMethodBeat.o(30079);
    }
    
    private void dEU()
    {
      AppMethodBeat.i(30088);
      String str1 = dEW();
      this.ztr = com.tencent.mm.ui.g.bJ(getContext(), str1);
      Object localObject1;
      Object localObject2;
      if ((this.ztr == 2) && (this.zto == null))
      {
        this.zto = ((LinearLayout)findViewById(2131823738));
        localObject1 = this.zto.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.ao(getContext(), 2131427563);
        this.zto.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = com.tencent.mm.ui.w.hM(getContext()).inflate(2130969437, this.zto, false);
        float f = com.tencent.mm.cb.a.dr(getContext());
        localObject2 = (ImageView)((View)localObject1).findViewById(2131821253);
        int i = ((ImageView)localObject2).getLayoutParams().height;
        ((ImageView)localObject2).getLayoutParams().height = ((int)(i * f));
        ((ImageView)localObject2).getLayoutParams().width = ((int)(f * i));
        ((ImageView)localObject2).requestLayout();
        localObject2 = (TextView)((View)localObject1).findViewById(2131821212);
        com.tencent.mm.aj.b localb = z.afr().rx(dEW());
        z.afr();
        z.afr();
        String str2 = com.tencent.mm.aj.c.kX(0);
        if ((localb == null) || (localb.field_use_preset_banner_tips) || (str2 == null)) {
          break label302;
        }
        ((TextView)localObject2).setText(str2);
      }
      for (;;)
      {
        this.zto.addView((View)localObject1);
        ((View)localObject1).setOnClickListener(new BizChatConversationUI.BizChatConversationFmUI.12(this));
        com.tencent.mm.ui.g.s(getContext(), this.jUE, 4);
        com.tencent.mm.ui.g.bK(getContext(), str1);
        if (this.zto == null) {
          break label322;
        }
        if (this.ztr != 2) {
          break;
        }
        this.zto.setVisibility(0);
        AppMethodBeat.o(30088);
        return;
        label302:
        ((TextView)localObject2).setText(2131299325);
      }
      this.zto.setVisibility(8);
      label322:
      AppMethodBeat.o(30088);
    }
    
    private void dEV()
    {
      boolean bool = false;
      AppMethodBeat.i(30089);
      Object localObject = z.afm().dg(this.jUE);
      this.ztq = z.afm().df((String)localObject);
      String str = this.jUE;
      if (this.ztq == null) {
        bool = true;
      }
      ab.i("MicroMsg.BizChatConversationFmUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, localObject, Boolean.valueOf(bool) });
      if ((bo.isNullOrNil((String)localObject)) || (this.ztq == null) || (this.ztq.afy()) || (bo.isNullOrNil(this.ztq.field_addMemberUrl)))
      {
        z.afq();
        com.tencent.mm.aj.a.h.a(this.jUE, this);
        localObject = thisActivity();
        getString(2131297087);
        this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131297112), true, new BizChatConversationUI.BizChatConversationFmUI.9(this));
      }
      AppMethodBeat.o(30089);
    }
    
    private String dEW()
    {
      AppMethodBeat.i(30090);
      if (bo.isNullOrNil(this.fvM)) {
        this.fvM = z.afi().rK(this.jUE).aeo();
      }
      String str = this.fvM;
      AppMethodBeat.o(30090);
      return str;
    }
    
    private void ow(long paramLong)
    {
      AppMethodBeat.i(30091);
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      this.ui.startChatting(this.jUE, localBundle, true);
      AppMethodBeat.o(30091);
    }
    
    public final void a(int paramInt, com.tencent.mm.ai.m paramm)
    {
      AppMethodBeat.i(30087);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (paramm.getType() == 1355)
      {
        paramm = ((com.tencent.mm.aj.a.n)paramm).afD();
        paramm = z.afk().sl(paramm.wOs.wXl.wyb);
        if (paramm == null)
        {
          Toast.makeText(ah.getContext(), getString(2131302681), 0).show();
          AppMethodBeat.o(30087);
          return;
        }
        ow(paramm.field_bizChatLocalId);
      }
      AppMethodBeat.o(30087);
    }
    
    public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject) {}
    
    public int getLayoutId()
    {
      return 2130969436;
    }
    
    public String getUserName()
    {
      AppMethodBeat.i(30081);
      if (bo.isNullOrNil(this.fvM))
      {
        str = this.jUE;
        AppMethodBeat.o(30081);
        return str;
      }
      String str = this.fvM;
      AppMethodBeat.o(30081);
      return str;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      AppMethodBeat.i(30080);
      super.onActivityCreated(paramBundle);
      this.jUE = thisActivity().getIntent().getStringExtra("Contact_User");
      ab.i("MicroMsg.BizChatConversationFmUI", "[registerListener]");
      z.afl().a(this.zts, thisActivity().getMainLooper());
      z.afk().a(this.ztt, thisActivity().getMainLooper());
      z.afr().a(this.ztu, thisActivity().getMainLooper());
      aw.aaz();
      com.tencent.mm.model.c.YF().a(this);
      this.emptyTipTv = ((TextView)findViewById(2131821852));
      this.emptyTipTv.setText(2131301414);
      this.jSl = ((ListView)findViewById(2131823736));
      dEU();
      this.ztp = new b(thisActivity(), new p.a()
      {
        public final void apT()
        {
          AppMethodBeat.i(30076);
          BizChatConversationUI.BizChatConversationFmUI.this.setMMTitle(s.nE(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this)));
          if (BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getCount() <= 0)
          {
            BizChatConversationUI.BizChatConversationFmUI.i(BizChatConversationUI.BizChatConversationFmUI.this).setVisibility(0);
            BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).setVisibility(8);
            AppMethodBeat.o(30076);
            return;
          }
          BizChatConversationUI.BizChatConversationFmUI.i(BizChatConversationUI.BizChatConversationFmUI.this).setVisibility(8);
          if (BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this) != null) {
            BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).setVisibility(0);
          }
          AppMethodBeat.o(30076);
        }
      }, this.jUE);
      this.ztp.setGetViewPositionCallback(new BizChatConversationUI.BizChatConversationFmUI.20(this));
      this.ztp.setPerformItemClickListener(new BizChatConversationUI.BizChatConversationFmUI.21(this));
      this.ztp.a(new BizChatConversationUI.BizChatConversationFmUI.2(this));
      this.jSl.setAdapter(this.ztp);
      this.jSn = new BizChatConversationUI.BizChatConversationFmUI.15(this);
      paramBundle = new com.tencent.mm.ui.widget.c.a(thisActivity());
      this.jSl.setOnTouchListener(new BizChatConversationUI.BizChatConversationFmUI.16(this));
      this.jSl.setOnItemLongClickListener(new BizChatConversationUI.BizChatConversationFmUI.17(this, paramBundle));
      this.jSl.setOnItemClickListener(new BizChatConversationUI.BizChatConversationFmUI.18(this));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(30057);
          BizChatConversationUI.BizChatConversationFmUI.this.finish();
          AppMethodBeat.o(30057);
          return true;
        }
      });
      addIconOptionMenu(1, 2131304318, 2131230741, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(30058);
          ab.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
          paramAnonymousMenuItem = new Intent(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), BizChatSearchUI.class);
          paramAnonymousMenuItem.putExtra("enterprise_biz_name", BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
          paramAnonymousMenuItem.putExtra("biz_chat_search_scene", 1);
          paramAnonymousMenuItem.putExtra("biz_chat_search_text", "");
          paramAnonymousMenuItem.addFlags(67108864);
          BizChatConversationUI.BizChatConversationFmUI.this.startActivity(paramAnonymousMenuItem);
          AppMethodBeat.o(30058);
          return true;
        }
      });
      addIconOptionMenu(2, 2131296407, 2131230736, new BizChatConversationUI.BizChatConversationFmUI.5(this));
      dEV();
      aw.RO().o(new BizChatConversationUI.BizChatConversationFmUI.10(this), 300L);
      paramBundle = dEW();
      if (paramBundle != null)
      {
        z.afr();
        com.tencent.mm.aj.c.a(paramBundle, null);
        ab.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", new Object[] { paramBundle });
      }
      for (;;)
      {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(30055);
            Object localObject = z.afi().rK(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
            BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, ((com.tencent.mm.aj.d)localObject).aeo());
            int m = BizChatConversationUI.BizChatConversationFmUI.this.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
            int i = -1;
            if (BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this) != null) {
              i = BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getCount();
            }
            localObject = z.afr().rx(BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this));
            int j;
            int k;
            label113:
            int n;
            long l1;
            if (localObject != null)
            {
              j = ((com.tencent.mm.aj.b)localObject).field_qyUin;
              if (localObject == null) {
                break label343;
              }
              k = ((com.tencent.mm.aj.b)localObject).field_userUin;
              n = z.afr().rz(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              if (localObject == null) {
                break label348;
              }
              l1 = ((com.tencent.mm.aj.b)localObject).field_wwCorpId;
              label140:
              if (localObject == null) {
                break label354;
              }
            }
            label343:
            label348:
            label354:
            for (long l2 = ((com.tencent.mm.aj.b)localObject).field_wwUserVid;; l2 = 0L)
            {
              com.tencent.mm.plugin.report.service.h.qsU.e(12648, new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
              ab.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
              AppMethodBeat.o(30055);
              return false;
              j = 0;
              break;
              k = 0;
              break label113;
              l1 = 0L;
              break label140;
            }
          }
        });
        paramBundle = thisActivity().getIntent();
        if (com.tencent.mm.sdk.platformtools.w.a(paramBundle, "biz_chat_need_to_jump_to_chatting_ui", false))
        {
          long l = paramBundle.getLongExtra("biz_chat_chat_id", -1L);
          if (l != -1L) {
            ow(l);
          }
        }
        AppMethodBeat.o(30080);
        return;
        ab.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
      }
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(30086);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(30086);
        return;
      }
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(30086);
        return;
      }
      paramIntent = paramIntent.getBundleExtra("result_data");
      Object localObject;
      aeh localaeh;
      if (paramIntent != null)
      {
        ab.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
        localObject = paramIntent.getString("enterprise_members");
        localaeh = new aeh();
        com.tencent.mm.aj.a.c localc = new com.tencent.mm.aj.a.c();
        if (this.ztq != null)
        {
          paramIntent = this.ztq.field_addMemberUrl;
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.jUE;
          if (!com.tencent.mm.aj.a.e.a(localc, (String)localObject, null, localaeh)) {
            break label256;
          }
          if (localc.field_bizChatLocalId == -1L) {
            break label198;
          }
          ow(localc.field_bizChatLocalId);
          paramInt1 = 1;
        }
      }
      for (;;)
      {
        if (paramInt1 == 0)
        {
          Toast.makeText(thisActivity(), getString(2131302681), 0).show();
          AppMethodBeat.o(30086);
          return;
          paramIntent = null;
          break;
          label198:
          z.afq();
          paramIntent = com.tencent.mm.aj.a.h.a(this.jUE, localaeh, this);
          localObject = thisActivity();
          getString(2131297087);
          this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131297112), true, new BizChatConversationUI.BizChatConversationFmUI.6(this, paramIntent));
          paramInt1 = 1;
          continue;
          label256:
          paramInt1 = 0;
          continue;
        }
        AppMethodBeat.o(30086);
        return;
        paramInt1 = 0;
      }
    }
    
    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(30085);
      paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenuInfo = (com.tencent.mm.aj.a.a)this.ztp.getItem(paramView.position);
      this.jUy = paramContextMenuInfo.field_bizChatId;
      if (paramContextMenuInfo.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 0, 2131301405);
        z.afl();
        if (!com.tencent.mm.aj.a.b.c(paramContextMenuInfo)) {
          break label126;
        }
        paramContextMenu.add(paramView.position, 3, 1, 2131301406);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 0, 2, 2131301410);
        AppMethodBeat.o(30085);
        return;
        paramContextMenu.add(paramView.position, 2, 0, 2131301403);
        break;
        label126:
        paramContextMenu.add(paramView.position, 3, 1, 2131301404);
      }
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(30082);
      ab.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
      z.afl().a(this.zts);
      z.afk().a(this.ztt);
      z.afr().a(this.ztu);
      if (aw.RG())
      {
        aw.aaz();
        com.tencent.mm.model.c.YF().b(this);
      }
      this.ztp.bKb();
      b localb = this.ztp;
      if (localb.zte != null)
      {
        localb.zte.clear();
        localb.zte = null;
      }
      super.onDestroy();
      AppMethodBeat.o(30082);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(30084);
      ab.i("MicroMsg.BizChatConversationFmUI", "on pause");
      aw.aaz();
      com.tencent.mm.model.c.YF().arJ(this.jUE);
      com.tencent.mm.aj.a.b localb = z.afl();
      String str = this.jUE;
      if (bo.isNullOrNil(str)) {
        ab.e("MicroMsg.BizConversationStorage", "brandUserName is null");
      }
      for (;;)
      {
        if (this.ztp != null) {
          this.ztp.onPause();
        }
        this.isCurrentActivity = false;
        aw.getNotification().kD("");
        super.onPause();
        AppMethodBeat.o(30084);
        return;
        str = "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'";
        ab.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", new Object[] { Boolean.valueOf(localb.db.execSQL("BizChatConversation", str)), str });
      }
    }
    
    public void onResume()
    {
      AppMethodBeat.i(30083);
      super.onResume();
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.jUE);
      if ((localad == null) || (!com.tencent.mm.n.a.je(localad.field_type)))
      {
        finish();
        AppMethodBeat.o(30083);
        return;
      }
      com.tencent.mm.aj.d locald = com.tencent.mm.aj.f.rS(this.jUE);
      if ((locald == null) || (locald.field_enterpriseFather == null) || (!t.nT(locald.field_enterpriseFather)))
      {
        finish();
        AppMethodBeat.o(30083);
        return;
      }
      if (localad.DP()) {
        setTitleMuteIconVisibility(0);
      }
      for (;;)
      {
        this.isCurrentActivity = true;
        this.ztp.a(null, null);
        aw.getNotification().kD(this.jUE);
        AppMethodBeat.o(30083);
        return;
        setTitleMuteIconVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI
 * JD-Core Version:    0.7.0.1
 */