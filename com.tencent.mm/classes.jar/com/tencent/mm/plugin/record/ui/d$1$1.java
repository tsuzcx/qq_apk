package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.b.g;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.Map;

final class d$1$1
  implements Runnable
{
  d$1$1(d.1 param1, com.tencent.mm.plugin.fav.a.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(24195);
    Object localObject1 = (View)com.tencent.mm.plugin.record.ui.b.c.qas.get(this.pZf.field_dataId);
    if (localObject1 == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.FavRecordAdapter", "view is null %s", new Object[] { Boolean.valueOf(bool) });
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(24195);
      return;
    }
    Object localObject2 = (b)((View)localObject1).getTag();
    String str = g.a((b)localObject2);
    ab.d("MicroMsg.FavRecordAdapter", "dataItemId: %s", new Object[] { ((b)localObject2).cuL.mBq });
    if (((b)localObject2).cuL.mBq.equals(this.pZf.field_dataId))
    {
      ab.d("MicroMsg.FavRecordAdapter", "change the sight status %s, dataId %s, progress %s cdnInfo %s", new Object[] { Integer.valueOf(this.pZf.field_status), this.pZf.field_dataId, Float.valueOf(this.pZf.getProgress()), Boolean.valueOf(this.pZf.isFinished()) });
      localObject2 = (ImageView)((View)localObject1).findViewById(2131820996);
      MMPinProgressBtn localMMPinProgressBtn = (MMPinProgressBtn)((View)localObject1).findViewById(2131821404);
      localObject1 = (a)((View)localObject1).findViewById(2131820629);
      ((ImageView)localObject2).setVisibility(8);
      localMMPinProgressBtn.setVisibility(8);
      ab.i("MicroMsg.FavRecordAdapter", "setVideoPath ".concat(String.valueOf(str)));
      ((a)localObject1).setCanPlay(true);
      ((a)localObject1).bl(str, false);
    }
    AppMethodBeat.o(24195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.d.1.1
 * JD-Core Version:    0.7.0.1
 */