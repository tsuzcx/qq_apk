package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ewc
  extends com.tencent.mm.bx.a
{
  public String YYr;
  public String abyF;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260029);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "SearchID", this.YYr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "POIID", this.abyF, false);
      label35:
      AppMethodBeat.o(260029);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117919);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YYr != null) {
        paramVarArgs.g(1, this.YYr);
      }
      if (this.abyF != null) {
        paramVarArgs.g(2, this.abyF);
      }
      AppMethodBeat.o(117919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YYr == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.YYr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abyF != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abyF);
      }
      AppMethodBeat.o(117919);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117919);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ewc localewc = (ewc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117919);
          return -1;
        case 1: 
          localewc.YYr = locala.ajGk.readString();
          AppMethodBeat.o(117919);
          return 0;
        }
        localewc.abyF = locala.ajGk.readString();
        AppMethodBeat.o(117919);
        return 0;
      }
      AppMethodBeat.o(117919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewc
 * JD-Core Version:    0.7.0.1
 */