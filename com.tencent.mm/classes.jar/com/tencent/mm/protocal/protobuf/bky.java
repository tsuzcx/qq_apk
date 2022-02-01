package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bky
  extends ckq
{
  public dwt DIQ;
  public int Dym;
  public String hnC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123626);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      paramVarArgs.aR(3, this.Dym);
      if (this.DIQ != null)
      {
        paramVarArgs.kX(4, this.DIQ.computeSize());
        this.DIQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123626);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hnC);
      }
      i += f.a.a.b.b.a.bA(3, this.Dym);
      paramInt = i;
      if (this.DIQ != null) {
        paramInt = i + f.a.a.a.kW(4, this.DIQ.computeSize());
      }
      AppMethodBeat.o(123626);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123626);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bky localbky = (bky)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123626);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbky.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123626);
          return 0;
        case 2: 
          localbky.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123626);
          return 0;
        case 3: 
          localbky.Dym = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123626);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbky.DIQ = ((dwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123626);
        return 0;
      }
      AppMethodBeat.o(123626);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bky
 * JD-Core Version:    0.7.0.1
 */