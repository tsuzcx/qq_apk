package com.tencent.mm.plugin.qmessage.ui;

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
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.clf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.x.a;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

@Deprecated
public class QConversationUI
  extends MMActivity
  implements h
{
  private boolean KiQ;
  private ListView NiE;
  private c NiF;
  private com.tencent.mm.plugin.qmessage.model.b NiG;
  private boolean NiH;
  private String NiI;
  private String NiJ;
  private boolean NiK;
  private String NiL;
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private u.i vzr;
  private au xVS;
  
  public QConversationUI()
  {
    AppMethodBeat.i(27780);
    this.KiQ = false;
    this.NiH = false;
    this.NiK = false;
    this.isDeleteCancel = false;
    this.vzr = new u.i()
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
  
  private static String bH(Context paramContext, String paramString)
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
        break label101;
      }
      paramContext = paramContext.activityInfo.name;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.QConversationUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(27787);
    return paramContext;
  }
  
  private static void gDP()
  {
    AppMethodBeat.i(27784);
    bh.bCz();
    Object localObject = com.tencent.mm.model.c.bzD().aaD(2);
    if ((localObject != null) && (((fi)localObject).field_msgId > 0L))
    {
      Log.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + ((cc)localObject).getCreateTime());
      bh.bCz();
      com.tencent.mm.model.c.ban().B(12295, Long.valueOf(((cc)localObject).getCreateTime()));
    }
    bh.bCz();
    localObject = com.tencent.mm.model.c.bzG().bxM("qmessage");
    if ((localObject == null) || (Util.nullAsNil(((bd)localObject).field_username).length() <= 0))
    {
      Log.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
      AppMethodBeat.o(27784);
      return;
    }
    ((bb)localObject).pG(0);
    bh.bCz();
    if (com.tencent.mm.model.c.bzG().c((bb)localObject, ((bd)localObject).field_username) == -1) {
      Log.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
    }
    AppMethodBeat.o(27784);
  }
  
  private void gDQ()
  {
    AppMethodBeat.i(27788);
    if (Util.isNullOrNil(this.NiI))
    {
      AppMethodBeat.o(27788);
      return;
    }
    this.NiH = true;
    addIconOptionMenu(0, R.l.actionbar_open_qq, R.k.qq, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27779);
        if (!Util.isNullOrNil(QConversationUI.f(QConversationUI.this))) {
          QConversationUI.a(QConversationUI.this, QConversationUI.f(QConversationUI.this), QConversationUI.g(QConversationUI.this));
        }
        AppMethodBeat.o(27779);
        return true;
      }
    });
    AppMethodBeat.o(27788);
  }
  
  private void gDR()
  {
    AppMethodBeat.i(27789);
    removeAllOptionMenu();
    gDQ();
    addIconOptionMenu(2, R.l.actionbar_setting, R.k.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27767);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Contact_User", QConversationUI.a(QConversationUI.this).field_username);
        paramAnonymousMenuItem.putExtra("Chat_Readonly", true);
        com.tencent.mm.plugin.qmessage.a.dNP().c(paramAnonymousMenuItem, QConversationUI.this.getContext());
        AppMethodBeat.o(27767);
        return true;
      }
    });
    AppMethodBeat.o(27789);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(27791);
    if (this.KiQ)
    {
      finish();
      AppMethodBeat.o(27791);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.plugin.qmessage.a.dNP().n(localIntent, this);
    overridePendingTransition(R.a.anim_not_change, R.a.pop_out);
    AppMethodBeat.o(27791);
  }
  
  public int getLayoutId()
  {
    return R.i.tmessage;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27786);
    this.KiQ = getIntent().getBooleanExtra("finish_direct", false);
    Log.d("MicroMsg.QConversationUI", "isFromSearch  " + this.KiQ);
    bh.bCz();
    this.xVS = com.tencent.mm.model.c.bzA().JE("qmessage");
    if ((this.xVS != null) && ((int)this.xVS.maN > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("can not find qmessage", bool);
      this.NiE = ((ListView)findViewById(R.h.tmessage_lv));
      this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
      this.emptyTipTv.setText(R.l.gFo);
      this.NiF = new c(this, new x.a()
      {
        public final void bWC()
        {
          AppMethodBeat.i(27766);
          QConversationUI localQConversationUI = QConversationUI.this;
          String str = QConversationUI.a(QConversationUI.this).aSU();
          int i = ac.bBY();
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
      this.NiF.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int eB(View paramAnonymousView)
        {
          AppMethodBeat.i(27772);
          int i = QConversationUI.c(QConversationUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(27772);
          return i;
        }
      });
      this.NiF.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(27773);
          QConversationUI.c(QConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(27773);
        }
      });
      this.NiF.a(new MMSlideDelView.f()
      {
        public final void es(Object paramAnonymousObject)
        {
          AppMethodBeat.i(27774);
          if (paramAnonymousObject == null)
          {
            Log.e("MicroMsg.QConversationUI", "onItemDel object null");
            AppMethodBeat.o(27774);
            return;
          }
          QConversationUI.a(QConversationUI.this, paramAnonymousObject.toString());
          AppMethodBeat.o(27774);
        }
      });
      this.NiE.setAdapter(this.NiF);
      this.NiE.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(27775);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qmessage/ui/QConversationUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousAdapterView = (bb)QConversationUI.b(QConversationUI.this).getItem(paramAnonymousInt);
          paramAnonymousView = new Intent();
          paramAnonymousView.addFlags(67108864);
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("key_need_send_video", false);
          com.tencent.mm.plugin.qmessage.a.dNP().d(paramAnonymousView, QConversationUI.this.getContext());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(27775);
        }
      });
      final com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(this);
      this.NiE.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(27776);
          if (paramAnonymousInt < QConversationUI.c(QConversationUI.this).getHeaderViewsCount())
          {
            Log.w("MicroMsg.QConversationUI", "on header view long click, ignore");
            AppMethodBeat.o(27776);
            return true;
          }
          locala.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, QConversationUI.this, QConversationUI.d(QConversationUI.this), 0, 0);
          AppMethodBeat.o(27776);
          return true;
        }
      });
      com.tencent.mm.plugin.qmessage.a.gDG().nK(1010);
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = QConversationUI.c(QConversationUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27778);
        }
      });
      bh.bCz();
      this.NiI = ((String)com.tencent.mm.model.c.ban().d(77, ""));
      bh.bCz();
      this.NiJ = ((String)com.tencent.mm.model.c.ban().d(78, ""));
      if (this.NiG == null)
      {
        this.NiG = new com.tencent.mm.plugin.qmessage.model.b();
        bh.aZW().a(this.NiG.getType(), this);
      }
      bh.aZW().a(this.NiG, 0);
      gDR();
      com.tencent.mm.plugin.qmessage.a.gDG().nK(1010);
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
    paramView = (bb)this.NiF.getItem(paramView.position);
    bh.bCz();
    paramContextMenu.setHeaderTitle(com.tencent.mm.model.c.bzA().JE(paramView.field_username).aSV());
    paramContextMenu.add(0, 0, 0, R.l.main_delete);
    this.NiL = paramView.field_username;
    AppMethodBeat.o(27792);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27782);
    this.NiF.fSd();
    if (this.NiG != null)
    {
      bh.aZW().a(this.NiG);
      bh.aZW().b(this.NiG.getType(), this);
      this.NiG = null;
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
    Log.v("MicroMsg.QConversationUI", "on pause");
    bh.bCz();
    com.tencent.mm.model.c.bzG().remove(this.NiF);
    gDP();
    this.NiF.onPause();
    super.onPause();
    AppMethodBeat.o(27785);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27783);
    super.onResume();
    gDP();
    bh.bCz();
    com.tencent.mm.model.c.bzG().add(this.NiF);
    this.NiF.onNotifyChange(null, null);
    AppMethodBeat.o(27783);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject2 = null;
    AppMethodBeat.i(27793);
    Log.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramp.getType())
    {
    }
    do
    {
      AppMethodBeat.o(27793);
      return;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    Object localObject3 = (com.tencent.mm.plugin.qmessage.model.b)paramp;
    if (((com.tencent.mm.plugin.qmessage.model.b)localObject3).oWn != null)
    {
      paramString = (clf)c.c.b(((com.tencent.mm.plugin.qmessage.model.b)localObject3).oWn.otC);
      if (paramString == null) {}
    }
    for (paramString = paramString.aati;; paramString = null)
    {
      if (((com.tencent.mm.plugin.qmessage.model.b)localObject3).oWn != null)
      {
        paramp = (clf)c.c.b(((com.tencent.mm.plugin.qmessage.model.b)localObject3).oWn.otC);
        if (paramp == null) {}
      }
      for (paramp = paramp.IcC;; paramp = null)
      {
        Object localObject1 = localObject2;
        if (((com.tencent.mm.plugin.qmessage.model.b)localObject3).oWn != null)
        {
          localObject3 = (clf)c.c.b(((com.tencent.mm.plugin.qmessage.model.b)localObject3).oWn.otC);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((clf)localObject3).aatj;
          }
        }
        if (!Util.isNullOrNil((String)localObject1))
        {
          this.NiI = ((String)localObject1);
          bh.bCz();
          com.tencent.mm.model.c.ban().B(77, localObject1);
        }
        this.NiJ = paramp;
        bh.bCz();
        com.tencent.mm.model.c.ban().B(78, paramp);
        if (!this.NiH) {
          gDR();
        }
        Log.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[] { paramString, paramp, localObject1 });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI
 * JD-Core Version:    0.7.0.1
 */