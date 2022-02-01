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
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.n;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;

public final class b
  implements e.a, a.a, w
{
  private boolean JSl = true;
  private int Kek = 0;
  private v Kel;
  com.tencent.mm.ak.i Kem = null;
  private String hmm;
  ProgressDialog jZH;
  Context mContext;
  String mRa;
  private int mScene;
  private String nTU;
  d nUK;
  as rjX;
  
  public b(Context paramContext, String paramString, int paramInt, v paramv)
  {
    this.mContext = paramContext;
    this.mRa = paramString;
    this.mScene = paramInt;
    this.Kel = paramv;
  }
  
  public b(Context paramContext, String paramString, int paramInt, v paramv, com.tencent.mm.pluginsdk.a parama)
  {
    this(paramContext, paramString, paramInt, paramv);
    AppMethodBeat.i(232190);
    if (parama != null)
    {
      this.JSl = parama.JSl;
      this.hmm = parama.JSj;
      this.Kek = parama.JSk;
      this.nTU = parama.dCw;
    }
    AppMethodBeat.o(232190);
  }
  
  private void beD(String paramString)
  {
    AppMethodBeat.i(31336);
    Log.i("MicroMsg.AddContactDialog", "searchContact %s", new Object[] { paramString });
    if (this.Kem == null) {
      this.Kem = new com.tencent.mm.ak.i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(31330);
          if (b.this.jZH != null) {
            b.this.jZH.dismiss();
          }
          if (b.this.Kem != null)
          {
            g.aAi();
            g.aAg().hqi.b(106, b.this.Kem);
          }
          if (b.this.jZH == null)
          {
            Log.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
            b.this.rU(0);
            AppMethodBeat.o(31330);
            return;
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            b.this.rU(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if (b.this.mContext == null)
          {
            Log.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
            b.this.rU(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if (((b.this.mContext instanceof Activity)) && (((Activity)b.this.mContext).isFinishing()))
          {
            Log.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
            b.this.rU(-1);
            AppMethodBeat.o(31330);
            return;
          }
          paramAnonymousString = ((f)paramAnonymousq).eiq();
          paramAnonymousq = z.a(paramAnonymousString.Lqk);
          if (Util.isNullOrNil(paramAnonymousq))
          {
            Log.e("MicroMsg.AddContactDialog", "searchContact, user is null");
            h.cD(b.this.mContext, b.this.mContext.getResources().getString(2131768777));
            b.this.rU(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if ((b.this.mRa == null) || (!b.this.mRa.equals(paramAnonymousq))) {
            Log.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", new Object[] { b.this.mRa, paramAnonymousq });
          }
          b localb = b.this;
          g.aAi();
          localb.rjX = ((l)g.af(l.class)).aSN().Kn(paramAnonymousq);
          if ((b.this.rjX == null) || ((int)b.this.rjX.gMZ == 0))
          {
            Log.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + paramAnonymousq + ", try get by alias");
            localb = b.this;
            g.aAi();
            localb.rjX = ((l)g.af(l.class)).aSN().bjH(paramAnonymousq);
            if ((b.this.rjX == null) || ((int)b.this.rjX.gMZ == 0))
            {
              Log.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
              b.this.rjX = new as(paramAnonymousq);
              b.this.rjX.BC(paramAnonymousString.ked);
              b.this.rjX.setNickname(z.a(paramAnonymousString.Mjj));
              b.this.rjX.BF(z.a(paramAnonymousString.LpA));
              b.this.rjX.BG(z.a(paramAnonymousString.LpB));
              b.this.rjX.nj(paramAnonymousString.kdY);
              b.this.rjX.Cb(RegionCodeDecoder.bq(paramAnonymousString.keh, paramAnonymousString.kdZ, paramAnonymousString.kea));
              b.this.rjX.BV(paramAnonymousString.keb);
              b.this.rjX.nf(paramAnonymousString.MmK);
              b.this.rjX.Ca(paramAnonymousString.MmL);
              b.this.rjX.ne(paramAnonymousString.MmO);
              b.this.rjX.BH(paramAnonymousString.MmN);
              b.this.rjX.BZ(paramAnonymousString.MmM);
            }
          }
          for (;;)
          {
            b.this.ak(b.this.rjX);
            AppMethodBeat.o(31330);
            return;
            Log.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", new Object[] { paramAnonymousq });
          }
        }
      };
    }
    g.aAi();
    g.aAg().hqi.a(106, this.Kem);
    paramString = new f(paramString, this.Kek);
    g.aAi();
    g.aAg().hqi.a(paramString, 0);
    AppMethodBeat.o(31336);
  }
  
  public final void Mr(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(31335);
    if (this.rjX != null)
    {
      int i;
      if ((this.rjX.field_username != null) && (this.rjX.field_username.equals(paramString)))
      {
        i = 1;
        if ((this.rjX.ajx() == null) || (!this.rjX.ajx().equals(paramString))) {
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
    if ((this.mRa == null) || (!this.mRa.equals(paramString)))
    {
      AppMethodBeat.o(31335);
      return;
    }
    label115:
    if ((this.nUK == null) || (!this.nUK.isShowing()))
    {
      AppMethodBeat.o(31335);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31329);
        ImageView localImageView = (ImageView)b.this.nUK.getContentView().findViewById(2131299005);
        if (localImageView != null)
        {
          Bitmap localBitmap2 = com.tencent.mm.aj.c.a(b.this.rjX.field_username, false, -1, null);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 != null)
          {
            localBitmap1 = localBitmap2;
            if (b.this.rjX.gBM()) {
              localBitmap1 = BitmapUtil.getRoundedCornerBitmap(localBitmap2, false, localBitmap2.getWidth() / 2);
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
    if (this.jZH != null) {
      this.jZH.dismiss();
    }
    if (paramBoolean1)
    {
      this.rjX.aqQ();
      g.aAi();
      ((l)g.af(l.class)).aSN().c(this.rjX.field_username, this.rjX);
      h.cD(this.mContext, this.mContext.getResources().getString(2131768781));
      rU(1);
      AppMethodBeat.o(31337);
      return;
    }
    rU(-1);
    AppMethodBeat.o(31337);
  }
  
  final void ak(final as paramas)
  {
    Object localObject3 = null;
    AppMethodBeat.i(31333);
    if (paramas == null)
    {
      Log.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
      rU(-1);
      AppMethodBeat.o(31333);
      return;
    }
    String str1 = this.mContext.getString(2131768775);
    Object localObject2 = com.tencent.mm.aj.c.a(paramas.field_username, false, -1, null);
    if (localObject2 == null) {
      p.aYn().a(this);
    }
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (paramas.gBM()) {
        localObject1 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject2, false, ((Bitmap)localObject2).getWidth() / 2);
      }
    }
    String str2 = paramas.field_nickname;
    this.nUK = null;
    if ((this.mContext instanceof MMActivity))
    {
      if (!this.JSl)
      {
        al(paramas);
        AppMethodBeat.o(31333);
        return;
      }
      com.tencent.mm.aj.i locali = p.aYB().Mx(paramas.field_username);
      localObject2 = localObject3;
      if (locali != null)
      {
        localObject2 = localObject3;
        if (!Util.isNullOrNil(locali.aYu())) {
          localObject2 = locali.aYu();
        }
      }
      this.nUK = o.a(((MMActivity)this.mContext).getController(), str1, (Bitmap)localObject1, str2, (String)localObject2, new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(31328);
          if (paramAnonymousBoolean) {
            b.this.al(paramas);
          }
          for (;;)
          {
            b.this.nUK.dismiss();
            AppMethodBeat.o(31328);
            return;
            b.this.rU(0);
          }
        }
      });
    }
    if (this.nUK == null)
    {
      Log.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
      rU(-1);
    }
    AppMethodBeat.o(31333);
  }
  
  final void al(as paramas)
  {
    AppMethodBeat.i(31334);
    if (this.jZH != null) {
      this.jZH.dismiss();
    }
    Object localObject = this.mContext;
    this.mContext.getString(2131755998);
    this.jZH = h.a((Context)localObject, this.mContext.getString(2131768778), true, null);
    localObject = new a(this.mContext, this);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(this.mScene));
    eqb localeqb = new eqb();
    localeqb.Lru = this.nTU;
    ((a)localObject).Kei = localeqb;
    ((a)localObject).a(paramas.field_username, localLinkedList, this.hmm);
    AppMethodBeat.o(31334);
  }
  
  final void rU(int paramInt)
  {
    AppMethodBeat.i(31338);
    if (this.Kel != null) {
      this.Kel.wK(paramInt);
    }
    AppMethodBeat.o(31338);
  }
  
  public final void show()
  {
    AppMethodBeat.i(31332);
    g.aAi();
    this.rjX = ((l)g.af(l.class)).aSN().Kn(this.mRa);
    if ((this.rjX != null) && ((int)this.rjX.gMZ <= 0))
    {
      Log.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", new Object[] { this.mRa });
      g.aAi();
      this.rjX = ((l)g.af(l.class)).aSN().bjH(this.mRa);
    }
    if ((this.rjX != null) && ((int)this.rjX.gMZ > 0))
    {
      Log.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
      if (this.rjX == null)
      {
        Log.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
        rU(-1);
        AppMethodBeat.o(31332);
        return;
      }
      localObject = this.rjX.field_username;
      if (!this.rjX.gBM())
      {
        if (((n)g.af(n.class)).fD((String)localObject))
        {
          Context localContext = this.mContext;
          this.mContext.getString(2131755998);
          this.jZH = h.a(localContext, this.mContext.getString(2131768778), true, null);
          beD((String)localObject);
          AppMethodBeat.o(31332);
          return;
        }
        if (((this.mContext instanceof MMActivity)) && (h.a(this.mContext, this.mContext.getString(2131768777), "", this.mContext.getString(2131755873), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(232189);
            Log.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
            b.this.rU(-1);
            AppMethodBeat.o(232189);
          }
        }) == null))
        {
          Log.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
          rU(-1);
        }
        AppMethodBeat.o(31332);
        return;
      }
      if (com.tencent.mm.contact.c.oR(this.rjX.field_type))
      {
        h.cD(this.mContext, this.mContext.getResources().getString(2131768781));
        rU(-2);
        AppMethodBeat.o(31332);
        return;
      }
      ak(this.rjX);
      AppMethodBeat.o(31332);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(31332);
      return;
    }
    Object localObject = this.mContext;
    this.mContext.getString(2131755998);
    this.jZH = h.a((Context)localObject, this.mContext.getString(2131768778), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(31327);
        if (b.this.jZH != null)
        {
          b.this.jZH.dismiss();
          b.this.jZH = null;
        }
        AppMethodBeat.o(31327);
      }
    });
    beD(this.mRa);
    AppMethodBeat.o(31332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */