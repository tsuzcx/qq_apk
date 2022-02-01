package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayw
  extends ckq
{
  public SKBuiltinBuffer_t Dxj;
  public int Dxk;
  public int Dxl;
  public int hnE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63273);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dxj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(63273);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.hnE);
      if (this.Dxj != null)
      {
        paramVarArgs.kX(3, this.Dxj.computeSize());
        this.Dxj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.Dxk);
      paramVarArgs.aR(5, this.Dxl);
      AppMethodBeat.o(63273);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.hnE);
      paramInt = i;
      if (this.Dxj != null) {
        paramInt = i + f.a.a.a.kW(3, this.Dxj.computeSize());
      }
      i = f.a.a.b.b.a.bA(4, this.Dxk);
      int j = f.a.a.b.b.a.bA(5, this.Dxl);
      AppMethodBeat.o(63273);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dxj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(63273);
          throw paramVarArgs;
        }
        AppMethodBeat.o(63273);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayw localayw = (ayw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63273);
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
            localayw.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63273);
          return 0;
        case 2: 
          localayw.hnE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(63273);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayw.Dxj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63273);
          return 0;
        case 4: 
          localayw.Dxk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(63273);
          return 0;
        }
        localayw.Dxl = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(63273);
        return 0;
      }
      AppMethodBeat.o(63273);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayw
 * JD-Core Version:    0.7.0.1
 */