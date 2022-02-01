package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gjq
  extends com.tencent.mm.bx.a
{
  public String aayV;
  public gol aayX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133209);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aayX == null)
      {
        paramVarArgs = new b("Not all required fields were included: VerifyBuff");
        AppMethodBeat.o(133209);
        throw paramVarArgs;
      }
      if (this.aayV != null) {
        paramVarArgs.g(1, this.aayV);
      }
      if (this.aayX != null)
      {
        paramVarArgs.qD(2, this.aayX.computeSize());
        this.aayX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aayV == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.b.b.a.h(1, this.aayV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aayX != null) {
        i = paramInt + i.a.a.a.qC(2, this.aayX.computeSize());
      }
      AppMethodBeat.o(133209);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aayX == null)
        {
          paramVarArgs = new b("Not all required fields were included: VerifyBuff");
          AppMethodBeat.o(133209);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133209);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gjq localgjq = (gjq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133209);
          return -1;
        case 1: 
          localgjq.aayV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(133209);
          return 0;
        }
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
          localgjq.aayX = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(133209);
        return 0;
      }
      AppMethodBeat.o(133209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjq
 * JD-Core Version:    0.7.0.1
 */