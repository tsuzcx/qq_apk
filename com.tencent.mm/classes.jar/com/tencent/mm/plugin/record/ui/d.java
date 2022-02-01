package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d
  extends h
{
  private static HashMap<String, Boolean> BHu;
  public p BHv;
  
  static
  {
    AppMethodBeat.i(27841);
    BHu = new HashMap();
    AppMethodBeat.o(27841);
  }
  
  public d(Context paramContext, h.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(27838);
    this.BHv = new p()
    {
      public final void e(final com.tencent.mm.plugin.fav.a.c paramAnonymousc)
      {
        AppMethodBeat.i(27837);
        b localb = (b)d.this.BHQ;
        if (paramAnonymousc.field_favLocalId != localb.qNT.field_localId)
        {
          Log.i("MicroMsg.FavRecordAdapter", "not equal Id %d %d", new Object[] { Long.valueOf(paramAnonymousc.field_favLocalId), Long.valueOf(localb.qNT.field_localId) });
          AppMethodBeat.o(27837);
          return;
        }
        Log.d("MicroMsg.FavRecordAdapter", "on cdn status changed, fav local id %d, data id %s, status %d", new Object[] { Long.valueOf(paramAnonymousc.field_favLocalId), paramAnonymousc.field_dataId, Integer.valueOf(paramAnonymousc.field_status) });
        if (4 == paramAnonymousc.field_status) {
          d.BHu.put(Util.nullAs(paramAnonymousc.field_dataId, "null"), Boolean.TRUE);
        }
        if (paramAnonymousc.isFinished()) {
          d.this.wMu.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27836);
              Object localObject1 = (View)com.tencent.mm.plugin.record.ui.b.c.BJe.get(paramAnonymousc.field_dataId);
              if (localObject1 == null) {}
              for (boolean bool = true;; bool = false)
              {
                Log.d("MicroMsg.FavRecordAdapter", "view is null %s", new Object[] { Boolean.valueOf(bool) });
                if (localObject1 != null) {
                  break;
                }
                AppMethodBeat.o(27836);
                return;
              }
              Object localObject2 = (com.tencent.mm.plugin.record.ui.a.b)((View)localObject1).getTag();
              String str = com.tencent.mm.plugin.record.b.h.a((com.tencent.mm.plugin.record.ui.a.b)localObject2);
              Log.d("MicroMsg.FavRecordAdapter", "dataItemId: %s", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dKT.dLl });
              if (((com.tencent.mm.plugin.record.ui.a.b)localObject2).dKT.dLl.equals(paramAnonymousc.field_dataId))
              {
                Log.d("MicroMsg.FavRecordAdapter", "change the sight status %s, dataId %s, progress %s cdnInfo %s", new Object[] { Integer.valueOf(paramAnonymousc.field_status), paramAnonymousc.field_dataId, Float.valueOf(paramAnonymousc.getProgress()), Boolean.valueOf(paramAnonymousc.isFinished()) });
                localObject2 = (ImageView)((View)localObject1).findViewById(2131308392);
                MMPinProgressBtn localMMPinProgressBtn = (MMPinProgressBtn)((View)localObject1).findViewById(2131306281);
                localObject1 = (com.tencent.mm.plugin.sight.decode.a.a)((View)localObject1).findViewById(2131302526);
                ((ImageView)localObject2).setVisibility(8);
                localMMPinProgressBtn.setVisibility(8);
                Log.i("MicroMsg.FavRecordAdapter", "setVideoPath ".concat(String.valueOf(str)));
                ((com.tencent.mm.plugin.sight.decode.a.a)localObject1).setCanPlay(true);
                ((com.tencent.mm.plugin.sight.decode.a.a)localObject1).e(str, false, 0);
              }
              AppMethodBeat.o(27836);
            }
          });
        }
        d.this.eIz();
        AppMethodBeat.o(27837);
      }
    };
    AppMethodBeat.o(27838);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(27839);
    Log.i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", new Object[] { Long.valueOf(((b)parama).qNT.field_localId), Integer.valueOf(((b)parama).qNT.field_itemStatus) });
    this.BHQ = parama;
    this.BHs.clear();
    this.BHs.addAll(parama.BHs);
    notifyDataSetChanged();
    AppMethodBeat.o(27839);
  }
  
  public final void d(com.tencent.mm.plugin.record.ui.a.b paramb)
  {
    AppMethodBeat.i(27840);
    Log.d("MicroMsg.FavRecordAdapter", "setupRecord %s", new Object[] { Long.valueOf(((b)this.BHQ).qNT.field_localId) });
    paramb.fromScene = 1;
    paramb.dataType = 1;
    paramb.BHS = 15;
    paramb.qNT = ((b)this.BHQ).qNT;
    AppMethodBeat.o(27840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.d
 * JD-Core Version:    0.7.0.1
 */