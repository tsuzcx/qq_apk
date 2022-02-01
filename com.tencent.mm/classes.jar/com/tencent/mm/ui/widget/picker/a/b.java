package com.tencent.mm.ui.widget.picker.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class b
  implements c
{
  private Context ctx;
  private final String[] jJU;
  private final int[] jJV;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(198500);
    this.jJU = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
    this.jJV = new int[] { 2131763922, 2131763921, 2131763925, 2131763918, 2131763926, 2131763924, 2131763923, 2131763919, 2131763929, 2131763928, 2131763927, 2131763920 };
    this.ctx = paramContext;
    AppMethodBeat.o(198500);
  }
  
  public final String Sf(String paramString)
  {
    AppMethodBeat.i(198501);
    Assert.assertEquals(12, this.jJU.length);
    Assert.assertEquals(12, this.jJV.length);
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < this.jJU.length)
      {
        if (paramString.equals(this.jJU[i])) {
          str = this.ctx.getResources().getString(this.jJV[i]);
        }
      }
      else
      {
        AppMethodBeat.o(198501);
        return str;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.b
 * JD-Core Version:    0.7.0.1
 */