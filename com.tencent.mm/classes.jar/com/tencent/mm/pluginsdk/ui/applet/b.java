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
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.m;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;

public final class b
  implements e.a, a.a, w
{
  private boolean Fbr = true;
  private int Fnu = 0;
  private v Fnv;
  com.tencent.mm.ak.f Fnw = null;
  private String gzz;
  ProgressDialog jbE;
  String lJm;
  Context mContext;
  private String mGW;
  d mHN;
  private int mScene;
  an pSY;
  
  public b(Context paramContext, String paramString, int paramInt, v paramv)
  {
    this.mContext = paramContext;
    this.lJm = paramString;
    this.mScene = paramInt;
    this.Fnv = paramv;
  }
  
  public b(Context paramContext, String paramString, int paramInt, v paramv, com.tencent.mm.pluginsdk.a parama)
  {
    this(paramContext, paramString, paramInt, paramv);
    AppMethodBeat.i(186722);
    if (parama != null)
    {
      this.Fbr = parama.Fbr;
      this.gzz = parama.Fbp;
      this.Fnu = parama.Fbq;
      this.mGW = parama.dlj;
    }
    AppMethodBeat.o(186722);
  }
  
  private void aOb(String paramString)
  {
    AppMethodBeat.i(31336);
    ae.i("MicroMsg.AddContactDialog", "searchContact %s", new Object[] { paramString });
    if (this.Fnw == null) {
      this.Fnw = new com.tencent.mm.ak.f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(31330);
          if (b.this.jbE != null) {
            b.this.jbE.dismiss();
          }
          if (b.this.Fnw != null)
          {
            g.ajS();
            g.ajQ().gDv.b(106, b.this.Fnw);
          }
          if (b.this.jbE == null)
          {
            ae.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
            b.this.ot(0);
            AppMethodBeat.o(31330);
            return;
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ae.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            b.this.ot(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if (b.this.mContext == null)
          {
            ae.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
            b.this.ot(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if (((b.this.mContext instanceof Activity)) && (((Activity)b.this.mContext).isFinishing()))
          {
            ae.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
            b.this.ot(-1);
            AppMethodBeat.o(31330);
            return;
          }
          paramAnonymousString = ((com.tencent.mm.plugin.messenger.a.f)paramAnonymousn).doB();
          paramAnonymousn = z.a(paramAnonymousString.GuF);
          if (bu.isNullOrNil(paramAnonymousn))
          {
            ae.e("MicroMsg.AddContactDialog", "searchContact, user is null");
            com.tencent.mm.ui.base.h.cm(b.this.mContext, b.this.mContext.getResources().getString(2131766266));
            b.this.ot(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if ((b.this.lJm == null) || (!b.this.lJm.equals(paramAnonymousn))) {
            ae.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", new Object[] { b.this.lJm, paramAnonymousn });
          }
          b localb = b.this;
          g.ajS();
          localb.pSY = ((l)g.ab(l.class)).azF().BH(paramAnonymousn);
          if ((b.this.pSY == null) || ((int)b.this.pSY.ght == 0))
          {
            ae.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + paramAnonymousn + ", try get by alias");
            localb = b.this;
            g.ajS();
            localb.pSY = ((l)g.ab(l.class)).azF().aUI(paramAnonymousn);
            if ((b.this.pSY == null) || ((int)b.this.pSY.ght == 0))
            {
              ae.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
              b.this.pSY = new an(paramAnonymousn);
              b.this.pSY.tl(paramAnonymousString.jga);
              b.this.pSY.to(z.a(paramAnonymousString.Hed));
              b.this.pSY.tp(z.a(paramAnonymousString.GtY));
              b.this.pSY.tq(z.a(paramAnonymousString.GtZ));
              b.this.pSY.kh(paramAnonymousString.jfV);
              b.this.pSY.tL(RegionCodeDecoder.bg(paramAnonymousString.jge, paramAnonymousString.jfW, paramAnonymousString.jfX));
              b.this.pSY.tF(paramAnonymousString.jfY);
              b.this.pSY.kd(paramAnonymousString.Hhu);
              b.this.pSY.tK(paramAnonymousString.Hhv);
              b.this.pSY.kc(paramAnonymousString.Hhy);
              b.this.pSY.tr(paramAnonymousString.Hhx);
              b.this.pSY.tJ(paramAnonymousString.Hhw);
            }
          }
          for (;;)
          {
            b.this.ai(b.this.pSY);
            AppMethodBeat.o(31330);
            return;
            ae.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", new Object[] { paramAnonymousn });
          }
        }
      };
    }
    g.ajS();
    g.ajQ().gDv.a(106, this.Fnw);
    paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, this.Fnu);
    g.ajS();
    g.ajQ().gDv.a(paramString, 0);
    AppMethodBeat.o(31336);
  }
  
  public final void DG(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(31335);
    if (this.pSY != null)
    {
      int i;
      if ((this.pSY.field_username != null) && (this.pSY.field_username.equals(paramString)))
      {
        i = 1;
        if ((this.pSY.VI() == null) || (!this.pSY.VI().equals(paramString))) {
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
    if ((this.lJm == null) || (!this.lJm.equals(paramString)))
    {
      AppMethodBeat.o(31335);
      return;
    }
    label115:
    if ((this.mHN == null) || (!this.mHN.isShowing()))
    {
      AppMethodBeat.o(31335);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31329);
        ImageView localImageView = (ImageView)b.this.mHN.getContentView().findViewById(2131298570);
        if (localImageView != null)
        {
          Bitmap localBitmap2 = com.tencent.mm.aj.c.a(b.this.pSY.field_username, false, -1, null);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 != null)
          {
            localBitmap1 = localBitmap2;
            if (b.this.pSY.fug()) {
              localBitmap1 = com.tencent.mm.sdk.platformtools.h.a(localBitmap2, false, localBitmap2.getWidth() / 2);
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
    if (this.jbE != null) {
      this.jbE.dismiss();
    }
    if (paramBoolean1)
    {
      this.pSY.acS();
      g.ajS();
      ((l)g.ab(l.class)).azF().c(this.pSY.field_username, this.pSY);
      com.tencent.mm.ui.base.h.cm(this.mContext, this.mContext.getResources().getString(2131766270));
      ot(1);
      AppMethodBeat.o(31337);
      return;
    }
    ot(-1);
    AppMethodBeat.o(31337);
  }
  
  final void ai(final an paraman)
  {
    Object localObject3 = null;
    AppMethodBeat.i(31333);
    if (paraman == null)
    {
      ae.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
      ot(-1);
      AppMethodBeat.o(31333);
      return;
    }
    String str1 = this.mContext.getString(2131766264);
    Object localObject2 = com.tencent.mm.aj.c.a(paraman.field_username, false, -1, null);
    if (localObject2 == null) {
      p.aEA().a(this);
    }
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (paraman.fug()) {
        localObject1 = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject2, false, ((Bitmap)localObject2).getWidth() / 2);
      }
    }
    String str2 = paraman.field_nickname;
    this.mHN = null;
    if ((this.mContext instanceof MMActivity))
    {
      if (!this.Fbr)
      {
        aj(paraman);
        AppMethodBeat.o(31333);
        return;
      }
      i locali = p.aEN().DL(paraman.field_username);
      localObject2 = localObject3;
      if (locali != null)
      {
        localObject2 = localObject3;
        if (!bu.isNullOrNil(locali.aEH())) {
          localObject2 = locali.aEH();
        }
      }
      this.mHN = o.a(((MMActivity)this.mContext).getController(), str1, (Bitmap)localObject1, str2, (String)localObject2, new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(31328);
          if (paramAnonymousBoolean) {
            b.this.aj(paraman);
          }
          for (;;)
          {
            b.this.mHN.dismiss();
            AppMethodBeat.o(31328);
            return;
            b.this.ot(0);
          }
        }
      });
    }
    if (this.mHN == null)
    {
      ae.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
      ot(-1);
    }
    AppMethodBeat.o(31333);
  }
  
  final void aj(an paraman)
  {
    AppMethodBeat.i(31334);
    if (this.jbE != null) {
      this.jbE.dismiss();
    }
    Object localObject = this.mContext;
    this.mContext.getString(2131755906);
    this.jbE = com.tencent.mm.ui.base.h.b((Context)localObject, this.mContext.getString(2131766267), true, null);
    localObject = new a(this.mContext, this);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(this.mScene));
    dvx localdvx = new dvx();
    localdvx.GvN = this.mGW;
    ((a)localObject).Fns = localdvx;
    ((a)localObject).a(paraman.field_username, localLinkedList, this.gzz);
    AppMethodBeat.o(31334);
  }
  
  final void ot(int paramInt)
  {
    AppMethodBeat.i(31338);
    if (this.Fnv != null) {
      this.Fnv.sO(paramInt);
    }
    AppMethodBeat.o(31338);
  }
  
  public final void show()
  {
    AppMethodBeat.i(31332);
    g.ajS();
    this.pSY = ((l)g.ab(l.class)).azF().BH(this.lJm);
    if ((this.pSY != null) && ((int)this.pSY.ght <= 0))
    {
      ae.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", new Object[] { this.lJm });
      g.ajS();
      this.pSY = ((l)g.ab(l.class)).azF().aUI(this.lJm);
    }
    if ((this.pSY != null) && ((int)this.pSY.ght > 0))
    {
      ae.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
      if (this.pSY == null)
      {
        ae.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
        ot(-1);
        AppMethodBeat.o(31332);
        return;
      }
      localObject = this.pSY.field_username;
      if (!this.pSY.fug())
      {
        if (((m)g.ab(m.class)).eR((String)localObject))
        {
          Context localContext = this.mContext;
          this.mContext.getString(2131755906);
          this.jbE = com.tencent.mm.ui.base.h.b(localContext, this.mContext.getString(2131766267), true, null);
          aOb((String)localObject);
          AppMethodBeat.o(31332);
          return;
        }
        if (((this.mContext instanceof MMActivity)) && (com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131766266), "", this.mContext.getString(2131755792), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(186721);
            ae.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
            b.this.ot(-1);
            AppMethodBeat.o(186721);
          }
        }) == null))
        {
          ae.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
          ot(-1);
        }
        AppMethodBeat.o(31332);
        return;
      }
      if (com.tencent.mm.contact.c.lO(this.pSY.field_type))
      {
        com.tencent.mm.ui.base.h.cm(this.mContext, this.mContext.getResources().getString(2131766270));
        ot(-2);
        AppMethodBeat.o(31332);
        return;
      }
      ai(this.pSY);
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
    this.jbE = com.tencent.mm.ui.base.h.b((Context)localObject, this.mContext.getString(2131766267), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(31327);
        if (b.this.jbE != null)
        {
          b.this.jbE.dismiss();
          b.this.jbE = null;
        }
        AppMethodBeat.o(31327);
      }
    });
    aOb(this.lJm);
    AppMethodBeat.o(31332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */