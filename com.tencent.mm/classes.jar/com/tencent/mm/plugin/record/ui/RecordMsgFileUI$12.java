package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Base64;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;
import java.io.File;

final class RecordMsgFileUI$12
  implements e.a
{
  RecordMsgFileUI$12(RecordMsgFileUI paramRecordMsgFileUI) {}
  
  public final void Es() {}
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(24267);
    ab.d("MicroMsg.RecordMsgFileUI", g.Mk() + " onPrepared");
    RecordMsgFileUI.i(this.pZN).setLoop(true);
    RecordMsgFileUI.i(this.pZN).start();
    AppMethodBeat.o(24267);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24268);
    RecordMsgFileUI.i(this.pZN).stop();
    if (RecordMsgFileUI.j(this.pZN))
    {
      AppMethodBeat.o(24268);
      return;
    }
    RecordMsgFileUI.k(this.pZN);
    final Bitmap localBitmap = RecordMsgFileUI.l(this.pZN).b(RecordMsgFileUI.a(this.pZN), RecordMsgFileUI.b(this.pZN));
    final String str = RecordMsgFileUI.i(this.pZN).getVideoPath();
    b.G(Base64.encodeToString((d.cmw() + "[RecordMsgFileUI] on play sight error, what=" + paramInt1 + ", extra=" + paramInt2 + ", path=" + bo.bf(str, "")).getBytes(), 2), "FullScreenPlaySight");
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24266);
        Object localObject = (ImageView)RecordMsgFileUI.12.this.pZN.findViewById(2131824109);
        ((ImageView)localObject).setImageBitmap(localBitmap);
        ((ImageView)localObject).setVisibility(0);
        localObject = new Intent();
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        k.a(RecordMsgFileUI.12.this.pZN.getContext(), (Intent)localObject, new File(str), "video/*");
        try
        {
          RecordMsgFileUI.12.this.pZN.startActivity(Intent.createChooser((Intent)localObject, RecordMsgFileUI.12.this.pZN.getString(2131299853)));
          AppMethodBeat.o(24266);
          return;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
          h.h(RecordMsgFileUI.12.this.pZN.getContext(), 2131299759, 2131299760);
          AppMethodBeat.o(24266);
        }
      }
    });
    AppMethodBeat.o(24268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.12
 * JD-Core Version:    0.7.0.1
 */