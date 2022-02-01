package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class eqj
  extends com.tencent.mm.bx.a
{
  public int abmA;
  public int abui;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258995);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "ClientType", Integer.valueOf(this.abui), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SubType", Integer.valueOf(this.abmA), false);
      label41:
      AppMethodBeat.o(258995);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117899);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abui);
      paramVarArgs.bS(2, this.abmA);
      AppMethodBeat.o(117899);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abui);
      int i = i.a.a.b.b.a.cJ(2, this.abmA);
      AppMethodBeat.o(117899);
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
      AppMethodBeat.o(117899);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eqj localeqj = (eqj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117899);
        return -1;
      case 1: 
        localeqj.abui = locala.ajGk.aar();
        AppMethodBeat.o(117899);
        return 0;
      }
      localeqj.abmA = locala.ajGk.aar();
      AppMethodBeat.o(117899);
      return 0;
    }
    AppMethodBeat.o(117899);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqj
 * JD-Core Version:    0.7.0.1
 */