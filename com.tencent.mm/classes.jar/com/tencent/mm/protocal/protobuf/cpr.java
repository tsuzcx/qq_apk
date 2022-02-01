package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cpr
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public gol YGU;
  public int ZtX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104810);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104810);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.ZtX);
      if (this.YGU != null)
      {
        paramVarArgs.qD(2, this.YGU.computeSize());
        this.YGU.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.IJG);
      AppMethodBeat.o(104810);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZtX) + 0;
      paramInt = i;
      if (this.YGU != null) {
        paramInt = i + i.a.a.a.qC(2, this.YGU.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.IJG);
      AppMethodBeat.o(104810);
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
      if (this.YGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104810);
        throw paramVarArgs;
      }
      AppMethodBeat.o(104810);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cpr localcpr = (cpr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104810);
        return -1;
      case 1: 
        localcpr.ZtX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104810);
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
          localcpr.YGU = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(104810);
        return 0;
      }
      localcpr.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(104810);
      return 0;
    }
    AppMethodBeat.o(104810);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpr
 * JD-Core Version:    0.7.0.1
 */