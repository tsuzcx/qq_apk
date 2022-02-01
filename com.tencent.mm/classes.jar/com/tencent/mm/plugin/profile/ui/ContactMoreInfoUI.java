package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactMoreInfoUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.plugin.fts.a.l
{
  private String fGM;
  ab fLO;
  private String fPi;
  boolean fQE;
  private ap handler;
  private am pMt;
  private ProfileNormalItemView wQK;
  private ProfileNormalItemView wQL;
  private ProfileNormalItemView wQM;
  private ProfileNormalItemView wQN;
  private ProfileNormalItemView wQO;
  private ProfileNormalItemView wQP;
  private ProfileNormalItemView wQQ;
  private ProfileNormalItemView wQR;
  private String wQS;
  private String wQT;
  private String wQU;
  private String wQV;
  private long wQW;
  private String wQX;
  String wQY;
  
  public ContactMoreInfoUI()
  {
    AppMethodBeat.i(27031);
    this.wQY = null;
    this.fQE = false;
    this.handler = new ap(Looper.getMainLooper());
    AppMethodBeat.o(27031);
  }
  
  private boolean S(am paramam)
  {
    AppMethodBeat.i(27034);
    if (u.aAm().equals(paramam.field_username))
    {
      ba.aBQ();
      paramam = (String)c.ajl().get(al.a.Itl, null);
      if (bt.isNullOrNil(paramam)) {
        break label164;
      }
    }
    for (;;)
    {
      try
      {
        paramam = new JSONObject(paramam);
        this.wQY = paramam.optString("ShopUrl");
        paramam = paramam.optString("ShopName");
        if (bt.isNullOrNil(this.wQY)) {
          break label169;
        }
        this.wQP.setVisibility(0);
        this.wQP.wUo = paramam;
        this.wQP.MX(getResources().getColor(2131100763));
        paramam = this.wQP;
        paramam.wUp = new ContactMoreInfoUI.2(this);
        paramam.dBj();
        AppMethodBeat.o(27034);
        return true;
      }
      catch (JSONException paramam)
      {
        ad.printErrStackTrace("MicroMsg.ContactMoreInfoUI", paramam, "", new Object[0]);
      }
      paramam = paramam.ePI;
      break;
      label164:
      paramam = null;
    }
    label169:
    this.wQP.setVisibility(8);
    AppMethodBeat.o(27034);
    return false;
  }
  
  public final void b(com.tencent.mm.plugin.fts.a.a.k paramk)
  {
    AppMethodBeat.i(27035);
    if (paramk.bZU == 0)
    {
      int i = ((Integer)((m)paramk.tvl.get(0)).userData).intValue();
      this.wQO.wUo = getString(2131757637, new Object[] { Integer.valueOf(i) });
      this.wQO.wUp = new ContactMoreInfoUI.5(this, i);
    }
    for (;;)
    {
      this.wQO.dBj();
      AppMethodBeat.o(27035);
      return;
      this.wQO.wUo = getString(2131757637, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public int getLayoutId()
  {
    return 2131493639;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27033);
    super.initView();
    setMMTitle(2131755815);
    setBackBtn(new ContactMoreInfoUI.1(this));
    this.wQK = ((ProfileNormalItemView)findViewById(2131301437));
    this.wQL = ((ProfileNormalItemView)findViewById(2131300600));
    this.wQM = ((ProfileNormalItemView)findViewById(2131303554));
    this.wQN = ((ProfileNormalItemView)findViewById(2131299151));
    this.wQN.setVisibility(8);
    this.wQN.mTitle = getString(2131757644);
    this.wQQ = ((ProfileNormalItemView)findViewById(2131304822));
    this.wQQ.MV(2131757822);
    this.wQQ.wNe.setSingleLine(false);
    this.wQR = ((ProfileNormalItemView)findViewById(2131300302));
    this.wQR.MV(2131757874);
    this.wQP = ((ProfileNormalItemView)findViewById(2131306965));
    this.wQO = ((ProfileNormalItemView)findViewById(2131298546));
    this.wQO.wUq.setVisibility(0);
    Object localObject1 = com.tencent.mm.n.g.acA().getValue("LinkedinPluginClose");
    int i;
    label328:
    Object localObject2;
    if ((bt.isNullOrNil((String)localObject1)) || (bt.getInt((String)localObject1, 0) == 0))
    {
      i = 1;
      if ((i == 0) || (bt.isNullOrNil(this.pMt.ePF))) {
        break label926;
      }
      this.wQK.setVisibility(0);
      if (bt.isNullOrNil(this.wQS)) {
        this.wQS = this.pMt.ePG;
      }
      localObject1 = this.wQK;
      ((ProfileNormalItemView)localObject1).wUo = this.wQS;
      ((ProfileNormalItemView)localObject1).wUp = new ContactMoreInfoUI.3(this);
      ((ProfileNormalItemView)localObject1).MX(getResources().getColor(2131100763)).dBj();
      this.wQL.setVisibility(0);
      localObject1 = this.wQL;
      ((ProfileNormalItemView)localObject1).wUo = this.wQU;
      ((ProfileNormalItemView)localObject1).dBj();
      ba.aBQ();
      i = bt.n((Integer)c.ajl().get(9, null));
      this.wQW = getIntent().getLongExtra("Contact_Uin", 0L);
      this.wQX = getIntent().getStringExtra("Contact_QQNick");
      if ((this.wQW == 0L) || (i == 0)) {
        break label938;
      }
      if ((this.wQX == null) || (this.wQX.length() == 0))
      {
        long l = this.wQW;
        localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().sB(l);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = null;
        }
        if (localObject1 != null) {
          this.wQX = ((as)localObject1).getDisplayName();
        }
      }
      localObject1 = bt.nullAsNil(this.wQX);
      localObject1 = (String)localObject1 + " " + new p(this.wQW).longValue();
      this.wQM.setVisibility(0);
      localObject2 = this.wQM;
      ((ProfileNormalItemView)localObject2).wUo = ((CharSequence)localObject1);
      ((ProfileNormalItemView)localObject2).wUp = new ContactMoreInfoUI.4(this);
      ((ProfileNormalItemView)localObject2).dBj();
      label565:
      localObject1 = this.wQQ;
      ((ProfileNormalItemView)localObject1).wUo = com.tencent.mm.pluginsdk.ui.span.k.c(this, this.pMt.signature);
      ((ProfileNormalItemView)localObject1).dBj();
      ad.i("MicroMsg.ContactMoreInfoUI", "[initFriendSource] source:%s", new Object[] { Integer.valueOf(this.pMt.getSource()) });
      switch (this.pMt.getSource())
      {
      default: 
        this.wQR.wUo = null;
      }
    }
    for (;;)
    {
      this.wQR.dBj();
      S(this.pMt);
      if (this.pMt.field_username.equals(u.aAm())) {
        break label1740;
      }
      localObject1 = this.pMt;
      if (!((aw)localObject1).field_username.equals(u.aAm())) {
        break label1654;
      }
      this.wQO.setVisibility(8);
      AppMethodBeat.o(27033);
      return;
      i = 0;
      break;
      label926:
      this.wQK.setVisibility(8);
      break label328;
      label938:
      this.wQM.setVisibility(8);
      break label565;
      this.wQR.MW(2131759467);
      continue;
      if (this.pMt.adx() > 1000000)
      {
        this.wQR.MW(2131757862);
      }
      else
      {
        this.wQR.MW(2131757861);
        continue;
        if (this.pMt.adx() > 1000000)
        {
          this.wQR.MW(2131757865);
        }
        else
        {
          this.wQR.MW(2131757864);
          continue;
          if (this.pMt.adx() > 1000000)
          {
            this.wQR.MW(2131757842);
          }
          else
          {
            this.wQR.MW(2131757839);
            continue;
            if (this.pMt.adx() > 1000000)
            {
              this.wQR.MW(2131757850);
            }
            else
            {
              this.wQR.MW(2131757849);
              continue;
              if (this.pMt.adx() > 1000000)
              {
                this.wQR.MW(2131757855);
              }
              else
              {
                this.wQR.MW(2131757854);
                continue;
                this.wQR.MW(2131757857);
                continue;
                localObject1 = this.pMt.field_sourceExtInfo;
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf((String)localObject1);
                if ((localObject1 == null) || (bt.isNullOrNil(((aw)localObject1).field_username)))
                {
                  localObject1 = null;
                  label1234:
                  if (this.pMt.adx() <= 1000000) {
                    break label1357;
                  }
                  if (bt.isNullOrNil((String)localObject1)) {
                    break label1345;
                  }
                }
                label1345:
                for (localObject1 = getString(2131757848, new Object[] { localObject1 });; localObject1 = getString(2131757846))
                {
                  localObject2 = this.wQR;
                  ((ProfileNormalItemView)localObject2).wNe.setMaxLines(5);
                  ((ProfileNormalItemView)localObject2).wNe.setEllipsize(TextUtils.TruncateAt.END);
                  this.wQR.wUo = ((CharSequence)localObject1);
                  break;
                  if (bt.isNullOrNil(((aw)localObject1).field_nickname))
                  {
                    localObject1 = q.yJ(((aw)localObject1).field_username);
                    break label1234;
                  }
                  localObject1 = ((aw)localObject1).field_nickname;
                  break label1234;
                }
                label1357:
                if (!bt.isNullOrNil((String)localObject1)) {}
                for (localObject1 = getString(2131757847, new Object[] { localObject1 });; localObject1 = getString(2131757845))
                {
                  this.wQR.wUo = ((CharSequence)localObject1);
                  break;
                }
                if (this.pMt.adx() > 1000000)
                {
                  this.wQR.MW(2131757868);
                }
                else
                {
                  this.wQR.MW(2131757867);
                  continue;
                  this.wQR.MW(2131757834);
                  continue;
                  this.wQR.MW(2131760022);
                  continue;
                  this.wQR.MW(2131757852);
                  continue;
                  if (this.pMt.adx() > 1000000)
                  {
                    this.wQR.MW(2131757871);
                  }
                  else
                  {
                    this.wQR.MW(2131757870);
                    continue;
                    if (this.pMt.adx() > 1000000)
                    {
                      this.wQR.MW(2131757871);
                    }
                    else
                    {
                      this.wQR.MW(2131757870);
                      continue;
                      if (this.pMt.adx() > 1000000)
                      {
                        this.wQR.MW(2131757837);
                      }
                      else
                      {
                        this.wQR.MW(2131757836);
                        continue;
                        if (this.pMt.adx() > 1000000) {
                          this.wQR.MW(2131757859);
                        } else {
                          this.wQR.MW(2131757858);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1654:
    if (((aw)localObject1).ePk == 1) {
      this.wQO.MV(2131757634);
    }
    for (;;)
    {
      this.wQO.dBj();
      localObject2 = new j();
      ((j)localObject2).query = ((aw)localObject1).field_username;
      ((j)localObject2).tvj = this;
      ((j)localObject2).handler = this.handler;
      ((j)localObject2).jQN = 5;
      ((n)com.tencent.mm.kernel.g.ad(n.class)).search(2, (j)localObject2);
      label1740:
      AppMethodBeat.o(27033);
      return;
      if (((aw)localObject1).ePk == 2) {
        this.wQO.MV(2131757633);
      } else {
        this.wQO.MV(2131757638);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27036);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(27036);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27032);
    super.onCreate(paramBundle);
    this.fQE = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.fPi = getIntent().getStringExtra("Contact_ChatRoomId");
    this.fGM = getIntent().getStringExtra("Contact_User");
    ba.aBQ();
    this.pMt = c.azp().Bf(this.fGM);
    this.wQS = getIntent().getStringExtra("KLinkedInAddFriendNickName");
    this.wQT = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
    this.wQU = getIntent().getStringExtra("verify_gmail");
    this.wQV = getIntent().getStringExtra("profileName");
    if (!bt.isNullOrNil(this.fPi))
    {
      ba.aBQ();
      this.fLO = c.azz().AN(this.fPi);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI
 * JD-Core Version:    0.7.0.1
 */