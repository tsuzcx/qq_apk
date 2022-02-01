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
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.v.a;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

@Deprecated
public class QConversationUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private boolean Eqj;
  private ListView HkR;
  private c HkS;
  private com.tencent.mm.plugin.qmessage.a.c HkT;
  private boolean HkU;
  private String HkV;
  private String HkW;
  private boolean HkX;
  private String HkY;
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private q.g snt;
  private as uNk;
  
  public QConversationUI()
  {
    AppMethodBeat.i(27780);
    this.Eqj = false;
    this.HkU = false;
    this.HkX = false;
    this.isDeleteCancel = false;
    this.snt = new q.g()
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
  
  private static String bF(Context paramContext, String paramString)
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
  
  private static void fsh()
  {
    AppMethodBeat.i(27784);
    bh.beI();
    Object localObject = com.tencent.mm.model.c.bbO().WB(2);
    if ((localObject != null) && (((et)localObject).field_msgId > 0L))
    {
      Log.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + ((et)localObject).field_createTime);
      bh.beI();
      com.tencent.mm.model.c.aHp().i(12295, Long.valueOf(((et)localObject).field_createTime));
    }
    bh.beI();
    localObject = com.tencent.mm.model.c.bbR().bwx("qmessage");
    if ((localObject == null) || (Util.nullAsNil(((bb)localObject).field_username).length() <= 0))
    {
      Log.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
      AppMethodBeat.o(27784);
      return;
    }
    ((az)localObject).pH(0);
    bh.beI();
    if (com.tencent.mm.model.c.bbR().a((az)localObject, ((bb)localObject).field_username) == -1) {
      Log.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
    }
    AppMethodBeat.o(27784);
  }
  
  private void fsi()
  {
    AppMethodBeat.i(27788);
    if (Util.isNullOrNil(this.HkV))
    {
      AppMethodBeat.o(27788);
      return;
    }
    this.HkU = true;
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
  
  private void fsj()
  {
    AppMethodBeat.i(27789);
    removeAllOptionMenu();
    fsi();
    addIconOptionMenu(2, R.l.actionbar_setting, R.k.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27767);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Contact_User", QConversationUI.a(QConversationUI.this).field_username);
        paramAnonymousMenuItem.putExtra("Chat_Readonly", true);
        com.tencent.mm.plugin.qmessage.a.dhe().c(paramAnonymousMenuItem, QConversationUI.this.getContext());
        AppMethodBeat.o(27767);
        return true;
      }
    });
    AppMethodBeat.o(27789);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(27791);
    if (this.Eqj)
    {
      finish();
      AppMethodBeat.o(27791);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.plugin.qmessage.a.dhe().n(localIntent, this);
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
    this.Eqj = getIntent().getBooleanExtra("finish_direct", false);
    Log.d("MicroMsg.QConversationUI", "isFromSearch  " + this.Eqj);
    bh.beI();
    this.uNk = com.tencent.mm.model.c.bbL().RG("qmessage");
    if ((this.uNk != null) && ((int)this.uNk.jxt > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("can not find qmessage", bool);
      this.HkR = ((ListView)findViewById(R.h.tmessage_lv));
      this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
      this.emptyTipTv.setText(R.l.eCg);
      this.HkS = new c(this, new v.a()
      {
        public final void bxN()
        {
          AppMethodBeat.i(27766);
          QConversationUI localQConversationUI = QConversationUI.this;
          String str = QConversationUI.a(QConversationUI.this).ayr();
          int i = ac.uM(2);
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
      this.HkS.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dO(View paramAnonymousView)
        {
          AppMethodBeat.i(27772);
          int i = QConversationUI.c(QConversationUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(27772);
          return i;
        }
      });
      this.HkS.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(27773);
          QConversationUI.c(QConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(27773);
        }
      });
      this.HkS.a(new MMSlideDelView.f()
      {
        public final void cW(Object paramAnonymousObject)
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
      this.HkR.setAdapter(this.HkS);
      this.HkR.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(27775);
          b localb = new b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qmessage/ui/QConversationUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          paramAnonymousAdapterView = (az)QConversationUI.b(QConversationUI.this).getItem(paramAnonymousInt);
          paramAnonymousView = new Intent();
          paramAnonymousView.addFlags(67108864);
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("key_need_send_video", false);
          com.tencent.mm.plugin.qmessage.a.dhe().d(paramAnonymousView, QConversationUI.this.getContext());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(27775);
        }
      });
      final com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(this);
      this.HkR.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
      com.tencent.mm.plugin.qmessage.a.frY().kd(1010);
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
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          paramAnonymousView = QConversationUI.c(QConversationUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27778);
        }
      });
      bh.beI();
      this.HkV = ((String)com.tencent.mm.model.c.aHp().b(77, ""));
      bh.beI();
      this.HkW = ((String)com.tencent.mm.model.c.aHp().b(78, ""));
      if (this.HkT == null)
      {
        this.HkT = new com.tencent.mm.plugin.qmessage.a.c();
        bh.aGY().a(this.HkT.getType(), this);
      }
      bh.aGY().a(this.HkT, 0);
      fsj();
      com.tencent.mm.plugin.qmessage.a.frY().kd(1010);
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
    paramView = (az)this.HkS.getItem(paramView.position);
    bh.beI();
    paramContextMenu.setHeaderTitle(com.tencent.mm.model.c.bbL().RG(paramView.field_username).ays());
    paramContextMenu.add(0, 0, 0, R.l.main_delete);
    this.HkY = paramView.field_username;
    AppMethodBeat.o(27792);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27782);
    this.HkS.eKd();
    if (this.HkT != null)
    {
      bh.aGY().a(this.HkT);
      bh.aGY().b(this.HkT.getType(), this);
      this.HkT = null;
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
    bh.beI();
    com.tencent.mm.model.c.bbR().remove(this.HkS);
    fsh();
    this.HkS.onPause();
    super.onPause();
    AppMethodBeat.o(27785);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27783);
    super.onResume();
    fsh();
    bh.beI();
    com.tencent.mm.model.c.bbR().add(this.HkS);
    this.HkS.onNotifyChange(null, null);
    AppMethodBeat.o(27783);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(27793);
    Log.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramq.getType())
    {
    }
    do
    {
      AppMethodBeat.o(27793);
      return;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    Object localObject3 = (com.tencent.mm.plugin.qmessage.a.c)paramq;
    if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).mdu != null)
    {
      paramString = (bwc)d.c.b(((com.tencent.mm.plugin.qmessage.a.c)localObject3).mdu.lBS);
      if (paramString == null) {}
    }
    for (paramString = paramString.TfO;; paramString = null)
    {
      if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).mdu != null)
      {
        paramq = (bwc)d.c.b(((com.tencent.mm.plugin.qmessage.a.c)localObject3).mdu.lBS);
        if (paramq == null) {}
      }
      for (paramq = paramq.Cqt;; paramq = null)
      {
        Object localObject1 = localObject2;
        if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).mdu != null)
        {
          localObject3 = (bwc)d.c.b(((com.tencent.mm.plugin.qmessage.a.c)localObject3).mdu.lBS);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((bwc)localObject3).TfP;
          }
        }
        if (!Util.isNullOrNil((String)localObject1))
        {
          this.HkV = ((String)localObject1);
          bh.beI();
          com.tencent.mm.model.c.aHp().i(77, localObject1);
        }
        this.HkW = paramq;
        bh.beI();
        com.tencent.mm.model.c.aHp().i(78, paramq);
        if (!this.HkU) {
          fsj();
        }
        Log.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[] { paramString, paramq, localObject1 });
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