package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.e.b.a;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.presenter.a;

public class AppBrandHistoryListUI
  extends MMActivity
  implements b.b
{
  private b.a aeAe;
  private String lMU;
  private TextView lMW;
  private RecyclerView mRecyclerView;
  private ProgressDialog wQT;
  
  private void na(boolean paramBoolean)
  {
    AppMethodBeat.i(35874);
    Log.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.wQT = w.a(this, getString(R.l.loading_tips), true, 0, null);
      AppMethodBeat.o(35874);
      return;
    }
    if ((this.wQT != null) && (this.wQT.isShowing()))
    {
      this.wQT.dismiss();
      this.wQT = null;
    }
    AppMethodBeat.o(35874);
  }
  
  public final void F(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35872);
    na(false);
    Log.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.lMW.setVisibility(0);
      this.mRecyclerView.setVisibility(8);
      this.lMW.setText(getString(R.l.gzi));
      AppMethodBeat.o(35872);
      return;
    }
    this.lMW.setVisibility(8);
    this.mRecyclerView.setVisibility(0);
    this.mRecyclerView.getAdapter().by(0, paramInt);
    AppMethodBeat.o(35872);
  }
  
  public final void em(String paramString, boolean paramBoolean) {}
  
  public int getLayoutId()
  {
    return R.i.gel;
  }
  
  public void initView()
  {
    AppMethodBeat.i(35869);
    setMMTitle(getString(R.l.gwf));
    this.lMW = ((TextView)findViewById(R.h.search_nothing_hint));
    this.mRecyclerView = ((RecyclerView)findViewById(R.h.history_recycler_view));
    this.mRecyclerView.setBackgroundColor(-1);
    this.mRecyclerView.setLayoutManager(this.aeAe.juP());
    this.mRecyclerView.setAdapter(this.aeAe.bBf(this.lMU));
    this.mRecyclerView.setHasFixedSize(true);
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
  
  public final void juV()
  {
    AppMethodBeat.i(35871);
    na(true);
    AppMethodBeat.o(35871);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35868);
    super.onCreate(paramBundle);
    this.lMU = getIntent().getStringExtra("Chat_User");
    new a(this).a(this);
    initView();
    this.aeAe.juR();
    if (au.bwE(this.lMU))
    {
      h.OAn.b(14562, new Object[] { this.lMU, Integer.valueOf(0) });
      AppMethodBeat.o(35868);
      return;
    }
    h.OAn.b(14562, new Object[] { this.lMU, Integer.valueOf(1) });
    AppMethodBeat.o(35868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35870);
    super.onDestroy();
    this.aeAe.onDetach();
    AppMethodBeat.o(35870);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(35873);
    Log.i("MicroMsg.AppBrandHistoryListUI", "[onRefreshed]");
    finish();
    AppMethodBeat.o(35873);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.AppBrandHistoryListUI
 * JD-Core Version:    0.7.0.1
 */