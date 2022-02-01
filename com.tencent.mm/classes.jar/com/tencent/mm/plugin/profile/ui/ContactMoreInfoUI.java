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
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactMoreInfoUI
  extends MMActivity
  implements View.OnClickListener, l
{
  private String foE;
  x ftP;
  private String fvZ;
  boolean fxr;
  private ao handler;
  private ai piT;
  private ProfileNormalItemView vJB;
  private ProfileNormalItemView vJC;
  private ProfileNormalItemView vJD;
  private ProfileNormalItemView vJE;
  private ProfileNormalItemView vJF;
  private ProfileNormalItemView vJG;
  private ProfileNormalItemView vJH;
  private ProfileNormalItemView vJI;
  private String vJJ;
  private String vJK;
  private String vJL;
  private String vJM;
  private long vJN;
  private String vJO;
  String vJP;
  
  public ContactMoreInfoUI()
  {
    AppMethodBeat.i(27031);
    this.vJP = null;
    this.fxr = false;
    this.handler = new ao(Looper.getMainLooper());
    AppMethodBeat.o(27031);
  }
  
  private boolean S(ai paramai)
  {
    AppMethodBeat.i(27034);
    if (u.axw().equals(paramai.field_username))
    {
      az.ayM();
      paramai = (String)c.agA().get(ah.a.GGT, null);
      if (bs.isNullOrNil(paramai)) {
        break label164;
      }
    }
    for (;;)
    {
      try
      {
        paramai = new JSONObject(paramai);
        this.vJP = paramai.optString("ShopUrl");
        paramai = paramai.optString("ShopName");
        if (bs.isNullOrNil(this.vJP)) {
          break label169;
        }
        this.vJG.setVisibility(0);
        this.vJG.vNf = paramai;
        this.vJG.Lv(getResources().getColor(2131100763));
        paramai = this.vJG;
        paramai.vNg = new ContactMoreInfoUI.2(this);
        paramai.dqG();
        AppMethodBeat.o(27034);
        return true;
      }
      catch (JSONException paramai)
      {
        ac.printErrStackTrace("MicroMsg.ContactMoreInfoUI", paramai, "", new Object[0]);
      }
      paramai = paramai.eyk;
      break;
      label164:
      paramai = null;
    }
    label169:
    this.vJG.setVisibility(8);
    AppMethodBeat.o(27034);
    return false;
  }
  
  public final void b(com.tencent.mm.plugin.fts.a.a.k paramk)
  {
    AppMethodBeat.i(27035);
    if (paramk.bPH == 0)
    {
      final int i = ((Integer)((m)paramk.syK.get(0)).userData).intValue();
      this.vJF.vNf = getString(2131757637, new Object[] { Integer.valueOf(i) });
      this.vJF.vNg = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27030);
          com.tencent.mm.plugin.fts.a.e.Fz(i);
          if (i > 0)
          {
            Object localObject = new Intent(ContactMoreInfoUI.this, CommonChatroomInfoUI.class);
            ((Intent)localObject).putExtra("Select_Talker_Name", ContactMoreInfoUI.b(ContactMoreInfoUI.this).field_username);
            paramAnonymousView = ContactMoreInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(27030);
        }
      };
    }
    for (;;)
    {
      this.vJF.dqG();
      AppMethodBeat.o(27035);
      return;
      this.vJF.vNf = getString(2131757637, new Object[] { Integer.valueOf(0) });
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
    this.vJB = ((ProfileNormalItemView)findViewById(2131301437));
    this.vJC = ((ProfileNormalItemView)findViewById(2131300600));
    this.vJD = ((ProfileNormalItemView)findViewById(2131303554));
    this.vJE = ((ProfileNormalItemView)findViewById(2131299151));
    this.vJE.setVisibility(8);
    this.vJE.mTitle = getString(2131757644);
    this.vJH = ((ProfileNormalItemView)findViewById(2131304822));
    this.vJH.Lt(2131757822);
    this.vJH.vFY.setSingleLine(false);
    this.vJI = ((ProfileNormalItemView)findViewById(2131300302));
    this.vJI.Lt(2131757874);
    this.vJG = ((ProfileNormalItemView)findViewById(2131306965));
    this.vJF = ((ProfileNormalItemView)findViewById(2131298546));
    this.vJF.vNh.setVisibility(0);
    Object localObject1 = com.tencent.mm.m.g.ZY().getValue("LinkedinPluginClose");
    int i;
    label329:
    Object localObject2;
    if ((bs.isNullOrNil((String)localObject1)) || (bs.getInt((String)localObject1, 0) == 0))
    {
      i = 1;
      if ((i == 0) || (bs.isNullOrNil(this.piT.eyh))) {
        break label926;
      }
      this.vJB.setVisibility(0);
      if (bs.isNullOrNil(this.vJJ)) {
        this.vJJ = this.piT.eyi;
      }
      localObject1 = this.vJB;
      ((ProfileNormalItemView)localObject1).vNf = this.vJJ;
      ((ProfileNormalItemView)localObject1).vNg = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27028);
          if (bs.isNullOrNil(ContactMoreInfoUI.a(ContactMoreInfoUI.this))) {
            ContactMoreInfoUI.a(ContactMoreInfoUI.this, ContactMoreInfoUI.b(ContactMoreInfoUI.this).eyj);
          }
          if (!bs.isNullOrNil(ContactMoreInfoUI.a(ContactMoreInfoUI.this)))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", ContactMoreInfoUI.a(ContactMoreInfoUI.this));
            paramAnonymousView.putExtra("geta8key_username", u.axw());
            d.b(ContactMoreInfoUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          AppMethodBeat.o(27028);
        }
      };
      ((ProfileNormalItemView)localObject1).Lv(getResources().getColor(2131100763)).dqG();
      this.vJC.setVisibility(0);
      localObject1 = this.vJC;
      ((ProfileNormalItemView)localObject1).vNf = this.vJL;
      ((ProfileNormalItemView)localObject1).dqG();
      az.ayM();
      i = bs.m((Integer)c.agA().get(9, null));
      this.vJN = getIntent().getLongExtra("Contact_Uin", 0L);
      this.vJO = getIntent().getStringExtra("Contact_QQNick");
      if ((this.vJN == 0L) || (i == 0)) {
        break label938;
      }
      if ((this.vJO == null) || (this.vJO.length() == 0))
      {
        long l = this.vJN;
        localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().qC(l);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = null;
        }
        if (localObject1 != null) {
          this.vJO = ((as)localObject1).getDisplayName();
        }
      }
      localObject1 = bs.nullAsNil(this.vJO);
      localObject1 = (String)localObject1 + " " + new p(this.vJN).longValue();
      this.vJD.setVisibility(0);
      localObject2 = this.vJD;
      ((ProfileNormalItemView)localObject2).vNf = ((CharSequence)localObject1);
      ((ProfileNormalItemView)localObject2).vNg = new ContactMoreInfoUI.4(this);
      ((ProfileNormalItemView)localObject2).dqG();
      label566:
      localObject1 = this.vJH;
      ((ProfileNormalItemView)localObject1).vNf = com.tencent.mm.pluginsdk.ui.span.k.c(this, this.piT.signature);
      ((ProfileNormalItemView)localObject1).dqG();
      ac.i("MicroMsg.ContactMoreInfoUI", "[initFriendSource] source:%s", new Object[] { Integer.valueOf(this.piT.getSource()) });
      switch (this.piT.getSource())
      {
      default: 
        this.vJI.vNf = null;
      }
    }
    for (;;)
    {
      this.vJI.dqG();
      S(this.piT);
      if (this.piT.field_username.equals(u.axw())) {
        break label1740;
      }
      localObject1 = this.piT;
      if (!((av)localObject1).field_username.equals(u.axw())) {
        break label1654;
      }
      this.vJF.setVisibility(8);
      AppMethodBeat.o(27033);
      return;
      i = 0;
      break;
      label926:
      this.vJB.setVisibility(8);
      break label329;
      label938:
      this.vJD.setVisibility(8);
      break label566;
      this.vJI.Lu(2131759467);
      continue;
      if (this.piT.aaU() > 1000000)
      {
        this.vJI.Lu(2131757862);
      }
      else
      {
        this.vJI.Lu(2131757861);
        continue;
        if (this.piT.aaU() > 1000000)
        {
          this.vJI.Lu(2131757865);
        }
        else
        {
          this.vJI.Lu(2131757864);
          continue;
          if (this.piT.aaU() > 1000000)
          {
            this.vJI.Lu(2131757842);
          }
          else
          {
            this.vJI.Lu(2131757839);
            continue;
            if (this.piT.aaU() > 1000000)
            {
              this.vJI.Lu(2131757850);
            }
            else
            {
              this.vJI.Lu(2131757849);
              continue;
              if (this.piT.aaU() > 1000000)
              {
                this.vJI.Lu(2131757855);
              }
              else
              {
                this.vJI.Lu(2131757854);
                continue;
                this.vJI.Lu(2131757857);
                continue;
                localObject1 = this.piT.field_sourceExtInfo;
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)localObject1);
                if ((localObject1 == null) || (bs.isNullOrNil(((av)localObject1).field_username)))
                {
                  localObject1 = null;
                  label1234:
                  if (this.piT.aaU() <= 1000000) {
                    break label1357;
                  }
                  if (bs.isNullOrNil((String)localObject1)) {
                    break label1345;
                  }
                }
                label1345:
                for (localObject1 = getString(2131757848, new Object[] { localObject1 });; localObject1 = getString(2131757846))
                {
                  localObject2 = this.vJI;
                  ((ProfileNormalItemView)localObject2).vFY.setMaxLines(5);
                  ((ProfileNormalItemView)localObject2).vFY.setEllipsize(TextUtils.TruncateAt.END);
                  this.vJI.vNf = ((CharSequence)localObject1);
                  break;
                  if (bs.isNullOrNil(((av)localObject1).field_nickname))
                  {
                    localObject1 = q.vS(((av)localObject1).field_username);
                    break label1234;
                  }
                  localObject1 = ((av)localObject1).field_nickname;
                  break label1234;
                }
                label1357:
                if (!bs.isNullOrNil((String)localObject1)) {}
                for (localObject1 = getString(2131757847, new Object[] { localObject1 });; localObject1 = getString(2131757845))
                {
                  this.vJI.vNf = ((CharSequence)localObject1);
                  break;
                }
                if (this.piT.aaU() > 1000000)
                {
                  this.vJI.Lu(2131757868);
                }
                else
                {
                  this.vJI.Lu(2131757867);
                  continue;
                  this.vJI.Lu(2131757834);
                  continue;
                  this.vJI.Lu(2131760022);
                  continue;
                  this.vJI.Lu(2131757852);
                  continue;
                  if (this.piT.aaU() > 1000000)
                  {
                    this.vJI.Lu(2131757871);
                  }
                  else
                  {
                    this.vJI.Lu(2131757870);
                    continue;
                    if (this.piT.aaU() > 1000000)
                    {
                      this.vJI.Lu(2131757871);
                    }
                    else
                    {
                      this.vJI.Lu(2131757870);
                      continue;
                      if (this.piT.aaU() > 1000000)
                      {
                        this.vJI.Lu(2131757837);
                      }
                      else
                      {
                        this.vJI.Lu(2131757836);
                        continue;
                        if (this.piT.aaU() > 1000000) {
                          this.vJI.Lu(2131757859);
                        } else {
                          this.vJI.Lu(2131757858);
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
    if (((av)localObject1).exL == 1) {
      this.vJF.Lt(2131757634);
    }
    for (;;)
    {
      this.vJF.dqG();
      localObject2 = new j();
      ((j)localObject2).query = ((av)localObject1).field_username;
      ((j)localObject2).syI = this;
      ((j)localObject2).handler = this.handler;
      ((j)localObject2).jwR = 5;
      ((n)com.tencent.mm.kernel.g.ad(n.class)).search(2, (j)localObject2);
      label1740:
      AppMethodBeat.o(27033);
      return;
      if (((av)localObject1).exL == 2) {
        this.vJF.Lt(2131757633);
      } else {
        this.vJF.Lt(2131757638);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27036);
    AppMethodBeat.o(27036);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27032);
    super.onCreate(paramBundle);
    this.fxr = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.fvZ = getIntent().getStringExtra("Contact_ChatRoomId");
    this.foE = getIntent().getStringExtra("Contact_User");
    az.ayM();
    this.piT = c.awB().aNt(this.foE);
    this.vJJ = getIntent().getStringExtra("KLinkedInAddFriendNickName");
    this.vJK = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
    this.vJL = getIntent().getStringExtra("verify_gmail");
    this.vJM = getIntent().getStringExtra("profileName");
    if (!bs.isNullOrNil(this.fvZ))
    {
      az.ayM();
      this.ftP = c.awK().xN(this.fvZ);
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