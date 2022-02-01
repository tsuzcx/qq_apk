package com.tencent.mm.pluginsdk.ui.applet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.m;
import com.tencent.mm.g.c.av;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;

public final class b
  implements e.a, a.a, w
{
  int DpV = 0;
  private v DpW;
  com.tencent.mm.ak.g DpX = null;
  private boolean DpY = true;
  private String gdi;
  ProgressDialog iFC;
  String lhM;
  Context mContext;
  private int mScene;
  d mcA;
  ai piT;
  
  public b(Context paramContext, String paramString1, int paramInt, v paramv, String paramString2)
  {
    this(paramContext, paramString1, paramInt, paramv, true, paramString2);
  }
  
  public b(Context paramContext, String paramString1, int paramInt, v paramv, boolean paramBoolean, String paramString2)
  {
    this.mContext = paramContext;
    this.lhM = paramString1;
    this.mScene = paramInt;
    this.DpW = paramv;
    this.DpY = paramBoolean;
    this.gdi = paramString2;
  }
  
  public b(Context paramContext, String paramString, v paramv)
  {
    this(paramContext, paramString, 0, paramv, true, "");
  }
  
  private void aHc(String paramString)
  {
    AppMethodBeat.i(31336);
    ac.i("MicroMsg.AddContactDialog", "searchContact %s", new Object[] { paramString });
    if (this.DpX == null) {
      this.DpX = new com.tencent.mm.ak.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(31330);
          if (b.this.iFC != null) {
            b.this.iFC.dismiss();
          }
          if (b.this.DpX != null)
          {
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.b(106, b.this.DpX);
          }
          if (b.this.iFC == null)
          {
            ac.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
            b.this.nQ(0);
            AppMethodBeat.o(31330);
            return;
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ac.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            b.this.nQ(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if (b.this.mContext == null)
          {
            ac.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
            b.this.nQ(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if (((b.this.mContext instanceof Activity)) && (((Activity)b.this.mContext).isFinishing()))
          {
            ac.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
            b.this.nQ(-1);
            AppMethodBeat.o(31330);
            return;
          }
          paramAnonymousString = ((com.tencent.mm.plugin.messenger.a.g)paramAnonymousn).dcj();
          paramAnonymousn = z.a(paramAnonymousString.EuE);
          if (bs.isNullOrNil(paramAnonymousn))
          {
            ac.e("MicroMsg.AddContactDialog", "searchContact, user is null");
            h.cg(b.this.mContext, b.this.mContext.getResources().getString(2131766266));
            b.this.nQ(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if ((b.this.lhM == null) || (!b.this.lhM.equals(paramAnonymousn))) {
            ac.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", new Object[] { b.this.lhM, paramAnonymousn });
          }
          b localb = b.this;
          com.tencent.mm.kernel.g.agS();
          localb.piT = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramAnonymousn);
          if ((b.this.piT == null) || ((int)b.this.piT.fLJ == 0))
          {
            ac.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + paramAnonymousn + ", try get by alias");
            localb = b.this;
            com.tencent.mm.kernel.g.agS();
            localb.piT = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNp(paramAnonymousn);
            if ((b.this.piT == null) || ((int)b.this.piT.fLJ == 0))
            {
              ac.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
              b.this.piT = new ai(paramAnonymousn);
              b.this.piT.qg(paramAnonymousString.iJY);
              b.this.piT.qj(z.a(paramAnonymousString.Fbd));
              b.this.piT.qk(z.a(paramAnonymousString.EtY));
              b.this.piT.ql(z.a(paramAnonymousString.EtZ));
              b.this.piT.jH(paramAnonymousString.iJT);
              b.this.piT.qG(RegionCodeDecoder.aW(paramAnonymousString.iKc, paramAnonymousString.iJU, paramAnonymousString.iJV));
              b.this.piT.qA(paramAnonymousString.iJW);
              b.this.piT.jD(paramAnonymousString.Feq);
              b.this.piT.qF(paramAnonymousString.Fer);
              b.this.piT.jC(paramAnonymousString.Feu);
              b.this.piT.qm(paramAnonymousString.Fet);
              b.this.piT.qE(paramAnonymousString.Fes);
            }
          }
          for (;;)
          {
            b.this.ab(b.this.piT);
            AppMethodBeat.o(31330);
            return;
            ac.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", new Object[] { paramAnonymousn });
          }
        }
      };
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(106, this.DpX);
    paramString = new com.tencent.mm.plugin.messenger.a.g(paramString, this.DpV);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
    AppMethodBeat.o(31336);
  }
  
  public final void Af(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(31335);
    if (this.piT != null)
    {
      int i;
      if ((this.piT.field_username != null) && (this.piT.field_username.equals(paramString)))
      {
        i = 1;
        if ((this.piT.Tl() == null) || (!this.piT.Tl().equals(paramString))) {
          break label85;
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0)) {
          break label115;
        }
        AppMethodBeat.o(31335);
        return;
        i = 0;
        break;
        label85:
        j = 0;
      }
    }
    if ((this.lhM == null) || (!this.lhM.equals(paramString)))
    {
      AppMethodBeat.o(31335);
      return;
    }
    label115:
    if ((this.mcA == null) || (!this.mcA.isShowing()))
    {
      AppMethodBeat.o(31335);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31329);
        ImageView localImageView = (ImageView)b.this.mcA.getContentView().findViewById(2131298570);
        if (localImageView != null)
        {
          Bitmap localBitmap2 = c.a(b.this.piT.field_username, false, -1, null);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 != null)
          {
            localBitmap1 = localBitmap2;
            if (b.this.piT.fad()) {
              localBitmap1 = f.a(localBitmap2, false, localBitmap2.getWidth() / 2);
            }
          }
          if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
          {
            localImageView.setImageBitmap(localBitmap1);
            localImageView.setVisibility(0);
          }
        }
        AppMethodBeat.o(31329);
      }
    });
    AppMethodBeat.o(31335);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31337);
    if (this.iFC != null) {
      this.iFC.dismiss();
    }
    if (paramBoolean1)
    {
      this.piT.aaf();
      com.tencent.mm.kernel.g.agS();
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().c(this.piT.field_username, this.piT);
      h.cg(this.mContext, this.mContext.getResources().getString(2131766270));
      nQ(1);
      AppMethodBeat.o(31337);
      return;
    }
    nQ(-1);
    AppMethodBeat.o(31337);
  }
  
  final void ab(final ai paramai)
  {
    Object localObject3 = null;
    AppMethodBeat.i(31333);
    if (paramai == null)
    {
      ac.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
      nQ(-1);
      AppMethodBeat.o(31333);
      return;
    }
    String str1 = this.mContext.getString(2131766264);
    Object localObject2 = c.a(paramai.field_username, false, -1, null);
    if (localObject2 == null) {
      p.aBh().a(this);
    }
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (paramai.fad()) {
        localObject1 = f.a((Bitmap)localObject2, false, ((Bitmap)localObject2).getWidth() / 2);
      }
    }
    String str2 = paramai.field_nickname;
    this.mcA = null;
    if ((this.mContext instanceof MMActivity))
    {
      if (!this.DpY)
      {
        ac(paramai);
        AppMethodBeat.o(31333);
        return;
      }
      i locali = p.aBw().Ak(paramai.field_username);
      localObject2 = localObject3;
      if (locali != null)
      {
        localObject2 = localObject3;
        if (!bs.isNullOrNil(locali.aBp())) {
          localObject2 = locali.aBp();
        }
      }
      this.mcA = o.a(((MMActivity)this.mContext).getController(), str1, (Bitmap)localObject1, str2, (String)localObject2, new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(31328);
          if (paramAnonymousBoolean) {
            b.this.ac(paramai);
          }
          for (;;)
          {
            b.this.mcA.dismiss();
            AppMethodBeat.o(31328);
            return;
            b.this.nQ(0);
          }
        }
      });
    }
    if (this.mcA == null)
    {
      ac.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
      nQ(-1);
    }
    AppMethodBeat.o(31333);
  }
  
  final void ac(ai paramai)
  {
    AppMethodBeat.i(31334);
    if (this.iFC != null) {
      this.iFC.dismiss();
    }
    Object localObject = this.mContext;
    this.mContext.getString(2131755906);
    this.iFC = h.b((Context)localObject, this.mContext.getString(2131766267), true, null);
    localObject = new a(this.mContext, this);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(this.mScene));
    ((a)localObject).a(paramai.field_username, localLinkedList, this.gdi);
    AppMethodBeat.o(31334);
  }
  
  final void nQ(int paramInt)
  {
    AppMethodBeat.i(31338);
    if (this.DpW != null) {
      this.DpW.sj(paramInt);
    }
    AppMethodBeat.o(31338);
  }
  
  public final void show()
  {
    AppMethodBeat.i(31332);
    com.tencent.mm.kernel.g.agS();
    this.piT = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(this.lhM);
    if ((this.piT != null) && ((int)this.piT.fLJ <= 0))
    {
      ac.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", new Object[] { this.lhM });
      com.tencent.mm.kernel.g.agS();
      this.piT = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNp(this.lhM);
    }
    if ((this.piT != null) && ((int)this.piT.fLJ > 0))
    {
      ac.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
      if (this.piT == null)
      {
        ac.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
        nQ(-1);
        AppMethodBeat.o(31332);
        return;
      }
      localObject = this.piT.field_username;
      if (!this.piT.fad())
      {
        if (((m)com.tencent.mm.kernel.g.ab(m.class)).dR((String)localObject))
        {
          Context localContext = this.mContext;
          this.mContext.getString(2131755906);
          this.iFC = h.b(localContext, this.mContext.getString(2131766267), true, null);
          aHc((String)localObject);
          AppMethodBeat.o(31332);
          return;
        }
        if (((this.mContext instanceof MMActivity)) && (h.a(this.mContext, this.mContext.getString(2131766266), "", this.mContext.getString(2131755792), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(196116);
            ac.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
            b.this.nQ(-1);
            AppMethodBeat.o(196116);
          }
        }) == null))
        {
          ac.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
          nQ(-1);
        }
        AppMethodBeat.o(31332);
        return;
      }
      if (com.tencent.mm.n.b.ln(this.piT.field_type))
      {
        h.cg(this.mContext, this.mContext.getResources().getString(2131766270));
        nQ(-2);
        AppMethodBeat.o(31332);
        return;
      }
      ab(this.piT);
      AppMethodBeat.o(31332);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(31332);
      return;
    }
    Object localObject = this.mContext;
    this.mContext.getString(2131755906);
    this.iFC = h.b((Context)localObject, this.mContext.getString(2131766267), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(31327);
        if (b.this.iFC != null)
        {
          b.this.iFC.dismiss();
          b.this.iFC = null;
        }
        AppMethodBeat.o(31327);
      }
    });
    aHc(this.lhM);
    AppMethodBeat.o(31332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */