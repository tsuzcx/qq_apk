package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class SearchConversationResultUI
  extends MMActivity
{
  private TextView iCZ;
  private String username;
  private ListView wiG;
  private a wiH;
  private String wiI = null;
  
  protected final int getLayoutId()
  {
    return R.i.voice_search_result;
  }
  
  protected final void initView()
  {
    this.wiG = ((ListView)findViewById(R.h.voice_search_resultlist));
    this.iCZ = ((TextView)findViewById(R.h.empty_voicesearch_tip_tv));
    this.wiH = new a(getApplicationContext(), new SearchConversationResultUI.1(this));
    if (this.wiH != null) {
      this.wiH.ej(new LinkedList());
    }
    this.wiG.setAdapter(this.wiH);
    this.iCZ.setVisibility(8);
    this.username = getIntent().getStringExtra("SearchConversationResult_User");
    this.wiI = getIntent().getStringExtra("SearchConversationResult_Error");
    setMMTitle(getString(R.l.voice_search_result));
    setBackBtn(new SearchConversationResultUI.2(this));
    this.wiG.setOnItemClickListener(new SearchConversationResultUI.3(this));
    String str = this.username;
    this.iCZ.setVisibility(8);
    if (this.wiH != null) {
      this.wiH.pA(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.wiH.bcS();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.SearchConversationResultUI
 * JD-Core Version:    0.7.0.1
 */