package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.q;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI
  extends MMActivity
{
  private static boolean zsP = false;
  private u efi;
  private String eiT;
  private String eiU;
  private q eiV;
  private ListView gJa;
  private String mTitle;
  private String talker;
  private AtSomeoneUI.a zwq;
  
  protected static String a(u paramu, String paramString)
  {
    AppMethodBeat.i(30402);
    if (paramu == null)
    {
      AppMethodBeat.o(30402);
      return null;
    }
    paramu = paramu.nE(paramString);
    AppMethodBeat.o(30402);
    return paramu;
  }
  
  public int getLayoutId()
  {
    return 2130968787;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(30397);
    setMMTitle(this.mTitle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(30387);
        AtSomeoneUI.this.setResult(0);
        AtSomeoneUI.this.finish();
        AppMethodBeat.o(30387);
        return true;
      }
    });
    this.eiV = new q((byte)0);
    this.eiV.Axg = new AtSomeoneUI.2(this);
    addSearchMenu(true, this.eiV);
    this.gJa = ((ListView)findViewById(2131821560));
    ad localad = new ad();
    u localu = this.efi;
    Object localObject1 = null;
    if (!ah.isNullOrNil(this.eiU))
    {
      localObject1 = this.eiU.split(",");
      ab.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString((Object[])localObject1) });
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.efi != null)
      {
        ab.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
        localObject2 = ah.d(this.efi.afx(), ",").split(",");
      }
    }
    if (localObject2 == null) {
      if (this.efi != null) {
        break label316;
      }
    }
    for (;;)
    {
      ab.e("MicroMsg.AtSomeoneUI", "WTF! member is null? %s", new Object[] { Boolean.valueOf(bool) });
      localObject1 = new LinkedList();
      if (!ah.isNullOrNil(this.eiT)) {
        localObject1 = ah.h(this.eiT.split(","));
      }
      aw.aaz();
      bq localbq = c.YI().TL("@t.qq.com");
      if (localbq != null) {
        ((List)localObject1).add(localbq.name);
      }
      this.zwq = new AtSomeoneUI.a(this, localad, localu, (String[])localObject2, (List)localObject1);
      this.gJa.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 1;
          AppMethodBeat.i(30389);
          Intent localIntent = new Intent();
          if ((paramAnonymousInt == 0) && (AtSomeoneUI.zsP))
          {
            localIntent.putExtra("Select_Conv_User", AtSomeoneUI.this.getString(2131297210, new Object[] { "" }));
            localIntent.putExtra("select_raw_user_name", "notify@all");
            AtSomeoneUI.this.setResult(-1, localIntent);
            AtSomeoneUI.this.finish();
            AppMethodBeat.o(30389);
            return;
          }
          paramAnonymousAdapterView = AtSomeoneUI.a(AtSomeoneUI.this);
          if (AtSomeoneUI.zsP) {}
          for (;;)
          {
            ad localad = (ad)paramAnonymousAdapterView.getItem(paramAnonymousInt - i);
            paramAnonymousView = AtSomeoneUI.a(AtSomeoneUI.b(AtSomeoneUI.this), localad.field_username);
            paramAnonymousAdapterView = paramAnonymousView;
            if (ah.isNullOrNil(paramAnonymousView)) {
              paramAnonymousAdapterView = localad.Oe();
            }
            localIntent.putExtra("select_raw_user_name", localad.field_username);
            localIntent.putExtra("Select_Conv_User", paramAnonymousAdapterView);
            break;
            i = 0;
          }
        }
      });
      this.gJa.setAdapter(this.zwq);
      AppMethodBeat.o(30397);
      return;
      label316:
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30396);
    super.onCreate(paramBundle);
    this.eiT = getIntent().getStringExtra("Block_list");
    this.eiU = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    aw.aaz();
    this.efi = c.YJ().oU(this.talker);
    if ((this.efi != null) && (this.efi.field_roomowner.equals(r.Zn()))) {
      zsP = false;
    }
    initView();
    AppMethodBeat.o(30396);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30399);
    this.zwq.bKb();
    super.onDestroy();
    AppMethodBeat.o(30399);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30398);
    super.onPause();
    if (this.eiV != null) {
      this.eiV.dNV();
    }
    AppMethodBeat.o(30398);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */