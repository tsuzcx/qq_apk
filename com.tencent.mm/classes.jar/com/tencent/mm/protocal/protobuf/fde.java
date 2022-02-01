package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class fde
  extends com.tencent.mm.bx.a
{
  public int AXR;
  public int abCH;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258878);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "checkCount", Integer.valueOf(this.AXR), false);
      com.tencent.mm.bk.a.a(localJSONObject, "isFinalCheck", Integer.valueOf(this.abCH), false);
      label41:
      AppMethodBeat.o(258878);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134259);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.AXR);
      paramVarArgs.bS(2, this.abCH);
      AppMethodBeat.o(134259);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.AXR);
      int i = i.a.a.b.b.a.cJ(2, this.abCH);
      AppMethodBeat.o(134259);
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
      AppMethodBeat.o(134259);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fde localfde = (fde)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(134259);
        return -1;
      case 1: 
        localfde.AXR = locala.ajGk.aar();
        AppMethodBeat.o(134259);
        return 0;
      }
      localfde.abCH = locala.ajGk.aar();
      AppMethodBeat.o(134259);
      return 0;
    }
    AppMethodBeat.o(134259);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fde
 * JD-Core Version:    0.7.0.1
 */