package com.tencent.mm.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class SearchBarUI
  extends BaseActivity
  implements ac.a
{
  ac zeL;
  
  public void onClickBackBtn(View paramView)
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = BaseActivity.c.yUz;
    SearchBarUI.1 local1 = new SearchBarUI.1(this);
    BaseActivity.b localb = new BaseActivity.b();
    localb.yUo = 0;
    localb.yUp = 0;
    localb.text = "";
    localb.gBC = local1;
    localb.mAd = null;
    localb.yUt = paramBundle;
    if ((localb.yUp == 2130837620) && ("".length() <= 0)) {
      localb.text = getString(2131296400);
    }
    int j = localb.yUo;
    int i = 0;
    for (;;)
    {
      if (i < this.yUg.size())
      {
        if (((BaseActivity.b)this.yUg.get(i)).yUo == j)
        {
          ak.d("BaseActivity", "match menu, id ：" + j + ", remove it", new Object[0]);
          this.yUg.remove(i);
        }
      }
      else
      {
        this.yUg.add(localb);
        new Handler().postDelayed(new BaseActivity.6(this), 200L);
        setBackBtn(new SearchBarUI.2(this));
        return;
      }
      i += 1;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.SearchBarUI
 * JD-Core Version:    0.7.0.1
 */