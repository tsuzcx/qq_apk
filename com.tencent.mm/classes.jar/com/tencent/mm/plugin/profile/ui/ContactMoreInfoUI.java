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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
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
  private long BeA;
  private String BeB;
  String BeC;
  private ProfileNormalItemView Beo;
  private ProfileNormalItemView Bep;
  private ProfileNormalItemView Beq;
  private ProfileNormalItemView Ber;
  private ProfileNormalItemView Bes;
  private ProfileNormalItemView Bet;
  private ProfileNormalItemView Beu;
  private ProfileNormalItemView Bev;
  private String Bew;
  private String Bex;
  private String Bey;
  private String Bez;
  private String goe;
  ah gtd;
  private String gwx;
  boolean gxS;
  private MMHandler handler;
  private com.tencent.mm.storage.as rjX;
  
  public ContactMoreInfoUI()
  {
    AppMethodBeat.i(27031);
    this.BeC = null;
    this.gxS = false;
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(27031);
  }
  
  private boolean Z(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(27034);
    if (z.aTY().equals(paramas.field_username))
    {
      bg.aVF();
      paramas = (String)c.azQ().get(ar.a.NVK, null);
      if (Util.isNullOrNil(paramas)) {
        break label164;
      }
    }
    for (;;)
    {
      try
      {
        paramas = new JSONObject(paramas);
        this.BeC = paramas.optString("ShopUrl");
        paramas = paramas.optString("ShopName");
        if (Util.isNullOrNil(this.BeC)) {
          break label169;
        }
        this.Bet.setVisibility(0);
        this.Bet.Bic = paramas;
        this.Bet.UQ(getResources().getColor(2131100959));
        paramas = this.Bet;
        paramas.Bid = new ContactMoreInfoUI.2(this);
        paramas.eEV();
        AppMethodBeat.o(27034);
        return true;
      }
      catch (JSONException paramas)
      {
        Log.printErrStackTrace("MicroMsg.ContactMoreInfoUI", paramas, "", new Object[0]);
      }
      paramas = paramas.fuW;
      break;
      label164:
      paramas = null;
    }
    label169:
    this.Bet.setVisibility(8);
    AppMethodBeat.o(27034);
    return false;
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(27035);
    if (paramk.resultCode == 0)
    {
      int i = ((Integer)((m)paramk.wXb.get(0)).userData).intValue();
      this.Bes.Bic = getString(2131757865, new Object[] { Integer.valueOf(i) });
      this.Bes.Bid = new ContactMoreInfoUI.5(this, i);
    }
    for (;;)
    {
      this.Bes.eEV();
      AppMethodBeat.o(27035);
      return;
      this.Bes.Bic = getString(2131757865, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public int getLayoutId()
  {
    return 2131493769;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27033);
    super.initView();
    setMMTitle(2131755899);
    setBackBtn(new ContactMoreInfoUI.1(this));
    this.Beo = ((ProfileNormalItemView)findViewById(2131303220));
    this.Bep = ((ProfileNormalItemView)findViewById(2131302152));
    this.Beq = ((ProfileNormalItemView)findViewById(2131306329));
    this.Ber = ((ProfileNormalItemView)findViewById(2131299679));
    this.Ber.setVisibility(8);
    this.Ber.mTitle = getString(2131757872);
    this.Beu = ((ProfileNormalItemView)findViewById(2131307905));
    this.Beu.UO(2131758062);
    this.Beu.Bau.setSingleLine(false);
    this.Bev = ((ProfileNormalItemView)findViewById(2131301792));
    this.Bev.UO(2131758114);
    this.Bet = ((ProfileNormalItemView)findViewById(2131310465));
    this.Bes = ((ProfileNormalItemView)findViewById(2131298977));
    this.Bes.Bie.setVisibility(0);
    Object localObject1 = h.aqJ().getValue("LinkedinPluginClose");
    int i;
    label328:
    Object localObject2;
    if ((Util.isNullOrNil((String)localObject1)) || (Util.getInt((String)localObject1, 0) == 0))
    {
      i = 1;
      if ((i == 0) || (Util.isNullOrNil(this.rjX.fuT))) {
        break label926;
      }
      this.Beo.setVisibility(0);
      if (Util.isNullOrNil(this.Bew)) {
        this.Bew = this.rjX.fuU;
      }
      localObject1 = this.Beo;
      ((ProfileNormalItemView)localObject1).Bic = this.Bew;
      ((ProfileNormalItemView)localObject1).Bid = new ContactMoreInfoUI.3(this);
      ((ProfileNormalItemView)localObject1).UQ(getResources().getColor(2131100959)).eEV();
      this.Bep.setVisibility(0);
      localObject1 = this.Bep;
      ((ProfileNormalItemView)localObject1).Bic = this.Bey;
      ((ProfileNormalItemView)localObject1).eEV();
      bg.aVF();
      i = Util.nullAsNil((Integer)c.azQ().get(9, null));
      this.BeA = getIntent().getLongExtra("Contact_Uin", 0L);
      this.BeB = getIntent().getStringExtra("Contact_QQNick");
      if ((this.BeA == 0L) || (i == 0)) {
        break label938;
      }
      if ((this.BeB == null) || (this.BeB.length() == 0))
      {
        long l = this.BeA;
        localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().AT(l);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = null;
        }
        if (localObject1 != null) {
          this.BeB = ((com.tencent.mm.plugin.account.friend.a.as)localObject1).getDisplayName();
        }
      }
      localObject1 = Util.nullAsNil(this.BeB);
      localObject1 = (String)localObject1 + " " + new p(this.BeA).longValue();
      this.Beq.setVisibility(0);
      localObject2 = this.Beq;
      ((ProfileNormalItemView)localObject2).Bic = ((CharSequence)localObject1);
      ((ProfileNormalItemView)localObject2).Bid = new ContactMoreInfoUI.4(this);
      ((ProfileNormalItemView)localObject2).eEV();
      label565:
      localObject1 = this.Beu;
      ((ProfileNormalItemView)localObject1).Bic = com.tencent.mm.pluginsdk.ui.span.l.c(this, this.rjX.signature);
      ((ProfileNormalItemView)localObject1).eEV();
      Log.i("MicroMsg.ContactMoreInfoUI", "[initFriendSource] source:%s", new Object[] { Integer.valueOf(this.rjX.getSource()) });
      switch (this.rjX.getSource())
      {
      default: 
        this.Bev.Bic = null;
      }
    }
    for (;;)
    {
      this.Bev.eEV();
      Z(this.rjX);
      if (this.rjX.field_username.equals(z.aTY())) {
        break label1740;
      }
      localObject1 = this.rjX;
      if (!((ax)localObject1).field_username.equals(z.aTY())) {
        break label1654;
      }
      this.Bes.setVisibility(8);
      AppMethodBeat.o(27033);
      return;
      i = 0;
      break;
      label926:
      this.Beo.setVisibility(8);
      break label328;
      label938:
      this.Beq.setVisibility(8);
      break label565;
      this.Bev.UP(2131760782);
      continue;
      if (this.rjX.arL() > 1000000)
      {
        this.Bev.UP(2131758102);
      }
      else
      {
        this.Bev.UP(2131758101);
        continue;
        if (this.rjX.arL() > 1000000)
        {
          this.Bev.UP(2131758105);
        }
        else
        {
          this.Bev.UP(2131758104);
          continue;
          if (this.rjX.arL() > 1000000)
          {
            this.Bev.UP(2131758082);
          }
          else
          {
            this.Bev.UP(2131758079);
            continue;
            if (this.rjX.arL() > 1000000)
            {
              this.Bev.UP(2131758090);
            }
            else
            {
              this.Bev.UP(2131758089);
              continue;
              if (this.rjX.arL() > 1000000)
              {
                this.Bev.UP(2131758095);
              }
              else
              {
                this.Bev.UP(2131758094);
                continue;
                this.Bev.UP(2131758097);
                continue;
                localObject1 = this.rjX.field_sourceExtInfo;
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)localObject1);
                if ((localObject1 == null) || (Util.isNullOrNil(((ax)localObject1).field_username)))
                {
                  localObject1 = null;
                  label1234:
                  if (this.rjX.arL() <= 1000000) {
                    break label1357;
                  }
                  if (Util.isNullOrNil((String)localObject1)) {
                    break label1345;
                  }
                }
                label1345:
                for (localObject1 = getString(2131758088, new Object[] { localObject1 });; localObject1 = getString(2131758086))
                {
                  localObject2 = this.Bev;
                  ((ProfileNormalItemView)localObject2).Bau.setMaxLines(5);
                  ((ProfileNormalItemView)localObject2).Bau.setEllipsize(TextUtils.TruncateAt.END);
                  this.Bev.Bic = ((CharSequence)localObject1);
                  break;
                  if (Util.isNullOrNil(((ax)localObject1).field_nickname))
                  {
                    localObject1 = v.HV(((ax)localObject1).field_username);
                    break label1234;
                  }
                  localObject1 = ((ax)localObject1).field_nickname;
                  break label1234;
                }
                label1357:
                if (!Util.isNullOrNil((String)localObject1)) {}
                for (localObject1 = getString(2131758087, new Object[] { localObject1 });; localObject1 = getString(2131758085))
                {
                  this.Bev.Bic = ((CharSequence)localObject1);
                  break;
                }
                if (this.rjX.arL() > 1000000)
                {
                  this.Bev.UP(2131758108);
                }
                else
                {
                  this.Bev.UP(2131758107);
                  continue;
                  this.Bev.UP(2131758074);
                  continue;
                  this.Bev.UP(2131761400);
                  continue;
                  this.Bev.UP(2131758092);
                  continue;
                  if (this.rjX.arL() > 1000000)
                  {
                    this.Bev.UP(2131758111);
                  }
                  else
                  {
                    this.Bev.UP(2131758110);
                    continue;
                    if (this.rjX.arL() > 1000000)
                    {
                      this.Bev.UP(2131758111);
                    }
                    else
                    {
                      this.Bev.UP(2131758110);
                      continue;
                      if (this.rjX.arL() > 1000000)
                      {
                        this.Bev.UP(2131758077);
                      }
                      else
                      {
                        this.Bev.UP(2131758076);
                        continue;
                        if (this.rjX.arL() > 1000000) {
                          this.Bev.UP(2131758099);
                        } else {
                          this.Bev.UP(2131758098);
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
    if (((ax)localObject1).fuA == 1) {
      this.Bes.UO(2131757862);
    }
    for (;;)
    {
      this.Bes.eEV();
      localObject2 = new j();
      ((j)localObject2).query = ((ax)localObject1).field_username;
      ((j)localObject2).wWZ = this;
      ((j)localObject2).handler = this.handler;
      ((j)localObject2).kXb = 5;
      ((n)g.ah(n.class)).search(2, (j)localObject2);
      label1740:
      AppMethodBeat.o(27033);
      return;
      if (((ax)localObject1).fuA == 2) {
        this.Bes.UO(2131757861);
      } else {
        this.Bes.UO(2131757866);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27036);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(27036);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27032);
    super.onCreate(paramBundle);
    this.gxS = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.gwx = getIntent().getStringExtra("Contact_ChatRoomId");
    this.goe = getIntent().getStringExtra("Contact_User");
    bg.aVF();
    this.rjX = c.aSN().Kn(this.goe);
    this.Bew = getIntent().getStringExtra("KLinkedInAddFriendNickName");
    this.Bex = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
    this.Bey = getIntent().getStringExtra("verify_gmail");
    this.Bez = getIntent().getStringExtra("profileName");
    if (!Util.isNullOrNil(this.gwx))
    {
      bg.aVF();
      this.gtd = c.aSX().Kd(this.gwx);
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