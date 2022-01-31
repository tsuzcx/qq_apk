package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import com.tencent.mm.R.e;

public abstract class WebSearchBaseActivity
  extends CustomStatusBarMMActivity
{
  protected final int getStatusBarColor()
  {
    return getResources().getColor(R.e.websearch_bg);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    czn();
    oX(-16777216);
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(R.e.websearch_bg));
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.websearch_bg)));
    }
    setBackBtn(new WebSearchBaseActivity.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WebSearchBaseActivity
 * JD-Core Version:    0.7.0.1
 */