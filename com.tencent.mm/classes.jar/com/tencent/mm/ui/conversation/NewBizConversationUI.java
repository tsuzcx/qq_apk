package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.contact.d;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineSettingUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.protocal.protobuf.doj;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.protocal.protobuf.epw;
import com.tencent.mm.protocal.protobuf.ri;
import com.tencent.mm.protocal.protobuf.rj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.x.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class NewBizConversationUI
  extends MMActivity
{
  private final int Brj;
  private String afpa;
  private ListView afpc;
  private a afrq;
  private final int afrr;
  private final int afrs;
  private final int afrt;
  private final int afru;
  private final int afrv;
  private final int afrw;
  private bb conversation;
  final MultiProcessMMKV eMf;
  private TextView emptyTipTv;
  private int hBm;
  private boolean isDeleteCancel;
  private String ovT;
  private int source;
  private String talker;
  private w tipDialog;
  private com.tencent.mm.ui.widget.b.a vEV;
  private u.i vGU;
  private long vGY;
  private IListener vIz;
  private int x_down;
  private int y_down;
  
  public NewBizConversationUI()
  {
    AppMethodBeat.i(38687);
    this.source = 1;
    this.talker = "";
    this.vGY = 0L;
    this.x_down = 0;
    this.y_down = 0;
    this.afrr = 1;
    this.afrs = 2;
    this.Brj = 3;
    this.afrt = 100;
    this.afru = 1;
    this.afrv = 2;
    this.afrw = 3;
    this.eMf = MultiProcessMMKV.getSingleMMKV("brandService");
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.vGU = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(38671);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(38671);
          return;
          bh.bCz();
          paramAnonymousMenuItem = com.tencent.mm.model.c.bzA().JE(NewBizConversationUI.q(NewBizConversationUI.this));
          if (paramAnonymousMenuItem == null)
          {
            Log.e("MicroMsg.NewBizConversationUI", "changed biz stick status failed, contact is null, talker = " + NewBizConversationUI.q(NewBizConversationUI.this));
            AppMethodBeat.o(38671);
            return;
          }
          if (paramAnonymousMenuItem.aSQ())
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
            ab.L(NewBizConversationUI.q(NewBizConversationUI.this), true);
          }
          for (;;)
          {
            com.tencent.mm.autogen.a.au localau = new com.tencent.mm.autogen.a.au();
            localau.hAy.userName = paramAnonymousMenuItem.field_username;
            localau.publish();
            AppMethodBeat.o(38671);
            return;
            com.tencent.mm.plugin.report.service.h.OAn.b(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
            ab.K(NewBizConversationUI.q(NewBizConversationUI.this), true);
          }
          bh.bCz();
          paramAnonymousMenuItem = com.tencent.mm.model.c.bzA().JE(NewBizConversationUI.q(NewBizConversationUI.this));
          com.tencent.mm.ui.tools.c.a(af.bHf().Mn(NewBizConversationUI.q(NewBizConversationUI.this)), NewBizConversationUI.this, paramAnonymousMenuItem, 2);
          AppMethodBeat.o(38671);
          return;
          NewBizConversationUI.b(NewBizConversationUI.this, NewBizConversationUI.q(NewBizConversationUI.this));
          AppMethodBeat.o(38671);
          return;
          com.tencent.mm.ui.h.c(NewBizConversationUI.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(256812);
              bh.bCz();
              com.tencent.mm.model.c.bzG().bxK(NewBizConversationUI.q(NewBizConversationUI.this));
              AppMethodBeat.o(256812);
            }
          });
        }
      }
    };
    this.vIz = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(38687);
  }
  
  private void jAR()
  {
    final boolean bool1 = true;
    AppMethodBeat.i(38689);
    removeAllOptionMenu();
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.vtB;
    final boolean bool2 = com.tencent.mm.plugin.bizui.a.a.daI();
    boolean bool3 = aj.aBu();
    Log.d("MicroMsg.NewBizConversationUI", "open search entrance:%b, isBizTeenModeAllowAll: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool2) && (!bool3)) {
      addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new NewBizConversationUI.1(this));
    }
    bool2 = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbx();
    final int i = this.eMf.decodeInt(jAT(), 0);
    if ((i == 1) && (bool2) && (this.eMf.decodeBool("NeedShowPayActionBarRedDot", true))) {}
    for (;;)
    {
      addIconOptionMenu(0, R.l.app_more, R.k.actionbar_icon_dark_more, bool1, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38675);
          if (bool1)
          {
            NewBizConversationUI.this.eMf.encode("NeedShowPayActionBarRedDot", false);
            NewBizConversationUI.a(NewBizConversationUI.this);
          }
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(NewBizConversationUI.this, 1, false);
          paramAnonymousMenuItem.Vtg = new u.g()
          {
            public final void onCreateMMMenu(s paramAnonymous2s)
            {
              AppMethodBeat.i(38673);
              paramAnonymous2s.oh(1, R.l.biz_time_line_new_msg_list);
              Object localObject = NewBizConversationUI.this.eMf.decodeString("PaySubscribeEntryUrl", "");
              if ((NewBizConversationUI.11.this.afrB == 1) && (!Util.isNullOrNil((String)localObject)) && (NewBizConversationUI.11.this.afrC))
              {
                boolean bool = NewBizConversationUI.this.eMf.decodeBool("NeedShowPayRedDot", true);
                paramAnonymous2s.a(2, NewBizConversationUI.this.getString(R.l.biz_article_pay_list), bool);
              }
              localObject = NewBizConversationUI.b(NewBizConversationUI.this);
              if ((localObject != null) && (!Util.isNullOrNil(((doj)localObject).aaVr)))
              {
                int i = 0;
                while (i < ((doj)localObject).aaVr.size())
                {
                  doi localdoi = (doi)((doj)localObject).aaVr.get(i);
                  if ((localdoi != null) && (localdoi.vhJ == 3) && (!Util.isNullOrNil(localdoi.aaVp)) && (!Util.isNullOrNil(localdoi.aaVo))) {
                    paramAnonymous2s.c(i + 100, localdoi.aaVp);
                  }
                  i += 1;
                }
              }
              if (NewBizConversationUI.jAV()) {
                paramAnonymous2s.a(3, NewBizConversationUI.this.getString(R.l.app_set), false);
              }
              AppMethodBeat.o(38673);
            }
          };
          paramAnonymousMenuItem.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(38674);
              Object localObject;
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                localObject = NewBizConversationUI.b(NewBizConversationUI.this);
                if ((localObject != null) && (!Util.isNullOrNil(((doj)localObject).aaVr))) {
                  paramAnonymous2Int = 0;
                }
                break;
              }
              for (;;)
              {
                if (paramAnonymous2Int < ((doj)localObject).aaVr.size())
                {
                  doi localdoi = (doi)((doj)localObject).aaVr.get(paramAnonymous2Int);
                  if ((localdoi != null) && (localdoi.vhJ == 3) && (!Util.isNullOrNil(localdoi.aaVp)) && (!Util.isNullOrNil(localdoi.aaVo)) && (paramAnonymous2Int + 100 == paramAnonymous2MenuItem.getItemId())) {
                    NewBizConversationUI.a(NewBizConversationUI.this, localdoi.aaVo, localdoi.aaVq);
                  }
                }
                else
                {
                  Log.w("MicroMsg.NewBizConversationUI", "default onMMMenuItemSelected err");
                  AppMethodBeat.o(38674);
                  return;
                  localObject = new Intent(NewBizConversationUI.this.getContext(), BizTimeLineNewMsgUI.class);
                  ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 2);
                  ((Intent)localObject).putExtra("biz_time_line_line_session_id", NewBizConversationUI.c(NewBizConversationUI.this));
                  paramAnonymous2MenuItem = NewBizConversationUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(38674);
                  return;
                  NewBizConversationUI.this.eMf.encode("NeedShowPayRedDot", false);
                  paramAnonymous2MenuItem = NewBizConversationUI.this.eMf.decodeString("PaySubscribeEntryUrl", "");
                  NewBizConversationUI.a(NewBizConversationUI.this, paramAnonymous2MenuItem, true);
                  AppMethodBeat.o(38674);
                  return;
                  localObject = new Intent(NewBizConversationUI.this.getContext(), BizTimeLineSettingUI.class);
                  paramAnonymous2MenuItem = NewBizConversationUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(38674);
                  return;
                }
                paramAnonymous2Int += 1;
              }
            }
          };
          paramAnonymousMenuItem.dDn();
          AppMethodBeat.o(38675);
          return true;
        }
      });
      AppMethodBeat.o(38689);
      return;
      bool1 = false;
    }
  }
  
  private doj jAS()
  {
    AppMethodBeat.i(256832);
    byte[] arrayOfByte = this.eMf.decodeBytes(jAU());
    if (arrayOfByte != null) {
      try
      {
        doj localdoj = new doj();
        localdoj.parseFrom(arrayOfByte);
        AppMethodBeat.o(256832);
        return localdoj;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.NewBizConversationUI", "getMenuEntryListInfo ex %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(256832);
    return null;
  }
  
  private static String jAT()
  {
    AppMethodBeat.i(162388);
    if (com.tencent.mm.kernel.h.baz()) {
      com.tencent.mm.kernel.h.baC();
    }
    for (String str = com.tencent.mm.kernel.b.aZs();; str = "")
    {
      str = str + ":PaySubscribeEntryOpen";
      AppMethodBeat.o(162388);
      return str;
    }
  }
  
  private static String jAU()
  {
    AppMethodBeat.i(256842);
    if (com.tencent.mm.kernel.h.baz()) {
      com.tencent.mm.kernel.h.baC();
    }
    for (String str = com.tencent.mm.kernel.b.aZs();; str = "")
    {
      str = str + ":MenuEntryListInfo";
      AppMethodBeat.o(256842);
      return str;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.tmessage;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38693);
    setMMTitle(this.afpa);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38677);
        NewBizConversationUI.this.finish();
        AppMethodBeat.o(38677);
        return true;
      }
    });
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38678);
        if ((NewBizConversationUI.this.activityHasDestroyed()) || (NewBizConversationUI.this.isFinishing()))
        {
          AppMethodBeat.o(38678);
          return;
        }
        NewBizConversationUI.d(NewBizConversationUI.this);
        AppMethodBeat.o(38678);
      }
    });
    this.afpc = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.gFn);
    this.afrq = new a(this, this.ovT, new x.a()
    {
      public final void bWC()
      {
        AppMethodBeat.i(38680);
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.h(NewBizConversationUI.this).getCount());
        AppMethodBeat.o(38680);
      }
    });
    this.afrq.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int eB(View paramAnonymousView)
      {
        AppMethodBeat.i(38681);
        int i = NewBizConversationUI.i(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38681);
        return i;
      }
    });
    this.afrq.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38682);
        NewBizConversationUI.i(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38682);
      }
    });
    this.afpc.setAdapter(this.afrq);
    this.vEV = new com.tencent.mm.ui.widget.b.a(this);
    this.afpc.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38662);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        NewBizConversationUI.a(NewBizConversationUI.this, (bb)NewBizConversationUI.h(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.j(NewBizConversationUI.this).field_username);
        paramAnonymousAdapterView = NewBizConversationUI.j(NewBizConversationUI.this);
        if (paramAnonymousAdapterView == null)
        {
          Log.e("MicroMsg.NewBizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(NewBizConversationUI.h(NewBizConversationUI.this).getCount()) });
          NewBizConversationUI.h(NewBizConversationUI.this).notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38662);
          return;
        }
        localObject = new Intent(NewBizConversationUI.this, ChattingUI.class);
        ((Intent)localObject).putExtra("Chat_User", paramAnonymousAdapterView.field_username);
        ((Intent)localObject).putExtra("finish_direct", true);
        ((Intent)localObject).putExtra("biz_click_item_unread_count", NewBizConversationUI.j(NewBizConversationUI.this).field_unReadCount);
        ((Intent)localObject).putExtra("biz_click_item_position", paramAnonymousInt + 1);
        ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 92);
        ((Intent)localObject).putExtra("specific_chat_from_scene", 6);
        paramAnonymousView = NewBizConversationUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        NewBizConversationUI.h(NewBizConversationUI.this).a(paramAnonymousAdapterView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(38662);
      }
    });
    this.afpc.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(38663);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(38663);
          return false;
          NewBizConversationUI.b(NewBizConversationUI.this, (int)paramAnonymousMotionEvent.getRawX());
          NewBizConversationUI.c(NewBizConversationUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    this.afpc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38664);
        NewBizConversationUI.a(NewBizConversationUI.this, (bb)NewBizConversationUI.h(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.j(NewBizConversationUI.this).field_username);
        NewBizConversationUI.n(NewBizConversationUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NewBizConversationUI.this, NewBizConversationUI.k(NewBizConversationUI.this), NewBizConversationUI.l(NewBizConversationUI.this), NewBizConversationUI.m(NewBizConversationUI.this));
        AppMethodBeat.o(38664);
        return true;
      }
    });
    this.afrq.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int eB(View paramAnonymousView)
      {
        AppMethodBeat.i(38665);
        int i = NewBizConversationUI.i(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38665);
        return i;
      }
    });
    this.afrq.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38666);
        NewBizConversationUI.i(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38666);
      }
    });
    this.afrq.a(new MMSlideDelView.f()
    {
      public final void es(Object paramAnonymousObject)
      {
        AppMethodBeat.i(38667);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.NewBizConversationUI", "onItemDel object null");
          AppMethodBeat.o(38667);
          return;
        }
        paramAnonymousObject = paramAnonymousObject.toString();
        NewBizConversationUI.b(NewBizConversationUI.this, paramAnonymousObject);
        AppMethodBeat.o(38667);
      }
    });
    AppMethodBeat.o(38693);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38694);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38694);
      return;
    }
    AppMethodBeat.o(38694);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38688);
    super.onCreate(paramBundle);
    if (!bh.baz())
    {
      Log.e("MicroMsg.NewBizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(38688);
      return;
    }
    this.hBm = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.source = getIntent().getIntExtra("biz_enter_source", 1);
    this.ovT = "officialaccounts";
    com.tencent.mm.plugin.report.service.h.OAn.b(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.hBm), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.source), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.afpa = getIntent().getStringExtra("enterprise_biz_display_name");
    if (Util.isNullOrNil(this.afpa)) {
      this.afpa = getString(R.l.gvH);
    }
    initView();
    jAR();
    paramBundle = new c.a();
    paramBundle.otE = new ri();
    paramBundle.otF = new rj();
    paramBundle.uri = "/cgi-bin/mmbiz-bin/timeline/bizstrategy";
    paramBundle.funcId = 1806;
    paramBundle = paramBundle.bEF();
    ((ri)c.b.b(paramBundle.otB)).nUz = 321;
    z.a(paramBundle, new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
      {
        int i = 1;
        AppMethodBeat.i(38676);
        Log.i("MicroMsg.NewBizConversationUI", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0))
        {
          AppMethodBeat.o(38676);
          return 0;
        }
        boolean bool = NewBizConversationUI.jAV();
        paramAnonymousString = (rj)c.c.b(paramAnonymousc.otC);
        paramAnonymousc = com.tencent.mm.pluginsdk.model.a.XPo;
        com.tencent.mm.pluginsdk.model.a.a(paramAnonymousString.YWr);
        if (NewBizConversationUI.jAV() != bool) {}
        for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
        {
          if ((paramAnonymousString.YWi != null) && (!Util.isNullOrNil(paramAnonymousString.YWi.abie)))
          {
            paramAnonymousInt2 = NewBizConversationUI.this.eMf.decodeInt(NewBizConversationUI.jAW(), 0);
            NewBizConversationUI.this.eMf.encode("PaySubscribeEntryUrl", paramAnonymousString.YWi.abie);
            NewBizConversationUI.this.eMf.encode(NewBizConversationUI.jAW(), paramAnonymousString.YWi.abid);
            if (paramAnonymousString.YWp == null) {
              break label251;
            }
          }
          label267:
          for (;;)
          {
            try
            {
              NewBizConversationUI.this.eMf.encode(NewBizConversationUI.jAX(), paramAnonymousString.YWp.toByteArray());
              if (paramAnonymousInt2 == paramAnonymousString.YWi.abid) {
                break label267;
              }
              paramAnonymousInt1 = i;
              if (paramAnonymousInt1 != 0) {
                NewBizConversationUI.a(NewBizConversationUI.this);
              }
              AppMethodBeat.o(38676);
              return 0;
            }
            catch (Exception paramAnonymousc)
            {
              Log.e("MicroMsg.NewBizConversationUI", "encode ex %s", new Object[] { paramAnonymousc.getMessage() });
              continue;
            }
            label251:
            NewBizConversationUI.this.eMf.removeValueForKey(NewBizConversationUI.jAX());
          }
        }
      }
    });
    bh.bCz();
    com.tencent.mm.model.c.bzG().add(this.afrq);
    this.vGY = System.currentTimeMillis();
    this.vIz.alive();
    AppMethodBeat.o(38688);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(38695);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    bh.bCz();
    com.tencent.mm.storage.au localau = com.tencent.mm.model.c.bzA().JE(this.talker);
    if (localau == null)
    {
      Log.e("MicroMsg.NewBizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38695);
      return;
    }
    String str = localau.aSV();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (Util.isNullOrNil(localau.field_nickname)) {
        paramView = getString(R.l.gzv);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.p.b(this, paramView));
    if (d.rs(localau.field_type))
    {
      if (!localau.aSQ()) {
        break label205;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.biz_contact_unset_star);
    }
    for (;;)
    {
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.main_conversation_longclick_delete_biz_service);
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.main_delete);
      AppMethodBeat.o(38695);
      return;
      label205:
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.biz_contact_set_star);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38690);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38679);
        NewBizConversationUI.e(NewBizConversationUI.this);
        NewBizConversationUI.f(NewBizConversationUI.this);
        NewBizConversationUI.g(NewBizConversationUI.this);
        AppMethodBeat.o(38679);
      }
    });
    this.vIz.dead();
    if (bh.baz())
    {
      bh.bCz();
      com.tencent.mm.model.c.bzG().remove(this.afrq);
    }
    if (this.afrq != null) {
      this.afrq.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(38690);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38692);
    Log.i("MicroMsg.NewBizConversationUI", "on pause");
    if (this.afrq != null) {
      this.afrq.onPause();
    }
    super.onPause();
    AppMethodBeat.o(38692);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38691);
    Log.v("MicroMsg.NewBizConversationUI", "on resume");
    if (this.afrq != null) {
      this.afrq.onResume();
    }
    super.onResume();
    AppMethodBeat.o(38691);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(256997);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.addAll(super.importUIComponents());
    paramHashSet.add(q.class);
    AppMethodBeat.o(256997);
  }
  
  static final class a
    extends g
  {
    private String hUQ;
    HashMap<String, NewBizConversationUI.b> vOc;
    
    public a(Context paramContext, String paramString, x.a parama)
    {
      super(parama);
      AppMethodBeat.i(38683);
      this.hUQ = paramString;
      this.vOc = new HashMap();
      AppMethodBeat.o(38683);
    }
    
    public final void a(bb parambb, int paramInt)
    {
      AppMethodBeat.i(38686);
      bh.bCz();
      a(parambb, com.tencent.mm.model.c.bzG().k(parambb), paramInt, true);
      AppMethodBeat.o(38686);
    }
    
    protected final void a(bb parambb, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      AppMethodBeat.i(38685);
      if (parambb == null)
      {
        AppMethodBeat.o(38685);
        return;
      }
      NewBizConversationUI.b localb = (NewBizConversationUI.b)this.vOc.get(parambb.field_username);
      if (localb == null)
      {
        localb = new NewBizConversationUI.b((byte)0);
        this.vOc.put(parambb.field_username, localb);
      }
      for (;;)
      {
        if (localb.oTP > 0)
        {
          AppMethodBeat.o(38685);
          return;
        }
        localb.abtU = paramBoolean1;
        if ((localb.abtX) || (parambb.field_unReadCount > 0)) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          localb.abtX = paramBoolean1;
          localb.ILB = (paramInt + 1);
          if (paramBoolean2) {
            localb.oTP = localb.ILB;
          }
          localb.abtW = ((int)(System.currentTimeMillis() / 1000L));
          if (parambb.field_lastSeq != localb.seq) {
            break;
          }
          AppMethodBeat.o(38685);
          return;
        }
        localb.seq = parambb.field_lastSeq;
        parambb = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLG(parambb.field_username);
        if ((parambb != null) && (parambb.iYe()))
        {
          parambb = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(parambb.field_msgId, parambb.field_content);
          if ((parambb != null) && (!Util.isNullOrNil(parambb.nUC)) && (!Util.isNullOrNil(((v)parambb.nUC.get(0)).url))) {
            try
            {
              parambb = Uri.parse(((v)parambb.nUC.get(0)).url);
              localb.abtS = Util.getLong(parambb.getQueryParameter("mid"), 0L);
              localb.abtT = Util.getInt(parambb.getQueryParameter("idx"), 0);
              AppMethodBeat.o(38685);
              return;
            }
            catch (UnsupportedOperationException parambb)
            {
              Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { parambb.getMessage() });
              AppMethodBeat.o(38685);
              return;
            }
            catch (Exception parambb)
            {
              Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { parambb.getMessage() });
            }
          }
        }
        AppMethodBeat.o(38685);
        return;
      }
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(38684);
      bh.bCz();
      w(com.tencent.mm.model.c.bzG().a(1, this.lMF, this.hUQ));
      if (this.adDx != null) {
        this.adDx.bWC();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38684);
    }
  }
  
  static final class b
    extends epw
  {
    public int oTP = -1;
    public long seq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI
 * JD-Core Version:    0.7.0.1
 */