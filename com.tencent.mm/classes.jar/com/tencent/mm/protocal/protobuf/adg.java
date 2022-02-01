package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class adg
  extends com.tencent.mm.bx.a
{
  public int ZlP;
  public gol ZlQ;
  public int ZlR;
  public gol ZlS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145668);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZlQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(145668);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.ZlP);
      if (this.ZlQ != null)
      {
        paramVarArgs.qD(2, this.ZlQ.computeSize());
        this.ZlQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.ZlR);
      if (this.ZlS != null)
      {
        paramVarArgs.qD(4, this.ZlS.computeSize());
        this.ZlS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZlP) + 0;
      paramInt = i;
      if (this.ZlQ != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZlQ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.ZlR);
      paramInt = i;
      if (this.ZlS != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZlS.computeSize());
      }
      AppMethodBeat.o(145668);
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
      if (this.ZlQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(145668);
        throw paramVarArgs;
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      adg localadg = (adg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      gol localgol;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(145668);
        return -1;
      case 1: 
        localadg.ZlP = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(145668);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localadg.ZlQ = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(145668);
        return 0;
      case 3: 
        localadg.ZlR = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(145668);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localgol = new gol();
        if ((localObject != null) && (localObject.length > 0)) {
          localgol.dg((byte[])localObject);
        }
        localadg.ZlS = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    AppMethodBeat.o(145668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adg
 * JD-Core Version:    0.7.0.1
 */