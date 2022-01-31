package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.Map;

final class d$1$1
  implements Runnable
{
  d$1$1(d.1 param1, com.tencent.mm.plugin.fav.a.c paramc) {}
  
  public final void run()
  {
    Object localObject1 = (View)com.tencent.mm.plugin.record.ui.b.c.nuD.get(this.nty.field_dataId);
    boolean bool;
    if (localObject1 == null)
    {
      bool = true;
      y.d("MicroMsg.FavRecordAdapter", "view is null %s", new Object[] { Boolean.valueOf(bool) });
      if (localObject1 != null) {
        break label53;
      }
    }
    label53:
    String str;
    do
    {
      return;
      bool = false;
      break;
      localObject2 = (com.tencent.mm.plugin.record.ui.a.b)((View)localObject1).getTag();
      str = com.tencent.mm.plugin.record.b.b.a((com.tencent.mm.plugin.record.ui.a.b)localObject2);
      y.d("MicroMsg.FavRecordAdapter", "dataItemId: %s", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject2).bNt.kgC });
    } while (!((com.tencent.mm.plugin.record.ui.a.b)localObject2).bNt.kgC.equals(this.nty.field_dataId));
    y.d("MicroMsg.FavRecordAdapter", "change the sight status %s, dataId %s, progress %s cdnInfo %s", new Object[] { Integer.valueOf(this.nty.field_status), this.nty.field_dataId, Float.valueOf(this.nty.getProgress()), Boolean.valueOf(this.nty.isFinished()) });
    Object localObject2 = (ImageView)((View)localObject1).findViewById(R.h.status_btn);
    MMPinProgressBtn localMMPinProgressBtn = (MMPinProgressBtn)((View)localObject1).findViewById(R.h.progress);
    localObject1 = (a)((View)localObject1).findViewById(R.h.image);
    ((ImageView)localObject2).setVisibility(8);
    localMMPinProgressBtn.setVisibility(8);
    y.i("MicroMsg.FavRecordAdapter", "setVideoPath " + str);
    ((a)localObject1).setCanPlay(true);
    ((a)localObject1).aW(str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.d.1.1
 * JD-Core Version:    0.7.0.1
 */