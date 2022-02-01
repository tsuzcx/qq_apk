package com.tencent.mm.plugin.profile.ui;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.plugin.account.friend.model.ap;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactMoreInfoUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.plugin.fts.a.l
{
  private long MWA;
  private String MWB;
  String MWC;
  private ProfileNormalItemView MWn;
  private ProfileNormalItemView MWo;
  private ProfileNormalItemView MWp;
  private ProfileNormalItemView MWq;
  private ProfileNormalItemView MWr;
  private ProfileNormalItemView MWs;
  private ProfileNormalItemView MWt;
  private ProfileNormalItemView MWu;
  private ProfileNormalItemView MWv;
  private String MWw;
  private String MWx;
  private String MWy;
  private String MWz;
  private MMHandler handler;
  boolean lKk;
  private String luk;
  private String lyn;
  aj lzy;
  private au xVS;
  
  public ContactMoreInfoUI()
  {
    AppMethodBeat.i(27031);
    this.MWC = null;
    this.lKk = false;
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(27031);
  }
  
  private boolean am(au paramau)
  {
    AppMethodBeat.i(27034);
    if (z.bAM().equals(paramau.field_username))
    {
      bh.bCz();
      paramau = (String)c.ban().get(at.a.acLe, null);
      if (Util.isNullOrNil(paramau)) {
        break label165;
      }
    }
    for (;;)
    {
      try
      {
        paramau = new JSONObject(paramau);
        this.MWC = paramau.optString("ShopUrl");
        paramau = paramau.optString("ShopName");
        if (Util.isNullOrNil(this.MWC)) {
          break label170;
        }
        this.MWs.setVisibility(0);
        this.MWs.Naa = paramau;
        this.MWs.afQ(getResources().getColor(R.e.fkT));
        paramau = this.MWs;
        paramau.Nab = new ContactMoreInfoUI.2(this);
        paramau.gCe();
        AppMethodBeat.o(27034);
        return true;
      }
      catch (JSONException paramau)
      {
        Log.printErrStackTrace("MicroMsg.ContactMoreInfoUI", paramau, "", new Object[0]);
      }
      paramau = paramau.kaq;
      break;
      label165:
      paramau = null;
    }
    label170:
    this.MWs.setVisibility(8);
    AppMethodBeat.o(27034);
    return false;
  }
  
  public final void b(m paramm)
  {
    AppMethodBeat.i(27035);
    if (paramm.resultCode == 0)
    {
      int i = ((Integer)((o)paramm.HtF.get(0)).HtQ).intValue();
      this.MWr.Naa = getString(R.l.gBi, new Object[] { Integer.valueOf(i) });
      this.MWr.Nab = new ContactMoreInfoUI.6(this, i);
    }
    for (;;)
    {
      this.MWr.gCe();
      AppMethodBeat.o(27035);
      return;
      this.MWr.Naa = getString(R.l.gBi, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public int getLayoutId()
  {
    return R.i.gik;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27033);
    super.initView();
    setMMTitle(R.l.app_more);
    setBackBtn(new ContactMoreInfoUI.1(this));
    this.MWn = ((ProfileNormalItemView)findViewById(R.h.fMS));
    this.MWo = ((ProfileNormalItemView)findViewById(R.h.fJh));
    this.MWp = ((ProfileNormalItemView)findViewById(R.h.qq));
    this.MWq = ((ProfileNormalItemView)findViewById(R.h.district));
    this.MWq.setVisibility(8);
    this.MWq.mTitle = getString(R.l.gBl);
    this.MWt = ((ProfileNormalItemView)findViewById(R.h.fXJ));
    this.MWt.afO(R.l.gCg);
    this.MWt.MRV.setSingleLine(false);
    this.MWu = ((ProfileNormalItemView)findViewById(R.h.fIR));
    this.MWu.afO(R.l.gCW);
    this.MWs = ((ProfileNormalItemView)findViewById(R.h.gdw));
    this.MWr = ((ProfileNormalItemView)findViewById(R.h.fBs));
    this.MWr.gCd();
    this.MWv = ((ProfileNormalItemView)findViewById(R.h.from));
    this.MWv.afO(R.l.gBn);
    this.MWv.gCd();
    Object localObject1 = i.aRC().getValue("LinkedinPluginClose");
    int i;
    label361:
    Object localObject2;
    if ((Util.isNullOrNil((String)localObject1)) || (Util.getInt((String)localObject1, 0) == 0))
    {
      i = 1;
      if ((i == 0) || (Util.isNullOrNil(this.xVS.kan))) {
        break label1094;
      }
      this.MWn.setVisibility(0);
      if (Util.isNullOrNil(this.MWw)) {
        this.MWw = this.xVS.kao;
      }
      localObject1 = this.MWn;
      ((ProfileNormalItemView)localObject1).Naa = this.MWw;
      ((ProfileNormalItemView)localObject1).Nab = new ContactMoreInfoUI.3(this);
      ((ProfileNormalItemView)localObject1).afQ(getResources().getColor(R.e.fkT)).gCe();
      this.MWo.setVisibility(0);
      localObject1 = this.MWo;
      ((ProfileNormalItemView)localObject1).Naa = this.MWy;
      ((ProfileNormalItemView)localObject1).gCe();
      bh.bCz();
      i = Util.nullAsNil((Integer)c.ban().d(9, null));
      this.MWA = getIntent().getLongExtra("Contact_Uin", 0L);
      this.MWB = getIntent().getStringExtra("Contact_QQNick");
      if ((this.MWA == 0L) || (i == 0)) {
        break label1106;
      }
      if ((this.MWB == null) || (this.MWB.length() == 0))
      {
        long l = this.MWA;
        localObject2 = com.tencent.mm.plugin.account.b.getQQListStg().jt(l);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = null;
        }
        if (localObject1 != null) {
          this.MWB = ((ap)localObject1).getDisplayName();
        }
      }
      localObject1 = Util.nullAsNil(this.MWB);
      localObject1 = (String)localObject1 + " " + new com.tencent.mm.b.p(this.MWA).longValue();
      this.MWp.setVisibility(0);
      localObject2 = this.MWp;
      ((ProfileNormalItemView)localObject2).Naa = ((CharSequence)localObject1);
      ((ProfileNormalItemView)localObject2).Nab = new ContactMoreInfoUI.4(this);
      ((ProfileNormalItemView)localObject2).gCe();
      label598:
      localObject1 = this.MWt;
      ((ProfileNormalItemView)localObject1).Naa = com.tencent.mm.pluginsdk.ui.span.p.b(this, this.xVS.signature);
      ((ProfileNormalItemView)localObject1).gCe();
      Log.i("MicroMsg.ContactMoreInfoUI", "[initFriendSource] source:%s", new Object[] { Integer.valueOf(this.xVS.getSource()) });
      switch (this.xVS.getSource())
      {
      default: 
        this.MWu.Naa = null;
        label884:
        this.MWu.gCe();
        am(this.xVS);
        localObject1 = this.xVS;
        if ((au.bwO(((az)localObject1).field_username)) && (((az)localObject1).kau != 0))
        {
          localObject2 = ((e)h.ax(e.class)).a(((az)localObject1).field_openImAppid, "openim_intro_desc", e.a.prb, 0);
          this.MWv.Naa = com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), (CharSequence)localObject2);
          String str = ((e)h.ax(e.class)).a(((az)localObject1).field_openImAppid, "openim_intro_url", e.a.prc, 0);
          if (!TextUtils.isEmpty(str))
          {
            ProfileNormalItemView localProfileNormalItemView = this.MWv;
            localProfileNormalItemView.Nab = new ContactMoreInfoUI.5(this, str, (au)localObject1, (String)localObject2);
            localProfileNormalItemView.gCe();
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (!this.xVS.field_username.equals(z.bAM()))
      {
        localObject1 = this.xVS;
        if (((az)localObject1).field_username.equals(z.bAM()))
        {
          this.MWr.setVisibility(8);
          AppMethodBeat.o(27033);
          return;
          i = 0;
          break;
          label1094:
          this.MWn.setVisibility(8);
          break label361;
          label1106:
          this.MWp.setVisibility(8);
          break label598;
          this.MWu.afP(R.l.gIc);
          break label884;
          if (this.xVS.aSX() > 1000000)
          {
            this.MWu.afP(R.l.gCL);
            break label884;
          }
          this.MWu.afP(R.l.gCK);
          break label884;
          if (this.xVS.aSX() > 1000000)
          {
            this.MWu.afP(R.l.gCO);
            break label884;
          }
          this.MWu.afP(R.l.gCN);
          break label884;
          if (this.xVS.aSX() > 1000000)
          {
            this.MWu.afP(R.l.gCq);
            break label884;
          }
          this.MWu.afP(R.l.gCn);
          break label884;
          if (this.xVS.aSX() > 1000000)
          {
            this.MWu.afP(R.l.gCA);
            break label884;
          }
          this.MWu.afP(R.l.gCz);
          break label884;
          if (this.xVS.aSX() > 1000000)
          {
            this.MWu.afP(R.l.gCE);
            break label884;
          }
          this.MWu.afP(R.l.gCD);
          break label884;
          this.MWu.afP(R.l.gCG);
          break label884;
          localObject1 = this.xVS.field_sourceExtInfo;
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject1);
          if ((localObject1 == null) || (Util.isNullOrNil(((az)localObject1).field_username)))
          {
            localObject1 = null;
            label1402:
            if (this.xVS.aSX() <= 1000000) {
              break label1525;
            }
            if (Util.isNullOrNil((String)localObject1)) {
              break label1513;
            }
          }
          label1513:
          for (localObject1 = getString(R.l.gCw, new Object[] { localObject1 });; localObject1 = getString(R.l.gCu))
          {
            localObject2 = this.MWu;
            ((ProfileNormalItemView)localObject2).MRV.setMaxLines(5);
            ((ProfileNormalItemView)localObject2).MRV.setEllipsize(TextUtils.TruncateAt.END);
            this.MWu.Naa = ((CharSequence)localObject1);
            break;
            if (Util.isNullOrNil(((az)localObject1).field_nickname))
            {
              localObject1 = v.Ie(((az)localObject1).field_username);
              break label1402;
            }
            localObject1 = ((az)localObject1).field_nickname;
            break label1402;
          }
          label1525:
          if (!Util.isNullOrNil((String)localObject1)) {}
          for (localObject1 = getString(R.l.gCv, new Object[] { localObject1 });; localObject1 = getString(R.l.gCt))
          {
            this.MWu.Naa = ((CharSequence)localObject1);
            break;
          }
          if (this.xVS.aSX() > 1000000)
          {
            this.MWu.afP(R.l.gCR);
            break label884;
          }
          this.MWu.afP(R.l.gCQ);
          break label884;
          this.MWu.afP(R.l.gCj);
          break label884;
          this.MWu.afP(R.l.gcontact_from_source);
          break label884;
          this.MWu.afP(R.l.gCC);
          break label884;
          if (this.xVS.aSX() > 1000000)
          {
            this.MWu.afP(R.l.gCU);
            break label884;
          }
          this.MWu.afP(R.l.gCT);
          break label884;
          if (this.xVS.aSX() > 1000000)
          {
            this.MWu.afP(R.l.gCU);
            break label884;
          }
          this.MWu.afP(R.l.gCT);
          break label884;
          if (this.xVS.aSX() > 1000000)
          {
            this.MWu.afP(R.l.gCl);
            break label884;
          }
          this.MWu.afP(R.l.gCk);
          break label884;
          if (this.xVS.aSX() > 1000000)
          {
            this.MWu.afP(R.l.gCI);
            break label884;
          }
          this.MWu.afP(R.l.gCH);
          break label884;
          this.MWv.setVisibility(8);
          continue;
        }
        if (((az)localObject1).sex != 1) {
          break label1927;
        }
        this.MWr.afO(R.l.gBh);
      }
    }
    for (;;)
    {
      this.MWr.gCe();
      localObject2 = new com.tencent.mm.plugin.fts.a.a.l();
      ((com.tencent.mm.plugin.fts.a.a.l)localObject2).query = ((az)localObject1).field_username;
      ((com.tencent.mm.plugin.fts.a.a.l)localObject2).HtC = this;
      ((com.tencent.mm.plugin.fts.a.a.l)localObject2).handler = this.handler;
      ((com.tencent.mm.plugin.fts.a.a.l)localObject2).qRb = 5;
      ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.l)localObject2);
      AppMethodBeat.o(27033);
      return;
      label1927:
      if (((az)localObject1).sex == 2) {
        this.MWr.afO(R.l.gBg);
      } else {
        this.MWr.afO(R.l.gBj);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27036);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(27036);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27032);
    super.onCreate(paramBundle);
    this.lKk = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.lyn = getIntent().getStringExtra("Contact_ChatRoomId");
    this.luk = getIntent().getStringExtra("Contact_User");
    bh.bCz();
    this.xVS = c.bzA().JE(this.luk);
    this.MWw = getIntent().getStringExtra("KLinkedInAddFriendNickName");
    this.MWx = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
    this.MWy = getIntent().getStringExtra("verify_gmail");
    this.MWz = getIntent().getStringExtra("profileName");
    if (!Util.isNullOrNil(this.lyn))
    {
      bh.bCz();
      this.lzy = c.bzK().Ju(this.lyn);
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