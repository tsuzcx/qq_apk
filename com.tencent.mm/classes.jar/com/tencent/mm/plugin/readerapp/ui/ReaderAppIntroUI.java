package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMActivity;

public class ReaderAppIntroUI
  extends MMActivity
{
  private int dXa = 0;
  
  public int getLayoutId()
  {
    return 2131496035;
  }
  
  public void initView()
  {
    AppMethodBeat.i(102705);
    ImageView localImageView = (ImageView)findViewById(2131306567);
    TextView localTextView = (TextView)findViewById(2131306568);
    this.dXa = getIntent().getIntExtra("type", 0);
    if (this.dXa == 20)
    {
      setMMTitle(2131761594);
      localImageView.setImageResource(2131234613);
      localTextView.setText(2131758022);
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
    addIconOptionMenu(0, 2131689513, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(102703);
        a.jRt.c(new Intent().putExtra("Contact_User", bv.sd(ReaderAppIntroUI.a(ReaderAppIntroUI.this))), ReaderAppIntroUI.this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppIntroUI
 * JD-Core Version:    0.7.0.1
 */