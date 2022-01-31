package com.tencent.mm.wear.app.ui.emoji;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.wear.app.d.f;
import com.tencent.mm.wear.app.ui.MMActivity;
import com.tencent.mm.wear.app.ui.MMAvatarActivity;

public class ReplyEmojiListUI
  extends MMAvatarActivity
{
  private AdapterView.OnItemClickListener aeI = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      int i = ReplyEmojiListUI.a(ReplyEmojiListUI.this).getHeaderViewsCount();
      if ((paramAnonymousInt == i) && (ReplyEmojiListUI.b(ReplyEmojiListUI.this).nn()))
      {
        paramAnonymousAdapterView = new Intent(ReplyEmojiListUI.this, HeartBeatEmojiUI.class);
        ReplyEmojiListUI.this.e(paramAnonymousAdapterView);
        return;
      }
      paramAnonymousAdapterView = ReplyEmojiListUI.b(ReplyEmojiListUI.this).bX(paramAnonymousInt - i);
      paramAnonymousView = new Intent(ReplyEmojiListUI.this, DetailEmojiListUI.class);
      paramAnonymousView.putExtra("key_product_id", paramAnonymousAdapterView.afs);
      ReplyEmojiListUI.this.e(paramAnonymousView);
    }
  };
  private ListView afT;
  private d afU;
  
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
        if (nd() > 0) {
          f.i(this, nd());
        }
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.afT = ((ListView)findViewById(2131558454));
    if (!MMActivity.isRect())
    {
      paramBundle = getLayoutInflater().inflate(2130903050, null);
      View localView = getLayoutInflater().inflate(2130903049, null);
      this.afT.addHeaderView(paramBundle);
      this.afT.addFooterView(localView);
      this.afT.setPadding(36, 0, 36, 0);
    }
    this.afU = new d(this);
    this.afT.setAdapter(this.afU);
    this.afT.setOnItemClickListener(this.aeI);
    N(getUsername());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.emoji.ReplyEmojiListUI
 * JD-Core Version:    0.7.0.1
 */