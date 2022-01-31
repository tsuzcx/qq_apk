package com.tencent.mm.ui.websearch;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class WebSearchBaseActivity
  extends CustomStatusBarMMActivity
{
  protected final int getStatusBarColor()
  {
    return getResources().getColor(2131690690);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtnColorFilter(-16777216);
    setMMTitleColor(-16777216);
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(2131690690));
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131690690)));
    }
    setBackBtn(new WebSearchBaseActivity.1(this));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.websearch.WebSearchBaseActivity
 * JD-Core Version:    0.7.0.1
 */