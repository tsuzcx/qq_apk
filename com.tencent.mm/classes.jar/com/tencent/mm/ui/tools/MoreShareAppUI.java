package com.tencent.mm.ui.tools;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.List;

public class MoreShareAppUI
  extends MMActivity
{
  private DragSortListView jdy;
  private List<f> uQU;
  private MoreShareAppUI.a wdH;
  
  protected final int getLayoutId()
  {
    return R.i.more_share_app;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.bottom_sheet_more_share);
    this.jdy = ((DragSortListView)findViewById(R.h.listview));
    this.jdy.setDropListener(new DragSortListView.h()
    {
      public final void cg(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        f localf = (f)MoreShareAppUI.a(MoreShareAppUI.this).getItem(paramAnonymousInt1);
        MoreShareAppUI.a.a(MoreShareAppUI.a(MoreShareAppUI.this)).remove(paramAnonymousInt1);
        MoreShareAppUI.a(MoreShareAppUI.this).notifyDataSetChanged();
        MoreShareAppUI.a(MoreShareAppUI.this).insert(localf, paramAnonymousInt2);
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    setBackBtn(new MoreShareAppUI.2(this));
    addTextOptionMenu(0, getString(R.l.emoji_sequence), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
    });
    this.wdH = new MoreShareAppUI.a(this, this.uQU);
    this.jdy.setAdapter(this.wdH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MoreShareAppUI
 * JD-Core Version:    0.7.0.1
 */