package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class dpz
  extends com.tencent.mm.bx.a
{
  public long aaWA;
  public long aaWz;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257692);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "set_bitmask", Long.valueOf(this.aaWz), false);
      com.tencent.mm.bk.a.a(localJSONObject, "clear_bitmask", Long.valueOf(this.aaWA), false);
      label41:
      AppMethodBeat.o(257692);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134247);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaWz);
      paramVarArgs.bv(2, this.aaWA);
      AppMethodBeat.o(134247);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.aaWz);
      int i = i.a.a.b.b.a.q(2, this.aaWA);
      AppMethodBeat.o(134247);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(134247);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dpz localdpz = (dpz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(134247);
        return -1;
      case 1: 
        localdpz.aaWz = locala.ajGk.aaw();
        AppMethodBeat.o(134247);
        return 0;
      }
      localdpz.aaWA = locala.ajGk.aaw();
      AppMethodBeat.o(134247);
      return 0;
    }
    AppMethodBeat.o(134247);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpz
 * JD-Core Version:    0.7.0.1
 */