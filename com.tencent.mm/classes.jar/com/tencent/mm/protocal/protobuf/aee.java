package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class aee
  extends com.tencent.mm.bx.a
{
  public String Username;
  public int hAO;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257430);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Action", Integer.valueOf(this.hAO), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Username", this.Username, false);
      label38:
      AppMethodBeat.o(257430);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117859);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.hAO);
      if (this.Username != null) {
        paramVarArgs.g(2, this.Username);
      }
      AppMethodBeat.o(117859);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.hAO) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Username);
      }
      AppMethodBeat.o(117859);
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
      AppMethodBeat.o(117859);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aee localaee = (aee)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117859);
        return -1;
      case 1: 
        localaee.hAO = locala.ajGk.aar();
        AppMethodBeat.o(117859);
        return 0;
      }
      localaee.Username = locala.ajGk.readString();
      AppMethodBeat.o(117859);
      return 0;
    }
    AppMethodBeat.o(117859);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aee
 * JD-Core Version:    0.7.0.1
 */