package com.tencent.mm.ui.conversation;

import android.app.Activity;
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
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cxd;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.v.a;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.LinkedList;

public class NewBizConversationUI
  extends MMActivity
{
  private a XDM;
  private final int XDN;
  private final int XDO;
  private final int XDP;
  private final int XDQ;
  private final int XDR;
  private final int XDS;
  private ListView XzG;
  private String XzI;
  final MultiProcessMMKV cQO;
  private az conversation;
  private TextView emptyTipTv;
  private int fwM;
  private boolean isDeleteCancel;
  private String lEm;
  private q.g sBv;
  private long sBz;
  private IListener sCF;
  private int source;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.widget.b.a szq;
  private String talker;
  private s tipDialog;
  
  public NewBizConversationUI()
  {
    AppMethodBeat.i(38687);
    this.source = 1;
    this.talker = "";
    this.sBz = 0L;
    this.syc = 0;
    this.syd = 0;
    this.XDN = 1;
    this.XDO = 2;
    this.XDP = 100;
    this.XDQ = 1;
    this.XDR = 2;
    this.XDS = 3;
    this.cQO = MultiProcessMMKV.getSingleMMKV("brandService");
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.sBv = new NewBizConversationUI.10(this);
    this.sCF = new NewBizConversationUI.11(this);
    AppMethodBeat.o(38687);
  }
  
  private void hWD()
  {
    final boolean bool1 = true;
    AppMethodBeat.i(38689);
    removeAllOptionMenu();
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.shG;
    final boolean bool2 = com.tencent.mm.plugin.bizui.a.a.cxR();
    boolean bool3 = ((com.tencent.mm.api.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.q.class)).ZN();
    Log.d("MicroMsg.NewBizConversationUI", "open search entrance:%b, isBizTeenModeAllowAll: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool2) && (bool3)) {
      addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new NewBizConversationUI.1(this));
    }
    bool2 = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cyB();
    final int i = this.cQO.decodeInt(hWF(), 0);
    if ((i == 1) && (bool2) && (this.cQO.decodeBool("NeedShowPayActionBarRedDot", true))) {}
    for (;;)
    {
      addIconOptionMenu(0, R.l.esT, R.k.actionbar_icon_dark_more, bool1, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38675);
          if (bool1)
          {
            NewBizConversationUI.this.cQO.encode("NeedShowPayActionBarRedDot", false);
            NewBizConversationUI.a(NewBizConversationUI.this);
          }
          paramAnonymousMenuItem = new e(NewBizConversationUI.this, 1, false);
          paramAnonymousMenuItem.ODT = new q.f()
          {
            public final void onCreateMMMenu(o paramAnonymous2o)
            {
              AppMethodBeat.i(38673);
              paramAnonymous2o.mn(1, R.l.esS);
              Object localObject = NewBizConversationUI.this.cQO.decodeString("PaySubscribeEntryUrl", "");
              if ((NewBizConversationUI.12.this.XDX == 1) && (!Util.isNullOrNil((String)localObject)) && (NewBizConversationUI.12.this.XDY))
              {
                boolean bool = NewBizConversationUI.this.cQO.decodeBool("NeedShowPayRedDot", true);
                paramAnonymous2o.a(2, NewBizConversationUI.this.getString(R.l.esI), bool);
              }
              localObject = NewBizConversationUI.b(NewBizConversationUI.this);
              if ((localObject != null) && (!Util.isNullOrNil(((cxe)localObject).TFK)))
              {
                int i = 0;
                while (i < ((cxe)localObject).TFK.size())
                {
                  cxd localcxd = (cxd)((cxe)localObject).TFK.get(i);
                  if ((localcxd != null) && (localcxd.rWu == 3) && (!Util.isNullOrNil(localcxd.TFI)) && (!Util.isNullOrNil(localcxd.TFH))) {
                    paramAnonymous2o.d(i + 100, localcxd.TFI);
                  }
                  i += 1;
                }
              }
              AppMethodBeat.o(38673);
            }
          };
          paramAnonymousMenuItem.ODU = new q.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(38674);
              Object localObject;
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                localObject = NewBizConversationUI.b(NewBizConversationUI.this);
                if ((localObject != null) && (!Util.isNullOrNil(((cxe)localObject).TFK))) {
                  paramAnonymous2Int = 0;
                }
                break;
              }
              for (;;)
              {
                if (paramAnonymous2Int < ((cxe)localObject).TFK.size())
                {
                  cxd localcxd = (cxd)((cxe)localObject).TFK.get(paramAnonymous2Int);
                  if ((localcxd != null) && (localcxd.rWu == 3) && (!Util.isNullOrNil(localcxd.TFI)) && (!Util.isNullOrNil(localcxd.TFH)) && (paramAnonymous2Int + 100 == paramAnonymous2MenuItem.getItemId())) {
                    NewBizConversationUI.a(NewBizConversationUI.this, localcxd.TFH, localcxd.TFJ);
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
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(38674);
                  return;
                  NewBizConversationUI.this.cQO.encode("NeedShowPayRedDot", false);
                  paramAnonymous2MenuItem = NewBizConversationUI.this.cQO.decodeString("PaySubscribeEntryUrl", "");
                  NewBizConversationUI.a(NewBizConversationUI.this, paramAnonymous2MenuItem, true);
                  AppMethodBeat.o(38674);
                  return;
                }
                paramAnonymous2Int += 1;
              }
            }
          };
          paramAnonymousMenuItem.eik();
          AppMethodBeat.o(38675);
          return true;
        }
      });
      AppMethodBeat.o(38689);
      return;
      bool1 = false;
    }
  }
  
  private cxe hWE()
  {
    AppMethodBeat.i(251838);
    byte[] arrayOfByte = this.cQO.decodeBytes(hWG());
    if (arrayOfByte != null) {
      try
      {
        cxe localcxe = new cxe();
        localcxe.parseFrom(arrayOfByte);
        AppMethodBeat.o(251838);
        return localcxe;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.NewBizConversationUI", "getMenuEntryListInfo ex %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(251838);
    return null;
  }
  
  private static String hWF()
  {
    AppMethodBeat.i(162388);
    if (com.tencent.mm.kernel.h.aHB()) {
      com.tencent.mm.kernel.h.aHE();
    }
    for (String str = com.tencent.mm.kernel.b.aGq();; str = "")
    {
      str = str + ":PaySubscribeEntryOpen";
      AppMethodBeat.o(162388);
      return str;
    }
  }
  
  private static String hWG()
  {
    AppMethodBeat.i(251840);
    if (com.tencent.mm.kernel.h.aHB()) {
      com.tencent.mm.kernel.h.aHE();
    }
    for (String str = com.tencent.mm.kernel.b.aGq();; str = "")
    {
      str = str + ":MenuEntryListInfo";
      AppMethodBeat.o(251840);
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
    setMMTitle(this.XzI);
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
    this.XzG = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.eCf);
    this.XDM = new a(this, this.lEm, new v.a()
    {
      public final void bxN()
      {
        AppMethodBeat.i(38680);
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.h(NewBizConversationUI.this).getCount());
        AppMethodBeat.o(38680);
      }
    });
    this.XDM.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(38681);
        int i = NewBizConversationUI.i(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38681);
        return i;
      }
    });
    this.XDM.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38682);
        NewBizConversationUI.i(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38682);
      }
    });
    this.XzG.setAdapter(this.XDM);
    this.szq = new com.tencent.mm.ui.widget.b.a(this);
    this.XzG.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38662);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        NewBizConversationUI.a(NewBizConversationUI.this, (az)NewBizConversationUI.h(NewBizConversationUI.this).getItem(paramAnonymousInt));
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        NewBizConversationUI.h(NewBizConversationUI.this).a(paramAnonymousAdapterView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(38662);
      }
    });
    this.XzG.setOnTouchListener(new View.OnTouchListener()
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
    this.XzG.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38664);
        NewBizConversationUI.a(NewBizConversationUI.this, (az)NewBizConversationUI.h(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.j(NewBizConversationUI.this).field_username);
        NewBizConversationUI.n(NewBizConversationUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NewBizConversationUI.this, NewBizConversationUI.k(NewBizConversationUI.this), NewBizConversationUI.l(NewBizConversationUI.this), NewBizConversationUI.m(NewBizConversationUI.this));
        AppMethodBeat.o(38664);
        return true;
      }
    });
    this.XDM.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(38665);
        int i = NewBizConversationUI.i(NewBizConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38665);
        return i;
      }
    });
    this.XDM.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38666);
        NewBizConversationUI.i(NewBizConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38666);
      }
    });
    this.XDM.a(new MMSlideDelView.f()
    {
      public final void cW(Object paramAnonymousObject)
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
    if (!bh.aHB())
    {
      Log.e("MicroMsg.NewBizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(38688);
      return;
    }
    this.fwM = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.source = getIntent().getIntExtra("biz_enter_source", 1);
    this.lEm = "officialaccounts";
    com.tencent.mm.plugin.report.service.h.IzE.a(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.fwM), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.source), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.XzI = getIntent().getStringExtra("enterprise_biz_display_name");
    if (Util.isNullOrNil(this.XzI)) {
      this.XzI = getString(R.l.esM);
    }
    initView();
    hWD();
    paramBundle = new d.a();
    paramBundle.lBU = new py();
    paramBundle.lBV = new pz();
    paramBundle.uri = "/cgi-bin/mmbiz-bin/timeline/bizstrategy";
    paramBundle.funcId = 1806;
    paramBundle = paramBundle.bgN();
    ((py)d.b.b(paramBundle.lBR)).lpw = 65;
    aa.a(paramBundle, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(38676);
        Log.i("MicroMsg.NewBizConversationUI", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0))
        {
          AppMethodBeat.o(38676);
          return 0;
        }
        paramAnonymousString = (pz)d.c.b(paramAnonymousd.lBS);
        if ((paramAnonymousString.RYj != null) && (!Util.isNullOrNil(paramAnonymousString.RYj.TRF)))
        {
          paramAnonymousInt1 = NewBizConversationUI.this.cQO.decodeInt(NewBizConversationUI.hWH(), 0);
          NewBizConversationUI.this.cQO.encode("PaySubscribeEntryUrl", paramAnonymousString.RYj.TRF);
          NewBizConversationUI.this.cQO.encode(NewBizConversationUI.hWH(), paramAnonymousString.RYj.TRE);
          if (paramAnonymousString.RYq == null) {
            break label214;
          }
        }
        for (;;)
        {
          try
          {
            NewBizConversationUI.this.cQO.encode(NewBizConversationUI.hWI(), paramAnonymousString.RYq.toByteArray());
            if (paramAnonymousInt1 != paramAnonymousString.RYj.TRE) {
              NewBizConversationUI.a(NewBizConversationUI.this);
            }
            AppMethodBeat.o(38676);
            return 0;
          }
          catch (Exception paramAnonymousd)
          {
            Log.e("MicroMsg.NewBizConversationUI", "encode ex %s", new Object[] { paramAnonymousd.getMessage() });
            continue;
          }
          label214:
          NewBizConversationUI.this.cQO.removeValueForKey(NewBizConversationUI.hWI());
        }
      }
    });
    bh.beI();
    com.tencent.mm.model.c.bbR().add(this.XDM);
    this.sBz = System.currentTimeMillis();
    EventCenter.instance.addListener(this.sCF);
    AppMethodBeat.o(38688);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(38695);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    bh.beI();
    as localas = com.tencent.mm.model.c.bbL().RG(this.talker);
    if (localas == null)
    {
      Log.e("MicroMsg.NewBizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38695);
      return;
    }
    String str = localas.ays();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (Util.isNullOrNil(localas.field_nickname)) {
        paramView = getString(R.l.ewS);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(l.c(this, paramView));
    if (com.tencent.mm.contact.d.rk(localas.field_type))
    {
      if (!localas.ayn()) {
        break label205;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.esK);
    }
    for (;;)
    {
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.eLi);
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.main_delete);
      AppMethodBeat.o(38695);
      return;
      label205:
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.esJ);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38690);
    bh.aHJ().postToWorker(new Runnable()
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
    EventCenter.instance.removeListener(this.sCF);
    if (bh.aHB())
    {
      bh.beI();
      com.tencent.mm.model.c.bbR().remove(this.XDM);
    }
    if (this.XDM != null) {
      this.XDM.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(38690);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38692);
    Log.i("MicroMsg.NewBizConversationUI", "on pause");
    if (this.XDM != null) {
      this.XDM.onPause();
    }
    super.onPause();
    AppMethodBeat.o(38692);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38691);
    Log.v("MicroMsg.NewBizConversationUI", "on resume");
    if (this.XDM != null) {
      this.XDM.onResume();
    }
    super.onResume();
    AppMethodBeat.o(38691);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends f
  {
    private String fOX;
    HashMap<String, NewBizConversationUI.b> sIz;
    
    public a(Context paramContext, String paramString, v.a parama)
    {
      super(parama);
      AppMethodBeat.i(38683);
      this.fOX = paramString;
      this.sIz = new HashMap();
      AppMethodBeat.o(38683);
    }
    
    public final void a(az paramaz, int paramInt)
    {
      AppMethodBeat.i(38686);
      bh.beI();
      a(paramaz, com.tencent.mm.model.c.bbR().h(paramaz), paramInt, true);
      AppMethodBeat.o(38686);
    }
    
    protected final void a(az paramaz, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      AppMethodBeat.i(38685);
      if (paramaz == null)
      {
        AppMethodBeat.o(38685);
        return;
      }
      NewBizConversationUI.b localb = (NewBizConversationUI.b)this.sIz.get(paramaz.field_username);
      if (localb == null)
      {
        localb = new NewBizConversationUI.b((byte)0);
        this.sIz.put(paramaz.field_username, localb);
      }
      for (;;)
      {
        if (localb.maV > 0)
        {
          AppMethodBeat.o(38685);
          return;
        }
        localb.UcA = paramBoolean1;
        if ((localb.UcD) || (paramaz.field_unReadCount > 0)) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          localb.UcD = paramBoolean1;
          localb.CRl = (paramInt + 1);
          if (paramBoolean2) {
            localb.maV = localb.CRl;
          }
          localb.UcC = ((int)(System.currentTimeMillis() / 1000L));
          if (paramaz.field_lastSeq != localb.seq) {
            break;
          }
          AppMethodBeat.o(38685);
          return;
        }
        localb.seq = paramaz.field_lastSeq;
        paramaz = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(paramaz.field_username);
        if ((paramaz != null) && (paramaz.hwA()))
        {
          paramaz = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramaz.field_msgId, paramaz.field_content);
          if ((paramaz != null) && (!Util.isNullOrNil(paramaz.lpz)) && (!Util.isNullOrNil(((v)paramaz.lpz.get(0)).url))) {
            try
            {
              paramaz = Uri.parse(((v)paramaz.lpz.get(0)).url);
              localb.Ucy = Util.getLong(paramaz.getQueryParameter("mid"), 0L);
              localb.Ucz = Util.getInt(paramaz.getQueryParameter("idx"), 0);
              AppMethodBeat.o(38685);
              return;
            }
            catch (UnsupportedOperationException paramaz)
            {
              Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramaz.getMessage() });
              AppMethodBeat.o(38685);
              return;
            }
            catch (Exception paramaz)
            {
              Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramaz.getMessage() });
            }
          }
        }
        AppMethodBeat.o(38685);
        return;
      }
    }
    
    public final void atr()
    {
      AppMethodBeat.i(38684);
      bh.beI();
      v(com.tencent.mm.model.c.bbR().a(1, this.jkb, this.fOX));
      if (this.VZc != null) {
        this.VZc.bxN();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38684);
    }
  }
  
  static final class b
    extends dws
  {
    public int maV = -1;
    public long seq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI
 * JD-Core Version:    0.7.0.1
 */