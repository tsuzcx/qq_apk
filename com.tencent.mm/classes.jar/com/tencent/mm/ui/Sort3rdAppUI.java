package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.o;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3rdAppUI
  extends MMActivity
{
  private long HnP;
  private Sort3rdAppUI.a WeE;
  private List<g> WeF;
  private DragSortListView uKp;
  
  protected int getLayoutId()
  {
    return R.i.elp;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(33757);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(33749);
        Sort3rdAppUI.this.finish();
        AppMethodBeat.o(33749);
        return true;
      }
    });
    setMMTitle(getString(R.l.actionbar_setting));
    this.uKp = ((DragSortListView)findViewById(R.h.listview));
    this.uKp.setDropListener(new DragSortListView.h()
    {
      public final void eX(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(33750);
        g localg = (g)Sort3rdAppUI.a(Sort3rdAppUI.this).getItem(paramAnonymousInt1);
        Sort3rdAppUI.a(Sort3rdAppUI.this).remove(localg);
        Sort3rdAppUI.a(Sort3rdAppUI.this).insert(localg, paramAnonymousInt2);
        AppMethodBeat.o(33750);
      }
    });
    AppMethodBeat.o(33757);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(33756);
    super.onCreate(paramBundle);
    this.HnP = getIntent().getLongExtra("KFlag", -1L);
    initView();
    this.WeF = com.tencent.mm.pluginsdk.model.app.h.c(this, this.HnP, true);
    paramBundle = ao.hhI().TT(this.HnP);
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      Collections.sort(this.WeF, new Comparator() {});
    }
    this.WeE = new Sort3rdAppUI.a(this, this.WeF, this.HnP);
    this.uKp.setAdapter(this.WeE);
    AppMethodBeat.o(33756);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33758);
    super.onDestroy();
    AppMethodBeat.o(33758);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33759);
    super.onPause();
    if (this.WeE != null)
    {
      List localList = this.WeE.uAd;
      p localp = ao.hhI();
      long l = this.HnP;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete from AppSort");
      ((StringBuilder)localObject).append(" where flag = ").append(l).append(" ");
      localObject = ((StringBuilder)localObject).toString();
      localp.db.execSQL("AppSort", (String)localObject);
      if ((localList != null) && (localList.size() > 0))
      {
        bh.beI();
        l = c.getDataDB().beginTransaction(Thread.currentThread().getId());
        localp = ao.hhI();
        int i = 0;
        while (i < localList.size())
        {
          localObject = new o();
          ((o)localObject).field_flag = this.HnP;
          ((o)localObject).field_appId = ((g)localList.get(i)).field_appId;
          ((o)localObject).field_sortId = i;
          localp.a((o)localObject);
          i += 1;
        }
        bh.beI();
        c.getDataDB().endTransaction(l);
      }
    }
    AppMethodBeat.o(33759);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI
 * JD-Core Version:    0.7.0.1
 */