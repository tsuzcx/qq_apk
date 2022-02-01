package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class rt
  extends com.tencent.mm.bx.a
{
  public String Username;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257534);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Username", this.Username, false);
      label24:
      AppMethodBeat.o(257534);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117837);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.g(1, this.Username);
      }
      AppMethodBeat.o(117837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.h(1, this.Username) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(117837);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117837);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        rt localrt = (rt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117837);
          return -1;
        }
        localrt.Username = locala.ajGk.readString();
        AppMethodBeat.o(117837);
        return 0;
      }
      AppMethodBeat.o(117837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rt
 * JD-Core Version:    0.7.0.1
 */