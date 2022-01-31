package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class aq$a
{
  String cID;
  String id;
  String rix;
  String riy;
  int type;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(36612);
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      if ((this.id.equals(paramObject.id)) && (this.type == paramObject.type))
      {
        AppMethodBeat.o(36612);
        return true;
      }
      AppMethodBeat.o(36612);
      return false;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(36612);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aq.a
 * JD-Core Version:    0.7.0.1
 */