package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nn
  extends com.tencent.mm.bx.a
{
  public String CGS;
  public int CID;
  public no CLj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124454);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CLj != null)
      {
        paramVarArgs.kX(1, this.CLj.computeSize());
        this.CLj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CID);
      if (this.CGS != null) {
        paramVarArgs.d(3, this.CGS);
      }
      AppMethodBeat.o(124454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLj == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.a.kW(1, this.CLj.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CID);
      paramInt = i;
      if (this.CGS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CGS);
      }
      AppMethodBeat.o(124454);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nn localnn = (nn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124454);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new no();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((no)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnn.CLj = ((no)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124454);
          return 0;
        case 2: 
          localnn.CID = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124454);
          return 0;
        }
        localnn.CGS = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(124454);
        return 0;
      }
      AppMethodBeat.o(124454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nn
 * JD-Core Version:    0.7.0.1
 */