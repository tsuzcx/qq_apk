package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class gnp
  extends com.tencent.mm.bx.a
{
  public long aciD;
  public long aciE;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259596);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "FuncsSwitch", Long.valueOf(this.aciD), false);
      com.tencent.mm.bk.a.a(localJSONObject, "FuncsUserChoiceSwitch", Long.valueOf(this.aciE), false);
      label41:
      AppMethodBeat.o(259596);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259597);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aciD);
      paramVarArgs.bv(2, this.aciE);
      AppMethodBeat.o(259597);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.aciD);
      int i = i.a.a.b.b.a.q(2, this.aciE);
      AppMethodBeat.o(259597);
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
      AppMethodBeat.o(259597);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gnp localgnp = (gnp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259597);
        return -1;
      case 1: 
        localgnp.aciD = locala.ajGk.aaw();
        AppMethodBeat.o(259597);
        return 0;
      }
      localgnp.aciE = locala.ajGk.aaw();
      AppMethodBeat.o(259597);
      return 0;
    }
    AppMethodBeat.o(259597);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gnp
 * JD-Core Version:    0.7.0.1
 */