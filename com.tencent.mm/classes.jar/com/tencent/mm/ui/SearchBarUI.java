package com.tencent.mm.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.mm.ci.a.e;
import com.tencent.mm.ci.a.i;
import java.util.LinkedList;

public abstract class SearchBarUI
  extends BaseActivity
  implements ah.a
{
  ah uQz;
  
  public void onClickBackBtn(View paramView)
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = BaseActivity.c.uHo;
    SearchBarUI.1 local1 = new SearchBarUI.1(this);
    BaseActivity.b localb = new BaseActivity.b();
    localb.uHd = 0;
    localb.uHe = 0;
    localb.text = "";
    localb.fkl = local1;
    localb.kfL = null;
    localb.uHi = paramBundle;
    if ((localb.uHe == a.e.actionbar_icon_dark_more) && ("".length() <= 0)) {
      localb.text = getString(a.i.actionbar_more);
    }
    int j = localb.uHd;
    int i = 0;
    for (;;)
    {
      if (i < this.uGV.size())
      {
        if (((BaseActivity.b)this.uGV.get(i)).uHd == j)
        {
          ao.s("match menu, id ：" + j + ", remove it", new Object[0]);
          this.uGV.remove(i);
        }
      }
      else
      {
        this.uGV.add(localb);
        new Handler().postDelayed(new BaseActivity.6(this), 200L);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            SearchBarUI.this.finish();
            return true;
          }
        });
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.SearchBarUI
 * JD-Core Version:    0.7.0.1
 */