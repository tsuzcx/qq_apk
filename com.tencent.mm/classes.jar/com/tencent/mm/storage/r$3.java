package com.tencent.mm.storage;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class r$3
  implements a<Void, Void>
{
  public r$3(r paramr, List paramList) {}
  
  private Void atf()
  {
    AppMethodBeat.i(11856);
    long l = r.a(this.ywK).kr(Thread.currentThread().getId());
    Iterator localIterator = this.ieO.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if (localq.field_appMsgStatInfoProto == null) {
          continue;
        }
        ContentValues localContentValues = new ContentValues();
        try
        {
          localContentValues.put("appMsgStatInfoProto", localq.field_appMsgStatInfoProto.toByteArray());
          if (localContentValues.size() > 0) {
            r.a(this.ywK).update("BizTimeLineInfo", localContentValues, "msgSvrId = ?", new String[] { localq.field_msgSvrId });
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ab.e("MicroMsg.BizTimeLineInfoStorage", localIOException.getMessage());
          }
        }
      }
    }
    r.a(this.ywK).nY(l);
    AppMethodBeat.o(11856);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.r.3
 * JD-Core Version:    0.7.0.1
 */