package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class ShakeTvHistoryListUI
  extends MMActivity
{
  private n.d jSn;
  private ShakeTvHistoryListUI.a qRE;
  private ListView qRF;
  private String username;
  
  public ShakeTvHistoryListUI()
  {
    AppMethodBeat.i(24903);
    this.jSn = new ShakeTvHistoryListUI.5(this);
    AppMethodBeat.o(24903);
  }
  
  public int getLayoutId()
  {
    return 2130970720;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24906);
    setMMTitle(2131303653);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(24892);
        ShakeTvHistoryListUI.this.hideVKB();
        ShakeTvHistoryListUI.this.finish();
        AppMethodBeat.o(24892);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131296891), new ShakeTvHistoryListUI.2(this));
    this.qRF = ((ListView)findViewById(2131827758));
    this.qRE = new ShakeTvHistoryListUI.a(this, this);
    this.qRF.setAdapter(this.qRE);
    this.qRF.setOnItemClickListener(new ShakeTvHistoryListUI.3(this));
    l locall = new l(this);
    this.qRF.setOnItemLongClickListener(new ShakeTvHistoryListUI.4(this, locall));
    AppMethodBeat.o(24906);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24904);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(24904);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(24907);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.username = ((n)this.qRE.getItem(paramView.position)).field_username;
    paramContextMenu.add(paramView.position, 0, 0, 2131296901);
    AppMethodBeat.o(24907);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24905);
    this.qRE.bKb();
    super.onDestroy();
    AppMethodBeat.o(24905);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a$a
  {
    TextView iJG;
    TextView ojf;
    MMImageView qRI;
    
    a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI
 * JD-Core Version:    0.7.0.1
 */