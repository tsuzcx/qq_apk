package com.tencent.mm.pluginsdk.ui.applet;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;
import java.util.LinkedList;

public final class b
  implements d.a, a.a, o
{
  private String eDy;
  ProgressDialog gsr;
  c iNf;
  String ikj;
  ad lpe;
  Context mContext;
  private int mScene;
  int vSY = 0;
  private n vSZ;
  com.tencent.mm.ai.f vTa = null;
  private boolean vTb = true;
  
  public b(Context paramContext, String paramString1, int paramInt, n paramn, String paramString2)
  {
    this(paramContext, paramString1, paramInt, paramn, true, paramString2);
  }
  
  public b(Context paramContext, String paramString1, int paramInt, n paramn, boolean paramBoolean, String paramString2)
  {
    this.mContext = paramContext;
    this.ikj = paramString1;
    this.mScene = paramInt;
    this.vSZ = paramn;
    this.vTb = paramBoolean;
    this.eDy = paramString2;
  }
  
  public b(Context paramContext, String paramString, n paramn)
  {
    this(paramContext, paramString, 0, paramn, true, "");
  }
  
  private void amh(String paramString)
  {
    AppMethodBeat.i(27633);
    ab.i("MicroMsg.AddContactDialog", "searchContact %s", new Object[] { paramString });
    if (this.vTa == null) {
      this.vTa = new b.4(this);
    }
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(106, this.vTa);
    paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, this.vSY);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
    AppMethodBeat.o(27633);
  }
  
  final void T(final ad paramad)
  {
    AppMethodBeat.i(27630);
    if (paramad == null)
    {
      ab.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
      kw(-1);
      AppMethodBeat.o(27630);
      return;
    }
    String str = this.mContext.getString(2131306016);
    Object localObject2 = com.tencent.mm.ah.b.b(paramad.field_username, false, -1);
    if (localObject2 == null) {
      com.tencent.mm.ah.o.acQ().a(this);
    }
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (paramad.dwz()) {
        localObject1 = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject2, false, ((Bitmap)localObject2).getWidth() / 2);
      }
    }
    localObject2 = paramad.field_nickname;
    this.iNf = null;
    if ((this.mContext instanceof MMActivity))
    {
      if (!this.vTb)
      {
        U(paramad);
        AppMethodBeat.o(27630);
        return;
      }
      this.iNf = g.a(((MMActivity)this.mContext).getController(), str, (Bitmap)localObject1, (String)localObject2, "", new q.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(27625);
          if (paramAnonymousBoolean) {
            b.this.U(paramad);
          }
          for (;;)
          {
            b.this.iNf.dismiss();
            AppMethodBeat.o(27625);
            return;
            b.this.kw(0);
          }
        }
      });
    }
    if (this.iNf == null)
    {
      ab.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
      kw(-1);
    }
    AppMethodBeat.o(27630);
  }
  
  final void U(ad paramad)
  {
    AppMethodBeat.i(27631);
    if (this.gsr != null) {
      this.gsr.dismiss();
    }
    Object localObject = this.mContext;
    this.mContext.getString(2131297087);
    this.gsr = h.b((Context)localObject, this.mContext.getString(2131306019), true, null);
    localObject = new a(this.mContext, this);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(this.mScene));
    ((a)localObject).a(paramad.field_username, localLinkedList, this.eDy);
    AppMethodBeat.o(27631);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(27634);
    if (this.gsr != null) {
      this.gsr.dismiss();
    }
    if (paramBoolean1)
    {
      this.lpe.Nx();
      com.tencent.mm.kernel.g.RM();
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().b(this.lpe.field_username, this.lpe);
      h.bO(this.mContext, this.mContext.getResources().getString(2131306022));
      kw(1);
      AppMethodBeat.o(27634);
      return;
    }
    kw(-1);
    AppMethodBeat.o(27634);
  }
  
  final void kw(int paramInt)
  {
    AppMethodBeat.i(27635);
    if (this.vSZ != null) {
      this.vSZ.nP(paramInt);
    }
    AppMethodBeat.o(27635);
  }
  
  public final void re(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(27632);
    if (this.lpe != null)
    {
      int i;
      if ((this.lpe.field_username != null) && (this.lpe.field_username.equals(paramString)))
      {
        i = 1;
        if ((this.lpe.Hq() == null) || (!this.lpe.Hq().equals(paramString))) {
          break label85;
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0)) {
          break label115;
        }
        AppMethodBeat.o(27632);
        return;
        i = 0;
        break;
        label85:
        j = 0;
      }
    }
    if ((this.ikj == null) || (!this.ikj.equals(paramString)))
    {
      AppMethodBeat.o(27632);
      return;
    }
    label115:
    if ((this.iNf == null) || (!this.iNf.isShowing()))
    {
      AppMethodBeat.o(27632);
      return;
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27626);
        ImageView localImageView = (ImageView)b.this.iNf.getContentView().findViewById(2131822991);
        if (localImageView != null)
        {
          Bitmap localBitmap2 = com.tencent.mm.ah.b.b(b.this.lpe.field_username, false, -1);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 != null)
          {
            localBitmap1 = localBitmap2;
            if (b.this.lpe.dwz()) {
              localBitmap1 = com.tencent.mm.sdk.platformtools.d.a(localBitmap2, false, localBitmap2.getWidth() / 2);
            }
          }
          if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
          {
            localImageView.setImageBitmap(localBitmap1);
            localImageView.setVisibility(0);
          }
        }
        AppMethodBeat.o(27626);
      }
    });
    AppMethodBeat.o(27632);
  }
  
  public final void show()
  {
    AppMethodBeat.i(27629);
    com.tencent.mm.kernel.g.RM();
    this.lpe = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.ikj);
    if ((this.lpe != null) && ((int)this.lpe.euF <= 0))
    {
      ab.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", new Object[] { this.ikj });
      com.tencent.mm.kernel.g.RM();
      this.lpe = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().ars(this.ikj);
    }
    if ((this.lpe != null) && ((int)this.lpe.euF > 0))
    {
      ab.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
      if (this.lpe == null)
      {
        ab.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
        kw(-1);
        AppMethodBeat.o(27629);
        return;
      }
      localObject = this.lpe.field_username;
      if (!this.lpe.dwz())
      {
        if (((com.tencent.mm.api.j)com.tencent.mm.kernel.g.E(com.tencent.mm.api.j.class)).dk((String)localObject))
        {
          Context localContext = this.mContext;
          this.mContext.getString(2131297087);
          this.gsr = h.b(localContext, this.mContext.getString(2131306019), true, null);
          amh((String)localObject);
          AppMethodBeat.o(27629);
          return;
        }
        localObject = BitmapFactory.decodeResource(this.mContext.getResources(), 2130838470);
        if (((this.mContext instanceof MMActivity)) && (g.a(((MMActivity)this.mContext).getController(), (Bitmap)localObject, this.mContext.getResources().getString(2131306024), new b.5(this)) == null))
        {
          ab.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
          kw(-1);
        }
        AppMethodBeat.o(27629);
        return;
      }
      if (com.tencent.mm.n.a.je(this.lpe.field_type))
      {
        h.bO(this.mContext, this.mContext.getResources().getString(2131306022));
        kw(-2);
        AppMethodBeat.o(27629);
        return;
      }
      T(this.lpe);
      AppMethodBeat.o(27629);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(27629);
      return;
    }
    Object localObject = this.mContext;
    this.mContext.getString(2131297087);
    this.gsr = h.b((Context)localObject, this.mContext.getString(2131306019), true, new b.1(this));
    amh(this.ikj);
    AppMethodBeat.o(27629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */