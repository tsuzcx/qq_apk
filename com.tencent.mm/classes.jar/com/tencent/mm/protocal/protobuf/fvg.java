package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class fvg
  extends com.tencent.mm.bx.a
{
  public int errCode;
  public String errMsg;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258714);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "errCode", Integer.valueOf(this.errCode), false);
      com.tencent.mm.bk.a.a(localJSONObject, "errMsg", this.errMsg, false);
      label38:
      AppMethodBeat.o(258714);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147780);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.errCode);
      if (this.errMsg != null) {
        paramVarArgs.g(2, this.errMsg);
      }
      AppMethodBeat.o(147780);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.errCode) + 0;
      paramInt = i;
      if (this.errMsg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.errMsg);
      }
      AppMethodBeat.o(147780);
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
      AppMethodBeat.o(147780);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fvg localfvg = (fvg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147780);
        return -1;
      case 1: 
        localfvg.errCode = locala.ajGk.aar();
        AppMethodBeat.o(147780);
        return 0;
      }
      localfvg.errMsg = locala.ajGk.readString();
      AppMethodBeat.o(147780);
      return 0;
    }
    AppMethodBeat.o(147780);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvg
 * JD-Core Version:    0.7.0.1
 */