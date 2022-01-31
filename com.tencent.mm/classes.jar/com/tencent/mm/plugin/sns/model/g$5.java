package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;

final class g$5
  implements am.a
{
  g$5(g paramg) {}
  
  public final boolean cg(Object paramObject)
  {
    AppMethodBeat.i(36139);
    String str = (String)paramObject;
    Object localObject;
    if (g.a(this.rdL, str)) {
      localObject = g.a(this.rdL);
    }
    for (;;)
    {
      try
      {
        paramObject = ((am.b)((am)localObject).rhX.get(str)).obj;
        if (!(paramObject instanceof Bitmap)) {
          continue;
        }
        paramObject = (Bitmap)paramObject;
        if ((paramObject != null) && (!paramObject.isRecycled()))
        {
          ab.d("MicroMsg.SnsLRUMap", "remove key:".concat(String.valueOf(str)));
          paramObject.recycle();
        }
      }
      catch (Exception paramObject)
      {
        int i;
        ab.printErrStackTrace("MicroMsg.SnsLRUMap", paramObject, "", new Object[0]);
        ab.e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
        continue;
        boolean bool = false;
        continue;
      }
      i = ((am)localObject).rhX.size();
      paramObject = ((am)localObject).rhX.remove(str);
      localObject = new StringBuilder("internalMap ").append(((am)localObject).rhX.size()).append(" bfSize :").append(i).append(" o == null ");
      if (paramObject != null)
      {
        bool = true;
        ab.d("MicroMsg.SnsLRUMap", bool);
        ab.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + g.a(this.rdL).rhX.size() + " listPaitSize:" + g.b(this.rdL).size());
        AppMethodBeat.o(36139);
        return true;
        paramObject = (WeakReference)((am.b)((am)localObject).rhX.get(str)).obj;
        if (paramObject != null) {
          paramObject = (Bitmap)paramObject.get();
        }
      }
      else
      {
        AppMethodBeat.o(36139);
        return false;
      }
      paramObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g.5
 * JD-Core Version:    0.7.0.1
 */