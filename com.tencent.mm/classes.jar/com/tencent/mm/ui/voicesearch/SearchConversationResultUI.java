package com.tencent.mm.ui.voicesearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class SearchConversationResultUI
  extends MMActivity
{
  private String ABA = null;
  private ListView ABy;
  private a ABz;
  private TextView kIg;
  private String username;
  
  public int getLayoutId()
  {
    return 2130971101;
  }
  
  public void initView()
  {
    AppMethodBeat.i(35323);
    this.ABy = ((ListView)findViewById(2131828799));
    this.kIg = ((TextView)findViewById(2131821075));
    this.ABz = new a(getApplicationContext(), new SearchConversationResultUI.1(this));
    if (this.ABz != null) {
      this.ABz.ft(new LinkedList());
    }
    this.ABy.setAdapter(this.ABz);
    this.kIg.setVisibility(8);
    this.username = getIntent().getStringExtra("SearchConversationResult_User");
    this.ABA = getIntent().getStringExtra("SearchConversationResult_Error");
    setMMTitle(getString(2131304590));
    setBackBtn(new SearchConversationResultUI.2(this));
    this.ABy.setOnItemClickListener(new SearchConversationResultUI.3(this));
    String str = this.username;
    this.kIg.setVisibility(8);
    if (this.ABz != null) {
      this.ABz.wQ(str);
    }
    AppMethodBeat.o(35323);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35318);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(35318);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35320);
    super.onDestroy();
    this.ABz.bKb();
    AppMethodBeat.o(35320);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35321);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(35321);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.SearchConversationResultUI
 * JD-Core Version:    0.7.0.1
 */