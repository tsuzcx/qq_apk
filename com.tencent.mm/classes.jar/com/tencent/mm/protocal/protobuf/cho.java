package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class cho
  extends com.tencent.mm.bx.a
{
  public int YYs;
  public long aanC;
  public int vhJ;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259036);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Type", Integer.valueOf(this.vhJ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Offset", Integer.valueOf(this.YYs), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Version", Long.valueOf(this.aanC), false);
      label55:
      AppMethodBeat.o(259036);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label55;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117868);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      paramVarArgs.bS(2, this.YYs);
      paramVarArgs.bv(3, this.aanC);
      AppMethodBeat.o(117868);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.vhJ);
      int i = i.a.a.b.b.a.cJ(2, this.YYs);
      int j = i.a.a.b.b.a.q(3, this.aanC);
      AppMethodBeat.o(117868);
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
      AppMethodBeat.o(117868);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cho localcho = (cho)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117868);
        return -1;
      case 1: 
        localcho.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(117868);
        return 0;
      case 2: 
        localcho.YYs = locala.ajGk.aar();
        AppMethodBeat.o(117868);
        return 0;
      }
      localcho.aanC = locala.ajGk.aaw();
      AppMethodBeat.o(117868);
      return 0;
    }
    AppMethodBeat.o(117868);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cho
 * JD-Core Version:    0.7.0.1
 */