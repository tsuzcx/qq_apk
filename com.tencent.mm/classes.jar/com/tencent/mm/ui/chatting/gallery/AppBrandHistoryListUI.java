package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
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
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.f.b.a;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.chatting.l.a;

public class AppBrandHistoryListUI
  extends MMActivity
  implements b.b
{
  private b.a WQK;
  private String jkq;
  private TextView jks;
  private RecyclerView mRecyclerView;
  private ProgressDialog tND;
  
  private void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(35874);
    Log.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.tND = s.a(this, getString(R.l.loading_tips), true, 0, null);
      AppMethodBeat.o(35874);
      return;
    }
    if ((this.tND != null) && (this.tND.isShowing()))
    {
      this.tND.dismiss();
      this.tND = null;
    }
    AppMethodBeat.o(35874);
  }
  
  public final void H(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35872);
    lG(false);
    Log.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.jks.setVisibility(0);
      this.mRecyclerView.setVisibility(8);
      this.jks.setText(getString(R.l.ewF));
      AppMethodBeat.o(35872);
      return;
    }
    this.jks.setVisibility(8);
    this.mRecyclerView.setVisibility(0);
    this.mRecyclerView.getAdapter().aE(0, paramInt);
    AppMethodBeat.o(35872);
  }
  
  public final void dD(String paramString, boolean paramBoolean) {}
  
  public int getLayoutId()
  {
    return R.i.ebD;
  }
  
  public final void hRy()
  {
    AppMethodBeat.i(35871);
    lG(true);
    AppMethodBeat.o(35871);
  }
  
  public void initView()
  {
    AppMethodBeat.i(35869);
    setMMTitle(getString(R.l.etJ));
    this.jks = ((TextView)findViewById(R.h.search_nothing_hint));
    this.mRecyclerView = ((RecyclerView)findViewById(R.h.history_recycler_view));
    this.mRecyclerView.setBackgroundColor(-1);
    this.mRecyclerView.setLayoutManager(this.WQK.hRs());
    this.mRecyclerView.setAdapter(this.WQK.bzt(this.jkq));
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
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35868);
    super.onCreate(paramBundle);
    this.jkq = getIntent().getStringExtra("Chat_User");
    new a(this).a(this);
    initView();
    this.WQK.hRu();
    if (ab.Lj(this.jkq))
    {
      h.IzE.a(14562, new Object[] { this.jkq, Integer.valueOf(0) });
      AppMethodBeat.o(35868);
      return;
    }
    h.IzE.a(14562, new Object[] { this.jkq, Integer.valueOf(1) });
    AppMethodBeat.o(35868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35870);
    super.onDestroy();
    this.WQK.onDetach();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.AppBrandHistoryListUI
 * JD-Core Version:    0.7.0.1
 */