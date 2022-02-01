package com.tencent.mm.wear.app.ui.emoji;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.wear.app.d.g;
import com.tencent.mm.wear.app.ui.MMActivity;
import com.tencent.mm.wear.app.ui.MMAvatarActivity;

public class ReplyEmojiListUI
  extends MMAvatarActivity
{
  private AdapterView.OnItemClickListener aik = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      int i = ReplyEmojiListUI.a(ReplyEmojiListUI.this).getHeaderViewsCount();
      if ((paramAnonymousInt == i) && (ReplyEmojiListUI.b(ReplyEmojiListUI.this).oa()))
      {
        paramAnonymousAdapterView = new Intent(ReplyEmojiListUI.this, HeartBeatEmojiUI.class);
        ReplyEmojiListUI.this.g(paramAnonymousAdapterView);
        return;
      }
      paramAnonymousAdapterView = ReplyEmojiListUI.b(ReplyEmojiListUI.this).ct(paramAnonymousInt - i);
      paramAnonymousView = new Intent(ReplyEmojiListUI.this, DetailEmojiListUI.class);
      paramAnonymousView.putExtra("key_product_id", paramAnonymousAdapterView.aiU);
      ReplyEmojiListUI.this.g(paramAnonymousView);
    }
  };
  private ListView ajv;
  private d ajw;
  
  public final int getLayoutId()
  {
    return 2130903052;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        if (nQ() > 0) {
          g.i(this, nQ());
        }
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ajv = ((ListView)findViewById(2131558455));
    if (!MMActivity.isRect())
    {
      paramBundle = getLayoutInflater().inflate(2130903050, null);
      View localView = getLayoutInflater().inflate(2130903049, null);
      this.ajv.addHeaderView(paramBundle);
      this.ajv.addFooterView(localView);
      this.ajv.setPadding(36, 0, 36, 0);
    }
    this.ajw = new d(this);
    this.ajv.setAdapter(this.ajw);
    this.ajv.setOnItemClickListener(this.aik);
    U(getUsername());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.emoji.ReplyEmojiListUI
 * JD-Core Version:    0.7.0.1
 */