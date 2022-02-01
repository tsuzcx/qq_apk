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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r.a;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class QConversationUI
  extends MMActivity
  implements g
{
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private n.d ntM;
  private ai piT;
  private boolean udM;
  private ListView vTl;
  private c vTm;
  private com.tencent.mm.plugin.qmessage.a.c vTn;
  private boolean vTo;
  private String vTp;
  private String vTq;
  private boolean vTr;
  private String vTs;
  
  public QConversationUI()
  {
    AppMethodBeat.i(27780);
    this.udM = false;
    this.vTo = false;
    this.vTr = false;
    this.isDeleteCancel = false;
    this.ntM = new n.d()
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
  
  private static String aX(Context paramContext, String paramString)
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
        ac.printErrStackTrace("MicroMsg.QConversationUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(27787);
    return paramContext;
  }
  
  private void drA()
  {
    AppMethodBeat.i(27789);
    removeAllOptionMenu();
    drz();
    addIconOptionMenu(2, 2131755131, 2131689511, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27767);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Contact_User", QConversationUI.a(QConversationUI.this).field_username);
        paramAnonymousMenuItem.putExtra("Chat_Readonly", true);
        com.tencent.mm.plugin.qmessage.a.iyx.c(paramAnonymousMenuItem, QConversationUI.this.getContext());
        AppMethodBeat.o(27767);
        return true;
      }
    });
    AppMethodBeat.o(27789);
  }
  
  private static void dry()
  {
    AppMethodBeat.i(27784);
    com.tencent.mm.model.az.ayM();
    Object localObject = com.tencent.mm.model.c.awD().Iq(2);
    if ((localObject != null) && (((dy)localObject).field_msgId > 0L))
    {
      ac.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + ((dy)localObject).field_createTime);
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.agA().set(12295, Long.valueOf(((dy)localObject).field_createTime));
    }
    com.tencent.mm.model.az.ayM();
    localObject = com.tencent.mm.model.c.awG().aNI("qmessage");
    if ((localObject == null) || (bs.nullAsNil(((com.tencent.mm.g.c.az)localObject).field_username).length() <= 0))
    {
      ac.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
      AppMethodBeat.o(27784);
      return;
    }
    ((ap)localObject).jR(0);
    com.tencent.mm.model.az.ayM();
    if (com.tencent.mm.model.c.awG().a((ap)localObject, ((com.tencent.mm.g.c.az)localObject).field_username) == -1) {
      ac.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
    }
    AppMethodBeat.o(27784);
  }
  
  private void drz()
  {
    AppMethodBeat.i(27788);
    if (bs.isNullOrNil(this.vTp))
    {
      AppMethodBeat.o(27788);
      return;
    }
    this.vTo = true;
    addIconOptionMenu(0, 2131755128, 2131691057, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27779);
        if (!bs.isNullOrNil(QConversationUI.f(QConversationUI.this))) {
          QConversationUI.a(QConversationUI.this, QConversationUI.f(QConversationUI.this), QConversationUI.g(QConversationUI.this));
        }
        AppMethodBeat.o(27779);
        return true;
      }
    });
    AppMethodBeat.o(27788);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(27791);
    if (this.udM)
    {
      finish();
      AppMethodBeat.o(27791);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.plugin.qmessage.a.iyx.p(localIntent, this);
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
    this.udM = getIntent().getBooleanExtra("finish_direct", false);
    ac.d("MicroMsg.QConversationUI", "isFromSearch  " + this.udM);
    com.tencent.mm.model.az.ayM();
    this.piT = com.tencent.mm.model.c.awB().aNt("qmessage");
    if ((this.piT != null) && ((int)this.piT.fLJ > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("can not find qmessage", bool);
      this.vTl = ((ListView)findViewById(2131305951));
      this.emptyTipTv = ((TextView)findViewById(2131299468));
      this.emptyTipTv.setText(2131758420);
      this.vTm = new c(this, new r.a()
      {
        public final void aPg()
        {
          AppMethodBeat.i(27766);
          QConversationUI localQConversationUI = QConversationUI.this;
          String str = QConversationUI.a(QConversationUI.this).aaR();
          int i = x.xC(w.hmQ);
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
      this.vTm.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dy(View paramAnonymousView)
        {
          AppMethodBeat.i(27772);
          int i = QConversationUI.c(QConversationUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(27772);
          return i;
        }
      });
      this.vTm.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(27773);
          QConversationUI.c(QConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(27773);
        }
      });
      this.vTm.a(new MMSlideDelView.f()
      {
        public final void cN(Object paramAnonymousObject)
        {
          AppMethodBeat.i(27774);
          if (paramAnonymousObject == null)
          {
            ac.e("MicroMsg.QConversationUI", "onItemDel object null");
            AppMethodBeat.o(27774);
            return;
          }
          QConversationUI.a(QConversationUI.this, paramAnonymousObject.toString());
          AppMethodBeat.o(27774);
        }
      });
      this.vTl.setAdapter(this.vTm);
      this.vTl.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(27775);
          paramAnonymousAdapterView = (ap)QConversationUI.b(QConversationUI.this).getItem(paramAnonymousInt);
          paramAnonymousView = new Intent();
          paramAnonymousView.addFlags(67108864);
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("key_need_send_video", false);
          com.tencent.mm.plugin.qmessage.a.iyx.d(paramAnonymousView, QConversationUI.this.getContext());
          AppMethodBeat.o(27775);
        }
      });
      final com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(this);
      this.vTl.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(27776);
          if (paramAnonymousInt < QConversationUI.c(QConversationUI.this).getHeaderViewsCount())
          {
            ac.w("MicroMsg.QConversationUI", "on header view long click, ignore");
            AppMethodBeat.o(27776);
            return true;
          }
          locala.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, QConversationUI.this, QConversationUI.d(QConversationUI.this), 0, 0);
          AppMethodBeat.o(27776);
          return true;
        }
      });
      com.tencent.mm.plugin.qmessage.a.vSQ.hn(1010);
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
          paramAnonymousView = QConversationUI.c(QConversationUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(27778);
        }
      });
      com.tencent.mm.model.az.ayM();
      this.vTp = ((String)com.tencent.mm.model.c.agA().get(77, ""));
      com.tencent.mm.model.az.ayM();
      this.vTq = ((String)com.tencent.mm.model.c.agA().get(78, ""));
      if (this.vTn == null)
      {
        this.vTn = new com.tencent.mm.plugin.qmessage.a.c();
        com.tencent.mm.model.az.agi().a(this.vTn.getType(), this);
      }
      com.tencent.mm.model.az.agi().a(this.vTn, 0);
      drA();
      com.tencent.mm.plugin.qmessage.a.vSQ.hn(1010);
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
    paramView = (ap)this.vTm.getItem(paramView.position);
    com.tencent.mm.model.az.ayM();
    paramContextMenu.setHeaderTitle(com.tencent.mm.model.c.awB().aNt(paramView.field_username).aaS());
    paramContextMenu.add(0, 0, 0, 2131761057);
    this.vTs = paramView.field_username;
    AppMethodBeat.o(27792);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27782);
    this.vTm.cVi();
    if (this.vTn != null)
    {
      com.tencent.mm.model.az.agi().a(this.vTn);
      com.tencent.mm.model.az.agi().b(this.vTn.getType(), this);
      this.vTn = null;
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
    ac.v("MicroMsg.QConversationUI", "on pause");
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awG().b(this.vTm);
    dry();
    this.vTm.onPause();
    super.onPause();
    AppMethodBeat.o(27785);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27783);
    super.onResume();
    dry();
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awG().a(this.vTm);
    this.vTm.a(null, null);
    AppMethodBeat.o(27783);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject2 = null;
    AppMethodBeat.i(27793);
    ac.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    }
    do
    {
      AppMethodBeat.o(27793);
      return;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    Object localObject3 = (com.tencent.mm.plugin.qmessage.a.c)paramn;
    if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).hWC != null)
    {
      paramString = (ayh)((com.tencent.mm.plugin.qmessage.a.c)localObject3).hWC.hvs.hvw;
      if (paramString == null) {}
    }
    for (paramString = paramString.EPL;; paramString = null)
    {
      if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).hWC != null)
      {
        paramn = (ayh)((com.tencent.mm.plugin.qmessage.a.c)localObject3).hWC.hvs.hvw;
        if (paramn == null) {}
      }
      for (paramn = paramn.sVp;; paramn = null)
      {
        Object localObject1 = localObject2;
        if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).hWC != null)
        {
          localObject3 = (ayh)((com.tencent.mm.plugin.qmessage.a.c)localObject3).hWC.hvs.hvw;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((ayh)localObject3).EPM;
          }
        }
        if (!bs.isNullOrNil((String)localObject1))
        {
          this.vTp = ((String)localObject1);
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.agA().set(77, localObject1);
        }
        this.vTq = paramn;
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.agA().set(78, paramn);
        if (!this.vTo) {
          drA();
        }
        ac.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[] { paramString, paramn, localObject1 });
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