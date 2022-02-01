package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afl
  extends ckq
{
  public String CHp;
  public int dep;
  public String dlB;
  public int pNP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104360);
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
      if (this.CHp != null) {
        paramVarArgs.d(3, this.CHp);
      }
      paramVarArgs.aR(4, this.dep);
      paramVarArgs.aR(5, this.pNP);
      AppMethodBeat.o(104360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlB);
      }
      i = paramInt;
      if (this.CHp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CHp);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.dep);
      int j = f.a.a.b.b.a.bA(5, this.pNP);
      AppMethodBeat.o(104360);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104360);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afl localafl = (afl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104360);
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
            localafl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104360);
          return 0;
        case 2: 
          localafl.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104360);
          return 0;
        case 3: 
          localafl.CHp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104360);
          return 0;
        case 4: 
          localafl.dep = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104360);
          return 0;
        }
        localafl.pNP = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104360);
        return 0;
      }
      AppMethodBeat.o(104360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afl
 * JD-Core Version:    0.7.0.1
 */