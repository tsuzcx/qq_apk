package com.tencent.mm.ui.a;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private final String TAG = "MicroMsg.Accessibility.Tool";
  private List<String> uRx = new ArrayList();
  
  public final b acY(String paramString)
  {
    this.uRx.add(paramString);
    return this;
  }
  
  public final void dB(View paramView)
  {
    if ((paramView != null) && (this.uRx.size() > 0))
    {
      Iterator localIterator = this.uRx.iterator();
      String str2;
      for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + ",") {
        str2 = (String)localIterator.next();
      }
      paramView.setContentDescription(str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.a.b
 * JD-Core Version:    0.7.0.1
 */