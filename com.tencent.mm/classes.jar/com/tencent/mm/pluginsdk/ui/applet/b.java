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
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class b
  implements f.a, a.a, w
{
  private boolean QRq = true;
  private int ReY = 0;
  private v ReZ;
  i Rfa = null;
  private String jXW;
  Context mContext;
  ProgressDialog mRa;
  private int mScene;
  String pRV;
  private String qVt;
  com.tencent.mm.ui.widget.a.d qWk;
  as uNk;
  
  public b(Context paramContext, String paramString, int paramInt, v paramv)
  {
    this.mContext = paramContext;
    this.pRV = paramString;
    this.mScene = paramInt;
    this.ReZ = paramv;
  }
  
  public b(Context paramContext, String paramString, int paramInt, v paramv, com.tencent.mm.pluginsdk.a parama)
  {
    this(paramContext, paramString, paramInt, paramv);
    AppMethodBeat.i(199884);
    if (parama != null)
    {
      this.QRq = parama.QRq;
      this.jXW = parama.QRo;
      this.ReY = parama.QRp;
      this.qVt = parama.fvd;
    }
    AppMethodBeat.o(199884);
  }
  
  private void bqZ(String paramString)
  {
    AppMethodBeat.i(31336);
    Log.i("MicroMsg.AddContactDialog", "searchContact %s", new Object[] { paramString });
    if (this.Rfa == null) {
      this.Rfa = new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(31330);
          if (b.this.mRa != null) {
            b.this.mRa.dismiss();
          }
          if (b.this.Rfa != null)
          {
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.b(106, b.this.Rfa);
          }
          if (b.this.mRa == null)
          {
            Log.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
            b.this.uR(0);
            AppMethodBeat.o(31330);
            return;
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            b.this.uR(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if (b.this.mContext == null)
          {
            Log.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
            b.this.uR(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if (((b.this.mContext instanceof Activity)) && (((Activity)b.this.mContext).isFinishing()))
          {
            Log.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
            b.this.uR(-1);
            AppMethodBeat.o(31330);
            return;
          }
          paramAnonymousString = ((com.tencent.mm.plugin.messenger.a.f)paramAnonymousq).eRV();
          paramAnonymousq = z.a(paramAnonymousString.SrH);
          if (Util.isNullOrNil(paramAnonymousq))
          {
            Log.e("MicroMsg.AddContactDialog", "searchContact, user is null");
            com.tencent.mm.ui.base.h.cO(b.this.mContext, b.this.mContext.getResources().getString(R.l.wv_follow_is_not_biz));
            b.this.uR(-1);
            AppMethodBeat.o(31330);
            return;
          }
          if ((b.this.pRV == null) || (!b.this.pRV.equals(paramAnonymousq))) {
            Log.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", new Object[] { b.this.pRV, paramAnonymousq });
          }
          b localb = b.this;
          com.tencent.mm.kernel.h.aHH();
          localb.uNk = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramAnonymousq);
          if ((b.this.uNk == null) || ((int)b.this.uNk.jxt == 0))
          {
            Log.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + paramAnonymousq + ", try get by alias");
            localb = b.this;
            com.tencent.mm.kernel.h.aHH();
            localb.uNk = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwe(paramAnonymousq);
            if ((b.this.uNk == null) || ((int)b.this.uNk.jxt == 0))
            {
              Log.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
              b.this.uNk = new as(paramAnonymousq);
              b.this.uNk.Iq(paramAnonymousString.mVD);
              b.this.uNk.setNickname(z.a(paramAnonymousString.TtX));
              b.this.uNk.It(z.a(paramAnonymousString.SqW));
              b.this.uNk.Iu(z.a(paramAnonymousString.SqX));
              b.this.uNk.pw(paramAnonymousString.mVy);
              b.this.uNk.IP(RegionCodeDecoder.bl(paramAnonymousString.mVH, paramAnonymousString.mVz, paramAnonymousString.mVA));
              b.this.uNk.IJ(paramAnonymousString.mVB);
              b.this.uNk.ps(paramAnonymousString.TxF);
              b.this.uNk.IO(paramAnonymousString.TxG);
              b.this.uNk.pr(paramAnonymousString.TxJ);
              b.this.uNk.Iv(paramAnonymousString.TxI);
              b.this.uNk.IN(paramAnonymousString.TxH);
            }
          }
          for (;;)
          {
            b.this.aq(b.this.uNk);
            AppMethodBeat.o(31330);
            return;
            Log.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", new Object[] { paramAnonymousq });
          }
        }
      };
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(106, this.Rfa);
    paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, this.ReY);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    AppMethodBeat.o(31336);
  }
  
  public final void TM(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(31335);
    if (this.uNk != null)
    {
      int i;
      if ((this.uNk.field_username != null) && (this.uNk.field_username.equals(paramString)))
      {
        i = 1;
        if ((this.uNk.apf() == null) || (!this.uNk.apf().equals(paramString))) {
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
    if ((this.pRV == null) || (!this.pRV.equals(paramString)))
    {
      AppMethodBeat.o(31335);
      return;
    }
    label115:
    if ((this.qWk == null) || (!this.qWk.isShowing()))
    {
      AppMethodBeat.o(31335);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31329);
        ImageView localImageView = (ImageView)b.this.qWk.getContentView().findViewById(R.h.confirm_dialog_thumb_iv);
        if (localImageView != null)
        {
          Bitmap localBitmap2 = com.tencent.mm.am.d.a(b.this.uNk.field_username, false, -1, null);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 != null)
          {
            localBitmap1 = localBitmap2;
            if (b.this.uNk.hxX()) {
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
    if (this.mRa != null) {
      this.mRa.dismiss();
    }
    if (paramBoolean1)
    {
      this.uNk.axk();
      com.tencent.mm.kernel.h.aHH();
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().c(this.uNk.field_username, this.uNk);
      com.tencent.mm.ui.base.h.cO(this.mContext, this.mContext.getResources().getString(R.l.wv_has_follow));
      uR(1);
      AppMethodBeat.o(31337);
      return;
    }
    uR(-1);
    AppMethodBeat.o(31337);
  }
  
  final void aq(final as paramas)
  {
    Object localObject3 = null;
    AppMethodBeat.i(31333);
    if (paramas == null)
    {
      Log.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
      uR(-1);
      AppMethodBeat.o(31333);
      return;
    }
    String str1 = this.mContext.getString(R.l.wv_follow_brand_account);
    Object localObject2 = com.tencent.mm.am.d.a(paramas.field_username, false, -1, null);
    if (localObject2 == null) {
      com.tencent.mm.am.q.bhz().a(this);
    }
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (paramas.hxX()) {
        localObject1 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject2, false, ((Bitmap)localObject2).getWidth() / 2);
      }
    }
    String str2 = paramas.field_nickname;
    this.qWk = null;
    if ((this.mContext instanceof MMActivity))
    {
      if (!this.QRq)
      {
        ar(paramas);
        AppMethodBeat.o(31333);
        return;
      }
      j localj = com.tencent.mm.am.q.bhP().TS(paramas.field_username);
      localObject2 = localObject3;
      if (localj != null)
      {
        localObject2 = localObject3;
        if (!Util.isNullOrNil(localj.bhI())) {
          localObject2 = localj.bhI();
        }
      }
      this.qWk = o.a(((MMActivity)this.mContext).getController(), str1, (Bitmap)localObject1, str2, (String)localObject2, R.l.exR, new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(31328);
          if (paramAnonymousBoolean) {
            b.this.ar(paramas);
          }
          for (;;)
          {
            b.this.qWk.dismiss();
            AppMethodBeat.o(31328);
            return;
            b.this.uR(0);
          }
        }
      });
    }
    if (this.qWk == null)
    {
      Log.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
      uR(-1);
    }
    AppMethodBeat.o(31333);
  }
  
  final void ar(as paramas)
  {
    AppMethodBeat.i(31334);
    if (this.mRa != null) {
      this.mRa.dismiss();
    }
    Object localObject = this.mContext;
    this.mContext.getString(R.l.app_tip);
    this.mRa = com.tencent.mm.ui.base.h.a((Context)localObject, this.mContext.getString(R.l.wv_following), true, null);
    localObject = new a(this.mContext, this);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(this.mScene));
    fam localfam = new fam();
    localfam.SsR = this.qVt;
    ((a)localObject).ReP = localfam;
    ((a)localObject).a(paramas.field_username, localLinkedList, this.jXW);
    AppMethodBeat.o(31334);
  }
  
  public final void show()
  {
    AppMethodBeat.i(31332);
    com.tencent.mm.kernel.h.aHH();
    this.uNk = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.pRV);
    if ((this.uNk != null) && ((int)this.uNk.jxt <= 0))
    {
      Log.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", new Object[] { this.pRV });
      com.tencent.mm.kernel.h.aHH();
      this.uNk = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwe(this.pRV);
    }
    if ((this.uNk != null) && ((int)this.uNk.jxt > 0))
    {
      Log.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
      if (this.uNk == null)
      {
        Log.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
        uR(-1);
        AppMethodBeat.o(31332);
        return;
      }
      localObject = this.uNk.field_username;
      if (!this.uNk.hxX())
      {
        if (((com.tencent.mm.api.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.n.class)).go((String)localObject))
        {
          Context localContext = this.mContext;
          this.mContext.getString(R.l.app_tip);
          this.mRa = com.tencent.mm.ui.base.h.a(localContext, this.mContext.getString(R.l.wv_following), true, null);
          bqZ((String)localObject);
          AppMethodBeat.o(31332);
          return;
        }
        if (((this.mContext instanceof MMActivity)) && (com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.wv_follow_is_not_biz), "", this.mContext.getString(R.l.app_i_know), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(262271);
            Log.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
            b.this.uR(-1);
            AppMethodBeat.o(262271);
          }
        }) == null))
        {
          Log.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
          uR(-1);
        }
        AppMethodBeat.o(31332);
        return;
      }
      if (com.tencent.mm.contact.d.rk(this.uNk.field_type))
      {
        com.tencent.mm.ui.base.h.cO(this.mContext, this.mContext.getResources().getString(R.l.wv_has_follow));
        uR(-2);
        AppMethodBeat.o(31332);
        return;
      }
      aq(this.uNk);
      AppMethodBeat.o(31332);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(31332);
      return;
    }
    Object localObject = this.mContext;
    this.mContext.getString(R.l.app_tip);
    this.mRa = com.tencent.mm.ui.base.h.a((Context)localObject, this.mContext.getString(R.l.wv_following), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(31327);
        if (b.this.mRa != null)
        {
          b.this.mRa.dismiss();
          b.this.mRa = null;
        }
        AppMethodBeat.o(31327);
      }
    });
    bqZ(this.pRV);
    AppMethodBeat.o(31332);
  }
  
  final void uR(int paramInt)
  {
    AppMethodBeat.i(31338);
    if (this.ReZ != null) {
      this.ReZ.zZ(paramInt);
    }
    AppMethodBeat.o(31338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */