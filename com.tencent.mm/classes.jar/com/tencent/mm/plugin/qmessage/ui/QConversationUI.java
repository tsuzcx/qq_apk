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
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class QConversationUI
  extends MMActivity
  implements f
{
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private n.d jSn;
  private ad lpe;
  private boolean oCb;
  private ListView pIe;
  private c pIf;
  private com.tencent.mm.plugin.qmessage.a.c pIg;
  private boolean pIh;
  private String pIi;
  private String pIj;
  private boolean pIk;
  private String pIl;
  
  public QConversationUI()
  {
    AppMethodBeat.i(24140);
    this.oCb = false;
    this.pIh = false;
    this.pIk = false;
    this.isDeleteCancel = false;
    this.jSn = new QConversationUI.5(this);
    AppMethodBeat.o(24140);
  }
  
  private static String aO(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24147);
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
        ab.printErrStackTrace("MicroMsg.QConversationUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(24147);
    return paramContext;
  }
  
  private void cdA()
  {
    AppMethodBeat.i(24149);
    removeAllOptionMenu();
    cdz();
    addIconOptionMenu(2, 2131296404, 2131230758, new QConversationUI.2(this));
    AppMethodBeat.o(24149);
  }
  
  private static void cdy()
  {
    AppMethodBeat.i(24144);
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.YC().yU(2);
    if ((localObject != null) && (((dd)localObject).field_msgId > 0L))
    {
      ab.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + ((dd)localObject).field_createTime);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(12295, Long.valueOf(((dd)localObject).field_createTime));
    }
    aw.aaz();
    localObject = com.tencent.mm.model.c.YF().arH("qmessage");
    if ((localObject == null) || (bo.nullAsNil(((au)localObject).field_username).length() <= 0))
    {
      ab.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
      AppMethodBeat.o(24144);
      return;
    }
    ((ak)localObject).hJ(0);
    aw.aaz();
    if (com.tencent.mm.model.c.YF().a((ak)localObject, ((au)localObject).field_username) == -1) {
      ab.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
    }
    AppMethodBeat.o(24144);
  }
  
  private void cdz()
  {
    AppMethodBeat.i(24148);
    if (bo.isNullOrNil(this.pIi))
    {
      AppMethodBeat.o(24148);
      return;
    }
    this.pIh = true;
    addIconOptionMenu(0, 2131296401, 2131231888, new QConversationUI.13(this));
    AppMethodBeat.o(24148);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(24154);
    if (this.oCb)
    {
      finish();
      AppMethodBeat.o(24154);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.plugin.qmessage.a.gmO.p(localIntent, this);
    overridePendingTransition(2131034130, 2131034222);
    AppMethodBeat.o(24154);
  }
  
  public int getLayoutId()
  {
    return 2130971000;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24146);
    this.oCb = getIntent().getBooleanExtra("finish_direct", false);
    ab.d("MicroMsg.QConversationUI", "isFromSearch  " + this.oCb);
    aw.aaz();
    this.lpe = com.tencent.mm.model.c.YA().arw("qmessage");
    if ((this.lpe != null) && ((int)this.lpe.euF > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("can not find qmessage", bool);
      this.pIe = ((ListView)findViewById(2131823736));
      this.emptyTipTv = ((TextView)findViewById(2131821852));
      this.emptyTipTv.setText(2131299294);
      this.pIf = new c(this, new QConversationUI.1(this));
      this.pIf.setGetViewPositionCallback(new QConversationUI.6(this));
      this.pIf.setPerformItemClickListener(new QConversationUI.7(this));
      this.pIf.a(new QConversationUI.8(this));
      this.pIe.setAdapter(this.pIf);
      this.pIe.setOnItemClickListener(new QConversationUI.9(this));
      com.tencent.mm.ui.widget.c.a locala = new com.tencent.mm.ui.widget.c.a(this);
      this.pIe.setOnItemLongClickListener(new QConversationUI.10(this, locala));
      com.tencent.mm.plugin.qmessage.a.pHJ.gf(1010);
      setBackBtn(new QConversationUI.11(this));
      setToTop(new QConversationUI.12(this));
      aw.aaz();
      this.pIi = ((String)com.tencent.mm.model.c.Ru().get(77, ""));
      aw.aaz();
      this.pIj = ((String)com.tencent.mm.model.c.Ru().get(78, ""));
      if (this.pIg == null)
      {
        this.pIg = new com.tencent.mm.plugin.qmessage.a.c();
        aw.Rc().a(this.pIg.getType(), this);
      }
      aw.Rc().a(this.pIg, 0);
      cdA();
      com.tencent.mm.plugin.qmessage.a.pHJ.gf(1010);
      AppMethodBeat.o(24146);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24141);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(24141);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(24155);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramView = (ak)this.pIf.getItem(paramView.position);
    aw.aaz();
    paramContextMenu.setHeaderTitle(com.tencent.mm.model.c.YA().arw(paramView.field_username).Of());
    paramContextMenu.add(0, 0, 0, 2131301410);
    this.pIl = paramView.field_username;
    AppMethodBeat.o(24155);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24142);
    this.pIf.bKb();
    if (this.pIg != null)
    {
      aw.Rc().a(this.pIg);
      aw.Rc().b(this.pIg.getType(), this);
      this.pIg = null;
    }
    super.onDestroy();
    AppMethodBeat.o(24142);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(24153);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(24153);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(24153);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(24145);
    ab.v("MicroMsg.QConversationUI", "on pause");
    aw.aaz();
    com.tencent.mm.model.c.YF().b(this.pIf);
    cdy();
    this.pIf.onPause();
    super.onPause();
    AppMethodBeat.o(24145);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24143);
    super.onResume();
    cdy();
    aw.aaz();
    com.tencent.mm.model.c.YF().a(this.pIf);
    this.pIf.a(null, null);
    AppMethodBeat.o(24143);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(24156);
    ab.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramm.getType())
    {
    }
    do
    {
      AppMethodBeat.o(24156);
      return;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    Object localObject3 = (com.tencent.mm.plugin.qmessage.a.c)paramm;
    if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).fTs != null)
    {
      paramString = (all)((com.tencent.mm.plugin.qmessage.a.c)localObject3).fTs.fsW.fta;
      if (paramString == null) {}
    }
    for (paramString = paramString.xcj;; paramString = null)
    {
      if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).fTs != null)
      {
        paramm = (all)((com.tencent.mm.plugin.qmessage.a.c)localObject3).fTs.fsW.fta;
        if (paramm == null) {}
      }
      for (paramm = paramm.wxa;; paramm = null)
      {
        Object localObject1 = localObject2;
        if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).fTs != null)
        {
          localObject3 = (all)((com.tencent.mm.plugin.qmessage.a.c)localObject3).fTs.fsW.fta;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((all)localObject3).xck;
          }
        }
        if (!bo.isNullOrNil((String)localObject1))
        {
          this.pIi = ((String)localObject1);
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(77, localObject1);
        }
        this.pIj = paramm;
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(78, paramm);
        if (!this.pIh) {
          cdA();
        }
        ab.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[] { paramString, paramm, localObject1 });
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