package com.tencent.mm.plugin.sight.draft.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;

public class SightDraftUI
  extends MMActivity
{
  private int Jut;
  SightDraftContainerView Juu;
  private LinkedList<String> Juv;
  
  public SightDraftUI()
  {
    AppMethodBeat.i(28699);
    this.Jut = 1;
    this.Juv = new LinkedList();
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
    setMMTitle(R.l.sight_old_draft_title);
    getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.e.black));
    this.Juu = new SightDraftContainerView(this);
    setContentView(this.Juu);
    this.Juu.fIZ();
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
    this.Juu.setSightDraftCallback(new a()
    {
      public final void fIW()
      {
        AppMethodBeat.i(28697);
        SightDraftUI.this.addTextOptionMenu(SightDraftUI.a(SightDraftUI.this), SightDraftUI.this.getString(R.l.sight_draft_save), new MenuItem.OnMenuItemClickListener()
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
      
      public final void fIX()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftUI
 * JD-Core Version:    0.7.0.1
 */