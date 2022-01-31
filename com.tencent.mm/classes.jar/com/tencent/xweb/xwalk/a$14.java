package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.xwalk.plugin.c;
import com.tencent.xweb.xwalk.plugin.c.b;
import java.util.HashMap;

final class a$14
  implements View.OnClickListener
{
  a$14(a parama) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.xlg;
    c localc = new c();
    Object localObject = new a.26(paramView, localc);
    localc.xmt = "FullScreenVideo";
    localc.xmu = ((c.b)localObject);
    localObject = new HashMap();
    ((HashMap)localObject).put("UpdaterCheckType", "1");
    localc.a(paramView.xgK, (HashMap)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.14
 * JD-Core Version:    0.7.0.1
 */