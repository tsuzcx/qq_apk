package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class eyq
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b aaLg;
  public com.tencent.mm.bx.b abzV;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259156);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Name", this.abzV, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Value", this.aaLg, false);
      label35:
      AppMethodBeat.o(259156);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117924);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abzV == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Name");
        AppMethodBeat.o(117924);
        throw paramVarArgs;
      }
      if (this.aaLg == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Value");
        AppMethodBeat.o(117924);
        throw paramVarArgs;
      }
      if (this.abzV != null) {
        paramVarArgs.d(1, this.abzV);
      }
      if (this.aaLg != null) {
        paramVarArgs.d(2, this.aaLg);
      }
      AppMethodBeat.o(117924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abzV == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = i.a.a.b.b.a.c(1, this.abzV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaLg != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.aaLg);
      }
      AppMethodBeat.o(117924);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abzV == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: Name");
          AppMethodBeat.o(117924);
          throw paramVarArgs;
        }
        if (this.aaLg == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: Value");
          AppMethodBeat.o(117924);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117924);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eyq localeyq = (eyq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117924);
          return -1;
        case 1: 
          localeyq.abzV = locala.ajGk.kFX();
          AppMethodBeat.o(117924);
          return 0;
        }
        localeyq.aaLg = locala.ajGk.kFX();
        AppMethodBeat.o(117924);
        return 0;
      }
      AppMethodBeat.o(117924);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyq
 * JD-Core Version:    0.7.0.1
 */