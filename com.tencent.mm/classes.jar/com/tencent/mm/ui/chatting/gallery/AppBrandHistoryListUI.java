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
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.f.b.a;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.chatting.k.a;

public class AppBrandHistoryListUI
  extends MMActivity
  implements b.b
{
  private b.a Pws;
  private String gAn;
  private TextView gAp;
  private RecyclerView mRecyclerView;
  private ProgressDialog qoU;
  
  private void ku(boolean paramBoolean)
  {
    AppMethodBeat.i(35874);
    Log.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.qoU = q.a(this, getString(2131762446), true, 0, null);
      AppMethodBeat.o(35874);
      return;
    }
    if ((this.qoU != null) && (this.qoU.isShowing()))
    {
      this.qoU.dismiss();
      this.qoU = null;
    }
    AppMethodBeat.o(35874);
  }
  
  public final void D(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35872);
    ku(false);
    Log.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.gAp.setVisibility(0);
      this.mRecyclerView.setVisibility(8);
      this.gAp.setText(getString(2131757493));
      AppMethodBeat.o(35872);
      return;
    }
    this.gAp.setVisibility(8);
    this.mRecyclerView.setVisibility(0);
    this.mRecyclerView.getAdapter().aq(0, paramInt);
    AppMethodBeat.o(35872);
  }
  
  public final void dr(String paramString, boolean paramBoolean) {}
  
  public final void gSc()
  {
    AppMethodBeat.i(35871);
    ku(true);
    AppMethodBeat.o(35871);
  }
  
  public int getLayoutId()
  {
    return 2131493136;
  }
  
  public void initView()
  {
    AppMethodBeat.i(35869);
    setMMTitle(getString(2131757212));
    this.gAp = ((TextView)findViewById(2131307411));
    this.mRecyclerView = ((RecyclerView)findViewById(2131302345));
    this.mRecyclerView.setBackgroundColor(-1);
    this.mRecyclerView.setLayoutManager(this.Pws.gRW());
    this.mRecyclerView.setAdapter(this.Pws.bmS(this.gAn));
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
    this.gAn = getIntent().getStringExtra("Chat_User");
    new a(this).a(this);
    initView();
    this.Pws.gRY();
    if (ab.Eq(this.gAn))
    {
      h.CyF.a(14562, new Object[] { this.gAn, Integer.valueOf(0) });
      AppMethodBeat.o(35868);
      return;
    }
    h.CyF.a(14562, new Object[] { this.gAn, Integer.valueOf(1) });
    AppMethodBeat.o(35868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35870);
    super.onDestroy();
    this.Pws.onDetach();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.AppBrandHistoryListUI
 * JD-Core Version:    0.7.0.1
 */