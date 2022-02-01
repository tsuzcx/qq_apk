package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.o;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3rdAppUI
  extends MMActivity
{
  private long FwG;
  private Sort3rdAppUI.a Hsd;
  private List<g> Hse;
  private DragSortListView pga;
  
  protected int getLayoutId()
  {
    return 2131495627;
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
    setMMTitle(getString(2131755131));
    this.pga = ((DragSortListView)findViewById(2131301457));
    this.pga.setDropListener(new DragSortListView.h()
    {
      public final void ei(int paramAnonymousInt1, int paramAnonymousInt2)
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
    this.FwG = getIntent().getLongExtra("KFlag", -1L);
    initView();
    this.Hse = com.tencent.mm.pluginsdk.model.app.h.b(this, this.FwG, true);
    paramBundle = ap.eLm().zO(this.FwG);
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      Collections.sort(this.Hse, new Comparator() {});
    }
    this.Hsd = new Sort3rdAppUI.a(this, this.Hse, this.FwG);
    this.pga.setAdapter(this.Hsd);
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
    if (this.Hsd != null)
    {
      List localList = this.Hsd.oXp;
      p localp = ap.eLm();
      long l = this.FwG;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete from AppSort");
      ((StringBuilder)localObject).append(" where flag = ").append(l).append(" ");
      localObject = ((StringBuilder)localObject).toString();
      localp.db.execSQL("AppSort", (String)localObject);
      if ((localList != null) && (localList.size() > 0))
      {
        az.ayM();
        l = c.agw().vE(Thread.currentThread().getId());
        localp = ap.eLm();
        int i = 0;
        while (i < localList.size())
        {
          localObject = new o();
          ((o)localObject).field_flag = this.FwG;
          ((o)localObject).field_appId = ((g)localList.get(i)).field_appId;
          ((o)localObject).field_sortId = i;
          localp.a((o)localObject);
          i += 1;
        }
        az.ayM();
        c.agw().qL(l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI
 * JD-Core Version:    0.7.0.1
 */