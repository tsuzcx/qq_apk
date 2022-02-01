package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avg
  extends ckq
{
  public String DuI;
  public String dlB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153272);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      if (this.DuI != null) {
        paramVarArgs.d(3, this.DuI);
      }
      AppMethodBeat.o(153272);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label430;
      }
    }
    label430:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlB);
      }
      i = paramInt;
      if (this.DuI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DuI);
      }
      AppMethodBeat.o(153272);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153272);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avg localavg = (avg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153272);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavg.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153272);
          return 0;
        case 2: 
          localavg.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153272);
          return 0;
        }
        localavg.DuI = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(153272);
        return 0;
      }
      AppMethodBeat.o(153272);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avg
 * JD-Core Version:    0.7.0.1
 */