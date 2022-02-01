package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMActivity;

public class ReaderAppIntroUI
  extends MMActivity
{
  private int dEj = 0;
  
  public int getLayoutId()
  {
    return 2131495192;
  }
  
  public void initView()
  {
    AppMethodBeat.i(102705);
    ImageView localImageView = (ImageView)findViewById(2131303778);
    TextView localTextView = (TextView)findViewById(2131303779);
    this.dEj = getIntent().getIntExtra("type", 0);
    if (this.dEj == 20)
    {
      setMMTitle(2131760208);
      localImageView.setImageResource(2131233792);
      localTextView.setText(2131757782);
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(102702);
        ReaderAppIntroUI.this.finish();
        AppMethodBeat.o(102702);
        return true;
      }
    });
    addIconOptionMenu(0, 2131689511, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(102703);
        a.iRG.c(new Intent().putExtra("Contact_User", bp.oz(ReaderAppIntroUI.a(ReaderAppIntroUI.this))), ReaderAppIntroUI.this);
        ReaderAppIntroUI.this.finish();
        AppMethodBeat.o(102703);
        return true;
      }
    });
    AppMethodBeat.o(102705);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102704);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(102704);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppIntroUI
 * JD-Core Version:    0.7.0.1
 */