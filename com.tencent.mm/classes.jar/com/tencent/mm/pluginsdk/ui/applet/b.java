package com.tencent.mm.pluginsdk.ui.applet;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.api.i;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

public final class b
  implements d.a, a.a, o
{
  private String dFW;
  ProgressDialog faz;
  private int fzn;
  String hcm;
  ad jgl;
  Context mContext;
  private n sbQ;
  com.tencent.mm.ui.widget.a.c sbR;
  com.tencent.mm.ah.f sbS = null;
  private boolean sbT = true;
  
  public b(Context paramContext, String paramString1, int paramInt, n paramn, String paramString2)
  {
    this(paramContext, paramString1, paramInt, paramn, true, paramString2);
  }
  
  public b(Context paramContext, String paramString1, int paramInt, n paramn, boolean paramBoolean, String paramString2)
  {
    this.mContext = paramContext;
    this.hcm = paramString1;
    this.fzn = paramInt;
    this.sbQ = paramn;
    this.sbT = paramBoolean;
    this.dFW = paramString2;
  }
  
  public b(Context paramContext, String paramString, n paramn)
  {
    this(paramContext, paramString, 0, paramn, true, "");
  }
  
  private void WB(String paramString)
  {
    y.i("MicroMsg.AddContactDialog", "searchContact %s", new Object[] { paramString });
    if (this.sbS == null) {
      this.sbS = new b.4(this);
    }
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(106, this.sbS);
    paramString = new com.tencent.mm.plugin.messenger.a.f(paramString);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
  }
  
  final void Q(ad paramad)
  {
    if (paramad == null)
    {
      y.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
      hK(-1);
    }
    do
    {
      return;
      String str = this.mContext.getString(R.l.wv_follow_brand_account);
      Object localObject2 = com.tencent.mm.ag.b.a(paramad.field_username, false, -1);
      if (localObject2 == null) {
        com.tencent.mm.ag.o.JQ().a(this);
      }
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (paramad.cua()) {
          localObject1 = com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject2, false, ((Bitmap)localObject2).getWidth() / 2);
        }
      }
      localObject2 = paramad.field_nickname;
      this.sbR = null;
      if ((this.mContext instanceof MMActivity))
      {
        if (!this.sbT)
        {
          R(paramad);
          return;
        }
        s locals = ((MMActivity)this.mContext).mController;
        int i = R.l.contact_info_biz_add;
        paramad.cua();
        this.sbR = g.a(locals, str, (Bitmap)localObject1, (String)localObject2, "", i, new b.2(this, paramad));
      }
    } while (this.sbR != null);
    y.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
    hK(-1);
  }
  
  final void R(ad paramad)
  {
    if (this.faz != null) {
      this.faz.dismiss();
    }
    Object localObject = this.mContext;
    this.mContext.getString(R.l.app_tip);
    this.faz = h.b((Context)localObject, this.mContext.getString(R.l.wv_following), true, null);
    localObject = new a(this.mContext, this);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(this.fzn));
    ((a)localObject).a(paramad.field_username, localLinkedList, this.dFW);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (this.faz != null) {
      this.faz.dismiss();
    }
    if (paramBoolean1)
    {
      this.jgl.AH();
      com.tencent.mm.kernel.g.DQ();
      ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().a(this.jgl.field_username, this.jgl);
      h.bC(this.mContext, this.mContext.getResources().getString(R.l.wv_has_follow));
      hK(1);
      return;
    }
    hK(-1);
  }
  
  final void hK(int paramInt)
  {
    if (this.sbQ != null) {
      this.sbQ.lg(paramInt);
    }
  }
  
  public final void kk(String paramString)
  {
    int j = 1;
    int i;
    if (this.jgl != null) {
      if ((this.jgl.field_username != null) && (this.jgl.field_username.equals(paramString)))
      {
        i = 1;
        if ((this.jgl.vk() == null) || (!this.jgl.vk().equals(paramString))) {
          break label73;
        }
        label59:
        if ((i != 0) || (j != 0)) {
          break label96;
        }
      }
    }
    label73:
    label96:
    while ((this.sbR == null) || (!this.sbR.isShowing())) {
      do
      {
        return;
        i = 0;
        break;
        j = 0;
        break label59;
      } while ((this.hcm == null) || (!this.hcm.equals(paramString)));
    }
    ai.d(new Runnable()
    {
      public final void run()
      {
        ImageView localImageView = (ImageView)b.this.sbR.getContentView().findViewById(R.h.confirm_dialog_thumb_iv);
        if (localImageView != null)
        {
          Bitmap localBitmap2 = com.tencent.mm.ag.b.a(b.this.jgl.field_username, false, -1);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 != null)
          {
            localBitmap1 = localBitmap2;
            if (b.this.jgl.cua()) {
              localBitmap1 = com.tencent.mm.sdk.platformtools.c.a(localBitmap2, false, localBitmap2.getWidth() / 2);
            }
          }
          if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
          {
            localImageView.setImageBitmap(localBitmap1);
            localImageView.setVisibility(0);
          }
        }
      }
    });
  }
  
  public final void show()
  {
    com.tencent.mm.kernel.g.DQ();
    this.jgl = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(this.hcm);
    if ((this.jgl != null) && ((int)this.jgl.dBe <= 0))
    {
      y.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", new Object[] { this.hcm });
      com.tencent.mm.kernel.g.DQ();
      this.jgl = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abh(this.hcm);
    }
    if ((this.jgl != null) && ((int)this.jgl.dBe > 0))
    {
      y.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
      if (this.jgl == null)
      {
        y.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
        hK(-1);
      }
    }
    while (this.mContext == null)
    {
      do
      {
        return;
        localObject = this.jgl.field_username;
        if (this.jgl.cua()) {
          break;
        }
        if (((i)com.tencent.mm.kernel.g.r(i.class)).ca((String)localObject))
        {
          Context localContext = this.mContext;
          this.mContext.getString(R.l.app_tip);
          this.faz = h.b(localContext, this.mContext.getString(R.l.wv_following), true, null);
          WB((String)localObject);
          return;
        }
        localObject = BitmapFactory.decodeResource(this.mContext.getResources(), R.g.confirm_dialog_failweb);
      } while ((!(this.mContext instanceof MMActivity)) || (g.a(((MMActivity)this.mContext).mController, (Bitmap)localObject, this.mContext.getResources().getString(R.l.wv_is_not_biz_contact), new b.5(this)) != null));
      y.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
      hK(-1);
      return;
      if (com.tencent.mm.n.a.gR(this.jgl.field_type))
      {
        h.bC(this.mContext, this.mContext.getResources().getString(R.l.wv_has_follow));
        hK(-2);
        return;
      }
      Q(this.jgl);
      return;
    }
    Object localObject = this.mContext;
    this.mContext.getString(R.l.app_tip);
    this.faz = h.b((Context)localObject, this.mContext.getString(R.l.wv_following), true, new b.1(this));
    WB(this.hcm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */