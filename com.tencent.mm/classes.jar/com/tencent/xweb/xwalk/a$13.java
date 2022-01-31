package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.xweb.xwalk.plugin.c;
import java.util.HashMap;

final class a$13
  implements View.OnClickListener
{
  a$13(a parama) {}
  
  public final void onClick(View paramView)
  {
    paramView = new c();
    HashMap localHashMap = new HashMap();
    localHashMap.put("UpdaterCheckType", "1");
    paramView.a(this.xlg.xgK, localHashMap);
    Toast.makeText(this.xlg.xgK, "开始检测插件更新", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.13
 * JD-Core Version:    0.7.0.1
 */