package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a
  implements i
{
  private LinkedList<String> Byl;
  private LinkedList<Integer> Bym;
  private a KdZ;
  public b Kea;
  private LinkedList<String> Keb;
  String Kec;
  public boolean Ked;
  public boolean Kee;
  boolean Kef;
  public boolean Keg;
  public String Keh;
  public eqb Kei;
  private String chatroomName;
  private Context context;
  private String hmm;
  public String khI;
  public int pHw;
  private String sourceNickName;
  private String sourceUserName;
  private com.tencent.mm.ui.base.q tipDialog;
  public String wHV;
  public String wZz;
  
  public a(Context paramContext, a parama)
  {
    AppMethodBeat.i(152151);
    this.hmm = "";
    this.wZz = "";
    this.Kec = "";
    this.chatroomName = "";
    this.Ked = true;
    this.Kee = true;
    this.Kef = true;
    this.khI = "";
    this.Keg = false;
    this.Keh = "";
    this.pHw = 0;
    this.context = paramContext;
    this.KdZ = parama;
    this.Byl = new LinkedList();
    this.Keb = new LinkedList();
    this.tipDialog = null;
    AppMethodBeat.o(152151);
  }
  
  private void R(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(152162);
    if ((this.Keg) && (!Util.isNullOrNil(paramString))) {
      com.tencent.mm.ui.base.h.c(this.context, paramString, "", true);
    }
    for (;;)
    {
      c(false, false, this.Kec, this.khI);
      AppMethodBeat.o(152162);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -22)) {
        Toast.makeText(this.context, this.context.getString(2131755185), 1).show();
      } else if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
        Toast.makeText(this.context, paramString, 1).show();
      } else {
        Toast.makeText(this.context, this.context.getString(2131755184), 1).show();
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
      this.Ked = paramBoolean;
      this.hmm = paramString2;
      this.Bym = paramLinkedList;
      this.Byl.add(paramString1);
      this.Kec = paramString1;
      gpf();
      AppMethodBeat.o(152157);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(152159);
    if (this.KdZ != null) {
      this.KdZ.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
    }
    if (paramBoolean1)
    {
      paramString2 = new mp();
      paramString2.dSe.username = paramString1;
      EventCenter.instance.publish(paramString2);
    }
    AppMethodBeat.o(152159);
  }
  
  private void onStart()
  {
    AppMethodBeat.i(152160);
    g.aAg().hqi.a(30, this);
    g.aAg().hqi.a(667, this);
    AppMethodBeat.o(152160);
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
  
  public final void beC(String paramString)
  {
    AppMethodBeat.i(152155);
    if (!TextUtils.isEmpty(paramString)) {
      this.Keb.add(paramString);
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
  
  final void gpf()
  {
    AppMethodBeat.i(152158);
    onStart();
    if (this.Kee)
    {
      localObject = this.context;
      this.context.getString(2131755998);
      this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, this.context.getString(2131757806), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(152147);
          a.a(a.this, false, a.this.Kec, a.this.khI);
          AppMethodBeat.o(152147);
        }
      });
    }
    if (as.bjp((String)this.Byl.getFirst()))
    {
      String str = (String)this.Byl.getFirst();
      if (this.Keb.isEmpty()) {}
      for (localObject = "";; localObject = (String)this.Keb.getFirst())
      {
        localObject = new com.tencent.mm.openim.b.b(str, (String)localObject);
        g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
        AppMethodBeat.o(152158);
        return;
      }
    }
    Object localObject = new p(1, this.Byl, this.Bym, this.Keb, "", this.wZz, null, this.chatroomName, this.hmm);
    if (!Util.isNullOrNil(this.sourceUserName)) {
      ((p)localObject).mw(this.sourceUserName, this.sourceNickName);
    }
    ((p)localObject).Pz(this.Keh);
    ((p)localObject).setSubScene(this.pHw);
    ((p)localObject).a(this.Kei);
    ((p)localObject).zJ(this.Kef);
    g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
    AppMethodBeat.o(152158);
  }
  
  public final void h(String paramString, LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(152153);
    a(paramString, paramLinkedList, false, "");
    AppMethodBeat.o(152153);
  }
  
  public final void mz(String paramString1, String paramString2)
  {
    this.sourceUserName = paramString1;
    this.sourceNickName = paramString2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(152161);
    Log.d("MicroMsg.AddContact", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((paramq.getType() != 30) && (paramq.getType() != 667))
    {
      Log.w("MicroMsg.AddContact", "not expected scene,  type = " + paramq.getType());
      AppMethodBeat.o(152161);
      return;
    }
    if (((paramq instanceof p)) && (((p)paramq).dKy != 1))
    {
      Log.e("MicroMsg.AddContact", "not opcode addcontact!");
      AppMethodBeat.o(152161);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    g.aAg().hqi.b(30, this);
    g.aAg().hqi.b(667, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() == 30)
      {
        this.Kec = ((p)paramq).gmD();
        c(true, false, this.Kec, this.khI);
        paramString = com.tencent.mm.plugin.report.service.h.CyF;
        paramq = this.sourceUserName;
        if (this.Bym.size() <= 0) {
          break label355;
        }
      }
      label355:
      for (paramInt1 = ((Integer)this.Bym.getLast()).intValue();; paramInt1 = 0)
      {
        paramString.a(18713, new Object[] { paramq, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(0) });
        AppMethodBeat.o(152161);
        return;
        if (paramq.getType() != 667) {
          break;
        }
        this.Kec = ((com.tencent.mm.openim.b.b)paramq).jGZ;
        break;
      }
    }
    if (paramInt2 == -44)
    {
      paramq = this.khI;
      if (this.Kea != null)
      {
        b localb = this.Kea;
        if (this.Keb.isEmpty()) {}
        for (paramString = "";; paramString = (String)this.Keb.getFirst())
        {
          localb.aE(paramString, paramInt2);
          c(false, false, this.Kec, paramq);
          AppMethodBeat.o(152161);
          return;
        }
      }
      paramString = new aa(this.context, new aa.a()
      {
        public final void jdMethod_do(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(152150);
          String str = a.this.khI;
          a locala = a.this;
          a.a(locala, paramAnonymousBoolean, locala.Kec, str);
          AppMethodBeat.o(152150);
        }
      });
      if (this.wHV != null) {
        paramString.wHV = this.wHV;
      }
      if (this.Ked)
      {
        paramString.z(this.Byl, this.Bym);
        AppMethodBeat.o(152161);
        return;
      }
      paramString.a(this.Byl, this.Bym, this.Keb);
      AppMethodBeat.o(152161);
      return;
    }
    if (paramInt2 == -87)
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131757832), "", true);
      AppMethodBeat.o(152161);
      return;
    }
    if ((paramInt2 == -101) && (!Util.isNullOrNil(paramString)))
    {
      Log.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
      com.tencent.mm.ui.base.h.a(this.context, paramString, "", false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(152148);
          a.a(a.this, false, a.this.Kec, a.this.khI);
          AppMethodBeat.o(152148);
        }
      });
      AppMethodBeat.o(152161);
      return;
    }
    if (paramInt2 == -2)
    {
      if (!Util.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.a(this.context, paramString, this.context.getString(2131755998), this.context.getString(2131755921), null);
        AppMethodBeat.o(152161);
        return;
      }
      R(paramInt1, paramInt2, null);
      AppMethodBeat.o(152161);
      return;
    }
    if (paramInt2 == -160)
    {
      if (!Util.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.c(this.context, paramString, "", this.context.getResources().getString(2131755771), this.context.getResources().getString(2131755761), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(152149);
            a.this.Kef = false;
            a.this.gpf();
            AppMethodBeat.o(152149);
          }
        }, null);
        AppMethodBeat.o(152161);
        return;
      }
      R(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(152161);
      return;
    }
    R(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(152161);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract boolean aE(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a
 * JD-Core Version:    0.7.0.1
 */