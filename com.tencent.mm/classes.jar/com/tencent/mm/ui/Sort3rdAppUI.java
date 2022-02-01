package com.tencent.mm.ui;

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
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.s;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3rdAppUI
  extends MMActivity
{
  private long NlD;
  private Sort3rdAppUI.a adKl;
  private List<g> adKm;
  private DragSortListView xSK;
  
  protected int getLayoutId()
  {
    return R.i.gou;
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
    this.xSK = ((DragSortListView)findViewById(R.h.listview));
    this.xSK.setDropListener(new DragSortListView.h()
    {
      public final void drop(int paramAnonymousInt1, int paramAnonymousInt2)
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
    this.NlD = getIntent().getLongExtra("KFlag", -1L);
    initView();
    this.adKm = com.tencent.mm.pluginsdk.model.app.h.c(this, this.NlD, true);
    paramBundle = as.iIK().yj(this.NlD);
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      Collections.sort(this.adKm, new Comparator() {});
    }
    this.adKl = new Sort3rdAppUI.a(this, this.adKm, this.NlD);
    this.xSK.setAdapter(this.adKl);
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
    if (this.adKl != null)
    {
      List localList = this.adKl.xGG;
      t localt = as.iIK();
      long l = this.NlD;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete from AppSort");
      ((StringBuilder)localObject).append(" where flag = ").append(l).append(" ");
      localObject = ((StringBuilder)localObject).toString();
      localt.db.execSQL("AppSort", (String)localObject);
      if ((localList != null) && (localList.size() > 0))
      {
        bh.bCz();
        l = c.getDataDB().beginTransaction(Thread.currentThread().getId());
        localt = as.iIK();
        int i = 0;
        while (i < localList.size())
        {
          localObject = new s();
          ((s)localObject).field_flag = this.NlD;
          ((s)localObject).field_appId = ((g)localList.get(i)).field_appId;
          ((s)localObject).field_sortId = i;
          localt.a((s)localObject);
          i += 1;
        }
        bh.bCz();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI
 * JD-Core Version:    0.7.0.1
 */