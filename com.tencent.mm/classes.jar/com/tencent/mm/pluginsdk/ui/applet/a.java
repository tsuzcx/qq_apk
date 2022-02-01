package com.tencent.mm.pluginsdk.ui.applet;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.f.a.ng;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.protocal.protobuf.fap;
import com.tencent.mm.protocal.protobuf.faq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.f.d;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.b;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public final class a
  implements i
{
  public String BAU;
  public String BLy;
  private LinkedList<Integer> HtJ;
  private a ReG;
  public b ReH;
  private LinkedList<String> ReI;
  private LinkedList<String> ReJ;
  private String ReK;
  public boolean ReL;
  private boolean ReM;
  public boolean ReN;
  public String ReO;
  public fam ReP;
  public aa.a ReQ;
  public Map<String, Integer> ReR;
  private com.tencent.mm.pluginsdk.model.t ReS;
  private boolean ReT;
  public String ReU;
  public String chatroomName;
  public String content;
  private Context context;
  public boolean fgi;
  private String jXW;
  public String mZh;
  private String sourceNickName;
  private String sourceUserName;
  private s tipDialog;
  public int wGA;
  
  public a(Context paramContext, a parama)
  {
    AppMethodBeat.i(152151);
    this.jXW = "";
    this.BLy = "";
    this.ReK = "";
    this.chatroomName = "";
    this.ReL = true;
    this.fgi = true;
    this.ReM = true;
    this.mZh = "";
    this.ReN = false;
    this.ReO = "";
    this.wGA = 0;
    this.content = "";
    this.ReT = false;
    this.ReU = "";
    this.context = paramContext;
    this.ReG = parama;
    this.ReI = new LinkedList();
    this.ReJ = new LinkedList();
    this.tipDialog = null;
    AppMethodBeat.o(152151);
  }
  
  private void P(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(152162);
    if ((this.ReN) && (!Util.isNullOrNil(paramString))) {
      com.tencent.mm.ui.base.h.c(this.context, paramString, "", true);
    }
    for (;;)
    {
      d(false, false, this.ReK, this.mZh);
      hkb();
      AppMethodBeat.o(152162);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -22)) {
        Toast.makeText(this.context, this.context.getString(c.h.addcontact_fail_blacklist), 1).show();
      } else if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
        Toast.makeText(this.context, paramString, 1).show();
      } else {
        Toast.makeText(this.context, this.context.getString(c.h.addcontact_fail), 1).show();
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, q paramq, String paramString2)
  {
    AppMethodBeat.i(239186);
    dMg();
    onStop();
    this.ReT = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() == 30) {
        this.ReK = ((com.tencent.mm.pluginsdk.model.t)paramq).hhc();
      }
      for (;;)
      {
        hka();
        AppMethodBeat.o(239186);
        return;
        if (paramq.getType() == 667) {
          this.ReK = ((com.tencent.mm.openim.b.b)paramq).myd;
        }
      }
    }
    b localb;
    if (paramInt2 == -44)
    {
      paramq = this.mZh;
      if (this.ReH != null)
      {
        localb = this.ReH;
        if (this.ReJ.isEmpty()) {}
        for (paramString1 = "";; paramString1 = (String)this.ReJ.getFirst())
        {
          localb.m(paramString1, paramInt2, paramString2);
          d(false, false, this.ReK, paramq);
          AppMethodBeat.o(239186);
          return;
        }
      }
      hjZ();
      AppMethodBeat.o(239186);
      return;
    }
    if (paramInt2 == -4000)
    {
      paramq = this.mZh;
      if (this.ReH != null)
      {
        localb = this.ReH;
        if (this.ReJ.isEmpty()) {}
        for (paramString1 = "";; paramString1 = (String)this.ReJ.getFirst())
        {
          localb.m(paramString1, paramInt2, paramString2);
          d(false, false, this.ReK, paramq);
          AppMethodBeat.o(239186);
          return;
        }
      }
      hjZ();
      AppMethodBeat.o(239186);
      return;
    }
    if (paramInt2 == -87)
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(c.h.contact_info_biz_join_fans_limit), "", true);
      hkb();
      AppMethodBeat.o(239186);
      return;
    }
    if ((paramInt2 == -101) && (!Util.isNullOrNil(paramString1)))
    {
      Log.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString1 });
      com.tencent.mm.ui.base.h.a(this.context, paramString1, "", false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(219065);
          a.a(a.this, false, a.a(a.this), a.e(a.this));
          a.f(a.this);
          AppMethodBeat.o(219065);
        }
      });
      AppMethodBeat.o(239186);
      return;
    }
    if (paramInt2 == -2)
    {
      if (!Util.isNullOrNil(paramString1))
      {
        com.tencent.mm.ui.base.h.a(this.context, paramString1, this.context.getString(c.h.app_tip), this.context.getString(c.h.app_ok), null);
        hkb();
        AppMethodBeat.o(239186);
        return;
      }
      P(paramInt1, paramInt2, null);
      AppMethodBeat.o(239186);
      return;
    }
    if (paramInt2 == -160)
    {
      if (!Util.isNullOrNil(paramString1))
      {
        com.tencent.mm.ui.base.h.c(this.context, paramString1, "", this.context.getResources().getString(c.h.app_continue), this.context.getResources().getString(c.h.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(191202);
            a.g(a.this);
            a.h(a.this);
            a.f(a.this);
            AppMethodBeat.o(191202);
          }
        }, null);
        AppMethodBeat.o(239186);
        return;
      }
      P(paramInt1, paramInt2, paramString1);
      AppMethodBeat.o(239186);
      return;
    }
    P(paramInt1, paramInt2, paramString1);
    AppMethodBeat.o(239186);
  }
  
  private void a(String paramString1, LinkedList<Integer> paramLinkedList, boolean paramBoolean, String paramString2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(152157);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramLinkedList == null) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      this.ReL = paramBoolean;
      this.jXW = paramString2;
      this.HtJ = paramLinkedList;
      this.ReI.add(paramString1);
      this.ReK = paramString1;
      hjY();
      AppMethodBeat.o(152157);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static boolean a(com.tencent.mm.pluginsdk.model.t paramt, faq paramfaq)
  {
    AppMethodBeat.i(239207);
    if (!hkd())
    {
      Log.i("MicroMsg.AddContact", "needShowDialog, isSupportStrangerBadManDialogShow is 0.");
      AppMethodBeat.o(239207);
      return false;
    }
    if (paramfaq == null)
    {
      Log.i("MicroMsg.AddContact", "needShowDialog, verifyUserSpamInfo is null.");
      AppMethodBeat.o(239207);
      return false;
    }
    if (paramt.fDn != 1)
    {
      Log.i("MicroMsg.AddContact", "needShowDialog, is not MM_VERIFYUSER_ADDCONTACT.");
      AppMethodBeat.o(239207);
      return false;
    }
    if ((Util.isNullOrNil(paramfaq.UAH)) || (Util.isNullOrNil(paramfaq.UAG)))
    {
      Log.i("MicroMsg.AddContact", "needShowDialog, key word is null.");
      AppMethodBeat.o(239207);
      return false;
    }
    AppMethodBeat.o(239207);
    return true;
  }
  
  private void d(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(152159);
    if (this.ReG != null) {
      this.ReG.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
    }
    if (paramBoolean1)
    {
      paramString2 = new ng();
      paramString2.fLB.username = paramString1;
      EventCenter.instance.publish(paramString2);
    }
    AppMethodBeat.o(152159);
  }
  
  private void dMg()
  {
    AppMethodBeat.i(239188);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(239188);
  }
  
  private void hjY()
  {
    AppMethodBeat.i(152158);
    onStart();
    if (this.fgi)
    {
      localObject = this.context;
      this.context.getString(c.h.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, this.context.getString(c.h.contact_info_adding_tip), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(152147);
          a.a(a.this, false, a.a(a.this), a.b(a.this));
          AppMethodBeat.o(152147);
        }
      });
    }
    if (as.bvK((String)this.ReI.getFirst()))
    {
      String str = (String)this.ReI.getFirst();
      if (this.ReJ.isEmpty()) {}
      for (localObject = "";; localObject = (String)this.ReJ.getFirst())
      {
        localObject = new com.tencent.mm.openim.b.b(str, (String)localObject);
        com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject, 0);
        AppMethodBeat.o(152158);
        return;
      }
    }
    Object localObject = new com.tencent.mm.pluginsdk.model.t(1, this.ReI, this.HtJ, this.ReJ, this.content, this.BLy, this.ReR, this.chatroomName, this.jXW, this.ReU);
    if (!Util.isNullOrNil(this.sourceUserName)) {
      ((com.tencent.mm.pluginsdk.model.t)localObject).nl(this.sourceUserName, this.sourceNickName);
    }
    ((com.tencent.mm.pluginsdk.model.t)localObject).WW(this.ReO);
    ((com.tencent.mm.pluginsdk.model.t)localObject).setSubScene(this.wGA);
    ((com.tencent.mm.pluginsdk.model.t)localObject).a(this.ReP);
    ((com.tencent.mm.pluginsdk.model.t)localObject).DO(this.ReM);
    com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject, 0);
    AppMethodBeat.o(152158);
  }
  
  private void hjZ()
  {
    AppMethodBeat.i(239191);
    aa localaa = new aa(this.context, new aa.b()
    {
      public final void dO(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(228361);
        String str = a.e(a.this);
        a locala = a.this;
        a.a(locala, paramAnonymousBoolean, a.a(locala), str);
        AppMethodBeat.o(228361);
      }
    });
    if (this.BAU != null) {
      localaa.BAU = this.BAU;
    }
    if (this.ReL)
    {
      localaa.F(this.ReI, this.HtJ);
      AppMethodBeat.o(239191);
      return;
    }
    localaa.a(this.ReI, this.HtJ, this.ReJ);
    AppMethodBeat.o(239191);
  }
  
  private void hka()
  {
    AppMethodBeat.i(239194);
    d(true, false, this.ReK, this.mZh);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    String str = this.sourceUserName;
    if (this.HtJ.size() > 0) {}
    for (int i = ((Integer)this.HtJ.getLast()).intValue();; i = 0)
    {
      localh.a(18713, new Object[] { str, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0) });
      AppMethodBeat.o(239194);
      return;
    }
  }
  
  private void hkb()
  {
    AppMethodBeat.i(239198);
    if (this.ReQ != null)
    {
      this.ReQ.fqN();
      Log.i("MicroMsg.AddContact", "errorFinishAddContact.");
    }
    AppMethodBeat.o(239198);
  }
  
  private static boolean hkd()
  {
    AppMethodBeat.i(239204);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWI, 1);
    Log.i("MicroMsg.AddContact", "isSupportStrangerBadManDialogShow() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(239204);
      return true;
    }
    AppMethodBeat.o(239204);
    return false;
  }
  
  private void onStart()
  {
    AppMethodBeat.i(152160);
    com.tencent.mm.kernel.h.aHF().kcd.a(30, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(667, this);
    AppMethodBeat.o(152160);
  }
  
  private void onStop()
  {
    AppMethodBeat.i(239181);
    com.tencent.mm.kernel.h.aHF().kcd.b(30, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(667, this);
    AppMethodBeat.o(239181);
  }
  
  public final void a(Activity paramActivity, as paramas, String paramString, LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(293049);
    this.HtJ = paramLinkedList;
    if (this.ReJ == null) {
      this.ReJ = new LinkedList();
    }
    Log.i("MicroMsg.AddContact", "sendRequestImmediateAddContact, userName: %s.", new Object[] { paramString });
    if (paramLinkedList != null) {
      Log.i("MicroMsg.AddContact", "sendRequestImmediateAddContact, lstScene.size: %s.", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    }
    if (paramas != null) {
      Log.i("MicroMsg.AddContact", "sendRequestImmediateAddContact, contact getUsername: %s, getAntiSpamTicket: %s.", new Object[] { paramas.field_username, paramas.hDx });
    }
    String str = paramActivity.getIntent().getStringExtra("room_name");
    paramActivity = paramActivity.getIntent().getStringExtra(f.d.VRW);
    Log.i("MicroMsg.AddContact", "sendRequestImmediateAddContact， roomId = %s, antispamTicketFromCard = %s.", new Object[] { str, paramActivity });
    if (!TextUtils.isEmpty(paramActivity))
    {
      bqY(paramActivity);
      d(paramString, str, paramLinkedList);
      AppMethodBeat.o(293049);
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      bqY(paramas.hDx);
      i(paramString, paramLinkedList);
      AppMethodBeat.o(293049);
      return;
    }
    if (!TextUtils.isEmpty(this.BLy))
    {
      d(paramString, str, paramLinkedList);
      AppMethodBeat.o(293049);
      return;
    }
    if (paramas != null) {}
    for (paramActivity = Util.nullAs(paramas.hDx, "");; paramActivity = "")
    {
      Log.i("MicroMsg.AddContact", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { paramString, str, paramActivity });
      if (TextUtils.isEmpty(paramActivity)) {
        break;
      }
      bqY(paramActivity);
      d(paramString, str, paramLinkedList);
      AppMethodBeat.o(293049);
      return;
    }
    az.a.ltq.a(paramString, str, new a.9(this, paramas, paramString, str, paramLinkedList));
    AppMethodBeat.o(293049);
  }
  
  public final void a(String paramString1, LinkedList<Integer> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(152154);
    a(paramString1, paramLinkedList, false, paramString2);
    AppMethodBeat.o(152154);
  }
  
  public final void b(String paramString, LinkedList<Integer> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(152156);
    a(paramString, paramLinkedList, paramBoolean, "");
    AppMethodBeat.o(152156);
  }
  
  public final void bqY(String paramString)
  {
    AppMethodBeat.i(152155);
    if (!TextUtils.isEmpty(paramString)) {
      this.ReJ.add(paramString);
    }
    AppMethodBeat.o(152155);
  }
  
  public final void d(String paramString1, String paramString2, LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(152152);
    this.chatroomName = paramString2;
    a(paramString1, paramLinkedList, false, "");
    AppMethodBeat.o(152152);
  }
  
  public final void hkc()
  {
    AppMethodBeat.i(239203);
    if (this.ReS != null) {
      com.tencent.mm.kernel.h.aGY().a(this.ReS);
    }
    AppMethodBeat.o(239203);
  }
  
  public final void i(String paramString, LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(152153);
    a(paramString, paramLinkedList, false, "");
    AppMethodBeat.o(152153);
  }
  
  public final void np(String paramString1, String paramString2)
  {
    this.sourceUserName = paramString1;
    this.sourceNickName = paramString2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(152161);
    Log.d("MicroMsg.AddContact", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((paramq.getType() != 30) && (paramq.getType() != 667))
    {
      Log.w("MicroMsg.AddContact", "not expected scene,  type = " + paramq.getType());
      AppMethodBeat.o(152161);
      return;
    }
    if (((paramq instanceof com.tencent.mm.pluginsdk.model.t)) && (((com.tencent.mm.pluginsdk.model.t)paramq).fDn != 1))
    {
      Log.e("MicroMsg.AddContact", "not opcode addcontact!");
      AppMethodBeat.o(152161);
      return;
    }
    dMg();
    fap localfap;
    if ((paramq instanceof com.tencent.mm.pluginsdk.model.t))
    {
      localfap = ((com.tencent.mm.pluginsdk.model.t)paramq).hhe();
      if (this.ReT)
      {
        Log.i("MicroMsg.AddContact", "needShowDialog, isShowErrorDialog.");
        AppMethodBeat.o(152161);
        return;
      }
      if ((localfap != null) && (a((com.tencent.mm.pluginsdk.model.t)paramq, localfap.UAE)))
      {
        localObject = AppForegroundDelegate.fby;
        if ((((AppForegroundDelegate)localObject).fbD == null) || (((AppForegroundDelegate)localObject).fbD.get() == null)) {
          ((AppForegroundDelegate)localObject).fbD = AppForegroundDelegate.aay();
        }
        localObject = ((AppForegroundDelegate)localObject).fbD;
        if (localObject == null) {
          break label471;
        }
      }
    }
    label471:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = new m((Context)localObject);
        String str = localfap.UAE.UAG;
        ((m)localObject).titleTv.setText(str);
        str = localfap.UAE.UAH;
        ((m)localObject).nmi.setText(str);
        paramString = new a.4(this, (m)localObject, paramInt1, paramInt2, paramString, paramq, localfap);
        ((m)localObject).jLo.setOnClickListener(paramString);
        paramString = ((m)localObject).i(new a.3(this, (m)localObject));
        paramq = new a.2(this, localfap);
        paramString.Wkh.setOnClickListener(paramq);
        if (Util.isNullOrNil(localfap.UAE.UAI))
        {
          Log.i("MicroMsg.MMHalfBottomDialog", "hideLinkTips");
          ((m)localObject).Wkh.setVisibility(4);
        }
        ((m)localObject).eik();
        this.ReT = true;
        if (this.ReQ != null) {
          this.ReQ.fqO();
        }
        ((g)localObject).YnH = new g.b()
        {
          public final void dismiss()
          {
            AppMethodBeat.i(228162);
            a.c(a.this);
            a.d(a.this);
            AppMethodBeat.o(228162);
          }
        };
        AppMethodBeat.o(152161);
        return;
      }
      a(paramInt1, paramInt2, paramString, paramq, null);
      AppMethodBeat.o(152161);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract boolean m(String paramString1, int paramInt, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a
 * JD-Core Version:    0.7.0.1
 */