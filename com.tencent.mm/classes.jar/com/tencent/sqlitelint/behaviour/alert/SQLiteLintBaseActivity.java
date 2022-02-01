package com.tencent.sqlitelint.behaviour.alert;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.Toolbar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.sqlitelint.R.id;
import com.tencent.sqlitelint.R.layout;

public abstract class SQLiteLintBaseActivity
  extends HellActivity
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    onCreateView();
  }
  
  protected void onCreateView()
  {
    setContentView(R.layout.activity_sqlitelint_base);
    Object localObject = (FrameLayout)findViewById(R.id.content);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this);
    int i = getLayoutId();
    assert (i != 0);
    localLayoutInflater.inflate(i, (ViewGroup)localObject);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mToolBar = ((Toolbar)findViewById(R.id.toolbar));
      this.mToolBar.setNavigationOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(52910);
          SQLiteLintBaseActivity.this.onBackBtnClick();
          AppMethodBeat.o(52910);
        }
      });
      localObject = this.mToolBar.getLogo();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, true);
      }
      return;
    }
    Toast.makeText(this, "SQLiteLint toolbar only support in api level >= 21.", 1);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void setTitle(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.mToolBar.setTitle(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity
 * JD-Core Version:    0.7.0.1
 */