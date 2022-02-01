package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class fod
  extends com.tencent.mm.bx.a
{
  public String name;
  public long timestamp;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258194);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "name", this.name, false);
      com.tencent.mm.bk.a.a(localJSONObject, "timestamp", Long.valueOf(this.timestamp), false);
      label38:
      AppMethodBeat.o(258194);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153005);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.g(1, this.name);
      }
      paramVarArgs.bv(2, this.timestamp);
      AppMethodBeat.o(153005);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.name) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.timestamp);
      AppMethodBeat.o(153005);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153005);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fod localfod = (fod)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153005);
          return -1;
        case 1: 
          localfod.name = locala.ajGk.readString();
          AppMethodBeat.o(153005);
          return 0;
        }
        localfod.timestamp = locala.ajGk.aaw();
        AppMethodBeat.o(153005);
        return 0;
      }
      AppMethodBeat.o(153005);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fod
 * JD-Core Version:    0.7.0.1
 */