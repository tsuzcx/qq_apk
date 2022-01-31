package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.al;
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
  private DragSortListView lml;
  private long xCZ;
  private Sort3rdAppUI.a zff;
  private List<f> zfg;
  
  protected int getLayoutId()
  {
    return 2130970900;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(29905);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29897);
        Sort3rdAppUI.this.finish();
        AppMethodBeat.o(29897);
        return true;
      }
    });
    setMMTitle(getString(2131296404));
    this.lml = ((DragSortListView)findViewById(2131821736));
    this.lml.setDropListener(new Sort3rdAppUI.2(this));
    AppMethodBeat.o(29905);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29904);
    super.onCreate(paramBundle);
    this.xCZ = getIntent().getLongExtra("KFlag", -1L);
    initView();
    this.zfg = g.b(this, this.xCZ, true);
    paramBundle = al.dlM().ny(this.xCZ);
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      Collections.sort(this.zfg, new Sort3rdAppUI.3(this, paramBundle));
    }
    this.zff = new Sort3rdAppUI.a(this, this.zfg, this.xCZ);
    this.lml.setAdapter(this.zff);
    AppMethodBeat.o(29904);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29906);
    super.onDestroy();
    AppMethodBeat.o(29906);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29907);
    super.onPause();
    if (this.zff != null)
    {
      List localList = this.zff.lee;
      o localo = al.dlM();
      long l = this.xCZ;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete from AppSort");
      ((StringBuilder)localObject).append(" where flag = ").append(l).append(" ");
      localObject = ((StringBuilder)localObject).toString();
      localo.db.execSQL("AppSort", (String)localObject);
      if ((localList != null) && (localList.size() > 0))
      {
        aw.aaz();
        l = c.Rq().kr(Thread.currentThread().getId());
        localo = al.dlM();
        int i = 0;
        while (i < localList.size())
        {
          localObject = new n();
          ((n)localObject).field_flag = this.xCZ;
          ((n)localObject).field_appId = ((f)localList.get(i)).field_appId;
          ((n)localObject).field_sortId = i;
          localo.a((n)localObject);
          i += 1;
        }
        aw.aaz();
        c.Rq().nY(l);
      }
    }
    AppMethodBeat.o(29907);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI
 * JD-Core Version:    0.7.0.1
 */