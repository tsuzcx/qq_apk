package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d
  extends h
{
  private static HashMap<String, Boolean> xrz;
  public p xrA;
  
  static
  {
    AppMethodBeat.i(27841);
    xrz = new HashMap();
    AppMethodBeat.o(27841);
  }
  
  public d(Context paramContext, h.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(27838);
    this.xrA = new p()
    {
      public final void e(final com.tencent.mm.plugin.fav.a.c paramAnonymousc)
      {
        AppMethodBeat.i(27837);
        b localb = (b)d.this.xrT;
        if (paramAnonymousc.field_favLocalId != localb.prW.field_localId)
        {
          ad.i("MicroMsg.FavRecordAdapter", "not equal Id %d %d", new Object[] { Long.valueOf(paramAnonymousc.field_favLocalId), Long.valueOf(localb.prW.field_localId) });
          AppMethodBeat.o(27837);
          return;
        }
        ad.d("MicroMsg.FavRecordAdapter", "on cdn status changed, fav local id %d, data id %s, status %d", new Object[] { Long.valueOf(paramAnonymousc.field_favLocalId), paramAnonymousc.field_dataId, Integer.valueOf(paramAnonymousc.field_status) });
        if (4 == paramAnonymousc.field_status) {
          d.xrz.put(bt.bI(paramAnonymousc.field_dataId, "null"), Boolean.TRUE);
        }
        if (paramAnonymousc.isFinished()) {
          d.this.tkw.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27836);
              Object localObject1 = (View)com.tencent.mm.plugin.record.ui.b.c.xte.get(paramAnonymousc.field_dataId);
              if (localObject1 == null) {}
              for (boolean bool = true;; bool = false)
              {
                ad.d("MicroMsg.FavRecordAdapter", "view is null %s", new Object[] { Boolean.valueOf(bool) });
                if (localObject1 != null) {
                  break;
                }
                AppMethodBeat.o(27836);
                return;
              }
              Object localObject2 = (com.tencent.mm.plugin.record.ui.a.b)((View)localObject1).getTag();
              String str = com.tencent.mm.plugin.record.b.h.a((com.tencent.mm.plugin.record.ui.a.b)localObject2);
              ad.d("MicroMsg.FavRecordAdapter", "dataItemId: %s", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dsC.dsU });
              if (((com.tencent.mm.plugin.record.ui.a.b)localObject2).dsC.dsU.equals(paramAnonymousc.field_dataId))
              {
                ad.d("MicroMsg.FavRecordAdapter", "change the sight status %s, dataId %s, progress %s cdnInfo %s", new Object[] { Integer.valueOf(paramAnonymousc.field_status), paramAnonymousc.field_dataId, Float.valueOf(paramAnonymousc.getProgress()), Boolean.valueOf(paramAnonymousc.isFinished()) });
                localObject2 = (ImageView)((View)localObject1).findViewById(2131305196);
                MMPinProgressBtn localMMPinProgressBtn = (MMPinProgressBtn)((View)localObject1).findViewById(2131303515);
                localObject1 = (com.tencent.mm.plugin.sight.decode.a.a)((View)localObject1).findViewById(2131300914);
                ((ImageView)localObject2).setVisibility(8);
                localMMPinProgressBtn.setVisibility(8);
                ad.i("MicroMsg.FavRecordAdapter", "setVideoPath ".concat(String.valueOf(str)));
                ((com.tencent.mm.plugin.sight.decode.a.a)localObject1).setCanPlay(true);
                ((com.tencent.mm.plugin.sight.decode.a.a)localObject1).e(str, false, 0);
              }
              AppMethodBeat.o(27836);
            }
          });
        }
        d.this.dEv();
        AppMethodBeat.o(27837);
      }
    };
    AppMethodBeat.o(27838);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(27839);
    ad.i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", new Object[] { Long.valueOf(((b)parama).prW.field_localId), Integer.valueOf(((b)parama).prW.field_itemStatus) });
    this.xrT = parama;
    this.xrx.clear();
    this.xrx.addAll(parama.xrx);
    notifyDataSetChanged();
    AppMethodBeat.o(27839);
  }
  
  public final void d(com.tencent.mm.plugin.record.ui.a.b paramb)
  {
    AppMethodBeat.i(27840);
    ad.d("MicroMsg.FavRecordAdapter", "setupRecord %s", new Object[] { Long.valueOf(((b)this.xrT).prW.field_localId) });
    paramb.fromScene = 1;
    paramb.dataType = 1;
    paramb.prW = ((b)this.xrT).prW;
    AppMethodBeat.o(27840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.d
 * JD-Core Version:    0.7.0.1
 */