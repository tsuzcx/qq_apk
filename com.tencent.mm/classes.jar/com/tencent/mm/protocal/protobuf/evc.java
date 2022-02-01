package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class evc
  extends com.tencent.mm.bx.a
{
  public int Zvi;
  public int abxT;
  public int muC;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257318);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Entry", Integer.valueOf(this.abxT), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Timestamp", Integer.valueOf(this.Zvi), false);
      com.tencent.mm.bk.a.a(localJSONObject, "OpType", Integer.valueOf(this.muC), false);
      label55:
      AppMethodBeat.o(257318);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label55;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117906);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abxT);
      paramVarArgs.bS(2, this.Zvi);
      paramVarArgs.bS(3, this.muC);
      AppMethodBeat.o(117906);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abxT);
      int i = i.a.a.b.b.a.cJ(2, this.Zvi);
      int j = i.a.a.b.b.a.cJ(3, this.muC);
      AppMethodBeat.o(117906);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117906);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      evc localevc = (evc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117906);
        return -1;
      case 1: 
        localevc.abxT = locala.ajGk.aar();
        AppMethodBeat.o(117906);
        return 0;
      case 2: 
        localevc.Zvi = locala.ajGk.aar();
        AppMethodBeat.o(117906);
        return 0;
      }
      localevc.muC = locala.ajGk.aar();
      AppMethodBeat.o(117906);
      return 0;
    }
    AppMethodBeat.o(117906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evc
 * JD-Core Version:    0.7.0.1
 */