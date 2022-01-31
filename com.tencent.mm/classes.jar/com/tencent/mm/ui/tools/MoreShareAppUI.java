package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.List;

public class MoreShareAppUI
  extends MMActivity
{
  private MoreShareAppUI.a Awr;
  private DragSortListView lml;
  private List<f> zfg;
  
  public int getLayoutId()
  {
    return 2130970298;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34889);
    setMMTitle(2131297807);
    this.lml = ((DragSortListView)findViewById(2131821736));
    this.lml.setDropListener(new DragSortListView.h()
    {
      public final void dp(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(34884);
        f localf = (f)MoreShareAppUI.a(MoreShareAppUI.this).getItem(paramAnonymousInt1);
        MoreShareAppUI.a.a(MoreShareAppUI.a(MoreShareAppUI.this)).remove(paramAnonymousInt1);
        MoreShareAppUI.a(MoreShareAppUI.this).notifyDataSetChanged();
        MoreShareAppUI.a(MoreShareAppUI.this).insert(localf, paramAnonymousInt2);
        AppMethodBeat.o(34884);
      }
    });
    AppMethodBeat.o(34889);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34888);
    super.onCreate(paramBundle);
    initView();
    setBackBtn(new MoreShareAppUI.2(this));
    addTextOptionMenu(0, getString(2131299173), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
    });
    this.Awr = new MoreShareAppUI.a(this, this.zfg);
    this.lml.setAdapter(this.Awr);
    AppMethodBeat.o(34888);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MoreShareAppUI
 * JD-Core Version:    0.7.0.1
 */