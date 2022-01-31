package com.tencent.mm.plugin.record.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

final class FavRecordDetailUI$4
  implements Runnable
{
  FavRecordDetailUI$4(FavRecordDetailUI paramFavRecordDetailUI, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(24209);
    if (this.pZr == null)
    {
      AppMethodBeat.o(24209);
      return;
    }
    ab.i("MicroMsg.FavRecordDetailUI", "start calc");
    Object localObject = this.pZr.iterator();
    long l1 = 0L;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      aca localaca = (aca)((Iterator)localObject).next();
      if ((localaca != null) && (!FavRecordDetailUI.e(this.pZl))) {
        switch (localaca.dataType)
        {
        default: 
          m += 1;
          break;
        case 2: 
          j += 1;
          break;
        case 1: 
          i += 1;
          if (localaca.desc != null) {}
          for (long l2 = localaca.desc.getBytes().length;; l2 = 0L)
          {
            l1 = l2 + l1;
            break;
          }
        case 4: 
        case 15: 
          k += 1;
        }
      }
    }
    localObject = String.format("%s:%s:%s:%s:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
    FavRecordDetailUI.a(this.pZl, (String)localObject);
    ab.v("MicroMsg.FavRecordDetailUI", "start calc finish %s", new Object[] { localObject });
    AppMethodBeat.o(24209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.4
 * JD-Core Version:    0.7.0.1
 */