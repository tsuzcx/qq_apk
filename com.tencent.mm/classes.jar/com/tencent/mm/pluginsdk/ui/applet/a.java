package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a
  implements f
{
  private a Fnh;
  public b Fni;
  private LinkedList<String> Fnj;
  public String Fnk;
  String Fnl;
  private String Fnm;
  public boolean Fnn;
  public boolean Fno;
  boolean Fnp;
  public boolean Fnq;
  public String Fnr;
  public dvx Fns;
  private String chatroomName;
  private Context context;
  private String gzz;
  public String jjG;
  private String kbH;
  public int otZ;
  public String tIA;
  private p tipDialog;
  private LinkedList<String> xyi;
  private LinkedList<Integer> xyj;
  
  public a(Context paramContext, a parama)
  {
    AppMethodBeat.i(152151);
    this.gzz = "";
    this.tIA = "";
    this.Fnl = "";
    this.chatroomName = "";
    this.Fnn = true;
    this.Fno = true;
    this.Fnp = true;
    this.jjG = "";
    this.Fnq = false;
    this.Fnr = "";
    this.otZ = 0;
    this.context = paramContext;
    this.Fnh = parama;
    this.xyi = new LinkedList();
    this.Fnj = new LinkedList();
    this.tipDialog = null;
    AppMethodBeat.o(152151);
  }
  
  private void P(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(152162);
    if ((this.Fnq) && (!bu.isNullOrNil(paramString))) {
      h.c(this.context, paramString, "", true);
    }
    for (;;)
    {
      c(false, false, this.Fnl, this.jjG);
      AppMethodBeat.o(152162);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -22)) {
        Toast.makeText(this.context, this.context.getString(2131755167), 1).show();
      } else if ((paramInt1 == 4) && (paramInt2 == -24) && (!bu.isNullOrNil(paramString))) {
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
      this.Fnn = paramBoolean;
      this.gzz = paramString2;
      this.xyj = paramLinkedList;
      this.xyi.add(paramString1);
      this.Fnl = paramString1;
      ffW();
      AppMethodBeat.o(152157);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(152159);
    if (this.Fnh != null) {
      this.Fnh.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
    }
    if (paramBoolean1)
    {
      paramString2 = new lz();
      paramString2.dAr.username = paramString1;
      com.tencent.mm.sdk.b.a.IvT.l(paramString2);
    }
    AppMethodBeat.o(152159);
  }
  
  private void onStart()
  {
    AppMethodBeat.i(152160);
    com.tencent.mm.kernel.g.ajQ().gDv.a(30, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(667, this);
    AppMethodBeat.o(152160);
  }
  
  public final void a(String paramString1, LinkedList<Integer> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(152154);
    a(paramString1, paramLinkedList, false, paramString2);
    AppMethodBeat.o(152154);
  }
  
  public final void aOa(String paramString)
  {
    AppMethodBeat.i(152155);
    if (!TextUtils.isEmpty(paramString)) {
      this.Fnj.add(paramString);
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
  
  final void ffW()
  {
    AppMethodBeat.i(152158);
    onStart();
    if (this.Fno)
    {
      localObject = this.context;
      this.context.getString(2131755906);
      this.tipDialog = h.b((Context)localObject, this.context.getString(2131757579), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(152147);
          a.a(a.this, false, a.this.Fnl, a.this.jjG);
          AppMethodBeat.o(152147);
        }
      });
    }
    if (an.aUq((String)this.xyi.getFirst()))
    {
      String str = (String)this.xyi.getFirst();
      if (this.Fnj.isEmpty()) {}
      for (localObject = "";; localObject = (String)this.Fnj.getFirst())
      {
        localObject = new com.tencent.mm.openim.b.b(str, (String)localObject);
        com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject, 0);
        AppMethodBeat.o(152158);
        return;
      }
    }
    Object localObject = new o(1, this.xyi, this.xyj, this.Fnj, "", this.tIA, null, this.chatroomName, this.gzz);
    if (!bu.isNullOrNil(this.kbH)) {
      ((o)localObject).ly(this.kbH, this.Fnm);
    }
    ((o)localObject).GN(this.Fnr);
    ((o)localObject).setSubScene(this.otZ);
    ((o)localObject).a(this.Fns);
    ((o)localObject).vM(this.Fnp);
    com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject, 0);
    AppMethodBeat.o(152158);
  }
  
  public final void h(String paramString, LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(152153);
    a(paramString, paramLinkedList, false, "");
    AppMethodBeat.o(152153);
  }
  
  public final void lB(String paramString1, String paramString2)
  {
    this.kbH = paramString1;
    this.Fnm = paramString2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(152161);
    ae.d("MicroMsg.AddContact", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((paramn.getType() != 30) && (paramn.getType() != 667))
    {
      ae.w("MicroMsg.AddContact", "not expected scene,  type = " + paramn.getType());
      AppMethodBeat.o(152161);
      return;
    }
    if (((paramn instanceof o)) && (((o)paramn).dto != 1))
    {
      ae.e("MicroMsg.AddContact", "not opcode addcontact!");
      AppMethodBeat.o(152161);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.kernel.g.ajQ().gDv.b(30, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(667, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 30)
      {
        this.Fnl = ((o)paramn).fdt();
        c(true, false, this.Fnl, this.jjG);
        paramString = com.tencent.mm.plugin.report.service.g.yxI;
        paramn = this.kbH;
        if (this.xyj.size() <= 0) {
          break label355;
        }
      }
      label355:
      for (paramInt1 = ((Integer)this.xyj.getLast()).intValue();; paramInt1 = 0)
      {
        paramString.f(18713, new Object[] { paramn, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(0) });
        AppMethodBeat.o(152161);
        return;
        if (paramn.getType() != 667) {
          break;
        }
        this.Fnl = ((com.tencent.mm.openim.b.b)paramn).iKt;
        break;
      }
    }
    if (paramInt2 == -44)
    {
      paramn = this.jjG;
      if (this.Fni != null)
      {
        b localb = this.Fni;
        if (this.Fnj.isEmpty()) {}
        for (paramString = "";; paramString = (String)this.Fnj.getFirst())
        {
          localb.aA(paramString, paramInt2);
          c(false, false, this.Fnl, paramn);
          AppMethodBeat.o(152161);
          return;
        }
      }
      paramString = new aa(this.context, new aa.a()
      {
        public final void cF(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(152150);
          String str = a.this.jjG;
          a locala = a.this;
          a.a(locala, paramAnonymousBoolean, locala.Fnl, str);
          AppMethodBeat.o(152150);
        }
      });
      if (this.Fnk != null) {
        paramString.Fnk = this.Fnk;
      }
      if (this.Fnn)
      {
        paramString.D(this.xyi, this.xyj);
        AppMethodBeat.o(152161);
        return;
      }
      paramString.a(this.xyi, this.xyj, this.Fnj);
      AppMethodBeat.o(152161);
      return;
    }
    if (paramInt2 == -87)
    {
      h.c(this.context, this.context.getString(2131757604), "", true);
      AppMethodBeat.o(152161);
      return;
    }
    if ((paramInt2 == -101) && (!bu.isNullOrNil(paramString)))
    {
      ae.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
      h.a(this.context, paramString, "", false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(152148);
          a.a(a.this, false, a.this.Fnl, a.this.jjG);
          AppMethodBeat.o(152148);
        }
      });
      AppMethodBeat.o(152161);
      return;
    }
    if (paramInt2 == -2)
    {
      if (!bu.isNullOrNil(paramString))
      {
        h.a(this.context, paramString, this.context.getString(2131755906), this.context.getString(2131755835), null);
        AppMethodBeat.o(152161);
        return;
      }
      P(paramInt1, paramInt2, null);
      AppMethodBeat.o(152161);
      return;
    }
    if (paramInt2 == -160)
    {
      if (!bu.isNullOrNil(paramString))
      {
        h.e(this.context, paramString, "", this.context.getResources().getString(2131755700), this.context.getResources().getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(152149);
            a.this.Fnp = false;
            a.this.ffW();
            AppMethodBeat.o(152149);
          }
        }, null);
        AppMethodBeat.o(152161);
        return;
      }
      P(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(152161);
      return;
    }
    P(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(152161);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract boolean aA(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a
 * JD-Core Version:    0.7.0.1
 */