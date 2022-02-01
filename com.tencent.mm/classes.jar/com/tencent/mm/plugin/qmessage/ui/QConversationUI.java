package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.content.Context;
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
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bon;
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
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.s.a;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

@Deprecated
public class QConversationUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private com.tencent.mm.plugin.qmessage.a.c BqA;
  private boolean BqB;
  private String BqC;
  private String BqD;
  private boolean BqE;
  private String BqF;
  private ListView Bqy;
  private c Bqz;
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private o.g plk;
  private as rjX;
  private boolean yMq;
  
  public QConversationUI()
  {
    AppMethodBeat.i(27780);
    this.yMq = false;
    this.BqB = false;
    this.BqE = false;
    this.isDeleteCancel = false;
    this.plk = new o.g()
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
  
  private static String bs(Context paramContext, String paramString)
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
        Log.printErrStackTrace("MicroMsg.QConversationUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(27787);
    return paramContext;
  }
  
  private static void eGg()
  {
    AppMethodBeat.i(27784);
    bg.aVF();
    Object localObject = com.tencent.mm.model.c.aSQ().Qo(2);
    if ((localObject != null) && (((eo)localObject).field_msgId > 0L))
    {
      Log.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + ((eo)localObject).field_createTime);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(12295, Long.valueOf(((eo)localObject).field_createTime));
    }
    bg.aVF();
    localObject = com.tencent.mm.model.c.aST().bjY("qmessage");
    if ((localObject == null) || (Util.nullAsNil(((bb)localObject).field_username).length() <= 0))
    {
      Log.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
      AppMethodBeat.o(27784);
      return;
    }
    ((az)localObject).nt(0);
    bg.aVF();
    if (com.tencent.mm.model.c.aST().a((az)localObject, ((bb)localObject).field_username) == -1) {
      Log.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
    }
    AppMethodBeat.o(27784);
  }
  
  private void eGh()
  {
    AppMethodBeat.i(27788);
    if (Util.isNullOrNil(this.BqC))
    {
      AppMethodBeat.o(27788);
      return;
    }
    this.BqB = true;
    addIconOptionMenu(0, 2131755146, 2131691359, new MenuItem.OnMenuItemClickListener()
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
  
  private void eGi()
  {
    AppMethodBeat.i(27789);
    removeAllOptionMenu();
    eGh();
    addIconOptionMenu(2, 2131755149, 2131689513, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27767);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Contact_User", QConversationUI.a(QConversationUI.this).field_username);
        paramAnonymousMenuItem.putExtra("Chat_Readonly", true);
        com.tencent.mm.plugin.qmessage.a.jRt.c(paramAnonymousMenuItem, QConversationUI.this.getContext());
        AppMethodBeat.o(27767);
        return true;
      }
    });
    AppMethodBeat.o(27789);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(27791);
    if (this.yMq)
    {
      finish();
      AppMethodBeat.o(27791);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.plugin.qmessage.a.jRt.o(localIntent, this);
    overridePendingTransition(2130771986, 2130772124);
    AppMethodBeat.o(27791);
  }
  
  public int getLayoutId()
  {
    return 2131496720;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27786);
    this.yMq = getIntent().getBooleanExtra("finish_direct", false);
    Log.d("MicroMsg.QConversationUI", "isFromSearch  " + this.yMq);
    bg.aVF();
    this.rjX = com.tencent.mm.model.c.aSN().Kn("qmessage");
    if ((this.rjX != null) && ((int)this.rjX.gMZ > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("can not find qmessage", bool);
      this.Bqy = ((ListView)findViewById(2131309254));
      this.emptyTipTv = ((TextView)findViewById(2131300096));
      this.emptyTipTv.setText(2131758715);
      this.Bqz = new c(this, new s.a()
      {
        public final void bnE()
        {
          AppMethodBeat.i(27766);
          QConversationUI localQConversationUI = QConversationUI.this;
          String str = QConversationUI.a(QConversationUI.this).arI();
          int i = ac.JP(ab.iCI);
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
      this.Bqz.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dr(View paramAnonymousView)
        {
          AppMethodBeat.i(27772);
          int i = QConversationUI.c(QConversationUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(27772);
          return i;
        }
      });
      this.Bqz.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(27773);
          QConversationUI.c(QConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(27773);
        }
      });
      this.Bqz.a(new MMSlideDelView.f()
      {
        public final void cZ(Object paramAnonymousObject)
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
      this.Bqy.setAdapter(this.Bqz);
      this.Bqy.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(27775);
          b localb = new b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qmessage/ui/QConversationUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          paramAnonymousAdapterView = (az)QConversationUI.b(QConversationUI.this).getItem(paramAnonymousInt);
          paramAnonymousView = new Intent();
          paramAnonymousView.addFlags(67108864);
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("key_need_send_video", false);
          com.tencent.mm.plugin.qmessage.a.jRt.d(paramAnonymousView, QConversationUI.this.getContext());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(27775);
        }
      });
      com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(this);
      this.Bqy.setOnItemLongClickListener(new QConversationUI.10(this, locala));
      com.tencent.mm.plugin.qmessage.a.Bqd.iO(1010);
      setBackBtn(new QConversationUI.11(this));
      setToTop(new QConversationUI.12(this));
      bg.aVF();
      this.BqC = ((String)com.tencent.mm.model.c.azQ().get(77, ""));
      bg.aVF();
      this.BqD = ((String)com.tencent.mm.model.c.azQ().get(78, ""));
      if (this.BqA == null)
      {
        this.BqA = new com.tencent.mm.plugin.qmessage.a.c();
        bg.azz().a(this.BqA.getType(), this);
      }
      bg.azz().a(this.BqA, 0);
      eGi();
      com.tencent.mm.plugin.qmessage.a.Bqd.iO(1010);
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
    paramView = (az)this.Bqz.getItem(paramView.position);
    bg.aVF();
    paramContextMenu.setHeaderTitle(com.tencent.mm.model.c.aSN().Kn(paramView.field_username).arJ());
    paramContextMenu.add(0, 0, 0, 2131762843);
    this.BqF = paramView.field_username;
    AppMethodBeat.o(27792);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27782);
    this.Bqz.ebf();
    if (this.BqA != null)
    {
      bg.azz().a(this.BqA);
      bg.azz().b(this.BqA.getType(), this);
      this.BqA = null;
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
    bg.aVF();
    com.tencent.mm.model.c.aST().remove(this.Bqz);
    eGg();
    this.Bqz.onPause();
    super.onPause();
    AppMethodBeat.o(27785);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27783);
    super.onResume();
    eGg();
    bg.aVF();
    com.tencent.mm.model.c.aST().add(this.Bqz);
    this.Bqz.onNotifyChange(null, null);
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
    if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).jof != null)
    {
      paramString = (bon)((com.tencent.mm.plugin.qmessage.a.c)localObject3).jof.iLL.iLR;
      if (paramString == null) {}
    }
    for (paramString = paramString.LWH;; paramString = null)
    {
      if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).jof != null)
      {
        paramq = (bon)((com.tencent.mm.plugin.qmessage.a.c)localObject3).jof.iLL.iLR;
        if (paramq == null) {}
      }
      for (paramq = paramq.xuc;; paramq = null)
      {
        Object localObject1 = localObject2;
        if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).jof != null)
        {
          localObject3 = (bon)((com.tencent.mm.plugin.qmessage.a.c)localObject3).jof.iLL.iLR;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((bon)localObject3).LWI;
          }
        }
        if (!Util.isNullOrNil((String)localObject1))
        {
          this.BqC = ((String)localObject1);
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(77, localObject1);
        }
        this.BqD = paramq;
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(78, paramq);
        if (!this.BqB) {
          eGi();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI
 * JD-Core Version:    0.7.0.1
 */