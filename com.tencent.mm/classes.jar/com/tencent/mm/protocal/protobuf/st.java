package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class st
  extends com.tencent.mm.bx.a
{
  public String Url;
  public int vhJ;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260123);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Type", Integer.valueOf(this.vhJ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Url", this.Url, false);
      label38:
      AppMethodBeat.o(260123);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117839);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      if (this.Url != null) {
        paramVarArgs.g(2, this.Url);
      }
      AppMethodBeat.o(117839);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0;
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Url);
      }
      AppMethodBeat.o(117839);
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
      AppMethodBeat.o(117839);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      st localst = (st)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117839);
        return -1;
      case 1: 
        localst.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(117839);
        return 0;
      }
      localst.Url = locala.ajGk.readString();
      AppMethodBeat.o(117839);
      return 0;
    }
    AppMethodBeat.o(117839);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.st
 * JD-Core Version:    0.7.0.1
 */