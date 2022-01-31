package com.tencent.xweb.xwalk;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnLongClickListener;

final class a$25
  implements View.OnLongClickListener
{
  a$25(a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    new AlertDialog.Builder(this.xlg.xgK).setTitle("提示").setMessage("清空保存页面文件").setPositiveButton("确定", new a.25.2(this)).setNegativeButton("取消", new a.25.1(this)).show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.25
 * JD-Core Version:    0.7.0.1
 */