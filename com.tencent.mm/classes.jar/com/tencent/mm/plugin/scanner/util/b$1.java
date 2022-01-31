package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.qbar.QbarNative;

final class b$1
  implements Runnable
{
  b$1(b paramb, byte[] paramArrayOfByte, int paramInt, Point paramPoint, Rect paramRect) {}
  
  public final void run()
  {
    AppMethodBeat.i(81372);
    byte[] arrayOfByte1 = this.val$data;
    if (270 == this.hJr)
    {
      byte[] arrayOfByte2 = new byte[this.val$data.length];
      QbarNative.a(arrayOfByte2, this.val$data, this.qAi.x, this.qAi.y);
      arrayOfByte1 = new byte[this.val$data.length];
      QbarNative.a(arrayOfByte1, arrayOfByte2, this.qAi.y, this.qAi.x);
      QbarNative.nativeRelease();
    }
    ab.d("MicroMsg.scanner.BaseDecoder", "asyncDecode() resolution:%s, coverage:%s", new Object[] { this.qAi.toString(), this.qAj.toString() });
    if ((arrayOfByte1 != null) && (this.qCd.a(arrayOfByte1, this.qAi, this.qAj)))
    {
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(81370);
          if (b.1.this.qCd.qBY != null) {
            b.1.this.qCd.qBY.a(b.quq, b.1.this.qCd.qCa, b.1.this.qCd.rawData, b.1.this.qCd.qBZ, b.1.this.qCd.cpE, b.1.this.qCd.cpF, b.1.this.qCd.typeName);
          }
          AppMethodBeat.o(81370);
        }
      });
      AppMethodBeat.o(81372);
      return;
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(81371);
        if (b.1.this.qCd.qBY != null)
        {
          ab.d("MicroMsg.scanner.BaseDecoder", "failed in asyncDecode() resolution:%s, coverage:%s", new Object[] { b.1.this.qAi.toString(), b.1.this.qAj.toString() });
          b.1.this.qCd.qBY.le(b.1.this.qCd.qCb);
        }
        AppMethodBeat.o(81371);
      }
    });
    AppMethodBeat.o(81372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.b.1
 * JD-Core Version:    0.7.0.1
 */