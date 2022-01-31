package com.tencent.mm.plugin.qmessage.ui;

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
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.agq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class QConversationUI
  extends MMActivity
  implements f
{
  private TextView emptyTipTv;
  private n.d hZq = new QConversationUI.5(this);
  private boolean isDeleteCancel = false;
  private ad jgl;
  private boolean mbA = false;
  private ListView ncM;
  private c ncN;
  private com.tencent.mm.plugin.qmessage.a.c ncO;
  private boolean ncP = false;
  private String ncQ;
  private String ncR;
  private boolean ncS = false;
  private String ncT;
  
  private static String aF(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext != null)
      {
        paramContext = paramContext.activityInfo.name;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.QConversationUI", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  private static void btn()
  {
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Fy().tE(2);
    if ((localObject != null) && (((cs)localObject).field_msgId > 0L))
    {
      y.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + ((cs)localObject).field_createTime);
      au.Hx();
      com.tencent.mm.model.c.Dz().o(12295, Long.valueOf(((cs)localObject).field_createTime));
    }
    au.Hx();
    localObject = com.tencent.mm.model.c.FB().abv("qmessage");
    if ((localObject == null) || (bk.pm(((as)localObject).field_username).length() <= 0)) {
      y.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
    }
    do
    {
      return;
      ((ak)localObject).fy(0);
      au.Hx();
    } while (com.tencent.mm.model.c.FB().a((ak)localObject, ((as)localObject).field_username) != -1);
    y.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
  }
  
  private void bto()
  {
    this.mController.removeAllOptionMenu();
    if (!bk.bl(this.ncQ))
    {
      this.ncP = true;
      addIconOptionMenu(0, R.l.actionbar_open_qq, R.k.qq, new QConversationUI.13(this));
    }
    addIconOptionMenu(2, R.l.actionbar_setting, R.k.actionbar_setting_icon, new QConversationUI.2(this));
  }
  
  private void goBack()
  {
    if (this.mbA)
    {
      finish();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.plugin.qmessage.a.eUR.q(localIntent, this);
    overridePendingTransition(R.a.anim_not_change, R.a.pop_out);
  }
  
  protected final int getLayoutId()
  {
    return R.i.tmessage;
  }
  
  protected final void initView()
  {
    this.mbA = getIntent().getBooleanExtra("finish_direct", false);
    y.d("MicroMsg.QConversationUI", "isFromSearch  " + this.mbA);
    au.Hx();
    this.jgl = com.tencent.mm.model.c.Fw().abl("qmessage");
    if ((this.jgl != null) && ((int)this.jgl.dBe > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("can not find qmessage", bool);
      this.ncM = ((ListView)findViewById(R.h.tmessage_lv));
      this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
      this.emptyTipTv.setText(R.l.empty_qmsg_tip);
      this.ncN = new c(this, new QConversationUI.1(this));
      this.ncN.setGetViewPositionCallback(new QConversationUI.6(this));
      this.ncN.setPerformItemClickListener(new QConversationUI.7(this));
      this.ncN.a(new QConversationUI.8(this));
      this.ncM.setAdapter(this.ncN);
      this.ncM.setOnItemClickListener(new QConversationUI.9(this));
      com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(this);
      this.ncM.setOnItemLongClickListener(new QConversationUI.10(this, locala));
      com.tencent.mm.plugin.qmessage.a.ncr.es(1010);
      setBackBtn(new QConversationUI.11(this));
      new QConversationUI.12(this);
      au.Hx();
      this.ncQ = ((String)com.tencent.mm.model.c.Dz().get(77, ""));
      au.Hx();
      this.ncR = ((String)com.tencent.mm.model.c.Dz().get(78, ""));
      if (this.ncO == null)
      {
        this.ncO = new com.tencent.mm.plugin.qmessage.a.c();
        au.Dk().a(this.ncO.getType(), this);
      }
      au.Dk().a(this.ncO, 0);
      bto();
      com.tencent.mm.plugin.qmessage.a.ncr.es(1010);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramView = (ak)this.ncN.getItem(paramView.position);
    au.Hx();
    paramContextMenu.setHeaderTitle(com.tencent.mm.model.c.Fw().abl(paramView.field_username).Bq());
    paramContextMenu.add(0, 0, 0, R.l.main_delete);
    this.ncT = paramView.field_username;
  }
  
  public void onDestroy()
  {
    this.ncN.bcS();
    if (this.ncO != null)
    {
      au.Dk().c(this.ncO);
      au.Dk().b(this.ncO.getType(), this);
      this.ncO = null;
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    y.v("MicroMsg.QConversationUI", "on pause");
    au.Hx();
    com.tencent.mm.model.c.FB().b(this.ncN);
    btn();
    this.ncN.onPause();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    btn();
    au.Hx();
    com.tencent.mm.model.c.FB().a(this.ncN);
    this.ncN.a(null, null);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    Object localObject2 = null;
    y.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramm.getType())
    {
    }
    do
    {
      return;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    Object localObject3 = (com.tencent.mm.plugin.qmessage.a.c)paramm;
    if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).eDB != null)
    {
      paramString = (agq)((com.tencent.mm.plugin.qmessage.a.c)localObject3).eDB.ecF.ecN;
      if (paramString == null) {}
    }
    for (paramString = paramString.tej;; paramString = null)
    {
      if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).eDB != null)
      {
        paramm = (agq)((com.tencent.mm.plugin.qmessage.a.c)localObject3).eDB.ecF.ecN;
        if (paramm == null) {}
      }
      for (paramm = paramm.sww;; paramm = null)
      {
        Object localObject1 = localObject2;
        if (((com.tencent.mm.plugin.qmessage.a.c)localObject3).eDB != null)
        {
          localObject3 = (agq)((com.tencent.mm.plugin.qmessage.a.c)localObject3).eDB.ecF.ecN;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((agq)localObject3).tek;
          }
        }
        if (!bk.bl((String)localObject1))
        {
          this.ncQ = ((String)localObject1);
          au.Hx();
          com.tencent.mm.model.c.Dz().o(77, localObject1);
        }
        this.ncR = paramm;
        au.Hx();
        com.tencent.mm.model.c.Dz().o(78, paramm);
        if (!this.ncP) {
          bto();
        }
        y.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[] { paramString, paramm, localObject1 });
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI
 * JD-Core Version:    0.7.0.1
 */