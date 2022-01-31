package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a$b
{
  public String label;
  public List<n> seq;
  
  public a$b()
  {
    AppMethodBeat.i(39960);
    this.seq = new ArrayList();
    this.label = "";
    AppMethodBeat.o(39960);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(39961);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.seq.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      ((StringBuilder)localObject).append("\t[localId=").append(localn.rCV).append(", snsId=").append(localn.field_snsId).append("\n");
    }
    localObject = this.label + "\n" + ((StringBuilder)localObject).toString();
    AppMethodBeat.o(39961);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a.b
 * JD-Core Version:    0.7.0.1
 */