package com.tencent.mm.x;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

final class a$1
  extends ak
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(77701);
    if ((paramMessage.what == 0) && ((paramMessage.obj instanceof a.b)))
    {
      paramMessage = (a.b)paramMessage.obj;
      if (paramMessage.eDg != null)
      {
        a locala = this.eDe;
        Object localObject2 = paramMessage.eDg;
        paramMessage = null;
        Iterator localIterator = locala.eDb.iterator();
        Object localObject1;
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference != null) && (localWeakReference.get() != null))
          {
            ((a.a)localWeakReference.get()).b((ac.a)localObject2);
          }
          else
          {
            localObject1 = paramMessage;
            if (paramMessage == null) {
              localObject1 = new ArrayList();
            }
            ((ArrayList)localObject1).add(localWeakReference);
            paramMessage = (Message)localObject1;
          }
        }
        if (paramMessage != null)
        {
          localObject1 = paramMessage.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (WeakReference)((Iterator)localObject1).next();
            locala.eDb.remove(localObject2);
          }
          paramMessage.clear();
        }
        AppMethodBeat.o(77701);
        return;
      }
      a.a(this.eDe, paramMessage.eDf, paramMessage.value);
    }
    AppMethodBeat.o(77701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.x.a.1
 * JD-Core Version:    0.7.0.1
 */