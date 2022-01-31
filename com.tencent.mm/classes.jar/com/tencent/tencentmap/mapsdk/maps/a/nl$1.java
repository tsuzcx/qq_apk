package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bc;
import com.tencent.tencentmap.mapsdk.a.be;
import java.lang.ref.WeakReference;

class nl$1
  implements Runnable
{
  nl$1(nl paramnl, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {}
  
  public void run()
  {
    AppMethodBeat.i(149492);
    if (!nl.a(this.d, this.a))
    {
      AppMethodBeat.o(149492);
      return;
    }
    Object localObject = new be();
    ((be)localObject).a(this.b);
    localObject = new bc(((be)localObject).a(), ((be)localObject).b(), ((be)localObject).c(), 0, nl.b(this.d, this.a));
    Bitmap localBitmap = BitmapFactory.decodeByteArray(this.c, 0, this.c.length);
    if (localBitmap != null)
    {
      if ((nl.a(this.d) != null) && (nl.a(this.d).get() != null)) {
        ((np)nl.a(this.d).get()).a(1);
      }
      nl.b(this.d).a(jr.a(localBitmap, Bitmap.CompressFormat.PNG), (bc)localObject);
    }
    AppMethodBeat.o(149492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nl.1
 * JD-Core Version:    0.7.0.1
 */