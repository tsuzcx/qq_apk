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
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.e.b.a;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.i.a;

public class AppBrandHistoryListUI
  extends MMActivity
  implements b.b
{
  private RecyclerView adt;
  private String ejr;
  private TextView ejt;
  private ProgressDialog kFY;
  private b.a zJG;
  
  private void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(31958);
    ab.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.kFY = p.b(this, getString(2131301086), true, null);
      AppMethodBeat.o(31958);
      return;
    }
    if ((this.kFY != null) && (this.kFY.isShowing()))
    {
      this.kFY.dismiss();
      this.kFY = null;
    }
    AppMethodBeat.o(31958);
  }
  
  public final void co(String paramString, boolean paramBoolean) {}
  
  public final void dJU()
  {
    AppMethodBeat.i(31955);
    fV(true);
    AppMethodBeat.o(31955);
  }
  
  public int getLayoutId()
  {
    return 2130968768;
  }
  
  public void initView()
  {
    AppMethodBeat.i(31953);
    setMMTitle(getString(2131298094));
    this.ejt = ((TextView)findViewById(2131821515));
    this.adt = ((RecyclerView)findViewById(2131821516));
    this.adt.setBackgroundColor(-1);
    this.adt.setLayoutManager(this.zJG.bgA());
    this.adt.setAdapter(this.zJG.auc(this.ejr));
    this.adt.setHasFixedSize(true);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(31951);
        AppBrandHistoryListUI.this.finish();
        AppMethodBeat.o(31951);
        return true;
      }
    });
    AppMethodBeat.o(31953);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(31952);
    super.onCreate(paramBundle);
    this.ejr = getIntent().getStringExtra("Chat_User");
    new a(this).a(this);
    initView();
    this.zJG.dJQ();
    if (t.lA(this.ejr))
    {
      h.qsU.e(14562, new Object[] { this.ejr, Integer.valueOf(0) });
      AppMethodBeat.o(31952);
      return;
    }
    h.qsU.e(14562, new Object[] { this.ejr, Integer.valueOf(1) });
    AppMethodBeat.o(31952);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(31954);
    super.onDestroy();
    this.zJG.onDetach();
    AppMethodBeat.o(31954);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(31957);
    ab.i("MicroMsg.AppBrandHistoryListUI", "[onRefreshed]");
    finish();
    AppMethodBeat.o(31957);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void s(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(31956);
    fV(false);
    ab.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.ejt.setVisibility(0);
      this.adt.setVisibility(8);
      this.ejt.setText(getString(2131298288));
      AppMethodBeat.o(31956);
      return;
    }
    this.ejt.setVisibility(8);
    this.adt.setVisibility(0);
    this.adt.getAdapter().an(0, paramInt);
    AppMethodBeat.o(31956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.AppBrandHistoryListUI
 * JD-Core Version:    0.7.0.1
 */