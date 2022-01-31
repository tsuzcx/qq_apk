package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class ResourcesExceedUI
  extends MMActivity
{
  private int type = 0;
  private TextView zCc;
  
  public int getLayoutId()
  {
    return 2130970584;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30986);
    setBackBtn(new ResourcesExceedUI.1(this));
    this.zCc = ((TextView)findViewById(2131823463));
    switch (this.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30986);
      return;
      this.zCc.setText(2131304516);
      AppMethodBeat.o(30986);
      return;
      this.zCc.setText(2131299882);
      AppMethodBeat.o(30986);
      return;
      this.zCc.setText(2131300727);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30985);
    super.onCreate(paramBundle);
    this.type = getIntent().getIntExtra("clean_view_type", 0);
    setMMTitle("");
    initView();
    AppMethodBeat.o(30985);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30987);
    super.onDestroy();
    AppMethodBeat.o(30987);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ResourcesExceedUI
 * JD-Core Version:    0.7.0.1
 */