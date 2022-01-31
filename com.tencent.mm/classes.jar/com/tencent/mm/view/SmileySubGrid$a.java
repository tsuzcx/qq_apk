package com.tencent.mm.view;

import android.view.View;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SmileySubGrid$a
  extends SmileySubGrid.d
  implements Runnable
{
  private SmileySubGrid$a(SmileySubGrid paramSmileySubGrid)
  {
    super(paramSmileySubGrid, (byte)0);
  }
  
  public final void run()
  {
    AppMethodBeat.i(62955);
    ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "LongPress run");
    int i = this.ARL.acS;
    Object localObject = this.ARL;
    localObject = ((SmileySubGrid)localObject).getChildAt(i - ((SmileySubGrid)localObject).getFirstVisiblePosition());
    if (localObject != null)
    {
      int j = this.ARL.acS;
      long l = this.ARL.getAdapter().getItemId(this.ARL.acS);
      if (dNo())
      {
        ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", new Object[] { Integer.valueOf(j), Long.valueOf(l) });
        SmileySubGrid.a(this.ARL, (View)localObject, i);
        this.ARL.anS = -1;
        this.ARL.zis = 5;
        this.ARL.setScrollEnable(false);
      }
    }
    AppMethodBeat.o(62955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid.a
 * JD-Core Version:    0.7.0.1
 */