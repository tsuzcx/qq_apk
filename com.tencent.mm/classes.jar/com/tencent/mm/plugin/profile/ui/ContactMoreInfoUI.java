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
import com.tencent.mm.a.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.m.e;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactMoreInfoUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.plugin.fts.a.l
{
  private String eaX;
  u efi;
  private String egF;
  boolean egW;
  private ak handler;
  private ad lpe;
  private b pxo;
  private ProfileNormalItemView pyZ;
  private ProfileNormalItemView pza;
  private ProfileNormalItemView pzb;
  private ProfileNormalItemView pzc;
  private ProfileNormalItemView pzd;
  private ProfileNormalItemView pze;
  private ProfileNormalItemView pzf;
  private ProfileNormalItemView pzg;
  private String pzh;
  private String pzi;
  private String pzj;
  private String pzk;
  private long pzl;
  private String pzm;
  String pzn;
  
  public ContactMoreInfoUI()
  {
    AppMethodBeat.i(23410);
    this.pzn = null;
    this.egW = false;
    this.handler = new ak(Looper.getMainLooper());
    AppMethodBeat.o(23410);
  }
  
  private boolean L(ad paramad)
  {
    AppMethodBeat.i(23413);
    if (r.Zn().equals(paramad.field_username))
    {
      aw.aaz();
      paramad = (String)c.Ru().get(ac.a.yAI, null);
      if (bo.isNullOrNil(paramad)) {
        break label164;
      }
    }
    for (;;)
    {
      try
      {
        paramad = new JSONObject(paramad);
        this.pzn = paramad.optString("ShopUrl");
        paramad = paramad.optString("ShopName");
        if (bo.isNullOrNil(this.pzn)) {
          break label169;
        }
        this.pze.setVisibility(0);
        this.pze.pCy = paramad;
        this.pze.BJ(getResources().getColor(2131690782));
        paramad = this.pze;
        paramad.pCz = new ContactMoreInfoUI.2(this);
        paramad.ccG();
        AppMethodBeat.o(23413);
        return true;
      }
      catch (JSONException paramad)
      {
        ab.printErrStackTrace("MicroMsg.ContactMoreInfoUI", paramad, "", new Object[0]);
      }
      paramad = paramad.dqY;
      break;
      label164:
      paramad = null;
    }
    label169:
    this.pze.setVisibility(8);
    AppMethodBeat.o(23413);
    return false;
  }
  
  public final void b(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(23421);
    if (paramj.bpE == 0)
    {
      int i = ((Integer)((com.tencent.mm.plugin.fts.a.a.l)paramj.mSW.get(0)).userData).intValue();
      this.pzd.pCy = getString(2131298578, new Object[] { Integer.valueOf(i) });
      this.pzd.pCz = new ContactMoreInfoUI.5(this, i);
    }
    for (;;)
    {
      this.pzd.ccG();
      AppMethodBeat.o(23421);
      return;
      this.pzd.pCy = getString(2131298578, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public int getLayoutId()
  {
    return 2130969251;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23412);
    super.initView();
    setMMTitle(2131296998);
    setBackBtn(new ContactMoreInfoUI.1(this));
    this.pyZ = ((ProfileNormalItemView)findViewById(2131823159));
    this.pza = ((ProfileNormalItemView)findViewById(2131823161));
    this.pzb = ((ProfileNormalItemView)findViewById(2131823162));
    this.pzc = ((ProfileNormalItemView)findViewById(2131821064));
    this.pzc.setVisibility(8);
    this.pzc.mTitle = getString(2131298585);
    this.pzf = ((ProfileNormalItemView)findViewById(2131823157));
    this.pzf.BH(2131298759);
    this.pzf.pvv.setSingleLine(false);
    this.pzg = ((ProfileNormalItemView)findViewById(2131823158));
    this.pzg.BH(2131298811);
    this.pze = ((ProfileNormalItemView)findViewById(2131823160));
    this.pzd = ((ProfileNormalItemView)findViewById(2131823156));
    this.pzd.pCA.setVisibility(0);
    Object localObject1 = com.tencent.mm.m.g.Nq().getValue("LinkedinPluginClose");
    int i;
    label331:
    Object localObject2;
    if ((bo.isNullOrNil((String)localObject1)) || (Integer.valueOf((String)localObject1).intValue() == 0))
    {
      i = 1;
      if ((i == 0) || (bo.isNullOrNil(this.lpe.dqV))) {
        break label930;
      }
      this.pyZ.setVisibility(0);
      if (bo.isNullOrNil(this.pzh)) {
        this.pzh = this.lpe.dqW;
      }
      localObject1 = this.pyZ;
      ((ProfileNormalItemView)localObject1).pCy = this.pzh;
      ((ProfileNormalItemView)localObject1).pCz = new ContactMoreInfoUI.3(this);
      ((ProfileNormalItemView)localObject1).BJ(getResources().getColor(2131690782)).ccG();
      this.pza.setVisibility(0);
      localObject1 = this.pza;
      ((ProfileNormalItemView)localObject1).pCy = this.pzj;
      ((ProfileNormalItemView)localObject1).ccG();
      aw.aaz();
      i = bo.g((Integer)c.Ru().get(9, null));
      this.pzl = getIntent().getLongExtra("Contact_Uin", 0L);
      this.pzm = getIntent().getStringExtra("Contact_QQNick");
      if ((this.pzl == 0L) || (i == 0)) {
        break label942;
      }
      if ((this.pzm == null) || (this.pzm.length() == 0))
      {
        long l = this.pzl;
        localObject2 = a.getQQListStg().hn(l);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = null;
        }
        if (localObject1 != null) {
          this.pzm = ((ao)localObject1).getDisplayName();
        }
      }
      localObject1 = bo.nullAsNil(this.pzm);
      localObject1 = (String)localObject1 + " " + new p(this.pzl).longValue();
      this.pzb.setVisibility(0);
      localObject2 = this.pzb;
      ((ProfileNormalItemView)localObject2).pCy = ((CharSequence)localObject1);
      ((ProfileNormalItemView)localObject2).pCz = new ContactMoreInfoUI.4(this);
      ((ProfileNormalItemView)localObject2).ccG();
      label568:
      localObject1 = this.pzf;
      ((ProfileNormalItemView)localObject1).pCy = com.tencent.mm.pluginsdk.ui.d.j.b(this, this.lpe.signature);
      ((ProfileNormalItemView)localObject1).ccG();
      ab.i("MicroMsg.ContactMoreInfoUI", "[initFriendSource] source:%s", new Object[] { Integer.valueOf(this.lpe.getSource()) });
      switch (this.lpe.getSource())
      {
      default: 
        this.pzg.pCy = null;
      }
    }
    for (;;)
    {
      this.pzg.ccG();
      L(this.lpe);
      if (this.lpe.field_username.equals(r.Zn())) {
        break label1744;
      }
      localObject1 = this.lpe;
      if (!((aq)localObject1).field_username.equals(r.Zn())) {
        break label1658;
      }
      this.pzd.setVisibility(8);
      AppMethodBeat.o(23412);
      return;
      i = 0;
      break;
      label930:
      this.pyZ.setVisibility(8);
      break label331;
      label942:
      this.pzb.setVisibility(8);
      break label568;
      this.pzg.BI(2131300001);
      continue;
      if (this.lpe.Oh() > 1000000)
      {
        this.pzg.BI(2131298799);
      }
      else
      {
        this.pzg.BI(2131298798);
        continue;
        if (this.lpe.Oh() > 1000000)
        {
          this.pzg.BI(2131298802);
        }
        else
        {
          this.pzg.BI(2131298801);
          continue;
          if (this.lpe.Oh() > 1000000)
          {
            this.pzg.BI(2131298779);
          }
          else
          {
            this.pzg.BI(2131298776);
            continue;
            if (this.lpe.Oh() > 1000000)
            {
              this.pzg.BI(2131298787);
            }
            else
            {
              this.pzg.BI(2131298786);
              continue;
              if (this.lpe.Oh() > 1000000)
              {
                this.pzg.BI(2131298792);
              }
              else
              {
                this.pzg.BI(2131298791);
                continue;
                this.pzg.BI(2131298794);
                continue;
                localObject1 = this.lpe.field_sourceExtInfo;
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw((String)localObject1);
                if ((localObject1 == null) || (bo.isNullOrNil(((aq)localObject1).field_username)))
                {
                  localObject1 = null;
                  label1238:
                  if (this.lpe.Oh() <= 1000000) {
                    break label1361;
                  }
                  if (bo.isNullOrNil((String)localObject1)) {
                    break label1349;
                  }
                }
                label1349:
                for (localObject1 = getString(2131298785, new Object[] { localObject1 });; localObject1 = getString(2131298783))
                {
                  localObject2 = this.pzg;
                  ((ProfileNormalItemView)localObject2).pvv.setMaxLines(5);
                  ((ProfileNormalItemView)localObject2).pvv.setEllipsize(TextUtils.TruncateAt.END);
                  this.pzg.pCy = ((CharSequence)localObject1);
                  break;
                  if (bo.isNullOrNil(((aq)localObject1).field_nickname))
                  {
                    localObject1 = com.tencent.mm.model.n.nm(((aq)localObject1).field_username);
                    break label1238;
                  }
                  localObject1 = ((aq)localObject1).field_nickname;
                  break label1238;
                }
                label1361:
                if (!bo.isNullOrNil((String)localObject1)) {}
                for (localObject1 = getString(2131298784, new Object[] { localObject1 });; localObject1 = getString(2131298782))
                {
                  this.pzg.pCy = ((CharSequence)localObject1);
                  break;
                }
                if (this.lpe.Oh() > 1000000)
                {
                  this.pzg.BI(2131298805);
                }
                else
                {
                  this.pzg.BI(2131298804);
                  continue;
                  this.pzg.BI(2131298771);
                  continue;
                  this.pzg.BI(2131300486);
                  continue;
                  this.pzg.BI(2131298789);
                  continue;
                  if (this.lpe.Oh() > 1000000)
                  {
                    this.pzg.BI(2131298808);
                  }
                  else
                  {
                    this.pzg.BI(2131298807);
                    continue;
                    if (this.lpe.Oh() > 1000000)
                    {
                      this.pzg.BI(2131298808);
                    }
                    else
                    {
                      this.pzg.BI(2131298807);
                      continue;
                      if (this.lpe.Oh() > 1000000)
                      {
                        this.pzg.BI(2131298774);
                      }
                      else
                      {
                        this.pzg.BI(2131298773);
                        continue;
                        if (this.lpe.Oh() > 1000000) {
                          this.pzg.BI(2131298796);
                        } else {
                          this.pzg.BI(2131298795);
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
    label1658:
    if (((aq)localObject1).dqC == 1) {
      this.pzd.BH(2131298575);
    }
    for (;;)
    {
      this.pzd.ccG();
      localObject2 = new i();
      ((i)localObject2).query = ((aq)localObject1).field_username;
      ((i)localObject2).mSU = this;
      ((i)localObject2).handler = this.handler;
      ((i)localObject2).hdl = 5;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fts.a.n.class)).search(2, (i)localObject2);
      label1744:
      AppMethodBeat.o(23412);
      return;
      if (((aq)localObject1).dqC == 2) {
        this.pzd.BH(2131298574);
      } else {
        this.pzd.BH(2131298579);
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23411);
    super.onCreate(paramBundle);
    this.egW = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.egF = getIntent().getStringExtra("Contact_ChatRoomId");
    this.eaX = getIntent().getStringExtra("Contact_User");
    aw.aaz();
    this.lpe = c.YA().arw(this.eaX);
    this.pzh = getIntent().getStringExtra("KLinkedInAddFriendNickName");
    this.pzi = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
    this.pzj = getIntent().getStringExtra("verify_gmail");
    this.pzk = getIntent().getStringExtra("profileName");
    if (!bo.isNullOrNil(this.egF))
    {
      aw.aaz();
      this.efi = c.YJ().oU(this.egF);
    }
    this.pxo = new b(this, this.lpe);
    initView();
    AppMethodBeat.o(23411);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI
 * JD-Core Version:    0.7.0.1
 */