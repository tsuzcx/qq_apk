package com.tencent.mm.pluginsdk.ui.applet;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.a.on;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.protobuf.fws;
import com.tencent.mm.protocal.protobuf.fwv;
import com.tencent.mm.protocal.protobuf.fww;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.b;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.am.h
{
  public int AcJ;
  public String His;
  private LinkedList<Integer> NrA;
  private a YaL;
  public b YaM;
  private LinkedList<String> YaN;
  private LinkedList<String> YaO;
  private String YaP;
  public boolean YaQ;
  private boolean YaR;
  public boolean YaS;
  public String YaT;
  public fws YaU;
  public ab.a YaV;
  public Map<String, Integer> YaW;
  private v YaX;
  private boolean YaY;
  public String YaZ;
  public String chatroomName;
  public String content;
  private Context context;
  public boolean hks;
  private String mxQ;
  public String pPi;
  public String pVP;
  private String sourceNickName;
  private String sourceUserName;
  private w tipDialog;
  
  public a(Context paramContext, a parama)
  {
    AppMethodBeat.i(152151);
    this.mxQ = "";
    this.pPi = "";
    this.YaP = "";
    this.chatroomName = "";
    this.YaQ = true;
    this.hks = true;
    this.YaR = true;
    this.pVP = "";
    this.YaS = false;
    this.YaT = "";
    this.AcJ = 0;
    this.content = "";
    this.YaY = false;
    this.YaZ = "";
    this.context = paramContext;
    this.YaL = parama;
    this.YaN = new LinkedList();
    this.YaO = new LinkedList();
    this.tipDialog = null;
    AppMethodBeat.o(152151);
  }
  
  private void Z(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(152162);
    if ((this.YaS) && (!Util.isNullOrNil(paramString))) {
      k.c(this.context, paramString, "", true);
    }
    for (;;)
    {
      b(false, false, this.YaP, this.pVP);
      iKT();
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
  
  private void a(int paramInt1, int paramInt2, String paramString1, p paramp, String paramString2)
  {
    AppMethodBeat.i(245256);
    eGg();
    onStop();
    this.YaY = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp.getType() == 30) {
        this.YaP = ((v)paramp).iIc();
      }
      for (;;)
      {
        iKS();
        AppMethodBeat.o(245256);
        return;
        if (paramp.getType() == 667) {
          this.YaP = ((com.tencent.mm.openim.model.b)paramp).psp;
        }
      }
    }
    b localb;
    if (paramInt2 == -44)
    {
      paramp = this.pVP;
      if (this.YaM != null)
      {
        localb = this.YaM;
        if (!this.YaO.isEmpty()) {
          break label146;
        }
      }
      label146:
      for (paramString1 = ""; !localb.n(paramString1, paramInt2, paramString2); paramString1 = (String)this.YaO.getFirst())
      {
        iKR();
        AppMethodBeat.o(245256);
        return;
      }
      b(false, false, this.YaP, paramp);
      AppMethodBeat.o(245256);
      return;
    }
    if (paramInt2 == -4000)
    {
      paramp = this.pVP;
      if (this.YaM != null)
      {
        localb = this.YaM;
        if (!this.YaO.isEmpty()) {
          break label241;
        }
      }
      label241:
      for (paramString1 = ""; !localb.n(paramString1, paramInt2, paramString2); paramString1 = (String)this.YaO.getFirst())
      {
        iKR();
        AppMethodBeat.o(245256);
        return;
      }
      b(false, false, this.YaP, paramp);
      AppMethodBeat.o(245256);
      return;
    }
    if (paramInt2 == -87)
    {
      k.c(this.context, this.context.getString(c.h.contact_info_biz_join_fans_limit), "", true);
      iKT();
      AppMethodBeat.o(245256);
      return;
    }
    if ((paramInt2 == -101) && (!Util.isNullOrNil(paramString1)))
    {
      Log.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString1 });
      k.a(this.context, paramString1, "", false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(245279);
          a.a(a.this, false, a.a(a.this), a.e(a.this));
          a.f(a.this);
          AppMethodBeat.o(245279);
        }
      });
      AppMethodBeat.o(245256);
      return;
    }
    if (paramInt2 == -2)
    {
      if (!Util.isNullOrNil(paramString1))
      {
        k.a(this.context, paramString1, this.context.getString(c.h.app_tip), this.context.getString(c.h.app_ok), null);
        iKT();
        AppMethodBeat.o(245256);
        return;
      }
      Z(paramInt1, paramInt2, null);
      AppMethodBeat.o(245256);
      return;
    }
    if (paramInt2 == -160)
    {
      if (!Util.isNullOrNil(paramString1))
      {
        k.b(this.context, paramString1, "", this.context.getResources().getString(c.h.app_continue), this.context.getResources().getString(c.h.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(245277);
            a.g(a.this);
            a.h(a.this);
            a.f(a.this);
            AppMethodBeat.o(245277);
          }
        }, null);
        AppMethodBeat.o(245256);
        return;
      }
      Z(paramInt1, paramInt2, paramString1);
      AppMethodBeat.o(245256);
      return;
    }
    Z(paramInt1, paramInt2, paramString1);
    AppMethodBeat.o(245256);
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
      this.YaQ = paramBoolean;
      this.mxQ = paramString2;
      this.NrA = paramLinkedList;
      this.YaN.add(paramString1);
      this.YaP = paramString1;
      iKQ();
      AppMethodBeat.o(152157);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static boolean a(v paramv, fww paramfww)
  {
    AppMethodBeat.i(245281);
    if (!iKV())
    {
      Log.i("MicroMsg.AddContact", "needShowDialog, isSupportStrangerBadManDialogShow is 0.");
      AppMethodBeat.o(245281);
      return false;
    }
    if (paramfww == null)
    {
      Log.i("MicroMsg.AddContact", "needShowDialog, verifyUserSpamInfo is null.");
      AppMethodBeat.o(245281);
      return false;
    }
    if (paramv.hId != 1)
    {
      Log.i("MicroMsg.AddContact", "needShowDialog, is not MM_VERIFYUSER_ADDCONTACT.");
      AppMethodBeat.o(245281);
      return false;
    }
    if ((Util.isNullOrNil(paramfww.abUK)) || (Util.isNullOrNil(paramfww.abUJ)))
    {
      Log.i("MicroMsg.AddContact", "needShowDialog, key word is null.");
      AppMethodBeat.o(245281);
      return false;
    }
    AppMethodBeat.o(245281);
    return true;
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(152159);
    if (this.YaL != null) {
      this.YaL.canAddContact(paramBoolean1, paramBoolean2, paramString1, paramString2);
    }
    if (paramBoolean1)
    {
      paramString2 = new on();
      paramString2.hRj.username = paramString1;
      paramString2.publish();
    }
    AppMethodBeat.o(152159);
  }
  
  private void eGg()
  {
    AppMethodBeat.i(245259);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(245259);
  }
  
  private void iKQ()
  {
    AppMethodBeat.i(152158);
    onStart();
    if (this.hks)
    {
      localObject = this.context;
      this.context.getString(c.h.app_tip);
      this.tipDialog = k.a((Context)localObject, this.context.getString(c.h.contact_info_adding_tip), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(152147);
          a.a(a.this, false, a.a(a.this), a.b(a.this));
          AppMethodBeat.o(152147);
        }
      });
    }
    if (au.bwO((String)this.YaN.getFirst()))
    {
      String str = (String)this.YaN.getFirst();
      if (this.YaO.isEmpty()) {}
      for (localObject = "";; localObject = (String)this.YaO.getFirst())
      {
        localObject = new com.tencent.mm.openim.model.b(str, (String)localObject);
        com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
        AppMethodBeat.o(152158);
        return;
      }
    }
    Object localObject = new v(1, this.YaN, this.NrA, this.YaO, this.content, this.pPi, this.YaW, this.chatroomName, this.mxQ, this.YaZ);
    if (!Util.isNullOrNil(this.sourceUserName)) {
      ((v)localObject).pg(this.sourceUserName, this.sourceNickName);
    }
    ((v)localObject).OW(this.YaT);
    ((v)localObject).setSubScene(this.AcJ);
    ((v)localObject).a(this.YaU);
    ((v)localObject).Jv(this.YaR);
    com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
    AppMethodBeat.o(152158);
  }
  
  private void iKR()
  {
    AppMethodBeat.i(245260);
    ab localab = new ab(this.context, new ab.b()
    {
      public final void sendEnd(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(245239);
        String str = a.e(a.this);
        a locala = a.this;
        a.a(locala, paramAnonymousBoolean, a.a(locala), str);
        AppMethodBeat.o(245239);
      }
    });
    if (this.His != null) {
      localab.His = this.His;
    }
    if (this.YaQ)
    {
      localab.S(this.YaN, this.NrA);
      AppMethodBeat.o(245260);
      return;
    }
    localab.a(this.YaN, this.NrA, this.YaO);
    AppMethodBeat.o(245260);
  }
  
  private void iKS()
  {
    AppMethodBeat.i(245264);
    b(true, false, this.YaP, this.pVP);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    String str = this.sourceUserName;
    if (this.NrA.size() > 0) {}
    for (int i = ((Integer)this.NrA.getLast()).intValue();; i = 0)
    {
      localh.b(18713, new Object[] { str, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0) });
      AppMethodBeat.o(245264);
      return;
    }
  }
  
  private void iKT()
  {
    AppMethodBeat.i(245271);
    if (this.YaV != null)
    {
      this.YaV.gCl();
      Log.i("MicroMsg.AddContact", "errorFinishAddContact.");
    }
    AppMethodBeat.o(245271);
  }
  
  private static boolean iKV()
  {
    AppMethodBeat.i(245275);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpn, 1);
    Log.i("MicroMsg.AddContact", "isSupportStrangerBadManDialogShow() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(245275);
      return true;
    }
    AppMethodBeat.o(245275);
    return false;
  }
  
  private void onStart()
  {
    AppMethodBeat.i(152160);
    com.tencent.mm.kernel.h.baD().mCm.a(30, this);
    com.tencent.mm.kernel.h.baD().mCm.a(667, this);
    AppMethodBeat.o(152160);
  }
  
  private void onStop()
  {
    AppMethodBeat.i(245254);
    com.tencent.mm.kernel.h.baD().mCm.b(30, this);
    com.tencent.mm.kernel.h.baD().mCm.b(667, this);
    AppMethodBeat.o(245254);
  }
  
  public final void a(Activity paramActivity, final au paramau, final String paramString, final LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(245313);
    this.NrA = paramLinkedList;
    if (this.YaO == null) {
      this.YaO = new LinkedList();
    }
    Log.i("MicroMsg.AddContact", "sendRequestImmediateAddContact, userName: %s.", new Object[] { paramString });
    if (paramLinkedList != null) {
      Log.i("MicroMsg.AddContact", "sendRequestImmediateAddContact, lstScene.size: %s.", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    }
    if (paramau != null) {
      Log.i("MicroMsg.AddContact", "sendRequestImmediateAddContact, contact getUsername: %s, getAntiSpamTicket: %s.", new Object[] { paramau.field_username, paramau.kas });
    }
    final String str = paramActivity.getIntent().getStringExtra("room_name");
    paramActivity = paramActivity.getIntent().getStringExtra(f.e.adwe);
    Log.i("MicroMsg.AddContact", "sendRequestImmediateAddContact， roomId = %s, antispamTicketFromCard = %s.", new Object[] { str, paramActivity });
    if (!TextUtils.isEmpty(paramActivity))
    {
      bqM(paramActivity);
      d(paramString, str, paramLinkedList);
      AppMethodBeat.o(245313);
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      bqM(paramau.kas);
      i(paramString, paramLinkedList);
      AppMethodBeat.o(245313);
      return;
    }
    if (!TextUtils.isEmpty(this.pPi))
    {
      d(paramString, str, paramLinkedList);
      AppMethodBeat.o(245313);
      return;
    }
    if (paramau != null) {}
    for (paramActivity = Util.nullAs(paramau.kas, "");; paramActivity = "")
    {
      Log.i("MicroMsg.AddContact", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { paramString, str, paramActivity });
      if (TextUtils.isEmpty(paramActivity)) {
        break;
      }
      bqM(paramActivity);
      d(paramString, str, paramLinkedList);
      AppMethodBeat.o(245313);
      return;
    }
    az.a.okP.a(paramString, str, new az.b.a()
    {
      public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(245241);
        paramAnonymousString = paramau;
        if (paramAnonymousString != null) {}
        for (paramAnonymousString = Util.nullAs(paramAnonymousString.kas, "");; paramAnonymousString = "")
        {
          a.this.bqM(paramAnonymousString);
          a.this.d(paramString, str, paramLinkedList);
          AppMethodBeat.o(245241);
          return;
        }
      }
    });
    AppMethodBeat.o(245313);
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
  
  public final void bqM(String paramString)
  {
    AppMethodBeat.i(152155);
    if (!TextUtils.isEmpty(paramString)) {
      this.YaO.add(paramString);
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
  
  public final void i(String paramString, LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(152153);
    a(paramString, paramLinkedList, false, "");
    AppMethodBeat.o(152153);
  }
  
  public final void iKU()
  {
    AppMethodBeat.i(245318);
    if (this.YaX != null) {
      com.tencent.mm.kernel.h.aZW().a(this.YaX);
    }
    AppMethodBeat.o(245318);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final p paramp)
  {
    AppMethodBeat.i(152161);
    Log.i("MicroMsg.AddContact", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((paramp.getType() != 30) && (paramp.getType() != 667))
    {
      Log.w("MicroMsg.AddContact", "not expected scene,  type = " + paramp.getType());
      AppMethodBeat.o(152161);
      return;
    }
    if (((paramp instanceof v)) && (((v)paramp).hId != 1))
    {
      Log.e("MicroMsg.AddContact", "not opcode addcontact!");
      AppMethodBeat.o(152161);
      return;
    }
    eGg();
    final fwv localfwv;
    if ((paramp instanceof v))
    {
      localfwv = ((v)paramp).iId();
      if (this.YaY)
      {
        Log.i("MicroMsg.AddContact", "needShowDialog, isShowErrorDialog.");
        AppMethodBeat.o(152161);
        return;
      }
      if ((localfwv != null) && (a((v)paramp, localfwv.abUH)))
      {
        localObject = AppForegroundDelegate.heY.aCb();
        if (localObject == null) {
          break label440;
        }
      }
    }
    label440:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = new q((Context)localObject);
        String str = localfwv.abUH.abUJ;
        ((q)localObject).titleTv.setText(str);
        str = localfwv.abUH.abUK;
        ((q)localObject).qjr.setText(str);
        paramString = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(245269);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/AddContact$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            this.Ybc.cyW();
            a.a(a.this, paramInt1, paramInt2, paramString, paramp, localfwv.abUG);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/AddContact$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245269);
          }
        };
        ((q)localObject).mkz.setOnClickListener(paramString);
        paramString = ((q)localObject).l(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(245266);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/AddContact$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            this.Ybc.cyW();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/AddContact$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245266);
          }
        });
        paramp = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(245286);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/AddContact$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", localfwv.abUH.abUL);
            com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/AddContact$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245286);
          }
        };
        paramString.adRp.setOnClickListener(paramp);
        if (Util.isNullOrNil(localfwv.abUH.abUL))
        {
          Log.i("MicroMsg.MMHalfBottomDialog", "hideLinkTips");
          ((q)localObject).adRp.setVisibility(4);
        }
        ((q)localObject).dDn();
        this.YaY = true;
        if (this.YaV != null) {
          this.YaV.gCm();
        }
        ((j)localObject).agfT = new j.b()
        {
          public final void dismiss()
          {
            AppMethodBeat.i(245273);
            a.c(a.this);
            a.d(a.this);
            AppMethodBeat.o(245273);
          }
        };
        AppMethodBeat.o(152161);
        return;
      }
      a(paramInt1, paramInt2, paramString, paramp, null);
      AppMethodBeat.o(152161);
      return;
    }
  }
  
  public final void pk(String paramString1, String paramString2)
  {
    this.sourceUserName = paramString1;
    this.sourceNickName = paramString2;
  }
  
  public static abstract interface a
  {
    public abstract void canAddContact(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract boolean n(String paramString1, int paramInt, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a
 * JD-Core Version:    0.7.0.1
 */