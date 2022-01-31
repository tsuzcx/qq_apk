package com.tencent.mm.ui.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private final String TAG;
  private List<String> zfY;
  
  public b()
  {
    AppMethodBeat.i(106140);
    this.TAG = "MicroMsg.Accessibility.Tool";
    this.zfY = new ArrayList();
    AppMethodBeat.o(106140);
  }
  
  public final b atr(String paramString)
  {
    AppMethodBeat.i(106141);
    this.zfY.add(paramString);
    AppMethodBeat.o(106141);
    return this;
  }
  
  public final void eK(View paramView)
  {
    AppMethodBeat.i(106142);
    if ((paramView != null) && (this.zfY.size() > 0))
    {
      Iterator localIterator = this.zfY.iterator();
      String str2;
      for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + ",") {
        str2 = (String)localIterator.next();
      }
      paramView.setContentDescription(str1);
    }
    AppMethodBeat.o(106142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.a.b
 * JD-Core Version:    0.7.0.1
 */