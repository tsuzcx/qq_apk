package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asm
  extends cvp
{
  public boolean completed;
  public int dfG;
  public int hMP;
  public String rJX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169069);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.hMP);
      paramVarArgs.aS(3, this.dfG);
      if (this.rJX != null) {
        paramVarArgs.d(4, this.rJX);
      }
      paramVarArgs.bt(5, this.completed);
      AppMethodBeat.o(169069);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.hMP) + f.a.a.b.b.a.bz(3, this.dfG);
      paramInt = i;
      if (this.rJX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rJX);
      }
      i = f.a.a.b.b.a.alV(5);
      AppMethodBeat.o(169069);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169069);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asm localasm = (asm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169069);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169069);
          return 0;
        case 2: 
          localasm.hMP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169069);
          return 0;
        case 3: 
          localasm.dfG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169069);
          return 0;
        case 4: 
          localasm.rJX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169069);
          return 0;
        }
        localasm.completed = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(169069);
        return 0;
      }
      AppMethodBeat.o(169069);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asm
 * JD-Core Version:    0.7.0.1
 */