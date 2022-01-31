package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class FavRecordDetailUI$4
  implements Runnable
{
  FavRecordDetailUI$4(FavRecordDetailUI paramFavRecordDetailUI, List paramList) {}
  
  public final void run()
  {
    if (this.ntJ == null) {
      return;
    }
    y.i("MicroMsg.FavRecordDetailUI", "start calc");
    Object localObject = this.ntJ.iterator();
    long l = 0L;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      xv localxv = (xv)((Iterator)localObject).next();
      if ((localxv != null) && (!FavRecordDetailUI.e(this.ntD))) {
        switch (localxv.aYU)
        {
        default: 
          m += 1;
          break;
        case 2: 
          j += 1;
          break;
        case 1: 
          i += 1;
          l = localxv.desc.getBytes().length + l;
          break;
        case 4: 
        case 15: 
          k += 1;
        }
      }
    }
    localObject = String.format("%s:%s:%s:%s:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
    FavRecordDetailUI.a(this.ntD, (String)localObject);
    y.v("MicroMsg.FavRecordDetailUI", "start calc finish %s", new Object[] { localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.4
 * JD-Core Version:    0.7.0.1
 */