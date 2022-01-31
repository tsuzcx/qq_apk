package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.a.o;
import com.tencent.mm.m.e;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  implements com.tencent.mm.plugin.fts.a.l
{
  private String djD;
  u dnL;
  boolean dpA = false;
  private String dpj;
  private ah handler = new ah(Looper.getMainLooper());
  private ad jgl;
  private String liF;
  private ProfileNormalItemView mWg;
  private ProfileNormalItemView mWh;
  private ProfileNormalItemView mWi;
  private ProfileNormalItemView mWj;
  private ProfileNormalItemView mWk;
  private ProfileNormalItemView mWl;
  private ProfileNormalItemView mWm;
  private String mWn;
  private String mWo;
  private String mWp;
  private long mWq;
  private String mWr;
  String mWs = null;
  
  private boolean K(ad paramad)
  {
    if (q.Gj().equals(paramad.field_username))
    {
      au.Hx();
      paramad = (String)c.Dz().get(ac.a.uqI, null);
      if (bk.bl(paramad)) {
        break label153;
      }
    }
    for (;;)
    {
      try
      {
        paramad = new JSONObject(paramad);
        this.mWs = paramad.optString("ShopUrl");
        paramad = paramad.optString("ShopName");
        if (bk.bl(this.mWs)) {
          break label158;
        }
        this.mWk.setVisibility(0);
        this.mWk.mYY = paramad;
        this.mWk.we(getResources().getColor(R.e.profile_normal_item_view_summary_color));
        paramad = this.mWk;
        paramad.mYZ = new ContactMoreInfoUI.2(this);
        paramad.bsP();
        return true;
      }
      catch (JSONException paramad)
      {
        y.printErrStackTrace("MicroMsg.ContactMoreInfoUI", paramad, "", new Object[0]);
      }
      paramad = paramad.cCO;
      break;
      label153:
      paramad = null;
    }
    label158:
    this.mWk.setVisibility(8);
    return false;
  }
  
  private void bsv()
  {
    this.dpA = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.dpj = getIntent().getStringExtra("Contact_ChatRoomId");
    this.djD = getIntent().getStringExtra("Contact_User");
    au.Hx();
    this.jgl = c.Fw().abl(this.djD);
    this.mWn = getIntent().getStringExtra("KLinkedInAddFriendNickName");
    this.mWo = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
    this.liF = getIntent().getStringExtra("verify_gmail");
    this.mWp = getIntent().getStringExtra("profileName");
  }
  
  public final void b(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    if (paramj.aYY == 0)
    {
      int i = ((Integer)((com.tencent.mm.plugin.fts.a.a.l)paramj.kxh.get(0)).userData).intValue();
      this.mWj.mYY = getString(R.l.contact_info_common_chatroom_number, new Object[] { Integer.valueOf(i) });
      this.mWj.mYZ = new ContactMoreInfoUI.5(this, i);
    }
    for (;;)
    {
      this.mWj.bsP();
      return;
      this.mWj.mYY = getString(R.l.contact_info_common_chatroom_number, new Object[] { Integer.valueOf(0) });
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.contact_info_more_ui;
  }
  
  protected final void initView()
  {
    int j = 0;
    super.initView();
    this.mWg = ((ProfileNormalItemView)findViewById(R.h.linkedin));
    this.mWh = ((ProfileNormalItemView)findViewById(R.h.google_plus));
    this.mWi = ((ProfileNormalItemView)findViewById(R.h.qq));
    this.mWl = ((ProfileNormalItemView)findViewById(R.h.signature));
    this.mWl.wc(R.l.contact_info_signature);
    this.mWl.mTp.setSingleLine(false);
    this.mWm = ((ProfileNormalItemView)findViewById(R.h.friend_source));
    this.mWm.wc(R.l.contact_info_source_title);
    this.mWk = ((ProfileNormalItemView)findViewById(R.h.weishop));
    this.mWj = ((ProfileNormalItemView)findViewById(R.h.common_chatroom));
    setBackBtn(new ContactMoreInfoUI.1(this));
    bsv();
    au.Hx();
    this.dnL = c.FF().in(this.dpj);
    Object localObject1 = com.tencent.mm.m.g.AA().getValue("LinkedinPluginClose");
    boolean bool1;
    label298:
    boolean bool3;
    Object localObject2;
    boolean bool2;
    label539:
    boolean bool4;
    label800:
    boolean bool5;
    boolean bool6;
    if ((bk.bl((String)localObject1)) || (Integer.valueOf((String)localObject1).intValue() == 0))
    {
      i = 1;
      if ((i == 0) || (bk.bl(this.jgl.cCL))) {
        break label928;
      }
      this.mWg.setVisibility(0);
      if (bk.bl(this.mWn)) {
        this.mWn = this.jgl.cCM;
      }
      localObject1 = this.mWg;
      ((ProfileNormalItemView)localObject1).mYY = this.mWn;
      ((ProfileNormalItemView)localObject1).mYZ = new ContactMoreInfoUI.3(this);
      bool1 = ((ProfileNormalItemView)localObject1).we(getResources().getColor(R.e.profile_normal_item_view_summary_color)).bsP();
      this.mWh.setVisibility(0);
      localObject1 = this.mWh;
      ((ProfileNormalItemView)localObject1).mYY = this.liF;
      bool3 = ((ProfileNormalItemView)localObject1).bsP();
      au.Hx();
      i = bk.g((Integer)c.Dz().get(9, null));
      this.mWq = getIntent().getLongExtra("Contact_Uin", 0L);
      this.mWr = getIntent().getStringExtra("Contact_QQNick");
      if ((this.mWq == 0L) || (i == 0)) {
        break label942;
      }
      if ((this.mWr == null) || (this.mWr.length() == 0))
      {
        long l = this.mWq;
        localObject2 = b.getQQListStg().cr(l);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = null;
        }
        if (localObject1 != null) {
          this.mWr = ((com.tencent.mm.plugin.account.friend.a.ao)localObject1).getDisplayName();
        }
      }
      localObject1 = bk.pm(this.mWr);
      localObject1 = (String)localObject1 + " " + new o(this.mWq).longValue();
      this.mWi.setVisibility(0);
      localObject2 = this.mWi;
      ((ProfileNormalItemView)localObject2).mYY = ((CharSequence)localObject1);
      ((ProfileNormalItemView)localObject2).mYZ = new ContactMoreInfoUI.4(this);
      bool2 = ((ProfileNormalItemView)localObject2).bsP();
      localObject1 = this.mWl;
      ((ProfileNormalItemView)localObject1).mYY = com.tencent.mm.pluginsdk.ui.d.j.b(this, this.jgl.signature);
      bool4 = ((ProfileNormalItemView)localObject1).bsP();
      switch (this.jgl.getSource())
      {
      default: 
        this.mWm.mYY = null;
        bool5 = this.mWm.bsP();
        bool6 = K(this.jgl);
        i = j;
        if (!this.jgl.field_username.equals(q.Gj()))
        {
          localObject1 = this.jgl;
          if ((!ad.aaU(((com.tencent.mm.h.c.ao)localObject1).field_username)) && (!((com.tencent.mm.h.c.ao)localObject1).field_username.equals(q.Gj()))) {
            break label1478;
          }
        }
        break;
      }
    }
    label928:
    label942:
    label1478:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label1483;
      }
      this.mWj.setVisibility(8);
      i = j;
      if ((!bool4) && (!bool5) && (!bool6) && (!bool1) && (!bool3) && (!bool2) && (i == 0)) {
        finish();
      }
      return;
      i = 0;
      break;
      this.mWg.setVisibility(8);
      bool1 = false;
      break label298;
      this.mWi.setVisibility(8);
      bool2 = false;
      break label539;
      this.mWm.wd(R.l.fmessage_come_from_qq);
      break label800;
      if (this.jgl.Bs() > 1000000)
      {
        this.mWm.wd(R.l.contact_info_source_by_search_qq_passive);
        break label800;
      }
      this.mWm.wd(R.l.contact_info_source_by_search_qq);
      break label800;
      if (this.jgl.Bs() > 1000000)
      {
        this.mWm.wd(R.l.contact_info_source_by_search_wechat_passive);
        break label800;
      }
      this.mWm.wd(R.l.contact_info_source_by_search_wechat);
      break label800;
      if (this.jgl.Bs() > 1000000)
      {
        this.mWm.wd(R.l.contact_info_source_by_card_passive);
        break label800;
      }
      this.mWm.wd(R.l.contact_info_source_by_card);
      break label800;
      if (this.jgl.Bs() > 1000000)
      {
        this.mWm.wd(R.l.contact_info_source_by_lbs_passive);
        break label800;
      }
      this.mWm.wd(R.l.contact_info_source_by_lbs);
      break label800;
      if (this.jgl.Bs() > 1000000)
      {
        this.mWm.wd(R.l.contact_info_source_by_qrcode_passive);
        break label800;
      }
      this.mWm.wd(R.l.contact_info_source_by_qrcode);
      break label800;
      this.mWm.wd(R.l.contact_info_source_by_raddar);
      break label800;
      if (this.jgl.Bs() > 1000000)
      {
        this.mWm.wd(R.l.contact_info_source_by_chatroom_passive);
        break label800;
      }
      this.mWm.wd(R.l.contact_info_source_by_chatroom);
      break label800;
      if (this.jgl.Bs() > 1000000)
      {
        this.mWm.wd(R.l.contact_info_source_by_shake_passive);
        break label800;
      }
      this.mWm.wd(R.l.contact_info_source_by_shake);
      break label800;
      this.mWm.wd(R.l.contact_info_source_brandqa);
      break label800;
      this.mWm.wd(R.l.gcontact_from_source);
      break label800;
      this.mWm.wd(R.l.contact_info_source_by_linkedin);
      break label800;
      if (this.jgl.Bs() > 1000000)
      {
        this.mWm.wd(R.l.contact_info_source_by_view_address_book_passive);
        break label800;
      }
      this.mWm.wd(R.l.contact_info_source_by_view_address_book);
      break label800;
      if (this.jgl.Bs() > 1000000)
      {
        this.mWm.wd(R.l.contact_info_source_by_view_address_book_passive);
        break label800;
      }
      this.mWm.wd(R.l.contact_info_source_by_view_address_book);
      break label800;
      if (this.jgl.Bs() > 1000000)
      {
        this.mWm.wd(R.l.contact_info_source_by_bottle_passive);
        break label800;
      }
      this.mWm.wd(R.l.contact_info_source_by_bottle);
      break label800;
      if (this.jgl.Bs() > 1000000)
      {
        this.mWm.wd(R.l.contact_info_source_by_search_mobile_passive);
        break label800;
      }
      this.mWm.wd(R.l.contact_info_source_by_search_mobile);
      break label800;
    }
    label1483:
    if (((com.tencent.mm.h.c.ao)localObject1).sex == 1) {
      this.mWj.wc(R.l.contact_info_common_chatroom_male);
    }
    for (;;)
    {
      this.mWj.bsP();
      localObject2 = new i();
      ((i)localObject2).bVk = ((com.tencent.mm.h.c.ao)localObject1).field_username;
      ((i)localObject2).kxf = this;
      ((i)localObject2).handler = this.handler;
      ((i)localObject2).kwX = 5;
      ((n)com.tencent.mm.kernel.g.t(n.class)).search(2, (i)localObject2);
      i = 1;
      break;
      if (((com.tencent.mm.h.c.ao)localObject1).sex == 2) {
        this.mWj.wc(R.l.contact_info_common_chatroom_female);
      } else {
        this.mWj.wc(R.l.contact_info_common_chatroom_unknow);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bsv();
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI
 * JD-Core Version:    0.7.0.1
 */