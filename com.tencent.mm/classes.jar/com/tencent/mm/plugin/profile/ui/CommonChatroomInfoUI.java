package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;

public class CommonChatroomInfoUI
  extends MMBaseSelectContactUI
{
  private ad dnp;
  private a mVD;
  private b mVE;
  
  protected final boolean VC()
  {
    return true;
  }
  
  protected final boolean VD()
  {
    return false;
  }
  
  protected final String VE()
  {
    if (this.dnp.sex == 1) {
      return getString(R.l.contact_info_common_chatroom_male);
    }
    if (this.dnp.sex == 2) {
      return getString(R.l.contact_info_common_chatroom_female);
    }
    return getString(R.l.contact_info_common_chatroom_unknow);
  }
  
  protected final o VF()
  {
    if (this.mVD == null) {
      this.mVD = new a(this, this.scene, this.dnp);
    }
    return this.mVD;
  }
  
  protected final m VG()
  {
    if (this.mVE == null) {
      this.mVE = new b(this, this.scene, this.dnp);
    }
    return this.mVE;
  }
  
  protected final void initView()
  {
    super.initView();
    a locala = this.mVD;
    i locali = new i();
    locali.bVk = locala.dnp.field_username;
    locali.kxf = locala;
    locali.handler = locala.handler;
    locali.kwX = 6;
    locali.kxe = new a.a((byte)0);
    ((n)g.t(n.class)).search(2, locali);
  }
  
  public final void jP(int paramInt)
  {
    e locale = (e)getContentLV().getAdapter().getItem(paramInt);
    if (locale != null) {
      d.e(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", locale.dnp.field_username).putExtra("finish_direct", true));
    }
  }
  
  protected final void xK()
  {
    super.xK();
    String str = getIntent().getStringExtra("Select_Talker_Name");
    au.Hx();
    this.dnp = c.Fw().abl(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.CommonChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */