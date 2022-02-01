package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.b.p;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.n.f;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactMoreInfoUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.plugin.fts.a.l
{
  private ProfileNormalItemView GYk;
  private ProfileNormalItemView GYl;
  private ProfileNormalItemView GYm;
  private ProfileNormalItemView GYn;
  private ProfileNormalItemView GYo;
  private ProfileNormalItemView GYp;
  private ProfileNormalItemView GYq;
  private ProfileNormalItemView GYr;
  private ProfileNormalItemView GYs;
  private String GYt;
  private String GYu;
  private String GYv;
  private String GYw;
  private long GYx;
  private String GYy;
  String GYz;
  private MMHandler handler;
  private String iSn;
  ah iXp;
  private String jaK;
  boolean jhU;
  private com.tencent.mm.storage.as uNk;
  
  public ContactMoreInfoUI()
  {
    AppMethodBeat.i(27031);
    this.GYz = null;
    this.jhU = false;
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(27031);
  }
  
  private boolean ag(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(27034);
    if (z.bcZ().equals(paramas.field_username))
    {
      bh.beI();
      paramas = (String)c.aHp().get(ar.a.VjK, null);
      if (Util.isNullOrNil(paramas)) {
        break label165;
      }
    }
    for (;;)
    {
      try
      {
        paramas = new JSONObject(paramas);
        this.GYz = paramas.optString("ShopUrl");
        paramas = paramas.optString("ShopName");
        if (Util.isNullOrNil(this.GYz)) {
          break label170;
        }
        this.GYp.setVisibility(0);
        this.GYp.HbS = paramas;
        this.GYp.abw(getResources().getColor(R.e.dkE));
        paramas = this.GYp;
        paramas.HbT = new ContactMoreInfoUI.2(this);
        paramas.fqK();
        AppMethodBeat.o(27034);
        return true;
      }
      catch (JSONException paramas)
      {
        Log.printErrStackTrace("MicroMsg.ContactMoreInfoUI", paramas, "", new Object[0]);
      }
      paramas = paramas.hDv;
      break;
      label165:
      paramas = null;
    }
    label170:
    this.GYp.setVisibility(8);
    AppMethodBeat.o(27034);
    return false;
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(27035);
    if (paramk.resultCode == 0)
    {
      int i = ((Integer)((m)paramk.BIW.get(0)).BJh).intValue();
      this.GYo.HbS = getString(R.l.eyq, new Object[] { Integer.valueOf(i) });
      this.GYo.HbT = new ContactMoreInfoUI.6(this, i);
    }
    for (;;)
    {
      this.GYo.fqK();
      AppMethodBeat.o(27035);
      return;
      this.GYo.HbS = getString(R.l.eyq, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public int getLayoutId()
  {
    return R.i.efp;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27033);
    super.initView();
    setMMTitle(R.l.app_more);
    setBackBtn(new ContactMoreInfoUI.1(this));
    this.GYk = ((ProfileNormalItemView)findViewById(R.h.dLn));
    this.GYl = ((ProfileNormalItemView)findViewById(R.h.dHU));
    this.GYm = ((ProfileNormalItemView)findViewById(R.h.qq));
    this.GYn = ((ProfileNormalItemView)findViewById(R.h.district));
    this.GYn.setVisibility(8);
    this.GYn.mTitle = getString(R.l.eyt);
    this.GYq = ((ProfileNormalItemView)findViewById(R.h.dVn));
    this.GYq.abu(R.l.ezr);
    this.GYq.GUs.setSingleLine(false);
    this.GYr = ((ProfileNormalItemView)findViewById(R.h.dHH));
    this.GYr.abu(R.l.eAf);
    this.GYp = ((ProfileNormalItemView)findViewById(R.h.eaS));
    this.GYo = ((ProfileNormalItemView)findViewById(R.h.dAw));
    this.GYo.fqJ();
    this.GYs = ((ProfileNormalItemView)findViewById(R.h.from));
    this.GYs.abu(R.l.eyv);
    this.GYs.fqJ();
    Object localObject1 = com.tencent.mm.n.h.axc().getValue("LinkedinPluginClose");
    int i;
    label361:
    Object localObject2;
    if ((Util.isNullOrNil((String)localObject1)) || (Util.getInt((String)localObject1, 0) == 0))
    {
      i = 1;
      if ((i == 0) || (Util.isNullOrNil(this.uNk.hDs))) {
        break label1092;
      }
      this.GYk.setVisibility(0);
      if (Util.isNullOrNil(this.GYt)) {
        this.GYt = this.uNk.hDt;
      }
      localObject1 = this.GYk;
      ((ProfileNormalItemView)localObject1).HbS = this.GYt;
      ((ProfileNormalItemView)localObject1).HbT = new ContactMoreInfoUI.3(this);
      ((ProfileNormalItemView)localObject1).abw(getResources().getColor(R.e.dkE)).fqK();
      this.GYl.setVisibility(0);
      localObject1 = this.GYl;
      ((ProfileNormalItemView)localObject1).HbS = this.GYv;
      ((ProfileNormalItemView)localObject1).fqK();
      bh.beI();
      i = Util.nullAsNil((Integer)c.aHp().b(9, null));
      this.GYx = getIntent().getLongExtra("Contact_Uin", 0L);
      this.GYy = getIntent().getStringExtra("Contact_QQNick");
      if ((this.GYx == 0L) || (i == 0)) {
        break label1104;
      }
      if ((this.GYy == null) || (this.GYy.length() == 0))
      {
        long l = this.GYx;
        localObject2 = com.tencent.mm.plugin.account.b.getQQListStg().Hd(l);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = null;
        }
        if (localObject1 != null) {
          this.GYy = ((com.tencent.mm.plugin.account.friend.a.as)localObject1).getDisplayName();
        }
      }
      localObject1 = Util.nullAsNil(this.GYy);
      localObject1 = (String)localObject1 + " " + new p(this.GYx).longValue();
      this.GYm.setVisibility(0);
      localObject2 = this.GYm;
      ((ProfileNormalItemView)localObject2).HbS = ((CharSequence)localObject1);
      ((ProfileNormalItemView)localObject2).HbT = new ContactMoreInfoUI.4(this);
      ((ProfileNormalItemView)localObject2).fqK();
      label598:
      localObject1 = this.GYq;
      ((ProfileNormalItemView)localObject1).HbS = com.tencent.mm.pluginsdk.ui.span.l.c(this, this.uNk.signature);
      ((ProfileNormalItemView)localObject1).fqK();
      Log.i("MicroMsg.ContactMoreInfoUI", "[initFriendSource] source:%s", new Object[] { Integer.valueOf(this.uNk.getSource()) });
      switch (this.uNk.getSource())
      {
      default: 
        this.GYr.HbS = null;
        label884:
        this.GYr.fqK();
        ag(this.uNk);
        localObject1 = this.uNk;
        if ((com.tencent.mm.storage.as.bvK(((ax)localObject1).field_username)) && (((ax)localObject1).hDz != 0))
        {
          localObject2 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).c(((ax)localObject1).field_openImAppid, "openim_intro_desc", a.a.mxX);
          this.GYs.HbS = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)localObject2);
          String str = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).c(((ax)localObject1).field_openImAppid, "openim_intro_url", a.a.mxY);
          if (!TextUtils.isEmpty(str))
          {
            ProfileNormalItemView localProfileNormalItemView = this.GYs;
            localProfileNormalItemView.HbT = new ContactMoreInfoUI.5(this, str, (com.tencent.mm.storage.as)localObject1, (String)localObject2);
            localProfileNormalItemView.fqK();
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (!this.uNk.field_username.equals(z.bcZ()))
      {
        localObject1 = this.uNk;
        if (((ax)localObject1).field_username.equals(z.bcZ()))
        {
          this.GYo.setVisibility(8);
          AppMethodBeat.o(27033);
          return;
          i = 0;
          break;
          label1092:
          this.GYk.setVisibility(8);
          break label361;
          label1104:
          this.GYm.setVisibility(8);
          break label598;
          this.GYr.abv(R.l.eFi);
          break label884;
          if (this.uNk.ayu() > 1000000)
          {
            this.GYr.abv(R.l.ezU);
            break label884;
          }
          this.GYr.abv(R.l.ezT);
          break label884;
          if (this.uNk.ayu() > 1000000)
          {
            this.GYr.abv(R.l.ezX);
            break label884;
          }
          this.GYr.abv(R.l.ezW);
          break label884;
          if (this.uNk.ayu() > 1000000)
          {
            this.GYr.abv(R.l.ezB);
            break label884;
          }
          this.GYr.abv(R.l.ezy);
          break label884;
          if (this.uNk.ayu() > 1000000)
          {
            this.GYr.abv(R.l.ezJ);
            break label884;
          }
          this.GYr.abv(R.l.ezI);
          break label884;
          if (this.uNk.ayu() > 1000000)
          {
            this.GYr.abv(R.l.ezN);
            break label884;
          }
          this.GYr.abv(R.l.ezM);
          break label884;
          this.GYr.abv(R.l.ezP);
          break label884;
          localObject1 = this.uNk.field_sourceExtInfo;
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG((String)localObject1);
          if ((localObject1 == null) || (Util.isNullOrNil(((ax)localObject1).field_username)))
          {
            localObject1 = null;
            label1400:
            if (this.uNk.ayu() <= 1000000) {
              break label1523;
            }
            if (Util.isNullOrNil((String)localObject1)) {
              break label1511;
            }
          }
          label1511:
          for (localObject1 = getString(R.l.ezH, new Object[] { localObject1 });; localObject1 = getString(R.l.ezF))
          {
            localObject2 = this.GYr;
            ((ProfileNormalItemView)localObject2).GUs.setMaxLines(5);
            ((ProfileNormalItemView)localObject2).GUs.setEllipsize(TextUtils.TruncateAt.END);
            this.GYr.HbS = ((CharSequence)localObject1);
            break;
            if (Util.isNullOrNil(((ax)localObject1).field_nickname))
            {
              localObject1 = v.Pl(((ax)localObject1).field_username);
              break label1400;
            }
            localObject1 = ((ax)localObject1).field_nickname;
            break label1400;
          }
          label1523:
          if (!Util.isNullOrNil((String)localObject1)) {}
          for (localObject1 = getString(R.l.ezG, new Object[] { localObject1 });; localObject1 = getString(R.l.ezE))
          {
            this.GYr.HbS = ((CharSequence)localObject1);
            break;
          }
          if (this.uNk.ayu() > 1000000)
          {
            this.GYr.abv(R.l.eAa);
            break label884;
          }
          this.GYr.abv(R.l.ezZ);
          break label884;
          this.GYr.abv(R.l.ezu);
          break label884;
          this.GYr.abv(R.l.gcontact_from_source);
          break label884;
          this.GYr.abv(R.l.ezL);
          break label884;
          if (this.uNk.ayu() > 1000000)
          {
            this.GYr.abv(R.l.eAd);
            break label884;
          }
          this.GYr.abv(R.l.eAc);
          break label884;
          if (this.uNk.ayu() > 1000000)
          {
            this.GYr.abv(R.l.eAd);
            break label884;
          }
          this.GYr.abv(R.l.eAc);
          break label884;
          if (this.uNk.ayu() > 1000000)
          {
            this.GYr.abv(R.l.ezw);
            break label884;
          }
          this.GYr.abv(R.l.ezv);
          break label884;
          if (this.uNk.ayu() > 1000000)
          {
            this.GYr.abv(R.l.ezR);
            break label884;
          }
          this.GYr.abv(R.l.ezQ);
          break label884;
          this.GYs.setVisibility(8);
          continue;
        }
        if (((ax)localObject1).sex != 1) {
          break label1925;
        }
        this.GYo.abu(R.l.eyp);
      }
    }
    for (;;)
    {
      this.GYo.fqK();
      localObject2 = new j();
      ((j)localObject2).query = ((ax)localObject1).field_username;
      ((j)localObject2).BIU = this;
      ((j)localObject2).handler = this.handler;
      ((j)localObject2).nRn = 5;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).search(2, (j)localObject2);
      AppMethodBeat.o(27033);
      return;
      label1925:
      if (((ax)localObject1).sex == 2) {
        this.GYo.abu(R.l.eyo);
      } else {
        this.GYo.abu(R.l.eyr);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27036);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(27036);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27032);
    super.onCreate(paramBundle);
    this.jhU = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.jaK = getIntent().getStringExtra("Contact_ChatRoomId");
    this.iSn = getIntent().getStringExtra("Contact_User");
    bh.beI();
    this.uNk = c.bbL().RG(this.iSn);
    this.GYt = getIntent().getStringExtra("KLinkedInAddFriendNickName");
    this.GYu = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
    this.GYv = getIntent().getStringExtra("verify_gmail");
    this.GYw = getIntent().getStringExtra("profileName");
    if (!Util.isNullOrNil(this.jaK))
    {
      bh.beI();
      this.iXp = c.bbV().Rw(this.jaK);
    }
    initView();
    AppMethodBeat.o(27032);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI
 * JD-Core Version:    0.7.0.1
 */