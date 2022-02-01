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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.dva;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;

public final class b
  implements e.a, a.a, w
{
  private boolean EIT = true;
  private int EUZ = 0;
  private v EVa;
  com.tencent.mm.al.f EVb = null;
  private String gwS;
  ProgressDialog iYL;
  String lEN;
  private String mBR;
  d mCI;
  Context mContext;
  private int mScene;
  am pMt;
  
  public b(Context paramContext, String paramString, int paramInt, v paramv)
  {
    this.mContext = paramContext;
    this.lEN = paramString;
    this.mScene = paramInt;
    this.EVa = paramv;
  }
  
  public b(Context paramContext, String paramString, int paramInt, v paramv, com.tencent.mm.pluginsdk.a parama)
  {
    this(paramContext, paramString, paramInt, paramv);
    AppMethodBeat.i(193442);
    if (parama != null)
    {
      this.EIT = parama.EIT;
      this.gwS = parama.EIR;
      this.EUZ = parama.EIS;
      this.mBR = parama.dkh;
    }
    AppMethodBeat.o(193442);
  }
  
  private void aMF(String paramString)
  {
    AppMethodBeat.i(31336);
    ad.i("MicroMsg.AddContactDialog", "searchContact %s", new Object[] { paramString });
    if (this.EVb == null) {
      this.EVb = new com.tencent.mm.al.f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(31330);
          if (b.this.iYL != null) {
            b.this.iYL.dismiss();
          }
          if (b.this.EVb != null)
          {
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.b(106, b.this.EVb);
          }
          if (b.this.iYL == null)
          {
            ad.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
            b.this.oq(0);
            AppMethodBeat.o(31330);
            return;
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            b.this.oq(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if (b.this.mContext == null)
          {
            ad.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
            b.this.oq(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if (((b.this.mContext instanceof Activity)) && (((Activity)b.this.mContext).isFinishing()))
          {
            ad.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
            b.this.oq(-1);
            AppMethodBeat.o(31330);
            return;
          }
          paramAnonymousString = ((com.tencent.mm.plugin.messenger.a.f)paramAnonymousn).dlC();
          paramAnonymousn = z.a(paramAnonymousString.GbY);
          if (bt.isNullOrNil(paramAnonymousn))
          {
            ad.e("MicroMsg.AddContactDialog", "searchContact, user is null");
            h.cl(b.this.mContext, b.this.mContext.getResources().getString(2131766266));
            b.this.oq(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if ((b.this.lEN == null) || (!b.this.lEN.equals(paramAnonymousn))) {
            ad.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", new Object[] { b.this.lEN, paramAnonymousn });
          }
          b localb = b.this;
          com.tencent.mm.kernel.g.ajD();
          localb.pMt = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramAnonymousn);
          if ((b.this.pMt == null) || ((int)b.this.pMt.gfj == 0))
          {
            ad.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + paramAnonymousn + ", try get by alias");
            localb = b.this;
            com.tencent.mm.kernel.g.ajD();
            localb.pMt = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTh(paramAnonymousn);
            if ((b.this.pMt == null) || ((int)b.this.pMt.gfj == 0))
            {
              ad.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
              b.this.pMt = new am(paramAnonymousn);
              b.this.pMt.sQ(paramAnonymousString.jdh);
              b.this.pMt.sT(z.a(paramAnonymousString.GKC));
              b.this.pMt.sU(z.a(paramAnonymousString.Gbr));
              b.this.pMt.sV(z.a(paramAnonymousString.Gbs));
              b.this.pMt.kf(paramAnonymousString.jdc);
              b.this.pMt.tq(RegionCodeDecoder.bf(paramAnonymousString.jdl, paramAnonymousString.jdd, paramAnonymousString.jde));
              b.this.pMt.tk(paramAnonymousString.jdf);
              b.this.pMt.kb(paramAnonymousString.GNU);
              b.this.pMt.tp(paramAnonymousString.GNV);
              b.this.pMt.ka(paramAnonymousString.GNY);
              b.this.pMt.sW(paramAnonymousString.GNX);
              b.this.pMt.to(paramAnonymousString.GNW);
            }
          }
          for (;;)
          {
            b.this.ab(b.this.pMt);
            AppMethodBeat.o(31330);
            return;
            ad.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", new Object[] { paramAnonymousn });
          }
        }
      };
    }
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(106, this.EVb);
    paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, this.EUZ);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    AppMethodBeat.o(31336);
  }
  
  public final void De(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(31335);
    if (this.pMt != null)
    {
      int i;
      if ((this.pMt.field_username != null) && (this.pMt.field_username.equals(paramString)))
      {
        i = 1;
        if ((this.pMt.VA() == null) || (!this.pMt.VA().equals(paramString))) {
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
    if ((this.lEN == null) || (!this.lEN.equals(paramString)))
    {
      AppMethodBeat.o(31335);
      return;
    }
    label115:
    if ((this.mCI == null) || (!this.mCI.isShowing()))
    {
      AppMethodBeat.o(31335);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31329);
        ImageView localImageView = (ImageView)b.this.mCI.getContentView().findViewById(2131298570);
        if (localImageView != null)
        {
          Bitmap localBitmap2 = c.a(b.this.pMt.field_username, false, -1, null);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 != null)
          {
            localBitmap1 = localBitmap2;
            if (b.this.pMt.fqg()) {
              localBitmap1 = com.tencent.mm.sdk.platformtools.g.a(localBitmap2, false, localBitmap2.getWidth() / 2);
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
    if (this.iYL != null) {
      this.iYL.dismiss();
    }
    if (paramBoolean1)
    {
      this.pMt.acH();
      com.tencent.mm.kernel.g.ajD();
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().c(this.pMt.field_username, this.pMt);
      h.cl(this.mContext, this.mContext.getResources().getString(2131766270));
      oq(1);
      AppMethodBeat.o(31337);
      return;
    }
    oq(-1);
    AppMethodBeat.o(31337);
  }
  
  final void ab(final am paramam)
  {
    Object localObject3 = null;
    AppMethodBeat.i(31333);
    if (paramam == null)
    {
      ad.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
      oq(-1);
      AppMethodBeat.o(31333);
      return;
    }
    String str1 = this.mContext.getString(2131766264);
    Object localObject2 = c.a(paramam.field_username, false, -1, null);
    if (localObject2 == null) {
      p.aEk().a(this);
    }
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (paramam.fqg()) {
        localObject1 = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject2, false, ((Bitmap)localObject2).getWidth() / 2);
      }
    }
    String str2 = paramam.field_nickname;
    this.mCI = null;
    if ((this.mContext instanceof MMActivity))
    {
      if (!this.EIT)
      {
        ac(paramam);
        AppMethodBeat.o(31333);
        return;
      }
      i locali = p.aEx().Dj(paramam.field_username);
      localObject2 = localObject3;
      if (locali != null)
      {
        localObject2 = localObject3;
        if (!bt.isNullOrNil(locali.aEr())) {
          localObject2 = locali.aEr();
        }
      }
      this.mCI = o.a(((MMActivity)this.mContext).getController(), str1, (Bitmap)localObject1, str2, (String)localObject2, new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(31328);
          if (paramAnonymousBoolean) {
            b.this.ac(paramam);
          }
          for (;;)
          {
            b.this.mCI.dismiss();
            AppMethodBeat.o(31328);
            return;
            b.this.oq(0);
          }
        }
      });
    }
    if (this.mCI == null)
    {
      ad.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
      oq(-1);
    }
    AppMethodBeat.o(31333);
  }
  
  final void ac(am paramam)
  {
    AppMethodBeat.i(31334);
    if (this.iYL != null) {
      this.iYL.dismiss();
    }
    Object localObject = this.mContext;
    this.mContext.getString(2131755906);
    this.iYL = h.b((Context)localObject, this.mContext.getString(2131766267), true, null);
    localObject = new a(this.mContext, this);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(this.mScene));
    dva localdva = new dva();
    localdva.Gdg = this.mBR;
    ((a)localObject).EUX = localdva;
    ((a)localObject).a(paramam.field_username, localLinkedList, this.gwS);
    AppMethodBeat.o(31334);
  }
  
  final void oq(int paramInt)
  {
    AppMethodBeat.i(31338);
    if (this.EVa != null) {
      this.EVa.sL(paramInt);
    }
    AppMethodBeat.o(31338);
  }
  
  public final void show()
  {
    AppMethodBeat.i(31332);
    com.tencent.mm.kernel.g.ajD();
    this.pMt = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.lEN);
    if ((this.pMt != null) && ((int)this.pMt.gfj <= 0))
    {
      ad.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", new Object[] { this.lEN });
      com.tencent.mm.kernel.g.ajD();
      this.pMt = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTh(this.lEN);
    }
    if ((this.pMt != null) && ((int)this.pMt.gfj > 0))
    {
      ad.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
      if (this.pMt == null)
      {
        ad.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
        oq(-1);
        AppMethodBeat.o(31332);
        return;
      }
      localObject = this.pMt.field_username;
      if (!this.pMt.fqg())
      {
        if (((m)com.tencent.mm.kernel.g.ab(m.class)).eM((String)localObject))
        {
          Context localContext = this.mContext;
          this.mContext.getString(2131755906);
          this.iYL = h.b(localContext, this.mContext.getString(2131766267), true, null);
          aMF((String)localObject);
          AppMethodBeat.o(31332);
          return;
        }
        if (((this.mContext instanceof MMActivity)) && (h.a(this.mContext, this.mContext.getString(2131766266), "", this.mContext.getString(2131755792), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(193441);
            ad.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
            b.this.oq(-1);
            AppMethodBeat.o(193441);
          }
        }) == null))
        {
          ad.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
          oq(-1);
        }
        AppMethodBeat.o(31332);
        return;
      }
      if (com.tencent.mm.o.b.lM(this.pMt.field_type))
      {
        h.cl(this.mContext, this.mContext.getResources().getString(2131766270));
        oq(-2);
        AppMethodBeat.o(31332);
        return;
      }
      ab(this.pMt);
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
    this.iYL = h.b((Context)localObject, this.mContext.getString(2131766267), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(31327);
        if (b.this.iYL != null)
        {
          b.this.iYL.dismiss();
          b.this.iYL = null;
        }
        AppMethodBeat.o(31327);
      }
    });
    aMF(this.lEN);
    AppMethodBeat.o(31332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */