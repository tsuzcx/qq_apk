package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class chc
  extends com.tencent.mm.bx.a
{
  public int YFL;
  public etl aapS;
  public int aapT;
  public int aapU;
  public int aapV = 1;
  public int aapW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101809);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aapS == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatroomId");
        AppMethodBeat.o(101809);
        throw paramVarArgs;
      }
      if (this.aapS != null)
      {
        paramVarArgs.qD(1, this.aapS.computeSize());
        this.aapS.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YFL);
      paramVarArgs.bS(3, this.aapT);
      paramVarArgs.bS(4, this.aapU);
      paramVarArgs.bS(5, this.aapV);
      paramVarArgs.bS(6, this.aapW);
      AppMethodBeat.o(101809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aapS == null) {
        break label564;
      }
    }
    label564:
    for (paramInt = i.a.a.a.qC(1, this.aapS.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.YFL);
      int j = i.a.a.b.b.a.cJ(3, this.aapT);
      int k = i.a.a.b.b.a.cJ(4, this.aapU);
      int m = i.a.a.b.b.a.cJ(5, this.aapV);
      int n = i.a.a.b.b.a.cJ(6, this.aapW);
      AppMethodBeat.o(101809);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aapS == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatroomId");
          AppMethodBeat.o(101809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        chc localchc = (chc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101809);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            etl localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localchc.aapS = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(101809);
          return 0;
        case 2: 
          localchc.YFL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101809);
          return 0;
        case 3: 
          localchc.aapT = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101809);
          return 0;
        case 4: 
          localchc.aapU = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101809);
          return 0;
        case 5: 
          localchc.aapV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101809);
          return 0;
        }
        localchc.aapW = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(101809);
        return 0;
      }
      AppMethodBeat.o(101809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chc
 * JD-Core Version:    0.7.0.1
 */