package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils.TruncateAt;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactMoreInfoUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.plugin.fts.a.l
{
  private String fIQ;
  ac fNS;
  private String fRo;
  boolean fSK;
  private aq handler;
  private an pSY;
  private ProfileNormalItemView xgB;
  private ProfileNormalItemView xgC;
  private ProfileNormalItemView xgD;
  private ProfileNormalItemView xgE;
  private ProfileNormalItemView xgF;
  private ProfileNormalItemView xgG;
  private ProfileNormalItemView xgH;
  private ProfileNormalItemView xgI;
  private String xgJ;
  private String xgK;
  private String xgL;
  private String xgM;
  private long xgN;
  private String xgO;
  String xgP;
  
  public ContactMoreInfoUI()
  {
    AppMethodBeat.i(27031);
    this.xgP = null;
    this.fSK = false;
    this.handler = new aq(Looper.getMainLooper());
    AppMethodBeat.o(27031);
  }
  
  private boolean Z(an paraman)
  {
    AppMethodBeat.i(27034);
    if (v.aAC().equals(paraman.field_username))
    {
      bc.aCg();
      paraman = (String)c.ajA().get(am.a.INH, null);
      if (bu.isNullOrNil(paraman)) {
        break label164;
      }
    }
    for (;;)
    {
      try
      {
        paraman = new JSONObject(paraman);
        this.xgP = paraman.optString("ShopUrl");
        paraman = paraman.optString("ShopName");
        if (bu.isNullOrNil(this.xgP)) {
          break label169;
        }
        this.xgG.setVisibility(0);
        this.xgG.xkf = paraman;
        this.xgG.ND(getResources().getColor(2131100763));
        paraman = this.xgG;
        paraman.xkg = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27027);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", ContactMoreInfoUI.this.xgP);
            paramAnonymousView.putExtra("geta8key_username", v.aAC());
            d.b(ContactMoreInfoUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27027);
          }
        };
        paraman.dEA();
        AppMethodBeat.o(27034);
        return true;
      }
      catch (JSONException paraman)
      {
        ae.printErrStackTrace("MicroMsg.ContactMoreInfoUI", paraman, "", new Object[0]);
      }
      paraman = paraman.eRt;
      break;
      label164:
      paraman = null;
    }
    label169:
    this.xgG.setVisibility(8);
    AppMethodBeat.o(27034);
    return false;
  }
  
  public final void b(com.tencent.mm.plugin.fts.a.a.k paramk)
  {
    AppMethodBeat.i(27035);
    if (paramk.bZU == 0)
    {
      final int i = ((Integer)((m)paramk.tGc.get(0)).userData).intValue();
      this.xgF.xkf = getString(2131757637, new Object[] { Integer.valueOf(i) });
      this.xgF.xkg = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27030);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          com.tencent.mm.plugin.fts.a.e.Hl(i);
          if (i > 0)
          {
            localObject = new Intent(ContactMoreInfoUI.this, CommonChatroomInfoUI.class);
            ((Intent)localObject).putExtra("Select_Talker_Name", ContactMoreInfoUI.b(ContactMoreInfoUI.this).field_username);
            paramAnonymousView = ContactMoreInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27030);
        }
      };
    }
    for (;;)
    {
      this.xgF.dEA();
      AppMethodBeat.o(27035);
      return;
      this.xgF.xkf = getString(2131757637, new Object[] { Integer.valueOf(0) });
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27026);
        ContactMoreInfoUI.this.finish();
        AppMethodBeat.o(27026);
        return true;
      }
    });
    this.xgB = ((ProfileNormalItemView)findViewById(2131301437));
    this.xgC = ((ProfileNormalItemView)findViewById(2131300600));
    this.xgD = ((ProfileNormalItemView)findViewById(2131303554));
    this.xgE = ((ProfileNormalItemView)findViewById(2131299151));
    this.xgE.setVisibility(8);
    this.xgE.mTitle = getString(2131757644);
    this.xgH = ((ProfileNormalItemView)findViewById(2131304822));
    this.xgH.NB(2131757822);
    this.xgH.xcS.setSingleLine(false);
    this.xgI = ((ProfileNormalItemView)findViewById(2131300302));
    this.xgI.NB(2131757874);
    this.xgG = ((ProfileNormalItemView)findViewById(2131306965));
    this.xgF = ((ProfileNormalItemView)findViewById(2131298546));
    this.xgF.xkh.setVisibility(0);
    Object localObject1 = com.tencent.mm.n.g.acL().getValue("LinkedinPluginClose");
    int i;
    label329:
    Object localObject2;
    if ((bu.isNullOrNil((String)localObject1)) || (bu.getInt((String)localObject1, 0) == 0))
    {
      i = 1;
      if ((i == 0) || (bu.isNullOrNil(this.pSY.eRq))) {
        break label926;
      }
      this.xgB.setVisibility(0);
      if (bu.isNullOrNil(this.xgJ)) {
        this.xgJ = this.pSY.eRr;
      }
      localObject1 = this.xgB;
      ((ProfileNormalItemView)localObject1).xkf = this.xgJ;
      ((ProfileNormalItemView)localObject1).xkg = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27028);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (bu.isNullOrNil(ContactMoreInfoUI.a(ContactMoreInfoUI.this))) {
            ContactMoreInfoUI.a(ContactMoreInfoUI.this, ContactMoreInfoUI.b(ContactMoreInfoUI.this).eRs);
          }
          if (!bu.isNullOrNil(ContactMoreInfoUI.a(ContactMoreInfoUI.this)))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", ContactMoreInfoUI.a(ContactMoreInfoUI.this));
            paramAnonymousView.putExtra("geta8key_username", v.aAC());
            d.b(ContactMoreInfoUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27028);
        }
      };
      ((ProfileNormalItemView)localObject1).ND(getResources().getColor(2131100763)).dEA();
      this.xgC.setVisibility(0);
      localObject1 = this.xgC;
      ((ProfileNormalItemView)localObject1).xkf = this.xgL;
      ((ProfileNormalItemView)localObject1).dEA();
      bc.aCg();
      i = bu.o((Integer)c.ajA().get(9, null));
      this.xgN = getIntent().getLongExtra("Contact_Uin", 0L);
      this.xgO = getIntent().getStringExtra("Contact_QQNick");
      if ((this.xgN == 0L) || (i == 0)) {
        break label938;
      }
      if ((this.xgO == null) || (this.xgO.length() == 0))
      {
        long l = this.xgN;
        localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().sO(l);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = null;
        }
        if (localObject1 != null) {
          this.xgO = ((as)localObject1).getDisplayName();
        }
      }
      localObject1 = bu.nullAsNil(this.xgO);
      localObject1 = (String)localObject1 + " " + new p(this.xgN).longValue();
      this.xgD.setVisibility(0);
      localObject2 = this.xgD;
      ((ProfileNormalItemView)localObject2).xkf = ((CharSequence)localObject1);
      ((ProfileNormalItemView)localObject2).xkg = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27029);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27029);
        }
      };
      ((ProfileNormalItemView)localObject2).dEA();
      label566:
      localObject1 = this.xgH;
      ((ProfileNormalItemView)localObject1).xkf = com.tencent.mm.pluginsdk.ui.span.k.c(this, this.pSY.signature);
      ((ProfileNormalItemView)localObject1).dEA();
      ae.i("MicroMsg.ContactMoreInfoUI", "[initFriendSource] source:%s", new Object[] { Integer.valueOf(this.pSY.getSource()) });
      switch (this.pSY.getSource())
      {
      default: 
        this.xgI.xkf = null;
      }
    }
    for (;;)
    {
      this.xgI.dEA();
      Z(this.pSY);
      if (this.pSY.field_username.equals(v.aAC())) {
        break label1740;
      }
      localObject1 = this.pSY;
      if (!((aw)localObject1).field_username.equals(v.aAC())) {
        break label1654;
      }
      this.xgF.setVisibility(8);
      AppMethodBeat.o(27033);
      return;
      i = 0;
      break;
      label926:
      this.xgB.setVisibility(8);
      break label329;
      label938:
      this.xgD.setVisibility(8);
      break label566;
      this.xgI.NC(2131759467);
      continue;
      if (this.pSY.adI() > 1000000)
      {
        this.xgI.NC(2131757862);
      }
      else
      {
        this.xgI.NC(2131757861);
        continue;
        if (this.pSY.adI() > 1000000)
        {
          this.xgI.NC(2131757865);
        }
        else
        {
          this.xgI.NC(2131757864);
          continue;
          if (this.pSY.adI() > 1000000)
          {
            this.xgI.NC(2131757842);
          }
          else
          {
            this.xgI.NC(2131757839);
            continue;
            if (this.pSY.adI() > 1000000)
            {
              this.xgI.NC(2131757850);
            }
            else
            {
              this.xgI.NC(2131757849);
              continue;
              if (this.pSY.adI() > 1000000)
              {
                this.xgI.NC(2131757855);
              }
              else
              {
                this.xgI.NC(2131757854);
                continue;
                this.xgI.NC(2131757857);
                continue;
                localObject1 = this.pSY.field_sourceExtInfo;
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH((String)localObject1);
                if ((localObject1 == null) || (bu.isNullOrNil(((aw)localObject1).field_username)))
                {
                  localObject1 = null;
                  label1234:
                  if (this.pSY.adI() <= 1000000) {
                    break label1357;
                  }
                  if (bu.isNullOrNil((String)localObject1)) {
                    break label1345;
                  }
                }
                label1345:
                for (localObject1 = getString(2131757848, new Object[] { localObject1 });; localObject1 = getString(2131757846))
                {
                  localObject2 = this.xgI;
                  ((ProfileNormalItemView)localObject2).xcS.setMaxLines(5);
                  ((ProfileNormalItemView)localObject2).xcS.setEllipsize(TextUtils.TruncateAt.END);
                  this.xgI.xkf = ((CharSequence)localObject1);
                  break;
                  if (bu.isNullOrNil(((aw)localObject1).field_nickname))
                  {
                    localObject1 = r.zt(((aw)localObject1).field_username);
                    break label1234;
                  }
                  localObject1 = ((aw)localObject1).field_nickname;
                  break label1234;
                }
                label1357:
                if (!bu.isNullOrNil((String)localObject1)) {}
                for (localObject1 = getString(2131757847, new Object[] { localObject1 });; localObject1 = getString(2131757845))
                {
                  this.xgI.xkf = ((CharSequence)localObject1);
                  break;
                }
                if (this.pSY.adI() > 1000000)
                {
                  this.xgI.NC(2131757868);
                }
                else
                {
                  this.xgI.NC(2131757867);
                  continue;
                  this.xgI.NC(2131757834);
                  continue;
                  this.xgI.NC(2131760022);
                  continue;
                  this.xgI.NC(2131757852);
                  continue;
                  if (this.pSY.adI() > 1000000)
                  {
                    this.xgI.NC(2131757871);
                  }
                  else
                  {
                    this.xgI.NC(2131757870);
                    continue;
                    if (this.pSY.adI() > 1000000)
                    {
                      this.xgI.NC(2131757871);
                    }
                    else
                    {
                      this.xgI.NC(2131757870);
                      continue;
                      if (this.pSY.adI() > 1000000)
                      {
                        this.xgI.NC(2131757837);
                      }
                      else
                      {
                        this.xgI.NC(2131757836);
                        continue;
                        if (this.pSY.adI() > 1000000) {
                          this.xgI.NC(2131757859);
                        } else {
                          this.xgI.NC(2131757858);
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
    if (((aw)localObject1).eQV == 1) {
      this.xgF.NB(2131757634);
    }
    for (;;)
    {
      this.xgF.dEA();
      localObject2 = new j();
      ((j)localObject2).query = ((aw)localObject1).field_username;
      ((j)localObject2).tGa = this;
      ((j)localObject2).handler = this.handler;
      ((j)localObject2).jUf = 5;
      ((n)com.tencent.mm.kernel.g.ad(n.class)).search(2, (j)localObject2);
      label1740:
      AppMethodBeat.o(27033);
      return;
      if (((aw)localObject1).eQV == 2) {
        this.xgF.NB(2131757633);
      } else {
        this.xgF.NB(2131757638);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27036);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(27036);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27032);
    super.onCreate(paramBundle);
    this.fSK = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.fRo = getIntent().getStringExtra("Contact_ChatRoomId");
    this.fIQ = getIntent().getStringExtra("Contact_User");
    bc.aCg();
    this.pSY = c.azF().BH(this.fIQ);
    this.xgJ = getIntent().getStringExtra("KLinkedInAddFriendNickName");
    this.xgK = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
    this.xgL = getIntent().getStringExtra("verify_gmail");
    this.xgM = getIntent().getStringExtra("profileName");
    if (!bu.isNullOrNil(this.fRo))
    {
      bc.aCg();
      this.fNS = c.azP().Bx(this.fRo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI
 * JD-Core Version:    0.7.0.1
 */