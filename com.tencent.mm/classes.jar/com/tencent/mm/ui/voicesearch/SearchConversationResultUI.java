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
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.s.a;
import java.util.LinkedList;

public class SearchConversationResultUI
  extends MMActivity
{
  private ListView QBe;
  private a QBf;
  private String QBg = null;
  private TextView qqJ;
  private String username;
  
  public int getLayoutId()
  {
    return 2131496851;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39526);
    this.QBe = ((ListView)findViewById(2131309992));
    this.qqJ = ((TextView)findViewById(2131300114));
    this.QBf = new a(getApplicationContext(), new s.a()
    {
      public final void bnE() {}
    });
    if (this.QBf != null) {
      this.QBf.jB(new LinkedList());
    }
    this.QBe.setAdapter(this.QBf);
    this.qqJ.setVisibility(8);
    this.username = getIntent().getStringExtra("SearchConversationResult_User");
    this.QBg = getIntent().getStringExtra("SearchConversationResult_Error");
    setMMTitle(getString(2131767200));
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
    this.QBe.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(39524);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (paramAnonymousInt < SearchConversationResultUI.a(SearchConversationResultUI.this).getHeaderViewsCount())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(39524);
          return;
        }
        paramAnonymousInt -= SearchConversationResultUI.a(SearchConversationResultUI.this).getHeaderViewsCount();
        paramAnonymousAdapterView = (az)SearchConversationResultUI.b(SearchConversationResultUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          Log.e("MicroMsg.VoiceSearchResultUI", "null user at position = ".concat(String.valueOf(paramAnonymousInt)));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(39524);
          return;
        }
        Log.d("MicroMsg.VoiceSearchResultUI", "username " + paramAnonymousAdapterView.field_username);
        if (ab.IY(paramAnonymousAdapterView.field_username)) {
          if (z.aUw())
          {
            paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
            c.b(SearchConversationResultUI.this.getContext(), "tmessage", ".ui.TConversationUI", paramAnonymousAdapterView);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(39524);
          return;
          c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          continue;
          if (ab.Ja(paramAnonymousAdapterView.field_username))
          {
            if (z.aUt())
            {
              paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
              c.b(SearchConversationResultUI.this.getContext(), "qmessage", ".ui.QConversationUI", paramAnonymousAdapterView);
            }
            else
            {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (ab.IZ(paramAnonymousAdapterView.field_username))
          {
            c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else if (ab.Je(paramAnonymousAdapterView.field_username))
          {
            MMAppMgr.cancelNotification(paramAnonymousAdapterView.field_username);
            c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else if (ab.IW(paramAnonymousAdapterView.field_username))
          {
            if (z.aUH()) {
              SearchConversationResultUI.a(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            } else {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (ab.Jj(paramAnonymousAdapterView.field_username))
          {
            if (z.aUA())
            {
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.putExtra("type", 20);
              c.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", paramAnonymousAdapterView);
            }
            else
            {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (ab.Jr(paramAnonymousAdapterView.field_username))
          {
            if (z.aUB())
            {
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.putExtra("type", 11);
              c.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", paramAnonymousAdapterView);
            }
            else
            {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (ab.Jb(paramAnonymousAdapterView.field_username))
          {
            c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else if (ab.Jc(paramAnonymousAdapterView.field_username))
          {
            if (z.aUD())
            {
              paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
              c.b(SearchConversationResultUI.this, "masssend", ".ui.MassSendHistoryUI", paramAnonymousAdapterView);
            }
            else
            {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (ab.Ji(paramAnonymousAdapterView.field_username))
          {
            if (z.aUx()) {
              SearchConversationResultUI.b(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            } else {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if ((ab.Jg(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (ab.Jh(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (ab.Jd(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (ab.Jl(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (ab.Jm(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (ab.IX(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (ab.Ju(SearchConversationResultUI.c(SearchConversationResultUI.this))))
          {
            c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else
          {
            SearchConversationResultUI.c(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
          }
        }
      }
    });
    String str = this.username;
    this.qqJ.setVisibility(8);
    if (this.QBf != null) {
      this.QBf.SM(str);
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
    this.QBf.ebf();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.SearchConversationResultUI
 * JD-Core Version:    0.7.0.1
 */