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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.openim.model.j;
import com.tencent.mm.openim.model.r;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.protobuf.dxi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class ab
  implements com.tencent.mm.am.h
{
  int AcJ;
  String His;
  private TextView NaQ;
  LinkedList<Integer> NrA;
  String OMN;
  String REU;
  LinkedList<String> YaN;
  LinkedList<String> YaO;
  private boolean YaQ;
  boolean YaR;
  String YaT;
  private a YaV;
  public Map<String, Integer> YaW;
  v YaX;
  private b YcZ;
  boolean Yda;
  private boolean Ydb;
  public String chatroomName;
  public String content;
  private Context context;
  private int hHT;
  String mxQ;
  String pPi;
  private View pRt;
  private e pRv;
  private String roomId;
  private EditText tID;
  private w tipDialog;
  
  public ab(Context paramContext, b paramb)
  {
    AppMethodBeat.i(152244);
    this.pRv = null;
    this.content = "";
    this.YaR = true;
    this.Yda = true;
    this.hHT = 2;
    this.Ydb = false;
    this.mxQ = "";
    this.pPi = "";
    this.YaQ = true;
    this.YaT = "";
    this.AcJ = 0;
    this.roomId = "";
    this.context = paramContext;
    this.YcZ = paramb;
    AppMethodBeat.o(152244);
  }
  
  private void Z(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(245274);
    if ((paramInt1 == 4) && (paramInt2 == -22)) {
      Toast.makeText(this.context, this.context.getString(c.h.addcontact_fail_blacklist), 1).show();
    }
    for (;;)
    {
      Log.i("MicroMsg.SendVerifyRequest", "dealFail.");
      iKT();
      AppMethodBeat.o(245274);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
        Toast.makeText(this.context, paramString, 1).show();
      } else {
        Toast.makeText(this.context, this.context.getString(c.h.addcontact_fail), 1).show();
      }
    }
  }
  
  private void iKQ()
  {
    AppMethodBeat.i(152250);
    this.YaX = new v(this.hHT, this.YaN, this.NrA, this.content, "", this.YaW, this.chatroomName);
    this.YaX.Jv(this.YaR);
    this.YaX.pg(this.OMN, this.REU);
    com.tencent.mm.kernel.h.baD().mCm.a(this.YaX, 0);
    AppMethodBeat.o(152250);
  }
  
  private void iKT()
  {
    AppMethodBeat.i(245278);
    if (this.YaV != null)
    {
      this.YaV.gCl();
      Log.i("MicroMsg.SendVerifyRequest", "errorFinishAddContact.");
    }
    AppMethodBeat.o(245278);
  }
  
  private void iLx()
  {
    AppMethodBeat.i(245265);
    this.YaX = new v(2, this.YaN, this.NrA, this.content, "", this.YaW, this.chatroomName);
    this.YaX.Jv(this.YaR);
    this.YaX.pg(this.OMN, this.REU);
    com.tencent.mm.kernel.h.baD().mCm.a(this.YaX, 0);
    AppMethodBeat.o(245265);
  }
  
  private void iLy()
  {
    AppMethodBeat.i(152251);
    if ((this.YaO == null) || (this.YaO.isEmpty()))
    {
      this.Ydb = true;
      com.tencent.mm.kernel.h.baD().mCm.a(881, this);
      com.tencent.mm.kernel.h.baD().mCm.a(new j((String)this.YaN.getFirst(), "", ""), 0);
      AppMethodBeat.o(152251);
      return;
    }
    com.tencent.mm.kernel.h.baD().mCm.a(new r((String)this.YaN.getFirst(), this.content, (String)this.YaO.getFirst(), 0), 0);
    AppMethodBeat.o(152251);
  }
  
  private void onStop()
  {
    AppMethodBeat.i(152246);
    com.tencent.mm.kernel.h.baD().mCm.b(30, this);
    com.tencent.mm.kernel.h.baD().mCm.b(243, this);
    if (this.pRv != null)
    {
      this.pRv.dismiss();
      this.pRv = null;
    }
    AppMethodBeat.o(152246);
  }
  
  public final void S(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(152249);
    this.Yda = false;
    onStart();
    this.YaN = new LinkedList(paramList);
    this.NrA = new LinkedList(paramList1);
    if ((paramList.size() == 1) && (au.bwO((String)this.YaN.getFirst())))
    {
      iLy();
      AppMethodBeat.o(152249);
      return;
    }
    iKQ();
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
      this.YaN = paramLinkedList1;
      this.NrA = paramLinkedList;
      this.YaO = paramLinkedList2;
      this.pRt = View.inflate(this.context, c.f.sendrequest_dialog, null);
      if (this.His != null) {
        break label331;
      }
      bool = true;
      label80:
      if (this.His != null) {
        break label337;
      }
    }
    label325:
    label331:
    label337:
    for (int i = 0;; i = this.His.length())
    {
      Log.i("MicroMsg.SendVerifyRequest", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), this.His });
      if (!Util.isNullOrNil(this.His)) {
        ((TextView)this.pRt.findViewById(c.e.sendrequest_tip)).setText(this.His);
      }
      this.tID = ((EditText)this.pRt.findViewById(c.e.sendrequest_content));
      this.NaQ = ((TextView)this.pRt.findViewById(c.e.wordcount));
      this.NaQ.setVisibility(0);
      this.tID.setText(null);
      this.NaQ.setText("50");
      this.tID.setFilters(com.tencent.mm.pluginsdk.ui.tools.k.Ytp);
      this.tID.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(152237);
          int j = 50 - paramAnonymousEditable.length();
          int i = j;
          if (j < 0) {
            i = 0;
          }
          if (ab.a(ab.this) != null) {
            ab.a(ab.this).setText(String.valueOf(i));
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
          if (ab.b(ab.this) != null)
          {
            ab.b(ab.this).dismiss();
            ab.c(ab.this);
          }
          new MTimerHandler(new MTimerHandler.CallBack()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(152238);
              if (ab.d(ab.this) != null) {
                ab.a(ab.this, ab.e(ab.this).getText().toString().trim());
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
          if (ab.b(ab.this) != null)
          {
            ab.b(ab.this).dismiss();
            ab.c(ab.this);
          }
          ab.f(ab.this);
          if (ab.g(ab.this) != null) {
            ab.g(ab.this).sendEnd(false);
          }
          AppMethodBeat.o(152240);
        }
      };
      this.pRv = com.tencent.mm.ui.base.k.a(this.context, this.context.getString(c.h.sendrequest_title), this.pRt, paramLinkedList1, paramLinkedList);
      if (this.pRv == null) {
        onStop();
      }
      this.tID.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(152241);
          if ((ab.h(ab.this) instanceof MMActivity)) {
            ((MMActivity)ab.h(ab.this)).showVKB();
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
  
  public final void iKU()
  {
    AppMethodBeat.i(152247);
    if (this.YaX != null) {
      com.tencent.mm.kernel.h.aZW().a(this.YaX);
    }
    AppMethodBeat.o(152247);
  }
  
  public final void onSceneEnd(int paramInt1, final int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(152252);
    if (paramp.getType() == 881)
    {
      com.tencent.mm.kernel.h.baD().mCm.b(881, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.Ydb)
        {
          paramString = ((j)paramp).pst.YFT;
          com.tencent.mm.kernel.h.baD().mCm.a(new r((String)this.YaN.getFirst(), this.content, paramString, 0), 0);
        }
      }
      for (;;)
      {
        this.Ydb = false;
        AppMethodBeat.o(152252);
        return;
        Toast.makeText(this.context, this.context.getString(c.h.sendrequest_send_fail), 1).show();
      }
    }
    if ((paramp.getType() != 30) && (paramp.getType() != 243))
    {
      Log.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + paramp.getType());
      AppMethodBeat.o(152252);
      return;
    }
    if (((paramp instanceof v)) && (((v)paramp).hId != 2) && (((v)paramp).hId != 1))
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
    if (((paramInt1 != 0) || (paramInt2 != 0)) && ((paramp instanceof v)) && (((v)paramp).hId == 1))
    {
      Log.i("MicroMsg.SendVerifyRequest", "onSceneEnd, addcontact error.");
      if (paramInt2 == -44)
      {
        Log.i("MicroMsg.SendVerifyRequest", "dealAddContactError, resend request ver.");
        this.chatroomName = this.roomId;
        iLx();
        AppMethodBeat.o(152252);
        return;
      }
      if (paramInt2 == -87)
      {
        com.tencent.mm.ui.base.k.c(this.context, this.context.getString(c.h.contact_info_biz_join_fans_limit), "", true);
        iKT();
        AppMethodBeat.o(152252);
        return;
      }
      if ((paramInt2 == -101) && (!Util.isNullOrNil(paramString)))
      {
        Log.d("MicroMsg.SendVerifyRequest", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
        com.tencent.mm.ui.base.k.a(this.context, paramString, "", false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(245280);
            Log.d("MicroMsg.SendVerifyRequest", "jacks 1 catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
            ab.k(ab.this);
            AppMethodBeat.o(245280);
          }
        });
        AppMethodBeat.o(152252);
        return;
      }
      if (paramInt2 == -2)
      {
        if (!Util.isNullOrNil(paramString))
        {
          com.tencent.mm.ui.base.k.a(this.context, paramString, this.context.getString(c.h.app_tip), this.context.getString(c.h.app_ok), null);
          iKT();
          AppMethodBeat.o(152252);
          return;
        }
        Z(paramInt1, paramInt2, null);
        AppMethodBeat.o(152252);
        return;
      }
      if (paramInt2 == -160)
      {
        if (!Util.isNullOrNil(paramString))
        {
          com.tencent.mm.ui.base.k.b(this.context, paramString, "", this.context.getResources().getString(c.h.app_continue), this.context.getResources().getString(c.h.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(245258);
              ab.i(ab.this);
              paramAnonymousDialogInterface = ab.this;
              paramAnonymousDialogInterface.Yda = false;
              paramAnonymousDialogInterface.onStart();
              paramAnonymousDialogInterface.YaX = new v(1, paramAnonymousDialogInterface.YaN, paramAnonymousDialogInterface.NrA, paramAnonymousDialogInterface.YaO, paramAnonymousDialogInterface.content, paramAnonymousDialogInterface.pPi, paramAnonymousDialogInterface.YaW, paramAnonymousDialogInterface.chatroomName, paramAnonymousDialogInterface.mxQ);
              if (!Util.isNullOrNil(paramAnonymousDialogInterface.OMN)) {
                paramAnonymousDialogInterface.YaX.pg(paramAnonymousDialogInterface.OMN, paramAnonymousDialogInterface.REU);
              }
              paramAnonymousDialogInterface.YaX.OW(paramAnonymousDialogInterface.YaT);
              paramAnonymousDialogInterface.YaX.setSubScene(paramAnonymousDialogInterface.AcJ);
              paramAnonymousDialogInterface.YaX.Jv(paramAnonymousDialogInterface.YaR);
              com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousDialogInterface.YaX, 0);
              AppMethodBeat.o(245258);
            }
          }, null);
          AppMethodBeat.o(152252);
          return;
        }
        Z(paramInt1, paramInt2, paramString);
        AppMethodBeat.o(152252);
        return;
      }
      Z(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(152252);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.SendVerifyRequest", "onSceneEnd, 已发送");
      if (this.Yda) {
        com.tencent.mm.ui.base.k.cZ(this.context, this.context.getString(c.h.sendrequest_send_success));
      }
      if (this.YcZ != null)
      {
        this.YcZ.sendEnd(true);
        AppMethodBeat.o(152252);
      }
    }
    else
    {
      if ((paramInt1 != 4) || (paramInt2 != -34)) {
        break label758;
      }
      paramp = this.context.getString(c.h.fmessage_request_too_offen);
    }
    for (;;)
    {
      if ((this.Yda) && (!Util.isNullOrNil(paramp))) {
        Toast.makeText(this.context, paramp, 1).show();
      }
      if (this.YcZ != null) {
        this.YcZ.sendEnd(false);
      }
      AppMethodBeat.o(152252);
      return;
      label758:
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramp = this.context.getString(c.h.fmessage_user_not_support);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramp = paramString;
        if (!Util.isNullOrNil(paramString)) {}
      }
      else
      {
        if (paramInt2 == -160)
        {
          if (!Util.isNullOrNil(paramString))
          {
            com.tencent.mm.ui.base.k.b(this.context, paramString, "", this.context.getResources().getString(c.h.app_continue), this.context.getResources().getString(c.h.app_cancel), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(152243);
                ab.i(ab.this);
                ab.j(ab.this);
                AppMethodBeat.o(152243);
              }
            }, null);
            paramp = null;
          }
        }
        else
        {
          if (paramInt1 == 4)
          {
            paramp = paramString;
            if (!Util.isNullOrNil(paramString)) {
              continue;
            }
          }
          paramp = this.context.getString(c.h.sendrequest_send_fail);
          continue;
        }
        paramp = null;
      }
    }
  }
  
  final void onStart()
  {
    AppMethodBeat.i(152245);
    com.tencent.mm.kernel.h.baD().mCm.a(30, this);
    com.tencent.mm.kernel.h.baD().mCm.a(243, this);
    AppMethodBeat.o(152245);
  }
  
  public final void pg(String paramString1, String paramString2)
  {
    this.OMN = paramString1;
    this.REU = paramString2;
  }
  
  public static abstract interface a
  {
    public abstract void gCl();
    
    public abstract void gCm();
  }
  
  public static abstract interface b
  {
    public abstract void sendEnd(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ab
 * JD-Core Version:    0.7.0.1
 */