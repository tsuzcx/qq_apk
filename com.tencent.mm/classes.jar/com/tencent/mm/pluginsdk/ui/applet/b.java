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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.c;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.protocal.protobuf.fws;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.e;
import java.util.LinkedList;

public final class b
  implements AvatarStorage.a, a.a, w
{
  private boolean XNl = true;
  private int Ybd;
  private int Ybe = 0;
  private v Ybf;
  private com.tencent.mm.am.h Ybg = null;
  private boolean Ybh;
  private Context mContext;
  private int mScene;
  private String mxQ;
  private ProgressDialog pNH;
  private String sWX;
  private String uaZ;
  private e ubT;
  private au xVS;
  
  public b(Context paramContext, String paramString, int paramInt, v paramv)
  {
    this.mContext = paramContext;
    this.sWX = paramString;
    this.mScene = paramInt;
    this.Ybf = paramv;
  }
  
  public b(Context paramContext, String paramString, int paramInt, v paramv, com.tencent.mm.pluginsdk.a parama)
  {
    this(paramContext, paramString, paramInt, paramv);
    AppMethodBeat.i(245248);
    a(parama);
    AppMethodBeat.o(245248);
  }
  
  public b(Context paramContext, String paramString, v paramv, com.tencent.mm.pluginsdk.a parama)
  {
    this(paramContext, paramString, 215, paramv);
    AppMethodBeat.i(245245);
    a(parama);
    this.Ybh = true;
    AppMethodBeat.o(245245);
  }
  
  private void AJ(int paramInt)
  {
    AppMethodBeat.i(31338);
    if (this.Ybf != null) {
      this.Ybf.onAddContact(paramInt);
    }
    AppMethodBeat.o(31338);
  }
  
  private void a(com.tencent.mm.pluginsdk.a parama)
  {
    if (parama != null)
    {
      this.XNl = parama.XNl;
      this.mxQ = parama.XNj;
      this.Ybe = parama.XNk;
      this.uaZ = parama.hzx;
      this.Ybd = parama.AcJ;
    }
  }
  
  private void aw(final au paramau)
  {
    Object localObject3 = null;
    AppMethodBeat.i(31333);
    if (paramau == null)
    {
      Log.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
      AJ(-1);
      AppMethodBeat.o(31333);
      return;
    }
    String str1 = this.mContext.getString(R.l.wv_follow_brand_account);
    Object localObject2 = com.tencent.mm.modelavatar.d.a(paramau.field_username, false, -1, null);
    if (localObject2 == null) {
      q.bFp().a(this);
    }
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (paramau.iZC()) {
        localObject1 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject2, false, ((Bitmap)localObject2).getWidth() / 2);
      }
    }
    String str2 = paramau.field_nickname;
    this.ubT = null;
    if ((this.mContext instanceof MMActivity))
    {
      if (!this.XNl)
      {
        ax(paramau);
        AppMethodBeat.o(31333);
        return;
      }
      j localj = q.bFE().LS(paramau.field_username);
      localObject2 = localObject3;
      if (localj != null)
      {
        localObject2 = localObject3;
        if (!Util.isNullOrNil(localj.bFx())) {
          localObject2 = localj.bFx();
        }
      }
      this.ubT = o.a(((MMActivity)this.mContext).getController(), str1, (Bitmap)localObject1, str2, (String)localObject2, R.l.gAG, new y.a()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(31328);
          if (paramAnonymousBoolean) {
            b.a(b.this, paramau);
          }
          for (;;)
          {
            b.c(b.this).dismiss();
            AppMethodBeat.o(31328);
            return;
            b.a(b.this, 0);
          }
        }
      });
    }
    if (this.ubT == null)
    {
      Log.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
      AJ(-1);
    }
    AppMethodBeat.o(31333);
  }
  
  private void ax(au paramau)
  {
    boolean bool = true;
    AppMethodBeat.i(31334);
    if (this.pNH != null) {
      this.pNH.dismiss();
    }
    if (!this.Ybh)
    {
      localObject = this.mContext;
      this.mContext.getString(R.l.app_tip);
      this.pNH = com.tencent.mm.ui.base.k.a((Context)localObject, this.mContext.getString(R.l.wv_following), true, null);
    }
    Object localObject = new a(this.mContext, this);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(this.mScene));
    fws localfws = new fws();
    localfws.Zsa = this.uaZ;
    localfws.YIc = this.Ybd;
    ((a)localObject).YaU = localfws;
    if (!this.Ybh) {}
    for (;;)
    {
      ((a)localObject).hks = bool;
      ((a)localObject).a(paramau.field_username, localLinkedList, this.mxQ);
      AppMethodBeat.o(31334);
      return;
      bool = false;
    }
  }
  
  private void bqN(String paramString)
  {
    AppMethodBeat.i(31336);
    Log.i("MicroMsg.AddContactDialog", "searchContact %s", new Object[] { paramString });
    if (this.Ybg == null) {
      this.Ybg = new com.tencent.mm.am.h()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(31330);
          if (b.a(b.this) != null) {
            b.a(b.this).dismiss();
          }
          if (b.e(b.this) != null)
          {
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.b(106, b.e(b.this));
          }
          if ((b.a(b.this) == null) && (!b.f(b.this)))
          {
            Log.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
            b.a(b.this, 0);
            AppMethodBeat.o(31330);
            return;
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            b.a(b.this, -1);
            AppMethodBeat.o(31330);
            return;
          }
          if (b.g(b.this) == null)
          {
            Log.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
            b.a(b.this, -1);
            AppMethodBeat.o(31330);
            return;
          }
          if (((b.g(b.this) instanceof Activity)) && (((Activity)b.g(b.this)).isFinishing()))
          {
            Log.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
            b.a(b.this, -1);
            AppMethodBeat.o(31330);
            return;
          }
          paramAnonymousString = ((f)paramAnonymousp).gaH();
          paramAnonymousp = com.tencent.mm.platformtools.w.a(paramAnonymousString.ZqL);
          if (Util.isNullOrNil(paramAnonymousp))
          {
            Log.e("MicroMsg.AddContactDialog", "searchContact, user is null");
            com.tencent.mm.ui.base.k.cZ(b.g(b.this), b.g(b.this).getResources().getString(R.l.wv_follow_is_not_biz));
            b.a(b.this, -1);
            AppMethodBeat.o(31330);
            return;
          }
          if ((b.h(b.this) == null) || (!b.h(b.this).equals(paramAnonymousp))) {
            Log.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", new Object[] { b.h(b.this), paramAnonymousp });
          }
          b localb = b.this;
          com.tencent.mm.kernel.h.baF();
          b.b(localb, ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramAnonymousp));
          if ((b.d(b.this) == null) || ((int)b.d(b.this).maN == 0))
          {
            Log.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + paramAnonymousp + ", try get by alias");
            localb = b.this;
            com.tencent.mm.kernel.h.baF();
            b.b(localb, ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxs(paramAnonymousp));
            if ((b.d(b.this) == null) || ((int)b.d(b.this).maN == 0))
            {
              Log.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
              b.b(b.this, new au(paramAnonymousp));
              b.d(b.this).AV(paramAnonymousString.pSk);
              b.d(b.this).setNickname(com.tencent.mm.platformtools.w.a(paramAnonymousString.aaIz));
              b.d(b.this).AY(com.tencent.mm.platformtools.w.a(paramAnonymousString.ZpX));
              b.d(b.this).AZ(com.tencent.mm.platformtools.w.a(paramAnonymousString.ZpY));
              b.d(b.this).pv(paramAnonymousString.pSf);
              b.d(b.this).Bu(RegionCodeDecoder.bI(paramAnonymousString.pSo, paramAnonymousString.pSg, paramAnonymousString.pSh));
              b.d(b.this).Bo(paramAnonymousString.pSi);
              b.d(b.this).pr(paramAnonymousString.aaMm);
              b.d(b.this).Bt(paramAnonymousString.aaMn);
              b.d(b.this).pq(paramAnonymousString.aaMq);
              b.d(b.this).Ba(paramAnonymousString.aaMp);
              b.d(b.this).Bs(paramAnonymousString.aaMo);
            }
          }
          for (;;)
          {
            b.c(b.this, b.d(b.this));
            AppMethodBeat.o(31330);
            return;
            Log.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", new Object[] { paramAnonymousp });
          }
        }
      };
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(106, this.Ybg);
    paramString = new f(paramString, this.Ybe);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    AppMethodBeat.o(31336);
  }
  
  public final void LM(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(31335);
    if (this.xVS != null)
    {
      int i;
      if ((this.xVS.field_username != null) && (this.xVS.field_username.equals(paramString)))
      {
        i = 1;
        if ((this.xVS.aJs() == null) || (!this.xVS.aJs().equals(paramString))) {
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
    if ((this.sWX == null) || (!this.sWX.equals(paramString)))
    {
      AppMethodBeat.o(31335);
      return;
    }
    label115:
    if ((this.ubT == null) || (!this.ubT.isShowing()))
    {
      AppMethodBeat.o(31335);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31329);
        ImageView localImageView = (ImageView)b.c(b.this).getContentView().findViewById(R.h.confirm_dialog_thumb_iv);
        if (localImageView != null)
        {
          Bitmap localBitmap2 = com.tencent.mm.modelavatar.d.a(b.d(b.this).field_username, false, -1, null);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 != null)
          {
            localBitmap1 = localBitmap2;
            if (b.d(b.this).iZC()) {
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
  
  public final void canAddContact(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31337);
    if (this.pNH != null) {
      this.pNH.dismiss();
    }
    if (paramBoolean1)
    {
      this.xVS.aRK();
      com.tencent.mm.kernel.h.baF();
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(this.xVS.field_username, this.xVS);
      com.tencent.mm.ui.base.k.cZ(this.mContext, this.mContext.getResources().getString(R.l.wv_has_follow));
      AJ(1);
      AppMethodBeat.o(31337);
      return;
    }
    AJ(-1);
    AppMethodBeat.o(31337);
  }
  
  public final void show()
  {
    AppMethodBeat.i(31332);
    com.tencent.mm.kernel.h.baF();
    this.xVS = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.sWX);
    if ((this.xVS != null) && ((int)this.xVS.maN <= 0))
    {
      Log.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", new Object[] { this.sWX });
      com.tencent.mm.kernel.h.baF();
      this.xVS = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxs(this.sWX);
    }
    Object localObject;
    if ((this.xVS != null) && ((int)this.xVS.maN > 0))
    {
      Log.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
      if (this.xVS == null)
      {
        Log.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
        AJ(-1);
        AppMethodBeat.o(31332);
        return;
      }
      localObject = this.xVS.field_username;
      if (!this.xVS.iZC())
      {
        if (((com.tencent.mm.api.o)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.o.class)).hO((String)localObject))
        {
          if (!this.Ybh)
          {
            Context localContext = this.mContext;
            this.mContext.getString(R.l.app_tip);
            this.pNH = com.tencent.mm.ui.base.k.a(localContext, this.mContext.getString(R.l.wv_following), true, null);
          }
          bqN((String)localObject);
          AppMethodBeat.o(31332);
          return;
        }
        if (((this.mContext instanceof MMActivity)) && (com.tencent.mm.ui.base.k.a(this.mContext, this.mContext.getString(R.l.wv_follow_is_not_biz), "", this.mContext.getString(R.l.app_i_know), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(245301);
            Log.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
            b.a(b.this, -1);
            AppMethodBeat.o(245301);
          }
        }) == null))
        {
          Log.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
          AJ(-1);
        }
        AppMethodBeat.o(31332);
        return;
      }
      if (com.tencent.mm.contact.d.rs(this.xVS.field_type))
      {
        com.tencent.mm.ui.base.k.cZ(this.mContext, this.mContext.getResources().getString(R.l.wv_has_follow));
        AJ(-2);
        AppMethodBeat.o(31332);
        return;
      }
      aw(this.xVS);
      AppMethodBeat.o(31332);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(31332);
      return;
    }
    if (!this.Ybh)
    {
      localObject = this.mContext;
      this.mContext.getString(R.l.app_tip);
      this.pNH = com.tencent.mm.ui.base.k.a((Context)localObject, this.mContext.getString(R.l.wv_following), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(31327);
          if (b.a(b.this) != null)
          {
            b.a(b.this).dismiss();
            b.b(b.this);
          }
          AppMethodBeat.o(31327);
        }
      });
    }
    bqN(this.sWX);
    AppMethodBeat.o(31332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */