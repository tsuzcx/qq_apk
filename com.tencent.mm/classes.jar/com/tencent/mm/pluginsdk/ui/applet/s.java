package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.o;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.protocal.c.bbd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c;
import java.util.LinkedList;
import junit.framework.Assert;

public final class s
  implements f
{
  String content = "";
  Context context;
  View feu;
  c few = null;
  EditText nge;
  LinkedList<Integer> nkB;
  TextView nmd;
  private LinkedList<String> sbH = new LinkedList();
  String sbI;
  s.a sdo;
  LinkedList<String> sdp;
  boolean sdq = true;
  private boolean sdr = false;
  com.tencent.mm.ui.base.p tipDialog;
  
  public s(Context paramContext, s.a parama)
  {
    this.context = paramContext;
    this.sdo = parama;
  }
  
  public final void a(LinkedList<String> paramLinkedList1, LinkedList<Integer> paramLinkedList, LinkedList<String> paramLinkedList2)
  {
    boolean bool;
    if (paramLinkedList1.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramLinkedList.size() <= 0) {
        break label311;
      }
      bool = true;
      label25:
      Assert.assertTrue(bool);
      onStart();
      this.sdp = paramLinkedList1;
      this.nkB = paramLinkedList;
      this.sbH = paramLinkedList2;
      this.feu = View.inflate(this.context, a.f.sendrequest_dialog, null);
      if (this.sbI != null) {
        break label317;
      }
      bool = true;
      label74:
      if (this.sbI != null) {
        break label323;
      }
    }
    label311:
    label317:
    label323:
    for (int i = 0;; i = this.sbI.length())
    {
      y.i("MicroMsg.SendVerifyRequest", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), this.sbI });
      if (!bk.bl(this.sbI)) {
        ((TextView)this.feu.findViewById(a.e.sendrequest_tip)).setText(this.sbI);
      }
      this.nge = ((EditText)this.feu.findViewById(a.e.sendrequest_content));
      this.nmd = ((TextView)this.feu.findViewById(a.e.wordcount));
      this.nmd.setVisibility(0);
      this.nge.setText(null);
      this.nmd.setText("50");
      this.nge.setFilters(com.tencent.mm.pluginsdk.ui.tools.h.smJ);
      this.nge.addTextChangedListener(new s.1(this));
      paramLinkedList1 = new s.2(this);
      paramLinkedList = new s.3(this);
      this.few = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(a.h.sendrequest_title), this.feu, paramLinkedList1, paramLinkedList);
      if (this.few == null) {
        onStop();
      }
      this.nge.post(new s.4(this));
      return;
      bool = false;
      break;
      bool = false;
      break label25;
      bool = false;
      break label74;
    }
  }
  
  final void cmS()
  {
    if (this.sbH.isEmpty())
    {
      this.sdr = true;
      g.DO().dJT.a(881, this);
      g.DO().dJT.a(new com.tencent.mm.openim.b.h((String)this.sdp.getFirst(), "", ""), 0);
      return;
    }
    g.DO().dJT.a(new o((String)this.sdp.getFirst(), this.content, (String)this.sbH.getFirst()), 0);
  }
  
  public final void f(LinkedList<String> paramLinkedList, LinkedList<Integer> paramLinkedList1)
  {
    a(paramLinkedList, paramLinkedList1, new LinkedList());
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 881)
    {
      g.DO().dJT.b(881, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.sdr)
        {
          paramString = ((com.tencent.mm.openim.b.h)paramm).ePS.svT;
          g.DO().dJT.a(new o((String)this.sdp.getFirst(), this.content, paramString), 0);
        }
      }
      for (;;)
      {
        this.sdr = false;
        return;
        Toast.makeText(this.context, this.context.getString(a.h.sendrequest_send_fail), 1).show();
      }
    }
    if ((paramm.getType() != 30) && (paramm.getType() != 243))
    {
      y.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + paramm.getType());
      return;
    }
    y.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    onStop();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.sdq) {
        com.tencent.mm.ui.base.h.bC(this.context, this.context.getString(a.h.sendrequest_send_success));
      }
      this.sdo.bl(true);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -34)) {
      paramm = this.context.getString(a.h.fmessage_request_too_offen);
    }
    for (;;)
    {
      if (this.sdq) {
        Toast.makeText(this.context, paramm, 1).show();
      }
      this.sdo.bl(false);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramm = this.context.getString(a.h.fmessage_user_not_support);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramm = paramString;
        if (!bk.bl(paramString)) {}
      }
      else if (paramInt1 == 4)
      {
        paramm = paramString;
        if (!bk.bl(paramString)) {}
      }
      else
      {
        paramm = this.context.getString(a.h.sendrequest_send_fail);
      }
    }
  }
  
  final void onStart()
  {
    g.DO().dJT.a(30, this);
    g.DO().dJT.a(243, this);
  }
  
  final void onStop()
  {
    g.DO().dJT.b(30, this);
    g.DO().dJT.b(243, this);
    if (this.few != null)
    {
      this.few.dismiss();
      this.few = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s
 * JD-Core Version:    0.7.0.1
 */