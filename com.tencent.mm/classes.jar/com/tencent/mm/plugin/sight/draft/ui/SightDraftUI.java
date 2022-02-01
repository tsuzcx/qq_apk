package com.tencent.mm.plugin.sight.draft.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public class SightDraftUI
  extends MMActivity
{
  private int DoO;
  SightDraftContainerView DoP;
  private LinkedList<String> DoQ;
  
  public SightDraftUI()
  {
    AppMethodBeat.i(28699);
    this.DoO = 1;
    this.DoQ = new LinkedList();
    AppMethodBeat.o(28699);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28700);
    super.onCreate(paramBundle);
    setMMTitle(2131765899);
    getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(2131100042));
    this.DoP = new SightDraftContainerView(this);
    setContentView(this.DoP);
    this.DoP.eVW();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28695);
        SightDraftUI.this.finish();
        AppMethodBeat.o(28695);
        return false;
      }
    });
    this.DoP.setSightDraftCallback(new a()
    {
      public final void eVT()
      {
        AppMethodBeat.i(28697);
        SightDraftUI.this.addTextOptionMenu(SightDraftUI.a(SightDraftUI.this), SightDraftUI.this.getString(2131765888), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
          {
            AppMethodBeat.i(28696);
            SightDraftUI.b(SightDraftUI.this);
            AppMethodBeat.o(28696);
            return true;
          }
        });
        AppMethodBeat.o(28697);
      }
      
      public final void eVU()
      {
        AppMethodBeat.i(28698);
        SightDraftUI.this.removeOptionMenu(SightDraftUI.a(SightDraftUI.this));
        AppMethodBeat.o(28698);
      }
    });
    AppMethodBeat.o(28700);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftUI
 * JD-Core Version:    0.7.0.1
 */