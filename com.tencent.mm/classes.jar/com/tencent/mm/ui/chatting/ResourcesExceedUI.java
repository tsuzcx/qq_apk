package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ui.MMActivity;

public class ResourcesExceedUI
  extends MMActivity
{
  private TextView aelo;
  private int type = 0;
  
  public void finish()
  {
    AppMethodBeat.i(34872);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(34872);
  }
  
  public int getLayoutId()
  {
    return R.i.gnD;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34870);
    hideTitleView();
    fullScreenNoTitleBar(true);
    if (d.rb(19))
    {
      getWindow().setFlags(201327616, 201327616);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(34867);
          ResourcesExceedUI.this.finish();
          AppMethodBeat.o(34867);
          return true;
        }
      });
      this.aelo = ((TextView)findViewById(R.h.fGh));
      switch (this.type)
      {
      }
    }
    for (;;)
    {
      findViewById(R.h.root_view).setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(34868);
          ResourcesExceedUI.this.finish();
          AppMethodBeat.o(34868);
          return false;
        }
      });
      AppMethodBeat.o(34870);
      return;
      getWindow().setFlags(1024, 1024);
      break;
      this.aelo.setText(R.l.gXE);
      continue;
      this.aelo.setText(R.l.gHD);
      continue;
      this.aelo.setText(R.l.gJE);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34869);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.type = getIntent().getIntExtra("clean_view_type", 0);
    setMMTitle("");
    initView();
    AppMethodBeat.o(34869);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34871);
    super.onDestroy();
    AppMethodBeat.o(34871);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ResourcesExceedUI
 * JD-Core Version:    0.7.0.1
 */