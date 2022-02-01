package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class drs
  extends com.tencent.mm.bx.a
{
  public long aaXm;
  public String aaXn;
  public long status;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260155);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "addType", Long.valueOf(this.aaXm), false);
      com.tencent.mm.bk.a.a(localJSONObject, "status", Long.valueOf(this.status), false);
      com.tencent.mm.bk.a.a(localJSONObject, "itemSubId", this.aaXn, false);
      label52:
      AppMethodBeat.o(260155);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260162);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaXm);
      paramVarArgs.bv(2, this.status);
      if (this.aaXn != null) {
        paramVarArgs.g(3, this.aaXn);
      }
      AppMethodBeat.o(260162);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.aaXm) + 0 + i.a.a.b.b.a.q(2, this.status);
      paramInt = i;
      if (this.aaXn != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aaXn);
      }
      AppMethodBeat.o(260162);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260162);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      drs localdrs = (drs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260162);
        return -1;
      case 1: 
        localdrs.aaXm = locala.ajGk.aaw();
        AppMethodBeat.o(260162);
        return 0;
      case 2: 
        localdrs.status = locala.ajGk.aaw();
        AppMethodBeat.o(260162);
        return 0;
      }
      localdrs.aaXn = locala.ajGk.readString();
      AppMethodBeat.o(260162);
      return 0;
    }
    AppMethodBeat.o(260162);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drs
 * JD-Core Version:    0.7.0.1
 */