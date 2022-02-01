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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.v.a;
import java.util.LinkedList;

public class SearchConversationResultUI
  extends MMActivity
{
  private ListView XZD;
  private a XZE;
  private String XZF = null;
  private TextView jkI;
  private String username;
  
  public int getLayoutId()
  {
    return R.i.elV;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39526);
    this.XZD = ((ListView)findViewById(R.h.eal));
    this.jkI = ((TextView)findViewById(R.h.dFA));
    this.XZE = new a(getApplicationContext(), new v.a()
    {
      public final void bxN() {}
    });
    if (this.XZE != null) {
      this.XZE.kw(new LinkedList());
    }
    this.XZD.setAdapter(this.XZE);
    this.jkI.setVisibility(8);
    this.username = getIntent().getStringExtra("SearchConversationResult_User");
    this.XZF = getIntent().getStringExtra("SearchConversationResult_Error");
    setMMTitle(getString(R.l.elV));
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
    this.XZD.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(39524);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
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
        if (ab.Qr(paramAnonymousAdapterView.field_username)) {
          if (z.bdy())
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
          if (ab.Qt(paramAnonymousAdapterView.field_username))
          {
            if (z.bdv())
            {
              paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
              c.b(SearchConversationResultUI.this.getContext(), "qmessage", ".ui.QConversationUI", paramAnonymousAdapterView);
            }
            else
            {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (ab.Qs(paramAnonymousAdapterView.field_username))
          {
            c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else if (ab.Qx(paramAnonymousAdapterView.field_username))
          {
            MMAppMgr.hg(paramAnonymousAdapterView.field_username);
            c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else if (ab.Qp(paramAnonymousAdapterView.field_username))
          {
            if (z.bdJ()) {
              SearchConversationResultUI.a(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            } else {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (ab.QC(paramAnonymousAdapterView.field_username))
          {
            if (z.bdC())
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
          else if (ab.QK(paramAnonymousAdapterView.field_username))
          {
            if (z.bdD())
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
          else if (ab.Qu(paramAnonymousAdapterView.field_username))
          {
            c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else if (ab.Qv(paramAnonymousAdapterView.field_username))
          {
            if (z.bdF())
            {
              paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
              c.b(SearchConversationResultUI.this, "masssend", ".ui.MassSendHistoryUI", paramAnonymousAdapterView);
            }
            else
            {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (ab.QB(paramAnonymousAdapterView.field_username))
          {
            if (z.bdz()) {
              SearchConversationResultUI.b(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            } else {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if ((ab.Qz(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (ab.QA(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (ab.Qw(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (ab.QE(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (ab.QF(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (ab.Qq(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (ab.QN(SearchConversationResultUI.c(SearchConversationResultUI.this))))
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
    this.jkI.setVisibility(8);
    if (this.XZE != null) {
      this.XZE.aas(str);
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
    this.XZE.eKd();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.SearchConversationResultUI
 * JD-Core Version:    0.7.0.1
 */