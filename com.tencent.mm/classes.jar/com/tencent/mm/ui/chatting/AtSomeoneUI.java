package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.n;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI
  extends MMActivity
{
  private static boolean vep = false;
  private u dnL;
  private String drl;
  private String drm;
  private n drn;
  private ListView fry;
  private String mTitle;
  private String talker;
  private AtSomeoneUI.a vhw;
  
  protected static String a(u paramu, String paramString)
  {
    if (paramu == null) {
      return null;
    }
    return paramu.gV(paramString);
  }
  
  protected final int getLayoutId()
  {
    return R.i.at_someone_ui;
  }
  
  protected final void initView()
  {
    boolean bool = true;
    setMMTitle(this.mTitle);
    setBackBtn(new AtSomeoneUI.1(this));
    this.drn = new n((byte)0);
    this.drn.weq = new AtSomeoneUI.2(this);
    a(this.drn);
    this.fry = ((ListView)findViewById(R.h.chatroom_member_lv));
    ad localad = new ad();
    u localu = this.dnL;
    Object localObject1 = null;
    if (!ah.bl(this.drm))
    {
      localObject1 = this.drm.split(",");
      y.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString((Object[])localObject1) });
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.dnL != null)
      {
        y.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
        localObject2 = ah.c(this.dnL.MN(), ",").split(",");
      }
    }
    if (localObject2 == null) {
      if (this.dnL != null) {
        break label304;
      }
    }
    for (;;)
    {
      y.e("MicroMsg.AtSomeoneUI", "WTF! member is null? %s", new Object[] { Boolean.valueOf(bool) });
      localObject1 = new LinkedList();
      if (!ah.bl(this.drl)) {
        localObject1 = ah.h(this.drl.split(","));
      }
      au.Hx();
      bq localbq = c.FE().Ic("@t.qq.com");
      if (localbq != null) {
        ((List)localObject1).add(localbq.name);
      }
      this.vhw = new AtSomeoneUI.a(this, localad, localu, (String[])localObject2, (List)localObject1);
      this.fry.setOnItemClickListener(new AtSomeoneUI.3(this));
      this.fry.setAdapter(this.vhw);
      return;
      label304:
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.drl = getIntent().getStringExtra("Block_list");
    this.drm = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    au.Hx();
    this.dnL = c.FF().in(this.talker);
    if ((this.dnL != null) && (this.dnL.field_roomowner.equals(q.Gj()))) {
      vep = false;
    }
    initView();
  }
  
  protected void onDestroy()
  {
    this.vhw.bcS();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.drn != null) {
      this.drn.cJg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */