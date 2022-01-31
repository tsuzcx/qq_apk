package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.axt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

public class ReaderAppSubscribeUI
  extends MMActivity
{
  private ListView noG;
  private ReaderAppSubscribeUI.a noH;
  
  private void ws(int paramInt)
  {
    g.DP().Dz().o(868518889, Integer.valueOf(paramInt));
    Object localObject = new axt();
    ((axt)localObject).ttW = paramInt;
    ((j)g.r(j.class)).Fv().b(new i.a(43, (com.tencent.mm.bv.a)localObject));
    localObject = new Intent();
    ((Intent)localObject).putExtra("Contact_User", "newsapp");
    ((Intent)localObject).addFlags(67108864);
    com.tencent.mm.plugin.readerapp.b.a.eUR.d((Intent)localObject, this);
    finish();
  }
  
  protected final int getLayoutId()
  {
    return a.e.readerapp_subscribe_list;
  }
  
  protected final void initView()
  {
    this.noH = new ReaderAppSubscribeUI.a(this, bk.g((Integer)g.DP().Dz().get(868518889, null)));
    this.noG = ((ListView)findViewById(a.d.readerapp_subscribe_lv));
    this.noG.setAdapter(this.noH);
    this.noG.setOnItemClickListener(new ReaderAppSubscribeUI.1(this));
    this.noH.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this, ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this).noK);
        return true;
      }
    });
    new ReaderAppSubscribeUI.3(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g.DP().Dz().o(868518890, "in");
    setMMTitle(a.g.contact_info_readerappnews_subscribe);
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.noH != null) {
        ws(this.noH.noK);
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.noH.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI
 * JD-Core Version:    0.7.0.1
 */