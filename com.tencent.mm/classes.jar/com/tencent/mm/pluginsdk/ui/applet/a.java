package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.al.g
{
  public boolean BXA;
  public String BXB;
  public dju BXC;
  private a BXr;
  public b BXs;
  private LinkedList<String> BXt;
  public String BXu;
  String BXv;
  private String BXw;
  public boolean BXx;
  public boolean BXy;
  boolean BXz;
  private String chatroomName;
  private Context context;
  private String fYC;
  public String iny;
  private String jec;
  public int niJ;
  public String rso;
  private p tipDialog;
  private LinkedList<String> uRN;
  private LinkedList<Integer> uRO;
  
  public a(Context paramContext, a parama)
  {
    AppMethodBeat.i(152151);
    this.fYC = "";
    this.rso = "";
    this.BXv = "";
    this.chatroomName = "";
    this.BXx = true;
    this.BXy = true;
    this.BXz = true;
    this.iny = "";
    this.BXA = false;
    this.BXB = "";
    this.niJ = 0;
    this.context = paramContext;
    this.BXr = parama;
    this.uRN = new LinkedList();
    this.BXt = new LinkedList();
    this.tipDialog = null;
    AppMethodBeat.o(152151);
  }
  
  private void O(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(152162);
    if ((this.BXA) && (!bt.isNullOrNil(paramString))) {
      com.tencent.mm.ui.base.h.c(this.context, paramString, "", true);
    }
    for (;;)
    {
      c(false, false, this.BXv, this.iny);
      AppMethodBeat.o(152162);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -22)) {
        Toast.makeText(this.context, this.context.getString(2131755167), 1).show();
      } else if ((paramInt1 == 4) && (paramInt2 == -24) && (!bt.isNullOrNil(paramString))) {
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
      this.BXx = paramBoolean;
      this.fYC = paramString2;
      this.uRO = paramLinkedList;
      this.uRN.add(paramString1);
      this.BXv = paramString1;
      exP();
      AppMethodBeat.o(152157);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(152159);
    if (this.BXr != null) {
      this.BXr.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
    }
    if (paramBoolean1)
    {
      paramString2 = new lg();
      paramString2.dpN.username = paramString1;
      com.tencent.mm.sdk.b.a.ESL.l(paramString2);
    }
    AppMethodBeat.o(152159);
  }
  
  private void onStart()
  {
    AppMethodBeat.i(152160);
    com.tencent.mm.kernel.g.afA().gcy.a(30, this);
    com.tencent.mm.kernel.g.afA().gcy.a(667, this);
    AppMethodBeat.o(152160);
  }
  
  public final void a(String paramString1, LinkedList<Integer> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(152154);
    a(paramString1, paramLinkedList, false, paramString2);
    AppMethodBeat.o(152154);
  }
  
  public final void aBJ(String paramString)
  {
    AppMethodBeat.i(152155);
    if (!TextUtils.isEmpty(paramString)) {
      this.BXt.add(paramString);
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
  
  final void exP()
  {
    AppMethodBeat.i(152158);
    onStart();
    if (this.BXy)
    {
      localObject = this.context;
      this.context.getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, this.context.getString(2131757579), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(152147);
          a.a(a.this, false, a.this.BXv, a.this.iny);
          AppMethodBeat.o(152147);
        }
      });
    }
    if (af.aHH((String)this.uRN.getFirst()))
    {
      String str = (String)this.uRN.getFirst();
      if (this.BXt.isEmpty()) {}
      for (localObject = "";; localObject = (String)this.BXt.getFirst())
      {
        localObject = new com.tencent.mm.openim.b.b(str, (String)localObject);
        com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
        AppMethodBeat.o(152158);
        return;
      }
    }
    Object localObject = new o(1, this.uRN, this.uRO, this.BXt, "", this.rso, null, this.chatroomName, this.fYC);
    if (!bt.isNullOrNil(this.jec)) {
      ((o)localObject).kx(this.jec, this.BXw);
    }
    ((o)localObject).zb(this.BXB);
    ((o)localObject).setSubScene(this.niJ);
    ((o)localObject).a(this.BXC);
    ((o)localObject).tS(this.BXz);
    com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
    AppMethodBeat.o(152158);
  }
  
  public final void i(String paramString, LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(152153);
    a(paramString, paramLinkedList, false, "");
    AppMethodBeat.o(152153);
  }
  
  public final void kA(String paramString1, String paramString2)
  {
    this.jec = paramString1;
    this.BXw = paramString2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(152161);
    ad.d("MicroMsg.AddContact", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((paramn.getType() != 30) && (paramn.getType() != 667))
    {
      ad.w("MicroMsg.AddContact", "not expected scene,  type = " + paramn.getType());
      AppMethodBeat.o(152161);
      return;
    }
    if (((paramn instanceof o)) && (((o)paramn).djq != 1))
    {
      ad.e("MicroMsg.AddContact", "not opcode addcontact!");
      AppMethodBeat.o(152161);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.kernel.g.afA().gcy.b(30, this);
    com.tencent.mm.kernel.g.afA().gcy.b(667, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 30)
      {
        this.BXv = ((o)paramn).evr();
        c(true, false, this.BXv, this.iny);
        paramString = com.tencent.mm.plugin.report.service.h.vKh;
        paramn = this.jec;
        if (this.uRO.size() <= 0) {
          break label355;
        }
      }
      label355:
      for (paramInt1 = ((Integer)this.uRO.getLast()).intValue();; paramInt1 = 0)
      {
        paramString.f(18713, new Object[] { paramn, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(0) });
        AppMethodBeat.o(152161);
        return;
        if (paramn.getType() != 667) {
          break;
        }
        this.BXv = ((com.tencent.mm.openim.b.b)paramn).hNH;
        break;
      }
    }
    if (paramInt2 == -44)
    {
      paramn = this.iny;
      if (this.BXs != null)
      {
        b localb = this.BXs;
        if (this.BXt.isEmpty()) {}
        for (paramString = "";; paramString = (String)this.BXt.getFirst())
        {
          localb.at(paramString, paramInt2);
          c(false, false, this.BXv, paramn);
          AppMethodBeat.o(152161);
          return;
        }
      }
      paramString = new aa(this.context, new aa.a()
      {
        public final void cE(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(152150);
          String str = a.this.iny;
          a locala = a.this;
          a.a(locala, paramAnonymousBoolean, locala.BXv, str);
          AppMethodBeat.o(152150);
        }
      });
      if (this.BXu != null) {
        paramString.BXu = this.BXu;
      }
      if (this.BXx)
      {
        paramString.D(this.uRN, this.uRO);
        AppMethodBeat.o(152161);
        return;
      }
      paramString.a(this.uRN, this.uRO, this.BXt);
      AppMethodBeat.o(152161);
      return;
    }
    if (paramInt2 == -87)
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131757604), "", true);
      AppMethodBeat.o(152161);
      return;
    }
    if ((paramInt2 == -101) && (!bt.isNullOrNil(paramString)))
    {
      ad.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
      com.tencent.mm.ui.base.h.a(this.context, paramString, "", false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(152148);
          a.a(a.this, false, a.this.BXv, a.this.iny);
          AppMethodBeat.o(152148);
        }
      });
      AppMethodBeat.o(152161);
      return;
    }
    if (paramInt2 == -2)
    {
      if (!bt.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.a(this.context, paramString, this.context.getString(2131755906), this.context.getString(2131755835), null);
        AppMethodBeat.o(152161);
        return;
      }
      O(paramInt1, paramInt2, null);
      AppMethodBeat.o(152161);
      return;
    }
    if (paramInt2 == -160)
    {
      if (!bt.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.d(this.context, paramString, "", this.context.getResources().getString(2131755700), this.context.getResources().getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(152149);
            a.this.BXz = false;
            a.this.exP();
            AppMethodBeat.o(152149);
          }
        }, null);
        AppMethodBeat.o(152161);
        return;
      }
      O(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(152161);
      return;
    }
    O(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(152161);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract boolean at(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a
 * JD-Core Version:    0.7.0.1
 */