package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.e.b.a;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.j.a;

public class AppBrandHistoryListUI
  extends MMActivity
  implements b.b
{
  private b.a HZS;
  private RecyclerView alu;
  private String fzK;
  private TextView fzM;
  private ProgressDialog opZ;
  
  private void ji(boolean paramBoolean)
  {
    AppMethodBeat.i(35874);
    ac.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.opZ = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(35874);
      return;
    }
    if ((this.opZ != null) && (this.opZ.isShowing()))
    {
      this.opZ.dismiss();
      this.opZ = null;
    }
    AppMethodBeat.o(35874);
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35872);
    ji(false);
    ac.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.fzM.setVisibility(0);
      this.alu.setVisibility(8);
      this.fzM.setText(getString(2131757279));
      AppMethodBeat.o(35872);
      return;
    }
    this.fzM.setVisibility(8);
    this.alu.setVisibility(0);
    this.alu.getAdapter().ao(0, paramInt);
    AppMethodBeat.o(35872);
  }
  
  public final void cN(String paramString, boolean paramBoolean) {}
  
  public final void fpd()
  {
    AppMethodBeat.i(35871);
    ji(true);
    AppMethodBeat.o(35871);
  }
  
  public int getLayoutId()
  {
    return 2131493094;
  }
  
  public void initView()
  {
    AppMethodBeat.i(35869);
    setMMTitle(getString(2131757040));
    this.fzM = ((TextView)findViewById(2131304436));
    this.alu = ((RecyclerView)findViewById(2131300757));
    this.alu.setBackgroundColor(-1);
    this.alu.setLayoutManager(this.HZS.bUW());
    this.alu.setAdapter(this.HZS.aQt(this.fzK));
    this.alu.setHasFixedSize(true);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(35867);
        AppBrandHistoryListUI.this.finish();
        AppMethodBeat.o(35867);
        return true;
      }
    });
    AppMethodBeat.o(35869);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35868);
    super.onCreate(paramBundle);
    this.fzK = getIntent().getStringExtra("Chat_User");
    new a(this).a(this);
    initView();
    this.HZS.foZ();
    if (w.sQ(this.fzK))
    {
      h.wUl.f(14562, new Object[] { this.fzK, Integer.valueOf(0) });
      AppMethodBeat.o(35868);
      return;
    }
    h.wUl.f(14562, new Object[] { this.fzK, Integer.valueOf(1) });
    AppMethodBeat.o(35868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35870);
    super.onDestroy();
    this.HZS.onDetach();
    AppMethodBeat.o(35870);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(35873);
    ac.i("MicroMsg.AppBrandHistoryListUI", "[onRefreshed]");
    finish();
    AppMethodBeat.o(35873);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.AppBrandHistoryListUI
 * JD-Core Version:    0.7.0.1
 */