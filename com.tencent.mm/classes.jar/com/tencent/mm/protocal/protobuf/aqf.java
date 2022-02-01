package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqf
  extends ckq
{
  public SKBuiltinBuffer_t CFU;
  public String Drp;
  public int Drq;
  public int Scene;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104367);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.mBH);
      paramVarArgs.aR(3, this.Scene);
      if (this.Drp != null) {
        paramVarArgs.d(4, this.Drp);
      }
      if (this.CFU != null)
      {
        paramVarArgs.kX(5, this.CFU.computeSize());
        this.CFU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.Drq);
      AppMethodBeat.o(104367);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBH) + f.a.a.b.b.a.bA(3, this.Scene);
      paramInt = i;
      if (this.Drp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Drp);
      }
      i = paramInt;
      if (this.CFU != null) {
        i = paramInt + f.a.a.a.kW(5, this.CFU.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(6, this.Drq);
      AppMethodBeat.o(104367);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104367);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqf localaqf = (aqf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104367);
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
            localaqf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104367);
          return 0;
        case 2: 
          localaqf.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104367);
          return 0;
        case 3: 
          localaqf.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104367);
          return 0;
        case 4: 
          localaqf.Drp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104367);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqf.CFU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104367);
          return 0;
        }
        localaqf.Drq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104367);
        return 0;
      }
      AppMethodBeat.o(104367);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqf
 * JD-Core Version:    0.7.0.1
 */