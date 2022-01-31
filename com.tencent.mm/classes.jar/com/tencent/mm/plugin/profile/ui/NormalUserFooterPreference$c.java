package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.bh.d;
import com.tencent.mm.h.b.a.n;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.a;
import java.util.LinkedList;
import junit.framework.Assert;

class NormalUserFooterPreference$c
  extends NormalUserFooterPreference.a
{
  public NormalUserFooterPreference$c(NormalUserFooterPreference paramNormalUserFooterPreference)
  {
    super(paramNormalUserFooterPreference);
  }
  
  protected final void Fj()
  {
    super.Fj();
  }
  
  protected void bsI()
  {
    boolean bool;
    if (!s.hU(NormalUserFooterPreference.a(this.mYC).field_username))
    {
      bool = true;
      Assert.assertTrue(bool);
      NormalUserFooterPreference.r(this.mYC).setVisibility(8);
      NormalUserFooterPreference.s(this.mYC).setVisibility(8);
      if (!NormalUserFooterPreference.d(this.mYC)) {
        break label182;
      }
      NormalUserFooterPreference.D(this.mYC).setOnClickListener(new NormalUserFooterPreference.c.1(this));
      if (!com.tencent.mm.n.a.gR(NormalUserFooterPreference.a(this.mYC).field_type)) {
        break label167;
      }
      NormalUserFooterPreference.D(this.mYC).setVisibility(0);
    }
    for (;;)
    {
      NormalUserFooterPreference.t(this.mYC).setVisibility(8);
      NormalUserFooterPreference.f(this.mYC).setVisibility(8);
      NormalUserFooterPreference.g(this.mYC).setVisibility(8);
      NormalUserFooterPreference.h(this.mYC).setVisibility(8);
      NormalUserFooterPreference.q(this.mYC).setVisibility(8);
      return;
      bool = false;
      break;
      label167:
      NormalUserFooterPreference.D(this.mYC).setVisibility(8);
    }
    label182:
    NormalUserFooterPreference.t(this.mYC).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (NormalUserFooterPreference.b(NormalUserFooterPreference.c.this.mYC).getIntent() != null)
        {
          paramAnonymousView = NormalUserFooterPreference.b(NormalUserFooterPreference.c.this.mYC).getIntent().getStringExtra("key_ww_add_session_id");
          if (!bk.bl(paramAnonymousView))
          {
            n localn = new n();
            localn.ciW = paramAnonymousView;
            localn.ciX = 0L;
            localn.ciZ = 1L;
            localn.QX();
          }
        }
        NormalUserFooterPreference.c.this.bsN();
        if (NormalUserFooterPreference.E(NormalUserFooterPreference.c.this.mYC) != 0) {
          h.nFQ.f(11263, new Object[] { Integer.valueOf(NormalUserFooterPreference.E(NormalUserFooterPreference.c.this.mYC)), NormalUserFooterPreference.a(NormalUserFooterPreference.c.this.mYC).field_username });
        }
      }
    });
    if (!com.tencent.mm.n.a.gR(NormalUserFooterPreference.a(this.mYC).field_type))
    {
      NormalUserFooterPreference.t(this.mYC).setVisibility(0);
      NormalUserFooterPreference.f(this.mYC).setVisibility(8);
      NormalUserFooterPreference.g(this.mYC).setVisibility(8);
      NormalUserFooterPreference.h(this.mYC).setVisibility(8);
      if (NormalUserFooterPreference.a(this.mYC).Bg()) {
        NormalUserFooterPreference.q(this.mYC).setVisibility(0);
      }
    }
    else
    {
      NormalUserFooterPreference.t(this.mYC).setVisibility(8);
      NormalUserFooterPreference.f(this.mYC).setVisibility(0);
      if ((!this.mYC.bsF()) && (!NormalUserFooterPreference.a(this.mYC).field_username.equals(q.Gj())) && (!s.hU(NormalUserFooterPreference.a(this.mYC).field_username)) && (!s.hN(NormalUserFooterPreference.a(this.mYC).field_username)) && (!ad.aaU(NormalUserFooterPreference.a(this.mYC).field_username)) && (!s.hj(NormalUserFooterPreference.a(this.mYC).field_username))) {
        NormalUserFooterPreference.h(this.mYC).setVisibility(0);
      }
      for (;;)
      {
        au.Hx();
        if (!c.Fw().abo(NormalUserFooterPreference.a(this.mYC).field_username)) {
          break;
        }
        NormalUserFooterPreference.k(this.mYC).setVisibility(0);
        NormalUserFooterPreference.a(this.mYC, NormalUserFooterPreference.a(this.mYC).getSource());
        break;
        NormalUserFooterPreference.h(this.mYC).setVisibility(8);
      }
    }
    NormalUserFooterPreference.q(this.mYC).setVisibility(8);
  }
  
  protected final void bsN()
  {
    if ((int)NormalUserFooterPreference.a(this.mYC).dBe == 0)
    {
      au.Hx();
      if (c.Fw().W(NormalUserFooterPreference.a(this.mYC)) != -1)
      {
        localObject1 = this.mYC;
        au.Hx();
        NormalUserFooterPreference.a((NormalUserFooterPreference)localObject1, c.Fw().abl(NormalUserFooterPreference.a(this.mYC).field_username));
      }
    }
    Object localObject2;
    Object localObject3;
    if ((NormalUserFooterPreference.F(this.mYC)) || (NormalUserFooterPreference.l(this.mYC) == 12))
    {
      y.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.G(this.mYC) + " qqReamrk " + NormalUserFooterPreference.H(this.mYC));
      if ((NormalUserFooterPreference.G(this.mYC) != 0L) && (NormalUserFooterPreference.H(this.mYC) != null) && (!NormalUserFooterPreference.H(this.mYC).equals("")))
      {
        localObject1 = com.tencent.mm.plugin.account.b.getQQListStg().cr(NormalUserFooterPreference.G(this.mYC));
        if (localObject1 == null)
        {
          localObject1 = new com.tencent.mm.plugin.account.friend.a.ao();
          ((com.tencent.mm.plugin.account.friend.a.ao)localObject1).nickname = "";
          ((com.tencent.mm.plugin.account.friend.a.ao)localObject1).fgW = NormalUserFooterPreference.G(this.mYC);
          ((com.tencent.mm.plugin.account.friend.a.ao)localObject1).fhe = NormalUserFooterPreference.H(this.mYC);
          ((com.tencent.mm.plugin.account.friend.a.ao)localObject1).username = NormalUserFooterPreference.a(this.mYC).field_username;
          ((com.tencent.mm.plugin.account.friend.a.ao)localObject1).Xo();
          com.tencent.mm.plugin.account.b.getQQListStg().a((com.tencent.mm.plugin.account.friend.a.ao)localObject1);
        }
      }
      else
      {
        localObject2 = NormalUserFooterPreference.b(this.mYC).getIntent().getStringExtra("Contact_Mobile_MD5");
        localObject1 = NormalUserFooterPreference.b(this.mYC).getIntent().getStringExtra("Contact_full_Mobile_MD5");
        localObject2 = bk.pm((String)localObject2);
        localObject1 = bk.pm((String)localObject1);
        if ((!((String)localObject2).equals("")) || (!((String)localObject1).equals("")))
        {
          localObject3 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI((String)localObject2);
          if (localObject3 != null) {
            break label931;
          }
          localObject3 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI((String)localObject1);
          localObject2 = localObject1;
        }
      }
    }
    label931:
    for (Object localObject1 = localObject3;; localObject1 = localObject3)
    {
      if (localObject1 != null) {
        com.tencent.mm.plugin.account.b.getAddrUploadStg().a((String)localObject2, (com.tencent.mm.plugin.account.friend.a.a)localObject1);
      }
      localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.mYC.mContext, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          if (paramAnonymousBoolean1)
          {
            NormalUserFooterPreference.c.this.mYC.ebu.bV("hide_btn");
            NormalUserFooterPreference.c.this.mYC.ebu.doNotify();
            NormalUserFooterPreference.v(NormalUserFooterPreference.c.this.mYC);
            NormalUserFooterPreference.c.a(NormalUserFooterPreference.c.this);
          }
          for (;;)
          {
            if ((paramAnonymousBoolean1) || (paramAnonymousBoolean2))
            {
              paramAnonymousString1 = NormalUserFooterPreference.b(NormalUserFooterPreference.c.this.mYC).getIntent();
              int i = paramAnonymousString1.getIntExtra("search_kvstat_scene", 0);
              int j = paramAnonymousString1.getIntExtra("search_kvstat_position", 0);
              if ((i > 0) && (j > 0)) {
                h.nFQ.f(10991, new Object[] { Integer.valueOf(i), Integer.valueOf(6), Integer.valueOf(j) });
              }
            }
            return;
            if (paramAnonymousBoolean2) {
              d.RY().du(paramAnonymousString1, 2);
            } else {
              y.e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = " + paramAnonymousString1);
            }
          }
        }
      });
      localObject3 = new LinkedList();
      ((LinkedList)localObject3).add(Integer.valueOf(NormalUserFooterPreference.l(this.mYC)));
      localObject1 = NormalUserFooterPreference.b(this.mYC).getIntent().getStringExtra("source_from_user_name");
      String str = NormalUserFooterPreference.b(this.mYC).getIntent().getStringExtra("source_from_nick_name");
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).sbK = ((String)localObject1);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).sbL = str;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).sbG = new NormalUserFooterPreference.c.4(this, (String)localObject1, str);
      str = NormalUserFooterPreference.b(this.mYC).getIntent().getStringExtra("room_name");
      localObject1 = NormalUserFooterPreference.b(this.mYC).getIntent().getStringExtra(e.a.uHO);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        y.i("MicroMsg.NormalUserFooterPreference", "add contact case 1:%s", new Object[] { localObject1 });
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).WA((String)localObject1);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).b(NormalUserFooterPreference.a(this.mYC).field_username, "", (LinkedList)localObject3);
        return;
        ((com.tencent.mm.plugin.account.friend.a.ao)localObject1).fgW = NormalUserFooterPreference.G(this.mYC);
        ((com.tencent.mm.plugin.account.friend.a.ao)localObject1).fhe = NormalUserFooterPreference.H(this.mYC);
        ((com.tencent.mm.plugin.account.friend.a.ao)localObject1).username = NormalUserFooterPreference.a(this.mYC).field_username;
        ((com.tencent.mm.plugin.account.friend.a.ao)localObject1).Xo();
        com.tencent.mm.plugin.account.b.getQQListStg().a(NormalUserFooterPreference.G(this.mYC), (com.tencent.mm.plugin.account.friend.a.ao)localObject1);
        break;
        if ((NormalUserFooterPreference.l(this.mYC) != 58) && (NormalUserFooterPreference.l(this.mYC) != 59) && (NormalUserFooterPreference.l(this.mYC) != 60)) {
          break;
        }
        com.tencent.mm.plugin.account.b.getGoogleFriendStorage().ac(NormalUserFooterPreference.a(this.mYC).field_username, 1);
        break;
      }
      if (TextUtils.isEmpty(str))
      {
        y.i("MicroMsg.NormalUserFooterPreference", "add contact case 2, %s", new Object[] { NormalUserFooterPreference.a(this.mYC).cCQ });
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).WA(NormalUserFooterPreference.a(this.mYC).cCQ);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).e(NormalUserFooterPreference.a(this.mYC).field_username, (LinkedList)localObject3);
        return;
      }
      if (!TextUtils.isEmpty(((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).kzG))
      {
        y.i("MicroMsg.NormalUserFooterPreference", "add contact case 3, %s", new Object[] { NormalUserFooterPreference.a(this.mYC).cCQ });
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).WA(NormalUserFooterPreference.a(this.mYC).cCQ);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).b(NormalUserFooterPreference.a(this.mYC).field_username, str, (LinkedList)localObject3);
        return;
      }
      au.Hx();
      localObject1 = c.Fw().abl(NormalUserFooterPreference.a(this.mYC).field_username);
      if (localObject1 != null) {}
      for (localObject1 = bk.aM(((com.tencent.mm.h.c.ao)localObject1).cCQ, "");; localObject1 = "")
      {
        y.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { NormalUserFooterPreference.a(this.mYC).field_username, str, localObject1 });
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).WA((String)localObject1);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).b(NormalUserFooterPreference.a(this.mYC).field_username, str, (LinkedList)localObject3);
        return;
      }
      am.a.dVy.a(NormalUserFooterPreference.a(this.mYC).field_username, str, new NormalUserFooterPreference.c.5(this, (com.tencent.mm.pluginsdk.ui.applet.a)localObject2, str, (LinkedList)localObject3));
      return;
    }
  }
  
  protected void onDetach()
  {
    super.onDetach();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c
 * JD-Core Version:    0.7.0.1
 */