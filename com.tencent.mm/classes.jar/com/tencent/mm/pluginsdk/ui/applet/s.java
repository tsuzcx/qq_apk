package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.b;
import com.tencent.mm.openim.b.o;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.widget.b.c;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class s
  implements f
{
  public String chatroomName;
  public String content;
  Context context;
  View gwd;
  c gwf;
  EditText pLt;
  private LinkedList<Integer> pPR;
  TextView pRs;
  public String scg;
  public String sch;
  com.tencent.mm.ui.base.p tipDialog;
  private LinkedList<String> vSO;
  String vSP;
  boolean vSU;
  s.a vUr;
  LinkedList<String> vUs;
  public Map<String, Integer> vUt;
  private boolean vUu;
  private com.tencent.mm.pluginsdk.model.m vUv;
  private boolean vUw;
  
  public s(Context paramContext, s.a parama)
  {
    AppMethodBeat.i(79794);
    this.gwf = null;
    this.content = "";
    this.vSU = true;
    this.vUu = true;
    this.vUw = false;
    this.context = paramContext;
    this.vUr = parama;
    AppMethodBeat.o(79794);
  }
  
  private void onStart()
  {
    AppMethodBeat.i(79795);
    com.tencent.mm.kernel.g.RK().eHt.a(30, this);
    com.tencent.mm.kernel.g.RK().eHt.a(243, this);
    AppMethodBeat.o(79795);
  }
  
  public final void a(LinkedList<String> paramLinkedList1, LinkedList<Integer> paramLinkedList, LinkedList<String> paramLinkedList2)
  {
    AppMethodBeat.i(79798);
    boolean bool;
    if (paramLinkedList1.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramLinkedList.size() <= 0) {
        break label316;
      }
      bool = true;
      label30:
      Assert.assertTrue(bool);
      onStart();
      this.vUs = paramLinkedList1;
      this.pPR = paramLinkedList;
      this.vSO = paramLinkedList2;
      this.gwd = View.inflate(this.context, 2130970676, null);
      if (this.vSP != null) {
        break label322;
      }
      bool = true;
      label78:
      if (this.vSP != null) {
        break label328;
      }
    }
    label316:
    label322:
    label328:
    for (int i = 0;; i = this.vSP.length())
    {
      ab.i("MicroMsg.SendVerifyRequest", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), this.vSP });
      if (!bo.isNullOrNil(this.vSP)) {
        ((TextView)this.gwd.findViewById(2131827574)).setText(this.vSP);
      }
      this.pLt = ((EditText)this.gwd.findViewById(2131827575));
      this.pRs = ((TextView)this.gwd.findViewById(2131823234));
      this.pRs.setVisibility(0);
      this.pLt.setText(null);
      this.pRs.setText("50");
      this.pLt.setFilters(com.tencent.mm.pluginsdk.ui.tools.g.wfe);
      this.pLt.addTextChangedListener(new s.1(this));
      paramLinkedList1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(79790);
          if (s.this.gwf != null)
          {
            s.this.gwf.dismiss();
            s.this.gwf = null;
          }
          new ap(new s.2.1(this), false).ag(500L, 500L);
          AppMethodBeat.o(79790);
        }
      };
      paramLinkedList = new s.3(this);
      this.gwf = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(2131303132), this.gwd, paramLinkedList1, paramLinkedList);
      if (this.gwf == null) {
        onStop();
      }
      this.pLt.post(new s.4(this));
      AppMethodBeat.o(79798);
      return;
      bool = false;
      break;
      bool = false;
      break label30;
      bool = false;
      break label78;
    }
  }
  
  public final void dnJ()
  {
    AppMethodBeat.i(151628);
    if (this.vUv != null) {
      com.tencent.mm.kernel.g.Rc().a(this.vUv);
    }
    AppMethodBeat.o(151628);
  }
  
  final void dnK()
  {
    AppMethodBeat.i(79799);
    if ((this.vSO == null) || (this.vSO.isEmpty()))
    {
      this.vUw = true;
      com.tencent.mm.kernel.g.RK().eHt.a(881, this);
      com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.openim.b.h((String)this.vUs.getFirst(), "", ""), 0);
      AppMethodBeat.o(79799);
      return;
    }
    com.tencent.mm.kernel.g.RK().eHt.a(new o((String)this.vUs.getFirst(), this.content, (String)this.vSO.getFirst()), 0);
    AppMethodBeat.o(79799);
  }
  
  final void dnv()
  {
    AppMethodBeat.i(151630);
    this.vUv = new com.tencent.mm.pluginsdk.model.m(this.vUs, this.pPR, this.content, "", this.vUt, this.chatroomName);
    this.vUv.oY(this.vSU);
    this.vUv.hR(this.scg, this.sch);
    com.tencent.mm.kernel.g.RK().eHt.a(this.vUv, 0);
    AppMethodBeat.o(151630);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(79800);
    if (paramm.getType() == 881)
    {
      com.tencent.mm.kernel.g.RK().eHt.b(881, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.vUw)
        {
          paramString = ((com.tencent.mm.openim.b.h)paramm).gfN.wpd;
          com.tencent.mm.kernel.g.RK().eHt.a(new o((String)this.vUs.getFirst(), this.content, paramString), 0);
        }
      }
      for (;;)
      {
        this.vUw = false;
        AppMethodBeat.o(79800);
        return;
        Toast.makeText(this.context, this.context.getString(2131303126), 1).show();
      }
    }
    if ((paramm.getType() != 30) && (paramm.getType() != 243))
    {
      ab.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + paramm.getType());
      AppMethodBeat.o(79800);
      return;
    }
    if (((paramm instanceof com.tencent.mm.pluginsdk.model.m)) && (((com.tencent.mm.pluginsdk.model.m)paramm).cut != 2))
    {
      ab.e("MicroMsg.SendVerifyRequest", "not opcode sendrequest!");
      AppMethodBeat.o(79800);
      return;
    }
    ab.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    onStop();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.vUu) {
        com.tencent.mm.ui.base.h.bO(this.context, this.context.getString(2131303127));
      }
      if (this.vUr != null)
      {
        this.vUr.bL(true);
        AppMethodBeat.o(79800);
      }
    }
    else
    {
      if ((paramInt1 != 4) || (paramInt2 != -34)) {
        break label402;
      }
      paramm = this.context.getString(2131300013);
    }
    for (;;)
    {
      if ((this.vUu) && (!bo.isNullOrNil(paramm))) {
        Toast.makeText(this.context, paramm, 1).show();
      }
      if (this.vUr != null) {
        this.vUr.bL(false);
      }
      AppMethodBeat.o(79800);
      return;
      label402:
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramm = this.context.getString(2131300016);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramm = paramString;
        if (!bo.isNullOrNil(paramString)) {}
      }
      else
      {
        if (paramInt2 == -160)
        {
          if (!bo.isNullOrNil(paramString))
          {
            com.tencent.mm.ui.base.h.d(this.context, paramString, "", this.context.getResources().getString(2131296894), this.context.getResources().getString(2131296888), new s.6(this), null);
            paramm = null;
          }
        }
        else
        {
          if (paramInt1 == 4)
          {
            paramm = paramString;
            if (!bo.isNullOrNil(paramString)) {
              continue;
            }
          }
          paramm = this.context.getString(2131303126);
          continue;
        }
        paramm = null;
      }
    }
  }
  
  final void onStop()
  {
    AppMethodBeat.i(79796);
    com.tencent.mm.kernel.g.RK().eHt.b(30, this);
    com.tencent.mm.kernel.g.RK().eHt.b(243, this);
    if (this.gwf != null)
    {
      this.gwf.dismiss();
      this.gwf = null;
    }
    AppMethodBeat.o(79796);
  }
  
  public final void r(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(151629);
    this.vUu = false;
    onStart();
    this.vUs = new LinkedList(paramList);
    this.pPR = new LinkedList(paramList1);
    if ((paramList.size() == 1) && (ad.arf((String)this.vUs.getFirst())))
    {
      dnK();
      AppMethodBeat.o(151629);
      return;
    }
    dnv();
    AppMethodBeat.o(151629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s
 * JD-Core Version:    0.7.0.1
 */