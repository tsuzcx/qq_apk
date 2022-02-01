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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactMoreInfoUI
  extends MMActivity
  implements View.OnClickListener, l
{
  private String flk;
  w fql;
  private String fss;
  boolean ftK;
  private ap handler;
  private af oFt;
  private ProfileNormalItemView uAI;
  private ProfileNormalItemView uAJ;
  private ProfileNormalItemView uAK;
  private ProfileNormalItemView uAL;
  private ProfileNormalItemView uAM;
  private ProfileNormalItemView uAN;
  private ProfileNormalItemView uAO;
  private ProfileNormalItemView uAP;
  private String uAQ;
  private String uAR;
  private String uAS;
  private String uAT;
  private long uAU;
  private String uAV;
  String uAW;
  
  public ContactMoreInfoUI()
  {
    AppMethodBeat.i(27031);
    this.uAW = null;
    this.ftK = false;
    this.handler = new ap(Looper.getMainLooper());
    AppMethodBeat.o(27031);
  }
  
  private boolean R(af paramaf)
  {
    AppMethodBeat.i(27034);
    if (u.aqG().equals(paramaf.field_username))
    {
      az.arV();
      paramaf = (String)c.afk().get(ae.a.Fje, null);
      if (bt.isNullOrNil(paramaf)) {
        break label164;
      }
    }
    for (;;)
    {
      try
      {
        paramaf = new JSONObject(paramaf);
        this.uAW = paramaf.optString("ShopUrl");
        paramaf = paramaf.optString("ShopName");
        if (bt.isNullOrNil(this.uAW)) {
          break label169;
        }
        this.uAN.setVisibility(0);
        this.uAN.uEo = paramaf;
        this.uAN.Jw(getResources().getColor(2131100763));
        paramaf = this.uAN;
        paramaf.uEp = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27027);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", ContactMoreInfoUI.this.uAW);
            paramAnonymousView.putExtra("geta8key_username", u.aqG());
            d.b(ContactMoreInfoUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            AppMethodBeat.o(27027);
          }
        };
        paramaf.dcY();
        AppMethodBeat.o(27034);
        return true;
      }
      catch (JSONException paramaf)
      {
        ad.printErrStackTrace("MicroMsg.ContactMoreInfoUI", paramaf, "", new Object[0]);
      }
      paramaf = paramaf.evN;
      break;
      label164:
      paramaf = null;
    }
    label169:
    this.uAN.setVisibility(8);
    AppMethodBeat.o(27034);
    return false;
  }
  
  public final void b(com.tencent.mm.plugin.fts.a.a.k paramk)
  {
    AppMethodBeat.i(27035);
    if (paramk.bRZ == 0)
    {
      final int i = ((Integer)((m)paramk.rpQ.get(0)).userData).intValue();
      this.uAM.uEo = getString(2131757637, new Object[] { Integer.valueOf(i) });
      this.uAM.uEp = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27030);
          com.tencent.mm.plugin.fts.a.e.DD(i);
          if (i > 0)
          {
            Object localObject = new Intent(ContactMoreInfoUI.this, CommonChatroomInfoUI.class);
            ((Intent)localObject).putExtra("Select_Talker_Name", ContactMoreInfoUI.b(ContactMoreInfoUI.this).field_username);
            paramAnonymousView = ContactMoreInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(27030);
        }
      };
    }
    for (;;)
    {
      this.uAM.dcY();
      AppMethodBeat.o(27035);
      return;
      this.uAM.uEo = getString(2131757637, new Object[] { Integer.valueOf(0) });
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
    this.uAI = ((ProfileNormalItemView)findViewById(2131301437));
    this.uAJ = ((ProfileNormalItemView)findViewById(2131300600));
    this.uAK = ((ProfileNormalItemView)findViewById(2131303554));
    this.uAL = ((ProfileNormalItemView)findViewById(2131299151));
    this.uAL.setVisibility(8);
    this.uAL.mTitle = getString(2131757644);
    this.uAO = ((ProfileNormalItemView)findViewById(2131304822));
    this.uAO.Ju(2131757822);
    this.uAO.uxf.setSingleLine(false);
    this.uAP = ((ProfileNormalItemView)findViewById(2131300302));
    this.uAP.Ju(2131757874);
    this.uAN = ((ProfileNormalItemView)findViewById(2131306965));
    this.uAM = ((ProfileNormalItemView)findViewById(2131298546));
    this.uAM.uEq.setVisibility(0);
    Object localObject1 = com.tencent.mm.m.g.Zd().getValue("LinkedinPluginClose");
    int i;
    label329:
    Object localObject2;
    if ((bt.isNullOrNil((String)localObject1)) || (bt.getInt((String)localObject1, 0) == 0))
    {
      i = 1;
      if ((i == 0) || (bt.isNullOrNil(this.oFt.evK))) {
        break label926;
      }
      this.uAI.setVisibility(0);
      if (bt.isNullOrNil(this.uAQ)) {
        this.uAQ = this.oFt.evL;
      }
      localObject1 = this.uAI;
      ((ProfileNormalItemView)localObject1).uEo = this.uAQ;
      ((ProfileNormalItemView)localObject1).uEp = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27028);
          if (bt.isNullOrNil(ContactMoreInfoUI.a(ContactMoreInfoUI.this))) {
            ContactMoreInfoUI.a(ContactMoreInfoUI.this, ContactMoreInfoUI.b(ContactMoreInfoUI.this).evM);
          }
          if (!bt.isNullOrNil(ContactMoreInfoUI.a(ContactMoreInfoUI.this)))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", ContactMoreInfoUI.a(ContactMoreInfoUI.this));
            paramAnonymousView.putExtra("geta8key_username", u.aqG());
            d.b(ContactMoreInfoUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          AppMethodBeat.o(27028);
        }
      };
      ((ProfileNormalItemView)localObject1).Jw(getResources().getColor(2131100763)).dcY();
      this.uAJ.setVisibility(0);
      localObject1 = this.uAJ;
      ((ProfileNormalItemView)localObject1).uEo = this.uAS;
      ((ProfileNormalItemView)localObject1).dcY();
      az.arV();
      i = bt.l((Integer)c.afk().get(9, null));
      this.uAU = getIntent().getLongExtra("Contact_Uin", 0L);
      this.uAV = getIntent().getStringExtra("Contact_QQNick");
      if ((this.uAU == 0L) || (i == 0)) {
        break label938;
      }
      if ((this.uAV == null) || (this.uAV.length() == 0))
      {
        long l = this.uAU;
        localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().mN(l);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = null;
        }
        if (localObject1 != null) {
          this.uAV = ((as)localObject1).getDisplayName();
        }
      }
      localObject1 = bt.nullAsNil(this.uAV);
      localObject1 = (String)localObject1 + " " + new p(this.uAU).longValue();
      this.uAK.setVisibility(0);
      localObject2 = this.uAK;
      ((ProfileNormalItemView)localObject2).uEo = ((CharSequence)localObject1);
      ((ProfileNormalItemView)localObject2).uEp = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27029);
          AppMethodBeat.o(27029);
        }
      };
      ((ProfileNormalItemView)localObject2).dcY();
      label566:
      localObject1 = this.uAO;
      ((ProfileNormalItemView)localObject1).uEo = com.tencent.mm.pluginsdk.ui.span.k.c(this, this.oFt.signature);
      ((ProfileNormalItemView)localObject1).dcY();
      ad.i("MicroMsg.ContactMoreInfoUI", "[initFriendSource] source:%s", new Object[] { Integer.valueOf(this.oFt.getSource()) });
      switch (this.oFt.getSource())
      {
      default: 
        this.uAP.uEo = null;
      }
    }
    for (;;)
    {
      this.uAP.dcY();
      R(this.oFt);
      if (this.oFt.field_username.equals(u.aqG())) {
        break label1740;
      }
      localObject1 = this.oFt;
      if (!((au)localObject1).field_username.equals(u.aqG())) {
        break label1654;
      }
      this.uAM.setVisibility(8);
      AppMethodBeat.o(27033);
      return;
      i = 0;
      break;
      label926:
      this.uAI.setVisibility(8);
      break label329;
      label938:
      this.uAK.setVisibility(8);
      break label566;
      this.uAP.Jv(2131759467);
      continue;
      if (this.oFt.ZZ() > 1000000)
      {
        this.uAP.Jv(2131757862);
      }
      else
      {
        this.uAP.Jv(2131757861);
        continue;
        if (this.oFt.ZZ() > 1000000)
        {
          this.uAP.Jv(2131757865);
        }
        else
        {
          this.uAP.Jv(2131757864);
          continue;
          if (this.oFt.ZZ() > 1000000)
          {
            this.uAP.Jv(2131757842);
          }
          else
          {
            this.uAP.Jv(2131757839);
            continue;
            if (this.oFt.ZZ() > 1000000)
            {
              this.uAP.Jv(2131757850);
            }
            else
            {
              this.uAP.Jv(2131757849);
              continue;
              if (this.oFt.ZZ() > 1000000)
              {
                this.uAP.Jv(2131757855);
              }
              else
              {
                this.uAP.Jv(2131757854);
                continue;
                this.uAP.Jv(2131757857);
                continue;
                localObject1 = this.oFt.field_sourceExtInfo;
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY((String)localObject1);
                if ((localObject1 == null) || (bt.isNullOrNil(((au)localObject1).field_username)))
                {
                  localObject1 = null;
                  label1234:
                  if (this.oFt.ZZ() <= 1000000) {
                    break label1357;
                  }
                  if (bt.isNullOrNil((String)localObject1)) {
                    break label1345;
                  }
                }
                label1345:
                for (localObject1 = getString(2131757848, new Object[] { localObject1 });; localObject1 = getString(2131757846))
                {
                  localObject2 = this.uAP;
                  ((ProfileNormalItemView)localObject2).uxf.setMaxLines(5);
                  ((ProfileNormalItemView)localObject2).uxf.setEllipsize(TextUtils.TruncateAt.END);
                  this.uAP.uEo = ((CharSequence)localObject1);
                  break;
                  if (bt.isNullOrNil(((au)localObject1).field_nickname))
                  {
                    localObject1 = q.rP(((au)localObject1).field_username);
                    break label1234;
                  }
                  localObject1 = ((au)localObject1).field_nickname;
                  break label1234;
                }
                label1357:
                if (!bt.isNullOrNil((String)localObject1)) {}
                for (localObject1 = getString(2131757847, new Object[] { localObject1 });; localObject1 = getString(2131757845))
                {
                  this.uAP.uEo = ((CharSequence)localObject1);
                  break;
                }
                if (this.oFt.ZZ() > 1000000)
                {
                  this.uAP.Jv(2131757868);
                }
                else
                {
                  this.uAP.Jv(2131757867);
                  continue;
                  this.uAP.Jv(2131757834);
                  continue;
                  this.uAP.Jv(2131760022);
                  continue;
                  this.uAP.Jv(2131757852);
                  continue;
                  if (this.oFt.ZZ() > 1000000)
                  {
                    this.uAP.Jv(2131757871);
                  }
                  else
                  {
                    this.uAP.Jv(2131757870);
                    continue;
                    if (this.oFt.ZZ() > 1000000)
                    {
                      this.uAP.Jv(2131757871);
                    }
                    else
                    {
                      this.uAP.Jv(2131757870);
                      continue;
                      if (this.oFt.ZZ() > 1000000)
                      {
                        this.uAP.Jv(2131757837);
                      }
                      else
                      {
                        this.uAP.Jv(2131757836);
                        continue;
                        if (this.oFt.ZZ() > 1000000) {
                          this.uAP.Jv(2131757859);
                        } else {
                          this.uAP.Jv(2131757858);
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
    if (((au)localObject1).evp == 1) {
      this.uAM.Ju(2131757634);
    }
    for (;;)
    {
      this.uAM.dcY();
      localObject2 = new j();
      ((j)localObject2).query = ((au)localObject1).field_username;
      ((j)localObject2).rpO = this;
      ((j)localObject2).handler = this.handler;
      ((j)localObject2).iWB = 5;
      ((n)com.tencent.mm.kernel.g.ad(n.class)).search(2, (j)localObject2);
      label1740:
      AppMethodBeat.o(27033);
      return;
      if (((au)localObject1).evp == 2) {
        this.uAM.Ju(2131757633);
      } else {
        this.uAM.Ju(2131757638);
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
    this.ftK = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.fss = getIntent().getStringExtra("Contact_ChatRoomId");
    this.flk = getIntent().getStringExtra("Contact_User");
    az.arV();
    this.oFt = c.apM().aHY(this.flk);
    this.uAQ = getIntent().getStringExtra("KLinkedInAddFriendNickName");
    this.uAR = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
    this.uAS = getIntent().getStringExtra("verify_gmail");
    this.uAT = getIntent().getStringExtra("profileName");
    if (!bt.isNullOrNil(this.fss))
    {
      az.arV();
      this.fql = c.apV().tH(this.fss);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI
 * JD-Core Version:    0.7.0.1
 */