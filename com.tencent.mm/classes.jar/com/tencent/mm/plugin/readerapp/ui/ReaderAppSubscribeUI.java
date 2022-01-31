package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

public class ReaderAppSubscribeUI
  extends MMActivity
{
  private ListView pTU;
  private ReaderAppSubscribeUI.a pTV;
  
  private void Ce(int paramInt)
  {
    AppMethodBeat.i(76810);
    g.RL().Ru().set(868518889, Integer.valueOf(paramInt));
    Object localObject = new bem();
    ((bem)localObject).xtY = paramInt;
    ((j)g.E(j.class)).Yz().c(new j.a(43, (com.tencent.mm.bv.a)localObject));
    localObject = new Intent();
    ((Intent)localObject).putExtra("Contact_User", "newsapp");
    ((Intent)localObject).addFlags(67108864);
    com.tencent.mm.plugin.readerapp.b.a.gmO.c((Intent)localObject, this);
    finish();
    AppMethodBeat.o(76810);
  }
  
  public int getLayoutId()
  {
    return 2130970520;
  }
  
  public void initView()
  {
    AppMethodBeat.i(76808);
    this.pTV = new ReaderAppSubscribeUI.a(this, bo.g((Integer)g.RL().Ru().get(868518889, null)));
    this.pTU = ((ListView)findViewById(2131827045));
    this.pTU.setAdapter(this.pTV);
    this.pTU.setOnItemClickListener(new ReaderAppSubscribeUI.1(this));
    this.pTV.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(76803);
        ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this, ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this).pTY);
        AppMethodBeat.o(76803);
        return true;
      }
    });
    setToTop(new ReaderAppSubscribeUI.3(this));
    AppMethodBeat.o(76808);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(76807);
    super.onCreate(paramBundle);
    g.RL().Ru().set(868518890, "in");
    setMMTitle(2131298717);
    initView();
    AppMethodBeat.o(76807);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(76809);
    if (paramInt == 4)
    {
      if (this.pTV != null) {
        Ce(this.pTV.pTY);
      }
      AppMethodBeat.o(76809);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(76809);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(76811);
    super.onResume();
    this.pTV.notifyDataSetChanged();
    AppMethodBeat.o(76811);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI
 * JD-Core Version:    0.7.0.1
 */