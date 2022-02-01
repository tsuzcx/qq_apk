package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ebj
  extends com.tencent.mm.bx.a
{
  public int abgU;
  public gol abgV;
  public int abgW;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258091);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "PatternVersion", Integer.valueOf(this.abgU), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Sign", this.abgV, false);
      com.tencent.mm.bk.a.a(localJSONObject, "LockStatus", Integer.valueOf(this.abgW), false);
      label52:
      AppMethodBeat.o(258091);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134248);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abgU);
      if (this.abgV != null)
      {
        paramVarArgs.qD(2, this.abgV.computeSize());
        this.abgV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.abgW);
      AppMethodBeat.o(134248);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abgU) + 0;
      paramInt = i;
      if (this.abgV != null) {
        paramInt = i + i.a.a.a.qC(2, this.abgV.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.abgW);
      AppMethodBeat.o(134248);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(134248);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ebj localebj = (ebj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(134248);
        return -1;
      case 1: 
        localebj.abgU = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(134248);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gol localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localebj.abgV = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(134248);
        return 0;
      }
      localebj.abgW = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(134248);
      return 0;
    }
    AppMethodBeat.o(134248);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebj
 * JD-Core Version:    0.7.0.1
 */