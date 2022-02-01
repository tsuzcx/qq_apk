package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.c;
import com.tencent.mm.openim.b.o;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.protocal.protobuf.dfg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class aa
  implements i
{
  String BAU;
  String BLy;
  private TextView HcF;
  LinkedList<Integer> HtJ;
  String IGF;
  String LeL;
  LinkedList<String> ReI;
  LinkedList<String> ReJ;
  private boolean ReL;
  boolean ReM;
  String ReO;
  private a ReQ;
  public Map<String, Integer> ReR;
  com.tencent.mm.pluginsdk.model.t ReS;
  private b RgT;
  boolean RgU;
  private boolean RgV;
  public String chatroomName;
  public String content;
  private Context context;
  private int fDe;
  String jXW;
  private View mUM;
  private d mUO;
  private EditText qDO;
  private String roomId;
  private s tipDialog;
  int wGA;
  
  public aa(Context paramContext, b paramb)
  {
    AppMethodBeat.i(152244);
    this.mUO = null;
    this.content = "";
    this.ReM = true;
    this.RgU = true;
    this.fDe = 2;
    this.RgV = false;
    this.jXW = "";
    this.BLy = "";
    this.ReL = true;
    this.ReO = "";
    this.wGA = 0;
    this.roomId = "";
    this.context = paramContext;
    this.RgT = paramb;
    AppMethodBeat.o(152244);
  }
  
  private void P(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(225633);
    if ((paramInt1 == 4) && (paramInt2 == -22)) {
      Toast.makeText(this.context, this.context.getString(c.h.addcontact_fail_blacklist), 1).show();
    }
    for (;;)
    {
      Log.i("MicroMsg.SendVerifyRequest", "dealFail.");
      hkb();
      AppMethodBeat.o(225633);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
        Toast.makeText(this.context, paramString, 1).show();
      } else {
        Toast.makeText(this.context, this.context.getString(c.h.addcontact_fail), 1).show();
      }
    }
  }
  
  private void hjY()
  {
    AppMethodBeat.i(152250);
    this.ReS = new com.tencent.mm.pluginsdk.model.t(this.fDe, this.ReI, this.HtJ, this.content, "", this.ReR, this.chatroomName);
    this.ReS.DO(this.ReM);
    this.ReS.nl(this.IGF, this.LeL);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.ReS, 0);
    AppMethodBeat.o(152250);
  }
  
  private void hkG()
  {
    AppMethodBeat.i(225616);
    this.ReS = new com.tencent.mm.pluginsdk.model.t(2, this.ReI, this.HtJ, this.content, "", this.ReR, this.chatroomName);
    this.ReS.DO(this.ReM);
    this.ReS.nl(this.IGF, this.LeL);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.ReS, 0);
    AppMethodBeat.o(225616);
  }
  
  private void hkH()
  {
    AppMethodBeat.i(152251);
    if ((this.ReJ == null) || (this.ReJ.isEmpty()))
    {
      this.RgV = true;
      com.tencent.mm.kernel.h.aHF().kcd.a(881, this);
      com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.openim.b.h((String)this.ReI.getFirst(), "", ""), 0);
      AppMethodBeat.o(152251);
      return;
    }
    com.tencent.mm.kernel.h.aHF().kcd.a(new o((String)this.ReI.getFirst(), this.content, (String)this.ReJ.getFirst(), 0), 0);
    AppMethodBeat.o(152251);
  }
  
  private void hkb()
  {
    AppMethodBeat.i(225637);
    if (this.ReQ != null)
    {
      this.ReQ.fqN();
      Log.i("MicroMsg.SendVerifyRequest", "errorFinishAddContact.");
    }
    AppMethodBeat.o(225637);
  }
  
  private void onStop()
  {
    AppMethodBeat.i(152246);
    com.tencent.mm.kernel.h.aHF().kcd.b(30, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(243, this);
    if (this.mUO != null)
    {
      this.mUO.dismiss();
      this.mUO = null;
    }
    AppMethodBeat.o(152246);
  }
  
  public final void F(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(152249);
    this.RgU = false;
    onStart();
    this.ReI = new LinkedList(paramList);
    this.HtJ = new LinkedList(paramList1);
    if ((paramList.size() == 1) && (as.bvK((String)this.ReI.getFirst())))
    {
      hkH();
      AppMethodBeat.o(152249);
      return;
    }
    hjY();
    AppMethodBeat.o(152249);
  }
  
  public final void a(LinkedList<String> paramLinkedList1, LinkedList<Integer> paramLinkedList, LinkedList<String> paramLinkedList2)
  {
    AppMethodBeat.i(152248);
    boolean bool;
    if (paramLinkedList1.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramLinkedList.size() <= 0) {
        break label325;
      }
      bool = true;
      label31:
      Assert.assertTrue(bool);
      onStart();
      this.ReI = paramLinkedList1;
      this.HtJ = paramLinkedList;
      this.ReJ = paramLinkedList2;
      this.mUM = View.inflate(this.context, c.f.sendrequest_dialog, null);
      if (this.BAU != null) {
        break label331;
      }
      bool = true;
      label80:
      if (this.BAU != null) {
        break label337;
      }
    }
    label325:
    label331:
    label337:
    for (int i = 0;; i = this.BAU.length())
    {
      Log.i("MicroMsg.SendVerifyRequest", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), this.BAU });
      if (!Util.isNullOrNil(this.BAU)) {
        ((TextView)this.mUM.findViewById(c.e.sendrequest_tip)).setText(this.BAU);
      }
      this.qDO = ((EditText)this.mUM.findViewById(c.e.sendrequest_content));
      this.HcF = ((TextView)this.mUM.findViewById(c.e.wordcount));
      this.HcF.setVisibility(0);
      this.qDO.setText(null);
      this.HcF.setText("50");
      this.qDO.setFilters(m.Rxd);
      this.qDO.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(152237);
          int j = 50 - paramAnonymousEditable.length();
          int i = j;
          if (j < 0) {
            i = 0;
          }
          if (aa.a(aa.this) != null) {
            aa.a(aa.this).setText(String.valueOf(i));
          }
          AppMethodBeat.o(152237);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      paramLinkedList1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(152239);
          if (aa.b(aa.this) != null)
          {
            aa.b(aa.this).dismiss();
            aa.c(aa.this);
          }
          new MTimerHandler(new MTimerHandler.CallBack()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(152238);
              if (aa.d(aa.this) != null) {
                aa.a(aa.this, aa.e(aa.this).getText().toString().trim());
              }
              AppMethodBeat.o(152238);
              return false;
            }
          }, false).startTimer(500L);
          AppMethodBeat.o(152239);
        }
      };
      paramLinkedList = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(152240);
          if (aa.b(aa.this) != null)
          {
            aa.b(aa.this).dismiss();
            aa.c(aa.this);
          }
          aa.f(aa.this);
          if (aa.g(aa.this) != null) {
            aa.g(aa.this).dO(false);
          }
          AppMethodBeat.o(152240);
        }
      };
      this.mUO = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(c.h.sendrequest_title), this.mUM, paramLinkedList1, paramLinkedList);
      if (this.mUO == null) {
        onStop();
      }
      this.qDO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(152241);
          if ((aa.h(aa.this) instanceof MMActivity)) {
            ((MMActivity)aa.h(aa.this)).showVKB();
          }
          AppMethodBeat.o(152241);
        }
      });
      AppMethodBeat.o(152248);
      return;
      bool = false;
      break;
      bool = false;
      break label31;
      bool = false;
      break label80;
    }
  }
  
  public final void hkc()
  {
    AppMethodBeat.i(152247);
    if (this.ReS != null) {
      com.tencent.mm.kernel.h.aGY().a(this.ReS);
    }
    AppMethodBeat.o(152247);
  }
  
  public final void nl(String paramString1, String paramString2)
  {
    this.IGF = paramString1;
    this.LeL = paramString2;
  }
  
  public final void onSceneEnd(int paramInt1, final int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(152252);
    if (paramq.getType() == 881)
    {
      com.tencent.mm.kernel.h.aHF().kcd.b(881, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.RgV)
        {
          paramString = ((com.tencent.mm.openim.b.h)paramq).myf.RIS;
          com.tencent.mm.kernel.h.aHF().kcd.a(new o((String)this.ReI.getFirst(), this.content, paramString, 0), 0);
        }
      }
      for (;;)
      {
        this.RgV = false;
        AppMethodBeat.o(152252);
        return;
        Toast.makeText(this.context, this.context.getString(c.h.sendrequest_send_fail), 1).show();
      }
    }
    if ((paramq.getType() != 30) && (paramq.getType() != 243))
    {
      Log.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + paramq.getType());
      AppMethodBeat.o(152252);
      return;
    }
    if (((paramq instanceof com.tencent.mm.pluginsdk.model.t)) && (((com.tencent.mm.pluginsdk.model.t)paramq).fDn != 2) && (((com.tencent.mm.pluginsdk.model.t)paramq).fDn != 1))
    {
      Log.e("MicroMsg.SendVerifyRequest", "not opcode sendrequest!");
      AppMethodBeat.o(152252);
      return;
    }
    Log.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    onStop();
    if (((paramInt1 != 0) || (paramInt2 != 0)) && ((paramq instanceof com.tencent.mm.pluginsdk.model.t)) && (((com.tencent.mm.pluginsdk.model.t)paramq).fDn == 1))
    {
      Log.i("MicroMsg.SendVerifyRequest", "onSceneEnd, addcontact error.");
      if (paramInt2 == -44)
      {
        Log.i("MicroMsg.SendVerifyRequest", "dealAddContactError, resend request ver.");
        this.chatroomName = this.roomId;
        hkG();
        AppMethodBeat.o(152252);
        return;
      }
      if (paramInt2 == -87)
      {
        com.tencent.mm.ui.base.h.c(this.context, this.context.getString(c.h.contact_info_biz_join_fans_limit), "", true);
        hkb();
        AppMethodBeat.o(152252);
        return;
      }
      if ((paramInt2 == -101) && (!Util.isNullOrNil(paramString)))
      {
        Log.d("MicroMsg.SendVerifyRequest", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
        com.tencent.mm.ui.base.h.a(this.context, paramString, "", false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(189115);
            Log.d("MicroMsg.SendVerifyRequest", "jacks 1 catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
            aa.k(aa.this);
            AppMethodBeat.o(189115);
          }
        });
        AppMethodBeat.o(152252);
        return;
      }
      if (paramInt2 == -2)
      {
        if (!Util.isNullOrNil(paramString))
        {
          com.tencent.mm.ui.base.h.a(this.context, paramString, this.context.getString(c.h.app_tip), this.context.getString(c.h.app_ok), null);
          hkb();
          AppMethodBeat.o(152252);
          return;
        }
        P(paramInt1, paramInt2, null);
        AppMethodBeat.o(152252);
        return;
      }
      if (paramInt2 == -160)
      {
        if (!Util.isNullOrNil(paramString))
        {
          com.tencent.mm.ui.base.h.c(this.context, paramString, "", this.context.getResources().getString(c.h.app_continue), this.context.getResources().getString(c.h.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(232801);
              aa.i(aa.this);
              paramAnonymousDialogInterface = aa.this;
              paramAnonymousDialogInterface.RgU = false;
              paramAnonymousDialogInterface.onStart();
              paramAnonymousDialogInterface.ReS = new com.tencent.mm.pluginsdk.model.t(1, paramAnonymousDialogInterface.ReI, paramAnonymousDialogInterface.HtJ, paramAnonymousDialogInterface.ReJ, paramAnonymousDialogInterface.content, paramAnonymousDialogInterface.BLy, paramAnonymousDialogInterface.ReR, paramAnonymousDialogInterface.chatroomName, paramAnonymousDialogInterface.jXW);
              if (!Util.isNullOrNil(paramAnonymousDialogInterface.IGF)) {
                paramAnonymousDialogInterface.ReS.nl(paramAnonymousDialogInterface.IGF, paramAnonymousDialogInterface.LeL);
              }
              paramAnonymousDialogInterface.ReS.WW(paramAnonymousDialogInterface.ReO);
              paramAnonymousDialogInterface.ReS.setSubScene(paramAnonymousDialogInterface.wGA);
              paramAnonymousDialogInterface.ReS.DO(paramAnonymousDialogInterface.ReM);
              com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousDialogInterface.ReS, 0);
              AppMethodBeat.o(232801);
            }
          }, null);
          AppMethodBeat.o(152252);
          return;
        }
        P(paramInt1, paramInt2, paramString);
        AppMethodBeat.o(152252);
        return;
      }
      P(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(152252);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.SendVerifyRequest", "onSceneEnd, 已发送");
      if (this.RgU) {
        com.tencent.mm.ui.base.h.cO(this.context, this.context.getString(c.h.sendrequest_send_success));
      }
      if (this.RgT != null)
      {
        this.RgT.dO(true);
        AppMethodBeat.o(152252);
      }
    }
    else
    {
      if ((paramInt1 != 4) || (paramInt2 != -34)) {
        break label758;
      }
      paramq = this.context.getString(c.h.fmessage_request_too_offen);
    }
    for (;;)
    {
      if ((this.RgU) && (!Util.isNullOrNil(paramq))) {
        Toast.makeText(this.context, paramq, 1).show();
      }
      if (this.RgT != null) {
        this.RgT.dO(false);
      }
      AppMethodBeat.o(152252);
      return;
      label758:
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramq = this.context.getString(c.h.fmessage_user_not_support);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramq = paramString;
        if (!Util.isNullOrNil(paramString)) {}
      }
      else
      {
        if (paramInt2 == -160)
        {
          if (!Util.isNullOrNil(paramString))
          {
            com.tencent.mm.ui.base.h.c(this.context, paramString, "", this.context.getResources().getString(c.h.app_continue), this.context.getResources().getString(c.h.app_cancel), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(152243);
                aa.i(aa.this);
                aa.j(aa.this);
                AppMethodBeat.o(152243);
              }
            }, null);
            paramq = null;
          }
        }
        else
        {
          if (paramInt1 == 4)
          {
            paramq = paramString;
            if (!Util.isNullOrNil(paramString)) {
              continue;
            }
          }
          paramq = this.context.getString(c.h.sendrequest_send_fail);
          continue;
        }
        paramq = null;
      }
    }
  }
  
  final void onStart()
  {
    AppMethodBeat.i(152245);
    com.tencent.mm.kernel.h.aHF().kcd.a(30, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(243, this);
    AppMethodBeat.o(152245);
  }
  
  public static abstract interface a
  {
    public abstract void fqN();
    
    public abstract void fqO();
  }
  
  public static abstract interface b
  {
    public abstract void dO(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.aa
 * JD-Core Version:    0.7.0.1
 */