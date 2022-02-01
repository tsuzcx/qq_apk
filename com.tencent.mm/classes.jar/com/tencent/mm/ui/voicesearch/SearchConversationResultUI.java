package com.tencent.mm.ui.voicesearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.q.a;
import java.util.LinkedList;

public class SearchConversationResultUI
  extends MMActivity
{
  private ListView HxW;
  private a HxX;
  private String HxY = null;
  private TextView nOJ;
  private String username;
  
  public int getLayoutId()
  {
    return 2131495871;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39526);
    this.HxW = ((ListView)findViewById(2131306532));
    this.nOJ = ((TextView)findViewById(2131299481));
    this.HxX = new a(getApplicationContext(), new q.a()
    {
      public final void aIp() {}
    });
    if (this.HxX != null) {
      this.HxX.hP(new LinkedList());
    }
    this.HxW.setAdapter(this.HxX);
    this.nOJ.setVisibility(8);
    this.username = getIntent().getStringExtra("SearchConversationResult_User");
    this.HxY = getIntent().getStringExtra("SearchConversationResult_Error");
    setMMTitle(getString(2131764763));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39523);
        SearchConversationResultUI.this.finish();
        AppMethodBeat.o(39523);
        return true;
      }
    });
    this.HxW.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(39524);
        if (paramAnonymousInt < SearchConversationResultUI.a(SearchConversationResultUI.this).getHeaderViewsCount())
        {
          AppMethodBeat.o(39524);
          return;
        }
        paramAnonymousInt -= SearchConversationResultUI.a(SearchConversationResultUI.this).getHeaderViewsCount();
        paramAnonymousAdapterView = (am)SearchConversationResultUI.b(SearchConversationResultUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ad.e("MicroMsg.VoiceSearchResultUI", "null user at position = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(39524);
          return;
        }
        ad.d("MicroMsg.VoiceSearchResultUI", "username " + paramAnonymousAdapterView.field_username);
        if (w.sJ(paramAnonymousAdapterView.field_username))
        {
          if (u.arb())
          {
            paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
            d.b(SearchConversationResultUI.this.getContext(), "tmessage", ".ui.TConversationUI", paramAnonymousAdapterView);
            AppMethodBeat.o(39524);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.sL(paramAnonymousAdapterView.field_username))
        {
          if (u.aqY())
          {
            paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
            d.b(SearchConversationResultUI.this.getContext(), "qmessage", ".ui.QConversationUI", paramAnonymousAdapterView);
            AppMethodBeat.o(39524);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.sK(paramAnonymousAdapterView.field_username))
        {
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.sP(paramAnonymousAdapterView.field_username))
        {
          MMAppMgr.cancelNotification(paramAnonymousAdapterView.field_username);
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.sH(paramAnonymousAdapterView.field_username))
        {
          if (u.ark())
          {
            SearchConversationResultUI.a(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            AppMethodBeat.o(39524);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.sU(paramAnonymousAdapterView.field_username))
        {
          if (u.are())
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("type", 20);
            d.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", paramAnonymousAdapterView);
            AppMethodBeat.o(39524);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.tc(paramAnonymousAdapterView.field_username))
        {
          if (u.arf())
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("type", 11);
            d.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", paramAnonymousAdapterView);
            AppMethodBeat.o(39524);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.sM(paramAnonymousAdapterView.field_username))
        {
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.sN(paramAnonymousAdapterView.field_username))
        {
          if (u.arh())
          {
            paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
            d.b(SearchConversationResultUI.this, "masssend", ".ui.MassSendHistoryUI", paramAnonymousAdapterView);
            AppMethodBeat.o(39524);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.sT(paramAnonymousAdapterView.field_username))
        {
          if (u.arc())
          {
            SearchConversationResultUI.b(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            AppMethodBeat.o(39524);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if ((w.sR(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (w.sS(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (w.sO(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (w.sW(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (w.sX(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (w.sI(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (w.tf(SearchConversationResultUI.c(SearchConversationResultUI.this))))
        {
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        SearchConversationResultUI.c(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
        AppMethodBeat.o(39524);
      }
    });
    String str = this.username;
    this.nOJ.setVisibility(8);
    if (this.HxX != null) {
      this.HxX.BW(str);
    }
    AppMethodBeat.o(39526);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39525);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(39525);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39527);
    super.onDestroy();
    this.HxX.cHX();
    AppMethodBeat.o(39527);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39528);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(39528);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.SearchConversationResultUI
 * JD-Core Version:    0.7.0.1
 */