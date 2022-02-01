package com.tencent.mm.ui.widget.picker.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class b
  implements c
{
  private Context ctx;
  private final String[] iNh;
  private final int[] iNi;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(200542);
    this.iNh = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
    this.iNi = new int[] { 2131761916, 2131761915, 2131761919, 2131761912, 2131761920, 2131761918, 2131761917, 2131761913, 2131761923, 2131761922, 2131761921, 2131761914 };
    this.ctx = paramContext;
    AppMethodBeat.o(200542);
  }
  
  public final String Ji(String paramString)
  {
    AppMethodBeat.i(200543);
    Assert.assertEquals(12, this.iNh.length);
    Assert.assertEquals(12, this.iNi.length);
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < this.iNh.length)
      {
        if (paramString.equals(this.iNh[i])) {
          str = this.ctx.getResources().getString(this.iNi[i]);
        }
      }
      else
      {
        AppMethodBeat.o(200543);
        return str;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.b
 * JD-Core Version:    0.7.0.1
 */