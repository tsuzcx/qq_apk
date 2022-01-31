package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;

public class ResourcesExceedUI
  extends MMActivity
{
  private int type = 0;
  private TextView vmG;
  
  protected final int getLayoutId()
  {
    return R.i.resources_exceed_ui;
  }
  
  protected final void initView()
  {
    setBackBtn(new ResourcesExceedUI.1(this));
    this.vmG = ((TextView)findViewById(R.h.download_fail_text));
    switch (this.type)
    {
    default: 
      return;
    case 0: 
      this.vmG.setText(R.l.video_fail_or_clean);
      return;
    case 2: 
      this.vmG.setText(R.l.file_fail_or_clean);
      return;
    }
    this.vmG.setText(R.l.imgdownload_fail_or_cleaned);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.type = getIntent().getIntExtra("clean_view_type", 0);
    setMMTitle("");
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ResourcesExceedUI
 * JD-Core Version:    0.7.0.1
 */