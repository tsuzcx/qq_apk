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
import com.tencent.mm.g.c.ba;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;

public class SearchConversationResultUI
  extends MMActivity
{
  private ListView LlW;
  private a LlX;
  private String LlY = null;
  private TextView pbK;
  private String username;
  
  public int getLayoutId()
  {
    return 2131495871;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39526);
    this.LlW = ((ListView)findViewById(2131306532));
    this.pbK = ((TextView)findViewById(2131299481));
    this.LlX = new a(getApplicationContext(), new r.a()
    {
      public final void aSR() {}
    });
    if (this.LlX != null) {
      this.LlX.iy(new LinkedList());
    }
    this.LlW.setAdapter(this.LlX);
    this.pbK.setVisibility(8);
    this.username = getIntent().getStringExtra("SearchConversationResult_User");
    this.LlY = getIntent().getStringExtra("SearchConversationResult_Error");
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
    this.LlW.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(39524);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        if (paramAnonymousInt < SearchConversationResultUI.a(SearchConversationResultUI.this).getHeaderViewsCount())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(39524);
          return;
        }
        paramAnonymousInt -= SearchConversationResultUI.a(SearchConversationResultUI.this).getHeaderViewsCount();
        paramAnonymousAdapterView = (au)SearchConversationResultUI.b(SearchConversationResultUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ae.e("MicroMsg.VoiceSearchResultUI", "null user at position = ".concat(String.valueOf(paramAnonymousInt)));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(39524);
          return;
        }
        ae.d("MicroMsg.VoiceSearchResultUI", "username " + paramAnonymousAdapterView.field_username);
        if (x.At(paramAnonymousAdapterView.field_username)) {
          if (v.aAZ())
          {
            paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
            d.b(SearchConversationResultUI.this.getContext(), "tmessage", ".ui.TConversationUI", paramAnonymousAdapterView);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(39524);
          return;
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          continue;
          if (x.Av(paramAnonymousAdapterView.field_username))
          {
            if (v.aAW())
            {
              paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
              d.b(SearchConversationResultUI.this.getContext(), "qmessage", ".ui.QConversationUI", paramAnonymousAdapterView);
            }
            else
            {
              d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (x.Au(paramAnonymousAdapterView.field_username))
          {
            d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else if (x.Az(paramAnonymousAdapterView.field_username))
          {
            MMAppMgr.cancelNotification(paramAnonymousAdapterView.field_username);
            d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else if (x.Ar(paramAnonymousAdapterView.field_username))
          {
            if (v.aBk()) {
              SearchConversationResultUI.a(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            } else {
              d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (x.AE(paramAnonymousAdapterView.field_username))
          {
            if (v.aBd())
            {
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.putExtra("type", 20);
              d.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", paramAnonymousAdapterView);
            }
            else
            {
              d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (x.AM(paramAnonymousAdapterView.field_username))
          {
            if (v.aBe())
            {
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.putExtra("type", 11);
              d.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", paramAnonymousAdapterView);
            }
            else
            {
              d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (x.Aw(paramAnonymousAdapterView.field_username))
          {
            d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else if (x.Ax(paramAnonymousAdapterView.field_username))
          {
            if (v.aBg())
            {
              paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
              d.b(SearchConversationResultUI.this, "masssend", ".ui.MassSendHistoryUI", paramAnonymousAdapterView);
            }
            else
            {
              d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (x.AD(paramAnonymousAdapterView.field_username))
          {
            if (v.aBa()) {
              SearchConversationResultUI.b(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            } else {
              d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if ((x.AB(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (x.AC(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (x.Ay(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (x.AG(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (x.AH(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (x.As(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (x.AP(SearchConversationResultUI.c(SearchConversationResultUI.this))))
          {
            d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else
          {
            SearchConversationResultUI.c(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
          }
        }
      }
    });
    String str = this.username;
    this.pbK.setVisibility(8);
    if (this.LlX != null) {
      this.LlX.JN(str);
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
    this.LlX.dhl();
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