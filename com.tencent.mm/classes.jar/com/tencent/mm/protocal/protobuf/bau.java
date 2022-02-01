package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bau
  extends com.tencent.mm.bx.a
{
  public fhp BfU;
  public String ZLA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260037);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZLA != null) {
        paramVarArgs.g(1, this.ZLA);
      }
      if (this.BfU != null)
      {
        paramVarArgs.qD(2, this.BfU.computeSize());
        this.BfU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260037);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZLA == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZLA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.BfU != null) {
        i = paramInt + i.a.a.a.qC(2, this.BfU.computeSize());
      }
      AppMethodBeat.o(260037);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260037);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bau localbau = (bau)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260037);
          return -1;
        case 1: 
          localbau.ZLA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260037);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fhp localfhp = new fhp();
          if ((localObject != null) && (localObject.length > 0)) {
            localfhp.parseFrom((byte[])localObject);
          }
          localbau.BfU = localfhp;
          paramInt += 1;
        }
        AppMethodBeat.o(260037);
        return 0;
      }
      AppMethodBeat.o(260037);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bau
 * JD-Core Version:    0.7.0.1
 */