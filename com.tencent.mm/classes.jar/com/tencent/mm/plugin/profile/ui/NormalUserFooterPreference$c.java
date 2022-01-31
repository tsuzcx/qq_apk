package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.b;
import java.util.LinkedList;
import junit.framework.Assert;

class NormalUserFooterPreference$c
  extends NormalUserFooterPreference.a
{
  public NormalUserFooterPreference$c(NormalUserFooterPreference paramNormalUserFooterPreference)
  {
    super(paramNormalUserFooterPreference);
  }
  
  private void ccD()
  {
    AppMethodBeat.i(23708);
    Object localObject2 = NormalUserFooterPreference.b(this.pCe).getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject1 = NormalUserFooterPreference.b(this.pCe).getIntent().getStringExtra("Contact_full_Mobile_MD5");
    String str = bo.nullAsNil((String)localObject2);
    localObject1 = bo.nullAsNil((String)localObject1);
    if ((!str.equals("")) || (!((String)localObject1).equals("")))
    {
      localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa(str);
      if (localObject2 != null) {
        break label113;
      }
      localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa((String)localObject1);
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(23708);
        return;
      }
      com.tencent.mm.plugin.account.a.getAddrUploadStg().a((String)localObject1, (com.tencent.mm.plugin.account.friend.a.a)localObject2);
      AppMethodBeat.o(23708);
      return;
      label113:
      localObject1 = str;
    }
  }
  
  protected final void Yj()
  {
    AppMethodBeat.i(23704);
    super.Yj();
    AppMethodBeat.o(23704);
  }
  
  protected final void ccC()
  {
    AppMethodBeat.i(23707);
    if ((int)NormalUserFooterPreference.a(this.pCe).euF == 0)
    {
      aw.aaz();
      if (c.YA().Z(NormalUserFooterPreference.a(this.pCe)) != -1)
      {
        localObject = this.pCe;
        aw.aaz();
        NormalUserFooterPreference.a((NormalUserFooterPreference)localObject, c.YA().arw(NormalUserFooterPreference.a(this.pCe).field_username));
      }
    }
    if ((NormalUserFooterPreference.F(this.pCe)) || (NormalUserFooterPreference.l(this.pCe) == 12))
    {
      ab.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.G(this.pCe) + " qqReamrk " + NormalUserFooterPreference.H(this.pCe));
      if ((NormalUserFooterPreference.G(this.pCe) != 0L) && (NormalUserFooterPreference.H(this.pCe) != null) && (!NormalUserFooterPreference.H(this.pCe).equals("")))
      {
        localObject = com.tencent.mm.plugin.account.a.getQQListStg().hn(NormalUserFooterPreference.G(this.pCe));
        if (localObject != null) {
          break label450;
        }
        localObject = new ao();
        ((ao)localObject).nickname = "";
        ((ao)localObject).gyE = NormalUserFooterPreference.G(this.pCe);
        ((ao)localObject).gyM = NormalUserFooterPreference.H(this.pCe);
        ((ao)localObject).username = NormalUserFooterPreference.a(this.pCe).field_username;
        ((ao)localObject).aqS();
        com.tencent.mm.plugin.account.a.getQQListStg().a((ao)localObject);
      }
    }
    com.tencent.mm.pluginsdk.ui.applet.a locala;
    LinkedList localLinkedList;
    String str;
    for (;;)
    {
      ccD();
      locala = new com.tencent.mm.pluginsdk.ui.applet.a(this.pCe.mContext, new NormalUserFooterPreference.c.3(this));
      localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(NormalUserFooterPreference.l(this.pCe)));
      localObject = NormalUserFooterPreference.b(this.pCe).getIntent().getStringExtra("source_from_user_name");
      str = NormalUserFooterPreference.b(this.pCe).getIntent().getStringExtra("source_from_nick_name");
      locala.hU((String)localObject, str);
      locala.vSN = new NormalUserFooterPreference.c.4(this, (String)localObject, str);
      str = NormalUserFooterPreference.b(this.pCe).getIntent().getStringExtra("room_name");
      localObject = NormalUserFooterPreference.b(this.pCe).getIntent().getStringExtra(e.b.yUZ);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      ab.i("MicroMsg.NormalUserFooterPreference", "add contact case 1:%s", new Object[] { localObject });
      locala.amg((String)localObject);
      locala.c(NormalUserFooterPreference.a(this.pCe).field_username, "", localLinkedList);
      AppMethodBeat.o(23707);
      return;
      label450:
      ((ao)localObject).gyE = NormalUserFooterPreference.G(this.pCe);
      ((ao)localObject).gyM = NormalUserFooterPreference.H(this.pCe);
      ((ao)localObject).username = NormalUserFooterPreference.a(this.pCe).field_username;
      ((ao)localObject).aqS();
      com.tencent.mm.plugin.account.a.getQQListStg().a(NormalUserFooterPreference.G(this.pCe), (ao)localObject);
      continue;
      if ((NormalUserFooterPreference.l(this.pCe) == 58) || (NormalUserFooterPreference.l(this.pCe) == 59) || (NormalUserFooterPreference.l(this.pCe) == 60)) {
        com.tencent.mm.plugin.account.a.getGoogleFriendStorage().ak(NormalUserFooterPreference.a(this.pCe).field_username, 1);
      }
    }
    if (TextUtils.isEmpty(str))
    {
      ab.i("MicroMsg.NormalUserFooterPreference", "add contact case 2, %s", new Object[] { NormalUserFooterPreference.a(this.pCe).dra });
      locala.amg(NormalUserFooterPreference.a(this.pCe).dra);
      locala.e(NormalUserFooterPreference.a(this.pCe).field_username, localLinkedList);
      AppMethodBeat.o(23707);
      return;
    }
    if (!TextUtils.isEmpty(locala.mVw))
    {
      ab.i("MicroMsg.NormalUserFooterPreference", "add contact case 3, %s", new Object[] { NormalUserFooterPreference.a(this.pCe).dra });
      locala.amg(NormalUserFooterPreference.a(this.pCe).dra);
      locala.c(NormalUserFooterPreference.a(this.pCe).field_username, str, localLinkedList);
      AppMethodBeat.o(23707);
      return;
    }
    aw.aaz();
    Object localObject = c.YA().arw(NormalUserFooterPreference.a(this.pCe).field_username);
    if (localObject != null) {}
    for (localObject = bo.bf(((aq)localObject).dra, "");; localObject = "")
    {
      ab.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { NormalUserFooterPreference.a(this.pCe).field_username, str, localObject });
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      locala.amg((String)localObject);
      locala.c(NormalUserFooterPreference.a(this.pCe).field_username, str, localLinkedList);
      AppMethodBeat.o(23707);
      return;
    }
    ao.a.flI.a(NormalUserFooterPreference.a(this.pCe).field_username, str, new NormalUserFooterPreference.c.5(this, locala, str, localLinkedList));
    AppMethodBeat.o(23707);
  }
  
  protected void ccx()
  {
    AppMethodBeat.i(23706);
    boolean bool;
    if (!t.oD(NormalUserFooterPreference.a(this.pCe).field_username))
    {
      bool = true;
      Assert.assertTrue(bool);
      NormalUserFooterPreference.r(this.pCe).setVisibility(8);
      NormalUserFooterPreference.s(this.pCe).setVisibility(8);
      if (!NormalUserFooterPreference.d(this.pCe)) {
        break label194;
      }
      NormalUserFooterPreference.D(this.pCe).setOnClickListener(new NormalUserFooterPreference.c.1(this));
      if (!com.tencent.mm.n.a.je(NormalUserFooterPreference.a(this.pCe).field_type)) {
        break label179;
      }
      NormalUserFooterPreference.D(this.pCe).setVisibility(0);
    }
    for (;;)
    {
      NormalUserFooterPreference.t(this.pCe).setVisibility(8);
      NormalUserFooterPreference.f(this.pCe).setVisibility(8);
      NormalUserFooterPreference.g(this.pCe).setVisibility(8);
      NormalUserFooterPreference.h(this.pCe).setVisibility(8);
      NormalUserFooterPreference.q(this.pCe).setVisibility(8);
      AppMethodBeat.o(23706);
      return;
      bool = false;
      break;
      label179:
      NormalUserFooterPreference.D(this.pCe).setVisibility(8);
    }
    label194:
    NormalUserFooterPreference.t(this.pCe).setOnClickListener(new NormalUserFooterPreference.c.2(this));
    if (!com.tencent.mm.n.a.je(NormalUserFooterPreference.a(this.pCe).field_type))
    {
      NormalUserFooterPreference.t(this.pCe).setVisibility(0);
      NormalUserFooterPreference.f(this.pCe).setVisibility(8);
      NormalUserFooterPreference.g(this.pCe).setVisibility(8);
      NormalUserFooterPreference.h(this.pCe).setVisibility(8);
      if (NormalUserFooterPreference.a(this.pCe).NW())
      {
        NormalUserFooterPreference.q(this.pCe).setVisibility(0);
        AppMethodBeat.o(23706);
      }
    }
    else
    {
      NormalUserFooterPreference.t(this.pCe).setVisibility(8);
      NormalUserFooterPreference.f(this.pCe).setVisibility(0);
      if ((!this.pCe.ccu()) && (!NormalUserFooterPreference.a(this.pCe).field_username.equals(r.Zn())) && (!t.oD(NormalUserFooterPreference.a(this.pCe).field_username)) && (!t.ow(NormalUserFooterPreference.a(this.pCe).field_username)) && (!ad.arf(NormalUserFooterPreference.a(this.pCe).field_username)) && (!t.nS(NormalUserFooterPreference.a(this.pCe).field_username))) {
        NormalUserFooterPreference.h(this.pCe).setVisibility(0);
      }
      for (;;)
      {
        aw.aaz();
        if (!c.YA().arz(NormalUserFooterPreference.a(this.pCe).field_username)) {
          break;
        }
        NormalUserFooterPreference.k(this.pCe).setVisibility(0);
        NormalUserFooterPreference.a(this.pCe, NormalUserFooterPreference.a(this.pCe).getSource());
        break;
        NormalUserFooterPreference.h(this.pCe).setVisibility(8);
      }
    }
    NormalUserFooterPreference.q(this.pCe).setVisibility(8);
    AppMethodBeat.o(23706);
  }
  
  protected void onDetach()
  {
    AppMethodBeat.i(23705);
    super.onDetach();
    AppMethodBeat.o(23705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c
 * JD-Core Version:    0.7.0.1
 */