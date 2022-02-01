package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ho;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Iterator;
import java.util.List;

public final class ac
  extends ho
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public int QZA;
  
  static
  {
    AppMethodBeat.i(97623);
    info = ho.aJm();
    AppMethodBeat.o(97623);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97622);
    super.convertFrom(paramCursor);
    this.QZA = ((int)this.systemRowid);
    AppMethodBeat.o(97622);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final void kG(List<etl> paramList)
  {
    AppMethodBeat.i(97621);
    this.field_memberList = "";
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      etl localetl = (etl)paramList.next();
      this.field_memberList = (this.field_memberList + localetl.abwM + ",");
    }
    AppMethodBeat.o(97621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.ac
 * JD-Core Version:    0.7.0.1
 */