package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ak.g
{
  private a DpI;
  public b DpJ;
  private LinkedList<String> DpK;
  public String DpL;
  String DpM;
  private String DpN;
  public boolean DpO;
  public boolean DpP;
  boolean DpQ;
  public boolean DpR;
  public String DpS;
  public dpj DpT;
  private String chatroomName;
  private Context context;
  private String gdi;
  public String iNE;
  private String jEq;
  public int nLC;
  public String sBi;
  private p tipDialog;
  private LinkedList<String> waC;
  private LinkedList<Integer> waD;
  
  public a(Context paramContext, a parama)
  {
    AppMethodBeat.i(152151);
    this.gdi = "";
    this.sBi = "";
    this.DpM = "";
    this.chatroomName = "";
    this.DpO = true;
    this.DpP = true;
    this.DpQ = true;
    this.iNE = "";
    this.DpR = false;
    this.DpS = "";
    this.nLC = 0;
    this.context = paramContext;
    this.DpI = parama;
    this.waC = new LinkedList();
    this.DpK = new LinkedList();
    this.tipDialog = null;
    AppMethodBeat.o(152151);
  }
  
  private void N(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(152162);
    if ((this.DpR) && (!bs.isNullOrNil(paramString))) {
      com.tencent.mm.ui.base.h.c(this.context, paramString, "", true);
    }
    for (;;)
    {
      c(false, false, this.DpM, this.iNE);
      AppMethodBeat.o(152162);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -22)) {
        Toast.makeText(this.context, this.context.getString(2131755167), 1).show();
      } else if ((paramInt1 == 4) && (paramInt2 == -24) && (!bs.isNullOrNil(paramString))) {
        Toast.makeText(this.context, paramString, 1).show();
      } else {
        Toast.makeText(this.context, this.context.getString(2131755166), 1).show();
      }
    }
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
        break label86;
      }
    }
    label86:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      this.DpO = paramBoolean;
      this.gdi = paramString2;
      this.waD = paramLinkedList;
      this.waC.add(paramString1);
      this.DpM = paramString1;
      eNj();
      AppMethodBeat.o(152157);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(152159);
    if (this.DpI != null) {
      this.DpI.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
    }
    if (paramBoolean1)
    {
      paramString2 = new lp();
      paramString2.dny.username = paramString1;
      com.tencent.mm.sdk.b.a.GpY.l(paramString2);
    }
    AppMethodBeat.o(152159);
  }
  
  private void onStart()
  {
    AppMethodBeat.i(152160);
    com.tencent.mm.kernel.g.agQ().ghe.a(30, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(667, this);
    AppMethodBeat.o(152160);
  }
  
  public final void a(String paramString1, LinkedList<Integer> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(152154);
    a(paramString1, paramLinkedList, false, paramString2);
    AppMethodBeat.o(152154);
  }
  
  public final void aHb(String paramString)
  {
    AppMethodBeat.i(152155);
    if (!TextUtils.isEmpty(paramString)) {
      this.DpK.add(paramString);
    }
    AppMethodBeat.o(152155);
  }
  
  public final void b(String paramString, LinkedList<Integer> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(152156);
    a(paramString, paramLinkedList, paramBoolean, "");
    AppMethodBeat.o(152156);
  }
  
  public final void d(String paramString1, String paramString2, LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(152152);
    this.chatroomName = paramString2;
    a(paramString1, paramLinkedList, false, "");
    AppMethodBeat.o(152152);
  }
  
  final void eNj()
  {
    AppMethodBeat.i(152158);
    onStart();
    if (this.DpP)
    {
      localObject = this.context;
      this.context.getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, this.context.getString(2131757579), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(152147);
          a.a(a.this, false, a.this.DpM, a.this.iNE);
          AppMethodBeat.o(152147);
        }
      });
    }
    if (ai.aNc((String)this.waC.getFirst()))
    {
      String str = (String)this.waC.getFirst();
      if (this.DpK.isEmpty()) {}
      for (localObject = "";; localObject = (String)this.DpK.getFirst())
      {
        localObject = new com.tencent.mm.openim.b.b(str, (String)localObject);
        com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
        AppMethodBeat.o(152158);
        return;
      }
    }
    Object localObject = new o(1, this.waC, this.waD, this.DpK, "", this.sBi, null, this.chatroomName, this.gdi);
    if (!bs.isNullOrNil(this.jEq)) {
      ((o)localObject).kU(this.jEq, this.DpN);
    }
    ((o)localObject).Dg(this.DpS);
    ((o)localObject).setSubScene(this.nLC);
    ((o)localObject).a(this.DpT);
    ((o)localObject).uT(this.DpQ);
    com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
    AppMethodBeat.o(152158);
  }
  
  public final void i(String paramString, LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(152153);
    a(paramString, paramLinkedList, false, "");
    AppMethodBeat.o(152153);
  }
  
  public final void kX(String paramString1, String paramString2)
  {
    this.jEq = paramString1;
    this.DpN = paramString2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(152161);
    ac.d("MicroMsg.AddContact", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((paramn.getType() != 30) && (paramn.getType() != 667))
    {
      ac.w("MicroMsg.AddContact", "not expected scene,  type = " + paramn.getType());
      AppMethodBeat.o(152161);
      return;
    }
    if (((paramn instanceof o)) && (((o)paramn).dgL != 1))
    {
      ac.e("MicroMsg.AddContact", "not opcode addcontact!");
      AppMethodBeat.o(152161);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.kernel.g.agQ().ghe.b(30, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(667, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 30)
      {
        this.DpM = ((o)paramn).eKL();
        c(true, false, this.DpM, this.iNE);
        paramString = com.tencent.mm.plugin.report.service.h.wUl;
        paramn = this.jEq;
        if (this.waD.size() <= 0) {
          break label355;
        }
      }
      label355:
      for (paramInt1 = ((Integer)this.waD.getLast()).intValue();; paramInt1 = 0)
      {
        paramString.f(18713, new Object[] { paramn, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(0) });
        AppMethodBeat.o(152161);
        return;
        if (paramn.getType() != 667) {
          break;
        }
        this.DpM = ((com.tencent.mm.openim.b.b)paramn).iod;
        break;
      }
    }
    if (paramInt2 == -44)
    {
      paramn = this.iNE;
      if (this.DpJ != null)
      {
        b localb = this.DpJ;
        if (this.DpK.isEmpty()) {}
        for (paramString = "";; paramString = (String)this.DpK.getFirst())
        {
          localb.ax(paramString, paramInt2);
          c(false, false, this.DpM, paramn);
          AppMethodBeat.o(152161);
          return;
        }
      }
      paramString = new aa(this.context, new aa.a()
      {
        public final void cD(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(152150);
          String str = a.this.iNE;
          a locala = a.this;
          a.a(locala, paramAnonymousBoolean, locala.DpM, str);
          AppMethodBeat.o(152150);
        }
      });
      if (this.DpL != null) {
        paramString.DpL = this.DpL;
      }
      if (this.DpO)
      {
        paramString.C(this.waC, this.waD);
        AppMethodBeat.o(152161);
        return;
      }
      paramString.a(this.waC, this.waD, this.DpK);
      AppMethodBeat.o(152161);
      return;
    }
    if (paramInt2 == -87)
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131757604), "", true);
      AppMethodBeat.o(152161);
      return;
    }
    if ((paramInt2 == -101) && (!bs.isNullOrNil(paramString)))
    {
      ac.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
      com.tencent.mm.ui.base.h.a(this.context, paramString, "", false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(152148);
          a.a(a.this, false, a.this.DpM, a.this.iNE);
          AppMethodBeat.o(152148);
        }
      });
      AppMethodBeat.o(152161);
      return;
    }
    if (paramInt2 == -2)
    {
      if (!bs.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.a(this.context, paramString, this.context.getString(2131755906), this.context.getString(2131755835), null);
        AppMethodBeat.o(152161);
        return;
      }
      N(paramInt1, paramInt2, null);
      AppMethodBeat.o(152161);
      return;
    }
    if (paramInt2 == -160)
    {
      if (!bs.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.d(this.context, paramString, "", this.context.getResources().getString(2131755700), this.context.getResources().getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(152149);
            a.this.DpQ = false;
            a.this.eNj();
            AppMethodBeat.o(152149);
          }
        }, null);
        AppMethodBeat.o(152161);
        return;
      }
      N(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(152161);
      return;
    }
    N(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(152161);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract boolean ax(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a
 * JD-Core Version:    0.7.0.1
 */