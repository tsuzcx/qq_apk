package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;

abstract class NormalUserFooterPreference$a
  implements com.tencent.mm.ai.f
{
  boolean isDeleteCancel = false;
  private com.tencent.mm.ui.widget.b.d pxp = null;
  
  public NormalUserFooterPreference$a(NormalUserFooterPreference paramNormalUserFooterPreference) {}
  
  final void Au(String paramString)
  {
    NormalUserFooterPreference.a(this.pCe).Ny();
    if (ad.arf(paramString))
    {
      ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.a.class)).wg(paramString);
      ao.a.flI.pm(paramString);
      bf.a(paramString, new NormalUserFooterPreference.a.9(this));
      aw.aaz();
      com.tencent.mm.model.c.YA().b(paramString, NormalUserFooterPreference.a(this.pCe));
      aw.aaz();
      com.tencent.mm.model.c.YF().arF(paramString);
      com.tencent.mm.bi.c.e(0L, paramString);
      com.tencent.mm.bi.c.e(0L, NormalUserFooterPreference.a(this.pCe).field_encryptUsername);
      switch (NormalUserFooterPreference.l(this.pCe))
      {
      default: 
        label180:
        if (NormalUserFooterPreference.l(this.pCe) == 9)
        {
          ab.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + NormalUserFooterPreference.a(this.pCe).getSource());
          switch (NormalUserFooterPreference.a(this.pCe).getSource())
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (NormalUserFooterPreference.o(this.pCe) != 0) {
        break label492;
      }
      paramString = new Intent();
      paramString.addFlags(67108864);
      com.tencent.mm.plugin.profile.b.gmO.p(paramString, this.pCe.mContext);
      return;
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new com.tencent.mm.az.c(paramString));
      break;
      Object localObject = com.tencent.mm.plugin.account.a.getQQListStg().xn(paramString);
      if (localObject == null) {
        break label180;
      }
      ((ao)localObject).gyF = 1;
      com.tencent.mm.plugin.account.a.getQQListStg().a(((ao)localObject).gyE, (ao)localObject);
      break label180;
      localObject = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(paramString);
      if ((localObject != null) && (!bo.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject).gwO)))
      {
        ((com.tencent.mm.plugin.account.friend.a.a)localObject).status = 1;
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(((com.tencent.mm.plugin.account.friend.a.a)localObject).Al(), (com.tencent.mm.plugin.account.friend.a.a)localObject);
      }
      w.J(this.pCe.mContext, paramString);
      break label180;
      w.J(this.pCe.mContext, paramString);
      break label180;
      localObject = com.tencent.mm.plugin.account.a.getFacebookFrdStg().xf(paramString);
      if (localObject == null) {
        break label180;
      }
      ((com.tencent.mm.plugin.account.friend.a.g)localObject).status = 100;
      com.tencent.mm.plugin.account.a.getFacebookFrdStg().a((com.tencent.mm.plugin.account.friend.a.g)localObject);
      break label180;
      com.tencent.mm.plugin.account.a.getGoogleFriendStorage().ak(paramString, 2);
      break label180;
      ab.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
      w.J(this.pCe.mContext, paramString);
    }
    label492:
    NormalUserFooterPreference.b(this.pCe).setResult(-1, NormalUserFooterPreference.b(this.pCe).getIntent().putExtra("_delete_ok_", true));
    ((Activity)this.pCe.mContext).finish();
  }
  
  protected final void F(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      return;
    }
    NormalUserFooterPreference.b(this.pCe).addIconOptionMenu(0, 2130839668, new NormalUserFooterPreference.a.11(this, paramBoolean1, paramBoolean2));
  }
  
  final void Xg(String paramString)
  {
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.pCe));
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", NormalUserFooterPreference.a(this.pCe).field_username);
    paramString.putExtra("Contact_Nick", NormalUserFooterPreference.a(this.pCe).field_nickname);
    paramString.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(this.pCe).field_conRemark);
    com.tencent.mm.plugin.profile.b.gmO.n(paramString, this.pCe.mContext);
  }
  
  protected void Yj()
  {
    ccx();
    ccz();
    NormalUserFooterPreference.f(this.pCe).setOnClickListener(new NormalUserFooterPreference.a.12(this));
    NormalUserFooterPreference.g(this.pCe).setOnClickListener(new NormalUserFooterPreference.a.13(this));
    NormalUserFooterPreference.h(this.pCe).setOnClickListener(new NormalUserFooterPreference.a.14(this));
    NormalUserFooterPreference.i(this.pCe).setOnClickListener(new NormalUserFooterPreference.a.15(this));
    NormalUserFooterPreference.j(this.pCe).setOnClickListener(new NormalUserFooterPreference.a.16(this));
    NormalUserFooterPreference.k(this.pCe).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23694);
        NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
        AppMethodBeat.o(23694);
      }
    });
  }
  
  final void ccA()
  {
    this.pxp = new com.tencent.mm.ui.widget.b.d(NormalUserFooterPreference.b(this.pCe), 1, false);
    this.pxp.sao = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(23679);
        paramAnonymousl.aw(2, 2131296952, 2131231978);
        paramAnonymousl.aw(1, 2131296954, 2131231979);
        AppMethodBeat.o(23679);
      }
    };
    this.pxp.sap = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(23680);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(23680);
          return;
          NormalUserFooterPreference.a.this.pCe.ccv();
          AppMethodBeat.o(23680);
          return;
          NormalUserFooterPreference.a.this.pCe.ccw();
        }
      }
    };
    this.pxp.crd();
  }
  
  protected final void ccB()
  {
    com.tencent.mm.plugin.report.service.h.qsU.e(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.a(this.pCe).field_username });
    String str = NormalUserFooterPreference.a(this.pCe).field_username;
    if (t.nR(str))
    {
      NormalUserFooterPreference.a(this.pCe).Ny();
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new com.tencent.mm.az.c(str));
      aw.aaz();
      com.tencent.mm.model.c.YA().arC(str);
      aw.aaz();
      com.tencent.mm.model.c.YJ().pa(str);
      return;
    }
    this.isDeleteCancel = false;
    Object localObject = this.pCe.mContext;
    this.pCe.mContext.getString(2131297087);
    p localp = com.tencent.mm.ui.base.h.b((Context)localObject, this.pCe.mContext.getString(2131297112), true, new NormalUserFooterPreference.a.6(this));
    if (!this.isDeleteCancel) {}
    for (localObject = com.tencent.mm.pluginsdk.wallet.f.amZ(NormalUserFooterPreference.a(this.pCe).field_username);; localObject = null)
    {
      if (!bo.isNullOrNil((String)localObject))
      {
        localp.dismiss();
        com.tencent.mm.ui.base.h.a(this.pCe.mContext, false, this.pCe.mContext.getString(2131305044, new Object[] { localObject }), null, this.pCe.mContext.getString(2131300537), this.pCe.mContext.getString(2131298948), new NormalUserFooterPreference.a.7(this), new NormalUserFooterPreference.a.8(this, localp, str), -1, 2131689667);
        return;
      }
      Au(str);
      return;
    }
  }
  
  protected abstract void ccx();
  
  protected final void ccy()
  {
    NormalUserFooterPreference.b(this.pCe).addIconOptionMenu(0, 2130839668, new NormalUserFooterPreference.a.1(this));
  }
  
  protected void ccz()
  {
    if (NormalUserFooterPreference.d(this.pCe)) {
      NormalUserFooterPreference.b(this.pCe).showOptionMenu(false);
    }
    do
    {
      do
      {
        return;
      } while (r.Zn().equals(NormalUserFooterPreference.a(this.pCe).field_username));
      if (!com.tencent.mm.n.a.je(NormalUserFooterPreference.a(this.pCe).field_type)) {
        break;
      }
    } while (t.ow(NormalUserFooterPreference.a(this.pCe).field_username));
    ccy();
    return;
    F(false, false);
  }
  
  protected void onDetach() {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    ab.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramm.getType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
 * JD-Core Version:    0.7.0.1
 */