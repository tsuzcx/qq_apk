package com.tencent.mm.ui.voicesearch;

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
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.x.a;
import java.util.LinkedList;

public class SearchConversationResultUI
  extends MMActivity
{
  private a afRA;
  private String afRB = null;
  private ListView afRz;
  private TextView lNm;
  private String username;
  
  public int getLayoutId()
  {
    return R.i.goZ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39526);
    this.afRz = ((ListView)findViewById(R.h.gdb));
    this.lNm = ((TextView)findViewById(R.h.fGG));
    this.afRA = new a(getApplicationContext(), new x.a()
    {
      public final void bWC() {}
    });
    if (this.afRA != null) {
      this.afRA.nM(new LinkedList());
    }
    this.afRz.setAdapter(this.afRA);
    this.lNm.setVisibility(8);
    this.username = getIntent().getStringExtra("SearchConversationResult_User");
    this.afRB = getIntent().getStringExtra("SearchConversationResult_Error");
    setMMTitle(getString(R.l.goZ));
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
    this.afRz.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(39524);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (paramAnonymousInt < SearchConversationResultUI.a(SearchConversationResultUI.this).getHeaderViewsCount())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(39524);
          return;
        }
        paramAnonymousInt -= SearchConversationResultUI.a(SearchConversationResultUI.this).getHeaderViewsCount();
        paramAnonymousAdapterView = (bb)SearchConversationResultUI.b(SearchConversationResultUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          Log.e("MicroMsg.VoiceSearchResultUI", "null user at position = ".concat(String.valueOf(paramAnonymousInt)));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(39524);
          return;
        }
        Log.d("MicroMsg.VoiceSearchResultUI", "username " + paramAnonymousAdapterView.field_username);
        if (au.bvV(paramAnonymousAdapterView.field_username)) {
          if (z.bBq())
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
          if (au.bvX(paramAnonymousAdapterView.field_username))
          {
            if (z.bBn())
            {
              paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
              c.b(SearchConversationResultUI.this.getContext(), "qmessage", ".ui.QConversationUI", paramAnonymousAdapterView);
            }
            else
            {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (au.bvW(paramAnonymousAdapterView.field_username))
          {
            c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else if (au.bwb(paramAnonymousAdapterView.field_username))
          {
            MMAppMgr.iH(paramAnonymousAdapterView.field_username);
            c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else if (au.bvS(paramAnonymousAdapterView.field_username))
          {
            if (z.bBB()) {
              SearchConversationResultUI.a(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            } else {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (au.bwg(paramAnonymousAdapterView.field_username))
          {
            if (z.bBu())
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
          else if (au.bwo(paramAnonymousAdapterView.field_username))
          {
            if (z.bBv())
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
          else if (au.bvY(paramAnonymousAdapterView.field_username))
          {
            c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          }
          else if (au.bvZ(paramAnonymousAdapterView.field_username))
          {
            if (z.bBx())
            {
              paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
              c.b(SearchConversationResultUI.this, "masssend", ".ui.MassSendHistoryUI", paramAnonymousAdapterView);
            }
            else
            {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if (au.bwf(paramAnonymousAdapterView.field_username))
          {
            if (z.bBr()) {
              SearchConversationResultUI.b(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            } else {
              c.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
            }
          }
          else if ((au.bwd(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (au.bwe(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (au.bwa(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (au.bwi(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (au.bwj(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (au.bvT(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (au.bwr(SearchConversationResultUI.c(SearchConversationResultUI.this))))
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
    this.lNm.setVisibility(8);
    if (this.afRA != null) {
      this.afRA.SM(str);
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
    this.afRA.fSd();
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