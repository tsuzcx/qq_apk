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
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.api.m;
import com.tencent.mm.g.c.au;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;

public final class b
  implements e.a, a.a, w
{
  int BXE = 0;
  private v BXF;
  com.tencent.mm.al.g BXG = null;
  private boolean BXH = true;
  private String fYC;
  ProgressDialog ift;
  String kGt;
  d lAE;
  Context mContext;
  private int mScene;
  af oFt;
  
  public b(Context paramContext, String paramString1, int paramInt, v paramv, String paramString2)
  {
    this(paramContext, paramString1, paramInt, paramv, true, paramString2);
  }
  
  public b(Context paramContext, String paramString1, int paramInt, v paramv, boolean paramBoolean, String paramString2)
  {
    this.mContext = paramContext;
    this.kGt = paramString1;
    this.mScene = paramInt;
    this.BXF = paramv;
    this.BXH = paramBoolean;
    this.fYC = paramString2;
  }
  
  public b(Context paramContext, String paramString, v paramv)
  {
    this(paramContext, paramString, 0, paramv, true, "");
  }
  
  private void aBK(String paramString)
  {
    AppMethodBeat.i(31336);
    ad.i("MicroMsg.AddContactDialog", "searchContact %s", new Object[] { paramString });
    if (this.BXG == null) {
      this.BXG = new com.tencent.mm.al.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(31330);
          if (b.this.ift != null) {
            b.this.ift.dismiss();
          }
          if (b.this.BXG != null)
          {
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.b(106, b.this.BXG);
          }
          if (b.this.ift == null)
          {
            ad.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
            b.this.nc(0);
            AppMethodBeat.o(31330);
            return;
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            b.this.nc(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if (b.this.mContext == null)
          {
            ad.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
            b.this.nc(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if (((b.this.mContext instanceof Activity)) && (((Activity)b.this.mContext).isFinishing()))
          {
            ad.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
            b.this.nc(-1);
            AppMethodBeat.o(31330);
            return;
          }
          paramAnonymousString = ((com.tencent.mm.plugin.messenger.a.g)paramAnonymousn).cOA();
          paramAnonymousn = z.a(paramAnonymousString.Dby);
          if (bt.isNullOrNil(paramAnonymousn))
          {
            ad.e("MicroMsg.AddContactDialog", "searchContact, user is null");
            h.cf(b.this.mContext, b.this.mContext.getResources().getString(2131766266));
            b.this.nc(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if ((b.this.kGt == null) || (!b.this.kGt.equals(paramAnonymousn))) {
            ad.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", new Object[] { b.this.kGt, paramAnonymousn });
          }
          b localb = b.this;
          com.tencent.mm.kernel.g.afC();
          localb.oFt = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramAnonymousn);
          if ((b.this.oFt == null) || ((int)b.this.oFt.fId == 0))
          {
            ad.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + paramAnonymousn + ", try get by alias");
            localb = b.this;
            com.tencent.mm.kernel.g.afC();
            localb.oFt = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHU(paramAnonymousn);
            if ((b.this.oFt == null) || ((int)b.this.oFt.fId == 0))
            {
              ad.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
              b.this.oFt = new af(paramAnonymousn);
              b.this.oFt.na(paramAnonymousString.ijR);
              b.this.oFt.nd(z.a(paramAnonymousString.DFJ));
              b.this.oFt.ne(z.a(paramAnonymousString.Dbb));
              b.this.oFt.nf(z.a(paramAnonymousString.Dbc));
              b.this.oFt.jJ(paramAnonymousString.ijM);
              b.this.oFt.nA(RegionCodeDecoder.aT(paramAnonymousString.ijV, paramAnonymousString.ijN, paramAnonymousString.ijO));
              b.this.oFt.nu(paramAnonymousString.ijP);
              b.this.oFt.jF(paramAnonymousString.DIV);
              b.this.oFt.nz(paramAnonymousString.DIW);
              b.this.oFt.jE(paramAnonymousString.DIZ);
              b.this.oFt.ng(paramAnonymousString.DIY);
              b.this.oFt.ny(paramAnonymousString.DIX);
            }
          }
          for (;;)
          {
            b.this.aa(b.this.oFt);
            AppMethodBeat.o(31330);
            return;
            ad.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", new Object[] { paramAnonymousn });
          }
        }
      };
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(106, this.BXG);
    paramString = new com.tencent.mm.plugin.messenger.a.g(paramString, this.BXE);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    AppMethodBeat.o(31336);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31337);
    if (this.ift != null) {
      this.ift.dismiss();
    }
    if (paramBoolean1)
    {
      this.oFt.Zk();
      com.tencent.mm.kernel.g.afC();
      ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().c(this.oFt.field_username, this.oFt);
      h.cf(this.mContext, this.mContext.getResources().getString(2131766270));
      nc(1);
      AppMethodBeat.o(31337);
      return;
    }
    nc(-1);
    AppMethodBeat.o(31337);
  }
  
  final void aa(final af paramaf)
  {
    Object localObject3 = null;
    AppMethodBeat.i(31333);
    if (paramaf == null)
    {
      ad.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
      nc(-1);
      AppMethodBeat.o(31333);
      return;
    }
    String str1 = this.mContext.getString(2131766264);
    Object localObject2 = c.a(paramaf.field_username, false, -1, null);
    if (localObject2 == null) {
      p.auq().a(this);
    }
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (paramaf.eKB()) {
        localObject1 = f.a((Bitmap)localObject2, false, ((Bitmap)localObject2).getWidth() / 2);
      }
    }
    String str2 = paramaf.field_nickname;
    this.lAE = null;
    if ((this.mContext instanceof MMActivity))
    {
      if (!this.BXH)
      {
        ab(paramaf);
        AppMethodBeat.o(31333);
        return;
      }
      i locali = p.auF().we(paramaf.field_username);
      localObject2 = localObject3;
      if (locali != null)
      {
        localObject2 = localObject3;
        if (!bt.isNullOrNil(locali.auy())) {
          localObject2 = locali.auy();
        }
      }
      this.lAE = o.a(((MMActivity)this.mContext).getController(), str1, (Bitmap)localObject1, str2, (String)localObject2, new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(31328);
          if (paramAnonymousBoolean) {
            b.this.ab(paramaf);
          }
          for (;;)
          {
            b.this.lAE.dismiss();
            AppMethodBeat.o(31328);
            return;
            b.this.nc(0);
          }
        }
      });
    }
    if (this.lAE == null)
    {
      ad.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
      nc(-1);
    }
    AppMethodBeat.o(31333);
  }
  
  final void ab(af paramaf)
  {
    AppMethodBeat.i(31334);
    if (this.ift != null) {
      this.ift.dismiss();
    }
    Object localObject = this.mContext;
    this.mContext.getString(2131755906);
    this.ift = h.b((Context)localObject, this.mContext.getString(2131766267), true, null);
    localObject = new a(this.mContext, this);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(this.mScene));
    ((a)localObject).a(paramaf.field_username, localLinkedList, this.fYC);
    AppMethodBeat.o(31334);
  }
  
  final void nc(int paramInt)
  {
    AppMethodBeat.i(31338);
    if (this.BXF != null) {
      this.BXF.ru(paramInt);
    }
    AppMethodBeat.o(31338);
  }
  
  public final void show()
  {
    AppMethodBeat.i(31332);
    com.tencent.mm.kernel.g.afC();
    this.oFt = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(this.kGt);
    if ((this.oFt != null) && ((int)this.oFt.fId <= 0))
    {
      ad.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", new Object[] { this.kGt });
      com.tencent.mm.kernel.g.afC();
      this.oFt = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHU(this.kGt);
    }
    if ((this.oFt != null) && ((int)this.oFt.fId > 0))
    {
      ad.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
      if (this.oFt == null)
      {
        ad.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
        nc(-1);
        AppMethodBeat.o(31332);
        return;
      }
      localObject = this.oFt.field_username;
      if (!this.oFt.eKB())
      {
        if (((m)com.tencent.mm.kernel.g.ab(m.class)).ec((String)localObject))
        {
          Context localContext = this.mContext;
          this.mContext.getString(2131755906);
          this.ift = h.b(localContext, this.mContext.getString(2131766267), true, null);
          aBK((String)localObject);
          AppMethodBeat.o(31332);
          return;
        }
        if (((this.mContext instanceof MMActivity)) && (h.a(this.mContext, this.mContext.getString(2131766266), "", this.mContext.getString(2131755792), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(191278);
            ad.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
            b.this.nc(-1);
            AppMethodBeat.o(191278);
          }
        }) == null))
        {
          ad.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
          nc(-1);
        }
        AppMethodBeat.o(31332);
        return;
      }
      if (com.tencent.mm.n.b.ls(this.oFt.field_type))
      {
        h.cf(this.mContext, this.mContext.getResources().getString(2131766270));
        nc(-2);
        AppMethodBeat.o(31332);
        return;
      }
      aa(this.oFt);
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
    this.ift = h.b((Context)localObject, this.mContext.getString(2131766267), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(31327);
        if (b.this.ift != null)
        {
          b.this.ift.dismiss();
          b.this.ift = null;
        }
        AppMethodBeat.o(31327);
      }
    });
    aBK(this.kGt);
    AppMethodBeat.o(31332);
  }
  
  public final void vZ(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(31335);
    if (this.oFt != null)
    {
      int i;
      if ((this.oFt.field_username != null) && (this.oFt.field_username.equals(paramString)))
      {
        i = 1;
        if ((this.oFt.Ss() == null) || (!this.oFt.Ss().equals(paramString))) {
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
    if ((this.kGt == null) || (!this.kGt.equals(paramString)))
    {
      AppMethodBeat.o(31335);
      return;
    }
    label115:
    if ((this.lAE == null) || (!this.lAE.isShowing()))
    {
      AppMethodBeat.o(31335);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31329);
        ImageView localImageView = (ImageView)b.this.lAE.getContentView().findViewById(2131298570);
        if (localImageView != null)
        {
          Bitmap localBitmap2 = c.a(b.this.oFt.field_username, false, -1, null);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 != null)
          {
            localBitmap1 = localBitmap2;
            if (b.this.oFt.eKB()) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */