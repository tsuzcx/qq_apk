package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a$b
{
  public List<SnsInfo> RHC;
  public String label;
  
  public a$b()
  {
    AppMethodBeat.i(99850);
    this.RHC = new ArrayList();
    this.label = "";
    AppMethodBeat.o(99850);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(99851);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.RHC.iterator();
    while (localIterator.hasNext())
    {
      SnsInfo localSnsInfo = (SnsInfo)localIterator.next();
      ((StringBuilder)localObject).append("\t[localId=").append(localSnsInfo.localid).append(", snsId=").append(localSnsInfo.field_snsId).append("\n");
    }
    localObject = this.label + "\n" + ((StringBuilder)localObject).toString();
    AppMethodBeat.o(99851);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a.b
 * JD-Core Version:    0.7.0.1
 */