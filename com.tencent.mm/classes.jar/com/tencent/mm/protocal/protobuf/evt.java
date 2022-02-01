package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import org.json.JSONObject;

public final class evt
  extends com.tencent.mm.bx.a
{
  public String YWK;
  public long abmO;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260047);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Query", this.YWK, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Timestamp", Long.valueOf(this.abmO), false);
      label38:
      AppMethodBeat.o(260047);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117911);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YWK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Query");
        AppMethodBeat.o(117911);
        throw paramVarArgs;
      }
      if (this.YWK != null) {
        paramVarArgs.g(1, this.YWK);
      }
      paramVarArgs.bv(2, this.abmO);
      AppMethodBeat.o(117911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YWK == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.YWK) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.abmO);
      AppMethodBeat.o(117911);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YWK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Query");
          AppMethodBeat.o(117911);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117911);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        evt localevt = (evt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117911);
          return -1;
        case 1: 
          localevt.YWK = locala.ajGk.readString();
          AppMethodBeat.o(117911);
          return 0;
        }
        localevt.abmO = locala.ajGk.aaw();
        AppMethodBeat.o(117911);
        return 0;
      }
      AppMethodBeat.o(117911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evt
 * JD-Core Version:    0.7.0.1
 */