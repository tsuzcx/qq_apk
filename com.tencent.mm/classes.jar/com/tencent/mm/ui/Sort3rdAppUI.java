package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.cf.h;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.o;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import java.util.Collections;
import java.util.List;

public class Sort3rdAppUI
  extends MMActivity
{
  private DragSortListView jdy;
  private long tBq;
  private Sort3rdAppUI.a uQT;
  private List<f> uQU;
  
  protected final int getLayoutId()
  {
    return R.i.sort_3rd_app_ui;
  }
  
  protected final void initView()
  {
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        Sort3rdAppUI.this.finish();
        return true;
      }
    });
    setMMTitle(getString(R.l.actionbar_setting));
    this.jdy = ((DragSortListView)findViewById(R.h.listview));
    this.jdy.setDropListener(new Sort3rdAppUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.tBq = getIntent().getLongExtra("KFlag", -1L);
    initView();
    this.uQU = g.b(this, this.tBq, true);
    paramBundle = ap.cld().hc(this.tBq);
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      Collections.sort(this.uQU, new Sort3rdAppUI.3(this, paramBundle));
    }
    this.uQT = new Sort3rdAppUI.a(this, this.uQU, this.tBq);
    this.jdy.setAdapter(this.uQT);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.uQT != null)
    {
      List localList = this.uQT.iVa;
      o localo = ap.cld();
      long l = this.tBq;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete from AppSort");
      ((StringBuilder)localObject).append(" where flag = ").append(l).append(" ");
      localObject = ((StringBuilder)localObject).toString();
      localo.dXw.gk("AppSort", (String)localObject);
      if ((localList != null) && (localList.size() > 0))
      {
        au.Hx();
        l = c.Dv().eV(Thread.currentThread().getId());
        localo = ap.cld();
        int i = 0;
        while (i < localList.size())
        {
          localObject = new n();
          ((n)localObject).field_flag = this.tBq;
          ((n)localObject).field_appId = ((f)localList.get(i)).field_appId;
          ((n)localObject).field_sortId = i;
          localo.a((n)localObject);
          i += 1;
        }
        au.Hx();
        c.Dv().hI(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI
 * JD-Core Version:    0.7.0.1
 */