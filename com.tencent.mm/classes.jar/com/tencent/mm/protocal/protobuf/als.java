package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class als
  extends cld
{
  public int cWU;
  public boolean completed;
  public int gTY;
  public String qpB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169069);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.gTY);
      paramVarArgs.aR(3, this.cWU);
      if (this.qpB != null) {
        paramVarArgs.d(4, this.qpB);
      }
      paramVarArgs.bg(5, this.completed);
      AppMethodBeat.o(169069);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.gTY) + f.a.a.b.b.a.bA(3, this.cWU);
      paramInt = i;
      if (this.qpB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.qpB);
      }
      i = f.a.a.b.b.a.fY(5);
      AppMethodBeat.o(169069);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169069);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        als localals = (als)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169069);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localals.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169069);
          return 0;
        case 2: 
          localals.gTY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169069);
          return 0;
        case 3: 
          localals.cWU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169069);
          return 0;
        case 4: 
          localals.qpB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169069);
          return 0;
        }
        localals.completed = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(169069);
        return 0;
      }
      AppMethodBeat.o(169069);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.als
 * JD-Core Version:    0.7.0.1
 */