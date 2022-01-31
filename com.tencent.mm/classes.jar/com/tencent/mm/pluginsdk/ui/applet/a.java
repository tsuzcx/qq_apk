package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a
  implements f
{
  private String chatroomName;
  private Context context;
  private String eDy;
  public String gAl;
  private String inF;
  public int kbN;
  public String mVw;
  private LinkedList<String> pPQ;
  private LinkedList<Integer> pPR;
  private com.tencent.mm.ui.base.p tipDialog;
  private a.a vSM;
  public a.b vSN;
  private LinkedList<String> vSO;
  public String vSP;
  String vSQ;
  private String vSR;
  public boolean vSS;
  public boolean vST;
  boolean vSU;
  public boolean vSV;
  public String vSW;
  
  public a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(79704);
    this.eDy = "";
    this.mVw = "";
    this.vSQ = "";
    this.chatroomName = "";
    this.vSS = true;
    this.vST = true;
    this.vSU = true;
    this.gAl = "";
    this.vSV = false;
    this.vSW = "";
    this.kbN = 0;
    this.context = paramContext;
    this.vSM = parama;
    this.pPQ = new LinkedList();
    this.vSO = new LinkedList();
    this.tipDialog = null;
    AppMethodBeat.o(79704);
  }
  
  private void D(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(79714);
    if ((this.vSV) && (!bo.isNullOrNil(paramString))) {
      Toast.makeText(this.context, paramString, 1).show();
    }
    for (;;)
    {
      c(false, false, this.vSQ, this.gAl);
      AppMethodBeat.o(79714);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -22)) {
        Toast.makeText(this.context, this.context.getString(2131296439), 1).show();
      } else if ((paramInt1 == 4) && (paramInt2 == -24) && (!bo.isNullOrNil(paramString))) {
        Toast.makeText(this.context, paramString, 1).show();
      } else {
        Toast.makeText(this.context, this.context.getString(2131296438), 1).show();
      }
    }
  }
  
  private void a(String paramString1, LinkedList<Integer> paramLinkedList, boolean paramBoolean, String paramString2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(79710);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramLinkedList == null) {
        break label86;
      }
    }
    label86:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      this.vSS = paramBoolean;
      this.eDy = paramString2;
      this.pPR = paramLinkedList;
      this.pPQ.add(paramString1);
      this.vSQ = paramString1;
      dnv();
      AppMethodBeat.o(79710);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(79711);
    if (this.vSM != null) {
      this.vSM.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
    }
    if (paramBoolean1)
    {
      paramString2 = new kb();
      paramString2.czE.username = paramString1;
      com.tencent.mm.sdk.b.a.ymk.l(paramString2);
    }
    AppMethodBeat.o(79711);
  }
  
  private void onStart()
  {
    AppMethodBeat.i(79712);
    g.RK().eHt.a(30, this);
    g.RK().eHt.a(667, this);
    AppMethodBeat.o(79712);
  }
  
  public final void a(String paramString1, LinkedList<Integer> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(79707);
    a(paramString1, paramLinkedList, false, paramString2);
    AppMethodBeat.o(79707);
  }
  
  public final void amg(String paramString)
  {
    AppMethodBeat.i(79708);
    if (!TextUtils.isEmpty(paramString)) {
      this.vSO.add(paramString);
    }
    AppMethodBeat.o(79708);
  }
  
  public final void b(String paramString, LinkedList<Integer> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(79709);
    a(paramString, paramLinkedList, paramBoolean, "");
    AppMethodBeat.o(79709);
  }
  
  public final void c(String paramString1, String paramString2, LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(79705);
    this.chatroomName = paramString2;
    a(paramString1, paramLinkedList, false, "");
    AppMethodBeat.o(79705);
  }
  
  final void dnv()
  {
    AppMethodBeat.i(151626);
    onStart();
    if (this.vST)
    {
      localObject = this.context;
      this.context.getString(2131297087);
      this.tipDialog = h.b((Context)localObject, this.context.getString(2131298520), true, new a.1(this));
    }
    if (ad.arf((String)this.pPQ.getFirst()))
    {
      String str = (String)this.pPQ.getFirst();
      if (this.vSO.isEmpty()) {}
      for (localObject = "";; localObject = (String)this.vSO.getFirst())
      {
        localObject = new com.tencent.mm.openim.b.b(str, (String)localObject);
        g.RK().eHt.a((com.tencent.mm.ai.m)localObject, 0);
        AppMethodBeat.o(151626);
        return;
      }
    }
    Object localObject = new com.tencent.mm.pluginsdk.model.m(1, this.pPQ, this.pPR, this.vSO, "", this.mVw, null, this.chatroomName, this.eDy);
    if (!bo.isNullOrNil(this.inF)) {
      ((com.tencent.mm.pluginsdk.model.m)localObject).hR(this.inF, this.vSR);
    }
    ((com.tencent.mm.pluginsdk.model.m)localObject).uo(this.vSW);
    ((com.tencent.mm.pluginsdk.model.m)localObject).setSubScene(this.kbN);
    ((com.tencent.mm.pluginsdk.model.m)localObject).oY(this.vSU);
    g.RK().eHt.a((com.tencent.mm.ai.m)localObject, 0);
    AppMethodBeat.o(151626);
  }
  
  public final void e(String paramString, LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(79706);
    a(paramString, paramLinkedList, false, "");
    AppMethodBeat.o(79706);
  }
  
  public final void hU(String paramString1, String paramString2)
  {
    this.inF = paramString1;
    this.vSR = paramString2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(79713);
    ab.d("MicroMsg.AddContact", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((paramm.getType() != 30) && (paramm.getType() != 667))
    {
      ab.w("MicroMsg.AddContact", "not expected scene,  type = " + paramm.getType());
      AppMethodBeat.o(79713);
      return;
    }
    if (((paramm instanceof com.tencent.mm.pluginsdk.model.m)) && (((com.tencent.mm.pluginsdk.model.m)paramm).cut != 1))
    {
      ab.e("MicroMsg.AddContact", "not opcode addcontact!");
      AppMethodBeat.o(79713);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    g.RK().eHt.b(30, this);
    g.RK().eHt.b(667, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 30) {
        this.vSQ = ((com.tencent.mm.pluginsdk.model.m)paramm).dlk();
      }
      for (;;)
      {
        c(true, false, this.vSQ, this.gAl);
        AppMethodBeat.o(79713);
        return;
        if (paramm.getType() == 667) {
          this.vSQ = ((com.tencent.mm.openim.b.b)paramm).gfL;
        }
      }
    }
    if (paramInt2 == -44)
    {
      paramm = this.gAl;
      if (this.vSN != null)
      {
        a.b localb = this.vSN;
        if (this.vSO.isEmpty()) {}
        for (paramString = "";; paramString = (String)this.vSO.getFirst())
        {
          localb.wU(paramString);
          c(false, false, this.vSQ, paramm);
          AppMethodBeat.o(79713);
          return;
        }
      }
      paramString = new s(this.context, new a.4(this));
      if (this.vSP != null) {
        paramString.vSP = this.vSP;
      }
      if (this.vSS)
      {
        paramString.r(this.pPQ, this.pPR);
        AppMethodBeat.o(79713);
        return;
      }
      paramString.a(this.pPQ, this.pPR, this.vSO);
      AppMethodBeat.o(79713);
      return;
    }
    if (paramInt2 == -87)
    {
      h.b(this.context, this.context.getString(2131298545), "", true);
      AppMethodBeat.o(79713);
      return;
    }
    if ((paramInt2 == -101) && (!bo.isNullOrNil(paramString)))
    {
      ab.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
      h.a(this.context, paramString, "", false, new a.2(this));
      AppMethodBeat.o(79713);
      return;
    }
    if (paramInt2 == -2)
    {
      if (!bo.isNullOrNil(paramString))
      {
        h.a(this.context, paramString, this.context.getString(2131297087), this.context.getString(2131297018), null);
        AppMethodBeat.o(79713);
        return;
      }
      D(paramInt1, paramInt2, null);
      AppMethodBeat.o(79713);
      return;
    }
    if (paramInt2 == -160)
    {
      if (!bo.isNullOrNil(paramString))
      {
        h.d(this.context, paramString, "", this.context.getResources().getString(2131296894), this.context.getResources().getString(2131296888), new a.3(this), null);
        AppMethodBeat.o(79713);
        return;
      }
      D(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(79713);
      return;
    }
    D(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(79713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a
 * JD-Core Version:    0.7.0.1
 */