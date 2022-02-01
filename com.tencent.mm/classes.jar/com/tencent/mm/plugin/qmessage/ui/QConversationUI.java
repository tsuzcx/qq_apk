package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.r.a;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class QConversationUI
  extends MMActivity
  implements f
{
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private n.e nUI;
  private am pMt;
  private boolean vgw;
  private String xaA;
  private boolean xaB;
  private String xaC;
  private ListView xav;
  private c xaw;
  private com.tencent.mm.plugin.qmessage.a.c xax;
  private boolean xay;
  private String xaz;
  
  public QConversationUI()
  {
    AppMethodBeat.i(27780);
    this.vgw = false;
    this.xay = false;
    this.xaB = false;
    this.isDeleteCancel = false;
    this.nUI = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(27771);
        QConversationUI.a(QConversationUI.this, QConversationUI.j(QConversationUI.this));
        AppMethodBeat.o(27771);
      }
    };
    AppMethodBeat.o(27780);
  }
  
  private static String ba(Context paramContext, String paramString)
  {
    AppMethodBeat.i(27787);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext == null) {
        break label100;
      }
      paramContext = paramContext.activityInfo.name;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.QConversationUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(27787);
    return paramContext;
  }
  
  private static void dCa()
  {
    AppMethodBeat.i(27784);
    com.tencent.mm.model.ba.aBQ();
    Object localObject = com.tencent.mm.model.c.azs().JN(2);
    if ((localObject != null) && (((ei)localObject).field_msgId > 0L))
    {
      ad.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + ((ei)localObject).field_createTime);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.ajl().set(12295, Long.valueOf(((ei)localObject).field_createTime));
    }
    com.tencent.mm.model.ba.aBQ();
    localObject = com.tencent.mm.model.c.azv().aTz("qmessage");
    if ((localObject == null) || (bt.nullAsNil(((com.tencent.mm.g.c.ba)localObject).field_username).length() <= 0))
    {
      ad.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
      AppMethodBeat.o(27784);
      return;
    }
    ((at)localObject).kp(0);
    com.tencent.mm.model.ba.aBQ();
    if (com.tencent.mm.model.c.azv().a((at)localObject, ((com.tencent.mm.g.c.ba)localObject).field_username) == -1) {
      ad.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
    }
    AppMethodBeat.o(27784);
  }
  
  private void dCb()
  {
    AppMethodBeat.i(27788);
    if (bt.isNullOrNil(this.xaz))
    {
      AppMethodBeat.o(27788);
      return;
    }
    this.xay = true;
    addIconOptionMenu(0, 2131755128, 2131691057, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27779);
        if (!bt.isNullOrNil(QConversationUI.f(QConversationUI.this))) {
          QConversationUI.a(QConversationUI.this, QConversationUI.f(QConversationUI.this), QConversationUI.g(QConversationUI.this));
        }
        AppMethodBeat.o(27779);
        return true;
      }
    });
    AppMethodBeat.o(27788);
  }
  
  private void dCc()
  {
    AppMethodBeat.i(27789);
    removeAllOptionMenu();
    dCb();
    addIconOptionMenu(2, 2131755131, 2131689511, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27767);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Contact_User", QConversationUI.a(QConversationUI.this).field_username);
        paramAnonymousMenuItem.putExtra("Chat_Readonly", true);
        com.tencent.mm.plugin.qmessage.a.iRG.c(paramAnonymousMenuItem, QConversationUI.this.getContext());
        AppMethodBeat.o(27767);
        return true;
      }
    });
    AppMethodBeat.o(27789);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(27791);
    if (this.vgw)
    {
      finish();
      AppMethodBeat.o(27791);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.plugin.qmessage.a.iRG.p(localIntent, this);
    overridePendingTransition(2130771986, 2130772100);
    AppMethodBeat.o(27791);
  }
  
  public int getLayoutId()
  {
    return 2131495762;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27786);
    this.vgw = getIntent().getBooleanExtra("finish_direct", false);
    ad.d("MicroMsg.QConversationUI", "isFromSearch  " + this.vgw);
    com.tencent.mm.model.ba.aBQ();
    this.pMt = com.tencent.mm.model.c.azp().Bf("qmessage");
    if ((this.pMt != null) && ((int)this.pMt.gfj > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("can not find qmessage", bool);
      this.xav = ((ListView)findViewById(2131305951));
      this.emptyTipTv = ((TextView)findViewById(2131299468));
      this.emptyTipTv.setText(2131758420);
      this.xaw = new c(this, new r.a()
      {
        public final void aSs()
        {
          AppMethodBeat.i(27766);
          QConversationUI localQConversationUI = QConversationUI.this;
          String str = QConversationUI.a(QConversationUI.this).adu();
          int i = x.AA(w.hFg);
          if (i <= 0) {
            localQConversationUI.setMMTitle(str);
          }
          for (;;)
          {
            QConversationUI.a(QConversationUI.this, QConversationUI.b(QConversationUI.this).getCount());
            AppMethodBeat.o(27766);
            return;
            localQConversationUI.setMMTitle(str + "(" + i + ")");
          }
        }
      });
      this.xaw.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
        {
          AppMethodBeat.i(27772);
          int i = QConversationUI.c(QConversationUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(27772);
          return i;
        }
      });
      this.xaw.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(27773);
          QConversationUI.c(QConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(27773);
        }
      });
      this.xaw.a(new MMSlideDelView.f()
      {
        public final void cP(Object paramAnonymousObject)
        {
          AppMethodBeat.i(27774);
          if (paramAnonymousObject == null)
          {
            ad.e("MicroMsg.QConversationUI", "onItemDel object null");
            AppMethodBeat.o(27774);
            return;
          }
          QConversationUI.a(QConversationUI.this, paramAnonymousObject.toString());
          AppMethodBeat.o(27774);
        }
      });
      this.xav.setAdapter(this.xaw);
      this.xav.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(27775);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qmessage/ui/QConversationUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          paramAnonymousAdapterView = (at)QConversationUI.b(QConversationUI.this).getItem(paramAnonymousInt);
          paramAnonymousView = new Intent();
          paramAnonymousView.addFlags(67108864);
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("key_need_send_video", false);
          com.tencent.mm.plugin.qmessage.a.iRG.d(paramAnonymousView, QConversationUI.this.getContext());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(27775);
        }
      });
      final com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(this);
      this.xav.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(27776);
          if (paramAnonymousInt < QConversationUI.c(QConversationUI.this).getHeaderViewsCount())
          {
            ad.w("MicroMsg.QConversationUI", "on header view long click, ignore");
            AppMethodBeat.o(27776);
            return true;
          }
          locala.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, QConversationUI.this, QConversationUI.d(QConversationUI.this), 0, 0);
          AppMethodBeat.o(27776);
          return true;
        }
      });
      com.tencent.mm.plugin.qmessage.a.xaa.hu(1010);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27777);
          QConversationUI.e(QConversationUI.this);
          AppMethodBeat.o(27777);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27778);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = QConversationUI.c(QConversationUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27778);
        }
      });
      com.tencent.mm.model.ba.aBQ();
      this.xaz = ((String)com.tencent.mm.model.c.ajl().get(77, ""));
      com.tencent.mm.model.ba.aBQ();
      this.xaA = ((String)com.tencent.mm.model.c.ajl().get(78, ""));
      if (this.xax == null)
      {
        this.xax = new com.tencent.mm.plugin.qmessage.a.c();
        com.tencent.mm.model.ba.aiU().a(this.xax.getType(), this);
      }
      com.tencent.mm.model.ba.aiU().a(this.xax, 0);
      dCc();
      com.tencent.mm.plugin.qmessage.a.xaa.hu(1010);
      AppMethodBeat.o(27786);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27781);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(27781);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(27792);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramView = (at)this.xaw.getItem(paramView.position);
    com.tencent.mm.model.ba.aBQ();
    paramContextMenu.setHeaderTitle(com.tencent.mm.model.c.azp().Bf(paramView.field_username).adv());
    paramContextMenu.add(0, 0, 0, 2131761057);
    this.xaC = paramView.field_username;
    AppMethodBeat.o(27792);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27782);
    this.xaw.det();
    if (this.xax != null)
    {
      com.tencent.mm.model.ba.aiU().a(this.xax);
      com.tencent.mm.model.ba.aiU().b(this.xax.getType(), this);
      this.xax = null;
    }
    super.onDestroy();
    AppMethodBeat.o(27782);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27790);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(27790);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(27790);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27785);
    ad.v("MicroMsg.QConversationUI", "on pause");
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azv().b(this.xaw);
    dCa();
    this.xaw.onPause();
    super.onPause();
    AppMethodBeat.o(27785);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27783);
    super.onResume();
    dCa();
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azv().a(this.xaw);
    this.xaw.a(null, null);
    AppMethodBeat.o(27783);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject2 = null;
    AppMethodBeat.i(27793);
    ad.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    }
    do
    {
      AppMethodBeat.o(27793);
      return;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    Object localObject3 = (com.tencent.mm.plugin.qmessage.a.c)paramn;
    if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).ipX != null)
    {
      paramString = (bcl)((com.tencent.mm.plugin.qmessage.a.c)localObject3).ipX.hNL.hNQ;
      if (paramString == null) {}
    }
    for (paramString = paramString.Gzc;; paramString = null)
    {
      if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).ipX != null)
      {
        paramn = (bcl)((com.tencent.mm.plugin.qmessage.a.c)localObject3).ipX.hNL.hNQ;
        if (paramn == null) {}
      }
      for (paramn = paramn.tRU;; paramn = null)
      {
        Object localObject1 = localObject2;
        if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).ipX != null)
        {
          localObject3 = (bcl)((com.tencent.mm.plugin.qmessage.a.c)localObject3).ipX.hNL.hNQ;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((bcl)localObject3).Gzd;
          }
        }
        if (!bt.isNullOrNil((String)localObject1))
        {
          this.xaz = ((String)localObject1);
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.ajl().set(77, localObject1);
        }
        this.xaA = paramn;
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.ajl().set(78, paramn);
        if (!this.xay) {
          dCc();
        }
        ad.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[] { paramString, paramn, localObject1 });
        break;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI
 * JD-Core Version:    0.7.0.1
 */