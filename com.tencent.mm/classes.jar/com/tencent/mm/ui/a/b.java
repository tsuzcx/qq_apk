package com.tencent.mm.ui.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private final String TAG;
  private List<String> adLp;
  
  public b()
  {
    AppMethodBeat.i(141500);
    this.TAG = "MicroMsg.Accessibility.Tool";
    this.adLp = new ArrayList();
    AppMethodBeat.o(141500);
  }
  
  public final b bzT(String paramString)
  {
    AppMethodBeat.i(141501);
    this.adLp.add(paramString);
    AppMethodBeat.o(141501);
    return this;
  }
  
  public final void kX(View paramView)
  {
    AppMethodBeat.i(141502);
    if ((paramView != null) && (this.adLp.size() > 0))
    {
      Iterator localIterator = this.adLp.iterator();
      String str2;
      for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + ",") {
        str2 = (String)localIterator.next();
      }
      paramView.setContentDescription(str1);
    }
    AppMethodBeat.o(141502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.a.b
 * JD-Core Version:    0.7.0.1
 */