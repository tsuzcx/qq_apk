package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class adl
  extends ckq
{
  public String CIt;
  public b DbF;
  public b Dee;
  public int rNz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CIt != null) {
        paramVarArgs.d(2, this.CIt);
      }
      paramVarArgs.aR(3, this.rNz);
      if (this.Dee != null) {
        paramVarArgs.c(4, this.Dee);
      }
      if (this.DbF != null) {
        paramVarArgs.c(5, this.DbF);
      }
      AppMethodBeat.o(124485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CIt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CIt);
      }
      i += f.a.a.b.b.a.bA(3, this.rNz);
      paramInt = i;
      if (this.Dee != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Dee);
      }
      i = paramInt;
      if (this.DbF != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.DbF);
      }
      AppMethodBeat.o(124485);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adl localadl = (adl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124485);
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
            localadl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124485);
          return 0;
        case 2: 
          localadl.CIt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124485);
          return 0;
        case 3: 
          localadl.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124485);
          return 0;
        case 4: 
          localadl.Dee = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(124485);
          return 0;
        }
        localadl.DbF = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(124485);
        return 0;
      }
      AppMethodBeat.o(124485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adl
 * JD-Core Version:    0.7.0.1
 */