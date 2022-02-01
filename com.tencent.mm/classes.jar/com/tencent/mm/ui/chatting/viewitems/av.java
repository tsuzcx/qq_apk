package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Util;

final class av
{
  static void a(e.c paramc, final k.b paramb)
  {
    AppMethodBeat.i(255089);
    paramb = Util.nullAsNil(paramb.title).trim();
    if (TextUtils.isEmpty(paramb))
    {
      paramc.aeNR.setText("");
      paramc.aeNR.setVisibility(8);
      AppMethodBeat.o(255089);
      return;
    }
    paramc.aeNR.setText(paramb);
    paramc.aeNR.setVisibility(0);
    paramc = paramc.aeNR;
    if (!TextUtils.isEmpty(paramb)) {
      paramc.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(255078);
          TextPaint localTextPaint = av.this.getPaint();
          float f = av.this.getMeasuredWidth() - av.this.getPaddingLeft() - av.this.getPaddingRight();
          if (localTextPaint.measureText(paramb) > f)
          {
            av.this.setMinLines(2);
            AppMethodBeat.o(255078);
            return;
          }
          av.this.setMinLines(0);
          AppMethodBeat.o(255078);
        }
      });
    }
    AppMethodBeat.o(255089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.av
 * JD-Core Version:    0.7.0.1
 */