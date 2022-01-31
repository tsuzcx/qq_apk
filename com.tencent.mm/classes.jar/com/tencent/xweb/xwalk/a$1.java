package com.tencent.xweb.xwalk;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    new AlertDialog.Builder(this.xlg.xgK).setTitle("保存页面").setMessage("确定保存页面？").setPositiveButton("确定", new a.1.2(this)).setNegativeButton("取消", new a.1.1(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.1
 * JD-Core Version:    0.7.0.1
 */