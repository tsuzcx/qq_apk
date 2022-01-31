package com.tencent.sqlitelint.behaviour.alert;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class SQLiteLintBaseActivity
  extends Activity
{
  private Toolbar mToolBar;
  
  static
  {
    if (!SQLiteLintBaseActivity.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  protected abstract int getLayoutId();
  
  protected void onBackBtnClick()
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    onCreateView();
  }
  
  protected void onCreateView()
  {
    setContentView(2130968628);
    Object localObject = (FrameLayout)findViewById(2131820946);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this);
    int i = getLayoutId();
    assert (i != 0);
    localLayoutInflater.inflate(i, (ViewGroup)localObject);
    this.mToolBar = ((Toolbar)findViewById(2131821034));
    this.mToolBar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94066);
        SQLiteLintBaseActivity.this.onBackBtnClick();
        AppMethodBeat.o(94066);
      }
    });
    localObject = this.mToolBar.getLogo();
    if (localObject != null) {
      ((Drawable)localObject).setVisible(false, true);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void setTitle(String paramString)
  {
    this.mToolBar.setTitle(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity
 * JD-Core Version:    0.7.0.1
 */