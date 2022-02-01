package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.ia.a;
import com.tencent.mm.g.b.a.dz;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class aj$38$1
  implements Runnable
{
  aj$38$1(aj.38 param38, ia paramia) {}
  
  public final void run()
  {
    AppMethodBeat.i(202758);
    Object localObject3 = aj.faO();
    Object localObject1 = new ArrayList();
    Object localObject2 = "select *,rowid from SnsInfo  where " + n.EmA;
    localObject3 = ((n)localObject3).iFy.rawQuery((String)localObject2, null, 2);
    Log.d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(localObject2)));
    while (((Cursor)localObject3).moveToNext())
    {
      localObject2 = new SnsInfo();
      ((SnsInfo)localObject2).convertFrom((Cursor)localObject3);
      ((List)localObject1).add(localObject2);
    }
    ((Cursor)localObject3).close();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SnsInfo)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject3 = ((SnsInfo)localObject2).getTimeLine();
        if ((localObject3 != null) && (((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.dME != null) && (((TimeLineObject)localObject3).ContentObj.dME.localId == this.DLU.dMC.localId))
        {
          if ((this.DLU.dMC.dMD) && (this.DLU.dMC.dME != null))
          {
            ((TimeLineObject)localObject3).ContentObj.dME = this.DLU.dMC.dME;
            e.DUQ.DVE.ql(((TimeLineObject)localObject3).ContentObj.dME.objectId);
            ((SnsInfo)localObject2).setTimeLine((TimeLineObject)localObject3);
            ((SnsInfo)localObject2).cleanPostHolding();
          }
          for (;;)
          {
            aj.faO().S((SnsInfo)localObject2);
            aj.faK().eZn();
            AppMethodBeat.o(202758);
            return;
            e.DUQ.DVE.esJ = 1L;
            e.DUQ.fcF();
            e.DUQ.DVD = 0;
            ((SnsInfo)localObject2).cleanPostHolding();
            ((SnsInfo)localObject2).setItemDie();
          }
        }
      }
    }
    AppMethodBeat.o(202758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aj.38.1
 * JD-Core Version:    0.7.0.1
 */