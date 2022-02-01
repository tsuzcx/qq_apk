package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.record.model.i;
import com.tencent.mm.protocal.protobuf.arf;
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
  private static HashMap<String, Boolean> NBc;
  public q Anv;
  
  static
  {
    AppMethodBeat.i(27841);
    NBc = new HashMap();
    AppMethodBeat.o(27841);
  }
  
  public d(Context paramContext, h.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(27838);
    this.Anv = new q()
    {
      public final void e(final com.tencent.mm.plugin.fav.a.c paramAnonymousc)
      {
        AppMethodBeat.i(27837);
        b localb = (b)d.this.NBz;
        if (paramAnonymousc.field_favLocalId != localb.xvD.field_localId)
        {
          Log.i("MicroMsg.FavRecordAdapter", "not equal Id %d %d", new Object[] { Long.valueOf(paramAnonymousc.field_favLocalId), Long.valueOf(localb.xvD.field_localId) });
          AppMethodBeat.o(27837);
          return;
        }
        Log.d("MicroMsg.FavRecordAdapter", "on cdn status changed, fav local id %d, data id %s, status %d", new Object[] { Long.valueOf(paramAnonymousc.field_favLocalId), paramAnonymousc.field_dataId, Integer.valueOf(paramAnonymousc.field_status) });
        if (4 == paramAnonymousc.field_status) {
          d.NBc.put(Util.nullAs(paramAnonymousc.field_dataId, "null"), Boolean.TRUE);
        }
        if (paramAnonymousc.isFinished()) {
          d.this.NBu.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27836);
              Object localObject1 = (View)com.tencent.mm.plugin.record.ui.viewWrappers.c.NCP.get(paramAnonymousc.field_dataId);
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
              String str = i.a((com.tencent.mm.plugin.record.ui.a.b)localObject2);
              Log.d("MicroMsg.FavRecordAdapter", "dataItemId: %s", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject2).hIy.hIQ });
              if (((com.tencent.mm.plugin.record.ui.a.b)localObject2).hIy.hIQ.equals(paramAnonymousc.field_dataId))
              {
                Log.d("MicroMsg.FavRecordAdapter", "change the sight status %s, dataId %s, progress %s cdnInfo %s", new Object[] { Integer.valueOf(paramAnonymousc.field_status), paramAnonymousc.field_dataId, Float.valueOf(paramAnonymousc.getProgress()), Boolean.valueOf(paramAnonymousc.isFinished()) });
                localObject2 = (ImageView)((View)localObject1).findViewById(R.h.status_btn);
                MMPinProgressBtn localMMPinProgressBtn = (MMPinProgressBtn)((View)localObject1).findViewById(R.h.progress);
                localObject1 = (com.tencent.mm.plugin.sight.decode.model.a)((View)localObject1).findViewById(R.h.image);
                ((ImageView)localObject2).setVisibility(8);
                localMMPinProgressBtn.setVisibility(8);
                Log.i("MicroMsg.FavRecordAdapter", "setVideoPath ".concat(String.valueOf(str)));
                ((com.tencent.mm.plugin.sight.decode.model.a)localObject1).setCanPlay(true);
                ((com.tencent.mm.plugin.sight.decode.model.a)localObject1).e(str, false, 0);
              }
              AppMethodBeat.o(27836);
            }
          });
        }
        d.this.gGt();
        AppMethodBeat.o(27837);
      }
    };
    AppMethodBeat.o(27838);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(27839);
    Log.i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", new Object[] { Long.valueOf(((b)parama).xvD.field_localId), Integer.valueOf(((b)parama).xvD.field_itemStatus) });
    this.NBz = parama;
    this.NBa.clear();
    this.NBa.addAll(parama.NBa);
    notifyDataSetChanged();
    AppMethodBeat.o(27839);
  }
  
  public final void d(com.tencent.mm.plugin.record.ui.a.b paramb)
  {
    AppMethodBeat.i(27840);
    Log.d("MicroMsg.FavRecordAdapter", "setupRecord %s", new Object[] { Long.valueOf(((b)this.NBz).xvD.field_localId) });
    paramb.fromScene = 1;
    paramb.dataType = 1;
    paramb.NBB = 15;
    paramb.xvD = ((b)this.NBz).xvD;
    AppMethodBeat.o(27840);
  }
  
  protected final int getFromScene()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.d
 * JD-Core Version:    0.7.0.1
 */