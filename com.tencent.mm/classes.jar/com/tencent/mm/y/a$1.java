package com.tencent.mm.y;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

final class a$1
  extends ah
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject1;
    if ((paramMessage.what == 0) && ((paramMessage.obj instanceof a.b)))
    {
      localObject1 = (a.b)paramMessage.obj;
      if (((a.b)localObject1).dFE == null) {
        break label229;
      }
      a locala = this.dFC;
      Object localObject3 = ((a.b)localObject1).dFE;
      localObject1 = null;
      Iterator localIterator = locala.dFz.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null))
        {
          ((a.a)localWeakReference.get()).b((ac.a)localObject3);
        }
        else
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localWeakReference);
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (WeakReference)((Iterator)localObject2).next();
          locala.dFz.remove(localObject3);
        }
        ((ArrayList)localObject1).clear();
      }
    }
    for (;;)
    {
      if ((paramMessage.what == 1) && ((paramMessage.obj instanceof a.c)))
      {
        paramMessage = (a.c)paramMessage.obj;
        if (paramMessage.dFE == null) {
          break;
        }
        a.a(this.dFC);
      }
      return;
      label229:
      a.a(this.dFC, ((a.b)localObject1).dFD);
    }
    a.b(this.dFC, paramMessage.dFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.y.a.1
 * JD-Core Version:    0.7.0.1
 */