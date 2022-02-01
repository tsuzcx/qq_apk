package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ccf
  extends com.tencent.mm.bx.a
{
  public String aalE;
  public ccc aalF;
  public b aalG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257846);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aalE != null) {
        paramVarArgs.g(1, this.aalE);
      }
      if (this.aalF != null)
      {
        paramVarArgs.qD(2, this.aalF.computeSize());
        this.aalF.writeFields(paramVarArgs);
      }
      if (this.aalG != null) {
        paramVarArgs.d(3, this.aalG);
      }
      AppMethodBeat.o(257846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aalE == null) {
        break label404;
      }
    }
    label404:
    for (int i = i.a.a.b.b.a.h(1, this.aalE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aalF != null) {
        paramInt = i + i.a.a.a.qC(2, this.aalF.computeSize());
      }
      i = paramInt;
      if (this.aalG != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.aalG);
      }
      AppMethodBeat.o(257846);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257846);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ccf localccf = (ccf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257846);
          return -1;
        case 1: 
          localccf.aalE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257846);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ccc localccc = new ccc();
            if ((localObject != null) && (localObject.length > 0)) {
              localccc.parseFrom((byte[])localObject);
            }
            localccf.aalF = localccc;
            paramInt += 1;
          }
          AppMethodBeat.o(257846);
          return 0;
        }
        localccf.aalG = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(257846);
        return 0;
      }
      AppMethodBeat.o(257846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccf
 * JD-Core Version:    0.7.0.1
 */