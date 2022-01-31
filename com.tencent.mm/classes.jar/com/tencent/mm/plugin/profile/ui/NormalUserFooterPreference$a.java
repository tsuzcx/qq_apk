package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.MenuItem;
import android.widget.Button;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.model.af;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.d;

abstract class NormalUserFooterPreference$a
  implements f
{
  boolean isDeleteCancel = false;
  private d mYD = null;
  
  public NormalUserFooterPreference$a(NormalUserFooterPreference paramNormalUserFooterPreference) {}
  
  protected final void B(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      return;
    }
    NormalUserFooterPreference.b(this.mYC).addIconOptionMenu(0, R.g.mm_title_btn_menu, new NormalUserFooterPreference.a.11(this, paramBoolean1, paramBoolean2));
  }
  
  protected void Fj()
  {
    bsI();
    bsK();
    NormalUserFooterPreference.f(this.mYC).setOnClickListener(new NormalUserFooterPreference.a.12(this));
    NormalUserFooterPreference.g(this.mYC).setOnClickListener(new NormalUserFooterPreference.a.13(this));
    NormalUserFooterPreference.h(this.mYC).setOnClickListener(new NormalUserFooterPreference.a.14(this));
    NormalUserFooterPreference.i(this.mYC).setOnClickListener(new NormalUserFooterPreference.a.15(this));
    NormalUserFooterPreference.j(this.mYC).setOnClickListener(new NormalUserFooterPreference.a.16(this));
    NormalUserFooterPreference.k(this.mYC).setOnClickListener(new NormalUserFooterPreference.a.17(this));
  }
  
  final void KW(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.mYC));
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", NormalUserFooterPreference.a(this.mYC).field_username);
    paramString.putExtra("Contact_Nick", NormalUserFooterPreference.a(this.mYC).field_nickname);
    paramString.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(this.mYC).field_conRemark);
    com.tencent.mm.plugin.profile.a.eUR.o(paramString, this.mYC.mContext);
  }
  
  protected abstract void bsI();
  
  protected final void bsJ()
  {
    NormalUserFooterPreference.b(this.mYC).addIconOptionMenu(0, R.g.mm_title_btn_menu, new NormalUserFooterPreference.a.1(this));
  }
  
  protected void bsK()
  {
    if (NormalUserFooterPreference.d(this.mYC)) {
      NormalUserFooterPreference.b(this.mYC).showOptionMenu(false);
    }
    do
    {
      do
      {
        return;
      } while (q.Gj().equals(NormalUserFooterPreference.a(this.mYC).field_username));
      if (!com.tencent.mm.n.a.gR(NormalUserFooterPreference.a(this.mYC).field_type)) {
        break;
      }
    } while (s.hN(NormalUserFooterPreference.a(this.mYC).field_username));
    bsJ();
    return;
    B(false, false);
  }
  
  final void bsL()
  {
    this.mYD = new d(NormalUserFooterPreference.b(this.mYC), 1, false);
    this.mYD.phH = new NormalUserFooterPreference.a.4(this);
    this.mYD.phI = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          return;
        case 1: 
          NormalUserFooterPreference.a.this.mYC.bsG();
          return;
        }
        NormalUserFooterPreference.a.this.mYC.bsH();
      }
    };
    this.mYD.cfU();
  }
  
  protected final void bsM()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.a(this.mYC).field_username });
    String str = NormalUserFooterPreference.a(this.mYC).field_username;
    if (s.hi(str))
    {
      NormalUserFooterPreference.a(this.mYC).AI();
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.b(str));
      au.Hx();
      com.tencent.mm.model.c.Fw().abr(str);
      au.Hx();
      com.tencent.mm.model.c.FF().it(str);
      return;
    }
    this.isDeleteCancel = false;
    Object localObject = this.mYC.mContext;
    this.mYC.mContext.getString(R.l.app_tip);
    p localp = com.tencent.mm.ui.base.h.b((Context)localObject, this.mYC.mContext.getString(R.l.app_waiting), true, new NormalUserFooterPreference.a.6(this));
    if (!this.isDeleteCancel) {}
    for (localObject = e.Xe(NormalUserFooterPreference.a(this.mYC).field_username);; localObject = null)
    {
      if (!bk.bl((String)localObject))
      {
        localp.dismiss();
        com.tencent.mm.ui.base.h.a(this.mYC.mContext, false, this.mYC.mContext.getString(R.l.wallet_delete_contact_note, new Object[] { localObject }), null, this.mYC.mContext.getString(R.l.goto_conversation), this.mYC.mContext.getString(R.l.delete_contact), new NormalUserFooterPreference.a.7(this), new NormalUserFooterPreference.a.8(this, localp, str), -1, R.e.alert_btn_color_warn);
        return;
      }
      sz(str);
      return;
    }
  }
  
  protected void onDetach() {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramm.getType());
  }
  
  final void sz(String paramString)
  {
    Object localObject1 = null;
    NormalUserFooterPreference.a(this.mYC).AI();
    if (ad.aaU(paramString))
    {
      ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.a.class)).oO(paramString);
      am.a.dVy.iD(paramString);
      label43:
      com.tencent.mm.model.bd.a(paramString, new NormalUserFooterPreference.a.9(this));
      au.Hx();
      com.tencent.mm.model.c.Fw().a(paramString, NormalUserFooterPreference.a(this.mYC));
      au.Hx();
      com.tencent.mm.model.c.FB().abu(paramString);
      com.tencent.mm.bh.c.g(0L, paramString);
      com.tencent.mm.bh.c.g(0L, NormalUserFooterPreference.a(this.mYC).field_encryptUsername);
    }
    label268:
    Object localObject2;
    switch (NormalUserFooterPreference.l(this.mYC))
    {
    default: 
    case 12: 
    case 13: 
    case 10: 
    case 31: 
      for (;;)
      {
        if (NormalUserFooterPreference.l(this.mYC) == 9) {
          y.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + NormalUserFooterPreference.a(this.mYC).getSource());
        }
        switch (NormalUserFooterPreference.a(this.mYC).getSource())
        {
        case 11: 
        case 12: 
        default: 
          if (NormalUserFooterPreference.o(this.mYC) != 0) {
            break label564;
          }
          paramString = new Intent();
          paramString.addFlags(67108864);
          com.tencent.mm.plugin.profile.a.eUR.q(paramString, this.mYC.mContext);
          return;
          au.Hx();
          com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.b(paramString));
          break label43;
          localObject1 = com.tencent.mm.plugin.account.b.getQQListStg().pR(paramString);
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.account.friend.a.ao)localObject1).fgX = 1;
            com.tencent.mm.plugin.account.b.getQQListStg().a(((com.tencent.mm.plugin.account.friend.a.ao)localObject1).fgW, (com.tencent.mm.plugin.account.friend.a.ao)localObject1);
            continue;
            localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(paramString);
            if ((localObject1 != null) && (!bk.bl(((com.tencent.mm.plugin.account.friend.a.a)localObject1).ffg)))
            {
              ((com.tencent.mm.plugin.account.friend.a.a)localObject1).status = 1;
              com.tencent.mm.plugin.account.b.getAddrUploadStg().a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wv(), (com.tencent.mm.plugin.account.friend.a.a)localObject1);
            }
            w.F(this.mYC.mContext, paramString);
            continue;
            w.F(this.mYC.mContext, paramString);
            continue;
            localObject2 = com.tencent.mm.plugin.account.b.getFacebookFrdStg();
            String str = "select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + paramString + "\"";
            localObject2 = ((com.tencent.mm.plugin.account.friend.a.h)localObject2).dXo.a(str, null, 2);
            if (localObject2 != null) {
              break label499;
            }
            label478:
            if (localObject1 != null)
            {
              ((com.tencent.mm.plugin.account.friend.a.g)localObject1).status = 100;
              com.tencent.mm.plugin.account.b.getFacebookFrdStg().a((com.tencent.mm.plugin.account.friend.a.g)localObject1);
            }
          }
          break;
        }
      }
      label499:
      if (((Cursor)localObject2).moveToFirst())
      {
        localObject1 = new com.tencent.mm.plugin.account.friend.a.g();
        ((com.tencent.mm.plugin.account.friend.a.g)localObject1).d((Cursor)localObject2);
      }
      break;
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      break label478;
      com.tencent.mm.plugin.account.b.getGoogleFriendStorage().ac(paramString, 2);
      break;
      y.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
      w.F(this.mYC.mContext, paramString);
      break label268;
      label564:
      NormalUserFooterPreference.b(this.mYC).setResult(-1, NormalUserFooterPreference.b(this.mYC).getIntent().putExtra("_delete_ok_", true));
      ((Activity)this.mYC.mContext).finish();
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
 * JD-Core Version:    0.7.0.1
 */