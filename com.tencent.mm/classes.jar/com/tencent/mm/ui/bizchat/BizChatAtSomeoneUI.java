package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.q;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI
  extends MMActivity
{
  private static boolean zsP = false;
  private String eiT;
  private String eiU;
  private q eiV;
  private ListView gJa;
  private long jUy;
  private String mTitle;
  private String talker;
  private BizChatAtSomeoneUI.a zsN;
  private c zsO;
  
  protected static String a(c paramc, String paramString)
  {
    AppMethodBeat.i(30043);
    if (paramc == null)
    {
      AppMethodBeat.o(30043);
      return null;
    }
    paramc = paramc.nE(paramString);
    AppMethodBeat.o(30043);
    return paramc;
  }
  
  public int getLayoutId()
  {
    return 2130968787;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30038);
    setMMTitle(this.mTitle);
    setBackBtn(new BizChatAtSomeoneUI.1(this));
    this.eiV = new q((byte)0);
    this.eiV.Axg = new BizChatAtSomeoneUI.2(this);
    addSearchMenu(true, this.eiV);
    this.gJa = ((ListView)findViewById(2131821560));
    j localj = new j();
    c localc = this.zsO;
    String[] arrayOfString = null;
    if (!ah.isNullOrNil(this.eiU))
    {
      arrayOfString = this.eiU.split(";");
      ab.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString(arrayOfString) });
    }
    Object localObject = new LinkedList();
    if (!ah.isNullOrNil(this.eiT)) {
      localObject = ah.h(this.eiT.split(";"));
    }
    this.zsN = new BizChatAtSomeoneUI.a(this, localj, localc, arrayOfString, (List)localObject);
    this.gJa.setOnItemClickListener(new BizChatAtSomeoneUI.3(this));
    this.gJa.setAdapter(this.zsN);
    this.gJa.setOnScrollListener(new BizChatAtSomeoneUI.4(this));
    AppMethodBeat.o(30038);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30037);
    super.onCreate(paramBundle);
    this.eiT = getIntent().getStringExtra("Block_list");
    this.eiU = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.jUy = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.zsO = z.afk().aG(this.jUy);
    if (this.zsO == null)
    {
      ab.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
      finish();
      AppMethodBeat.o(30037);
      return;
    }
    if ((this.zsO != null) && (this.zsO.field_ownerUserId.equals(r.Zn()))) {
      zsP = true;
    }
    initView();
    AppMethodBeat.o(30037);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30040);
    this.zsN.bKb();
    super.onDestroy();
    AppMethodBeat.o(30040);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30039);
    super.onPause();
    if (this.eiV != null) {
      this.eiV.dNV();
    }
    AppMethodBeat.o(30039);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */