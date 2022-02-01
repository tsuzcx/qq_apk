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
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.q.a;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class QConversationUI
  extends MMActivity
  implements g
{
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private n.d mRw;
  private af oFt;
  private boolean sVA;
  private boolean uKA;
  private String uKB;
  private ListView uKu;
  private c uKv;
  private com.tencent.mm.plugin.qmessage.a.c uKw;
  private boolean uKx;
  private String uKy;
  private String uKz;
  
  public QConversationUI()
  {
    AppMethodBeat.i(27780);
    this.sVA = false;
    this.uKx = false;
    this.uKA = false;
    this.isDeleteCancel = false;
    this.mRw = new n.d()
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
  
  private static String aW(Context paramContext, String paramString)
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
  
  private static void ddQ()
  {
    AppMethodBeat.i(27784);
    az.arV();
    Object localObject = com.tencent.mm.model.c.apO().Gu(2);
    if ((localObject != null) && (((du)localObject).field_msgId > 0L))
    {
      ad.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + ((du)localObject).field_createTime);
      az.arV();
      com.tencent.mm.model.c.afk().set(12295, Long.valueOf(((du)localObject).field_createTime));
    }
    az.arV();
    localObject = com.tencent.mm.model.c.apR().aIn("qmessage");
    if ((localObject == null) || (bt.nullAsNil(((ay)localObject).field_username).length() <= 0))
    {
      ad.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
      AppMethodBeat.o(27784);
      return;
    }
    ((am)localObject).jT(0);
    az.arV();
    if (com.tencent.mm.model.c.apR().a((am)localObject, ((ay)localObject).field_username) == -1) {
      ad.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
    }
    AppMethodBeat.o(27784);
  }
  
  private void ddR()
  {
    AppMethodBeat.i(27788);
    if (bt.isNullOrNil(this.uKy))
    {
      AppMethodBeat.o(27788);
      return;
    }
    this.uKx = true;
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
  
  private void ddS()
  {
    AppMethodBeat.i(27789);
    removeAllOptionMenu();
    ddR();
    addIconOptionMenu(2, 2131755131, 2131689511, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27767);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Contact_User", QConversationUI.a(QConversationUI.this).field_username);
        paramAnonymousMenuItem.putExtra("Chat_Readonly", true);
        com.tencent.mm.plugin.qmessage.a.hYt.c(paramAnonymousMenuItem, QConversationUI.this.getContext());
        AppMethodBeat.o(27767);
        return true;
      }
    });
    AppMethodBeat.o(27789);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(27791);
    if (this.sVA)
    {
      finish();
      AppMethodBeat.o(27791);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.plugin.qmessage.a.hYt.p(localIntent, this);
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
    this.sVA = getIntent().getBooleanExtra("finish_direct", false);
    ad.d("MicroMsg.QConversationUI", "isFromSearch  " + this.sVA);
    az.arV();
    this.oFt = com.tencent.mm.model.c.apM().aHY("qmessage");
    if ((this.oFt != null) && ((int)this.oFt.fId > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("can not find qmessage", bool);
      this.uKu = ((ListView)findViewById(2131305951));
      this.emptyTipTv = ((TextView)findViewById(2131299468));
      this.emptyTipTv.setText(2131758420);
      this.uKv = new c(this, new q.a()
      {
        public final void aIp()
        {
          AppMethodBeat.i(27766);
          QConversationUI localQConversationUI = QConversationUI.this;
          String str = QConversationUI.a(QConversationUI.this).ZW();
          int i = x.tz(w.gMq);
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
      this.uKv.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dw(View paramAnonymousView)
        {
          AppMethodBeat.i(27772);
          int i = QConversationUI.c(QConversationUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(27772);
          return i;
        }
      });
      this.uKv.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(27773);
          QConversationUI.c(QConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(27773);
        }
      });
      this.uKv.a(new MMSlideDelView.f()
      {
        public final void cO(Object paramAnonymousObject)
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
      this.uKu.setAdapter(this.uKv);
      this.uKu.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(27775);
          paramAnonymousAdapterView = (am)QConversationUI.b(QConversationUI.this).getItem(paramAnonymousInt);
          paramAnonymousView = new Intent();
          paramAnonymousView.addFlags(67108864);
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("key_need_send_video", false);
          com.tencent.mm.plugin.qmessage.a.hYt.d(paramAnonymousView, QConversationUI.this.getContext());
          AppMethodBeat.o(27775);
        }
      });
      final com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(this);
      this.uKu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
      com.tencent.mm.plugin.qmessage.a.uJZ.hD(1010);
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
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(27778);
        }
      });
      az.arV();
      this.uKy = ((String)com.tencent.mm.model.c.afk().get(77, ""));
      az.arV();
      this.uKz = ((String)com.tencent.mm.model.c.afk().get(78, ""));
      if (this.uKw == null)
      {
        this.uKw = new com.tencent.mm.plugin.qmessage.a.c();
        az.aeS().a(this.uKw.getType(), this);
      }
      az.aeS().a(this.uKw, 0);
      ddS();
      com.tencent.mm.plugin.qmessage.a.uJZ.hD(1010);
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
    paramView = (am)this.uKv.getItem(paramView.position);
    az.arV();
    paramContextMenu.setHeaderTitle(com.tencent.mm.model.c.apM().aHY(paramView.field_username).ZX());
    paramContextMenu.add(0, 0, 0, 2131761057);
    this.uKB = paramView.field_username;
    AppMethodBeat.o(27792);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27782);
    this.uKv.cHX();
    if (this.uKw != null)
    {
      az.aeS().a(this.uKw);
      az.aeS().b(this.uKw.getType(), this);
      this.uKw = null;
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
    az.arV();
    com.tencent.mm.model.c.apR().b(this.uKv);
    ddQ();
    this.uKv.onPause();
    super.onPause();
    AppMethodBeat.o(27785);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27783);
    super.onResume();
    ddQ();
    az.arV();
    com.tencent.mm.model.c.apR().a(this.uKv);
    this.uKv.a(null, null);
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
    if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).hwb != null)
    {
      paramString = (avb)((com.tencent.mm.plugin.qmessage.a.c)localObject3).hwb.gUT.gUX;
      if (paramString == null) {}
    }
    for (paramString = paramString.DuC;; paramString = null)
    {
      if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).hwb != null)
      {
        paramn = (avb)((com.tencent.mm.plugin.qmessage.a.c)localObject3).hwb.gUT.gUX;
        if (paramn == null) {}
      }
      for (paramn = paramn.rNA;; paramn = null)
      {
        Object localObject1 = localObject2;
        if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).hwb != null)
        {
          localObject3 = (avb)((com.tencent.mm.plugin.qmessage.a.c)localObject3).hwb.gUT.gUX;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((avb)localObject3).DuD;
          }
        }
        if (!bt.isNullOrNil((String)localObject1))
        {
          this.uKy = ((String)localObject1);
          az.arV();
          com.tencent.mm.model.c.afk().set(77, localObject1);
        }
        this.uKz = paramn;
        az.arV();
        com.tencent.mm.model.c.afk().set(78, paramn);
        if (!this.uKx) {
          ddS();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI
 * JD-Core Version:    0.7.0.1
 */