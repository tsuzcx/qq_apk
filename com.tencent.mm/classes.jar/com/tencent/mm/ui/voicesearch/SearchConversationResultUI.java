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
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;

public class SearchConversationResultUI
  extends MMActivity
{
  private ListView IYt;
  private a IYu;
  private String IYv = null;
  private TextView orL;
  private String username;
  
  public int getLayoutId()
  {
    return 2131495871;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39526);
    this.IYt = ((ListView)findViewById(2131306532));
    this.orL = ((TextView)findViewById(2131299481));
    this.IYu = new a(getApplicationContext(), new r.a()
    {
      public final void aPg() {}
    });
    if (this.IYu != null) {
      this.IYu.ic(new LinkedList());
    }
    this.IYt.setAdapter(this.IYu);
    this.orL.setVisibility(8);
    this.username = getIntent().getStringExtra("SearchConversationResult_User");
    this.IYv = getIntent().getStringExtra("SearchConversationResult_Error");
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
    this.IYt.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
        paramAnonymousAdapterView = (ap)SearchConversationResultUI.b(SearchConversationResultUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ac.e("MicroMsg.VoiceSearchResultUI", "null user at position = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(39524);
          return;
        }
        ac.d("MicroMsg.VoiceSearchResultUI", "username " + paramAnonymousAdapterView.field_username);
        if (w.wM(paramAnonymousAdapterView.field_username))
        {
          if (u.axR())
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
        if (w.wO(paramAnonymousAdapterView.field_username))
        {
          if (u.axO())
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
        if (w.wN(paramAnonymousAdapterView.field_username))
        {
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.wS(paramAnonymousAdapterView.field_username))
        {
          MMAppMgr.cancelNotification(paramAnonymousAdapterView.field_username);
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.wK(paramAnonymousAdapterView.field_username))
        {
          if (u.aya())
          {
            SearchConversationResultUI.a(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            AppMethodBeat.o(39524);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.wX(paramAnonymousAdapterView.field_username))
        {
          if (u.axU())
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
        if (w.xf(paramAnonymousAdapterView.field_username))
        {
          if (u.axV())
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
        if (w.wP(paramAnonymousAdapterView.field_username))
        {
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if (w.wQ(paramAnonymousAdapterView.field_username))
        {
          if (u.axX())
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
        if (w.wW(paramAnonymousAdapterView.field_username))
        {
          if (u.axS())
          {
            SearchConversationResultUI.b(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            AppMethodBeat.o(39524);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          AppMethodBeat.o(39524);
          return;
        }
        if ((w.wU(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (w.wV(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (w.wR(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (w.wZ(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (w.xa(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (w.wL(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (w.xi(SearchConversationResultUI.c(SearchConversationResultUI.this))))
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
    this.orL.setVisibility(8);
    if (this.IYu != null) {
      this.IYu.FZ(str);
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
    this.IYu.cVi();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.SearchConversationResultUI
 * JD-Core Version:    0.7.0.1
 */