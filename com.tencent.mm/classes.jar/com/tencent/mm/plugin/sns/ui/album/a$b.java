package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a$b
{
  public List<p> AJt;
  public String label;
  
  public a$b()
  {
    AppMethodBeat.i(99850);
    this.AJt = new ArrayList();
    this.label = "";
    AppMethodBeat.o(99850);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(99851);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.AJt.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      ((StringBuilder)localObject).append("\t[localId=").append(localp.AdJ).append(", snsId=").append(localp.field_snsId).append("\n");
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