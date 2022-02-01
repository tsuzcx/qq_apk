package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class wt
  extends com.tencent.mm.bx.a
{
  public int CYN;
  public SKBuiltinBuffer_t CYO;
  public int CYP;
  public SKBuiltinBuffer_t CYQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CYO == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(145668);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.CYN);
      if (this.CYO != null)
      {
        paramVarArgs.kX(2, this.CYO.computeSize());
        this.CYO.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.CYP);
      if (this.CYQ != null)
      {
        paramVarArgs.kX(4, this.CYQ.computeSize());
        this.CYQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.CYN) + 0;
      paramInt = i;
      if (this.CYO != null) {
        paramInt = i + f.a.a.a.kW(2, this.CYO.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.CYP);
      paramInt = i;
      if (this.CYQ != null) {
        paramInt = i + f.a.a.a.kW(4, this.CYQ.computeSize());
      }
      AppMethodBeat.o(145668);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.CYO == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(145668);
        throw paramVarArgs;
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      wt localwt = (wt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(145668);
        return -1;
      case 1: 
        localwt.CYN = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(145668);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localwt.CYO = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(145668);
        return 0;
      case 3: 
        localwt.CYP = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(145668);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localwt.CYQ = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    AppMethodBeat.o(145668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wt
 * JD-Core Version:    0.7.0.1
 */