package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import com.tencent.xweb.xwalk.plugin.b;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

final class a$15
  implements View.OnClickListener
{
  a$15(a parama) {}
  
  public final void onClick(View paramView)
  {
    paramView = XWalkPluginManager.cTF().iterator();
    while (paramView.hasNext()) {
      ((b)paramView.next()).KJ(-1);
    }
    paramView = XWalkEnvironment.getPluginBaseDir();
    if (paramView.isEmpty()) {
      return;
    }
    com.tencent.xweb.util.a.agX(paramView);
    this.xlg.afz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.15
 * JD-Core Version:    0.7.0.1
 */