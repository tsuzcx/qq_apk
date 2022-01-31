package com.tencent.pb.common.b;

import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class e$3
  implements Runnable
{
  e$3(e parame, d paramd, int paramInt1, int paramInt2, String paramString) {}
  
  public final void run()
  {
    Set localSet = (Set)e.b(this.Bdh).get(this.Bdi.getType());
    if ((localSet != null) && (localSet.size() > 0))
    {
      Object localObject = new HashSet();
      ((Set)localObject).addAll(localSet);
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if ((localb != null) && (localSet.contains(localb))) {
          localb.a(this.val$errType, this.val$errCode, this.ftO, this.Bdi);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.e.3
 * JD-Core Version:    0.7.0.1
 */