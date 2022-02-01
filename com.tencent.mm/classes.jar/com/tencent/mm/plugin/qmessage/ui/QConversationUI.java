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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
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
  private n.e oao;
  private an pSY;
  private boolean vsD;
  private ListView xqm;
  private c xqn;
  private com.tencent.mm.plugin.qmessage.a.c xqo;
  private boolean xqp;
  private String xqq;
  private String xqr;
  private boolean xqs;
  private String xqt;
  
  public QConversationUI()
  {
    AppMethodBeat.i(27780);
    this.vsD = false;
    this.xqp = false;
    this.xqs = false;
    this.isDeleteCancel = false;
    this.oao = new n.e()
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
  
  private static String bc(Context paramContext, String paramString)
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
        break label99;
      }
      paramContext = paramContext.activityInfo.name;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.QConversationUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(27787);
    return paramContext;
  }
  
  private static void dFr()
  {
    AppMethodBeat.i(27784);
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azI().Km(2);
    if ((localObject != null) && (((ei)localObject).field_msgId > 0L))
    {
      ae.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + ((ei)localObject).field_createTime);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(12295, Long.valueOf(((ei)localObject).field_createTime));
    }
    bc.aCg();
    localObject = com.tencent.mm.model.c.azL().aVa("qmessage");
    if ((localObject == null) || (bu.nullAsNil(((ba)localObject).field_username).length() <= 0))
    {
      ae.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
      AppMethodBeat.o(27784);
      return;
    }
    ((au)localObject).kr(0);
    bc.aCg();
    if (com.tencent.mm.model.c.azL().a((au)localObject, ((ba)localObject).field_username) == -1) {
      ae.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
    }
    AppMethodBeat.o(27784);
  }
  
  private void dFs()
  {
    AppMethodBeat.i(27788);
    if (bu.isNullOrNil(this.xqq))
    {
      AppMethodBeat.o(27788);
      return;
    }
    this.xqp = true;
    addIconOptionMenu(0, 2131755128, 2131691057, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27779);
        if (!bu.isNullOrNil(QConversationUI.f(QConversationUI.this))) {
          QConversationUI.a(QConversationUI.this, QConversationUI.f(QConversationUI.this), QConversationUI.g(QConversationUI.this));
        }
        AppMethodBeat.o(27779);
        return true;
      }
    });
    AppMethodBeat.o(27788);
  }
  
  private void dFt()
  {
    AppMethodBeat.i(27789);
    removeAllOptionMenu();
    dFs();
    addIconOptionMenu(2, 2131755131, 2131689511, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27767);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Contact_User", QConversationUI.a(QConversationUI.this).field_username);
        paramAnonymousMenuItem.putExtra("Chat_Readonly", true);
        com.tencent.mm.plugin.qmessage.a.iUz.c(paramAnonymousMenuItem, QConversationUI.this.getContext());
        AppMethodBeat.o(27767);
        return true;
      }
    });
    AppMethodBeat.o(27789);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(27791);
    if (this.vsD)
    {
      finish();
      AppMethodBeat.o(27791);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.plugin.qmessage.a.iUz.p(localIntent, this);
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
    this.vsD = getIntent().getBooleanExtra("finish_direct", false);
    ae.d("MicroMsg.QConversationUI", "isFromSearch  " + this.vsD);
    bc.aCg();
    this.pSY = com.tencent.mm.model.c.azF().BH("qmessage");
    if ((this.pSY != null) && ((int)this.pSY.ght > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("can not find qmessage", bool);
      this.xqm = ((ListView)findViewById(2131305951));
      this.emptyTipTv = ((TextView)findViewById(2131299468));
      this.emptyTipTv.setText(2131758420);
      this.xqn = new c(this, new r.a()
      {
        public final void aSR()
        {
          AppMethodBeat.i(27766);
          QConversationUI localQConversationUI = QConversationUI.this;
          String str = QConversationUI.a(QConversationUI.this).adF();
          int i = y.Bk(x.hHY);
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
      this.xqn.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
        {
          AppMethodBeat.i(27772);
          int i = QConversationUI.c(QConversationUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(27772);
          return i;
        }
      });
      this.xqn.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(27773);
          QConversationUI.c(QConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(27773);
        }
      });
      this.xqn.a(new MMSlideDelView.f()
      {
        public final void cQ(Object paramAnonymousObject)
        {
          AppMethodBeat.i(27774);
          if (paramAnonymousObject == null)
          {
            ae.e("MicroMsg.QConversationUI", "onItemDel object null");
            AppMethodBeat.o(27774);
            return;
          }
          QConversationUI.a(QConversationUI.this, paramAnonymousObject.toString());
          AppMethodBeat.o(27774);
        }
      });
      this.xqm.setAdapter(this.xqn);
      this.xqm.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(27775);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qmessage/ui/QConversationUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          paramAnonymousAdapterView = (au)QConversationUI.b(QConversationUI.this).getItem(paramAnonymousInt);
          paramAnonymousView = new Intent();
          paramAnonymousView.addFlags(67108864);
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("key_need_send_video", false);
          com.tencent.mm.plugin.qmessage.a.iUz.d(paramAnonymousView, QConversationUI.this.getContext());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(27775);
        }
      });
      final com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(this);
      this.xqm.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(27776);
          if (paramAnonymousInt < QConversationUI.c(QConversationUI.this).getHeaderViewsCount())
          {
            ae.w("MicroMsg.QConversationUI", "on header view long click, ignore");
            AppMethodBeat.o(27776);
            return true;
          }
          locala.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, QConversationUI.this, QConversationUI.d(QConversationUI.this), 0, 0);
          AppMethodBeat.o(27776);
          return true;
        }
      });
      com.tencent.mm.plugin.qmessage.a.xpR.hu(1010);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = QConversationUI.c(QConversationUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27778);
        }
      });
      bc.aCg();
      this.xqq = ((String)com.tencent.mm.model.c.ajA().get(77, ""));
      bc.aCg();
      this.xqr = ((String)com.tencent.mm.model.c.ajA().get(78, ""));
      if (this.xqo == null)
      {
        this.xqo = new com.tencent.mm.plugin.qmessage.a.c();
        bc.ajj().a(this.xqo.getType(), this);
      }
      bc.ajj().a(this.xqo, 0);
      dFt();
      com.tencent.mm.plugin.qmessage.a.xpR.hu(1010);
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
    paramView = (au)this.xqn.getItem(paramView.position);
    bc.aCg();
    paramContextMenu.setHeaderTitle(com.tencent.mm.model.c.azF().BH(paramView.field_username).adG());
    paramContextMenu.add(0, 0, 0, 2131761057);
    this.xqt = paramView.field_username;
    AppMethodBeat.o(27792);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27782);
    this.xqn.dhl();
    if (this.xqo != null)
    {
      bc.ajj().a(this.xqo);
      bc.ajj().b(this.xqo.getType(), this);
      this.xqo = null;
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
    ae.v("MicroMsg.QConversationUI", "on pause");
    bc.aCg();
    com.tencent.mm.model.c.azL().b(this.xqn);
    dFr();
    this.xqn.onPause();
    super.onPause();
    AppMethodBeat.o(27785);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27783);
    super.onResume();
    dFr();
    bc.aCg();
    com.tencent.mm.model.c.azL().a(this.xqn);
    this.xqn.a(null, null);
    AppMethodBeat.o(27783);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject2 = null;
    AppMethodBeat.i(27793);
    ae.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    }
    do
    {
      AppMethodBeat.o(27793);
      return;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    Object localObject3 = (com.tencent.mm.plugin.qmessage.a.c)paramn;
    if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).isS != null)
    {
      paramString = (bdb)((com.tencent.mm.plugin.qmessage.a.c)localObject3).isS.hQE.hQJ;
      if (paramString == null) {}
    }
    for (paramString = paramString.GSC;; paramString = null)
    {
      if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).isS != null)
      {
        paramn = (bdb)((com.tencent.mm.plugin.qmessage.a.c)localObject3).isS.hQE.hQJ;
        if (paramn == null) {}
      }
      for (paramn = paramn.ucL;; paramn = null)
      {
        Object localObject1 = localObject2;
        if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).isS != null)
        {
          localObject3 = (bdb)((com.tencent.mm.plugin.qmessage.a.c)localObject3).isS.hQE.hQJ;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((bdb)localObject3).GSD;
          }
        }
        if (!bu.isNullOrNil((String)localObject1))
        {
          this.xqq = ((String)localObject1);
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(77, localObject1);
        }
        this.xqr = paramn;
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(78, paramn);
        if (!this.xqp) {
          dFt();
        }
        ae.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[] { paramString, paramn, localObject1 });
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