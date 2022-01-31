package com.tencent.mm.plugin.shake.ui;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;

public class ShakeTvHistoryListUI
  extends MMActivity
{
  private n.d hZq = new ShakeTvHistoryListUI.5(this);
  private ShakeTvHistoryListUI.a odx;
  private ListView ody;
  private String username;
  
  protected final int getLayoutId()
  {
    return R.i.shake_tv_history_list;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.shake_tv_history_list_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        ShakeTvHistoryListUI.this.XM();
        ShakeTvHistoryListUI.this.finish();
        return true;
      }
    });
    addTextOptionMenu(0, getString(R.l.app_clear), new ShakeTvHistoryListUI.2(this));
    this.ody = ((ListView)findViewById(R.h.shake_tv_history_listview));
    this.odx = new ShakeTvHistoryListUI.a(this, this);
    this.ody.setAdapter(this.odx);
    this.ody.setOnItemClickListener(new ShakeTvHistoryListUI.3(this));
    j localj = new j(this);
    this.ody.setOnItemLongClickListener(new ShakeTvHistoryListUI.4(this, localj));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.username = ((n)this.odx.getItem(paramView.position)).field_username;
    paramContextMenu.add(paramView.position, 0, 0, R.l.app_delete);
  }
  
  public void onDestroy()
  {
    this.odx.bcS();
    super.onDestroy();
  }
  
  final class a$a
  {
    TextView haW;
    TextView lLL;
    MMImageView odB;
    
    a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI
 * JD-Core Version:    0.7.0.1
 */